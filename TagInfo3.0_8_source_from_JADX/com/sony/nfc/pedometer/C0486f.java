package com.sony.nfc.pedometer;

import com.sony.nfc.C0474d;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.NfcTag;
import com.sony.nfc.p024a.C0454a;
import com.sony.nfc.p025b.C0466a;

/* renamed from: com.sony.nfc.pedometer.f */
public class C0486f extends C0474d {
    private int f1598a;

    public C0486f() {
        this(1);
    }

    public C0486f(int i) {
        this.f1598a = 1;
        this.f1598a = i;
    }

    protected NfcTag m1717a(NfcTag nfcTag) {
        C0466a.m1497a("PedometerFs500ADetector", "detect");
        NfcDynamicTag nfcDynamicTag = (NfcDynamicTag) super.m1532a(nfcTag);
        if (nfcDynamicTag == null) {
            return null;
        }
        if (!C0474d.m1531a((NfcTag) nfcDynamicTag, PedometerFs500A.f1488a)) {
            return nfcDynamicTag;
        }
        NfcTag pedometerFs500A = new PedometerFs500A(nfcDynamicTag);
        m1527b(pedometerFs500A);
        if (this.f1598a == 1) {
            try {
                pedometerFs500A.m1574h();
            } catch (C0454a e) {
                C0466a.m1497a("PedometerFs500ADetector", "Error:" + e);
            }
        }
        return pedometerFs500A;
    }

    protected Class m1718a() {
        return PedometerFs500A.class;
    }
}
