package com.nxp.taginfolite.p009e.p013d;

import android.nfc.tech.IsoDep;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.C0368u;
import com.nxp.taginfolite.p004f.p017c.C0345a;
import com.nxp.taginfolite.p009e.C0270w;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.d.a */
public class C0272a {
    int f674a;
    private final C0428i f675b;

    public C0272a() {
        this.f675b = new C0428i();
        this.f674a = -1;
    }

    public static C0272a m715a(C0270w c0270w) {
        C0272a c0272a = null;
        IsoDep h = c0270w.m661h();
        byte[] historicalBytes = h.getHistoricalBytes();
        if (historicalBytes != null && historicalBytes.length >= 2 && historicalBytes[0] == 90 && historicalBytes[1] == 67) {
            C0345a c0345a = new C0345a(h);
            c0345a.m996a(new byte[]{(byte) -64, (byte) 0, (byte) 0, (byte) 0, (byte) 0});
            if (c0345a.m1007c()) {
                c0272a = new C0272a();
                c0270w.m646a(C0275d.BASICCARD);
                byte[] f = c0345a.m1011f();
                if (f.length >= 7) {
                    c0270w.m647a(C0279h.SmartMX);
                    CharSequence str = new String(f, 1, 5, C0429j.f1360a);
                    if (TextUtils.equals("ZC7.5", str)) {
                        c0270w.m649a(C0368u.SMX_P5CD040);
                    } else if (TextUtils.equals("ZC7.4", str)) {
                        c0270w.m649a(C0368u.SMX_P5CD021);
                    }
                    c0270w.m654b(new String(f, 1, f.length - 3, C0429j.f1360a));
                }
                c0272a.m717a(f);
                if (c0272a.f674a == 0 || c0272a.f674a == 1) {
                    c0272a.m716a(c0345a);
                } else if (c0272a.f674a != 2) {
                    c0272a.m718b(c0345a);
                    c0272a.m719c(c0345a);
                }
                c0272a.m720d(c0345a);
            }
        }
        return c0272a;
    }

    private void m716a(C0345a c0345a) {
        byte[] a = c0345a.m996a(new byte[]{(byte) -64, (byte) 2, (byte) 0, (byte) 0, (byte) 4});
        if (c0345a.m1007c()) {
            this.f675b.m1384a((CharSequence) "EEPROM info:");
            this.f675b.m1384a(String.format(C0358k.f1076c + "Start address: 0x%04X", new Object[]{Integer.valueOf(C0429j.m1388a(a[0], a[1]))}));
            this.f675b.m1384a(String.format(C0358k.f1076c + "Size: %d bytes", new Object[]{Integer.valueOf(C0429j.m1388a(a[2], a[3]))}));
        }
    }

    private void m717a(byte[] bArr) {
        String str;
        this.f674a = bArr[0] & MotionEventCompat.ACTION_MASK;
        switch (this.f674a) {
            case C0519c.Switch_thumb /*0*/:
                str = "New (0x00)\n" + C0358k.f1076c + "Configuration state";
                break;
            case C0519c.Switch_track /*1*/:
                str = "Load (0x01)\n" + C0358k.f1076c + "No program active";
                break;
            case C0519c.Switch_textOn /*2*/:
                str = "Pers (0x02)\n" + C0358k.f1076c + "Program inactive, file system active";
                break;
            case C0519c.Switch_textOff /*3*/:
                str = "Test (0x03)\n" + C0358k.f1076c + "Program active, can be overwritten";
                break;
            case C0519c.Switch_thumbTextPadding /*4*/:
                str = "Run (0x04)\n" + C0358k.f1076c + "Program active, cannot be changed";
                break;
            default:
                str = String.format("[unknown] (0x%02X)", new Object[]{Integer.valueOf(this.f674a)});
                break;
        }
        this.f675b.m1384a("Card state: " + str);
    }

    private void m718b(C0345a c0345a) {
        byte[] a = c0345a.m996a(new byte[]{(byte) -64, (byte) 14, (byte) 0, (byte) 3, (byte) 0});
        if (c0345a.m1007c()) {
            this.f675b.m1384a("Card serial no: " + C0429j.m1402b(a, 0, a.length - 2));
        }
    }

    private void m719c(C0345a c0345a) {
        byte[] a = c0345a.m996a(new byte[]{(byte) -64, (byte) 14, (byte) 0, (byte) 0, (byte) 0});
        if (c0345a.m1007c()) {
            CharSequence str = C0429j.m1396a(a, 0, a.length + -2) ? new String(a, 0, a.length - 2, C0429j.f1360a) : C0429j.m1406c(a, 0, a.length - 2);
            this.f675b.m1387b("Application name: \"");
            this.f675b.m1387b(C0429j.m1391a(str));
            this.f675b.m1384a((CharSequence) "\"");
            return;
        }
        this.f675b.m1384a((CharSequence) "Application name not configured");
    }

    private void m720d(C0345a c0345a) {
        byte[] a = c0345a.m996a(new byte[]{(byte) -64, (byte) 72, (byte) 0, (byte) 0, (byte) 4});
        if (c0345a.m1007c() && a.length == 6) {
            this.f675b.m1384a(String.format("Available memory: %d bytes", new Object[]{Integer.valueOf(C0429j.m1388a(a[0], a[1]))}));
            this.f675b.m1384a(String.format(C0358k.f1076c + "Largest free block: %d bytes", new Object[]{Integer.valueOf(C0429j.m1388a(a[2], a[3]))}));
        }
    }

    public C0428i m721a() {
        return this.f675b;
    }
}
