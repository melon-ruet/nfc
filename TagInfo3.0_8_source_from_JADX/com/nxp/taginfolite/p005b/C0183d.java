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

/* renamed from: com.nxp.taginfolite.b.d */
public class C0183d implements C0180a {
    protected int f123a;
    protected int f124b;
    protected int f125c;
    protected int f126d;
    protected String f127e;
    protected byte[] f128f;
    protected String f129g;

    protected C0183d() {
        this.f125c = 16;
        this.f126d = 8;
        this.f128f = null;
        this.f123a = -1;
        this.f124b = 2;
        this.f127e = null;
        this.f129g = null;
    }

    public C0183d(int i, int i2, String str, int i3, int i4, byte[] bArr) {
        this(i, i2, str, i3, i4, bArr, null);
    }

    public C0183d(int i, int i2, String str, int i3, int i4, byte[] bArr, String str2) {
        this.f123a = i;
        this.f124b = i2;
        this.f125c = i3;
        this.f126d = i4;
        this.f127e = str;
        if (bArr != null) {
            this.f128f = Arrays.copyOf(bArr, bArr.length);
        } else {
            this.f128f = null;
        }
        this.f129g = str2;
    }

    public C0183d(int i, int i2, String str, byte[] bArr) {
        int i3 = 0;
        int length = bArr != null ? bArr.length : 0;
        if (bArr != null) {
            i3 = bArr.length;
        }
        this(i, i2, str, length, i3, bArr);
    }

    public C0183d(XmlPullParser xmlPullParser) {
        this(xmlPullParser, -1, 2, null, 16, 8, null);
    }

    public C0183d(XmlPullParser xmlPullParser, int i, int i2, String str, int i3, int i4, byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        int next = xmlPullParser.next();
        Object obj = null;
        String str2 = null;
        Object obj2 = null;
        int i5 = 0;
        int i6 = i2;
        byte[] bArr2 = bArr;
        Object obj3 = null;
        int i7 = i;
        while (obj == null && next != 1) {
            Object obj4;
            Object obj5;
            String str3;
            int i8;
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
                        obj4 = obj2;
                        i7 = i6;
                        obj5 = obj;
                        str3 = str2;
                        obj = 1;
                        i8 = i5;
                        break;
                    } else if ("data".equalsIgnoreCase(name)) {
                        str = xmlPullParser.getAttributeValue(null, "access");
                        str2 = xmlPullParser.getAttributeValue(null, "comment");
                        name = xmlPullParser.getAttributeValue(null, "width");
                        if (name != null) {
                            try {
                                i5 = Integer.parseInt(name.trim());
                            } catch (NumberFormatException e2) {
                                i6 = i2;
                            }
                        }
                        bArr = bArr2;
                        i = i7;
                        int i9 = 1;
                        i7 = i6;
                        obj5 = obj;
                        str3 = str2;
                        obj = obj3;
                        i8 = i5;
                        break;
                    } else {
                        throw new XmlPullParserException("TagInfo_Data Unexpected start tag: " + name);
                    }
                case C0519c.Switch_textOff /*3*/:
                    name = xmlPullParser.getName();
                    if (!"block".equalsIgnoreCase(name)) {
                        Object obj6;
                        byte[] bArr3;
                        Object obj7;
                        if ("address".equalsIgnoreCase(name) && obj3 != null) {
                            int parseInt;
                            try {
                                parseInt = Integer.parseInt(stringBuilder.toString().trim());
                            } catch (NumberFormatException e3) {
                                parseInt = 0;
                            }
                            obj6 = obj2;
                            bArr3 = bArr2;
                            obj4 = null;
                            i8 = parseInt;
                            obj7 = obj6;
                        } else if (!"data".equalsIgnoreCase(name) || obj2 == null) {
                            throw new XmlPullParserException("TagInfo_Data Unexpected end tag: " + name);
                        } else {
                            bArr3 = C0183d.m153a(stringBuilder.toString().trim());
                            obj7 = null;
                            obj4 = obj3;
                            i8 = i7;
                        }
                        bArr = bArr3;
                        i = i8;
                        str3 = str2;
                        i8 = i5;
                        obj6 = obj;
                        obj = obj4;
                        obj4 = obj7;
                        stringBuilder = new StringBuilder();
                        i7 = i6;
                        obj5 = obj6;
                        break;
                    }
                    bArr = bArr2;
                    i = i7;
                    obj4 = obj2;
                    i7 = i6;
                    i6 = 1;
                    str3 = str2;
                    obj = obj3;
                    i8 = i5;
                    break;
                    break;
                case C0519c.Switch_thumbTextPadding /*4*/:
                    Object text = xmlPullParser.getText();
                    if (!TextUtils.isEmpty(text)) {
                        stringBuilder.append(text);
                        bArr = bArr2;
                        i = i7;
                        obj4 = obj2;
                        i7 = i6;
                        obj5 = obj;
                        str3 = str2;
                        obj = obj3;
                        i8 = i5;
                        break;
                    }
                    bArr = bArr2;
                    i = i7;
                    obj4 = obj2;
                    i7 = i6;
                    obj5 = obj;
                    str3 = str2;
                    obj = obj3;
                    i8 = i5;
                    break;
                default:
                    throw new XmlPullParserException("TagInfo_Data Unknown XPP event!");
            }
            if (obj5 == null) {
                next = xmlPullParser.next();
                str2 = str3;
                obj2 = obj4;
                i5 = i8;
                bArr2 = bArr;
                obj3 = obj;
                obj = obj5;
                i6 = i7;
                i7 = i;
            } else {
                str2 = str3;
                i5 = i8;
                obj2 = obj4;
                obj3 = obj;
                obj = obj5;
                bArr2 = bArr;
                i6 = i7;
                i7 = i;
            }
        }
        this.f123a = i7;
        this.f124b = i6;
        this.f127e = str;
        this.f129g = str2;
        if (bArr2 != null) {
            this.f125c = bArr2.length;
            if (this.f125c > 8) {
                this.f126d = (this.f125c / 2) + (this.f125c % 2);
            } else {
                this.f126d = this.f125c;
            }
        } else if (i5 == 0) {
            this.f125c = i3;
            this.f126d = i4;
        } else {
            this.f125c = i5;
            if (i5 > 8) {
                this.f126d = (i5 % 2) + (i5 / 2);
            } else {
                this.f126d = this.f125c;
            }
        }
        if (bArr2 != null) {
            this.f128f = Arrays.copyOf(bArr2, bArr2.length);
        } else {
            this.f128f = null;
        }
    }

    protected static byte[] m153a(String str) {
        int i = 0;
        String[] split = str.trim().split(" ");
        if (split == null || (split.length == 1 && TextUtils.isEmpty(split[0]))) {
            return null;
        }
        int length = split.length;
        byte[] bArr = new byte[length];
        while (i < length) {
            try {
                bArr[i] = (byte) Integer.parseInt(split[i], 16);
                i++;
            } catch (NumberFormatException e) {
                throw new XmlPullParserException("Error in hex digit: " + split[i]);
            }
        }
        return bArr;
    }

    public CharSequence m154a(Context context, boolean z) {
        C0428i c0428i = new C0428i();
        if (this.f123a >= 0) {
            c0428i.m1387b(String.format("[%0" + String.valueOf(this.f124b) + "X]", new Object[]{Integer.valueOf(this.f123a)}));
        }
        c0428i.m1387b(" ");
        int i;
        if (z || this.f125c == this.f126d) {
            if (!TextUtils.isEmpty(this.f127e)) {
                c0428i.m1387b(this.f127e);
                c0428i.m1387b(" ");
            }
            if (this.f128f == null || this.f128f.length == 0) {
                for (i = 0; i < this.f125c; i++) {
                    c0428i.m1387b("-- ");
                }
            } else if (TextUtils.isEmpty(this.f129g)) {
                c0428i.m1387b(C0429j.m1407d(this.f128f, 0, this.f125c));
            } else {
                c0428i.m1387b(C0429j.m1394a(this.f128f, BuildConfig.VERSION_NAME, " ", 0, this.f125c));
                c0428i.m1387b(" ");
                c0428i.m1387b(this.f129g);
            }
        } else {
            int i2;
            i = this.f124b + 2;
            if (!TextUtils.isEmpty(this.f127e)) {
                i -= this.f127e.length();
            }
            for (i2 = 0; i2 < (-i); i2++) {
                c0428i.m1387b(" ");
            }
            if (this.f128f == null || this.f128f.length == 0) {
                for (i2 = 0; i2 < this.f126d; i2++) {
                    c0428i.m1387b("-- ");
                }
                c0428i.m1387b("\n");
                for (i2 = 0; i2 < i; i2++) {
                    c0428i.m1387b(" ");
                }
                if (!TextUtils.isEmpty(this.f127e)) {
                    c0428i.m1387b(String.format("%s ", new Object[]{this.f127e}));
                }
                for (i = 0; i < this.f125c - this.f126d; i++) {
                    c0428i.m1387b("-- ");
                }
            } else {
                if (TextUtils.isEmpty(this.f129g)) {
                    c0428i.m1387b(C0429j.m1407d(this.f128f, 0, this.f126d));
                } else {
                    c0428i.m1387b(C0429j.m1394a(this.f128f, BuildConfig.VERSION_NAME, " ", 0, this.f126d));
                    c0428i.m1387b(" ");
                    c0428i.m1387b(this.f129g);
                }
                if (this.f128f.length > this.f126d) {
                    c0428i.m1387b("\n");
                    for (i2 = 0; i2 < i; i2++) {
                        c0428i.m1387b(" ");
                    }
                    if (!TextUtils.isEmpty(this.f127e)) {
                        c0428i.m1387b(this.f127e);
                    }
                    c0428i.m1387b(" ");
                    if (TextUtils.isEmpty(this.f129g)) {
                        c0428i.m1387b(C0429j.m1407d(this.f128f, this.f126d, this.f126d));
                    } else {
                        c0428i.m1387b(C0429j.m1394a(this.f128f, BuildConfig.VERSION_NAME, " ", this.f126d, this.f126d));
                    }
                }
            }
        }
        c0428i.m1385a(new TextAppearanceSpan(context, R.style.item_mono));
        return c0428i.m1386b();
    }

    public String m155a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<block");
        CharSequence b = m156b();
        if (!(b == null || TextUtils.isEmpty(b))) {
            stringBuilder.append(" type=\"");
            stringBuilder.append(m156b());
            stringBuilder.append("\"");
        }
        stringBuilder.append(">\n");
        stringBuilder.append("\t<address");
        if (this.f124b != 2) {
            stringBuilder.append(" addrwidth=\"");
            stringBuilder.append(String.valueOf(this.f124b));
            stringBuilder.append("\"");
        }
        stringBuilder.append(">");
        stringBuilder.append(String.valueOf(this.f123a));
        stringBuilder.append("</address>\n");
        stringBuilder.append("\t<data");
        if (!TextUtils.isEmpty(this.f127e)) {
            stringBuilder.append(" access=\"");
            stringBuilder.append(this.f127e);
            stringBuilder.append("\"");
        }
        if (!TextUtils.isEmpty(this.f129g)) {
            stringBuilder.append(" comment=\"");
            stringBuilder.append(this.f129g);
            stringBuilder.append("\"");
        }
        if (this.f128f == null || this.f128f.length <= 0) {
            if (this.f125c != 16) {
                stringBuilder.append(" width=\"");
                stringBuilder.append(Integer.toString(this.f125c));
                stringBuilder.append("\"");
            }
            stringBuilder.append("/>\n");
        } else {
            stringBuilder.append(">");
            stringBuilder.append(C0429j.m1393a(this.f128f, BuildConfig.VERSION_NAME, " "));
            stringBuilder.append("</data>\n");
        }
        stringBuilder.append("</block>\n");
        return stringBuilder.toString();
    }

    protected String m156b() {
        return BuildConfig.VERSION_NAME;
    }
}
