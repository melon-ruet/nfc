package com.nxp.taginfolite.data;

import java.util.Map;

/* renamed from: com.nxp.taginfolite.data.b */
public class C0208b {
    private static final Map f225a;

    static {
        f225a = new C0209c();
    }

    public static int m280a(String str) {
        Integer num = (Integer) f225a.get(str);
        return num == null ? 0 : num.intValue();
    }
}
