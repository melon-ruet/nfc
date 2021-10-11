package com.nxp.taginfolite.p004f.p017c;

import com.nxp.taginfolite.p004f.p017c.p018a.C0342a;
import com.nxp.taginfolite.p004f.p017c.p018a.C0343b;
import com.nxp.taginfolite.p004f.p017c.p018a.C0344c;

/* renamed from: com.nxp.taginfolite.f.c.b */
public class C0346b {
    public static String m1012a(int i) {
        if (i == -1) {
            return "[No response]";
        }
        String a = C0343b.m983a(i);
        if (a == null) {
            a = C0344c.m984a(i);
        }
        if (a == null) {
            a = C0342a.m982a(i);
        }
        if (a == null) {
            a = "[Unknown status]";
        }
        return String.format("SW=%04X: ", new Object[]{Integer.valueOf(i)}) + a;
    }

    public static String m1013a(byte[] bArr) {
        if (bArr == null) {
            return "[No response]";
        }
        int length = bArr.length;
        if (length >= 2) {
            return C0346b.m1012a(C0345a.m988e(bArr));
        }
        if (length == 0) {
            return "[No response]";
        }
        return String.format("0x%02X (not ISO/IEC 7816-4 compliant)", new Object[]{Byte.valueOf(bArr[0])});
    }
}
