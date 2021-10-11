package com.nxp.taginfolite.p000a;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* renamed from: com.nxp.taginfolite.a.b */
class C0133b implements OnItemClickListener {
    final /* synthetic */ AlertDialog f24a;
    final /* synthetic */ C0132a f25b;

    C0133b(C0132a c0132a, AlertDialog alertDialog) {
        this.f25b = c0132a;
        this.f24a = alertDialog;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f25b.f5b.m21a().m20a().onClick(this.f24a, i);
    }
}
