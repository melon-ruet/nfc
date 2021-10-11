package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.Type3Tag;
import com.sony.nfc.p024a.C0456c;
import com.sony.nfc.p025b.C0466a;
import java.util.Calendar;

public class PedometerFs750 extends NfcDynamicTag implements Parcelable, C0481a {
    public static final Creator CREATOR;
    protected static final byte[] f1509a;
    private PedometerFs750Data[] f1510b;
    private byte[] f1511c;
    private int f1512d;
    private int f1513e;
    private int f1514f;
    private int f1515g;
    private Calendar f1516h;

    static {
        f1509a = new byte[]{(byte) 0, (byte) 16, (byte) 1, (byte) 0, (byte) 1, (byte) 52};
        CREATOR = new C0490j();
    }

    protected PedometerFs750(Parcel parcel) {
        super(parcel);
        this.f1512d = -1;
        this.f1513e = -1;
        this.f1514f = -1;
        this.f1515g = -1;
        this.f1510b = (PedometerFs750Data[]) parcel.createTypedArray(PedometerFs750Data.CREATOR);
        this.f1511c = parcel.createByteArray();
        this.f1512d = parcel.readInt();
        this.f1513e = parcel.readInt();
        this.f1514f = parcel.readInt();
        this.f1515g = parcel.readInt();
        if (parcel.readInt() != 0) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            int readInt5 = parcel.readInt();
            int readInt6 = parcel.readInt();
            this.f1516h = Calendar.getInstance();
            this.f1516h.clear();
            this.f1516h.set(readInt, readInt2, readInt3, readInt4, readInt5, readInt6);
            return;
        }
        this.f1516h = null;
    }

    protected PedometerFs750(NfcDynamicTag nfcDynamicTag) {
        super((Type3Tag) nfcDynamicTag);
        this.f1512d = -1;
        this.f1513e = -1;
        this.f1514f = -1;
        this.f1515g = -1;
    }

    private static int m1599a(byte b) {
        return (((b & 240) / 16) * 10) + (b & 15);
    }

    private static void m1600a(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        bArr[i + 0] = m1603c(instance.get(12));
        bArr[i + 1] = m1603c(instance.get(11));
        bArr[i + 2] = m1603c(instance.get(5));
        bArr[i + 3] = m1603c(instance.get(2) + 1);
        bArr[i + 4] = m1603c(instance.get(1) % 100);
    }

    private static Calendar m1601b(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(m1599a(bArr[i + 4]) + 2000, m1599a(bArr[i + 3]) - 1, m1599a(bArr[i + 2]), m1599a(bArr[i + 1]), m1599a(bArr[i + 0]));
        return instance;
    }

    private void m1602b(byte[] bArr) {
        int i = 0;
        Object obj = new byte[(((bArr.length + 16) / 16) * 16)];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        byte b = (byte) 0;
        while (i < obj.length - 1) {
            b = (byte) (b + (bArr[i] & MotionEventCompat.ACTION_MASK));
            i++;
        }
        obj[obj.length - 1] = b;
        m1478a((byte[]) obj);
    }

    private static byte m1603c(int i) {
        return (byte) (((i / 10) * 16) + (i % 10));
    }

    private static boolean m1604c(byte[] bArr) {
        byte b = (byte) 0;
        for (int i = 0; i < bArr.length - 1; i++) {
            b = (byte) (b + bArr[i]);
        }
        return b == bArr[bArr.length + -1];
    }

    private byte[] m1605f() {
        return m1480a(12);
    }

    public PedometerData[] m1606a() {
        return this.f1510b;
    }

    public int describeContents() {
        return 0;
    }

    public PedometerData[] m1607e() {
        C0466a.m1497a("PedometerFs750", "readStepData");
        byte[] bArr = new byte[15];
        bArr[0] = (byte) -96;
        bArr[3] = (byte) 1;
        bArr[4] = (byte) 48;
        bArr[5] = (byte) 0;
        bArr[6] = (byte) 96;
        bArr[7] = (byte) 0;
        bArr[8] = (byte) 112;
        bArr[9] = (byte) 1;
        m1600a(bArr, 10);
        m1602b(bArr);
        byte[] f = m1605f();
        if (f[15] != null) {
            throw new C0456c();
        } else if (m1604c(f)) {
            this.f1511c = new byte[5];
            this.f1511c[0] = f[4];
            this.f1511c[1] = f[3];
            this.f1511c[2] = f[2];
            this.f1511c[3] = f[1];
            this.f1511c[4] = f[0];
            this.f1512d = (m1599a(f[5]) + (m1599a(f[6]) * 100)) * 100;
            this.f1513e = (m1599a(f[7]) + (m1599a(f[8]) * 100)) * 10;
            Calendar b = m1601b(f, 9);
            this.f1516h = (Calendar) b.clone();
            this.f1510b = new PedometerFs750Data[15];
            for (int i = 0; i < this.f1510b.length; i++) {
                Calendar calendar = (Calendar) b.clone();
                this.f1510b[i] = new PedometerFs750Data(calendar, (m1599a(f[((i * 11) + 16) + 0]) + (m1599a(f[((i * 11) + 16) + 1]) * 100)) + (m1599a(f[((i * 11) + 16) + 2]) * 10000), (m1599a(f[((i * 11) + 16) + 3]) + (m1599a(f[((i * 11) + 16) + 4]) * 100)) + (m1599a(f[((i * 11) + 16) + 5]) * 10000), ((m1599a(f[((i * 11) + 16) + 6]) + (m1599a(f[((i * 11) + 16) + 7]) * 100)) + (m1599a(f[((i * 11) + 16) + 8]) * 10000)) * 100, (m1599a(f[((i * 11) + 16) + 9]) + (m1599a(f[((i * 11) + 16) + 10]) * 100)) * 100, -1, -1, -1);
                b.add(5, -1);
            }
            return this.f1510b;
        } else {
            throw new C0456c();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedArray(this.f1510b, i);
        parcel.writeByteArray(this.f1511c);
        parcel.writeInt(this.f1512d);
        parcel.writeInt(this.f1513e);
        parcel.writeInt(this.f1514f);
        parcel.writeInt(this.f1515g);
        if (this.f1516h != null) {
            parcel.writeInt(1);
            parcel.writeInt(this.f1516h.get(1));
            parcel.writeInt(this.f1516h.get(2));
            parcel.writeInt(this.f1516h.get(5));
            parcel.writeInt(this.f1516h.get(11));
            parcel.writeInt(this.f1516h.get(12));
            parcel.writeInt(this.f1516h.get(13));
            return;
        }
        parcel.writeInt(0);
    }
}
