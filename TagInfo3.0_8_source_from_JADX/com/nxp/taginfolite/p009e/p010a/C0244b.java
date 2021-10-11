package com.nxp.taginfolite.p009e.p010a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.nxp.taginfolite.TagInfoApp;
import com.nxp.taginfolite.database.provider.UserKeys;
import com.nxp.taginfolite.p003g.C0422a;
import com.nxp.taginfolite.p004f.C0354g;
import com.nxp.taginfolite.p009e.as;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.nxp.taginfolite.e.a.b */
public class C0244b {
    public static final C0422a f366a;
    public static final C0422a f367b;
    public static final C0422a f368c;
    public static final C0422a f369d;
    public static final C0422a f370e;
    public static final C0422a f371f;
    public static final C0422a f372g;
    public static final C0422a f373h;
    public static final C0422a f374i;
    public static final C0422a f375j;
    public static final C0422a f376k;
    public static final C0422a f377l;
    private static final HashMap f378m;
    private static final HashMap f379n;
    private static final Map f380o;

    static {
        f366a = new C0422a(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
        f367b = new C0422a(176, 177, 178, 179, 180, 181);
        f368c = new C0422a(160, 161, 162, 163, 164, 165);
        f369d = new C0422a(165, 164, 163, 162, 161, 160);
        f370e = new C0422a(211, 247, 211, 247, 211, 247);
        f371f = new C0422a(0, 0, 0, 0, 0, 0);
        f372g = new C0422a(252, 0, 1, 135, 120, 247);
        f373h = new C0422a(193, 229, 28, 99, 184, 245);
        f374i = new C0422a(239, 246, 3, 225, 239, 233);
        f375j = new C0422a(143, 230, 68, 3, 135, 144);
        f376k = new C0422a(29, 183, 16, 100, 138, 101);
        f377l = new C0422a(24, 243, 76, 146, 165, 110);
        f378m = new C0245c();
        f379n = new C0246d();
        f380o = new C0247e();
    }

    private static Cursor m384a(int i, boolean z, as asVar) {
        ContentResolver a = TagInfoApp.m10a();
        String[] strArr = new String[]{"key_value", "key_type"};
        String str = "enabled = '" + Integer.toString(1) + "' AND " + "chip" + " = '" + "MFC" + "' AND " + "subselector" + " = '" + "MFC" + "' AND " + "subselector_value" + " in ( '" + "Any" + "' , ? ) AND " + "chip_var" + " IN ( '" + "Any" + "' , ? ) AND " + "selector_type" + " = '" + "SEC" + "' AND " + "selector_value" + " LIKE ? AND " + "key_type" + " IN ( '" + "A|B" + "' , '" + "B" + "' , ? )";
        String str2 = z ? "A" : "B";
        String str3 = (String) f378m.get(asVar.f479a);
        String str4 = (String) f379n.get(asVar.f480b);
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = 0;
        while (i2 < 40) {
            stringBuilder.append(i == i2 ? "1" : "_");
            i2++;
        }
        return a.query(UserKeys.f350c, strArr, str, new String[]{str3, str4, stringBuilder.toString(), str2}, null);
    }

    public static String m385a(C0422a c0422a) {
        String str = (String) f380o.get(c0422a);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        ContentResolver a = TagInfoApp.m10a();
        String[] strArr = new String[]{"title"};
        StringBuilder stringBuilder = new StringBuilder("key_value= x'");
        int length = c0422a.m1362a().length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(String.format("%02x", new Object[]{Byte.valueOf(r6[i])}));
        }
        stringBuilder.append("' AND subselector = 'MFC'");
        Log.v("TI_KeyList", "Selection: " + stringBuilder);
        Cursor query = a.query(UserKeys.f350c, strArr, stringBuilder.toString(), null, null);
        return (query == null || query.getCount() == 0 || !query.moveToFirst()) ? null : query.getString(query.getColumnIndex("title"));
    }

    public static List m386a(int i, C0354g c0354g, SparseArray sparseArray, as asVar, boolean z, boolean z2) {
        List arrayList = new ArrayList();
        C0354g c0354g2 = (C0354g) sparseArray.get(i);
        if (c0354g2 == null) {
            c0354g2 = c0354g != null ? c0354g : null;
        }
        Collection a = C0354g.m1058a(C0244b.m384a(i, z2, asVar));
        if (c0354g2 != null) {
            arrayList.add(c0354g2);
        }
        if (!(c0354g == null || c0354g.m1061a(c0354g2))) {
            arrayList.add(c0354g);
        }
        if (i == 0 || i == 16) {
            arrayList.add(new C0354g(f368c, "A|B"));
        } else if (z) {
            arrayList.add(new C0354g(f370e, "A|B"));
        }
        if (a != null) {
            arrayList.addAll(a);
        }
        arrayList.add(new C0354g(f366a, "A|B"));
        arrayList.add(new C0354g(f368c, "A|B"));
        arrayList.add(new C0354g(f371f, "A|B"));
        arrayList.add(new C0354g(f370e, "A|B"));
        arrayList.add(new C0354g(f367b, "A|B"));
        arrayList.add(new C0354g(f369d, "A|B"));
        return C0354g.m1059a(arrayList);
    }
}
