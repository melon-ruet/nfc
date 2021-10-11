package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;

public class PedometerUw101NfcData extends PedometerData implements Parcelable {
    public static final Creator CREATOR;
    private int f1578a;

    static {
        CREATOR = new C0505y();
    }

    protected PedometerUw101NfcData(Parcel parcel) {
        super(parcel);
        this.f1578a = parcel.readInt();
    }

    protected PedometerUw101NfcData(Calendar calendar, int i, int i2, int i3, int i4, int i5) {
        super(calendar, i, i2, i3, i4);
        this.f1578a = i5;
    }

    public int describeContents() {
        return 0;
    }

    public int m1675f() {
        return this.f1578a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f1578a);
    }
}
