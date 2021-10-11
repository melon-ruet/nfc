package com.nxp.taginfolite.p004f.p015a;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.f.a.f */
public class C0333f {
    C0332d f970a;
    boolean f971b;
    int f972c;

    public C0333f(int i) {
        if (i > MotionEventCompat.ACTION_MASK) {
            int i2 = i >> 8;
            this.f972c = i & TransportMediator.KEYCODE_MEDIA_PAUSE;
            i = i2;
        } else {
            this.f972c = i & 31;
        }
        switch ((i >> 6) & 3) {
            case C0519c.Switch_thumb /*0*/:
                this.f970a = C0332d.UNIVERSAL;
                break;
            case C0519c.Switch_track /*1*/:
                this.f970a = C0332d.APPLICATION;
                break;
            case C0519c.Switch_textOn /*2*/:
                this.f970a = C0332d.CONTEXT_SPECIFIC;
                break;
            case C0519c.Switch_textOff /*3*/:
                this.f970a = C0332d.PRIVATE;
                break;
        }
        this.f971b = (i & 32) != 0;
    }

    public C0332d m952a() {
        return this.f970a;
    }

    public boolean m953b() {
        return this.f971b;
    }

    public int m954c() {
        return this.f972c;
    }
}
