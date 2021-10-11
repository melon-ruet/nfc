package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.BuildConfig;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.Type3Tag;
import com.sony.nfc.p024a.C0456c;
import com.sony.nfc.p025b.C0466a;
import java.util.Calendar;

public class PedometerMi700 extends NfcDynamicTag implements Parcelable, C0481a {
    public static final Creator CREATOR;
    protected static final byte[] f1528a;
    private PedometerMi700Data[] f1529b;
    private byte[] f1530c;
    private String f1531d;
    private int f1532e;
    private int f1533f;
    private int f1534g;
    private int f1535h;
    private int f1536i;
    private int f1537j;
    private byte[] f1538k;
    private Calendar f1539l;

    static {
        f1528a = new byte[]{(byte) 0, (byte) 16, (byte) 1, (byte) 0, (byte) 1, (byte) 3};
        CREATOR = new C0495o();
    }

    protected PedometerMi700(Parcel parcel) {
        super(parcel);
        this.f1531d = BuildConfig.VERSION_NAME;
        this.f1532e = -1;
        this.f1533f = -1;
        this.f1534g = -1;
        this.f1535h = -1;
        this.f1536i = -1;
        this.f1537j = -1;
        this.f1529b = (PedometerMi700Data[]) parcel.createTypedArray(PedometerMi700Data.CREATOR);
        this.f1530c = parcel.createByteArray();
        this.f1531d = parcel.readString();
        this.f1532e = parcel.readInt();
        this.f1533f = parcel.readInt();
        this.f1534g = parcel.readInt();
        this.f1535h = parcel.readInt();
        this.f1536i = parcel.readInt();
        this.f1537j = parcel.readInt();
        this.f1538k = parcel.createByteArray();
        if (parcel.readInt() != 0) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            int readInt5 = parcel.readInt();
            int readInt6 = parcel.readInt();
            this.f1539l = Calendar.getInstance();
            this.f1539l.clear();
            this.f1539l.set(readInt, readInt2, readInt3, readInt4, readInt5, readInt6);
            return;
        }
        this.f1539l = null;
    }

    protected PedometerMi700(NfcDynamicTag nfcDynamicTag) {
        super((Type3Tag) nfcDynamicTag);
        this.f1531d = BuildConfig.VERSION_NAME;
        this.f1532e = -1;
        this.f1533f = -1;
        this.f1534g = -1;
        this.f1535h = -1;
        this.f1536i = -1;
        this.f1537j = -1;
    }

    private static int m1618a(byte b) {
        return (((b & 240) / 16) * 10) + (b & 15);
    }

    private static PedometerMi700Data m1619a(byte[] bArr, int i) {
        return new PedometerMi700Data(m1627d(bArr, i + 1), (bArr[i + 10] & MotionEventCompat.ACTION_MASK) | (((bArr[i + 8] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 9] & MotionEventCompat.ACTION_MASK) << 8)), (bArr[i + 13] & MotionEventCompat.ACTION_MASK) | (((bArr[i + 11] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 12] & MotionEventCompat.ACTION_MASK) << 8)), ((((bArr[i + 22] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 23] & MotionEventCompat.ACTION_MASK) << 8)) | (bArr[i + 24] & MotionEventCompat.ACTION_MASK)) * 100, (((bArr[i + 14] & MotionEventCompat.ACTION_MASK) << 8) | (bArr[i + 15] & MotionEventCompat.ACTION_MASK)) * 100, (((bArr[i + 16] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 17] & MotionEventCompat.ACTION_MASK) << 8)) | (bArr[i + 18] & MotionEventCompat.ACTION_MASK), ((((bArr[i + 19] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 20] & MotionEventCompat.ACTION_MASK) << 8)) | (bArr[i + 21] & MotionEventCompat.ACTION_MASK)) * 100, (bArr[i + 26] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 25] & MotionEventCompat.ACTION_MASK) << 8));
    }

    private static String m1620a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2 && (bArr[i + i3] & MotionEventCompat.ACTION_MASK) >= 32 && (bArr[i + i3] & MotionEventCompat.ACTION_MASK) <= TransportMediator.KEYCODE_MEDIA_PAUSE) {
            i3++;
        }
        return new String(bArr, i, i3);
    }

    private static byte[] m1621a(String str) {
        if (str.length() % 2 != 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
            }
            return bArr;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void m1622b(byte[] bArr) {
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

    private static void m1623b(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        bArr[i + 0] = m1626d(instance.get(12));
        bArr[i + 1] = m1626d(instance.get(11));
        bArr[i + 2] = m1626d(instance.get(5));
        bArr[i + 3] = m1626d(instance.get(2) + 1);
        bArr[i + 4] = m1626d(instance.get(1) % 100);
    }

    private static Calendar m1624c(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(m1618a(bArr[i + 4]) + 2000, m1618a(bArr[i + 3]) - 1, m1618a(bArr[i + 2]), m1618a(bArr[i + 1]), m1618a(bArr[i + 0]));
        return instance;
    }

    private static boolean m1625c(byte[] bArr) {
        byte b = (byte) 0;
        for (int i = 0; i < bArr.length - 1; i++) {
            b = (byte) (b + bArr[i]);
        }
        return b == bArr[bArr.length + -1];
    }

    private static byte m1626d(int i) {
        return (byte) (((i / 10) * 16) + (i % 10));
    }

    private static Calendar m1627d(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(((bArr[i + 0] & MotionEventCompat.ACTION_MASK) * 100) + (bArr[i + 1] & MotionEventCompat.ACTION_MASK), (bArr[i + 2] & MotionEventCompat.ACTION_MASK) - 1, bArr[i + 3] & MotionEventCompat.ACTION_MASK, bArr[i + 4] & MotionEventCompat.ACTION_MASK, bArr[i + 5] & MotionEventCompat.ACTION_MASK, bArr[i + 6] & MotionEventCompat.ACTION_MASK);
        return instance;
    }

    private byte[] m1628g() {
        return m1480a(12);
    }

    public PedometerData[] m1629a() {
        return this.f1529b;
    }

    public PedometerMi700Data[] m1630a(int i, boolean z) {
        C0466a.m1497a("PedometerMi700", "readLongDailyData");
        if (i < 10 || i > 91) {
            throw new IllegalArgumentException();
        }
        int i2;
        byte[] bArr = new byte[15];
        bArr[0] = (byte) -80;
        bArr[1] = m1626d(i - 1);
        if (z) {
            bArr[2] = (byte) 1;
        } else {
            bArr[2] = (byte) 0;
        }
        C0466a.m1497a("PedometerMi700", C0466a.m1496a(bArr));
        int i3 = (((i + 2) + 1) + 11) / 12;
        Object obj = new byte[(i3 * 192)];
        for (i2 = 0; i2 < i3; i2++) {
            m1622b(bArr);
            byte[] g = m1628g();
            C0466a.m1497a("PedometerMi700", C0466a.m1496a(g));
            if (g[0] == -1 && g[2] == -1) {
                throw new C0456c();
            }
            System.arraycopy(g, 0, obj, i2 * 192, 192);
        }
        if (m1625c((byte[]) obj)) {
            this.f1530c = new byte[5];
            this.f1530c[0] = obj[4];
            this.f1530c[1] = obj[3];
            this.f1530c[2] = obj[2];
            this.f1530c[3] = obj[1];
            this.f1530c[4] = obj[0];
            C0466a.m1497a("PedometerMi700", "ID:" + C0466a.m1496a(this.f1530c));
            this.f1538k = new byte[11];
            System.arraycopy(obj, 5, this.f1538k, 0, 11);
            C0466a.m1497a("PedometerMi700", "Mode:" + C0466a.m1496a(this.f1538k));
            this.f1534g = obj[16] & MotionEventCompat.ACTION_MASK;
            this.f1535h = m1618a(obj[17]) + (m1618a(obj[18]) * 100);
            this.f1532e = (m1618a(obj[19]) + (m1618a(obj[20]) * 100)) * 100;
            this.f1533f = (m1618a(obj[21]) + (m1618a(obj[22]) * 100)) * 10;
            this.f1536i = obj[29] & MotionEventCompat.ACTION_MASK;
            this.f1537j = (obj[30] & MotionEventCompat.ACTION_MASK) | ((obj[31] & MotionEventCompat.ACTION_MASK) << 8);
            Calendar c = m1624c(obj, 23);
            this.f1539l = (Calendar) c.clone();
            i2 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                if (obj[((i4 * 16) + 32) + 0] != -1) {
                    i2++;
                }
            }
            this.f1529b = new PedometerMi700Data[i2];
            for (int i5 = 0; i5 < this.f1529b.length; i5++) {
                if (obj[((i5 * 16) + 32) + 0] != -1) {
                    i3 = (m1618a(obj[((i5 * 16) + 32) + 2]) + (m1618a(obj[((i5 * 16) + 32) + 3]) * 100)) + (m1618a(obj[((i5 * 16) + 32) + 4]) * 10000);
                    int a = (m1618a(obj[((i5 * 16) + 32) + 5]) + (m1618a(obj[((i5 * 16) + 32) + 6]) * 100)) + (m1618a(obj[((i5 * 16) + 32) + 7]) * 10000);
                    int a2 = ((m1618a(obj[((i5 * 16) + 32) + 8]) + (m1618a(obj[((i5 * 16) + 32) + 9]) * 100)) + (m1618a(obj[((i5 * 16) + 32) + 10]) * 10000)) * 100;
                    int a3 = ((m1618a(obj[((i5 * 16) + 32) + 11]) + (m1618a(obj[((i5 * 16) + 32) + 12]) * 100)) + (m1618a(obj[((i5 * 16) + 32) + 13]) * 10000)) * 100;
                    int a4 = (m1618a(obj[((i5 * 16) + 32) + 14]) + (m1618a(obj[((i5 * 16) + 32) + 15]) * 100)) * 100;
                    Calendar calendar = (Calendar) c.clone();
                    calendar.add(5, -(m1618a(obj[((i5 * 16) + 32) + 0]) + (m1618a(obj[((i5 * 16) + 32) + 1]) * 100)));
                    if (z) {
                        this.f1529b[i5] = new PedometerMi700Data(calendar, i3, -1, a3, a4, a, a2, -1);
                    } else {
                        this.f1529b[i5] = new PedometerMi700Data(calendar, i3, a, a3, a4, -1, a2, -1);
                    }
                }
            }
            return this.f1529b;
        }
        throw new C0456c();
    }

    public PedometerMi700Data[] m1631c(int i) {
        C0466a.m1497a("PedometerMi700", "readHourlyData");
        if (i < 1 || i > 8) {
            throw new IllegalArgumentException();
        }
        int i2;
        byte[] bArr = new byte[15];
        bArr[0] = (byte) 4;
        bArr[2] = (byte) (i - 1);
        bArr[3] = (byte) -1;
        bArr[4] = (byte) 23;
        bArr[5] = (byte) 112;
        bArr[6] = (byte) 0;
        bArr[7] = (byte) -86;
        m1623b(bArr, 8);
        int i3 = (((i * 24) + 1) + 5) / 6;
        byte[] bArr2 = new byte[(i3 * 192)];
        for (i2 = 0; i2 < i3; i2++) {
            m1622b(bArr);
            byte[] g = m1628g();
            C0466a.m1497a("PedometerMi700", C0466a.m1496a(g));
            if (g[0] == -128) {
                throw new C0456c();
            }
            System.arraycopy(g, 0, bArr2, i2 * 192, 192);
        }
        if (bArr2[((i3 - 1) * 192) + 176] != 127) {
            throw new C0456c();
        } else if (m1625c(bArr2)) {
            this.f1530c = m1621a(m1620a(bArr2, 0, 10));
            C0466a.m1497a("PedometerMi700", "ID:" + C0466a.m1496a(this.f1530c));
            this.f1531d = m1620a(bArr2, 16, 16);
            C0466a.m1497a("PedometerMi700", "Product:" + this.f1531d);
            this.f1539l = (Calendar) m1627d(bArr2, 33).clone();
            this.f1529b = new PedometerMi700Data[(i * 24)];
            for (i2 = 0; i2 < this.f1529b.length; i2++) {
                this.f1529b[i2] = m1619a(bArr2, (i2 * 32) + 32);
            }
            return this.f1529b;
        } else {
            throw new C0456c();
        }
    }

    public int describeContents() {
        return 0;
    }

    public PedometerData[] m1632e() {
        C0466a.m1497a("PedometerMi700", "readStepData");
        byte[] bArr = new byte[15];
        bArr[0] = (byte) -96;
        bArr[3] = (byte) 1;
        bArr[4] = (byte) 48;
        bArr[5] = (byte) 0;
        bArr[6] = (byte) 96;
        bArr[7] = (byte) 0;
        bArr[8] = (byte) 112;
        bArr[9] = (byte) 1;
        m1623b(bArr, 10);
        m1622b(bArr);
        byte[] g = m1628g();
        if (g[15] != null) {
            throw new C0456c();
        } else if (m1625c(g)) {
            this.f1530c = new byte[5];
            this.f1530c[0] = g[4];
            this.f1530c[1] = g[3];
            this.f1530c[2] = g[2];
            this.f1530c[3] = g[1];
            this.f1530c[4] = g[0];
            this.f1532e = (m1618a(g[5]) + (m1618a(g[6]) * 100)) * 100;
            this.f1533f = (m1618a(g[7]) + (m1618a(g[8]) * 100)) * 10;
            this.f1536i = g[181] & MotionEventCompat.ACTION_MASK;
            this.f1537j = (g[182] & MotionEventCompat.ACTION_MASK) | ((g[183] & MotionEventCompat.ACTION_MASK) << 8);
            Calendar c = m1624c(g, 9);
            this.f1539l = (Calendar) c.clone();
            this.f1529b = new PedometerMi700Data[15];
            for (int i = 0; i < this.f1529b.length; i++) {
                Calendar calendar = (Calendar) c.clone();
                this.f1529b[i] = new PedometerMi700Data(calendar, (m1618a(g[((i * 11) + 16) + 0]) + (m1618a(g[((i * 11) + 16) + 1]) * 100)) + (m1618a(g[((i * 11) + 16) + 2]) * 10000), (m1618a(g[((i * 11) + 16) + 3]) + (m1618a(g[((i * 11) + 16) + 4]) * 100)) + (m1618a(g[((i * 11) + 16) + 5]) * 10000), ((m1618a(g[((i * 11) + 16) + 6]) + (m1618a(g[((i * 11) + 16) + 7]) * 100)) + (m1618a(g[((i * 11) + 16) + 8]) * 10000)) * 100, (m1618a(g[((i * 11) + 16) + 9]) + (m1618a(g[((i * 11) + 16) + 10]) * 100)) * 100, -1, -1, -1);
                c.add(5, -1);
            }
            return this.f1529b;
        } else {
            throw new C0456c();
        }
    }

    public PedometerMi700Data[] m1633f() {
        int i;
        C0466a.m1497a("PedometerMi700", "readDailyData");
        byte[] bArr = new byte[15];
        bArr[0] = (byte) 0;
        bArr[2] = (byte) -1;
        bArr[3] = (byte) -1;
        bArr[4] = (byte) 23;
        bArr[5] = (byte) 112;
        bArr[6] = (byte) 0;
        bArr[7] = (byte) -86;
        m1623b(bArr, 8);
        byte[] bArr2 = new byte[576];
        for (i = 0; i < 3; i++) {
            m1622b(bArr);
            byte[] g = m1628g();
            C0466a.m1497a("PedometerMi700", C0466a.m1496a(g));
            if (g[0] == -128) {
                throw new C0456c();
            }
            System.arraycopy(g, 0, bArr2, i * 192, 192);
        }
        if (bArr2[560] != 127) {
            throw new C0456c();
        } else if (m1625c(bArr2)) {
            this.f1530c = m1621a(m1620a(bArr2, 0, 10));
            C0466a.m1497a("PedometerMi700", "ID:" + C0466a.m1496a(this.f1530c));
            this.f1531d = m1620a(bArr2, 16, 16);
            C0466a.m1497a("PedometerMi700", "Product:" + this.f1531d);
            this.f1539l = (Calendar) m1627d(bArr2, 33).clone();
            this.f1529b = new PedometerMi700Data[15];
            for (i = 0; i < this.f1529b.length; i++) {
                this.f1529b[i] = m1619a(bArr2, (i * 32) + 32);
            }
            return this.f1529b;
        } else {
            throw new C0456c();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedArray(this.f1529b, i);
        parcel.writeByteArray(this.f1530c);
        parcel.writeString(this.f1531d);
        parcel.writeInt(this.f1532e);
        parcel.writeInt(this.f1533f);
        parcel.writeInt(this.f1534g);
        parcel.writeInt(this.f1535h);
        parcel.writeInt(this.f1536i);
        parcel.writeInt(this.f1537j);
        parcel.writeByteArray(this.f1538k);
        if (this.f1539l != null) {
            parcel.writeInt(1);
            parcel.writeInt(this.f1539l.get(1));
            parcel.writeInt(this.f1539l.get(2));
            parcel.writeInt(this.f1539l.get(5));
            parcel.writeInt(this.f1539l.get(11));
            parcel.writeInt(this.f1539l.get(12));
            parcel.writeInt(this.f1539l.get(13));
            return;
        }
        parcel.writeInt(0);
    }
}
