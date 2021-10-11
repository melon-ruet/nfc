package com.nxp.taginfolite.p000a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.a.j */
public class C0141j extends DialogFragment {
    Intent f35a;

    private void m26a(Context context, TextView textView) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(textView.getWindowToken(), 0);
    }

    public void m28a(Intent intent) {
        this.f35a = intent;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f35a = (Intent) bundle.getParcelable("TagInfo_GetSubjectDialog.INTENT");
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Context activity = getActivity();
        C0158a a = C0158a.m30a(activity);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.get_subject_dialog, null);
        EditText editText = (EditText) inflate.findViewById(R.id.dialog_get_subject_text);
        editText.setText(this.f35a.getStringExtra("android.intent.extra.SUBJECT"));
        ((CheckBox) inflate.findViewById(R.id.dialog_get_subject_check)).setOnCheckedChangeListener(new C0142k(this, a));
        Dialog create = new Builder(activity).setView(inflate).setPositiveButton(R.string.dialog_get_subject_ok, new C0144m(this, editText, activity)).setNegativeButton(R.string.dialog_button_cancel, new C0143l(this, activity, editText)).create();
        editText.setOnEditorActionListener(new C0145n(this, editText, activity, create));
        editText.requestFocus();
        editText.setSelection(0);
        create.getWindow().setSoftInputMode(4);
        create.getWindow().setGravity(48);
        return create;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f35a != null) {
            bundle.putParcelable("TagInfo_GetSubjectDialog.INTENT", this.f35a);
        }
    }
}
