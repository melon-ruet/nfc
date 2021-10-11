package com.sony.nfc.wscale;

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

public class WScaleUc324Nfc extends NfcDynamicTag implements Parcelable, C0510f {
    public static final Creator CREATOR;
    protected static final byte[] f1619a;
    protected static final byte[] f1620b;
    private WeighingScaleData[] f1621c;
    private String f1622d;
    private String f1623e;

    static {
        f1619a = new byte[]{(byte) 0, (byte) 19, (byte) 16, (byte) 0, (byte) 1};
        f1620b = new byte[]{(byte) 0, (byte) 19, (byte) 16, (byte) 1, (byte) 1};
        CREATOR = new C0511a();
    }

    protected WScaleUc324Nfc(Parcel parcel) {
        super(parcel);
        this.f1622d = null;
        this.f1623e = null;
        this.f1621c = (WeighingScaleData[]) parcel.createTypedArray(WeighingScaleData.CREATOR);
        this.f1622d = parcel.readString();
        this.f1623e = parcel.readString();
    }

    protected WScaleUc324Nfc(NfcDynamicTag nfcDynamicTag) {
        super((Type3Tag) nfcDynamicTag);
        this.f1622d = null;
        this.f1623e = null;
    }

    private static WeighingScaleData m1770a(byte[] bArr, int i, int i2) {
        int i3 = ((bArr[i + 8] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 9] & MotionEventCompat.ACTION_MASK) << 0);
        return new WeighingScaleData(m1775b(bArr, i + 1), i2 == 1 ? ((((i3 * 22046) / 10000) + 5) / 10) * 100 : i3 * 10, -1, -1, -1, i2);
    }

    private static String m1771a(String str) {
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

    private static void m1772a(byte[] bArr, int i, Calendar calendar) {
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

    private static boolean m1773a(byte[] bArr, int i) {
        byte b = (byte) 0;
        for (int i2 = 0; i2 < i - 1; i2++) {
            b = (byte) (b + bArr[i2]);
        }
        return b == bArr[i + -1];
    }

    private static String m1774b(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2 && (bArr[i + i3] & MotionEventCompat.ACTION_MASK) >= 32 && (bArr[i + i3] & MotionEventCompat.ACTION_MASK) <= TransportMediator.KEYCODE_MEDIA_PAUSE) {
            i3++;
        }
        return new String(bArr, i, i3);
    }

    private static Calendar m1775b(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(((bArr[i + 0] & MotionEventCompat.ACTION_MASK) * 100) + (bArr[i + 1] & MotionEventCompat.ACTION_MASK), (bArr[i + 2] & MotionEventCompat.ACTION_MASK) - 1, bArr[i + 3] & MotionEventCompat.ACTION_MASK, bArr[i + 4] & MotionEventCompat.ACTION_MASK, bArr[i + 5] & MotionEventCompat.ACTION_MASK, bArr[i + 6] & MotionEventCompat.ACTION_MASK);
        return instance;
    }

    private void m1776b(byte[] bArr) {
        int i = 0;
        byte b = (byte) 0;
        while (i < bArr.length - 1) {
            b = (byte) (b + (bArr[i] & MotionEventCompat.ACTION_MASK));
            i++;
        }
        bArr[bArr.length - 1] = b;
        m1478a(bArr);
    }

    private byte[] m1777c(int i) {
        return m1480a(i);
    }

    public int describeContents() {
        return 0;
    }

    public WeighingScaleData[] m1778e() {
        return this.f1621c;
    }

    public WeighingScaleData[] m1779f() {
        int i;
        int i2;
        C0466a.m1497a("WScaleUc324Nfc", "readScaleData");
        byte[] bArr = new byte[16];
        bArr[0] = (byte) 0;
        bArr[2] = (byte) 6;
        bArr[3] = (byte) 64;
        bArr[4] = (byte) 30;
        bArr[5] = (byte) 0;
        m1772a(bArr, 8, null);
        byte[] bArr2 = new byte[1728];
        for (i = 0; i < 9; i++) {
            m1776b(bArr);
            byte[] c = m1777c(12);
            C0466a.m1497a("WScaleUc324Nfc", C0466a.m1496a(c));
            if (c[0] == -128) {
                throw new C0456c();
            }
            System.arraycopy(c, 0, bArr2, i * 192, 192);
            if (c[176] == 127) {
                i2 = i + 1;
                break;
            }
        }
        i2 = -1;
        if (i2 == -1) {
            throw new C0456c();
        } else if (m1773a(bArr2, i2 * 192)) {
            int i3;
            this.f1622d = m1771a(m1774b(bArr2, 0, 16));
            this.f1623e = m1771a(m1774b(bArr2, 16, 16));
            int i4 = 0;
            i = 0;
            while (i4 < (i2 * 12) - 2 && bArr2[(i4 * 16) + 32] == null) {
                for (i3 = 1; i3 < 8; i3++) {
                    if (bArr2[((i4 * 16) + 32) + i3] != null) {
                        i++;
                        break;
                    }
                }
                i4++;
            }
            i3 = m1467d()[5] == (byte) 1 ? 1 : 0;
            this.f1621c = new WeighingScaleData[i];
            i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                for (i2 = 1; i2 < 8; i2++) {
                    if (bArr2[((i5 * 16) + 32) + i2] != null) {
                        this.f1621c[i4] = m1770a(bArr2, (i5 * 16) + 32, i3);
                        i4++;
                        break;
                    }
                }
            }
            bArr[0] = Byte.MAX_VALUE;
            m1776b(bArr);
            return this.f1621c;
        } else {
            throw new C0456c();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedArray(this.f1621c, i);
        parcel.writeString(this.f1622d);
        parcel.writeString(this.f1623e);
    }
}
