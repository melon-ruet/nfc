package com.sony.nfc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.b */
final class C0467b implements Creator {
    C0467b() {
    }

    public NdefType3Tag m1499a(Parcel parcel) {
        return new NdefType3Tag(parcel);
    }

    public NdefType3Tag[] m1500a(int i) {
        return new NdefType3Tag[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1499a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1500a(i);
    }
}
