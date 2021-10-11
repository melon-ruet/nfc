package com.nxp.taginfolite.p000a;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.RadioGroup;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.p000a.p001a.C0131a;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.a.s */
public class C0150s extends DialogFragment {
    C0131a f51a;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f51a = (C0131a) getTargetFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException("Target fragment must implement SortDialogListener");
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.key_sort_dialog, null);
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.sort_group_item);
        RadioGroup radioGroup2 = (RadioGroup) inflate.findViewById(R.id.sort_group_order);
        Dialog create = new Builder(getActivity()).setView(inflate).setPositiveButton(R.string.dialog_button_ok, new C0152u(this, radioGroup, radioGroup2)).setNegativeButton(R.string.dialog_button_cancel, new C0151t(this)).setCancelable(true).create();
        switch (C0153v.f56a[((C0154w) this.f51a.m13b()).ordinal()]) {
            case C0519c.Switch_track /*1*/:
                radioGroup.check(R.id.sort_by_title);
                break;
            case C0519c.Switch_textOn /*2*/:
                radioGroup.check(R.id.sort_by_type);
                break;
            case C0519c.Switch_textOff /*3*/:
                radioGroup.check(R.id.sort_by_enabled);
                break;
        }
        switch (C0153v.f57b[((C0155x) this.f51a.m11a()).ordinal()]) {
            case C0519c.Switch_track /*1*/:
                radioGroup2.check(R.id.sort_ascending);
                break;
            case C0519c.Switch_textOn /*2*/:
                radioGroup2.check(R.id.sort_descending);
                break;
        }
        return create;
    }
}
