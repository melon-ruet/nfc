package com.nxp.taginfolite.p009e.p013d;

import android.support.v4.BuildConfig;
import android.text.TextUtils;
import com.actionbarsherlock.C0086R;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0368u;
import com.nxp.taginfolite.p004f.p017c.C0345a;
import com.nxp.taginfolite.p009e.C0270w;
import java.util.HashMap;

/* renamed from: com.nxp.taginfolite.e.d.b */
public class C0273b {
    public static final byte[] f676a;
    private static final HashMap f677b;

    static {
        f677b = new C0274c();
        f676a = new byte[]{(byte) -96, (byte) 0, (byte) 0, (byte) 0, (byte) 24, (byte) 67, (byte) 77};
    }

    public static String m722a(C0275d c0275d, String str) {
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        CharSequence charSequence = (String) f677b.get(c0275d);
        if (charSequence != null) {
            stringBuilder.append(C0429j.m1391a(charSequence));
            if (!TextUtils.isEmpty(str)) {
                stringBuilder.append(" ");
                stringBuilder.append(str);
            }
        }
        return stringBuilder.toString();
    }

    public static void m723a(C0270w c0270w) {
        C0277f n = c0270w.m667n();
        if (n != null && n.m745d() && n.m744c() != null && n.m744c().length >= f676a.length) {
            byte[] c = n.m744c();
            Object obj = 1;
            for (int i = 0; i < f676a.length && obj != null; i++) {
                obj = f676a[i] == c[i] ? 1 : null;
            }
            if (obj != null) {
                c0270w.m646a(C0275d.GEM_TOP);
            }
        }
    }

    private static boolean m724a(int i) {
        switch (i) {
            case 26624:
            case 27904:
            case 28160:
                return true;
            default:
                return false;
        }
    }

    public static void m725b(C0270w c0270w) {
        int i = 9;
        byte[] bArr = new byte[]{Byte.MIN_VALUE, (byte) -54, (byte) -33, (byte) 80, (byte) 23};
        byte[] bArr2 = new byte[]{Byte.MIN_VALUE, (byte) -54, (byte) -33, (byte) 82, (byte) 23};
        C0345a c0345a = new C0345a(c0270w.m661h());
        bArr = c0345a.m996a(bArr);
        if (c0345a.m1007c() && bArr.length > 19) {
            c0270w.m646a(C0275d.OCS_OS);
            switch (bArr[19]) {
                case C0086R.styleable.SherlockTheme_actionModeShareDrawable /*17*/:
                    c0270w.m640a(4);
                    c0270w.m647a(C0279h.SmartMX);
                    c0270w.m649a(C0368u.SMX_P5CT072);
                    break;
                case C0086R.styleable.SherlockTheme_windowContentOverlay /*21*/:
                    c0270w.m640a(4);
                    c0270w.m647a(C0279h.SmartMX);
                    c0270w.m649a(C0368u.SMX_P5CD072);
                    break;
                case C0086R.styleable.SherlockTheme_dropDownHintAppearance /*66*/:
                    c0270w.m640a(4);
                    c0270w.m647a(C0279h.SmartMX);
                    c0270w.m649a(C0368u.SMX_P5CD041);
                    break;
                case (byte) 68:
                    c0270w.m640a(4);
                    c0270w.m647a(C0279h.SmartMX);
                    c0270w.m649a(C0368u.SMX_P5CD081);
                    break;
            }
        }
        bArr2 = c0345a.m996a(bArr2);
        if (c0345a.m1007c() && bArr2.length > 14) {
            c0270w.m646a(C0275d.OCS_OS);
            C0428i p = c0270w.m669p();
            p.m1384a(String.format("Mask no: %02X", new Object[]{Byte.valueOf(bArr2[3])}));
            p.m1384a(String.format("Mask version: %02X", new Object[]{Byte.valueOf(bArr2[4])}));
            p.m1384a(String.format("LDS configuration: %02X", new Object[]{Byte.valueOf(bArr2[5])}));
            p.m1384a(String.format("ROM code: %02X%02X%02X", new Object[]{Byte.valueOf(bArr2[6]), Byte.valueOf(bArr2[7]), Byte.valueOf(bArr2[8])}));
            boolean a = C0429j.m1396a(bArr2, 9, 6);
            p.m1387b(String.format("Patch code: ", new Object[0]));
            if (a) {
                for (int i2 = 9; i2 < 15; i2++) {
                    p.m1387b(String.format("%c", new Object[]{Character.valueOf((char) bArr2[i2])}));
                }
                p.m1387b("<hexoutput> (0x");
                while (i < 15) {
                    p.m1387b(String.format("%02X", new Object[]{Byte.valueOf(bArr2[i])}));
                    i++;
                }
                p.m1387b(")</hexoutput>");
                return;
            }
            p.m1387b("0x");
            while (i < 15) {
                p.m1387b(String.format("%02X", new Object[]{Byte.valueOf(bArr2[i])}));
                i++;
            }
        }
    }

    public static void m726c(C0270w c0270w) {
        byte[] bArr = new byte[]{Byte.MIN_VALUE, (byte) 20, (byte) 0, (byte) 0, (byte) 1, (byte) -1, (byte) 0};
        C0345a c0345a = new C0345a(c0270w.m661h());
        c0345a.m996a(bArr);
        switch (c0345a.m1010e()) {
            case 26368:
            case 26880:
            case 27010:
            case 27265:
            case 36864:
                c0270w.m646a(C0275d.TIMECOS);
            default:
        }
    }

    public static void m727d(C0270w c0270w) {
        byte[] bArr = new byte[]{(byte) 0, (byte) 10, (byte) 0, (byte) 0, (byte) 0};
        C0345a c0345a = new C0345a(c0270w.m661h());
        c0270w.m661h().setTimeout(3000);
        c0345a.m996a(bArr);
        if (!C0273b.m724a(c0345a.m1010e())) {
            c0270w.m646a(C0275d.FMCOS);
            c0270w.m640a(65537);
        }
    }

    public static void m728e(C0270w c0270w) {
        byte[] bArr = new byte[]{Byte.MIN_VALUE, (byte) -8, (byte) 0, (byte) -1, (byte) 0};
        C0345a c0345a = new C0345a(c0270w.m661h());
        c0345a.m996a(bArr);
        int e = c0345a.m1010e();
        if (!C0273b.m724a(e) || e == 27265) {
            c0270w.m646a(C0275d.SMARTCOS);
        }
    }
}
