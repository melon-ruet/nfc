package com.sony.nfc.thermometer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;

public class ThermometerData implements Parcelable {
    public static final Creator CREATOR;
    private Calendar f1614a;
    private int f1615b;
    private int f1616c;
    private int f1617d;
    private int f1618e;

    static {
        CREATOR = new C0509b();
    }

    protected ThermometerData(Parcel parcel) {
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        int readInt5 = parcel.readInt();
        int readInt6 = parcel.readInt();
        this.f1614a = Calendar.getInstance();
        this.f1614a.clear();
        this.f1614a.set(readInt, readInt2, readInt3, readInt4, readInt5, readInt6);
        this.f1615b = parcel.readInt();
        this.f1616c = parcel.readInt();
        this.f1617d = parcel.readInt();
        this.f1618e = parcel.readInt();
    }

    public Calendar m1761a() {
        return this.f1614a;
    }

    public int m1762b() {
        return this.f1615b;
    }

    public int m1763c() {
        return this.f1616c;
    }

    public int m1764d() {
        return this.f1617d;
    }

    public int describeContents() {
        return 0;
    }

    public int m1765e() {
        return this.f1618e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1614a.get(1));
        parcel.writeInt(this.f1614a.get(2));
        parcel.writeInt(this.f1614a.get(5));
        parcel.writeInt(this.f1614a.get(11));
        parcel.writeInt(this.f1614a.get(12));
        parcel.writeInt(this.f1614a.get(13));
        parcel.writeInt(this.f1615b);
        parcel.writeInt(this.f1616c);
        parcel.writeInt(this.f1617d);
        parcel.writeInt(this.f1618e);
    }
}
