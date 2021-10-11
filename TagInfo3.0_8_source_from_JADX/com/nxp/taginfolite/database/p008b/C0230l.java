package com.nxp.taginfolite.database.p008b;

import android.database.Cursor;
import android.net.Uri;
import com.nxp.taginfolite.TagInfoApp;
import com.nxp.taginfolite.database.provider.Lookup;

/* renamed from: com.nxp.taginfolite.database.b.l */
public class C0230l {
    public static final Uri f274a;
    public static final Uri f275b;

    static {
        f274a = Uri.withAppendedPath(Lookup.f332a, "oui");
        f275b = Uri.withAppendedPath(f274a, "#");
    }

    public static String m336a(int i) {
        Cursor query = TagInfoApp.m10a().query(f274a, null, "oui = '" + String.format("0x%06X", new Object[]{Integer.valueOf(i)}) + "'", null, null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        String string = query.getString(query.getColumnIndex("manufacturer"));
        query.close();
        return string;
    }
}
