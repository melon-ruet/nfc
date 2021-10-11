package com.nxp.taginfolite.p005b;

import android.content.Context;
import android.support.v4.BuildConfig;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.nxp.taginfolite.b.g */
public class C0187g extends C0183d {
    public C0187g(int i, String str, byte[] bArr) {
        this(i, str, bArr, null);
    }

    public C0187g(int i, String str, byte[] bArr, String str2) {
        super(i, 2, str + (str.length() == 1 ? " " : BuildConfig.VERSION_NAME), 16, 8, bArr, str2);
        this.c = 16;
    }

    public C0187g(XmlPullParser xmlPullParser) {
        super(xmlPullParser, -1, 2, null, 16, 8, null);
        this.c = 16;
    }

    public CharSequence m160a(Context context, boolean z) {
        C0428i c0428i = new C0428i();
        if (this.f != null && this.f.length >= this.c) {
            return super.m154a(context, z);
        }
        if (this.a >= 0) {
            c0428i.m1387b(String.format("[%0" + String.valueOf(this.b) + "X]", new Object[]{Integer.valueOf(this.a)}));
        }
        int length;
        if (z || this.c == this.d) {
            c0428i.m1387b(" ");
            if (!TextUtils.isEmpty(this.e)) {
                c0428i.m1387b(this.e);
            }
            length = this.f == null ? 0 : this.f.length;
            c0428i.m1387b(C0429j.m1394a(this.f, " ", " ", 0, length));
            while (length < this.c) {
                c0428i.m1387b(" --");
                length++;
            }
            if (TextUtils.isEmpty(this.g)) {
                c0428i.m1387b(" ");
                c0428i.m1387b(C0429j.m1407d(this.f, 0, this.c));
            } else {
                c0428i.m1387b(" ");
                c0428i.m1387b(this.g);
            }
        } else {
            int length2 = this.f == null ? 0 : this.f.length;
            length = length2 > 8 ? 8 : length2;
            c0428i.m1387b(C0429j.m1394a(this.f, " ", " ", 0, length));
            while (length < 8) {
                c0428i.m1387b(" --");
                length++;
            }
            if (!TextUtils.isEmpty(this.g)) {
                c0428i.m1387b(" ");
                c0428i.m1387b(this.g);
            }
            c0428i.m1387b("\n  ");
            if (!TextUtils.isEmpty(this.e)) {
                c0428i.m1387b(this.e);
            }
            length = length2 > 8 ? length2 - 8 : 0;
            if (length > 0) {
                c0428i.m1387b(C0429j.m1394a(this.f, " ", " ", 8, length));
            }
            while (length < 8) {
                c0428i.m1387b(" --");
                length++;
            }
        }
        c0428i.m1385a(new TextAppearanceSpan(context, R.style.item_mono));
        return c0428i.m1386b();
    }

    protected String m161b() {
        return "FelicaLite";
    }
}
