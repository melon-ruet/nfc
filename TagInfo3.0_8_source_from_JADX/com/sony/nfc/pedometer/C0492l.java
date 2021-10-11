package com.sony.nfc.pedometer;

import com.sony.nfc.C0474d;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.NfcTag;
import com.sony.nfc.p024a.C0454a;
import com.sony.nfc.p025b.C0466a;

/* renamed from: com.sony.nfc.pedometer.l */
public class C0492l extends C0474d {
    private int f1602a;

    public C0492l() {
        this(1);
    }

    public C0492l(int i) {
        this.f1602a = 1;
        this.f1602a = i;
    }

    protected NfcTag m1729a(NfcTag nfcTag) {
        C0466a.m1497a("PedometerFs750Detector", "detect");
        NfcDynamicTag nfcDynamicTag = (NfcDynamicTag) super.m1532a(nfcTag);
        if (nfcDynamicTag == null) {
            return null;
        }
        if (!C0474d.m1531a((NfcTag) nfcDynamicTag, PedometerFs750.f1509a)) {
            return nfcDynamicTag;
        }
        NfcTag pedometerFs750 = new PedometerFs750(nfcDynamicTag);
        m1527b(pedometerFs750);
        try {
            if (this.f1602a == 1) {
                pedometerFs750.m1607e();
            }
        } catch (C0454a e) {
            C0466a.m1497a("PedometerFs750Detector", "Error:" + e);
        }
        return pedometerFs750;
    }

    protected Class m1730a() {
        return PedometerFs750.class;
    }
}
