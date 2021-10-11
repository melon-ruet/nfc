package com.nxp.taginfolite.p000a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.RadioGroup;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.a.ah */
class ah implements OnClickListener {
    final /* synthetic */ RadioGroup f11a;
    final /* synthetic */ RadioGroup f12b;
    final /* synthetic */ af f13c;

    ah(af afVar, RadioGroup radioGroup, RadioGroup radioGroup2) {
        this.f13c = afVar;
        this.f11a = radioGroup;
        this.f12b = radioGroup2;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f11a.getCheckedRadioButtonId()) {
            case R.id.sort_by_title:
                this.f13c.f9a.m14b(aj.TITLE);
                break;
            case R.id.sort_by_time:
                this.f13c.f9a.m14b(aj.TIME);
                break;
            case R.id.sort_by_ndef:
                this.f13c.f9a.m14b(aj.NDEF);
                break;
            case R.id.sort_by_uid:
                this.f13c.f9a.m14b(aj.UID);
                break;
        }
        switch (this.f12b.getCheckedRadioButtonId()) {
            case R.id.sort_descending:
                this.f13c.f9a.m12a(ak.DESC);
            case R.id.sort_ascending:
                this.f13c.f9a.m12a(ak.ASC);
            default:
        }
    }
}
