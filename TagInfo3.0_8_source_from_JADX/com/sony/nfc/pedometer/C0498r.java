package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.pedometer.r */
final class C0498r implements Creator {
    C0498r() {
    }

    public PedometerMtn200 m1741a(Parcel parcel) {
        return new PedometerMtn200(parcel);
    }

    public PedometerMtn200[] m1742a(int i) {
        return new PedometerMtn200[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1741a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1742a(i);
    }
}
