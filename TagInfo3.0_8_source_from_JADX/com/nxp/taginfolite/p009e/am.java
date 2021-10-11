package com.nxp.taginfolite.p009e;

import android.support.v4.BuildConfig;
import java.util.EnumMap;

/* renamed from: com.nxp.taginfolite.e.am */
final class am extends EnumMap {
    am(Class cls) {
        super(cls);
        put(aw.SL1, "Security Level 1");
        put(aw.NONE, BuildConfig.VERSION_NAME);
    }
}
