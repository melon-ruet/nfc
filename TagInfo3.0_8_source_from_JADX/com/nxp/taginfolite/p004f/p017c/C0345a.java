package com.nxp.taginfolite.p004f.p017c;

import android.nfc.TagLostException;
import android.nfc.tech.IsoDep;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.nxp.taginfolite.p003g.C0429j;
import java.io.IOException;

/* renamed from: com.nxp.taginfolite.f.c.a */
public class C0345a {
    private final IsoDep f1049a;
    private byte f1050b;
    private byte[] f1051c;

    public C0345a(IsoDep isoDep) {
        this.f1050b = (byte) 0;
        this.f1051c = null;
        this.f1049a = isoDep;
    }

    private static byte[] m985b(byte[] bArr, byte[] bArr2, int i) {
        Object obj;
        if (bArr2 == null) {
            obj = new byte[0];
        }
        int length = obj.length;
        int length2 = bArr.length + obj.length;
        if (length > 0) {
            length2++;
        }
        if (i >= 0) {
            length2++;
        }
        Object obj2 = new byte[length2];
        System.arraycopy(bArr, 0, obj2, 0, bArr.length);
        if (length > 0) {
            obj2[bArr.length] = (byte) length;
            System.arraycopy(obj, 0, obj2, bArr.length + 1, obj.length);
        }
        if (i >= 0) {
            obj2[length2 - 1] = (byte) i;
        }
        return obj2;
    }

    public static boolean m986c(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        int length = bArr.length;
        return length >= 2 && bArr[length - 2] == -112 && bArr[length - 1] == null;
    }

    public static boolean m987d(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        int length = bArr.length;
        return length >= 2 && bArr[length - 2] == 98 && bArr[length - 1] == -125;
    }

    public static int m988e(byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        int length = bArr.length;
        return length >= 2 ? C0429j.m1388a(bArr[length - 2], bArr[length - 1]) : -1;
    }

    public byte[] m989a() {
        return m991a(0, 0);
    }

    public byte[] m990a(int i) {
        return m991a(0, i);
    }

    public byte[] m991a(int i, int i2) {
        return m996a(new byte[]{this.f1050b, (byte) -80, (byte) (i >> 8), (byte) (i & MotionEventCompat.ACTION_MASK), (byte) i2});
    }

    public byte[] m992a(int i, int i2, int i3) {
        return m996a(new byte[]{this.f1050b, (byte) -80, (byte) ((i & 31) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS), (byte) i2, (byte) i3});
    }

    public byte[] m993a(int i, int i2, int i3, int i4) {
        return m996a(new byte[]{this.f1050b, (byte) -78, (byte) i, (byte) ((i2 << 3) | (i3 & 7)), (byte) i4});
    }

    public byte[] m994a(int i, int i2, byte[] bArr, int i3) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        return m996a(C0345a.m985b(new byte[]{this.f1050b, (byte) -92, (byte) i, (byte) i2}, bArr, i3));
    }

    public byte[] m995a(int i, byte[] bArr, int i2) {
        return m994a(4, i, bArr, i2);
    }

    public byte[] m996a(byte[] bArr) {
        try {
            this.f1051c = this.f1049a.transceive(bArr);
        } catch (TagLostException e) {
            throw e;
        } catch (IOException e2) {
            this.f1051c = null;
        }
        return this.f1051c;
    }

    public byte[] m997a(byte[] bArr, int i) {
        return m994a(4, 0, bArr, i);
    }

    public byte[] m998a(byte[] bArr, int i, int i2) {
        return m994a(0, i, bArr, i2);
    }

    public byte[] m999a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length != 2) {
            bArr = new byte[]{(byte) 0, (byte) 0};
        }
        return m996a(C0345a.m985b(new byte[]{this.f1050b, (byte) -53, bArr[0], bArr[1]}, bArr2, 0));
    }

    public byte[] m1000a(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return m996a(C0345a.m985b(new byte[]{this.f1050b, (byte) -79, bArr[0], bArr[1]}, bArr2, i));
    }

    public byte[] m1001b() {
        return m1008c(0, 0, 0);
    }

    public byte[] m1002b(int i) {
        return m992a(i, 0, 0);
    }

    public byte[] m1003b(int i, int i2) {
        return m996a(new byte[]{Byte.MIN_VALUE, (byte) -54, (byte) i, (byte) i2, (byte) 0});
    }

    public byte[] m1004b(int i, int i2, int i3) {
        return m993a(i, i2, 4, i3);
    }

    public byte[] m1005b(byte[] bArr) {
        return m994a(4, 0, bArr, 0);
    }

    public byte[] m1006b(byte[] bArr, int i) {
        return m994a(0, 0, bArr, i);
    }

    public boolean m1007c() {
        return C0345a.m986c(this.f1051c);
    }

    public byte[] m1008c(int i, int i2, int i3) {
        return m996a(new byte[]{this.f1050b, (byte) -54, (byte) i, (byte) i2, (byte) i3});
    }

    public boolean m1009d() {
        return C0345a.m987d(this.f1051c);
    }

    public int m1010e() {
        return C0345a.m988e(this.f1051c);
    }

    public byte[] m1011f() {
        return this.f1051c;
    }
}
