package com.nxp.taginfolite.database.p008b;

import android.provider.BaseColumns;
import android.support.v4.BuildConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.nxp.taginfolite.database.b.o */
public abstract class C0220o implements BaseColumns {
    private static final Map f261a;
    private final Map f262b;
    final String f263c;

    static {
        f261a = new HashMap();
    }

    protected C0220o(String str, Map map) {
        if (str == null || map == null) {
            throw new IllegalArgumentException("title, and/or columnNamesAndTypes were null");
        }
        this.f263c = str;
        this.f262b = map;
    }

    public static C0220o m321a(Class cls) {
        synchronized (cls) {
            if (f261a.containsKey(cls)) {
                C0220o c0220o = (C0220o) f261a.get(cls);
                return c0220o;
            }
            try {
                c0220o = (C0220o) cls.newInstance();
                f261a.put(cls, c0220o);
                return c0220o;
            } catch (InstantiationException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public String m322b() {
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE ");
        stringBuilder.append(this.f263c);
        stringBuilder.append(" (");
        Map hashMap = new HashMap();
        Iterator it = this.f262b.keySet().iterator();
        do {
            String str = (String) it.next();
            if (str.startsWith("CONSTRAINT ")) {
                hashMap.put(str, this.f262b.get(str));
            } else {
                stringBuilder.append(str);
                stringBuilder.append(" ");
                stringBuilder.append((String) this.f262b.get(str));
                stringBuilder.append(it.hasNext() ? ", " : BuildConfig.VERSION_NAME);
            }
        } while (it.hasNext());
        for (String str2 : hashMap.keySet()) {
            stringBuilder.append(", ");
            stringBuilder.append(str2);
            stringBuilder.append(" ");
            stringBuilder.append((String) this.f262b.get(str2));
        }
        stringBuilder.append(");");
        return stringBuilder.toString();
    }
}
