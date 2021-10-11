package com.nxp.taginfolite.fragments;

import android.os.Handler;
import android.os.Message;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.fragments.n */
class C0404n extends Handler {
    private final C0386g f1303a;
    private int f1304b;
    private boolean f1305c;

    public C0404n(C0386g c0386g) {
        this.f1304b = 1;
        this.f1305c = false;
        this.f1303a = c0386g;
    }

    public void m1307a() {
        new C0405o(this).run();
    }

    public void m1308b() {
        Message message = new Message();
        message.what = 4;
        sendMessage(message);
        m1307a();
    }

    public void m1309c() {
        Message message = new Message();
        message.what = 1;
        sendMessage(message);
    }

    public void m1310d() {
        Message message = new Message();
        message.what = 2;
        sendMessage(message);
    }

    public void m1311e() {
        this.f1305c = true;
    }

    public void handleMessage(Message message) {
        boolean z = false;
        if (this.f1304b > 0) {
            switch (message.what) {
                case C0519c.Switch_track /*1*/:
                    this.f1304b = 0;
                    break;
                case C0519c.Switch_textOn /*2*/:
                    this.f1304b = 0;
                    z = true;
                    break;
                case C0519c.Switch_textOff /*3*/:
                    this.f1304b--;
                    z = true;
                    break;
                case C0519c.Switch_thumbTextPadding /*4*/:
                    this.f1304b++;
                    break;
                default:
                    this.f1304b = 0;
                    break;
            }
            if (this.f1304b == 0 && !this.f1305c) {
                this.f1303a.f1248y.setVisibility(8);
                this.f1303a.m1204a(z);
            }
        }
    }
}
