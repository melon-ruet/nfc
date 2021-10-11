package com.nxp.taginfolite.p000a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.nxp.taginfolite.C0206d;

/* renamed from: com.nxp.taginfolite.a.m */
class C0144m implements OnClickListener {
    final /* synthetic */ EditText f41a;
    final /* synthetic */ Activity f42b;
    final /* synthetic */ C0141j f43c;

    C0144m(C0141j c0141j, EditText editText, Activity activity) {
        this.f43c = c0141j;
        this.f41a = editText;
        this.f42b = activity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f43c.f35a.putExtra("android.intent.extra.SUBJECT", this.f41a.getText().toString());
        this.f43c.m26a(this.f42b, this.f41a);
        C0206d.m259a(this.f42b, this.f43c.f35a);
    }
}
