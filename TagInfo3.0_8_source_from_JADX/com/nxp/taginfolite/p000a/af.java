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

/* renamed from: com.nxp.taginfolite.a.af */
public class af extends DialogFragment {
    C0131a f9a;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f9a = (C0131a) getTargetFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException("Target fragment must implement SortDialogListener");
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.scan_sort_dialog, null);
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.sort_group_item);
        RadioGroup radioGroup2 = (RadioGroup) inflate.findViewById(R.id.sort_group_order);
        Dialog create = new Builder(getActivity()).setView(inflate).setPositiveButton(R.string.dialog_button_ok, new ah(this, radioGroup, radioGroup2)).setNegativeButton(R.string.dialog_button_cancel, new ag(this)).setCancelable(true).create();
        switch (ai.f14a[((aj) this.f9a.m13b()).ordinal()]) {
            case C0519c.Switch_track /*1*/:
                radioGroup.check(R.id.sort_by_time);
                break;
            case C0519c.Switch_textOn /*2*/:
                radioGroup.check(R.id.sort_by_title);
                break;
            case C0519c.Switch_textOff /*3*/:
                radioGroup.check(R.id.sort_by_ndef);
                break;
            case C0519c.Switch_thumbTextPadding /*4*/:
                radioGroup.check(R.id.sort_by_uid);
                break;
        }
        switch (ai.f15b[((ak) this.f9a.m11a()).ordinal()]) {
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
