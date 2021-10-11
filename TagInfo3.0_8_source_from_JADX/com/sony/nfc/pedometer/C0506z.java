package com.sony.nfc.pedometer;

import com.sony.nfc.C0474d;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.NfcTag;
import com.sony.nfc.p024a.C0454a;
import com.sony.nfc.p025b.C0466a;

/* renamed from: com.sony.nfc.pedometer.z */
public class C0506z extends C0474d {
    private int f1610a;

    public C0506z() {
        this(1);
    }

    public C0506z(int i) {
        this.f1610a = 1;
        this.f1610a = i;
    }

    protected NfcTag m1757a(NfcTag nfcTag) {
        C0466a.m1497a("PedometerUw101NfcDetector", "detect");
        NfcDynamicTag nfcDynamicTag = (NfcDynamicTag) super.m1532a(nfcTag);
        if (nfcDynamicTag == null) {
            return null;
        }
        if (!C0474d.m1531a((NfcTag) nfcDynamicTag, PedometerUw101Nfc.f1572a) && !C0474d.m1531a((NfcTag) nfcDynamicTag, PedometerUw101Nfc.f1573b)) {
            return nfcDynamicTag;
        }
        NfcTag pedometerUw101Nfc = new PedometerUw101Nfc(nfcDynamicTag);
        m1527b(pedometerUw101Nfc);
        if (this.f1610a == 1) {
            try {
                pedometerUw101Nfc.m1674e();
            } catch (C0454a e) {
                C0466a.m1497a("PedometerUw101NfcDetector", "Error:" + e);
            }
        }
        return pedometerUw101Nfc;
    }

    protected Class m1758a() {
        return PedometerUw101Nfc.class;
    }
}
