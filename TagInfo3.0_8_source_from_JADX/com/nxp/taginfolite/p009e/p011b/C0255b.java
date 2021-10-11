package com.nxp.taginfolite.p009e.p011b;

import android.support.v4.media.TransportMediator;
import android.util.SparseArray;

/* renamed from: com.nxp.taginfolite.e.b.b */
final class C0255b extends SparseArray {
    C0255b() {
        put(0, "Operation OK");
        put(12, "No Changes");
        put(14, "Out of EEPROM");
        put(28, "Illegal Command Code");
        put(30, "Integrity Error");
        put(64, "No Such Key");
        put(TransportMediator.KEYCODE_MEDIA_PLAY, "Length Error");
        put(-99, "Permission Denied");
        put(-98, "Parameter Error");
        put(-96, "Application Not Found");
        put(-95, "Application Integrity Error");
        put(-82, "Authentication Error");
        put(-81, "Additional Frame");
        put(-66, "Boundary Error");
        put(-63, "Card Integrity Error");
        put(-54, "Command Aborted");
        put(-51, "Card Disabled Error");
        put(-50, "Count Error");
        put(-34, "Duplicate Error");
        put(-18, "EEPROM Error");
        put(-16, "File Not Found");
        put(-15, "File Integrity Error");
    }
}
