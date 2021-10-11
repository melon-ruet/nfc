package com.nxp.taginfolite.p000a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.RadioGroup;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.a.u */
class C0152u implements OnClickListener {
    final /* synthetic */ RadioGroup f53a;
    final /* synthetic */ RadioGroup f54b;
    final /* synthetic */ C0150s f55c;

    C0152u(C0150s c0150s, RadioGroup radioGroup, RadioGroup radioGroup2) {
        this.f55c = c0150s;
        this.f53a = radioGroup;
        this.f54b = radioGroup2;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f53a.getCheckedRadioButtonId()) {
            case R.id.sort_by_title:
                this.f55c.f51a.m14b(C0154w.TITLE);
                break;
            case R.id.sort_by_type:
                this.f55c.f51a.m14b(C0154w.TYPE);
                break;
            case R.id.sort_by_enabled:
                this.f55c.f51a.m14b(C0154w.ENABLED);
                break;
        }
        switch (this.f54b.getCheckedRadioButtonId()) {
            case R.id.sort_descending:
                this.f55c.f51a.m12a(C0155x.DESC);
            case R.id.sort_ascending:
                this.f55c.f51a.m12a(C0155x.ASC);
            default:
        }
    }
}
