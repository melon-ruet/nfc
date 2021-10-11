package com.nxp.taginfolite.p000a;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.nxp.taginfolite.C0206d;

/* renamed from: com.nxp.taginfolite.a.n */
class C0145n implements OnEditorActionListener {
    final /* synthetic */ EditText f44a;
    final /* synthetic */ Activity f45b;
    final /* synthetic */ AlertDialog f46c;
    final /* synthetic */ C0141j f47d;

    C0145n(C0141j c0141j, EditText editText, Activity activity, AlertDialog alertDialog) {
        this.f47d = c0141j;
        this.f44a = editText;
        this.f45b = activity;
        this.f46c = alertDialog;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (6 != i) {
            return false;
        }
        this.f47d.f35a.putExtra("android.intent.extra.SUBJECT", this.f44a.getText().toString());
        this.f47d.m26a(this.f45b, this.f44a);
        C0206d.m259a(this.f45b, this.f47d.f35a);
        this.f46c.dismiss();
        return true;
    }
}
