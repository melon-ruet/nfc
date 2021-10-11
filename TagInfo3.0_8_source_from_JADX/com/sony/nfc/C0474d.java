package com.sony.nfc;

import com.sony.nfc.p024a.C0454a;
import com.sony.nfc.p025b.C0466a;

/* renamed from: com.sony.nfc.d */
public class C0474d extends C0473k {
    protected static boolean m1531a(NfcTag nfcTag, byte[] bArr) {
        byte[] d = nfcTag.m1467d();
        for (int i = 0; i < bArr.length; i++) {
            if (d[i + 2] != bArr[i]) {
                return false;
            }
        }
        return true;
    }

    protected NfcTag m1532a(NfcTag nfcTag) {
        NfcTag nfcTag2 = null;
        C0466a.m1497a("NfcDynamicTagDetector", "detect");
        if (NfcDynamicTag.class.isAssignableFrom(nfcTag.getClass())) {
            return nfcTag;
        }
        if (!Type3Tag.class.isAssignableFrom(nfcTag.getClass())) {
            return nfcTag2;
        }
        try {
            nfcTag = new NfcDynamicTag(((Type3Tag) nfcTag).m1475b(65249));
            m1527b(nfcTag);
            return nfcTag;
        } catch (C0454a e) {
            return nfcTag2;
        }
    }

    protected Class m1533a() {
        return NfcDynamicTag.class;
    }

    protected boolean m1534a(NfcTag nfcTag, C0472f c0472f) {
        return NfcDynamicTag.class.isAssignableFrom(nfcTag.getClass()) || !NfcDynamicTag.class.isAssignableFrom(c0472f.m1525a());
    }
}
