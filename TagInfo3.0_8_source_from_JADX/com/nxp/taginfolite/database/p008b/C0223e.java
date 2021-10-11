package com.nxp.taginfolite.database.p008b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Map;

/* renamed from: com.nxp.taginfolite.database.b.e */
public class C0223e extends C0220o {
    static final Map f266a;
    public static final String[] f267b;

    static {
        f266a = new C0224f();
        f267b = new String[]{"_id", "key_selector_user_keys_id", "selector_type", "selector_value"};
    }

    protected C0223e() {
        super("key_selector", f266a);
    }

    public static C0223e m326a() {
        return (C0223e) C0220o.m321a(C0223e.class);
    }

    public long m327a(SQLiteOpenHelper sQLiteOpenHelper, ContentValues contentValues) {
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("key_selector_user_keys_id", contentValues.getAsString("key_selector_user_keys_id"));
        contentValues2.put("selector_type", contentValues.getAsString("selector_type"));
        contentValues2.put("selector_value", contentValues.getAsString("selector_value"));
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        return writableDatabase == null ? -1 : writableDatabase.insertOrThrow("key_selector", null, contentValues2);
    }

    public long m328a(SQLiteOpenHelper sQLiteOpenHelper, ContentValues contentValues, String str, String[] strArr) {
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("key_selector_user_keys_id", contentValues.getAsString("key_selector_user_keys_id"));
        contentValues2.put("selector_type", contentValues.getAsString("selector_type"));
        contentValues2.put("selector_value", contentValues.getAsString("selector_value"));
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        return writableDatabase == null ? -1 : (long) writableDatabase.update("key_selector", contentValues2, str, strArr);
    }
}
