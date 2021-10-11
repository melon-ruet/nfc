package com.nxp.taginfolite.database.p007a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.util.Log;
import com.nxp.taginfolite.database.p008b.C0221c;
import com.nxp.taginfolite.database.p008b.C0223e;
import com.nxp.taginfolite.database.p008b.C0225g;
import com.nxp.taginfolite.database.p008b.C0227i;

/* renamed from: com.nxp.taginfolite.database.a.a */
public class C0214a extends SQLiteOpenHelper {
    private String f253a;

    public C0214a(Context context) {
        this(context, "TagInfo_Keys");
        if (VERSION.SDK_INT < 14) {
            this.f253a = "TagInfo_Keys";
        }
    }

    protected C0214a(Context context, String str) {
        super(context, str, null, 7);
        if (VERSION.SDK_INT < 14) {
            this.f253a = str;
        }
    }

    @SuppressLint({"NewApi"})
    public String getDatabaseName() {
        return VERSION.SDK_INT < 14 ? this.f253a : super.getDatabaseName();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(C0227i.m332a().m322b());
        sQLiteDatabase.execSQL(C0221c.m323a().m322b());
        sQLiteDatabase.execSQL(C0223e.m326a().m322b());
        sQLiteDatabase.execSQL(C0225g.m329a().m322b());
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        if (!sQLiteDatabase.isReadOnly()) {
            sQLiteDatabase.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Log.v("TagInfo_KeyDatabaseHelper", "Upgrading database from version " + i + " to " + i2 + ", we'll try to migrate the data.");
        Log.v("TagInfo_KeyDatabaseHelper", "Unfortunately we were not able to recognize the oldVersion. Tables will be dropped and recreated.");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS user_keys");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chip_var");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS key_selector");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS key_subselector");
        onCreate(sQLiteDatabase);
    }
}
