package com.sony.nfc.pulseoximeter;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.pulseoximeter.a */
final class C0507a implements Creator {
    C0507a() {
    }

    public PulseOximeterData m1759a(Parcel parcel) {
        return new PulseOximeterData(parcel);
    }

    public PulseOximeterData[] m1760a(int i) {
        return new PulseOximeterData[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1759a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1760a(i);
    }
}
