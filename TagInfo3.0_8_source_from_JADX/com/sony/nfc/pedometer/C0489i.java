package com.sony.nfc.pedometer;

import com.sony.nfc.C0474d;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.NfcTag;
import com.sony.nfc.p024a.C0454a;
import com.sony.nfc.p025b.C0466a;

/* renamed from: com.sony.nfc.pedometer.i */
public class C0489i extends C0474d {
    private int f1599a;
    private int f1600b;
    private boolean f1601c;

    public C0489i() {
        this(1);
    }

    public C0489i(int i) {
        this.f1599a = 1;
        this.f1600b = 91;
        this.f1601c = false;
        this.f1599a = i;
    }

    protected NfcTag m1723a(NfcTag nfcTag) {
        C0466a.m1497a("PedometerFs700Detector", "detect");
        NfcDynamicTag nfcDynamicTag = (NfcDynamicTag) super.m1532a(nfcTag);
        if (nfcDynamicTag == null) {
            return null;
        }
        if (!C0474d.m1531a((NfcTag) nfcDynamicTag, PedometerFs700.f1494a)) {
            return nfcDynamicTag;
        }
        NfcTag pedometerFs700 = new PedometerFs700(nfcDynamicTag);
        m1527b(pedometerFs700);
        try {
            if (this.f1599a == 1) {
                pedometerFs700.m1593i();
            } else if (this.f1599a == 2) {
                pedometerFs700.m1594j();
            } else if (this.f1599a == 3) {
                pedometerFs700.m1588c(1);
            } else if (this.f1599a == 4) {
                pedometerFs700.m1588c(8);
            } else if (this.f1599a == 5) {
                pedometerFs700.m1587a(this.f1600b, this.f1601c);
            }
        } catch (C0454a e) {
            C0466a.m1497a("PedometerFs700Detector", "Error:" + e);
        }
        return pedometerFs700;
    }

    protected Class m1724a() {
        return PedometerFs700.class;
    }
}
