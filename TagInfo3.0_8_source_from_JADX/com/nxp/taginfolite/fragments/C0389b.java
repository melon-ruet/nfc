package com.nxp.taginfolite.fragments;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

/* renamed from: com.nxp.taginfolite.fragments.b */
class C0389b implements OnItemSelectedListener {
    final /* synthetic */ Spinner f1271a;
    final /* synthetic */ C0383a f1272b;

    C0389b(C0383a c0383a, Spinner spinner) {
        this.f1272b = c0383a;
        this.f1271a = spinner;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        Object itemAtPosition = this.f1271a.getItemAtPosition(i);
        if (itemAtPosition != null) {
            itemAtPosition.toString();
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}
