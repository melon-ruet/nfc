package com.nxp.taginfolite.p006c;

import android.content.Context;
import android.support.v4.BuildConfig;
import android.text.TextUtils;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p005b.C0190k;
import com.nxp.taginfolite.p005b.C0193o;
import com.nxp.taginfolite.p005b.C0194n;

/* renamed from: com.nxp.taginfolite.c.a */
public class C0197a {
    private CharSequence f152a;
    private CharSequence f153b;
    private CharSequence f154c;
    private CharSequence f155d;
    private CharSequence f156e;
    private CharSequence f157f;
    private CharSequence f158g;
    private CharSequence f159h;
    private CharSequence f160i;
    private String f161j;
    private String f162k;
    private CharSequence f163l;
    private CharSequence f164m;
    private CharSequence f165n;
    private CharSequence f166o;
    private CharSequence f167p;
    private CharSequence f168q;
    private CharSequence f169r;
    private CharSequence f170s;
    private CharSequence f171t;
    private CharSequence f172u;
    private CharSequence f173v;
    private CharSequence f174w;
    private CharSequence f175x;

    public C0197a() {
        this.f152a = null;
        this.f153b = null;
        this.f154c = null;
        this.f155d = null;
        this.f156e = null;
        this.f157f = null;
        this.f158g = null;
        this.f159h = null;
        this.f160i = null;
        this.f161j = null;
        this.f162k = null;
        this.f163l = null;
        this.f164m = null;
        this.f165n = null;
        this.f166o = null;
        this.f167p = null;
        this.f168q = null;
        this.f169r = null;
        this.f170s = null;
        this.f171t = null;
        this.f172u = null;
        this.f173v = null;
        this.f174w = null;
        this.f175x = null;
    }

    public CharSequence m189a(Context context) {
        return "\t<section>\n" + m190a(context, "\t\t<subsection title=\"", "\">\n", "\t\t\t", "\n\t\t</subsection>\n") + "\t</" + "section" + ">\n";
    }

    protected String m190a(Context context, String str, String str2, String str3, String str4) {
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        if (!TextUtils.isEmpty(this.f153b)) {
            if (TextUtils.isEmpty(this.f152a)) {
                this.f152a = context.getString(R.string.title_extra_mem_size);
            }
            String a = C0429j.m1391a(this.f152a);
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            C0193o c0193o = new C0193o(this.f153b.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f155d)) {
            if (TextUtils.isEmpty(this.f154c)) {
                this.f154c = context.getString(R.string.title_extra_mf_mem_size);
            }
            stringBuilder.append(str);
            stringBuilder.append(C0429j.m1391a(this.f154c));
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f155d.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f156e)) {
            a = C0429j.m1391a(context.getString(R.string.title_extra_ic));
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f156e.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f157f)) {
            a = C0429j.m1391a(context.getString(R.string.title_extra_sec_level));
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f157f.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f171t)) {
            a = C0429j.m1391a(this.f170s);
            if (TextUtils.isEmpty(a)) {
                a = C0429j.m1391a(context.getString(R.string.title_extra_ats));
            }
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f171t.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f161j)) {
            a = C0429j.m1391a(this.f160i);
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            stringBuilder.append(str3);
            stringBuilder.append(this.f161j);
            if (!TextUtils.isEmpty(this.f162k)) {
                stringBuilder.append(this.f162k);
            }
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f164m)) {
            a = C0429j.m1391a(this.f163l);
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0194n(this.f164m.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f159h)) {
            a = this.f158g.toString();
            if (TextUtils.isEmpty(this.f158g)) {
                a = C0429j.m1391a(context.getString(R.string.title_extra_desfire));
            }
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f159h.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f166o)) {
            a = C0429j.m1391a(this.f165n);
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f166o.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f167p)) {
            a = C0429j.m1391a(context.getString(R.string.title_extra_cplc));
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f167p.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f169r)) {
            a = C0429j.m1391a(this.f168q);
            if (TextUtils.isEmpty(a)) {
                a = C0429j.m1391a(context.getString(R.string.title_extra_jcop));
            }
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f169r.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f173v)) {
            a = C0429j.m1391a(this.f172u);
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f173v.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f175x)) {
            a = C0429j.m1391a(this.f174w);
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f175x.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        return stringBuilder.toString();
    }

    public void m191a() {
        this.f152a = null;
        this.f153b = null;
        this.f155d = null;
        this.f156e = null;
        this.f157f = null;
        this.f159h = null;
        this.f160i = null;
        this.f161j = null;
        this.f162k = null;
        this.f163l = null;
        this.f164m = null;
        this.f165n = null;
        this.f166o = null;
        this.f167p = null;
        this.f169r = null;
        this.f170s = null;
        this.f171t = null;
        this.f172u = null;
        this.f173v = null;
        this.f174w = null;
        this.f175x = null;
    }

    public void m192a(C0190k c0190k) {
        this.f162k = c0190k.m166a();
    }

    public void m193a(CharSequence charSequence) {
        this.f153b = charSequence;
    }

    public void m194a(CharSequence charSequence, C0190k c0190k) {
        this.f160i = charSequence;
        this.f161j = c0190k.m166a();
    }

    public void m195a(CharSequence charSequence, CharSequence charSequence2) {
        this.f174w = charSequence;
        this.f175x = charSequence2;
    }

    public void m196b(CharSequence charSequence) {
        this.f155d = charSequence;
    }

    public void m197b(CharSequence charSequence, CharSequence charSequence2) {
        this.f152a = charSequence;
        this.f153b = charSequence2;
    }

    public void m198c(CharSequence charSequence) {
        this.f156e = charSequence;
    }

    public void m199c(CharSequence charSequence, CharSequence charSequence2) {
        this.f154c = charSequence;
        this.f155d = charSequence2;
    }

    public void m200d(CharSequence charSequence) {
        this.f157f = charSequence;
    }

    public void m201d(CharSequence charSequence, CharSequence charSequence2) {
        this.f158g = charSequence;
        this.f159h = charSequence2;
    }

    public void m202e(CharSequence charSequence) {
        this.f167p = charSequence;
    }

    public void m203e(CharSequence charSequence, CharSequence charSequence2) {
        this.f172u = charSequence;
        this.f173v = charSequence2;
    }

    public void m204f(CharSequence charSequence) {
        this.f169r = charSequence;
    }

    public void m205f(CharSequence charSequence, CharSequence charSequence2) {
        this.f163l = charSequence;
        this.f164m = charSequence2;
    }

    public void m206g(CharSequence charSequence) {
        this.f171t = charSequence;
    }

    public void m207g(CharSequence charSequence, CharSequence charSequence2) {
        this.f165n = charSequence;
        this.f166o = charSequence2;
    }

    public void m208h(CharSequence charSequence, CharSequence charSequence2) {
        this.f168q = charSequence;
        this.f169r = charSequence2;
    }

    public void m209i(CharSequence charSequence, CharSequence charSequence2) {
        this.f170s = charSequence;
        this.f171t = charSequence2;
    }
}
