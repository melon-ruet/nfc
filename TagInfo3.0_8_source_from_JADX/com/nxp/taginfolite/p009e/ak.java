package com.nxp.taginfolite.p009e;

import java.util.EnumMap;

/* renamed from: com.nxp.taginfolite.e.ak */
final class ak extends EnumMap {
    ak(Class cls) {
        super(cls);
        put(av.CLASSIC, "MIFARE Classic");
        put(av.PLUS, "MIFARE Plus");
        put(av.PRO, "MIFARE Pro");
    }
}
