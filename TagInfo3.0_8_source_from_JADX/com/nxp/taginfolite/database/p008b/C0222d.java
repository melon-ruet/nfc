package com.nxp.taginfolite.database.p008b;

import java.util.HashMap;

/* renamed from: com.nxp.taginfolite.database.b.d */
final class C0222d extends HashMap {
    C0222d() {
        put("_id", "INTEGER PRIMARY KEY AUTOINCREMENT");
        put("chip_var_user_keys_id", "INTEGER REFERENCES user_keys(_id) ON DELETE CASCADE");
        put("chip_var", "TEXT NOT NULL");
    }
}
