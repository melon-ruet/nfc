package com.nxp.taginfolite.p009e;

import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.support.v4.BuildConfig;
import android.support.v4.os.EnvironmentCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.p003g.C0422a;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0351d;
import com.nxp.taginfolite.p004f.C0353f;
import com.nxp.taginfolite.p004f.C0355h;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.C0360m;
import com.nxp.taginfolite.p004f.C0361n;
import com.nxp.taginfolite.p004f.C0362o;
import com.nxp.taginfolite.p004f.C0369v;
import com.nxp.taginfolite.p004f.p019d.C0347a;
import com.nxp.taginfolite.p005b.C0182c;
import com.nxp.taginfolite.p005b.C0185e;
import com.nxp.taginfolite.p005b.C0193o;
import com.nxp.taginfolite.p005b.C0194n;
import com.nxp.taginfolite.p006c.C0197a;
import com.nxp.taginfolite.p006c.C0199c;
import com.nxp.taginfolite.p006c.C0200d;
import com.nxp.taginfolite.p009e.p011b.C0254a;
import com.nxp.taginfolite.p009e.p011b.C0256c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.crypto.spec.SecretKeySpec;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.c */
public final class C0271c extends C0270w {
    private C0307f f661k;
    private C0308g f662l;
    private boolean f663m;
    private byte[] f664n;
    private byte[] f665o;
    private int f666p;
    private List f667q;
    private byte[] f668r;
    private int f669s;
    private List f670t;
    private byte[] f671u;
    private boolean f672v;
    private boolean f673w;

    public C0271c() {
        this.f661k = C0307f.UNKNOWN;
        this.f662l = C0308g.UNKNOWN;
        this.f663m = false;
        this.f664n = null;
        this.f665o = null;
        this.f666p = 0;
        this.f667q = null;
        this.f668r = null;
        this.f669s = -1;
        this.f670t = null;
        this.f671u = null;
        this.f672v = false;
        this.f673w = true;
    }

    private byte[] m672A() {
        return m691c((byte) 96);
    }

    private byte[] m673B() {
        return m691c((byte) 110);
    }

    private List m674C() {
        List arrayList = new ArrayList();
        byte[] bArr = new byte[]{(byte) 109};
        byte[] j;
        do {
            j = m699j(m661h().transceive(C0271c.m698i(bArr)));
            if (j == null || j.length == 0 || (j.length == 1 && j[0] == null)) {
                return arrayList;
            }
            if (m695f(j)) {
                bArr = new byte[]{j[1], j[2], j[3]};
                byte[] bArr2 = new byte[]{j[4], j[5]};
                byte[] copyOfRange = Arrays.copyOfRange(j, 6, j.length);
                arrayList.add(new byte[][]{bArr, bArr2, copyOfRange});
                bArr = new byte[]{(byte) -81};
            }
        } while (j[0] == (byte) -81);
        return arrayList;
    }

    private List m675D() {
        List arrayList = new ArrayList();
        if (m694e(this.f665o)) {
            int length = (this.f665o.length - 1) / 3;
            for (int i = 0; i < length; i++) {
                byte[] bArr = new byte[]{this.f665o[(i * 3) + 1], this.f665o[(i * 3) + 2], this.f665o[(i * 3) + 3]};
                if (m694e(m693d(bArr))) {
                    byte[] c = m691c((byte) 97);
                    if (m694e(c) && c.length > 1) {
                        int length2 = (c.length - 1) / 2;
                        Object obj = new byte[(length2 + 1)][];
                        obj[0] = Arrays.copyOf(bArr, bArr.length);
                        for (int i2 = 0; i2 < length2; i2++) {
                            obj[i2 + 1] = new byte[]{c[(i2 * 2) + 1], c[(i2 * 2) + 2]};
                        }
                        arrayList.add(obj);
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean m676E() {
        boolean z = true;
        Object obj = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        SecretKeySpec secretKeySpec = new SecretKeySpec(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, "DESede");
        byte[] bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        try {
            byte[] j = m699j(m661h().transceive(C0271c.m698i(new byte[]{(byte) 10, (byte) 0})));
            if (j[0] != -81) {
                return false;
            }
            j = C0353f.m1056a(Arrays.copyOfRange(j, 1, 9), 2, secretKeySpec, bArr);
            Object a = C0353f.m1056a(new byte[]{j[1], j[2], j[3], j[4], j[5], j[6], j[7], j[0]}, 2, secretKeySpec, bArr);
            Object obj2 = new byte[(obj.length + a.length)];
            System.arraycopy(obj, 0, obj2, 0, obj.length);
            System.arraycopy(a, 0, obj2, obj.length, a.length);
            obj = new byte[(obj2.length + 1)];
            obj[0] = (byte) -81;
            System.arraycopy(obj2, 0, obj, 1, obj2.length);
            if (m697h(obj)[0] != null) {
                z = false;
            }
            return z;
        } catch (IOException e) {
            return false;
        } catch (GeneralSecurityException e2) {
            return false;
        }
    }

    private String m677F() {
        C0428i c0428i = new C0428i();
        byte[] bArr = this.f664n;
        if (bArr == null || bArr.length < 29) {
            return null;
        }
        c0428i.m1387b("Vendor ID: ");
        CharSequence a = C0355h.m1064a(bArr[1] & MotionEventCompat.ACTION_MASK);
        if (TextUtils.isEmpty(a)) {
            c0428i.m1387b("[unknown]");
        } else {
            c0428i.m1387b(a);
        }
        c0428i.m1384a(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[1])}));
        c0428i.m1384a((CharSequence) "Hardware info:");
        c0428i.m1384a(String.format(C0358k.f1076c + "Type/subtype: 0x%02X/0x%02X", new Object[]{Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])}));
        c0428i.m1384a(String.format(C0358k.f1076c + "Version: %d.%d", new Object[]{Integer.valueOf(bArr[4] & MotionEventCompat.ACTION_MASK), Integer.valueOf(bArr[5] & MotionEventCompat.ACTION_MASK)}));
        String num = Integer.toString(1 << ((bArr[6] & MotionEventCompat.ACTION_MASK) >> 1));
        if ((bArr[6] & 1) != 0) {
            num = ">" + num;
        }
        c0428i.m1387b(C0358k.f1076c + "Storage size: " + num + " bytes");
        c0428i.m1384a(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[6])}));
        c0428i.m1387b(C0358k.f1076c + "Protocol: ");
        switch (bArr[7] & MotionEventCompat.ACTION_MASK) {
            case C0519c.Switch_switchTextAppearance /*5*/:
                c0428i.m1387b("ISO/IEC 14443-2 and -3");
                break;
            default:
                c0428i.m1387b("[unknown]");
                break;
        }
        c0428i.m1384a(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[7])}));
        c0428i.m1384a((CharSequence) "Software info:");
        c0428i.m1384a(String.format(C0358k.f1076c + "Type/subtype: 0x%02X/0x%02X", new Object[]{Byte.valueOf(bArr[9]), Byte.valueOf(bArr[10])}));
        c0428i.m1384a(String.format(C0358k.f1076c + "Version: %d.%d", new Object[]{Integer.valueOf(bArr[11] & MotionEventCompat.ACTION_MASK), Integer.valueOf(bArr[12] & MotionEventCompat.ACTION_MASK)}));
        num = Integer.toString(1 << ((bArr[13] & MotionEventCompat.ACTION_MASK) >> 1));
        if ((bArr[13] & 1) != 0) {
            num = ">" + num;
        }
        c0428i.m1387b(C0358k.f1076c + "Storage size: " + num + " bytes");
        c0428i.m1384a(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[13])}));
        c0428i.m1387b(C0358k.f1076c + "Protocol: ");
        switch (bArr[14] & MotionEventCompat.ACTION_MASK) {
            case C0519c.Switch_switchTextAppearance /*5*/:
                c0428i.m1387b("ISO/IEC 14443-3 and -4");
                break;
            default:
                c0428i.m1387b("[unknown]");
                break;
        }
        c0428i.m1384a(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[14])}));
        c0428i.m1387b("Batch no: ");
        c0428i.m1384a(String.format("0x%02X%02X%02X%02X%02X", new Object[]{Byte.valueOf(bArr[22]), Byte.valueOf(bArr[23]), Byte.valueOf(bArr[24]), Byte.valueOf(bArr[25]), Byte.valueOf(bArr[26])}));
        if ((bArr[27] & 15) > 9 || (bArr[28] & 15) > 9 || this.f662l == C0308g.SMX_EMU) {
            c0428i.m1387b(String.format("Production date: week %02d, 20%02d", new Object[]{Integer.valueOf(bArr[27] & MotionEventCompat.ACTION_MASK), Integer.valueOf(bArr[28] & MotionEventCompat.ACTION_MASK)}));
        } else {
            c0428i.m1387b(String.format("Production date: week %02X, 20%02X", new Object[]{Byte.valueOf(bArr[27]), Byte.valueOf(bArr[28])}));
        }
        c0428i.m1384a(String.format("<hexoutput> (0x%02X%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[27]), Byte.valueOf(bArr[28])}));
        return c0428i.toString();
    }

    private String m678G() {
        C0428i c0428i = new C0428i();
        C0428i c0428i2 = new C0428i();
        if (!m694e(this.f665o)) {
            return null;
        }
        for (int i = 1; i < this.f665o.length; i += 3) {
            CharSequence g = m696g(new byte[]{this.f665o[i], this.f665o[i + 1], this.f665o[i + 2]});
            if (TextUtils.isEmpty(g)) {
                this.f666p++;
                c0428i2.m1384a(String.format(C0358k.f1076c + "Unknown application 0x%02X%02X%02X", new Object[]{Byte.valueOf(this.f665o[i + 2]), Byte.valueOf(this.f665o[i + 1]), Byte.valueOf(this.f665o[i])}));
            } else {
                c0428i.m1387b(C0429j.m1391a(g));
                c0428i.m1384a(String.format("<hexoutput> (0x%02X%02X%02X)</hexoutput>", new Object[]{Byte.valueOf(this.f665o[i + 2]), Byte.valueOf(this.f665o[i + 1]), Byte.valueOf(this.f665o[i])}));
            }
        }
        if (this.f666p > 0) {
            String str = "%s%d unknown application%s";
            Object[] objArr = new Object[3];
            objArr[0] = c0428i.toString().isEmpty() ? BuildConfig.VERSION_NAME : "and ";
            objArr[1] = Integer.valueOf(this.f666p);
            objArr[2] = this.f666p == 1 ? BuildConfig.VERSION_NAME : "s";
            c0428i.m1387b(String.format(str, objArr));
            c0428i.m1384a("<hexoutput>:\n" + c0428i2.toString() + "</hexoutput>");
        }
        return c0428i.toString();
    }

    private String m679H() {
        C0428i c0428i = new C0428i();
        C0428i c0428i2 = new C0428i();
        this.f666p = 0;
        if (m694e(this.f665o)) {
            if (this.f667q != null) {
                c0428i.m1384a(m684a(this.f667q, c0428i2));
            }
            for (int i = 1; i < this.f665o.length; i += 3) {
                boolean z;
                byte[] bArr = new byte[]{this.f665o[i], this.f665o[i + 1], this.f665o[i + 2]};
                if (this.f667q != null) {
                    z = false;
                    for (byte[][] bArr2 : this.f667q) {
                        z = Arrays.equals(bArr, bArr2[0]);
                        if (z) {
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    CharSequence g = m696g(bArr);
                    if (TextUtils.isEmpty(g)) {
                        this.f666p++;
                        c0428i2.m1384a(String.format("Unknown application 0x%02X%02X%02X", new Object[]{Byte.valueOf(bArr[2]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[0])}));
                    } else {
                        c0428i.m1387b(C0429j.m1391a(g));
                        c0428i.m1384a(String.format("<hexoutput> (0x%02X%02X%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[2]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[0])}));
                    }
                }
            }
        } else {
            c0428i.m1384a(m684a(this.f667q, c0428i2));
        }
        if (this.f666p > 0) {
            String str = "%s%d unknown application%s";
            Object[] objArr = new Object[3];
            objArr[0] = c0428i.toString().isEmpty() ? BuildConfig.VERSION_NAME : "and ";
            objArr[1] = Integer.valueOf(this.f666p);
            objArr[2] = this.f666p == 1 ? BuildConfig.VERSION_NAME : "s";
            c0428i.m1387b(String.format(str, objArr));
            c0428i.m1384a("<hexoutput>:\n" + c0428i2.toString() + "</hexoutput>");
        }
        return c0428i.toString();
    }

    private String m680I() {
        int i;
        int i2;
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        List<byte[][]> arrayList = new ArrayList();
        if (this.f667q != null) {
            i = 0;
            for (byte[][] bArr : this.f667q) {
                if (i != 0) {
                    stringBuilder.append("\n");
                }
                stringBuilder.append(String.format("%02X%02X%02X : %02X%02X : ", new Object[]{Byte.valueOf(bArr[0][2]), Byte.valueOf(bArr[0][1]), Byte.valueOf(bArr[0][0]), Byte.valueOf(bArr[1][1]), Byte.valueOf(bArr[1][0])}));
                if (bArr[2] == null || bArr[2].length <= 0) {
                    stringBuilder.append("[no ISO DF-name]");
                } else {
                    int length = bArr[2].length;
                    for (i = 0; i < length; i++) {
                        stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(r4[i])}));
                    }
                }
                for (byte[][] bArr2 : this.f670t) {
                    if (Arrays.equals(bArr2[0], bArr[0])) {
                        stringBuilder.append("\n").append(C0358k.f1076c);
                        String str = "Contains ISO FID%s: %02X%02X";
                        Object[] objArr = new Object[3];
                        objArr[0] = bArr2.length > 2 ? "s" : BuildConfig.VERSION_NAME;
                        objArr[1] = Byte.valueOf(bArr2[1][1]);
                        objArr[2] = Byte.valueOf(bArr2[1][0]);
                        stringBuilder.append(String.format(str, objArr));
                        if (bArr2.length > 2) {
                            for (i2 = 2; i2 < bArr2.length; i2++) {
                                stringBuilder.append(String.format(", %02X%02X", new Object[]{Byte.valueOf(bArr2[i2][1]), Byte.valueOf(bArr2[i2][0])}));
                            }
                        }
                    } else {
                        arrayList.add(bArr2);
                    }
                }
                i = 1;
            }
        } else {
            i = 0;
        }
        for (byte[][] bArr3 : arrayList) {
            if (i != 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(String.format("%02X%02X%02X", new Object[]{Byte.valueOf(bArr3[0][2]), Byte.valueOf(bArr3[0][1]), Byte.valueOf(bArr3[0][0])}));
            stringBuilder.append("\n").append(C0358k.f1076c);
            String str2 = "FID%s: %02X%02X";
            Object[] objArr2 = new Object[3];
            objArr2[0] = bArr3.length > 2 ? "s" : BuildConfig.VERSION_NAME;
            objArr2[1] = Byte.valueOf(bArr3[1][1]);
            objArr2[2] = Byte.valueOf(bArr3[1][0]);
            stringBuilder.append(String.format(str2, objArr2));
            if (bArr3.length > 2) {
                for (i2 = 2; i2 < bArr3.length; i2++) {
                    stringBuilder.append(String.format(", %02X%02X", new Object[]{Byte.valueOf(bArr3[i2][1]), Byte.valueOf(bArr3[i2][0])}));
                }
            }
        }
        return stringBuilder.toString();
    }

    private C0182c m681a(byte b, C0306e c0306e) {
        int i = 1;
        byte[] bArr = new byte[]{(byte) 0, b, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        byte[] bArr2 = new byte[]{(byte) 108, b};
        byte[] bArr3 = null;
        switch (C0292d.f745a[c0306e.ordinal()]) {
            case C0519c.Switch_textOn /*2*/:
                bArr[0] = (byte) -67;
                bArr3 = m697h(bArr);
                break;
            case C0519c.Switch_textOff /*3*/:
                bArr3 = m697h(bArr2);
                break;
            case C0519c.Switch_thumbTextPadding /*4*/:
                bArr[0] = (byte) -69;
                bArr3 = m697h(bArr);
                break;
        }
        C0182c c0182c = new C0182c();
        if (m694e(bArr3)) {
            c0182c.m147a(new C0193o("    ~ Contents:\n"));
            int length = bArr3.length;
            while (i + 16 < length) {
                c0182c.m147a(new C0185e(i - 1, Arrays.copyOfRange(bArr3, i, i + 16)));
                i += 16;
            }
            c0182c.m147a(new C0185e(i - 1, Arrays.copyOfRange(bArr3, i, length)));
        } else {
            c0182c.m147a(new C0193o("    ~ (No access)"));
        }
        return c0182c;
    }

    public static C0271c m682a(Tag tag, IsoDep isoDep, C0158a c0158a) {
        int i = 2;
        boolean z = false;
        C0271c c0271c = new C0271c();
        c0271c.m641a(tag);
        c0271c.a = isoDep;
        c0271c.f662l = C0308g.UNKNOWN;
        c0271c.f661k = C0307f.UNKNOWN;
        c0271c.f666p = 0;
        c0271c.f = c0158a;
        try {
            isoDep.connect();
            c0271c.m708z();
            c0271c.f664n = c0271c.m672A();
            if (c0271c.f664n != null) {
                if (c0271c.f664n.length > 4) {
                    switch (c0271c.f664n[4]) {
                        case C0519c.Switch_thumb /*0*/:
                            c0271c.f662l = C0308g.DESFIRE_D40;
                            c0271c.f663m = true;
                            break;
                        case C0519c.Switch_track /*1*/:
                            switch (c0271c.f664n[2]) {
                                case (byte) -127:
                                    c0271c.f662l = C0308g.SMX_EMU;
                                    break;
                                case C0519c.Switch_track /*1*/:
                                    c0271c.f662l = C0308g.DESFIRE_EV1;
                                    break;
                                default:
                                    break;
                            }
                        case C0086R.styleable.SherlockTheme_actionModePopupWindowStyle /*18*/:
                            c0271c.f662l = C0308g.DESFIRE_EV2;
                            break;
                    }
                    if (c0271c.f664n[1] != (byte) 4) {
                        c0271c.f662l = C0308g.UNKNOWN;
                    }
                }
                if (c0271c.f664n.length > 6) {
                    switch (c0271c.f664n[6]) {
                        case C0086R.styleable.SherlockTheme_selectableItemBackground /*20*/:
                            c0271c.f662l = C0308g.NTAG401;
                            c0271c.f661k = C0307f.OneK;
                            break;
                        case C0086R.styleable.SherlockTheme_textAppearanceLargePopupMenu /*22*/:
                            c0271c.f661k = C0307f.TwoK;
                            break;
                        case C0086R.styleable.SherlockTheme_textAppearanceSmall /*24*/:
                            c0271c.f661k = C0307f.FourK;
                            break;
                        case C0086R.styleable.SherlockTheme_textColorPrimaryDisableOnly /*26*/:
                            c0271c.f661k = C0307f.EightK;
                            break;
                    }
                }
                if (c0271c.f664n.length > 26) {
                    byte[] a = C0362o.m1079a(c0271c.f664n, 22);
                    if (a != null && C0429j.m1404b(a)) {
                        z = true;
                    }
                    c0271c.f673w = z;
                }
            }
            c0271c.m708z();
            NfcA nfcA;
            if (c0271c.f662l == C0308g.DESFIRE_EV1 && c0271c.f661k == C0307f.FourK && c0271c.m701s()) {
                c0271c.f662l = C0308g.LEGIC_ATC4096;
                c0271c.f668r = c0271c.m702t();
                isoDep.close();
                if (!c0271c.m714e()) {
                    nfcA = NfcA.get(isoDep.getTag());
                    if (nfcA != null) {
                        nfcA.connect();
                        c0271c.h = C0351d.m1037a(nfcA);
                        nfcA.close();
                        nfcA.connect();
                        nfcA.close();
                    }
                    isoDep.connect();
                    c0271c.m708z();
                    isoDep.close();
                }
                return c0271c;
            }
            if (c0271c.f662l != C0308g.SMX_EMU) {
                if (c0271c.f663m) {
                    i = 1;
                }
                if (i == 1) {
                    c0271c.m648a(c0271c.i, i, c0158a, true);
                } else {
                    c0271c.m648a(c0271c.j, i, c0158a, true);
                }
            }
            c0271c.m661h().close();
            c0271c.m661h().connect();
            if (!(c0271c.f662l == C0308g.NTAG401 || c0271c.f662l == C0308g.LEGIC_ATC4096)) {
                c0271c.f672v = c0271c.m676E();
                c0271c.f665o = c0271c.m697h(new byte[]{(byte) 106});
                if (!c0271c.f663m) {
                    byte[] B = c0271c.m673B();
                    if (c0271c.m694e(B)) {
                        c0271c.f669s = C0429j.m1389a(B[3], B[2], B[1]);
                    }
                }
                c0271c.f667q = c0271c.m674C();
                c0271c.f670t = c0271c.m675D();
                c0271c.e.m1384a(c0271c.m703u());
                c0271c.e.m1384a(c0271c.m704v());
                c0271c.e.m1384a(c0271c.m705w());
                c0271c.e.m1384a(c0271c.m685a(C0256c.f574e, "Istanbulkart (Istanbul public transport card)" + C0361n.f1092c));
                c0271c.e.m1384a(c0271c.m685a(C0256c.f576g, "Delhi Metro Travel Card" + C0361n.f1092c));
                c0271c.e.m1384a(c0271c.m685a(C0256c.f580k, "Melbourne myki public transport card" + C0361n.f1092c));
                c0271c.e.m1384a(c0271c.m685a(C0256c.f571b, "Transport for London Oyster card" + C0361n.f1092c));
                c0271c.e.m1384a(c0271c.m685a(C0256c.f572c, "Dubai Nol card" + C0361n.f1092c));
                c0271c.e.m1384a(c0271c.m685a(C0256c.f575f, "Helsinki public transport (HSL) card" + C0361n.f1092c));
                c0271c.e.m1384a(c0271c.m685a(C0256c.f577h, "Transport for NSW Opal card" + C0361n.f1092c));
                c0271c.e.m1384a(c0271c.m706x());
                c0271c.e.m1384a(c0271c.m685a(C0256c.f585p, "PG Bank Flexicard"));
                c0271c.e.m1384a(c0271c.m688b(C0256c.f586q, "Bank Mega card"));
                c0271c.e.m1384a(c0271c.m688b(C0256c.f588s, "Antwerp city pass"));
            }
            if (c0158a.m56n()) {
                c0271c.d = c0271c.m707y();
            }
            try {
                isoDep.close();
            } catch (IOException e) {
            }
            if (c0271c.m714e()) {
                nfcA = NfcA.get(isoDep.getTag());
                if (nfcA != null) {
                    try {
                        nfcA.connect();
                        c0271c.h = C0351d.m1037a(nfcA);
                    } catch (TagLostException e2) {
                        c0271c.c = true;
                    } catch (IOException e3) {
                    }
                    try {
                        nfcA.close();
                    } catch (IOException e4) {
                    }
                    try {
                        nfcA.connect();
                    } catch (TagLostException e5) {
                        c0271c.c = true;
                    } catch (IOException e6) {
                    }
                    try {
                        nfcA.close();
                    } catch (IOException e7) {
                    }
                }
                try {
                    isoDep.connect();
                    c0271c.m708z();
                } catch (IOException e8) {
                }
                try {
                    isoDep.close();
                } catch (IOException e9) {
                }
            }
            return c0271c;
        } catch (TagLostException e10) {
            c0271c.c = true;
        } catch (IOException e11) {
        }
    }

    private String m683a(C0308g c0308g) {
        Object obj = 1;
        if (c0308g == C0308g.DESFIRE_EV1) {
            if (this.f664n[3] != (byte) 2) {
                obj = null;
            }
            switch (C0292d.f746b[this.f661k.ordinal()]) {
                case C0519c.Switch_track /*1*/:
                    return obj != null ? "MF3ICDH81" : "MF3ICD81";
                case C0519c.Switch_textOn /*2*/:
                    return obj != null ? "MF3ICDH41" : "MF3ICD41";
                case C0519c.Switch_textOff /*3*/:
                    return obj != null ? "MF3ICDH21" : "MF3ICD21";
                default:
                    return BuildConfig.VERSION_NAME;
            }
        } else if (c0308g == C0308g.DESFIRE_EV2) {
            if (this.f664n[3] != (byte) 2) {
                obj = null;
            }
            switch (C0292d.f746b[this.f661k.ordinal()]) {
                case C0519c.Switch_track /*1*/:
                    return obj != null ? "MF3DH82" : "MF3D82";
                case C0519c.Switch_textOn /*2*/:
                    return obj != null ? "MF3DH42" : "MF3D42";
                case C0519c.Switch_textOff /*3*/:
                    return obj != null ? "MF3DH22" : "MF3D22";
                default:
                    return BuildConfig.VERSION_NAME;
            }
        } else if (c0308g != C0308g.SMX_EMU) {
            return c0308g == C0308g.LEGIC_ATC4096 ? "ATC4096-MP" : "MF3ICD40";
        } else {
            switch (C0292d.f746b[this.f661k.ordinal()]) {
                case C0519c.Switch_track /*1*/:
                    return "P5CD041/081 or P5CN081";
                case C0519c.Switch_textOn /*2*/:
                case C0519c.Switch_textOff /*3*/:
                    return "P5CD016/021/041/081 or P5CN081";
                default:
                    return BuildConfig.VERSION_NAME;
            }
        }
    }

    private String m684a(List list, C0428i c0428i) {
        C0428i c0428i2 = new C0428i();
        for (byte[][] bArr : list) {
            int i;
            byte[] bArr2 = bArr[0];
            byte[] bArr3 = bArr[2];
            CharSequence charSequence = (String) C0256c.f590u.get(new C0422a(bArr3));
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = m696g(bArr2);
                if (TextUtils.isEmpty(charSequence)) {
                    this.f666p++;
                    i = 0;
                } else {
                    c0428i2.m1387b(C0429j.m1391a(charSequence));
                    i = 1;
                }
            } else {
                c0428i2.m1387b(C0429j.m1391a(charSequence));
                i = 0;
            }
            if (charSequence != null) {
                c0428i2.m1387b("<hexoutput> (0x");
                if (bArr3 == null || bArr3.length <= 0 || r2 != 0) {
                    c0428i2.m1387b(C0429j.m1393a(bArr2, BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME));
                } else {
                    c0428i2.m1387b(C0429j.m1393a(bArr3, BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME));
                }
                c0428i2.m1384a((CharSequence) ")</hexoutput>");
            } else {
                c0428i.m1387b("Unknown application ");
                if (bArr3 == null || bArr3.length <= 0) {
                    c0428i.m1387b(C0429j.m1393a(bArr2, "0x", BuildConfig.VERSION_NAME));
                } else {
                    if (C0429j.m1404b(bArr3)) {
                        c0428i.m1387b("\"");
                        i = bArr3.length;
                        for (int i2 = 0; i2 < i; i2++) {
                            c0428i.m1387b(String.format("%c", new Object[]{Character.valueOf((char) bArr3[i2])}));
                        }
                        c0428i.m1387b("\" (");
                    }
                    c0428i.m1387b(C0429j.m1393a(bArr3, "0x", BuildConfig.VERSION_NAME));
                    if (C0429j.m1404b(bArr3)) {
                        c0428i.m1387b(")");
                    }
                }
                c0428i.m1383a();
            }
        }
        return c0428i2.toString();
    }

    private String m685a(byte[] bArr, String str) {
        m708z();
        return m694e(m693d(bArr)) ? str : BuildConfig.VERSION_NAME;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m686a(android.nfc.tech.IsoDep r8) {
        /*
        r7 = -81;
        r6 = -111; // 0xffffffffffffff91 float:NaN double:NaN;
        r0 = 1;
        r1 = 0;
        r2 = 4;
        r2 = new byte[r2];
        r2 = {90, 0, 0, 0};
        r3 = new byte[r0];
        r4 = 96;
        r3[r1] = r4;
        r8.connect();	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        r2 = com.nxp.taginfolite.p009e.C0271c.m698i(r2);	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        r2 = r8.transceive(r2);	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        if (r2 == 0) goto L_0x0053;
    L_0x001f:
        r4 = r2.length;	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        r5 = 2;
        if (r4 < r5) goto L_0x0053;
    L_0x0023:
        r4 = r2.length;	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        r4 = r4 + -1;
        r4 = r2[r4];	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        if (r4 != 0) goto L_0x0053;
    L_0x002a:
        r4 = r2.length;	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        r4 = r4 + -2;
        r4 = r2[r4];	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        if (r4 != r6) goto L_0x0053;
    L_0x0031:
        r2 = com.nxp.taginfolite.p009e.C0271c.m698i(r3);	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        r2 = r8.transceive(r2);	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        if (r2 == 0) goto L_0x006f;
    L_0x003b:
        r3 = r2.length;	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        r4 = 9;
        if (r3 != r4) goto L_0x006f;
    L_0x0040:
        r3 = r2.length;	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        r3 = r3 + -1;
        r3 = r2[r3];	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        if (r3 != r7) goto L_0x006f;
    L_0x0047:
        r3 = r2.length;	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        r3 = r3 + -2;
        r2 = r2[r3];	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        if (r2 != r6) goto L_0x006f;
    L_0x004e:
        r1 = r0;
    L_0x004f:
        r8.close();	 Catch:{ IOException -> 0x0085 }
    L_0x0052:
        return r1;
    L_0x0053:
        if (r2 == 0) goto L_0x006f;
    L_0x0055:
        r4 = r2.length;	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        if (r4 != r0) goto L_0x006f;
    L_0x0058:
        r4 = 0;
        r2 = r2[r4];	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        r4 = 28;
        if (r2 != r4) goto L_0x006f;
    L_0x005f:
        r2 = r8.transceive(r3);	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        if (r2 == 0) goto L_0x006f;
    L_0x0065:
        r3 = r2.length;	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        r4 = 8;
        if (r3 != r4) goto L_0x006f;
    L_0x006a:
        r3 = 0;
        r2 = r2[r3];	 Catch:{ TagLostException -> 0x0071, IOException -> 0x007b }
        if (r2 == r7) goto L_0x004e;
    L_0x006f:
        r0 = r1;
        goto L_0x004e;
    L_0x0071:
        r0 = move-exception;
        r8.close();	 Catch:{ IOException -> 0x0079 }
        r8.connect();	 Catch:{ IOException -> 0x0079 }
        goto L_0x004f;
    L_0x0079:
        r0 = move-exception;
        goto L_0x004f;
    L_0x007b:
        r0 = move-exception;
        r8.close();	 Catch:{ IOException -> 0x0083 }
        r8.connect();	 Catch:{ IOException -> 0x0083 }
        goto L_0x004f;
    L_0x0083:
        r0 = move-exception;
        goto L_0x004f;
    L_0x0085:
        r0 = move-exception;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.e.c.a(android.nfc.tech.IsoDep):boolean");
    }

    private C0182c m687b(byte b) {
        C0182c c0182c = new C0182c();
        C0428i c0428i = new C0428i();
        c0428i.m1387b(String.format("\n  \u2022 File ID 0x%02X: ", new Object[]{Byte.valueOf(b)}));
        byte[] h = m697h(new byte[]{(byte) -11, b});
        if (m694e(h)) {
            C0306e c0306e = C0306e.UNKNOWN;
            switch (h[1] & MotionEventCompat.ACTION_MASK) {
                case C0519c.Switch_thumb /*0*/:
                    c0428i.m1384a(String.format("Standard data, %d bytes", new Object[]{Integer.valueOf(C0429j.m1389a(h[7], h[6], h[5]))}));
                    c0306e = C0306e.DATA;
                    break;
                case C0519c.Switch_track /*1*/:
                    c0428i.m1384a(String.format("Backup data, %d bytes", new Object[]{Integer.valueOf(C0429j.m1389a(h[7], h[6], h[5]))}));
                    c0306e = C0306e.DATA;
                    break;
                case C0519c.Switch_textOn /*2*/:
                    c0428i.m1384a((CharSequence) "Value data");
                    Object[] objArr = new Object[1];
                    objArr[0] = Long.valueOf(C0429j.m1390a(h[8], h[7], h[6], h[5]));
                    c0428i.m1384a(String.format("    ~ Lower limit: %d", objArr));
                    objArr = new Object[1];
                    objArr[0] = Long.valueOf(C0429j.m1390a(h[12], h[11], h[10], h[9]));
                    c0428i.m1384a(String.format("    ~ Upper limit: %d", objArr));
                    String str = "    ~ Limited credit %sallowed";
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = h[17] != null ? BuildConfig.VERSION_NAME : "not ";
                    c0428i.m1384a(String.format(str, objArr2));
                    if (h[17] != null) {
                        objArr = new Object[1];
                        objArr[0] = Long.valueOf(C0429j.m1390a(h[16], h[15], h[14], h[13]));
                        c0428i.m1384a(String.format("    ~ Max. limited credit value: %d", objArr));
                    }
                    c0306e = C0306e.VALUE;
                    break;
                case C0519c.Switch_textOff /*3*/:
                    c0428i.m1384a(String.format("Linear record, %d records", new Object[]{Integer.valueOf(C0429j.m1389a(h[13], h[12], h[11]))}));
                    c0428i.m1384a(String.format("    ~ Record size: %d bytes", new Object[]{Integer.valueOf(C0429j.m1389a(h[7], h[6], h[5]))}));
                    c0428i.m1384a(String.format("    ~ Max. no. of records: %d", new Object[]{Integer.valueOf(C0429j.m1389a(h[10], h[9], h[8]))}));
                    c0306e = C0306e.RECORD;
                    break;
                case C0519c.Switch_thumbTextPadding /*4*/:
                    c0428i.m1384a(String.format("Cyclic record file, %d records", new Object[]{Integer.valueOf(C0429j.m1389a(h[13], h[12], h[11]))}));
                    c0428i.m1384a(String.format("    ~ Record size: %d bytes", new Object[]{Integer.valueOf(C0429j.m1389a(h[7], h[6], h[5]))}));
                    c0428i.m1384a(String.format("    ~ Max. no. of records: %d", new Object[]{Integer.valueOf(C0429j.m1389a(h[10], h[9], h[8]))}));
                    c0306e = C0306e.RECORD;
                    break;
                default:
                    c0428i.m1384a(EnvironmentCompat.MEDIA_UNKNOWN);
                    break;
            }
            c0428i.m1387b("    ~ Communication: ");
            switch (h[2] & 3) {
                case C0519c.Switch_thumb /*0*/:
                case C0086R.styleable.SherlockTheme_searchViewCloseIcon /*32*/:
                    c0428i.m1384a((CharSequence) "plain");
                    break;
                case C0519c.Switch_track /*1*/:
                    c0428i.m1384a((CharSequence) "with MAC");
                    break;
                case C0519c.Switch_textOff /*3*/:
                    c0428i.m1384a((CharSequence) "encrypted");
                    c0306e = C0306e.UNKNOWN;
                    break;
                default:
                    c0428i.m1384a(EnvironmentCompat.MEDIA_UNKNOWN);
                    break;
            }
            c0428i.m1384a("    ~ Read key: " + m690c((h[4] >>> 4) & 15));
            c0428i.m1384a("    ~ Write key: " + m690c(h[4] & 15));
            c0428i.m1384a("    ~ Read/Write key: " + m690c((h[3] >>> 4) & 15));
            c0428i.m1384a("    ~ Change key: " + m690c(h[3] & 15));
            c0182c.m147a(new C0193o(c0428i.toString()));
            c0182c.m148a(m681a(b, c0306e));
        } else {
            c0428i.m1384a(String.format("\n    ~ Error 0x%02X: %s", new Object[]{Byte.valueOf(h[0]), m692d(h[0])}));
            c0182c.m147a(new C0193o(c0428i.toString()));
        }
        return c0182c;
    }

    private String m688b(byte[] bArr, String str) {
        if (this.f667q != null) {
            for (byte[][] bArr2 : this.f667q) {
                if (Arrays.equals(bArr, bArr2[2])) {
                    return str;
                }
            }
        }
        return BuildConfig.VERSION_NAME;
    }

    private C0193o m689c(byte[] bArr) {
        C0428i c0428i = new C0428i();
        boolean equals = Arrays.equals(bArr, C0256c.f570a);
        if (equals) {
            c0428i.m1384a((CharSequence) "PICC level (Application ID 0x000000)");
            if (m676E()) {
                c0428i.m1384a(C0358k.f1077d + "Default PICC master key");
            }
        } else {
            c0428i.m1387b(String.format("\nApplication ID 0x%02X%02X%02X", new Object[]{Byte.valueOf(bArr[2]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[0])}));
            CharSequence charSequence = (String) C0256c.f589t.get(new C0422a(bArr));
            if (charSequence != null) {
                c0428i.m1387b(" (" + C0429j.m1391a(charSequence) + ")");
            }
            c0428i.m1383a();
            if (m676E()) {
                c0428i.m1384a(C0358k.f1077d + "Default master key");
            }
        }
        String str = equals ? "PICC key" : "Master key";
        byte[] c = m691c((byte) 69);
        C0428i c0428i2 = new C0428i();
        CharSequence charSequence2 = BuildConfig.VERSION_NAME;
        int i;
        int i2;
        if (m694e(c) && c.length > 2) {
            String str2 = C0358k.f1077d + "%s configuration:" + "<hexoutput>" + " (0x%02X%02X)" + "</hexoutput>";
            Object[] objArr = new Object[3];
            objArr[0] = equals ? str : "Key";
            objArr[1] = Byte.valueOf(c[1]);
            objArr[2] = Byte.valueOf(c[2]);
            c0428i.m1384a(String.format(str2, objArr));
            i = c[2] & 63;
            if (!equals) {
                if (i > 0) {
                    c0428i2.m1387b(String.format("  \u2022 %d ", new Object[]{Integer.valueOf(i)}));
                    switch (c[2] & 192) {
                        case C0519c.Switch_thumb /*0*/:
                            c0428i2.m1387b("(3)DES key");
                            i2 = 0;
                            break;
                        case C0086R.styleable.SherlockTheme_activityChooserViewStyle /*64*/:
                            c0428i2.m1387b("3k3DES key");
                            i2 = 0;
                            break;
                        case AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS /*128*/:
                            c0428i2.m1387b("AES key");
                            i2 = 1;
                            break;
                        default:
                            c0428i2.m1387b("key");
                            i2 = 0;
                            break;
                    }
                    if (i == 1) {
                        c0428i2.m1383a();
                    } else {
                        c0428i2.m1384a((CharSequence) "s");
                    }
                    if (i > 0) {
                        c0428i2.m1387b("  \u2022 " + str);
                        if ((c[1] & 1) == 0) {
                            c0428i2.m1384a((CharSequence) " changeable");
                        } else {
                            c0428i2.m1384a((CharSequence) " frozen");
                        }
                        c0428i2.m1384a("  \u2022 " + str + " required for:");
                        c0428i2.m1387b("    ~ directory list access: ");
                        if ((c[1] & 2) == 0) {
                            c0428i2.m1384a((CharSequence) "no");
                        } else {
                            c0428i2.m1384a((CharSequence) "yes");
                        }
                        if (equals) {
                            c0428i2.m1387b("    ~ create/delete files: ");
                        } else {
                            c0428i2.m1387b("    ~ create/delete applications: ");
                        }
                        if ((c[1] & 4) == 0) {
                            c0428i2.m1384a((CharSequence) "no");
                        } else {
                            c0428i2.m1384a((CharSequence) "yes");
                        }
                        c0428i2.m1387b("  \u2022 Configuration ");
                        if ((c[1] & 8) == 0) {
                            c0428i2.m1384a((CharSequence) "changeable");
                        } else {
                            c0428i2.m1384a((CharSequence) "frozen");
                        }
                        if (!equals && i > 1) {
                            switch ((c[1] >> 4) & 15) {
                                case C0519c.Switch_thumb /*0*/:
                                    c0428i2.m1384a((CharSequence) "  \u2022 Master key required for changing a key");
                                    break;
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
                                case C0086R.styleable.SherlockTheme_actionModeCloseButtonStyle /*13*/:
                                    c0428i2.m1384a("  \u2022 " + String.format("Key #%d", new Object[]{Integer.valueOf((c[1] >> 4) & 15)}) + " required for changing keys");
                                    break;
                                case C0086R.styleable.SherlockTheme_actionModeBackground /*14*/:
                                    c0428i2.m1384a((CharSequence) "  \u2022 Key itself required for changing a key");
                                    break;
                                case C0086R.styleable.SherlockTheme_actionModeSplitBackground /*15*/:
                                    c0428i2.m1384a((CharSequence) "  \u2022 All application keys frozen");
                                    break;
                            }
                        }
                    }
                }
                c0428i2.m1384a((CharSequence) "  \u2022 No keys configured");
            }
            i2 = 0;
            if (i > 0) {
                c0428i2.m1387b("  \u2022 " + str);
                if ((c[1] & 1) == 0) {
                    c0428i2.m1384a((CharSequence) " frozen");
                } else {
                    c0428i2.m1384a((CharSequence) " changeable");
                }
                c0428i2.m1384a("  \u2022 " + str + " required for:");
                c0428i2.m1387b("    ~ directory list access: ");
                if ((c[1] & 2) == 0) {
                    c0428i2.m1384a((CharSequence) "yes");
                } else {
                    c0428i2.m1384a((CharSequence) "no");
                }
                if (equals) {
                    c0428i2.m1387b("    ~ create/delete files: ");
                } else {
                    c0428i2.m1387b("    ~ create/delete applications: ");
                }
                if ((c[1] & 4) == 0) {
                    c0428i2.m1384a((CharSequence) "yes");
                } else {
                    c0428i2.m1384a((CharSequence) "no");
                }
                c0428i2.m1387b("  \u2022 Configuration ");
                if ((c[1] & 8) == 0) {
                    c0428i2.m1384a((CharSequence) "frozen");
                } else {
                    c0428i2.m1384a((CharSequence) "changeable");
                }
                switch ((c[1] >> 4) & 15) {
                    case C0519c.Switch_thumb /*0*/:
                        c0428i2.m1384a((CharSequence) "  \u2022 Master key required for changing a key");
                        break;
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
                    case C0086R.styleable.SherlockTheme_actionModeCloseButtonStyle /*13*/:
                        c0428i2.m1384a("  \u2022 " + String.format("Key #%d", new Object[]{Integer.valueOf((c[1] >> 4) & 15)}) + " required for changing keys");
                        break;
                    case C0086R.styleable.SherlockTheme_actionModeBackground /*14*/:
                        c0428i2.m1384a((CharSequence) "  \u2022 Key itself required for changing a key");
                        break;
                    case C0086R.styleable.SherlockTheme_actionModeSplitBackground /*15*/:
                        c0428i2.m1384a((CharSequence) "  \u2022 All application keys frozen");
                        break;
                }
            }
        }
        c0428i2.m1384a(String.format("  \u2022 Key configuration unavailable (%s)", new Object[]{m692d(c[0])}));
        i = -1;
        i2 = 0;
        byte[] h;
        if (!equals && r1 != 0 && i > 1) {
            c0428i2.m1384a((CharSequence) "  \u2022 Key versions:");
            for (int i3 = 0; i3 < i; i3++) {
                h = m697h(new byte[]{(byte) 100, (byte) i3});
                if (i3 == 0) {
                    c0428i2.m1387b("    ~ Master key: ");
                } else {
                    c0428i2.m1387b(String.format("    ~ Key #%d: ", new Object[]{Integer.valueOf(i3)}));
                }
                if (!m694e(h) || h.length <= 1) {
                    c0428i2.m1384a((CharSequence) "[unavailable]");
                } else {
                    c0428i2.m1384a(String.format("%d", new Object[]{Integer.valueOf(h[1] & MotionEventCompat.ACTION_MASK)}));
                }
            }
        } else if (equals || (r1 != 0 && i == 1)) {
            h = m697h(new byte[]{(byte) 100, (byte) 0});
            if (!m694e(h) || h.length <= 1) {
                c0428i2.m1384a("  \u2022 " + str + " version: [unavailable]");
            } else {
                String str3;
                i = h[1] & MotionEventCompat.ACTION_MASK;
                if (this.f663m) {
                    str3 = "  \u2022 (3)DES key";
                } else if (i > 0) {
                    str3 = "  \u2022 AES key";
                } else {
                    CharSequence charSequence3 = charSequence2;
                }
                c0428i2.m1387b("  \u2022 " + str + " version: ");
                c0428i2.m1384a(String.format("%d", new Object[]{Integer.valueOf(i)}));
                charSequence2 = str3;
            }
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            c0428i.m1384a(charSequence2);
        }
        c0428i.m1387b(c0428i2.toString());
        return new C0193o(c0428i.toString());
    }

    private String m690c(int i) {
        if ((i & MotionEventCompat.ACTION_MASK) == 0) {
            return "master key<hexoutput> (0x00)</hexoutput>";
        }
        if ((i & MotionEventCompat.ACTION_MASK) == 14) {
            return "free access<hexoutput> (0x0E)</hexoutput>";
        }
        if ((i & MotionEventCompat.ACTION_MASK) == 15) {
            return "blocked<hexoutput> (0x0F)</hexoutput>";
        }
        return String.format("key #%d", new Object[]{Integer.valueOf(i)});
    }

    private byte[] m691c(byte b) {
        return m697h(new byte[]{b});
    }

    private String m692d(byte b) {
        String str = (String) C0254a.f555a.get(b);
        if (str != null) {
            return str;
        }
        return String.format("Unknown status<hexoutput> (0x%02X)</hexoutput>", new Object[]{Byte.valueOf(b)});
    }

    private byte[] m693d(byte[] bArr) {
        if (bArr == null || bArr.length != 3) {
            return null;
        }
        return m697h(new byte[]{(byte) 90, bArr[0], bArr[1], bArr[2]});
    }

    private boolean m694e(byte[] bArr) {
        return bArr != null && bArr.length > 0 && bArr[0] == null;
    }

    private boolean m695f(byte[] bArr) {
        return (bArr == null || bArr.length <= 0) ? false : bArr[0] == null || bArr[0] == -81;
    }

    private String m696g(byte[] bArr) {
        String str = (String) C0256c.f589t.get(new C0422a(bArr));
        if ((bArr[2] & 240) != 240) {
            return str;
        }
        String[] c = C0347a.m1020c((C0429j.m1388a((byte) (bArr[2] & 15), bArr[1]) * 16) + ((bArr[0] >>> 4) & 15));
        if (c == null) {
            return str;
        }
        return c[0] + String.format(" #%d\n", new Object[]{Integer.valueOf(bArr[0] & 15)}) + C0358k.f1076c + c[1];
    }

    private byte[] m697h(byte[] bArr) {
        byte[] j = m699j(m661h().transceive(C0271c.m698i(bArr)));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(j);
        while (j[0] == (byte) -81) {
            j = m699j(m661h().transceive(C0271c.m698i(new byte[]{(byte) -81})));
            byteArrayOutputStream.write(j, 1, j.length - 1);
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        toByteArray[0] = j[0];
        return toByteArray;
    }

    private static byte[] m698i(byte[] bArr) {
        byte[] bArr2;
        if (bArr.length > 1) {
            bArr2 = new byte[(bArr.length + 5)];
            bArr2[4] = (byte) (bArr.length - 1);
            System.arraycopy(bArr, 1, bArr2, 5, bArr.length - 1);
        } else {
            bArr2 = new byte[5];
        }
        bArr2[0] = (byte) -112;
        bArr2[1] = bArr[0];
        bArr2[2] = (byte) 0;
        bArr2[3] = (byte) 0;
        bArr2[bArr2.length - 1] = (byte) 0;
        return bArr2;
    }

    private byte[] m699j(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            if (bArr == null || bArr.length != 1) {
                return new byte[]{(byte) -54};
            } else if (bArr[0] == null) {
                return bArr;
            } else {
                this.f671u = bArr;
                return bArr;
            }
        } else if (bArr[bArr.length - 2] != -111) {
            return new byte[]{(byte) -54};
        } else {
            Object obj = new byte[(bArr.length - 1)];
            obj[0] = bArr[bArr.length - 1];
            System.arraycopy(bArr, 0, obj, 1, bArr.length - 2);
            return obj;
        }
    }

    private String m700k(byte[] bArr) {
        C0428i c0428i = new C0428i();
        String str = "Size: %s%d\u200akB";
        Object[] objArr = new Object[2];
        objArr[0] = (bArr[6] & 1) == 1 ? ">" : BuildConfig.VERSION_NAME;
        objArr[1] = Integer.valueOf((1 << ((bArr[6] >>> 1) & MotionEventCompat.ACTION_MASK)) / AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        c0428i.m1384a(String.format(str, objArr));
        if (this.f669s >= AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT) {
            c0428i.m1387b(String.format(Locale.US, "Available: %01.1f\u200akB", new Object[]{Float.valueOf(((float) this.f669s) / 1024.0f)}));
            c0428i.m1384a(String.format("<hexoutput> (%d bytes)</hexoutput>", new Object[]{Integer.valueOf(this.f669s)}));
        } else if (this.f669s >= 0) {
            c0428i.m1384a(String.format("Available: %d bytes", new Object[]{Integer.valueOf(this.f669s)}));
        }
        return c0428i.toString();
    }

    private boolean m701s() {
        return m694e(m693d(C0256c.f581l));
    }

    private byte[] m702t() {
        byte[] h = m697h(new byte[]{(byte) -67, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 20, (byte) 0, (byte) 0});
        return (h == null || h.length <= 0 || h[0] != null) ? null : Arrays.copyOfRange(h, 1, h.length);
    }

    private String m703u() {
        C0428i c0428i = new C0428i();
        m708z();
        if (m694e(m693d(C0256c.f578i))) {
            c0428i.m1384a((CharSequence) "ORCA public transport card");
            if (!m694e(m697h(new byte[]{(byte) -67, (byte) 4, (byte) 41, (byte) 0, (byte) 0, (byte) 2, (byte) 0, (byte) 0}))) {
                return c0428i.toString();
            }
            if (m694e(m693d(C0256c.f587r))) {
                if (!m694e(m697h(new byte[]{(byte) -67, (byte) 15, (byte) 5, (byte) 0, (byte) 0, (byte) 3, (byte) 0, (byte) 0}))) {
                    return c0428i.toString();
                }
                c0428i.m1384a(String.format(C0358k.f1076c + "Card no: %d", new Object[]{Integer.valueOf(C0429j.m1389a(r2[1], r2[2], r2[3]))}));
            }
            c0428i.m1384a(String.format(Locale.US, C0358k.f1076c + "Current value: $%.2f", new Object[]{Double.valueOf(((double) C0429j.m1388a(r1[1], r1[2])) / 100.0d)}));
        }
        return c0428i.toString();
    }

    private String m704v() {
        C0428i c0428i = new C0428i();
        m708z();
        if (m694e(m693d(C0256c.f579j))) {
            c0428i.m1384a((CharSequence) "Clipper public transport card");
            byte[] h = m697h(new byte[]{(byte) -67, (byte) 2, (byte) 18, (byte) 0, (byte) 0, (byte) 2, (byte) 0, (byte) 0});
            if (!m694e(h)) {
                return c0428i.toString();
            }
            if (!m694e(m697h(new byte[]{(byte) -67, (byte) 8, (byte) 1, (byte) 0, (byte) 0, (byte) 4, (byte) 0, (byte) 0}))) {
                return c0428i.toString();
            }
            StringBuilder append = new StringBuilder().append(C0358k.f1076c);
            Object[] objArr = new Object[1];
            objArr[0] = Long.valueOf(C0429j.m1390a(r2[1], r2[2], r2[3], r2[4]));
            c0428i.m1384a(append.append(String.format("Card no: %d", objArr)).toString());
            StringBuilder append2 = new StringBuilder().append(C0358k.f1076c);
            Object[] objArr2 = new Object[1];
            objArr2[0] = Double.valueOf(((double) ((short) ((h[2] & MotionEventCompat.ACTION_MASK) | ((h[1] & MotionEventCompat.ACTION_MASK) << 8)))) / 100.0d);
            c0428i.m1384a(append2.append(String.format("Current value: $%01.2f", objArr2)).toString());
        }
        return c0428i.toString();
    }

    private String m705w() {
        C0428i c0428i = new C0428i();
        m708z();
        if (m694e(m693d(C0256c.f573d))) {
            c0428i.m1384a((CharSequence) "Norway public transport card");
            byte[] h = m697h(new byte[]{(byte) -67, (byte) 12, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0});
            if (!m694e(h) || h.length < 11) {
                return c0428i.toString();
            }
            if ((((h[1] & MotionEventCompat.ACTION_MASK) << 2) | ((h[2] & 192) >> 6)) != 578) {
                return c0428i.toString();
            }
            if ((h[2] & 63) != 0 || (h[3] & MotionEventCompat.ACTION_MASK) != 0 || (h[4] & 252) != 0) {
                return c0428i.toString();
            }
            if ((h[4] & 3) != 2) {
                return c0428i.toString();
            }
            long a = C0429j.m1390a(h[5], h[6], h[7], h[8]);
            int i = ((h[10] & MotionEventCompat.ACTION_MASK) >> 2) | ((h[9] & MotionEventCompat.ACTION_MASK) << 6);
            Calendar instance = Calendar.getInstance();
            instance.clear();
            instance.set(1, 1997);
            instance.set(6, i);
            c0428i.m1384a(C0358k.f1076c + String.format("Card no: %d", new Object[]{Long.valueOf(a)}));
            c0428i.m1384a(C0358k.f1076c + String.format("Valid till: %s %s %d %d", new Object[]{C0358k.f1074a[instance.get(7) - 1], C0358k.f1075b[instance.get(2)], Integer.valueOf(instance.get(5)), Integer.valueOf(instance.get(1))}));
        }
        return c0428i.toString();
    }

    private String m706x() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 1; i4 < this.f665o.length && (i3 == 0 || i2 == 0 || i == 0); i4 += 3) {
            byte[] bArr = new byte[]{this.f665o[i4], this.f665o[i4 + 1], this.f665o[i4 + 2]};
            if (Arrays.equals(bArr, C0256c.f582m)) {
                i3 = 1;
            }
            if (Arrays.equals(bArr, C0256c.f583n)) {
                i2 = 1;
            }
            if (Arrays.equals(bArr, C0256c.f584o)) {
                i = 1;
            }
        }
        return (i3 == 0 || i2 == 0 || i == 0) ? BuildConfig.VERSION_NAME : "PingPing payment tag";
    }

    private C0182c m707y() {
        C0182c c0182c = new C0182c();
        try {
            m708z();
            c0182c.m147a(m689c(C0256c.f570a));
            byte[] h = m697h(new byte[]{(byte) 106});
            if (m694e(h)) {
                int length = (h.length - 1) / 3;
                for (int i = 0; i < length; i++) {
                    byte[] bArr = new byte[]{h[(i * 3) + 1], h[(i * 3) + 2], h[(i * 3) + 3]};
                    if (m694e(m693d(bArr))) {
                        c0182c.m147a(m689c(bArr));
                        byte[] c = m691c((byte) 111);
                        if (m694e(c) && c.length > 1) {
                            int length2 = c.length - 1;
                            String str = length2 != 1 ? "s" : BuildConfig.VERSION_NAME;
                            if (length2 > 0) {
                                c0182c.m147a(new C0193o(String.format(C0358k.f1077d + "%d file" + str + " present", new Object[]{Integer.valueOf(length2)})));
                            } else {
                                c0182c.m147a(new C0193o(C0358k.f1077d + "No files present"));
                            }
                            for (int i2 = 0; i2 < length2; i2++) {
                                c0182c.m148a(m687b(c[i2 + 1]));
                            }
                        } else if (m694e(c) && c.length == 1) {
                            c0182c.m147a(new C0193o(C0358k.f1077d + "No files present"));
                        } else {
                            c0182c.m147a(new C0193o(String.format(C0358k.f1077d + "No file information (%s)", new Object[]{m692d(c[0])})));
                        }
                    }
                }
                return c0182c;
            }
            c0182c.m147a(new C0193o("No application information available"));
            return c0182c;
        } catch (TagLostException e) {
            c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "<aborted: tag disappeared>")));
            this.c = true;
        } catch (IOException e2) {
            c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "<aborted: read error>")));
        }
    }

    private byte[] m708z() {
        return m693d(C0256c.f570a);
    }

    public void m709a(C0197a c0197a, boolean z) {
        CharSequence charSequence;
        byte[] bArr = this.f664n;
        if (bArr != null && bArr.length >= 7) {
            charSequence = "Memory size";
            if (this.f662l == C0308g.DESFIRE_EV1 || this.f662l == C0308g.SMX_EMU) {
                charSequence = this.f662l == C0308g.SMX_EMU ? "DESFire memory information" : "Memory information";
                CharSequence k = m700k(bArr);
                if (this.f662l == C0308g.SMX_EMU) {
                    c0197a.m199c(charSequence, k);
                } else {
                    c0197a.m197b(charSequence, k);
                }
            } else {
                c0197a.m197b(charSequence, String.format("%d\u200akB", new Object[]{Integer.valueOf((1 << ((bArr[6] >>> 1) & MotionEventCompat.ACTION_MASK)) / AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT)}));
            }
            charSequence = BuildConfig.VERSION_NAME;
            switch (bArr[3]) {
                case C0519c.Switch_track /*1*/:
                    charSequence = "Capacitance: 17\u200apF";
                    break;
                case C0519c.Switch_textOn /*2*/:
                    charSequence = "Capacitance: 70\u200apF";
                    break;
            }
            c0197a.m198c(charSequence);
        }
        charSequence = "Version information";
        if (this.f662l == C0308g.LEGIC_ATC4096) {
            c0197a.m203e("EF-CONF file", C0429j.m1409e(this.f668r));
        } else {
            if (this.f662l == C0308g.SMX_EMU) {
                charSequence = "DESFire version information";
            }
            c0197a.m201d(charSequence, m677F());
        }
        if (this.f662l == C0308g.DESFIRE_EV1 || this.f662l == C0308g.SMX_EMU) {
            c0197a.m205f("DESFire App. ID : ISO-FID : ISO DF-Name", m680I());
        }
        byte[] historicalBytes = this.a.getHistoricalBytes();
        bArr = (historicalBytes == null || historicalBytes.length == 0) ? C0351d.m1042c(this.h) : historicalBytes;
        charSequence = BuildConfig.VERSION_NAME;
        if (bArr != null && bArr.length == 1 && bArr[0] == -113) {
            charSequence = "Possibly interrupted Format PICC command occurred";
        }
        if (this.f671u != null) {
            charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? BuildConfig.VERSION_NAME : "\n") + ((String) C0254a.f555a.get(this.f671u[0]));
        }
        if (!TextUtils.isEmpty(charSequence)) {
            c0197a.m195a((CharSequence) "Reported error", charSequence);
        }
        if (this.f672v) {
            c0197a.m203e("Authentication information", "Default PICC master key");
        }
        c0197a.m206g(C0351d.m1034a(bArr, this.b.getId()));
    }

    public void m710a(C0199c c0199c, boolean z) {
        CharSequence charSequence;
        if (this.f662l == C0308g.LEGIC_ATC4096) {
            charSequence = "LEGIC Identsystems Ltd";
        } else {
            byte[] id = this.b.getId();
            charSequence = (id == null || id.length != 7) ? "NXP Semiconductors" : C0355h.m1067b(id, C0360m.DESFIRE);
        }
        c0199c.m230d(charSequence);
        Object a = C0429j.m1391a(m713d());
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        if (this.f662l == C0308g.DESFIRE_EV1) {
            stringBuilder.append("MIFARE DESFire EV1");
            if (!TextUtils.isEmpty(a)) {
                stringBuilder.append(" (");
                stringBuilder.append(a);
                stringBuilder.append(")");
            }
        } else if (this.f662l == C0308g.NTAG401) {
            stringBuilder.append("MIFARE DESFire EV1");
        } else if (this.f662l == C0308g.SMX_EMU) {
            stringBuilder.append("SmartMX");
            if (!TextUtils.isEmpty(a)) {
                stringBuilder.append(" (").append(a).append(")");
            }
        } else if (this.f662l == C0308g.LEGIC_ATC4096) {
            stringBuilder.append(a);
        } else {
            stringBuilder.append("MIFARE DESFire");
            if (!TextUtils.isEmpty(a)) {
                stringBuilder.append(" (").append(a).append(")");
            }
        }
        c0199c.m231e(stringBuilder.toString());
        if (this.f662l != C0308g.LEGIC_ATC4096) {
            charSequence = "DESFire Applications";
            if (this.f662l == C0308g.DESFIRE_EV1 || this.f662l == C0308g.SMX_EMU) {
                if (this.f662l == C0308g.SMX_EMU) {
                    charSequence = "MIFARE " + charSequence;
                }
                CharSequence G = (this.f667q == null || this.f667q.isEmpty()) ? m678G() : m679H();
                if (!TextUtils.isEmpty(G)) {
                    c0199c.m228b(charSequence, G);
                } else if (this.f662l == C0308g.SMX_EMU) {
                    c0199c.m228b(charSequence, "No known MIFARE DESFire applications found");
                }
            } else {
                c0199c.m228b(charSequence, m678G());
            }
            c0199c.m227b(this.e.toString());
        }
    }

    public void m711a(C0200d c0200d, boolean z) {
        C0428i c0428i = new C0428i();
        c0428i.m1384a((CharSequence) "ISO/IEC 7816-4 compatible");
        if (!(this.f662l == C0308g.LEGIC_ATC4096 || this.f662l == C0308g.NTAG401)) {
            c0428i.m1384a((CharSequence) "Native DESFire APDU framing");
        }
        c0428i.m1384a((CharSequence) "ISO/IEC 14443-4 (Type A) compatible");
        c0428i.m1384a((CharSequence) "ISO/IEC 14443-3 (Type A) compatible");
        c0428i.m1384a((CharSequence) "ISO/IEC 14443-2 (Type A) compatible");
        c0200d.m238a(c0428i.toString());
        NfcA nfcA = NfcA.get(m666m());
        if (!m714e()) {
            C0369v.m1096a(nfcA, m661h(), this.h, c0200d, C0360m.DESFIRE);
        }
        if (this.d == null) {
            return;
        }
        if (m714e()) {
            c0200d.m241c(this.d);
        } else {
            c0200d.m237a(this.d);
        }
    }

    public boolean m712a() {
        return true;
    }

    public String m713d() {
        return m683a(this.f662l);
    }

    public boolean m714e() {
        return this.f662l == C0308g.SMX_EMU;
    }
}
