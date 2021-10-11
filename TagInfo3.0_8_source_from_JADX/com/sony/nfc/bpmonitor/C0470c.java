package com.sony.nfc.bpmonitor;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.sony.nfc.bpmonitor.c */
final class C0470c implements Creator {
    C0470c() {
    }

    public BpMonitorUa772Nfc m1520a(Parcel parcel) {
        return new BpMonitorUa772Nfc(parcel);
    }

    public BpMonitorUa772Nfc[] m1521a(int i) {
        return new BpMonitorUa772Nfc[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1520a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1521a(i);
    }
}
