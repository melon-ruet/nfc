package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.pedometer.x */
final class C0504x implements Creator {
    C0504x() {
    }

    public PedometerUw101Nfc m1753a(Parcel parcel) {
        return new PedometerUw101Nfc(parcel);
    }

    public PedometerUw101Nfc[] m1754a(int i) {
        return new PedometerUw101Nfc[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1753a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1754a(i);
    }
}
