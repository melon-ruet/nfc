package com.sony.nfc.thermometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.thermometer.b */
final class C0509b implements Creator {
    C0509b() {
    }

    public ThermometerData m1767a(Parcel parcel) {
        return new ThermometerData(parcel);
    }

    public ThermometerData[] m1768a(int i) {
        return new ThermometerData[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1767a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1768a(i);
    }
}
