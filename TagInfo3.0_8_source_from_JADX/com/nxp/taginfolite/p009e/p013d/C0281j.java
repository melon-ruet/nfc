package com.nxp.taginfolite.p009e.p013d;

import android.nfc.tech.IsoDep;
import android.support.v4.BuildConfig;
import android.support.v4.view.MotionEventCompat;
import android.util.SparseArray;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0362o;
import com.nxp.taginfolite.p004f.C0368u;
import com.nxp.taginfolite.p004f.p017c.C0345a;
import com.nxp.taginfolite.p009e.C0270w;
import java.util.Arrays;
import java.util.HashMap;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.d.j */
public class C0281j {
    public static HashMap f728a;
    private static final HashMap f729e;
    private static final SparseArray f730f;
    private byte[] f731b;
    private String f732c;
    private int f733d;

    static {
        f728a = new C0282k();
        f729e = new C0283l();
        f730f = new C0284m();
    }

    public C0281j() {
        this.f731b = null;
        this.f732c = null;
        this.f733d = 0;
    }

    private static C0279h m746a(byte[] bArr) {
        C0279h c0279h = C0279h.UNKNOWN;
        switch (bArr[2] & MotionEventCompat.ACTION_MASK) {
            case C0519c.Switch_thumb /*0*/:
            case C0519c.Switch_track /*1*/:
                return C0279h.SmartMX;
            default:
                return c0279h;
        }
    }

    public static C0281j m747a(C0270w c0270w) {
        byte[] a = C0281j.m750a(c0270w.m661h());
        int length = a.length;
        C0281j r = c0270w.m671r();
        if (length > 13 && a[length - 2] == 106 && a[length - 1] == -126) {
            if (r == null) {
                r = new C0281j();
            }
            c0270w.m651a(true);
            c0270w.m640a(18320);
            r.f731b = Arrays.copyOf(a, length - 2);
            if (c0270w.m663j() == C0279h.UNKNOWN) {
                c0270w.m647a(C0281j.m746a(a));
            }
            if (length > 16) {
                c0270w.m646a(C0275d.JCOP_NXP);
                byte[] copyOfRange = Arrays.copyOfRange(a, 16, a[15] + 16);
                String str = new String(a, 8, 6, C0429j.f1360a);
                c0270w.m649a(C0362o.m1076a(C0275d.JCOP_NXP, str, copyOfRange, c0270w.m664k()));
                r.f732c = str;
                return r;
            }
            c0270w.m646a(C0275d.JCOP_IBM);
            return r;
        }
        if (C0345a.m986c(a)) {
            if (r == null) {
                r = new C0281j();
            }
            c0270w.m651a(true);
            r.f731b = Arrays.copyOf(a, length - 2);
        }
        return null;
    }

    public static String m748a(C0270w c0270w, C0281j c0281j) {
        String str = null;
        C0279h j = c0270w.m663j();
        if (!(c0281j == null || j == C0279h.MifareProX || j == C0279h.MifarePro)) {
            str = C0281j.m749a(c0281j.f732c, c0281j.f733d, c0270w.m664k());
        }
        switch (C0285n.f734a[c0270w.m662i().ordinal()]) {
            case C0519c.Switch_track /*1*/:
                if (str != null) {
                    return "NXP JCOP " + str;
                }
                str = "NXP JCOP";
                return c0270w.m668o() != null ? str + " " + c0270w.m668o() : str;
            case C0519c.Switch_textOn /*2*/:
                if (str != null) {
                    return "NXP JCOP " + str;
                }
                str = "NXP JCOP";
                if (j == C0279h.MifareProX || j == C0279h.MifarePro) {
                    str = str + " 30-31";
                }
                return c0270w.m668o() != null ? str + " " + c0270w.m668o() : str;
            default:
                return BuildConfig.VERSION_NAME;
        }
    }

    private static String m749a(String str, int i, C0368u c0368u) {
        String str2 = str != null ? (String) f729e.get(str) : null;
        if (str2 == null) {
            str2 = (String) f730f.get(i);
        }
        return str2 == null ? null : (!str2.contains("31-41") || C0362o.m1081b(c0368u)) ? str2 : ((String) C0362o.f1102i.get(c0368u)).charAt(3) == 'T' ? str2.replaceFirst("31-41", "41") : str2.replaceFirst("31-41", "31");
    }

    private static byte[] m750a(IsoDep isoDep) {
        return isoDep.transceive(new byte[]{(byte) 0, (byte) -92, (byte) 4, (byte) 0, (byte) 9, (byte) -96, (byte) 0, (byte) 0, (byte) 1, (byte) 103, (byte) 65, (byte) 48, (byte) 0, (byte) -1, (byte) 0});
    }

    public String m751a() {
        byte[] bArr = this.f731b;
        if (bArr == null) {
            return null;
        }
        int i = bArr.length <= 16 ? 1 : 0;
        if (C0345a.m986c(bArr)) {
            return C0429j.m1410f(bArr);
        }
        int i2;
        C0428i c0428i = new C0428i();
        c0428i.m1384a(String.format("Fabkey ID: 0x%02X\n", new Object[]{Byte.valueOf(bArr[0])}));
        c0428i.m1384a(String.format("Patch ID: 0x%02X\n", new Object[]{Byte.valueOf(bArr[1])}));
        c0428i.m1387b("Target ID: ");
        switch (bArr[2]) {
            case C0519c.Switch_thumb /*0*/:
            case C0519c.Switch_track /*1*/:
                c0428i.m1387b("SmartMX<hexoutput>");
                c0428i.m1387b(String.format(" (0x%02X)", new Object[]{Byte.valueOf(bArr[2])}));
                c0428i.m1387b("</hexoutput>");
                c0428i.m1383a();
                break;
            default:
                c0428i.m1384a(String.format("Unknown (0x%02X)", new Object[]{Byte.valueOf(bArr[2])}));
                break;
        }
        c0428i.m1384a(String.format("Mask ID: 0x%02X (mask%d)", new Object[]{Byte.valueOf(bArr[3]), Integer.valueOf(bArr[3] & MotionEventCompat.ACTION_MASK)}));
        c0428i.m1387b("Custom mask ID: ");
        if (bArr[4] == null && bArr[5] == null && bArr[6] == null && bArr[7] == null) {
            c0428i.m1387b("Generic<hexoutput> (0x00000000)</hexoutput>");
            c0428i.m1383a();
        } else {
            c0428i.m1384a(String.format("0x%02X%02X%02X%02X", new Object[]{Byte.valueOf(bArr[4]), Byte.valueOf(bArr[5]), Byte.valueOf(bArr[6]), Byte.valueOf(bArr[7])}));
        }
        int i3 = i != 0 ? 2 : 6;
        c0428i.m1387b("Mask name: ");
        boolean a = C0429j.m1396a(bArr, 8, i3);
        if (a) {
            for (i2 = 8; i2 < i3 + 8; i2++) {
                c0428i.m1387b(String.format("%c", new Object[]{Character.valueOf((char) bArr[i2])}));
            }
            c0428i.m1387b("<hexoutput> (0x");
            for (i2 = 8; i2 < i3 + 8; i2++) {
                c0428i.m1387b(String.format("%02X", new Object[]{Byte.valueOf(bArr[i2])}));
            }
            c0428i.m1387b(")</hexoutput>");
        } else {
            c0428i.m1387b("0x");
            for (i2 = 8; i2 < i3 + 8; i2++) {
                c0428i.m1387b(String.format("%02X", new Object[]{Byte.valueOf(bArr[i2])}));
            }
        }
        c0428i.m1383a();
        if (i == 0) {
            c0428i.m1387b("Fuse state: ");
            switch (bArr[14]) {
                case C0519c.Switch_thumb /*0*/:
                    c0428i.m1384a((CharSequence) "unfused<hexoutput> (0x00)</hexoutput>");
                    break;
                case C0519c.Switch_track /*1*/:
                    c0428i.m1384a((CharSequence) "fused<hexoutput> (0x01)</hexoutput>");
                    break;
                default:
                    c0428i.m1384a(String.format("unknown (0x%02X)\n", new Object[]{Byte.valueOf(bArr[14])}));
                    break;
            }
        }
        c0428i.m1384a((CharSequence) "Fuse state: -");
        i3 = i != 0 ? 9 : 15;
        c0428i.m1387b("ROM info: ");
        int i4 = i != 0 ? 4 : bArr[i3] & MotionEventCompat.ACTION_MASK;
        if (i4 == 0) {
            c0428i.m1387b("[none]");
        } else {
            c0428i.m1387b("0x");
            for (i2 = 0; i2 < i4; i2++) {
                c0428i.m1387b(String.format("%02X", new Object[]{Byte.valueOf(bArr[(i3 + 1) + i2])}));
            }
        }
        if (i == 0) {
            c0428i.m1387b(String.format("<hexoutput> (length: %d bytes)</hexoutput>", new Object[]{Integer.valueOf(i4)}));
        }
        c0428i.m1383a();
        if (i == 0) {
            if (bArr.length > (i4 + 16) + 2) {
                if (bArr[i4 + 16] == null) {
                    c0428i.m1387b("FIPS mode: disabled");
                } else {
                    c0428i.m1387b("FIPS mode: enabled");
                }
                c0428i.m1384a("<hexoutput>" + String.format(" (0x%02X)\n", new Object[]{Byte.valueOf(bArr[i4 + 15])}) + "</hexoutput>");
            }
            if (bArr[2] == (byte) 1 || bArr[2] == null) {
                c0428i.m1387b(String.format("Combo name: smartmx-m%02x.%02x.%02x", new Object[]{Byte.valueOf(bArr[3]), Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1])}));
                if ((((bArr[4] | bArr[5]) | bArr[6]) | bArr[7]) != 0) {
                    c0428i.m1387b(String.format(".%02X%02X%02X%02X", new Object[]{Byte.valueOf(bArr[4]), Byte.valueOf(bArr[5]), Byte.valueOf(bArr[6]), Byte.valueOf(bArr[7])}));
                }
                if (a) {
                    c0428i.m1387b("-");
                    for (i = 8; i < 14; i++) {
                        c0428i.m1387b(String.format("%c", new Object[]{Character.valueOf((char) bArr[i])}));
                    }
                }
            }
        }
        return c0428i.toString();
    }

    public void m752a(short s) {
        this.f733d = s;
    }
}
