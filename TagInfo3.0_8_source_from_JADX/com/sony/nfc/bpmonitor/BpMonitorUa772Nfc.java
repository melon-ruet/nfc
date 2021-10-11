package com.sony.nfc.bpmonitor;

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

public class BpMonitorUa772Nfc extends NfcDynamicTag implements Parcelable, C0468b {
    public static final Creator CREATOR;
    protected static final byte[] f1467a;
    private BpMonitorUa772NfcData[] f1468b;
    private String f1469c;
    private String f1470d;

    static {
        f1467a = new byte[]{(byte) 0, (byte) 19, (byte) 32, (byte) 0, (byte) 1};
        CREATOR = new C0470c();
    }

    protected BpMonitorUa772Nfc(Parcel parcel) {
        super(parcel);
        this.f1468b = (BpMonitorUa772NfcData[]) parcel.createTypedArray(BpMonitorUa772NfcData.CREATOR);
        this.f1469c = parcel.readString();
        this.f1470d = parcel.readString();
    }

    protected BpMonitorUa772Nfc(NfcDynamicTag nfcDynamicTag) {
        super((Type3Tag) nfcDynamicTag);
    }

    private static BpMonitorUa772NfcData m1507a(byte[] bArr, int i) {
        int i2 = 1;
        Calendar c = m1513c(bArr, i + 1);
        int i3 = ((bArr[i + 8] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 9] & MotionEventCompat.ACTION_MASK) << 0);
        int i4 = bArr[i + 10] & MotionEventCompat.ACTION_MASK;
        int i5 = bArr[i + 11] & MotionEventCompat.ACTION_MASK;
        int i6 = bArr[i + 12] & MotionEventCompat.ACTION_MASK;
        int i7 = bArr[i + 13] & MotionEventCompat.ACTION_MASK;
        if (i7 != 1) {
            i2 = i7 == 2 ? 2 : i7 == 3 ? 4 : i7 == 4 ? 3 : i7 == 5 ? 5 : 0;
        }
        return new BpMonitorUa772NfcData(c, i3, i4, i5, i6, i2);
    }

    private static String m1508a(String str) {
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

    private static String m1509a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2 && (bArr[i + i3] & MotionEventCompat.ACTION_MASK) >= 32 && (bArr[i + i3] & MotionEventCompat.ACTION_MASK) <= TransportMediator.KEYCODE_MEDIA_PAUSE) {
            i3++;
        }
        return new String(bArr, i, i3);
    }

    private static void m1510a(byte[] bArr, int i, Calendar calendar) {
        bArr[i + 0] = (byte) (calendar.get(1) / 100);
        bArr[i + 1] = (byte) (calendar.get(1) % 100);
        bArr[i + 2] = (byte) (calendar.get(2) + 1);
        bArr[i + 3] = (byte) calendar.get(5);
        bArr[i + 4] = (byte) calendar.get(11);
        bArr[i + 5] = (byte) calendar.get(12);
        bArr[i + 6] = (byte) calendar.get(13);
    }

    private void m1511b(byte[] bArr) {
        int i = 0;
        byte b = (byte) 0;
        while (i < bArr.length - 1) {
            b = (byte) (b + (bArr[i] & MotionEventCompat.ACTION_MASK));
            i++;
        }
        bArr[bArr.length - 1] = b;
        m1478a(bArr);
    }

    private static boolean m1512b(byte[] bArr, int i) {
        byte b = (byte) 0;
        for (int i2 = 0; i2 < i - 1; i2++) {
            b = (byte) (b + bArr[i2]);
        }
        return b == bArr[i + -1];
    }

    private static Calendar m1513c(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(((bArr[i + 0] & MotionEventCompat.ACTION_MASK) * 100) + (bArr[i + 1] & MotionEventCompat.ACTION_MASK), (bArr[i + 2] & MotionEventCompat.ACTION_MASK) - 1, bArr[i + 3] & MotionEventCompat.ACTION_MASK, bArr[i + 4] & MotionEventCompat.ACTION_MASK, bArr[i + 5] & MotionEventCompat.ACTION_MASK, bArr[i + 6] & MotionEventCompat.ACTION_MASK);
        return instance;
    }

    private byte[] m1514c(int i) {
        return m1480a(i);
    }

    public BloodPressureData[] m1515a() {
        return this.f1468b;
    }

    public int describeContents() {
        return 0;
    }

    public BloodPressureData[] m1516e() {
        int i = 2;
        int i2 = 0;
        C0466a.m1497a("BpMonitorUa772Nfc", "readBloodPressureData");
        byte[] bArr = new byte[16];
        bArr[0] = (byte) 0;
        bArr[2] = (byte) 7;
        bArr[3] = (byte) 7;
        bArr[4] = (byte) 32;
        bArr[5] = (byte) 0;
        bArr[6] = (byte) 3;
        bArr[7] = (byte) 3;
        m1510a(bArr, 8, Calendar.getInstance());
        byte[] bArr2 = new byte[1728];
        int i3 = 0;
        while (i3 < 9) {
            m1511b(bArr);
            byte[] c = m1514c(12);
            C0466a.m1497a("BpMonitorUa772Nfc", C0466a.m1496a(c));
            System.arraycopy(c, 0, bArr2, i3 * 192, 192);
            if (c[0] == -128) {
                throw new C0456c();
            } else if (c[176] == 127) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 == 9) {
            throw new C0456c();
        }
        int i4 = i3 + 1;
        if (m1512b(bArr2, i4 * 192)) {
            bArr[0] = Byte.MAX_VALUE;
            m1511b(bArr);
            this.f1469c = m1508a(m1509a(bArr2, 0, 16));
            this.f1470d = m1508a(m1509a(bArr2, 16, 16));
            i3 = 0;
            while (i < i4 * 12 && bArr2[i * 16] == null) {
                i3++;
                i++;
            }
            this.f1468b = new BpMonitorUa772NfcData[i3];
            while (i2 < i3) {
                this.f1468b[i2] = m1507a(bArr2, (i2 * 16) + 32);
                i2++;
            }
            return this.f1468b;
        }
        throw new C0456c();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedArray(this.f1468b, i);
        parcel.writeString(this.f1469c);
        parcel.writeString(this.f1470d);
    }
}
