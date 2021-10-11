package org.jraf.android.backport.switchwidget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: org.jraf.android.backport.switchwidget.d */
final class C0520d implements Creator {
    C0520d() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new TwoStatePreference$SavedState(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new TwoStatePreference$SavedState[i];
    }
}
