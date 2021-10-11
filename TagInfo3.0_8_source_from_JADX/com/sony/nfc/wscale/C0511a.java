package com.sony.nfc.wscale;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.wscale.a */
final class C0511a implements Creator {
    C0511a() {
    }

    public WScaleUc324Nfc m1801a(Parcel parcel) {
        return new WScaleUc324Nfc(parcel);
    }

    public WScaleUc324Nfc[] m1802a(int i) {
        return new WScaleUc324Nfc[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1801a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1802a(i);
    }
}
