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

/* renamed from: com.nxp.taginfolite.a.q */
public class C0148q extends DialogFragment {
    public Dialog onCreateDialog(Bundle bundle) {
        Context activity = getActivity();
        View inflate = LayoutInflater.from(activity).inflate(R.layout.message_dialog, null);
        ((TextView) inflate.findViewById(R.id.dialog_title)).setText(R.string.dialog_install_title);
        ((TextView) inflate.findViewById(R.id.dialog_text)).setText(R.string.dialog_install_text);
        return new Builder(activity).setView(inflate).setPositiveButton(R.string.dialog_install_ok, new C0149r(this, activity)).create();
    }
}
