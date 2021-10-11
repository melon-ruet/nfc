package com.nxp.taginfolite.p000a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.a.a */
public class C0132a extends DialogFragment {
    private C0134c f4a;
    private C0135d f5b;

    private C0135d m15a() {
        this.f5b = (C0135d) getFragmentManager().findFragmentByTag("TI_ChooseFiletask");
        if (this.f5b == null) {
            this.f5b = new C0135d();
            getFragmentManager().beginTransaction().add(this.f5b, "TI_ChooseFiletask").commit();
        }
        return this.f5b;
    }

    public void m17a(C0134c c0134c) {
        this.f4a = c0134c;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m15a();
        if (this.f4a != null) {
            this.f5b.m22a(this.f4a);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Context activity = getActivity();
        View inflate = LayoutInflater.from(activity).inflate(R.layout.file_choose_dialog, null);
        ((TextView) inflate.findViewById(R.id.dialog_title)).setText(R.string.dialog_file_title);
        Bundle arguments = getArguments();
        String[] strArr = new String[0];
        if (arguments != null) {
            Object[] stringArray = arguments.getStringArray("TI_ChooseFilefiles");
        } else {
            String[] strArr2 = strArr;
        }
        ListView listView = (ListView) inflate.findViewById(R.id.dialog_list);
        if (stringArray == null || stringArray.length <= 0) {
            inflate.findViewById(R.id.no_files).setVisibility(0);
            listView.setVisibility(8);
            Object obj = null;
        } else {
            ListAdapter arrayAdapter = new ArrayAdapter(getActivity(), R.layout.file_select_dialog_item, stringArray);
            listView.setAdapter(arrayAdapter);
            ListAdapter listAdapter = arrayAdapter;
        }
        Dialog create = new Builder(activity).setView(inflate).create();
        if (listAdapter != null) {
            listView.setOnItemClickListener(new C0133b(this, create));
        }
        return create;
    }
}
