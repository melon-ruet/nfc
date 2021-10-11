package com.nxp.taginfolite.database.p008b;

import android.database.Cursor;
import android.net.Uri;
import com.nxp.taginfolite.TagInfoApp;
import com.nxp.taginfolite.database.provider.Lookup;

/* renamed from: com.nxp.taginfolite.database.b.k */
public class C0229k {
    public static final Uri f272a;
    public static final Uri f273b;

    static {
        f272a = Uri.withAppendedPath(Lookup.f332a, "mad");
        f273b = Uri.withAppendedPath(f272a, "#");
    }

    public static String[] m335a(int i) {
        Cursor query = TagInfoApp.m10a().query(f272a, null, "mad = '" + String.format("0x%04X", new Object[]{Integer.valueOf(i)}) + "'", null, null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        String[] strArr = new String[]{query.getString(query.getColumnIndex("application")), query.getString(query.getColumnIndex("service_provider")), query.getString(query.getColumnIndex("system_integrator")), query.getString(query.getColumnIndex("company"))};
        query.close();
        return strArr;
    }
}
