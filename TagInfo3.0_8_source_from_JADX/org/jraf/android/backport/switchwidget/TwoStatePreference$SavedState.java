package org.jraf.android.backport.switchwidget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.preference.Preference.BaseSavedState;

class TwoStatePreference$SavedState extends BaseSavedState {
    public static final Creator CREATOR;
    boolean f1680a;

    static {
        CREATOR = new C0520d();
    }

    public TwoStatePreference$SavedState(Parcel parcel) {
        boolean z = true;
        super(parcel);
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.a = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.a ? 1 : 0);
    }
}
