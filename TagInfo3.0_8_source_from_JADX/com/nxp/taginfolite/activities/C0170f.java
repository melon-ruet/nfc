package com.nxp.taginfolite.activities;

import android.view.View;
import android.view.View.OnClickListener;
import com.nxp.taginfolite.C0373f;

/* renamed from: com.nxp.taginfolite.activities.f */
class C0170f implements OnClickListener {
    final /* synthetic */ String f108a;
    final /* synthetic */ About f109b;

    C0170f(About about, String str) {
        this.f109b = about;
        this.f108a = str;
    }

    public void onClick(View view) {
        this.f109b.m81a("nfcapp.support@nxp.com", "TagInfo registration request", C0373f.m1125a(this.f108a));
    }
}
