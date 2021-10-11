package com.nxp.taginfolite.p009e.p013d;

import android.support.v4.BuildConfig;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.actionbarsherlock.view.Menu;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0338a;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.p017c.C0345a;
import com.nxp.taginfolite.p004f.p017c.C0346b;
import com.nxp.taginfolite.p005b.C0182c;
import com.nxp.taginfolite.p005b.C0188i;
import com.nxp.taginfolite.p005b.C0193o;
import com.nxp.taginfolite.p006c.C0198b;
import com.nxp.taginfolite.p009e.C0270w;
import java.util.Arrays;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.d.s */
public class C0290s {
    public static final byte[] f741a;

    static {
        f741a = new byte[]{(byte) -31, (byte) 3};
    }

    public static int m759a(int i) {
        switch (i) {
            case C0519c.Switch_track /*1*/:
                return 0;
            case C0519c.Switch_textOn /*2*/:
            case C0519c.Switch_textOff /*3*/:
                return 12;
            default:
                return -1;
        }
    }

    public static C0182c m760a(byte[] bArr) {
        return C0188i.m162a(Arrays.copyOfRange(bArr, 0, bArr.length - 2));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.ByteArrayOutputStream m761a(long r13, int r15, boolean r16, boolean r17, com.nxp.taginfolite.p004f.p017c.C0345a r18) {
        /*
        if (r16 == 0) goto L_0x0011;
    L_0x0002:
        r1 = 4;
    L_0x0003:
        r0 = r18;
        r1 = r0.m990a(r1);
        r2 = r18.m1007c();
        if (r2 != 0) goto L_0x0013;
    L_0x000f:
        r1 = 0;
    L_0x0010:
        return r1;
    L_0x0011:
        r1 = 2;
        goto L_0x0003;
    L_0x0013:
        if (r16 == 0) goto L_0x0081;
    L_0x0015:
        r2 = 4;
        r2 = new byte[r2];
        r3 = 0;
        r4 = 0;
        r4 = r1[r4];
        r2[r3] = r4;
        r3 = 1;
        r4 = 1;
        r4 = r1[r4];
        r2[r3] = r4;
        r3 = 2;
        r4 = 2;
        r4 = r1[r4];
        r2[r3] = r4;
        r3 = 3;
        r4 = 3;
        r1 = r1[r4];
        r2[r3] = r1;
        r1 = com.nxp.taginfolite.p003g.C0429j.m1390a(r2);
        r3 = r1;
    L_0x0035:
        if (r16 == 0) goto L_0x008e;
    L_0x0037:
        r1 = 4;
    L_0x0039:
        r7 = r3 + r1;
        if (r17 == 0) goto L_0x0091;
    L_0x003d:
        r3 = r13;
    L_0x003e:
        if (r16 == 0) goto L_0x0093;
    L_0x0040:
        r1 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
    L_0x0043:
        r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));
        if (r5 <= 0) goto L_0x00b2;
    L_0x0047:
        r3 = new java.io.ByteArrayOutputStream;
        r4 = (int) r1;
        r3.<init>(r4);
        r4 = 0;
        r5 = r1;
    L_0x004f:
        r1 = (long) r4;
        r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1));
        if (r1 <= 0) goto L_0x0097;
    L_0x0054:
        r1 = 1;
        r2 = r1;
    L_0x0056:
        r9 = (long) r15;
        r1 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1));
        if (r1 <= 0) goto L_0x009a;
    L_0x005b:
        r1 = r15;
    L_0x005c:
        if (r2 != 0) goto L_0x0069;
    L_0x005e:
        r2 = r4 + r1;
        r9 = (long) r2;
        r2 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));
        if (r2 <= 0) goto L_0x0069;
    L_0x0065:
        r1 = (long) r4;
        r1 = r7 - r1;
        r1 = (int) r1;
    L_0x0069:
        r2 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r1 < r2) goto L_0x006f;
    L_0x006d:
        r1 = 255; // 0xff float:3.57E-43 double:1.26E-321;
    L_0x006f:
        r0 = r18;
        r1 = r0.m991a(r4, r1);
        r2 = r18.m1007c();
        if (r2 == 0) goto L_0x007f;
    L_0x007b:
        r2 = r1.length;
        r9 = 2;
        if (r2 != r9) goto L_0x009c;
    L_0x007f:
        r1 = r3;
        goto L_0x0010;
    L_0x0081:
        r2 = 0;
        r2 = r1[r2];
        r3 = 1;
        r1 = r1[r3];
        r1 = com.nxp.taginfolite.p003g.C0429j.m1388a(r2, r1);
        r1 = (long) r1;
        r3 = r1;
        goto L_0x0035;
    L_0x008e:
        r1 = 2;
        goto L_0x0039;
    L_0x0091:
        r3 = r7;
        goto L_0x003e;
    L_0x0093:
        r1 = 65534; // 0xfffe float:9.1833E-41 double:3.2378E-319;
        goto L_0x0043;
    L_0x0097:
        r1 = 0;
        r2 = r1;
        goto L_0x0056;
    L_0x009a:
        r1 = (int) r5;
        goto L_0x005c;
    L_0x009c:
        r2 = r1.length;
        r2 = r2 + -2;
        r9 = 0;
        r3.write(r1, r9, r2);
        r1 = r4 + r2;
        r9 = (long) r2;
        r4 = r5 - r9;
        r9 = 0;
        r2 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1));
        if (r2 <= 0) goto L_0x007f;
    L_0x00ae:
        r11 = r4;
        r5 = r11;
        r4 = r1;
        goto L_0x004f;
    L_0x00b2:
        r1 = r3;
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.e.d.s.a(long, int, boolean, boolean, com.nxp.taginfolite.f.c.a):java.io.ByteArrayOutputStream");
    }

    public static String m762a(byte[] bArr, int i) {
        C0428i c0428i = new C0428i();
        if (!C0345a.m986c(bArr) || bArr.length < 17) {
            c0428i.m1384a((CharSequence) "Error reading CC file");
            if (bArr != null && bArr.length >= 2 && C0429j.m1388a(bArr[0], bArr[1]) < 15) {
                c0428i.m1384a(String.format("CC length: %d bytes", new Object[]{Integer.valueOf(C0429j.m1388a(bArr[0], bArr[1]))}));
                c0428i.m1384a(C0358k.f1076c + "CC length field invalid");
            }
            if (!C0345a.m986c(bArr)) {
                c0428i.m1384a(C0429j.m1391a(C0346b.m1013a(bArr)));
            }
        } else {
            int i2;
            int a = C0429j.m1388a(bArr[0], bArr[1]);
            byte b = bArr[2];
            int a2 = C0429j.m1388a(bArr[3], bArr[4]);
            int a3 = C0429j.m1388a(bArr[5], bArr[6]);
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            long j = -1;
            int[] iArr = new int[2];
            if (bArr[7] == 4) {
                i3 = bArr[8];
                iArr[0] = bArr[9] & MotionEventCompat.ACTION_MASK;
                iArr[1] = bArr[10] & MotionEventCompat.ACTION_MASK;
                j = (long) C0429j.m1388a(bArr[11], bArr[12]);
                i4 = bArr[13] & MotionEventCompat.ACTION_MASK;
                i5 = bArr[14] & MotionEventCompat.ACTION_MASK;
            } else if (bArr[7] == 6) {
                i3 = bArr[8];
                iArr[0] = bArr[9] & MotionEventCompat.ACTION_MASK;
                iArr[1] = bArr[10] & MotionEventCompat.ACTION_MASK;
                j = C0429j.m1390a(bArr[11], bArr[12], bArr[13], bArr[14]);
                i4 = bArr[15] & MotionEventCompat.ACTION_MASK;
                i5 = bArr[16] & MotionEventCompat.ACTION_MASK;
            }
            c0428i.m1387b(String.format("Mapping version %d.%d", new Object[]{Integer.valueOf((b >> 4) & 15), Integer.valueOf(b & 15)}));
            if (i == 1 && i < ((b >> 4) & 15)) {
                c0428i.m1387b(" (ERROR)");
            }
            c0428i.m1383a();
            c0428i.m1384a(String.format("CC length: %d bytes", new Object[]{Integer.valueOf(a)}));
            c0428i.m1387b(String.format("Maximum Le value: %d bytes", new Object[]{Integer.valueOf(a2)}));
            c0428i.m1384a(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(a2)}));
            c0428i.m1387b(String.format("Maximum Lc value: %d bytes", new Object[]{Integer.valueOf(a3)}));
            c0428i.m1384a(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(a3)}));
            if (bArr[7] == 4 || bArr[7] == 6) {
                Object obj = bArr[7] == 6 ? 1 : null;
                if (obj != null) {
                    c0428i.m1387b("Extended ");
                }
                c0428i.m1384a((CharSequence) "NDEF File Control TLV:");
                c0428i.m1387b(String.format(C0358k.f1076c + "Length: %d bytes", new Object[]{Integer.valueOf(i3)}));
                if (obj != null && i3 != 8) {
                    c0428i.m1387b(" (ERROR)");
                } else if (obj == null && i3 != 6) {
                    c0428i.m1387b(" (ERROR)");
                }
                c0428i.m1383a();
                c0428i.m1387b(String.format(C0358k.f1076c + "NDEF file ID: 0x%02X%02X", new Object[]{Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])}));
                switch ((iArr[0] * AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) + iArr[1]) {
                    case C0519c.Switch_thumb /*0*/:
                    case 16128:
                    case 16383:
                    case 57602:
                    case 57603:
                        c0428i.m1387b(" (ERROR)");
                        break;
                    case Menu.USER_MASK /*65535*/:
                        c0428i.m1387b(" [RFU]");
                        break;
                }
                c0428i.m1383a();
                c0428i.m1387b(String.format(C0358k.f1076c + "Maximum NDEF data size: %d bytes", new Object[]{Long.valueOf(j)}));
                if (obj != null) {
                    c0428i.m1387b(String.format("<hexoutput> (0x%04X)</hexoutput>", new Object[]{Long.valueOf(j)}));
                } else {
                    c0428i.m1387b(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Long.valueOf(j)}));
                }
                if (obj == null) {
                    switch ((int) (j & 65535)) {
                        case C0519c.Switch_thumb /*0*/:
                        case C0519c.Switch_track /*1*/:
                        case C0519c.Switch_textOn /*2*/:
                        case C0519c.Switch_textOff /*3*/:
                        case C0519c.Switch_thumbTextPadding /*4*/:
                        case Menu.USER_MASK /*65535*/:
                            c0428i.m1387b(" [RFU]");
                            break;
                    }
                } else if (j <= 65535 || j == -1) {
                    c0428i.m1387b(" [RFU]");
                }
                c0428i.m1383a();
                c0428i.m1387b(C0358k.f1076c + "NDEF access: ");
                if (i4 == 0 && i5 == 0) {
                    c0428i.m1387b(C0429j.m1391a((CharSequence) "Read & Write"));
                } else if (i4 == 0 && i5 == MotionEventCompat.ACTION_MASK) {
                    c0428i.m1387b("Read-Only");
                } else {
                    if (i4 == 0) {
                        c0428i.m1387b("free read access, ");
                    } else if ((1 <= i4 && i4 <= TransportMediator.KEYCODE_MEDIA_PAUSE) || i4 == MotionEventCompat.ACTION_MASK) {
                        c0428i.m1387b("limited read access [RFU], ");
                    } else if (AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS <= i4 && i4 <= 254) {
                        c0428i.m1387b("limited read access (proprietary), ");
                    }
                    if (i5 == 0) {
                        c0428i.m1387b("free write access");
                    } else if ((1 <= i5 && i5 <= TransportMediator.KEYCODE_MEDIA_PAUSE) || i5 == MotionEventCompat.ACTION_MASK) {
                        c0428i.m1387b("limited write access [RFU], ");
                    } else if (AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS <= i5 && i5 <= 254) {
                        c0428i.m1387b("limited write access (proprietary), ");
                    }
                }
                c0428i.m1384a(String.format("<hexoutput> (0x%02X%02X)</hexoutput>", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5)}));
            } else {
                c0428i.m1384a((CharSequence) "No NDEF File Control TLV found");
            }
            if (bArr.length > i3 + 9) {
                i2 = i3 + 9;
                while (i2 + 1 < bArr.length && i2 < a) {
                    int i6 = i2 + 2;
                    if (bArr[i2] == 5) {
                        c0428i.m1384a((CharSequence) "Proprietary File Control TLV:");
                        i5 = bArr[i2 + 1] & MotionEventCompat.ACTION_MASK;
                        if (i5 != MotionEventCompat.ACTION_MASK || i2 + 3 >= bArr.length) {
                            i2 = i6;
                            i6 = i5;
                        } else {
                            i6 = C0429j.m1388a(bArr[i2 + 2], bArr[i2 + 3]);
                            i2 += 4;
                        }
                        c0428i.m1384a(String.format(C0358k.f1076c + "Length: %d bytes", new Object[]{Integer.valueOf(i6)}));
                        if (i2 + i6 < bArr.length) {
                            c0428i.m1384a(C0358k.f1076c + "Value: " + C0429j.m1402b(bArr, i2, i6));
                        }
                    } else {
                        c0428i.m1384a(String.format("Reserved tag field: 0x%02X", new Object[]{Byte.valueOf(bArr[i2])}));
                        i5 = bArr[i2 + 1] & MotionEventCompat.ACTION_MASK;
                        if (i5 != MotionEventCompat.ACTION_MASK || i2 + 3 >= bArr.length) {
                            i2 = i6;
                            i6 = i5;
                        } else {
                            i6 = C0429j.m1388a(bArr[i2 + 2], bArr[i2 + 3]);
                            i2 += 4;
                        }
                    }
                    i2 += i6;
                }
            }
            if (!C0345a.m986c(bArr)) {
                c0428i.m1384a((CharSequence) "Error reading CC file");
                i2 = bArr.length;
                if (!((bArr[i2 - 2] & MotionEventCompat.ACTION_MASK) == MotionEventCompat.ACTION_MASK || (bArr[i2 - 1] & MotionEventCompat.ACTION_MASK) == MotionEventCompat.ACTION_MASK)) {
                    c0428i.m1384a(C0429j.m1391a(C0346b.m1013a(bArr)));
                }
            }
        }
        return c0428i.toString();
    }

    public static void m763a(C0198b c0198b, C0291t c0291t, C0291t c0291t2) {
        StringBuilder stringBuilder;
        int i = 0;
        byte[] bArr = c0291t.f742a;
        if (bArr != null && bArr.length > 2) {
            if ((bArr[2] & 240) == 48) {
                i = 1;
            }
            C0182c c0182c = new C0182c();
            c0182c.m148a(C0290s.m760a(c0291t.f742a));
            c0198b.m216a((CharSequence) "Capability Container (CC) file content", C0290s.m762a(c0291t.f742a, 2));
            c0198b.m213a(c0182c);
        }
        if (c0291t2.f742a != null) {
            stringBuilder = new StringBuilder();
            C0182c c0182c2 = new C0182c();
            if (c0291t.f742a != null) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(C0290s.m762a(c0291t2.f742a, 1));
            c0182c2.m148a(C0290s.m760a(c0291t2.f742a));
            c0198b.m219b("Capability Container (CC) file content", stringBuilder.toString());
            c0198b.m217b(c0182c2);
        }
        stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        if (c0291t.f744c != null) {
            stringBuilder.append(C0270w.m618a(c0291t.f744c, 2));
        }
        if (c0291t2.f744c != null) {
            if (c0291t.f744c != null) {
                stringBuilder.append("\n\n");
            }
            stringBuilder.append(C0270w.m618a(c0291t2.f744c, 1));
        }
        c0198b.m218b(stringBuilder.toString());
        if (c0291t.f743b != null || c0291t2.f743b != null) {
            CharSequence charSequence;
            c0182c = new C0182c();
            if (c0291t.f743b != null) {
                if (c0291t2.f743b != null) {
                    if (i != 0) {
                        c0182c.m147a(new C0193o("Version 3:"));
                    } else {
                        c0182c.m147a(new C0193o("Version 2:"));
                    }
                }
                c0182c.m148a(c0291t.f743b);
            }
            if (c0291t2.f743b != null) {
                if (c0291t.f743b != null) {
                    c0182c.m147a(new C0193o(" "));
                    c0182c.m147a(new C0193o("Version 1:"));
                }
                c0182c.m148a(c0291t2.f743b);
            }
            String str = "NDEF file contents";
            if (i != 0) {
                charSequence = "Extended " + str;
            } else {
                Object obj = str;
            }
            c0198b.m215a(charSequence, c0182c);
        }
    }

    public static byte[] m764a(int i, C0345a c0345a) {
        return c0345a.m998a(f741a, C0290s.m759a(i), -1);
    }

    public static byte[] m765a(int i, C0345a c0345a, boolean z) {
        int i2 = 17;
        byte[] a = c0345a.m990a(15);
        byte[] f = c0345a.m1011f();
        if (!c0345a.m1007c() || a.length < 15) {
            return f;
        }
        if (i == 2 && (a[2] & 240) == 48) {
            f = c0345a.m990a(17);
        } else {
            i2 = 15;
            f = a;
        }
        if (!z) {
            return f;
        }
        int i3;
        byte[] bArr;
        int a2 = C0429j.m1388a(f[3], f[4]);
        byte[] copyOf = Arrays.copyOf(f, f.length - 2);
        int a3 = C0429j.m1388a(copyOf[0], copyOf[1]) - copyOf.length;
        f = null;
        while (a3 > 0) {
            i3 = a3 > a2 ? a2 : a3;
            if (i3 >= AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) {
                i3 = MotionEventCompat.ACTION_MASK;
            }
            f = c0345a.m991a(i2, i3);
            if (!c0345a.m1007c()) {
                bArr = f;
                i3 = 1;
                break;
            }
            int length = f.length - 2;
            copyOf = C0429j.m1399a(copyOf, f, length);
            i2 += length;
            a3 -= length;
        }
        bArr = f;
        i3 = 0;
        if (i3 != 0) {
            return (bArr == null || bArr.length < 2) ? C0429j.m1399a(copyOf, new byte[]{(byte) -1, (byte) -1}, 2) : C0429j.m1398a(copyOf, bArr);
        } else {
            return c0345a.m1007c() ? C0429j.m1398a(copyOf, c0345a.m991a(i2, 0)) : C0429j.m1398a(copyOf, new byte[]{(byte) -112, (byte) 0});
        }
    }

    public static byte[] m766a(int i, byte[] bArr, C0345a c0345a) {
        return c0345a.m998a(bArr, C0290s.m759a(i), -1);
    }

    public static byte[] m767b(int i) {
        switch (i) {
            case C0519c.Switch_track /*1*/:
                return C0338a.f1022h;
            case C0519c.Switch_textOn /*2*/:
            case C0519c.Switch_textOff /*3*/:
                return C0338a.f1023i;
            default:
                return null;
        }
    }

    public static byte[] m768b(int i, C0345a c0345a) {
        int i2;
        switch (i) {
            case C0519c.Switch_track /*1*/:
                i2 = -1;
                break;
            case C0519c.Switch_textOn /*2*/:
            case C0519c.Switch_textOff /*3*/:
                i2 = 0;
                break;
            default:
                return null;
        }
        return c0345a.m995a(0, C0290s.m767b(i), i2);
    }
}
