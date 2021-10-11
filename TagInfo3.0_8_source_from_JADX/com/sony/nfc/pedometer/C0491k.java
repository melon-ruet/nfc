package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.pedometer.k */
final class C0491k implements Creator {
    C0491k() {
    }

    public PedometerFs750Data m1727a(Parcel parcel) {
        return new PedometerFs750Data(parcel);
    }

    public PedometerFs750Data[] m1728a(int i) {
        return new PedometerFs750Data[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1727a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1728a(i);
    }
}
