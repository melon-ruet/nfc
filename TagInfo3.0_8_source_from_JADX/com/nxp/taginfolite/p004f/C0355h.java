package com.nxp.taginfolite.p004f;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.f.h */
public class C0355h {
    private static final SparseArray f1072a;
    private static final SparseArray f1073b;

    static {
        f1072a = new C0356i();
        f1073b = new C0357j();
    }

    public static String m1064a(int i) {
        String str = (String) f1073b.get(i);
        return TextUtils.isEmpty(str) ? (String) f1072a.get(i) : str;
    }

    public static boolean m1065a(byte[] bArr, C0360m c0360m) {
        return "NXP Semiconductors".equals(C0355h.m1067b(bArr, c0360m));
    }

    public static String m1066b(int i) {
        switch (Menu.USER_MASK & i) {
            case 16496:
            case 18320:
            case 18464:
            case 20552:
                return "NXP Semiconductors";
            case 16528:
                return "Infineon Technologies AG";
            case 16768:
                return "INSIDE Secure S.A.";
            case 16976:
                return "Samsung Electronics Co. Ltd";
            case 18256:
                return "STMicroelectronics SA";
            default:
                if (i >= Menu.CATEGORY_CONTAINER) {
                    switch (i) {
                        case Menu.CATEGORY_CONTAINER /*65536*/:
                            return "Hitachi, Ltd";
                        case 65537:
                            return "Fudan Microelectronics";
                        case 65538:
                            return "Maxim Integrated";
                    }
                }
                return "Unknown manufacturer";
        }
    }

    public static String m1067b(byte[] bArr, C0360m c0360m) {
        String str = "Unknown manufacturer";
        if (bArr == null || c0360m == C0360m.UNKNOWN) {
            return "Unknown manufacturer";
        }
        int i;
        if (bArr.length >= 7) {
            i = c0360m == C0360m.ISO15693 ? bArr[6] & MotionEventCompat.ACTION_MASK : c0360m == C0360m.BARCODE ? bArr[0] & TransportMediator.KEYCODE_MEDIA_PAUSE : bArr[0] & MotionEventCompat.ACTION_MASK;
            str = (String) f1072a.get(i);
            return str == null ? "Unknown manufacturer" : str;
        } else if (bArr.length != 4) {
            return str;
        } else {
            if (bArr[0] == 8 && (c0360m == C0360m.ISO14443_A || c0360m == C0360m.MIFARE)) {
                return "Unknown manufacturer";
            }
            if (bArr[0] == -128 && c0360m == C0360m.DESFIRE) {
                return "NXP Semiconductors";
            }
            if (c0360m != C0360m.MIFARE && c0360m != C0360m.ISO14443_A) {
                return str;
            }
            i = bArr[0] & MotionEventCompat.ACTION_MASK;
            int i2 = bArr[1] & MotionEventCompat.ACTION_MASK;
            int i3 = bArr[2] & MotionEventCompat.ACTION_MASK;
            int i4 = bArr[3] & MotionEventCompat.ACTION_MASK;
            switch (i & 15) {
                case C0519c.Switch_thumb /*0*/:
                    if (i4 > 28) {
                        return "NXP Semiconductors";
                    }
                    long j = (long) ((((bArr[0] & MotionEventCompat.ACTION_MASK) | ((bArr[1] & MotionEventCompat.ACTION_MASK) << 8)) | ((bArr[2] & MotionEventCompat.ACTION_MASK) << 16)) | ((bArr[3] & MotionEventCompat.ACTION_MASK) << 24));
                    return (j < 224000000 || j > 480000000) ? "NXP Semiconductors" : "Gemalto SA";
                case C0519c.Switch_track /*1*/:
                case C0519c.Switch_switchTextAppearance /*5*/:
                case C0519c.Switch_switchPadding /*7*/:
                case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                    return "Infineon Technologies AG";
                case C0519c.Switch_textOn /*2*/:
                case C0519c.Switch_thumbTextPadding /*4*/:
                case C0519c.Switch_switchMinWidth /*6*/:
                case C0086R.styleable.SherlockTheme_actionMenuTextAppearance /*10*/:
                case C0086R.styleable.SherlockTheme_actionMenuTextColor /*11*/:
                case C0086R.styleable.SherlockTheme_actionModeStyle /*12*/:
                case C0086R.styleable.SherlockTheme_actionModeCloseButtonStyle /*13*/:
                case C0086R.styleable.SherlockTheme_actionModeBackground /*14*/:
                    return "NXP Semiconductors";
                case C0519c.Switch_textOff /*3*/:
                    return i4 <= 63 ? (i4 <= 15 || (i4 == 16 && i3 == 0 && i2 == 0 && i == 3)) ? "Renesas Technology Corp." : (i4 <= 31 || (i4 == 32 && i3 == 0 && i2 == 0 && i == 3)) ? "STMicroelectronics SA" : "NXP Semiconductors" : "NXP Semiconductors";
                case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                    i = (i & 240) >> 4;
                    return (i == 6 || i == 7 || (i >= 10 && i <= 15)) ? "NXP Semiconductors" : i == 0 ? "Unknown manufacturer" : i == 8 ? "Reserved: Cascade tag" : "Infineon Technologies AG";
                case C0086R.styleable.SherlockTheme_actionModeSplitBackground /*15*/:
                    return (i & 16) == 1 ? "Infineon Technologies AG" : "NXP Semiconductors";
                default:
                    return "Unknown manufacturer";
            }
        }
    }
}
