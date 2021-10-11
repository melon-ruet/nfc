package com.nxp.taginfolite.data;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.Arrays;

public class AuthKey implements Parcelable {
    public static final Creator CREATOR;
    private final String f215a;
    private final boolean f216b;
    private final String f217c;
    private final String f218d;
    private final String f219e;
    private final String f220f;
    private final String f221g;
    private final String f222h;
    private final String f223i;
    private final byte[] f224j;

    static {
        CREATOR = new C0207a();
    }

    private AuthKey(Parcel parcel) {
        boolean z = true;
        this.f215a = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f216b = z;
        this.f217c = parcel.readString();
        this.f218d = parcel.readString();
        this.f219e = parcel.readString();
        this.f220f = parcel.readString();
        this.f221g = parcel.readString();
        this.f222h = parcel.readString();
        this.f223i = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt >= 0) {
            this.f224j = new byte[readInt];
            parcel.readByteArray(this.f224j);
            return;
        }
        this.f224j = null;
    }

    public AuthKey(String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7, String str8, byte[] bArr) {
        this.f215a = str;
        this.f216b = z;
        this.f217c = str2;
        this.f218d = str3;
        this.f219e = str4;
        this.f220f = str5;
        this.f221g = str6;
        this.f222h = str7;
        this.f223i = str8;
        if (bArr != null) {
            this.f224j = Arrays.copyOf(bArr, bArr.length);
        } else {
            this.f224j = null;
        }
    }

    public static AuthKey m265a(Cursor cursor) {
        boolean z = true;
        String string = cursor.getString(cursor.getColumnIndex("title"));
        if (1 != cursor.getInt(cursor.getColumnIndex("enabled"))) {
            z = false;
        }
        return new AuthKey(string, z, cursor.getString(cursor.getColumnIndex("chip")), cursor.getString(cursor.getColumnIndex("chip_var")), cursor.getString(cursor.getColumnIndex("selector_type")), cursor.getString(cursor.getColumnIndex("selector_value")), cursor.getString(cursor.getColumnIndex("subselector")), cursor.getString(cursor.getColumnIndex("subselector_value")), cursor.getString(cursor.getColumnIndex("key_type")), cursor.getBlob(cursor.getColumnIndex("key_value")));
    }

    public String m266a() {
        return this.f215a;
    }

    public boolean m267a(AuthKey authKey) {
        return authKey != null && TextUtils.equals(this.f215a, authKey.f215a) && TextUtils.equals(this.f217c, authKey.f217c) && TextUtils.equals(this.f218d, authKey.f218d) && TextUtils.equals(this.f219e, authKey.f219e) && TextUtils.equals(this.f220f, authKey.f220f) && TextUtils.equals(this.f221g, authKey.f221g) && TextUtils.equals(this.f222h, authKey.f222h) && TextUtils.equals(this.f222h, authKey.f222h) && TextUtils.equals(this.f223i, authKey.f223i) && Arrays.equals(this.f224j, authKey.f224j) && ((this.f216b && authKey.f216b) || !(this.f216b || authKey.f216b));
    }

    public boolean m268b() {
        return this.f216b;
    }

    public String m269c() {
        return this.f217c;
    }

    public String m270d() {
        return this.f218d;
    }

    public int describeContents() {
        return 0;
    }

    public String m271e() {
        return this.f219e;
    }

    public String m272f() {
        return this.f220f;
    }

    public String m273g() {
        return this.f221g;
    }

    public String m274h() {
        return this.f222h;
    }

    public String m275i() {
        return this.f223i;
    }

    public byte[] m276j() {
        return this.f224j;
    }

    public AuthKey m277k() {
        return new AuthKey(this.f215a, this.f216b, this.f217c, this.f218d, this.f219e, this.f220f, this.f221g, this.f222h, this.f223i, this.f224j);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f215a);
        parcel.writeInt(this.f216b ? 1 : 0);
        parcel.writeString(this.f217c);
        parcel.writeString(this.f218d);
        parcel.writeString(this.f219e);
        parcel.writeString(this.f220f);
        parcel.writeString(this.f221g);
        parcel.writeString(this.f222h);
        parcel.writeString(this.f223i);
        parcel.writeInt(this.f224j != null ? this.f224j.length : -1);
        if (this.f224j != null) {
            parcel.writeByteArray(this.f224j);
        }
    }
}
