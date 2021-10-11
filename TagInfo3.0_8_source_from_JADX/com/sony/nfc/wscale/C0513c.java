package com.sony.nfc.wscale;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.wscale.c */
final class C0513c implements Creator {
    C0513c() {
    }

    public WScaleUc411Nfc m1805a(Parcel parcel) {
        return new WScaleUc411Nfc(parcel);
    }

    public WScaleUc411Nfc[] m1806a(int i) {
        return new WScaleUc411Nfc[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1805a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1806a(i);
    }
}
