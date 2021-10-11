package com.nxp.taginfolite.p000a;

import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* renamed from: com.nxp.taginfolite.a.h */
class C0139h implements OnEditorActionListener {
    final /* synthetic */ EditText f32a;
    final /* synthetic */ AlertDialog f33b;
    final /* synthetic */ C0136e f34c;

    C0139h(C0136e c0136e, EditText editText, AlertDialog alertDialog) {
        this.f34c = c0136e;
        this.f32a = editText;
        this.f33b = alertDialog;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (6 != i) {
            return false;
        }
        CharSequence text = this.f32a.getText();
        if (!TextUtils.isEmpty(text)) {
            this.f34c.f27a.m25a(this.f34c.f28b, text.toString().trim());
        }
        this.f33b.dismiss();
        return true;
    }
}
