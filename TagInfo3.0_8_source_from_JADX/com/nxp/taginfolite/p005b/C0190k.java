package com.nxp.taginfolite.p005b;

import android.content.Context;
import android.support.v4.BuildConfig;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.R;
import java.util.ArrayList;
import java.util.List;
import org.jraf.android.backport.switchwidget.C0519c;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.nxp.taginfolite.b.k */
public class C0190k implements C0180a {
    final List f130a;
    final CharSequence f131b;
    final CharSequence f132c;
    boolean f133d;

    public C0190k(List list) {
        this(list, "MIFARE Application IDs:", null, true);
    }

    public C0190k(List list, CharSequence charSequence, CharSequence charSequence2) {
        this(list, charSequence, charSequence2, false);
    }

    protected C0190k(List list, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        this.f130a = list;
        this.f131b = charSequence;
        this.f132c = charSequence2;
        this.f133d = z;
    }

    public C0190k(XmlPullParser xmlPullParser) {
        Object obj = null;
        boolean z = false;
        boolean m = C0158a.m29a().m55m();
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence charSequence = null;
        CharSequence stringBuilder2 = new StringBuilder();
        String attributeValue = xmlPullParser.getAttributeValue(null, "hexoutput");
        if (attributeValue != null) {
            z = Boolean.parseBoolean(attributeValue);
        }
        int next = xmlPullParser.next();
        this.f130a = new ArrayList();
        StringBuilder stringBuilder3 = stringBuilder;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        StringBuilder stringBuilder4 = stringBuilder3;
        while (obj == null && next != 1) {
            Object obj6;
            StringBuilder stringBuilder5;
            Object obj7;
            CharSequence charSequence2;
            String name;
            switch (next) {
                case C0519c.Switch_textOn /*2*/:
                    name = xmlPullParser.getName();
                    if ("aid".equalsIgnoreCase(name)) {
                        obj6 = obj;
                        obj = 1;
                        obj5 = obj3;
                        stringBuilder5 = stringBuilder4;
                        obj7 = obj4;
                        obj4 = obj2;
                        charSequence2 = charSequence;
                        break;
                    } else if ("text".equalsIgnoreCase(name)) {
                        obj6 = obj;
                        obj = obj5;
                        int i = 1;
                        stringBuilder5 = new StringBuilder();
                        obj7 = obj4;
                        obj4 = obj2;
                        charSequence2 = charSequence;
                        break;
                    } else if ("hexoutput".equalsIgnoreCase(name)) {
                        if (obj3 != null && stringBuilder4.length() > 0) {
                            stringBuilder2.append(stringBuilder4);
                        }
                        obj6 = obj;
                        obj = obj5;
                        obj5 = obj3;
                        stringBuilder5 = new StringBuilder();
                        obj7 = obj4;
                        int i2 = 1;
                        charSequence2 = charSequence;
                        break;
                    } else if ("error".equalsIgnoreCase(name)) {
                        obj6 = obj;
                        obj = obj5;
                        obj5 = obj3;
                        stringBuilder5 = new StringBuilder();
                        int i3 = 1;
                        obj4 = obj2;
                        charSequence2 = charSequence;
                        break;
                    } else {
                        throw new XmlPullParserException("TagInfo_MadText Unexpected start tag: " + name);
                    }
                case C0519c.Switch_textOff /*3*/:
                    name = xmlPullParser.getName();
                    if ("aid".equalsIgnoreCase(name)) {
                        if (obj5 != null) {
                            CharSequence stringBuilder6 = stringBuilder4.toString();
                            if (TextUtils.isEmpty(stringBuilder6)) {
                                this.f130a.add("  ----  ");
                            } else {
                                this.f130a.add(stringBuilder6);
                            }
                        }
                        obj5 = null;
                    } else if ("text".equalsIgnoreCase(name)) {
                        if (obj3 != null && stringBuilder4.length() > 0) {
                            stringBuilder2.append(stringBuilder4);
                        }
                        obj3 = null;
                    } else if ("hexoutput".equalsIgnoreCase(name)) {
                        if (m && obj2 != null && stringBuilder4.length() > 0) {
                            stringBuilder2.append(stringBuilder4);
                        }
                        obj2 = null;
                    } else if ("error".equalsIgnoreCase(name)) {
                        if (obj4 != null && stringBuilder4.length() > 0) {
                            charSequence = stringBuilder4.toString();
                        }
                        obj4 = null;
                    } else if ("block".equalsIgnoreCase(name)) {
                        int i4 = 1;
                        obj = obj5;
                        obj5 = obj3;
                        stringBuilder5 = stringBuilder4;
                        obj7 = obj4;
                        obj4 = obj2;
                        charSequence2 = charSequence;
                        break;
                    } else {
                        throw new XmlPullParserException("TagInfo_MadText Unexpected end tag: " + name);
                    }
                    obj6 = obj;
                    obj = obj5;
                    obj5 = obj3;
                    stringBuilder5 = new StringBuilder();
                    obj7 = obj4;
                    obj4 = obj2;
                    charSequence2 = charSequence;
                    break;
                case C0519c.Switch_thumbTextPadding /*4*/:
                    obj6 = xmlPullParser.getText();
                    if (!TextUtils.isEmpty(obj6)) {
                        stringBuilder4.append(obj6);
                        obj6 = obj;
                        obj = obj5;
                        obj5 = obj3;
                        stringBuilder5 = stringBuilder4;
                        obj7 = obj4;
                        obj4 = obj2;
                        charSequence2 = charSequence;
                        break;
                    }
                    obj6 = obj;
                    obj = obj5;
                    obj5 = obj3;
                    stringBuilder5 = stringBuilder4;
                    obj7 = obj4;
                    obj4 = obj2;
                    charSequence2 = charSequence;
                    break;
                default:
                    throw new XmlPullParserException("TagInfo_MadText Unknown XPP event!");
            }
            next = obj6 == null ? xmlPullParser.next() : next;
            charSequence = charSequence2;
            obj2 = obj4;
            obj4 = obj7;
            stringBuilder4 = stringBuilder5;
            obj3 = obj5;
            obj5 = obj;
            obj = obj6;
        }
        this.f131b = stringBuilder2;
        this.f132c = charSequence;
        this.f133d = z;
    }

    public CharSequence m165a(Context context, boolean z) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.f133d) {
            if (!C0158a.m29a().m55m()) {
                return BuildConfig.VERSION_NAME;
            }
            spannableStringBuilder.append("\n");
        }
        if (!TextUtils.isEmpty(this.f131b)) {
            spannableStringBuilder.append(this.f131b);
            spannableStringBuilder.append("\n");
        }
        int length = spannableStringBuilder.length();
        int i;
        if (z) {
            for (i = 0; i < this.f130a.size(); i++) {
                spannableStringBuilder.append((CharSequence) this.f130a.get(i));
                if (i % 8 == 7) {
                    spannableStringBuilder.append("\n");
                } else {
                    spannableStringBuilder.append(" ");
                }
            }
        } else {
            for (i = 0; i < this.f130a.size(); i++) {
                spannableStringBuilder.append((CharSequence) this.f130a.get(i));
                if (i % 4 == 3) {
                    spannableStringBuilder.append("\n");
                } else {
                    spannableStringBuilder.append("  ");
                }
            }
        }
        spannableStringBuilder.setSpan(new TextAppearanceSpan(context, R.style.item_mono), length, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new TextAppearanceSpan(context, R.style.item_size_12), length, spannableStringBuilder.length(), 17);
        if (!TextUtils.isEmpty(this.f132c)) {
            spannableStringBuilder.append("\n");
            spannableStringBuilder.append(this.f132c);
        }
        return spannableStringBuilder;
    }

    public String m166a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<block type=\"mad\" hexoutput=\"");
        stringBuilder.append(Boolean.toString(this.f133d));
        stringBuilder.append("\">\n\t");
        if (TextUtils.isEmpty(this.f131b)) {
            stringBuilder.append("<text/>");
        } else {
            stringBuilder.append("<text>");
            stringBuilder.append(this.f131b);
            stringBuilder.append("</text>\n");
        }
        for (String str : this.f130a) {
            if (TextUtils.isEmpty(str)) {
                stringBuilder.append("<aid/>");
            } else {
                stringBuilder.append("<aid>");
                stringBuilder.append(str);
                stringBuilder.append("</aid>");
            }
        }
        if (TextUtils.isEmpty(this.f132c)) {
            stringBuilder.append("\n<error/>");
        } else {
            stringBuilder.append("\n<error>");
            stringBuilder.append(this.f132c);
            stringBuilder.append("</error>");
        }
        stringBuilder.append("\n</block>");
        return stringBuilder.toString();
    }
}
