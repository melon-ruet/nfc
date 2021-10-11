package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.pedometer.o */
final class C0495o implements Creator {
    C0495o() {
    }

    public PedometerMi700 m1735a(Parcel parcel) {
        return new PedometerMi700(parcel);
    }

    public PedometerMi700[] m1736a(int i) {
        return new PedometerMi700[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1735a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1736a(i);
    }
}
