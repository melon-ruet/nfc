package com.nxp.taginfolite.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.BuildConfig;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.data.AuthKey;

/* renamed from: com.nxp.taginfolite.fragments.w */
public class C0419w extends C0382c {
    private String f1339f;

    private String m1352a(Activity activity) {
        return m1160a(activity, R.id.edit_name_ntag);
    }

    private byte[] m1353b(Activity activity) {
        return m1162a(activity, (int) R.id.edit_key_ntag0, 4);
    }

    protected void m1354a() {
        Activity activity = getActivity();
        String a = m1352a(activity);
        boolean isChecked = this.a.isChecked();
        byte[] b = m1353b(activity);
        Object obj = BuildConfig.VERSION_NAME;
        String str = TextUtils.isEmpty(obj) ? BuildConfig.VERSION_NAME : "UID";
        if (TextUtils.isEmpty(this.f1339f)) {
            this.f1339f = "21X";
        }
        this.e = new AuthKey(a, isChecked, this.f1339f, BuildConfig.VERSION_NAME, str, obj, BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME, b);
    }

    public int m1355b() {
        return "UL1".equals(this.f1339f) ? R.string.key_editor_ul_ev1 : R.string.key_editor_ntag;
    }

    public boolean m1356c() {
        Activity activity = getActivity();
        return (TextUtils.isEmpty(m1352a(activity)) || m1353b(activity) == null) ? false : true;
    }

    public void m1357d() {
        C0196b.m180a(getActivity(), (int) R.string.toast_missing_fields);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f1339f = arguments.getString("TagInfo_NtagKeyEditorFragmentkey_type");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.key_editor_ntag, viewGroup, false);
        if (inflate != null) {
            return inflate;
        }
        throw new RuntimeException("Cannot inflate layout!");
    }

    public void onSaveInstanceState(Bundle bundle) {
        m1354a();
        super.onSaveInstanceState(bundle);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        Activity activity = getActivity();
        if (this.e != null) {
            TextView textView = (TextView) activity.findViewById(R.id.edit_name_ntag);
            CharSequence a = this.e.m266a();
            if (!TextUtils.isEmpty(a)) {
                textView.setText(a);
            }
            this.a.setChecked(this.e.m268b());
            textView = (TextView) activity.findViewById(R.id.edit_key_ntag0);
            byte[] j = this.e.m276j();
            if (j != null && j.length >= 4) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(j[i])}));
                }
                textView.setText(stringBuilder.toString());
                return;
            }
            return;
        }
        this.a.setChecked(true);
    }
}
