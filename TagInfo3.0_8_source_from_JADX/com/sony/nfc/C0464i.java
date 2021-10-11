package com.sony.nfc;

import com.sony.nfc.p024a.C0463j;
import com.sony.nfc.p025b.C0466a;

/* renamed from: com.sony.nfc.i */
public abstract class C0464i {
    protected C0262h f1443a;
    protected int f1444b;
    protected int f1445c;
    protected int f1446d;
    protected int f1447e;
    protected int f1448f;
    protected boolean f1449g;

    public C0464i() {
        this.f1444b = 500;
        this.f1445c = 100;
        this.f1446d = 400;
        this.f1447e = 0;
        this.f1448f = 2;
    }

    protected NfcTag m1482a(NfcTag nfcTag, C0472f[] c0472fArr) {
        int i = 0;
        C0466a.m1497a("NfcTagManager", "detect");
        this.f1449g = false;
        boolean[] zArr = new boolean[c0472fArr.length];
        while (i < c0472fArr.length) {
            if (!(c0472fArr[i] == null || !nfcTag.getClass().isAssignableFrom(c0472fArr[i].m1525a()) || zArr[i])) {
                NfcTag a = c0472fArr[i].m1524a(nfcTag);
                if (a != null) {
                    C0466a.m1497a("NfcTagManager", "Detect:" + a.getClass());
                    C0466a.m1497a("NfcTagManager", "REQ:" + c0472fArr[i].m1525a());
                    if (a.getClass().equals(c0472fArr[i].m1525a())) {
                        return a;
                    }
                    nfcTag = a;
                } else {
                    for (int i2 = i + 1; i2 < c0472fArr.length; i2++) {
                        if (!c0472fArr[i2].m1526a(nfcTag, c0472fArr[i])) {
                            zArr[i2] = true;
                        }
                    }
                }
            }
            i++;
        }
        if (this.f1449g) {
            C0466a.m1497a("NfcTagManager", "unknown tag");
            this.f1443a.m599a(new C0463j());
        }
        return null;
    }

    protected abstract Type3Tag m1483a(int i, int i2, int i3);

    protected abstract void m1484a();

    protected void m1485a(NfcTag nfcTag) {
        C0262h c0262h = this.f1443a;
        if (c0262h != null) {
            c0262h.m598a(nfcTag);
            this.f1449g = true;
        }
    }

    protected abstract byte[] m1486a(byte[] bArr);

    protected abstract void m1487b();
}
