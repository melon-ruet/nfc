package com.sony.nfc.glucosemeter;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.glucosemeter.a */
final class C0479a implements Creator {
    C0479a() {
    }

    public GlucoseData m1543a(Parcel parcel) {
        return new GlucoseData(parcel);
    }

    public GlucoseData[] m1544a(int i) {
        return new GlucoseData[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1543a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1544a(i);
    }
}
