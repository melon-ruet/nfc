package com.nxp.taginfolite.p006c;

import android.content.Context;
import android.support.v4.BuildConfig;
import android.text.TextUtils;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p005b.C0182c;
import com.nxp.taginfolite.p005b.C0193o;

/* renamed from: com.nxp.taginfolite.c.b */
public class C0198b {
    private CharSequence f176a;
    private CharSequence f177b;
    private CharSequence f178c;
    private CharSequence f179d;
    private CharSequence f180e;
    private CharSequence f181f;
    private CharSequence f182g;
    private CharSequence f183h;
    private CharSequence f184i;
    private CharSequence f185j;
    private CharSequence f186k;
    private CharSequence f187l;

    public C0198b() {
        this.f176a = null;
        this.f177b = null;
        this.f178c = null;
        this.f179d = null;
        this.f180e = null;
        this.f181f = null;
        this.f182g = null;
        this.f183h = null;
        this.f184i = null;
        this.f185j = null;
        this.f186k = null;
        this.f187l = null;
    }

    public CharSequence m210a(Context context) {
        return m211a(context, "\t\t<subsection title=\"", "\">\n", "\t\t\t", "\n\t\t</subsection>\n");
    }

    protected String m211a(Context context, String str, String str2, String str3, String str4) {
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        if (!TextUtils.isEmpty(this.f177b)) {
            if (TextUtils.isEmpty(this.f176a)) {
                this.f176a = context.getString(R.string.title_ndef_cc);
            }
            String a = C0429j.m1391a(this.f176a);
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            C0193o c0193o = new C0193o(this.f177b.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            if (!TextUtils.isEmpty(this.f178c)) {
                stringBuilder.append(this.f178c.toString());
            }
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f180e)) {
            if (TextUtils.isEmpty(this.f179d) && TextUtils.isEmpty(this.f176a)) {
                this.f179d = context.getString(R.string.title_ndef_cc);
            } else if (!TextUtils.isEmpty(this.f176a)) {
                this.f179d = null;
            }
            a = C0429j.m1391a(this.f179d);
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f180e.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            if (!TextUtils.isEmpty(this.f181f)) {
                stringBuilder.append(this.f181f.toString());
            }
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f187l)) {
            a = C0429j.m1391a(context.getString(R.string.title_ndef_tlv));
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            stringBuilder.append(str3);
            stringBuilder.append(this.f187l.toString());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f186k)) {
            a = C0429j.m1391a(context.getString(R.string.title_ndef_fci));
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f186k.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f185j)) {
            if (TextUtils.isEmpty(this.f184i)) {
                this.f184i = context.getString(R.string.title_ndef_mifare_cc);
            }
            a = C0429j.m1391a(this.f184i);
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            c0193o = new C0193o(this.f185j.toString());
            stringBuilder.append(str3);
            stringBuilder.append(c0193o.m173a());
            stringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(this.f183h)) {
            if (TextUtils.isEmpty(this.f182g)) {
                this.f179d = context.getString(R.string.title_ndef_file);
            }
            a = C0429j.m1391a(this.f182g);
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            stringBuilder.append(str3);
            if (!TextUtils.isEmpty(this.f183h)) {
                stringBuilder.append(this.f183h.toString());
            }
            stringBuilder.append(str4);
        }
        return stringBuilder.toString();
    }

    public void m212a() {
        this.f176a = null;
        this.f177b = null;
        this.f178c = null;
        this.f179d = null;
        this.f180e = null;
        this.f184i = null;
        this.f185j = null;
        this.f181f = null;
        this.f182g = null;
        this.f183h = null;
        this.f186k = null;
        this.f187l = null;
    }

    public void m213a(C0182c c0182c) {
        this.f178c = c0182c.m151b();
    }

    public void m214a(CharSequence charSequence) {
        this.f180e = charSequence;
    }

    public void m215a(CharSequence charSequence, C0182c c0182c) {
        this.f182g = charSequence;
        this.f183h = c0182c.m151b();
    }

    public void m216a(CharSequence charSequence, CharSequence charSequence2) {
        this.f176a = charSequence;
        this.f177b = charSequence2;
    }

    public void m217b(C0182c c0182c) {
        this.f181f = c0182c.m151b();
    }

    public void m218b(CharSequence charSequence) {
        this.f186k = charSequence;
    }

    public void m219b(CharSequence charSequence, CharSequence charSequence2) {
        this.f179d = charSequence;
        this.f180e = charSequence2;
    }

    public void m220c(C0182c c0182c) {
        this.f187l = c0182c.m151b();
    }

    public void m221c(CharSequence charSequence, CharSequence charSequence2) {
        this.f184i = charSequence;
        this.f185j = charSequence2;
    }
}
