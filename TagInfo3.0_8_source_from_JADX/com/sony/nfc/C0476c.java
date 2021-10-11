package com.sony.nfc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.c */
final class C0476c implements Creator {
    C0476c() {
    }

    public NfcDynamicTag m1537a(Parcel parcel) {
        return new NfcDynamicTag(parcel);
    }

    public NfcDynamicTag[] m1538a(int i) {
        return new NfcDynamicTag[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1537a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1538a(i);
    }
}
