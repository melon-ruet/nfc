package com.nxp.taginfolite.database.p008b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Map;

/* renamed from: com.nxp.taginfolite.database.b.c */
public class C0221c extends C0220o {
    static final Map f264a;
    static final String[] f265b;

    static {
        f264a = new C0222d();
        f265b = new String[]{"_id", "chip_var_user_keys_id", "chip_var"};
    }

    protected C0221c() {
        super("chip_var", f264a);
    }

    public static C0221c m323a() {
        return (C0221c) C0220o.m321a(C0221c.class);
    }

    public long m324a(SQLiteOpenHelper sQLiteOpenHelper, ContentValues contentValues) {
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("chip_var_user_keys_id", contentValues.getAsString("chip_var_user_keys_id"));
        contentValues2.put("chip_var", contentValues.getAsString("chip_var"));
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        return writableDatabase == null ? -1 : writableDatabase.insertOrThrow("chip_var", null, contentValues2);
    }

    public long m325a(SQLiteOpenHelper sQLiteOpenHelper, ContentValues contentValues, String str, String[] strArr) {
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("chip_var_user_keys_id", contentValues.getAsString("chip_var_user_keys_id"));
        contentValues2.put("chip_var", contentValues.getAsString("chip_var"));
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        return writableDatabase == null ? -1 : (long) writableDatabase.update("chip_var", contentValues2, str, strArr);
    }
}
