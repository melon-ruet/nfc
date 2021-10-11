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

public class PedometerJp700 extends NfcDynamicTag implements Parcelable, C0481a {
    public static final Creator CREATOR;
    protected static final byte[] f1520a;
    protected static final byte[] f1521b;
    protected static final byte[] f1522c;
    private PedometerData[] f1523d;
    private byte[] f1524e;
    private int f1525f;
    private int f1526g;
    private Calendar f1527h;

    static {
        f1520a = new byte[]{(byte) 0, (byte) 49, (byte) 0, (byte) 0, (byte) 1, (byte) 32};
        f1521b = new byte[]{(byte) 0, (byte) 49, (byte) 0, (byte) 0, (byte) 1, (byte) 33};
        f1522c = new byte[]{(byte) 0, (byte) 49, (byte) 0, (byte) 1, (byte) 1, (byte) 34};
        CREATOR = new C0493m();
    }

    protected PedometerJp700(Parcel parcel) {
        super(parcel);
        this.f1525f = -1;
        this.f1526g = -1;
        this.f1523d = (PedometerData[]) parcel.createTypedArray(PedometerData.CREATOR);
        this.f1524e = parcel.createByteArray();
        this.f1525f = parcel.readInt();
        this.f1526g = parcel.readInt();
        if (parcel.readInt() != 0) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            int readInt5 = parcel.readInt();
            int readInt6 = parcel.readInt();
            this.f1527h = Calendar.getInstance();
            this.f1527h.clear();
            this.f1527h.set(readInt, readInt2, readInt3, readInt4, readInt5, readInt6);
            return;
        }
        this.f1527h = null;
    }

    protected PedometerJp700(NfcDynamicTag nfcDynamicTag) {
        super((Type3Tag) nfcDynamicTag);
        this.f1525f = -1;
        this.f1526g = -1;
    }

    private static int m1608a(byte b) {
        return (((b & 240) / 16) * 10) + (b & 15);
    }

    private static void m1609a(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        bArr[i + 0] = m1611c(instance.get(12));
        bArr[i + 1] = m1611c(instance.get(11));
        bArr[i + 2] = m1611c(instance.get(5));
        bArr[i + 3] = m1611c(instance.get(2) + 1);
        bArr[i + 4] = m1611c(instance.get(1) % 100);
    }

    private static Calendar m1610b(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(m1608a(bArr[i + 4]) + 2000, m1608a(bArr[i + 3]) - 1, m1608a(bArr[i + 2]), m1608a(bArr[i + 1]), m1608a(bArr[i + 0]));
        return instance;
    }

    private static byte m1611c(int i) {
        return (byte) (((i / 10) * 16) + (i % 10));
    }

    private void m1612c(byte[] bArr) {
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

    private byte[] m1613g() {
        return m1480a(12);
    }

    public PedometerData[] m1614a() {
        return this.f1523d;
    }

    protected boolean m1615b(byte[] bArr) {
        byte[] d = m1467d();
        for (int i = 0; i < bArr.length; i++) {
            if (d[i + 2] != bArr[i]) {
                return false;
            }
        }
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public int m1616e() {
        return m1615b(f1520a) ? 0 : m1615b(f1521b) ? 1 : m1615b(f1522c) ? 2 : -1;
    }

    public PedometerData[] m1617f() {
        C0466a.m1497a("PedometerJp700", "readStepData");
        byte[] bArr = new byte[15];
        bArr[0] = (byte) -96;
        bArr[6] = (byte) 96;
        bArr[7] = (byte) 0;
        bArr[8] = (byte) 0;
        bArr[9] = (byte) 1;
        m1609a(bArr, 10);
        m1612c(bArr);
        byte[] g = m1613g();
        if (g[15] != null) {
            throw new C0456c();
        }
        this.f1524e = new byte[5];
        this.f1524e[0] = g[4];
        this.f1524e[1] = g[3];
        this.f1524e[2] = g[2];
        this.f1524e[3] = g[1];
        this.f1524e[4] = g[0];
        this.f1525f = (m1608a(g[5]) + (m1608a(g[6]) * 100)) * 1000;
        this.f1526g = (m1608a(g[7]) + (m1608a(g[8]) * 100)) * 10;
        Calendar b = m1610b(g, 9);
        this.f1527h = (Calendar) b.clone();
        int i = b.get(1);
        int i2 = b.get(2);
        int i3 = b.get(5);
        b.clear();
        b.set(i, i2, i3);
        this.f1523d = new PedometerData[15];
        for (int i4 = 0; i4 < this.f1523d.length; i4++) {
            Calendar calendar = (Calendar) b.clone();
            this.f1523d[i4] = new PedometerData(calendar, (m1608a(g[((i4 * 11) + 16) + 0]) + (m1608a(g[((i4 * 11) + 16) + 1]) * 100)) + (m1608a(g[((i4 * 11) + 16) + 2]) * 10000), (m1608a(g[((i4 * 11) + 16) + 3]) + (m1608a(g[((i4 * 11) + 16) + 4]) * 100)) + (m1608a(g[((i4 * 11) + 16) + 5]) * 10000), ((m1608a(g[((i4 * 11) + 16) + 6]) + (m1608a(g[((i4 * 11) + 16) + 7]) * 100)) + (m1608a(g[((i4 * 11) + 16) + 8]) * 10000)) * 100, (m1608a(g[((i4 * 11) + 16) + 9]) + (m1608a(g[((i4 * 11) + 16) + 10]) * 100)) * 100);
            b.add(5, -1);
        }
        return this.f1523d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedArray(this.f1523d, i);
        parcel.writeByteArray(this.f1524e);
        parcel.writeInt(this.f1525f);
        parcel.writeInt(this.f1526g);
        if (this.f1527h != null) {
            parcel.writeInt(1);
            parcel.writeInt(this.f1527h.get(1));
            parcel.writeInt(this.f1527h.get(2));
            parcel.writeInt(this.f1527h.get(5));
            parcel.writeInt(this.f1527h.get(11));
            parcel.writeInt(this.f1527h.get(12));
            parcel.writeInt(this.f1527h.get(13));
            return;
        }
        parcel.writeInt(0);
    }
}
