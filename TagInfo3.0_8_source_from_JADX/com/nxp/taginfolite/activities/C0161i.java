package com.nxp.taginfolite.activities;

import android.os.Bundle;
import android.widget.TextView;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.activities.i */
public class C0161i extends C0160g {
    protected void m76a(int i) {
        m77a(getString(i));
    }

    protected void m77a(String str) {
        ((TextView) findViewById(R.id.custom_title)).setText(str);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c.setCustomView((int) R.layout.custom_bar);
        this.c.setDisplayShowCustomEnabled(true);
    }
}
