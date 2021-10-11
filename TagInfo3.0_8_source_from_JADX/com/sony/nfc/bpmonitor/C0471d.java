package com.sony.nfc.bpmonitor;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.bpmonitor.d */
final class C0471d implements Creator {
    C0471d() {
    }

    public BpMonitorUa772NfcData m1522a(Parcel parcel) {
        return new BpMonitorUa772NfcData(parcel);
    }

    public BpMonitorUa772NfcData[] m1523a(int i) {
        return new BpMonitorUa772NfcData[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1522a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1523a(i);
    }
}
