package com.sony.nfc.p025b;

import android.support.v4.BuildConfig;
import android.support.v4.view.MotionEventCompat;

/* renamed from: com.sony.nfc.b.a */
public class C0466a {
    public static String m1495a(int i) {
        return (i < 0 || i >= 16) ? Integer.toHexString(i & MotionEventCompat.ACTION_MASK) : "0" + Integer.toHexString(i);
    }

    public static String m1496a(byte[] bArr) {
        String str = BuildConfig.VERSION_NAME;
        if (bArr != null) {
            for (int a : bArr) {
                str = str + C0466a.m1495a(a);
            }
        }
        return str;
    }

    public static void m1497a(String str, String str2) {
    }

    public static void m1498b(String str, String str2) {
    }
}
