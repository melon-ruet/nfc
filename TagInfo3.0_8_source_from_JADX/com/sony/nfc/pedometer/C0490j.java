package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.pedometer.j */
final class C0490j implements Creator {
    C0490j() {
    }

    public PedometerFs750 m1725a(Parcel parcel) {
        return new PedometerFs750(parcel);
    }

    public PedometerFs750[] m1726a(int i) {
        return new PedometerFs750[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1725a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1726a(i);
    }
}
