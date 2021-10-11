package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ab implements Creator {
    ab() {
    }

    public PedometerUw201NfcData m1705a(Parcel parcel) {
        return new PedometerUw201NfcData(parcel);
    }

    public PedometerUw201NfcData[] m1706a(int i) {
        return new PedometerUw201NfcData[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1705a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1706a(i);
    }
}
