package com.nxp.taginfolite.p009e.p014e;

import android.content.ContentResolver;
import android.database.Cursor;
import android.nfc.tech.MifareUltralight;
import android.support.v4.BuildConfig;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.actionbarsherlock.C0086R;
import com.nxp.taginfolite.TagInfoApp;
import com.nxp.taginfolite.database.provider.UserKeys;
import com.nxp.taginfolite.p003g.C0422a;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0353f;
import com.nxp.taginfolite.p004f.C0354g;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.C0372z;
import com.nxp.taginfolite.p009e.az;
import com.nxp.taginfolite.p009e.bb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.e.a */
public class C0293a {
    private static final C0422a f747A;
    private static final C0422a f748B;
    private static final C0422a f749C;
    public static final HashMap f750a;
    public static final HashMap f751b;
    public static final HashMap f752c;
    public static final HashMap f753d;
    public static final HashMap f754e;
    private static final byte[] f755f;
    private static final C0422a f756g;
    private static final C0422a f757h;
    private static final C0422a f758i;
    private static final C0422a f759j;
    private static final C0422a f760k;
    private static final C0422a f761l;
    private static final C0422a f762m;
    private static final C0422a f763n;
    private static final C0422a f764o;
    private static final C0422a f765p;
    private static final C0422a f766q;
    private static final C0422a f767r;
    private static final C0422a f768s;
    private static final C0422a f769t;
    private static final C0422a f770u;
    private static final C0422a f771v;
    private static final C0422a f772w;
    private static final C0422a f773x;
    private static final C0422a f774y;
    private static final C0422a f775z;

    static {
        f755f = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1};
        f756g = new C0422a(0, 4, 3, 1, 0, 0, 11, 3);
        f757h = new C0422a(0, 4, 3, 1, 1, 0, 11, 3);
        f758i = new C0422a(0, 4, 3, 2, 1, 0, 11, 3);
        f759j = new C0422a(0, 4, 3, 3, 1, 0, 11, 3);
        f760k = new C0422a(0, 4, 3, 1, 1, 0, 14, 3);
        f761l = new C0422a(0, 4, 3, 2, 1, 0, 14, 3);
        f762m = new C0422a(0, 4, 3, 1, 1, 0, 17, 3);
        f763n = new C0422a(0, 4, 3, 2, 1, 0, 17, 3);
        f764o = new C0422a(0, 4, 3, 1, 1, 0, 19, 3);
        f765p = new C0422a(0, 4, 4, 1, 1, 0, 11, 3);
        f766q = new C0422a(0, 4, 4, 2, 1, 0, 11, 3);
        f767r = new C0422a(0, 4, 4, 1, 1, 0, 14, 3);
        f768s = new C0422a(0, 4, 4, 2, 1, 0, 15, 3);
        f769t = new C0422a(0, 4, 4, 4, 1, 0, 15, 3);
        f770u = new C0422a(0, 4, 4, 2, 1, 1, 17, 3);
        f771v = new C0422a(0, 4, 4, 2, 1, 0, 17, 3);
        f772w = new C0422a(0, 4, 4, 4, 1, 0, 17, 3);
        f773x = new C0422a(0, 4, 4, 2, 1, 0, 19, 3);
        f774y = new C0422a(0, 4, 4, 4, 1, 0, 19, 3);
        f775z = new C0422a(0, 4, 4, 5, 2, 0, 19, 3);
        f747A = new C0422a(0, 4, 4, 5, 2, 0, 21, 3);
        f748B = new C0422a(0, 4, 4, 5, 2, 1, 19, 3);
        f749C = new C0422a(0, 4, 4, 5, 2, 1, 21, 3);
        f750a = new C0294b();
        f751b = new C0295c();
        f752c = new C0296d();
        f753d = new C0297e();
        f754e = new C0298f();
    }

    public static int m769a(byte[] bArr, C0302j c0302j) {
        switch (C0299g.f777b[C0293a.m770a(bArr).ordinal()]) {
            case C0519c.Switch_track /*1*/:
                return c0302j == C0302j.UC0 ? 15 : 19;
            case C0519c.Switch_textOn /*2*/:
                return 40;
            case C0519c.Switch_textOff /*3*/:
                return 44;
            case C0519c.Switch_thumbTextPadding /*4*/:
                return 76;
            case C0519c.Switch_switchTextAppearance /*5*/:
                return 134;
            case C0519c.Switch_switchMinWidth /*6*/:
                return 230;
            case C0519c.Switch_switchPadding /*7*/:
                return 480;
            default:
                return ((C0372z.m1118d(bArr).intValue() / 4) + 3) + 5;
        }
    }

    public static C0301i m770a(byte[] bArr) {
        switch (bArr[6] & MotionEventCompat.ACTION_MASK) {
            case C0086R.styleable.SherlockTheme_actionMenuTextColor /*11*/:
                return C0301i.MS0;
            case C0086R.styleable.SherlockTheme_actionModeBackground /*14*/:
                return C0301i.MS1;
            case C0086R.styleable.SherlockTheme_actionModeSplitBackground /*15*/:
                return C0301i.MS4;
            case C0086R.styleable.SherlockTheme_actionModeShareDrawable /*17*/:
                return (bArr[5] & MotionEventCompat.ACTION_MASK) == 1 ? C0301i.MS5 : C0301i.MS2;
            case C0086R.styleable.SherlockTheme_buttonStyleSmall /*19*/:
                return C0301i.MS3;
            default:
                return C0301i.UNKNOWN;
        }
    }

    private static String m772a(int i, byte[] bArr, C0301i c0301i) {
        Boolean bool = null;
        boolean z = true;
        if (bArr == null || bArr.length < 5 || i < 16) {
            return "?";
        }
        int i2;
        Boolean valueOf;
        switch (C0299g.f777b[c0301i.ordinal()]) {
            case C0519c.Switch_track /*1*/:
                return " ";
            case C0519c.Switch_textOn /*2*/:
            case C0519c.Switch_textOff /*3*/:
                i2 = 2;
                break;
            case C0519c.Switch_thumbTextPadding /*4*/:
            case C0519c.Switch_switchTextAppearance /*5*/:
            case C0519c.Switch_switchMinWidth /*6*/:
                i2 = 16;
                break;
            default:
                i2 = 0;
                break;
        }
        int intValue = ((Integer) f754e.get(c0301i)).intValue();
        if (i < intValue) {
            i2 = (i - 16) / i2;
            bool = Boolean.valueOf(((C0429j.m1388a(bArr[1], bArr[0]) >> i2) & 1) == 1);
            if (((bArr[2] >> (i2 / 2)) & 1) != 1) {
                z = false;
            }
            valueOf = Boolean.valueOf(z);
        } else if (i == intValue) {
            switch (C0299g.f777b[c0301i.ordinal()]) {
                case C0519c.Switch_textOn /*2*/:
                    if ((bArr[2] & 31) != 31) {
                        z = false;
                    }
                    valueOf = Boolean.valueOf(z);
                    break;
                case C0519c.Switch_textOff /*3*/:
                    if ((bArr[2] & 63) != 63) {
                        z = false;
                    }
                    valueOf = Boolean.valueOf(z);
                    break;
                case C0519c.Switch_thumbTextPadding /*4*/:
                    if ((bArr[2] & 3) != 3) {
                        z = false;
                    }
                    valueOf = Boolean.valueOf(z);
                    break;
                case C0519c.Switch_switchTextAppearance /*5*/:
                    if ((bArr[2] & 15) != 15) {
                        z = false;
                    }
                    valueOf = Boolean.valueOf(z);
                    break;
                case C0519c.Switch_switchMinWidth /*6*/:
                    if ((bArr[2] & TransportMediator.KEYCODE_MEDIA_PAUSE) != TransportMediator.KEYCODE_MEDIA_PAUSE) {
                        z = false;
                    }
                    valueOf = Boolean.valueOf(z);
                    break;
                default:
                    valueOf = Boolean.valueOf(false);
                    break;
            }
            bool = valueOf;
        } else if (i != intValue + 1 && i != intValue + 2) {
            valueOf = Boolean.valueOf(true);
            bool = Boolean.valueOf(false);
        } else if (bArr.length >= 9) {
            if (((bArr[8] >> 6) & 1) != 1) {
                z = false;
            }
            valueOf = Boolean.valueOf(z);
            bool = valueOf;
        } else {
            valueOf = null;
        }
        return bool == null ? "?" : (bool.booleanValue() && valueOf.booleanValue()) ? "*" : bool.booleanValue() ? "x" : valueOf.booleanValue() ? "+" : ".";
    }

    private static String m773a(MifareUltralight mifareUltralight, bb bbVar) {
        String str;
        if (bbVar == bb.NTAG21x) {
            str = "04494E1A386D3D3CFE3DC10E5DE68A499B1C202DB5B132393E89ED19FE5BE8BC61";
        } else if (bbVar != bb.ULTRALIGHT_EV1) {
            return null;
        } else {
            str = "0490933BDCD6E99B4E255E3DA55389A827564E11718E017292FAF23226A96614B8";
        }
        return C0353f.m1051a(str, mifareUltralight.transceive(new byte[]{(byte) 60, (byte) 0}), mifareUltralight.getTag().getId());
    }

    private static String m774a(C0300h c0300h, C0302j c0302j) {
        int i = 1;
        if (c0300h == null) {
            return null;
        }
        C0428i c0428i = new C0428i();
        int i2 = (c0300h.f783e == null || c0300h.f783e.length <= 0) ? 0 : 1;
        int i3 = (c0300h.f779a == null || c0300h.f779a.length <= 0) ? 0 : 1;
        if (i3 != 0) {
            for (int i4 = 0; i4 < c0300h.f779a.length; i4++) {
                byte[] bArr = c0300h.f779a[i4];
                if (bArr != null && bArr.length >= 3) {
                    int a = C0429j.m1389a(bArr[2], bArr[1], bArr[0]);
                    c0428i.m1387b(C0358k.f1076c);
                    if (i2 != 0) {
                        c0428i.m1387b("AFC counter");
                    } else {
                        c0428i.m1387b("Counter");
                    }
                    c0428i.m1387b(String.format(" #%d: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(a)}));
                    c0428i.m1387b("<hexoutput> (");
                    c0428i.m1387b(String.format("0x%02X%02X%02X", new Object[]{Byte.valueOf(bArr[2]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[0])}));
                    c0428i.m1387b(")</hexoutput>");
                    C0293a.m776a(c0428i, c0300h.f780b[i4]);
                    c0428i.m1383a();
                }
            }
        }
        if (i2 != 0) {
            byte[] bArr2 = c0300h.f783e;
            int a2 = C0429j.m1389a(bArr2[2], bArr2[1], bArr2[0]);
            if (i3 != 0) {
                c0428i.m1387b(C0358k.f1076c);
                c0428i.m1387b("NFC counter");
            } else {
                c0428i.m1387b("NFC counter value");
            }
            c0428i.m1387b(String.format(": %d", new Object[]{Integer.valueOf(a2)}));
            c0428i.m1387b("<hexoutput> (");
            c0428i.m1387b(String.format("0x%02X%02X%02X", new Object[]{Byte.valueOf(bArr2[2]), Byte.valueOf(bArr2[1]), Byte.valueOf(bArr2[0])}));
            c0428i.m1387b(")</hexoutput>");
            C0293a.m776a(c0428i, c0300h.f784f);
            c0428i.m1383a();
            i = i2;
        } else if (c0302j == C0302j.UC4 || c0302j == C0302j.UC5) {
            if (i3 != 0) {
                c0428i.m1387b(C0358k.f1076c);
            }
            c0428i.m1387b("NFC counter: ");
            if (c0300h.f781c == Boolean.TRUE) {
                c0428i.m1387b("protected");
            } else if (c0300h.f781c == Boolean.FALSE) {
                c0428i.m1387b("disabled");
            } else {
                c0428i.m1387b("inaccessible");
            }
            C0293a.m776a(c0428i, c0300h.f784f);
            c0428i.m1383a();
        } else {
            i = i2;
        }
        if (i3 == 0 && r1 == 0) {
            return BuildConfig.VERSION_NAME;
        }
        String str = "Counter values:\n";
        if (i3 != 0 && r1 == 0) {
            str = "AFC counter values:\n";
        } else if (i3 == 0) {
            str = BuildConfig.VERSION_NAME;
        }
        return str + c0428i.toString();
    }

    public static void m775a(az azVar) {
        azVar.f545o = C0293a.m773a(azVar.f541k, azVar.f544n);
        azVar.f546p = C0293a.m780a(azVar.f541k, azVar.a);
        azVar.f547q = C0293a.m789d(azVar);
        if (azVar.f544n == bb.ULTRALIGHT_EV1 && azVar.f549s != C0302j.UC0) {
            azVar.f548r = C0293a.m782b(azVar.f541k);
        }
    }

    private static void m776a(C0428i c0428i, byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            c0428i.m1387b(" (");
            if (bArr[0] == -67) {
                c0428i.m1387b("no tearing");
            } else {
                c0428i.m1387b("tearing occurred");
            }
            c0428i.m1387b("<hexoutput>: ");
            c0428i.m1387b(String.format("0x%02X", new Object[]{Byte.valueOf(bArr[0])}));
            c0428i.m1387b("</hexoutput>)");
        }
    }

    public static byte[] m777a(MifareUltralight mifareUltralight) {
        return mifareUltralight.transceive(new byte[]{(byte) 96});
    }

    private static byte[] m778a(MifareUltralight mifareUltralight, int i) {
        byte[] bArr = null;
        try {
            bArr = mifareUltralight.transceive(new byte[]{(byte) 57, (byte) i});
        } catch (IOException e) {
            C0293a.m788c(mifareUltralight);
        }
        return bArr;
    }

    private static byte[] m779a(MifareUltralight mifareUltralight, int i, int i2) {
        return mifareUltralight.transceive(new byte[]{(byte) 58, (byte) i, (byte) i2});
    }

    private static byte[] m780a(MifareUltralight mifareUltralight, byte[] bArr) {
        int i = 0;
        Integer num = (Integer) f754e.get(C0293a.m770a(bArr));
        int i2 = C0293a.m770a(bArr) == C0301i.MS0 ? 2 : 3;
        byte[] bArr2 = new byte[0];
        if (num != null) {
            while (i < i2) {
                try {
                    byte[] a = C0429j.m1398a(bArr2, C0293a.m779a(mifareUltralight, num.intValue() + i, num.intValue() + i));
                    i++;
                    bArr2 = a;
                } catch (IOException e) {
                    return bArr2;
                }
            }
        }
        return bArr2;
    }

    private static String m782b(MifareUltralight mifareUltralight) {
        Arrays.fill(new byte[21], (byte) 75);
        try {
            return String.format("0x%02X", new Object[]{Byte.valueOf(mifareUltralight.transceive(new byte[21])[0])});
        } catch (IOException e) {
            C0293a.m788c(mifareUltralight);
            return "[not accessible]";
        }
    }

    public static String m783b(az azVar) {
        C0302j c0302j = azVar.f549s;
        CharSequence a = C0293a.m774a(azVar.f547q, c0302j);
        C0428i c0428i = new C0428i();
        byte[] bArr = azVar.f546p;
        int i = C0293a.m770a(azVar.a) == C0301i.MS0 ? 0 : 4;
        if (bArr != null && bArr.length > i + 6) {
            int i2 = (bArr[i] >> 6) & 3;
            int i3 = (bArr[i] >> 4) & 3;
            int i4 = (bArr[i] >> 3) & 1;
            int i5 = (bArr[i] >> 2) & 1;
            int i6 = bArr[i] & 3;
            int i7 = bArr[i + 2] & MotionEventCompat.ACTION_MASK;
            int i8 = (bArr[i + 4] >> 6) & 1;
            int i9 = bArr[i + 4] & 7;
            if (c0302j == C0302j.UC3 || c0302j == C0302j.UC4 || c0302j == C0302j.UC5) {
                if (i2 != 0) {
                    int i10;
                    switch (i2) {
                        case C0519c.Switch_track /*1*/:
                            c0428i.m1384a((CharSequence) "UID ASCII mirror enabled:");
                            i10 = 14;
                            break;
                        case C0519c.Switch_textOn /*2*/:
                            if (c0302j != C0302j.UC3) {
                                c0428i.m1384a((CharSequence) "NFC counter ASCII mirror enabled:");
                                i10 = 6;
                                break;
                            }
                            c0428i.m1384a(C0429j.m1391a((CharSequence) "UID ASCII mirror enabled:"));
                            i10 = 14;
                            break;
                        case C0519c.Switch_textOff /*3*/:
                            if (c0302j != C0302j.UC3) {
                                c0428i.m1384a(C0429j.m1391a((CharSequence) "UID & NFC counter ASCII mirror enabled:"));
                                i10 = 21;
                                break;
                            }
                            c0428i.m1384a(C0429j.m1391a((CharSequence) "UID ASCII mirror enabled:"));
                            i10 = 14;
                            break;
                        default:
                            i10 = 0;
                            break;
                    }
                    c0428i.m1387b(C0358k.f1076c);
                    c0428i.m1384a(String.format("Page 0x%02X, byte offset %d", new Object[]{Integer.valueOf(i7), Integer.valueOf(i3)}));
                    Integer num = (Integer) f754e.get(C0293a.m770a(azVar.a));
                    i2 = (i10 % 4 == 0 ? 0 : 1) + (i10 / 4);
                    i10 = ((i10 + i3) % 4 == 0 ? 0 : 1) + ((i10 + i3) / 4);
                    if (i7 < 4) {
                        c0428i.m1384a(C0358k.f1076c + "ERROR: mirror page address should be at least 4");
                    } else if (i7 > num.intValue() - i2) {
                        c0428i.m1384a(C0358k.f1076c + "ERROR: mirror page address too high");
                    } else if (i7 == num.intValue() - i2 && i7 > num.intValue() - i10) {
                        c0428i.m1384a(C0358k.f1076c + "ERROR: mirror byte offset too large");
                    }
                } else {
                    if (c0302j == C0302j.UC3) {
                        c0428i.m1387b("UID ");
                    }
                    c0428i.m1384a((CharSequence) "ASCII mirror disabled");
                }
            }
            if (!TextUtils.isEmpty(a)) {
                c0428i.m1384a(a);
            }
            if (c0302j != null) {
                switch (C0299g.f776a[c0302j.ordinal()]) {
                    case C0519c.Switch_track /*1*/:
                    case C0519c.Switch_textOn /*2*/:
                    case C0519c.Switch_textOff /*3*/:
                    case C0519c.Switch_thumbTextPadding /*4*/:
                    case C0519c.Switch_switchTextAppearance /*5*/:
                        if (i9 <= 0) {
                            c0428i.m1384a((CharSequence) "No limit on wrong password attempts");
                            break;
                        }
                        c0428i.m1384a(String.format("Wrong password attempts allowed: %d", new Object[]{Integer.valueOf(i9)}));
                        break;
                }
            }
            if (i5 == 1) {
                c0428i.m1384a((CharSequence) "Strong load modulation enabled");
            } else {
                c0428i.m1384a((CharSequence) "Strong load modulation disabled");
            }
            if (c0302j == C0302j.UC6) {
                switch (i6) {
                    case C0519c.Switch_track /*1*/:
                        c0428i.m1384a((CharSequence) "Field detection triggered by data reception");
                        break;
                    case C0519c.Switch_textOn /*2*/:
                        c0428i.m1384a((CharSequence) "Field detection triggered by tag activation");
                        break;
                    case C0519c.Switch_textOff /*3*/:
                        c0428i.m1384a((CharSequence) "Field detection triggered by field presence");
                        break;
                    default:
                        c0428i.m1384a((CharSequence) "Field detection disabled");
                        break;
                }
                if (i4 == 1) {
                    c0428i.m1384a((CharSequence) "Sleep mode enabled");
                } else {
                    c0428i.m1384a((CharSequence) "Sleep mode disabled");
                }
            }
            if (i8 == 1) {
                c0428i.m1384a((CharSequence) "Configuration locked");
            }
        } else if (!TextUtils.isEmpty(a)) {
            c0428i.m1384a(a);
        }
        return c0428i.toString();
    }

    private static byte[] m784b(MifareUltralight mifareUltralight, int i) {
        byte[] bArr = null;
        try {
            bArr = mifareUltralight.transceive(new byte[]{(byte) 62, (byte) i});
        } catch (IOException e) {
            C0293a.m788c(mifareUltralight);
        }
        return bArr;
    }

    private static byte[] m785b(MifareUltralight mifareUltralight, byte[] bArr) {
        if (bArr == null || bArr.length != 4) {
            return null;
        }
        Object obj = new byte[(bArr.length + 1)];
        obj[0] = (byte) 27;
        System.arraycopy(bArr, 0, obj, 1, bArr.length);
        return mifareUltralight.transceive(obj);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.nxp.taginfolite.p005b.C0182c m786c(com.nxp.taginfolite.p009e.az r25) {
        /*
        r2 = "\n  *:locked & blocked, x:locked,\n  +:blocked, .:un(b)locked, ?:unknown\n  r:readable (write-protected),\n  p:password protected, -:write-only\n  P:password protected write-only";
        r0 = r25;
        r2 = r0.f541k;
        r0 = r25;
        r0 = r0.f544n;
        r20 = r0;
        r4 = 0;
        r0 = r25;
        r3 = r0.a;
        r21 = com.nxp.taginfolite.p009e.p014e.C0293a.m770a(r3);
        r3 = f754e;
        r0 = r21;
        r3 = r3.get(r0);
        r3 = (java.lang.Integer) r3;
        r10 = r3.intValue();
        r3 = r10 + 5;
        r5 = com.nxp.taginfolite.p009e.p014e.C0301i.MS0;
        r0 = r21;
        if (r0 != r5) goto L_0x00eb;
    L_0x002b:
        r0 = r25;
        r3 = r0.f549s;
        r5 = com.nxp.taginfolite.p009e.p014e.C0302j.UC0;
        if (r3 != r5) goto L_0x00e6;
    L_0x0033:
        r3 = 15;
        r4 = 1;
        r9 = r4;
    L_0x0037:
        r16 = "";
        r4 = r3 + 1;
        r4 = r4 * 4;
        r0 = new int[r4];
        r22 = r0;
        r4 = -1;
        r0 = r22;
        java.util.Arrays.fill(r0, r4);
        r12 = 0;
        r11 = 4;
        r15 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r4 = 0;
        r8 = "r";
        r5 = 0;
        r14 = r2.readPages(r5);	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r4 = 1;
        r5 = 4;
        r5 = new int[r5];	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r6 = 0;
        r7 = 0;
        r7 = r14[r7];	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r7 = r7 & 255;
        r5[r6] = r7;	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r6 = 1;
        r7 = 1;
        r7 = r14[r7];	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r7 = r7 & 255;
        r5[r6] = r7;	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r6 = 2;
        r7 = 2;
        r7 = r14[r7];	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r7 = r7 & 255;
        r5[r6] = r7;	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r6 = 3;
        r7 = 3;
        r7 = r14[r7];	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r7 = r7 & 255;
        r5[r6] = r7;	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r6 = 4;
        r6 = new int[r6];	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r7 = 0;
        r13 = 4;
        r13 = r14[r13];	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r13 = r13 & 255;
        r6[r7] = r13;	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r7 = 1;
        r13 = 5;
        r13 = r14[r13];	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r13 = r13 & 255;
        r6[r7] = r13;	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r7 = 2;
        r13 = 6;
        r13 = r14[r13];	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r13 = r13 & 255;
        r6[r7] = r13;	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r7 = 3;
        r13 = 7;
        r13 = r14[r13];	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r13 = r13 & 255;
        r6[r7] = r13;	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r7 = 4;
        r7 = new int[r7];	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r13 = 0;
        r17 = 8;
        r17 = r14[r17];	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r0 = r17;
        r0 = r0 & 255;
        r17 = r0;
        r7[r13] = r17;	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r13 = 1;
        r17 = 9;
        r17 = r14[r17];	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r0 = r17;
        r0 = r0 & 255;
        r17 = r0;
        r7[r13] = r17;	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r13 = 2;
        r17 = 10;
        r17 = r14[r17];	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r0 = r17;
        r0 = r0 & 255;
        r17 = r0;
        r7[r13] = r17;	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r13 = 3;
        r17 = 11;
        r17 = r14[r17];	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r0 = r17;
        r0 = r0 & 255;
        r17 = r0;
        r7[r13] = r17;	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r13 = 0;
    L_0x00d2:
        r0 = r14.length;	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r17 = r0;
        r0 = r17;
        if (r13 >= r0) goto L_0x0106;
    L_0x00d9:
        r17 = r14[r13];	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r0 = r17;
        r0 = r0 & 255;
        r17 = r0;
        r22[r13] = r17;	 Catch:{ TagLostException -> 0x063f, IOException -> 0x0206 }
        r13 = r13 + 1;
        goto L_0x00d2;
    L_0x00e6:
        r3 = 19;
        r9 = r4;
        goto L_0x0037;
    L_0x00eb:
        r5 = com.nxp.taginfolite.p009e.p014e.C0301i.UNKNOWN;
        r0 = r21;
        if (r0 != r5) goto L_0x0691;
    L_0x00f1:
        r0 = r25;
        r3 = r0.a;
        r3 = com.nxp.taginfolite.p004f.C0372z.m1118d(r3);
        r3 = r3.intValue();
        r3 = r3 / 4;
        r3 = r3 + 3;
        r3 = r3 + 5;
        r9 = r4;
        goto L_0x0037;
    L_0x0106:
        if (r9 == 0) goto L_0x0130;
    L_0x0108:
        r14 = 4;
        r13 = r15;
    L_0x010a:
        if (r14 >= r3) goto L_0x068e;
    L_0x010c:
        r18 = r2.readPages(r14);	 Catch:{ TagLostException -> 0x0137, IOException -> 0x0185 }
        r4 = r4 + 1;
        r17 = 0;
    L_0x0114:
        r0 = r18;
        r0 = r0.length;	 Catch:{ TagLostException -> 0x0137, IOException -> 0x0185 }
        r19 = r0;
        r0 = r17;
        r1 = r19;
        if (r0 >= r1) goto L_0x0132;
    L_0x011f:
        r19 = r14 * 4;
        r19 = r19 + r17;
        r23 = r18[r17];	 Catch:{ TagLostException -> 0x0137, IOException -> 0x0185 }
        r0 = r23;
        r0 = r0 & 255;
        r23 = r0;
        r22[r19] = r23;	 Catch:{ TagLostException -> 0x0137, IOException -> 0x0185 }
        r17 = r17 + 1;
        goto L_0x0114;
    L_0x0130:
        r3 = r10;
        goto L_0x0108;
    L_0x0132:
        r13 = r14 + 4;
        r14 = r14 + 4;
        goto L_0x010a;
    L_0x0137:
        r3 = move-exception;
        throw r3;	 Catch:{ TagLostException -> 0x0139, IOException -> 0x0615 }
    L_0x0139:
        r3 = move-exception;
        r3 = r8;
        r8 = r13;
    L_0x013c:
        r5 = 1;
        r0 = r25;
        r0.f542l = r5;
        r15 = r4 * 4;
        r4 = "\n<aborted: tag disappeared>";
        r14 = r15;
        r18 = r11;
        r19 = r12;
        r16 = r4;
        r4 = r8;
    L_0x014d:
        if (r19 == 0) goto L_0x067e;
    L_0x014f:
        r3 = com.nxp.taginfolite.p009e.p014e.C0301i.MS0;
        r0 = r21;
        if (r0 != r3) goto L_0x0216;
    L_0x0155:
        r3 = 1;
    L_0x0156:
        r0 = r18;
        if (r0 <= r3) goto L_0x0233;
    L_0x015a:
        r3 = com.nxp.taginfolite.p009e.p014e.C0301i.MS0;
        r0 = r21;
        if (r0 != r3) goto L_0x021d;
    L_0x0160:
        r3 = 3;
        r3 = r19[r3];
        r4 = r3 & 255;
        r3 = 4;
        r3 = r19[r3];
        r3 = r3 & 128;
        if (r3 != 0) goto L_0x0219;
    L_0x016c:
        r3 = "r";
    L_0x016e:
        r11 = r3;
        r12 = r4;
    L_0x0170:
        r15 = new com.nxp.taginfolite.b.c;
        r15.<init>();
        if (r14 > 0) goto L_0x023b;
    L_0x0177:
        r2 = new com.nxp.taginfolite.b.o;
        r3 = com.nxp.taginfolite.p003g.C0429j.m1391a(r16);
        r2.<init>(r3);
        r15.m147a(r2);
        r2 = r15;
    L_0x0184:
        return r2;
    L_0x0185:
        r3 = move-exception;
        r3 = "p";
        r2.close();	 Catch:{ TagLostException -> 0x0649, IOException -> 0x061d }
        r2.connect();	 Catch:{ TagLostException -> 0x0649, IOException -> 0x061d }
        r8 = r3;
        r13 = r14;
        r14 = r4;
    L_0x0191:
        r3 = r14 + -1;
        r18 = r3 * 16;
        r3 = r18 + 16;
        r0 = r22;
        r1 = r18;
        r4 = java.util.Arrays.copyOfRange(r0, r1, r3);	 Catch:{ TagLostException -> 0x064d, IOException -> 0x0622 }
        r3 = r18 / 4;
        r17 = com.nxp.taginfolite.p009e.p014e.C0304l.m818a(r2, r3, r4, r5, r6, r7);	 Catch:{ TagLostException -> 0x064d, IOException -> 0x0622 }
        r3 = 4;
        r0 = r17;
        if (r0 >= r3) goto L_0x0687;
    L_0x01aa:
        r3 = 4 - r17;
        r4 = r13 - r3;
        r3 = "p";
        r8 = r17;
    L_0x01b2:
        r13 = 4;
        if (r8 >= r13) goto L_0x01c0;
    L_0x01b5:
        r13 = r8 * 4;
        r13 = r13 + r18;
        r17 = -1;
        r22[r13] = r17;	 Catch:{ TagLostException -> 0x0659, IOException -> 0x062c }
        r8 = r8 + 1;
        goto L_0x01b2;
    L_0x01c0:
        r13 = r3;
        r8 = r4;
    L_0x01c2:
        if (r8 < r10) goto L_0x0682;
    L_0x01c4:
        if (r9 != 0) goto L_0x0682;
    L_0x01c6:
        r12 = r2.readPages(r10);	 Catch:{ TagLostException -> 0x01f3, IOException -> 0x01fa }
        r3 = r12.length;	 Catch:{ TagLostException -> 0x01f3, IOException -> 0x0665 }
        r4 = new int[r3];	 Catch:{ TagLostException -> 0x01f3, IOException -> 0x0665 }
        r3 = 0;
    L_0x01ce:
        r0 = r12.length;	 Catch:{ TagLostException -> 0x01f3, IOException -> 0x0665 }
        r17 = r0;
        r0 = r17;
        if (r3 >= r0) goto L_0x01e2;
    L_0x01d5:
        r17 = r12[r3];	 Catch:{ TagLostException -> 0x01f3, IOException -> 0x0665 }
        r0 = r17;
        r0 = r0 & 255;
        r17 = r0;
        r4[r3] = r17;	 Catch:{ TagLostException -> 0x01f3, IOException -> 0x0665 }
        r3 = r3 + 1;
        goto L_0x01ce;
    L_0x01e2:
        r3 = r10;
        r3 = com.nxp.taginfolite.p009e.p014e.C0304l.m818a(r2, r3, r4, r5, r6, r7);	 Catch:{ TagLostException -> 0x01f3, IOException -> 0x0665 }
        r4 = r3;
        r5 = r12;
        r3 = r8;
    L_0x01ea:
        r14 = r15;
        r18 = r4;
        r19 = r5;
        r4 = r3;
        r3 = r13;
        goto L_0x014d;
    L_0x01f3:
        r3 = move-exception;
        throw r3;	 Catch:{ TagLostException -> 0x01f5, IOException -> 0x0632 }
    L_0x01f5:
        r3 = move-exception;
        r3 = r13;
        r4 = r14;
        goto L_0x013c;
    L_0x01fa:
        r3 = move-exception;
        r3 = r12;
    L_0x01fc:
        r2.close();	 Catch:{ TagLostException -> 0x065e, IOException -> 0x0638 }
        r2.connect();	 Catch:{ TagLostException -> 0x065e, IOException -> 0x0638 }
        r4 = r11;
        r5 = r3;
        r3 = r10;
        goto L_0x01ea;
    L_0x0206:
        r3 = move-exception;
    L_0x0207:
        r3 = r4 * 4;
        r4 = "\n<aborted: read error>";
        r14 = r3;
        r18 = r11;
        r19 = r12;
        r16 = r4;
        r4 = r15;
        r3 = r8;
        goto L_0x014d;
    L_0x0216:
        r3 = 2;
        goto L_0x0156;
    L_0x0219:
        r3 = "p";
        goto L_0x016e;
    L_0x021d:
        r3 = 7;
        r3 = r19[r3];
        r4 = r3 & 255;
        r3 = 8;
        r3 = r19[r3];
        r3 = r3 & 128;
        if (r3 != 0) goto L_0x0230;
    L_0x022a:
        r3 = "r";
    L_0x022c:
        r11 = r3;
        r12 = r4;
        goto L_0x0170;
    L_0x0230:
        r3 = "p";
        goto L_0x022c;
    L_0x0233:
        r4 = r10 + r18;
        r3 = "p";
        r11 = r3;
        r12 = r4;
        goto L_0x0170;
    L_0x023b:
        r3 = "(UID0-UID2, BCC0)";
        r4 = 0;
        r4 = r22[r4];
        r4 = r4 ^ 136;
        r5 = 1;
        r5 = r22[r5];
        r4 = r4 ^ r5;
        r5 = 2;
        r5 = r22[r5];
        r4 = r4 ^ r5;
        r5 = 3;
        r5 = r22[r5];
        r4 = r4 ^ r5;
        r4 = r4 & 255;
        if (r4 == 0) goto L_0x0265;
    L_0x0252:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r3 = r4.append(r3);
        r4 = " CRC error";
        r3 = r3.append(r4);
        r3 = r3.toString();
    L_0x0265:
        r4 = new com.nxp.taginfolite.b.p;
        r5 = 0;
        r6 = "* ";
        r7 = 0;
        r8 = 4;
        r0 = r22;
        r7 = java.util.Arrays.copyOfRange(r0, r7, r8);
        r7 = com.nxp.taginfolite.p003g.C0422a.m1361a(r7);
        r4.<init>(r5, r6, r7, r3);
        r15.m147a(r4);
        r3 = "(UID3-UID6)";
        r4 = 4;
        r4 = r22[r4];
        r5 = 5;
        r5 = r22[r5];
        r4 = r4 ^ r5;
        r5 = 6;
        r5 = r22[r5];
        r4 = r4 ^ r5;
        r5 = 7;
        r5 = r22[r5];
        r4 = r4 ^ r5;
        r5 = 8;
        r5 = r22[r5];
        r4 = r4 ^ r5;
        r4 = r4 & 255;
        if (r4 == 0) goto L_0x02a9;
    L_0x0296:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r3 = r4.append(r3);
        r4 = " CRC error";
        r3 = r3.append(r4);
        r3 = r3.toString();
    L_0x02a9:
        r4 = new com.nxp.taginfolite.b.p;
        r5 = 1;
        r6 = "* ";
        r7 = 4;
        r8 = 8;
        r0 = r22;
        r7 = java.util.Arrays.copyOfRange(r0, r7, r8);
        r7 = com.nxp.taginfolite.p003g.C0422a.m1361a(r7);
        r4.<init>(r5, r6, r7, r3);
        r15.m147a(r4);
        r3 = 10;
        r3 = r22[r3];
        r3 = r3 & 255;
        r0 = (byte) r3;
        r17 = r0;
        r3 = 11;
        r3 = r22[r3];
        r3 = r3 & 255;
        r0 = (byte) r3;
        r23 = r0;
        r3 = r17 & 7;
        r4 = 7;
        if (r3 != r4) goto L_0x0341;
    L_0x02d8:
        r3 = "* ";
    L_0x02da:
        r4 = new com.nxp.taginfolite.b.p;
        r5 = 2;
        r6 = 8;
        r7 = 12;
        r0 = r22;
        r6 = java.util.Arrays.copyOfRange(r0, r6, r7);
        r6 = com.nxp.taginfolite.p003g.C0422a.m1361a(r6);
        r7 = "(BCC1, INT, LOCK0-LOCK1)";
        r4.<init>(r5, r3, r6, r7);
        r15.m147a(r4);
        r3 = r17 & 8;
        if (r3 == 0) goto L_0x0356;
    L_0x02f7:
        r3 = r17 & 1;
        if (r3 == 0) goto L_0x0352;
    L_0x02fb:
        r3 = "*";
        r5 = r3;
    L_0x02fe:
        r3 = " ";
        r4 = 3;
        if (r4 < r12) goto L_0x067b;
    L_0x0303:
        r13 = r11;
    L_0x0304:
        r3 = "p";
        r3 = r3.equals(r13);
        if (r3 == 0) goto L_0x0362;
    L_0x030c:
        r3 = new com.nxp.taginfolite.b.p;
        r4 = 3;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r6 = "p";
        r5 = r5.append(r6);
        r5 = r5.toString();
        r6 = 1;
        r7 = 4;
        r8 = "(OTP0-OTP3)";
        r3.<init>(r4, r5, r6, r7, r8);
        r15.m147a(r3);
    L_0x032c:
        r4 = 4;
        r5 = r13;
    L_0x032e:
        if (r4 >= r10) goto L_0x0426;
    L_0x0330:
        if (r4 < r14) goto L_0x038d;
    L_0x0332:
        r2 = new com.nxp.taginfolite.b.o;
        r3 = com.nxp.taginfolite.p003g.C0429j.m1391a(r16);
        r2.<init>(r3);
        r15.m147a(r2);
        r2 = r15;
        goto L_0x0184;
    L_0x0341:
        if (r17 != 0) goto L_0x0348;
    L_0x0343:
        if (r23 != 0) goto L_0x0348;
    L_0x0345:
        r3 = ". ";
        goto L_0x02da;
    L_0x0348:
        r3 = r17 & 7;
        if (r3 != 0) goto L_0x034f;
    L_0x034c:
        r3 = "x ";
        goto L_0x02da;
    L_0x034f:
        r3 = "+ ";
        goto L_0x02da;
    L_0x0352:
        r3 = "x";
        r5 = r3;
        goto L_0x02fe;
    L_0x0356:
        r3 = r17 & 1;
        if (r3 == 0) goto L_0x035e;
    L_0x035a:
        r3 = "+";
        r5 = r3;
        goto L_0x02fe;
    L_0x035e:
        r3 = ".";
        r5 = r3;
        goto L_0x02fe;
    L_0x0362:
        r3 = new com.nxp.taginfolite.b.p;
        r4 = 3;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r5 = r5.append(r13);
        r5 = r5.toString();
        r6 = 12;
        r7 = 16;
        r0 = r22;
        r6 = java.util.Arrays.copyOfRange(r0, r6, r7);
        r6 = com.nxp.taginfolite.p003g.C0422a.m1361a(r6);
        r7 = "(OTP0-OTP3)";
        r3.<init>(r4, r5, r6, r7);
        r15.m147a(r3);
        goto L_0x032c;
    L_0x038d:
        r3 = 16;
        if (r4 >= r3) goto L_0x03ce;
    L_0x0391:
        r3 = r4 / 4;
        r0 = r17;
        r1 = r23;
        r3 = com.nxp.taginfolite.p009e.C0253s.m522a(r3, r0, r1);
        r5 = r4 % 4;
        r3 = r3[r5];
        r5 = r3;
    L_0x03a0:
        r3 = " ";
        if (r4 < r12) goto L_0x0678;
    L_0x03a4:
        r13 = r11;
    L_0x03a5:
        r3 = "p";
        r3 = r3.equals(r13);
        if (r3 == 0) goto L_0x03d8;
    L_0x03ad:
        r3 = new com.nxp.taginfolite.b.p;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r5 = r5.append(r13);
        r5 = r5.toString();
        r6 = 1;
        r7 = 4;
        r8 = 0;
        r3.<init>(r4, r5, r6, r7, r8);
        r15.m147a(r3);
    L_0x03c9:
        r4 = r4 + 1;
        r5 = r13;
        goto L_0x032e;
    L_0x03ce:
        r0 = r19;
        r1 = r21;
        r3 = com.nxp.taginfolite.p009e.p014e.C0293a.m772a(r4, r0, r1);
        r5 = r3;
        goto L_0x03a0;
    L_0x03d8:
        r3 = r4 * 4;
        r3 = r22[r3];
        r6 = -1;
        if (r3 == r6) goto L_0x0409;
    L_0x03df:
        r3 = r4 * 4;
        r6 = r4 * 4;
        r6 = r6 + 4;
        r0 = r22;
        r3 = java.util.Arrays.copyOfRange(r0, r3, r6);
        r3 = com.nxp.taginfolite.p003g.C0422a.m1361a(r3);
        r6 = new com.nxp.taginfolite.b.p;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r5 = r7.append(r5);
        r5 = r5.append(r13);
        r5 = r5.toString();
        r6.<init>(r4, r5, r3);
        r15.m147a(r6);
        goto L_0x03c9;
    L_0x0409:
        r3 = new com.nxp.taginfolite.b.p;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r5 = r5.append(r13);
        r5 = r5.toString();
        r6 = 0;
        r7 = 4;
        r8 = 0;
        r3.<init>(r4, r5, r6, r7, r8);
        r15.m147a(r3);
        goto L_0x03c9;
    L_0x0426:
        r3 = 5;
        r4 = new java.lang.String[r3];
        r3 = 0;
        r6 = "(LOCK2-LOCK4, CHK)";
        r4[r3] = r6;
        r3 = 1;
        r6 = "(AUTH0)";
        r4[r3] = r6;
        r3 = 2;
        r6 = "(ACCESS, VCTID)";
        r4[r3] = r6;
        r3 = 3;
        r6 = "(PWD0-PWD3)";
        r4[r3] = r6;
        r3 = 4;
        r6 = "(PACK0-PACK1)";
        r4[r3] = r6;
        r3 = 5;
        r3 = new int[r3];
        r3 = {4, 1, 2, 4, 2};
        r6 = com.nxp.taginfolite.p009e.bb.NTAG21x;
        r0 = r20;
        if (r0 != r6) goto L_0x0674;
    L_0x044e:
        r3 = 5;
        r4 = new java.lang.String[r3];
        r3 = 0;
        r6 = "(LOCK2-LOCK4, CHK)";
        r4[r3] = r6;
        r3 = 1;
        r6 = "(CFG, MIRROR, AUTH0)";
        r4[r3] = r6;
        r3 = 2;
        r6 = "(ACCESS)";
        r4[r3] = r6;
        r3 = 3;
        r6 = "(PWD0-PWD3)";
        r4[r3] = r6;
        r3 = 4;
        r6 = "(PACK0-PACK1)";
        r4[r3] = r6;
        r3 = 5;
        r3 = new int[r3];
        r3 = {4, 4, 2, 4, 2};
        r13 = r3;
        r14 = r4;
    L_0x0472:
        r3 = com.nxp.taginfolite.p009e.p014e.C0301i.MS0;
        r0 = r21;
        if (r0 != r3) goto L_0x049a;
    L_0x0478:
        r17 = 1;
    L_0x047a:
        if (r19 == 0) goto L_0x05db;
    L_0x047c:
        r0 = r19;
        r3 = r0.length;
        r4 = 16;
        if (r3 < r4) goto L_0x05db;
    L_0x0483:
        r3 = com.nxp.taginfolite.p009e.p014e.C0301i.MS0;
        r0 = r21;
        if (r0 != r3) goto L_0x049d;
    L_0x0489:
        r3 = 0;
    L_0x048a:
        r4 = 8;
        if (r3 >= r4) goto L_0x04ae;
    L_0x048e:
        r4 = r10 * 4;
        r4 = r4 + r3;
        r6 = r19[r3];
        r6 = r6 & 255;
        r22[r4] = r6;
        r3 = r3 + 1;
        goto L_0x048a;
    L_0x049a:
        r17 = 0;
        goto L_0x047a;
    L_0x049d:
        r3 = 0;
    L_0x049e:
        r4 = 12;
        if (r3 >= r4) goto L_0x04ae;
    L_0x04a2:
        r4 = r10 * 4;
        r4 = r4 + r3;
        r6 = r19[r3];
        r6 = r6 & 255;
        r22[r4] = r6;
        r3 = r3 + 1;
        goto L_0x049e;
    L_0x04ae:
        r16 = r17;
        r3 = r5;
    L_0x04b1:
        r4 = 3;
        r0 = r16;
        if (r0 >= r4) goto L_0x0539;
    L_0x04b6:
        r4 = r10 + r16;
        r4 = r4 - r17;
        r0 = r19;
        r1 = r21;
        r5 = com.nxp.taginfolite.p009e.p014e.C0293a.m772a(r4, r0, r1);
        if (r4 < r12) goto L_0x0671;
    L_0x04c4:
        r9 = r11;
    L_0x04c5:
        r3 = "p";
        r3 = r3.equals(r9);
        if (r3 != 0) goto L_0x04d3;
    L_0x04cd:
        r0 = r16;
        r1 = r18;
        if (r0 < r1) goto L_0x04f7;
    L_0x04d3:
        r3 = new com.nxp.taginfolite.b.p;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r5 = r5.append(r9);
        r5 = r5.toString();
        r6 = 1;
        r7 = r13[r16];
        r8 = r14[r16];
        r3.<init>(r4, r5, r6, r7, r8);
        r15.m147a(r3);
    L_0x04f1:
        r3 = r16 + 1;
        r16 = r3;
        r3 = r9;
        goto L_0x04b1;
    L_0x04f7:
        r3 = 2;
        r0 = r16;
        if (r0 != r3) goto L_0x0528;
    L_0x04fc:
        r3 = r4 * 4;
        r6 = r4 * 4;
        r6 = r6 + 2;
        r0 = r22;
        r3 = java.util.Arrays.copyOfRange(r0, r3, r6);
        r3 = com.nxp.taginfolite.p003g.C0422a.m1361a(r3);
    L_0x050c:
        r6 = new com.nxp.taginfolite.b.p;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r5 = r7.append(r5);
        r5 = r5.append(r9);
        r5 = r5.toString();
        r7 = r14[r16];
        r6.<init>(r4, r5, r3, r7);
        r15.m147a(r6);
        goto L_0x04f1;
    L_0x0528:
        r3 = r4 * 4;
        r6 = r4 * 4;
        r6 = r6 + 4;
        r0 = r22;
        r3 = java.util.Arrays.copyOfRange(r0, r3, r6);
        r3 = com.nxp.taginfolite.p003g.C0422a.m1361a(r3);
        goto L_0x050c;
    L_0x0539:
        r4 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r5 = r10 + 2;
        r5 = r5 - r17;
        if (r5 < r12) goto L_0x0549;
    L_0x0541:
        r6 = "r";
        r3 = r6.equals(r3);
        if (r3 == 0) goto L_0x066e;
    L_0x0549:
        r3 = r5 * 4;
        r3 = r22[r3];
        r3 = r3 & 7;
    L_0x054f:
        r6 = 0;
        r5 = 0;
        r4 = 0;
        if (r3 != 0) goto L_0x0669;
    L_0x0554:
        r3 = com.nxp.taginfolite.p009e.p014e.C0293a.m792e(r25);
        r7 = r3.iterator();
    L_0x055c:
        r3 = r7.hasNext();
        if (r3 == 0) goto L_0x0669;
    L_0x0562:
        r3 = r7.next();
        r3 = (com.nxp.taginfolite.p004f.C0354g) r3;
        r8 = r3.m1062b();	 Catch:{ IOException -> 0x05ac }
        r2 = com.nxp.taginfolite.p009e.p014e.C0293a.m785b(r2, r8);	 Catch:{ IOException -> 0x05ac }
        r4 = 1;
    L_0x0571:
        if (r4 != 0) goto L_0x05b6;
    L_0x0573:
        r2 = r10 + 3;
        r3 = r2 - r17;
        r2 = new com.nxp.taginfolite.b.p;
        r4 = "+P";
        r5 = 1;
        r6 = 3;
        r6 = r13[r6];
        r7 = 3;
        r7 = r14[r7];
        r2.<init>(r3, r4, r5, r6, r7);
        r15.m147a(r2);
        r3 = r3 + 1;
        r2 = new com.nxp.taginfolite.b.p;
        r4 = "+P";
        r5 = 1;
        r6 = 4;
        r6 = r13[r6];
        r7 = 4;
        r7 = r14[r7];
        r2.<init>(r3, r4, r5, r6, r7);
        r15.m147a(r2);
    L_0x059b:
        r2 = new com.nxp.taginfolite.b.o;
        r3 = "\n  *:locked & blocked, x:locked,\n  +:blocked, .:un(b)locked, ?:unknown\n  r:readable (write-protected),\n  p:password protected, -:write-only\n  P:password protected write-only";
        r3 = com.nxp.taginfolite.p003g.C0429j.m1391a(r3);
        r2.<init>(r3);
        r15.m147a(r2);
        r2 = r15;
        goto L_0x0184;
    L_0x05ac:
        r3 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x05b4 }
        r2.connect();	 Catch:{ IOException -> 0x05b4 }
        goto L_0x055c;
    L_0x05b4:
        r3 = move-exception;
        goto L_0x055c;
    L_0x05b6:
        r4 = r10 + 3;
        r4 = r4 - r17;
        r5 = new com.nxp.taginfolite.b.p;
        r6 = "+P";
        r3 = r3.m1062b();
        r7 = 3;
        r7 = r14[r7];
        r5.<init>(r4, r6, r3, r7);
        r15.m147a(r5);
        r3 = r4 + 1;
        r4 = new com.nxp.taginfolite.b.p;
        r5 = "+P";
        r6 = 4;
        r6 = r14[r6];
        r4.<init>(r3, r5, r2, r6);
        r15.m147a(r4);
        goto L_0x059b;
    L_0x05db:
        if (r9 != 0) goto L_0x059b;
    L_0x05dd:
        r2 = 5;
        r9 = new java.lang.String[r2];
        r2 = 0;
        r3 = "?p";
        r9[r2] = r3;
        r2 = 1;
        r3 = "?p";
        r9[r2] = r3;
        r2 = 2;
        r3 = "?p";
        r9[r2] = r3;
        r2 = 3;
        r3 = "+P";
        r9[r2] = r3;
        r2 = 4;
        r3 = "+P";
        r9[r2] = r3;
        r2 = 0;
        r8 = r2;
    L_0x05fb:
        r2 = 5;
        if (r8 >= r2) goto L_0x059b;
    L_0x05fe:
        r2 = new com.nxp.taginfolite.b.p;
        r3 = r10 + r8;
        r3 = r3 - r17;
        r4 = r9[r8];
        r5 = 1;
        r6 = r13[r8];
        r7 = r14[r8];
        r2.<init>(r3, r4, r5, r6, r7);
        r15.m147a(r2);
        r2 = r8 + 1;
        r8 = r2;
        goto L_0x05fb;
    L_0x0615:
        r3 = move-exception;
        r15 = r13;
        goto L_0x0207;
    L_0x0619:
        r3 = move-exception;
        r15 = r14;
        goto L_0x0207;
    L_0x061d:
        r5 = move-exception;
        r8 = r3;
        r15 = r14;
        goto L_0x0207;
    L_0x0622:
        r3 = move-exception;
        r4 = r14;
        r15 = r13;
        goto L_0x0207;
    L_0x0627:
        r3 = move-exception;
        r15 = r4;
        r4 = r14;
        goto L_0x0207;
    L_0x062c:
        r5 = move-exception;
        r8 = r3;
        r15 = r4;
        r4 = r14;
        goto L_0x0207;
    L_0x0632:
        r3 = move-exception;
        r4 = r14;
        r15 = r8;
        r8 = r13;
        goto L_0x0207;
    L_0x0638:
        r4 = move-exception;
        r8 = r13;
        r4 = r14;
        r15 = r10;
        r12 = r3;
        goto L_0x0207;
    L_0x063f:
        r3 = move-exception;
        r3 = r8;
        r8 = r15;
        goto L_0x013c;
    L_0x0644:
        r3 = move-exception;
        r3 = r8;
        r8 = r14;
        goto L_0x013c;
    L_0x0649:
        r5 = move-exception;
        r8 = r14;
        goto L_0x013c;
    L_0x064d:
        r3 = move-exception;
        r3 = r8;
        r4 = r14;
        r8 = r13;
        goto L_0x013c;
    L_0x0653:
        r3 = move-exception;
        r3 = r8;
        r8 = r4;
        r4 = r14;
        goto L_0x013c;
    L_0x0659:
        r5 = move-exception;
        r8 = r4;
        r4 = r14;
        goto L_0x013c;
    L_0x065e:
        r4 = move-exception;
        r4 = r14;
        r8 = r10;
        r12 = r3;
        r3 = r13;
        goto L_0x013c;
    L_0x0665:
        r3 = move-exception;
        r3 = r12;
        goto L_0x01fc;
    L_0x0669:
        r3 = r4;
        r2 = r5;
        r4 = r6;
        goto L_0x0571;
    L_0x066e:
        r3 = r4;
        goto L_0x054f;
    L_0x0671:
        r9 = r3;
        goto L_0x04c5;
    L_0x0674:
        r13 = r3;
        r14 = r4;
        goto L_0x0472;
    L_0x0678:
        r13 = r3;
        goto L_0x03a5;
    L_0x067b:
        r13 = r3;
        goto L_0x0304;
    L_0x067e:
        r11 = r3;
        r12 = r4;
        goto L_0x0170;
    L_0x0682:
        r3 = r8;
        r4 = r11;
        r5 = r12;
        goto L_0x01ea;
    L_0x0687:
        r24 = r8;
        r8 = r13;
        r13 = r24;
        goto L_0x01c2;
    L_0x068e:
        r14 = r4;
        goto L_0x0191;
    L_0x0691:
        r9 = r4;
        goto L_0x0037;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.e.e.a.c(com.nxp.taginfolite.e.az):com.nxp.taginfolite.b.c");
    }

    private static void m788c(MifareUltralight mifareUltralight) {
        mifareUltralight.close();
        mifareUltralight.connect();
    }

    private static C0300h m789d(az azVar) {
        int i;
        int i2;
        C0300h c0300h = new C0300h();
        C0302j c0302j = azVar.f549s;
        switch (C0299g.f776a[c0302j.ordinal()]) {
            case C0519c.Switch_track /*1*/:
            case C0519c.Switch_textOn /*2*/:
                i = 3;
                break;
            case C0519c.Switch_textOff /*3*/:
                i = 2;
                break;
            default:
                i = 0;
                break;
        }
        if (i > 0) {
            c0300h.f779a = new byte[i][];
            c0300h.f780b = new byte[i][];
            for (i2 = 0; i2 < i; i2++) {
                c0300h.f779a[i2] = C0293a.m778a(azVar.f541k, i2);
                c0300h.f780b[i2] = C0293a.m784b(azVar.f541k, i2);
            }
        }
        if (c0302j == C0302j.UC4 || c0302j == C0302j.UC5) {
            byte[] bArr = azVar.f546p;
            i2 = C0293a.m770a(azVar.a) == C0301i.MS0 ? 0 : 4;
            if (bArr != null && bArr.length >= i2 + 5) {
                byte b = bArr[i2 + 4];
                if ((b & 16) == 16) {
                    c0300h.f781c = Boolean.valueOf(true);
                    if ((b & 8) == 8) {
                        if ((b & 7) == 0) {
                            for (C0354g b2 : C0293a.m792e(azVar)) {
                                try {
                                    C0293a.m785b(azVar.f541k, b2.m1062b());
                                    c0300h.f782d = Boolean.valueOf(true);
                                } catch (IOException e) {
                                    c0300h.f782d = Boolean.valueOf(false);
                                    try {
                                        azVar.f541k.close();
                                        azVar.f541k.connect();
                                    } catch (IOException e2) {
                                    }
                                }
                            }
                        } else {
                            c0300h.f782d = Boolean.valueOf(false);
                        }
                    }
                } else {
                    c0300h.f781c = Boolean.valueOf(false);
                }
            }
            if (!(c0300h.f781c == Boolean.FALSE || c0300h.f782d == Boolean.FALSE)) {
                c0300h.f783e = C0293a.m778a(azVar.f541k, 2);
            }
            c0300h.f784f = C0293a.m784b(azVar.f541k, 2);
        }
        return c0300h;
    }

    private static List m792e(az azVar) {
        List arrayList = new ArrayList();
        arrayList.add(new C0354g(new C0422a(f755f), null));
        Collection a = C0354g.m1058a(C0293a.m793f(azVar));
        if (a != null) {
            arrayList.addAll(a);
        }
        return C0354g.m1059a(arrayList);
    }

    private static Cursor m793f(az azVar) {
        String str;
        ContentResolver a = TagInfoApp.m10a();
        String[] strArr = new String[]{"key_value", "key_type"};
        switch (C0299g.f778c[azVar.f544n.ordinal()]) {
            case C0519c.Switch_track /*1*/:
                str = "21X";
                break;
            case C0519c.Switch_textOn /*2*/:
                str = "UL1";
                break;
            default:
                return null;
        }
        return a.query(UserKeys.f350c, strArr, "enabled = '" + Integer.toString(1) + "' AND " + "chip" + " = '" + str + "'", null, null);
    }
}
