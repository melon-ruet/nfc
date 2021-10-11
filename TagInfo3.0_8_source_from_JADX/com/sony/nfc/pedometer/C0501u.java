package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.pedometer.u */
final class C0501u implements Creator {
    C0501u() {
    }

    public PedometerMtn210 m1747a(Parcel parcel) {
        return new PedometerMtn210(parcel);
    }

    public PedometerMtn210[] m1748a(int i) {
        return new PedometerMtn210[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1747a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1748a(i);
    }
}
