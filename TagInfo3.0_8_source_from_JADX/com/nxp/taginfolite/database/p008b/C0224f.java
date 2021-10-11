package com.nxp.taginfolite.database.p008b;

import java.util.HashMap;

/* renamed from: com.nxp.taginfolite.database.b.f */
final class C0224f extends HashMap {
    C0224f() {
        put("_id", "INTEGER PRIMARY KEY AUTOINCREMENT");
        put("key_selector_user_keys_id", "INTEGER REFERENCES user_keys(_id) ON DELETE CASCADE");
        put("selector_type", "TEXT NOT NULL");
        put("selector_value", "BLOB NOT NULL");
    }
}
