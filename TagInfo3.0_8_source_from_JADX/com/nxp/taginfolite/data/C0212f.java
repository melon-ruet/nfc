package com.nxp.taginfolite.data;

import android.support.v4.BuildConfig;
import android.text.TextUtils;
import com.nxp.taginfolite.C0158a;

/* renamed from: com.nxp.taginfolite.data.f */
public final class C0212f {
    static String f243a;
    static String f244b;
    static final String f245c;

    static {
        f243a = null;
        f244b = null;
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        stringBuilder.append("<scan>");
        stringBuilder.append("<cleared>");
        stringBuilder.append("true");
        stringBuilder.append("</cleared>");
        for (int i = 0; i < 4; i++) {
            stringBuilder.append("<section> <subsection><block type=\"text\"> <content>   </content> </block><block type=\"text\"> <content>  </content> </block> </subsection> </section>");
        }
        stringBuilder.append("</scan>");
        f245c = stringBuilder.toString();
    }

    public static String m298a() {
        if (f243a == null) {
            f243a = C0158a.m29a().m65w();
            if (TextUtils.isEmpty(f243a)) {
                f243a = f245c;
            }
        }
        return f243a;
    }

    public static void m299a(String str, String str2) {
        f243a = str;
        f244b = str2;
    }

    public static String m300b() {
        if (f244b == null) {
            f244b = C0158a.m29a().m66x();
        }
        return f244b;
    }

    public static void m301c() {
        if (!TextUtils.isEmpty(f243a)) {
            C0158a a = C0158a.m29a();
            a.m39b(f243a);
            a.m42c(f244b);
        }
    }

    public static void m302d() {
        f243a = f245c;
        f244b = BuildConfig.VERSION_NAME;
        C0212f.m301c();
    }
}
