package com.nxp.taginfolite.ndef.p023a;

import android.support.v4.view.MotionEventCompat;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0358k;

/* renamed from: com.nxp.taginfolite.ndef.a.r */
public class C0447r {
    public static void m1447a(byte[] bArr, String str, StringBuilder stringBuilder) {
        int a = C0429j.m1388a(bArr[0], bArr[1]);
        int i = 2;
        for (int i2 = 0; i2 < a; i2++) {
            int i3 = i + 1;
            i = bArr[i] & MotionEventCompat.ACTION_MASK;
            String a2 = C0429j.m1391a(new String(bArr, i3, i, C0429j.f1361b));
            i += i3;
            i3 = i + 1;
            i = bArr[i] & MotionEventCompat.ACTION_MASK;
            String a3 = C0429j.m1391a(new String(bArr, i3, i, C0429j.f1361b));
            i += i3;
            if (i2 > 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(str).append(String.format("App #%d:\n" + C0358k.f1076c + "Platform: %s\n" + C0358k.f1076c + "ID: %s", new Object[]{Integer.valueOf(i2 + 1), a2, a3}));
        }
        stringBuilder.append("\n").append(str).append("Argument list:\n" + C0358k.f1076c + "\"").append(new String(bArr, i + 2, C0429j.m1388a(bArr[i], bArr[i + 1]), C0429j.f1361b)).append("\"");
    }
}
