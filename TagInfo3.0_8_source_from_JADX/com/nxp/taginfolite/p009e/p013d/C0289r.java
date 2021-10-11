package com.nxp.taginfolite.p009e.p013d;

import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.p017c.C0345a;
import com.nxp.taginfolite.p009e.C0270w;

/* renamed from: com.nxp.taginfolite.e.d.r */
public class C0289r {
    public static String m758a(C0270w c0270w) {
        C0345a c0345a = new C0345a(c0270w.m661h());
        C0290s.m768b(2, c0345a);
        if (c0345a.m1007c()) {
            c0345a.m996a(new byte[]{(byte) 0, (byte) -92, (byte) 0, (byte) 12, (byte) 2, (byte) -31, (byte) 1});
            if (c0345a.m1007c()) {
                byte[] a = c0345a.m990a(18);
                C0428i c0428i = new C0428i();
                c0428i.m1387b("I\u00b2C protect: ");
                c0428i.m1384a(a[2] != null ? "enabled" : "disabled");
                c0428i.m1387b("I\u00b2C watchdog: ");
                c0428i.m1384a(a[3] != null ? "enabled" : "disabled");
                c0428i.m1384a((CharSequence) "GPO: ");
                int i = (a[4] & 240) >> 4;
                if (i == 0) {
                    c0428i.m1384a(C0358k.f1076c + "High impedance");
                }
                if (i == 1) {
                    c0428i.m1384a(C0358k.f1076c + "Session Open");
                }
                if (i == 2) {
                    c0428i.m1384a(C0358k.f1076c + "Writing in Progress (WIP)");
                }
                if (i == 3) {
                    c0428i.m1384a(C0358k.f1076c + "NDEF Message writing in Progress (MIP)");
                }
                if (i == 4) {
                    c0428i.m1384a(C0358k.f1076c + "Interrupt (INT)");
                }
                if (i == 5) {
                    c0428i.m1384a(C0358k.f1076c + "State Control");
                }
                if (i == 6) {
                    c0428i.m1384a(C0358k.f1076c + "RF busy");
                }
                return c0428i.toString();
            }
        }
        return null;
    }
}
