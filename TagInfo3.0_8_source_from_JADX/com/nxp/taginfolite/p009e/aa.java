package com.nxp.taginfolite.p009e;

import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.tech.NfcA;
import android.support.v4.BuildConfig;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.Menu;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.C0369v;
import com.nxp.taginfolite.p005b.C0182c;
import com.nxp.taginfolite.p005b.C0183d;
import com.nxp.taginfolite.p005b.C0184h;
import com.nxp.taginfolite.p005b.C0193o;
import com.nxp.taginfolite.p005b.C0194n;
import com.nxp.taginfolite.p006c.C0197a;
import com.nxp.taginfolite.p006c.C0198b;
import com.nxp.taginfolite.p006c.C0199c;
import com.nxp.taginfolite.p006c.C0200d;
import java.io.IOException;
import java.util.Arrays;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.aa */
public final class aa implements ay {
    private static final byte[] f387b;
    protected C0182c f388a;
    private Tag f389c;
    private NfcA f390d;
    private boolean f391e;
    private int f392f;
    private int f393g;
    private byte[] f394h;
    private C0158a f395i;
    private byte[] f396j;
    private boolean f397k;

    static {
        f387b = new byte[0];
    }

    public aa() {
        this.f389c = null;
        this.f390d = null;
        this.f391e = false;
        this.f392f = 0;
        this.f393g = 0;
        this.f394h = null;
        this.f395i = null;
        this.f396j = null;
        this.f397k = false;
        this.f388a = null;
    }

    public static ay m413a(Tag tag, C0158a c0158a) {
        int i = 0;
        aa aaVar = new aa();
        aaVar.f389c = tag;
        aaVar.f390d = NfcA.get(tag);
        aaVar.f395i = c0158a;
        if (aaVar.f390d != null) {
            try {
                aaVar.f390d.connect();
                byte[] a = aaVar.m417a((byte) 120, 0, f387b);
                aaVar.f392f = a[0] & MotionEventCompat.ACTION_MASK;
                aaVar.f393g = a[1] & MotionEventCompat.ACTION_MASK;
                aaVar.m415a(aaVar.f395i.m56n());
                if (!(aaVar.f392f == 18 && aaVar.f395i.m56n())) {
                    i = 2;
                }
                aaVar.f396j = Arrays.copyOfRange(aaVar.f394h, i + 8, (i + 8) + 4);
                aaVar.f397k = aaVar.m418e();
                aaVar.f388a = aaVar.m419f();
            } catch (TagLostException e) {
                aaVar.f391e = true;
            } catch (IOException e2) {
            }
            try {
                aaVar.f390d.close();
            } catch (IOException e3) {
            }
        }
        return aaVar;
    }

    private void m414a(C0200d c0200d) {
        C0182c c0182c = new C0182c();
        int i = this.f392f == 18 ? 0 : 2;
        if (this.f394h != null) {
            byte[] bArr = new byte[]{this.f394h[i + 112], this.f394h[(i + 112) + 1]};
            c0182c.m147a(new C0183d(0, 2, "*", Arrays.copyOfRange(this.f394h, i, i + 8)));
            int i2 = 1;
            while (i2 < 15) {
                c0182c.m147a(new C0183d(i2, 2, ((bArr[i2 >= 8 ? 1 : 0] >>> (i2 % 8)) & 1) == 1 ? "*" : ".", Arrays.copyOfRange(this.f394h, (i2 * 8) + i, ((i2 + 1) * 8) + i)));
                i2++;
            }
            if (this.f392f == 18) {
                int length = this.f394h.length;
                for (int i3 = 15; i3 < length / 8; i3++) {
                    c0182c.m147a(new C0183d(i3, 2, " ", Arrays.copyOfRange(this.f394h, (i3 * 8) + i, ((i3 + 1) * 8) + i)));
                }
            }
            c0182c.m147a(new C0194n("\n  *:locked, .:unlocked"));
        }
        c0200d.m237a(c0182c);
    }

    private void m415a(boolean z) {
        int i = 0;
        if (this.f392f == 18 && z) {
            byte[] bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
            while (i < 4) {
                this.f394h = C0429j.m1400a(this.f394h, m417a((byte) 16, i * 16, bArr), 1, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                i++;
            }
            return;
        }
        this.f394h = m417a((byte) 0, 0, f387b);
    }

    public static boolean m416a(NfcA nfcA) {
        byte[] atqa = nfcA.getAtqa();
        return atqa != null && atqa[0] == null && atqa[1] == 12;
    }

    private byte[] m417a(byte b, int i, byte[] bArr) {
        Object obj;
        int i2 = 8;
        switch (b) {
            case C0519c.Switch_thumb /*0*/:
            case C0519c.Switch_track /*1*/:
            case C0086R.styleable.SherlockTheme_textColorPrimaryDisableOnly /*26*/:
            case (byte) 83:
            case (byte) 120:
                obj = new byte[7];
                System.arraycopy(this.f389c.getId(), 0, obj, 3, 4);
                break;
            case C0519c.Switch_textOn /*2*/:
            case Menu.CATEGORY_SHIFT /*16*/:
            case C0086R.styleable.SherlockTheme_textColorPrimaryInverse /*27*/:
            case (byte) 84:
                obj = new byte[14];
                System.arraycopy(this.f389c.getId(), 0, obj, 10, 4);
                break;
            default:
                throw new IOException();
        }
        obj[0] = b;
        switch (b) {
            case C0519c.Switch_track /*1*/:
                break;
            case C0519c.Switch_textOn /*2*/:
            case Menu.CATEGORY_SHIFT /*16*/:
            case C0086R.styleable.SherlockTheme_textColorPrimaryInverse /*27*/:
            case (byte) 84:
                obj[1] = (byte) (i & MotionEventCompat.ACTION_MASK);
                if (bArr.length <= 8) {
                    i2 = bArr.length;
                }
                System.arraycopy(bArr, 0, obj, 2, i2);
                break;
            case C0086R.styleable.SherlockTheme_textColorPrimaryDisableOnly /*26*/:
            case (byte) 83:
                obj[2] = bArr[0];
                break;
        }
        obj[1] = (byte) (i & MotionEventCompat.ACTION_MASK);
        switch (b) {
            case C0519c.Switch_thumb /*0*/:
                i2 = 122;
                break;
            case C0519c.Switch_track /*1*/:
            case C0086R.styleable.SherlockTheme_textColorPrimaryDisableOnly /*26*/:
            case (byte) 83:
                i2 = 2;
                break;
            case C0519c.Switch_textOn /*2*/:
            case C0086R.styleable.SherlockTheme_textColorPrimaryInverse /*27*/:
            case (byte) 84:
                i2 = 9;
                break;
            case Menu.CATEGORY_SHIFT /*16*/:
                i2 = 129;
                break;
            case (byte) 120:
                i2 = 6;
                break;
            default:
                i2 = 0;
                break;
        }
        Object transceive = this.f390d.transceive(obj);
        if (transceive.length >= i2) {
            return transceive;
        }
        obj = new byte[i2];
        System.arraycopy(transceive, 0, obj, 1, transceive.length);
        obj[0] = (byte) i;
        return obj;
    }

    private boolean m418e() {
        int i = (this.f392f == 18 && this.f395i.m56n()) ? 0 : 2;
        i += 112;
        boolean z = this.f394h[i] == (byte) -1 && this.f394h[i + 1] == (byte) -1;
        return this.f392f != 18 ? z : false;
    }

    private C0182c m419f() {
        C0182c c0182c = new C0182c();
        int i = (this.f392f == 18 && this.f395i.m56n()) ? 0 : 2;
        int i2 = 12 + i;
        Object obj = null;
        Object obj2 = null;
        while (obj == null) {
            int i3 = this.f394h[i2] & MotionEventCompat.ACTION_MASK;
            switch (i3) {
                case C0519c.Switch_thumb /*0*/:
                case 253:
                    break;
                case C0519c.Switch_track /*1*/:
                case C0519c.Switch_textOn /*2*/:
                    obj2 = 1;
                    break;
                case C0519c.Switch_textOff /*3*/:
                case 254:
                    obj = 1;
                    break;
                default:
                    obj = 1;
                    break;
            }
            if (obj != null) {
                return c0182c;
            }
            int i4;
            Object obj3;
            if (obj2 != null) {
                C0428i c0428i = new C0428i();
                int i5 = i2 - i;
                if (i3 == 1) {
                    c0428i.m1387b("Lock Control TLV ");
                } else if (i3 == 2) {
                    c0428i.m1387b("Memory Control TLV ");
                }
                c0428i.m1384a(String.format("at block 0x%02X, offset %d", new Object[]{Integer.valueOf(i5 / 8), Integer.valueOf(i5 % 8)}));
                i2++;
                int i6 = i2 + 1;
                if ((this.f394h[i2] & MotionEventCompat.ACTION_MASK) != 3) {
                    c0428i.m1384a(String.format(C0358k.f1076c + "Wrong length: %d", new Object[]{Integer.valueOf(this.f394h[i2] & MotionEventCompat.ACTION_MASK)}));
                    c0182c.m147a(new C0193o(c0428i.toString()));
                    return c0182c;
                }
                int[] iArr = new int[3];
                int i7 = i6 + 1;
                iArr[0] = this.f394h[i6] & MotionEventCompat.ACTION_MASK;
                int i8 = i7 + 1;
                iArr[1] = this.f394h[i7] & MotionEventCompat.ACTION_MASK;
                iArr[2] = this.f394h[i8] & MotionEventCompat.ACTION_MASK;
                byte[] bArr = new byte[]{(byte) i3, (byte) i2, (byte) iArr[0], (byte) iArr[1], (byte) iArr[2]};
                int i9 = (iArr[0] >> 4) & 15;
                i7 = iArr[0] & 15;
                i2 = iArr[1];
                if (i2 == 0) {
                    i2 = AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
                }
                int i10 = ((1 << (iArr[2] & 15)) * i9) + i7;
                c0428i.m1387b(C0358k.f1076c);
                if (i3 == 1) {
                    c0428i.m1387b("Dynamic lock bytes ");
                } else {
                    c0428i.m1387b("Reserved area ");
                }
                c0428i.m1384a(String.format("at block 0x%02X, offset %d", new Object[]{Integer.valueOf(i10 / 8), Integer.valueOf(i10 % 8)}));
                if (i3 == 1) {
                    c0428i.m1384a(String.format("\t\u2022 %d lock bits<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(i2), Integer.valueOf(iArr[1])}));
                    i2 = 1 << ((iArr[2] >> 4) & 15);
                    c0428i.m1384a(String.format("\t\u2022 %d bytes locked per lock bit<hexoutput> (0x%X)", new Object[]{Integer.valueOf(i2), Integer.valueOf((iArr[2] >> 4) & 15)}));
                } else {
                    c0428i.m1384a(String.format("\t\u2022 Reserved area length: %d bytes<hexoutput> (0x%02X)", new Object[]{Integer.valueOf(i2), Integer.valueOf(iArr[1])}));
                }
                c0428i.m1384a((CharSequence) "\t\u2022 Address calculation:");
                c0428i.m1384a(String.format("\t\t~ page address: 0x%X", new Object[]{Integer.valueOf(i9)}));
                c0428i.m1384a(String.format("\t\t~ byte offset: 0x%X", new Object[]{Integer.valueOf(i7)}));
                c0428i.m1384a(C0429j.m1391a(String.format("\t\t~ %d bytes per page (1<<0x%X)", new Object[]{Integer.valueOf(1 << r12), Integer.valueOf(r12)})) + "</hexoutput>");
                c0182c.m147a(new C0193o(c0428i.toString()));
                c0182c.m147a(new C0184h(-1, bArr));
                i4 = i8 + 1;
                obj3 = null;
            } else if (i3 == 0) {
                obj3 = obj2;
                i4 = i2 + 1;
            } else {
                i3 = i2 + 1;
                i2 = this.f394h[i3] & MotionEventCompat.ACTION_MASK;
                if (i2 == MotionEventCompat.ACTION_MASK) {
                    i2 = i3 + 1;
                    i3 = i2 + 1;
                    i2 = ((this.f394h[i2] & MotionEventCompat.ACTION_MASK) * AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) + (this.f394h[i3] & MotionEventCompat.ACTION_MASK);
                }
                i2 = (i2 + 1) + i3;
                obj3 = obj2;
                i4 = i2;
            }
            obj = i4 >= 96 ? 1 : obj;
            i2 = i4;
            obj2 = obj3;
        }
        return c0182c;
    }

    public void m420a(C0197a c0197a, boolean z) {
        CharSequence charSequence = this.f392f == 18 ? "512 bytes\n" + C0358k.f1076c + "64 blocks, with 8 bytes per block" : "120 bytes\n" + C0358k.f1076c + "15 blocks, with 8 bytes per block";
        if (this.f397k) {
            c0197a.m197b("Memory information", charSequence + "\nMemory is locked");
        } else {
            c0197a.m193a(charSequence);
        }
    }

    public void m421a(C0198b c0198b, boolean z) {
        if (this.f396j != null && this.f396j.length >= 4 && this.f396j[0] == -31) {
            StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
            int i = this.f396j[1] & MotionEventCompat.ACTION_MASK;
            int i2 = this.f396j[2] & MotionEventCompat.ACTION_MASK;
            int i3 = this.f396j[3] & MotionEventCompat.ACTION_MASK;
            stringBuilder.append("NDEF memory map: ");
            if ((this.f392f & 15) == 1) {
                stringBuilder.append("Static\n");
            } else {
                stringBuilder.append("Dynamic\n");
            }
            stringBuilder.append(String.format("Mapping version: %d.%d", new Object[]{Integer.valueOf((i >>> 4) & 15), Integer.valueOf(i & 15)}));
            if (1 != ((i >>> 4) & 15)) {
                stringBuilder.append(" (ERROR)\n");
            } else {
                stringBuilder.append("\n");
            }
            stringBuilder.append(String.format("Maximum NDEF data size: %d bytes", new Object[]{Integer.valueOf((i2 + 1) * 8)}));
            stringBuilder.append(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(i2)}));
            stringBuilder.append("\nNDEF access: ");
            if (i3 == 0) {
                stringBuilder.append(C0429j.m1391a((CharSequence) "Read & Write"));
            } else if (i3 == 15) {
                stringBuilder.append("Read-Only");
            } else {
                stringBuilder.append("[unknown]");
            }
            stringBuilder.append(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(i3)}));
            c0198b.m219b("NDEF Capability Container (CC)", stringBuilder.toString());
            c0198b.m217b(new C0182c().m147a(new C0184h(-1, this.f396j)));
        }
        if (this.f388a != null) {
            c0198b.m220c(this.f388a);
        }
    }

    public void m422a(C0199c c0199c, boolean z) {
        c0199c.m230d("Broadcom Corporation");
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        Object d = m427d();
        if (this.f392f == 17) {
            stringBuilder.append("Topaz (");
            stringBuilder.append(d);
            stringBuilder.append(")");
        } else if (this.f392f == 18) {
            stringBuilder.append("Topaz-512 (");
            stringBuilder.append(d);
            stringBuilder.append(")");
        } else if (TextUtils.isEmpty(d)) {
            stringBuilder.append("Unknown Jewel IC");
        } else {
            stringBuilder.append("Jewel ");
            stringBuilder.append(d);
        }
        c0199c.m231e(stringBuilder.toString());
    }

    public void m423a(C0200d c0200d, boolean z) {
        c0200d.m238a((CharSequence) "ISO/IEC 14443-3 (Type A) compatible\nISO/IEC 14443-2 (Type A) compatible");
        C0369v.m1098a(this.f390d, c0200d, this.f392f, this.f393g);
        if (this.f395i.m56n()) {
            m414a(c0200d);
        }
    }

    public boolean m424a() {
        return false;
    }

    public boolean m425b() {
        return this.f391e;
    }

    public byte[] m426c() {
        return this.f389c.getId();
    }

    public String m427d() {
        if (this.f392f == 17) {
            return "BCM20203T96 or IRT5011";
        }
        if (this.f392f == 18) {
            return "BCM20203T512 or TPZ-505-016";
        }
        if (this.f392f == 1 && this.f393g == 0) {
            return "IRT101DA";
        }
        if (this.f392f == 1 && this.f393g == 60) {
            return "IRT5001";
        }
        if (this.f392f <= 1 || this.f392f >= 7) {
            return null;
        }
        return String.format("IRT50%02X", new Object[]{Integer.valueOf(this.f392f)});
    }
}
