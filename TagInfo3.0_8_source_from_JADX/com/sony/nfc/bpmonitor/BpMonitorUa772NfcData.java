package com.sony.nfc.bpmonitor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;

public class BpMonitorUa772NfcData extends BloodPressureData implements Parcelable {
    public static final Creator CREATOR;
    private int f1471a;

    static {
        CREATOR = new C0471d();
    }

    protected BpMonitorUa772NfcData(Parcel parcel) {
        super(parcel);
        this.f1471a = parcel.readInt();
    }

    protected BpMonitorUa772NfcData(Calendar calendar, int i, int i2, int i3, int i4, int i5) {
        super(calendar, i, i2, i3, i4);
        this.f1471a = i5;
    }

    public int describeContents() {
        return 0;
    }

    public int m1517f() {
        return this.f1471a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f1471a);
    }
}
