package com.sony.nfc.wscale;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;

public class WScaleUc411NfcData extends WeighingScaleData implements Parcelable {
    public static final Creator CREATOR;
    private int f1641a;
    private int f1642b;
    private int f1643c;
    private int f1644d;

    static {
        CREATOR = new C0514d();
    }

    protected WScaleUc411NfcData(Parcel parcel) {
        super(parcel);
        this.f1641a = parcel.readInt();
        this.f1642b = parcel.readInt();
        this.f1643c = parcel.readInt();
        this.f1644d = parcel.readInt();
    }

    protected WScaleUc411NfcData(Calendar calendar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        super(calendar, i2, i3, i4, i5);
        this.f1641a = i6;
        this.f1642b = i7;
        this.f1643c = i8;
        this.f1644d = i;
    }

    public int m1797a() {
        return this.f1641a;
    }

    public int m1798b() {
        return this.f1642b;
    }

    public int m1799c() {
        return this.f1643c;
    }

    public int m1800d() {
        return this.f1644d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f1641a);
        parcel.writeInt(this.f1642b);
        parcel.writeInt(this.f1643c);
        parcel.writeInt(this.f1644d);
    }
}
