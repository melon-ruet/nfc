package com.sony.nfc.wscale;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;

public class WeighingScaleData implements Parcelable {
    public static final Creator CREATOR;
    private Calendar f1635a;
    private int f1636b;
    private int f1637c;
    private int f1638d;
    private int f1639e;
    private int f1640f;

    static {
        CREATOR = new C0516g();
    }

    protected WeighingScaleData(Parcel parcel) {
        this.f1640f = 0;
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        int readInt5 = parcel.readInt();
        int readInt6 = parcel.readInt();
        this.f1635a = Calendar.getInstance();
        this.f1635a.clear();
        this.f1635a.set(readInt, readInt2, readInt3, readInt4, readInt5, readInt6);
        this.f1636b = parcel.readInt();
        this.f1637c = parcel.readInt();
        this.f1638d = parcel.readInt();
        this.f1639e = parcel.readInt();
        this.f1640f = parcel.readInt();
    }

    protected WeighingScaleData(Calendar calendar, int i, int i2, int i3, int i4) {
        this.f1640f = 0;
        this.f1635a = calendar;
        this.f1636b = i;
        this.f1637c = i2;
        this.f1638d = i3;
        this.f1639e = i4;
    }

    protected WeighingScaleData(Calendar calendar, int i, int i2, int i3, int i4, int i5) {
        this(calendar, i, i2, i3, i4);
        this.f1640f = i5;
    }

    public int describeContents() {
        return 0;
    }

    public Calendar m1791e() {
        return this.f1635a;
    }

    public int m1792f() {
        return this.f1636b;
    }

    public int m1793g() {
        return this.f1637c;
    }

    public int m1794h() {
        return this.f1638d;
    }

    public int m1795i() {
        return this.f1639e;
    }

    public int m1796j() {
        return this.f1640f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1635a.get(1));
        parcel.writeInt(this.f1635a.get(2));
        parcel.writeInt(this.f1635a.get(5));
        parcel.writeInt(this.f1635a.get(11));
        parcel.writeInt(this.f1635a.get(12));
        parcel.writeInt(this.f1635a.get(13));
        parcel.writeInt(this.f1636b);
        parcel.writeInt(this.f1637c);
        parcel.writeInt(this.f1638d);
        parcel.writeInt(this.f1639e);
        parcel.writeInt(this.f1640f);
    }
}
