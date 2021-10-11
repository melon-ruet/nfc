package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class aa implements Creator {
    aa() {
    }

    public PedometerUw201Nfc m1703a(Parcel parcel) {
        return new PedometerUw201Nfc(parcel);
    }

    public PedometerUw201Nfc[] m1704a(int i) {
        return new PedometerUw201Nfc[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1703a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1704a(i);
    }
}
