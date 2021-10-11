package com.sony.nfc.pulseoximeter;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;

public class PulseOximeterData implements Parcelable {
    public static final Creator CREATOR;
    private Calendar f1611a;
    private int f1612b;
    private int f1613c;

    static {
        CREATOR = new C0507a();
    }

    protected PulseOximeterData(Parcel parcel) {
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        int readInt5 = parcel.readInt();
        int readInt6 = parcel.readInt();
        this.f1611a = Calendar.getInstance();
        this.f1611a.clear();
        this.f1611a.set(readInt, readInt2, readInt3, readInt4, readInt5, readInt6);
        this.f1612b = parcel.readInt();
        this.f1613c = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1611a.get(1));
        parcel.writeInt(this.f1611a.get(2));
        parcel.writeInt(this.f1611a.get(5));
        parcel.writeInt(this.f1611a.get(11));
        parcel.writeInt(this.f1611a.get(12));
        parcel.writeInt(this.f1611a.get(13));
        parcel.writeInt(this.f1612b);
        parcel.writeInt(this.f1613c);
    }
}
