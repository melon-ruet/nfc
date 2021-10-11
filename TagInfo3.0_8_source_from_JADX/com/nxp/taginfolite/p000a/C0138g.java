package com.nxp.taginfolite.p000a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;

/* renamed from: com.nxp.taginfolite.a.g */
class C0138g implements OnClickListener {
    final /* synthetic */ EditText f30a;
    final /* synthetic */ C0136e f31b;

    C0138g(C0136e c0136e, EditText editText) {
        this.f31b = c0136e;
        this.f30a = editText;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        CharSequence text = this.f30a.getText();
        if (!TextUtils.isEmpty(text)) {
            this.f31b.f27a.m25a(this.f31b.f28b, text.toString().trim());
        }
    }
}
