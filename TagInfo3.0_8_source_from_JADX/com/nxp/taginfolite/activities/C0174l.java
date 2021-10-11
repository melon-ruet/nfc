package com.nxp.taginfolite.activities;

import android.view.View;
import android.view.View.OnClickListener;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.activities.l */
class C0174l implements OnClickListener {
    final /* synthetic */ License f113a;

    C0174l(License license) {
        this.f113a = license;
    }

    public void onClick(View view) {
        this.f113a.m73a(Integer.valueOf(R.string.license_notices_title), Integer.valueOf(R.string.license_notices));
    }
}
