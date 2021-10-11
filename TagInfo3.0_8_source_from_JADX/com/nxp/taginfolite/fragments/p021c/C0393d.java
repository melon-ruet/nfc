package com.nxp.taginfolite.fragments.p021c;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* renamed from: com.nxp.taginfolite.fragments.c.d */
class C0393d implements OnGlobalLayoutListener {
    final /* synthetic */ C0390a f1288a;

    C0393d(C0390a c0390a) {
        this.f1288a = c0390a;
    }

    public void onGlobalLayout() {
        if (this.f1288a.f1276d != null) {
            this.f1288a.m1278b();
            this.f1288a.f1276d.update(this.f1288a.f1274b, this.f1288a.f1279g, this.f1288a.f1280h, this.f1288a.f1281i, this.f1288a.f1282j);
        }
    }
}
