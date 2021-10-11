package com.sony.nfc.glucosemeter;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;

public class GlucoseData implements Parcelable {
    public static final Creator CREATOR;
    private Calendar f1473a;
    private int f1474b;
    private int f1475c;
    private int f1476d;

    static {
        CREATOR = new C0479a();
    }

    protected GlucoseData(Parcel parcel) {
        this.f1475c = 0;
        this.f1476d = 0;
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        int readInt5 = parcel.readInt();
        int readInt6 = parcel.readInt();
        this.f1473a = Calendar.getInstance();
        this.f1473a.clear();
        this.f1473a.set(readInt, readInt2, readInt3, readInt4, readInt5, readInt6);
        this.f1474b = parcel.readInt();
        this.f1475c = parcel.readInt();
        this.f1476d = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1473a.get(1));
        parcel.writeInt(this.f1473a.get(2));
        parcel.writeInt(this.f1473a.get(5));
        parcel.writeInt(this.f1473a.get(11));
        parcel.writeInt(this.f1473a.get(12));
        parcel.writeInt(this.f1473a.get(13));
        parcel.writeInt(this.f1474b);
        parcel.writeInt(this.f1475c);
        parcel.writeInt(this.f1476d);
    }
}
