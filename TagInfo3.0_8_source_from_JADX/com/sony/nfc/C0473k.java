package com.sony.nfc;

import com.sony.nfc.p025b.C0466a;

/* renamed from: com.sony.nfc.k */
public class C0473k extends C0472f {
    protected NfcTag m1528a(NfcTag nfcTag) {
        C0466a.m1497a("Type3TagDetector", "detect");
        return Type3Tag.class.isAssignableFrom(nfcTag.getClass()) ? nfcTag : null;
    }

    protected Class m1529a() {
        return Type3Tag.class;
    }

    protected boolean m1530a(NfcTag nfcTag, C0472f c0472f) {
        return true;
    }
}
