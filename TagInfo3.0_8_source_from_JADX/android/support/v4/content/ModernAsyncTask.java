package android.support.v4.content;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ModernAsyncTask {
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static volatile Executor sDefaultExecutor;
    private static final InternalHandler sHandler;
    private static final BlockingQueue sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    private final FutureTask mFuture;
    private volatile Status mStatus;
    private final AtomicBoolean mTaskInvoked;
    private final WorkerRunnable mWorker;

    /* renamed from: android.support.v4.content.ModernAsyncTask.1 */
    final class C00221 implements ThreadFactory {
        private final AtomicInteger mCount;

        C00221() {
            this.mCount = new AtomicInteger(ModernAsyncTask.MESSAGE_POST_RESULT);
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.mCount.getAndIncrement());
        }
    }

    abstract class WorkerRunnable implements Callable {
        Object[] mParams;

        private WorkerRunnable() {
        }
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask.2 */
    class C00232 extends WorkerRunnable {
        C00232() {
            super();
        }

        public Object call() {
            ModernAsyncTask.this.mTaskInvoked.set(true);
            Process.setThreadPriority(10);
            return ModernAsyncTask.this.postResult(ModernAsyncTask.this.doInBackground(this.mParams));
        }
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask.3 */
    class C00243 extends FutureTask {
        C00243(Callable callable) {
            super(callable);
        }

        protected void done() {
            try {
                ModernAsyncTask.this.postResultIfNotInvoked(get());
            } catch (Throwable e) {
                Log.w(ModernAsyncTask.LOG_TAG, e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                ModernAsyncTask.this.postResultIfNotInvoked(null);
            } catch (Throwable e4) {
                RuntimeException runtimeException = new RuntimeException("An error occured while executing doInBackground()", e4);
            }
        }
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask.4 */
    /* synthetic */ class C00254 {
        static final /* synthetic */ int[] $SwitchMap$android$support$v4$content$ModernAsyncTask$Status;

        static {
            $SwitchMap$android$support$v4$content$ModernAsyncTask$Status = new int[Status.values().length];
            try {
                $SwitchMap$android$support$v4$content$ModernAsyncTask$Status[Status.RUNNING.ordinal()] = ModernAsyncTask.MESSAGE_POST_RESULT;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$support$v4$content$ModernAsyncTask$Status[Status.FINISHED.ordinal()] = ModernAsyncTask.MESSAGE_POST_PROGRESS;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    class AsyncTaskResult {
        final Object[] mData;
        final ModernAsyncTask mTask;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Object... objArr) {
            this.mTask = modernAsyncTask;
            this.mData = objArr;
        }
    }

    class InternalHandler extends Handler {
        private InternalHandler() {
        }

        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            switch (message.what) {
                case ModernAsyncTask.MESSAGE_POST_RESULT /*1*/:
                    asyncTaskResult.mTask.finish(asyncTaskResult.mData[0]);
                case ModernAsyncTask.MESSAGE_POST_PROGRESS /*2*/:
                    asyncTaskResult.mTask.onProgressUpdate(asyncTaskResult.mData);
                default:
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    static {
        sThreadFactory = new C00221();
        sPoolWorkQueue = new LinkedBlockingQueue(10);
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 1, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
        sHandler = new InternalHandler();
        sDefaultExecutor = THREAD_POOL_EXECUTOR;
    }

    public ModernAsyncTask() {
        this.mStatus = Status.PENDING;
        this.mTaskInvoked = new AtomicBoolean();
        this.mWorker = new C00232();
        this.mFuture = new C00243(this.mWorker);
    }

    public static void execute(Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    private void finish(Object obj) {
        if (isCancelled()) {
            onCancelled(obj);
        } else {
            onPostExecute(obj);
        }
        this.mStatus = Status.FINISHED;
    }

    public static void init() {
        sHandler.getLooper();
    }

    private Object postResult(Object obj) {
        InternalHandler internalHandler = sHandler;
        Object[] objArr = new Object[MESSAGE_POST_RESULT];
        objArr[0] = obj;
        internalHandler.obtainMessage(MESSAGE_POST_RESULT, new AsyncTaskResult(this, objArr)).sendToTarget();
        return obj;
    }

    private void postResultIfNotInvoked(Object obj) {
        if (!this.mTaskInvoked.get()) {
            postResult(obj);
        }
    }

    public static void setDefaultExecutor(Executor executor) {
        sDefaultExecutor = executor;
    }

    public final boolean cancel(boolean z) {
        return this.mFuture.cancel(z);
    }

    protected abstract Object doInBackground(Object... objArr);

    public final ModernAsyncTask execute(Object... objArr) {
        return executeOnExecutor(sDefaultExecutor, objArr);
    }

    public final ModernAsyncTask executeOnExecutor(Executor executor, Object... objArr) {
        if (this.mStatus != Status.PENDING) {
            switch (C00254.$SwitchMap$android$support$v4$content$ModernAsyncTask$Status[this.mStatus.ordinal()]) {
                case MESSAGE_POST_RESULT /*1*/:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case MESSAGE_POST_PROGRESS /*2*/:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.mStatus = Status.RUNNING;
        onPreExecute();
        this.mWorker.mParams = objArr;
        executor.execute(this.mFuture);
        return this;
    }

    public final Object get() {
        return this.mFuture.get();
    }

    public final Object get(long j, TimeUnit timeUnit) {
        return this.mFuture.get(j, timeUnit);
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mFuture.isCancelled();
    }

    protected void onCancelled() {
    }

    protected void onCancelled(Object obj) {
        onCancelled();
    }

    protected void onPostExecute(Object obj) {
    }

    protected void onPreExecute() {
    }

    protected void onProgressUpdate(Object... objArr) {
    }

    protected final void publishProgress(Object... objArr) {
        if (!isCancelled()) {
            sHandler.obtainMessage(MESSAGE_POST_PROGRESS, new AsyncTaskResult(this, objArr)).sendToTarget();
        }
    }
}
