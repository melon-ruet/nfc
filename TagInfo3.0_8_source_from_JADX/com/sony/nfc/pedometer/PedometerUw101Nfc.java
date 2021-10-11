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

public class PedometerUw101Nfc extends NfcDynamicTag implements Parcelable, C0481a {
    public static final Creator CREATOR;
    protected static final byte[] f1572a;
    protected static final byte[] f1573b;
    private PedometerUw101NfcData[] f1574c;
    private int f1575d;
    private String f1576e;
    private String f1577f;

    static {
        f1572a = new byte[]{(byte) 0, (byte) 19, (byte) 0, (byte) 0, (byte) 1};
        f1573b = new byte[]{(byte) 0, (byte) 19, (byte) 0, (byte) 1, (byte) 1};
        CREATOR = new C0504x();
    }

    protected PedometerUw101Nfc(Parcel parcel) {
        super(parcel);
        this.f1575d = -1;
        this.f1576e = null;
        this.f1577f = null;
        this.f1574c = (PedometerUw101NfcData[]) parcel.createTypedArray(PedometerUw101NfcData.CREATOR);
        this.f1576e = parcel.readString();
        this.f1577f = parcel.readString();
        this.f1575d = parcel.readInt();
    }

    protected PedometerUw101Nfc(NfcDynamicTag nfcDynamicTag) {
        super((Type3Tag) nfcDynamicTag);
        this.f1575d = -1;
        this.f1576e = null;
        this.f1577f = null;
        this.f1575d = m1467d()[5] & MotionEventCompat.ACTION_MASK;
    }

    private static PedometerUw101NfcData m1665a(byte[] bArr, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5 = -1;
        Calendar a = m1668a(bArr, i + 1);
        int i6 = (bArr[i + 10] & MotionEventCompat.ACTION_MASK) | (((bArr[i + 8] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 9] & MotionEventCompat.ACTION_MASK) << 8));
        if (z) {
            i2 = (bArr[i + 13] & MotionEventCompat.ACTION_MASK) | (((bArr[i + 11] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 12] & MotionEventCompat.ACTION_MASK) << 8));
            i3 = (((bArr[i + 14] & MotionEventCompat.ACTION_MASK) << 8) | (bArr[i + 15] & MotionEventCompat.ACTION_MASK)) * 100;
            i4 = ((((bArr[i + 16] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 17] & MotionEventCompat.ACTION_MASK) << 8)) | (bArr[i + 18] & MotionEventCompat.ACTION_MASK)) * 100;
        } else {
            i4 = ((((bArr[i + 14] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 15] & MotionEventCompat.ACTION_MASK) << 8)) | (bArr[i + 16] & MotionEventCompat.ACTION_MASK)) * 100;
            i3 = -1;
            i2 = -1;
            i5 = ((((bArr[i + 11] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[i + 12] & MotionEventCompat.ACTION_MASK) << 8)) | (bArr[i + 13] & MotionEventCompat.ACTION_MASK)) * 10;
        }
        return new PedometerUw101NfcData(a, i6, i2, i4, i3, i5);
    }

    private static String m1666a(String str) {
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

    private static String m1667a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2 && (bArr[i + i3] & MotionEventCompat.ACTION_MASK) >= 32 && (bArr[i + i3] & MotionEventCompat.ACTION_MASK) <= TransportMediator.KEYCODE_MEDIA_PAUSE) {
            i3++;
        }
        return new String(bArr, i, i3);
    }

    private static Calendar m1668a(byte[] bArr, int i) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(((bArr[i + 0] & MotionEventCompat.ACTION_MASK) * 100) + (bArr[i + 1] & MotionEventCompat.ACTION_MASK), (bArr[i + 2] & MotionEventCompat.ACTION_MASK) - 1, bArr[i + 3] & MotionEventCompat.ACTION_MASK, bArr[i + 4] & MotionEventCompat.ACTION_MASK, bArr[i + 5] & MotionEventCompat.ACTION_MASK, bArr[i + 6] & MotionEventCompat.ACTION_MASK);
        return instance;
    }

    private static void m1669a(byte[] bArr, int i, Calendar calendar) {
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

    private void m1670b(byte[] bArr) {
        int i = 0;
        byte b = (byte) 0;
        while (i < bArr.length - 1) {
            b = (byte) (b + (bArr[i] & MotionEventCompat.ACTION_MASK));
            i++;
        }
        bArr[bArr.length - 1] = b;
        m1478a(bArr);
    }

    private static boolean m1671c(byte[] bArr) {
        byte b = (byte) 0;
        for (int i = 0; i < bArr.length - 1; i++) {
            b = (byte) (b + bArr[i]);
        }
        return b == bArr[bArr.length + -1];
    }

    private byte[] m1672c(int i) {
        return m1480a(i);
    }

    public PedometerData[] m1673a() {
        return this.f1574c;
    }

    public int describeContents() {
        return 0;
    }

    public PedometerData[] m1674e() {
        int i = 0;
        C0466a.m1497a("PedometerUw101Nfc", "readStepData");
        boolean z = m1467d()[7] == (byte) 16;
        int i2 = m1467d()[5] == (byte) 1 ? 1 : 0;
        byte[] bArr = new byte[16];
        bArr[0] = (byte) 0;
        bArr[1] = (byte) this.f1575d;
        bArr[2] = (byte) -1;
        bArr[3] = (byte) -1;
        if (i2 != 0) {
            bArr[4] = (byte) 50;
            bArr[5] = (byte) -56;
            bArr[6] = (byte) 0;
            bArr[7] = (byte) -56;
        } else {
            bArr[4] = (byte) 23;
            bArr[5] = (byte) 112;
            bArr[6] = (byte) 0;
            bArr[7] = (byte) -86;
        }
        m1669a(bArr, 8, null);
        byte[] bArr2 = new byte[576];
        for (int i3 = 0; i3 < 3; i3++) {
            m1670b(bArr);
            byte[] c = m1672c(12);
            C0466a.m1497a("PedometerUw101Nfc", C0466a.m1496a(c));
            if (c[0] == -128) {
                throw new C0456c();
            }
            System.arraycopy(c, 0, bArr2, i3 * 192, 192);
        }
        if (bArr2[560] != 127) {
            throw new C0456c();
        } else if (m1671c(bArr2)) {
            this.f1576e = m1666a(m1667a(bArr2, 0, 16));
            C0466a.m1497a("PedometerUw101Nfc", "ID:" + this.f1576e);
            this.f1577f = m1666a(m1667a(bArr2, 16, 16));
            C0466a.m1497a("PedometerUw101Nfc", "Product:" + this.f1577f);
            this.f1574c = new PedometerUw101NfcData[15];
            while (i < this.f1574c.length) {
                this.f1574c[i] = m1665a(bArr2, (i * 32) + 32, z);
                i++;
            }
            return this.f1574c;
        } else {
            throw new C0456c();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedArray(this.f1574c, i);
        parcel.writeString(this.f1576e);
        parcel.writeString(this.f1577f);
        parcel.writeInt(this.f1575d);
    }
}
