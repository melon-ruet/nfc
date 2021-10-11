package com.sony.nfc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.j */
final class C0480j implements Creator {
    C0480j() {
    }

    public Type3Tag m1545a(Parcel parcel) {
        return new Type3Tag(parcel);
    }

    public Type3Tag[] m1546a(int i) {
        return new Type3Tag[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1545a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1546a(i);
    }
}
