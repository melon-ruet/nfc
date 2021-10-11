package com.nxp.taginfolite.database.p008b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.nxp.taginfolite.database.b.m */
public final class C0231m extends C0220o {
    public static final Map f276a;

    static {
        f276a = new HashMap();
        f276a.put("_id", "INTEGER PRIMARY KEY AUTOINCREMENT");
        f276a.put("uid", "TEXT");
        f276a.put("taglost", "INTEGER");
        f276a.put("title", "TEXT");
        f276a.put("data", "TEXT");
        f276a.put("comment", "TEXT");
        f276a.put("hasndef", "INTEGER");
        f276a.put("ndef", "BLOB");
    }

    protected C0231m() {
        super("scan", f276a);
    }

    public static long m337a(Cursor cursor, ContentValues contentValues) {
        if (cursor == null || !cursor.moveToFirst()) {
            return -1;
        }
        int columnIndex = cursor.getColumnIndex("data");
        String asString = contentValues.getAsString("data");
        while (!C0231m.m340a(cursor.getString(columnIndex), asString)) {
            if (!cursor.moveToNext()) {
                return -1;
            }
        }
        return cursor.getLong(cursor.getColumnIndex("_id"));
    }

    public static long m338a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        String[] strArr = new String[]{"_id", "data"};
        String str = "uid= '" + contentValues.getAsString("uid") + "'";
        return C0231m.m337a(sQLiteDatabase.query("scan", strArr, str, null, null, null, null), contentValues);
    }

    public static C0231m m339a() {
        return (C0231m) C0220o.m321a(C0231m.class);
    }

    private static boolean m340a(String str, String str2) {
        boolean z = true;
        if (str == null || str2 == null) {
            if (str != str2) {
                z = false;
            }
            return z;
        }
        String[] split = str.split("</date>", 2);
        String[] split2 = str2.split("</date>", 2);
        return (split == null || split2 == null || split.length <= 1 || split2.length <= 1) ? false : TextUtils.equals(split[1].replaceAll(">[\\t\\r\\n ]*<", "><"), split2[1].replaceAll(">[\\t\\r\\n ]*<", "><"));
    }

    public long m341a(SQLiteOpenHelper sQLiteOpenHelper, ContentValues contentValues) {
        long a = C0231m.m338a(sQLiteOpenHelper.getReadableDatabase(), contentValues);
        if (a != -1) {
            return a;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("uid", contentValues.getAsString("uid"));
        contentValues2.put("taglost", contentValues.getAsBoolean("taglost"));
        contentValues2.put("title", contentValues.getAsString("title"));
        contentValues2.put("data", contentValues.getAsString("data"));
        contentValues2.put("comment", contentValues.getAsString("comment"));
        contentValues2.put("hasndef", contentValues.getAsBoolean("hasndef"));
        contentValues2.put("ndef", contentValues.getAsByteArray("ndef"));
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        return writableDatabase == null ? -1 : writableDatabase.insertOrThrow("scan", null, contentValues2);
    }
}
