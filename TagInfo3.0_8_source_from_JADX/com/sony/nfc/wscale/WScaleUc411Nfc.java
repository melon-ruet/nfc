package com.sony.nfc.wscale;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.actionbarsherlock.view.Menu;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.Type3Tag;
import com.sony.nfc.p024a.C0456c;
import com.sony.nfc.p024a.C0457d;
import com.sony.nfc.p025b.C0466a;
import java.util.Calendar;

public class WScaleUc411Nfc extends NfcDynamicTag implements Parcelable, C0510f {
    public static final Creator CREATOR;
    protected static final byte[] f1624a;
    protected int f1625b;
    protected int f1626c;
    protected int f1627d;
    protected boolean f1628e;
    protected int f1629f;
    protected int f1630g;
    protected WScaleUc411Nfc f1631h;
    private WScaleUc411NfcData[] f1632i;
    private String f1633j;
    private String f1634k;

    static {
        f1624a = new byte[]{(byte) 0, (byte) 19, (byte) 17, (byte) 0, (byte) 1, (byte) 0};
        CREATOR = new C0513c();
    }

    protected WScaleUc411Nfc(Parcel parcel) {
        super(parcel);
        this.f1633j = null;
        this.f1634k = null;
        this.f1632i = (WScaleUc411NfcData[]) parcel.createTypedArray(WScaleUc411NfcData.CREATOR);
        this.f1633j = parcel.readString();
        this.f1634k = parcel.readString();
        this.f1625b = parcel.readInt();
        this.f1626c = parcel.readInt();
        this.f1627d = parcel.readInt();
        this.f1628e = parcel.readInt() != 0;
        this.f1629f = parcel.readInt();
        this.f1630g = parcel.readInt();
    }

    protected WScaleUc411Nfc(NfcDynamicTag nfcDynamicTag, int i, int i2, int i3, boolean z, int i4, int i5, WScaleUc411Nfc wScaleUc411Nfc) {
        super((Type3Tag) nfcDynamicTag);
        this.f1633j = null;
        this.f1634k = null;
        this.f1626c = i2;
        this.f1627d = i3;
        this.f1628e = z;
        this.f1629f = i4;
        this.f1630g = i5;
        this.f1625b = i;
        this.f1631h = wScaleUc411Nfc;
    }

    private static WScaleUc411NfcData m1780a(byte[] bArr, int i) {
        Calendar c = m1786c(bArr, i + 1);
        int i2 = (((bArr[i + 8] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 9] & MotionEventCompat.ACTION_MASK) << 0)) * 10;
        int i3 = ((bArr[i + 11] & MotionEventCompat.ACTION_MASK) << 0) | ((bArr[i + 10] & MotionEventCompat.ACTION_MASK) << 8);
        if (i3 == Menu.USER_MASK) {
            i3 = -1;
        }
        int i4 = ((bArr[i + 13] & MotionEventCompat.ACTION_MASK) << 0) | ((bArr[i + 12] & MotionEventCompat.ACTION_MASK) << 8);
        if (i4 == Menu.USER_MASK) {
            i4 = -1;
        }
        int i5 = ((bArr[i + 17] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 18] & MotionEventCompat.ACTION_MASK) << 0);
        if (i5 == Menu.USER_MASK) {
            i5 = -1;
        }
        int i6 = ((bArr[i + 19] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 20] & MotionEventCompat.ACTION_MASK) << 0);
        int i7 = i6 == Menu.USER_MASK ? -1 : i6 * 1000;
        i6 = ((bArr[i + 21] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 22] & MotionEventCompat.ACTION_MASK) << 0);
        int i8 = i6 == Menu.USER_MASK ? -1 : i6 * 100;
        i6 = ((bArr[i + 23] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 24] & MotionEventCompat.ACTION_MASK) << 0);
        int i9 = i6 == Menu.USER_MASK ? -1 : i6 * 100;
        i6 = bArr[i + 26] & MotionEventCompat.ACTION_MASK;
        if (i6 == MotionEventCompat.ACTION_MASK) {
            i6 = -1;
        }
        return new WScaleUc411NfcData(c, i6, i2, i3, i4, i7, i5, i8, i9);
    }

    private static String m1781a(String str) {
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

    private static String m1782a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2 && (bArr[i + i3] & MotionEventCompat.ACTION_MASK) >= 32 && (bArr[i + i3] & MotionEventCompat.ACTION_MASK) <= TransportMediator.KEYCODE_MEDIA_PAUSE) {
            i3++;
        }
        return new String(bArr, i, i3);
    }

    private static void m1783a(byte[] bArr, int i, Calendar calendar) {
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

    private void m1784b(byte[] bArr) {
        int i = 0;
        byte b = (byte) 0;
        while (i < bArr.length - 1) {
            b = (byte) (b + (bArr[i] & MotionEventCompat.ACTION_MASK));
            i++;
        }
        bArr[bArr.length - 1] = b;
        m1478a(bArr);
    }

    private static boolean m1785b(byte[] bArr, int i) {
        byte b = (byte) 0;
        for (int i2 = 0; i2 < i - 1; i2++) {
            b = (byte) (b + bArr[i2]);
        }
        return b == bArr[i + -1];
    }

    private static Calendar m1786c(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(((bArr[i + 0] & MotionEventCompat.ACTION_MASK) * 100) + (bArr[i + 1] & MotionEventCompat.ACTION_MASK), (bArr[i + 2] & MotionEventCompat.ACTION_MASK) - 1, bArr[i + 3] & MotionEventCompat.ACTION_MASK, bArr[i + 4] & MotionEventCompat.ACTION_MASK, bArr[i + 5] & MotionEventCompat.ACTION_MASK, bArr[i + 6] & MotionEventCompat.ACTION_MASK);
        return instance;
    }

    private byte[] m1787d(int i) {
        return m1480a(i);
    }

    public WScaleUc411Nfc m1788c(int i) {
        boolean z = true;
        C0466a.m1497a("WScaleUc411Nfc", "readUserData");
        if (i < -1 || i > 5) {
            throw new C0457d();
        }
        int i2 = i == -1 ? this.f1625b : i;
        byte[] bArr = new byte[16];
        bArr[0] = (byte) -88;
        bArr[1] = (byte) i2;
        for (int i3 = 2; i3 < 15; i3++) {
            bArr[i3] = (byte) -1;
        }
        C0466a.m1497a("WScaleUc411Nfc", C0466a.m1496a(bArr));
        m1784b(bArr);
        byte[] d = m1787d(1);
        C0466a.m1497a("WScaleUc411Nfc", C0466a.m1496a(d));
        if (d[0] == bArr[0] && d[1] == bArr[1]) {
            int i4 = ((d[2] & MotionEventCompat.ACTION_MASK) << 8) | ((d[3] & MotionEventCompat.ACTION_MASK) << 0);
            int i5 = d[4] & MotionEventCompat.ACTION_MASK;
            if (d[5] != null) {
                z = false;
            }
            this.f1631h = new WScaleUc411Nfc(this, i2, i4, i5, z, this.f1629f, this.f1630g, null);
            return this.f1631h;
        }
        throw new C0456c();
    }

    public int describeContents() {
        return 0;
    }

    public WeighingScaleData[] m1789e() {
        return this.f1632i;
    }

    public WeighingScaleData[] m1790f() {
        int i;
        int i2;
        C0466a.m1497a("WScaleUc411Nfc", "readScaleData");
        byte[] bArr = new byte[16];
        bArr[0] = (byte) -73;
        bArr[1] = (byte) this.f1625b;
        if (this.f1626c == -1 || this.f1627d == -1) {
            bArr[2] = (byte) -1;
            bArr[3] = (byte) -1;
            bArr[4] = (byte) -1;
            bArr[5] = (byte) -1;
            bArr[6] = (byte) 0;
            bArr[7] = (byte) 0;
        } else {
            bArr[2] = (byte) ((this.f1626c >> 8) & MotionEventCompat.ACTION_MASK);
            bArr[3] = (byte) ((this.f1626c >> 0) & MotionEventCompat.ACTION_MASK);
            bArr[4] = (byte) (this.f1627d & MotionEventCompat.ACTION_MASK);
            bArr[5] = (byte) (this.f1628e ? 0 : 1);
            bArr[6] = (byte) (this.f1629f & MotionEventCompat.ACTION_MASK);
            if (this.f1630g == -1) {
                bArr[7] = (byte) 0;
            } else {
                bArr[7] = (byte) ((this.f1630g - 9744) & MotionEventCompat.ACTION_MASK);
            }
        }
        m1783a(bArr, 8, null);
        C0466a.m1497a("WScaleUc411Nfc", C0466a.m1496a(bArr));
        byte[] bArr2 = new byte[576];
        for (i = 0; i < 3; i++) {
            m1784b(bArr);
            byte[] d = m1787d(12);
            C0466a.m1497a("WScaleUc411Nfc", C0466a.m1496a(d));
            if (d[0] == -128) {
                throw new C0456c();
            }
            System.arraycopy(d, 0, bArr2, i * 192, 192);
            if (d[176] == 127) {
                i2 = i + 1;
                break;
            }
        }
        i2 = -1;
        if (i2 == -1) {
            throw new C0456c();
        } else if (m1785b(bArr2, i2 * 192)) {
            this.f1633j = m1781a(m1782a(bArr2, 0, 16));
            this.f1634k = m1781a(m1782a(bArr2, 16, 16));
            int i3 = 0;
            i = 0;
            while (i3 < (i2 * 6) - 1 && bArr2[(i3 * 32) + 32] == bArr[0]) {
                if (bArr2[((i3 * 32) + 32) + 16] == (byte) 1) {
                    i++;
                }
                i3++;
            }
            this.f1632i = new WScaleUc411NfcData[i];
            i3 = 0;
            for (i2 = 0; i2 < i; i2++) {
                if (bArr2[((i2 * 32) + 32) + 16] == (byte) 1) {
                    this.f1632i[i3] = m1780a(bArr2, (i2 * 32) + 32);
                    i3++;
                }
            }
            bArr[0] = Byte.MAX_VALUE;
            m1784b(bArr);
            return this.f1632i;
        } else {
            throw new C0456c();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedArray(this.f1632i, i);
        parcel.writeString(this.f1633j);
        parcel.writeString(this.f1634k);
        parcel.writeInt(this.f1625b);
        parcel.writeInt(this.f1626c);
        parcel.writeInt(this.f1627d);
        parcel.writeInt(this.f1628e ? 1 : 0);
        parcel.writeInt(this.f1629f);
        parcel.writeInt(this.f1630g);
    }
}
