package com.nxp.taginfolite.ndef.p023a;

import android.support.v4.BuildConfig;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.database.p008b.C0230l;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0358k;
import java.util.UUID;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.ndef.a.b */
public final class C0431b {
    private static final SparseArray f1363a;

    static {
        f1363a = new C0432c();
    }

    public static String m1415a(byte[] bArr, String str, int i) {
        String str2;
        String str3;
        String str4;
        switch (i) {
            case C0519c.Switch_track /*1*/:
                str2 = C0358k.f1076c;
                str3 = "\t\u2022 ";
                str4 = "\t\t~ ";
                break;
            default:
                str2 = BuildConfig.VERSION_NAME;
                str3 = C0358k.f1076c;
                str4 = "\t\u2022 ";
                break;
        }
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        stringBuilder.append(str).append(str2).append("MAC address: ").append(C0429j.m1393a(bArr, BuildConfig.VERSION_NAME, ":")).append("\n");
        Object a = C0429j.m1391a(C0230l.m336a(C0429j.m1389a(bArr[0], bArr[1], bArr[2])));
        if (TextUtils.isEmpty(a)) {
            a = C0429j.m1391a(C0230l.m336a(C0429j.m1389a(bArr[5], bArr[4], bArr[3])));
            if (TextUtils.isEmpty(a)) {
                stringBuilder.append(str).append(str3).append("Unknown manufacturer");
            } else {
                stringBuilder.append(str).append(str3).append("Manufacturer: ").append(a).append("\n");
                stringBuilder.append(str).append(str4).append("Possibly reversed byte order");
            }
        } else {
            stringBuilder.append(str).append(str3).append("Manufacturer: ").append(a);
        }
        return stringBuilder.toString();
    }

    public static void m1416a(String str, byte b, byte b2, byte b3, StringBuilder stringBuilder) {
        stringBuilder.append(str).append(String.format("Device class: %02X:%02X:%02X\n", new Object[]{Byte.valueOf(b), Byte.valueOf(b2), Byte.valueOf(b3)}));
        int i = b3 & 3;
        if (i == 0) {
            stringBuilder.append(str).append(C0358k.f1076c).append("Service class:\n");
            int i2 = ((b & MotionEventCompat.ACTION_MASK) << 3) + ((b2 & 224) >>> 5);
            if ((i2 & 1) != 0) {
                stringBuilder.append("\t\u2022 Limited discoverable mode\n");
            }
            if ((i2 & 8) != 0) {
                stringBuilder.append("\t\u2022 Positioning\n");
            }
            if ((i2 & 16) != 0) {
                stringBuilder.append("\t\u2022 Networking\n");
            }
            if ((i2 & 32) != 0) {
                stringBuilder.append("\t\u2022 Rendering\n");
            }
            if ((i2 & 64) != 0) {
                stringBuilder.append("\t\u2022 Capturing\n");
            }
            if ((i2 & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0) {
                stringBuilder.append("\t\u2022 Object transfer\n");
            }
            if ((i2 & AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) != 0) {
                stringBuilder.append("\t\u2022 Audio\n");
            }
            if ((i2 & AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY) != 0) {
                stringBuilder.append("\t\u2022 Telephony\n");
            }
            if ((i2 & AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT) != 0) {
                stringBuilder.append("\t\u2022 Information\n");
            }
            if (!((i2 & 2) == 0 && (i2 & 4) == 0)) {
                stringBuilder.append("\t\u2022 (Reserved)\n");
            }
            if (i2 == 0) {
                stringBuilder.append("\t\u2022 [unknown]\n");
            }
            stringBuilder.append(str).append(C0358k.f1076c).append("Major type: ");
            i2 = b2 & 31;
            switch (i2) {
                case C0519c.Switch_thumb /*0*/:
                    stringBuilder.append("Miscellaneous\n");
                    break;
                case C0519c.Switch_track /*1*/:
                    stringBuilder.append("Computer\n");
                    break;
                case C0519c.Switch_textOn /*2*/:
                    stringBuilder.append("Phone\n");
                    break;
                case C0519c.Switch_textOff /*3*/:
                    stringBuilder.append("Network access point\n");
                    break;
                case C0519c.Switch_thumbTextPadding /*4*/:
                    stringBuilder.append("Audio/Video\n");
                    break;
                case C0519c.Switch_switchTextAppearance /*5*/:
                    stringBuilder.append("Peripheral\n");
                    break;
                case C0519c.Switch_switchMinWidth /*6*/:
                    stringBuilder.append("Imaging\n");
                    break;
                case C0519c.Switch_switchPadding /*7*/:
                    stringBuilder.append("Wearable\n");
                    break;
                case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                    stringBuilder.append("Toy\n");
                    break;
                case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                    stringBuilder.append("Health\n");
                    break;
                case C0086R.styleable.SherlockTheme_searchDropdownBackground /*31*/:
                    stringBuilder.append("Uncategorized\n");
                    break;
                default:
                    stringBuilder.append(String.format("[unknown] (0x%02X)\n", new Object[]{Integer.valueOf(i2)}));
                    break;
            }
            stringBuilder.append(str).append(C0358k.f1076c).append("Minor type: ");
            int i3 = (b3 & 252) >> 2;
            if (i2 == 1) {
                switch (i3) {
                    case C0519c.Switch_thumb /*0*/:
                        stringBuilder.append("Unclassified\n");
                        break;
                    case C0519c.Switch_track /*1*/:
                        stringBuilder.append("Desktop\n");
                        break;
                    case C0519c.Switch_textOn /*2*/:
                        stringBuilder.append("Server\n");
                        break;
                    case C0519c.Switch_textOff /*3*/:
                        stringBuilder.append("Laptop\n");
                        break;
                    case C0519c.Switch_thumbTextPadding /*4*/:
                        stringBuilder.append("Handheld\n");
                        break;
                    case C0519c.Switch_switchTextAppearance /*5*/:
                        stringBuilder.append("Palmtop\n");
                        break;
                    case C0519c.Switch_switchMinWidth /*6*/:
                        stringBuilder.append("Wearable\n");
                        break;
                    default:
                        stringBuilder.append(String.format("[unknown] (0x%02X)\n", new Object[]{Integer.valueOf(i3)}));
                        break;
                }
            } else if (i2 == 2) {
                switch (i3) {
                    case C0519c.Switch_thumb /*0*/:
                        stringBuilder.append("Unclassified\n");
                        break;
                    case C0519c.Switch_track /*1*/:
                        stringBuilder.append("Cellular\n");
                        break;
                    case C0519c.Switch_textOn /*2*/:
                        stringBuilder.append("Cordless\n");
                        break;
                    case C0519c.Switch_textOff /*3*/:
                        stringBuilder.append("Smart phone\n");
                        break;
                    case C0519c.Switch_thumbTextPadding /*4*/:
                        stringBuilder.append("Modem or gateway\n");
                        break;
                    case C0519c.Switch_switchTextAppearance /*5*/:
                        stringBuilder.append("ISDN phone\n");
                        break;
                    default:
                        stringBuilder.append(String.format("[unknown] (0x%02X)\n", new Object[]{Integer.valueOf(i3)}));
                        break;
                }
            } else if (i2 == 3) {
                switch (i3 & 224) {
                    case C0519c.Switch_thumb /*0*/:
                        stringBuilder.append("0% utilized\n");
                        break;
                    case C0086R.styleable.SherlockTheme_searchViewCloseIcon /*32*/:
                        stringBuilder.append("1-17% utilized\n");
                        break;
                    case C0086R.styleable.SherlockTheme_activityChooserViewStyle /*64*/:
                        stringBuilder.append("17-33% utilized\n");
                        break;
                    case 96:
                        stringBuilder.append("33-50% utilized\n");
                        break;
                    case AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS /*128*/:
                        stringBuilder.append("50-67% utilized\n");
                        break;
                    case 160:
                        stringBuilder.append("67-83% utilized\n");
                        break;
                    case 192:
                        stringBuilder.append("83-99% utilized\n");
                        break;
                    case 224:
                        stringBuilder.append("No service\n");
                        break;
                    default:
                        stringBuilder.append(String.format("[unknown] (0x%02X)\n", new Object[]{Integer.valueOf(i3)}));
                        break;
                }
            } else if (i2 == 4) {
                switch (i3) {
                    case C0519c.Switch_thumb /*0*/:
                        stringBuilder.append("Unclassified\n");
                        break;
                    case C0519c.Switch_track /*1*/:
                        stringBuilder.append("Wearable headset\n");
                        break;
                    case C0519c.Switch_textOn /*2*/:
                        stringBuilder.append("Hands-free\n");
                        break;
                    case C0519c.Switch_thumbTextPadding /*4*/:
                        stringBuilder.append("Microphone\n");
                        break;
                    case C0519c.Switch_switchTextAppearance /*5*/:
                        stringBuilder.append("Loudspeaker\n");
                        break;
                    case C0519c.Switch_switchMinWidth /*6*/:
                        stringBuilder.append("Headphones\n");
                        break;
                    case C0519c.Switch_switchPadding /*7*/:
                        stringBuilder.append("Portable audio\n");
                        break;
                    case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                        stringBuilder.append("Car audio\n");
                        break;
                    case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                        stringBuilder.append("Set-top box\n");
                        break;
                    case C0086R.styleable.SherlockTheme_actionMenuTextAppearance /*10*/:
                        stringBuilder.append("Hifi audio\n");
                        break;
                    case C0086R.styleable.SherlockTheme_actionMenuTextColor /*11*/:
                        stringBuilder.append("VCR\n");
                        break;
                    case C0086R.styleable.SherlockTheme_actionModeStyle /*12*/:
                        stringBuilder.append("Video camera\n");
                        break;
                    case C0086R.styleable.SherlockTheme_actionModeCloseButtonStyle /*13*/:
                        stringBuilder.append("Camcorder\n");
                        break;
                    case C0086R.styleable.SherlockTheme_actionModeBackground /*14*/:
                        stringBuilder.append("Video monitor\n");
                        break;
                    case C0086R.styleable.SherlockTheme_actionModeSplitBackground /*15*/:
                        stringBuilder.append("Video display &amp; loudspeaker\n");
                        break;
                    case Menu.CATEGORY_SHIFT /*16*/:
                        stringBuilder.append("Video conferencing\n");
                        break;
                    case C0086R.styleable.SherlockTheme_actionModePopupWindowStyle /*18*/:
                        stringBuilder.append("Gaming/Toy\n");
                        break;
                    default:
                        stringBuilder.append(String.format("[unknown] (0x%02X)\n", new Object[]{Integer.valueOf(i3)}));
                        break;
                }
            } else if (i2 == 5) {
                switch (i3 & 15) {
                    case C0519c.Switch_thumb /*0*/:
                        stringBuilder.append("Unclassified");
                        break;
                    case C0519c.Switch_track /*1*/:
                        stringBuilder.append("Joystick");
                        break;
                    case C0519c.Switch_textOn /*2*/:
                        stringBuilder.append("Gamepad");
                        break;
                    case C0519c.Switch_textOff /*3*/:
                        stringBuilder.append("Remote control");
                        break;
                    case C0519c.Switch_thumbTextPadding /*4*/:
                        stringBuilder.append("Sensing device");
                        break;
                    case C0519c.Switch_switchTextAppearance /*5*/:
                        stringBuilder.append("Digitizer tablet");
                        break;
                    case C0519c.Switch_switchMinWidth /*6*/:
                        stringBuilder.append("Card reader");
                        break;
                    case C0519c.Switch_switchPadding /*7*/:
                        stringBuilder.append("Digital pen");
                        break;
                    case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                        stringBuilder.append("Barcode/RFID scanner");
                        break;
                    case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                        stringBuilder.append("Gestural wand");
                        break;
                    default:
                        stringBuilder.append(String.format("[unknown] (0x%02X)\n", new Object[]{Integer.valueOf(i3 & 15)}));
                        break;
                }
                switch (i3 & 96) {
                    case C0519c.Switch_thumb /*0*/:
                        stringBuilder.append(" (no keyboard/pointing device)\n");
                        break;
                    case C0086R.styleable.SherlockTheme_searchViewCloseIcon /*32*/:
                        stringBuilder.append(" (keyboard)\n");
                        break;
                    case C0086R.styleable.SherlockTheme_activityChooserViewStyle /*64*/:
                        stringBuilder.append(" (pointing device)\n");
                        break;
                    case 96:
                        stringBuilder.append(" (keyboard &amp; pointing device)\n");
                        break;
                    default:
                        break;
                }
            } else if (i2 == 6) {
                if ((i3 & 4) != 0) {
                    stringBuilder.append("Display ");
                }
                if ((i3 & 8) != 0) {
                    stringBuilder.append("Camera ");
                }
                if ((i3 & 16) != 0) {
                    stringBuilder.append("Scanner ");
                }
                if ((i3 & 32) != 0) {
                    stringBuilder.append("Printer ");
                }
                if ((i3 & 60) == 0) {
                    stringBuilder.append(String.format("[unknown] (0x%02X)", new Object[]{Integer.valueOf(i3)}));
                }
                stringBuilder.append("\n");
            } else if (i2 == 7) {
                switch (i3) {
                    case C0519c.Switch_thumb /*0*/:
                        stringBuilder.append("Unclassified\n");
                        break;
                    case C0519c.Switch_track /*1*/:
                        stringBuilder.append("Wrist watch\n");
                        break;
                    case C0519c.Switch_textOn /*2*/:
                        stringBuilder.append("Pager\n");
                        break;
                    case C0519c.Switch_textOff /*3*/:
                        stringBuilder.append("Jacket\n");
                        break;
                    case C0519c.Switch_thumbTextPadding /*4*/:
                        stringBuilder.append("Helmet\n");
                        break;
                    case C0519c.Switch_switchTextAppearance /*5*/:
                        stringBuilder.append("Glasses\n");
                        break;
                    default:
                        stringBuilder.append(String.format("[unknown] (0x%02X)\n", new Object[]{Integer.valueOf(i3 & 15)}));
                        break;
                }
            } else if (i2 == 8) {
                switch (i3) {
                    case C0519c.Switch_thumb /*0*/:
                        stringBuilder.append("Unclassified\n");
                        break;
                    case C0519c.Switch_track /*1*/:
                        stringBuilder.append("Robot\n");
                        break;
                    case C0519c.Switch_textOn /*2*/:
                        stringBuilder.append("Vehicle\n");
                        break;
                    case C0519c.Switch_textOff /*3*/:
                        stringBuilder.append("Doll/Action figure\n");
                        break;
                    case C0519c.Switch_thumbTextPadding /*4*/:
                        stringBuilder.append("Controller\n");
                        break;
                    case C0519c.Switch_switchTextAppearance /*5*/:
                        stringBuilder.append("Game\n");
                        break;
                    default:
                        stringBuilder.append(String.format("[unknown] (0x%02X)\n", new Object[]{Integer.valueOf(i3 & 15)}));
                        break;
                }
            } else if (i2 == 9) {
                switch (i3) {
                    case C0519c.Switch_thumb /*0*/:
                        stringBuilder.append("Unclassified\n");
                        break;
                    case C0519c.Switch_track /*1*/:
                        stringBuilder.append("Blood pressure monitor\n");
                        break;
                    case C0519c.Switch_textOn /*2*/:
                        stringBuilder.append("Thermometer\n");
                        break;
                    case C0519c.Switch_textOff /*3*/:
                        stringBuilder.append("Weighing scale\n");
                        break;
                    case C0519c.Switch_thumbTextPadding /*4*/:
                        stringBuilder.append("Glucose meter\n");
                        break;
                    case C0519c.Switch_switchTextAppearance /*5*/:
                        stringBuilder.append("Pulse oximeter\n");
                        break;
                    case C0519c.Switch_switchMinWidth /*6*/:
                        stringBuilder.append("Heart/Pulse rate monitor\n");
                        break;
                    case C0519c.Switch_switchPadding /*7*/:
                        stringBuilder.append("Health data display\n");
                        break;
                    case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                        stringBuilder.append("Step counter\n");
                        break;
                    case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                        stringBuilder.append("Body composition analyzer\n");
                        break;
                    case C0086R.styleable.SherlockTheme_actionMenuTextAppearance /*10*/:
                        stringBuilder.append("Peak flow monitor\n");
                        break;
                    case C0086R.styleable.SherlockTheme_actionMenuTextColor /*11*/:
                        stringBuilder.append("Medication monitor\n");
                        break;
                    case C0086R.styleable.SherlockTheme_actionModeStyle /*12*/:
                        stringBuilder.append("Knee prosthesis\n");
                        break;
                    case C0086R.styleable.SherlockTheme_actionModeCloseButtonStyle /*13*/:
                        stringBuilder.append("Ankle prosthesis\n");
                        break;
                    case C0086R.styleable.SherlockTheme_actionModeBackground /*14*/:
                        stringBuilder.append("Generic health manager\n");
                        break;
                    default:
                        stringBuilder.append(String.format("[unknown] (0x%02X)\n", new Object[]{Integer.valueOf(i3 & 15)}));
                        break;
                }
            } else {
                stringBuilder.append(String.format("[unknown] (0x%02X)\n", new Object[]{Integer.valueOf(i3 & 15)}));
            }
        }
        stringBuilder.append(str).append(C0358k.f1076c).append("Format type: ");
        switch (i) {
            case C0519c.Switch_thumb /*0*/:
                stringBuilder.append("Format #1");
            default:
                stringBuilder.append(String.format("[unknown] (0x%02X)", new Object[]{Integer.valueOf(i)}));
        }
    }

    private static void m1417a(byte[] bArr, int i, int i2, int i3, String str, StringBuilder stringBuilder) {
        int i4 = 0;
        while (i4 + 1 < i && (i2 + i4) + 1 < i3) {
            String str2 = (String) f1363a.get(C0429j.m1388a(bArr[(i2 + i4) + 1], bArr[i2 + i4]));
            stringBuilder.append("\n").append(str).append(String.format(C0358k.f1076c + "%04X", new Object[]{Integer.valueOf(r3)}));
            if (!TextUtils.isEmpty(str2)) {
                stringBuilder.append(": ").append(str2);
            }
            i4 += 2;
        }
    }

    public static void m1418a(byte[] bArr, String str, StringBuilder stringBuilder) {
        int length = bArr.length;
        int a = C0429j.m1388a(bArr[1], bArr[0]);
        stringBuilder.append(str).append(String.format("OOB data length: %d bytes\n", new Object[]{Integer.valueOf(a)}));
        if (length < a) {
            stringBuilder.append(str).append(C0358k.f1076c).append("Error: not enough data\n");
        } else if (length == a + 2) {
            stringBuilder.append(str).append(C0358k.f1076c).append("Error: length should include length field\n");
        } else if (length > a) {
            stringBuilder.append(str).append(C0358k.f1076c).append("Error: too much data\n");
        }
        byte[] bArr2 = new byte[6];
        for (a = 0; a < 6; a++) {
            bArr2[a] = bArr[7 - a];
        }
        stringBuilder.append(C0431b.m1415a(bArr2, str, 0));
        int i = 8;
        while (i < length) {
            stringBuilder.append("\n");
            int i2 = (bArr[i] & MotionEventCompat.ACTION_MASK) - 1;
            switch (bArr[i + 1] & MotionEventCompat.ACTION_MASK) {
                case C0519c.Switch_textOn /*2*/:
                    stringBuilder.append(str).append("List of 16-bit service class UUIDs:");
                    C0431b.m1417a(bArr, i2, i + 2, length, str, stringBuilder);
                    continue;
                case C0519c.Switch_textOff /*3*/:
                    stringBuilder.append(str).append("List of 16-bit service class UUIDs (complete):");
                    C0431b.m1417a(bArr, i2, i + 2, length, str, stringBuilder);
                    continue;
                case C0519c.Switch_thumbTextPadding /*4*/:
                    stringBuilder.append(str).append("List of 32-bit service class UUIDs:");
                    C0431b.m1419b(bArr, i2, i + 2, length, str, stringBuilder);
                    continue;
                case C0519c.Switch_switchTextAppearance /*5*/:
                    stringBuilder.append(str).append("List of 32-bit service class UUIDs (complete):");
                    C0431b.m1419b(bArr, i2, i + 2, length, str, stringBuilder);
                    continue;
                case C0519c.Switch_switchMinWidth /*6*/:
                    stringBuilder.append(str).append("List of 128-bit service class UUIDs:");
                    C0431b.m1420c(bArr, i2, i + 2, length, str, stringBuilder);
                    break;
                case C0519c.Switch_switchPadding /*7*/:
                    break;
                case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                    stringBuilder.append(str).append("Shortened local name: \"").append(C0429j.m1391a(new String(bArr, i + 2, i2, C0429j.f1360a))).append("\"");
                    continue;
                case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                    stringBuilder.append(str).append("Complete local name: \"").append(C0429j.m1391a(new String(bArr, i + 2, i2, C0429j.f1360a))).append("\"");
                    continue;
                case C0086R.styleable.SherlockTheme_actionModeCloseButtonStyle /*13*/:
                    C0431b.m1416a(str, bArr[i + 4], bArr[i + 3], bArr[i + 2], stringBuilder);
                    continue;
                case C0086R.styleable.SherlockTheme_actionModeBackground /*14*/:
                    stringBuilder.append(str).append("Simple pairing hash C:\n").append(str).append(C0358k.f1076c);
                    a = 0;
                    while (a < i2 && (i + a) + 2 < length) {
                        stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[(i + a) + 2])}));
                        a++;
                    }
                    break;
                case C0086R.styleable.SherlockTheme_actionModeSplitBackground /*15*/:
                    stringBuilder.append(str).append("Simple pairing randomizer R:\n").append(str).append(C0358k.f1076c);
                    a = 0;
                    while (a < i2 && (i + a) + 2 < length) {
                        stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[(i + a) + 2])}));
                        a++;
                    }
                    break;
                default:
                    stringBuilder.append(str).append("EIR data:\n").append(str).append(C0358k.f1076c);
                    a = 0;
                    while (a < i2 && (i + a) + 2 < length) {
                        stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[(i + a) + 2])}));
                        a++;
                    }
                    break;
            }
            stringBuilder.append(str).append("List of 128-bit service class UUIDs (complete):");
            C0431b.m1420c(bArr, i2, i + 2, length, str, stringBuilder);
            i = (i2 + 2) + i;
        }
    }

    private static void m1419b(byte[] bArr, int i, int i2, int i3, String str, StringBuilder stringBuilder) {
        int i4 = 0;
        while (i4 + 3 < i && (i2 + i4) + 3 < i3) {
            long a = C0429j.m1390a(bArr[(i2 + i4) + 3], bArr[(i2 + i4) + 2], bArr[(i2 + i4) + 1], bArr[i2 + i4]);
            Object obj = null;
            if (a <= 2147483647L) {
                obj = (String) f1363a.get((int) a);
            }
            stringBuilder.append("\n").append(str).append(String.format(C0358k.f1076c + "%08X", new Object[]{Long.valueOf(a)}));
            if (!TextUtils.isEmpty(obj)) {
                stringBuilder.append(": ").append(obj);
            }
            i4 += 4;
        }
    }

    private static void m1420c(byte[] bArr, int i, int i2, int i3, String str, StringBuilder stringBuilder) {
        int i4 = 0;
        while (i4 + 15 < i && (i2 + i4) + 15 < i3) {
            long j = 0;
            long j2 = 0;
            for (int i5 = 7; i5 >= 0; i5--) {
                j2 = (j2 << 8) | ((long) (bArr[(i5 + i4) + i2] & MotionEventCompat.ACTION_MASK));
                j = (j << 8) | ((long) (bArr[((i5 + 8) + i4) + i2] & MotionEventCompat.ACTION_MASK));
            }
            Object uuid = new UUID(j, j2).toString();
            if (!TextUtils.isEmpty(uuid)) {
                String toUpperCase = uuid.toUpperCase();
                stringBuilder.append("\n").append(str).append(C0358k.f1076c).append(toUpperCase);
                if (toUpperCase.endsWith("-0000-1000-8000-00805F9B34FB")) {
                    toUpperCase = (String) f1363a.get(Integer.parseInt(toUpperCase.substring(0, 8), 16));
                    if (!TextUtils.isEmpty(toUpperCase)) {
                        stringBuilder.append("\n\t\u2022 ").append(toUpperCase);
                    }
                }
            }
            i4 += 16;
        }
    }
}
