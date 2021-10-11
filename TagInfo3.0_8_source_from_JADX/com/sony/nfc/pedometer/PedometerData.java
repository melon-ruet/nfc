package com.sony.nfc.pedometer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;

public class PedometerData implements Parcelable {
    public static final Creator CREATOR;
    private Calendar f1477a;
    private int f1478b;
    private int f1479c;
    private int f1480d;
    private int f1481e;

    static {
        CREATOR = new C0482b();
    }

    protected PedometerData(Parcel parcel) {
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        int readInt5 = parcel.readInt();
        int readInt6 = parcel.readInt();
        this.f1477a = Calendar.getInstance();
        this.f1477a.clear();
        this.f1477a.set(readInt, readInt2, readInt3, readInt4, readInt5, readInt6);
        this.f1478b = parcel.readInt();
        this.f1479c = parcel.readInt();
        this.f1480d = parcel.readInt();
        this.f1481e = parcel.readInt();
    }

    protected PedometerData(Calendar calendar, int i, int i2, int i3, int i4) {
        this.f1477a = calendar;
        this.f1478b = i;
        this.f1479c = i2;
        this.f1480d = i3;
        this.f1481e = i4;
    }

    public Calendar m1547a() {
        return this.f1477a;
    }

    public int m1548b() {
        return this.f1478b;
    }

    public int m1549c() {
        return this.f1479c;
    }

    public int m1550d() {
        return this.f1480d;
    }

    public int describeContents() {
        return 0;
    }

    public int m1551e() {
        return this.f1481e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1477a.get(1));
        parcel.writeInt(this.f1477a.get(2));
        parcel.writeInt(this.f1477a.get(5));
        parcel.writeInt(this.f1477a.get(11));
        parcel.writeInt(this.f1477a.get(12));
        parcel.writeInt(this.f1477a.get(13));
        parcel.writeInt(this.f1478b);
        parcel.writeInt(this.f1479c);
        parcel.writeInt(this.f1480d);
        parcel.writeInt(this.f1481e);
    }
}
