package com.nxp.taginfolite.p004f.p015a;

/* renamed from: com.nxp.taginfolite.f.a.d */
public enum C0332d {
    UNIVERSAL(0),
    APPLICATION(1),
    CONTEXT_SPECIFIC(2),
    PRIVATE(3);
    
    int f969e;

    private C0332d(int i) {
        this.f969e = i;
    }

    public static C0332d m951a(byte b) {
        int i = (b & 192) >>> 6;
        for (C0332d c0332d : C0332d.values()) {
            if (c0332d.f969e == i) {
                return c0332d;
            }
        }
        return null;
    }
}
