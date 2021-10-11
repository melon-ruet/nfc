package com.nxp.taginfolite.p002d;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.d.c */
class C0204c extends Handler {
    WeakReference f213a;

    public C0204c(C0203b c0203b) {
        this.f213a = new WeakReference(c0203b);
    }

    public void handleMessage(Message message) {
        C0203b c0203b = (C0203b) this.f213a.get();
        if (c0203b != null) {
            c0203b.f209c = message.what;
            switch (message.what) {
                case C0519c.Switch_track /*1*/:
                    if (!c0203b.f211e) {
                        C0203b.m252b(c0203b.f207a, message.what);
                        break;
                    }
                    break;
                case C0519c.Switch_textOn /*2*/:
                    if (!c0203b.f211e) {
                        C0203b.m252b(c0203b.f207a, message.what);
                        break;
                    }
                    break;
            }
            c0203b.f211e = true;
        }
    }
}
