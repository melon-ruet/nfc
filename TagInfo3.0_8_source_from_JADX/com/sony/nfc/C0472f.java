package com.sony.nfc;

import com.sony.nfc.p025b.C0466a;

/* renamed from: com.sony.nfc.f */
public class C0472f {
    protected C0472f() {
    }

    protected NfcTag m1524a(NfcTag nfcTag) {
        C0466a.m1497a("NfcTagDetector", "detect");
        return nfcTag;
    }

    protected Class m1525a() {
        return NfcTag.class;
    }

    protected boolean m1526a(NfcTag nfcTag, C0472f c0472f) {
        return true;
    }

    protected void m1527b(NfcTag nfcTag) {
        nfcTag.m1465b();
    }
}
