package com.sony.nfc.pedometer;

import com.sony.nfc.C0474d;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.NfcTag;
import com.sony.nfc.p024a.C0454a;
import com.sony.nfc.p025b.C0466a;

/* renamed from: com.sony.nfc.pedometer.d */
public class C0484d extends C0474d {
    private int f1597a;

    public C0484d() {
        this(1);
    }

    public C0484d(int i) {
        this.f1597a = 1;
        this.f1597a = i;
    }

    protected NfcTag m1713a(NfcTag nfcTag) {
        C0466a.m1497a("PedometerEx950Detector", "detect");
        NfcDynamicTag nfcDynamicTag = (NfcDynamicTag) super.m1532a(nfcTag);
        if (nfcDynamicTag == null) {
            return null;
        }
        if (!C0474d.m1531a((NfcTag) nfcDynamicTag, PedometerEx950.f1482a)) {
            return nfcDynamicTag;
        }
        NfcTag pedometerEx950 = new PedometerEx950(nfcDynamicTag);
        m1527b(pedometerEx950);
        if (this.f1597a == 1) {
            try {
                pedometerEx950.m1563h();
            } catch (C0454a e) {
                C0466a.m1497a("PedometerEx950Detector", "Error:" + e);
            }
        }
        return pedometerEx950;
    }

    protected Class m1714a() {
        return PedometerEx950.class;
    }
}
