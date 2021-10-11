package com.nxp.taginfolite.database;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.p003g.C0422a;
import com.nxp.taginfolite.p005b.C0180a;
import com.nxp.taginfolite.p005b.C0181b;
import com.nxp.taginfolite.p005b.C0182c;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.jraf.android.backport.switchwidget.C0519c;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.nxp.taginfolite.database.e */
public class C0236e {
    private final Context f293a;
    private final String f294b;
    private C0238g f295c;
    private C0238g f296d;
    private final C0233b f297e;
    private List[] f298f;
    private String f299g;
    private String f300h;
    private String f301i;
    private String f302j;
    private boolean f303k;
    private boolean f304l;
    private boolean f305m;
    private byte[] f306n;
    private boolean f307o;
    private int f308p;
    private List f309q;
    private String f310r;
    private C0182c f311s;
    private String f312t;
    private StringBuilder f313u;

    public C0236e(Context context, String str) {
        this.f295c = C0238g.UNKNOWN;
        this.f296d = C0238g.UNKNOWN;
        this.f297e = null;
        this.f293a = context;
        this.f294b = str;
        this.f298f = null;
    }

    private void m363a(XmlPullParser xmlPullParser) {
        if (this.f295c != C0238g.UNKNOWN_TAG) {
            String name = xmlPullParser.getName();
            if ("scan".equalsIgnoreCase(name)) {
                this.f295c = C0238g.SCAN;
            } else if ("title".equalsIgnoreCase(name)) {
                this.f313u = new StringBuilder();
                this.f295c = C0238g.TITLE;
            } else if ("date".equalsIgnoreCase(name)) {
                this.f313u = new StringBuilder();
                this.f295c = C0238g.DATE;
            } else if ("uid".equalsIgnoreCase(name)) {
                this.f313u = new StringBuilder();
                this.f303k = Boolean.parseBoolean(xmlPullParser.getAttributeValue(null, "nxp"));
                this.f295c = C0238g.UID;
            } else if ("version".equalsIgnoreCase(name)) {
                this.f313u = new StringBuilder();
                this.f295c = C0238g.VERSION;
            } else if ("taglost".equalsIgnoreCase(name)) {
                this.f313u = new StringBuilder();
                this.f295c = C0238g.TAG_LOST;
            } else if ("ndef".equalsIgnoreCase(name)) {
                this.f313u = new StringBuilder();
                this.f295c = C0238g.NDEF;
            } else if ("hasndef".equalsIgnoreCase(name)) {
                this.f313u = new StringBuilder();
                this.f295c = C0238g.HAS_NDEF;
            } else if ("cleared".equalsIgnoreCase(name)) {
                this.f313u = new StringBuilder();
                this.f295c = C0238g.CLEARED;
            } else if ("section".equalsIgnoreCase(name)) {
                this.f309q = new ArrayList();
                this.f295c = C0238g.SECTION;
            } else if ("subsection".equalsIgnoreCase(name)) {
                this.f310r = xmlPullParser.getAttributeValue(null, "title");
                this.f311s = new C0182c();
                int next = xmlPullParser.next();
                while (next != 1) {
                    C0180a a;
                    switch (next) {
                        case C0519c.Switch_textOn /*2*/:
                            name = xmlPullParser.getName();
                            if ("block".equalsIgnoreCase(name)) {
                                a = C0181b.m146a(this.f293a, xmlPullParser);
                                if (a == null) {
                                    break;
                                }
                                this.f311s.m147a(a);
                                break;
                            }
                            Log.e("TagInfo_ScanXmlPullParser", "Unexpected start tag found: " + name);
                            Log.v("TagInfo_ScanXmlPullParser", "XML line: " + xmlPullParser.getLineNumber());
                            throw new XmlPullParserException("Unexpected start tag found!");
                        case C0519c.Switch_textOff /*3*/:
                            name = xmlPullParser.getName();
                            if ("subsection".equalsIgnoreCase(name)) {
                                List<C0180a> a2 = this.f311s.m150a();
                                if (a2.size() > 0) {
                                    this.f309q.add(new C0235d(this.f310r, new C0182c().m147a((C0180a) a2.remove(0))));
                                    for (C0180a a3 : a2) {
                                        C0182c c0182c = new C0182c();
                                        c0182c.m147a(a3);
                                        this.f309q.add(new C0235d(null, c0182c));
                                    }
                                } else {
                                    this.f309q.add(new C0235d(this.f310r, this.f311s));
                                }
                                this.f295c = C0238g.SECTION;
                                return;
                            }
                            Log.e("TagInfo_ScanXmlPullParser", "Unexpected end tag found: " + name);
                            throw new XmlPullParserException("Unexpected end tag found!");
                        case C0519c.Switch_thumbTextPadding /*4*/:
                            name = xmlPullParser.getText();
                            if (!(this.f295c == C0238g.DOC || this.f295c == C0238g.SCAN || TextUtils.isEmpty(name) || name.trim().isEmpty())) {
                                Log.e("TagInfo_ScanXmlPullParser", "Orphan text found: " + name + " {" + this.f295c + "}");
                                throw new XmlPullParserException("Orphan text found!");
                            }
                        default:
                            Log.e("TagInfo_ScanXmlPullParser", "Unknown XPP event: " + next);
                            throw new XmlPullParserException("Unknown XPP event!");
                    }
                    next = xmlPullParser.next();
                }
                this.f295c = C0238g.SUBSECTION;
            } else if ("block".equalsIgnoreCase(name)) {
                this.f295c = C0238g.BLOCK;
            } else {
                this.f296d = this.f295c;
                this.f295c = C0238g.UNKNOWN_TAG;
                this.f312t = name;
            }
        }
    }

    private void m364b(XmlPullParser xmlPullParser) {
        switch (C0237f.f314a[this.f295c.ordinal()]) {
            case C0519c.Switch_track /*1*/:
                this.f295c = C0238g.DOC;
            case C0519c.Switch_textOn /*2*/:
                this.f299g = this.f313u.toString();
                this.f295c = C0238g.SCAN;
            case C0519c.Switch_textOff /*3*/:
                this.f300h = this.f313u.toString();
                this.f295c = C0238g.SCAN;
            case C0519c.Switch_thumbTextPadding /*4*/:
                this.f302j = this.f313u.toString();
                this.f295c = C0238g.SCAN;
            case C0519c.Switch_switchTextAppearance /*5*/:
                this.f301i = this.f313u.toString();
                this.f295c = C0238g.SCAN;
            case C0519c.Switch_switchMinWidth /*6*/:
                this.f304l = Boolean.parseBoolean(this.f313u.toString());
                this.f295c = C0238g.SCAN;
            case C0519c.Switch_switchPadding /*7*/:
                this.f306n = C0422a.m1360a(this.f313u.toString());
                this.f295c = C0238g.SCAN;
            case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                this.f305m = Boolean.parseBoolean(this.f313u.toString());
                this.f295c = C0238g.SCAN;
            case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                this.f307o = Boolean.parseBoolean(this.f313u.toString());
                this.f295c = C0238g.SCAN;
            case C0086R.styleable.SherlockTheme_actionMenuTextAppearance /*10*/:
                List[] listArr = this.f298f;
                int i = this.f308p;
                this.f308p = i + 1;
                listArr[i] = this.f309q;
                this.f295c = C0238g.SCAN;
            case C0086R.styleable.SherlockTheme_actionMenuTextColor /*11*/:
                Log.v("TagInfo_ScanXmlPullParser", "WHY IS THIS CODE CALLED????");
                List<C0180a> a = this.f311s.m150a();
                if (a.size() > 0) {
                    this.f309q.add(new C0235d(this.f310r, new C0182c().m147a((C0180a) a.remove(0))));
                    for (C0180a c0180a : a) {
                        C0182c c0182c = new C0182c();
                        c0182c.m147a(c0180a);
                        this.f309q.add(new C0235d(null, c0182c));
                    }
                } else {
                    this.f309q.add(new C0235d(this.f310r, this.f311s));
                }
                this.f295c = C0238g.SECTION;
            case C0086R.styleable.SherlockTheme_actionModeStyle /*12*/:
                this.f295c = C0238g.SUBSECTION;
            case C0086R.styleable.SherlockTheme_actionModeCloseButtonStyle /*13*/:
                this.f295c = C0238g.DOC;
            case C0086R.styleable.SherlockTheme_actionModeBackground /*14*/:
                if (xmlPullParser.getName().equalsIgnoreCase(this.f312t)) {
                    this.f295c = this.f296d;
                }
            default:
                this.f295c = C0238g.UNKNOWN;
        }
    }

    public C0233b m365a() {
        if (this.f297e != null) {
            return this.f297e;
        }
        this.f298f = new ArrayList[4];
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            if (this.f294b == null) {
                throw new IOException("XML is null");
            }
            newPullParser.setInput(new StringReader(this.f294b));
            this.f308p = 0;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case C0519c.Switch_thumb /*0*/:
                        this.f295c = C0238g.DOC;
                        break;
                    case C0519c.Switch_textOn /*2*/:
                        m363a(newPullParser);
                        break;
                    case C0519c.Switch_textOff /*3*/:
                        m364b(newPullParser);
                        break;
                    case C0519c.Switch_thumbTextPadding /*4*/:
                        String text = newPullParser.getText();
                        if (this.f295c != C0238g.UNKNOWN_TAG) {
                            if (this.f295c != C0238g.DOC && this.f295c != C0238g.SCAN) {
                                this.f313u.append(text);
                                break;
                            } else if (!(TextUtils.isEmpty(text) || text.trim().isEmpty())) {
                                Log.e("TagInfo_ScanXmlPullParser", "Orphan text found: " + text + " {" + this.f295c + "}");
                                throw new XmlPullParserException("Orphan text found!");
                            }
                        }
                        continue;
                        break;
                    default:
                        Log.e("TagInfo_ScanXmlPullParser", "Unknown XPP event: " + eventType);
                        throw new XmlPullParserException("Unknown XPP event!");
                }
            }
            return new C0233b(this.f294b, this.f298f, this.f299g, this.f300h, this.f302j, this.f303k, this.f304l, this.f305m, this.f306n, this.f307o, this.f301i);
        } catch (XmlPullParserException e) {
            Log.e("TagInfo_ScanXmlPullParser", "XML format error: " + e.getMessage() + " " + this.f294b);
            throw e;
        } catch (IOException e2) {
            Log.e("TagInfo_ScanXmlPullParser", "I/O Exception: " + e2.getMessage());
            return null;
        }
    }
}
