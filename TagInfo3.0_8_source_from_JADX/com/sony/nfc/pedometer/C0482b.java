package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.pedometer.b */
final class C0482b implements Creator {
    C0482b() {
    }

    public PedometerData m1709a(Parcel parcel) {
        return new PedometerData(parcel);
    }

    public PedometerData[] m1710a(int i) {
        return new PedometerData[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1709a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1710a(i);
    }
}
