package com.nxp.taginfolite;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.nxp.taginfolite.data.C0210d;
import com.nxp.taginfolite.data.C0213g;
import com.nxp.taginfolite.p009e.ay;
import java.util.Arrays;

/* renamed from: com.nxp.taginfolite.b */
public class C0196b {
    private static int f143b;
    private static byte[] f144c;
    final AudioManager f145a;
    private final Activity f146d;
    private final SoundPool f147e;
    private boolean f148f;
    private final int f149g;
    private final int f150h;
    private final int f151i;

    public C0196b(Activity activity) {
        this.f148f = false;
        this.f146d = activity;
        this.f147e = new SoundPool(1, 5, 0);
        this.f147e.setOnLoadCompleteListener(new C0201c(this));
        this.f145a = (AudioManager) activity.getSystemService("audio");
        this.f149g = this.f147e.load(activity, R.raw.start_scan, 1);
        this.f150h = this.f147e.load(activity, R.raw.success_scan, 1);
        this.f151i = this.f147e.load(activity, R.raw.error_scan, 1);
    }

    private void m178a() {
        if (C0158a.m30a(this.f146d).m44c()) {
            ((Vibrator) this.f146d.getSystemService("vibrator")).vibrate(150);
        }
    }

    private void m179a(int i) {
        if (C0158a.m29a().m41b() && this.f145a.getRingerMode() == 2) {
            int i2 = 0;
            while (!this.f148f && i2 < 100) {
                Log.d("TagInfo_Notify", "Waiting for sounds to load!!!");
                i2++;
                SystemClock.sleep(10);
            }
            if (this.f148f) {
                float streamVolume = (float) this.f145a.getStreamVolume(5);
                this.f147e.play(i, streamVolume, streamVolume, 1, 0, 1.0f);
            }
        }
    }

    public static void m180a(Context context, int i) {
        C0196b.m181a(context, i, R.drawable.ic_action_error, 1);
    }

    private static void m181a(Context context, int i, int i2, int i3) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.error_toast, null);
        if (inflate != null) {
            ((TextView) inflate.findViewById(R.id.error_message)).setText(i);
            ((ImageView) inflate.findViewById(R.id.error_image)).setImageResource(i2);
            Toast toast = new Toast(context);
            toast.setView(inflate);
            toast.setDuration(i3);
            toast.show();
        }
    }

    private boolean m183a(byte[] bArr, byte[] bArr2) {
        return (bArr == null || bArr2 == null) ? false : !Arrays.equals(bArr, bArr2) ? bArr.length == 4 && bArr2.length == 4 && (bArr[0] & MotionEventCompat.ACTION_MASK) == 8 && (bArr2[0] & MotionEventCompat.ACTION_MASK) == 8 : true;
    }

    public static void m184b(Context context, int i) {
        C0196b.m181a(context, i, R.drawable.ic_action_warning, 1);
    }

    private void m185b(C0213g c0213g, C0210d c0210d) {
        View inflate = this.f146d.getLayoutInflater().inflate(R.layout.nxp_ndef_toast, null);
        if (inflate != null) {
            if (!c0210d.m284a() && c0210d.m292h() == null) {
                inflate.findViewById(R.id.ndefDetected).setVisibility(8);
                inflate.findViewById(R.id.toastDivider).setVisibility(8);
            }
            if (!(c0210d.m284a() || c0210d.m292h() == null)) {
                ((TextView) inflate.findViewById(R.id.ndefDetected)).setText(R.string.toast_ndef_storage_detected);
            }
            if (c0213g.m303a() == null || !c0213g.m303a().m401a()) {
                inflate.findViewById(R.id.nxpDetected).setVisibility(8);
                inflate.findViewById(R.id.toastDivider).setVisibility(8);
            }
            Toast toast = new Toast(this.f146d);
            toast.setView(inflate);
            toast.setDuration(0);
            toast.setGravity(17, 0, 0);
            toast.show();
        }
    }

    public static void m186c(Context context, int i) {
        C0196b.m181a(context, i, R.drawable.ic_action_about, 0);
    }

    public void m187a(C0213g c0213g, C0210d c0210d) {
        int i;
        byte[] bArr = null;
        m178a();
        ay a = c0213g.m303a();
        int i2 = (c0210d.m284a() || (a != null && a.m401a())) ? 1 : 0;
        i2 = (i2 == 0 || !C0158a.m30a(this.f146d).m64v()) ? 0 : 1;
        if (a == null || (!a.m402b() && ((c0213g.m308b() == null || !c0213g.m308b().m496b()) && (c0213g.m310c() == null || !c0213g.m310c().m656b())))) {
            f143b = 0;
            if (a != null) {
                f144c = a.m403c();
            } else {
                f144c = null;
            }
            m179a(this.f150h);
            i = i2;
        } else {
            byte[] c = a.m403c();
            if (m183a(f144c, c)) {
                f143b++;
            } else {
                if (c != null) {
                    bArr = Arrays.copyOf(c, c.length);
                }
                f144c = bArr;
                f143b = 1;
            }
            if (f143b >= 3) {
                f143b = 0;
                C0196b.m180a(this.f146d, (int) R.string.toast_tag_error_message);
                i = 0;
            } else {
                C0196b.m184b(this.f146d, (int) R.string.toast_tag_lost_message);
                i = i2;
            }
            m179a(this.f151i);
        }
        if (i != 0) {
            m185b(c0213g, c0210d);
        }
    }

    public void m188a(boolean z) {
        if ((z && VERSION.SDK_INT <= 10) || (VERSION.SDK_INT >= 19 && C0158a.m30a(this.f146d).m59q())) {
            m179a(this.f149g);
        }
        m178a();
    }
}
