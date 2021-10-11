package com.sony.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.sony.nfc.p024a.C0457d;
import com.sony.nfc.p025b.C0466a;

public class NfcDynamicTag extends Type3Tag implements Parcelable {
    public static final Creator CREATOR;

    static {
        CREATOR = new C0476c();
    }

    protected NfcDynamicTag(Parcel parcel) {
        super(parcel);
    }

    protected NfcDynamicTag(Type3Tag type3Tag) {
        super(type3Tag);
    }

    private static int[] m1477c(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = i2;
        }
        return iArr;
    }

    public void m1478a(byte[] bArr) {
        m1479a(m1477c(bArr.length / 16), bArr);
    }

    public void m1479a(int[] iArr, byte[] bArr) {
        C0466a.m1497a("NfcDynamicTag", "write");
        if (iArr.length > 12) {
            throw new C0457d();
        }
        m1471a(9, iArr, bArr);
    }

    public byte[] m1480a(int i) {
        return m1481a(m1477c(i));
    }

    public byte[] m1481a(int[] iArr) {
        C0466a.m1497a("NfcDynamicTag", "read");
        if (iArr.length <= 12) {
            return m1473a(11, iArr);
        }
        throw new C0457d();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
