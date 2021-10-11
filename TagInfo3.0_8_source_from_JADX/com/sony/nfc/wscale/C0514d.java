package com.sony.nfc.wscale;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.wscale.d */
final class C0514d implements Creator {
    C0514d() {
    }

    public WScaleUc411NfcData m1807a(Parcel parcel) {
        return new WScaleUc411NfcData(parcel);
    }

    public WScaleUc411NfcData[] m1808a(int i) {
        return new WScaleUc411NfcData[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1807a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1808a(i);
    }
}
