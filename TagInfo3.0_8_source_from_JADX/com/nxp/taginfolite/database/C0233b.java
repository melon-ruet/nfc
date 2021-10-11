package com.nxp.taginfolite.database;

import android.content.Context;
import android.nfc.NdefMessage;
import android.support.v4.BuildConfig;
import com.nxp.taginfolite.C0373f;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.data.C0210d;
import com.nxp.taginfolite.data.C0211e;
import com.nxp.taginfolite.data.C0213g;
import com.nxp.taginfolite.p003g.C0422a;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p005b.C0193o;
import com.nxp.taginfolite.p006c.C0197a;
import com.nxp.taginfolite.p006c.C0198b;
import com.nxp.taginfolite.p006c.C0199c;
import com.nxp.taginfolite.p006c.C0200d;
import com.nxp.taginfolite.p009e.ay;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.nxp.taginfolite.database.b */
public class C0233b {
    private final String f278a;
    private final List[] f279b;
    private final String f280c;
    private final String f281d;
    private final String f282e;
    private final boolean f283f;
    private final boolean f284g;
    private final boolean f285h;
    private final byte[] f286i;
    private final boolean f287j;
    private final String f288k;

    public C0233b(String str, List[] listArr, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, byte[] bArr, boolean z4, String str5) {
        this.f278a = str;
        this.f279b = listArr;
        this.f280c = str2;
        this.f281d = str3;
        this.f282e = str4;
        this.f283f = z;
        this.f284g = z2;
        this.f285h = z3;
        if (bArr != null) {
            this.f286i = Arrays.copyOf(bArr, bArr.length);
        } else {
            this.f286i = null;
        }
        this.f287j = z4;
        this.f288k = str5;
    }

    public static C0233b m344a(Context context, String str) {
        return new C0236e(context, str).m365a();
    }

    public static String m345a(Context context, String str, C0210d c0210d, C0213g c0213g, C0199c c0199c, C0211e c0211e, C0198b c0198b, C0197a c0197a, C0200d c0200d) {
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        stringBuilder.append("<scan>\n");
        stringBuilder.append("\t<version>");
        stringBuilder.append(C0373f.m1124a());
        stringBuilder.append("</version>\n");
        stringBuilder.append("\t<date>");
        stringBuilder.append(str);
        stringBuilder.append("</date>\n");
        ay a = c0213g.m303a();
        stringBuilder.append("\t<title>");
        stringBuilder.append(C0233b.m346a(c0213g, c0210d, c0199c));
        stringBuilder.append("</title>\n");
        String a2 = a != null ? C0429j.m1393a(a.m403c(), BuildConfig.VERSION_NAME, ":") : BuildConfig.VERSION_NAME;
        boolean z = a != null && a.m401a();
        stringBuilder.append("\t<uid nxp=\"");
        stringBuilder.append(Boolean.toString(z));
        stringBuilder.append("\">");
        stringBuilder.append(a2);
        stringBuilder.append("</uid>\n");
        stringBuilder.append("\t<hasndef>");
        stringBuilder.append(c0210d.m284a());
        stringBuilder.append("</hasndef>\n");
        NdefMessage[] j = c0210d.m294j();
        if (c0210d.m284a() && j != null && j.length > 0) {
            String a3 = C0422a.m1358a(j[0].toByteArray());
            stringBuilder.append("\t<ndef>");
            stringBuilder.append(a3);
            stringBuilder.append("</ndef>\n");
        }
        if ((a != null && a.m402b()) || ((c0213g.m308b() != null && c0213g.m308b().m496b()) || (c0213g.m310c() != null && c0213g.m310c().m656b()))) {
            stringBuilder.append("\t<taglost>");
            stringBuilder.append(true);
            stringBuilder.append("</taglost>\n");
        }
        if (a != null) {
            if (c0199c != null) {
                stringBuilder.append(c0199c.m222a(context));
            } else {
                stringBuilder.append("<section/>\n");
            }
            if (c0211e != null) {
                stringBuilder.append("\t<section>\n");
                stringBuilder.append(c0211e.m296a(context));
                stringBuilder.append(c0198b.m210a(context));
                stringBuilder.append("\t</section>\n");
            } else {
                stringBuilder.append("<section/>\n");
            }
            if (c0197a != null) {
                stringBuilder.append(c0197a.m189a(context));
            } else {
                stringBuilder.append("<section/>\n");
            }
            if (c0200d != null) {
                stringBuilder.append(c0200d.m234a(context));
            } else {
                stringBuilder.append("<section/>\n");
            }
        } else if (c0211e != null) {
            stringBuilder.append("<section/>\n");
            stringBuilder.append("\t<section>\n");
            stringBuilder.append(c0211e.m296a(context));
            stringBuilder.append("\t</section>\n");
            stringBuilder.append("<section/>\n");
            stringBuilder.append("<section/>\n");
        } else {
            stringBuilder.append("<section>\n<subsection title=\"");
            stringBuilder.append(context.getString(R.string.no_tag));
            stringBuilder.append("\">");
            stringBuilder.append(new C0193o(context.getString(R.string.empty_text)).m173a());
            stringBuilder.append("\n</subsection>\n</section>\n");
        }
        stringBuilder.append("</scan>\n");
        return stringBuilder.toString();
    }

    private static String m346a(C0213g c0213g, C0210d c0210d, C0199c c0199c) {
        return (c0213g.m303a() == null || c0199c == null) ? c0210d.m284a() ? "NFC peer-to-peer communication" : BuildConfig.VERSION_NAME : c0199c.m223a(c0213g.m313f()).toString();
    }

    public String m347a() {
        return this.f278a;
    }

    public List m348a(int i) {
        return this.f279b[i];
    }

    public String m349b() {
        return this.f280c;
    }

    public String m350c() {
        return this.f281d;
    }

    public String m351d() {
        return this.f282e;
    }

    public boolean m352e() {
        return this.f283f;
    }

    public boolean m353f() {
        return this.f284g;
    }

    public boolean m354g() {
        return this.f285h;
    }

    public byte[] m355h() {
        return this.f286i != null ? Arrays.copyOf(this.f286i, this.f286i.length) : null;
    }

    public boolean m356i() {
        return this.f287j;
    }

    public String m357j() {
        return this.f288k;
    }
}
