package com.nxp.taginfolite.p009e.p012c;

import com.sony.nfc.C0262h;
import com.sony.nfc.NfcTag;
import com.sony.nfc.p024a.C0454a;

/* renamed from: com.nxp.taginfolite.e.c.b */
class C0263b implements C0262h {
    final /* synthetic */ C0261a f612a;

    C0263b(C0261a c0261a) {
        this.f612a = c0261a;
    }

    public void m601a(NfcTag nfcTag) {
    }

    public void m602a(C0454a c0454a) {
        this.f612a.m595a(String.format("Error:%s\n", new Object[]{c0454a.getClass().getSimpleName()}));
    }

    public void m603b(NfcTag nfcTag) {
        this.f612a.m594a(nfcTag);
    }
}
