package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.pedometer.s */
final class C0499s implements Creator {
    C0499s() {
    }

    public PedometerMtn200Data m1743a(Parcel parcel) {
        return new PedometerMtn200Data(parcel);
    }

    public PedometerMtn200Data[] m1744a(int i) {
        return new PedometerMtn200Data[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1743a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1744a(i);
    }
}
