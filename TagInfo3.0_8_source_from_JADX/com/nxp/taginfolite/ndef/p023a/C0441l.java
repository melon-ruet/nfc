package com.nxp.taginfolite.ndef.p023a;

import android.support.v4.BuildConfig;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.nxp.taginfolite.p003g.C0429j;
import java.util.Arrays;
import java.util.Locale;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.ndef.a.l */
public final class C0441l {
    public static void m1436a(byte[] bArr, String str, StringBuilder stringBuilder) {
        stringBuilder.append(str).append("configuration type: ");
        switch (bArr[0] & MotionEventCompat.ACTION_MASK) {
            case C0519c.Switch_thumb /*0*/:
                stringBuilder.append("discovery only");
                break;
            case C0519c.Switch_track /*1*/:
                stringBuilder.append("PIN");
                break;
            case C0519c.Switch_textOn /*2*/:
                stringBuilder.append("public key");
                break;
            default:
                stringBuilder.append("[unknown]");
                break;
        }
        stringBuilder.append(String.format("<hexoutput> (0x%02X)</hexoutput>\n", new Object[]{Byte.valueOf(bArr[0])}));
        stringBuilder.append(C0431b.m1415a(Arrays.copyOfRange(bArr, 1, 7), str, 0)).append("\n");
        C0431b.m1416a(str, bArr[7], bArr[8], bArr[9], stringBuilder);
        stringBuilder.append("\n").append(str).append("authentication info: \"");
        StringBuilder stringBuilder2 = new StringBuilder(BuildConfig.VERSION_NAME);
        for (int i = 0; i < 16; i++) {
            byte b = bArr[i + 10];
            if ((b & MotionEventCompat.ACTION_MASK) > 0) {
                if (C0429j.m1395a(b)) {
                    stringBuilder2.append(String.format("%c", new Object[]{Character.valueOf((char) b)}));
                } else {
                    stringBuilder2.append("\u00b7");
                }
            }
        }
        stringBuilder.append(C0429j.m1391a(stringBuilder2.toString())).append("\"\n");
        stringBuilder.append(str).append("short name: \"");
        stringBuilder.append(C0429j.m1391a(new String(bArr, 27, bArr[26] & MotionEventCompat.ACTION_MASK, C0429j.f1360a)));
        stringBuilder.append("\"");
    }

    public static void m1437b(byte[] bArr, String str, StringBuilder stringBuilder) {
        char c = ',';
        if ((bArr[0] & MotionEventCompat.ACTION_MASK) == MotionEventCompat.ACTION_MASK || (bArr[1] & MotionEventCompat.ACTION_MASK) == MotionEventCompat.ACTION_MASK) {
            stringBuilder.append(str).append("time: [none]\n");
        } else {
            stringBuilder.append(str).append(String.format("time: %d:%02dh\n", new Object[]{Integer.valueOf(bArr[0] & MotionEventCompat.ACTION_MASK), Integer.valueOf(bArr[1] & MotionEventCompat.ACTION_MASK)}));
        }
        byte b = bArr[2];
        if (b != null) {
            String str2;
            Object[] objArr;
            stringBuilder.append(str).append("repeat: ");
            if ((b & 1) != 0) {
                str2 = " Mon%c";
                objArr = new Object[1];
                objArr[0] = Character.valueOf((b & TransportMediator.KEYCODE_MEDIA_PLAY) != 0 ? ',' : ' ');
                stringBuilder.append(String.format(str2, objArr));
            }
            if ((b & 2) != 0) {
                str2 = " Tue%c";
                objArr = new Object[1];
                objArr[0] = Character.valueOf((b & 124) != 0 ? ',' : ' ');
                stringBuilder.append(String.format(str2, objArr));
            }
            if ((b & 4) != 0) {
                str2 = " Wed%c";
                objArr = new Object[1];
                objArr[0] = Character.valueOf((b & 120) != 0 ? ',' : ' ');
                stringBuilder.append(String.format(str2, objArr));
            }
            if ((b & 8) != 0) {
                str2 = " Thu%c";
                objArr = new Object[1];
                objArr[0] = Character.valueOf((b & 112) != 0 ? ',' : ' ');
                stringBuilder.append(String.format(str2, objArr));
            }
            if ((b & 16) != 0) {
                str2 = " Fri%c";
                objArr = new Object[1];
                objArr[0] = Character.valueOf((b & 96) != 0 ? ',' : ' ');
                stringBuilder.append(String.format(str2, objArr));
            }
            if ((b & 32) != 0) {
                String str3 = " Sat%c";
                Object[] objArr2 = new Object[1];
                if ((b & 64) == 0) {
                    c = ' ';
                }
                objArr2[0] = Character.valueOf(c);
                stringBuilder.append(String.format(str3, objArr2));
            }
            if ((b & 64) != 0) {
                stringBuilder.append(String.format(" Sun", new Object[0]));
            }
            stringBuilder.append("\n");
        } else {
            stringBuilder.append(str).append("repeat: none\n");
        }
        stringBuilder.append(str).append(String.format("snooze: %d min\n", new Object[]{Byte.valueOf(bArr[3])}));
        stringBuilder.append(str).append("message: \"").append(C0429j.m1391a(new String(bArr, 5, bArr[4] & MotionEventCompat.ACTION_MASK, C0429j.f1360a))).append("\"");
    }

    public static void m1438c(byte[] bArr, String str, StringBuilder stringBuilder) {
        stringBuilder.append(str).append("profile: ");
        switch (bArr[0] & MotionEventCompat.ACTION_MASK) {
            case C0519c.Switch_thumb /*0*/:
                stringBuilder.append("General (0)");
            case C0519c.Switch_track /*1*/:
                stringBuilder.append("Silent (1)");
            case C0519c.Switch_textOn /*2*/:
                stringBuilder.append("Flight (2)");
            case C0519c.Switch_textOff /*3*/:
                stringBuilder.append("Meeting (3)");
            case C0519c.Switch_thumbTextPadding /*4*/:
                stringBuilder.append("Outdoor (4)");
            default:
                stringBuilder.append("\"").append(C0429j.m1391a(new String(bArr, 2, bArr.length - 2, C0429j.f1360a))).append("\" (User defined)");
        }
    }

    public static void m1439d(byte[] bArr, String str, StringBuilder stringBuilder) {
        stringBuilder.append(str).append(String.format(Locale.US, "frequency: %.1f MHz\n", new Object[]{Double.valueOf(((((double) (bArr[0] & 63)) * 256.0d) + ((double) (bArr[1] & MotionEventCompat.ACTION_MASK))) / 100.0d)}));
        stringBuilder.append(str).append("station: ").append(C0429j.m1391a(new String(bArr, 3, bArr[2] & MotionEventCompat.ACTION_MASK, C0429j.f1360a))).append("\n");
        stringBuilder.append(str).append("service ID: ").append(C0429j.m1391a(new String(bArr, ((bArr[2] & MotionEventCompat.ACTION_MASK) + 3) + 1, bArr[(bArr[2] & MotionEventCompat.ACTION_MASK) + 3], C0429j.f1360a)));
    }
}
