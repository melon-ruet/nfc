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

public class PedometerFs500A extends NfcDynamicTag implements Parcelable, C0481a {
    public static final Creator CREATOR;
    protected static final byte[] f1488a;
    private PedometerData[] f1489b;
    private byte[] f1490c;
    private int f1491d;
    private int f1492e;
    private Calendar f1493f;

    static {
        f1488a = new byte[]{(byte) 0, (byte) 16, (byte) 0, (byte) 0, (byte) 1, (byte) 8};
        CREATOR = new C0485e();
    }

    protected PedometerFs500A(Parcel parcel) {
        super(parcel);
        this.f1491d = -1;
        this.f1492e = -1;
        this.f1489b = (PedometerData[]) parcel.createTypedArray(PedometerData.CREATOR);
        this.f1490c = parcel.createByteArray();
        this.f1491d = parcel.readInt();
        this.f1492e = parcel.readInt();
        if (parcel.readInt() != 0) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            int readInt5 = parcel.readInt();
            int readInt6 = parcel.readInt();
            this.f1493f = Calendar.getInstance();
            this.f1493f.clear();
            this.f1493f.set(readInt, readInt2, readInt3, readInt4, readInt5, readInt6);
            return;
        }
        this.f1493f = null;
    }

    protected PedometerFs500A(NfcDynamicTag nfcDynamicTag) {
        super((Type3Tag) nfcDynamicTag);
        this.f1491d = -1;
        this.f1492e = -1;
    }

    private static int m1564a(byte b) {
        return (((b & 240) / 16) * 10) + (b & 15);
    }

    private static void m1565a(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        bArr[i + 0] = m1568c(instance.get(12));
        bArr[i + 1] = m1568c(instance.get(11));
        bArr[i + 2] = m1568c(instance.get(5));
        bArr[i + 3] = m1568c(instance.get(2) + 1);
        bArr[i + 4] = m1568c(instance.get(1) % 100);
    }

    private static Calendar m1566b(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(m1564a(bArr[i + 4]) + 2000, m1564a(bArr[i + 3]) - 1, m1564a(bArr[i + 2]), m1564a(bArr[i + 1]), m1564a(bArr[i + 0]));
        return instance;
    }

    private void m1567b(byte[] bArr) {
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

    private static byte m1568c(int i) {
        return (byte) (((i / 10) * 16) + (i % 10));
    }

    private byte[] m1569i() {
        return m1480a(12);
    }

    public PedometerData[] m1570a() {
        return this.f1489b;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] m1571e() {
        return this.f1490c;
    }

    public int m1572f() {
        return this.f1491d;
    }

    public int m1573g() {
        return this.f1492e;
    }

    public PedometerData[] m1574h() {
        C0466a.m1497a("PedometerFs500A", "readStepData");
        byte[] bArr = new byte[15];
        bArr[0] = (byte) -96;
        bArr[6] = (byte) 96;
        bArr[7] = (byte) 0;
        bArr[8] = (byte) 96;
        bArr[9] = (byte) 0;
        m1565a(bArr, 10);
        m1567b(bArr);
        byte[] i = m1569i();
        if (i[15] != null) {
            throw new C0456c();
        }
        this.f1490c = new byte[5];
        this.f1490c[0] = i[4];
        this.f1490c[1] = i[3];
        this.f1490c[2] = i[2];
        this.f1490c[3] = i[1];
        this.f1490c[4] = i[0];
        this.f1491d = (m1564a(i[5]) + (m1564a(i[6]) * 100)) * 1000;
        this.f1492e = (m1564a(i[7]) + (m1564a(i[8]) * 100)) * 10;
        Calendar b = m1566b(i, 9);
        this.f1493f = (Calendar) b.clone();
        if (b.get(11) < 2) {
            b.add(5, -1);
        }
        int i2 = b.get(1);
        int i3 = b.get(2);
        int i4 = b.get(5);
        b.clear();
        b.set(i2, i3, i4);
        this.f1489b = new PedometerData[15];
        for (int i5 = 0; i5 < this.f1489b.length; i5++) {
            Calendar calendar = (Calendar) b.clone();
            this.f1489b[i5] = new PedometerData(calendar, (m1564a(i[((i5 * 11) + 16) + 0]) + (m1564a(i[((i5 * 11) + 16) + 1]) * 100)) + (m1564a(i[((i5 * 11) + 16) + 2]) * 10000), (m1564a(i[((i5 * 11) + 16) + 3]) + (m1564a(i[((i5 * 11) + 16) + 4]) * 100)) + (m1564a(i[((i5 * 11) + 16) + 5]) * 10000), ((m1564a(i[((i5 * 11) + 16) + 6]) + (m1564a(i[((i5 * 11) + 16) + 7]) * 100)) + (m1564a(i[((i5 * 11) + 16) + 8]) * 10000)) * 100, (m1564a(i[((i5 * 11) + 16) + 9]) + (m1564a(i[((i5 * 11) + 16) + 10]) * 100)) * 100);
            b.add(5, -1);
        }
        return this.f1489b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedArray(this.f1489b, i);
        parcel.writeByteArray(this.f1490c);
        parcel.writeInt(this.f1491d);
        parcel.writeInt(this.f1492e);
        if (this.f1493f != null) {
            parcel.writeInt(1);
            parcel.writeInt(this.f1493f.get(1));
            parcel.writeInt(this.f1493f.get(2));
            parcel.writeInt(this.f1493f.get(5));
            parcel.writeInt(this.f1493f.get(11));
            parcel.writeInt(this.f1493f.get(12));
            parcel.writeInt(this.f1493f.get(13));
            return;
        }
        parcel.writeInt(0);
    }
}
