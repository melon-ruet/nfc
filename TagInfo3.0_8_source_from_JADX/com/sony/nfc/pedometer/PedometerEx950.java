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

public class PedometerEx950 extends NfcDynamicTag implements Parcelable, C0481a {
    public static final Creator CREATOR;
    protected static final byte[] f1482a;
    private PedometerData[] f1483b;
    private byte[] f1484c;
    private int f1485d;
    private int f1486e;
    private Calendar f1487f;

    static {
        f1482a = new byte[]{(byte) 0, (byte) 21, (byte) 0, (byte) 0, (byte) 1, (byte) 18};
        CREATOR = new C0483c();
    }

    protected PedometerEx950(Parcel parcel) {
        super(parcel);
        this.f1485d = -1;
        this.f1486e = -1;
        this.f1483b = (PedometerData[]) parcel.createTypedArray(PedometerData.CREATOR);
        this.f1484c = parcel.createByteArray();
        this.f1485d = parcel.readInt();
        this.f1486e = parcel.readInt();
        if (parcel.readInt() != 0) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            int readInt5 = parcel.readInt();
            int readInt6 = parcel.readInt();
            this.f1487f = Calendar.getInstance();
            this.f1487f.clear();
            this.f1487f.set(readInt, readInt2, readInt3, readInt4, readInt5, readInt6);
            return;
        }
        this.f1487f = null;
    }

    protected PedometerEx950(NfcDynamicTag nfcDynamicTag) {
        super((Type3Tag) nfcDynamicTag);
        this.f1485d = -1;
        this.f1486e = -1;
    }

    private static int m1553a(byte b) {
        return (((b & 240) / 16) * 10) + (b & 15);
    }

    private static void m1554a(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        bArr[i + 0] = m1557c(instance.get(12));
        bArr[i + 1] = m1557c(instance.get(11));
        bArr[i + 2] = m1557c(instance.get(5));
        bArr[i + 3] = m1557c(instance.get(2) + 1);
        bArr[i + 4] = m1557c(instance.get(1) % 100);
    }

    private static Calendar m1555b(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(m1553a(bArr[i + 4]) + 2000, m1553a(bArr[i + 3]) - 1, m1553a(bArr[i + 2]), m1553a(bArr[i + 1]), m1553a(bArr[i + 0]));
        return instance;
    }

    private void m1556b(byte[] bArr) {
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

    private static byte m1557c(int i) {
        return (byte) (((i / 10) * 16) + (i % 10));
    }

    private byte[] m1558i() {
        return m1480a(12);
    }

    public PedometerData[] m1559a() {
        return this.f1483b;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] m1560e() {
        return this.f1484c;
    }

    public int m1561f() {
        return this.f1485d;
    }

    public int m1562g() {
        return this.f1486e;
    }

    public PedometerData[] m1563h() {
        C0466a.m1497a("PedometerEx950", "readStepData");
        byte[] bArr = new byte[15];
        bArr[0] = (byte) -96;
        bArr[6] = (byte) 96;
        bArr[7] = (byte) 0;
        bArr[8] = (byte) 96;
        bArr[9] = (byte) 0;
        m1554a(bArr, 10);
        C0466a.m1497a("PedometerEx950", "command:" + C0466a.m1496a(bArr));
        m1556b(bArr);
        byte[] i = m1558i();
        C0466a.m1497a("PedometerEx950", "response:" + C0466a.m1496a(i));
        if (i[15] != null) {
            throw new C0456c();
        }
        this.f1484c = new byte[5];
        this.f1484c[0] = i[4];
        this.f1484c[1] = i[3];
        this.f1484c[2] = i[2];
        this.f1484c[3] = i[1];
        this.f1484c[4] = i[0];
        this.f1485d = (m1553a(i[5]) + (m1553a(i[6]) * 100)) * 1000;
        this.f1486e = (m1553a(i[7]) + (m1553a(i[8]) * 100)) * 10;
        Calendar b = m1555b(i, 9);
        this.f1487f = (Calendar) b.clone();
        if (b.get(11) < 2) {
            b.add(5, -1);
        }
        int i2 = b.get(1);
        int i3 = b.get(2);
        int i4 = b.get(5);
        b.clear();
        b.set(i2, i3, i4);
        this.f1483b = new PedometerData[15];
        for (int i5 = 0; i5 < this.f1483b.length; i5++) {
            Calendar calendar = (Calendar) b.clone();
            this.f1483b[i5] = new PedometerData(calendar, (m1553a(i[((i5 * 11) + 16) + 0]) + (m1553a(i[((i5 * 11) + 16) + 1]) * 100)) + (m1553a(i[((i5 * 11) + 16) + 2]) * 10000), (m1553a(i[((i5 * 11) + 16) + 3]) + (m1553a(i[((i5 * 11) + 16) + 4]) * 100)) + (m1553a(i[((i5 * 11) + 16) + 5]) * 10000), ((m1553a(i[((i5 * 11) + 16) + 6]) + (m1553a(i[((i5 * 11) + 16) + 7]) * 100)) + (m1553a(i[((i5 * 11) + 16) + 8]) * 10000)) * 100, (m1553a(i[((i5 * 11) + 16) + 9]) + (m1553a(i[((i5 * 11) + 16) + 10]) * 100)) * 100);
            b.add(5, -1);
        }
        return this.f1483b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedArray(this.f1483b, i);
        parcel.writeByteArray(this.f1484c);
        parcel.writeInt(this.f1485d);
        parcel.writeInt(this.f1486e);
        if (this.f1487f != null) {
            parcel.writeInt(1);
            parcel.writeInt(this.f1487f.get(1));
            parcel.writeInt(this.f1487f.get(2));
            parcel.writeInt(this.f1487f.get(5));
            parcel.writeInt(this.f1487f.get(11));
            parcel.writeInt(this.f1487f.get(12));
            parcel.writeInt(this.f1487f.get(13));
            return;
        }
        parcel.writeInt(0);
    }
}
