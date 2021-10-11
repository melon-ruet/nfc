package com.nxp.taginfolite.p000a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.RadioGroup;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.a.aa */
class aa implements OnClickListener {
    final /* synthetic */ RadioGroup f6a;
    final /* synthetic */ C0156y f7b;

    aa(C0156y c0156y, RadioGroup radioGroup) {
        this.f7b = c0156y;
        this.f6a = radioGroup;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f6a.getCheckedRadioButtonId()) {
            case R.id.new_key_mfc:
                this.f7b.f65a.m18a(0);
            case R.id.new_key_ulc:
                this.f7b.f65a.m18a(1);
            case R.id.new_key_ulev1:
                this.f7b.f65a.m18a(4);
            case R.id.new_key_ntag:
                this.f7b.f65a.m18a(3);
            default:
                C0196b.m180a(this.f7b.getActivity(), (int) R.string.toast_function_not_implemented);
                this.f7b.f65a.m19b();
        }
    }
}
