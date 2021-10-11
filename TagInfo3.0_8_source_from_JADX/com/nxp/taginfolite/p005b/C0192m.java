package com.nxp.taginfolite.p005b;

import android.content.Context;
import android.support.v4.BuildConfig;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.p003g.C0422a;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p009e.p010a.C0244b;
import java.util.Arrays;
import org.jraf.android.backport.switchwidget.C0519c;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.nxp.taginfolite.b.m */
public class C0192m extends C0183d {
    private final byte[] f134h;
    private final String f135i;
    private final byte[] f136j;
    private final String f137k;

    public C0192m(int i, String str, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(i, 2, str, bArr);
        if (bArr2 != null) {
            this.f134h = Arrays.copyOf(bArr2, bArr2.length);
            this.f135i = m169a(this.f134h);
        } else {
            this.f134h = null;
            this.f135i = null;
        }
        if (bArr3 != null) {
            this.f136j = Arrays.copyOf(bArr3, bArr3.length);
            this.f137k = m169a(this.f136j);
        } else if (this.f == null || !(this.e.charAt(2) == 'r' || this.e.charAt(2) == 'x')) {
            this.f136j = null;
            this.f137k = null;
        } else {
            this.f136j = Arrays.copyOfRange(this.f, 10, this.f.length);
            this.f137k = m169a(this.f136j);
        }
    }

    public C0192m(XmlPullParser xmlPullParser) {
        int i = -1;
        Object obj = null;
        byte[] bArr = null;
        Object obj2 = null;
        String str = null;
        byte[] bArr2 = null;
        Object obj3 = null;
        String str2 = null;
        byte[] bArr3 = null;
        Object obj4 = null;
        String str3 = null;
        StringBuilder stringBuilder = new StringBuilder();
        Object obj5 = null;
        int next = xmlPullParser.next();
        StringBuilder stringBuilder2 = stringBuilder;
        while (obj5 == null && next != 1) {
            String name;
            Object obj6;
            String str4;
            Object obj7;
            String str5;
            switch (next) {
                case C0519c.Switch_textOn /*2*/:
                    name = xmlPullParser.getName();
                    if ("address".equalsIgnoreCase(name)) {
                        name = str3;
                        obj6 = obj2;
                        obj2 = obj3;
                        str4 = str2;
                        obj7 = 1;
                        str5 = str;
                        break;
                    }
                    if ("data".equalsIgnoreCase(name)) {
                        String str6 = str3;
                        int i2 = 1;
                        obj2 = obj3;
                        str4 = str2;
                        obj7 = obj;
                        str5 = xmlPullParser.getAttributeValue(null, "access");
                        name = str6;
                        break;
                    }
                    if ("keyA".equalsIgnoreCase(name)) {
                        obj7 = obj;
                        str5 = str;
                        str4 = xmlPullParser.getAttributeValue(null, "name");
                        name = str3;
                        obj6 = obj2;
                        int i3 = 1;
                        break;
                    } else if ("keyB".equalsIgnoreCase(name)) {
                        obj4 = 1;
                        name = xmlPullParser.getAttributeValue(null, "name");
                        obj6 = obj2;
                        obj2 = obj3;
                        str4 = str2;
                        obj7 = obj;
                        str5 = str;
                        break;
                    } else {
                        throw new XmlPullParserException("TagInfo_MifareTrailer Unexpected start tag (MTB): " + name);
                    }
                case C0519c.Switch_textOff /*3*/:
                    Object obj8;
                    byte[] bArr4;
                    Object obj9;
                    byte[] bArr5;
                    Object obj10;
                    byte[] bArr6;
                    Object obj11;
                    int i4;
                    name = xmlPullParser.getName();
                    if ("block".equalsIgnoreCase(name)) {
                        obj8 = 1;
                        obj5 = obj4;
                        bArr4 = bArr3;
                        obj9 = obj3;
                        bArr5 = bArr2;
                        obj10 = obj2;
                        bArr6 = bArr;
                        obj11 = obj;
                        i4 = i;
                    } else {
                        Object obj12;
                        if (!"address".equalsIgnoreCase(name) || obj == null) {
                            if (!"data".equalsIgnoreCase(name) || obj2 == null) {
                                if ("keyA".equalsIgnoreCase(name) && obj3 != null) {
                                    bArr5 = C0183d.m153a(stringBuilder2.toString().trim());
                                    obj10 = obj2;
                                    bArr6 = bArr;
                                    obj11 = obj;
                                    i4 = i;
                                    obj12 = obj5;
                                    obj5 = obj4;
                                    bArr4 = bArr3;
                                    obj9 = null;
                                    obj8 = obj12;
                                } else if (!"keyB".equalsIgnoreCase(name) || obj4 == null) {
                                    throw new XmlPullParserException("TagInfo_MifareTrailer Unexpected end tag: " + name);
                                } else {
                                    bArr4 = C0183d.m153a(stringBuilder2.toString().trim());
                                    obj9 = obj3;
                                    bArr5 = bArr2;
                                    obj10 = obj2;
                                    bArr6 = bArr;
                                    obj11 = obj;
                                    i4 = i;
                                    obj12 = obj5;
                                    obj5 = null;
                                    obj8 = obj12;
                                }
                            } else {
                                bArr6 = C0183d.m153a(stringBuilder2.toString().trim());
                                obj11 = obj;
                                i4 = i;
                                byte[] bArr7 = bArr3;
                                obj9 = obj3;
                                bArr5 = bArr2;
                                obj10 = null;
                                obj8 = obj5;
                                obj5 = obj4;
                                bArr4 = bArr7;
                            }
                        } else {
                            int parseInt;
                            try {
                                parseInt = Integer.parseInt(stringBuilder2.toString().trim());
                            } catch (NumberFormatException e) {
                                parseInt = 0;
                            }
                            obj12 = obj5;
                            obj5 = obj4;
                            bArr4 = bArr3;
                            obj9 = obj3;
                            bArr5 = bArr2;
                            obj10 = obj2;
                            bArr6 = bArr;
                            obj11 = null;
                            i4 = parseInt;
                            obj8 = obj12;
                        }
                    }
                    i = i4;
                    obj = obj11;
                    bArr = bArr6;
                    obj2 = obj10;
                    bArr2 = bArr5;
                    obj3 = obj9;
                    bArr3 = bArr4;
                    obj4 = obj5;
                    obj5 = obj8;
                    stringBuilder = new StringBuilder();
                    break;
                case C0519c.Switch_thumbTextPadding /*4*/:
                    name = str3;
                    obj6 = obj2;
                    obj2 = obj3;
                    str4 = str2;
                    obj7 = obj;
                    str5 = str;
                    break;
                default:
                    stringBuilder = stringBuilder2;
                    break;
            }
            Object text = xmlPullParser.getText();
            if (TextUtils.isEmpty(text)) {
                str = str5;
                obj = obj7;
                str2 = str4;
                obj3 = obj2;
                obj2 = obj6;
                str3 = name;
                stringBuilder = stringBuilder2;
            } else {
                stringBuilder2.append(text);
                str = str5;
                obj = obj7;
                str2 = str4;
                obj3 = obj2;
                obj2 = obj6;
                str3 = name;
                stringBuilder = stringBuilder2;
            }
            if (obj5 == null) {
                next = xmlPullParser.next();
            }
            stringBuilder2 = stringBuilder;
        }
        this.a = i;
        this.b = 2;
        this.e = str;
        this.d = 8;
        this.c = 16;
        if (bArr != null) {
            this.f = Arrays.copyOf(bArr, bArr.length);
        } else {
            this.f = null;
        }
        if (bArr2 != null) {
            this.f134h = Arrays.copyOf(bArr2, bArr2.length);
        } else {
            this.f134h = null;
        }
        this.f135i = str2;
        if (bArr3 != null) {
            this.f136j = Arrays.copyOf(bArr3, bArr3.length);
        } else {
            this.f136j = null;
        }
        this.f137k = str3;
    }

    private String m169a(byte[] bArr) {
        return C0244b.m385a(new C0422a(bArr));
    }

    public CharSequence m170a(Context context, boolean z) {
        C0428i c0428i = new C0428i();
        c0428i.m1387b(String.format("[%02X]", new Object[]{Integer.valueOf(this.a)}));
        int i;
        if (z) {
            c0428i.m1387b(" ");
            c0428i.m1387b(this.e);
            if (this.f134h == null || this.f134h.length != 6) {
                c0428i.m1387b(String.format("  XX:XX:XX:XX:XX:XX", new Object[0]));
            } else {
                c0428i.m1387b(String.format("  %02X", new Object[]{Byte.valueOf(this.f134h[0])}));
                for (i = 1; i < 6; i++) {
                    c0428i.m1387b(String.format(":%02X", new Object[]{Byte.valueOf(this.f134h[i])}));
                }
            }
            if (this.f == null || this.f.length < 10) {
                c0428i.m1387b(" --:--:-- --");
            } else {
                c0428i.m1387b(String.format(" %02X:%02X:%02X %02X", new Object[]{Byte.valueOf(this.f[6]), Byte.valueOf(this.f[7]), Byte.valueOf(this.f[8]), Byte.valueOf(this.f[9])}));
            }
            if (this.f136j == null || this.f136j.length != 6) {
                c0428i.m1387b(String.format(" XX:XX:XX:XX:XX:XX", new Object[0]));
            } else {
                c0428i.m1387b(String.format(" %02X", new Object[]{Byte.valueOf(this.f136j[0])}));
                for (i = 1; i < 6; i++) {
                    c0428i.m1387b(String.format(":%02X", new Object[]{Byte.valueOf(this.f136j[i])}));
                }
            }
            c0428i.m1387b("\n");
            String str = this.f135i;
            if (this.f135i == null) {
                str = "(unknown key)";
            }
            String str2 = this.f137k;
            if (this.f137k == null) {
                str2 = "(unknown key)";
            }
            c0428i.m1387b(String.format("          %-27s   %s", new Object[]{str, str2}));
            if (this.e.charAt(2) == 'r' || this.e.charAt(2) == 'x') {
                c0428i.m1387b(" (readable)");
            }
        } else {
            if (this.f134h == null || this.f134h.length != 6) {
                c0428i.m1387b("  XX:XX:XX:XX:XX:XX  (unknown key)");
            } else {
                c0428i.m1387b(String.format("  %02X", new Object[]{Byte.valueOf(this.f134h[0])}));
                for (i = 1; i < 6; i++) {
                    c0428i.m1387b(String.format(":%02X", new Object[]{Byte.valueOf(this.f134h[i])}));
                }
                if (this.f135i != null) {
                    c0428i.m1387b("  ");
                    c0428i.m1387b(this.f135i);
                } else {
                    c0428i.m1387b("  (unknown key)");
                }
            }
            if (this.f == null || this.f.length < 10) {
                c0428i.m1387b("\n ");
                c0428i.m1387b(this.e);
                c0428i.m1387b("  --:--:-- --");
            } else {
                c0428i.m1387b("\n ");
                c0428i.m1387b(this.e);
                c0428i.m1387b(String.format("  %02X:%02X:%02X %02X", new Object[]{Byte.valueOf(this.f[6]), Byte.valueOf(this.f[7]), Byte.valueOf(this.f[8]), Byte.valueOf(this.f[9])}));
            }
            if (this.e.charAt(2) == 'r' || this.e.charAt(2) == 'x') {
                c0428i.m1387b(String.format("\n (r)  %02X", new Object[]{Byte.valueOf(this.f[10])}));
                for (i = 11; i < 16; i++) {
                    c0428i.m1387b(String.format(":%02X", new Object[]{Byte.valueOf(this.f[i])}));
                }
                if (this.f137k != null) {
                    c0428i.m1387b("  ");
                    c0428i.m1387b(this.f137k);
                } else {
                    c0428i.m1387b("  (unknown key)");
                }
            } else if (this.f136j == null || this.f136j.length != 6) {
                c0428i.m1387b("\n      XX:XX:XX:XX:XX:XX  (unknown key)");
            } else {
                c0428i.m1387b(String.format("\n      %02X", new Object[]{Byte.valueOf(this.f136j[0])}));
                for (i = 1; i < 6; i++) {
                    c0428i.m1387b(String.format(":%02X", new Object[]{Byte.valueOf(this.f136j[i])}));
                }
                if (this.f137k != null) {
                    c0428i.m1387b("  ");
                    c0428i.m1387b(this.f137k);
                } else {
                    c0428i.m1387b("  (unknown key)");
                }
            }
        }
        c0428i.m1385a(new TextAppearanceSpan(context, R.style.item_mono));
        return c0428i.m1386b();
    }

    public String m171a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<block type=\"MifareTrailer\">\n");
        stringBuilder.append("\t<address>");
        stringBuilder.append(String.valueOf(this.a));
        stringBuilder.append("</");
        stringBuilder.append("address");
        stringBuilder.append(">\n");
        if (this.f == null || this.f.length <= 0) {
            stringBuilder.append("\t<data access=\"");
            stringBuilder.append(this.e);
            stringBuilder.append("\"/>\n");
        } else {
            stringBuilder.append("\t<data access=\"");
            stringBuilder.append(this.e).append("\">");
            stringBuilder.append(C0429j.m1393a(this.f, BuildConfig.VERSION_NAME, " "));
            stringBuilder.append("</data>\n");
        }
        stringBuilder.append("\t<keyA");
        if (!(this.f135i == null || TextUtils.isEmpty(this.f135i))) {
            stringBuilder.append(" name=\"");
            stringBuilder.append(this.f135i);
            stringBuilder.append("\"");
        }
        stringBuilder.append(">");
        if (this.f134h != null && this.f134h.length > 0) {
            stringBuilder.append(C0429j.m1393a(this.f134h, BuildConfig.VERSION_NAME, " "));
        }
        stringBuilder.append("</keyA>\n");
        stringBuilder.append("\t<keyB");
        if (!(this.f137k == null || TextUtils.isEmpty(this.f137k))) {
            stringBuilder.append(" name=\"");
            stringBuilder.append(this.f137k);
            stringBuilder.append("\"");
        }
        stringBuilder.append(">");
        if (this.f136j != null && this.f136j.length > 0) {
            stringBuilder.append(C0429j.m1393a(this.f136j, BuildConfig.VERSION_NAME, " "));
        }
        stringBuilder.append("</keyB>\n");
        stringBuilder.append("</block>\n");
        return stringBuilder.toString();
    }
}
