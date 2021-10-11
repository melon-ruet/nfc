package com.nxp.taginfolite.activities;

import android.view.View;
import android.view.View.OnClickListener;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.activities.b */
class C0166b implements OnClickListener {
    final /* synthetic */ About f104a;

    C0166b(About about) {
        this.f104a = about;
    }

    public void onClick(View view) {
        this.f104a.m73a(Integer.valueOf(R.string.license_notices_title), Integer.valueOf(R.string.license_notices));
    }
}
