package com.nxp.taginfolite.p009e.p014e;

import android.nfc.TagLostException;
import android.nfc.tech.MifareUltralight;
import android.support.v4.BuildConfig;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.C0372z;
import com.nxp.taginfolite.p009e.az;
import java.io.IOException;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.e.k */
public class C0303k {
    private static String m812a(int i, byte[] bArr, int i2) {
        int i3 = 480;
        boolean z = true;
        if (bArr == null || bArr.length < 3 || i < 16) {
            return "?";
        }
        int i4;
        Boolean bool;
        switch (i2) {
            case 888:
                i4 = 16;
                break;
            case 1904:
                i4 = 32;
                break;
            default:
                i4 = 0;
                break;
        }
        Boolean bool2 = null;
        if (i2 == 888) {
            i3 = 226;
        } else if (i2 == 1904) {
        }
        if (i < i3) {
            i3 = (i - 16) / i4;
            Boolean valueOf = Boolean.valueOf(((C0429j.m1388a(bArr[1], bArr[0]) >> i3) & 1) == 1);
            if (((bArr[2] >> (i3 / 2)) & 1) != 1) {
                z = false;
            }
            bool2 = Boolean.valueOf(z);
            bool = valueOf;
        } else if (i == i3) {
            if ((bArr[2] & MotionEventCompat.ACTION_MASK) != MotionEventCompat.ACTION_MASK) {
                z = false;
            }
            bool2 = Boolean.valueOf(z);
            bool = bool2;
        } else {
            bool = null;
        }
        return bool == null ? "?" : (bool.booleanValue() && bool2.booleanValue()) ? "*" : bool.booleanValue() ? "x" : bool2.booleanValue() ? "+" : ".";
    }

    public static String m813a(byte[] bArr, boolean z, boolean z2, Integer num) {
        if (bArr == null || bArr.length < 7) {
            return null;
        }
        int i = bArr[0] & MotionEventCompat.ACTION_MASK;
        int i2 = bArr[1] & MotionEventCompat.ACTION_MASK;
        int i3 = i2 * 4;
        int i4 = bArr[2] & MotionEventCompat.ACTION_MASK;
        int a = C0429j.m1388a(bArr[4], bArr[3]);
        int i5 = bArr[5] & 1;
        int i6 = bArr[6] & MotionEventCompat.ACTION_MASK;
        int i7 = bArr[6] & MotionEventCompat.ACTION_MASK;
        int i8 = z2 ? 124 : 119;
        if (num != null && !z2 && num.intValue() == 888) {
            i8 = 55;
        } else if (num != null && z2 && num.intValue() == AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT) {
            i8 = 60;
        }
        C0428i c0428i = new C0428i();
        if (!z2) {
            c0428i.m1384a((CharSequence) "Last NDEF message page address:");
            c0428i.m1384a(String.format(C0358k.f1076c + "Sector %d, page 0x%02X" + "<hexoutput>" + " (0x%02X)" + "</hexoutput>", new Object[]{Integer.valueOf(i3 / AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY), Integer.valueOf(i3 % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY), Integer.valueOf(i2)}));
            Object obj = (i2 == 0 || i2 > i8) ? 1 : null;
            if (obj != null) {
                c0428i.m1384a((CharSequence) "\t\u2022 ERROR: invalid last NDEF message page address");
            } else if (z && i2 != 0) {
                c0428i.m1387b(C0358k.f1076c);
                if ((i6 & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0) {
                    c0428i.m1384a((CharSequence) "All bytes read from last NDEF message page");
                } else {
                    c0428i.m1384a((CharSequence) "Not all bytes read from last NDEF message page");
                }
            }
            c0428i.m1383a();
        }
        c0428i.m1384a((CharSequence) "Field detection pin configuration:");
        c0428i.m1387b(C0358k.f1076c + "Signal down on ");
        i3 = (i & 12) >> 2;
        switch (i3) {
            case C0519c.Switch_thumb /*0*/:
                c0428i.m1384a((CharSequence) "field presence");
                break;
            case C0519c.Switch_track /*1*/:
                c0428i.m1384a((CharSequence) "first valid SoF");
                break;
            case C0519c.Switch_textOn /*2*/:
                c0428i.m1384a((CharSequence) "tag selection");
                break;
            case C0519c.Switch_textOff /*3*/:
                if ((i & 1) == 0) {
                    c0428i.m1384a((CharSequence) "pass-through data read from RF");
                    break;
                }
                c0428i.m1384a((CharSequence) "pass-through data ready to be read from I\u00b2C");
                break;
        }
        c0428i.m1387b(C0358k.f1076c + "Signal up on ");
        switch ((i & 48) >> 4) {
            case C0519c.Switch_thumb /*0*/:
                c0428i.m1384a((CharSequence) "field switched off");
                break;
            case C0519c.Switch_track /*1*/:
                c0428i.m1384a((CharSequence) "field switched off or tag to HALT state");
                break;
            case C0519c.Switch_textOn /*2*/:
                c0428i.m1384a((CharSequence) "field switched off or full NDEF message read");
                break;
            case C0519c.Switch_textOff /*3*/:
                if (i3 != 3) {
                    c0428i.m1384a((CharSequence) "field switched off");
                    break;
                }
                c0428i.m1384a("field switched off or if last data is " + ((i & 1) != 0 ? "read" : "written") + " by " + "I\u00b2C");
                break;
        }
        c0428i.m1383a();
        c0428i.m1384a((CharSequence) "SRAM buffer configuration:");
        c0428i.m1387b(C0358k.f1076c + "Mirroring ");
        c0428i.m1384a((i & 2) != 0 ? "enabled (if VCC present)" : "disabled");
        if ((i & 2) != 0) {
            Object obj2;
            if (z2) {
                c0428i.m1384a(String.format(C0358k.f1076c + "Mirror address: block 0x%02X", new Object[]{Integer.valueOf(i4)}));
                if (i4 % 4 != 0 || i4 == 0 || i4 > i8 - 3) {
                    obj2 = 1;
                }
                obj2 = null;
            } else {
                i2 = i4 * 4;
                c0428i.m1384a(String.format(C0358k.f1076c + "Mirror address: sector %d, page 0x%02X" + "<hexoutput>" + " (0x%02X)" + "</hexoutput>", new Object[]{Integer.valueOf(i2 / AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY), Integer.valueOf(i2 % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY), Integer.valueOf(i4)}));
                if (i4 == 0 || i4 > i8 - 3) {
                    obj2 = 1;
                }
                obj2 = null;
            }
            if (obj2 != null) {
                c0428i.m1384a((CharSequence) "\t\u2022 ERROR: invalid SRAM mirror address");
            }
        }
        if (z) {
            c0428i.m1387b(C0358k.f1076c + "Pass-through mode ");
            c0428i.m1384a((i & 64) != 0 ? "enabled" : "disabled");
            if ((i & 64) != 0) {
                c0428i.m1387b(C0358k.f1076c + "Pass-through from ");
                c0428i.m1384a((i & 1) != 0 ? "RF to I\u00b2C" : "I\u00b2C to RF");
            }
        }
        if (z) {
            if ((i6 & 24) != 0) {
                c0428i.m1387b(C0358k.f1076c + "Data is ready in SRAM for ");
                if ((i6 & 16) != 0) {
                    c0428i.m1384a((CharSequence) "I\u00b2C read");
                }
                if ((i6 & 8) != 0) {
                    c0428i.m1384a((CharSequence) "RF read");
                }
            } else {
                c0428i.m1384a(C0358k.f1076c + "No data ready in SRAM");
            }
        }
        c0428i.m1383a();
        c0428i.m1384a((CharSequence) "I\u00b2C configuration: ");
        c0428i.m1387b(C0358k.f1076c + "Soft reset through repeated start ");
        c0428i.m1384a((i & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0 ? "enabled" : "disabled");
        c0428i.m1387b(C0358k.f1076c + "Clock stretching ");
        c0428i.m1384a(i5 == 1 ? "enabled" : "disabled");
        double d = (((double) a) * 1000.0d) / 106.0d;
        String str = "\u00b5s";
        if (d > 1000.0d) {
            d /= 1000.0d;
            str = "ms";
        }
        c0428i.m1384a(String.format(C0358k.f1076c + "Watchdog time-out: %.2f" + "\u200a" + "%s" + "<hexoutput>" + " (0x%04X)" + "</hexoutput>", new Object[]{Double.valueOf(d), str, Integer.valueOf(a)}));
        c0428i.m1383a();
        if (z) {
            c0428i.m1384a((CharSequence) "Memory access:");
            if ((i6 & 64) != 0) {
                c0428i.m1384a(C0358k.f1076c + "Memory access is locked to " + "I\u00b2C" + " interface");
            }
            if ((i6 & 32) != 0) {
                c0428i.m1384a(C0358k.f1076c + "Memory access is locked to RF interface");
            }
            if ((i6 & 96) == 0) {
                c0428i.m1384a(C0358k.f1076c + "Memory access not locked");
            }
            if ((i6 & 4) != 0) {
                c0428i.m1384a(C0358k.f1076c + "HV voltage error during EPP cycle via " + "I\u00b2C" + " host");
            }
            c0428i.m1387b(C0358k.f1076c + "EEPROM write cycle ");
            if ((i6 & 2) != 0) {
                c0428i.m1384a((CharSequence) "active (access disabled)");
            } else {
                c0428i.m1384a((CharSequence) "is possible");
            }
            c0428i.m1383a();
            if ((i6 & 1) != 0) {
                c0428i.m1384a((CharSequence) "RF field detected");
            } else {
                c0428i.m1384a((CharSequence) "No RF field detected");
            }
        } else {
            if ((i7 & 2) == 0) {
                c0428i.m1384a((CharSequence) "Configuration changeable from I\u00b2C");
            } else {
                c0428i.m1384a((CharSequence) "Configuration locked from I\u00b2C");
            }
            if ((i7 & 1) == 0) {
                c0428i.m1384a((CharSequence) "Configuration changeable from RF");
            } else {
                c0428i.m1384a((CharSequence) "Configuration locked from RF");
            }
        }
        c0428i.m1383a();
        if (z2) {
            c0428i.m1384a(C0429j.m1394a(bArr, BuildConfig.VERSION_NAME, " ", 0, 7));
        } else {
            i8 = z ? 248 : 232;
            c0428i.m1387b(String.format("[%02X]", new Object[]{Integer.valueOf(i8)}));
            c0428i.m1384a(C0429j.m1394a(bArr, "  ", " ", 0, 4));
            c0428i.m1387b(String.format("[%02X]", new Object[]{Integer.valueOf(i8 + 1)}));
            c0428i.m1384a(C0429j.m1394a(bArr, "  ", " ", 4, 4));
        }
        return c0428i.toString();
    }

    private static void m814a(MifareUltralight mifareUltralight, int i) {
        byte[] bArr = new byte[]{(byte) i, (byte) 0, (byte) 0, (byte) 0};
        byte[] bArr2 = null;
        try {
            bArr2 = mifareUltralight.transceive(new byte[]{(byte) -62, (byte) -1});
        } catch (TagLostException e) {
            throw new TagLostException("Sector Select part 1: no response");
        } catch (IOException e2) {
        }
        try {
            mifareUltralight.transceive(bArr);
            throw new IOException("Sector Select part 2 failed");
        } catch (TagLostException e3) {
            if (bArr2 != null && bArr2.length != 1) {
                throw new IOException("Sector Select part 1 failed");
            }
        }
    }

    private static byte[] m815a(az azVar, boolean z) {
        Integer valueOf;
        if (z) {
            valueOf = Integer.valueOf(1016);
        } else {
            valueOf = C0372z.m1118d(azVar.a);
            if (valueOf != null) {
                valueOf = Integer.valueOf(valueOf.intValue() == 888 ? 232 : 488);
            } else {
                valueOf = null;
            }
        }
        if (valueOf == null) {
            return null;
        }
        int intValue = valueOf.intValue() / AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
        MifareUltralight mifareUltralight = azVar.f541k;
        try {
            C0303k.m814a(mifareUltralight, intValue);
            return mifareUltralight.readPages(valueOf.intValue() % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
        } catch (IOException e) {
            throw new TagLostException("SectorSelect failed");
        }
    }

    public static byte[][] m816a(az azVar) {
        byte[][] bArr = new byte[][]{C0303k.m815a(azVar, false), C0303k.m815a(azVar, true)};
        try {
            C0303k.m814a(azVar.f541k, 0);
            return bArr;
        } catch (IOException e) {
            throw new TagLostException("SectorSelect failed");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.nxp.taginfolite.p005b.C0182c m817b(com.nxp.taginfolite.p009e.az r19) {
        /*
        r0 = r19;
        r15 = r0.f541k;
        r16 = new com.nxp.taginfolite.b.c;
        r16.<init>();
        r2 = 0;
        r0 = r19;
        r3 = r0.f550t;
        if (r3 == 0) goto L_0x010c;
    L_0x0010:
        r0 = r19;
        r3 = r0.f550t;
        r4 = 1;
        r3 = r3[r4];
        if (r3 == 0) goto L_0x0033;
    L_0x0019:
        r4 = r3.length;
        r5 = 7;
        if (r4 < r5) goto L_0x0033;
    L_0x001d:
        r4 = 6;
        r3 = r3[r4];
        r3 = r3 & 255;
        r3 = r3 & 64;
        if (r3 == 0) goto L_0x0033;
    L_0x0026:
        r2 = 1;
        r3 = new com.nxp.taginfolite.b.o;
        r4 = "Memory access is locked to I\u00b2C interface";
        r3.<init>(r4);
        r0 = r16;
        r0.m147a(r3);
    L_0x0033:
        r8 = r2;
    L_0x0034:
        r0 = r19;
        r2 = r0.a;
        r2 = com.nxp.taginfolite.p004f.C0372z.m1118d(r2);
        r3 = 480; // 0x1e0 float:6.73E-43 double:2.37E-321;
        if (r2 != 0) goto L_0x0398;
    L_0x0040:
        r2 = 1904; // 0x770 float:2.668E-42 double:9.407E-321;
        r2 = java.lang.Integer.valueOf(r2);
        r9 = r2;
    L_0x0047:
        r2 = r9.intValue();
        r4 = 888; // 0x378 float:1.244E-42 double:4.387E-321;
        if (r2 != r4) goto L_0x0122;
    L_0x004f:
        r2 = 226; // 0xe2 float:3.17E-43 double:1.117E-321;
        r10 = r2;
    L_0x0052:
        r11 = 0;
        if (r8 != 0) goto L_0x02cf;
    L_0x0055:
        r2 = 0;
        r12 = r15.readPages(r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2 = 10;
        r13 = r12[r2];	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2 = 11;
        r14 = r12[r2];	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r7 = "(UID0-UID2)";
        r2 = new com.nxp.taginfolite.b.p;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r3 = 0;
        r4 = 3;
        r5 = "*";
        r6 = 0;
        r17 = 4;
        r0 = r17;
        r6 = java.util.Arrays.copyOfRange(r12, r6, r0);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2.<init>(r3, r4, r5, r6, r7);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r16;
        r0.m147a(r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r7 = "(UID3-UID6)";
        r2 = new com.nxp.taginfolite.b.p;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r3 = 1;
        r4 = 3;
        r5 = "*";
        r6 = 4;
        r17 = 8;
        r0 = r17;
        r6 = java.util.Arrays.copyOfRange(r12, r6, r0);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2.<init>(r3, r4, r5, r6, r7);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r16;
        r0.m147a(r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2 = r13 & 7;
        r3 = 7;
        if (r2 != r3) goto L_0x012f;
    L_0x0099:
        r5 = "*";
    L_0x009b:
        r2 = new com.nxp.taginfolite.b.p;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r3 = 2;
        r4 = 3;
        r6 = 8;
        r7 = 12;
        r6 = java.util.Arrays.copyOfRange(r12, r6, r7);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r7 = "(CFG0-CFG1, LOCK0-LOCK1)";
        r2.<init>(r3, r4, r5, r6, r7);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r16;
        r0.m147a(r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2 = r13 & 8;
        if (r2 == 0) goto L_0x0147;
    L_0x00b5:
        r2 = r13 & 1;
        if (r2 == 0) goto L_0x0143;
    L_0x00b9:
        r5 = "*";
    L_0x00bb:
        r2 = new com.nxp.taginfolite.b.p;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r3 = 3;
        r4 = 3;
        r6 = 12;
        r7 = 16;
        r6 = java.util.Arrays.copyOfRange(r12, r6, r7);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r7 = "(CC0-CC3)";
        r2.<init>(r3, r4, r5, r6, r7);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r16;
        r0.m147a(r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2 = 1;
        r3 = r2;
    L_0x00d3:
        r2 = 4;
        if (r3 >= r2) goto L_0x0158;
    L_0x00d6:
        r4 = com.nxp.taginfolite.p009e.C0253s.m522a(r3, r13, r14);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2 = r3 * 4;
        r5 = r15.readPages(r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2 = r5.length;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r6 = 16;
        if (r2 < r6) goto L_0x0153;
    L_0x00e5:
        r2 = 0;
    L_0x00e6:
        r6 = r5.length;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        if (r2 >= r6) goto L_0x0153;
    L_0x00e9:
        r6 = new com.nxp.taginfolite.b.p;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r7 = r3 * 4;
        r12 = r2 / 4;
        r7 = r7 + r12;
        r12 = 3;
        r17 = r2 / 4;
        r17 = r4[r17];	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r18 = r2 + 4;
        r0 = r18;
        r18 = java.util.Arrays.copyOfRange(r5, r2, r0);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r17;
        r1 = r18;
        r6.<init>(r7, r12, r0, r1);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r16;
        r0.m147a(r6);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2 = r2 + 4;
        goto L_0x00e6;
    L_0x010c:
        r0 = r19;
        r3 = r0.f543m;
        if (r3 == 0) goto L_0x011f;
    L_0x0112:
        r2 = 1;
        r3 = new com.nxp.taginfolite.b.o;
        r4 = "Memory access is locked to I\u00b2C interface";
        r3.<init>(r4);
        r0 = r16;
        r0.m147a(r3);
    L_0x011f:
        r8 = r2;
        goto L_0x0034;
    L_0x0122:
        r2 = r9.intValue();
        r4 = 1904; // 0x770 float:2.668E-42 double:9.407E-321;
        if (r2 != r4) goto L_0x0395;
    L_0x012a:
        r2 = 480; // 0x1e0 float:6.73E-43 double:2.37E-321;
        r10 = r2;
        goto L_0x0052;
    L_0x012f:
        if (r13 != 0) goto L_0x0137;
    L_0x0131:
        if (r14 != 0) goto L_0x0137;
    L_0x0133:
        r5 = ".";
        goto L_0x009b;
    L_0x0137:
        r2 = r13 & 7;
        if (r2 != 0) goto L_0x013f;
    L_0x013b:
        r5 = "x";
        goto L_0x009b;
    L_0x013f:
        r5 = "+";
        goto L_0x009b;
    L_0x0143:
        r5 = "x";
        goto L_0x00bb;
    L_0x0147:
        r2 = r13 & 1;
        if (r2 == 0) goto L_0x014f;
    L_0x014b:
        r5 = "+";
        goto L_0x00bb;
    L_0x014f:
        r5 = ".";
        goto L_0x00bb;
    L_0x0153:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x00d3;
    L_0x0158:
        r2 = r9.intValue();	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r3 = 1904; // 0x770 float:2.668E-42 double:9.407E-321;
        if (r2 != r3) goto L_0x0164;
    L_0x0160:
        r2 = 1;
        com.nxp.taginfolite.p009e.p014e.C0303k.m814a(r15, r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
    L_0x0164:
        r2 = r10 % 256;
        r17 = r15.readPages(r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2 = r9.intValue();	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r3 = 1904; // 0x770 float:2.668E-42 double:9.407E-321;
        if (r2 != r3) goto L_0x0176;
    L_0x0172:
        r2 = 0;
        com.nxp.taginfolite.p009e.p014e.C0303k.m814a(r15, r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
    L_0x0176:
        r13 = 0;
        r2 = 16;
        r14 = r2;
        r2 = r13;
    L_0x017b:
        if (r14 > r10) goto L_0x0274;
    L_0x017d:
        r3 = r14 % 256;
        if (r3 != 0) goto L_0x0392;
    L_0x0181:
        r2 = r2 + 1;
        com.nxp.taginfolite.p009e.p014e.C0303k.m814a(r15, r2);	 Catch:{ IOException -> 0x01c4, TagLostException -> 0x01cd, IndexOutOfBoundsException -> 0x038c }
        r13 = r2;
    L_0x0187:
        r2 = r14 % 256;
        r18 = r15.readPages(r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r18;
        r2 = r0.length;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r3 = 16;
        if (r2 < r3) goto L_0x026e;
    L_0x0194:
        r2 = r9.intValue();	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r17;
        r5 = com.nxp.taginfolite.p009e.p014e.C0303k.m812a(r14, r0, r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2 = 0;
        r12 = r2;
    L_0x01a0:
        r0 = r18;
        r2 = r0.length;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        if (r12 >= r2) goto L_0x026e;
    L_0x01a5:
        r2 = r12 / 4;
        r2 = r2 + r14;
        if (r2 >= r10) goto L_0x0249;
    L_0x01aa:
        r2 = new com.nxp.taginfolite.b.p;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r3 = r12 / 4;
        r3 = r3 + r14;
        r4 = 3;
        r6 = r12 + 4;
        r0 = r18;
        r6 = java.util.Arrays.copyOfRange(r0, r12, r6);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2.<init>(r3, r4, r5, r6);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r16;
        r0.m147a(r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
    L_0x01c0:
        r2 = r12 + 4;
        r12 = r2;
        goto L_0x01a0;
    L_0x01c4:
        r2 = move-exception;
        r2 = new android.nfc.TagLostException;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r3 = "SectorSelect failed";
        r2.<init>(r3);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        throw r2;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
    L_0x01cd:
        r2 = move-exception;
        r2 = 1;
        r0 = r19;
        r0.f542l = r2;
        r2 = "\n<aborted: tag disappeared>";
        r9 = r2;
    L_0x01d6:
        r2 = r19.m560h();
        r3 = 1;
        r10 = r2[r3];
        if (r10 == 0) goto L_0x0222;
    L_0x01df:
        r2 = r10.length;
        r3 = 16;
        if (r2 < r3) goto L_0x0222;
    L_0x01e4:
        r2 = new com.nxp.taginfolite.b.n;
        r3 = "\nSession registers:";
        r3 = com.nxp.taginfolite.p003g.C0429j.m1391a(r3);
        r2.<init>(r3);
        r0 = r16;
        r0.m147a(r2);
        r2 = new com.nxp.taginfolite.b.p;
        r3 = 1016; // 0x3f8 float:1.424E-42 double:5.02E-321;
        r4 = 3;
        r5 = "r";
        r6 = 0;
        r7 = 4;
        r6 = java.util.Arrays.copyOfRange(r10, r6, r7);
        r7 = "(NC, LD, SM, WDT0)";
        r2.<init>(r3, r4, r5, r6, r7);
        r0 = r16;
        r0.m147a(r2);
        r2 = new com.nxp.taginfolite.b.p;
        r3 = 1017; // 0x3f9 float:1.425E-42 double:5.025E-321;
        r4 = 3;
        r5 = "r";
        r6 = 4;
        r7 = 7;
        r6 = java.util.Arrays.copyOfRange(r10, r6, r7);
        r7 = "(WDT1, CLK, NS)";
        r2.<init>(r3, r4, r5, r6, r7);
        r0 = r16;
        r0.m147a(r2);
    L_0x0222:
        r2 = android.text.TextUtils.isEmpty(r9);
        if (r2 != 0) goto L_0x0238;
    L_0x0228:
        if (r8 != 0) goto L_0x0238;
    L_0x022a:
        r2 = new com.nxp.taginfolite.b.n;
        r3 = com.nxp.taginfolite.p003g.C0429j.m1391a(r9);
        r2.<init>(r3);
        r0 = r16;
        r0.m147a(r2);
    L_0x0238:
        r2 = new com.nxp.taginfolite.b.o;
        r3 = "\n  *:locked & blocked, x:locked,\n  +:blocked, .:un(b)locked\n  w:readable & writable  r:readable (write-protected)";
        r3 = com.nxp.taginfolite.p003g.C0429j.m1391a(r3);
        r2.<init>(r3);
        r0 = r16;
        r0.m147a(r2);
        return r16;
    L_0x0249:
        r2 = r12 / 4;
        r2 = r2 + r14;
        if (r2 != r10) goto L_0x01c0;
    L_0x024e:
        r2 = new com.nxp.taginfolite.b.p;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r3 = r12 / 4;
        r3 = r3 + r14;
        r4 = 3;
        r6 = r12 + 4;
        r0 = r18;
        r6 = java.util.Arrays.copyOfRange(r0, r12, r6);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r7 = "(LOCK2-LOCK4, CHK)";
        r2.<init>(r3, r4, r5, r6, r7);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r16;
        r0.m147a(r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        goto L_0x01c0;
    L_0x0268:
        r2 = move-exception;
        r2 = "\n<aborted: read error>";
        r9 = r2;
        goto L_0x01d6;
    L_0x026e:
        r2 = r14 + 4;
        r14 = r2;
        r2 = r13;
        goto L_0x017b;
    L_0x0274:
        r2 = r9.intValue();	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r3 = 888; // 0x378 float:1.244E-42 double:4.387E-321;
        if (r2 != r3) goto L_0x0356;
    L_0x027c:
        r3 = 232; // 0xe8 float:3.25E-43 double:1.146E-321;
    L_0x027e:
        r2 = r19.m560h();	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r4 = 0;
        r10 = r2[r4];	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        if (r10 == 0) goto L_0x02cf;
    L_0x0287:
        r2 = r10.length;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r4 = 16;
        if (r2 < r4) goto L_0x02cf;
    L_0x028c:
        r2 = 6;
        r2 = r10[r2];	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2 = r2 & 255;
        r2 = r2 & 2;
        if (r2 == 0) goto L_0x035a;
    L_0x0295:
        r5 = "r";
    L_0x0297:
        r2 = new com.nxp.taginfolite.b.n;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r4 = "\nConfiguration registers:";
        r4 = com.nxp.taginfolite.p003g.C0429j.m1391a(r4);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2.<init>(r4);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r16;
        r0.m147a(r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2 = new com.nxp.taginfolite.b.p;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r4 = 3;
        r6 = 0;
        r7 = 4;
        r6 = java.util.Arrays.copyOfRange(r10, r6, r7);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r7 = "(NC, LD, SM, WDT0)";
        r2.<init>(r3, r4, r5, r6, r7);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r16;
        r0.m147a(r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2 = new com.nxp.taginfolite.b.p;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r3 = r3 + 1;
        r4 = 3;
        r6 = 4;
        r7 = 7;
        r6 = java.util.Arrays.copyOfRange(r10, r6, r7);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r7 = "(WDT1, CLK, LOCK)";
        r2.<init>(r3, r4, r5, r6, r7);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r16;
        r0.m147a(r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
    L_0x02cf:
        r2 = r9.intValue();	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r3 = 888; // 0x378 float:1.244E-42 double:4.387E-321;
        if (r2 != r3) goto L_0x035e;
    L_0x02d7:
        r2 = 240; // 0xf0 float:3.36E-43 double:1.186E-321;
        r3 = r2;
    L_0x02da:
        r2 = new com.nxp.taginfolite.b.n;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r4 = "\nSRAM buffer:";
        r4 = com.nxp.taginfolite.p003g.C0429j.m1391a(r4);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2.<init>(r4);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r16;
        r0.m147a(r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2 = 0;
    L_0x02eb:
        r4 = 16;
        if (r2 >= r4) goto L_0x0389;
    L_0x02ef:
        r4 = r3 + r2;
        r4 = r4 % 256;
        r4 = r15.readPages(r4);	 Catch:{ IOException -> 0x0363, TagLostException -> 0x01cd, IndexOutOfBoundsException -> 0x038c }
        r5 = r4.length;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r6 = 16;
        if (r5 < r6) goto L_0x0353;
    L_0x02fc:
        r5 = new com.nxp.taginfolite.b.p;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r6 = 3;
        r7 = "w";
        r9 = 0;
        r10 = 4;
        r9 = java.util.Arrays.copyOfRange(r4, r9, r10);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r5.<init>(r3, r6, r7, r9);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r16;
        r0.m147a(r5);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r5 = new com.nxp.taginfolite.b.p;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r6 = r3 + 1;
        r7 = 3;
        r9 = "w";
        r10 = 4;
        r12 = 8;
        r10 = java.util.Arrays.copyOfRange(r4, r10, r12);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r5.<init>(r6, r7, r9, r10);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r16;
        r0.m147a(r5);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r5 = new com.nxp.taginfolite.b.p;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r6 = r3 + 2;
        r7 = 3;
        r9 = "w";
        r10 = 8;
        r12 = 12;
        r10 = java.util.Arrays.copyOfRange(r4, r10, r12);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r5.<init>(r6, r7, r9, r10);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r16;
        r0.m147a(r5);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r5 = new com.nxp.taginfolite.b.p;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r6 = r3 + 3;
        r7 = 3;
        r9 = "w";
        r10 = 12;
        r12 = 16;
        r4 = java.util.Arrays.copyOfRange(r4, r10, r12);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r5.<init>(r6, r7, r9, r4);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r16;
        r0.m147a(r5);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
    L_0x0353:
        r2 = r2 + 4;
        goto L_0x02eb;
    L_0x0356:
        r3 = 488; // 0x1e8 float:6.84E-43 double:2.41E-321;
        goto L_0x027e;
    L_0x035a:
        r5 = "w";
        goto L_0x0297;
    L_0x035e:
        r2 = 496; // 0x1f0 float:6.95E-43 double:2.45E-321;
        r3 = r2;
        goto L_0x02da;
    L_0x0363:
        r2 = move-exception;
        r2 = "TagInfo_NTI2C";
        r4 = "page: 0x%02X";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r6 = 0;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r5[r6] = r3;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r3 = java.lang.String.format(r4, r5);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        android.util.Log.v(r2, r3);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2 = new com.nxp.taginfolite.b.n;	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r3 = "[Not available]";
        r3 = com.nxp.taginfolite.p003g.C0429j.m1391a(r3);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r2.<init>(r3);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
        r0 = r16;
        r0.m147a(r2);	 Catch:{ TagLostException -> 0x01cd, IOException -> 0x0268, IndexOutOfBoundsException -> 0x038c }
    L_0x0389:
        r9 = r11;
        goto L_0x01d6;
    L_0x038c:
        r2 = move-exception;
        r2 = "\n<aborted: cannot read any further>";
        r9 = r2;
        goto L_0x01d6;
    L_0x0392:
        r13 = r2;
        goto L_0x0187;
    L_0x0395:
        r10 = r3;
        goto L_0x0052;
    L_0x0398:
        r9 = r2;
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.e.e.k.b(com.nxp.taginfolite.e.az):com.nxp.taginfolite.b.c");
    }
}
