package com.nxp.taginfolite.p009e.p013d;

import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.Menu;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.p017c.C0345a;
import com.nxp.taginfolite.p009e.C0270w;
import java.util.Arrays;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.d.q */
public class C0288q {
    private byte[] f736a;
    private final byte[] f737b;
    private byte[] f738c;
    private byte[] f739d;
    private final C0428i f740e;

    public C0288q() {
        this.f736a = null;
        this.f737b = null;
        this.f738c = null;
        this.f739d = null;
        this.f740e = new C0428i();
    }

    public static C0288q m755a(C0270w c0270w) {
        c0270w.m660g();
        byte[] bArr = new byte[]{Byte.MIN_VALUE, (byte) 0, (byte) 0, (byte) 0, (byte) 0, Byte.MAX_VALUE};
        C0345a c0345a = new C0345a(c0270w.m661h());
        byte[] a = c0345a.m996a(bArr);
        if (c0345a.m1007c()) {
            C0288q c0288q = new C0288q();
            c0288q.f736a = Arrays.copyOf(a, a.length);
            c0288q.f740e.m1384a((CharSequence) "MULTOS data:");
            c0288q.f740e.m1384a(C0429j.m1405c(a));
            byte[] a2 = c0345a.m996a(new byte[]{Byte.MIN_VALUE, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 22});
            if (c0345a.m1007c()) {
                c0288q.f740e.m1384a((CharSequence) "Manufacturer data:");
                c0288q.f740e.m1384a(C0429j.m1405c(a2));
                c0270w.m646a(C0275d.MULTOS);
                switch (a[4] & 240) {
                    case C0519c.Switch_thumb /*0*/:
                        c0270w.m640a((int) Menu.CATEGORY_CONTAINER);
                        switch (a[4] & 15) {
                            case C0519c.Switch_thumb /*0*/:
                                c0270w.m647a(C0279h.H3112);
                                break;
                            case C0519c.Switch_track /*1*/:
                                c0270w.m647a(C0279h.H3114);
                                break;
                            default:
                                break;
                        }
                    case Menu.CATEGORY_SHIFT /*16*/:
                    case C0086R.styleable.SherlockTheme_buttonStyleSmall /*19*/:
                        c0270w.m640a(16528);
                        if ((a[4] & 15) == 0) {
                            c0270w.m647a(C0279h.SLE66);
                            break;
                        }
                        break;
                }
                if ((a[0] & 15) == 0) {
                    c0270w.m654b(String.format("v%d.%d", new Object[]{Integer.valueOf((a[1] >> 4) & 15), Integer.valueOf(a[1] & 15)}));
                } else {
                    c0270w.m654b(String.format("v%d.%02X", new Object[]{Integer.valueOf(a[0] & 15), Byte.valueOf(a[1])}));
                }
                a = c0345a.m1003b(0, 102);
                c0288q.f740e.m1384a((CharSequence) "Data 0066:");
                c0288q.f740e.m1384a(C0429j.m1405c(a));
                c0288q.m756a(c0345a, (byte) 0);
                c0288q.m756a(c0345a, (byte) 1);
                c0288q.m756a(c0345a, (byte) 2);
                c0288q.m756a(c0345a, (byte) 3);
                c0288q.m756a(c0345a, (byte) 4);
                c0288q.m756a(c0345a, (byte) 5);
                c0288q.m756a(c0345a, (byte) 6);
                c0288q.m756a(c0345a, (byte) 7);
                return c0288q;
            }
        }
        return null;
    }

    private void m756a(C0345a c0345a, byte b) {
        byte[] a = c0345a.m996a(new byte[]{Byte.MIN_VALUE, (byte) 16, b, (byte) 0, (byte) 0});
        switch (b) {
            case C0519c.Switch_thumb /*0*/:
                this.f740e.m1384a((CharSequence) "Platform ID:");
                break;
            case C0519c.Switch_track /*1*/:
                this.f740e.m1384a((CharSequence) "Max ALU size:");
                break;
            case C0519c.Switch_textOn /*2*/:
                this.f740e.m1384a((CharSequence) "Comms TX parameters:");
                break;
            case C0519c.Switch_textOff /*3*/:
                this.f740e.m1384a((CharSequence) "ATR control AIDs:");
                if (c0345a.m1007c()) {
                    this.f738c = Arrays.copyOf(a, a.length);
                    break;
                }
                break;
            case C0519c.Switch_thumbTextPadding /*4*/:
                this.f740e.m1384a((CharSequence) "AMD version info:");
                if (c0345a.m1007c()) {
                    this.f739d = Arrays.copyOf(a, a.length);
                    break;
                }
                break;
            case C0519c.Switch_switchTextAppearance /*5*/:
                this.f740e.m1384a((CharSequence) "Available codelets:");
                break;
            case C0519c.Switch_switchMinWidth /*6*/:
                this.f740e.m1384a((CharSequence) "Loaded AIDs:");
                break;
            case C0519c.Switch_switchPadding /*7*/:
                this.f740e.m1384a((CharSequence) "MULTOS public key certificate:");
                break;
        }
        this.f740e.m1384a(C0429j.m1405c(a));
    }

    public String m757a() {
        C0428i c0428i = new C0428i();
        if (this.f736a != null) {
            byte[] bArr = this.f736a;
            c0428i.m1384a(String.format("MULTOS Carrier Device (MCD) ID:\n" + C0358k.f1076c + "0x%02X%02X%02X%02X%02X%02X", new Object[]{Byte.valueOf(bArr[4]), Byte.valueOf(bArr[5]), Byte.valueOf(bArr[6]), Byte.valueOf(bArr[7]), Byte.valueOf(bArr[8]), Byte.valueOf(bArr[9])}));
            c0428i.m1384a(String.format("MCD number:\n" + C0358k.f1076c + "0x%02X%02X%02X%02X%02X%02X%02X%02X", new Object[]{Byte.valueOf(bArr[16]), Byte.valueOf(bArr[17]), Byte.valueOf(bArr[18]), Byte.valueOf(bArr[19]), Byte.valueOf(bArr[20]), Byte.valueOf(bArr[21]), Byte.valueOf(bArr[22]), Byte.valueOf(bArr[23])}));
        }
        if (this.f739d != null) {
            bArr = this.f739d;
            c0428i.m1384a(String.format("AMD version: %02X%02XV%01X%02X", new Object[]{Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])}));
        }
        if (this.f737b != null) {
            bArr = this.f737b;
            c0428i.m1384a(String.format("Max. Application Load Unit (ALU) size:\n" + C0358k.f1076c + "%d bytes", new Object[]{Integer.valueOf(C0429j.m1389a(bArr[0], bArr[1], bArr[2]))}));
        }
        if (this.f738c != null) {
            bArr = this.f738c;
            c0428i.m1387b("ATR Control Application ID, cold reset:");
            if (bArr[0] != null) {
                c0428i.m1384a(String.format("\n" + C0358k.f1076c + C0429j.m1402b(bArr, 1, bArr[0]), new Object[0]));
            } else {
                c0428i.m1384a((CharSequence) " [none]");
            }
            c0428i.m1387b("ATR Control Application ID, warm reset:");
            if (bArr[17] != null) {
                c0428i.m1384a(String.format("\n" + C0358k.f1076c + C0429j.m1402b(bArr, 18, bArr[0]), new Object[0]));
            } else {
                c0428i.m1384a((CharSequence) " [none]");
            }
        }
        return c0428i.toString();
    }
}
