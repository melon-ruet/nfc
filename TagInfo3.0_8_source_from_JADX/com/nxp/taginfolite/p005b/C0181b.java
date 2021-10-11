package com.nxp.taginfolite.p005b;

import android.content.Context;
import android.support.v4.BuildConfig;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.nxp.taginfolite.b.b */
public class C0181b {
    public static C0180a m146a(Context context, XmlPullParser xmlPullParser) {
        C0180a c0180a = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "type");
        if (attributeValue == null) {
            attributeValue = BuildConfig.VERSION_NAME;
        }
        if (attributeValue.equalsIgnoreCase("text")) {
            c0180a = new C0193o(context, xmlPullParser);
        } else if (attributeValue.equalsIgnoreCase("MifareData")) {
            c0180a = new C0191l(xmlPullParser);
        } else if (attributeValue.equalsIgnoreCase("MifareTrailer")) {
            c0180a = new C0192m(xmlPullParser);
        } else if (attributeValue.equalsIgnoreCase("FelicaLite")) {
            c0180a = new C0187g(xmlPullParser);
        } else if (attributeValue.equalsIgnoreCase("DesFire")) {
            c0180a = new C0185e(xmlPullParser);
        } else if (attributeValue.equalsIgnoreCase("Icode")) {
            c0180a = new C0189j(xmlPullParser);
        } else if (attributeValue.equalsIgnoreCase("Ultralight")) {
            c0180a = new C0195p(xmlPullParser);
        } else if (attributeValue.equalsIgnoreCase("File")) {
            c0180a = new C0184h(xmlPullParser);
        } else if (attributeValue.equalsIgnoreCase(BuildConfig.VERSION_NAME)) {
            c0180a = new C0183d(xmlPullParser);
        } else if (attributeValue.equalsIgnoreCase("mad")) {
            c0180a = new C0190k(xmlPullParser);
        }
        if (c0180a != null) {
            return c0180a;
        }
        throw new XmlPullParserException("Can't create block for type:" + attributeValue);
    }
}
