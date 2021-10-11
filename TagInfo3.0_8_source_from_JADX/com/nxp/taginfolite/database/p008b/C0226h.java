package com.nxp.taginfolite.database.p008b;

import java.util.HashMap;

/* renamed from: com.nxp.taginfolite.database.b.h */
final class C0226h extends HashMap {
    C0226h() {
        put("_id", "INTEGER PRIMARY KEY AUTOINCREMENT");
        put("key_subselector_user_keys_id", "INTEGER REFERENCES user_keys(_id) ON DELETE CASCADE");
        put("subselector", "TEXT NOT NULL");
        put("subselector_value", "BLOB NOT NULL");
    }
}
