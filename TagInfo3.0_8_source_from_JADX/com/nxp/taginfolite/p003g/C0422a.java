package com.nxp.taginfolite.p003g;

import android.support.v4.view.MotionEventCompat;
import java.util.Arrays;

/* renamed from: com.nxp.taginfolite.g.a */
public final class C0422a {
    static final char[] f1344a;
    private final byte[] f1345b;

    static {
        f1344a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public C0422a(byte[] bArr) {
        if (bArr == null) {
            this.f1345b = null;
        } else {
            this.f1345b = bArr;
        }
    }

    public C0422a(int... iArr) {
        if (iArr == null) {
            this.f1345b = null;
            return;
        }
        this.f1345b = new byte[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            this.f1345b[i] = (byte) (iArr[i] & MotionEventCompat.ACTION_MASK);
        }
    }

    public static String m1358a(byte[] bArr) {
        int i = 0;
        int length = bArr.length;
        char[] cArr = new char[(length << 1)];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr[i] = f1344a[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr[i3] = f1344a[bArr[i2] & 15];
        }
        return new String(cArr);
    }

    public static void m1359a(byte[] bArr, byte[]... bArr2) {
        int i = 0;
        for (Object obj : bArr2) {
            int length = obj.length;
            System.arraycopy(obj, 0, bArr, i, length);
            i += length;
        }
    }

    public static byte[] m1360a(String str) {
        String str2 = "0123456789ABCDEF";
        byte[] bArr = new byte[(str.length() / 2)];
        int length = str.length();
        for (int i = 0; i < length; i += 2) {
            int indexOf = "0123456789ABCDEF".indexOf(str.charAt(i));
            bArr[i / 2] = (byte) ((indexOf << 4) | "0123456789ABCDEF".indexOf(str.charAt(i + 1)));
        }
        return bArr;
    }

    public static byte[] m1361a(int[] iArr) {
        int length = iArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (iArr[i] & MotionEventCompat.ACTION_MASK);
        }
        return bArr;
    }

    public byte[] m1362a() {
        return this.f1345b == null ? null : Arrays.copyOf(this.f1345b, this.f1345b.length);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0422a) && Arrays.equals(this.f1345b, ((C0422a) obj).f1345b);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f1345b);
    }
}
