package com.nxp.taginfolite.database.p008b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Map;

/* renamed from: com.nxp.taginfolite.database.b.g */
public class C0225g extends C0220o {
    static final Map f268a;
    static final String[] f269b;

    static {
        f268a = new C0226h();
        f269b = new String[]{"_id", "key_subselector_user_keys_id", "subselector", "subselector_value"};
    }

    protected C0225g() {
        super("key_subselector", f268a);
    }

    public static C0225g m329a() {
        return (C0225g) C0220o.m321a(C0225g.class);
    }

    public long m330a(SQLiteOpenHelper sQLiteOpenHelper, ContentValues contentValues) {
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("key_subselector_user_keys_id", contentValues.getAsString("key_subselector_user_keys_id"));
        contentValues2.put("subselector", contentValues.getAsString("subselector"));
        contentValues2.put("subselector_value", contentValues.getAsString("subselector_value"));
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        return writableDatabase == null ? -1 : writableDatabase.insertOrThrow("key_subselector", null, contentValues2);
    }

    public long m331a(SQLiteOpenHelper sQLiteOpenHelper, ContentValues contentValues, String str, String[] strArr) {
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("key_subselector_user_keys_id", contentValues.getAsString("key_subselector_user_keys_id"));
        contentValues2.put("subselector", contentValues.getAsString("subselector"));
        contentValues2.put("subselector_value", contentValues.getAsString("subselector_value"));
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        return writableDatabase == null ? -1 : (long) writableDatabase.update("key_subselector", contentValues2, str, strArr);
    }
}
