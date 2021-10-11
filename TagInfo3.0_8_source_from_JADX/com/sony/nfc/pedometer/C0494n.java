package com.sony.nfc.pedometer;

import com.sony.nfc.C0474d;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.NfcTag;
import com.sony.nfc.p024a.C0454a;
import com.sony.nfc.p025b.C0466a;

/* renamed from: com.sony.nfc.pedometer.n */
public class C0494n extends C0474d {
    private int f1603a;

    public C0494n() {
        this(1);
    }

    public C0494n(int i) {
        this.f1603a = 1;
        this.f1603a = i;
    }

    protected NfcTag m1733a(NfcTag nfcTag) {
        C0466a.m1497a("PedometerJp700Detector", "detect");
        NfcDynamicTag nfcDynamicTag = (NfcDynamicTag) super.m1532a(nfcTag);
        if (nfcDynamicTag == null) {
            return null;
        }
        if (!C0474d.m1531a((NfcTag) nfcDynamicTag, PedometerJp700.f1520a) && !C0474d.m1531a((NfcTag) nfcDynamicTag, PedometerJp700.f1521b) && !C0474d.m1531a((NfcTag) nfcDynamicTag, PedometerJp700.f1522c)) {
            return nfcDynamicTag;
        }
        NfcTag pedometerJp700 = new PedometerJp700(nfcDynamicTag);
        m1527b(pedometerJp700);
        if (this.f1603a == 1) {
            try {
                pedometerJp700.m1617f();
            } catch (C0454a e) {
                C0466a.m1497a("PedometerJp700Detector", "Error:" + e);
            }
        }
        return pedometerJp700;
    }

    protected Class m1734a() {
        return PedometerJp700.class;
    }
}
