package com.nxp.taginfolite.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.nxp.taginfolite.data.a */
final class C0207a implements Creator {
    C0207a() {
    }

    public AuthKey m278a(Parcel parcel) {
        return new AuthKey(null);
    }

    public AuthKey[] m279a(int i) {
        return new AuthKey[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m278a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m279a(i);
    }
}
