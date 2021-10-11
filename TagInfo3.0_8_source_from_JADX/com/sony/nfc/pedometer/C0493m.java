package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.pedometer.m */
final class C0493m implements Creator {
    C0493m() {
    }

    public PedometerJp700 m1731a(Parcel parcel) {
        return new PedometerJp700(parcel);
    }

    public PedometerJp700[] m1732a(int i) {
        return new PedometerJp700[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1731a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1732a(i);
    }
}
