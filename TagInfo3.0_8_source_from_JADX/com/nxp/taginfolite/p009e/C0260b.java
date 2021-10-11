package com.nxp.taginfolite.p009e;

import android.annotation.SuppressLint;
import android.nfc.Tag;
import android.nfc.tech.NfcBarcode;
import android.support.v4.BuildConfig;
import com.nxp.taginfolite.ndef.C0448a;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0355h;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.C0360m;
import com.nxp.taginfolite.p004f.C0369v;
import com.nxp.taginfolite.p006c.C0197a;
import com.nxp.taginfolite.p006c.C0198b;
import com.nxp.taginfolite.p006c.C0199c;
import com.nxp.taginfolite.p006c.C0200d;
import java.util.Arrays;
import org.jraf.android.backport.switchwidget.C0519c;

@SuppressLint({"NewApi"})
/* renamed from: com.nxp.taginfolite.e.b */
public class C0260b implements ay {
    private NfcBarcode f596a;
    private StringBuilder f597b;

    public C0260b() {
        this.f597b = null;
    }

    public static C0260b m581a(Tag tag, NfcBarcode nfcBarcode) {
        C0260b c0260b = new C0260b();
        c0260b.f596a = nfcBarcode;
        if (nfcBarcode != null) {
            byte[] barcode = nfcBarcode.getBarcode();
            C0428i c0428i = new C0428i();
            if (barcode != null) {
                c0428i.m1387b("Barcode: ");
                c0428i.m1384a(C0429j.m1393a(barcode, BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME));
                byte[] copyOf = Arrays.copyOf(barcode, barcode.length);
                C0358k.m1073c(copyOf);
                if (!(barcode[barcode.length - 2] == copyOf[barcode.length - 1] && barcode[barcode.length - 1] == copyOf[barcode.length - 2])) {
                    c0428i.m1384a(C0358k.f1076c + "CRC error");
                }
            }
            if (nfcBarcode.getType() == 1 && barcode != null && barcode.length == 16) {
                switch (barcode[1] & 31) {
                    case C0519c.Switch_track /*1*/:
                    case C0519c.Switch_textOn /*2*/:
                    case C0519c.Switch_textOff /*3*/:
                    case C0519c.Switch_thumbTextPadding /*4*/:
                        barcode = Arrays.copyOfRange(barcode, 1, barcode.length - 2);
                        c0428i.m1384a((CharSequence) "URL data:");
                        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
                        C0448a.m1457b(barcode, C0358k.f1076c, stringBuilder);
                        c0428i.m1384a(stringBuilder.toString());
                        break;
                    case C0519c.Switch_switchTextAppearance /*5*/:
                        c0428i.m1384a(C0358k.m1070a(Arrays.copyOfRange(barcode, 2, barcode.length - 2)));
                        break;
                }
                c0260b.f597b = new StringBuilder(c0428i.toString());
            }
        }
        return c0260b;
    }

    public void m582a(C0197a c0197a, boolean z) {
        if (this.f596a.getBarcode() != null) {
            c0197a.m193a(String.format("%d bits", new Object[]{Integer.valueOf(this.f596a.getBarcode().length * 8)}));
        }
    }

    public void m583a(C0198b c0198b, boolean z) {
    }

    public void m584a(C0199c c0199c, boolean z) {
        if (this.f596a.getType() == 1) {
            c0199c.m230d("Thin Film Electronics ASA");
        } else {
            c0199c.m230d(C0355h.m1067b(this.f596a.getBarcode(), C0360m.BARCODE));
        }
        c0199c.m231e("NFC Barcode");
        if (this.f597b != null) {
            c0199c.m227b(this.f597b.toString());
        }
    }

    public void m585a(C0200d c0200d, boolean z) {
        String str = "Tag-Talks-First (TTF) protocol\nISO/IEC 14443-2 (Type A) compatible";
        c0200d.m238a((CharSequence) "Tag-Talks-First (TTF) protocol\nISO/IEC 14443-2 (Type A) compatible");
        C0369v.m1102a(this.f596a, c0200d);
    }

    public boolean m586a() {
        return false;
    }

    public boolean m587b() {
        return false;
    }

    public byte[] m588c() {
        return null;
    }

    public String m589d() {
        return null;
    }
}
