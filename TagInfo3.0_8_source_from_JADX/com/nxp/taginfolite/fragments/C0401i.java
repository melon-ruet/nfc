package com.nxp.taginfolite.fragments;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: com.nxp.taginfolite.fragments.i */
class C0401i implements OnTouchListener {
    final /* synthetic */ C0386g f1300a;

    C0401i(C0386g c0386g) {
        this.f1300a = c0386g;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f1300a.f1249z != null) {
            this.f1300a.f1249z.m1308b();
        }
        return false;
    }
}
