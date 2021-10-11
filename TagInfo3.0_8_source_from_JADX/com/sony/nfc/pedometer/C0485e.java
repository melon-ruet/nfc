package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.pedometer.e */
final class C0485e implements Creator {
    C0485e() {
    }

    public PedometerFs500A m1715a(Parcel parcel) {
        return new PedometerFs500A(parcel);
    }

    public PedometerFs500A[] m1716a(int i) {
        return new PedometerFs500A[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1715a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1716a(i);
    }
}
