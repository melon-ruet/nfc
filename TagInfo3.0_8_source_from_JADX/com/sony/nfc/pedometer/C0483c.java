package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.pedometer.c */
final class C0483c implements Creator {
    C0483c() {
    }

    public PedometerEx950 m1711a(Parcel parcel) {
        return new PedometerEx950(parcel);
    }

    public PedometerEx950[] m1712a(int i) {
        return new PedometerEx950[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1711a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1712a(i);
    }
}
