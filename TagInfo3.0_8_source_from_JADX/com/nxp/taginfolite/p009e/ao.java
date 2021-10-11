package com.nxp.taginfolite.p009e;

import java.util.EnumMap;

/* renamed from: com.nxp.taginfolite.e.ao */
final class ao extends EnumMap {
    ao(Class cls) {
        super(cls);
        put(ar.NXP, "NXP Semiconductors");
        put(ar.INFINEON, "Infineon Technologies AG");
        put(ar.FUDAN, "Fudan Microelectronics");
        put(ar.HUAHONG, "Hua Hong Group");
        put(ar.QUANRAY, "Quanray Electronics");
        put(ar.UNKNOWN, "Unknown manufacturer");
    }
}
