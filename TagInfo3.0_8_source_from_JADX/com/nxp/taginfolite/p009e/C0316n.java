package com.nxp.taginfolite.p009e;

import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.tech.NfcV;
import android.support.v4.BuildConfig;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.Log;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.database.p008b.C0218a;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0353f;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p005b.C0182c;
import com.nxp.taginfolite.p005b.C0188i;
import com.nxp.taginfolite.p005b.C0189j;
import com.nxp.taginfolite.p005b.C0194n;
import com.nxp.taginfolite.p005b.C0195p;
import com.nxp.taginfolite.p006c.C0197a;
import com.nxp.taginfolite.p006c.C0198b;
import com.nxp.taginfolite.p006c.C0199c;
import java.io.IOException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Locale;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.n */
public final class C0316n extends C0315z {
    private static final EnumMap f886C;
    private static final EnumMap f887D;
    private C0320r f888E;
    private byte[] f889F;
    private int f890G;
    private byte[] f891H;
    private String f892I;
    protected byte[] f893a;
    public String f894b;

    static {
        f886C = new C0317o(C0320r.class);
        f887D = new C0318p(C0320r.class);
    }

    public C0316n() {
        this.f888E = null;
        this.f893a = null;
        this.f894b = null;
        this.f889F = null;
        this.f890G = -1;
        this.f891H = null;
        this.f892I = null;
    }

    private static byte m909a(byte[] bArr, int i, byte b) {
        int i2 = b & MotionEventCompat.ACTION_MASK;
        for (int i3 = 0; i3 < i; i3++) {
            i2 ^= bArr[i3] & MotionEventCompat.ACTION_MASK;
            i2 ^= (((i2 << 6) ^ (i2 << 5)) ^ (i2 << 4)) & MotionEventCompat.ACTION_MASK;
            i2 = (i2 >>> 4) ^ (((i2 >>> 2) ^ i2) ^ (i2 >>> 3));
        }
        return (byte) (i2 & MotionEventCompat.ACTION_MASK);
    }

    public static C0316n m910a(Tag tag, NfcV nfcV, boolean z, C0158a c0158a) {
        C0320r c0320r;
        boolean z2 = false;
        byte[] id = tag.getId();
        C0316n c0316n = new C0316n();
        c0316n.c = tag;
        c0316n.d = nfcV;
        c0316n.f = id;
        c0316n.m = nfcV.getDsfId();
        c0316n.w = z;
        C0320r c0320r2 = C0320r.UNKNOWN;
        boolean z3 = (id[4] & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0;
        boolean z4 = (id[4] & 64) != 0;
        boolean z5 = (id[4] & 16) != 0;
        if ((id[4] & 8) != 0) {
            z2 = true;
        }
        switch (id[5]) {
            case C0519c.Switch_track /*1*/:
                if (z5 && !r2) {
                    if (!z3) {
                        c0320r = C0320r.SLIX;
                        break;
                    }
                    c0320r = C0320r.SLIX_HC;
                    break;
                } else if (z5 || !r2) {
                    if (!z5 && !r2) {
                        c0320r = C0320r.SLI;
                        break;
                    }
                    c0320r = c0320r2;
                    break;
                } else {
                    c0320r = C0320r.SLIX2;
                    break;
                }
                break;
            case C0519c.Switch_textOn /*2*/:
                if (!z5) {
                    if (!z3) {
                        if (!z4) {
                            c0320r = C0320r.SLI_S;
                            break;
                        }
                        c0320r = C0320r.SLI_SY;
                        break;
                    }
                    c0320r = C0320r.SLI_S_HC;
                    break;
                } else if (!z3) {
                    c0320r = C0320r.SLIX_S;
                    break;
                } else {
                    c0320r = C0320r.SLIX_S_HC;
                    break;
                }
            case C0519c.Switch_textOff /*3*/:
                if (!z5) {
                    if (!z3) {
                        c0320r = C0320r.SLI_L;
                        break;
                    }
                    c0320r = C0320r.SLI_L_HC;
                    break;
                } else if (!z3) {
                    c0320r = C0320r.SLIX_L;
                    break;
                } else {
                    c0320r = C0320r.SLIX_L_HC;
                    break;
                }
            default:
                c0320r = C0320r.UNKNOWN;
                break;
        }
        c0316n.f888E = c0320r;
        if (C0316n.m918d(c0320r)) {
            c0316n.p = 97.0d;
        } else {
            c0316n.p = 23.5d;
        }
        c0316n.m908s();
        try {
            nfcV.connect();
            c0316n.i = c0316n.m898i();
            if (C0316n.m917c(c0320r)) {
                c0316n.k = 8;
            }
            if (c0316n.f888E == C0320r.SLIX2) {
                c0316n.f893a = c0316n.m919t();
            }
            switch (C0319q.f895a[c0316n.f888E.ordinal()]) {
                case C0519c.Switch_track /*1*/:
                case C0519c.Switch_textOn /*2*/:
                case C0519c.Switch_textOff /*3*/:
                case C0519c.Switch_thumbTextPadding /*4*/:
                case C0519c.Switch_switchTextAppearance /*5*/:
                case C0519c.Switch_switchMinWidth /*6*/:
                case C0519c.Switch_switchPadding /*7*/:
                case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                case C0086R.styleable.SherlockTheme_actionMenuTextAppearance /*10*/:
                case C0086R.styleable.SherlockTheme_actionMenuTextColor /*11*/:
                case C0086R.styleable.SherlockTheme_actionModeStyle /*12*/:
                    break;
                default:
                    c0316n.f894b = c0316n.m920u();
                    break;
            }
            c0316n.m921v();
            if (c0320r == C0320r.SLI_S) {
                c0316n.f889F = c0316n.m922w();
            }
            c0316n.y = true;
            c0316n.x = c0316n.m899j();
            c0316n.B = c0316n.m924y();
            if (!c0316n.w && C0316n.m914a(c0320r)) {
                c0316n.f892I = c0316n.m923x();
            }
            if (!c0316n.w && (C0316n.m915b(c0320r) || C0316n.m914a(c0320r))) {
                c0316n.v = c0316n.m931e();
            }
            if (c0158a.m56n()) {
                c0316n.u = c0316n.m932f();
            }
        } catch (TagLostException e) {
            c0316n.g = true;
        } catch (IOException e2) {
        }
        try {
            nfcV.close();
        } catch (IOException e3) {
        }
        return c0316n;
    }

    private String m911a(C0320r c0320r, int i) {
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        if (!C0316n.m915b(c0320r)) {
            if (C0316n.m917c(c0320r)) {
                switch (this.f891H[i] & 1) {
                    case C0519c.Switch_thumb /*0*/:
                        stringBuilder.append(". ");
                        break;
                    case C0519c.Switch_track /*1*/:
                        stringBuilder.append("x ");
                        break;
                    default:
                        stringBuilder.append("? ");
                        break;
                }
            }
        }
        byte b = this.f891H[i];
        switch (b & 1) {
            case C0519c.Switch_thumb /*0*/:
                stringBuilder.append((b & 8) != 0 ? "+" : ".");
                break;
            case C0519c.Switch_track /*1*/:
                stringBuilder.append((b & 8) != 0 ? "*" : "x");
                break;
            default:
                stringBuilder.append("?");
                break;
        }
        switch (b & 2) {
            case C0519c.Switch_thumb /*0*/:
                stringBuilder.append((b & 4) != 0 ? "r=  " : "rw  ");
                break;
            case C0519c.Switch_textOn /*2*/:
                stringBuilder.append((b & 4) != 0 ? "-=  " : "--  ");
                break;
            default:
                stringBuilder.append("??  ");
                break;
        }
        return stringBuilder.toString();
    }

    private String m912a(byte[] bArr) {
        return (bArr == null || bArr.length < 12) ? null : C0358k.m1070a(C0429j.m1408d(bArr));
    }

    public static boolean m913a(Tag tag) {
        return tag.getId()[6] == 4;
    }

    private static boolean m914a(C0320r c0320r) {
        return c0320r == C0320r.SLI || c0320r == C0320r.SLIX || c0320r == C0320r.SLIX_HC || c0320r == C0320r.SLIX2;
    }

    private static boolean m915b(C0320r c0320r) {
        return c0320r == C0320r.SLI_S || c0320r == C0320r.SLI_SY || c0320r == C0320r.SLI_S_HC || c0320r == C0320r.SLIX_S || c0320r == C0320r.SLIX_S_HC;
    }

    private byte[] m916b(int i, int i2) {
        Object obj = new byte[14];
        obj[0] = (byte) 36;
        obj[1] = (byte) -80;
        obj[2] = 4;
        obj[3] = (byte) (this.f.length * 8);
        System.arraycopy(this.f, 0, obj, 4, this.f.length);
        obj[12] = (byte) i;
        obj[13] = (byte) (i2 - 1);
        return this.d.transceive(obj);
    }

    private static boolean m917c(C0320r c0320r) {
        return c0320r == C0320r.SLI_L || c0320r == C0320r.SLI_L_HC || c0320r == C0320r.SLIX_L || c0320r == C0320r.SLIX_L_HC;
    }

    private static boolean m918d(C0320r c0320r) {
        return c0320r == C0320r.SLIX_HC || c0320r == C0320r.SLI_S_HC || c0320r == C0320r.SLIX_S_HC || c0320r == C0320r.SLI_L_HC || c0320r == C0320r.SLIX_L_HC;
    }

    private byte[] m919t() {
        try {
            return m883a((byte) -85);
        } catch (IOException e) {
            return null;
        }
    }

    private String m920u() {
        int i;
        String str = "0490933BDCD6E99B4E255E3DA55389A827564E11718E017292FAF23226A96614B8";
        byte[] bArr = null;
        try {
            bArr = m883a((byte) -67);
            Log.d("TagInfo_ICODE", "Signature: " + C0429j.m1409e(bArr));
            i = 0;
        } catch (IOException e) {
            Log.d("TagInfo_ICODE", "No answer to GetSignature");
            i = 1;
        }
        if (i != 0) {
            return "[password protected]";
        }
        if (bArr != null && bArr.length >= 32) {
            return C0353f.m1051a("0490933BDCD6E99B4E255E3DA55389A827564E11718E017292FAF23226A96614B8", bArr, this.f);
        }
        return String.format("[error (0x%02X) in signature: ", new Object[]{Byte.valueOf(this.e)}) + C0429j.m1409e(bArr) + "]";
    }

    private void m921v() {
        boolean z = true;
        try {
            boolean z2 = m900k() && Arrays.equals(m883a((byte) -91), new byte[]{(byte) 47, (byte) -77, (byte) 98, (byte) 112, (byte) -43, (byte) -89, (byte) -112, Byte.MAX_VALUE, (byte) -24, (byte) -79, Byte.MIN_VALUE, (byte) 56, (byte) -46, (byte) -127, (byte) 73, (byte) 118, (byte) -126, (byte) -38, (byte) -102, (byte) -122, (byte) 111, (byte) -81, (byte) -117, (byte) -80, (byte) -15, (byte) -100, (byte) -47, (byte) 18, (byte) -91, (byte) 114, (byte) 55, (byte) -17});
            this.s = z2;
            if (this.s && this.f888E != C0320r.SLI) {
                try {
                    byte[] a = m884a((byte) -91, (byte) 64);
                    this.f890G = C0429j.m1388a(a[0], a[1]);
                } catch (IOException e) {
                    if (m902m()) {
                        z = false;
                    }
                    this.g = z;
                }
            }
        } catch (IOException e2) {
            if (m902m()) {
                z = false;
            }
            this.g = z;
            this.s = false;
        }
    }

    private byte[] m922w() {
        try {
            return m900k() ? m883a((byte) -88) : new byte[0];
        } catch (IOException e) {
            this.g = !m902m();
            return !this.g ? new byte[0] : null;
        }
    }

    private String m923x() {
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        byte[] a = m889a(0, 9);
        if (!m900k() || a[7] != C0316n.m909a(a, 7, (byte) -1)) {
            return null;
        }
        int i;
        String str = "NL-";
        for (i = 3; i < 8; i++) {
            str = str + String.format("%02X", new Object[]{Byte.valueOf(a[i + 20])});
        }
        CharSequence a2 = C0218a.m320a(str);
        if (a2 == null) {
            return null;
        }
        stringBuilder.append("Dutch public-library item\n");
        stringBuilder.append(C0358k.f1076c);
        stringBuilder.append(C0429j.m1391a(a2));
        stringBuilder.append("\n");
        stringBuilder.append(C0358k.f1076c).append("Object ID: ");
        for (i = 0; i < 7; i++) {
            stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(a[i])}));
        }
        stringBuilder.append("\n");
        stringBuilder.append(C0358k.f1076c).append("Barcode: ");
        for (i = 0; i < 7; i++) {
            byte b = a[i + 12];
            if (b != (byte) -1) {
                if ((b & 15) == 15) {
                    stringBuilder.append(String.format("%1X", new Object[]{Integer.valueOf((b >>> 4) & MotionEventCompat.ACTION_MASK)}));
                } else {
                    stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(b)}));
                }
            }
        }
        stringBuilder.append("\n");
        stringBuilder.append(String.format(C0358k.f1076c + "Item ID: %02X%02X\n", new Object[]{Byte.valueOf(a[8]), Byte.valueOf(a[9])}));
        return stringBuilder.toString();
    }

    private boolean m924y() {
        if (C0316n.m914a(this.f888E)) {
            byte[] a = m886a((byte) 44, new byte[]{(byte) 0, (byte) (this.k - 1)});
            if (a == null || a.length != this.k || !m900k()) {
                return false;
            }
            for (byte b : a) {
                if (b == null) {
                    return false;
                }
            }
            return true;
        } else if (!C0316n.m915b(this.f888E) && !C0316n.m917c(this.f888E)) {
            return false;
        } else {
            this.f891H = m886a((byte) -72, new byte[]{(byte) 0, (byte) (this.k - 1)});
            if (this.f891H == null || this.f891H.length != this.k || !m900k()) {
                return false;
            }
            for (byte b2 : this.f891H) {
                if ((b2 & 1) == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    private String m925z() {
        C0428i c0428i = new C0428i();
        if (this.f893a != null && this.f893a.length > 4) {
            c0428i.m1384a(String.format("Protection pointer address: block 0x%02X", new Object[]{Byte.valueOf(this.f893a[1])}));
            byte b = this.f893a[3];
            if ((b & 1) != 0) {
                c0428i.m1384a((CharSequence) "AFI locked");
            }
            if ((b & 4) != 0) {
                c0428i.m1384a((CharSequence) "DSFID locked");
            }
            if ((b & 2) != 0) {
                c0428i.m1384a((CharSequence) "EAS status locked");
            }
            if ((b & 8) != 0) {
                c0428i.m1384a((CharSequence) "Password protection status locked");
            }
            b = this.f893a[4];
            if (!(b == null && this.f893a[5] == null)) {
                c0428i.m1384a((CharSequence) "Supported features:");
            }
            if ((b & 1) != 0) {
                c0428i.m1387b(C0358k.f1076c);
                c0428i.m1384a((CharSequence) "User memory password protection");
            }
            if ((b & 2) != 0) {
                c0428i.m1387b(C0358k.f1076c);
                c0428i.m1384a((CharSequence) "Counter");
            }
            if ((b & 4) != 0) {
                c0428i.m1387b(C0358k.f1076c);
                c0428i.m1384a((CharSequence) "EAS ID");
            }
            if ((b & 8) != 0) {
                c0428i.m1387b(C0358k.f1076c);
                c0428i.m1384a((CharSequence) "EAS password protection");
            }
            if ((b & 16) != 0) {
                c0428i.m1387b(C0358k.f1076c);
                c0428i.m1384a((CharSequence) "AFI password protection");
            }
            if ((b & 32) != 0) {
                c0428i.m1387b(C0358k.f1076c);
                c0428i.m1384a((CharSequence) "Extended mode for Inventory Page Read");
            }
            if ((b & 64) != 0) {
                c0428i.m1387b("\t\u2022 ");
                c0428i.m1384a((CharSequence) "EAS selection in extended mode for Inventory Page Read");
            }
            b = this.f893a[5];
            if ((b & 1) != 0) {
                c0428i.m1387b(C0358k.f1076c);
                c0428i.m1384a((CharSequence) "Originality signature");
            }
            if ((b & 1) != 0) {
                c0428i.m1387b(C0358k.f1076c);
                c0428i.m1384a((CharSequence) "Originality signature password protection");
            }
            if ((b & 2) != 0) {
                c0428i.m1387b(C0358k.f1076c);
                c0428i.m1384a((CharSequence) "Persistent quiet state");
            }
            if ((b & 16) != 0) {
                c0428i.m1387b(C0358k.f1076c);
                c0428i.m1384a((CharSequence) "Privacy mode");
            }
            if ((b & 32) != 0) {
                c0428i.m1387b(C0358k.f1076c);
                c0428i.m1384a((CharSequence) "Destroy command");
            }
        }
        return c0428i.toString();
    }

    public void m926a(C0197a c0197a, boolean z) {
        CharSequence g = m933g();
        if (this.B) {
            c0197a.m197b("Memory information", g + "\nMemory is locked");
        } else {
            c0197a.m193a(g);
        }
        C0428i c0428i = new C0428i();
        c0428i.m1384a((CharSequence) "Supported read commands:");
        c0428i.m1384a(C0358k.f1076c + "Single Block Read");
        if (C0316n.m915b(this.f888E) || C0316n.m917c(this.f888E)) {
            c0428i.m1384a(C0358k.f1076c + "Inventory Page Read");
            c0428i.m1384a(C0358k.f1076c + "Fast Inventory Page Read");
            c0428i.m1384a(C0358k.f1076c + "Get Multiple Block Protection Status");
        } else {
            c0428i.m1384a(C0358k.f1076c + "Multiple Block Read");
            c0428i.m1384a(C0358k.f1076c + "Inventory Read");
            c0428i.m1384a(C0358k.f1076c + "Fast Inventory Read");
            c0428i.m1384a(C0358k.f1076c + "Get Multiple Block Security Status");
        }
        c0428i.m1384a(C0358k.f1076c + "Get System Information");
        if (this.f888E == C0320r.SLIX2) {
            c0428i.m1384a(C0358k.f1076c + "Get NXP System Information");
        }
        c0428i.m1384a((CharSequence) "AFI supported");
        c0428i.m1384a((CharSequence) "DSFID supported");
        if (m905p() > 0) {
            c0428i.m1387b("IC reference value: ");
            c0428i.m1384a(String.format("0x%02X", new Object[]{Integer.valueOf(r1)}));
        }
        if (this.p > 0.0d) {
            c0428i.m1384a(String.format(Locale.US, "Capacitance: %.1f\u200apF", new Object[]{Double.valueOf(this.p)}));
        }
        c0197a.m198c(c0428i.toString());
        if (this.f893a != null) {
            c0197a.m201d("NXP system information", m925z());
        }
        c0428i = new C0428i();
        if (this.f889F != null) {
            if (this.f889F.length > 0) {
                c0428i.m1384a(m912a(this.f889F));
            } else {
                c0428i.m1384a((CharSequence) "Electronic Product Code (EPC) destroyed");
            }
        }
        if (this.s) {
            c0428i.m1384a((CharSequence) "Electronic Article Surveillance (EAS) active");
            if (this.f890G != -1) {
                c0428i.m1384a(String.format("EAS ID: 0x%04X", new Object[]{Integer.valueOf(this.f890G)}));
            }
        }
        if (this.f894b != null) {
            c0197a.m203e("Originality check", this.f894b);
        }
        c0197a.m195a((CharSequence) "Electronic article information", c0428i.toString());
    }

    public void m927a(C0198b c0198b, boolean z) {
        if (this.x != null && this.x[0] == -31) {
            c0198b.m214a(m907r());
            c0198b.m217b(C0188i.m162a(this.x));
        }
    }

    public void m928a(C0199c c0199c, boolean z) {
        if (this.f892I != null) {
            c0199c.m227b(this.f892I);
        }
        c0199c.m230d("NXP Semiconductors");
        StringBuilder stringBuilder = new StringBuilder((String) f886C.get(this.f888E));
        Object d = m930d();
        if (!TextUtils.isEmpty(d)) {
            stringBuilder.append(" (");
            stringBuilder.append(d);
            stringBuilder.append(")");
        }
        c0199c.m231e(stringBuilder.toString());
        if (this.l != -1) {
            c0199c.m232f(m906q());
        }
        if (!TextUtils.isEmpty(this.v)) {
            c0199c.m227b(this.v);
        }
    }

    public boolean m929a() {
        return true;
    }

    public String m930d() {
        return (String) f887D.get(this.f888E);
    }

    protected String m931e() {
        if (C0316n.m915b(this.f888E)) {
            byte[] b = m916b(0, 2);
            if (m900k() && b != null && b.length > 22 && b[12] == (byte) 83 && b[16] == (byte) 83 && b[21] == (byte) 83 && b[13] == (byte) 66 && b[17] == (byte) 66 && b[22] == (byte) 66) {
                C0428i c0428i = new C0428i();
                c0428i.m1384a((CharSequence) "SKIDATA keycard");
                c0428i.m1387b(C0358k.f1076c + "Key number: ");
                c0428i.m1384a(m897h());
                return c0428i.toString();
            }
        }
        return null;
    }

    protected C0182c m932f() {
        boolean z = true;
        C0182c c0182c = new C0182c();
        byte[] n;
        int length;
        int i;
        if (C0316n.m914a(this.f888E)) {
            n = m903n();
            if (n == null) {
                return null;
            }
            length = this.k > 0 ? this.k : n.length / (this.j + 1);
            i = 0;
            while (i < length) {
                int i2 = i * (this.j + 1);
                if (i2 >= n.length) {
                    this.g = !m902m();
                    if (this.g) {
                        c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "\n <aborted: tag disappeared>")));
                    } else {
                        c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "\n<aborted: read error>")));
                    }
                    c0182c.m147a(new C0194n("\n  x:locked, .:unlocked"));
                } else {
                    String str = n[i2] == null ? "." : "x";
                    byte[] copyOfRange = Arrays.copyOfRange(n, i2 + 1, (i2 + 1) + this.j);
                    if (this.f888E == C0320r.SLIX2 && i == this.k - 1) {
                        c0182c.m147a(new C0195p(i, str, copyOfRange, String.format("(C0-C1 value: %d, PROT)", new Object[]{Integer.valueOf(C0429j.m1388a(copyOfRange[0], copyOfRange[1]))})));
                    } else {
                        c0182c.m147a(new C0189j(i, str, copyOfRange));
                    }
                    i++;
                }
            }
            c0182c.m147a(new C0194n("\n  x:locked, .:unlocked"));
        } else if (C0316n.m917c(this.f888E) || C0316n.m915b(this.f888E)) {
            try {
                n = m916b(0, this.k / 4);
                if (m900k()) {
                    length = 0;
                    int i3 = n[1];
                    i = 2;
                    while (length < this.k) {
                        byte b;
                        int i4;
                        if (i3 == 15) {
                            for (i3 = 0; i3 < 4; i3++) {
                                c0182c.m147a(new C0189j(length + i3, m911a(this.f888E, length + i3), null));
                            }
                            length += 3;
                            i3 = i + 1;
                            b = n[i];
                        } else {
                            c0182c.m147a(new C0189j(length, m911a(this.f888E, length), Arrays.copyOfRange(n, i, this.j + i)));
                            i += 4;
                            if (length % 4 != 3 || i + 1 >= n.length) {
                                i4 = i;
                                b = i3;
                                i3 = i4;
                            } else {
                                i3 = i + 1;
                                b = n[i];
                            }
                        }
                        length++;
                        i4 = i3;
                        i3 = b;
                        i = i4;
                    }
                    if (C0316n.m915b(this.f888E)) {
                        c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "\n  r:readable, w:writeable,\n  -:password protected, .:un(b)locked,\n  *:locked & blocked, x:locked, +:blocked")));
                    } else {
                        c0182c.m147a(new C0194n("\n  x:locked, .:unlocked"));
                    }
                } else {
                    throw new IOException();
                }
            } catch (TagLostException e) {
                if (m902m()) {
                    z = false;
                }
                this.g = z;
                c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "\n <aborted: tag disappeared>")));
            } catch (IOException e2) {
                c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "\n <aborted: read error>")));
            }
        }
        return c0182c;
    }

    protected String m933g() {
        C0428i c0428i = new C0428i();
        if (this.i != null && this.i.length != 0 && (this.i[0] & 4) != 0) {
            c0428i.m1384a(String.format("%d bytes", new Object[]{Integer.valueOf(this.j * this.k)}));
            if (C0316n.m915b(this.f888E)) {
                c0428i.m1384a(C0358k.f1076c + "10 pages, with 4 blocks per page");
            } else if (C0316n.m917c(this.f888E)) {
                c0428i.m1384a(C0358k.f1076c + "2 pages, with 4 blocks per page");
            }
            c0428i.m1384a(String.format(C0358k.f1076c + "%d blocks, with %d bytes per block", new Object[]{Integer.valueOf(this.k), Integer.valueOf(this.j)}));
        } else if (this.r != null) {
            c0428i.m1384a(this.r);
        }
        return c0428i.toString();
    }
}
