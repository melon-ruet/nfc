package com.nxp.taginfolite.p004f;

import android.os.Build.VERSION;
import android.support.v4.BuildConfig;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import com.actionbarsherlock.view.Menu;
import com.nxp.taginfolite.p003g.C0428i;

/* renamed from: com.nxp.taginfolite.f.k */
public final class C0358k {
    public static final String[] f1074a;
    public static final String[] f1075b;
    public static final String f1076c;
    public static final String f1077d;
    public static final String[][] f1078e;
    private static SparseArray f1079f;

    static {
        f1074a = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        f1075b = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
        if (VERSION.SDK_INT < 14) {
            f1076c = "\u25b6 ";
        } else {
            f1076c = "\u25ba ";
        }
        f1077d = f1076c;
        String[][] strArr = new String[9][];
        strArr[0] = new String[]{"\u25a0 ", "# "};
        strArr[1] = new String[]{f1076c, "* "};
        strArr[2] = new String[]{"\t\u2022 ", "\t- "};
        strArr[3] = new String[]{"  \u2022 ", "  - "};
        strArr[4] = new String[]{"\u200a", " "};
        strArr[5] = new String[]{"\u00b7", "."};
        strArr[6] = new String[]{"\u00b0", BuildConfig.VERSION_NAME};
        strArr[7] = new String[]{"\u00b5", "u"};
        strArr[8] = new String[]{"\u00b2", "2"};
        f1078e = strArr;
        f1079f = new C0359l();
    }

    public static Integer m1068a(byte b, byte b2, byte b3) {
        Integer num = null;
        if ((b & MotionEventCompat.ACTION_MASK) <= 153 && (b2 & MotionEventCompat.ACTION_MASK) <= 153 && (b3 & MotionEventCompat.ACTION_MASK) <= 153 && (b & 15) <= 9 && (b2 & 15) <= 9 && (b3 & 15) <= 9) {
            try {
                num = Integer.valueOf(Integer.parseInt(String.format("%02X%02X%02X", new Object[]{Byte.valueOf(b), Byte.valueOf(b2), Byte.valueOf(b3)}), 10));
            } catch (NumberFormatException e) {
            }
        }
        return num;
    }

    public static String m1069a(String str) {
        for (CharSequence[] charSequenceArr : f1078e) {
            str = str.replace(charSequenceArr[0], charSequenceArr[1]);
        }
        return str;
    }

    public static String m1070a(byte[] bArr) {
        if (bArr == null || bArr.length != 12) {
            return null;
        }
        C0428i c0428i = new C0428i();
        c0428i.m1384a((CharSequence) "Electronic Product Code (GS1 EPC):");
        c0428i.m1387b(f1076c);
        c0428i.m1384a(String.format("URI: urn:epc:raw:96.x%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X", new Object[]{Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]), Byte.valueOf(bArr[4]), Byte.valueOf(bArr[5]), Byte.valueOf(bArr[6]), Byte.valueOf(bArr[7]), Byte.valueOf(bArr[8]), Byte.valueOf(bArr[9]), Byte.valueOf(bArr[10]), Byte.valueOf(bArr[11])}));
        CharSequence b = C0358k.m1072b(bArr);
        if (!TextUtils.isEmpty(b)) {
            c0428i.m1387b("\t\u2022 ");
            c0428i.m1384a(b);
        }
        return c0428i.toString();
    }

    public static boolean m1071a(byte[] bArr, C0360m c0360m) {
        return (bArr == null || bArr.length != 4) ? false : (c0360m == C0360m.ISO14443_A && (bArr[0] & MotionEventCompat.ACTION_MASK) == 8) || (c0360m == C0360m.DESFIRE && bArr[0] == -128);
    }

    public static String m1072b(byte[] bArr) {
        return (String) f1079f.get(bArr[0] & MotionEventCompat.ACTION_MASK);
    }

    public static short m1073c(byte[] bArr) {
        int i = 25443;
        int length = bArr.length - 2;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = ((bArr[i2] & MotionEventCompat.ACTION_MASK) ^ (i & MotionEventCompat.ACTION_MASK)) & Menu.USER_MASK;
            i3 = (i3 ^ ((i3 << 4) & MotionEventCompat.ACTION_MASK)) & Menu.USER_MASK;
            i = ((((i >>> 8) ^ (i3 << 8)) ^ (i3 << 3)) ^ (i3 >>> 4)) & Menu.USER_MASK;
        }
        bArr[length] = (byte) (i & MotionEventCompat.ACTION_MASK);
        bArr[length + 1] = (byte) ((i >>> 8) & MotionEventCompat.ACTION_MASK);
        return (short) (i & Menu.USER_MASK);
    }
}
