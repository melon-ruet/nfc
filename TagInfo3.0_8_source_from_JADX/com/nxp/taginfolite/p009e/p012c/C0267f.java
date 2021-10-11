package com.nxp.taginfolite.p009e.p012c;

import android.text.TextUtils;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p004f.C0358k;
import com.sony.nfc.NfcTag;
import com.sony.nfc.p024a.C0454a;
import com.sony.nfc.pedometer.C0481a;
import com.sony.nfc.pedometer.PedometerData;
import com.sony.nfc.pedometer.PedometerEx950;
import com.sony.nfc.pedometer.PedometerFs500A;
import com.sony.nfc.pedometer.PedometerFs700;
import com.sony.nfc.pedometer.PedometerFs700Data;
import com.sony.nfc.pedometer.PedometerJp700;
import com.sony.nfc.pedometer.PedometerUw101NfcData;
import com.sony.nfc.pedometer.PedometerUw201Nfc;
import com.sony.nfc.pedometer.PedometerUw201NfcData;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.c.f */
public class C0267f implements C0264d {
    private static final Map f616c;
    NfcTag f617a;
    String f618b;

    static {
        f616c = new HashMap();
        f616c.put("PedometerEx950", "EX-950");
        f616c.put("PedometerFs500A", "FS-500A");
        f616c.put("PedometerFs700", "FS-700");
        f616c.put("PedometerJp700", "JP700");
        f616c.put("PedometerUw101Nfc", "UW-101NFC");
        f616c.put("PedometerUw201Nfc", "UW-201NFC");
    }

    public C0267f(NfcTag nfcTag) {
        this.f617a = nfcTag;
        this.f618b = nfcTag.getClass().getSimpleName();
    }

    private static String m607a(int i) {
        if (i < 0) {
            return C0358k.f1076c + "User weight: [not available]";
        }
        return String.format(Locale.US, C0358k.f1076c + "User weight: %.1f" + "\u200a" + "kg", new Object[]{Double.valueOf(((double) i) / 100.0d)});
    }

    private String m608a(NfcTag nfcTag) {
        PedometerData[] a = ((C0481a) nfcTag).m1552a();
        C0428i c0428i = new C0428i();
        if (a != null) {
            c0428i.m1384a(C0358k.f1076c + "Pedometer data:");
            for (PedometerData pedometerData : a) {
                c0428i.m1384a(C0261a.m596b(pedometerData.m1547a()));
                if (pedometerData instanceof PedometerUw101NfcData) {
                    c0428i.m1384a(String.format("\t\u2022 %d\u200am", new Object[]{Integer.valueOf(((PedometerUw101NfcData) pedometerData).m1675f())}));
                }
                c0428i.m1384a(String.format("\t\u2022 %d steps (%d active)", new Object[]{Integer.valueOf(pedometerData.m1548b()), Integer.valueOf(pedometerData.m1549c())}));
                c0428i.m1384a(String.format(Locale.US, "\t\u2022 %.1f\u200akcal, %.1f\u200aEx", new Object[]{Double.valueOf(((double) pedometerData.m1550d()) / 1000.0d), Double.valueOf(((double) pedometerData.m1551e()) / 1000.0d)}));
            }
        }
        return c0428i.toString();
    }

    private static String m609b(int i) {
        if (i < 0) {
            return C0358k.f1076c + "User stride: [not available]";
        }
        return String.format(Locale.US, C0358k.f1076c + "User stride: %.2f" + "\u200a" + "m", new Object[]{Double.valueOf(((double) i) / 1000.0d)});
    }

    public String m610a() {
        C0428i c0428i = new C0428i();
        if ("PedometerJp700".equals(this.f618b)) {
            switch (((PedometerJp700) this.f617a).m1616e()) {
                case C0519c.Switch_thumb /*0*/:
                    c0428i.m1384a((CharSequence) "Pedometer JP700-J");
                    break;
                case C0519c.Switch_track /*1*/:
                    c0428i.m1384a((CharSequence) "Pedometer JP700-E");
                    break;
                case C0519c.Switch_textOn /*2*/:
                    c0428i.m1384a((CharSequence) "Pedometer JP700-U");
                    break;
                default:
                    c0428i.m1384a((CharSequence) "Pedometer JP700");
                    break;
            }
        }
        String str = (String) f616c.get(this.f618b);
        if (TextUtils.isEmpty(str)) {
            c0428i.m1384a((CharSequence) "Pedometer");
        } else {
            c0428i.m1384a("Pedometer " + str);
        }
        Object f;
        if ("PedometerFs700".equals(this.f618b)) {
            PedometerFs700 pedometerFs700 = (PedometerFs700) this.f617a;
            f = pedometerFs700.m1590f();
            if (!TextUtils.isEmpty(f)) {
                c0428i.m1384a(C0358k.f1076c + "Product code: " + f);
            }
            c0428i.m1384a(C0261a.m591a(pedometerFs700.m1589e()));
            if (pedometerFs700.m1592h() >= 0) {
                c0428i.m1384a(String.format(Locale.US, C0358k.f1076c + "User height: %.2f" + "\u200a" + "m", new Object[]{Double.valueOf(((double) pedometerFs700.m1592h()) / 1000.0d)}));
            } else {
                c0428i.m1384a(C0358k.f1076c + "User height: [not available]");
            }
            c0428i.m1384a(C0267f.m607a(pedometerFs700.m1591g() / 10));
            PedometerFs700Data[] pedometerFs700DataArr = null;
            try {
                pedometerFs700DataArr = pedometerFs700.m1594j();
            } catch (C0454a e) {
                c0428i.m1384a((CharSequence) "Error reading pedometer data");
            }
            if (pedometerFs700DataArr != null) {
                c0428i.m1384a(C0358k.f1076c + "Pedometer data:");
                for (PedometerFs700Data a : pedometerFs700DataArr) {
                    c0428i.m1384a(C0261a.m596b(a.m1547a()));
                    c0428i.m1384a(String.format("\t\u2022 Steps: %d (%d active, %d jogging)", new Object[]{Integer.valueOf(a.m1548b()), Integer.valueOf(a.m1549c()), Integer.valueOf(a.m1595f())}));
                    c0428i.m1384a(String.format(Locale.US, "\t\u2022 Energy: %.1f\u200akcal (%.1f active)", new Object[]{Double.valueOf(((double) a.m1597h()) / 1000.0d), Double.valueOf(((double) a.m1596g()) / 1000.0d)}));
                    c0428i.m1384a(String.format(Locale.US, "\t\u2022 Body fat burnt: %.1f\u200ag", new Object[]{Double.valueOf(((double) a.m1598i()) / 10.0d)}));
                    c0428i.m1384a(String.format(Locale.US, "\t\u2022 Excercise: %.1f\u200aEx", new Object[]{Double.valueOf(((double) a.m1551e()) / 1000.0d)}));
                }
            }
        } else if ("PedometerUw201Nfc".equals(this.f618b)) {
            PedometerUw201Nfc pedometerUw201Nfc = (PedometerUw201Nfc) this.f617a;
            f = pedometerUw201Nfc.m1691f();
            if (!TextUtils.isEmpty(f)) {
                c0428i.m1384a(C0358k.f1076c + "Product code: " + f);
            }
            int k = pedometerUw201Nfc.m1696k();
            if (k != -1) {
                c0428i.m1384a(C0358k.f1076c + "Battery status: " + (k == 1 ? "low" : "OK"));
            }
            c0428i.m1384a(C0261a.m591a(pedometerUw201Nfc.m1690e()));
            k = pedometerUw201Nfc.m1694i();
            if (k != -1) {
                c0428i.m1384a(C0358k.f1076c + "User sex: " + (k == 1 ? "male" : "female"));
            }
            k = pedometerUw201Nfc.m1695j();
            if (k != -1) {
                c0428i.m1384a(C0358k.f1076c + "User age: " + Integer.toString(k));
            }
            if (pedometerUw201Nfc.m1693h() >= 0) {
                c0428i.m1384a(String.format(Locale.US, C0358k.f1076c + "User height: %.2f" + "\u200a" + "m", new Object[]{Double.valueOf(((double) pedometerUw201Nfc.m1693h()) / 1000.0d)}));
            } else {
                c0428i.m1384a(C0358k.f1076c + "User height: [not available]");
            }
            c0428i.m1384a(C0267f.m607a(pedometerUw201Nfc.m1692g() / 10));
            PedometerUw201NfcData[] pedometerUw201NfcDataArr = null;
            try {
                pedometerUw201NfcDataArr = pedometerUw201Nfc.m1698m();
            } catch (C0454a e2) {
                c0428i.m1384a((CharSequence) "Error reading pedometer data");
            }
            if (pedometerUw201NfcDataArr != null) {
                c0428i.m1384a(C0358k.f1076c + "Daily data:");
                for (PedometerUw201NfcData a2 : pedometerUw201NfcDataArr) {
                    c0428i.m1384a(C0261a.m596b(a2.m1547a()));
                    c0428i.m1384a(String.format("\t\u2022 Steps: %d (%d active, %d jogging)", new Object[]{Integer.valueOf(a2.m1548b()), Integer.valueOf(a2.m1549c()), Integer.valueOf(a2.m1699f())}));
                    c0428i.m1384a(String.format(Locale.US, "\t\u2022 Energy: %.1f\u200akcal (%.1f active)", new Object[]{Double.valueOf(((double) a2.m1701h()) / 1000.0d), Double.valueOf(((double) a2.m1700g()) / 1000.0d)}));
                    c0428i.m1384a(String.format(Locale.US, "\t\u2022 Body fat burnt: %.1f\u200ag", new Object[]{Double.valueOf(((double) a2.m1702i()) / 10.0d)}));
                    c0428i.m1384a(String.format(Locale.US, "\t\u2022 Excercise: %.1f\u200aEx", new Object[]{Double.valueOf(((double) a2.m1551e()) / 1000.0d)}));
                }
            }
        } else if ("PedometerEx950".equals(this.f618b)) {
            PedometerEx950 pedometerEx950 = (PedometerEx950) this.f617a;
            c0428i.m1384a(C0261a.m591a(pedometerEx950.m1560e()));
            c0428i.m1384a(C0267f.m607a(pedometerEx950.m1561f()));
            c0428i.m1384a(C0267f.m609b(pedometerEx950.m1562g()));
            c0428i.m1384a(m608a(this.f617a));
        } else if ("PedometerFs500A".equals(this.f618b)) {
            PedometerFs500A pedometerFs500A = (PedometerFs500A) this.f617a;
            c0428i.m1384a(C0261a.m591a(pedometerFs500A.m1571e()));
            c0428i.m1384a(C0267f.m607a(pedometerFs500A.m1572f()));
            c0428i.m1384a(C0267f.m609b(pedometerFs500A.m1573g()));
            c0428i.m1384a(m608a(this.f617a));
        } else {
            c0428i.m1384a(m608a(this.f617a));
        }
        return c0428i.toString();
    }
}
