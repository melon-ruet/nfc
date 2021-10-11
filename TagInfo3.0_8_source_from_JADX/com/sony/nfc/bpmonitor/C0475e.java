package com.sony.nfc.bpmonitor;

import com.sony.nfc.C0474d;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.NfcTag;
import com.sony.nfc.p024a.C0454a;
import com.sony.nfc.p025b.C0466a;

/* renamed from: com.sony.nfc.bpmonitor.e */
public class C0475e extends C0474d {
    private int f1472a;

    public C0475e() {
        this.f1472a = 1;
    }

    protected NfcTag m1535a(NfcTag nfcTag) {
        C0466a.m1497a("BpMonitorUa772NfcDetector", "detect");
        NfcDynamicTag nfcDynamicTag = (NfcDynamicTag) super.m1532a(nfcTag);
        if (nfcDynamicTag == null) {
            return null;
        }
        if (!C0474d.m1531a((NfcTag) nfcDynamicTag, BpMonitorUa772Nfc.f1467a)) {
            return nfcDynamicTag;
        }
        NfcTag bpMonitorUa772Nfc = new BpMonitorUa772Nfc(nfcDynamicTag);
        m1527b(bpMonitorUa772Nfc);
        if (this.f1472a == 1) {
            try {
                bpMonitorUa772Nfc.m1516e();
            } catch (C0454a e) {
                C0466a.m1497a("BpMonitorUa772NfcDetector", "Error:" + e);
            }
        }
        return bpMonitorUa772Nfc;
    }

    protected Class m1536a() {
        return BpMonitorUa772Nfc.class;
    }
}
