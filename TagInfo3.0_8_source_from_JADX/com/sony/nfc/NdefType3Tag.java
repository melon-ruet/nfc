package com.sony.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class NdefType3Tag extends Type3Tag implements Parcelable {
    public static final Creator CREATOR;
    private byte[] f1442a;

    static {
        CREATOR = new C0467b();
    }

    protected NdefType3Tag(Parcel parcel) {
        super(parcel);
        this.f1442a = parcel.createByteArray();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByteArray(this.f1442a);
    }
}
