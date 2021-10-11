package com.nxp.taginfolite.database.p008b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Map;

/* renamed from: com.nxp.taginfolite.database.b.i */
public final class C0227i extends C0220o {
    static final Map f270a;
    public static final String[] f271b;

    static {
        f270a = new C0228j();
        f271b = new String[]{"_id", "title", "enabled", "chip", "key_type", "key_value"};
    }

    protected C0227i() {
        super("user_keys", f270a);
    }

    public static C0227i m332a() {
        return (C0227i) C0220o.m321a(C0227i.class);
    }

    public long m333a(SQLiteOpenHelper sQLiteOpenHelper, ContentValues contentValues) {
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("title", contentValues.getAsString("title"));
        contentValues2.put("chip", contentValues.getAsString("chip"));
        contentValues2.put("key_type", contentValues.getAsString("key_type"));
        contentValues2.put("key_value", contentValues.getAsByteArray("key_value"));
        contentValues2.put("enabled", Integer.valueOf(1));
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        return writableDatabase == null ? -1 : writableDatabase.insertOrThrow("user_keys", null, contentValues2);
    }

    public long m334a(SQLiteOpenHelper sQLiteOpenHelper, ContentValues contentValues, String str, String[] strArr) {
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("title", contentValues.getAsString("title"));
        contentValues2.put("chip", contentValues.getAsString("chip"));
        contentValues2.put("key_type", contentValues.getAsString("key_type"));
        contentValues2.put("key_value", contentValues.getAsByteArray("key_value"));
        contentValues2.put("enabled", contentValues.getAsInteger("enabled"));
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        return writableDatabase == null ? -1 : (long) writableDatabase.update("user_keys", contentValues2, str, strArr);
    }
}
