package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.Type3Tag;
import com.sony.nfc.p024a.C0456c;
import com.sony.nfc.p025b.C0466a;
import java.util.Calendar;

public class PedometerMtn200 extends NfcDynamicTag implements Parcelable, C0481a {
    public static final Creator CREATOR;
    protected static final byte[] f1543a;
    private PedometerMtn200Data[] f1544b;
    private String f1545c;
    private String f1546d;
    private Calendar f1547e;
    private int f1548f;
    private int f1549g;
    private int f1550h;
    private int f1551i;
    private int f1552j;
    private int f1553k;
    private byte[] f1554l;

    static {
        f1543a = new byte[]{(byte) 0, (byte) 16, (byte) 1, (byte) 0, (byte) 2, (byte) 1};
        CREATOR = new C0498r();
    }

    protected PedometerMtn200(Parcel parcel) {
        super(parcel);
        this.f1545c = null;
        this.f1546d = null;
        this.f1547e = null;
        this.f1548f = -1;
        this.f1549g = -1;
        this.f1550h = -1;
        this.f1551i = -1;
        this.f1552j = -1;
        this.f1553k = -1;
        this.f1544b = (PedometerMtn200Data[]) parcel.createTypedArray(PedometerMtn200Data.CREATOR);
        this.f1545c = parcel.readString();
        this.f1546d = parcel.readString();
        if (parcel.readInt() != 0) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            int readInt5 = parcel.readInt();
            int readInt6 = parcel.readInt();
            this.f1547e = Calendar.getInstance();
            this.f1547e.clear();
            this.f1547e.set(readInt, readInt2, readInt3, readInt4, readInt5, readInt6);
        } else {
            this.f1547e = null;
        }
        this.f1548f = parcel.readInt();
        this.f1549g = parcel.readInt();
        this.f1550h = parcel.readInt();
        this.f1551i = parcel.readInt();
        this.f1552j = parcel.readInt();
        this.f1553k = parcel.readInt();
    }

    protected PedometerMtn200(NfcDynamicTag nfcDynamicTag) {
        super((Type3Tag) nfcDynamicTag);
        this.f1545c = null;
        this.f1546d = null;
        this.f1547e = null;
        this.f1548f = -1;
        this.f1549g = -1;
        this.f1550h = -1;
        this.f1551i = -1;
        this.f1552j = -1;
        this.f1553k = -1;
    }

    private static int m1634a(byte b) {
        return (((b & 240) / 16) * 10) + (b & 15);
    }

    private static PedometerMtn200Data m1635a(byte[] bArr, int i) {
        return new PedometerMtn200Data(m1644d(bArr, i + 1), (bArr[i + 10] & MotionEventCompat.ACTION_MASK) | (((bArr[i + 8] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 9] & MotionEventCompat.ACTION_MASK) << 8)), (bArr[i + 13] & MotionEventCompat.ACTION_MASK) | (((bArr[i + 11] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 12] & MotionEventCompat.ACTION_MASK) << 8)), ((((bArr[i + 22] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 23] & MotionEventCompat.ACTION_MASK) << 8)) | (bArr[i + 24] & MotionEventCompat.ACTION_MASK)) * 100, (((bArr[i + 14] & MotionEventCompat.ACTION_MASK) << 8) | (bArr[i + 15] & MotionEventCompat.ACTION_MASK)) * 100, ((((bArr[i + 19] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 20] & MotionEventCompat.ACTION_MASK) << 8)) | (bArr[i + 21] & MotionEventCompat.ACTION_MASK)) * 100, (bArr[i + 26] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 25] & MotionEventCompat.ACTION_MASK) << 8));
    }

    private static String m1636a(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) == ' ') {
                i++;
            }
        }
        return str.substring(0, str.length() - i);
    }

    private static String m1637a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2 && (bArr[i + i3] & MotionEventCompat.ACTION_MASK) >= 32 && (bArr[i + i3] & MotionEventCompat.ACTION_MASK) <= TransportMediator.KEYCODE_MEDIA_PAUSE) {
            i3++;
        }
        return new String(bArr, i, i3);
    }

    private static void m1638a(byte[] bArr, int i, Calendar calendar) {
        bArr[i + 0] = m1645e(calendar.get(12));
        bArr[i + 1] = m1645e(calendar.get(11));
        bArr[i + 2] = m1645e(calendar.get(5));
        bArr[i + 3] = m1645e(calendar.get(2) + 1);
        bArr[i + 4] = m1645e(calendar.get(1) % 100);
    }

    private void m1639b(byte[] bArr) {
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

    private static void m1640b(byte[] bArr, int i) {
        m1638a(bArr, i, Calendar.getInstance());
    }

    private static void m1641b(byte[] bArr, int i, Calendar calendar) {
        if (calendar == null) {
            calendar = Calendar.getInstance();
        }
        bArr[i + 0] = (byte) (calendar.get(1) / 100);
        bArr[i + 1] = (byte) (calendar.get(1) % 100);
        bArr[i + 2] = (byte) (calendar.get(2) + 1);
        bArr[i + 3] = (byte) calendar.get(5);
        bArr[i + 4] = (byte) calendar.get(11);
        bArr[i + 5] = (byte) calendar.get(12);
        bArr[i + 6] = (byte) calendar.get(13);
    }

    private static Calendar m1642c(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(m1634a(bArr[i + 4]) + 2000, m1634a(bArr[i + 3]) - 1, m1634a(bArr[i + 2]), m1634a(bArr[i + 1]), m1634a(bArr[i + 0]));
        return instance;
    }

    private static boolean m1643c(byte[] bArr) {
        byte b = (byte) 0;
        for (int i = 0; i < bArr.length - 1; i++) {
            b = (byte) (b + bArr[i]);
        }
        return b == bArr[bArr.length + -1];
    }

    private static Calendar m1644d(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(((bArr[i + 0] & MotionEventCompat.ACTION_MASK) * 100) + (bArr[i + 1] & MotionEventCompat.ACTION_MASK), (bArr[i + 2] & MotionEventCompat.ACTION_MASK) - 1, bArr[i + 3] & MotionEventCompat.ACTION_MASK, bArr[i + 4] & MotionEventCompat.ACTION_MASK, bArr[i + 5] & MotionEventCompat.ACTION_MASK, bArr[i + 6] & MotionEventCompat.ACTION_MASK);
        return instance;
    }

    private static byte m1645e(int i) {
        return (byte) (((i / 10) * 16) + (i % 10));
    }

    private byte[] m1646g() {
        return m1480a(12);
    }

    public PedometerData[] m1647a() {
        return this.f1544b;
    }

    public PedometerData[] m1648a(Calendar calendar, int i, int i2, int i3, int i4) {
        C0466a.m1497a("PedometerMtn200", "setInfo");
        Object obj = null;
        if (!(i == -1 || i2 == -1 || i3 == -1 || i4 == -1)) {
            obj = 1;
            if (i < 20000 || i > 130000 || i2 < 1000 || i2 > 2000 || (!(i3 == 0 || i3 == 1) || i4 < 5 || i4 > 120)) {
                throw new IllegalArgumentException();
            }
        }
        byte[] bArr = new byte[15];
        if (obj != null) {
            if (calendar != null) {
                bArr[0] = (byte) -93;
            } else {
                bArr[0] = (byte) -94;
            }
        } else if (calendar != null) {
            bArr[0] = (byte) -95;
        } else {
            bArr[0] = (byte) -96;
        }
        if (obj != null) {
            bArr[3] = (byte) (i3 & MotionEventCompat.ACTION_MASK);
            bArr[4] = m1645e(i4 % 100);
            bArr[5] = m1645e(i4 / 100);
            bArr[6] = m1645e((i / 100) % 100);
            bArr[7] = m1645e((i / 100) / 100);
            bArr[8] = m1645e((i2 / 10) % 100);
            bArr[9] = m1645e((i2 / 10) / 100);
        } else {
            bArr[3] = (byte) 1;
            bArr[4] = (byte) 48;
            bArr[5] = (byte) 0;
            bArr[6] = (byte) 96;
            bArr[7] = (byte) 0;
            bArr[8] = (byte) 112;
            bArr[9] = (byte) 1;
        }
        if (calendar != null) {
            m1638a(bArr, 10, calendar);
        } else {
            m1640b(bArr, 10);
        }
        m1639b(bArr);
        byte[] g = m1646g();
        C0466a.m1497a("PedometerMtn200", C0466a.m1496a(g));
        if (g[15] != null) {
            throw new C0456c();
        } else if (m1643c(g)) {
            this.f1545c = C0466a.m1496a(new byte[]{g[4], g[3], g[2], g[1], g[0]});
            C0466a.m1497a("PedometerMtn200", "ID:" + this.f1545c);
            this.f1548f = (m1634a(g[5]) + (m1634a(g[6]) * 100)) * 100;
            this.f1549g = (m1634a(g[7]) + (m1634a(g[8]) * 100)) * 10;
            Calendar c = m1642c(g, 9);
            this.f1547e = (Calendar) c.clone();
            int i5 = c.get(1);
            int i6 = c.get(2);
            int i7 = c.get(5);
            c.clear();
            c.set(i5, i6, i7);
            this.f1544b = new PedometerMtn200Data[15];
            for (int i8 = 0; i8 < this.f1544b.length; i8++) {
                Calendar calendar2 = (Calendar) c.clone();
                this.f1544b[i8] = new PedometerMtn200Data(calendar2, (m1634a(g[((i8 * 11) + 16) + 0]) + (m1634a(g[((i8 * 11) + 16) + 1]) * 100)) + (m1634a(g[((i8 * 11) + 16) + 2]) * 10000), (m1634a(g[((i8 * 11) + 16) + 3]) + (m1634a(g[((i8 * 11) + 16) + 4]) * 100)) + (m1634a(g[((i8 * 11) + 16) + 5]) * 10000), ((m1634a(g[((i8 * 11) + 16) + 6]) + (m1634a(g[((i8 * 11) + 16) + 7]) * 100)) + (m1634a(g[((i8 * 11) + 16) + 8]) * 10000)) * 100, (m1634a(g[((i8 * 11) + 16) + 9]) + (m1634a(g[((i8 * 11) + 16) + 10]) * 100)) * 100, -1, -1);
                c.add(5, -1);
            }
            return this.f1544b;
        } else {
            throw new C0456c();
        }
    }

    public PedometerMtn200Data[] m1649c(int i) {
        C0466a.m1497a("PedometerMtn200", "readLongDailyData");
        if (i < 10 || i > 91) {
            throw new IllegalArgumentException();
        }
        int i2;
        byte[] bArr = new byte[15];
        bArr[0] = (byte) -80;
        bArr[1] = m1645e(i - 1);
        bArr[2] = (byte) 0;
        C0466a.m1497a("PedometerMtn200", C0466a.m1496a(bArr));
        int i3 = (((i + 2) + 1) + 11) / 12;
        byte[] bArr2 = new byte[(i3 * 192)];
        for (i2 = 0; i2 < i3; i2++) {
            m1639b(bArr);
            byte[] g = m1646g();
            C0466a.m1497a("PedometerMtn200", C0466a.m1496a(g));
            if (g[0] == (byte) -1 && g[2] == (byte) -1) {
                throw new C0456c();
            }
            System.arraycopy(g, 0, bArr2, i2 * 192, 192);
        }
        if (m1643c(bArr2)) {
            this.f1545c = C0466a.m1496a(new byte[]{bArr2[4], bArr2[3], bArr2[2], bArr2[1], bArr2[0]});
            C0466a.m1497a("PedometerMtn200", "ID:" + this.f1545c);
            this.f1554l = new byte[11];
            System.arraycopy(bArr2, 5, this.f1554l, 0, 11);
            C0466a.m1497a("PedometerMtn200", "Mode:" + C0466a.m1496a(this.f1554l));
            this.f1550h = bArr2[16] & MotionEventCompat.ACTION_MASK;
            this.f1551i = m1634a(bArr2[17]) + (m1634a(bArr2[18]) * 100);
            this.f1548f = (m1634a(bArr2[19]) + (m1634a(bArr2[20]) * 100)) * 100;
            this.f1549g = (m1634a(bArr2[21]) + (m1634a(bArr2[22]) * 100)) * 10;
            this.f1552j = bArr2[29] & MotionEventCompat.ACTION_MASK;
            this.f1553k = (bArr2[30] & MotionEventCompat.ACTION_MASK) | ((bArr2[31] & MotionEventCompat.ACTION_MASK) << 8);
            Calendar c = m1642c(bArr2, 23);
            this.f1547e = (Calendar) c.clone();
            i2 = c.get(1);
            int i4 = c.get(2);
            i3 = c.get(5);
            c.clear();
            c.set(i2, i4, i3);
            i2 = 0;
            for (i4 = 0; i4 < i; i4++) {
                if (bArr2[((i4 * 16) + 32) + 0] != (byte) -1) {
                    i2++;
                }
            }
            this.f1544b = new PedometerMtn200Data[i2];
            for (int i5 = 0; i5 < this.f1544b.length; i5++) {
                if (bArr2[((i5 * 16) + 32) + 0] != (byte) -1) {
                    i4 = (m1634a(bArr2[((i5 * 16) + 32) + 2]) + (m1634a(bArr2[((i5 * 16) + 32) + 3]) * 100)) + (m1634a(bArr2[((i5 * 16) + 32) + 4]) * 10000);
                    i3 = (m1634a(bArr2[((i5 * 16) + 32) + 5]) + (m1634a(bArr2[((i5 * 16) + 32) + 6]) * 100)) + (m1634a(bArr2[((i5 * 16) + 32) + 7]) * 10000);
                    int a = ((m1634a(bArr2[((i5 * 16) + 32) + 8]) + (m1634a(bArr2[((i5 * 16) + 32) + 9]) * 100)) + (m1634a(bArr2[((i5 * 16) + 32) + 10]) * 10000)) * 100;
                    int a2 = ((m1634a(bArr2[((i5 * 16) + 32) + 11]) + (m1634a(bArr2[((i5 * 16) + 32) + 12]) * 100)) + (m1634a(bArr2[((i5 * 16) + 32) + 13]) * 10000)) * 100;
                    int a3 = (m1634a(bArr2[((i5 * 16) + 32) + 14]) + (m1634a(bArr2[((i5 * 16) + 32) + 15]) * 100)) * 100;
                    Calendar calendar = (Calendar) c.clone();
                    calendar.add(5, -(m1634a(bArr2[((i5 * 16) + 32) + 0]) + (m1634a(bArr2[((i5 * 16) + 32) + 1]) * 100)));
                    this.f1544b[i5] = new PedometerMtn200Data(calendar, i4, i3, a2, a3, a, -1);
                }
            }
            return this.f1544b;
        }
        throw new C0456c();
    }

    public PedometerMtn200Data[] m1650d(int i) {
        C0466a.m1497a("PedometerMtn200", "readHourlyData");
        if (i < 1 || i > 8) {
            throw new IllegalArgumentException();
        }
        int i2;
        byte[] bArr = new byte[15];
        bArr[0] = (byte) -79;
        bArr[1] = m1645e(i - 1);
        C0466a.m1497a("PedometerMtn200", C0466a.m1496a(bArr));
        int i3 = ((((i * 24) + 2) + 1) + 11) / 12;
        byte[] bArr2 = new byte[(i3 * 192)];
        for (i2 = 0; i2 < i3; i2++) {
            m1639b(bArr);
            byte[] g = m1646g();
            C0466a.m1497a("PedometerMtn200", C0466a.m1496a(g));
            if (g[0] == (byte) -1 && g[2] == (byte) -1) {
                throw new C0456c();
            }
            System.arraycopy(g, 0, bArr2, i2 * 192, 192);
        }
        if (m1643c(bArr2)) {
            this.f1545c = C0466a.m1496a(new byte[]{bArr2[4], bArr2[3], bArr2[2], bArr2[1], bArr2[0]});
            C0466a.m1497a("PedometerMtn200", "ID:" + this.f1545c);
            this.f1554l = new byte[11];
            System.arraycopy(bArr2, 5, this.f1554l, 0, 11);
            C0466a.m1497a("PedometerMtn200", "Mode:" + C0466a.m1496a(this.f1554l));
            this.f1550h = bArr2[16] & MotionEventCompat.ACTION_MASK;
            this.f1551i = m1634a(bArr2[17]) + (m1634a(bArr2[18]) * 100);
            this.f1548f = (m1634a(bArr2[19]) + (m1634a(bArr2[20]) * 100)) * 100;
            this.f1549g = (m1634a(bArr2[21]) + (m1634a(bArr2[22]) * 100)) * 10;
            this.f1552j = bArr2[29] & MotionEventCompat.ACTION_MASK;
            this.f1553k = (bArr2[30] & MotionEventCompat.ACTION_MASK) | ((bArr2[31] & MotionEventCompat.ACTION_MASK) << 8);
            Calendar c = m1642c(bArr2, 23);
            this.f1547e = (Calendar) c.clone();
            i2 = c.get(1);
            int i4 = c.get(2);
            i3 = c.get(5);
            c.clear();
            c.set(i2, i4, i3);
            i2 = 0;
            for (i4 = 0; i4 < i * 24; i4++) {
                if (bArr2[((i4 * 16) + 32) + 0] != (byte) -1) {
                    i2++;
                }
            }
            this.f1544b = new PedometerMtn200Data[i2];
            for (int i5 = 0; i5 < this.f1544b.length; i5++) {
                if (bArr2[((i5 * 16) + 32) + 0] != (byte) -1) {
                    int a = m1634a(bArr2[((i5 * 16) + 32) + 0]);
                    int a2 = m1634a(bArr2[((i5 * 16) + 32) + 1]);
                    i4 = (m1634a(bArr2[((i5 * 16) + 32) + 2]) + (m1634a(bArr2[((i5 * 16) + 32) + 3]) * 100)) + (m1634a(bArr2[((i5 * 16) + 32) + 4]) * 10000);
                    i3 = (m1634a(bArr2[((i5 * 16) + 32) + 5]) + (m1634a(bArr2[((i5 * 16) + 32) + 6]) * 100)) + (m1634a(bArr2[((i5 * 16) + 32) + 7]) * 10000);
                    int a3 = ((m1634a(bArr2[((i5 * 16) + 32) + 8]) + (m1634a(bArr2[((i5 * 16) + 32) + 9]) * 100)) + (m1634a(bArr2[((i5 * 16) + 32) + 10]) * 10000)) * 100;
                    int a4 = ((m1634a(bArr2[((i5 * 16) + 32) + 11]) + (m1634a(bArr2[((i5 * 16) + 32) + 12]) * 100)) + (m1634a(bArr2[((i5 * 16) + 32) + 13]) * 10000)) * 100;
                    int a5 = (m1634a(bArr2[((i5 * 16) + 32) + 14]) + (m1634a(bArr2[((i5 * 16) + 32) + 15]) * 100)) * 100;
                    Calendar calendar = (Calendar) c.clone();
                    calendar.add(5, -a);
                    calendar.add(11, a2);
                    this.f1544b[i5] = new PedometerMtn200Data(calendar, i4, i3, a4, a5, a3, -1);
                }
            }
            return this.f1544b;
        }
        throw new C0456c();
    }

    public int describeContents() {
        return 0;
    }

    public PedometerData[] m1651e() {
        C0466a.m1497a("PedometerMtn200", "readStepData");
        return m1648a(null, -1, -1, -1, -1);
    }

    public PedometerMtn200Data[] m1652f() {
        int i;
        C0466a.m1497a("PedometerMtn200", "readDailyData");
        byte[] bArr = new byte[15];
        bArr[0] = (byte) 0;
        bArr[4] = (byte) 23;
        bArr[5] = (byte) 112;
        bArr[6] = (byte) 0;
        bArr[7] = (byte) -86;
        m1641b(bArr, 8, null);
        C0466a.m1497a("PedometerMtn200", C0466a.m1496a(bArr));
        byte[] bArr2 = new byte[576];
        for (i = 0; i < 3; i++) {
            m1639b(bArr);
            byte[] g = m1646g();
            C0466a.m1497a("PedometerMtn200", C0466a.m1496a(g));
            if (g[0] == -128) {
                throw new C0456c();
            }
            System.arraycopy(g, 0, bArr2, i * 192, 192);
        }
        if (bArr2[560] != 127) {
            throw new C0456c();
        } else if (m1643c(bArr2)) {
            this.f1545c = m1636a(m1637a(bArr2, 0, 16));
            C0466a.m1497a("PedometerMtn200", "ID:" + this.f1545c);
            this.f1546d = m1636a(m1637a(bArr2, 16, 16));
            C0466a.m1497a("PedometerMtn200", "Product:" + this.f1546d);
            this.f1547e = (Calendar) m1644d(bArr2, 33).clone();
            this.f1544b = new PedometerMtn200Data[15];
            for (i = 0; i < this.f1544b.length; i++) {
                this.f1544b[i] = m1635a(bArr2, (i * 32) + 32);
            }
            return this.f1544b;
        } else {
            throw new C0456c();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedArray(this.f1544b, i);
        parcel.writeString(this.f1545c);
        parcel.writeString(this.f1546d);
        if (this.f1547e != null) {
            parcel.writeInt(1);
            parcel.writeInt(this.f1547e.get(1));
            parcel.writeInt(this.f1547e.get(2));
            parcel.writeInt(this.f1547e.get(5));
            parcel.writeInt(this.f1547e.get(11));
            parcel.writeInt(this.f1547e.get(12));
            parcel.writeInt(this.f1547e.get(13));
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.f1548f);
        parcel.writeInt(this.f1549g);
        parcel.writeInt(this.f1550h);
        parcel.writeInt(this.f1551i);
        parcel.writeInt(this.f1552j);
        parcel.writeInt(this.f1553k);
    }
}
