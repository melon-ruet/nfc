package com.nxp.taginfolite.fragments;

import com.nxp.taginfolite.p000a.aj;
import com.nxp.taginfolite.p000a.ak;

/* synthetic */ class ab {
    static final /* synthetic */ int[] f1252a;
    static final /* synthetic */ int[] f1253b;

    static {
        f1253b = new int[ak.values().length];
        try {
            f1253b[ak.ASC.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1253b[ak.DESC.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        f1252a = new int[aj.values().length];
        try {
            f1252a[aj.TIME.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f1252a[aj.TITLE.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f1252a[aj.NDEF.ordinal()] = 3;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f1252a[aj.UID.ordinal()] = 4;
        } catch (NoSuchFieldError e6) {
        }
    }
}
