package com.nxp.taginfolite.p009e;

import android.annotation.SuppressLint;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.tech.NfcV;
import android.os.Build.VERSION;
import android.support.v4.BuildConfig;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0355h;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.C0360m;
import com.nxp.taginfolite.p004f.C0369v;
import com.nxp.taginfolite.p005b.C0182c;
import com.nxp.taginfolite.p005b.C0188i;
import com.nxp.taginfolite.p006c.C0197a;
import com.nxp.taginfolite.p006c.C0198b;
import com.nxp.taginfolite.p006c.C0199c;
import com.nxp.taginfolite.p006c.C0200d;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.z */
public class C0315z implements ay {
    protected Boolean f857A;
    protected boolean f858B;
    private boolean f859C;
    private boolean f860a;
    private boolean f861b;
    protected Tag f862c;
    protected NfcV f863d;
    protected byte f864e;
    protected byte[] f865f;
    protected boolean f866g;
    protected int f867h;
    protected byte[] f868i;
    protected int f869j;
    protected int f870k;
    protected int f871l;
    protected byte f872m;
    protected int f873n;
    protected String f874o;
    protected double f875p;
    protected int f876q;
    protected String f877r;
    protected boolean f878s;
    protected String f879t;
    protected C0182c f880u;
    protected String f881v;
    protected boolean f882w;
    protected byte[] f883x;
    protected boolean f884y;
    protected Boolean f885z;

    public C0315z() {
        this.f862c = null;
        this.f863d = null;
        this.f865f = null;
        this.f866g = false;
        this.f868i = null;
        this.f869j = 0;
        this.f870k = 0;
        this.f871l = -1;
        this.f872m = (byte) -1;
        this.f873n = -1;
        this.f874o = null;
        this.f875p = -1.0d;
        this.f876q = -1;
        this.f877r = null;
        this.f878s = false;
        this.f879t = null;
        this.f860a = false;
        this.f880u = new C0182c();
        this.f881v = null;
        this.f861b = false;
        this.f882w = false;
        this.f883x = null;
        this.f884y = false;
        this.f859C = false;
        this.f885z = null;
        this.f857A = null;
        this.f858B = false;
    }

    private void m866A() {
        boolean z = true;
        if (this.f865f[6] == 2 && this.f860a) {
            this.f861b = true;
            this.f884y = true;
            this.f859C = true;
            return;
        }
        byte[] a;
        try {
            a = m889a(0, 1);
            if (m900k()) {
                this.f861b = true;
                if (this.f868i == null) {
                    this.f869j = a.length;
                }
            }
        } catch (IOException e) {
            this.f866g = !m902m();
        }
        try {
            a = m892b(0);
            if (m900k()) {
                this.f884y = true;
                if (this.f868i == null) {
                    this.f869j = a.length;
                }
            }
        } catch (IOException e2) {
            this.f866g = !m902m();
            if (this.f866g) {
                return;
            }
        }
        try {
            a = m886a((byte) 44, new byte[]{(byte) 0, (byte) -1});
            if (m900k()) {
                this.f859C = true;
                if (this.f868i == null && a.length < 254) {
                    this.f870k = a.length;
                }
            }
        } catch (IOException e3) {
            if (m902m()) {
                z = false;
            }
            this.f866g = z;
        }
    }

    private byte[] m867B() {
        byte[] a = m886a((byte) 44, new byte[]{(byte) 0, (byte) 63});
        if (m900k()) {
            Object obj = new byte[320];
            for (int i = 0; i < 64; i++) {
                obj[i * 5] = a[i];
                if ((a[i] & 6) == 0) {
                    Object b = m892b(i);
                    if (m900k()) {
                        System.arraycopy(b, 0, obj, (i * 5) + 1, 4);
                    } else {
                        throw new IOException();
                    }
                }
                obj[(i * 5) + 1] = -1;
                obj[(i * 5) + 2] = -1;
                obj[(i * 5) + 3] = -1;
                obj[(i * 5) + 4] = -1;
            }
            return obj;
        }
        throw new IOException();
    }

    private String m868C() {
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        if (!TextUtils.isEmpty(this.f877r)) {
            stringBuilder.append(this.f877r);
        } else if (this.f869j > 0 && this.f870k > 0) {
            stringBuilder.append(String.format("%d bytes\n", new Object[]{Integer.valueOf(this.f869j * this.f870k)}));
            stringBuilder.append(String.format(C0358k.f1076c + "%d blocks, with %d bytes per block", new Object[]{Integer.valueOf(this.f870k), Integer.valueOf(this.f869j)}));
        } else if (this.f869j > 0) {
            stringBuilder.append(String.format("%d bytes per block\n", new Object[]{Integer.valueOf(this.f869j)}));
            stringBuilder.append("(Unknown number of blocks)");
        }
        return stringBuilder.toString();
    }

    @SuppressLint({"NewApi"})
    public static ay m869b(Tag tag, NfcV nfcV, boolean z, C0158a c0158a) {
        boolean z2 = true;
        C0315z c0315z = new C0315z();
        c0315z.f862c = tag;
        c0315z.f863d = nfcV;
        c0315z.f865f = tag.getId();
        c0315z.f872m = nfcV.getDsfId();
        c0315z.f882w = z;
        byte[] bArr = c0315z.f865f;
        c0315z.m908s();
        try {
            nfcV.connect();
            c0315z.f868i = c0315z.m898i();
            c0315z.f874o = c0315z.m870g();
            c0315z.m866A();
            if (c0315z.f865f[6] == 22) {
                byte b = (byte) ((bArr[5] >>> 2) & 31);
                if (b == (byte) 1 || b == 7) {
                    byte[] a = c0315z.m889a(2, 1);
                    c0315z.f878s = (b == (byte) 1 ? (a[2] >> 5) & 1 : a[3] & 1) != 0;
                }
            }
            if (z) {
                c0315z.f883x = c0315z.m899j();
            }
            if (c0315z.f871l < 0) {
                c0315z.f885z = Boolean.valueOf(c0315z.m877z());
            }
            c0315z.f881v = c0315z.m895e();
            if (c0158a.m56n()) {
                c0315z.f880u = c0315z.m896f();
            }
        } catch (TagLostException e) {
            if (c0315z.m902m()) {
                z2 = false;
            }
            c0315z.f866g = z2;
        } catch (IOException e2) {
        }
        try {
            nfcV.close();
        } catch (IOException e3) {
        }
        return c0315z;
    }

    private String m870g() {
        byte b = this.f865f[6];
        return b == 22 ? m871t() : b == 7 ? m872u() : b == 5 ? m873v() : b == 2 ? m874w() : b == 43 ? m876y() : b == 8 ? m875x() : null;
    }

    private String m871t() {
        double d = 28.0d;
        double d2 = 23.5d;
        byte b = (byte) ((this.f865f[5] >>> 2) & 31);
        int i = (this.f865f[5] >>> 7) & 1;
        this.f876q = C0429j.m1388a((byte) (this.f865f[5] & 3), this.f865f[4]);
        String str;
        switch (b) {
            case C0519c.Switch_track /*1*/:
                this.f875p = 28.0d;
                this.f877r = "56 bytes\n" + C0358k.f1076c + "14 blocks, with 4 bytes per block";
                this.f870k = 14;
                this.f869j = 4;
                return "EM4034";
            case C0519c.Switch_textOff /*3*/:
                String str2 = "EM4035";
                this.f870k--;
                this.f869j--;
                if (i != 0) {
                    d = 95.0d;
                }
                this.f875p = d;
                return str2;
            case C0519c.Switch_thumbTextPadding /*4*/:
                str = "EM4135";
                this.f870k--;
                this.f869j--;
                return str;
            case C0519c.Switch_switchTextAppearance /*5*/:
                str = "EM4x3x";
                this.f870k--;
                this.f869j--;
                this.f877r = "400 bytes\n" + C0358k.f1076c + "50 blocks, with 8 bytes per block";
                return str;
            case C0519c.Switch_switchPadding /*7*/:
                String str3 = "EM4133";
                this.f875p = i == 0 ? 23.5d : 97.0d;
                this.f877r = "64 bytes\n" + C0358k.f1076c + "14 blocks, with 4 bytes per block";
                return str3;
            case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                str = "EM4033";
                this.f875p = 23.5d;
                this.f877r = "64 bit read-only";
                return str;
            case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                return "EM4x3x";
            case C0086R.styleable.SherlockTheme_actionMenuTextAppearance /*10*/:
                str = "EM4233SLIC";
                if (i != 0) {
                    d2 = 97.0d;
                }
                this.f875p = d2;
                return str;
            default:
                return null;
        }
    }

    private String m872u() {
        String str;
        switch ((byte) ((this.f865f[5] >>> 1) & TransportMediator.KEYCODE_MEDIA_PAUSE)) {
            case C0519c.Switch_thumb /*0*/:
                return "Tag-it HF-I Plus (inlay)";
            case C0086R.styleable.SherlockTheme_activityChooserViewStyle /*64*/:
                return "Tag-it HF-I Plus (TMS37112)";
            case (byte) 96:
                str = "Tag-it HF-I Standard";
                this.f877r = "44 bytes\n" + C0358k.f1076c + "11 blocks, with 4 bytes per block";
                this.f870k = 11;
                this.f869j = 4;
                return str;
            case (byte) 98:
                str = "Tag-it HF-I Pro";
                this.f870k = 13;
                this.f869j = 4;
                return str;
            default:
                return null;
        }
    }

    private String m873v() {
        String str = null;
        switch ((this.f865f[5] >>> 4) & 15) {
            case C0519c.Switch_thumb /*0*/:
                str = "my-d vicinity plain (SRF55V10P)";
                this.f877r = "1280 bytesn" + C0358k.f1076c + "248 blocks, with 4 bytes per block";
                this.f870k = 248;
                this.f869j = 4;
                break;
            case C0519c.Switch_track /*1*/:
                str = "my-d vicinity secure (SRF55V10S)";
                this.f877r = "1280 bytes";
                break;
            case C0519c.Switch_thumbTextPadding /*4*/:
                str = "my-d vicinity plain (SRF55V02P)";
                this.f877r = "320 bytes\n" + C0358k.f1076c + "56 blocks, with 4 bytes per block";
                this.f870k = 56;
                this.f869j = 4;
                break;
            case C0519c.Switch_switchTextAppearance /*5*/:
                str = "my-d vicinity secure (SRF55V02S)";
                this.f877r = "320 bytes";
                break;
        }
        if (this.f877r == null) {
            switch ((this.f865f[5] >>> 5) & 7) {
                case C0519c.Switch_thumb /*0*/:
                    this.f877r = "10\u200akbit";
                    break;
                case C0519c.Switch_track /*1*/:
                    this.f877r = "5\u200akbit";
                    break;
                case C0519c.Switch_textOn /*2*/:
                    this.f877r = "2.5\u200akbit";
                    break;
                case C0519c.Switch_textOff /*3*/:
                    this.f877r = "1.25\u200akbit";
                    break;
                case C0519c.Switch_thumbTextPadding /*4*/:
                    this.f877r = "20\u200akbit";
                    break;
            }
        }
        if ((this.f865f[5] & 16) != 0) {
            this.f879t = "Crypto Security support";
        } else {
            this.f879t = "Plain mode only (no Crypto Security support)";
        }
        switch (this.f865f[5] & 15) {
            case C0519c.Switch_thumb /*0*/:
                this.f879t += "\nSRF55Vxx chip functionality";
                break;
            case C0519c.Switch_track /*1*/:
            case C0519c.Switch_textOn /*2*/:
            case C0519c.Switch_textOff /*3*/:
            case C0519c.Switch_thumbTextPadding /*4*/:
            case C0519c.Switch_switchTextAppearance /*5*/:
            case C0519c.Switch_switchMinWidth /*6*/:
            case C0519c.Switch_switchPadding /*7*/:
                this.f879t += "\nBackwards compatible to SRF55Vxx functionality";
                break;
        }
        return str;
    }

    private String m874w() {
        if (this.f860a) {
            switch (this.f873n) {
                case C0086R.styleable.SherlockTheme_listPreferredItemHeightSmall /*44*/:
                    return "M24LR64-R";
                case 68:
                    return "LRiS64K";
                case 78:
                    return "M24LR16E-R";
                case 94:
                    return "M24LR64E-R";
                default:
                    return null;
            }
        }
        switch (this.f873n & 252) {
            case C0086R.styleable.SherlockTheme_selectableItemBackground /*20*/:
                return "LRi64";
            case C0086R.styleable.SherlockTheme_searchViewCloseIcon /*32*/:
                return "LRi2K";
            case C0086R.styleable.SherlockTheme_textColorSearchUrl /*40*/:
                return "LRiS2K";
            case C0086R.styleable.SherlockTheme_activityChooserViewStyle /*64*/:
                return "LRi1K";
            case 88:
                return this.f873n == 90 ? "M24LR04E-R" : null;
            default:
                return null;
        }
    }

    private String m875x() {
        switch (this.f865f[5]) {
            case C0519c.Switch_thumb /*0*/:
                return "MB89R116";
            case C0519c.Switch_track /*1*/:
                return "MB89R118C";
            case C0519c.Switch_textOn /*2*/:
                return "MB89R119B";
            case C0519c.Switch_switchTextAppearance /*5*/:
                return "MB89R112";
            default:
                return null;
        }
    }

    private String m876y() {
        switch ((byte) (((this.f865f[5] & 15) << 4) | ((this.f865f[4] >> 4) & 15))) {
            case C0519c.Switch_track /*1*/:
                return "MAX66100";
            case C0519c.Switch_textOn /*2*/:
                return "MAX66120";
            case C0519c.Switch_textOff /*3*/:
                return "MAX66140";
            default:
                return null;
        }
    }

    private boolean m877z() {
        boolean z = true;
        try {
            m887a(0);
            return true;
        } catch (IOException e) {
            if (m902m()) {
                z = false;
            }
            this.f866g = z;
            return false;
        }
    }

    public void m878a(C0197a c0197a, boolean z) {
        CharSequence C = m868C();
        if (this.f858B) {
            c0197a.m197b("Memory information", C + "\nMemory is locked");
        } else {
            c0197a.m193a(C);
        }
        C0428i c0428i = new C0428i();
        C = BuildConfig.VERSION_NAME;
        if (!this.f860a) {
            if (this.f860a) {
                C = " (proprietary)";
            }
            c0428i.m1384a((CharSequence) "Supported read commands:");
            if (this.f884y) {
                c0428i.m1387b(C0358k.f1076c + "Single Block Read");
                c0428i.m1387b(C);
                c0428i.m1383a();
            }
            if (this.f861b) {
                c0428i.m1387b(C0358k.f1076c + "Multiple Block Read");
                c0428i.m1387b(C);
                c0428i.m1383a();
            }
            if (this.f859C) {
                c0428i.m1387b(C0358k.f1076c + "Get Multiple Block Security Status");
                c0428i.m1387b(C);
                c0428i.m1383a();
            }
            if (this.f868i != null) {
                c0428i.m1387b(C0358k.f1076c + "Get System Information");
                c0428i.m1387b(C);
                c0428i.m1383a();
            }
            if (!(this.f884y || this.f861b || this.f859C || this.f868i != null)) {
                c0428i.m1384a(C0358k.f1076c + "[Could not be determined]");
            }
        }
        if (this.f871l >= 0 || (this.f885z != null && this.f885z.booleanValue())) {
            c0428i.m1384a((CharSequence) "AFI supported");
        } else if (this.f885z != null) {
            c0428i.m1384a((CharSequence) "AFI not supported");
        }
        if (this.f872m != null || (this.f857A != null && this.f857A.booleanValue())) {
            c0428i.m1384a((CharSequence) "DSFID supported");
        } else if (!(this.f857A == null || this.f857A.booleanValue() || this.f868i == null)) {
            c0428i.m1384a((CharSequence) "DSFID not supported");
        }
        if (m905p() >= 0) {
            c0428i.m1384a(String.format("IC reference value: 0x%02X", new Object[]{Integer.valueOf(m905p())}));
        }
        if (this.f875p > 0.0d) {
            c0428i.m1384a(String.format(Locale.US, "Capacitance: %.1f\u200apF", new Object[]{Double.valueOf(this.f875p)}));
        }
        if (this.f876q > 0) {
            c0428i.m1384a(String.format("Customer ID: 0x%03X", new Object[]{Integer.valueOf(this.f876q)}));
        }
        if (this.f879t != null) {
            c0428i.m1384a(this.f879t);
        }
        c0197a.m198c(c0428i.toString());
        if (this.f878s) {
            c0197a.m195a((CharSequence) "Electronic article information", (CharSequence) "Electronic Article Surveillance (EAS) active");
        }
    }

    public void m879a(C0198b c0198b, boolean z) {
        if (this.f883x != null && this.f883x[0] == -31) {
            c0198b.m214a(m907r());
            c0198b.m217b(C0188i.m162a(this.f883x));
        }
    }

    public void m880a(C0199c c0199c, boolean z) {
        c0199c.m230d(C0355h.m1067b(this.f862c.getId(), C0360m.ISO15693));
        if (this.f874o != null) {
            c0199c.m231e(this.f874o);
        } else {
            c0199c.m231e("Unknown IC");
        }
        if (this.f871l != -1) {
            c0199c.m232f(m906q());
        }
        if (!TextUtils.isEmpty(this.f881v)) {
            c0199c.m227b(this.f881v);
        }
    }

    public void m881a(C0200d c0200d, boolean z) {
        c0200d.m238a((CharSequence) "ISO/IEC 15693-3 compatible\nISO/IEC 15693-2 compatible");
        C0369v.m1103a(this.f863d, this.f871l, c0200d);
        if (this.f880u != null) {
            c0200d.m237a(this.f880u);
        }
    }

    public boolean m882a() {
        return C0355h.m1065a(this.f862c.getId(), C0360m.ISO15693);
    }

    protected byte[] m883a(byte b) {
        return m885a(b, (byte) 0, new byte[0]);
    }

    protected byte[] m884a(byte b, byte b2) {
        return m885a(b, b2, new byte[0]);
    }

    protected byte[] m885a(byte b, byte b2, byte[] bArr) {
        int i = ((b & MotionEventCompat.ACTION_MASK) < 160 || (b & MotionEventCompat.ACTION_MASK) >= 224) ? 0 : 1;
        int i2 = i != 0 ? 3 : 2;
        Object obj = new byte[((this.f865f.length + i2) + bArr.length)];
        obj[0] = (byte) (b2 | 32);
        obj[1] = b;
        if (i != 0) {
            obj[2] = this.f865f[6];
        }
        System.arraycopy(this.f865f, 0, obj, i2, this.f865f.length);
        if (bArr.length > 0) {
            System.arraycopy(bArr, 0, obj, i2 + this.f865f.length, bArr.length);
        }
        this.f864e = (byte) -1;
        byte[] transceive = this.f863d.transceive(obj);
        this.f864e = transceive[0];
        return Arrays.copyOfRange(transceive, 1, transceive.length);
    }

    protected byte[] m886a(byte b, byte[] bArr) {
        return m885a(b, (byte) 0, bArr);
    }

    protected byte[] m887a(int i) {
        Object obj = new byte[12];
        obj[0] = (byte) 52;
        obj[1] = 1;
        obj[2] = (byte) i;
        obj[3] = (byte) 64;
        System.arraycopy(this.f862c.getId(), 0, obj, 4, 8);
        return this.f863d.transceive(obj);
    }

    protected byte[] m888a(int i, byte b) {
        return m885a((byte) 32, b, new byte[]{(byte) i});
    }

    protected byte[] m889a(int i, int i2) {
        return m886a((byte) 35, new byte[]{(byte) i, (byte) (i2 - 1)});
    }

    protected byte[] m890a(int i, int i2, byte b) {
        return m885a((byte) 35, b, new byte[]{(byte) i, (byte) (i2 - 1)});
    }

    public boolean m891b() {
        return this.f866g;
    }

    protected byte[] m892b(int i) {
        return m886a((byte) 32, new byte[]{(byte) i});
    }

    public byte[] m893c() {
        return this.f862c.getId();
    }

    public String m894d() {
        return this.f874o;
    }

    protected String m895e() {
        int i = 1;
        byte b = this.f865f[6];
        int i2 = 0;
        byte[] a;
        if (b != 22) {
            if (b != 5) {
                if (b == 7) {
                    switch ((byte) ((this.f865f[5] >>> 1) & TransportMediator.KEYCODE_MEDIA_PAUSE)) {
                        case C0519c.Switch_thumb /*0*/:
                        case C0086R.styleable.SherlockTheme_activityChooserViewStyle /*64*/:
                            a = m889a(58, 3);
                            if (!(a != null && a.length > 11 && a[2] == (byte) 83 && a[6] == (byte) 83 && a[10] == (byte) 83 && a[3] == (byte) 66 && a[7] == (byte) 66 && a[11] == (byte) 66)) {
                                i = 0;
                            }
                            i2 = i;
                            break;
                        default:
                            break;
                    }
                }
            }
            switch ((this.f865f[5] >>> 4) & 15) {
                case C0519c.Switch_thumbTextPadding /*4*/:
                    a = m889a(2, 3);
                    if (!(a != null && a.length > 11 && a[2] == (byte) 83 && a[6] == (byte) 83 && a[10] == (byte) 83 && a[3] == (byte) 66 && a[7] == (byte) 66 && a[11] == (byte) 66)) {
                        i = 0;
                        break;
                    }
                default:
                    i = 0;
                    break;
            }
            i2 = i;
        } else {
            switch ((byte) ((this.f865f[5] >>> 2) & 31)) {
                case C0519c.Switch_track /*1*/:
                    a = m889a(2, 2);
                    if (!(a != null && a.length > 4 && a[0] == -2 && a[1] == 47 && a[2] == null && a[4] == 108)) {
                        i = 0;
                    }
                    i2 = i;
                    break;
                case C0519c.Switch_switchTextAppearance /*5*/:
                    byte[] a2 = m889a(25, 4);
                    if (a2 != null && a2.length > 28 && a2[7] == 109 && a2[16] == -77 && a2[20] == -125 && a2[28] == -29) {
                        i2 = 1;
                    }
                    a2 = m889a(15, 3);
                    if (a2 != null && a2.length > 19 && a2[2] == (byte) 83 && a2[3] == (byte) 66 && a2[10] == (byte) 83 && a2[11] == (byte) 66 && a2[18] == (byte) 83 && a2[19] == (byte) 66) {
                        i2 = 1;
                        break;
                    }
                case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                    a = m889a(28, 2);
                    if (!(a != null && a.length > 7 && a[2] == (byte) 83 && a[6] == (byte) 83 && a[3] == (byte) 66 && a[7] == (byte) 66)) {
                        i = 0;
                    }
                    i2 = i;
                    break;
            }
        }
        if (i2 == 0) {
            return null;
        }
        C0428i c0428i = new C0428i();
        c0428i.m1384a((CharSequence) "SKIDATA keycard");
        c0428i.m1387b(C0358k.f1076c + "Key number: ");
        c0428i.m1384a(m897h());
        return c0428i.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected com.nxp.taginfolite.p005b.C0182c m896f() {
        /*
        r15 = this;
        r4 = 0;
        r3 = 0;
        r2 = 0;
        r1 = -1;
        r0 = 0;
        r8 = new com.nxp.taginfolite.b.c;
        r8.<init>();
        r5 = r15.f865f;
        r6 = 6;
        r5 = r5[r6];
        switch(r5) {
            case 2: goto L_0x007a;
            case 5: goto L_0x006a;
            case 7: goto L_0x0048;
            case 22: goto L_0x003a;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = r15.f868i;
        if (r0 == 0) goto L_0x00cf;
    L_0x0016:
        r0 = r15.f868i;
        r5 = 0;
        r0 = r0[r5];
        r0 = r0 & 4;
        if (r0 == 0) goto L_0x00cf;
    L_0x001f:
        r0 = r15.f861b;
        if (r0 == 0) goto L_0x00c4;
    L_0x0023:
        r0 = r15.m903n();
        if (r0 != 0) goto L_0x0283;
    L_0x0029:
        r5 = r15.f884y;
        if (r5 == 0) goto L_0x0283;
    L_0x002d:
        r0 = r15.m904o();
        r9 = r0;
        r10 = r1;
        r11 = r2;
        r12 = r3;
        r13 = r4;
    L_0x0036:
        if (r9 != 0) goto L_0x00d2;
    L_0x0038:
        r0 = 0;
    L_0x0039:
        return r0;
    L_0x003a:
        r5 = r15.f870k;
        if (r5 <= 0) goto L_0x028a;
    L_0x003e:
        r0 = r15.m903n();
        r9 = r0;
        r10 = r1;
        r11 = r2;
        r12 = r3;
        r13 = r4;
        goto L_0x0036;
    L_0x0048:
        r4 = 1;
        r0 = r15.f865f;
        r1 = 5;
        r0 = r0[r1];
        r0 = r0 >>> 1;
        r0 = r0 & 127;
        r1 = (byte) r0;
        switch(r1) {
            case 0: goto L_0x0060;
            case 64: goto L_0x0060;
            default: goto L_0x0056;
        };
    L_0x0056:
        r0 = r15.m904o();
        r9 = r0;
        r10 = r1;
        r11 = r2;
        r12 = r3;
        r13 = r4;
        goto L_0x0036;
    L_0x0060:
        r0 = r15.m903n();
        r9 = r0;
        r10 = r1;
        r11 = r2;
        r12 = r3;
        r13 = r4;
        goto L_0x0036;
    L_0x006a:
        r0 = r15.f870k;
        if (r0 <= 0) goto L_0x0078;
    L_0x006e:
        r0 = r15.m903n();
        r9 = r0;
        r10 = r1;
        r11 = r2;
        r12 = r3;
        r13 = r4;
        goto L_0x0036;
    L_0x0078:
        r0 = 0;
        goto L_0x0039;
    L_0x007a:
        r5 = r15.f860a;
        if (r5 == 0) goto L_0x0086;
    L_0x007e:
        r3 = 1;
        r2 = 1;
        r9 = r0;
        r10 = r1;
        r11 = r2;
        r12 = r3;
        r13 = r4;
        goto L_0x0036;
    L_0x0086:
        r1 = r15.f873n;
        r1 = r1 & 252;
        r1 = (byte) r1;
        switch(r1) {
            case 40: goto L_0x009c;
            case 88: goto L_0x00a7;
            default: goto L_0x008e;
        };
    L_0x008e:
        r0 = r15.f861b;
        if (r0 == 0) goto L_0x00b9;
    L_0x0092:
        r0 = r15.m903n();
        r9 = r0;
        r10 = r1;
        r11 = r2;
        r12 = r3;
        r13 = r4;
        goto L_0x0036;
    L_0x009c:
        r3 = 1;
        r0 = r15.m867B();
        r9 = r0;
        r10 = r1;
        r11 = r2;
        r12 = r3;
        r13 = r4;
        goto L_0x0036;
    L_0x00a7:
        r5 = r15.f873n;
        r6 = 90;
        if (r5 != r6) goto L_0x028a;
    L_0x00ad:
        r3 = 1;
        r0 = r15.m903n();
        r9 = r0;
        r10 = r1;
        r11 = r2;
        r12 = r3;
        r13 = r4;
        goto L_0x0036;
    L_0x00b9:
        r0 = r15.m904o();
        r9 = r0;
        r10 = r1;
        r11 = r2;
        r12 = r3;
        r13 = r4;
        goto L_0x0036;
    L_0x00c4:
        r0 = r15.m904o();
        r9 = r0;
        r10 = r1;
        r11 = r2;
        r12 = r3;
        r13 = r4;
        goto L_0x0036;
    L_0x00cf:
        r0 = 0;
        goto L_0x0039;
    L_0x00d2:
        r0 = r15.f870k;
        if (r0 <= 0) goto L_0x010e;
    L_0x00d6:
        r0 = r15.f870k;
        r7 = r0;
    L_0x00d9:
        r1 = 0;
    L_0x00da:
        if (r1 >= r7) goto L_0x00ff;
    L_0x00dc:
        r3 = 0;
        r0 = 2;
        r2 = r15.f869j;
        r2 = r2 + 1;
        r4 = r1 * r2;
        r2 = r9.length;
        if (r4 < r2) goto L_0x0125;
    L_0x00e7:
        if (r13 == 0) goto L_0x0116;
    L_0x00e9:
        r0 = 98;
        if (r10 != r0) goto L_0x0116;
    L_0x00ed:
        r0 = 12;
        if (r1 != r0) goto L_0x0116;
    L_0x00f1:
        r0 = new com.nxp.taginfolite.b.d;
        r2 = 2;
        r3 = "?";
        r4 = 4;
        r5 = 4;
        r6 = 0;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r8.m147a(r0);
    L_0x00ff:
        if (r13 == 0) goto L_0x0269;
    L_0x0101:
        r0 = new com.nxp.taginfolite.b.o;
        r1 = "\n  x:user locked, *:factory locked, .:unlocked";
        r0.<init>(r1);
        r8.m147a(r0);
    L_0x010b:
        r0 = r8;
        goto L_0x0039;
    L_0x010e:
        r0 = r9.length;
        r1 = r15.f869j;
        r1 = r1 + 1;
        r0 = r0 / r1;
        r7 = r0;
        goto L_0x00d9;
    L_0x0116:
        r0 = new com.nxp.taginfolite.b.n;
        r1 = "\n<aborted: read error>";
        r1 = com.nxp.taginfolite.p003g.C0429j.m1391a(r1);
        r0.<init>(r1);
        r8.m147a(r0);
        goto L_0x00ff;
    L_0x0125:
        if (r13 == 0) goto L_0x0175;
    L_0x0127:
        r2 = r9[r4];
        r2 = r2 & 2;
        if (r2 == 0) goto L_0x0161;
    L_0x012d:
        r2 = "*";
        r14 = r2;
        r2 = r0;
        r0 = r3;
        r3 = r14;
    L_0x0133:
        r6 = 0;
        if (r0 != 0) goto L_0x0141;
    L_0x0136:
        r0 = r4 + 1;
        r4 = r4 + 1;
        r5 = r15.f869j;
        r4 = r4 + r5;
        r6 = java.util.Arrays.copyOfRange(r9, r0, r4);
    L_0x0141:
        r5 = r15.f869j;
        r0 = r15.f869j;
        r4 = 8;
        if (r0 <= r4) goto L_0x0153;
    L_0x0149:
        r0 = r15.f869j;
        r0 = r0 / 2;
        r4 = r15.f869j;
        r4 = r4 % 2;
        r5 = r0 + r4;
    L_0x0153:
        r0 = new com.nxp.taginfolite.b.d;
        r4 = r15.f869j;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r8.m147a(r0);
        r1 = r1 + 1;
        goto L_0x00da;
    L_0x0161:
        r2 = r9[r4];
        r2 = r2 & 2;
        if (r2 == 0) goto L_0x016e;
    L_0x0167:
        r2 = "x";
        r14 = r2;
        r2 = r0;
        r0 = r3;
        r3 = r14;
        goto L_0x0133;
    L_0x016e:
        r2 = ".";
        r14 = r2;
        r2 = r0;
        r0 = r3;
        r3 = r14;
        goto L_0x0133;
    L_0x0175:
        if (r12 == 0) goto L_0x0258;
    L_0x0177:
        r2 = r9[r4];
        r2 = r2 & 1;
        if (r2 == 0) goto L_0x019b;
    L_0x017d:
        r2 = "x";
    L_0x017f:
        if (r11 == 0) goto L_0x0182;
    L_0x0181:
        r0 = 3;
    L_0x0182:
        r5 = r9[r4];
        r5 = r5 & 1;
        if (r5 == 0) goto L_0x01f0;
    L_0x0188:
        r5 = r9[r4];
        r5 = r5 & 6;
        switch(r5) {
            case 0: goto L_0x019e;
            case 1: goto L_0x018f;
            case 2: goto L_0x01b2;
            case 3: goto L_0x018f;
            case 4: goto L_0x01c6;
            case 5: goto L_0x018f;
            case 6: goto L_0x01db;
            default: goto L_0x018f;
        };
    L_0x018f:
        r5 = r9[r4];
        r5 = r5 & 24;
        switch(r5) {
            case 0: goto L_0x0204;
            case 8: goto L_0x0219;
            case 16: goto L_0x022e;
            case 24: goto L_0x0243;
            default: goto L_0x0196;
        };
    L_0x0196:
        r14 = r2;
        r2 = r0;
        r0 = r3;
        r3 = r14;
        goto L_0x0133;
    L_0x019b:
        r2 = ".";
        goto L_0x017f;
    L_0x019e:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r2 = r5.append(r2);
        r5 = "r";
        r2 = r2.append(r5);
        r2 = r2.toString();
        goto L_0x018f;
    L_0x01b2:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r2 = r5.append(r2);
        r5 = "w";
        r2 = r2.append(r5);
        r2 = r2.toString();
        goto L_0x018f;
    L_0x01c6:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r2 = r3.append(r2);
        r3 = "W";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = 1;
        goto L_0x018f;
    L_0x01db:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r2 = r3.append(r2);
        r3 = "R";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = 1;
        goto L_0x018f;
    L_0x01f0:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r2 = r5.append(r2);
        r5 = "w";
        r2 = r2.append(r5);
        r2 = r2.toString();
        goto L_0x018f;
    L_0x0204:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r2 = r5.append(r2);
        r5 = " ";
        r2 = r2.append(r5);
        r2 = r2.toString();
        goto L_0x0196;
    L_0x0219:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r2 = r5.append(r2);
        r5 = "1";
        r2 = r2.append(r5);
        r2 = r2.toString();
        goto L_0x0196;
    L_0x022e:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r2 = r5.append(r2);
        r5 = "2";
        r2 = r2.append(r5);
        r2 = r2.toString();
        goto L_0x0196;
    L_0x0243:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r2 = r5.append(r2);
        r5 = "3";
        r2 = r2.append(r5);
        r2 = r2.toString();
        goto L_0x0196;
    L_0x0258:
        r2 = r9[r4];
        r2 = r2 & 1;
        if (r2 == 0) goto L_0x0266;
    L_0x025e:
        r2 = "x";
    L_0x0260:
        r14 = r2;
        r2 = r0;
        r0 = r3;
        r3 = r14;
        goto L_0x0133;
    L_0x0266:
        r2 = ".";
        goto L_0x0260;
    L_0x0269:
        if (r12 == 0) goto L_0x0277;
    L_0x026b:
        r0 = new com.nxp.taginfolite.b.o;
        r1 = "\n  x:locked, .:unlocked, r/R:read-only,\n  w/W: read+write, R/W: password protected,\n  r/w: free access, 1/2/3: password 1/2/3";
        r0.<init>(r1);
        r8.m147a(r0);
        goto L_0x010b;
    L_0x0277:
        r0 = new com.nxp.taginfolite.b.o;
        r1 = "\n  x:locked, .:unlocked";
        r0.<init>(r1);
        r8.m147a(r0);
        goto L_0x010b;
    L_0x0283:
        r9 = r0;
        r10 = r1;
        r11 = r2;
        r12 = r3;
        r13 = r4;
        goto L_0x0036;
    L_0x028a:
        r9 = r0;
        r10 = r1;
        r11 = r2;
        r12 = r3;
        r13 = r4;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.e.z.f():com.nxp.taginfolite.b.c");
    }

    protected String m897h() {
        StringBuilder stringBuilder = new StringBuilder("0");
        for (int length = this.f862c.getId().length - 1; length >= 0; length--) {
            stringBuilder.append(String.format("%02X", new Object[]{Integer.valueOf(r2[length] & MotionEventCompat.ACTION_MASK)}));
        }
        return "xx-" + new BigInteger(stringBuilder.toString(), 16).toString() + "-x";
    }

    protected byte[] m898i() {
        byte[] a;
        byte[] bArr = null;
        boolean z = true;
        try {
            a = m883a((byte) 43);
        } catch (TagLostException e) {
        } catch (IOException e2) {
            a = null;
        }
        if (!m900k()) {
            if (this.f865f[6] == (byte) 2) {
                try {
                    a = m884a((byte) 43, (byte) 8);
                    if (m900k()) {
                        this.f860a = true;
                    }
                    bArr = a;
                } catch (TagLostException e3) {
                    this.f866g = !m902m();
                } catch (IOException e4) {
                }
            }
            return bArr;
        } else if (this.f865f[6] == (byte) 2 && a != null && (a[0] & 4) == 0) {
            try {
                bArr = m884a((byte) 43, (byte) 8);
                if (m900k()) {
                    this.f860a = true;
                    a = bArr;
                }
                bArr = a;
            } catch (TagLostException e5) {
                if (m902m()) {
                    z = false;
                }
                this.f866g = z;
                bArr = a;
            } catch (IOException e6) {
                bArr = a;
            }
        } else {
            bArr = a;
        }
        int i = 9;
        if (bArr != null) {
            try {
                int i2;
                if ((bArr[0] & 1) != 0) {
                    i = 10;
                    this.f857A = Boolean.valueOf(true);
                } else {
                    this.f857A = Boolean.valueOf(false);
                }
                if ((bArr[0] & 2) != 0) {
                    i2 = i + 1;
                    this.f871l = bArr[i] & MotionEventCompat.ACTION_MASK;
                    this.f885z = Boolean.valueOf(true);
                } else {
                    this.f885z = Boolean.valueOf(false);
                    i2 = i;
                }
                if ((bArr[0] & 4) != 0) {
                    if (this.f860a) {
                        this.f870k = C0429j.m1388a((byte) (bArr[i2 + 1] & 31), bArr[i2]) + 1;
                        this.f869j = (bArr[i2 + 2] & MotionEventCompat.ACTION_MASK) + 1;
                        i2 += 3;
                    } else {
                        i = i2 + 1;
                        this.f870k = (bArr[i2] & MotionEventCompat.ACTION_MASK) + 1;
                        i2 = i + 1;
                        this.f869j = (bArr[i] & 31) + 1;
                    }
                }
                if ((bArr[0] & 8) != 0) {
                    this.f873n = bArr[i2] & MotionEventCompat.ACTION_MASK;
                }
            } catch (ArrayIndexOutOfBoundsException e7) {
            }
        }
        return bArr;
    }

    protected byte[] m899j() {
        boolean z = true;
        try {
            byte[] b = this.f884y ? m892b(0) : m889a(0, 1);
            if (m900k()) {
                return b;
            }
        } catch (TagLostException e) {
            if (m902m()) {
                z = false;
            }
            this.f866g = z;
        } catch (IOException e2) {
        }
        return null;
    }

    protected boolean m900k() {
        return this.f864e == null;
    }

    protected byte[] m901l() {
        Object obj = new byte[11];
        obj[0] = (byte) 36;
        obj[1] = 1;
        obj[2] = (byte) 64;
        System.arraycopy(this.f862c.getId(), 0, obj, 3, 8);
        return this.f863d.transceive(obj);
    }

    protected boolean m902m() {
        try {
            this.f863d.close();
            this.f863d.connect();
            m901l();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    protected byte[] m903n() {
        int i = this.f867h / (this.f869j + 1);
        if ((this.f869j + 1) * i == this.f867h) {
            i--;
        }
        byte b = this.f865f[6];
        if (b == 2) {
            switch (this.f873n) {
                case 90:
                    if (i > 32) {
                        i = 32;
                        break;
                    }
                    break;
            }
        } else if (b == 43 && i > 3) {
            i = 3;
        }
        int i2 = this.f870k > 0 ? this.f870k : MotionEventCompat.ACTION_MASK;
        ByteBuffer allocate = ByteBuffer.allocate((this.f869j + 1) * i2);
        int i3 = 0;
        while (i3 < i2) {
            if (i3 + i > i2) {
                try {
                    byte[] a = m890a(i3, i2 - i3, (byte) 64);
                } catch (IOException e) {
                    if (i3 == 0) {
                        return null;
                    }
                    allocate.rewind();
                    i *= (this.f869j + 1) * i3;
                    byte[] bArr = allocate.remaining() < i ? new byte[allocate.remaining()] : new byte[i];
                    allocate.get(bArr, 0, bArr.length);
                    return bArr;
                }
            }
            a = m890a(i3, i, (byte) 64);
            if (m900k()) {
                allocate.put(a);
                i3 += i;
            } else {
                throw new IOException();
            }
        }
        return allocate.array();
    }

    protected byte[] m904o() {
        int i = this.f870k > 0 ? this.f870k : MotionEventCompat.ACTION_MASK;
        ByteBuffer allocate = ByteBuffer.allocate((this.f869j + 1) * i);
        int i2 = 0;
        while (i2 < i) {
            try {
                byte[] a = m888a(i2, (byte) 64);
                if (m900k()) {
                    allocate.put(a);
                    i2++;
                } else {
                    throw new IOException();
                }
            } catch (IOException e) {
                if (i2 == 0) {
                    return null;
                }
                byte[] bArr = new byte[((this.f869j + 1) * i2)];
                allocate.rewind();
                allocate.get(bArr, 0, bArr.length);
                return bArr;
            }
        }
        return allocate.array();
    }

    protected int m905p() {
        return (this.f868i == null || this.f868i.length <= 0 || (this.f868i[0] & 8) == 0) ? -1 : this.f873n;
    }

    protected String m906q() {
        if (this.f871l == 0) {
            return null;
        }
        String str;
        switch (this.f871l & 240) {
            case C0519c.Switch_thumb /*0*/:
                if (this.f871l == 0) {
                    str = "No application";
                    break;
                }
                switch (this.f871l) {
                    case C0519c.Switch_switchPadding /*7*/:
                        str = "Re-circulating items, returnable assets: in stock";
                        break;
                    default:
                        str = "Proprietary";
                        break;
                }
            case Menu.CATEGORY_SHIFT /*16*/:
                str = "Transport";
                break;
            case C0086R.styleable.SherlockTheme_searchViewCloseIcon /*32*/:
                str = "Financial";
                break;
            case C0086R.styleable.SherlockTheme_windowMinWidthMajor /*48*/:
                str = "Identification";
                break;
            case C0086R.styleable.SherlockTheme_activityChooserViewStyle /*64*/:
                str = "Telecommunication";
                break;
            case 80:
                str = "Medical";
                break;
            case 96:
                str = "Multimedia";
                break;
            case 112:
                str = "Gaming";
                break;
            case AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS /*128*/:
                str = "Data storage";
                break;
            case 144:
                str = "Item management";
                break;
            case 160:
                switch (this.f871l) {
                    case 161:
                        str = "ISO 17367 product tagging";
                        break;
                    case 162:
                        str = "ISO 17365 transport unit";
                        break;
                    case 163:
                        str = "ISO 17364 returnable transport unit";
                        break;
                    case 164:
                        str = "ISO 17367 hazardous materials product tagging";
                        break;
                    case 165:
                        str = "ISO 17366 product packaging";
                        break;
                    case 166:
                        str = "ISO 17366 hazardous materials product packaging";
                        break;
                    case 167:
                        str = "ISO 17365 transport unit containing hazardous materials";
                        break;
                    case 168:
                        str = "ISO 17364 returnable transport unit containing hazardous materials";
                        break;
                    case 169:
                        str = "ISO 17363 freight containers";
                        break;
                    case 170:
                        str = " ISO 17363 freight containers containing hazardous materials";
                        break;
                    default:
                        str = "Express parcels";
                        break;
                }
            case 176:
                str = "Postal services";
                break;
            case 192:
                switch (this.f871l) {
                    case 193:
                        str = "IATA RP1740C baggage handling";
                        break;
                    case 194:
                        str = "Library items: out on loan";
                        break;
                    case 207:
                        str = "Extension code for multiple byte AFI for Item Management";
                        break;
                    default:
                        str = "Airline bags";
                        break;
                }
            case 208:
            case 224:
            case 240:
                str = "[RFU]";
                break;
            default:
                str = "Unknown";
                break;
        }
        return str + String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(this.f871l)});
    }

    protected String m907r() {
        C0428i c0428i = new C0428i();
        if (this.f883x == null || this.f883x[0] != -31) {
            return null;
        }
        int i = this.f883x[1] & 15;
        int i2 = this.f883x[2] & MotionEventCompat.ACTION_MASK;
        int i3 = this.f883x[3] & MotionEventCompat.ACTION_MASK;
        c0428i.m1387b(String.format("Mapping version: %d.%d", new Object[]{Integer.valueOf((r0 >>> 2) & 3), Integer.valueOf(((this.f883x[1] & 240) >> 4) & 3)}));
        if (1 != ((((this.f883x[1] & 240) >> 4) >>> 2) & 3)) {
            c0428i.m1387b(" (ERROR)");
        }
        c0428i.m1383a();
        c0428i.m1387b("Maximum NDEF data size: ");
        if (i2 == 0) {
            c0428i.m1384a((CharSequence) " >2040 bytes");
        } else {
            c0428i.m1387b(String.format("%d bytes", new Object[]{Integer.valueOf(i2 * 8)}));
        }
        c0428i.m1384a(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(i2)}));
        if (this.f865f[6] == (byte) 2) {
        }
        if (this.f865f[6] == 4) {
            c0428i.m1387b("NDEF access: ");
        } else {
            c0428i.m1387b("NDEF access: ");
        }
        switch (i) {
            case C0519c.Switch_thumb /*0*/:
                c0428i.m1387b(C0429j.m1391a((CharSequence) "Read & Write"));
                break;
            case C0519c.Switch_textOn /*2*/:
                c0428i.m1387b("[Proprietary]");
                break;
            case C0519c.Switch_textOff /*3*/:
                c0428i.m1387b("Read-Only");
                break;
            default:
                c0428i.m1387b("[RFU]");
                break;
        }
        c0428i.m1384a(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(i)}));
        switch (i3 & 3) {
            case C0519c.Switch_thumb /*0*/:
                c0428i.m1387b("Supports only Single Block Read");
                break;
            case C0519c.Switch_track /*1*/:
                c0428i.m1387b("Supports Multiple Block Read");
                break;
            case C0519c.Switch_textOn /*2*/:
                c0428i.m1387b("Supports Inventory Page Read");
                break;
            case C0519c.Switch_textOff /*3*/:
                c0428i.m1387b("Supports Multiple Block Read and Inventory Page Read");
                break;
            default:
                c0428i.m1387b("ERROR in read command support");
                break;
        }
        c0428i.m1384a(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(i3)}));
        if ((i3 & 4) != 0) {
            c0428i.m1384a(C0358k.f1076c + "Double Byte Addressing used");
        }
        return c0428i.toString();
    }

    protected void m908s() {
        if (VERSION.SDK_INT >= 14) {
            this.f867h = this.f863d.getMaxTransceiveLength() - 1;
        } else {
            this.f867h = 253;
        }
    }
}
