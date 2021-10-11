package com.nxp.taginfolite.database.p008b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.nxp.taginfolite.database.b.n */
public class C0232n extends C0220o {
    public static final Map f277a;

    static {
        f277a = new HashMap();
        f277a.put("_id", "INTEGER PRIMARY KEY AUTOINCREMENT");
        f277a.put("scan_id", "INTEGER REFERENCES scan(_id) ON DELETE CASCADE");
        f277a.put("time", "TEXT");
        f277a.put("CONSTRAINT timeIdConstr", "UNIQUE(time, scan_id) ON CONFLICT IGNORE");
    }

    protected C0232n() {
        super("scan_time", f277a);
    }

    public static C0232n m342a() {
        return (C0232n) C0220o.m321a(C0232n.class);
    }

    public long m343a(SQLiteOpenHelper sQLiteOpenHelper, ContentValues contentValues) {
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("scan_id", contentValues.getAsString("scan_id"));
        contentValues2.put("time", contentValues.getAsString("time"));
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        return writableDatabase == null ? -1 : writableDatabase.insertOrThrow("scan_time", null, contentValues2);
    }
}
