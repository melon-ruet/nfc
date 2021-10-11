package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.pedometer.v */
final class C0502v implements Creator {
    C0502v() {
    }

    public PedometerMtn210Data m1749a(Parcel parcel) {
        return new PedometerMtn210Data(parcel);
    }

    public PedometerMtn210Data[] m1750a(int i) {
        return new PedometerMtn210Data[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1749a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1750a(i);
    }
}
