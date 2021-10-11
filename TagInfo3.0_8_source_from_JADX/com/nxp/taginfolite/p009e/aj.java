package com.nxp.taginfolite.p009e;

import com.nxp.taginfolite.p004f.C0358k;
import java.util.EnumMap;

/* renamed from: com.nxp.taginfolite.e.aj */
final class aj extends EnumMap {
    aj(Class cls) {
        super(cls);
        put(au.OneK, "1\u200akB\n" + C0358k.f1076c + "16 sectors, with 4 blocks per sector\n" + C0358k.f1076c + "64 blocks, with 16 bytes per block");
        put(au.TwoK, "2\u200akB\n" + C0358k.f1076c + "32 sectors, with 4 blocks per sector\n" + C0358k.f1076c + "128 blocks, with 16 bytes per block");
        put(au.FourK, "4\u200akB\n" + C0358k.f1076c + "32 sectors of 4 blocks and 8 sectors of 16 blocks\n" + C0358k.f1076c + "256 blocks, with 16 bytes per block");
        put(au.Mini, "320 bytes\n" + C0358k.f1076c + "5 sectors, with 4 blocks per sector\n" + C0358k.f1076c + "20 blocks, with 16 bytes per block");
        put(au.Bytes32, "32 bytes\n" + C0358k.f1076c + "1 sector, with 4 blocks");
        put(au.UNKNOWN, "Unknown");
    }
}
