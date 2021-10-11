package com.nxp.taginfolite.ndef.p023a;

import android.support.v4.BuildConfig;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MotionEventCompat;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0358k;
import java.util.Arrays;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.ndef.a.q */
public final class C0446q {
    private static final byte[] f1372a;

    static {
        f1372a = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1};
    }

    private static void m1444a(byte[] bArr, int i, int i2, String str, StringBuilder stringBuilder) {
        int length = bArr.length;
        if (i + i2 > length) {
            bArr[i2] = bArr[length];
        }
        stringBuilder.append(str).append("credential:\n");
        int a = C0429j.m1388a(bArr[i + 2], bArr[i + 3]);
        int i3 = i;
        while ((i3 + a) + 4 <= i + i2) {
            int a2;
            if (i3 != i) {
                stringBuilder.append("\n");
            }
            switch (C0429j.m1388a(bArr[i3], bArr[i3 + 1])) {
                case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /*4097*/:
                    a2 = C0429j.m1388a(bArr[i3 + 4], bArr[i3 + 5]);
                    stringBuilder.append(str).append(String.format(C0358k.f1076c + "AP channel: %d", new Object[]{Integer.valueOf(a2)}));
                    break;
                case FragmentTransaction.TRANSIT_FRAGMENT_FADE /*4099*/:
                    stringBuilder.append(str).append(C0358k.f1076c).append("authentication type: ");
                    switch (C0429j.m1388a(bArr[i3 + 4], bArr[i3 + 5])) {
                        case C0519c.Switch_track /*1*/:
                            stringBuilder.append("Open");
                            break;
                        case C0519c.Switch_textOn /*2*/:
                            stringBuilder.append("WPAPSK");
                            break;
                        case C0519c.Switch_thumbTextPadding /*4*/:
                            stringBuilder.append("Shared");
                            break;
                        case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                            stringBuilder.append("WPA");
                            break;
                        case Menu.CATEGORY_SHIFT /*16*/:
                            stringBuilder.append("WPA2");
                            break;
                        case C0086R.styleable.SherlockTheme_searchViewCloseIcon /*32*/:
                            stringBuilder.append("WPA2PSK");
                            break;
                        default:
                            stringBuilder.append(String.format("[unknown] (0x%02X)", new Object[]{Integer.valueOf(C0429j.m1388a(bArr[i3 + 4], bArr[i3 + 5]))}));
                            break;
                    }
                case 4111:
                    stringBuilder.append(str).append(C0358k.f1076c).append("encryption type: ");
                    switch (C0429j.m1388a(bArr[i3 + 4], bArr[i3 + 5])) {
                        case C0519c.Switch_track /*1*/:
                            stringBuilder.append("None");
                            break;
                        case C0519c.Switch_textOn /*2*/:
                            stringBuilder.append("WEP");
                            break;
                        case C0519c.Switch_thumbTextPadding /*4*/:
                            stringBuilder.append("TKIP");
                            break;
                        case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                            stringBuilder.append("AES");
                            break;
                        default:
                            stringBuilder.append(String.format("[unknown] (0x%02X)", new Object[]{Integer.valueOf(C0429j.m1388a(bArr[i3 + 4], bArr[i3 + 5]))}));
                            break;
                    }
                case 4128:
                    byte[] bArr2 = new byte[a];
                    for (a2 = 0; a2 < a; a2++) {
                        bArr2[a2] = bArr[(i3 + a2) + 4];
                    }
                    if (!Arrays.equals(bArr2, f1372a)) {
                        stringBuilder.append(C0431b.m1415a(bArr2, str, 1));
                        break;
                    }
                    stringBuilder.append(str).append(C0358k.f1076c).append("MAC address: ").append(C0429j.m1393a(bArr2, BuildConfig.VERSION_NAME, ":"));
                    stringBuilder.append("\n");
                    stringBuilder.append(str).append("\t\u2022 Non-specific MAC address");
                    break;
                case 4134:
                    stringBuilder.append(str).append(String.format(C0358k.f1076c + "network index: %d", new Object[]{Integer.valueOf(bArr[i3 + 4] & MotionEventCompat.ACTION_MASK)}));
                    break;
                case 4135:
                    stringBuilder.append(str).append(C0358k.f1076c).append("network key:");
                    if (!C0429j.m1396a(bArr, i3 + 4, a)) {
                        stringBuilder.append("\n").append(str).append("\t\u2022 0x");
                        for (a2 = 0; a2 < a; a2++) {
                            stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[(i3 + a2) + 4])}));
                        }
                        break;
                    }
                    stringBuilder.append(" \"").append(C0429j.m1391a(new String(bArr, i3 + 4, a, C0429j.f1360a))).append(" \"");
                    break;
                case 4136:
                    stringBuilder.append(str).append(String.format(C0358k.f1076c + "network key index (reserved): %d", new Object[]{Integer.valueOf(bArr[i3 + 4] & MotionEventCompat.ACTION_MASK)}));
                    break;
                case 4165:
                    stringBuilder.append(str).append(C0358k.f1076c).append("SSID:");
                    if (C0429j.m1396a(bArr, i3 + 4, a)) {
                        StringBuilder stringBuilder2 = new StringBuilder(BuildConfig.VERSION_NAME);
                        a2 = 0;
                        while (a2 < a && (i3 + a2) + 4 < i2) {
                            stringBuilder2.append(new String(bArr, (i3 + a2) + 4, 1, C0429j.f1360a));
                            a2++;
                        }
                        stringBuilder.append(" \"").append(C0429j.m1391a(stringBuilder2.toString())).append("\"");
                        break;
                    }
                    stringBuilder.append("\n").append(str).append("\t\u2022 0x");
                    a2 = 0;
                    while (a2 < a && (i3 + a2) + 4 < i2) {
                        stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[(i3 + a2) + 4])}));
                        a2++;
                    }
                    break;
                case 4169:
                    C0446q.m1446b(bArr, i3 + 4, a, str, stringBuilder);
                    break;
                default:
                    stringBuilder.append(str).append(String.format(C0358k.f1076c + "unknown attribute: 0x%04X (%d bytes)\n", new Object[]{Integer.valueOf(a2), Integer.valueOf(a)}));
                    stringBuilder.append(str).append("\t\u2022 0x");
                    for (a2 = 0; a2 < a; a2++) {
                        stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[(i3 + a2) + 4])}));
                    }
                    break;
            }
            a2 = (a + 4) + i3;
            if (a2 + 3 < length) {
                a = C0429j.m1388a(bArr[a2 + 2], bArr[a2 + 3]);
            } else {
                length = 0;
            }
            i3 = a2;
        }
    }

    public static void m1445a(byte[] bArr, String str, StringBuilder stringBuilder) {
        int length = bArr.length;
        int i = 0;
        while (i + 4 < length) {
            if (i != 0) {
                stringBuilder.append("\n");
            }
            int a = C0429j.m1388a(bArr[i], bArr[i + 1]);
            int a2 = C0429j.m1388a(bArr[i + 2], bArr[i + 3]);
            switch (a) {
                case 4110:
                    C0446q.m1444a(bArr, i + 4, a2, str, stringBuilder);
                    break;
                case 4140:
                    stringBuilder.append("OOB device password:\n").append(str).append("\t\u2022 public key hash data: 0x");
                    a = 0;
                    while (a < 20 && (i + a) + 4 < length) {
                        stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[(i + a) + 4])}));
                        a++;
                    }
                    stringBuilder.append("\n").append(str).append(String.format("\t\u2022 password ID: 0x%02X%02X\n", new Object[]{Byte.valueOf(bArr[i + 24]), Byte.valueOf(bArr[i + 25])}));
                    stringBuilder.append(str).append("\t\u2022 device password: 0x");
                    a = 26;
                    while (a < a2 && (i + a) + 4 < length) {
                        stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[(i + a) + 4])}));
                        a++;
                    }
                    break;
                case 4169:
                    C0446q.m1446b(bArr, i + 4, a2, str, stringBuilder);
                    break;
                case 4170:
                    a = (bArr[i + 4] >> 4) & 15;
                    int i2 = bArr[i + 4] & 15;
                    stringBuilder.append(String.format("version: %d.%d", new Object[]{Integer.valueOf(a), Integer.valueOf(i2)}));
                    break;
                default:
                    stringBuilder.append(String.format("unknown attribute: 0x%04X (%d bytes)\n", new Object[]{Integer.valueOf(a), Integer.valueOf(a2)}));
                    stringBuilder.append(str).append("\t\u2022 0x");
                    a = 0;
                    while (a < a2 && (i + a) + 4 < length) {
                        stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[(i + a) + 4])}));
                        a++;
                    }
                    break;
            }
            i = (a2 + 4) + i;
        }
    }

    private static void m1446b(byte[] bArr, int i, int i2, String str, StringBuilder stringBuilder) {
        int length = bArr.length;
        if (i + i2 > length) {
            bArr[i2] = bArr[length];
        }
        stringBuilder.append(str).append(C0358k.f1076c).append("vendor extension: ");
        if (C0429j.m1389a(bArr[i], bArr[i + 1], bArr[i + 2]) == 14122) {
            stringBuilder.append("Wi-Fi Alliance");
            int i3 = i + 3;
            int i4 = bArr[i3 + 1] & MotionEventCompat.ACTION_MASK;
            int i5 = i3;
            while (i5 + i4 <= i + i2) {
                stringBuilder.append("\n");
                switch (bArr[i5] & MotionEventCompat.ACTION_MASK) {
                    case C0519c.Switch_thumb /*0*/:
                        i3 = (bArr[i5 + 2] >> 4) & 15;
                        int i6 = bArr[i5 + 2] & 15;
                        stringBuilder.append(str).append(String.format("\t\u2022 version2: %d.%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i6)}));
                        break;
                    case C0519c.Switch_textOn /*2*/:
                        StringBuilder append = stringBuilder.append(str);
                        String str2 = "\t\u2022 network key shareable: %s";
                        Object[] objArr = new Object[1];
                        objArr[0] = bArr[i5 + 2] == null ? "false" : "true";
                        append.append(String.format(str2, objArr));
                        break;
                    default:
                        stringBuilder.append(str).append(String.format("\t\u2022 unknown attribute: 0x%02X (%d bytes)\n", new Object[]{Integer.valueOf(bArr[i5] & MotionEventCompat.ACTION_MASK), Integer.valueOf(i4)}));
                        stringBuilder.append(str).append("\t\t~ 0x");
                        for (i3 = 0; i3 < i4; i3++) {
                            stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[(i5 + i3) + 2])}));
                        }
                        break;
                }
                i5 += i4 + 2;
                if (i5 + 1 < length) {
                    i3 = bArr[i5 + 1] & 15;
                    i4 = length;
                } else {
                    i3 = i4;
                    i4 = 0;
                }
                length = i4;
                i4 = i3;
            }
            return;
        }
        stringBuilder.append("unknown vendor");
    }
}
