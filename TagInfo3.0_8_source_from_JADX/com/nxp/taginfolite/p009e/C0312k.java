package com.nxp.taginfolite.p009e;

import android.util.SparseArray;

/* renamed from: com.nxp.taginfolite.e.k */
final class C0312k extends SparseArray {
    C0312k() {
        append(0, " Area Code             ");
        append(4, " Random Access R/W     ");
        append(5, " Random Access R/O     ");
        append(6, " Cyclic Access R/W     ");
        append(7, " Cyclic Access R/O     ");
        append(8, " Purse (Direct)        ");
        append(9, " Purse (Cashback/Decr.)");
        append(10, " Purse (Decrement)     ");
        append(11, " Purse (Read Only)     ");
        append(-1, " INVALID or UNKNOWN    ");
    }
}
