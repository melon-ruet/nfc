package com.nxp.taginfolite.fragments;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* renamed from: com.nxp.taginfolite.fragments.r */
class C0408r implements OnItemSelectedListener {
    final /* synthetic */ C0406p f1313a;

    C0408r(C0406p c0406p) {
        this.f1313a = c0406p;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        this.f1313a.f1312k = C0406p.f1308g[i];
        this.f1313a.m1316a(this.f1313a.f1312k);
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}
