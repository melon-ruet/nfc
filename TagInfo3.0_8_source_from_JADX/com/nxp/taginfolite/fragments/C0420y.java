package com.nxp.taginfolite.fragments;

import android.support.v4.BuildConfig;
import android.view.View;
import android.view.View.OnFocusChangeListener;

/* renamed from: com.nxp.taginfolite.fragments.y */
class C0420y implements OnFocusChangeListener {
    final /* synthetic */ C0384x f1340a;

    C0420y(C0384x c0384x) {
        this.f1340a = c0384x;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.f1340a.f1220c) {
            this.f1340a.m1185c();
            this.f1340a.f1223u = BuildConfig.VERSION_NAME;
            this.f1340a.f1218a.collapseActionView();
        }
        this.f1340a.f1220c = !this.f1340a.f1220c;
    }
}
