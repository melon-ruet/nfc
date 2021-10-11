package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;

public class PedometerMtn210Data extends PedometerData implements Parcelable {
    public static final Creator CREATOR;
    private int f1570a;
    private int f1571b;

    static {
        CREATOR = new C0502v();
    }

    protected PedometerMtn210Data(Parcel parcel) {
        super(parcel);
        this.f1570a = parcel.readInt();
        this.f1571b = parcel.readInt();
    }

    protected PedometerMtn210Data(Calendar calendar, int i, int i2, int i3, int i4, int i5) {
        super(calendar, i, i2, i3, -1);
        this.f1570a = i4;
        this.f1571b = i5;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f1570a);
        parcel.writeInt(this.f1571b);
    }
}
