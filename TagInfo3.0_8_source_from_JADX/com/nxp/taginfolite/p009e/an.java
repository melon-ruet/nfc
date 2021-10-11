package com.nxp.taginfolite.p009e;

import android.support.v4.BuildConfig;
import java.util.EnumMap;

/* renamed from: com.nxp.taginfolite.e.an */
final class an extends EnumMap {
    an(Class cls) {
        super(cls);
        put(at.S, "S");
        put(at.X, "X");
        put(at.NONE, BuildConfig.VERSION_NAME);
        put(at.UNKNOWN, "Unknown");
    }
}
