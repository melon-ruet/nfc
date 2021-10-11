package com.nxp.taginfolite.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.data.AuthKey;

/* renamed from: com.nxp.taginfolite.fragments.a */
public class C0383a extends C0382c {
    private String m1169a(Activity activity) {
        return m1160a(activity, R.id.edit_name_df);
    }

    private byte[] m1170b(Activity activity) {
        int i = 0;
        Object a = m1162a(activity, (int) R.id.edit_key_value_df1, 8);
        Object a2 = m1162a(activity, (int) R.id.edit_key_value_df2, 8);
        Object a3 = m1162a(activity, (int) R.id.edit_key_value_df3, 8);
        Object obj = new byte[25];
        if (a == null) {
            return null;
        }
        System.arraycopy(a, i, obj, i, 8);
        if (a2 != null) {
            System.arraycopy(a2, i, obj, 8, 8);
        }
        if (a3 != null) {
            System.arraycopy(a3, i, obj, 16, 8);
        }
        try {
            i = Integer.parseInt(m1176h(activity));
        } catch (NumberFormatException e) {
        }
        obj[24] = (byte) (i & MotionEventCompat.ACTION_MASK);
        return obj;
    }

    private String m1171c(Activity activity) {
        return m1164b(activity, R.id.spinner_ic_mem_df);
    }

    private String m1172d(Activity activity) {
        return m1164b(activity, R.id.spinner_ic_type_df);
    }

    private String m1173e(Activity activity) {
        String b = m1164b(activity, R.id.spinner_aid_type_df);
        return getString(R.string.aid_type_df).equals(b) ? "AID" : getString(R.string.aid_type_iso).equals(b) ? "ISO" : "AID";
    }

    private String m1174f(Activity activity) {
        return m1160a(activity, R.id.edit_aid_value);
    }

    private String m1175g(Activity activity) {
        String b = m1164b(activity, R.id.spinner_key_type_df);
        return getString(R.string.key_type_df_aes).equals(b) ? "AES" : getString(R.string.key_type_df_3k3des).equals(b) ? "3K3" : getString(R.string.key_type_df_2k3des).equals(b) ? "2K3" : getString(R.string.key_type_df_des).equals(b) ? "DES" : "3K3";
    }

    private String m1176h(Activity activity) {
        return m1160a(activity, R.id.edit_key_no);
    }

    protected void m1177a() {
        Activity activity = getActivity();
        String a = m1169a(activity);
        String c = m1171c(activity);
        String str = "DFR";
        String str2 = "DF";
        this.e = new AuthKey(a, this.a.isChecked(), str, c, m1173e(activity), m1174f(activity), str2, m1172d(activity), m1175g(activity), m1170b(activity));
    }

    public int m1178b() {
        return R.string.key_editor_df;
    }

    public boolean m1179c() {
        Activity activity = getActivity();
        return (TextUtils.isEmpty(m1169a(activity)) || m1170b(activity) == null || m1174f(activity) == null || m1176h(activity) == null) ? false : true;
    }

    public void m1180d() {
        C0196b.m180a(getActivity(), (int) R.string.toast_missing_fields);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.key_editor_desfire, viewGroup, false);
        if (inflate == null) {
            throw new RuntimeException("Cannot inflate layout!");
        }
        Spinner spinner = (Spinner) inflate.findViewById(R.id.spinner_ic_type_df);
        spinner.setOnItemSelectedListener(new C0389b(this, spinner));
        return inflate;
    }

    public void onSaveInstanceState(Bundle bundle) {
        m1177a();
        super.onSaveInstanceState(bundle);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        Activity activity = getActivity();
        if (this.e != null) {
            int i;
            Object itemAtPosition;
            String str;
            int i2;
            TextView textView = (TextView) activity.findViewById(R.id.edit_name_df);
            CharSequence a = this.e.m266a();
            if (!TextUtils.isEmpty(a)) {
                textView.setText(a);
            }
            this.a.setChecked(this.e.m268b());
            Spinner spinner = (Spinner) activity.findViewById(R.id.spinner_ic_type_df);
            String h = this.e.m274h();
            for (i = 0; i < spinner.getCount(); i++) {
                itemAtPosition = spinner.getItemAtPosition(i);
                if (itemAtPosition != null && itemAtPosition.toString().equals(h)) {
                    spinner.setSelection(i);
                    break;
                }
            }
            spinner = (Spinner) activity.findViewById(R.id.spinner_ic_mem_df);
            h = this.e.m270d();
            for (i = 0; i < spinner.getCount(); i++) {
                itemAtPosition = spinner.getItemAtPosition(i);
                if (itemAtPosition != null && itemAtPosition.toString().equals(h)) {
                    spinner.setSelection(i);
                    break;
                }
            }
            h = this.e.m271e();
            String string = getString(R.string.aid_type_df);
            Object string2 = getString(R.string.aid_type_iso);
            if ("AID".equals(h)) {
                string2 = string;
            } else if (!"ISO".equals(h)) {
                str = string;
            }
            spinner = (Spinner) activity.findViewById(R.id.spinner_aid_type_df);
            for (i2 = 0; i2 < spinner.getCount(); i2++) {
                itemAtPosition = spinner.getItemAtPosition(i2);
                if (itemAtPosition != null && itemAtPosition.toString().equals(r1)) {
                    spinner.setSelection(i2);
                    break;
                }
            }
            textView = (TextView) activity.findViewById(R.id.edit_aid_value);
            a = this.e.m272f();
            if (!TextUtils.isEmpty(a)) {
                textView.setText(a);
            }
            String i3 = this.e.m275i();
            string = getString(R.string.key_type_df_aes);
            string2 = getString(R.string.key_type_df_3k3des);
            h = getString(R.string.key_type_df_2k3des);
            String string3 = getString(R.string.key_type_df_des);
            if ("AES".equals(i3)) {
                string2 = string;
            } else if (!"3K3".equals(i3)) {
                str = "2K3".equals(i3) ? h : "DES".equals(i3) ? string3 : string;
            }
            spinner = (Spinner) activity.findViewById(R.id.spinner_key_type_df);
            for (i2 = 0; i2 < spinner.getCount(); i2++) {
                itemAtPosition = spinner.getItemAtPosition(i2);
                if (itemAtPosition != null && itemAtPosition.toString().equals(r1)) {
                    spinner.setSelection(i2);
                    break;
                }
            }
            byte[] j = this.e.m276j();
            int[] iArr = new int[]{R.id.edit_key_value_df1, R.id.edit_key_value_df2, R.id.edit_key_value_df3};
            if (j != null && j.length >= 25) {
                for (i2 = 0; i2 < 3; i2++) {
                    textView = (TextView) activity.findViewById(iArr[i2]);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (i = 0; i < 8; i++) {
                        stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(j[(i2 * 8) + i])}));
                    }
                    textView.setText(stringBuilder.toString());
                }
                ((TextView) activity.findViewById(R.id.edit_key_no)).setText(Integer.toString(j[24]));
                return;
            }
            return;
        }
        this.a.setChecked(true);
    }
}
