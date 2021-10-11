package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;

public class PedometerFs700Data extends PedometerData implements Parcelable {
    public static final Creator CREATOR;
    private int f1506a;
    private int f1507b;
    private int f1508c;

    static {
        CREATOR = new C0488h();
    }

    protected PedometerFs700Data(Parcel parcel) {
        super(parcel);
        this.f1506a = parcel.readInt();
        this.f1507b = parcel.readInt();
        this.f1508c = parcel.readInt();
    }

    protected PedometerFs700Data(Calendar calendar, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(calendar, i, i2, i3, i4);
        this.f1506a = i5;
        this.f1507b = i6;
        this.f1508c = i7;
    }

    public int describeContents() {
        return 0;
    }

    public int m1595f() {
        return this.f1506a;
    }

    public int m1596g() {
        return m1550d();
    }

    public int m1597h() {
        return this.f1507b;
    }

    public int m1598i() {
        return this.f1508c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f1506a);
        parcel.writeInt(this.f1507b);
        parcel.writeInt(this.f1508c);
    }
}
