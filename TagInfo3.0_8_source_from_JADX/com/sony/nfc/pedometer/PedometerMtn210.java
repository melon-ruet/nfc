package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.Type3Tag;
import com.sony.nfc.p024a.C0456c;
import com.sony.nfc.p024a.C0457d;
import com.sony.nfc.p025b.C0466a;
import java.util.Calendar;

public class PedometerMtn210 extends NfcDynamicTag implements Parcelable, C0481a {
    public static final Creator CREATOR;
    protected static final byte[] f1557a;
    private PedometerMtn210Data[] f1558b;
    private String f1559c;
    private Calendar f1560d;
    private int f1561e;
    private int f1562f;
    private int f1563g;
    private int f1564h;
    private int f1565i;
    private int f1566j;
    private int f1567k;
    private int f1568l;
    private int f1569m;

    static {
        f1557a = new byte[]{(byte) 0, (byte) 16, (byte) 1, (byte) 0, (byte) 3, (byte) 1};
        CREATOR = new C0501u();
    }

    protected PedometerMtn210(Parcel parcel) {
        super(parcel);
        this.f1559c = null;
        this.f1560d = null;
        this.f1561e = -1;
        this.f1562f = -1;
        this.f1563g = -1;
        this.f1564h = -1;
        this.f1565i = -1;
        this.f1566j = -1;
        this.f1567k = -1;
        this.f1568l = -1;
        this.f1569m = -1;
        this.f1558b = (PedometerMtn210Data[]) parcel.createTypedArray(PedometerMtn210Data.CREATOR);
        this.f1559c = parcel.readString();
        if (parcel.readInt() != 0) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            int readInt5 = parcel.readInt();
            int readInt6 = parcel.readInt();
            this.f1560d = Calendar.getInstance();
            this.f1560d.clear();
            this.f1560d.set(readInt, readInt2, readInt3, readInt4, readInt5, readInt6);
        } else {
            this.f1560d = null;
        }
        this.f1561e = parcel.readInt();
        this.f1562f = parcel.readInt();
        this.f1563g = parcel.readInt();
        this.f1564h = parcel.readInt();
        this.f1565i = parcel.readInt();
        this.f1566j = parcel.readInt();
        this.f1567k = parcel.readInt();
        this.f1568l = parcel.readInt();
        this.f1569m = parcel.readInt();
    }

    protected PedometerMtn210(NfcDynamicTag nfcDynamicTag) {
        super((Type3Tag) nfcDynamicTag);
        this.f1559c = null;
        this.f1560d = null;
        this.f1561e = -1;
        this.f1562f = -1;
        this.f1563g = -1;
        this.f1564h = -1;
        this.f1565i = -1;
        this.f1566j = -1;
        this.f1567k = -1;
        this.f1568l = -1;
        this.f1569m = -1;
    }

    private static PedometerMtn210Data m1653a(byte[] bArr, int i, Calendar calendar) {
        return new PedometerMtn210Data(calendar, (((bArr[i + 0] & MotionEventCompat.ACTION_MASK) << 0) | ((bArr[i + 1] & MotionEventCompat.ACTION_MASK) << 8)) | (((bArr[i + 9] >> 0) & 1) << 16), (((bArr[i + 2] & MotionEventCompat.ACTION_MASK) << 0) | ((bArr[i + 3] & MotionEventCompat.ACTION_MASK) << 8)) | ((((bArr[i + 9] & MotionEventCompat.ACTION_MASK) >> 1) & 1) << 16), ((((bArr[i + 6] & MotionEventCompat.ACTION_MASK) << 0) | ((bArr[i + 7] & MotionEventCompat.ACTION_MASK) << 8)) | ((((bArr[i + 9] & MotionEventCompat.ACTION_MASK) >> 6) & 3) << 16)) * 200, ((((bArr[i + 4] & MotionEventCompat.ACTION_MASK) << 0) | ((bArr[i + 5] & MotionEventCompat.ACTION_MASK) << 8)) | ((((bArr[i + 9] & MotionEventCompat.ACTION_MASK) >> 4) & 3) << 16)) * 200, ((bArr[i + 8] & MotionEventCompat.ACTION_MASK) << 0) | ((((bArr[i + 9] & MotionEventCompat.ACTION_MASK) >> 2) & 3) << 8));
    }

    private static String m1654a(byte[] bArr, int i) {
        return C0466a.m1496a(new byte[]{bArr[i + 4], bArr[i + 3], bArr[i + 2], bArr[i + 1], bArr[i + 0]});
    }

    private void m1655a(Calendar calendar, int i, PedometerMtn210Data[] pedometerMtn210DataArr, int i2) {
        C0466a.m1497a("PedometerMtn210", "readDailyCommand");
        byte[] bArr = new byte[]{(byte) -73, (byte) 17, (byte) bArr.length, (byte) 0, (byte) 0, (byte) calendar.get(5), (byte) (calendar.get(2) + 1), (byte) (calendar.get(1) % 100), (byte) i, (byte) (-m1657b(bArr, bArr.length))};
        C0466a.m1497a("PedometerMtn210", C0466a.m1496a(bArr));
        m1658b(bArr);
        byte[] f = m1661f();
        C0466a.m1497a("PedometerMtn210", C0466a.m1496a(f));
        if ((f[0] & MotionEventCompat.ACTION_MASK) != 183 || (f[1] & MotionEventCompat.ACTION_MASK) != 17 || (f[2] & MotionEventCompat.ACTION_MASK) < (i * 10) + 6 || (f[3] & MotionEventCompat.ACTION_MASK) != 0) {
            throw new C0456c();
        } else if (m1657b(f, f[2] & MotionEventCompat.ACTION_MASK) != null) {
            throw new C0456c();
        } else {
            for (int i3 = 0; i3 < i; i3++) {
                pedometerMtn210DataArr[i2 + i3] = m1653a(f, (i3 * 10) + 6, (Calendar) calendar.clone());
                calendar.add(5, -1);
            }
        }
    }

    private void m1656a(Calendar calendar, boolean z, int i, int i2, int i3, int i4) {
        int i5;
        C0466a.m1497a("PedometerMtn210", "configCommand");
        byte[] bArr = new byte[19];
        bArr[0] = (byte) -73;
        bArr[1] = (byte) 16;
        bArr[2] = (byte) bArr.length;
        bArr[3] = (byte) 0;
        bArr[4] = (byte) 0;
        if (z) {
            i5 = 15;
            bArr[8] = (byte) i3;
            bArr[9] = (byte) i4;
            bArr[10] = (byte) (((i / 100) >> 0) & MotionEventCompat.ACTION_MASK);
            bArr[11] = (byte) (((i / 100) >> 8) & MotionEventCompat.ACTION_MASK);
            bArr[12] = (byte) ((i2 / 10) & MotionEventCompat.ACTION_MASK);
        } else {
            i5 = 0;
        }
        if (calendar != null) {
            i5 |= 16;
            m1659b(bArr, 13, calendar);
        }
        bArr[6] = (byte) ((i5 >> 0) & MotionEventCompat.ACTION_MASK);
        bArr[7] = (byte) ((i5 >> 8) & MotionEventCompat.ACTION_MASK);
        bArr[5] = (byte) (-m1657b(bArr, bArr.length));
        C0466a.m1497a("PedometerMtn210", C0466a.m1496a(bArr));
        m1658b(bArr);
        bArr = m1661f();
        C0466a.m1497a("PedometerMtn210", C0466a.m1496a(bArr));
        if ((bArr[0] & MotionEventCompat.ACTION_MASK) != 183 || (bArr[1] & MotionEventCompat.ACTION_MASK) != 16 || (bArr[2] & MotionEventCompat.ACTION_MASK) < 32 || (bArr[3] & MotionEventCompat.ACTION_MASK) != 0) {
            throw new C0456c();
        } else if (m1657b(bArr, bArr[2] & MotionEventCompat.ACTION_MASK) != null) {
            throw new C0456c();
        } else {
            this.f1560d = (Calendar) m1660c(bArr, 16).clone();
            this.f1559c = m1654a(bArr, 6);
            C0466a.m1497a("PedometerMtn210", "ID:" + this.f1559c);
            this.f1563g = bArr[11] & MotionEventCompat.ACTION_MASK;
            this.f1564h = bArr[12] & MotionEventCompat.ACTION_MASK;
            this.f1561e = (((bArr[13] & MotionEventCompat.ACTION_MASK) << 0) | ((bArr[14] & MotionEventCompat.ACTION_MASK) << 8)) * 100;
            this.f1562f = (bArr[15] & MotionEventCompat.ACTION_MASK) * 10;
            this.f1565i = bArr[23] & MotionEventCompat.ACTION_MASK;
            this.f1567k = ((bArr[24] & MotionEventCompat.ACTION_MASK) << 0) | ((bArr[25] & MotionEventCompat.ACTION_MASK) << 8);
            this.f1568l = ((bArr[27] & MotionEventCompat.ACTION_MASK) << 0) | ((bArr[28] & MotionEventCompat.ACTION_MASK) << 8);
            this.f1569m = ((bArr[29] & MotionEventCompat.ACTION_MASK) << 0) | ((bArr[30] & MotionEventCompat.ACTION_MASK) << 8);
            this.f1566j = bArr[31] & MotionEventCompat.ACTION_MASK;
        }
    }

    private static byte m1657b(byte[] bArr, int i) {
        int i2 = 0;
        byte b = (byte) 0;
        while (i2 < i) {
            b = (byte) (b + bArr[i2]);
            i2++;
        }
        return b;
    }

    private void m1658b(byte[] bArr) {
        Object obj = new byte[(((bArr.length + 15) / 16) * 16)];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        m1478a((byte[]) obj);
    }

    private static void m1659b(byte[] bArr, int i, Calendar calendar) {
        if (calendar == null) {
            calendar = Calendar.getInstance();
        }
        bArr[i + 0] = (byte) calendar.get(13);
        bArr[i + 1] = (byte) calendar.get(12);
        bArr[i + 2] = (byte) calendar.get(11);
        bArr[i + 3] = (byte) calendar.get(5);
        bArr[i + 4] = (byte) (calendar.get(2) + 1);
        bArr[i + 5] = (byte) (calendar.get(1) % 100);
    }

    private static Calendar m1660c(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set((bArr[i + 5] & MotionEventCompat.ACTION_MASK) + 2000, (bArr[i + 4] & MotionEventCompat.ACTION_MASK) - 1, bArr[i + 3] & MotionEventCompat.ACTION_MASK, bArr[i + 2] & MotionEventCompat.ACTION_MASK, bArr[i + 1] & MotionEventCompat.ACTION_MASK, bArr[i + 0] & MotionEventCompat.ACTION_MASK);
        return instance;
    }

    private byte[] m1661f() {
        return m1480a(12);
    }

    public PedometerData[] m1662a() {
        return this.f1558b;
    }

    public PedometerMtn210Data[] m1663a(Calendar calendar, int i, Calendar calendar2, int i2, int i3, int i4, int i5) {
        C0466a.m1497a("PedometerMtn210", "readStepData");
        if (i < 1) {
            throw new C0457d();
        }
        boolean z = false;
        if (!(i2 == -1 || i3 == -1 || i4 == -1 || i5 == -1)) {
            z = true;
            if (i2 < 20000 || i2 > 130000 || i3 < 1000 || i3 > 2000 || (!(i4 == 0 || i4 == 1) || i5 < 5 || i5 > 120)) {
                throw new C0457d();
            }
        }
        m1656a(calendar2, z, i2, i3, i4, i5);
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(2012, 11, 31, 0, 0, 0);
        Calendar instance2 = Calendar.getInstance();
        instance2.clear();
        if (calendar != null) {
            instance2.set(calendar.get(1), calendar.get(2), calendar.get(5));
        } else {
            instance2.set(this.f1560d.get(1), this.f1560d.get(2), this.f1560d.get(5));
        }
        Object obj = new PedometerMtn210Data[i];
        int i6 = 0;
        while (i6 < obj.length && !instance2.before(instance)) {
            int i7 = i - i6;
            if (i7 > 18) {
                i7 = 18;
            }
            if (((long) i7) > ((((instance2.getTimeInMillis() - instance.getTimeInMillis()) / 1000) / 60) / 60) / 24) {
                i7 = (int) (((((instance2.getTimeInMillis() - instance.getTimeInMillis()) / 1000) / 60) / 60) / 24);
                if (i7 == 0) {
                    break;
                }
            }
            m1655a(instance2, i7, obj, i6);
            i6 += i7;
        }
        if (i6 < obj.length) {
            this.f1558b = new PedometerMtn210Data[i6];
            System.arraycopy(obj, 0, this.f1558b, 0, i6);
        } else {
            this.f1558b = obj;
        }
        return this.f1558b;
    }

    public int describeContents() {
        return 0;
    }

    public PedometerData[] m1664e() {
        return m1663a(null, 15, null, -1, -1, -1, -1);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedArray(this.f1558b, i);
        parcel.writeString(this.f1559c);
        if (this.f1560d != null) {
            parcel.writeInt(1);
            parcel.writeInt(this.f1560d.get(1));
            parcel.writeInt(this.f1560d.get(2));
            parcel.writeInt(this.f1560d.get(5));
            parcel.writeInt(this.f1560d.get(11));
            parcel.writeInt(this.f1560d.get(12));
            parcel.writeInt(this.f1560d.get(13));
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.f1561e);
        parcel.writeInt(this.f1562f);
        parcel.writeInt(this.f1563g);
        parcel.writeInt(this.f1564h);
        parcel.writeInt(this.f1565i);
        parcel.writeInt(this.f1566j);
        parcel.writeInt(this.f1567k);
        parcel.writeInt(this.f1568l);
        parcel.writeInt(this.f1569m);
    }
}
