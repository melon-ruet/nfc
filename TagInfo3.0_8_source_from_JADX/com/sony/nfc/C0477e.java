package com.sony.nfc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.e */
final class C0477e implements Creator {
    C0477e() {
    }

    public NfcTag m1539a(Parcel parcel) {
        return new NfcTag(parcel);
    }

    public NfcTag[] m1540a(int i) {
        return new NfcTag[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1539a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1540a(i);
    }
}
