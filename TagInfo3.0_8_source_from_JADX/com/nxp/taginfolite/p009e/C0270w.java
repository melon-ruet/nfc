package com.nxp.taginfolite.p009e;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.support.v4.BuildConfig;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.Menu;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0338a;
import com.nxp.taginfolite.p004f.C0351d;
import com.nxp.taginfolite.p004f.C0352e;
import com.nxp.taginfolite.p004f.C0355h;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.C0360m;
import com.nxp.taginfolite.p004f.C0361n;
import com.nxp.taginfolite.p004f.C0362o;
import com.nxp.taginfolite.p004f.C0368u;
import com.nxp.taginfolite.p004f.C0369v;
import com.nxp.taginfolite.p004f.p015a.C0337j;
import com.nxp.taginfolite.p004f.p016b.C0339a;
import com.nxp.taginfolite.p004f.p016b.C0340b;
import com.nxp.taginfolite.p004f.p017c.C0345a;
import com.nxp.taginfolite.p004f.p017c.C0346b;
import com.nxp.taginfolite.p005b.C0182c;
import com.nxp.taginfolite.p005b.C0188i;
import com.nxp.taginfolite.p005b.C0194n;
import com.nxp.taginfolite.p006c.C0197a;
import com.nxp.taginfolite.p006c.C0198b;
import com.nxp.taginfolite.p006c.C0199c;
import com.nxp.taginfolite.p006c.C0200d;
import com.nxp.taginfolite.p009e.p013d.C0272a;
import com.nxp.taginfolite.p009e.p013d.C0273b;
import com.nxp.taginfolite.p009e.p013d.C0275d;
import com.nxp.taginfolite.p009e.p013d.C0276e;
import com.nxp.taginfolite.p009e.p013d.C0277f;
import com.nxp.taginfolite.p009e.p013d.C0279h;
import com.nxp.taginfolite.p009e.p013d.C0281j;
import com.nxp.taginfolite.p009e.p013d.C0286o;
import com.nxp.taginfolite.p009e.p013d.C0288q;
import com.nxp.taginfolite.p009e.p013d.C0289r;
import com.nxp.taginfolite.p009e.p013d.C0290s;
import com.nxp.taginfolite.p009e.p013d.C0291t;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.w */
public class C0270w implements ay {
    private static final byte[] f625I;
    private static final byte[] f626J;
    private static final byte[] f627k;
    private static final byte[] f628l;
    private static final byte[] f629m;
    private static final byte[] f630n;
    private C0276e f631A;
    private C0272a f632B;
    private int f633C;
    private String f634D;
    private C0288q f635E;
    private String f636F;
    private C0428i f637G;
    private final C0428i f638H;
    protected IsoDep f639a;
    protected Tag f640b;
    protected boolean f641c;
    protected C0182c f642d;
    protected final C0428i f643e;
    protected C0158a f644f;
    protected final List f645g;
    protected byte[] f646h;
    protected C0291t f647i;
    protected C0291t f648j;
    private final HashMap f649o;
    private C0360m f650p;
    private int f651q;
    private C0279h f652r;
    private C0368u f653s;
    private C0275d f654t;
    private boolean f655u;
    private byte[] f656v;
    private byte[] f657w;
    private boolean f658x;
    private C0277f f659y;
    private C0281j f660z;

    static {
        f627k = new byte[]{(byte) 63, (byte) 0};
        f628l = new byte[]{(byte) 47, (byte) 0};
        f629m = new byte[]{(byte) 47, (byte) 1};
        f630n = new byte[]{(byte) 100, (byte) 98, (byte) 46, (byte) 100, (byte) 101, (byte) 58, (byte) 116, (byte) 97, (byte) 110, (byte) 100, (byte) 116};
        f625I = new byte[]{(byte) 110, (byte) 120, (byte) 112, (byte) 46, (byte) 99, (byte) 111, (byte) 109, (byte) 58, (byte) 107, (byte) 108, (byte) 108};
        f626J = new byte[]{Byte.MIN_VALUE, (byte) 92, (byte) 0, (byte) 2, (byte) 4};
    }

    public C0270w() {
        this.f649o = new HashMap();
        this.f655u = false;
        this.f639a = null;
        this.f640b = null;
        this.f641c = false;
        this.f642d = null;
        this.f643e = new C0428i();
        this.f656v = null;
        this.f657w = null;
        this.f658x = false;
        this.f659y = null;
        this.f660z = null;
        this.f631A = null;
        this.f632B = null;
        this.f644f = null;
        this.f645g = new ArrayList();
        this.f646h = null;
        this.f635E = null;
        this.f636F = null;
        this.f647i = new C0291t();
        this.f648j = new C0291t();
        this.f637G = new C0428i();
        this.f638H = new C0428i();
    }

    private boolean m613A() {
        C0345a c0345a = new C0345a(this.f639a);
        c0345a.m1005b(C0338a.f1025k);
        if (!c0345a.m1007c()) {
            return false;
        }
        byte[] b = c0345a.m1002b(5);
        if (!c0345a.m1007c()) {
            return false;
        }
        byte[] b2 = c0345a.m1002b(5);
        if (!c0345a.m1007c()) {
            return false;
        }
        byte[] a = c0345a.m996a(f626J);
        boolean c = c0345a.m1007c();
        c0345a.m1005b(C0338a.ad);
        if (!c0345a.m1007c()) {
            return false;
        }
        this.f643e.m1384a(m637a(C0338a.ad));
        if (b2.length >= 27) {
            StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
            for (int i = 0; i < 5; i++) {
                stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(b2[i])}));
            }
            this.f643e.m1384a(C0358k.f1076c + "Card no: " + stringBuilder);
        }
        if (b.length >= 27) {
            this.f643e.m1384a(C0358k.f1076c + String.format("Validity: %02X%02X/%02X/%02X - %02X%02X/%02X/%02X", new Object[]{Byte.valueOf(b[20]), Byte.valueOf(b[21]), Byte.valueOf(b[22]), Byte.valueOf(b[23]), Byte.valueOf(b[16]), Byte.valueOf(b[17]), Byte.valueOf(b[18]), Byte.valueOf(b[19])}));
        }
        if (!c) {
            a = c0345a.m996a(f626J);
            if (!c0345a.m1007c()) {
                return true;
            }
        }
        if (a.length >= 6) {
            this.f643e.m1384a(String.format(Locale.US, C0358k.f1076c + "Current value: " + "CN\u00a5" + " %01.2f", new Object[]{Float.valueOf(C0270w.m626e(a))}));
        }
        return true;
    }

    private boolean m614B() {
        C0345a c0345a = new C0345a(this.f639a);
        c0345a.m1005b(C0338a.f1025k);
        if (!c0345a.m1007c()) {
            return false;
        }
        c0345a.m1005b(C0338a.ae);
        if (!c0345a.m1007c()) {
            return false;
        }
        this.f643e.m1384a(m637a(C0338a.ae));
        byte[] b = c0345a.m1002b(21);
        if (c0345a.m1007c() && b.length >= 50) {
            StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
            for (int i = 11; i < 16; i++) {
                stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(b[i])}));
            }
            this.f643e.m1384a(C0358k.f1076c + "Card no: " + stringBuilder);
            this.f643e.m1384a(C0358k.f1076c + String.format("%02X%02X/%02X/%02X - %02X%02X/%02X/%02X", new Object[]{Byte.valueOf(b[23]), Byte.valueOf(b[24]), Byte.valueOf(b[25]), Byte.valueOf(b[26]), Byte.valueOf(b[27]), Byte.valueOf(b[28]), Byte.valueOf(b[29]), Byte.valueOf(b[30])}));
        }
        byte[] a = c0345a.m996a(f626J);
        if (!c0345a.m1007c() || a.length < 6) {
            return true;
        }
        this.f643e.m1384a(String.format(Locale.US, C0358k.f1076c + "Current value: " + "CN\u00a5" + " %01.2f", new Object[]{Float.valueOf(C0270w.m626e(a))}));
        return true;
    }

    private void m615C() {
        C0345a c0345a = new C0345a(this.f639a);
        c0345a.m1005b(C0338a.f1014Z);
        if (c0345a.m1007c()) {
            CharSequence a = m637a(C0338a.f1014Z);
            this.f649o.put(a, Boolean.valueOf(true));
            this.f643e.m1384a(a);
            c0345a.m994a(8, 0, new byte[]{(byte) 63, (byte) 0, (byte) 63, (byte) 28}, -1);
            if (c0345a.m1007c()) {
                byte[] b = c0345a.m1004b(1, 0, 29);
                if (c0345a.m1007c() && b.length > 29) {
                    int i;
                    this.f643e.m1384a(C0358k.f1076c + "Card number: " + new BigInteger("0" + C0429j.m1393a(Arrays.copyOfRange(b, 2, 12), BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME), 16).shiftRight(2).and(new BigInteger("FFFFFFFFFFFFFFFFFFF", 16)).toString(16).replaceAll("[A-Fa-f]", "x"));
                    byte[] copyOfRange = Arrays.copyOfRange(b, 25, 29);
                    copyOfRange[0] = (byte) (copyOfRange[0] & 15);
                    byte[] b2 = c0345a.m1004b(2, 0, 29);
                    b2 = C0429j.m1399a(copyOfRange, b2, b2.length - 2);
                    String bigInteger = new BigInteger(C0429j.m1393a(b2, BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME), 16).toString(2);
                    int length = ((b2.length * 8) - 4) - bigInteger.length();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (i = 0; i < length; i++) {
                        stringBuilder.append("0");
                    }
                    String str = stringBuilder.toString() + bigInteger;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    for (i = 1; i < (str.length() - 5) - 1; i += 5) {
                        length = 0;
                        for (int i2 = 0; i2 < 5; i2++) {
                            length = (length * 2) + Integer.parseInt(str.substring(i + i2, (i + i2) + 1));
                        }
                        if (length > 26 || length < 1) {
                            stringBuilder2.append(" ");
                        } else {
                            stringBuilder2.append((char) (length + 64));
                        }
                    }
                    this.f643e.m1384a(C0358k.f1076c + "Card holder: " + stringBuilder2.toString().trim());
                    if (!(b[24] == null || b[23] == null || b[21] == null)) {
                        this.f643e.m1384a(String.format(C0358k.f1076c + "Date of birth: %02d/%02d/%02d%02d", new Object[]{Byte.valueOf(b[24]), Byte.valueOf(b[23]), Byte.valueOf(b[21]), Byte.valueOf(b[22])}));
                    }
                }
                this.f643e.m1384a(C0361n.f1091b);
            }
        }
    }

    private String m616D() {
        if (!(this.f654t != C0275d.UNKNOWN || this.f659y == null || this.f659y.m743b() == null)) {
            this.f654t = C0275d.JAVA_CARD;
        }
        return (this.f654t == C0275d.JCOP_NXP || this.f654t == C0275d.JCOP_IBM) ? C0281j.m748a(this, this.f660z) : C0273b.m722a(this.f654t, this.f634D);
    }

    public static ay m617a(Tag tag, IsoDep isoDep, C0360m c0360m, boolean z, boolean z2, NdefMessage[] ndefMessageArr, C0158a c0158a) {
        int i;
        int length;
        C0270w c0270w = new C0270w();
        c0270w.f640b = tag;
        c0270w.f639a = isoDep;
        c0270w.f650p = c0360m;
        c0270w.m647a(C0279h.UNKNOWN);
        c0270w.f651q = -1;
        c0270w.f654t = C0275d.UNKNOWN;
        c0270w.f655u = z;
        c0270w.f653s = C0368u.UNKNOWN;
        c0270w.f634D = null;
        c0270w.f644f = c0158a;
        if (z && ndefMessageArr != null && ndefMessageArr.length == 1) {
            NdefRecord[] records = ndefMessageArr[0].getRecords();
            if (records != null && records.length == 1) {
                for (NdefRecord ndefRecord : records) {
                    if ((short) 4 == ndefRecord.getTnf() && Arrays.equals(ndefRecord.getType(), f630n)) {
                        c0270w.f643e.m1384a((CharSequence) "German public transport Touch and Travel tag");
                    }
                }
            }
        }
        try {
            c0270w.f639a.connect();
        } catch (IOException e) {
        }
        if (c0270w.f639a.isConnected()) {
            if (!z2) {
                try {
                    c0270w.m648a(c0270w.f648j, 2, c0158a, false);
                    c0270w.m648a(c0270w.f647i, 1, c0158a, false);
                } catch (TagLostException e2) {
                    c0270w.f641c = true;
                } catch (IOException e3) {
                    c0270w.f641c = true;
                }
            }
            byte a = C0351d.m1033a(isoDep.getHistoricalBytes());
            if (C0351d.m1041c(a)) {
                c0270w.m627e();
            }
            byte[] a2 = C0351d.m1036a(a) ? c0270w.m622a(f628l, C0351d.m1038b(a)) : c0270w.m622a(f628l, C0352e.ReadBinary);
            if (C0345a.m986c(a2)) {
                C0339a a3;
                List<C0337j> a4 = new C0337j(a2).m959a(97);
                List<C0339a> arrayList = new ArrayList();
                for (C0337j g : a4) {
                    a3 = C0339a.m973a(g.m965g());
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                }
                for (C0339a a32 : arrayList) {
                    c0270w.f643e.m1384a(a32.m979e());
                }
            }
            c0270w.m660g();
            c0270w.f659y = C0277f.m731a(c0270w);
            c0270w.m660g();
            byte[] id = c0270w.f640b.getId();
            if (c0360m == C0360m.ISO14443_A) {
                if (C0355h.m1065a(id, C0360m.ISO14443_A) || C0358k.m1071a(id, C0360m.ISO14443_A)) {
                    if (c0270w.f659y == null) {
                        c0270w.f631A = C0276e.m729a(c0270w);
                    } else if (c0270w.f652r == C0279h.UNKNOWN) {
                        c0270w.f631A = C0276e.m729a(c0270w);
                    }
                    if (c0270w.f654t != C0275d.EVALOS) {
                        c0270w.f660z = C0281j.m747a(c0270w);
                    } else if (c0270w.f652r == C0279h.UNKNOWN) {
                        c0270w.f660z = C0281j.m747a(c0270w);
                    }
                    if (c0270w.f654t == C0275d.UNKNOWN) {
                        c0270w.f632B = C0272a.m715a(c0270w);
                    } else if (c0270w.f654t == C0275d.UNKNOWN) {
                        c0270w.f632B = C0272a.m715a(c0270w);
                    }
                    if (c0270w.f654t == C0275d.UNKNOWN && z && c0270w.f659y == null) {
                        c0270w.m620a(ndefMessageArr, id);
                    }
                } else if (id.length == 7) {
                    a = id[0];
                    if (a == 22) {
                        if (id[1] == 16) {
                            c0270w.f653s = C0368u.NF4;
                        }
                    } else if (a == 2) {
                        Object obj = null;
                        switch (id[1] & MotionEventCompat.ACTION_MASK) {
                            case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                                obj = 1;
                                c0270w.f653s = C0368u.M24SR02_Y;
                                break;
                            case 132:
                            case 140:
                                obj = 1;
                                c0270w.f653s = C0368u.M24SR64_Y;
                                break;
                            case 133:
                                obj = 1;
                                c0270w.f653s = C0368u.M24SR16_Y;
                                break;
                            case 134:
                                obj = 1;
                                c0270w.f653s = C0368u.M24SR04_Y;
                                break;
                            case 210:
                                c0270w.f653s = C0368u.SRTAG2K_D;
                                break;
                        }
                        if (obj != null && c0270w.f644f.m56n()) {
                            c0270w.f634D = C0289r.m758a(c0270w);
                        }
                    } else if (a == 63 && (id[1] & MotionEventCompat.ACTION_MASK) == 16) {
                        c0270w.f653s = C0368u.AS3953A;
                    }
                }
            }
            if (c0270w.f654t == C0275d.UNKNOWN) {
                C0273b.m723a(c0270w);
            }
            if (c0270w.f654t == C0275d.UNKNOWN) {
                C0273b.m725b(c0270w);
            }
            if (c0270w.f654t == C0275d.UNKNOWN) {
                c0270w.f635E = C0288q.m755a(c0270w);
            }
            c0270w.m660g();
            C0340b.m981a(c0270w);
            c0270w.m660g();
            byte[][] bArr = C0338a.f993E;
            length = bArr.length;
            i = 0;
            while (i < length && !c0270w.m625d(bArr[i])) {
                i++;
            }
            if (!c0270w.m625d(C0338a.f1024j) && c0270w.m625d(C0338a.f1025k)) {
                if (c0270w.f654t == C0275d.UNKNOWN) {
                    C0273b.m727d(c0270w);
                    c0270w.m660g();
                }
                if (c0270w.f654t == C0275d.UNKNOWN) {
                    C0273b.m726c(c0270w);
                    c0270w.m660g();
                }
                if (c0270w.f654t == C0275d.UNKNOWN) {
                    C0273b.m728e(c0270w);
                    c0270w.m660g();
                }
                if (!(c0270w.m632v() || c0270w.m634x() || c0270w.m635y() || c0270w.m636z() || c0270w.m613A() || c0270w.m614B())) {
                    c0270w.m633w();
                }
            }
            c0270w.m621a(192, C0338a.f992D, -1);
            c0270w.m629s();
            c0270w.m630t();
            c0270w.m625d(C0338a.af);
            c0270w.m625d(C0338a.ag);
            c0270w.m621a(12, C0338a.f994F, -1);
            c0270w.m625d(C0338a.f999K);
            c0270w.m621a(12, C0338a.f997I, -1);
            c0270w.m621a(12, C0338a.f1004P, -1);
            c0270w.m625d(C0338a.f1006R);
            c0270w.m625d(C0338a.f1008T);
            c0270w.m615C();
            c0270w.m625d(C0338a.f1005Q);
            c0270w.m625d(C0338a.f1000L);
            c0270w.m625d(C0338a.f1001M);
            c0270w.m625d(C0338a.f1002N);
            if (c0270w.m625d(C0338a.f1020f) && c0270w.f654t == C0275d.UNKNOWN) {
                c0270w.f654t = C0275d.GEM_TOP;
            }
            c0270w.m631u();
            if (!c0270w.m621a(12, C0338a.f995G, -1)) {
                c0270w.m621a(12, C0338a.f996H, -1);
            }
            c0270w.m659f();
            if (NfcB.get(tag) != null) {
                C0286o.m754a(c0270w);
            }
            c0270w.m660g();
            try {
                isoDep.close();
            } catch (IOException e4) {
            }
            if (c0360m == C0360m.ISO14443_A) {
                MifareClassic mifareClassic = MifareClassic.get(isoDep.getTag());
                NfcA nfcA = NfcA.get(isoDep.getTag());
                if (mifareClassic == null && nfcA != null) {
                    try {
                        nfcA.connect();
                        c0270w.f646h = C0351d.m1037a(nfcA);
                    } catch (TagLostException e5) {
                        c0270w.f641c = true;
                    } catch (IOException e6) {
                    }
                    try {
                        nfcA.close();
                    } catch (IOException e7) {
                    }
                }
            }
            boolean z3 = (c0270w.f656v == null || c0270w.m624c(c0270w.f656v)) ? false : true;
            c0270w.f658x = z3;
            return c0270w;
        }
        try {
            isoDep.close();
        } catch (IOException e8) {
        }
        c0270w.f641c = true;
        return c0270w;
    }

    public static String m618a(byte[][] bArr, int i) {
        int i2 = 0;
        C0428i c0428i = new C0428i();
        if (bArr == null || bArr.length != 3) {
            return null;
        }
        String[] strArr = new String[]{"Type 4 Tag v" + i + " application FCI:", "CC file FCI:", "NDEF file FCI:"};
        while (i2 < 3) {
            byte[] bArr2 = bArr[i2];
            if (bArr2 != null) {
                c0428i.m1387b(strArr[i2]);
                if (bArr2.length > 0) {
                    c0428i.m1387b("\n" + C0358k.f1076c);
                    c0428i.m1384a(C0429j.m1411g(bArr[i2]));
                } else {
                    c0428i.m1384a((CharSequence) " [none]");
                }
            }
            i2++;
        }
        return c0428i.toString();
    }

    private void m619a(C0197a c0197a) {
        if (this.f659y != null) {
            c0197a.m207g("Global Platform information", this.f659y.m741a());
        }
        if (this.f660z != null) {
            c0197a.m204f(this.f660z.m751a());
        } else if (this.f654t == C0275d.MULTOS && this.f635E != null) {
            c0197a.m208h("MULTOS information", this.f635E.m757a());
        }
    }

    private void m620a(NdefMessage[] ndefMessageArr, byte[] bArr) {
        if (ndefMessageArr != null && ndefMessageArr.length != 0 && bArr != null && bArr.length == 7) {
            if (Arrays.equals(f625I, ndefMessageArr[0].getRecords()[0].getType())) {
                byte[] bArr2 = new byte[]{(byte) 106, (byte) -126};
                byte[] bArr3 = new byte[]{(byte) 111, (byte) 0};
                C0345a c0345a = new C0345a(this.f639a);
                c0345a.m1005b(new byte[0]);
                if (Arrays.equals(bArr2, c0345a.m1011f())) {
                    c0345a.m996a(new byte[0]);
                    if (Arrays.equals(bArr3, c0345a.m1011f())) {
                        c0345a.m997a(C0338a.f1022h, -1);
                        if (c0345a.m1007c()) {
                            c0345a.m1006b(C0290s.f741a, -1);
                            if (c0345a.m1007c()) {
                                bArr2 = c0345a.m989a();
                                if (c0345a.m1007c() && bArr2.length == 2) {
                                    this.f652r = C0279h.KEyLinkLite;
                                    this.f653s = C0368u.KEyLinkLite;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean m621a(int i, byte[] bArr, int i2) {
        if (m624c(bArr)) {
            return true;
        }
        C0345a c0345a = new C0345a(this.f639a);
        try {
            boolean z;
            m660g();
            byte[] a = c0345a.m995a(i, bArr, i2);
            if (c0345a.m1007c()) {
                C0337j a2 = C0340b.m980a(a);
                if (a2 != null) {
                    List<C0339a> a3 = C0339a.m974a(a2);
                    if (a3 != null) {
                        for (C0339a c0339a : a3) {
                            m638a(c0339a.m975a(), a);
                            this.f643e.m1384a(c0339a.m979e());
                        }
                    }
                    z = true;
                } else {
                    this.f643e.m1384a(m638a(bArr, a));
                    z = true;
                }
            } else {
                z = false;
            }
            return z;
        } catch (TagLostException e) {
            throw e;
        } catch (IOException e2) {
            return false;
        }
    }

    private byte[] m622a(byte[] bArr, C0352e c0352e) {
        if (c0352e == C0352e.UNKNOWN) {
            return null;
        }
        String.format("EF.%02X%02X", new Object[]{Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1])});
        String str;
        if (bArr[0] == f629m[0] && bArr[1] == f629m[1]) {
            str = "EF.INFO";
        } else if (bArr[0] == f628l[0] && bArr[1] == f628l[1]) {
            str = "EF.DIR";
        }
        C0345a c0345a = new C0345a(this.f639a);
        if (c0352e == C0352e.GetData) {
            c0345a.m999a(bArr, new byte[]{(byte) 92, (byte) 0});
            if (c0345a.m1007c()) {
                this.f655u = true;
                return c0345a.m1011f();
            }
        }
        if (c0352e == C0352e.ReadBinary || (c0352e == C0352e.ReadRecord && !c0345a.m1007c())) {
            for (int[] iArr : new int[][]{new int[]{2, 0, 0}, new int[]{2, 12, -1}, new int[]{2, 4, -1}, new int[]{2, 4, 0}, new int[]{0, 12, -1}, new int[]{0, 0, -1}, new int[]{0, 0, 0}}) {
                c0345a.m994a(iArr[0], iArr[1], bArr, iArr[2]);
                if (c0345a.m1007c()) {
                    break;
                }
            }
        }
        if (c0345a.m1007c()) {
            this.f655u = true;
            if (c0352e == C0352e.ReadRecord) {
                c0345a.m1004b(0, 1, 0);
            } else if (c0352e == C0352e.ReadBinary) {
                c0345a.m989a();
            } else if (c0352e == C0352e.GetData) {
                c0345a.m1001b();
            }
        } else if (c0352e == C0352e.ReadBinary) {
            c0345a.m1000a(bArr, new byte[]{(byte) 84, (byte) 2, (byte) 0, (byte) 0}, 0);
            if (c0345a.m1007c()) {
                this.f655u = true;
            }
        }
        return c0345a.m1011f();
    }

    private static String m623c(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        switch (i & 240) {
            case C0519c.Switch_thumb /*0*/:
                stringBuilder.append("Proprietary");
                break;
            case Menu.CATEGORY_SHIFT /*16*/:
                stringBuilder.append("Transport");
                break;
            case C0086R.styleable.SherlockTheme_searchViewCloseIcon /*32*/:
                stringBuilder.append("Financial");
                break;
            case C0086R.styleable.SherlockTheme_windowMinWidthMajor /*48*/:
                stringBuilder.append("Identification");
                break;
            case C0086R.styleable.SherlockTheme_activityChooserViewStyle /*64*/:
                stringBuilder.append("Telecommunication");
                break;
            case 80:
                stringBuilder.append("Medical");
                break;
            case 96:
                stringBuilder.append("Multimedia");
                break;
            case 112:
                stringBuilder.append("Gaming");
                break;
            case AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS /*128*/:
                stringBuilder.append("Data storage");
                break;
            case 144:
            case 160:
            case 176:
            case 192:
            case 208:
            case 240:
                stringBuilder.append("[RFU]");
                break;
            case 224:
                switch (i) {
                    case 225:
                        stringBuilder.append("Electronic passport (MRTD)");
                        break;
                    case 226:
                        stringBuilder.append("Electronic visa (MRTD)");
                        break;
                    default:
                        stringBuilder.append("[RFU]");
                        break;
                }
            default:
                stringBuilder.append("[unknown]");
                break;
        }
        stringBuilder.append(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(i)}));
        return stringBuilder.toString();
    }

    private boolean m624c(byte[] bArr) {
        Boolean bool = (Boolean) this.f649o.get(C0338a.m972a(bArr));
        return bool != null && bool.booleanValue();
    }

    private boolean m625d(byte[] bArr) {
        return m621a(0, bArr, 0);
    }

    private static float m626e(byte[] bArr) {
        return ((float) C0429j.m1390a((byte) (bArr[0] & TransportMediator.KEYCODE_MEDIA_PAUSE), bArr[1], bArr[2], bArr[3])) / 100.0f;
    }

    private byte[] m627e() {
        byte[] bArr = new byte[]{(byte) 0, (byte) -92, (byte) 0, (byte) 0, (byte) 2, f627k[0], f627k[1], (byte) 0};
        byte[] bArr2 = new byte[]{(byte) 0, (byte) -92, (byte) 0, (byte) 0, (byte) 2, f627k[0], f627k[1]};
        byte[] bArr3 = new byte[]{(byte) 0, (byte) -92, (byte) 0, (byte) 12, (byte) 2, f627k[0], f627k[1]};
        byte[] bArr4 = new byte[]{(byte) 0, (byte) -92, (byte) 0, (byte) 12, (byte) 2, f627k[0], f627k[1], (byte) 0};
        byte[][] bArr5 = new byte[][]{bArr, bArr2, bArr3, bArr4};
        C0345a c0345a = new C0345a(this.f639a);
        byte[] bArr6 = null;
        for (byte[] bArr62 : bArr5) {
            m660g();
            bArr62 = c0345a.m996a(bArr62);
            if (c0345a.m1007c()) {
                break;
            }
        }
        return bArr62;
    }

    private static String m628f(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return null;
        }
        C0428i c0428i = new C0428i();
        int i = bArr[3] & 15;
        if (i == 0) {
            byte[] bArr2 = new byte[bArr.length];
            Arrays.fill(bArr2, (byte) 0);
            if (Arrays.equals(bArr2, bArr)) {
                return null;
            }
        }
        if (i < 15) {
            c0428i.m1384a(String.format("Total number of applications: %d", new Object[]{Integer.valueOf(i)}));
        } else {
            c0428i.m1384a(C0358k.f1076c + "Total number of applications: >15");
        }
        i = bArr[0] & MotionEventCompat.ACTION_MASK;
        c0428i.m1387b("Application type: ");
        c0428i.m1384a(C0270w.m623c(i));
        if (((bArr[3] >> 4) & 15) < 15) {
            c0428i.m1384a(String.format(C0358k.f1076c + "Number of matching applications: %d", new Object[]{Integer.valueOf(i)}));
        } else {
            c0428i.m1384a(C0358k.f1076c + "Number of matching applications: >15");
        }
        c0428i.m1384a(String.format(C0358k.f1076c + "CRC_B(AID) of matching application: 0x%02X%02X", new Object[]{Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2])}));
        return c0428i.toString();
    }

    private void m629s() {
        C0345a c0345a = new C0345a(this.f639a);
        m660g();
        byte[] a = c0345a.m997a(C0338a.f1039y, -1);
        if (c0345a.m1007c()) {
            CharSequence a2 = m637a(C0338a.f1039y);
            this.f643e.m1384a(a2);
            this.f649o.put(a2, Boolean.valueOf(true));
            if (a.length >= 10) {
                this.f643e.m1384a(C0358k.f1076c + "Card no.: " + C0429j.m1394a(a, BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME, 8, 8));
            }
            a = c0345a.m996a(new byte[]{(byte) -112, (byte) 76, (byte) 0, (byte) 0, (byte) 4});
            if (c0345a.m1007c() && a.length >= 6) {
                long a3 = C0429j.m1390a(a[0], a[1], a[2], a[3]);
                this.f643e.m1384a(C0358k.f1076c + String.format("Value: \u20a9%d", new Object[]{Long.valueOf(a3)}));
            }
        }
    }

    private void m630t() {
        C0345a c0345a = new C0345a(this.f639a);
        m660g();
        byte[] a = c0345a.m997a(C0338a.f1040z, -1);
        if (c0345a.m1007c()) {
            CharSequence a2 = m637a(C0338a.f1040z);
            this.f643e.m1384a(a2);
            this.f649o.put(a2, Boolean.valueOf(true));
            if (a.length >= 10) {
                this.f643e.m1384a(C0358k.f1076c + "Card no.: " + C0429j.m1394a(a, BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME, 8, 8));
            }
            a = c0345a.m996a(new byte[]{(byte) -112, (byte) 76, (byte) 0, (byte) 0, (byte) 4});
            if (c0345a.m1007c() && a.length >= 6) {
                long a3 = C0429j.m1390a(a[0], a[1], a[2], a[3]);
                this.f643e.m1384a(C0358k.f1076c + String.format("Value: \u20a9%d", new Object[]{Long.valueOf(a3)}));
            }
        }
    }

    private void m631u() {
        C0345a c0345a = new C0345a(this.f639a);
        m660g();
        c0345a.m995a(12, C0338a.f990B, -1);
        if (c0345a.m1007c()) {
            byte[] b;
            int length;
            CharSequence format;
            CharSequence charSequence;
            int i;
            CharSequence a = m637a(C0338a.f990B);
            this.f643e.m1384a(a);
            this.f649o.put(a, Boolean.valueOf(true));
            a = BuildConfig.VERSION_NAME;
            byte[] b2 = c0345a.m1004b(1, 23, 0);
            if (c0345a.m1007c() && b2.length >= 24 && b2[0] == 103 && b2[20] == 1) {
                this.f643e.m1384a(String.format(C0358k.f1076c + "Valid until: 20%02X-%02X", new Object[]{Byte.valueOf(b2[10]), Byte.valueOf(b2[11])}));
                String str = new String(Arrays.copyOfRange(b2, 17, 20), C0429j.f1360a.name());
                a = (String) C0361n.f1090a.get(str);
                if (TextUtils.isEmpty(a)) {
                    a = str;
                }
            }
            byte[] b3 = c0345a.m1004b(1, 24, 0);
            if (c0345a.m1007c() && b3.length >= 12) {
                if (C0358k.m1068a(b3[0], b3[1], b3[2]) != null) {
                    this.f643e.m1384a(String.format(Locale.US, C0358k.f1076c + "Current value: %s%01.2f", new Object[]{a, Double.valueOf(((double) r2.floatValue()) / 100.0d)}));
                } else {
                    this.f643e.m1384a(String.format(C0358k.f1076c + "Current value: [unknown]", new Object[0]));
                }
            }
            byte[] bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
            int i2 = 1;
            Object obj = null;
            while (i2 <= 15) {
                b = c0345a.m1004b(i2, 29, 0);
                if (c0345a.m1007c()) {
                    length = b.length;
                    b2 = null;
                    if (length > 33) {
                        b2 = Arrays.copyOfRange(b, 28, 34);
                        format = String.format("%02X%02X-%02X-%02X %02X:%02X: ", new Object[]{Byte.valueOf(b[28]), Byte.valueOf(b[29]), Byte.valueOf(b[30]), Byte.valueOf(b[31]), Byte.valueOf(b[32]), Byte.valueOf(b[33])});
                    } else {
                        format = "[unknown date]: ";
                    }
                    if (!(b2 == null || Arrays.equals(bArr, b2))) {
                        if (i2 >= 1 && obj == null) {
                            this.f643e.m1384a(C0358k.f1076c + "Transactions:");
                            obj = 1;
                        }
                        switch (b[0] & MotionEventCompat.ACTION_MASK) {
                            case 193:
                                this.f643e.m1387b("\t\u2022 Initiate transaction");
                                break;
                            case 209:
                                this.f643e.m1387b("\t\u2022 ");
                                this.f643e.m1387b(format);
                                charSequence = "[unknown amount]";
                                if (length >= 21 && C0358k.m1068a(b[17], b[18], b[19]) != null) {
                                    charSequence = String.format(Locale.US, "-%s%01.2f", new Object[]{a, Double.valueOf(((double) C0358k.m1068a(b[17], b[18], b[19]).floatValue()) / 100.0d)});
                                }
                                this.f643e.m1384a(charSequence);
                                break;
                            case 241:
                                this.f643e.m1387b("\t\u2022 Cancelled transaction ");
                                this.f643e.m1387b(format);
                                this.f643e.m1387b(" (");
                                this.f643e.m1387b(a);
                                this.f643e.m1384a((CharSequence) "0.00)");
                                break;
                            default:
                                this.f643e.m1384a((CharSequence) "\t\u2022 [Unknown transaction] ");
                                break;
                        }
                    }
                    i2++;
                } else {
                    if (obj == null) {
                        this.f643e.m1384a(C0358k.f1076c + "No transactions");
                    }
                    i2 = 1;
                    obj = null;
                    while (i2 <= 3) {
                        b = c0345a.m1004b(i2, 28, 0);
                        if (!c0345a.m1007c()) {
                            length = b.length;
                            b2 = null;
                            if (length <= 29) {
                                b2 = Arrays.copyOfRange(b, 24, 30);
                                format = String.format("%02X%02X-%02X-%02X %02X:%02X: ", new Object[]{Byte.valueOf(b[24]), Byte.valueOf(b[25]), Byte.valueOf(b[26]), Byte.valueOf(b[27]), Byte.valueOf(b[28]), Byte.valueOf(b[29])});
                            } else {
                                format = "[unknown date]: ";
                            }
                            if (!(b2 == null || Arrays.equals(bArr, b2))) {
                                charSequence = "[unknown amount]";
                                if (length >= 7 && C0358k.m1068a(b[4], b[5], b[6]) != null) {
                                    charSequence = String.format(Locale.US, "%s%01.2f", new Object[]{a, Double.valueOf(((double) C0358k.m1068a(b[4], b[5], b[6]).floatValue()) / 100.0d)});
                                }
                                if (i2 >= 1 && obj == null) {
                                    this.f643e.m1384a(C0358k.f1076c + "Top-up actions:");
                                    obj = 1;
                                }
                                this.f643e.m1387b("\t\u2022 ");
                                this.f643e.m1387b(format);
                                i = b[0] & MotionEventCompat.ACTION_MASK;
                                switch (i) {
                                    case 145:
                                    case 147:
                                    case 149:
                                    case 151:
                                        this.f643e.m1384a(charSequence);
                                        break;
                                    case 177:
                                        this.f643e.m1384a((CharSequence) "Clear balance");
                                        break;
                                    default:
                                        if (i2 != 0) {
                                            this.f643e.m1384a((CharSequence) "[Unknown transaction]");
                                            break;
                                        }
                                        switch (i) {
                                            case 129:
                                            case 131:
                                                this.f643e.m1384a((CharSequence) "Initiate charging");
                                                break;
                                            case 161:
                                                this.f643e.m1384a((CharSequence) "Initiate discharging");
                                                break;
                                            default:
                                                this.f643e.m1384a((CharSequence) "[Unknown transaction]");
                                                break;
                                        }
                                }
                            }
                            i2++;
                        } else if (obj != null) {
                            this.f643e.m1384a(C0358k.f1076c + "No top-up actions");
                        }
                    }
                    if (obj != null) {
                        this.f643e.m1384a(C0358k.f1076c + "No top-up actions");
                    }
                }
            }
            if (obj == null) {
                this.f643e.m1384a(C0358k.f1076c + "No transactions");
            }
            i2 = 1;
            obj = null;
            while (i2 <= 3) {
                b = c0345a.m1004b(i2, 28, 0);
                if (!c0345a.m1007c()) {
                    length = b.length;
                    b2 = null;
                    if (length <= 29) {
                        format = "[unknown date]: ";
                    } else {
                        b2 = Arrays.copyOfRange(b, 24, 30);
                        format = String.format("%02X%02X-%02X-%02X %02X:%02X: ", new Object[]{Byte.valueOf(b[24]), Byte.valueOf(b[25]), Byte.valueOf(b[26]), Byte.valueOf(b[27]), Byte.valueOf(b[28]), Byte.valueOf(b[29])});
                    }
                    charSequence = "[unknown amount]";
                    charSequence = String.format(Locale.US, "%s%01.2f", new Object[]{a, Double.valueOf(((double) C0358k.m1068a(b[4], b[5], b[6]).floatValue()) / 100.0d)});
                    this.f643e.m1384a(C0358k.f1076c + "Top-up actions:");
                    obj = 1;
                    this.f643e.m1387b("\t\u2022 ");
                    this.f643e.m1387b(format);
                    i = b[0] & MotionEventCompat.ACTION_MASK;
                    switch (i) {
                        case 145:
                        case 147:
                        case 149:
                        case 151:
                            this.f643e.m1384a(charSequence);
                            break;
                        case 177:
                            this.f643e.m1384a((CharSequence) "Clear balance");
                            break;
                        default:
                            if (i2 != 0) {
                                switch (i) {
                                    case 129:
                                    case 131:
                                        this.f643e.m1384a((CharSequence) "Initiate charging");
                                        break;
                                    case 161:
                                        this.f643e.m1384a((CharSequence) "Initiate discharging");
                                        break;
                                    default:
                                        this.f643e.m1384a((CharSequence) "[Unknown transaction]");
                                        break;
                                }
                            }
                            this.f643e.m1384a((CharSequence) "[Unknown transaction]");
                            break;
                    }
                    i2++;
                } else if (obj != null) {
                    this.f643e.m1384a(C0358k.f1076c + "No top-up actions");
                }
            }
            if (obj != null) {
                this.f643e.m1384a(C0358k.f1076c + "No top-up actions");
            }
        }
    }

    private boolean m632v() {
        C0345a c0345a = new C0345a(this.f639a);
        int i = 0;
        boolean z = true;
        while (z && i < 16) {
            c0345a.m996a(new byte[]{(byte) -112, (byte) 50, (byte) i, (byte) 0, (byte) 0, (byte) 0});
            z = c0345a.m1007c() || c0345a.m1010e() == 27392;
            i++;
        }
        if (!z) {
            return false;
        }
        this.f643e.m1384a((CharSequence) "CEPAS Contactless e-Purse Application");
        return true;
    }

    private void m633w() {
        byte[] bArr = new byte[]{(byte) 16, (byte) 1};
        C0345a c0345a = new C0345a(this.f639a);
        c0345a.m1006b(bArr, -1);
        if (c0345a.m1007c()) {
            bArr = c0345a.m996a(f626J);
            if (c0345a.m1007c() && bArr.length >= 6) {
                this.f643e.m1384a((CharSequence) "Chinese public transport card");
                this.f643e.m1384a(String.format(Locale.US, C0358k.f1076c + "Current value: " + "CN\u00a5" + " %01.2f", new Object[]{Float.valueOf(C0270w.m626e(bArr))}));
            }
        }
    }

    private boolean m634x() {
        C0345a c0345a = new C0345a(this.f639a);
        c0345a.m1005b(C0338a.f1025k);
        if (!c0345a.m1007c()) {
            return false;
        }
        c0345a.m1005b(C0338a.ab);
        if (!c0345a.m1007c()) {
            return false;
        }
        this.f643e.m1384a(m637a(C0338a.ab));
        byte[] b = c0345a.m1002b(21);
        if (c0345a.m1007c() && b.length >= 30) {
            long a = C0429j.m1390a(b[19], b[18], b[17], b[16]);
            this.f643e.m1384a(C0358k.f1076c + String.format("Card no: %d", new Object[]{Long.valueOf(a)}));
            this.f643e.m1384a(C0358k.f1076c + String.format("Validity: %02X%02X/%02X/%02X - %02X%02X/%02X/%02X", new Object[]{Byte.valueOf(b[20]), Byte.valueOf(b[21]), Byte.valueOf(b[22]), Byte.valueOf(b[23]), Byte.valueOf(b[24]), Byte.valueOf(b[25]), Byte.valueOf(b[26]), Byte.valueOf(b[27])}));
        }
        b = c0345a.m996a(f626J);
        if (!c0345a.m1007c() || b.length < 6) {
            return true;
        }
        this.f643e.m1384a(String.format(Locale.US, C0358k.f1076c + "Current value: " + "CN\u00a5" + " %01.2f", new Object[]{Float.valueOf(C0270w.m626e(b))}));
        return true;
    }

    private boolean m635y() {
        C0345a c0345a = new C0345a(this.f639a);
        c0345a.m1005b(C0338a.f1025k);
        if (!c0345a.m1007c()) {
            return false;
        }
        byte[] b = c0345a.m1002b(4);
        if (!c0345a.m1007c()) {
            return false;
        }
        c0345a.m1002b(5);
        if (!c0345a.m1007c()) {
            return false;
        }
        c0345a.m1006b(new byte[]{(byte) 16, (byte) 1}, 0);
        byte[] a = c0345a.m996a(f626J);
        if (!c0345a.m1007c() || a.length < 6) {
            return false;
        }
        this.f643e.m1384a((CharSequence) "Beijing Yikatong card");
        if (b.length >= 34) {
            StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
            for (int i = 0; i < 8; i++) {
                stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(b[i])}));
            }
            this.f643e.m1384a(C0358k.f1076c + "Card no: " + stringBuilder);
            this.f643e.m1384a(C0358k.f1076c + String.format("Validity: %02X%02X/%02X/%02X - %02X%02X/%02X/%02X", new Object[]{Byte.valueOf(b[24]), Byte.valueOf(b[25]), Byte.valueOf(b[26]), Byte.valueOf(b[27]), Byte.valueOf(b[28]), Byte.valueOf(b[29]), Byte.valueOf(b[30]), Byte.valueOf(b[31])}));
        }
        this.f643e.m1384a(String.format(Locale.US, C0358k.f1076c + "Current value: " + "CN\u00a5" + " %01.2f", new Object[]{Float.valueOf(C0270w.m626e(a))}));
        return true;
    }

    private boolean m636z() {
        C0345a c0345a = new C0345a(this.f639a);
        c0345a.m1005b(C0338a.f1025k);
        if (!c0345a.m1007c()) {
            return false;
        }
        c0345a.m1005b(C0338a.ac);
        if (!c0345a.m1007c()) {
            return false;
        }
        this.f643e.m1384a(m637a(C0338a.ac));
        byte[] b = c0345a.m1002b(21);
        if (c0345a.m1007c() && b.length >= 30) {
            long a = C0429j.m1390a(b[16], b[17], b[18], b[20]);
            this.f643e.m1384a(C0358k.f1076c + String.format("Card no: %d", new Object[]{Long.valueOf(a)}));
            this.f643e.m1384a(C0358k.f1076c + String.format("Validity: %02X%02X/%02X/%02X - %02X%02X/%02X/%02X", new Object[]{Byte.valueOf(b[20]), Byte.valueOf(b[21]), Byte.valueOf(b[22]), Byte.valueOf(b[23]), Byte.valueOf(b[24]), Byte.valueOf(b[25]), Byte.valueOf(b[26]), Byte.valueOf(b[27])}));
        }
        b = c0345a.m996a(f626J);
        if (!c0345a.m1007c() || b.length < 6) {
            return true;
        }
        this.f643e.m1384a(String.format(Locale.US, C0358k.f1076c + "Current value: " + "CN\u00a5" + " %01.2f", new Object[]{Float.valueOf(C0270w.m626e(b))}));
        return true;
    }

    public String m637a(byte[] bArr) {
        String a = C0338a.m972a(bArr);
        this.f649o.put(a, Boolean.valueOf(true));
        return a;
    }

    public String m638a(byte[] bArr, byte[] bArr2) {
        this.f655u = true;
        String a = m637a(bArr);
        if (bArr2 != null && bArr2.length > 0) {
            int length = bArr2.length;
            if (length > 2) {
                this.f645g.add(new C0325y(a, Arrays.copyOfRange(bArr2, 0, length - 2)));
            }
        }
        return a;
    }

    public void m639a(byte b) {
        switch (this.f633C) {
            case C0086R.styleable.SherlockTheme_searchViewTextFieldRight /*39*/:
                this.f654t = C0275d.STM027;
            case 560:
                this.f654t = C0275d.GEM230;
            case 4753:
            case 6529:
                this.f654t = C0275d.GEM_TOP;
            case 5745:
                this.f654t = C0275d.SMARTCAFE;
            case 9105:
                this.f654t = C0275d.ACOS;
            case 16465:
            case 19034:
                this.f654t = C0275d.JCOP_IBM;
                if (this.f660z == null) {
                    this.f660z = new C0281j();
                }
                this.f660z.m752a((short) (b & MotionEventCompat.ACTION_MASK));
            case 16496:
            case 18321:
                this.f654t = C0275d.JCOP_NXP;
                if (this.f660z == null) {
                    this.f660z = new C0281j();
                }
                this.f660z.m752a((short) (b & MotionEventCompat.ACTION_MASK));
            case 16529:
                this.f654t = C0275d.JTOP;
                this.f634D = String.format("v#%d", new Object[]{Short.valueOf((short) (b & MotionEventCompat.ACTION_MASK))});
            case 33297:
                this.f654t = C0275d.ATHENA;
            case 33329:
                this.f654t = C0275d.OCS_OS;
            case 53248:
                this.f654t = C0275d.GEMALTO;
            default:
        }
    }

    public void m640a(int i) {
        this.f651q = i;
    }

    public void m641a(Tag tag) {
        this.f640b = tag;
    }

    public void m642a(C0197a c0197a, boolean z) {
        int i = 0;
        if (C0362o.m1082c(this.f653s) > 0) {
            c0197a.m197b("EEPROM memory size", String.format("%d\u200akB", new Object[]{Integer.valueOf(C0362o.m1082c(this.f653s))}));
        }
        m619a(c0197a);
        if (this.f659y != null) {
            Calendar instance = Calendar.getInstance();
            if (this.f652r == C0279h.MifarePro) {
                instance.clear();
                instance.set(1, 2006);
                instance.set(6, 1);
            } else if (this.f652r == C0279h.MifareProX) {
                instance.clear();
                instance.set(1, 2009);
                instance.set(6, 1);
            }
            c0197a.m202e(this.f659y.m742a(this.f651q, instance));
        }
        if (C0360m.ISO14443_A.equals(this.f650p)) {
            byte[] historicalBytes = this.f639a.getHistoricalBytes();
            if (historicalBytes == null || historicalBytes.length == 0) {
                historicalBytes = C0351d.m1042c(this.f646h);
            }
            c0197a.m206g(C0351d.m1034a(historicalBytes, this.f640b.getId()));
            String str = BuildConfig.VERSION_NAME;
            if (C0355h.m1065a(this.f640b.getId(), C0360m.ISO14443_A)) {
                NfcA nfcA = NfcA.get(this.f640b);
                if (!(nfcA == null || (nfcA.getSak() & 8) == 0)) {
                    str = "MIFARE Classic emulation";
                }
            } else {
                String[] techList = this.f640b.getTechList();
                int length = techList.length;
                while (i < length) {
                    if ("android.nfc.tech.MifareClassic".equals(techList[i])) {
                        str = "MIFARE Classic emulation";
                        break;
                    }
                    i++;
                }
            }
            if (this.f636F != null) {
                if (!(TextUtils.isEmpty(this.f636F) || str.isEmpty())) {
                    str = "\n" + str;
                }
                c0197a.m198c(this.f636F + str);
            } else {
                Object a = C0362o.m1078a(this.f653s);
                if (!(TextUtils.isEmpty(a) || str.isEmpty())) {
                    str = "\n" + str;
                }
                c0197a.m198c(a + str);
            }
        } else {
            NfcB nfcB = NfcB.get(this.f640b);
            if (this.f651q == 65538) {
                c0197a.m209i("Application type", C0270w.m623c(this.f646h[4]));
                c0197a.m197b("Memory information", C0286o.m753a(this.f646h));
            } else if (nfcB != null) {
                c0197a.m209i("Application data", C0270w.m628f(nfcB.getApplicationData()));
            }
        }
        CharSequence charSequence = "Misc. information";
        switch (C0324x.f948a[this.f654t.ordinal()]) {
            case C0519c.Switch_track /*1*/:
                charSequence = "BasicCard information";
                this.f637G = this.f632B.m721a();
                break;
            case C0519c.Switch_textOn /*2*/:
                charSequence = "Card OS information";
                break;
        }
        c0197a.m203e(charSequence, this.f637G.toString());
        C0428i c0428i = new C0428i();
        if (this.f658x && this.f657w != null && this.f657w.length > 0) {
            c0428i.m1384a((CharSequence) "Default selected AID");
            c0428i.m1387b("<mono>");
            c0428i.m1387b(C0429j.m1411g(this.f657w));
            c0428i.m1384a((CharSequence) "</mono>");
        }
        for (C0325y c0325y : this.f645g) {
            if (!(c0325y == null || c0325y.f951b == null || c0325y.f951b.length <= 0)) {
                c0428i.m1384a(c0325y.f950a);
                c0428i.m1387b("<mono>");
                c0428i.m1387b(C0429j.m1411g(c0325y.f951b));
                c0428i.m1384a((CharSequence) "</mono>");
            }
        }
        c0428i.m1384a(this.f638H.toString());
        c0197a.m195a((CharSequence) "File Control Information", c0428i.toString());
        if (!TextUtils.isEmpty(this.f634D)) {
            switch (C0324x.f949b[this.f653s.ordinal()]) {
                case C0519c.Switch_track /*1*/:
                case C0519c.Switch_textOn /*2*/:
                case C0519c.Switch_textOff /*3*/:
                case C0519c.Switch_thumbTextPadding /*4*/:
                    c0197a.m203e("System File info", this.f634D);
                default:
            }
        }
    }

    public void m643a(C0198b c0198b, boolean z) {
        C0290s.m763a(c0198b, this.f648j, this.f647i);
    }

    public void m644a(C0199c c0199c, boolean z) {
        CharSequence b;
        if (this.f650p == C0360m.ISO14443_A) {
            b = this.f651q > 0 ? C0355h.m1066b(this.f651q) : C0355h.m1067b(this.f640b.getId(), C0360m.ISO14443_A);
            if ("NXP Semiconductors".equals(b) && !m652a()) {
                b = "NXP Semiconductors";
            }
            c0199c.m230d(b);
        } else if (this.f651q > 0) {
            c0199c.m230d(C0355h.m1066b(this.f651q));
        } else {
            c0199c.m230d("Unknown manufacturer");
        }
        b = (String) C0279h.f726p.get(this.f652r);
        if (this.f653s != C0368u.UNKNOWN) {
            String str = (String) C0362o.f1102i.get(this.f653s);
            if (str != null) {
                b = b == null ? str : b + " (" + str + ")";
            }
        }
        if (TextUtils.isEmpty(b)) {
            c0199c.m231e("Unknown IC");
        } else {
            c0199c.m231e(b);
        }
        c0199c.m233g(m616D());
        C0428i c0428i = new C0428i();
        if (this.f659y != null && this.f659y.m745d()) {
            c0428i.m1384a((CharSequence) "Global Platform card manager present");
            this.f649o.put(C0338a.m972a(this.f659y.m744c()), Boolean.valueOf(true));
        }
        b = this.f643e.toString();
        if (!TextUtils.isEmpty(b)) {
            c0428i.m1384a(C0429j.m1391a(b));
        }
        if (this.f658x) {
            b = m637a(this.f656v);
            if (!TextUtils.isEmpty(b)) {
                c0428i.m1384a(C0429j.m1391a(b));
            }
            if (this.f657w != null) {
                C0337j a = C0340b.m980a(this.f657w);
                if (a != null) {
                    List<C0339a> a2 = C0339a.m974a(a);
                    if (a2 != null) {
                        for (C0339a c0339a : a2) {
                            if (!Arrays.equals(this.f656v, c0339a.m975a())) {
                                c0428i.m1384a(c0339a.m979e());
                            }
                        }
                    }
                }
            }
        }
        c0199c.m227b(c0428i.toString());
        if (!this.f644f.m68z()) {
            NfcA nfcA = NfcA.get(this.f639a.getTag());
            if (nfcA != null && ag.m461b(nfcA)) {
                c0199c.m228b("MIFARE applications", "No MIFARE support present in Android");
            }
        }
    }

    public void m645a(C0200d c0200d, boolean z) {
        CharSequence charSequence;
        if (C0360m.ISO14443_A.equals(this.f650p)) {
            charSequence = "ISO/IEC 14443-4 (Type A) compatible\nISO/IEC 14443-3 (Type A) compatible\nISO/IEC 14443-2 (Type A) compatible";
            C0369v.m1095a(NfcA.get(this.f640b), this.f639a, this.f646h, c0200d);
        } else {
            charSequence = "ISO/IEC 14443-4 (Type B) compatible\nISO/IEC 14443-3 (Type B) compatible\nISO/IEC 14443-2 (Type B) compatible";
            C0369v.m1100a(NfcB.get(this.f640b), this.f639a, c0200d);
        }
        if (this.f655u) {
            charSequence = "ISO/IEC 7816-4 compatible\n" + charSequence;
        }
        c0200d.m238a(charSequence);
    }

    public void m646a(C0275d c0275d) {
        this.f654t = c0275d;
    }

    public void m647a(C0279h c0279h) {
        this.f652r = c0279h;
    }

    protected void m648a(C0291t c0291t, int i, C0158a c0158a, boolean z) {
        C0345a c0345a = new C0345a(this.f639a);
        C0290s.m768b(i, c0345a);
        if (c0345a.m1007c()) {
            this.f649o.put(C0338a.m972a(C0290s.m767b(i)), Boolean.valueOf(true));
            if (!z) {
                this.f643e.m1384a(String.format("Type 4 Tag v%d application present", new Object[]{Integer.valueOf(i)}));
            }
            r4 = new byte[3][];
            c0291t.f744c = r4;
            byte[] f = c0345a.m1011f();
            r4[0] = Arrays.copyOfRange(f, 0, f.length - 2);
            try {
                f = C0290s.m764a(i, c0345a);
                if (c0345a.m1007c()) {
                    r4[1] = Arrays.copyOfRange(f, 0, f.length - 2);
                    byte[] a = C0290s.m765a(i, c0345a, c0158a.m56n());
                    if (a.length < 15) {
                        c0291t.f742a = a;
                        return;
                    }
                    int a2 = C0429j.m1388a(a[3], a[4]);
                    boolean z2 = false;
                    if (i == 2 && (a[2] & 240) == 48) {
                        z2 = true;
                    }
                    byte[] bArr = new byte[2];
                    if (a[7] == 4 || a[7] == 6) {
                        long a3;
                        bArr[0] = a[9];
                        bArr[1] = a[10];
                        if (z2) {
                            a3 = C0429j.m1390a(a[11], a[12], a[13], a[14]);
                        } else {
                            a3 = (long) C0429j.m1388a(a[11], a[12]);
                        }
                        ByteArrayOutputStream a4;
                        try {
                            bArr = C0290s.m766a(i, bArr, c0345a);
                            if (c0345a.m1007c()) {
                                r4[2] = Arrays.copyOfRange(bArr, 0, bArr.length - 2);
                                a4 = C0290s.m761a(a3, a2, z2, c0158a.m56n(), c0345a);
                                Object obj = null;
                                if (a4 == null) {
                                    a4 = new ByteArrayOutputStream(0);
                                    obj = 1;
                                }
                                C0182c a5 = C0188i.m162a(a4.toByteArray());
                                if (this.f641c) {
                                    a5.m147a(new C0194n(C0429j.m1391a((CharSequence) "<aborted: tag disappeared>")));
                                }
                                if (!(obj == null && c0345a.m1007c())) {
                                    a5.m147a(new C0194n(C0429j.m1391a("<aborted: read error>\n" + C0358k.f1076c + C0429j.m1391a(C0346b.m1012a(c0345a.m1010e())))));
                                }
                                c0291t.f743b = a5;
                                c0291t.f742a = a;
                                return;
                            }
                            c0291t.f742a = a;
                            return;
                        } catch (TagLostException e) {
                            this.f641c = true;
                            a4 = null;
                        }
                    } else {
                        c0291t.f742a = a;
                        return;
                    }
                } else if (z && i == 1) {
                    c0291t.f744c = (byte[][]) null;
                    c0291t.f742a = null;
                    return;
                } else {
                    c0291t.f742a = f;
                    return;
                }
            } catch (IOException e2) {
                c0291t.f742a = null;
                return;
            }
        }
        c0291t.f742a = null;
    }

    public void m649a(C0368u c0368u) {
        this.f653s = c0368u;
    }

    public void m650a(String str) {
        this.f636F = str;
    }

    public void m651a(boolean z) {
        this.f655u = z;
    }

    public boolean m652a() {
        if (!C0360m.ISO14443_A.equals(this.f650p)) {
            return false;
        }
        if (this.f652r == C0279h.SmartMX || this.f652r == C0279h.MifareProX || this.f652r == C0279h.MifarePro || this.f652r == C0279h.SmartEId || this.f654t == C0275d.JCOP_NXP || this.f654t == C0275d.EVALOS) {
            return true;
        }
        if ("NXP Semiconductors".equals(C0355h.m1066b(this.f651q))) {
            return true;
        }
        byte[] id = this.f640b.getId();
        return C0355h.m1065a(id, C0360m.ISO14443_A) && id.length >= 7;
    }

    public void m653b(int i) {
        this.f633C = i;
    }

    public void m654b(String str) {
        this.f634D = str;
    }

    public void m655b(byte[] bArr) {
        this.f646h = bArr;
    }

    public boolean m656b() {
        return this.f641c;
    }

    public byte[] m657c() {
        return this.f640b.getId();
    }

    public String m658d() {
        return (String) C0362o.f1102i.get(this.f653s);
    }

    public void m659f() {
        C0345a c0345a = new C0345a(this.f639a);
        byte[] b = c0345a.m1005b(new byte[0]);
        if (!c0345a.m1007c()) {
            b = c0345a.m997a(new byte[0], -1);
        }
        if (c0345a.m1007c()) {
            C0337j a = C0340b.m980a(b);
            if (a != null) {
                this.f657w = Arrays.copyOfRange(b, 0, b.length - 2);
                C0337j b2 = a.m962b(132);
                if (b2 != null) {
                    this.f656v = b2.m965g();
                }
            }
        }
    }

    public void m660g() {
        this.f639a.close();
        this.f639a.connect();
    }

    public IsoDep m661h() {
        return this.f639a;
    }

    public C0275d m662i() {
        return this.f654t;
    }

    public C0279h m663j() {
        return this.f652r;
    }

    public C0368u m664k() {
        return this.f653s;
    }

    public int m665l() {
        return this.f651q;
    }

    public Tag m666m() {
        return this.f640b;
    }

    public C0277f m667n() {
        return this.f659y;
    }

    public String m668o() {
        return this.f634D;
    }

    public C0428i m669p() {
        return this.f637G;
    }

    public C0428i m670q() {
        return this.f643e;
    }

    public C0281j m671r() {
        return this.f660z;
    }
}
