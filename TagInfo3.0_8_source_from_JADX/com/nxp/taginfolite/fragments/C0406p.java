package com.nxp.taginfolite.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.data.AuthKey;
import java.util.HashMap;

/* renamed from: com.nxp.taginfolite.fragments.p */
public class C0406p extends C0382c implements OnClickListener {
    public static final HashMap f1307f;
    private static final int[] f1308g;
    private static final int[] f1309h;
    private final CheckedTextView[] f1310i;
    private boolean f1311j;
    private int f1312k;

    static {
        f1308g = new int[]{40, 16, 32, 40, 5};
        f1309h = new int[]{R.id.checkedTextView, R.id.checkedTextView1, R.id.checkedTextView2, R.id.checkedTextView3, R.id.checkedTextView4, R.id.checkedTextView5, R.id.checkedTextView6, R.id.checkedTextView7, R.id.checkedTextView8, R.id.checkedTextView9, R.id.checkedTextView10, R.id.checkedTextView11, R.id.checkedTextView12, R.id.checkedTextView13, R.id.checkedTextView14, R.id.checkedTextView15, R.id.checkedTextView16, R.id.checkedTextView17, R.id.checkedTextView18, R.id.checkedTextView19, R.id.checkedTextView20, R.id.checkedTextView21, R.id.checkedTextView22, R.id.checkedTextView23, R.id.checkedTextView24, R.id.checkedTextView25, R.id.checkedTextView26, R.id.checkedTextView27, R.id.checkedTextView28, R.id.checkedTextView29, R.id.checkedTextView30, R.id.checkedTextView31, R.id.checkedTextView32, R.id.checkedTextView33, R.id.checkedTextView34, R.id.checkedTextView35, R.id.checkedTextView36, R.id.checkedTextView37, R.id.checkedTextView38, R.id.checkedTextView39};
        f1307f = new C0407q();
    }

    public C0406p() {
        this.f1310i = new CheckedTextView[f1309h.length];
        this.f1312k = 40;
    }

    private String m1314a(Activity activity) {
        return m1160a(activity, R.id.edit_name_mfc);
    }

    public static String m1315a(String str, String str2, String str3) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Key ");
        stringBuilder.append(str);
        Integer num = (Integer) f1307f.get(str2);
        if (num == null) {
            num = Integer.valueOf(40);
        }
        int[] iArr = new int[num.intValue()];
        int i2 = 0;
        while (i2 < iArr.length) {
            iArr[i2] = "1".equals(str3.substring(i2, i2 + 1)) ? 1 : 0;
            if (i2 > 1 && iArr[i2] == 1 && iArr[i2 - 1] == 1 && (iArr[i2 - 2] == 1 || iArr[i2 - 2] == -1)) {
                iArr[i2 - 1] = -1;
            }
            i2++;
        }
        stringBuilder.append(", sectors ");
        i2 = -2;
        while (i < iArr.length) {
            if (iArr[i] == 1) {
                if (i2 != -1 && i > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(Integer.toString(i));
            } else if (iArr[i] == -1 && i2 != -1) {
                stringBuilder.append("-");
            }
            i2 = iArr[i];
            i++;
        }
        return stringBuilder.toString();
    }

    private void m1316a(int i) {
        int i2 = 0;
        while (i2 < i && i2 < f1309h.length) {
            this.f1310i[i2].setEnabled(true);
            i2++;
        }
        while (i < f1309h.length) {
            this.f1310i[i].setEnabled(false);
            i++;
        }
    }

    private String m1317b(Activity activity) {
        return m1164b(activity, R.id.spinner_ic_type_mfc);
    }

    private String m1319c(Activity activity) {
        return m1164b(activity, R.id.spinner_ic_mem_mfc);
    }

    private String m1320d(Activity activity) {
        return m1164b(activity, R.id.spinner_key_type_mfc);
    }

    private byte[] m1321e(Activity activity) {
        return m1162a(activity, (int) R.id.edit_key_value_mfc, C0158a.f67a);
    }

    private String m1323h() {
        StringBuilder stringBuilder = new StringBuilder();
        for (CheckedTextView isChecked : this.f1310i) {
            stringBuilder.append(isChecked.isChecked() ? "1" : "0");
        }
        return stringBuilder.toString();
    }

    private void m1324i() {
        for (CheckedTextView checked : this.f1310i) {
            checked.setChecked(true);
        }
    }

    private void m1325j() {
        for (CheckedTextView toggle : this.f1310i) {
            toggle.toggle();
        }
    }

    private void m1326k() {
        for (int i = 0; i < f1309h.length; i++) {
            this.f1310i[i].setText(String.format("%02X", new Object[]{Integer.valueOf(i)}));
        }
        this.f1311j = true;
    }

    private void m1327l() {
        for (int i = 0; i < f1309h.length; i++) {
            this.f1310i[i].setText(String.format("%d", new Object[]{Integer.valueOf(i)}));
        }
        this.f1311j = false;
    }

    private void m1328m() {
        ScrollView scrollView = (ScrollView) getActivity().findViewById(R.id.scroll_view);
        scrollView.post(new C0409s(this, scrollView));
    }

    protected void m1329a() {
        Activity activity = getActivity();
        String str = "MFC";
        String str2 = "SEC";
        String str3 = "MFC";
        this.e = new AuthKey(m1314a(activity), this.a.isChecked(), str, m1319c(activity), str2, m1323h(), str3, m1317b(activity), m1320d(activity), m1321e(activity));
    }

    public int m1330b() {
        return R.string.key_editor_mfc;
    }

    public boolean m1331c() {
        Activity activity = getActivity();
        return (TextUtils.isEmpty(m1314a(activity)) || m1321e(activity) == null) ? false : true;
    }

    public void m1332d() {
        C0196b.m180a(getActivity(), (int) R.string.toast_missing_fields);
    }

    public void onClick(View view) {
        if (view instanceof CheckedTextView) {
            ((CheckedTextView) view).toggle();
            this.b = true;
        } else if (view instanceof Button) {
            Button button = (Button) view;
            switch (view.getId()) {
                case R.id.bt_select_all:
                    m1324i();
                    break;
                case R.id.bt_invert:
                    m1325j();
                    break;
                case R.id.bt_show_hex:
                    if (!this.f1311j) {
                        m1326k();
                        button.setText(R.string.menu_show_dec);
                        break;
                    }
                    m1327l();
                    button.setText(R.string.menu_show_hex);
                    break;
            }
            m1328m();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.key_editor_mifare, viewGroup, false);
        if (inflate == null) {
            throw new RuntimeException("Cannot inflate layout!");
        }
        for (int i = 0; i < f1309h.length; i++) {
            CheckedTextView checkedTextView = (CheckedTextView) inflate.findViewById(f1309h[i]);
            this.f1310i[i] = checkedTextView;
            if (checkedTextView == null) {
                throw new RuntimeException("Checkbox missing!");
            }
            checkedTextView.setOnClickListener(this);
        }
        ((Spinner) inflate.findViewById(R.id.spinner_ic_mem_mfc)).setOnItemSelectedListener(new C0408r(this));
        ((Button) inflate.findViewById(R.id.bt_select_all)).setOnClickListener(this);
        ((Button) inflate.findViewById(R.id.bt_invert)).setOnClickListener(this);
        ((Button) inflate.findViewById(R.id.bt_show_hex)).setOnClickListener(this);
        return inflate;
    }

    public void onSaveInstanceState(Bundle bundle) {
        m1329a();
        bundle.putBoolean("TagInfo_MifareKeyEditorFragmentshow_hex", this.f1311j);
        super.onSaveInstanceState(bundle);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        Activity activity = getActivity();
        if (this.e != null) {
            int i;
            Object itemAtPosition;
            TextView textView = (TextView) activity.findViewById(R.id.edit_name_mfc);
            CharSequence a = this.e.m266a();
            if (!TextUtils.isEmpty(a)) {
                textView.setText(a);
            }
            this.a.setChecked(this.e.m268b());
            Spinner spinner = (Spinner) activity.findViewById(R.id.spinner_ic_type_mfc);
            String c = this.e.m269c();
            for (i = 0; i < spinner.getCount(); i++) {
                itemAtPosition = spinner.getItemAtPosition(i);
                if (itemAtPosition != null && itemAtPosition.toString().equals(c)) {
                    spinner.setSelection(i);
                    break;
                }
            }
            spinner = (Spinner) activity.findViewById(R.id.spinner_ic_mem_mfc);
            c = this.e.m270d();
            for (i = 0; i < spinner.getCount(); i++) {
                itemAtPosition = spinner.getItemAtPosition(i);
                if (itemAtPosition != null && itemAtPosition.toString().equals(c)) {
                    spinner.setSelection(i);
                    this.f1312k = f1308g[i];
                    break;
                }
            }
            String f = this.e.m272f();
            if (f == null || f.length() != this.f1310i.length) {
                m1324i();
            } else {
                for (int i2 = 0; i2 < this.f1310i.length; i2++) {
                    this.f1310i[i2].setChecked("1".equals(f.substring(i2, i2 + 1)));
                }
            }
            spinner = (Spinner) activity.findViewById(R.id.spinner_key_type_mfc);
            c = this.e.m275i();
            for (i = 0; i < spinner.getCount(); i++) {
                itemAtPosition = spinner.getItemAtPosition(i);
                if (itemAtPosition != null && itemAtPosition.toString().equals(c)) {
                    spinner.setSelection(i);
                    break;
                }
            }
            textView = (TextView) activity.findViewById(R.id.edit_key_value_mfc);
            byte[] j = this.e.m276j();
            if (j != null && j.length >= C0158a.f67a) {
                StringBuilder stringBuilder = new StringBuilder();
                for (i = 0; i < C0158a.f67a; i++) {
                    stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(j[i])}));
                }
                textView.setText(stringBuilder.toString());
            }
        } else if (bundle != null) {
            this.f1311j = bundle.getBoolean("TagInfo_MifareKeyEditorFragmentshow_hex");
        } else {
            this.f1311j = C0158a.m29a().m55m();
            this.a.setChecked(true);
        }
        Button button = (Button) activity.findViewById(R.id.bt_show_hex);
        if (this.f1311j) {
            m1326k();
            button.setText(R.string.menu_show_dec);
            return;
        }
        m1327l();
        button.setText(R.string.menu_show_hex);
    }
}
