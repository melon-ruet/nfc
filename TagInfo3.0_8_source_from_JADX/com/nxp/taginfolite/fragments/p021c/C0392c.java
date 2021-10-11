package com.nxp.taginfolite.fragments.p021c;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* renamed from: com.nxp.taginfolite.fragments.c.c */
class C0392c implements OnItemClickListener {
    final /* synthetic */ C0390a f1287a;

    C0392c(C0390a c0390a) {
        this.f1287a = c0390a;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.f1287a.f1276d != null) {
            this.f1287a.f1276d.dismiss();
            if (this.f1287a.f1278f != null) {
                this.f1287a.f1278f.m1193a((int) j);
            }
        }
    }
}
