package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.pedometer.g */
final class C0487g implements Creator {
    C0487g() {
    }

    public PedometerFs700 m1719a(Parcel parcel) {
        return new PedometerFs700(parcel);
    }

    public PedometerFs700[] m1720a(int i) {
        return new PedometerFs700[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1719a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1720a(i);
    }
}
