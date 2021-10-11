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
import com.nxp.taginfolite.p003g.C0429j;
import java.lang.reflect.Array;

public class ah extends C0382c {
    private String m1261a(Activity activity) {
        CharSequence text = ((TextView) activity.findViewById(R.id.edit_name_ulc)).getText();
        return text == null ? null : text.toString();
    }

    private void m1262a(Activity activity, int i, byte[] bArr) {
        TextView textView = (TextView) activity.findViewById(i);
        if (bArr != null && bArr.length >= 4) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i2 = 0; i2 < 4; i2++) {
                stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i2])}));
            }
            textView.setText(stringBuilder.toString());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m1263a(byte[][] r7) {
        /*
        r6 = this;
        r0 = 0;
        r2 = 0;
        r5 = 4;
        if (r7 == 0) goto L_0x0008;
    L_0x0005:
        r1 = r7.length;
        if (r1 >= r5) goto L_0x0009;
    L_0x0008:
        return r0;
    L_0x0009:
        r1 = r2;
    L_0x000a:
        if (r1 >= r5) goto L_0x0018;
    L_0x000c:
        r3 = r7[r1];
        if (r3 == 0) goto L_0x0008;
    L_0x0010:
        r3 = r7[r1];
        r3 = r3.length;
        if (r3 < r5) goto L_0x0008;
    L_0x0015:
        r1 = r1 + 1;
        goto L_0x000a;
    L_0x0018:
        r0 = 16;
        r0 = new byte[r0];
        r1 = r2;
    L_0x001d:
        if (r1 >= r5) goto L_0x0008;
    L_0x001f:
        r3 = 7 - r1;
        r4 = r7[r2];
        r4 = r4[r1];
        r0[r3] = r4;
        r3 = 3 - r1;
        r4 = 1;
        r4 = r7[r4];
        r4 = r4[r1];
        r0[r3] = r4;
        r3 = 15 - r1;
        r4 = 2;
        r4 = r7[r4];
        r4 = r4[r1];
        r0[r3] = r4;
        r3 = 11 - r1;
        r4 = 3;
        r4 = r7[r4];
        r4 = r4[r1];
        r0[r3] = r4;
        r1 = r1 + 1;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.fragments.ah.a(byte[][]):byte[]");
    }

    private byte[][] m1264a(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            return (byte[][]) null;
        }
        byte[][] bArr2 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{4, 4});
        for (int i = 0; i < 4; i++) {
            bArr2[0][i] = bArr[7 - i];
            bArr2[1][i] = bArr[3 - i];
            bArr2[2][i] = bArr[15 - i];
            bArr2[3][i] = bArr[11 - i];
        }
        return bArr2;
    }

    private byte[] m1265b(Activity activity) {
        return m1263a(new byte[][]{m1266c(activity, R.id.edit_key_ulc0), m1266c(activity, R.id.edit_key_ulc1), m1266c(activity, R.id.edit_key_ulc2), m1266c(activity, R.id.edit_key_ulc3)});
    }

    private byte[] m1266c(Activity activity, int i) {
        CharSequence text = ((TextView) activity.findViewById(i)).getText();
        return (text == null || TextUtils.isEmpty(text)) ? null : C0429j.m1397a(text.toString(), 4);
    }

    protected void m1267a() {
        Activity activity = getActivity();
        this.e = new AuthKey(m1261a(activity), this.a.isChecked(), "ULC", BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME, m1265b(activity));
    }

    public int m1268b() {
        return R.string.key_editor_ulc;
    }

    public boolean m1269c() {
        Activity activity = getActivity();
        return (TextUtils.isEmpty(m1261a(activity)) || m1265b(activity) == null) ? false : true;
    }

    public void m1270d() {
        C0196b.m180a(getActivity(), (int) R.string.toast_missing_fields);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.key_editor_ulc, viewGroup, false);
        if (inflate != null) {
            return inflate;
        }
        throw new RuntimeException("Cannot inflate layout!");
    }

    public void onSaveInstanceState(Bundle bundle) {
        m1267a();
        super.onSaveInstanceState(bundle);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        Activity activity = getActivity();
        if (this.e != null) {
            TextView textView = (TextView) activity.findViewById(R.id.edit_name_ulc);
            CharSequence a = this.e.m266a();
            if (!TextUtils.isEmpty(a)) {
                textView.setText(a);
            }
            this.a.setChecked(this.e.m268b());
            byte[][] a2 = m1264a(this.e.m276j());
            if (a2 != null) {
                m1262a(activity, R.id.edit_key_ulc0, a2[0]);
                m1262a(activity, R.id.edit_key_ulc1, a2[1]);
                m1262a(activity, R.id.edit_key_ulc2, a2[2]);
                m1262a(activity, R.id.edit_key_ulc3, a2[3]);
                return;
            }
            return;
        }
        this.a.setChecked(true);
    }
}
