package com.sony.nfc.pedometer;

import com.sony.nfc.C0474d;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.NfcTag;
import com.sony.nfc.p024a.C0454a;
import com.sony.nfc.p025b.C0466a;

public class ac extends C0474d {
    private int f1594a;
    private int f1595b;
    private boolean f1596c;

    public ac() {
        this(1);
    }

    public ac(int i) {
        this.f1594a = 1;
        this.f1595b = 91;
        this.f1596c = false;
        this.f1594a = i;
    }

    protected NfcTag m1707a(NfcTag nfcTag) {
        C0466a.m1497a("PedometerUw201NfcDetector", "detect");
        NfcDynamicTag nfcDynamicTag = (NfcDynamicTag) super.m1532a(nfcTag);
        if (nfcDynamicTag == null) {
            return null;
        }
        if (!C0474d.m1531a((NfcTag) nfcDynamicTag, PedometerUw201Nfc.f1579a)) {
            return nfcDynamicTag;
        }
        NfcTag pedometerUw201Nfc = new PedometerUw201Nfc(nfcDynamicTag);
        m1527b(pedometerUw201Nfc);
        try {
            if (this.f1594a == 1) {
                pedometerUw201Nfc.m1697l();
            } else if (this.f1594a == 2) {
                pedometerUw201Nfc.m1698m();
            } else if (this.f1594a == 3) {
                pedometerUw201Nfc.m1689c(1);
            } else if (this.f1594a == 4) {
                pedometerUw201Nfc.m1689c(8);
            } else if (this.f1594a == 5) {
                pedometerUw201Nfc.m1688a(this.f1595b, this.f1596c);
            }
        } catch (C0454a e) {
            C0466a.m1497a("PedometerUw201NfcDetector", "Error:" + e);
        }
        return pedometerUw201Nfc;
    }

    protected Class m1708a() {
        return PedometerUw201Nfc.class;
    }
}
