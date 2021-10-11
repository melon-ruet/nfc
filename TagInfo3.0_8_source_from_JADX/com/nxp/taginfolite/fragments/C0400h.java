package com.nxp.taginfolite.fragments;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

/* renamed from: com.nxp.taginfolite.fragments.h */
class C0400h implements OnItemLongClickListener {
    final /* synthetic */ C0386g f1299a;

    C0400h(C0386g c0386g) {
        this.f1299a = c0386g;
    }

    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        this.f1299a.m1201a(i, j);
        return true;
    }
}
