package com.nxp.taginfolite.p005b;

import android.content.Context;
import android.support.v4.BuildConfig;
import com.nxp.taginfolite.p003g.C0428i;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.nxp.taginfolite.b.c */
public class C0182c {
    private final List f122a;

    public C0182c() {
        this.f122a = new ArrayList();
    }

    public C0182c m147a(C0180a c0180a) {
        this.f122a.add(c0180a);
        return this;
    }

    public C0182c m148a(C0182c c0182c) {
        this.f122a.addAll(c0182c.f122a);
        return this;
    }

    public CharSequence m149a(Context context, boolean z) {
        C0428i c0428i = new C0428i();
        new C0182c().f122a.addAll(this.f122a);
        c0428i.m1387b(BuildConfig.VERSION_NAME);
        for (C0180a a : this.f122a) {
            c0428i.m1384a(a.m144a(context, z));
        }
        return c0428i.m1386b();
    }

    public List m150a() {
        return this.f122a;
    }

    public String m151b() {
        C0428i c0428i = new C0428i();
        c0428i.m1387b(BuildConfig.VERSION_NAME);
        for (C0180a a : this.f122a) {
            c0428i.m1384a(a.m145a());
        }
        return c0428i.toString();
    }

    public boolean m152c() {
        for (C0180a c0180a : this.f122a) {
            if ((c0180a instanceof C0193o) && ((C0193o) c0180a).m174b()) {
                return true;
            }
        }
        return false;
    }
}
