package com.nxp.taginfolite.p000a;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.a.al */
public class al extends DialogFragment {
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.tag_scan_dialog, null);
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(1);
        dialog.setContentView(inflate);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().clearFlags(2);
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(inflate.findViewById(R.id.tag_scan_dialog_lblText).getWindowToken(), 0);
        return dialog;
    }
}
