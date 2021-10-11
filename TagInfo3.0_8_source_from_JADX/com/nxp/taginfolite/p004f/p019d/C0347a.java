package com.nxp.taginfolite.p004f.p019d;

import android.annotation.SuppressLint;
import android.support.v4.BuildConfig;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import com.nxp.taginfolite.database.p008b.C0229k;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p005b.C0190k;
import com.nxp.taginfolite.p006c.C0197a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.jraf.android.backport.switchwidget.C0519c;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.nxp.taginfolite.f.d.a */
public final class C0347a {
    private static final SparseArray f1052a;

    static {
        f1052a = new C0348b();
    }

    public static String m1014a(int i, String str, String str2) {
        String[] c = C0347a.m1020c(i);
        if (c == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        stringBuilder.append(str);
        stringBuilder.append(C0429j.m1391a(c[0]));
        stringBuilder.append("<hexoutput>");
        stringBuilder.append(String.format(" (0x%04X)", new Object[]{Integer.valueOf(i)}));
        stringBuilder.append("</hexoutput>");
        if (c[1] != null) {
            stringBuilder.append("\n");
            stringBuilder.append(str2);
            stringBuilder.append(C0429j.m1391a(c[1]));
        }
        return stringBuilder.toString();
    }

    public static String m1015a(boolean z, C0350d c0350d, boolean z2) {
        if (!z || c0350d == null) {
            return null;
        }
        C0428i c0428i = new C0428i();
        if (c0350d.m1030d()) {
            c0428i.m1384a((CharSequence) "Multi-application card");
        }
        if (c0350d.m1031e() != -1) {
            c0428i.m1384a(String.format("Card publisher sector: %d", new Object[]{Integer.valueOf(c0350d.m1031e())}));
        } else {
            c0428i.m1387b("<hexoutput>Card publisher sector not present\n</hexoutput>");
        }
        HashSet hashSet = new HashSet();
        Iterator it = c0350d.iterator();
        while (it.hasNext()) {
            C0349c c0349c = (C0349c) it.next();
            int a = !z2 ? c0349c.m1021a() : c0349c.m1024d();
            if (!hashSet.contains(Integer.valueOf(a))) {
                CharSequence b = C0347a.m1019b(a);
                if (b != null) {
                    c0428i.m1384a(b);
                } else if (a > 0) {
                    c0428i.m1384a(String.format(C0358k.f1076c + "Unknown application 0x%04X", new Object[]{Integer.valueOf(a)}));
                }
                hashSet.add(Integer.valueOf(a));
            }
        }
        return c0428i.toString();
    }

    public static void m1016a(C0197a c0197a, C0350d c0350d, boolean z, boolean z2, boolean z3) {
        C0428i c0428i = new C0428i();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (c0350d != null) {
            CharSequence charSequence;
            int[] a;
            int[] b;
            int i;
            Iterator it;
            C0349c c0349c;
            int e;
            byte c;
            byte b2;
            String[] a2;
            CharSequence charSequence2;
            String str = z3 ? "MIFARE Application Directory" : "Application Directory";
            int c2 = c0350d.m1029c();
            if (z3) {
                if (c2 <= 0 || c2 >= 3) {
                    c0428i.m1384a(String.format("Error in version: %d", new Object[]{Integer.valueOf(c2)}));
                } else {
                    charSequence = str + String.format(" (MADv%d)", new Object[]{Integer.valueOf(c2)});
                    if (z) {
                        c0428i.m1384a((CharSequence) "Showing reversed entry values");
                    }
                    a = c0350d.m1027a();
                    b = c0350d.m1028b();
                    if (a != null && a.length > 0) {
                        for (i = 0; i < a.length; i++) {
                            if (i != 0) {
                                c0428i.m1387b("CRC sector 0: ");
                            } else {
                                c0428i.m1383a();
                                c0428i.m1387b("CRC sector 16: ");
                            }
                            if (a[i] != b[i]) {
                                c0428i.m1387b("OK");
                                c0428i.m1387b(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(a[i])}));
                            } else {
                                c0428i.m1387b("ERROR");
                                c0428i.m1387b(String.format("<hexoutput> (0x%02X, should be 0x%02X)</hexoutput>", new Object[]{Integer.valueOf(a[i]), Integer.valueOf(b[i])}));
                            }
                        }
                        c0428i.m1383a();
                    }
                    if (z2) {
                        c0428i.m1384a((CharSequence) "Error: reversed directory key");
                    }
                    c0428i.m1384a((CharSequence) "Application classes:");
                    arrayList.add("  DIR   ");
                    arrayList2.add("  ----  ");
                    it = c0350d.iterator();
                    while (it.hasNext()) {
                        c0349c = (C0349c) it.next();
                        e = c0349c.m1025e();
                        if (z) {
                            c = c0349c.m1023c();
                            b2 = c0349c.m1022b();
                        } else {
                            c = c0349c.m1022b();
                            b2 = c0349c.m1023c();
                        }
                        if (e == 17) {
                            arrayList.add("  DIR   ");
                            arrayList2.add("  ----  ");
                        }
                        arrayList2.add(String.format("  %02X%02X  ", new Object[]{Byte.valueOf(b2), Byte.valueOf(c)}));
                        switch (b2) {
                            case (byte) -31:
                                if (c == 3) {
                                    if (c != 2) {
                                        arrayList.add("  NFC   ");
                                        break;
                                    } else {
                                        arrayList.add("  NTIP  ");
                                        break;
                                    }
                                }
                                arrayList.add("  NDEF  ");
                                break;
                            case C0519c.Switch_thumb /*0*/:
                                switch (c) {
                                    case C0519c.Switch_thumb /*0*/:
                                        arrayList.add("[empty] ");
                                        break;
                                    case C0519c.Switch_track /*1*/:
                                        arrayList.add("[defect]");
                                        break;
                                    case C0519c.Switch_textOn /*2*/:
                                        arrayList.add("reserved");
                                        break;
                                    case C0519c.Switch_textOff /*3*/:
                                        arrayList.add("dir.info");
                                        break;
                                    case C0519c.Switch_thumbTextPadding /*4*/:
                                        arrayList.add(" holder ");
                                        break;
                                    case C0519c.Switch_switchTextAppearance /*5*/:
                                        arrayList.add("[absent]");
                                        break;
                                    default:
                                        arrayList.add("  card  ");
                                        break;
                                }
                            default:
                                a2 = C0347a.m1017a(b2);
                                if (a2 == null) {
                                    arrayList.add("unknown ");
                                    break;
                                } else {
                                    arrayList.add(a2[0]);
                                    break;
                                }
                        }
                    }
                    charSequence2 = null;
                    if (c2 == 2 && c0350d.m1032f() < 38) {
                        charSequence2 = "(Data incomplete)";
                    }
                    c0197a.m194a(charSequence, new C0190k(arrayList, c0428i.m1386b(), charSequence2));
                    c0197a.m192a(new C0190k(arrayList2));
                }
            }
            Object obj = str;
            if (z) {
                c0428i.m1384a((CharSequence) "Showing reversed entry values");
            }
            a = c0350d.m1027a();
            b = c0350d.m1028b();
            for (i = 0; i < a.length; i++) {
                if (i != 0) {
                    c0428i.m1383a();
                    c0428i.m1387b("CRC sector 16: ");
                } else {
                    c0428i.m1387b("CRC sector 0: ");
                }
                if (a[i] != b[i]) {
                    c0428i.m1387b("ERROR");
                    c0428i.m1387b(String.format("<hexoutput> (0x%02X, should be 0x%02X)</hexoutput>", new Object[]{Integer.valueOf(a[i]), Integer.valueOf(b[i])}));
                } else {
                    c0428i.m1387b("OK");
                    c0428i.m1387b(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(a[i])}));
                }
            }
            c0428i.m1383a();
            if (z2) {
                c0428i.m1384a((CharSequence) "Error: reversed directory key");
            }
            c0428i.m1384a((CharSequence) "Application classes:");
            arrayList.add("  DIR   ");
            arrayList2.add("  ----  ");
            it = c0350d.iterator();
            while (it.hasNext()) {
                c0349c = (C0349c) it.next();
                e = c0349c.m1025e();
                if (z) {
                    c = c0349c.m1023c();
                    b2 = c0349c.m1022b();
                } else {
                    c = c0349c.m1022b();
                    b2 = c0349c.m1023c();
                }
                if (e == 17) {
                    arrayList.add("  DIR   ");
                    arrayList2.add("  ----  ");
                }
                arrayList2.add(String.format("  %02X%02X  ", new Object[]{Byte.valueOf(b2), Byte.valueOf(c)}));
                switch (b2) {
                    case (byte) -31:
                        if (c == 3) {
                            if (c != 2) {
                                arrayList.add("  NTIP  ");
                                break;
                            } else {
                                arrayList.add("  NFC   ");
                                break;
                            }
                        }
                        arrayList.add("  NDEF  ");
                        break;
                    case C0519c.Switch_thumb /*0*/:
                        switch (c) {
                            case C0519c.Switch_thumb /*0*/:
                                arrayList.add("[empty] ");
                                break;
                            case C0519c.Switch_track /*1*/:
                                arrayList.add("[defect]");
                                break;
                            case C0519c.Switch_textOn /*2*/:
                                arrayList.add("reserved");
                                break;
                            case C0519c.Switch_textOff /*3*/:
                                arrayList.add("dir.info");
                                break;
                            case C0519c.Switch_thumbTextPadding /*4*/:
                                arrayList.add(" holder ");
                                break;
                            case C0519c.Switch_switchTextAppearance /*5*/:
                                arrayList.add("[absent]");
                                break;
                            default:
                                arrayList.add("  card  ");
                                break;
                        }
                    default:
                        a2 = C0347a.m1017a(b2);
                        if (a2 == null) {
                            arrayList.add(a2[0]);
                            break;
                        } else {
                            arrayList.add("unknown ");
                            break;
                        }
                }
            }
            charSequence2 = null;
            charSequence2 = "(Data incomplete)";
            c0197a.m194a(charSequence, new C0190k(arrayList, c0428i.m1386b(), charSequence2));
            c0197a.m192a(new C0190k(arrayList2));
        }
    }

    public static String[] m1017a(byte b) {
        return (String[]) f1052a.get(b & MotionEventCompat.ACTION_MASK);
    }

    public static String[] m1018a(int i) {
        return (String[]) f1052a.get((i >>> 8) & MotionEventCompat.ACTION_MASK);
    }

    public static String m1019b(int i) {
        return C0347a.m1014a(i, C0358k.f1076c, "\t\u2022 ");
    }

    public static String[] m1020c(int i) {
        if (i == 0) {
            return null;
        }
        String[] a = C0229k.m335a(i);
        if (a == null) {
            a = new String[]{BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME};
        }
        String[] strArr = new String[2];
        if (TextUtils.isEmpty(a[0])) {
            String[] a2 = C0347a.m1018a(i);
            if (a2 == null || a2[1] == null) {
                return null;
            }
            strArr[0] = a2[1];
        } else {
            strArr[0] = a[0];
        }
        if (!TextUtils.isEmpty(a[3])) {
            strArr[1] = a[3];
        } else if (!TextUtils.isEmpty(a[1])) {
            strArr[1] = a[1];
        } else if (!TextUtils.isEmpty(a[2])) {
            strArr[1] = a[2];
        }
        return strArr;
    }
}
