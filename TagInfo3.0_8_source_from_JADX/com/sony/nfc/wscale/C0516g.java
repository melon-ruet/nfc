package com.sony.nfc.wscale;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.wscale.g */
final class C0516g implements Creator {
    C0516g() {
    }

    public WeighingScaleData m1811a(Parcel parcel) {
        return new WeighingScaleData(parcel);
    }

    public WeighingScaleData[] m1812a(int i) {
        return new WeighingScaleData[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1811a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1812a(i);
    }
}
