package com.actionbarsherlock.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.xmlpull.v1.XmlSerializer;

class ActivityChooserModel extends DataSetObservable {
    private static final String ATTRIBUTE_ACTIVITY = "activity";
    private static final String ATTRIBUTE_TIME = "time";
    private static final String ATTRIBUTE_WEIGHT = "weight";
    private static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    private static final String LOG_TAG;
    private static final Executor SERIAL_EXECUTOR;
    private static final String TAG_HISTORICAL_RECORD = "historical-record";
    private static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map sDataModelRegistry;
    private static final Object sRegistryLock;
    private final List mActivites;
    private OnChooseActivityListener mActivityChoserModelPolicy;
    private ActivitySorter mActivitySorter;
    private boolean mCanReadHistoricalData;
    private final Context mContext;
    private final Handler mHandler;
    private final List mHistoricalRecords;
    private boolean mHistoricalRecordsChanged;
    private final String mHistoryFileName;
    private int mHistoryMaxSize;
    private final Object mInstanceLock;
    private Intent mIntent;
    private boolean mReadShareHistoryCalled;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    public final class ActivityResolveInfo implements Comparable {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return ActivityChooserModel.DEBUG;
            }
            if (getClass() != obj.getClass()) {
                return ActivityChooserModel.DEBUG;
            }
            return Float.floatToIntBits(this.weight) != Float.floatToIntBits(((ActivityResolveInfo) obj).weight) ? ActivityChooserModel.DEBUG : true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:").append(this.resolveInfo.toString());
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.weight));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface ActivitySorter {
        void sort(Intent intent, List list, List list2);
    }

    final class DefaultSorter implements ActivitySorter {
        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        private final Map mPackageNameToActivityMap;

        private DefaultSorter() {
            this.mPackageNameToActivityMap = new HashMap();
        }

        public void sort(Intent intent, List list, List list2) {
            Map map = this.mPackageNameToActivityMap;
            map.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) list.get(i);
                activityResolveInfo.weight = 0.0f;
                map.put(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo);
            }
            int size2 = list2.size() + ActivityChooserModel.INVALID_INDEX;
            float f = ActivityChooserModel.DEFAULT_HISTORICAL_RECORD_WEIGHT;
            int i2 = size2;
            while (i2 >= 0) {
                float f2;
                HistoricalRecord historicalRecord = (HistoricalRecord) list2.get(i2);
                ActivityResolveInfo activityResolveInfo2 = (ActivityResolveInfo) map.get(historicalRecord.activity.getPackageName());
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.weight = (historicalRecord.weight * f) + activityResolveInfo2.weight;
                    f2 = WEIGHT_DECAY_COEFFICIENT * f;
                } else {
                    f2 = f;
                }
                i2 += ActivityChooserModel.INVALID_INDEX;
                f = f2;
            }
            Collections.sort(list);
        }
    }

    public final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(ComponentName componentName, long j, float f) {
            this.activity = componentName;
            this.time = j;
            this.weight = f;
        }

        public HistoricalRecord(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return ActivityChooserModel.DEBUG;
            }
            if (getClass() != obj.getClass()) {
                return ActivityChooserModel.DEBUG;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            if (this.activity == null) {
                if (historicalRecord.activity != null) {
                    return ActivityChooserModel.DEBUG;
                }
            } else if (!this.activity.equals(historicalRecord.activity)) {
                return ActivityChooserModel.DEBUG;
            }
            return this.time != historicalRecord.time ? ActivityChooserModel.DEBUG : Float.floatToIntBits(this.weight) != Float.floatToIntBits(historicalRecord.weight) ? ActivityChooserModel.DEBUG : true;
        }

        public int hashCode() {
            return (((((this.activity == null ? 0 : this.activity.hashCode()) + 31) * 31) + ((int) (this.time ^ (this.time >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:").append(this.activity);
            stringBuilder.append("; time:").append(this.time);
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.weight));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    final class HistoryLoader implements Runnable {

        /* renamed from: com.actionbarsherlock.widget.ActivityChooserModel.HistoryLoader.1 */
        class C01171 implements Runnable {
            C01171() {
            }

            public void run() {
                ActivityChooserModel.this.pruneExcessiveHistoricalRecordsLocked();
                ActivityChooserModel.this.sortActivities();
            }
        }

        private HistoryLoader() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r9 = this;
            r8 = 1;
            r0 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ FileNotFoundException -> 0x0145 }
            r0 = r0.mContext;	 Catch:{ FileNotFoundException -> 0x0145 }
            r1 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ FileNotFoundException -> 0x0145 }
            r1 = r1.mHistoryFileName;	 Catch:{ FileNotFoundException -> 0x0145 }
            r2 = r0.openFileInput(r1);	 Catch:{ FileNotFoundException -> 0x0145 }
            r1 = android.util.Xml.newPullParser();	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            r0 = 0;
            r1.setInput(r2, r0);	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            r0 = 0;
        L_0x001a:
            if (r0 == r8) goto L_0x0024;
        L_0x001c:
            r3 = 2;
            if (r0 == r3) goto L_0x0024;
        L_0x001f:
            r0 = r1.next();	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            goto L_0x001a;
        L_0x0024:
            r0 = "historical-records";
            r3 = r1.getName();	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            r0 = r0.equals(r3);	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            if (r0 != 0) goto L_0x005f;
        L_0x0030:
            r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            r1 = "Share records file does not start with historical-records tag.";
            r0.<init>(r1);	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            throw r0;	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
        L_0x0038:
            r0 = move-exception;
            r1 = com.actionbarsherlock.widget.ActivityChooserModel.LOG_TAG;	 Catch:{ all -> 0x00fc }
            r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00fc }
            r3.<init>();	 Catch:{ all -> 0x00fc }
            r4 = "Error reading historical recrod file: ";
            r3 = r3.append(r4);	 Catch:{ all -> 0x00fc }
            r4 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ all -> 0x00fc }
            r4 = r4.mHistoryFileName;	 Catch:{ all -> 0x00fc }
            r3 = r3.append(r4);	 Catch:{ all -> 0x00fc }
            r3 = r3.toString();	 Catch:{ all -> 0x00fc }
            android.util.Log.e(r1, r3, r0);	 Catch:{ all -> 0x00fc }
            if (r2 == 0) goto L_0x005e;
        L_0x005b:
            r2.close();	 Catch:{ IOException -> 0x0140 }
        L_0x005e:
            return;
        L_0x005f:
            r0 = new java.util.ArrayList;	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            r0.<init>();	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
        L_0x0064:
            r3 = r1.next();	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            if (r3 != r8) goto L_0x0092;
        L_0x006a:
            r1 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            r3 = r1.mInstanceLock;	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            monitor-enter(r3);	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            r4 = new java.util.LinkedHashSet;	 Catch:{ all -> 0x013d }
            r4.<init>(r0);	 Catch:{ all -> 0x013d }
            r0 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ all -> 0x013d }
            r5 = r0.mHistoricalRecords;	 Catch:{ all -> 0x013d }
            r0 = r5.size();	 Catch:{ all -> 0x013d }
            r0 = r0 + -1;
            r1 = r0;
        L_0x0083:
            if (r1 < 0) goto L_0x0103;
        L_0x0085:
            r0 = r5.get(r1);	 Catch:{ all -> 0x013d }
            r0 = (com.actionbarsherlock.widget.ActivityChooserModel.HistoricalRecord) r0;	 Catch:{ all -> 0x013d }
            r4.add(r0);	 Catch:{ all -> 0x013d }
            r0 = r1 + -1;
            r1 = r0;
            goto L_0x0083;
        L_0x0092:
            r4 = 3;
            if (r3 == r4) goto L_0x0064;
        L_0x0095:
            r4 = 4;
            if (r3 == r4) goto L_0x0064;
        L_0x0098:
            r3 = r1.getName();	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            r4 = "historical-record";
            r3 = r4.equals(r3);	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            if (r3 != 0) goto L_0x00d5;
        L_0x00a4:
            r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            r1 = "Share records file not well-formed.";
            r0.<init>(r1);	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            throw r0;	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
        L_0x00ac:
            r0 = move-exception;
            r1 = com.actionbarsherlock.widget.ActivityChooserModel.LOG_TAG;	 Catch:{ all -> 0x00fc }
            r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00fc }
            r3.<init>();	 Catch:{ all -> 0x00fc }
            r4 = "Error reading historical recrod file: ";
            r3 = r3.append(r4);	 Catch:{ all -> 0x00fc }
            r4 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ all -> 0x00fc }
            r4 = r4.mHistoryFileName;	 Catch:{ all -> 0x00fc }
            r3 = r3.append(r4);	 Catch:{ all -> 0x00fc }
            r3 = r3.toString();	 Catch:{ all -> 0x00fc }
            android.util.Log.e(r1, r3, r0);	 Catch:{ all -> 0x00fc }
            if (r2 == 0) goto L_0x005e;
        L_0x00cf:
            r2.close();	 Catch:{ IOException -> 0x00d3 }
            goto L_0x005e;
        L_0x00d3:
            r0 = move-exception;
            goto L_0x005e;
        L_0x00d5:
            r3 = 0;
            r4 = "activity";
            r3 = r1.getAttributeValue(r3, r4);	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            r4 = 0;
            r5 = "time";
            r4 = r1.getAttributeValue(r4, r5);	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            r4 = java.lang.Long.parseLong(r4);	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            r6 = 0;
            r7 = "weight";
            r6 = r1.getAttributeValue(r6, r7);	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            r6 = java.lang.Float.parseFloat(r6);	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            r7 = new com.actionbarsherlock.widget.ActivityChooserModel$HistoricalRecord;	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            r7.<init>(r3, r4, r6);	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            r0.add(r7);	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
            goto L_0x0064;
        L_0x00fc:
            r0 = move-exception;
            if (r2 == 0) goto L_0x0102;
        L_0x00ff:
            r2.close();	 Catch:{ IOException -> 0x0143 }
        L_0x0102:
            throw r0;
        L_0x0103:
            r0 = r5.size();	 Catch:{ all -> 0x013d }
            r1 = r4.size();	 Catch:{ all -> 0x013d }
            if (r0 != r1) goto L_0x0118;
        L_0x010d:
            monitor-exit(r3);	 Catch:{ all -> 0x013d }
            if (r2 == 0) goto L_0x005e;
        L_0x0110:
            r2.close();	 Catch:{ IOException -> 0x0115 }
            goto L_0x005e;
        L_0x0115:
            r0 = move-exception;
            goto L_0x005e;
        L_0x0118:
            r5.clear();	 Catch:{ all -> 0x013d }
            r5.addAll(r4);	 Catch:{ all -> 0x013d }
            r0 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ all -> 0x013d }
            r1 = 1;
            r0.mHistoricalRecordsChanged = r1;	 Catch:{ all -> 0x013d }
            r0 = com.actionbarsherlock.widget.ActivityChooserModel.this;	 Catch:{ all -> 0x013d }
            r0 = r0.mHandler;	 Catch:{ all -> 0x013d }
            r1 = new com.actionbarsherlock.widget.ActivityChooserModel$HistoryLoader$1;	 Catch:{ all -> 0x013d }
            r1.<init>();	 Catch:{ all -> 0x013d }
            r0.post(r1);	 Catch:{ all -> 0x013d }
            monitor-exit(r3);	 Catch:{ all -> 0x013d }
            if (r2 == 0) goto L_0x005e;
        L_0x0135:
            r2.close();	 Catch:{ IOException -> 0x013a }
            goto L_0x005e;
        L_0x013a:
            r0 = move-exception;
            goto L_0x005e;
        L_0x013d:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x013d }
            throw r0;	 Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x00ac }
        L_0x0140:
            r0 = move-exception;
            goto L_0x005e;
        L_0x0143:
            r1 = move-exception;
            goto L_0x0102;
        L_0x0145:
            r0 = move-exception;
            goto L_0x005e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.actionbarsherlock.widget.ActivityChooserModel.HistoryLoader.run():void");
        }
    }

    final class HistoryPersister implements Runnable {
        private HistoryPersister() {
        }

        public void run() {
            synchronized (ActivityChooserModel.this.mInstanceLock) {
                List arrayList = new ArrayList(ActivityChooserModel.this.mHistoricalRecords);
            }
            try {
                OutputStream openFileOutput = ActivityChooserModel.this.mContext.openFileOutput(ActivityChooserModel.this.mHistoryFileName, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                    newSerializer.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        HistoricalRecord historicalRecord = (HistoricalRecord) arrayList.remove(0);
                        newSerializer.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);
                        newSerializer.attribute(null, ActivityChooserModel.ATTRIBUTE_ACTIVITY, historicalRecord.activity.flattenToString());
                        newSerializer.attribute(null, ActivityChooserModel.ATTRIBUTE_TIME, String.valueOf(historicalRecord.time));
                        newSerializer.attribute(null, ActivityChooserModel.ATTRIBUTE_WEIGHT, String.valueOf(historicalRecord.weight));
                        newSerializer.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);
                    }
                    newSerializer.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);
                    newSerializer.endDocument();
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable e2) {
                    Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical recrod file: " + ActivityChooserModel.this.mHistoryFileName, e2);
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable e22) {
                    Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical recrod file: " + ActivityChooserModel.this.mHistoryFileName, e22);
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable e222) {
                    Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical recrod file: " + ActivityChooserModel.this.mHistoryFileName, e222);
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (Throwable th) {
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e6) {
                        }
                    }
                }
            } catch (Throwable e2222) {
                Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical recrod file: " + ActivityChooserModel.this.mHistoryFileName, e2222);
            }
        }
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    static {
        LOG_TAG = ActivityChooserModel.class.getSimpleName();
        sRegistryLock = new Object();
        sDataModelRegistry = new HashMap();
        SERIAL_EXECUTOR = Executors.newSingleThreadExecutor();
    }

    private ActivityChooserModel(Context context, String str) {
        this.mInstanceLock = new Object();
        this.mActivites = new ArrayList();
        this.mHistoricalRecords = new ArrayList();
        this.mActivitySorter = new DefaultSorter();
        this.mHistoryMaxSize = DEFAULT_HISTORY_MAX_LENGTH;
        this.mCanReadHistoricalData = true;
        this.mReadShareHistoryCalled = DEBUG;
        this.mHistoricalRecordsChanged = true;
        this.mHandler = new Handler();
        this.mContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(HISTORY_FILE_EXTENSION)) {
            this.mHistoryFileName = str;
        } else {
            this.mHistoryFileName = str + HISTORY_FILE_EXTENSION;
        }
    }

    private boolean addHisoricalRecord(HistoricalRecord historicalRecord) {
        boolean add;
        synchronized (this.mInstanceLock) {
            add = this.mHistoricalRecords.add(historicalRecord);
            if (add) {
                this.mHistoricalRecordsChanged = true;
                pruneExcessiveHistoricalRecordsLocked();
                persistHistoricalData();
                sortActivities();
            }
        }
        return add;
    }

    public static ActivityChooserModel get(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (sRegistryLock) {
            activityChooserModel = (ActivityChooserModel) sDataModelRegistry.get(str);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, str);
                sDataModelRegistry.put(str, activityChooserModel);
            }
            activityChooserModel.readHistoricalData();
        }
        return activityChooserModel;
    }

    private void loadActivitiesLocked() {
        this.mActivites.clear();
        if (this.mIntent != null) {
            List queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
            int size = queryIntentActivities.size();
            for (int i = 0; i < size; i++) {
                this.mActivites.add(new ActivityResolveInfo((ResolveInfo) queryIntentActivities.get(i)));
            }
            sortActivities();
            return;
        }
        notifyChanged();
    }

    private void persistHistoricalData() {
        synchronized (this.mInstanceLock) {
            if (!this.mReadShareHistoryCalled) {
                throw new IllegalStateException("No preceding call to #readHistoricalData");
            } else if (this.mHistoricalRecordsChanged) {
                this.mHistoricalRecordsChanged = DEBUG;
                this.mCanReadHistoricalData = true;
                if (!TextUtils.isEmpty(this.mHistoryFileName)) {
                    SERIAL_EXECUTOR.execute(new HistoryPersister());
                }
            }
        }
    }

    private void pruneExcessiveHistoricalRecordsLocked() {
        List list = this.mHistoricalRecords;
        int size = list.size() - this.mHistoryMaxSize;
        if (size > 0) {
            this.mHistoricalRecordsChanged = true;
            for (int i = 0; i < size; i++) {
                HistoricalRecord historicalRecord = (HistoricalRecord) list.remove(0);
            }
        }
    }

    private void readHistoricalData() {
        synchronized (this.mInstanceLock) {
            if (this.mCanReadHistoricalData && this.mHistoricalRecordsChanged) {
                this.mCanReadHistoricalData = DEBUG;
                this.mReadShareHistoryCalled = true;
                if (!TextUtils.isEmpty(this.mHistoryFileName)) {
                    SERIAL_EXECUTOR.execute(new HistoryLoader());
                }
                return;
            }
        }
    }

    private void sortActivities() {
        synchronized (this.mInstanceLock) {
            if (!(this.mActivitySorter == null || this.mActivites.isEmpty())) {
                this.mActivitySorter.sort(this.mIntent, this.mActivites, Collections.unmodifiableList(this.mHistoricalRecords));
                notifyChanged();
            }
        }
    }

    public Intent chooseActivity(int i) {
        ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) this.mActivites.get(i);
        ComponentName componentName = new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name);
        Intent intent = new Intent(this.mIntent);
        intent.setComponent(componentName);
        if (this.mActivityChoserModelPolicy != null) {
            if (this.mActivityChoserModelPolicy.onChooseActivity(this, new Intent(intent))) {
                return null;
            }
        }
        addHisoricalRecord(new HistoricalRecord(componentName, System.currentTimeMillis(), (float) DEFAULT_HISTORICAL_RECORD_WEIGHT));
        return intent;
    }

    public ResolveInfo getActivity(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.mInstanceLock) {
            resolveInfo = ((ActivityResolveInfo) this.mActivites.get(i)).resolveInfo;
        }
        return resolveInfo;
    }

    public int getActivityCount() {
        int size;
        synchronized (this.mInstanceLock) {
            size = this.mActivites.size();
        }
        return size;
    }

    public int getActivityIndex(ResolveInfo resolveInfo) {
        List list = this.mActivites;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((ActivityResolveInfo) list.get(i)).resolveInfo == resolveInfo) {
                return i;
            }
        }
        return INVALID_INDEX;
    }

    public ResolveInfo getDefaultActivity() {
        synchronized (this.mInstanceLock) {
            if (this.mActivites.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((ActivityResolveInfo) this.mActivites.get(0)).resolveInfo;
            return resolveInfo;
        }
    }

    public int getHistoryMaxSize() {
        int i;
        synchronized (this.mInstanceLock) {
            i = this.mHistoryMaxSize;
        }
        return i;
    }

    public int getHistorySize() {
        int size;
        synchronized (this.mInstanceLock) {
            size = this.mHistoricalRecords.size();
        }
        return size;
    }

    public Intent getIntent() {
        Intent intent;
        synchronized (this.mInstanceLock) {
            intent = this.mIntent;
        }
        return intent;
    }

    public void setActivitySorter(ActivitySorter activitySorter) {
        synchronized (this.mInstanceLock) {
            if (this.mActivitySorter == activitySorter) {
                return;
            }
            this.mActivitySorter = activitySorter;
            sortActivities();
        }
    }

    public void setDefaultActivity(int i) {
        ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) this.mActivites.get(i);
        ActivityResolveInfo activityResolveInfo2 = (ActivityResolveInfo) this.mActivites.get(0);
        addHisoricalRecord(new HistoricalRecord(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), System.currentTimeMillis(), activityResolveInfo2 != null ? (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f : DEFAULT_HISTORICAL_RECORD_WEIGHT));
    }

    public void setHistoryMaxSize(int i) {
        synchronized (this.mInstanceLock) {
            if (this.mHistoryMaxSize == i) {
                return;
            }
            this.mHistoryMaxSize = i;
            pruneExcessiveHistoricalRecordsLocked();
            sortActivities();
        }
    }

    public void setIntent(Intent intent) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == intent) {
                return;
            }
            this.mIntent = intent;
            loadActivitiesLocked();
        }
    }

    public void setOnChooseActivityListener(OnChooseActivityListener onChooseActivityListener) {
        this.mActivityChoserModelPolicy = onChooseActivityListener;
    }
}
