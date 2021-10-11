package com.nxp.taginfolite.p004f;

import android.support.v4.BuildConfig;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.actionbarsherlock.C0086R;
import com.nxp.taginfolite.p003g.C0428i;
import java.util.Arrays;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.f.z */
public class C0372z {
    private byte[] f1183a;

    public C0372z(byte[] bArr) {
        this.f1183a = null;
        if (bArr != null) {
            this.f1183a = Arrays.copyOf(bArr, bArr.length);
        }
    }

    public static CharSequence m1115a(byte[] bArr) {
        return new C0372z(bArr).m1120b();
    }

    public static boolean m1116b(byte[] bArr) {
        return new C0372z(bArr).m1119a();
    }

    public static String m1117c(byte[] bArr) {
        return new C0372z(bArr).m1121c();
    }

    public static Integer m1118d(byte[] bArr) {
        return new C0372z(bArr).m1122d();
    }

    public boolean m1119a() {
        return this.f1183a != null && this.f1183a.length > 7 && this.f1183a[0] == null;
    }

    public CharSequence m1120b() {
        if (!m1119a()) {
            return null;
        }
        int i;
        byte[] bArr = this.f1183a;
        C0428i c0428i = new C0428i();
        c0428i.m1387b("Vendor ID: ");
        if (bArr[1] == (byte) 4) {
            c0428i.m1387b("NXP");
        } else {
            c0428i.m1387b("[unknown]");
        }
        c0428i.m1384a(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[1])}));
        c0428i.m1387b("Type: ");
        switch (bArr[2] & 15) {
            case C0519c.Switch_textOff /*3*/:
                c0428i.m1387b("MIFARE Ultralight");
                i = 0;
                break;
            case C0519c.Switch_thumbTextPadding /*4*/:
                c0428i.m1387b("NTAG");
                i = 1;
                break;
            case C0519c.Switch_switchTextAppearance /*5*/:
                c0428i.m1387b("MIFARE Classic");
                i = 1;
                break;
            default:
                c0428i.m1387b("[unknown]");
                i = 0;
                break;
        }
        c0428i.m1384a(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[2])}));
        c0428i.m1387b("Subtype: ");
        switch (bArr[3] & 15) {
            case C0519c.Switch_track /*1*/:
                c0428i.m1387b("17\u200apF");
                break;
            case C0519c.Switch_textOn /*2*/:
                c0428i.m1387b("50\u200apF");
                break;
            case C0519c.Switch_textOff /*3*/:
                c0428i.m1387b("17\u200apF, MUG UID");
                break;
            case C0519c.Switch_thumbTextPadding /*4*/:
                c0428i.m1387b("50\u200apF, FDP");
                break;
            case C0519c.Switch_switchTextAppearance /*5*/:
                c0428i.m1387b("50\u200apF, FDP, I\u00b2C");
                break;
            default:
                c0428i.m1387b("[unknown]");
                break;
        }
        c0428i.m1384a(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[3])}));
        c0428i.m1387b("Major version: ");
        switch (bArr[4] & 3) {
            case C0519c.Switch_thumb /*0*/:
                c0428i.m1387b(i != 0 ? "0" : "EV0");
                break;
            case C0519c.Switch_track /*1*/:
                c0428i.m1387b(i != 0 ? "1" : "EV1");
                break;
            case C0519c.Switch_textOn /*2*/:
                c0428i.m1387b(i != 0 ? "2" : "EV2");
                break;
            default:
                c0428i.m1387b("[unknown]");
                break;
        }
        c0428i.m1384a(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[4])}));
        c0428i.m1387b(String.format("Minor version: V%d", new Object[]{Integer.valueOf(bArr[5] & 3)}));
        c0428i.m1384a(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[5])}));
        c0428i.m1387b("Storage size: " + C0372z.m1117c(bArr));
        c0428i.m1384a(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[6])}));
        c0428i.m1387b("Protocol: ");
        switch (bArr[7]) {
            case C0519c.Switch_textOff /*3*/:
                c0428i.m1387b("ISO/IEC 14443-3");
                break;
            default:
                c0428i.m1387b("[unknown]");
                break;
        }
        c0428i.m1384a(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[7])}));
        return c0428i.m1386b();
    }

    public String m1121c() {
        String str;
        int intValue = m1122d().intValue();
        if (intValue % 2 != 0) {
            intValue--;
            str = ">";
        } else {
            str = BuildConfig.VERSION_NAME;
        }
        return str + (intValue % AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT == 0 ? Integer.toString(intValue / AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT) + "\u200a" + "kB" : Integer.toString(intValue) + " bytes");
    }

    public Integer m1122d() {
        if (this.f1183a == null || this.f1183a.length < 6) {
            return null;
        }
        int i;
        byte b = this.f1183a[6];
        switch (b & MotionEventCompat.ACTION_MASK) {
            case C0086R.styleable.SherlockTheme_actionMenuTextColor /*11*/:
                i = 48;
                break;
            case C0086R.styleable.SherlockTheme_actionModeBackground /*14*/:
                i = AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS;
                break;
            case C0086R.styleable.SherlockTheme_actionModeSplitBackground /*15*/:
                i = 144;
                break;
            case C0086R.styleable.SherlockTheme_actionModeShareDrawable /*17*/:
                if ((this.f1183a[5] & MotionEventCompat.ACTION_MASK) != 1) {
                    i = 504;
                    break;
                }
                i = 272;
                break;
            case C0086R.styleable.SherlockTheme_buttonStyleSmall /*19*/:
                if ((this.f1183a[2] & 15) != 5) {
                    if ((this.f1183a[4] & MotionEventCompat.ACTION_MASK) != 2) {
                        i = 888;
                        break;
                    }
                    i = 888;
                    break;
                }
                i = AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT;
                break;
            case C0086R.styleable.SherlockTheme_windowContentOverlay /*21*/:
                if ((this.f1183a[2] & 15) != 5) {
                    if ((this.f1183a[4] & MotionEventCompat.ACTION_MASK) != 2) {
                        i = 1 << (((b & MotionEventCompat.ACTION_MASK) >> 1) + 1);
                        break;
                    }
                    i = 1904;
                    break;
                }
                i = AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT;
                break;
            default:
                i = 1 << ((b & MotionEventCompat.ACTION_MASK) >> 1);
                if ((b & 1) != 0) {
                    i++;
                    break;
                }
                break;
        }
        return Integer.valueOf(i);
    }
}
