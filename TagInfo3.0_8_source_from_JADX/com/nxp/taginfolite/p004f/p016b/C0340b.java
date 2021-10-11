package com.nxp.taginfolite.p004f.p016b;

import android.support.v4.view.MotionEventCompat;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p004f.C0338a;
import com.nxp.taginfolite.p004f.p015a.C0337j;
import com.nxp.taginfolite.p004f.p017c.C0345a;
import com.nxp.taginfolite.p009e.C0270w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.nxp.taginfolite.f.b.b */
public class C0340b {
    public static C0337j m980a(byte[] bArr) {
        try {
            return new C0337j(bArr).m962b(111);
        } catch (NullPointerException e) {
            return null;
        }
    }

    public static void m981a(C0270w c0270w) {
        C0345a c0345a = new C0345a(c0270w.m661h());
        byte[] b = c0345a.m1005b(C0338a.f1024j);
        if (c0345a.m1007c()) {
            C0428i q = c0270w.m670q();
            q.m1384a(c0270w.m638a(C0338a.f1024j, b));
            try {
                C0337j c0337j = new C0337j(b);
                C0337j a = C0340b.m980a(b);
                if (a != null) {
                    C0339a a2;
                    List<C0339a> arrayList = new ArrayList();
                    Collection a3 = C0339a.m974a(a);
                    if (a3 != null) {
                        arrayList.addAll(a3);
                    }
                    a = a.m962b(165);
                    if (a != null) {
                        a = a.m962b(136);
                        if (a != null) {
                            int i = a.m965g()[0] & MotionEventCompat.ACTION_MASK;
                            int i2 = 1;
                            while (true) {
                                b = c0345a.m1004b(i2, i, 4);
                                if (c0345a.m1007c()) {
                                    a = new C0337j(b).m962b(112);
                                    if (a != null) {
                                        List<C0337j> a4 = a.m959a(97);
                                        if (a4 != null) {
                                            for (C0337j a5 : a4) {
                                                a2 = C0339a.m973a(a5.m965g());
                                                if (a2 != null) {
                                                    arrayList.add(a2);
                                                }
                                            }
                                        }
                                    }
                                }
                                int i3 = i2 + 1;
                                if (!c0345a.m1007c()) {
                                    break;
                                }
                                i2 = i3;
                            }
                        }
                    }
                    for (C0339a a22 : arrayList) {
                        q.m1384a(a22.m979e());
                        c0270w.m637a(a22.m975a());
                    }
                }
            } catch (NullPointerException e) {
            }
        }
    }
}
