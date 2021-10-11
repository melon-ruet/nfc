package com.nxp.taginfolite.activities;

import android.view.View;
import android.view.View.OnClickListener;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.activities.a */
class C0165a implements OnClickListener {
    final /* synthetic */ About f103a;

    C0165a(About about) {
        this.f103a = about;
    }

    public void onClick(View view) {
        this.f103a.m73a(Integer.valueOf(R.string.name_license), Integer.valueOf(R.string.license_EULA));
    }
}
