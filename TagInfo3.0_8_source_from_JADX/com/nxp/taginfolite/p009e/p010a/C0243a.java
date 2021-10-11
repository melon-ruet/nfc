package com.nxp.taginfolite.p009e.p010a;

import android.support.v4.view.MotionEventCompat;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0355h;
import com.nxp.taginfolite.p004f.C0360m;
import com.nxp.taginfolite.p004f.C0362o;
import com.nxp.taginfolite.p009e.ag;
import com.nxp.taginfolite.p009e.ar;
import com.nxp.taginfolite.p009e.as;
import com.nxp.taginfolite.p009e.at;
import com.nxp.taginfolite.p009e.au;
import com.nxp.taginfolite.p009e.av;
import java.util.Arrays;
import java.util.Calendar;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.a.a */
public class C0243a {
    private static final byte[] f362a;
    private static final byte[] f363b;
    private static final byte[] f364c;
    private static final byte[] f365d;

    static {
        f362a = new byte[]{(byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105};
        f363b = new byte[]{(byte) -86, (byte) -69, (byte) -52, (byte) -35, (byte) -18, (byte) -1};
        f364c = new byte[]{(byte) -123, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        f365d = new byte[]{(byte) 105, (byte) 115, (byte) 115, (byte) 105, (byte) 53, (byte) 54, (byte) 52, (byte) 48};
    }

    private static boolean m374a(byte b) {
        int i = b & MotionEventCompat.ACTION_MASK;
        if ((i & 15) > 9 || ((i >> 4) & 15) > 9) {
            return false;
        }
        return (i & 15) + (((i >> 4) & 15) * 10) <= Calendar.getInstance().get(1) % 100;
    }

    private static boolean m375a(byte b, byte b2) {
        int i = b & MotionEventCompat.ACTION_MASK;
        int i2 = b2 & MotionEventCompat.ACTION_MASK;
        boolean z = (i2 & 240) < 160 && (i2 & 15) < 10 && i2 > 1;
        boolean z2 = (i & 240) < 96 && (i & 15) < 10 && (i & 15) > 0 && i <= 83;
        return z && z2;
    }

    public static boolean m376a(int i, av avVar) {
        return (68 <= i && i <= 72) || i == 80 || i == 192 || i == 193 || i == 194 || i == 199 || i == 200 || i == 100 || i == 224 || i == 225 || i == 227 || i == 226 || i == 228 || avVar == av.PLUS || i == 195 || i == 197 || i == 198;
    }

    public static boolean m377a(ag agVar, byte b) {
        boolean a = agVar.m490a();
        boolean equals = "Infineon Technologies AG".equals(C0355h.m1067b(agVar.m497c(), C0360m.MIFARE));
        au i = agVar.m503i();
        return (i == au.OneK && b == -120) || ((a && i == au.TwoK && b == -103) || ((a && i == au.FourK && b == -104) || ((equals && i == au.FourK && b == 24) || ((a && i == au.Mini && b == (byte) -119) || (a && i == au.Bytes32 && b == (byte) -119)))));
    }

    public static boolean m378a(ag agVar, byte[] bArr) {
        if (agVar.m501g() || agVar.m504j() != av.CLASSIC) {
            return true;
        }
        byte[] c = agVar.m497c();
        byte b = (c.length > 4 || c[0] == 8 || (c[0] & 15) == 15) ? bArr[7] : bArr[5];
        return C0243a.m377a(agVar, b);
    }

    public static boolean m379a(as asVar, int i, byte[] bArr) {
        if ("Infineon Technologies AG".equals(C0355h.m1067b(bArr, C0360m.MIFARE)) && asVar.f480b == au.OneK && i != 136) {
            asVar.f481c = ar.UNKNOWN;
            asVar.f479a = av.UNKNOWN;
            return true;
        } else if (!"NXP Semiconductors".equals(C0355h.m1067b(bArr, C0360m.MIFARE)) || ((asVar.f480b != au.OneK || i == 8 || i == 1) && (asVar.f480b != au.TwoK || i == 25))) {
            return false;
        } else {
            asVar.f481c = ar.UNKNOWN;
            asVar.f479a = av.UNKNOWN;
            return true;
        }
    }

    public static boolean m380a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 7) {
            return Arrays.equals(bArr, Arrays.copyOfRange(bArr2, 0, 7));
        }
        boolean z = bArr[0] == 8 || (bArr[0] & 15) == 15;
        return z || Arrays.equals(bArr, Arrays.copyOfRange(bArr2, 0, 4));
    }

    public static void m381b(ag agVar, byte[] bArr) {
        int i = 0;
        boolean z = true;
        if (bArr != null && bArr.length == 16 && !agVar.m501g()) {
            byte[] c = agVar.m497c();
            av j = agVar.m504j();
            int i2;
            if (j == av.CLASSIC || j == av.PRO) {
                String b = C0355h.m1067b(c, C0360m.MIFARE);
                boolean equals = "NXP Semiconductors".equals(b);
                boolean equals2 = "Infineon Technologies AG".equals(b);
                if (c.length == 4) {
                    if (!(C0243a.m380a(c, bArr) && C0243a.m383b(c, bArr) && C0243a.m378a(agVar, bArr))) {
                        agVar.m487a(ar.UNKNOWN);
                        agVar.m495b(true);
                    }
                    if (equals2 && !C0243a.m377a(agVar, (byte) agVar.m500f())) {
                        agVar.m487a(ar.UNKNOWN);
                        agVar.m495b(true);
                    }
                    if (!agVar.m502h() && c[0] == (byte) 8) {
                        if (bArr[0] == (byte) 4) {
                            agVar.m487a(ar.NXP);
                        } else if (bArr[0] == 5) {
                            agVar.m487a(ar.INFINEON);
                        }
                    }
                    i2 = bArr[8] & MotionEventCompat.ACTION_MASK;
                    if (j == av.CLASSIC && ((equals && !C0243a.m376a(i2, j)) || (equals2 && !C0243a.m382b(i2, j)))) {
                        agVar.m487a(ar.UNKNOWN);
                        agVar.m495b(true);
                    }
                    if (!(i2 == 194 || C0429j.m1396a(bArr, 12, 4) || !equals || !C0243a.m375a(bArr[14], bArr[15]) || C0243a.m374a(bArr[15]))) {
                        agVar.m487a(ar.UNKNOWN);
                        agVar.m495b(true);
                    }
                    if ((68 <= i2 && i2 < 72) || i2 == 192 || i2 == 193 || i2 == 100 || i2 == 224) {
                        c = C0362o.m1079a(bArr, 9);
                        if (c == null || !C0429j.m1404b(c)) {
                            agVar.m495b(true);
                        }
                    }
                    i2 = 0;
                    while (i2 < 8 && bArr[i2 + 8] == f362a[i2]) {
                        i2++;
                    }
                    if (i2 == 8) {
                        agVar.m487a(ar.FUDAN);
                        agVar.m495b(true);
                        return;
                    }
                    i2 = 0;
                    while (i2 < 6 && bArr[i2 + 10] == f363b[i2]) {
                        i2++;
                    }
                    if (i2 == 6) {
                        agVar.m487a(ar.HUAHONG);
                        agVar.m495b(true);
                        return;
                    }
                    i2 = 0;
                    while (i2 < 8 && bArr[i2 + 8] == f364c[i2]) {
                        i2++;
                    }
                    if (i2 == 8) {
                        agVar.m495b(true);
                        return;
                    }
                    while (i < 4 && bArr[i + 8] == f365d[i]) {
                        i++;
                    }
                    if (i == 4) {
                        agVar.m487a(ar.ISSI);
                        agVar.m495b(true);
                    }
                }
            } else if (j == av.PLUS) {
                i2 = c.length == 4 ? bArr[8] & MotionEventCompat.ACTION_MASK : bArr[10] & MotionEventCompat.ACTION_MASK;
                if ((i2 & 240) != 16) {
                    z = false;
                }
                if (z) {
                    agVar.m488a(at.X);
                } else {
                    agVar.m488a(at.S);
                }
                switch (i2 & 15) {
                    case C0519c.Switch_textOn /*2*/:
                        agVar.m489a(au.TwoK);
                    case C0519c.Switch_thumbTextPadding /*4*/:
                        agVar.m489a(au.FourK);
                    default:
                }
            }
        }
    }

    public static boolean m382b(int i, av avVar) {
        return 65 <= i && i <= 67;
    }

    public static boolean m383b(byte[] bArr, byte[] bArr2) {
        boolean z = bArr.length > 4 || bArr[0] == 8 || (bArr[0] & 15) == 15;
        return z || ((((bArr2[0] ^ bArr2[1]) ^ bArr2[2]) ^ bArr2[3]) & MotionEventCompat.ACTION_MASK) == (bArr2[4] & MotionEventCompat.ACTION_MASK);
    }
}
