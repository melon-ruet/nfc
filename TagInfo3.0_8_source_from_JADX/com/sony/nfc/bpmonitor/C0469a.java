package com.sony.nfc.bpmonitor;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.bpmonitor.a */
final class C0469a implements Creator {
    C0469a() {
    }

    public BloodPressureData m1518a(Parcel parcel) {
        return new BloodPressureData(parcel);
    }

    public BloodPressureData[] m1519a(int i) {
        return new BloodPressureData[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1518a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1519a(i);
    }
}
