package com.nxp.taginfolite.p006c;

import android.content.Context;
import android.support.v4.BuildConfig;
import android.text.TextUtils;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p005b.C0182c;
import com.nxp.taginfolite.p005b.C0193o;

/* renamed from: com.nxp.taginfolite.c.d */
public class C0200d {
    private CharSequence f198a;
    private CharSequence f199b;
    private CharSequence f200c;
    private CharSequence f201d;
    private String f202e;
    private String f203f;
    private String f204g;
    private String f205h;

    public C0200d() {
        this.f198a = null;
        this.f199b = null;
        this.f200c = null;
        this.f201d = null;
        this.f202e = null;
        this.f203f = null;
        this.f204g = null;
        this.f205h = null;
    }

    public CharSequence m234a(Context context) {
        return "\t<section>\n" + m235a(context, "\t\t<subsection title=\"", "\">\n", "\t\t\t", "\n\t\t</subsection>\n") + "\t</" + "section" + ">\n";
    }

    protected String m235a(Context context, String str, String str2, String str3, String str4) {
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        if (!TextUtils.isEmpty(this.f198a)) {
            String a = C0429j.m1391a(context.getString(R.string.title_tech_technology));
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            C0193o c0193o = new C0193o(this.f198a.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f199b)) {
            a = C0429j.m1391a(context.getString(R.string.title_tech_android_technology));
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f199b.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f200c)) {
            a = C0429j.m1391a(context.getString(R.string.title_tech_proto));
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f200c.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f202e)) {
            a = C0429j.m1391a(this.f201d);
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            stringBuilder.append(str3);
            stringBuilder.append(this.f202e);
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f203f)) {
            a = C0429j.m1391a(context.getString(R.string.title_tech_mifare_hex));
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            stringBuilder.append(str3);
            stringBuilder.append(this.f203f);
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f204g)) {
            if (TextUtils.isEmpty(this.f205h)) {
                this.f205h = C0429j.m1391a(context.getString(R.string.title_tech_desfire_hex));
            }
            stringBuilder.append(str);
            stringBuilder.append(this.f205h);
            stringBuilder.append(str2);
            stringBuilder.append(str3);
            stringBuilder.append(this.f204g);
            stringBuilder.append(str4);
        }
        return stringBuilder.toString();
    }

    public void m236a() {
        this.f198a = null;
        this.f199b = null;
        this.f200c = null;
        this.f201d = null;
        this.f202e = null;
        this.f203f = null;
        this.f204g = null;
        this.f205h = null;
    }

    public void m237a(C0182c c0182c) {
        this.f201d = "Memory content";
        this.f202e = c0182c.m151b();
    }

    public void m238a(CharSequence charSequence) {
        this.f198a = charSequence;
    }

    public void m239b(C0182c c0182c) {
        this.f203f = c0182c.m151b();
    }

    public void m240b(CharSequence charSequence) {
        this.f199b = charSequence;
    }

    public void m241c(C0182c c0182c) {
        this.f205h = null;
        this.f204g = c0182c.m151b();
    }

    public void m242c(CharSequence charSequence) {
        this.f200c = charSequence;
    }
}
