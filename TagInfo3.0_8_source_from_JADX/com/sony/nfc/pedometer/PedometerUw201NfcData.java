package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;

public class PedometerUw201NfcData extends PedometerData implements Parcelable {
    public static final Creator CREATOR;
    private int f1591a;
    private int f1592b;
    private int f1593c;

    static {
        CREATOR = new ab();
    }

    protected PedometerUw201NfcData(Parcel parcel) {
        super(parcel);
        this.f1591a = parcel.readInt();
        this.f1592b = parcel.readInt();
        this.f1593c = parcel.readInt();
    }

    protected PedometerUw201NfcData(Calendar calendar, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(calendar, i, i2, i3, i4);
        this.f1591a = i5;
        this.f1592b = i6;
        this.f1593c = i7;
    }

    public int describeContents() {
        return 0;
    }

    public int m1699f() {
        return this.f1591a;
    }

    public int m1700g() {
        return m1550d();
    }

    public int m1701h() {
        return this.f1592b;
    }

    public int m1702i() {
        return this.f1593c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f1591a);
        parcel.writeInt(this.f1592b);
        parcel.writeInt(this.f1593c);
    }
}
