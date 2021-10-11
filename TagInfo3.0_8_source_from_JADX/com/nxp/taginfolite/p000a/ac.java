package com.nxp.taginfolite.p000a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.a.ac */
public class ac extends DialogFragment {
    public Dialog onCreateDialog(Bundle bundle) {
        Context activity = getActivity();
        View inflate = LayoutInflater.from(activity).inflate(R.layout.message_dialog, null);
        Bundle arguments = getArguments();
        int i = arguments.getInt("TI_NfcSettingstitle");
        int i2 = arguments.getInt("TI_NfcSettingstext");
        ((TextView) inflate.findViewById(R.id.dialog_title)).setText(i);
        ((TextView) inflate.findViewById(R.id.dialog_text)).setText(i2);
        return new Builder(activity).setView(inflate).setPositiveButton(R.string.dialog_button_settings, new ad(this)).create();
    }
}
