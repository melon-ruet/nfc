package com.nxp.taginfolite.p009e.p012c;

import com.sony.nfc.NfcTag;
import com.sony.nfc.bpmonitor.C0468b;
import com.sony.nfc.pedometer.C0481a;
import com.sony.nfc.thermometer.C0508a;
import com.sony.nfc.wscale.C0510f;

/* renamed from: com.nxp.taginfolite.e.c.e */
public class C0266e {
    public static C0264d m606a(NfcTag nfcTag) {
        Class cls = nfcTag.getClass();
        return C0468b.class.isAssignableFrom(cls) ? new C0265c(nfcTag) : C0481a.class.isAssignableFrom(cls) ? new C0267f(nfcTag) : C0510f.class.isAssignableFrom(cls) ? new C0269h(nfcTag) : C0508a.class.isAssignableFrom(cls) ? new C0268g(nfcTag) : null;
    }
}
