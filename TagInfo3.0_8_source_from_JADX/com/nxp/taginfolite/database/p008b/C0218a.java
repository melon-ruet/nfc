package com.nxp.taginfolite.database.p008b;

import android.database.Cursor;
import android.net.Uri;
import com.nxp.taginfolite.TagInfoApp;
import com.nxp.taginfolite.database.provider.Lookup;

/* renamed from: com.nxp.taginfolite.database.b.a */
public class C0218a {
    public static final Uri f257a;
    public static final Uri f258b;

    static {
        f257a = Uri.withAppendedPath(Lookup.f332a, "bieb");
        f258b = Uri.withAppendedPath(f257a, "#");
    }

    public static String m320a(String str) {
        Cursor query = TagInfoApp.m10a().query(f257a, null, "bieb = '" + str + "'", null, null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        String string = query.getString(query.getColumnIndex("name"));
        query.close();
        return string;
    }
}
