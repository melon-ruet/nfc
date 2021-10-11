package com.nxp.taginfolite.p000a;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.a.y */
public class C0156y extends DialogFragment {
    ab f65a;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f65a = (ab) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Target fragment must implement SortDialogListener");
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.new_key_dialog, null);
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.key_group_item);
        if (!C0158a.m29a().m68z()) {
            RadioButton radioButton = (RadioButton) radioGroup.findViewById(R.id.new_key_mfc);
            if (radioButton != null) {
                radioButton.setEnabled(false);
            }
        }
        return new Builder(getActivity()).setView(inflate).setPositiveButton(R.string.dialog_button_ok, new aa(this, radioGroup)).setNegativeButton(R.string.dialog_button_cancel, new C0157z(this)).setCancelable(true).create();
    }
}
