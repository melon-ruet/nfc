package com.sony.nfc.bpmonitor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;

public class BloodPressureData implements Parcelable {
    public static final Creator CREATOR;
    private Calendar f1462a;
    private int f1463b;
    private int f1464c;
    private int f1465d;
    private int f1466e;

    static {
        CREATOR = new C0469a();
    }

    protected BloodPressureData(Parcel parcel) {
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        int readInt5 = parcel.readInt();
        int readInt6 = parcel.readInt();
        this.f1462a = Calendar.getInstance();
        this.f1462a.clear();
        this.f1462a.set(readInt, readInt2, readInt3, readInt4, readInt5, readInt6);
        this.f1463b = parcel.readInt();
        this.f1464c = parcel.readInt();
        this.f1465d = parcel.readInt();
        this.f1466e = parcel.readInt();
    }

    protected BloodPressureData(Calendar calendar, int i, int i2, int i3, int i4) {
        this.f1462a = calendar;
        this.f1463b = i;
        this.f1464c = i2;
        this.f1465d = i3;
        this.f1466e = i4;
    }

    public Calendar m1501a() {
        return this.f1462a;
    }

    public int m1502b() {
        return this.f1463b;
    }

    public int m1503c() {
        return this.f1464c;
    }

    public int m1504d() {
        return this.f1465d;
    }

    public int describeContents() {
        return 0;
    }

    public int m1505e() {
        return this.f1466e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1462a.get(1));
        parcel.writeInt(this.f1462a.get(2));
        parcel.writeInt(this.f1462a.get(5));
        parcel.writeInt(this.f1462a.get(11));
        parcel.writeInt(this.f1462a.get(12));
        parcel.writeInt(this.f1462a.get(13));
        parcel.writeInt(this.f1463b);
        parcel.writeInt(this.f1464c);
        parcel.writeInt(this.f1465d);
        parcel.writeInt(this.f1466e);
    }
}
