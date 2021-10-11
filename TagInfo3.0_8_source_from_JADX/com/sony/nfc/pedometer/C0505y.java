package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.pedometer.y */
final class C0505y implements Creator {
    C0505y() {
    }

    public PedometerUw101NfcData m1755a(Parcel parcel) {
        return new PedometerUw101NfcData(parcel);
    }

    public PedometerUw101NfcData[] m1756a(int i) {
        return new PedometerUw101NfcData[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1755a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1756a(i);
    }
}
