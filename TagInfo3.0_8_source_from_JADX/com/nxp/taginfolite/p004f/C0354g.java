package com.nxp.taginfolite.p004f;

import android.database.Cursor;
import android.text.TextUtils;
import com.nxp.taginfolite.p003g.C0422a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* renamed from: com.nxp.taginfolite.f.g */
public class C0354g {
    private final C0422a f1070a;
    private final String f1071b;

    public C0354g(C0422a c0422a, String str) {
        this.f1070a = c0422a;
        this.f1071b = str;
    }

    public static List m1058a(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0 || !cursor.moveToFirst()) {
            return null;
        }
        int columnIndex = cursor.getColumnIndex("key_value");
        int columnIndex2 = cursor.getColumnIndex("key_type");
        List arrayList = new ArrayList();
        do {
            byte[] blob = cursor.getBlob(columnIndex);
            arrayList.add(new C0354g(new C0422a(blob), cursor.getString(columnIndex2)));
        } while (cursor.moveToNext());
        return arrayList;
    }

    public static List m1059a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0354g c0354g = (C0354g) it.next();
            if (c0354g == null || c0354g.m1060a() == null || c0354g.m1062b() == null) {
                it.remove();
            }
        }
        return new ArrayList(new LinkedHashSet(list));
    }

    public C0422a m1060a() {
        return this.f1070a;
    }

    public boolean m1061a(C0354g c0354g) {
        return ((this.f1070a != null && this.f1070a.equals(c0354g.f1070a)) || this.f1070a == c0354g.f1070a) && TextUtils.equals(this.f1071b, c0354g.f1071b);
    }

    public byte[] m1062b() {
        return this.f1070a == null ? null : this.f1070a.m1362a();
    }

    public String m1063c() {
        return this.f1071b;
    }
}
