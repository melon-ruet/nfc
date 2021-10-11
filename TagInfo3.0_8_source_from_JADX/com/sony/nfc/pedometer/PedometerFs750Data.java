package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;

public class PedometerFs750Data extends PedometerData implements Parcelable {
    public static final Creator CREATOR;
    private int f1517a;
    private int f1518b;
    private int f1519c;

    static {
        CREATOR = new C0491k();
    }

    protected PedometerFs750Data(Parcel parcel) {
        super(parcel);
        this.f1517a = parcel.readInt();
        this.f1518b = parcel.readInt();
        this.f1519c = parcel.readInt();
    }

    protected PedometerFs750Data(Calendar calendar, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(calendar, i, i2, i3, i4);
        this.f1517a = i5;
        this.f1518b = i6;
        this.f1519c = i7;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f1517a);
        parcel.writeInt(this.f1518b);
        parcel.writeInt(this.f1519c);
    }
}
