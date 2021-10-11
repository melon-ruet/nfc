package com.nxp.taginfolite.ndef.span;

import android.content.ActivityNotFoundException;
import android.text.style.URLSpan;
import android.view.View;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.R;

public class UrlSpan extends URLSpan {
    public UrlSpan(String str) {
        super(str);
    }

    public void onClick(View view) {
        try {
            super.onClick(view);
        } catch (ActivityNotFoundException e) {
            C0196b.m180a(view.getContext(), (int) R.string.toast_no_app_installed_uri);
        }
    }
}
