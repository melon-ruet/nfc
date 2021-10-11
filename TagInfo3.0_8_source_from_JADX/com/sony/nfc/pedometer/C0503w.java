package com.sony.nfc.pedometer;

import com.sony.nfc.C0474d;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.NfcTag;
import com.sony.nfc.p024a.C0454a;
import com.sony.nfc.p025b.C0466a;

/* renamed from: com.sony.nfc.pedometer.w */
public class C0503w extends C0474d {
    private int f1609a;

    public C0503w() {
        this(1);
    }

    public C0503w(int i) {
        this.f1609a = 1;
        this.f1609a = i;
    }

    protected NfcTag m1751a(NfcTag nfcTag) {
        C0466a.m1497a("PedometerMtn210Detector", "detect");
        NfcDynamicTag nfcDynamicTag = (NfcDynamicTag) super.m1532a(nfcTag);
        if (nfcDynamicTag == null) {
            return null;
        }
        if (!C0474d.m1531a((NfcTag) nfcDynamicTag, PedometerMtn210.f1557a)) {
            return nfcDynamicTag;
        }
        NfcTag pedometerMtn210 = new PedometerMtn210(nfcDynamicTag);
        m1527b(pedometerMtn210);
        try {
            if (this.f1609a == 1) {
                pedometerMtn210.m1664e();
            }
        } catch (C0454a e) {
            C0466a.m1497a("PedometerMtn210Detector", "Error:" + e);
        }
        return pedometerMtn210;
    }

    protected Class m1752a() {
        return PedometerMtn210.class;
    }
}
