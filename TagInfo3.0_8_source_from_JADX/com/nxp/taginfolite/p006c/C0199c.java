package com.nxp.taginfolite.p006c;

import android.content.Context;
import android.support.v4.BuildConfig;
import android.text.TextUtils;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p005b.C0193o;

/* renamed from: com.nxp.taginfolite.c.c */
public class C0199c {
    private CharSequence f188a;
    private CharSequence f189b;
    private CharSequence f190c;
    private CharSequence f191d;
    private CharSequence f192e;
    private CharSequence f193f;
    private CharSequence f194g;
    private CharSequence f195h;
    private CharSequence f196i;
    private CharSequence f197j;

    public C0199c() {
        this.f188a = null;
        this.f189b = null;
        this.f190c = null;
        this.f191d = null;
        this.f192e = null;
        this.f193f = null;
        this.f194g = null;
        this.f195h = null;
        this.f196i = null;
        this.f197j = null;
    }

    public CharSequence m222a(Context context) {
        return "\t<section>\n" + m224a(context, "\t\t<subsection title=\"", "\">\n", "\t\t\t", "\n\t\t</subsection>\n") + "\t</" + "section" + ">\n";
    }

    public CharSequence m223a(CharSequence charSequence) {
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        CharSequence charSequence2 = this.f190c;
        String charSequence3 = this.f191d != null ? this.f191d.toString() : null;
        if ("Unknown manufacturer".equals(charSequence2)) {
            if (TextUtils.isEmpty(charSequence3) || "Unknown IC".equals(charSequence3)) {
                if ("AndroidBeam".equals(charSequence)) {
                    stringBuilder.append("NFC peer-to-peer communication");
                } else {
                    stringBuilder.append("Unknown ");
                    stringBuilder.append(charSequence);
                    stringBuilder.append(" tag");
                }
            } else if (charSequence3.startsWith("Unknown")) {
                stringBuilder.append(charSequence3);
                stringBuilder.append(" tag");
            } else {
                stringBuilder.append("Unknown ");
                stringBuilder.append(charSequence3);
                stringBuilder.append(" tag");
            }
        } else if (!TextUtils.isEmpty(charSequence3) && !"Unknown IC".equals(charSequence3)) {
            stringBuilder.append(charSequence2);
            stringBuilder.append(" ");
            stringBuilder.append(charSequence3);
            stringBuilder.append(" tag");
        } else if (!TextUtils.isEmpty(charSequence2)) {
            stringBuilder.append("Unknown ");
            stringBuilder.append(charSequence2);
            stringBuilder.append(" ");
            stringBuilder.append(charSequence);
            stringBuilder.append(" tag");
        } else if ("AndroidBeam".equals(charSequence)) {
            stringBuilder.append("NFC peer-to-peer communication");
        } else {
            stringBuilder.append("Unknown ");
            stringBuilder.append(charSequence);
            stringBuilder.append(" tag");
        }
        if (!TextUtils.isEmpty(this.f192e)) {
            stringBuilder.append(" with ");
            stringBuilder.append(this.f192e);
        }
        if (!TextUtils.isEmpty(this.f197j)) {
            stringBuilder.append(" as ");
            stringBuilder.append(this.f197j);
        }
        return stringBuilder.toString();
    }

    protected String m224a(Context context, String str, String str2, String str3, String str4) {
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        if (!TextUtils.isEmpty(this.f190c)) {
            String a = C0429j.m1391a(context.getString(R.string.title_tag_manufacturer));
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            C0193o c0193o = new C0193o(this.f190c.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f191d)) {
            a = C0429j.m1391a(context.getString(R.string.title_tag_ic_type));
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f191d.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f192e)) {
            a = C0429j.m1391a(context.getString(R.string.title_tag_os_type));
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f192e.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f197j)) {
            a = C0429j.m1391a(this.f196i);
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f197j.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f194g)) {
            a = C0429j.m1391a(this.f193f);
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f194g.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f195h)) {
            a = C0429j.m1391a(context.getString(R.string.title_tag_afi));
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f195h.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f188a)) {
            stringBuilder.append(str);
            stringBuilder.append(C0429j.m1391a(context.getString(R.string.title_tag_app_info)));
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f188a.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            if (!TextUtils.isEmpty(this.f189b)) {
                stringBuilder.append(new C0193o(this.f189b.toString()).m173a());
            }
            stringBuilder.append(str4);
        }
        return stringBuilder.toString();
    }

    public void m225a() {
        this.f188a = null;
        this.f189b = null;
        this.f190c = null;
        this.f191d = null;
        this.f192e = null;
        this.f193f = null;
        this.f194g = null;
        this.f195h = null;
        this.f196i = null;
        this.f197j = null;
    }

    public void m226a(CharSequence charSequence, CharSequence charSequence2) {
        this.f197j = charSequence2;
        this.f196i = charSequence;
    }

    public void m227b(CharSequence charSequence) {
        this.f188a = charSequence;
    }

    public void m228b(CharSequence charSequence, CharSequence charSequence2) {
        this.f193f = charSequence;
        this.f194g = charSequence2;
    }

    public void m229c(CharSequence charSequence) {
        this.f189b = charSequence;
    }

    public void m230d(CharSequence charSequence) {
        this.f190c = charSequence;
    }

    public void m231e(CharSequence charSequence) {
        this.f191d = charSequence;
    }

    public void m232f(CharSequence charSequence) {
        this.f195h = charSequence;
    }

    public void m233g(CharSequence charSequence) {
        this.f192e = charSequence;
    }
}
