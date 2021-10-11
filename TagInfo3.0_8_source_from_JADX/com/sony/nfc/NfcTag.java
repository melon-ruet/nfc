package com.sony.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.sony.nfc.p025b.C0466a;

public class NfcTag implements Parcelable {
    public static final Creator CREATOR;
    private byte[] f1438a;
    private C0464i f1439b;

    static {
        CREATOR = new C0477e();
    }

    protected NfcTag(Parcel parcel) {
        this.f1438a = parcel.createByteArray();
    }

    protected NfcTag(NfcTag nfcTag) {
        this.f1439b = nfcTag.f1439b;
        this.f1438a = nfcTag.f1438a;
    }

    protected NfcTag(C0464i c0464i, byte[] bArr) {
        this.f1439b = c0464i;
        this.f1438a = bArr;
    }

    protected C0464i a_() {
        return this.f1439b;
    }

    protected void m1465b() {
        C0466a.m1497a("NfcTag", "callTagDetected");
        if (this.f1439b != null) {
            this.f1439b.m1485a(this);
        }
    }

    protected void m1466c() {
        C0466a.m1497a("NfcTag", "disconnect");
        this.f1439b = null;
    }

    public byte[] m1467d() {
        return this.f1438a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.f1438a);
    }
}
