package com.nxp.taginfolite.database.p007a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.nxp.taginfolite.database.p008b.C0231m;
import com.nxp.taginfolite.database.p008b.C0232n;

/* renamed from: com.nxp.taginfolite.database.a.c */
public class C0216c extends SQLiteOpenHelper {
    private String f255a;

    public C0216c(Context context) {
        this(context, "TagInfo_Scans");
        if (VERSION.SDK_INT < 14) {
            this.f255a = "TagInfo_Scans";
        }
    }

    public C0216c(Context context, String str) {
        super(context, str, null, 7);
        if (VERSION.SDK_INT < 14) {
            this.f255a = str;
        }
    }

    @SuppressLint({"NewApi"})
    public String getDatabaseName() {
        return VERSION.SDK_INT < 14 ? this.f255a : super.getDatabaseName();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(C0231m.m339a().m322b());
        sQLiteDatabase.execSQL(C0232n.m342a().m322b());
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        if (!sQLiteDatabase.isReadOnly()) {
            sQLiteDatabase.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onUpgrade(android.database.sqlite.SQLiteDatabase r4, int r5, int r6) {
        /*
        r3 = this;
        r0 = "TagInfo_ScanDatabaseHelper";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Upgrading database from version ";
        r1 = r1.append(r2);
        r1 = r1.append(r5);
        r2 = " to ";
        r1 = r1.append(r2);
        r1 = r1.append(r6);
        r2 = ", we'll try to migrate the data.";
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
        switch(r5) {
            case 1: goto L_0x0053;
            case 2: goto L_0x0058;
            case 3: goto L_0x005d;
            case 4: goto L_0x0062;
            case 5: goto L_0x0067;
            case 6: goto L_0x006c;
            default: goto L_0x002b;
        };
    L_0x002b:
        r0 = "TagInfo_ScanDatabaseHelper";
        r1 = "Unfortunately we were not able to recognize the oldVersion. Tables will be dropped and recreated.";
        android.util.Log.v(r0, r1);
        r0 = "DROP TABLE IF EXISTS scan";
        r4.execSQL(r0);
        r0 = "DROP TABLE IF EXISTS scan_time";
        r4.execSQL(r0);
        r0 = com.nxp.taginfolite.database.p008b.C0231m.m339a();
        r0 = r0.m322b();
        r4.execSQL(r0);
        r0 = com.nxp.taginfolite.database.p008b.C0232n.m342a();
        r0 = r0.m322b();
        r4.execSQL(r0);
    L_0x0052:
        return;
    L_0x0053:
        r0 = "ALTER TABLE scans ADD COLUMN uid TEXT";
        r4.execSQL(r0);
    L_0x0058:
        r0 = "CREATE TABLE IF NOT EXISTS times (_id INTEGER PRIMARY KEY AUTOINCREMENT, uid TEXT, time TEXT )";
        r4.execSQL(r0);
    L_0x005d:
        r0 = "ALTER TABLE scans ADD COLUMN taglost INTEGER";
        r4.execSQL(r0);
    L_0x0062:
        r0 = "ALTER TABLE scans ADD COLUMN comment TEXT";
        r4.execSQL(r0);
    L_0x0067:
        r0 = "ALTER TABLE scans ADD COLUMN hasndef INTEGER";
        r4.execSQL(r0);
    L_0x006c:
        r0 = com.nxp.taginfolite.database.p008b.C0231m.m339a();
        r0 = r0.m322b();
        r4.execSQL(r0);
        r0 = com.nxp.taginfolite.database.p008b.C0232n.m342a();
        r0 = r0.m322b();
        r4.execSQL(r0);
        r0 = "INSERT INTO scan(_id, uid, taglost, title, data, comment, hasndef, ndef) SELECT _id, uid, taglost, title, data, comment, hasndef, ndef FROM scans;";
        r4.execSQL(r0);
        r0 = "INSERT INTO scan_time(_id, scan_id, time) SELECT null, _id, time FROM scans;";
        r4.execSQL(r0);
        r0 = "INSERT INTO scan_time(_id, scan_id, time) SELECT null, max(scan._id), scan_times.time from scan_times, scans, scan where scans.uid = scan_times.uid AND scan.uid = scans.uid group by scan_times.time";
        r4.execSQL(r0);
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.database.a.c.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }
}
