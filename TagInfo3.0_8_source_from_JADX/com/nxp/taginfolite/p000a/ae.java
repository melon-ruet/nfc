package com.nxp.taginfolite.p000a;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/* renamed from: com.nxp.taginfolite.a.ae */
public class ae extends DialogFragment {
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog progressDialog = new ProgressDialog(getActivity());
        int i = getArguments().getInt("TI_ProgressDialogtext", -1);
        if (i >= 0) {
            progressDialog.setMessage(getActivity().getText(i));
        }
        return progressDialog;
    }
}
