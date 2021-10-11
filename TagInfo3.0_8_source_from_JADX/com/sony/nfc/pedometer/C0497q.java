package com.sony.nfc.pedometer;

import com.sony.nfc.C0474d;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.NfcTag;
import com.sony.nfc.p024a.C0454a;
import com.sony.nfc.p025b.C0466a;

/* renamed from: com.sony.nfc.pedometer.q */
public class C0497q extends C0474d {
    private int f1604a;
    private int f1605b;
    private boolean f1606c;

    public C0497q() {
        this(1);
    }

    public C0497q(int i) {
        this.f1604a = 1;
        this.f1605b = 91;
        this.f1606c = false;
        this.f1604a = i;
    }

    protected NfcTag m1739a(NfcTag nfcTag) {
        C0466a.m1497a("PedometerMi700Detector", "detect");
        NfcDynamicTag nfcDynamicTag = (NfcDynamicTag) super.m1532a(nfcTag);
        if (nfcDynamicTag == null) {
            return null;
        }
        if (!C0474d.m1531a((NfcTag) nfcDynamicTag, PedometerMi700.f1528a)) {
            return nfcDynamicTag;
        }
        NfcTag pedometerMi700 = new PedometerMi700(nfcDynamicTag);
        m1527b(pedometerMi700);
        try {
            if (this.f1604a == 1) {
                pedometerMi700.m1632e();
            } else if (this.f1604a == 2) {
                pedometerMi700.m1633f();
            } else if (this.f1604a == 3) {
                pedometerMi700.m1631c(1);
            } else if (this.f1604a == 4) {
                pedometerMi700.m1631c(8);
            } else if (this.f1604a == 5) {
                pedometerMi700.m1630a(this.f1605b, this.f1606c);
            }
        } catch (C0454a e) {
            C0466a.m1497a("PedometerMi700Detector", "Error:" + e);
        }
        return pedometerMi700;
    }

    protected Class m1740a() {
        return PedometerMi700.class;
    }
}
