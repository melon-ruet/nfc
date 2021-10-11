package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;

public class PedometerMi700Data extends PedometerData implements Parcelable {
    public static final Creator CREATOR;
    private int f1540a;
    private int f1541b;
    private int f1542c;

    static {
        CREATOR = new C0496p();
    }

    protected PedometerMi700Data(Parcel parcel) {
        super(parcel);
        this.f1540a = parcel.readInt();
        this.f1541b = parcel.readInt();
        this.f1542c = parcel.readInt();
    }

    protected PedometerMi700Data(Calendar calendar, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(calendar, i, i2, i3, i4);
        this.f1540a = i5;
        this.f1541b = i6;
        this.f1542c = i7;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f1540a);
        parcel.writeInt(this.f1541b);
        parcel.writeInt(this.f1542c);
    }
}
