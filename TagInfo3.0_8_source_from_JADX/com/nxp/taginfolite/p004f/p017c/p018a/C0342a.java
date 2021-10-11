package com.nxp.taginfolite.p004f.p017c.p018a;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.util.SparseArray;

/* renamed from: com.nxp.taginfolite.f.c.a.a */
public class C0342a {
    private static final SparseArray f1046a;

    static {
        f1046a = new SparseArray();
        f1046a.put(0, "Operation OK [DESFire]");
        f1046a.put(12, "No Changes [DESFire]");
        f1046a.put(14, "Out of EEPROM [DESFire]");
        f1046a.put(28, "Illegal command code [DESFire]");
        f1046a.put(30, "Integrity error [DESFire]");
        f1046a.put(64, "No such key [DESFire]");
        f1046a.put(TransportMediator.KEYCODE_MEDIA_PLAY, "Length error [DESFire]");
        f1046a.put(157, "Permission denied [DESFire]");
        f1046a.put(158, "Parameter error [DESFire]");
        f1046a.put(160, "Application not found [DESFire]");
        f1046a.put(161, "Application integrity error [DESFire]");
        f1046a.put(174, "Authentication error [DESFire]");
        f1046a.put(175, "Additional frame [DESFire]");
        f1046a.put(190, "Boundary error [DESFire]");
        f1046a.put(193, "Card integrity error [DESFire]");
        f1046a.put(202, "Command aborted [DESFire]");
        f1046a.put(205, "Card disabled error [DESFire]");
        f1046a.put(206, "Count error [DESFire]");
        f1046a.put(222, "Duplicate error [DESFire]");
        f1046a.put(238, "EEPROM error [DESFire]");
        f1046a.put(240, "File not found [DESFire]");
        f1046a.put(241, "File integrity error [DESFire]");
    }

    public static String m982a(int i) {
        return ((i >> 8) & MotionEventCompat.ACTION_MASK) != 145 ? null : (String) f1046a.get(i);
    }
}
