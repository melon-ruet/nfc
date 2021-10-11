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

/* renamed from: com.nxp.taginfolite.a.o */
public class C0146o extends DialogFragment {
    public Dialog onCreateDialog(Bundle bundle) {
        Context activity = getActivity();
        View inflate = LayoutInflater.from(activity).inflate(R.layout.message_dialog, null);
        Bundle arguments = getArguments();
        int i = arguments.getInt("TI_MessageDialogtitle", -1);
        int i2 = arguments.getInt("TI_MessageDialogtext", -1);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_title);
        if (i >= 0) {
            textView.setText(i);
        } else {
            textView.setVisibility(8);
            inflate.findViewById(R.id.dialog_title_divider).setVisibility(8);
        }
        textView = (TextView) inflate.findViewById(R.id.dialog_text);
        if (i2 >= 0) {
            textView.setText(i2);
        } else {
            textView.setVisibility(8);
        }
        return new Builder(activity).setView(inflate).setPositiveButton(R.string.dialog_button_ok, new C0147p(this)).create();
    }
}
