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

public class PedometerUw201Nfc extends NfcDynamicTag implements Parcelable, C0481a {
    public static final Creator CREATOR;
    protected static final byte[] f1579a;
    private PedometerUw201NfcData[] f1580b;
    private byte[] f1581c;
    private String f1582d;
    private int f1583e;
    private int f1584f;
    private int f1585g;
    private int f1586h;
    private int f1587i;
    private int f1588j;
    private byte[] f1589k;
    private Calendar f1590l;

    static {
        f1579a = new byte[]{(byte) 0, (byte) 19, (byte) 1, (byte) 0, (byte) 1, (byte) 21};
        CREATOR = new aa();
    }

    protected PedometerUw201Nfc(Parcel parcel) {
        super(parcel);
        this.f1582d = BuildConfig.VERSION_NAME;
        this.f1583e = -1;
        this.f1584f = -1;
        this.f1585g = -1;
        this.f1586h = -1;
        this.f1587i = -1;
        this.f1588j = -1;
        this.f1580b = (PedometerUw201NfcData[]) parcel.createTypedArray(PedometerUw201NfcData.CREATOR);
        this.f1581c = parcel.createByteArray();
        this.f1582d = parcel.readString();
        this.f1583e = parcel.readInt();
        this.f1584f = parcel.readInt();
        this.f1585g = parcel.readInt();
        this.f1586h = parcel.readInt();
        this.f1587i = parcel.readInt();
        this.f1588j = parcel.readInt();
        this.f1589k = parcel.createByteArray();
        if (parcel.readInt() != 0) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            int readInt5 = parcel.readInt();
            int readInt6 = parcel.readInt();
            this.f1590l = Calendar.getInstance();
            this.f1590l.clear();
            this.f1590l.set(readInt, readInt2, readInt3, readInt4, readInt5, readInt6);
            return;
        }
        this.f1590l = null;
    }

    protected PedometerUw201Nfc(NfcDynamicTag nfcDynamicTag) {
        super((Type3Tag) nfcDynamicTag);
        this.f1582d = BuildConfig.VERSION_NAME;
        this.f1583e = -1;
        this.f1584f = -1;
        this.f1585g = -1;
        this.f1586h = -1;
        this.f1587i = -1;
        this.f1588j = -1;
    }

    private static int m1676a(byte b) {
        return (((b & 240) / 16) * 10) + (b & 15);
    }

    private static PedometerUw201NfcData m1677a(byte[] bArr, int i) {
        return new PedometerUw201NfcData(m1685d(bArr, i + 1), (bArr[i + 10] & MotionEventCompat.ACTION_MASK) | (((bArr[i + 8] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 9] & MotionEventCompat.ACTION_MASK) << 8)), (bArr[i + 13] & MotionEventCompat.ACTION_MASK) | (((bArr[i + 11] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 12] & MotionEventCompat.ACTION_MASK) << 8)), ((((bArr[i + 22] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 23] & MotionEventCompat.ACTION_MASK) << 8)) | (bArr[i + 24] & MotionEventCompat.ACTION_MASK)) * 100, (((bArr[i + 14] & MotionEventCompat.ACTION_MASK) << 8) | (bArr[i + 15] & MotionEventCompat.ACTION_MASK)) * 100, (((bArr[i + 16] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 17] & MotionEventCompat.ACTION_MASK) << 8)) | (bArr[i + 18] & MotionEventCompat.ACTION_MASK), ((((bArr[i + 19] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 20] & MotionEventCompat.ACTION_MASK) << 8)) | (bArr[i + 21] & MotionEventCompat.ACTION_MASK)) * 100, (bArr[i + 26] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 25] & MotionEventCompat.ACTION_MASK) << 8));
    }

    private static String m1678a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2 && (bArr[i + i3] & MotionEventCompat.ACTION_MASK) >= 32 && (bArr[i + i3] & MotionEventCompat.ACTION_MASK) <= TransportMediator.KEYCODE_MEDIA_PAUSE) {
            i3++;
        }
        return new String(bArr, i, i3);
    }

    private static byte[] m1679a(String str) {
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

    private void m1680b(byte[] bArr) {
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

    private static void m1681b(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        bArr[i + 0] = m1684d(instance.get(12));
        bArr[i + 1] = m1684d(instance.get(11));
        bArr[i + 2] = m1684d(instance.get(5));
        bArr[i + 3] = m1684d(instance.get(2) + 1);
        bArr[i + 4] = m1684d(instance.get(1) % 100);
    }

    private static Calendar m1682c(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(m1676a(bArr[i + 4]) + 2000, m1676a(bArr[i + 3]) - 1, m1676a(bArr[i + 2]), m1676a(bArr[i + 1]), m1676a(bArr[i + 0]));
        return instance;
    }

    private static boolean m1683c(byte[] bArr) {
        byte b = (byte) 0;
        for (int i = 0; i < bArr.length - 1; i++) {
            b = (byte) (b + bArr[i]);
        }
        return b == bArr[bArr.length + -1];
    }

    private static byte m1684d(int i) {
        return (byte) (((i / 10) * 16) + (i % 10));
    }

    private static Calendar m1685d(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(((bArr[i + 0] & MotionEventCompat.ACTION_MASK) * 100) + (bArr[i + 1] & MotionEventCompat.ACTION_MASK), (bArr[i + 2] & MotionEventCompat.ACTION_MASK) - 1, bArr[i + 3] & MotionEventCompat.ACTION_MASK, bArr[i + 4] & MotionEventCompat.ACTION_MASK, bArr[i + 5] & MotionEventCompat.ACTION_MASK, bArr[i + 6] & MotionEventCompat.ACTION_MASK);
        return instance;
    }

    private byte[] m1686n() {
        return m1480a(12);
    }

    public PedometerData[] m1687a() {
        return this.f1580b;
    }

    public PedometerUw201NfcData[] m1688a(int i, boolean z) {
        C0466a.m1497a("PedometerUw201Nfc", "readLongDailyData");
        if (i < 10 || i > 91) {
            throw new IllegalArgumentException();
        }
        int i2;
        byte[] bArr = new byte[15];
        bArr[0] = (byte) -80;
        bArr[1] = m1684d(i - 1);
        if (z) {
            bArr[2] = (byte) 1;
        } else {
            bArr[2] = (byte) 0;
        }
        C0466a.m1497a("PedometerUw201Nfc", C0466a.m1496a(bArr));
        int i3 = (((i + 2) + 1) + 11) / 12;
        Object obj = new byte[(i3 * 192)];
        for (i2 = 0; i2 < i3; i2++) {
            m1680b(bArr);
            byte[] n = m1686n();
            C0466a.m1497a("PedometerUw201Nfc", C0466a.m1496a(n));
            if (n[0] == -1 && n[2] == -1) {
                throw new C0456c();
            }
            System.arraycopy(n, 0, obj, i2 * 192, 192);
        }
        if (m1683c((byte[]) obj)) {
            this.f1581c = new byte[5];
            this.f1581c[0] = obj[4];
            this.f1581c[1] = obj[3];
            this.f1581c[2] = obj[2];
            this.f1581c[3] = obj[1];
            this.f1581c[4] = obj[0];
            C0466a.m1497a("PedometerUw201Nfc", "ID:" + C0466a.m1496a(this.f1581c));
            this.f1589k = new byte[11];
            System.arraycopy(obj, 5, this.f1589k, 0, 11);
            C0466a.m1497a("PedometerUw201Nfc", "Mode:" + C0466a.m1496a(this.f1589k));
            this.f1585g = obj[16] & MotionEventCompat.ACTION_MASK;
            this.f1586h = m1676a(obj[17]) + (m1676a(obj[18]) * 100);
            this.f1583e = (m1676a(obj[19]) + (m1676a(obj[20]) * 100)) * 100;
            this.f1584f = (m1676a(obj[21]) + (m1676a(obj[22]) * 100)) * 10;
            this.f1587i = obj[29] & MotionEventCompat.ACTION_MASK;
            this.f1588j = (obj[30] & MotionEventCompat.ACTION_MASK) | ((obj[31] & MotionEventCompat.ACTION_MASK) << 8);
            Calendar c = m1682c(obj, 23);
            this.f1590l = (Calendar) c.clone();
            i2 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                if (obj[((i4 * 16) + 32) + 0] != -1) {
                    i2++;
                }
            }
            this.f1580b = new PedometerUw201NfcData[i2];
            for (int i5 = 0; i5 < this.f1580b.length; i5++) {
                if (obj[((i5 * 16) + 32) + 0] != -1) {
                    i3 = (m1676a(obj[((i5 * 16) + 32) + 2]) + (m1676a(obj[((i5 * 16) + 32) + 3]) * 100)) + (m1676a(obj[((i5 * 16) + 32) + 4]) * 10000);
                    int a = (m1676a(obj[((i5 * 16) + 32) + 5]) + (m1676a(obj[((i5 * 16) + 32) + 6]) * 100)) + (m1676a(obj[((i5 * 16) + 32) + 7]) * 10000);
                    int a2 = ((m1676a(obj[((i5 * 16) + 32) + 8]) + (m1676a(obj[((i5 * 16) + 32) + 9]) * 100)) + (m1676a(obj[((i5 * 16) + 32) + 10]) * 10000)) * 100;
                    int a3 = ((m1676a(obj[((i5 * 16) + 32) + 11]) + (m1676a(obj[((i5 * 16) + 32) + 12]) * 100)) + (m1676a(obj[((i5 * 16) + 32) + 13]) * 10000)) * 100;
                    int a4 = (m1676a(obj[((i5 * 16) + 32) + 14]) + (m1676a(obj[((i5 * 16) + 32) + 15]) * 100)) * 100;
                    Calendar calendar = (Calendar) c.clone();
                    calendar.add(5, -(m1676a(obj[((i5 * 16) + 32) + 0]) + (m1676a(obj[((i5 * 16) + 32) + 1]) * 100)));
                    if (z) {
                        this.f1580b[i5] = new PedometerUw201NfcData(calendar, i3, -1, a3, a4, a, a2, -1);
                    } else {
                        this.f1580b[i5] = new PedometerUw201NfcData(calendar, i3, a, a3, a4, -1, a2, -1);
                    }
                }
            }
            return this.f1580b;
        }
        throw new C0456c();
    }

    public PedometerUw201NfcData[] m1689c(int i) {
        C0466a.m1497a("PedometerUw201Nfc", "readHourlyData");
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
        m1681b(bArr, 8);
        int i3 = (((i * 24) + 1) + 5) / 6;
        byte[] bArr2 = new byte[(i3 * 192)];
        for (i2 = 0; i2 < i3; i2++) {
            m1680b(bArr);
            byte[] n = m1686n();
            C0466a.m1497a("PedometerUw201Nfc", C0466a.m1496a(n));
            if (n[0] == -128) {
                throw new C0456c();
            }
            System.arraycopy(n, 0, bArr2, i2 * 192, 192);
        }
        if (bArr2[((i3 - 1) * 192) + 176] != 127) {
            throw new C0456c();
        } else if (m1683c(bArr2)) {
            this.f1581c = m1679a(m1678a(bArr2, 0, 10));
            C0466a.m1497a("PedometerUw201Nfc", "ID:" + C0466a.m1496a(this.f1581c));
            this.f1582d = m1678a(bArr2, 16, 16);
            C0466a.m1497a("PedometerUw201Nfc", "Product:" + this.f1582d);
            this.f1590l = (Calendar) m1685d(bArr2, 33).clone();
            this.f1580b = new PedometerUw201NfcData[(i * 24)];
            for (i2 = 0; i2 < this.f1580b.length; i2++) {
                this.f1580b[i2] = m1677a(bArr2, (i2 * 32) + 32);
            }
            return this.f1580b;
        } else {
            throw new C0456c();
        }
    }

    public int describeContents() {
        return 0;
    }

    public byte[] m1690e() {
        return this.f1581c;
    }

    public String m1691f() {
        return this.f1582d;
    }

    public int m1692g() {
        return this.f1583e;
    }

    public int m1693h() {
        return this.f1584f;
    }

    public int m1694i() {
        return this.f1585g;
    }

    public int m1695j() {
        return this.f1586h;
    }

    public int m1696k() {
        return this.f1587i;
    }

    public PedometerData[] m1697l() {
        C0466a.m1497a("PedometerUw201Nfc", "readStepData");
        byte[] bArr = new byte[15];
        bArr[0] = (byte) -96;
        bArr[3] = (byte) 1;
        bArr[4] = (byte) 48;
        bArr[5] = (byte) 0;
        bArr[6] = (byte) 96;
        bArr[7] = (byte) 0;
        bArr[8] = (byte) 112;
        bArr[9] = (byte) 1;
        m1681b(bArr, 10);
        m1680b(bArr);
        byte[] n = m1686n();
        if (n[15] != null) {
            throw new C0456c();
        } else if (m1683c(n)) {
            this.f1581c = new byte[5];
            this.f1581c[0] = n[4];
            this.f1581c[1] = n[3];
            this.f1581c[2] = n[2];
            this.f1581c[3] = n[1];
            this.f1581c[4] = n[0];
            this.f1583e = (m1676a(n[5]) + (m1676a(n[6]) * 100)) * 100;
            this.f1584f = (m1676a(n[7]) + (m1676a(n[8]) * 100)) * 10;
            this.f1587i = n[181] & MotionEventCompat.ACTION_MASK;
            this.f1588j = (n[182] & MotionEventCompat.ACTION_MASK) | ((n[183] & MotionEventCompat.ACTION_MASK) << 8);
            Calendar c = m1682c(n, 9);
            this.f1590l = (Calendar) c.clone();
            this.f1580b = new PedometerUw201NfcData[15];
            for (int i = 0; i < this.f1580b.length; i++) {
                Calendar calendar = (Calendar) c.clone();
                this.f1580b[i] = new PedometerUw201NfcData(calendar, (m1676a(n[((i * 11) + 16) + 0]) + (m1676a(n[((i * 11) + 16) + 1]) * 100)) + (m1676a(n[((i * 11) + 16) + 2]) * 10000), (m1676a(n[((i * 11) + 16) + 3]) + (m1676a(n[((i * 11) + 16) + 4]) * 100)) + (m1676a(n[((i * 11) + 16) + 5]) * 10000), ((m1676a(n[((i * 11) + 16) + 6]) + (m1676a(n[((i * 11) + 16) + 7]) * 100)) + (m1676a(n[((i * 11) + 16) + 8]) * 10000)) * 100, (m1676a(n[((i * 11) + 16) + 9]) + (m1676a(n[((i * 11) + 16) + 10]) * 100)) * 100, -1, -1, -1);
                c.add(5, -1);
            }
            return this.f1580b;
        } else {
            throw new C0456c();
        }
    }

    public PedometerUw201NfcData[] m1698m() {
        int i;
        C0466a.m1497a("PedometerUw201Nfc", "readDailyData");
        byte[] bArr = new byte[15];
        bArr[0] = (byte) 0;
        bArr[2] = (byte) -1;
        bArr[3] = (byte) -1;
        bArr[4] = (byte) 23;
        bArr[5] = (byte) 112;
        bArr[6] = (byte) 0;
        bArr[7] = (byte) -86;
        m1681b(bArr, 8);
        byte[] bArr2 = new byte[576];
        for (i = 0; i < 3; i++) {
            m1680b(bArr);
            byte[] n = m1686n();
            C0466a.m1497a("PedometerUw201Nfc", C0466a.m1496a(n));
            if (n[0] == -128) {
                throw new C0456c();
            }
            System.arraycopy(n, 0, bArr2, i * 192, 192);
        }
        if (bArr2[560] != 127) {
            throw new C0456c();
        } else if (m1683c(bArr2)) {
            this.f1581c = m1679a(m1678a(bArr2, 0, 10));
            C0466a.m1497a("PedometerUw201Nfc", "ID:" + C0466a.m1496a(this.f1581c));
            this.f1582d = m1678a(bArr2, 16, 16);
            C0466a.m1497a("PedometerUw201Nfc", "Product:" + this.f1582d);
            this.f1590l = (Calendar) m1685d(bArr2, 33).clone();
            this.f1580b = new PedometerUw201NfcData[15];
            for (i = 0; i < this.f1580b.length; i++) {
                this.f1580b[i] = m1677a(bArr2, (i * 32) + 32);
            }
            return this.f1580b;
        } else {
            throw new C0456c();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedArray(this.f1580b, i);
        parcel.writeByteArray(this.f1581c);
        parcel.writeString(this.f1582d);
        parcel.writeInt(this.f1583e);
        parcel.writeInt(this.f1584f);
        parcel.writeInt(this.f1585g);
        parcel.writeInt(this.f1586h);
        parcel.writeInt(this.f1587i);
        parcel.writeInt(this.f1588j);
        parcel.writeByteArray(this.f1589k);
        if (this.f1590l != null) {
            parcel.writeInt(1);
            parcel.writeInt(this.f1590l.get(1));
            parcel.writeInt(this.f1590l.get(2));
            parcel.writeInt(this.f1590l.get(5));
            parcel.writeInt(this.f1590l.get(11));
            parcel.writeInt(this.f1590l.get(12));
            parcel.writeInt(this.f1590l.get(13));
            return;
        }
        parcel.writeInt(0);
    }
}
