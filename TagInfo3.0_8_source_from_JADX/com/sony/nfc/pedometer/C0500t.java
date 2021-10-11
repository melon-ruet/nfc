package com.sony.nfc.pedometer;

import com.sony.nfc.C0474d;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.NfcTag;
import com.sony.nfc.p024a.C0454a;
import com.sony.nfc.p025b.C0466a;

/* renamed from: com.sony.nfc.pedometer.t */
public class C0500t extends C0474d {
    private int f1607a;
    private int f1608b;

    public C0500t() {
        this(1, 0);
    }

    public C0500t(int i, int i2) {
        this.f1607a = 1;
        if ((i != 3 || (i2 >= 10 && i2 <= 91)) && (i != 4 || (i2 >= 1 && i2 <= 8))) {
            this.f1607a = i;
            this.f1608b = i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    protected NfcTag m1745a(NfcTag nfcTag) {
        C0466a.m1497a("PedometerMtn200Detector", "detect");
        NfcDynamicTag nfcDynamicTag = (NfcDynamicTag) super.m1532a(nfcTag);
        if (nfcDynamicTag == null) {
            return null;
        }
        if (!C0474d.m1531a((NfcTag) nfcDynamicTag, PedometerMtn200.f1543a)) {
            return nfcDynamicTag;
        }
        NfcTag pedometerMtn200 = new PedometerMtn200(nfcDynamicTag);
        m1527b(pedometerMtn200);
        try {
            if (this.f1607a == 1) {
                pedometerMtn200.m1651e();
            } else if (this.f1607a == 2) {
                pedometerMtn200.m1652f();
            } else if (this.f1607a == 3) {
                pedometerMtn200.m1649c(this.f1608b);
            } else if (this.f1607a == 4) {
                pedometerMtn200.m1650d(this.f1608b);
            }
        } catch (C0454a e) {
            C0466a.m1497a("PedometerMtn200Detector", "Error:" + e);
        }
        return pedometerMtn200;
    }

    protected Class m1746a() {
        return PedometerMtn200.class;
    }
}
