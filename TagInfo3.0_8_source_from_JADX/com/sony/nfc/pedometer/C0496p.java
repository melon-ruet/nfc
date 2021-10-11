package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.pedometer.p */
final class C0496p implements Creator {
    C0496p() {
    }

    public PedometerMi700Data m1737a(Parcel parcel) {
        return new PedometerMi700Data(parcel);
    }

    public PedometerMi700Data[] m1738a(int i) {
        return new PedometerMi700Data[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1737a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1738a(i);
    }
}
