package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;

public class PedometerMtn200Data extends PedometerData implements Parcelable {
    public static final Creator CREATOR;
    private int f1555a;
    private int f1556b;

    static {
        CREATOR = new C0499s();
    }

    protected PedometerMtn200Data(Parcel parcel) {
        super(parcel);
        this.f1555a = parcel.readInt();
        this.f1556b = parcel.readInt();
    }

    protected PedometerMtn200Data(Calendar calendar, int i, int i2, int i3, int i4, int i5, int i6) {
        super(calendar, i, i2, i3, i4);
        this.f1555a = i5;
        this.f1556b = i6;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f1555a);
        parcel.writeInt(this.f1556b);
    }
}
