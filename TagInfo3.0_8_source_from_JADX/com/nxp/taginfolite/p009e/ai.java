package com.nxp.taginfolite.p009e;

import java.util.EnumMap;

/* renamed from: com.nxp.taginfolite.e.ai */
final class ai extends EnumMap {
    ai(Class cls) {
        super(cls);
        put(au.Bytes32, Integer.valueOf(1));
        put(au.OneK, Integer.valueOf(16));
        put(au.TwoK, Integer.valueOf(32));
        put(au.FourK, Integer.valueOf(40));
        put(au.Mini, Integer.valueOf(5));
        put(au.UNKNOWN, Integer.valueOf(0));
    }
}
