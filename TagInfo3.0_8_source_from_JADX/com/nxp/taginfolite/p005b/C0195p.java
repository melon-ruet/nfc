package com.nxp.taginfolite.p005b;

import android.content.Context;
import android.support.v4.BuildConfig;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import java.util.Arrays;
import org.jraf.android.backport.switchwidget.C0519c;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.nxp.taginfolite.b.p */
public class C0195p extends C0183d {
    private final boolean f140h;
    private final boolean f141i;
    private final int f142j;

    public C0195p(int i, int i2, String str, byte[] bArr) {
        this(i, i2, str, bArr, null);
    }

    public C0195p(int i, int i2, String str, byte[] bArr, String str2) {
        super(i, i2, str, 4, 4, bArr, str2);
        this.f140h = false;
        this.f141i = false;
        if (bArr == null) {
            this.f142j = 0;
        } else {
            this.f142j = bArr.length;
        }
    }

    public C0195p(int i, String str, boolean z, int i2, String str2) {
        super(i, 2, str, 4, 4, null, str2);
        this.f140h = z;
        this.f141i = !z;
        this.f142j = i2;
    }

    public C0195p(int i, String str, byte[] bArr) {
        this(i, str, bArr, null);
    }

    public C0195p(int i, String str, byte[] bArr, String str2) {
        this(i, 2, str, bArr, str2);
    }

    public C0195p(XmlPullParser xmlPullParser) {
        this(xmlPullParser, -1, 2, " ", 4, 4, null);
    }

    public C0195p(XmlPullParser xmlPullParser, int i, int i2, String str, int i3, int i4, byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        int i5 = -1;
        boolean z = false;
        String str2 = null;
        int next = xmlPullParser.next();
        byte[] bArr2 = bArr;
        Object obj = null;
        Object obj2 = null;
        int i6 = i2;
        StringBuilder stringBuilder2 = stringBuilder;
        Object obj3 = null;
        int i7 = i;
        while (obj2 == null && next != 1) {
            int i8;
            Object obj4;
            Object obj5;
            String str3;
            boolean z2;
            Object obj6;
            Object obj7;
            String name;
            switch (next) {
                case C0519c.Switch_textOn /*2*/:
                    name = xmlPullParser.getName();
                    if ("address".equalsIgnoreCase(name)) {
                        name = xmlPullParser.getAttributeValue(null, "addrwidth");
                        if (name != null) {
                            try {
                                i6 = Integer.parseInt(name.trim());
                            } catch (NumberFormatException e) {
                                i6 = i2;
                            }
                        }
                        bArr = bArr2;
                        i = i7;
                        i8 = i5;
                        obj4 = obj3;
                        i5 = i6;
                        stringBuilder = stringBuilder2;
                        obj5 = obj2;
                        str3 = str2;
                        z2 = z;
                        obj6 = 1;
                        break;
                    } else if ("data".equalsIgnoreCase(name)) {
                        str = xmlPullParser.getAttributeValue(null, "access");
                        str2 = xmlPullParser.getAttributeValue(null, "comment");
                        z = Boolean.parseBoolean(xmlPullParser.getAttributeValue(null, "secure"));
                        try {
                            bArr = bArr2;
                            i = i7;
                            i8 = Integer.parseInt(xmlPullParser.getAttributeValue(null, "length"));
                            i7 = 1;
                            i5 = i6;
                            stringBuilder = stringBuilder2;
                            obj5 = obj2;
                            str3 = str2;
                            obj7 = obj;
                            z2 = z;
                            obj6 = obj7;
                            break;
                        } catch (NumberFormatException e2) {
                            bArr = bArr2;
                            i = i7;
                            i8 = 4;
                            i7 = 1;
                            i5 = i6;
                            stringBuilder = stringBuilder2;
                            obj5 = obj2;
                            str3 = str2;
                            obj7 = obj;
                            z2 = z;
                            obj6 = obj7;
                            break;
                        }
                    } else {
                        throw new XmlPullParserException("TagInfo_UlBlock Unexpected start tag: " + name);
                    }
                case C0519c.Switch_textOff /*3*/:
                    name = xmlPullParser.getName();
                    int parseInt;
                    if (!"block".equalsIgnoreCase(name)) {
                        byte[] bArr3;
                        Object obj8;
                        int i9;
                        if ("address".equalsIgnoreCase(name) && obj != null) {
                            try {
                                parseInt = Integer.parseInt(stringBuilder2.toString().trim());
                            } catch (NumberFormatException e3) {
                                parseInt = 0;
                            }
                            obj7 = obj3;
                            bArr3 = bArr2;
                            obj8 = null;
                            i9 = parseInt;
                            obj5 = obj7;
                        } else if (!"data".equalsIgnoreCase(name) || obj3 == null) {
                            throw new XmlPullParserException("TagInfo_UlBlock Unexpected end tag: " + name);
                        } else {
                            bArr3 = C0183d.m153a(stringBuilder2.toString().trim());
                            obj5 = null;
                            obj8 = obj;
                            i9 = i7;
                        }
                        bArr = bArr3;
                        i = i9;
                        z2 = z;
                        stringBuilder = new StringBuilder();
                        obj4 = obj5;
                        obj6 = obj8;
                        obj5 = obj2;
                        i8 = i5;
                        str3 = str2;
                        i5 = i6;
                        break;
                    }
                    bArr = bArr2;
                    i = i7;
                    i8 = i5;
                    obj4 = obj3;
                    i5 = i6;
                    stringBuilder = stringBuilder2;
                    parseInt = 1;
                    str3 = str2;
                    obj7 = obj;
                    z2 = z;
                    obj6 = obj7;
                    break;
                    break;
                case C0519c.Switch_thumbTextPadding /*4*/:
                    Object text = xmlPullParser.getText();
                    if (!TextUtils.isEmpty(text)) {
                        stringBuilder2.append(text);
                        bArr = bArr2;
                        i = i7;
                        i8 = i5;
                        obj4 = obj3;
                        i5 = i6;
                        stringBuilder = stringBuilder2;
                        obj5 = obj2;
                        str3 = str2;
                        obj7 = obj;
                        z2 = z;
                        obj6 = obj7;
                        break;
                    }
                    bArr = bArr2;
                    i = i7;
                    i8 = i5;
                    obj4 = obj3;
                    i5 = i6;
                    stringBuilder = stringBuilder2;
                    obj5 = obj2;
                    str3 = str2;
                    obj7 = obj;
                    z2 = z;
                    obj6 = obj7;
                    break;
                default:
                    throw new XmlPullParserException("TagInfo_UlBlock Unknown XPP event!");
            }
            if (obj5 == null) {
                next = xmlPullParser.next();
                str2 = str3;
                obj2 = obj5;
                i6 = i5;
                stringBuilder2 = stringBuilder;
                i5 = i8;
                bArr2 = bArr;
                obj3 = obj4;
                i7 = i;
                obj7 = obj6;
                z = z2;
                obj = obj7;
            } else {
                str2 = str3;
                i6 = i5;
                i5 = i8;
                obj2 = obj5;
                bArr2 = bArr;
                stringBuilder2 = stringBuilder;
                obj3 = obj4;
                i7 = i;
                obj7 = obj6;
                z = z2;
                obj = obj7;
            }
        }
        this.a = i7;
        this.b = i6;
        this.e = str;
        this.g = str2;
        this.f140h = z;
        this.f141i = !z;
        if (bArr2 != null) {
            this.f142j = bArr2.length;
            this.c = bArr2.length;
            this.d = this.c;
            if (this.d > 8) {
                this.d = (this.c / 2) + (this.c % 2);
            }
        } else {
            if (i5 >= 0) {
                this.f142j = i5;
            } else {
                this.f142j = 4;
            }
            this.c = i3;
            this.d = i4;
        }
        if (bArr2 != null) {
            this.f = Arrays.copyOf(bArr2, bArr2.length);
        } else {
            this.f = null;
        }
    }

    public CharSequence m175a(Context context, boolean z) {
        C0428i c0428i = new C0428i();
        c0428i.m1387b(String.format("[%0" + String.valueOf(this.b) + "X] ", new Object[]{Integer.valueOf(this.a)}));
        if (this.e != null) {
            c0428i.m1387b(this.e);
        } else {
            c0428i.m1387b(" ");
        }
        int i;
        if (this.f == null || this.f.length == 0) {
            CharSequence charSequence = "--";
            if (this.f140h) {
                charSequence = "XX";
            } else if (this.f141i) {
                charSequence = "??";
            }
            for (int i2 = 0; i2 < this.f142j; i2++) {
                c0428i.m1387b(" ");
                c0428i.m1387b(charSequence);
            }
            for (i = this.f142j; i < 4; i++) {
                c0428i.m1387b(" --");
            }
        } else if (this.a == 0 && this.f142j == 4) {
            c0428i.m1387b(String.format(" %02X:%02X:%02X %02X", new Object[]{Byte.valueOf(this.f[0]), Byte.valueOf(this.f[1]), Byte.valueOf(this.f[2]), Byte.valueOf(this.f[3])}));
        } else if ((this.a == 1 || this.a == 3) && this.f142j == 4) {
            c0428i.m1387b(String.format(" %02X:%02X:%02X:%02X", new Object[]{Byte.valueOf(this.f[0]), Byte.valueOf(this.f[1]), Byte.valueOf(this.f[2]), Byte.valueOf(this.f[3])}));
        } else if (this.a == 2 && this.f142j == 4) {
            c0428i.m1387b(" ");
            c0428i.m1387b(C0429j.m1393a(this.f, BuildConfig.VERSION_NAME, " "));
        } else if (this.f142j == 4 && !TextUtils.isEmpty(this.g)) {
            c0428i.m1387b(" ");
            c0428i.m1387b(C0429j.m1393a(this.f, BuildConfig.VERSION_NAME, " "));
        } else if (this.f142j == 4) {
            c0428i.m1387b(" ");
            c0428i.m1387b(C0429j.m1412h(this.f));
        } else {
            for (i = 0; i < this.f142j; i++) {
                c0428i.m1387b(String.format(" %02X", new Object[]{Byte.valueOf(this.f[i])}));
            }
            for (i = this.f142j; i < 4; i++) {
                c0428i.m1387b(" --");
            }
        }
        if (!TextUtils.isEmpty(this.g)) {
            c0428i.m1387b(" ");
            c0428i.m1387b(this.g);
        }
        c0428i.m1385a(new TextAppearanceSpan(context, R.style.item_mono));
        return c0428i.m1386b();
    }

    public String m176a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<block");
        CharSequence b = m177b();
        if (!(b == null || TextUtils.isEmpty(b))) {
            stringBuilder.append(" type=\"");
            stringBuilder.append(m177b());
            stringBuilder.append("\"");
        }
        stringBuilder.append(">\n");
        stringBuilder.append("\t<address");
        if (this.b != 2) {
            stringBuilder.append(" addrwidth=\"");
            stringBuilder.append(String.valueOf(this.b));
            stringBuilder.append("\"");
        }
        stringBuilder.append(">");
        stringBuilder.append(String.valueOf(this.a));
        stringBuilder.append("</address>\n");
        stringBuilder.append("\t<data");
        if (!TextUtils.isEmpty(this.e)) {
            stringBuilder.append(" access=\"");
            stringBuilder.append(this.e);
            stringBuilder.append("\"");
        }
        if (!TextUtils.isEmpty(this.g)) {
            stringBuilder.append(" comment=\"");
            stringBuilder.append(this.g);
            stringBuilder.append("\"");
        }
        if (this.f140h) {
            stringBuilder.append(" secure=\"true\"");
        }
        if (this.f142j < 4) {
            stringBuilder.append(" length=\"");
            stringBuilder.append(Integer.toString(this.f142j));
            stringBuilder.append("\"");
        }
        if (this.f == null || this.f.length <= 0) {
            stringBuilder.append("/>\n");
        } else {
            stringBuilder.append(">");
            stringBuilder.append(C0429j.m1393a(this.f, BuildConfig.VERSION_NAME, " "));
            stringBuilder.append("</data>\n");
        }
        stringBuilder.append("</block>\n");
        return stringBuilder.toString();
    }

    protected String m177b() {
        return "Ultralight";
    }
}
