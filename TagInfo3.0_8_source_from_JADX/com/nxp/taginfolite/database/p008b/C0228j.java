package com.nxp.taginfolite.database.p008b;

import java.util.HashMap;

/* renamed from: com.nxp.taginfolite.database.b.j */
final class C0228j extends HashMap {
    C0228j() {
        put("_id", "INTEGER PRIMARY KEY AUTOINCREMENT");
        put("title", "TEXT NOT NULL");
        put("chip", "TEXT NOT NULL");
        put("key_type", "TEXT NOT NULL");
        put("key_value", "BLOB NOT NULL");
        put("enabled", "INTEGER");
    }
}
