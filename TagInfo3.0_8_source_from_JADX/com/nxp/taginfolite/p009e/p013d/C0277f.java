package com.nxp.taginfolite.p009e.p013d;

import android.support.v4.BuildConfig;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import com.actionbarsherlock.view.Menu;
import com.nxp.taginfolite.p003g.C0422a;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0338a;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.C0362o;
import com.nxp.taginfolite.p004f.p015a.C0332d;
import com.nxp.taginfolite.p004f.p015a.C0337j;
import com.nxp.taginfolite.p004f.p017c.C0345a;
import com.nxp.taginfolite.p009e.C0270w;
import java.util.Arrays;
import java.util.Calendar;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.d.f */
public class C0277f {
    private static final SparseArray f699a;
    private static final byte[] f700b;
    private boolean f701c;
    private C0345a f702d;
    private String f703e;
    private short[] f704f;
    private short[] f705g;
    private byte[] f706h;
    private byte[] f707i;
    private byte[] f708j;
    private byte[] f709k;
    private byte[] f710l;

    static {
        f699a = new C0278g();
        f700b = new byte[]{(byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -4, (byte) 107};
    }

    public C0277f() {
        this.f701c = false;
        this.f705g = null;
        this.f706h = null;
        this.f707i = null;
        this.f708j = null;
        this.f709k = null;
        this.f710l = null;
    }

    public static C0277f m731a(C0270w c0270w) {
        C0277f c0277f = new C0277f();
        C0345a c0345a = new C0345a(c0270w.m661h());
        c0277f.f702d = c0345a;
        byte[] e = c0277f.m739e();
        if (!c0345a.m1007c() && !c0345a.m1009d()) {
            return c0277f.m735b(c0270w) ? c0277f : null;
        } else {
            c0277f.f701c = true;
            c0270w.m651a(true);
            if (e[0] == 111) {
                byte[] g;
                C0337j c0337j = new C0337j(e);
                C0337j b = c0337j.m962b(40805);
                if (b != null) {
                    c0277f.f708j = b.m965g();
                }
                b = c0337j.m962b(40814);
                if (b != null) {
                    g = b.m965g();
                    c0277f.f710l = b.m970l();
                    if (g != null && g.length > 4) {
                        c0270w.m653b(C0429j.m1388a(g[0], g[1]));
                        c0270w.m639a(g[4]);
                    }
                }
                e = c0345a.m1003b(0, 102);
                if (c0345a.m1007c()) {
                    byte[] g2;
                    b = new C0337j(C0332d.PRIVATE, 0, true, e).m962b(115);
                    C0337j b2 = b.m962b(96);
                    if (b2 != null) {
                        b2 = b2.m962b(6);
                        if (b2 != null) {
                            g = b2.m965g();
                            StringBuilder stringBuilder = new StringBuilder();
                            for (int length = f700b.length + 1; length < g.length; length++) {
                                stringBuilder.append(Integer.toString(g[length] & MotionEventCompat.ACTION_MASK));
                                if (length + 1 < g.length) {
                                    stringBuilder.append(".");
                                }
                            }
                            c0277f.f703e = stringBuilder.toString();
                        }
                    }
                    b2 = b.m962b(100);
                    if (b2 != null) {
                        b2 = b2.m962b(6);
                        if (b2 != null) {
                            g2 = b2.m965g();
                            int length2 = f700b.length + 1;
                            c0277f.f704f = new short[]{(short) g2[length2], (short) g2[length2 + 1]};
                        }
                    }
                    b2 = b.m962b(102);
                    if (b2 != null) {
                        b2 = b2.m962b(6);
                        if (b2 != null) {
                            g2 = b2.m965g();
                            int length3 = new byte[]{(byte) 43, (byte) 6, (byte) 1, (byte) 4, (byte) 1, (byte) 42, (byte) 2, (byte) 110}.length + 1;
                            c0277f.f705g = new short[]{(short) 2, (short) g2[length3]};
                        }
                    }
                }
            }
            c0277f.m735b(c0270w);
            return c0277f;
        }
    }

    private static String m732a(byte b, byte b2, Calendar calendar) {
        if (b2 == null && (b & 15) == 0) {
            return (b == null ? "[not set]" : "[invalid]") + String.format("<hexoutput> (0x%02X00)</hexoutput>", new Object[]{Byte.valueOf(b)});
        } else if ((b & MotionEventCompat.ACTION_MASK) >= 160) {
            return "[invalid]" + String.format("<hexoutput> (0x%02X%02X)</hexoutput>", new Object[]{Byte.valueOf(b), Byte.valueOf(b2)});
        } else {
            int i = (((b & 15) * 100) + (((b2 >>> 4) & 15) * 10)) + (b2 & 15);
            if (i > 366) {
                return "[invalid]" + String.format("<hexoutput> (0x%02X%02X)</hexoutput>", new Object[]{Byte.valueOf(b), Byte.valueOf(b2)});
            }
            Calendar instance = Calendar.getInstance();
            int i2 = instance.get(1);
            i2 -= i2 % 10;
            Calendar instance2 = Calendar.getInstance();
            instance2.clear();
            instance2.set(1, i2 + ((b >>> 4) & 15));
            instance2.set(6, i);
            while (true) {
                if (instance2.after(instance) || instance2.after(calendar)) {
                    instance2.add(1, -10);
                } else {
                    return String.format("%d/%02d/%02d", new Object[]{Integer.valueOf(instance2.get(1)), Integer.valueOf(instance2.get(2) + 1), Integer.valueOf(instance2.get(5))}) + String.format("<hexoutput> (0x%02X%02X)</hexoutput>", new Object[]{Byte.valueOf(b), Byte.valueOf(b2)});
                }
            }
        }
    }

    private static String m733a(int i) {
        return (String) f699a.get(Menu.USER_MASK & i);
    }

    private static String m734b(int i) {
        switch (Menu.USER_MASK & i) {
            case C0519c.Switch_thumb /*0*/:
                return "[not set]";
            case 16496:
            case 18320:
            case 18464:
            case 20552:
                return "NXP";
            case 16528:
                return "Infineon";
            case 16768:
                return "INSIDE Secure";
            case 16976:
                return "Samsung";
            case 18256:
                return "STMicroelectronics";
            default:
                return BuildConfig.VERSION_NAME;
        }
    }

    private boolean m735b(C0270w c0270w) {
        byte[] b = this.f702d.m1003b(159, (int) TransportMediator.KEYCODE_MEDIA_PAUSE);
        if (b == null) {
            return false;
        }
        int length = b.length;
        if (!this.f702d.m1007c() || length <= 11) {
            return false;
        }
        c0270w.m640a(C0429j.m1388a(b[3], b[4]));
        int a = C0429j.m1388a(b[5], b[6]);
        c0270w.m647a(C0362o.m1074a(a, c0270w.m665l(), c0270w.m665l()));
        c0270w.m649a(C0362o.m1075a(a, c0270w.m665l(), c0270w.m666m()));
        c0270w.m653b(C0429j.m1388a(b[7], b[8]));
        c0270w.m639a(b[11]);
        this.f709k = Arrays.copyOf(b, b.length);
        c0270w.m653b(C0429j.m1388a(b[7], b[8]));
        c0270w.m639a(b[11]);
        return true;
    }

    private static String m736c(int i) {
        switch (Menu.USER_MASK & i) {
            case C0519c.Switch_thumb /*0*/:
                return "[not set]";
            case 16496:
            case 18450:
                return "NXP";
            case 18320:
            case 18448:
                return "NXP";
            default:
                return BuildConfig.VERSION_NAME;
        }
    }

    private static String m737d(int i) {
        switch (Menu.USER_MASK & i) {
            case C0519c.Switch_thumb /*0*/:
                return "[not set]";
            case 18320:
                return "NXP";
            case 18451:
                return "NXP";
            default:
                return BuildConfig.VERSION_NAME;
        }
    }

    private static String m738e(int i) {
        switch (Menu.USER_MASK & i) {
            case C0519c.Switch_thumb /*0*/:
                return "[not set]";
            case 18320:
                return "NXP";
            case 18324:
                return "NXP";
            default:
                return BuildConfig.VERSION_NAME;
        }
    }

    private byte[] m739e() {
        byte[] bArr = null;
        for (byte[] bArr2 : C0338a.f1021g) {
            bArr = this.f702d.m1005b(bArr2);
            if (this.f702d.m1007c() || this.f702d.m1009d()) {
                this.f706h = Arrays.copyOf(bArr2, bArr2.length);
                if (bArr.length > 2) {
                    this.f707i = Arrays.copyOf(bArr, bArr.length);
                }
                return bArr;
            }
        }
        return bArr;
    }

    private static String m740f(int i) {
        switch (Menu.USER_MASK & i) {
            case C0519c.Switch_thumb /*0*/:
                return "[not set]";
            case 18325:
                return "NXP";
            default:
                return BuildConfig.VERSION_NAME;
        }
    }

    public String m741a() {
        C0428i c0428i = new C0428i();
        if (this.f705g != null) {
            short[] sArr = this.f705g;
            c0428i.m1387b("Java Card version ");
            for (int i = 0; i < sArr.length - 1; i++) {
                c0428i.m1387b(String.format("%d.", new Object[]{Short.valueOf(sArr[i])}));
            }
            c0428i.m1384a(String.format("%d", new Object[]{Short.valueOf(sArr[sArr.length - 1])}));
        }
        if (this.f703e != null) {
            c0428i.m1384a("Global Platform version " + this.f703e);
        }
        if (this.f704f != null) {
            c0428i.m1384a(String.format("GP Secure Channel Protocol: %02X option %X", new Object[]{Short.valueOf(this.f704f[0]), Short.valueOf(this.f704f[1])}));
        }
        if (this.f708j != null) {
            c0428i.m1384a(String.format("Max. length APDU data field: %d bytes", new Object[]{Integer.valueOf(this.f708j[0] & MotionEventCompat.ACTION_MASK)}));
        }
        CharSequence a = C0338a.m971a(new C0422a(this.f706h));
        if (!TextUtils.isEmpty(a)) {
            c0428i.m1384a(a);
            if (this.f707i != null && this.f707i.length > 2) {
                if (C0345a.m986c(this.f707i)) {
                    c0428i.m1387b(C0358k.f1076c + "FCI: ");
                    c0428i.m1384a(C0429j.m1411g(Arrays.copyOfRange(this.f707i, 0, this.f707i.length - 2)));
                } else if (C0345a.m987d(this.f707i)) {
                    c0428i.m1387b(C0358k.f1076c + "Locked");
                    c0428i.m1384a(C0429j.m1411g(this.f707i));
                }
            }
        } else if (this.f707i != null && this.f707i.length > 0) {
            c0428i.m1387b("Card manager FCI: ");
            c0428i.m1384a(C0429j.m1411g(this.f707i));
        }
        return c0428i.toString();
    }

    public String m742a(int i, Calendar calendar) {
        C0428i c0428i = new C0428i();
        CharSequence a;
        if (this.f709k != null && this.f709k.length > 44) {
            byte[] bArr = this.f709k;
            int a2 = C0429j.m1388a(bArr[3], bArr[4]);
            CharSequence b = C0277f.m734b(a2);
            c0428i.m1387b("IC Fabricator: ");
            if (TextUtils.isEmpty(b)) {
                c0428i.m1387b("[unknown]");
            } else {
                c0428i.m1387b(b);
            }
            c0428i.m1384a(String.format("<hexoutput> (0x%02X%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[3]), Byte.valueOf(bArr[4])}));
            String str = (String) C0279h.f726p.get(C0362o.m1074a(C0429j.m1388a(bArr[5], bArr[6]), a2, i));
            c0428i.m1387b("IC Type: ");
            if (TextUtils.isEmpty(str)) {
                c0428i.m1387b("[unknown]");
            } else {
                c0428i.m1387b(str);
            }
            c0428i.m1384a(String.format("<hexoutput> (0x%02X%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[5]), Byte.valueOf(bArr[6])}));
            a = C0277f.m733a(C0429j.m1388a(bArr[7], bArr[8]));
            c0428i.m1387b("OS ID: ");
            if (TextUtils.isEmpty(a)) {
                c0428i.m1387b("[unknown]");
            } else {
                c0428i.m1387b(a);
            }
            c0428i.m1384a(String.format("<hexoutput> (0x%02X%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[7]), Byte.valueOf(bArr[8])}));
            c0428i.m1384a(String.format("OS release date: %s", new Object[]{C0277f.m732a(bArr[9], bArr[10], calendar)}));
            c0428i.m1384a(String.format("OS release level: 0x%02X%02X", new Object[]{Byte.valueOf(bArr[11]), Byte.valueOf(bArr[12])}));
            c0428i.m1384a(String.format("IC Fabrication Date: %s", new Object[]{C0277f.m732a(bArr[13], bArr[14], calendar)}));
            c0428i.m1384a(String.format("IC Serial Number: 0x%02X%02X%02X%02X", new Object[]{Byte.valueOf(bArr[15]), Byte.valueOf(bArr[16]), Byte.valueOf(bArr[17]), Byte.valueOf(bArr[18])}));
            c0428i.m1384a(String.format("IC Batch Identifier: 0x%02X%02X", new Object[]{Byte.valueOf(bArr[19]), Byte.valueOf(bArr[20])}));
            a = C0277f.m736c(C0429j.m1388a(bArr[21], bArr[22]));
            c0428i.m1387b("IC Module Fabricator: ");
            if (TextUtils.isEmpty(a)) {
                c0428i.m1387b("[unknown]");
            } else {
                c0428i.m1387b(a);
            }
            c0428i.m1384a(String.format("<hexoutput> (0x%02X%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[21]), Byte.valueOf(bArr[22])}));
            c0428i.m1384a(String.format("IC Module Packaging Date: %s", new Object[]{C0277f.m732a(bArr[23], bArr[24], calendar)}));
            a = C0277f.m737d(C0429j.m1388a(bArr[25], bArr[26]));
            c0428i.m1387b("ICC Manufacturer: ");
            if (TextUtils.isEmpty(a)) {
                c0428i.m1387b("[unknown]");
            } else {
                c0428i.m1387b(a);
            }
            c0428i.m1384a(String.format("<hexoutput> (0x%02X%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[25]), Byte.valueOf(bArr[26])}));
            c0428i.m1384a(String.format("IC Embedding Date: %s", new Object[]{C0277f.m732a(bArr[27], bArr[28], calendar)}));
            a = C0277f.m738e(C0429j.m1388a(bArr[29], bArr[30]));
            c0428i.m1387b("IC Pre-Personalizer: ");
            if (TextUtils.isEmpty(a)) {
                c0428i.m1387b("[unknown]");
            } else {
                c0428i.m1387b(a);
            }
            c0428i.m1384a(String.format("<hexoutput> (0x%02X%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[29]), Byte.valueOf(bArr[30])}));
            c0428i.m1384a(String.format("IC Pre-Perso. Equipment Date: %s", new Object[]{C0277f.m732a(bArr[31], bArr[32], calendar)}));
            c0428i.m1384a(String.format("IC Pre-Perso. Equipment ID: 0x%02X%02X%02X%02X", new Object[]{Byte.valueOf(bArr[33]), Byte.valueOf(bArr[34]), Byte.valueOf(bArr[35]), Byte.valueOf(bArr[36])}));
            a = C0277f.m740f(C0429j.m1388a(bArr[37], bArr[38]));
            c0428i.m1387b("IC Personalizer: ");
            if (TextUtils.isEmpty(a)) {
                c0428i.m1387b("[unknown]");
            } else {
                c0428i.m1387b(a);
            }
            c0428i.m1384a(String.format("<hexoutput> (0x%02X%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[37]), Byte.valueOf(bArr[38])}));
            c0428i.m1384a(String.format("IC Personalization Date: %s", new Object[]{C0277f.m732a(bArr[39], bArr[40], calendar)}));
            c0428i.m1384a(String.format("IC Perso. Equipment ID: 0x%02X%02X%02X%02X", new Object[]{Byte.valueOf(bArr[41]), Byte.valueOf(bArr[42]), Byte.valueOf(bArr[43]), Byte.valueOf(bArr[44])}));
            c0428i.m1384a(String.format("IC Personalizer: [unknown]<hexoutput> (0x%02X%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[37]), Byte.valueOf(bArr[38])}));
            c0428i.m1384a(String.format("IC Personalization Date: %s", new Object[]{C0277f.m732a(bArr[39], bArr[40], calendar)}));
            c0428i.m1384a(String.format("IC Perso. Equipment ID: 0x%02X%02X%02X%02X", new Object[]{Byte.valueOf(bArr[41]), Byte.valueOf(bArr[42]), Byte.valueOf(bArr[43]), Byte.valueOf(bArr[44])}));
        } else if (this.f710l != null && this.f710l.length > 8) {
            a = C0277f.m733a(C0429j.m1388a(this.f710l[3], this.f710l[4]));
            c0428i.m1387b("OS ID: ");
            if (TextUtils.isEmpty(a)) {
                c0428i.m1387b("[unknown]");
            } else {
                c0428i.m1387b(a);
            }
            c0428i.m1384a(String.format("<hexoutput> (0x%02X%02X)</hexoutput>", new Object[]{Byte.valueOf(this.f710l[3]), Byte.valueOf(this.f710l[4])}));
            c0428i.m1384a(String.format("OS release date: %s", new Object[]{C0277f.m732a(this.f710l[5], this.f710l[6], calendar)}));
            c0428i.m1384a(String.format("OS type: 0x%02X", new Object[]{Byte.valueOf(this.f710l[7])}));
            c0428i.m1384a(String.format("OS release version: 0x%02X", new Object[]{Byte.valueOf(this.f710l[8])}));
        }
        return c0428i.toString();
    }

    public short[] m743b() {
        return this.f705g;
    }

    public byte[] m744c() {
        return this.f706h;
    }

    public boolean m745d() {
        return this.f701c;
    }
}
