package com.nxp.taginfolite.p004f;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import android.support.v4.BuildConfig;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.p009e.p013d.C0275d;
import com.nxp.taginfolite.p009e.p013d.C0279h;
import com.nxp.taginfolite.p009e.p013d.C0281j;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.f.o */
public class C0362o {
    private static final SparseArray f1093A;
    public static final String f1094a;
    public static final String f1095b;
    public static final String f1096c;
    public static final String f1097d;
    public static final String f1098e;
    public static final String f1099f;
    public static final String f1100g;
    public static final String f1101h;
    public static HashMap f1102i;
    public static final SparseArray f1103j;
    private static final String f1104k;
    private static final String f1105l;
    private static final String f1106m;
    private static final String f1107n;
    private static final EnumMap f1108o;
    private static final byte[] f1109p;
    private static final byte[] f1110q;
    private static final byte[] f1111r;
    private static final byte[] f1112s;
    private static final byte[] f1113t;
    private static final byte[] f1114u;
    private static final byte[] f1115v;
    private static final byte[] f1116w;
    private static final byte[] f1117x;
    private static final byte[] f1118y;
    private static final byte[] f1119z;

    static {
        f1094a = "\n" + C0358k.f1076c;
        f1095b = f1094a + "ISO/IEC 14443 (contactless)";
        f1096c = f1094a + "ISO/IEC 7816-3 (contact)";
        f1097d = f1094a + "ISO/IEC 7816-3 (contact, P5CT072 only)";
        f1098e = f1094a + "ISO/IEC 7816-12 (USB)";
        f1099f = f1094a + "ISO/IEC 7816-12 (USB, P5CT072 only)";
        f1100g = f1094a + "ISO/IEC 28361 (WI, S\u00b2C)";
        f1104k = "Supported interfaces:" + f1095b + f1096c + "\nCoprocessors: " + "3DES, " + "FameXE (Public key)";
        f1105l = "Supported interfaces:" + f1095b + f1096c + "\nCoprocessors: " + "3DES, AES, " + "FameXE (Public key)";
        f1106m = "Supported interfaces:" + f1096c + f1100g + "\nCoprocessors: " + "3DES, AES, " + "FameXE (Public key)";
        f1107n = "Supported interfaces:" + f1095b + f1096c + f1098e + "\nCoprocessors: " + "3DES, AES, " + "FameXE (Public key)";
        f1101h = "Supported interfaces:" + f1095b + f1094a + "I\u00b2C" + " slave interface, supporting:\n" + "\t\u2022 " + "Standard mode (100" + "\u200a" + "kHz)\n" + "\t\u2022 " + "Fast mode (up to 400" + "\u200a" + "kHz)";
        f1108o = new C0363p(C0368u.class);
        f1102i = new C0364q();
        f1109p = new byte[]{(byte) 3, (byte) -40, (byte) -115, (byte) -109};
        f1110q = new byte[]{(byte) 3, (byte) -79, (byte) 72, (byte) 50};
        f1111r = new byte[]{(byte) -56, (byte) -11, (byte) -4};
        f1112s = new byte[]{(byte) -25, (byte) 89, (byte) -90};
        f1113t = new byte[]{(byte) -98, (byte) 0, (byte) 122};
        f1114u = new byte[]{(byte) -19, (byte) 16, (byte) 60};
        f1115v = new byte[]{(byte) 35, (byte) -73, (byte) 22};
        f1116w = new byte[]{(byte) 57, (byte) -8, (byte) 115};
        f1117x = new byte[]{(byte) 96, (byte) 45, (byte) -112};
        f1118y = new byte[]{(byte) 88, (byte) -23, (byte) 87};
        f1119z = new byte[]{(byte) -61, (byte) 16, (byte) -22};
        f1103j = new C0365r();
        f1093A = new C0366s();
    }

    public static C0279h m1074a(int i, int i2, int i3) {
        if (i == 19800) {
            return C0279h.MifareProX;
        }
        if (i2 == 20552) {
            switch (MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) {
                case 19712:
                    return C0279h.MifarePro;
                case 20480:
                case 24576:
                    return C0279h.MifareProX;
                default:
                    return C0279h.UNKNOWN;
            }
        }
        switch (Menu.USER_MASK & i) {
            case 516:
            case 517:
            case 44052:
            case 45588:
                return C0279h.ST23YR;
            case 20501:
            case 20502:
            case 20503:
            case 20513:
            case 20517:
            case 20536:
            case 20544:
            case 20547:
            case 20548:
            case 20594:
            case 20608:
            case 20804:
            case 20839:
            case 20840:
            case 20997:
            case 21010:
            case 21017:
                return C0279h.SmartMX;
            case 24930:
            case 24932:
                return C0279h.SLE66;
            case 30880:
            case 30882:
            case 30884:
            case 30885:
            case 30887:
            case 30889:
            case 30891:
            case 30895:
            case 30896:
            case 30897:
            case 30898:
                return C0279h.SLE78;
            case 38152:
            case 38166:
            case 38167:
            case 38408:
            case 38422:
            case 38423:
                return C0279h.MifareProX;
            default:
                return (TextUtils.equals(C0355h.m1066b(i3), "NXP Semiconductors") && (61440 & i) == 20480) ? C0279h.SmartMX : C0279h.UNKNOWN;
        }
    }

    public static C0368u m1075a(int i, int i2, Tag tag) {
        if (i == 19800) {
            return (C0368u) f1103j.get(i);
        }
        if (i2 != 20552) {
            return (C0368u) f1103j.get(i);
        }
        if (i == 19782) {
            NfcA nfcA = NfcA.get(tag);
            if (nfcA != null) {
                switch (nfcA.getSak() & MotionEventCompat.ACTION_MASK) {
                    case C0086R.styleable.SherlockTheme_searchViewCloseIcon /*32*/:
                        return C0368u.MFP_MF2ICD80;
                    case C0086R.styleable.SherlockTheme_textColorSearchUrl /*40*/:
                        return C0368u.MFP_MF2ICD81;
                    case 184:
                        return C0368u.MFP_MF2ICD84;
                    default:
                        return C0368u.UNKNOWN;
                }
            }
        }
        return (C0368u) f1093A.get(i);
    }

    public static C0368u m1076a(C0275d c0275d, String str, byte[] bArr, C0368u c0368u) {
        if (c0368u != C0368u.UNKNOWN && !C0362o.m1081b(c0368u)) {
            return c0368u;
        }
        if (c0275d == C0275d.JCOP_NXP && bArr == null) {
            return c0368u;
        }
        if (c0275d == C0275d.JCOP_NXP) {
            C0368u c0368u2 = (C0368u) C0281j.f728a.get(str);
            if (c0368u2 == C0368u.UNKNOWN) {
                return c0368u;
            }
            if (!C0362o.m1081b(c0368u2)) {
                return c0368u2;
            }
            switch (C0367t.f1120a[c0368u2.ordinal()]) {
                case C0519c.Switch_track /*1*/:
                case C0519c.Switch_textOn /*2*/:
                case C0519c.Switch_textOff /*3*/:
                    if (TextUtils.equals("PH620B", str)) {
                        return C0368u.SMX_P5CT072;
                    }
                    break;
                case C0519c.Switch_thumbTextPadding /*4*/:
                case C0519c.Switch_switchPadding /*7*/:
                    if (Arrays.equals(bArr, f1111r) || Arrays.equals(bArr, f1114u)) {
                        return C0368u.SMX_P5CD080;
                    }
                    if (Arrays.equals(bArr, f1113t) || Arrays.equals(bArr, f1115v) || Arrays.equals(bArr, f1116w)) {
                        return C0368u.SMX_P5CD040;
                    }
                    if (Arrays.equals(bArr, f1112s)) {
                        return C0368u.SMX_P5CD081;
                    }
                    break;
                case C0519c.Switch_switchMinWidth /*6*/:
                    return C0368u.SMX_P5CD144;
                case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                    if (Arrays.equals(bArr, f1117x)) {
                        return C0368u.SMX_P5CD145;
                    }
                    if (Arrays.equals(bArr, f1118y)) {
                        return C0368u.SMX_P5CD041_P5CD081;
                    }
                    break;
            }
            return c0368u2;
        } else if (c0275d == C0275d.SMARTCAFE) {
            switch (C0367t.f1120a[c0368u.ordinal()]) {
                case C0519c.Switch_thumbTextPadding /*4*/:
                    return C0368u.SMX_P5CD080;
                default:
                    return c0368u;
            }
        } else if (c0275d == C0275d.GEM_TOP) {
            switch (C0367t.f1120a[c0368u.ordinal()]) {
                case C0519c.Switch_switchMinWidth /*6*/:
                    return C0368u.SMX_P5CD081;
                default:
                    return c0368u;
            }
        } else if (c0275d != C0275d.OCS_OS) {
            return c0368u;
        } else {
            switch (C0367t.f1120a[c0368u.ordinal()]) {
                case C0519c.Switch_switchTextAppearance /*5*/:
                    return C0368u.SMX_P5CD081;
                default:
                    return c0368u;
            }
        }
    }

    public static String m1078a(C0368u c0368u) {
        String str = (String) f1108o.get(c0368u);
        return str == null ? BuildConfig.VERSION_NAME : str;
    }

    public static byte[] m1079a(byte[] bArr, int i) {
        if (bArr == null || bArr.length < i + 5) {
            return null;
        }
        return new byte[]{(byte) ((((bArr[4] >> 4) & 15) | ((bArr[3] << 4) & 48)) + 32), (byte) (((bArr[3] >> 2) & 63) + 32), (byte) ((bArr[2] & 63) + 32), (byte) ((((bArr[2] >> 6) & 3) | ((bArr[1] << 2) & 60)) + 32), (byte) ((((bArr[1] >> 4) & 15) | ((bArr[0] << 4) & 48)) + 32), (byte) (((bArr[0] >> 2) & 63) + 32)};
    }

    public static boolean m1081b(C0368u c0368u) {
        if (c0368u == null) {
            return false;
        }
        switch (C0367t.f1120a[c0368u.ordinal()]) {
            case C0519c.Switch_track /*1*/:
            case C0519c.Switch_textOn /*2*/:
            case C0519c.Switch_textOff /*3*/:
            case C0519c.Switch_thumbTextPadding /*4*/:
            case C0519c.Switch_switchTextAppearance /*5*/:
            case C0519c.Switch_switchMinWidth /*6*/:
            case C0519c.Switch_switchPadding /*7*/:
            case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                return true;
            default:
                return false;
        }
    }

    public static int m1082c(C0368u c0368u) {
        if (c0368u == null) {
            return -1;
        }
        switch (C0367t.f1120a[c0368u.ordinal()]) {
            case C0519c.Switch_textOn /*2*/:
            case C0519c.Switch_textOff /*3*/:
            case C0086R.styleable.SherlockTheme_spinnerItemStyle /*28*/:
            case C0086R.styleable.SherlockTheme_spinnerDropDownItemStyle /*29*/:
            case C0086R.styleable.SherlockTheme_searchAutoCompleteTextView /*30*/:
                return 72;
            case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
            case C0086R.styleable.SherlockTheme_actionMenuTextAppearance /*10*/:
                return 4;
            case C0086R.styleable.SherlockTheme_actionMenuTextColor /*11*/:
            case C0086R.styleable.SherlockTheme_actionModeStyle /*12*/:
            case C0086R.styleable.SherlockTheme_actionModeCloseButtonStyle /*13*/:
            case C0086R.styleable.SherlockTheme_actionModeBackground /*14*/:
            case C0086R.styleable.SherlockTheme_actionModeSplitBackground /*15*/:
                return 8;
            case Menu.CATEGORY_SHIFT /*16*/:
            case C0086R.styleable.SherlockTheme_actionModeShareDrawable /*17*/:
                return 12;
            case C0086R.styleable.SherlockTheme_actionModePopupWindowStyle /*18*/:
                return 20;
            case C0086R.styleable.SherlockTheme_buttonStyleSmall /*19*/:
            case C0086R.styleable.SherlockTheme_selectableItemBackground /*20*/:
            case C0086R.styleable.SherlockTheme_windowContentOverlay /*21*/:
            case C0086R.styleable.SherlockTheme_textAppearanceLargePopupMenu /*22*/:
                return 16;
            case C0086R.styleable.SherlockTheme_textAppearanceSmallPopupMenu /*23*/:
            case C0086R.styleable.SherlockTheme_textAppearanceSmall /*24*/:
                return 36;
            case C0086R.styleable.SherlockTheme_textColorPrimary /*25*/:
            case C0086R.styleable.SherlockTheme_textColorPrimaryDisableOnly /*26*/:
                return 40;
            case C0086R.styleable.SherlockTheme_textColorPrimaryInverse /*27*/:
                return 64;
            case C0086R.styleable.SherlockTheme_searchDropdownBackground /*31*/:
            case C0086R.styleable.SherlockTheme_searchViewCloseIcon /*32*/:
            case C0086R.styleable.SherlockTheme_searchViewGoIcon /*33*/:
                return 80;
            case C0086R.styleable.SherlockTheme_searchViewSearchIcon /*34*/:
                return AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS;
            case C0086R.styleable.SherlockTheme_searchViewVoiceIcon /*35*/:
                return 144;
            default:
                return -1;
        }
    }
}
