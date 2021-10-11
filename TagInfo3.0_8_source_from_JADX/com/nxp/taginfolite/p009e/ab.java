package com.nxp.taginfolite.p009e;

import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.Log;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0351d;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.C0369v;
import com.nxp.taginfolite.p004f.p019d.C0347a;
import com.nxp.taginfolite.p004f.p019d.C0350d;
import com.nxp.taginfolite.p006c.C0197a;
import com.nxp.taginfolite.p006c.C0198b;
import com.nxp.taginfolite.p006c.C0199c;
import com.nxp.taginfolite.p006c.C0200d;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.EnumMap;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.ab */
public final class ab implements ay {
    public static final byte[] f398a;
    public static final byte[] f399b;
    public static final byte[] f400c;
    static final byte[] f401d;
    private static final byte[] f402e;
    private static EnumMap f403q;
    private ae f404f;
    private af f405g;
    private ad f406h;
    private NfcA f407i;
    private IsoDep f408j;
    private boolean f409k;
    private Tag f410l;
    private byte[] f411m;
    private boolean f412n;
    private boolean f413o;
    private C0350d f414p;

    static {
        f398a = new byte[]{(byte) 77, (byte) 70, (byte) 80, (byte) 95, (byte) 69, (byte) 78, (byte) 71};
        f399b = new byte[]{(byte) -63, (byte) 5, (byte) 47, (byte) 47, (byte) 0, (byte) 53, (byte) -57};
        f400c = new byte[]{(byte) -63, (byte) 5, (byte) 47, (byte) 47, (byte) 1, (byte) -68, (byte) -42};
        f402e = new byte[]{(byte) -96, (byte) -95, (byte) -94, (byte) -93, (byte) -92, (byte) -91, (byte) -90, (byte) -89, (byte) -96, (byte) -95, (byte) -94, (byte) -93, (byte) -92, (byte) -91, (byte) -90, (byte) -89};
        f403q = null;
        f403q = new EnumMap(ae.class);
        f403q.put(ae.TwoK, "2\u200akB\n" + C0358k.f1076c + "128 blocks, with 16 bytes per block");
        f403q.put(ae.FourK, "4\u200akB\n" + C0358k.f1076c + "256 blocks, with 16 bytes per block");
        f403q.put(ae.UNKNOWN, "Unknown");
        f401d = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
    }

    public ab() {
        this.f407i = null;
        this.f408j = null;
        this.f409k = false;
        this.f410l = null;
        this.f411m = null;
        this.f412n = false;
        this.f413o = false;
        this.f414p = null;
    }

    private int m428a(int i) {
        return i < 32 ? i * 4 : ((i - 32) * 16) + AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS;
    }

    public static ay m429a(Tag tag, NfcA nfcA, IsoDep isoDep, C0158a c0158a) {
        ab abVar = new ab();
        abVar.f407i = nfcA;
        abVar.f408j = isoDep;
        abVar.f405g = af.UNKNOWN;
        abVar.f406h = ad.UNKNOWN;
        abVar.f404f = ae.UNKNOWN;
        abVar.f410l = tag;
        byte[] historicalBytes = isoDep.getHistoricalBytes();
        if (historicalBytes != null) {
            try {
                if (historicalBytes.length == f400c.length) {
                    if (Arrays.equals(historicalBytes, f400c)) {
                        abVar.f405g = af.PLUS_X;
                    } else if (Arrays.equals(historicalBytes, f399b)) {
                        abVar.f405g = af.PLUS_S;
                    }
                }
            } catch (TagLostException e) {
                abVar.f409k = true;
            } catch (IOException e2) {
            }
        }
        abVar.f406h = abVar.m438e();
        abVar.f404f = abVar.m439f();
        if (abVar.f405g == af.UNKNOWN) {
            abVar.f405g = abVar.m440g();
        }
        if (abVar.f406h == ad.SL3) {
            if (abVar.f405g == af.PLUS_X) {
                abVar.f412n = abVar.m441h();
            }
            if (!abVar.f412n) {
                abVar.f414p = abVar.m442i();
            }
        }
        try {
            abVar.f408j.close();
        } catch (IOException e3) {
        }
        NfcA nfcA2 = NfcA.get(abVar.f408j.getTag());
        if (nfcA2 != null) {
            try {
                nfcA2.connect();
                abVar.f411m = C0351d.m1037a(nfcA2);
            } catch (TagLostException e4) {
                abVar.f409k = true;
            } catch (IOException e5) {
            }
            try {
                nfcA2.close();
            } catch (IOException e6) {
            }
        }
        return abVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m430a(android.nfc.tech.NfcA r8, android.nfc.tech.IsoDep r9) {
        /*
        r7 = 4;
        r1 = 1;
        r0 = 0;
        r2 = r8.getTag();
        r2 = r2.getId();
        r3 = r8.getSak();
        r4 = r8.getAtqa();
        r5 = r2.length;
        r6 = 7;
        if (r5 < r6) goto L_0x001b;
    L_0x0017:
        r2 = r2[r0];
        if (r2 != r7) goto L_0x002d;
    L_0x001b:
        if (r4 == 0) goto L_0x002d;
    L_0x001d:
        r2 = r4.length;
        r5 = 2;
        if (r2 < r5) goto L_0x002d;
    L_0x0021:
        r2 = r4[r1];
        if (r2 != 0) goto L_0x002d;
    L_0x0025:
        r2 = 32;
        if (r3 == r2) goto L_0x002e;
    L_0x0029:
        r2 = 49;
        if (r3 == r2) goto L_0x002e;
    L_0x002d:
        return r0;
    L_0x002e:
        r2 = r4[r0];
        switch(r2) {
            case 2: goto L_0x0034;
            case 4: goto L_0x0034;
            case 66: goto L_0x0034;
            case 68: goto L_0x0034;
            default: goto L_0x0033;
        };
    L_0x0033:
        goto L_0x002d;
    L_0x0034:
        r2 = r9.getHistoricalBytes();
        if (r2 == 0) goto L_0x0054;
    L_0x003a:
        r3 = f400c;
        r3 = java.util.Arrays.equals(r2, r3);
        if (r3 != 0) goto L_0x0052;
    L_0x0042:
        r3 = f399b;
        r3 = java.util.Arrays.equals(r2, r3);
        if (r3 != 0) goto L_0x0052;
    L_0x004a:
        r3 = f398a;
        r2 = java.util.Arrays.equals(r2, r3);
        if (r2 == 0) goto L_0x0054;
    L_0x0052:
        r0 = r1;
        goto L_0x002d;
    L_0x0054:
        r9.connect();	 Catch:{ IOException -> 0x006d, all -> 0x0074 }
        r1 = 4;
        r1 = new byte[r1];	 Catch:{ IOException -> 0x006d, all -> 0x0074 }
        r1 = {112, 0, -128, 0};	 Catch:{ IOException -> 0x006d, all -> 0x0074 }
        r1 = r9.transceive(r1);	 Catch:{ IOException -> 0x006d, all -> 0x0074 }
        r2 = 17;
        r0 = com.nxp.taginfolite.p009e.ab.m431a(r1, r2);	 Catch:{ IOException -> 0x006d, all -> 0x0074 }
        r9.close();	 Catch:{ IOException -> 0x006b }
        goto L_0x002d;
    L_0x006b:
        r1 = move-exception;
        goto L_0x002d;
    L_0x006d:
        r1 = move-exception;
        r9.close();	 Catch:{ IOException -> 0x0072 }
        goto L_0x002d;
    L_0x0072:
        r1 = move-exception;
        goto L_0x002d;
    L_0x0074:
        r0 = move-exception;
        r9.close();	 Catch:{ IOException -> 0x0079 }
    L_0x0078:
        throw r0;
    L_0x0079:
        r1 = move-exception;
        goto L_0x0078;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.e.ab.a(android.nfc.tech.NfcA, android.nfc.tech.IsoDep):boolean");
    }

    private static boolean m431a(byte[] bArr, int i) {
        return bArr != null && bArr.length == i && bArr[0] == -112;
    }

    private byte[] m432a(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte b = (byte) (i & MotionEventCompat.ACTION_MASK);
        byte b2 = (byte) ((i >> 8) & MotionEventCompat.ACTION_MASK);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        byte[] bArr4 = new byte[]{(byte) 51, b, b2, (byte) i2};
        Log.v("TagInfo_MFP", "readCmd: " + C0429j.m1409e(bArr4));
        byte[] transceive = this.f408j.transceive(ab.m437a(bArr4, secretKeySpec, bArr2, bArr3));
        Log.v("TagInfo_MFP", "readResp: " + C0429j.m1409e(transceive));
        if (!ab.m431a(transceive, ((i2 * 16) + 1) + 8)) {
            return null;
        }
        int a = C0429j.m1388a(bArr2[0], bArr2[1]) + 1;
        bArr2[0] = (byte) ((a >> 8) & MotionEventCompat.ACTION_MASK);
        bArr2[0] = (byte) (a & MotionEventCompat.ACTION_MASK);
        return Arrays.copyOfRange(transceive, 1, (i2 * 16) + 1);
    }

    private byte[] m433a(int i, byte[] bArr, byte[] bArr2) {
        return m434a(i, bArr, bArr2, false);
    }

    private byte[] m434a(int i, byte[] bArr, byte[] bArr2, boolean z) {
        int i2 = 0;
        byte a = (byte) ((z ? 1 : 0) + (m428a(i) * 2));
        byte[] bArr3 = new byte[]{(byte) 112, a, (byte) 64, (byte) 6, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        this.f408j.close();
        this.f408j.connect();
        Log.v("TagInfo_MFP", "auth cmd1: " + C0429j.m1409e(bArr3));
        byte[] transceive = this.f408j.transceive(bArr3);
        Log.v("TagInfo_MFP", "auth resp1: " + C0429j.m1409e(transceive));
        if (!ab.m431a(transceive, 17)) {
            return null;
        }
        Object obj = new byte[]{Byte.MIN_VALUE, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1};
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        try {
            byte[] a2 = ab.m436a(Arrays.copyOfRange(transceive, 1, 17), 2, secretKeySpec, f401d);
            Object obj2 = new byte[]{a2[1], a2[2], a2[3], a2[4], a2[5], a2[6], a2[7], a2[8], a2[9], a2[10], a2[11], a2[12], a2[13], a2[14], a2[15], a2[0]};
            byte[] bArr4 = new byte[(obj.length + obj2.length)];
            System.arraycopy(obj, 0, bArr4, 0, obj.length);
            System.arraycopy(obj2, 0, bArr4, obj.length, obj2.length);
            Log.v("TagInfo_MFP", "auth rndARndB1: " + C0429j.m1409e(bArr4));
            obj2 = ab.m436a(bArr4, 1, secretKeySpec, f401d);
            Object obj3 = new byte[(obj2.length + 1)];
            obj3[0] = (byte) 114;
            System.arraycopy(obj2, 0, obj3, 1, obj2.length);
            Log.v("TagInfo_MFP", "auth cmd2: " + C0429j.m1409e(obj3));
            transceive = this.f408j.transceive(obj3);
            Log.v("TagInfo_MFP", "auth resp2: " + C0429j.m1409e(transceive));
            if (ab.m431a(transceive, 33)) {
                transceive = ab.m436a(Arrays.copyOfRange(transceive, 1, transceive.length), 2, secretKeySpec, f401d);
                Log.v("TagInfo_MFP", "auth payload: " + C0429j.m1409e(transceive));
                transceive = Arrays.copyOfRange(transceive, 0, 4);
                Log.v("TagInfo_MFP", "auth rndA: " + C0429j.m1409e(obj));
                Log.v("TagInfo_MFP", "auth rndB: " + C0429j.m1409e(a2));
                bArr4 = new byte[16];
                while (i2 < 5) {
                    bArr4[i2] = obj[i2 + 7];
                    bArr4[i2 + 5] = a2[i2 + 7];
                    bArr4[i2 + 10] = (byte) (obj[i2] ^ a2[i2]);
                    i2++;
                }
                bArr4[15] = (byte) 34;
                obj = ab.m436a(bArr4, 1, secretKeySpec, f401d);
                System.arraycopy(obj, 0, bArr2, 0, obj.length);
                return transceive;
            }
            if (transceive != null && transceive.length > 0 && transceive[0] == (byte) 6) {
                Log.v("TagInfo_MFP", "Authentication error");
            }
            return null;
        } catch (GeneralSecurityException e) {
            Log.v("TagInfo_MFP", "some security exception occurred");
            return null;
        }
    }

    private static byte[] m435a(byte[] bArr) {
        int i = 0;
        int i2 = (bArr[0] & MotionEventCompat.ACTION_MASK) >> 7;
        byte[] bArr2 = new byte[bArr.length];
        while (i < bArr.length - 1) {
            bArr2[i] = (byte) ((bArr[i] << 1) + ((bArr[i + 1] & MotionEventCompat.ACTION_MASK) >> 7));
            i++;
        }
        bArr2[bArr.length - 1] = (byte) (bArr[bArr.length - 1] << 1);
        if (i2 == 1) {
            i = bArr.length - 1;
            bArr2[i] = (byte) (bArr2[i] ^ -121);
        }
        return bArr2;
    }

    private static byte[] m436a(byte[] bArr, int i, SecretKeySpec secretKeySpec, byte[] bArr2) {
        Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
        instance.init(i, secretKeySpec, new IvParameterSpec(bArr2));
        return instance.doFinal(bArr);
    }

    private static byte[] m437a(byte[] bArr, SecretKeySpec secretKeySpec, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[]{bArr[0], bArr2[0], bArr2[1], bArr3[0], bArr3[1], bArr3[2], bArr3[3], bArr[1], bArr[2], bArr[3], Byte.MIN_VALUE, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        try {
            byte[] a = ab.m435a(ab.m435a(ab.m436a(f401d, 1, secretKeySpec, f401d)));
            byte[] bArr5 = new byte[bArr4.length];
            for (int i = 0; i < bArr4.length; i++) {
                bArr5[i] = (byte) (bArr4[i] ^ a[i]);
            }
            byte[] a2 = ab.m436a(bArr5, 1, secretKeySpec, f401d);
            Object obj = new byte[]{a2[1], a2[3], a2[5], a2[7], a2[9], a2[11], a2[13], a2[15]};
            Object obj2 = new byte[(bArr.length + 8)];
            System.arraycopy(bArr, 0, obj2, 0, bArr.length);
            System.arraycopy(obj, 0, obj2, bArr.length, obj.length);
            return obj2;
        } catch (GeneralSecurityException e) {
            return null;
        }
    }

    private ad m438e() {
        byte[] bArr = new byte[]{(byte) 72};
        this.f408j.connect();
        bArr = this.f408j.transceive(bArr);
        this.f408j.close();
        return Arrays.equals(bArr, new byte[]{(byte) 11}) ? ad.SL0 : ad.SL3;
    }

    private ae m439f() {
        if (this.f406h != ad.SL3) {
            return ae.UNKNOWN;
        }
        byte[] bArr = new byte[]{(byte) 112, (byte) 64, (byte) 64, (byte) 1, (byte) 0};
        this.f408j.connect();
        bArr = this.f408j.transceive(bArr);
        this.f408j.close();
        return Arrays.equals(bArr, new byte[]{(byte) 9}) ? ae.TwoK : ae.FourK;
    }

    private af m440g() {
        if (this.f406h != ad.SL3) {
            return af.UNKNOWN;
        }
        byte[] bArr = new byte[]{(byte) -16};
        this.f408j.connect();
        bArr = this.f408j.transceive(bArr);
        this.f408j.close();
        return ab.m431a(bArr, 1) ? af.PLUS_X : af.PLUS_S;
    }

    private boolean m441h() {
        if (this.f406h != ad.SL3) {
            return false;
        }
        byte[] bArr = new byte[]{(byte) 112, (byte) 0, (byte) 64, (byte) 1, (byte) 0};
        this.f408j.connect();
        bArr = this.f408j.transceive(bArr);
        this.f408j.close();
        return Arrays.equals(bArr, new byte[]{(byte) 11});
    }

    private C0350d m442i() {
        byte[] bArr = new byte[16];
        byte[] a = m433a(0, f402e, bArr);
        if (a == null) {
            return null;
        }
        Object obj;
        this.f413o = true;
        byte[] bArr2 = new byte[]{(byte) 0, (byte) 0};
        int i = m432a(3, 1, bArr, bArr2, a)[9] & MotionEventCompat.ACTION_MASK;
        Object a2 = m432a(1, 2, bArr, bArr2, a);
        if ((i & 3) == 2) {
            byte[] a3 = m433a(16, f402e, bArr);
            if (a3 != null) {
                obj = new byte[80];
                System.arraycopy(m432a(64, 3, bArr, bArr2, a3), 0, obj, 32, 48);
            } else {
                obj = new byte[32];
            }
        } else {
            obj = new byte[32];
        }
        System.arraycopy(a2, 0, obj, 0, 32);
        return new C0350d(obj, i);
    }

    public String m443a(boolean z) {
        return C0347a.m1015a(this.f413o, this.f414p, z);
    }

    public void m444a(C0197a c0197a, boolean z) {
        if (this.f404f != ae.UNKNOWN) {
            c0197a.m193a((CharSequence) f403q.get(this.f404f));
        }
        if (this.f406h != ad.UNKNOWN) {
            CharSequence charSequence = null;
            switch (ac.f415a[this.f406h.ordinal()]) {
                case C0519c.Switch_track /*1*/:
                    charSequence = "Security Level 0";
                    break;
                case C0519c.Switch_textOn /*2*/:
                    charSequence = "Security Level 3";
                    break;
            }
            c0197a.m200d(charSequence);
        }
        m449b(c0197a, false);
        byte[] historicalBytes = this.f408j.getHistoricalBytes();
        if (historicalBytes == null || historicalBytes.length == 0) {
            historicalBytes = C0351d.m1042c(this.f411m);
        }
        c0197a.m206g(C0351d.m1034a(historicalBytes, this.f410l.getId()));
        if (this.f405g != af.PLUS_X || this.f406h != ad.SL3) {
            return;
        }
        if (this.f412n) {
            c0197a.m203e("Proximity check", "Proximity check mandatory");
        } else {
            c0197a.m203e("Proximity check", "Proximity check optional");
        }
    }

    public void m445a(C0198b c0198b, boolean z) {
    }

    public void m446a(C0199c c0199c, boolean z) {
        c0199c.m230d("NXP Semiconductors");
        StringBuilder stringBuilder = new StringBuilder();
        Object d = m452d();
        stringBuilder.append("MIFARE Plus");
        if (this.f405g == af.PLUS_X) {
            stringBuilder.append(" X");
        } else if (this.f405g == af.PLUS_S) {
            stringBuilder.append(" S");
        }
        if (!TextUtils.isEmpty(d)) {
            stringBuilder.append(" (");
            stringBuilder.append(d);
            stringBuilder.append(")");
        }
        c0199c.m231e(stringBuilder.toString());
        CharSequence a = m443a(false);
        if (!TextUtils.isEmpty(a)) {
            c0199c.m228b("MIFARE applications", a);
        }
    }

    public void m447a(C0200d c0200d, boolean z) {
        c0200d.m238a((CharSequence) "ISO/IEC 14443-4 (Type A) compatible\nISO/IEC 14443-3 (Type A) compatible\nISO/IEC 14443-2 (Type A) compatible");
        C0369v.m1095a(this.f407i, this.f408j, this.f411m, c0200d);
    }

    public boolean m448a() {
        return true;
    }

    public void m449b(C0197a c0197a, boolean z) {
        C0347a.m1016a(c0197a, this.f414p, z, false, true);
    }

    public boolean m450b() {
        return this.f409k;
    }

    public byte[] m451c() {
        return this.f410l.getId();
    }

    public String m452d() {
        if (this.f405g != af.PLUS_X) {
            if (this.f405g == af.PLUS_S) {
                switch (ac.f416b[this.f404f.ordinal()]) {
                    case C0519c.Switch_track /*1*/:
                        return "MF1SPLUS60";
                    case C0519c.Switch_textOn /*2*/:
                        return "MF1SPLUS80";
                    case C0519c.Switch_textOff /*3*/:
                        return "MF1SPLUSx0";
                    default:
                        break;
                }
            }
        }
        switch (ac.f416b[this.f404f.ordinal()]) {
            case C0519c.Switch_track /*1*/:
                return "MF1PLUS60";
            case C0519c.Switch_textOn /*2*/:
                return "MF1PLUS80";
            case C0519c.Switch_textOff /*3*/:
                return "MF1PLUSx0";
        }
        return null;
    }
}
