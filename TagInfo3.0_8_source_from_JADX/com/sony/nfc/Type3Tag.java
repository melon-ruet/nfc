package com.sony.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import com.sony.nfc.p024a.C0454a;
import com.sony.nfc.p024a.C0457d;
import com.sony.nfc.p024a.C0458e;
import com.sony.nfc.p024a.C0460g;
import com.sony.nfc.p024a.C0462i;
import com.sony.nfc.p025b.C0466a;

public class Type3Tag extends NfcTag implements Parcelable {
    public static final Creator CREATOR;
    private byte[] f1440a;
    private byte[] f1441b;

    static {
        CREATOR = new C0480j();
    }

    protected Type3Tag(Parcel parcel) {
        super(parcel);
        this.f1440a = parcel.createByteArray();
        this.f1441b = parcel.createByteArray();
    }

    protected Type3Tag(NfcTag nfcTag, byte[] bArr, byte[] bArr2) {
        super(nfcTag);
        this.f1440a = bArr;
        this.f1441b = bArr2;
    }

    protected Type3Tag(Type3Tag type3Tag) {
        this(type3Tag, type3Tag.f1440a, type3Tag.f1441b);
    }

    protected static boolean m1468a(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < 8; i++) {
            if (bArr[i + 2] != bArr2[i + 2]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] m1469a(int[] iArr) {
        Object obj = new byte[(iArr.length * 3)];
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            if (iArr[i] < 0 || iArr[i] > 65535) {
                throw new C0457d();
            }
            int i3;
            if (iArr[i] < 256) {
                i3 = i2 + 1;
                obj[i2] = Byte.MIN_VALUE;
                i2 = i3 + 1;
                obj[i3] = (byte) iArr[i];
            } else {
                i3 = i2 + 1;
                obj[i2] = null;
                int i4 = i3 + 1;
                obj[i3] = (byte) (iArr[i] >> 0);
                i2 = i4 + 1;
                obj[i4] = (byte) (iArr[i] >> 8);
            }
            i++;
        }
        Object obj2 = new byte[i2];
        System.arraycopy(obj, 0, obj2, 0, i2);
        return obj2;
    }

    public Type3Tag m1470a(int i, int i2, int i3) {
        C0466a.m1497a("Type3Tag", "select");
        C0464i a_ = a_();
        if (a_ != null) {
            return a_.m1483a(i, i2, i3);
        }
        throw new C0460g();
    }

    public void m1471a(int i, int[] iArr, byte[] bArr) {
        m1472a(new int[]{i}, iArr.length, m1469a(iArr), bArr);
    }

    public void m1472a(int[] iArr, int i, byte[] bArr, byte[] bArr2) {
        C0466a.m1497a("Type3Tag", "update");
        C0464i a_ = a_();
        if (a_ == null) {
            throw new C0460g();
        } else if (iArr.length < 1 || iArr.length > 16 || i < 1 || i > 13 || ((((iArr.length * 2) + 11) + 1) + bArr.length) + (i * 16) > MotionEventCompat.ACTION_MASK || bArr2.length != i * 16) {
            throw new C0457d();
        } else {
            int i2;
            byte[] bArr3 = new byte[(((((iArr.length * 2) + 11) + 1) + bArr.length) + bArr2.length)];
            bArr3[0] = (byte) bArr3.length;
            bArr3[1] = (byte) 8;
            System.arraycopy(m1467d(), 0, bArr3, 2, 8);
            bArr3[10] = (byte) iArr.length;
            int i3 = 11;
            for (i2 = 0; i2 < iArr.length; i2++) {
                int i4 = i3 + 1;
                bArr3[i3] = (byte) ((iArr[i2] >> 0) & MotionEventCompat.ACTION_MASK);
                i3 = i4 + 1;
                bArr3[i4] = (byte) ((iArr[i2] >> 8) & MotionEventCompat.ACTION_MASK);
            }
            i2 = i3 + 1;
            bArr3[i3] = (byte) i;
            System.arraycopy(bArr, 0, bArr3, i2, bArr.length);
            i2 += bArr.length;
            System.arraycopy(bArr2, 0, bArr3, i2, bArr2.length);
            i2 += bArr2.length;
            byte[] a = a_.m1486a(bArr3);
            if (a.length != 12 || (a[0] & MotionEventCompat.ACTION_MASK) != a.length || (a[1] & MotionEventCompat.ACTION_MASK) != 9 || !m1468a(bArr3, a)) {
                throw new C0458e();
            } else if ((a[10] & MotionEventCompat.ACTION_MASK) != 0) {
                throw new C0462i();
            }
        }
    }

    public byte[] m1473a(int i, int[] iArr) {
        return m1474a(new int[]{i}, iArr.length, m1469a(iArr));
    }

    public byte[] m1474a(int[] iArr, int i, byte[] bArr) {
        C0466a.m1497a("Type3Tag", "check");
        C0464i a_ = a_();
        if (a_ == null) {
            throw new C0460g();
        } else if (iArr.length < 1 || iArr.length > 16 || i < 1 || i > 15 || (((iArr.length * 2) + 11) + 1) + bArr.length > MotionEventCompat.ACTION_MASK) {
            throw new C0457d();
        } else {
            int i2;
            byte[] bArr2 = new byte[((((iArr.length * 2) + 11) + 1) + bArr.length)];
            bArr2[0] = (byte) bArr2.length;
            bArr2[1] = (byte) 6;
            System.arraycopy(m1467d(), 0, bArr2, 2, 8);
            bArr2[10] = (byte) iArr.length;
            int i3 = 11;
            for (i2 = 0; i2 < iArr.length; i2++) {
                int i4 = i3 + 1;
                bArr2[i3] = (byte) ((iArr[i2] >> 0) & MotionEventCompat.ACTION_MASK);
                i3 = i4 + 1;
                bArr2[i4] = (byte) ((iArr[i2] >> 8) & MotionEventCompat.ACTION_MASK);
            }
            i2 = i3 + 1;
            bArr2[i3] = (byte) i;
            System.arraycopy(bArr, 0, bArr2, i2, bArr.length);
            i2 += bArr.length;
            byte[] a = a_.m1486a(bArr2);
            if (a.length < 12 || (a[0] & MotionEventCompat.ACTION_MASK) != a.length || (a[1] & MotionEventCompat.ACTION_MASK) != 7 || !m1468a(bArr2, a)) {
                throw new C0458e();
            } else if ((a[10] & MotionEventCompat.ACTION_MASK) != 0) {
                throw new C0462i();
            } else if (a.length == (i * 16) + 13 && (a[12] & MotionEventCompat.ACTION_MASK) == i) {
                Object obj = new byte[(i * 16)];
                System.arraycopy(a, 13, obj, 0, obj.length);
                return obj;
            } else {
                throw new C0458e();
            }
        }
    }

    public Type3Tag m1475b(int i) {
        return m1470a(i, 0, 0);
    }

    public void m1476c() {
        C0466a.m1497a("Type3Tag", "disconnect");
        C0464i a_ = a_();
        if (a_ != null) {
            try {
                a_.m1487b();
            } catch (C0454a e) {
            }
        }
        super.m1466c();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByteArray(this.f1440a);
        parcel.writeByteArray(this.f1441b);
    }
}
