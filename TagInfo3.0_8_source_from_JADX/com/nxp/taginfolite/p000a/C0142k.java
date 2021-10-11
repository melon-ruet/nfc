package com.nxp.taginfolite.p000a;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.nxp.taginfolite.C0158a;

/* renamed from: com.nxp.taginfolite.a.k */
class C0142k implements OnCheckedChangeListener {
    final /* synthetic */ C0158a f36a;
    final /* synthetic */ C0141j f37b;

    C0142k(C0141j c0141j, C0158a c0158a) {
        this.f37b = c0141j;
        this.f36a = c0158a;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f36a.m53k();
        } else {
            this.f36a.m52j();
        }
    }
}
