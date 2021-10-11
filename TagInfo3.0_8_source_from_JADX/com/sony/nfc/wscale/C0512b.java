package com.sony.nfc.wscale;

import com.sony.nfc.C0474d;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.NfcTag;
import com.sony.nfc.p024a.C0454a;
import com.sony.nfc.p025b.C0466a;

/* renamed from: com.sony.nfc.wscale.b */
public class C0512b extends C0474d {
    private int f1645a;

    public C0512b() {
        this.f1645a = 1;
    }

    protected NfcTag m1803a(NfcTag nfcTag) {
        C0466a.m1497a("WScaleUc324NfcDetector", "detect");
        NfcDynamicTag nfcDynamicTag = (NfcDynamicTag) super.m1532a(nfcTag);
        if (nfcDynamicTag == null) {
            return null;
        }
        if (!C0474d.m1531a((NfcTag) nfcDynamicTag, WScaleUc324Nfc.f1619a) && !C0474d.m1531a((NfcTag) nfcDynamicTag, WScaleUc324Nfc.f1620b)) {
            return nfcDynamicTag;
        }
        NfcTag wScaleUc324Nfc = new WScaleUc324Nfc(nfcDynamicTag);
        m1527b(wScaleUc324Nfc);
        try {
            if (this.f1645a == 1) {
                wScaleUc324Nfc.m1779f();
            }
        } catch (C0454a e) {
            C0466a.m1497a("WScaleUc324NfcDetector", "Error:" + e);
        }
        return wScaleUc324Nfc;
    }

    protected Class m1804a() {
        return WScaleUc324Nfc.class;
    }
}
