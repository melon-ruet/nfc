package com.nxp.taginfolite.p000a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;

/* renamed from: com.nxp.taginfolite.a.l */
class C0143l implements OnClickListener {
    final /* synthetic */ Activity f38a;
    final /* synthetic */ EditText f39b;
    final /* synthetic */ C0141j f40c;

    C0143l(C0141j c0141j, Activity activity, EditText editText) {
        this.f40c = c0141j;
        this.f38a = activity;
        this.f39b = editText;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f40c.m26a(this.f38a, this.f39b);
        dialogInterface.dismiss();
    }
}
