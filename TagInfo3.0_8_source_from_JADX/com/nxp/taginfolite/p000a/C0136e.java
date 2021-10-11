package com.nxp.taginfolite.p000a;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.a.e */
public class C0136e extends DialogFragment {
    C0140i f27a;
    private long f28b;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f27a = (C0140i) getTargetFragment();
            Bundle arguments = getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Edit title: missing arguments!");
            }
            this.f28b = arguments.getLong("edit_id");
            if (this.f28b == 0) {
                throw new IllegalArgumentException("Edit title: missing argument ID!");
            }
        } catch (ClassCastException e) {
            throw new ClassCastException("Target fragment must implement EditTitleDialogListener");
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Context activity = getActivity();
        View inflate = LayoutInflater.from(activity).inflate(R.layout.edit_title_dialog, null);
        EditText editText = (EditText) inflate.findViewById(R.id.dialog_get_subject_text);
        editText.setText(this.f27a.m24a(this.f28b));
        Dialog create = new Builder(activity).setView(inflate).setPositiveButton(R.string.dialog_edit_title_ok, new C0138g(this, editText)).setNegativeButton(R.string.dialog_button_cancel, new C0137f(this)).create();
        editText.setOnEditorActionListener(new C0139h(this, editText, create));
        editText.requestFocus();
        editText.setSelection(0);
        create.getWindow().setSoftInputMode(4);
        create.getWindow().setGravity(48);
        return create;
    }
}
