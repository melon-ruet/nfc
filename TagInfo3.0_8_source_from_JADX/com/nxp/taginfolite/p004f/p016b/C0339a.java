package com.nxp.taginfolite.p004f.p016b;

import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0338a;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.p015a.C0337j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.nxp.taginfolite.f.b.a */
public class C0339a {
    private byte[] f1041a;
    private byte[] f1042b;
    private byte[] f1043c;
    private int f1044d;
    private byte[] f1045e;

    public C0339a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        this.f1041a = bArr;
        this.f1042b = bArr2;
        this.f1043c = bArr3;
        this.f1044d = i & MotionEventCompat.ACTION_MASK;
    }

    public C0339a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4) {
        this.f1041a = bArr;
        this.f1042b = bArr2;
        this.f1043c = bArr3;
        this.f1044d = i & MotionEventCompat.ACTION_MASK;
        this.f1045e = bArr4;
    }

    public static C0339a m973a(byte[] bArr) {
        int i = 0;
        try {
            C0337j c0337j = new C0337j(bArr);
            C0337j b = c0337j.m962b(79);
            byte[] g = b != null ? b.m965g() : null;
            C0337j b2 = c0337j.m962b(80);
            byte[] g2 = b2 != null ? b2.m965g() : null;
            C0337j b3 = c0337j.m962b(40722);
            byte[] g3 = b3 != null ? b3.m965g() : null;
            C0337j b4 = c0337j.m962b(135);
            byte[] g4 = b4 != null ? b4.m965g() : null;
            if (g4 != null) {
                i = g4[0] & MotionEventCompat.ACTION_MASK;
            }
            b4 = c0337j.m962b(24365);
            return new C0339a(g, g2, g3, i, b4 != null ? b4.m965g() : null);
        } catch (NullPointerException e) {
            return null;
        }
    }

    public static List m974a(C0337j c0337j) {
        C0337j b = c0337j.m962b(165);
        List arrayList = new ArrayList();
        if (b != null) {
            C0337j b2 = b.m962b(48908);
            C0339a a;
            if (b2 != null) {
                List<C0337j> a2 = b2.m959a(97);
                if (a2 != null) {
                    for (C0337j b3 : a2) {
                        a = C0339a.m973a(b3.m965g());
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                }
            } else {
                b2 = c0337j.m962b(132);
                if (b2 != null) {
                    a = C0339a.m973a(b3.m965g());
                    if (a == null) {
                        return null;
                    }
                    arrayList.add(new C0339a(b2.m965g(), a.m976b(), a.m977c(), a.m978d()));
                }
            }
        }
        return arrayList;
    }

    public byte[] m975a() {
        return this.f1041a == null ? null : Arrays.copyOf(this.f1041a, this.f1041a.length);
    }

    public byte[] m976b() {
        return this.f1042b == null ? null : Arrays.copyOf(this.f1042b, this.f1042b.length);
    }

    public byte[] m977c() {
        return this.f1043c == null ? null : Arrays.copyOf(this.f1043c, this.f1043c.length);
    }

    public int m978d() {
        return this.f1044d;
    }

    public String m979e() {
        C0428i c0428i = new C0428i();
        CharSequence a = C0338a.m972a(this.f1041a);
        if (!TextUtils.isEmpty(a)) {
            c0428i.m1384a(a);
            if (this.f1042b != null && this.f1042b.length > 0 && C0429j.m1404b(this.f1042b)) {
                c0428i.m1387b(C0358k.f1076c);
                c0428i.m1387b("Label: \"");
                c0428i.m1387b(new String(this.f1042b, C0429j.f1360a));
                c0428i.m1384a((CharSequence) "\"");
            }
            if (this.f1044d > 0) {
                c0428i.m1387b(C0358k.f1076c);
                c0428i.m1387b("Priority: ");
                c0428i.m1384a(Integer.toString(this.f1044d));
            }
            if (this.f1045e != null && this.f1045e.length > 0 && C0429j.m1404b(this.f1045e)) {
                c0428i.m1387b(C0358k.f1076c);
                c0428i.m1387b("Languages: ");
                int length = this.f1045e.length;
                for (int i = 0; i + 1 < length; i += 2) {
                    c0428i.m1387b(new String(new byte[]{this.f1045e[i], this.f1045e[i + 1]}, C0429j.f1360a));
                    if (i + 3 < length) {
                        c0428i.m1387b(", ");
                    }
                }
                c0428i.m1383a();
            }
        }
        return c0428i.toString();
    }
}
