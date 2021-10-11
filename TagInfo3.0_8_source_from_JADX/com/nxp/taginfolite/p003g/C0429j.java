package com.nxp.taginfolite.p003g;

import android.support.v4.BuildConfig;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.nxp.taginfolite.g.j */
public final class C0429j {
    public static final Charset f1360a;
    public static final Charset f1361b;
    public static final Charset f1362c;

    static {
        f1360a = Charset.forName("US-ASCII");
        f1361b = Charset.forName("UTF-8");
        f1362c = Charset.forName("UTF-16BE");
    }

    public static int m1388a(byte b, byte b2) {
        return C0429j.m1413i(b, b2);
    }

    public static int m1389a(byte b, byte b2, byte b3) {
        return C0429j.m1413i(b, b2, b3);
    }

    public static long m1390a(byte... bArr) {
        if (bArr == null || bArr.length == 0 || bArr.length > 7) {
            throw new IllegalArgumentException("You can't convert no bytes or more than 7 bytes to an unsigned long!");
        }
        long j = 0;
        for (byte b : bArr) {
            j = (j << 8) | ((long) (b & MotionEventCompat.ACTION_MASK));
        }
        return j;
    }

    public static String m1391a(CharSequence charSequence) {
        int i = 0;
        if (charSequence == null) {
            return BuildConfig.VERSION_NAME;
        }
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence.toString();
        }
        String[] strArr = new String[]{"&", "\"", "'", "<", ">"};
        String[] strArr2 = new String[]{"&amp;", "&quot;", "&apos;", "&lt;", "&gt;"};
        String charSequence2 = charSequence.toString();
        while (i < strArr.length) {
            charSequence2 = charSequence2.replace(strArr[i], strArr2[i]);
            i++;
        }
        return charSequence2;
    }

    public static String m1392a(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.finish();
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static String m1393a(byte[] bArr, String str, String str2) {
        if (bArr == null || bArr.length == 0) {
            return "[none]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        for (int i = 0; i < bArr.length - 1; i++) {
            stringBuilder.append(String.format("%02X%s", new Object[]{Byte.valueOf(bArr[i]), str2}));
        }
        stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[bArr.length - 1])}));
        return stringBuilder.toString();
    }

    public static String m1394a(byte[] bArr, String str, String str2, int i, int i2) {
        int i3 = 0;
        if (bArr == null) {
            return null;
        }
        if (bArr.length >= i + i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return C0429j.m1393a(bArr2, str, str2);
        }
        bArr2 = new byte[(bArr.length - i)];
        System.arraycopy(bArr, i, bArr2, 0, bArr.length - i);
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        while (i3 < (i2 - bArr.length) + i) {
            stringBuilder.append(str2);
            stringBuilder.append("  ");
            i3++;
        }
        return C0429j.m1393a(bArr2, str, str2) + stringBuilder.toString();
    }

    public static boolean m1395a(byte b) {
        return (b & MotionEventCompat.ACTION_MASK) >= 32 && (b & MotionEventCompat.ACTION_MASK) <= TransportMediator.KEYCODE_MEDIA_PLAY;
    }

    public static boolean m1396a(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        boolean z = true;
        int i3 = i;
        while (i3 < length && i3 < i + i2 && z) {
            z = C0429j.m1395a(bArr[i3]);
            i3++;
        }
        return z && i3 == i + i2;
    }

    public static byte[] m1397a(String str, int i) {
        if (TextUtils.isEmpty(str) || i <= 0) {
            return null;
        }
        Long decode;
        byte[] bArr;
        try {
            decode = str.startsWith("0x") ? Long.decode(str) : Long.valueOf(Long.parseLong(str, 16));
        } catch (NumberFormatException e) {
            decode = null;
        }
        if (decode != null) {
            bArr = new byte[i];
            for (int i2 = i - 1; i2 >= 0; i2--) {
                bArr[i2] = (byte) ((int) ((decode.longValue() >> (((i - i2) - 1) * 8)) & 255));
            }
        } else {
            bArr = null;
        }
        return bArr;
    }

    public static byte[] m1398a(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null) {
            return bArr;
        }
        Object copyOf = Arrays.copyOf(bArr, bArr.length + bArr2.length);
        System.arraycopy(bArr2, 0, copyOf, bArr.length, bArr2.length);
        return copyOf;
    }

    public static byte[] m1399a(byte[] bArr, byte[] bArr2, int i) {
        return C0429j.m1400a(bArr, bArr2, 0, i);
    }

    public static byte[] m1400a(byte[] bArr, byte[] bArr2, int i, int i2) {
        if (bArr2 == null || bArr2.length < i) {
            return bArr;
        }
        int length = bArr2.length < i + i2 ? bArr2.length - i : i2;
        int i3 = length < 0 ? 0 : length;
        if (bArr == null) {
            return Arrays.copyOfRange(bArr2, i, i + i3);
        }
        Object copyOf = Arrays.copyOf(bArr, bArr.length + i3);
        System.arraycopy(bArr2, i, copyOf, bArr.length, i3);
        return copyOf;
    }

    public static String m1401b(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(Base64.decode(str, 0)));
            byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = gZIPInputStream.read(bArr, 0, AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                }
            }
        } catch (IllegalArgumentException e) {
            return str;
        }
    }

    public static String m1402b(byte[] bArr, int i, int i2) {
        return C0429j.m1394a(bArr, "0x", BuildConfig.VERSION_NAME, i, i2);
    }

    private static String m1403b(byte[] bArr, String str, String str2) {
        if (bArr == null || bArr.length == 0) {
            return BuildConfig.VERSION_NAME;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        for (byte b : bArr) {
            if (C0429j.m1395a(b)) {
                stringBuilder.append((char) b);
            } else {
                stringBuilder.append("\u00b7");
            }
        }
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    public static boolean m1404b(byte[] bArr) {
        return C0429j.m1396a(bArr, 0, bArr.length);
    }

    public static String m1405c(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        for (int i = 0; i < bArr.length; i += 8) {
            if (i > 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(String.format("[%02X] ", new Object[]{Integer.valueOf(i)}));
            stringBuilder.append(C0429j.m1407d(bArr, i, 8));
        }
        return stringBuilder.toString();
    }

    public static String m1406c(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (bArr == null) {
            return null;
        }
        if (bArr.length >= i + i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return C0429j.m1409e(bArr2) + C0429j.m1403b(bArr2, " |", "|");
        }
        bArr2 = new byte[(bArr.length - i)];
        System.arraycopy(bArr, i, bArr2, 0, bArr.length - i);
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        StringBuilder stringBuilder2 = new StringBuilder(BuildConfig.VERSION_NAME);
        while (i3 < (i2 - bArr.length) + i) {
            stringBuilder.append("   ");
            stringBuilder2.append(" ");
            i3++;
        }
        return C0429j.m1409e(bArr2) + stringBuilder.toString() + C0429j.m1403b(bArr2, " |", stringBuilder2 + "|");
    }

    public static String m1407d(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        if (i < 0 || i > length) {
            return null;
        }
        if (length >= i + i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return C0429j.m1393a(bArr2, BuildConfig.VERSION_NAME, " ") + C0429j.m1403b(bArr2, " |", "|");
        }
        byte[] bArr3 = new byte[(length - i)];
        System.arraycopy(bArr, i, bArr3, 0, length - i);
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        StringBuilder stringBuilder2 = new StringBuilder(BuildConfig.VERSION_NAME);
        for (int i3 = 0; i3 < (i2 - length) + i; i3++) {
            stringBuilder.append("   ");
            stringBuilder2.append(" ");
        }
        return C0429j.m1393a(bArr3, BuildConfig.VERSION_NAME, " ") + stringBuilder.toString() + C0429j.m1403b(bArr3, " |", stringBuilder2 + "|");
    }

    public static byte[] m1408d(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
            int i3 = 7;
            for (int i4 = i2 >>> 1; i4 != 0; i4 >>>= 1) {
                i2 = (i2 << 1) | (i4 & 1);
                i3--;
            }
            bArr2[i] = (byte) ((i2 << i3) & MotionEventCompat.ACTION_MASK);
        }
        return bArr2;
    }

    public static String m1409e(byte[] bArr) {
        return C0429j.m1393a(bArr, "0x", BuildConfig.VERSION_NAME);
    }

    public static String m1410f(byte[] bArr) {
        return C0429j.m1409e(bArr) + C0429j.m1403b(bArr, " |", "|");
    }

    public static String m1411g(byte[] bArr) {
        return C0429j.m1391a(C0429j.m1410f(bArr));
    }

    public static String m1412h(byte[] bArr) {
        return C0429j.m1393a(bArr, BuildConfig.VERSION_NAME, " ") + C0429j.m1403b(bArr, " |", "|");
    }

    private static int m1413i(byte... bArr) {
        int i = 0;
        if (bArr == null || bArr.length == 0 || bArr.length > 3) {
            throw new IllegalArgumentException("You can't convert no bytes or more than 3 bytes to an unsigned int!");
        }
        int i2 = 0;
        while (i < bArr.length) {
            i2 = (i2 << 8) | (bArr[i] & MotionEventCompat.ACTION_MASK);
            i++;
        }
        return i2;
    }
}
