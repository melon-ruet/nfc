package com.nxp.taginfolite.p005b;

import android.content.Context;
import android.text.style.TextAppearanceSpan;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.nxp.taginfolite.b.h */
public class C0184h extends C0183d {
    public C0184h(int i, int i2, byte[] bArr) {
        super(i, i2, null, 16, 8, bArr);
    }

    public C0184h(int i, byte[] bArr) {
        this(i, 2, bArr);
    }

    public C0184h(XmlPullParser xmlPullParser) {
        this(xmlPullParser, 2);
    }

    public C0184h(XmlPullParser xmlPullParser, int i) {
        super(xmlPullParser, -1, i, null, 16, 8, null);
    }

    public CharSequence m157a(Context context, boolean z) {
        C0428i c0428i = new C0428i();
        if (this.a >= 0) {
            c0428i.m1387b(String.format("[%0" + String.valueOf(this.b) + "X]", new Object[]{Integer.valueOf(this.a)}));
        }
        c0428i.m1387b(" ");
        if (z) {
            c0428i.m1387b(C0429j.m1407d(this.f, 0, 16));
        } else {
            c0428i.m1387b(C0429j.m1407d(this.f, 0, 8));
            if (this.f.length > 8) {
                c0428i.m1387b("\n");
                if (this.a >= 0) {
                    c0428i.m1387b(String.format("[%0" + String.valueOf(this.b) + "X]", new Object[]{Integer.valueOf(this.a + 8)}));
                }
                c0428i.m1387b(" ");
                c0428i.m1387b(C0429j.m1407d(this.f, 8, 8));
            }
        }
        c0428i.m1385a(new TextAppearanceSpan(context, R.style.item_mono));
        return c0428i.m1386b();
    }

    protected String m158b() {
        return "File";
    }
}
