package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.pedometer.h */
final class C0488h implements Creator {
    C0488h() {
    }

    public PedometerFs700Data m1721a(Parcel parcel) {
        return new PedometerFs700Data(parcel);
    }

    public PedometerFs700Data[] m1722a(int i) {
        return new PedometerFs700Data[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1721a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1722a(i);
    }
}
