package com.sony.nfc.wscale;

import android.support.v4.view.MotionEventCompat;
import com.sony.nfc.C0474d;
import com.sony.nfc.NfcDynamicTag;
import com.sony.nfc.NfcTag;
import com.sony.nfc.p024a.C0454a;
import com.sony.nfc.p025b.C0466a;

/* renamed from: com.sony.nfc.wscale.e */
public class C0515e extends C0474d {
    private int f1646a;
    private int f1647b;
    private int f1648c;
    private boolean f1649d;
    private int f1650e;
    private int f1651f;
    private int f1652g;

    private C0515e() {
        this.f1646a = 1;
        this.f1650e = 0;
        this.f1651f = -1;
        this.f1652g = 0;
    }

    public C0515e(int i, int i2, int i3, int i4, boolean z) {
        this(i, i2, i3, i4, z, 0, -1);
    }

    public C0515e(int i, int i2, int i3, int i4, boolean z, int i5, int i6) {
        this.f1646a = 1;
        this.f1650e = 0;
        this.f1651f = -1;
        this.f1652g = 0;
        if (i2 < 0 || i2 > 5 || ((i3 != -1 && (i3 < 900 || i3 > 2200)) || ((i4 != -1 && (i4 < 10 || i4 > 80)) || i5 < 0 || i5 > MotionEventCompat.ACTION_MASK || ((i6 < 9745 || i6 > 9999) && i6 != -1)))) {
            throw new IllegalArgumentException();
        }
        this.f1652g = i2;
        this.f1646a = i;
        this.f1647b = i3;
        this.f1648c = i4;
        this.f1649d = z;
        this.f1650e = i5;
        this.f1651f = i6;
    }

    protected NfcTag m1809a(NfcTag nfcTag) {
        C0466a.m1497a("WScaleUc411NfcDetector", "detect");
        NfcTag nfcTag2 = (NfcDynamicTag) super.m1532a(nfcTag);
        if (nfcTag2 == null) {
            return null;
        }
        if (!C0474d.m1531a(nfcTag2, WScaleUc411Nfc.f1624a)) {
            return nfcTag2;
        }
        NfcTag wScaleUc411Nfc = new WScaleUc411Nfc(nfcTag2, this.f1652g, this.f1647b, this.f1648c, this.f1649d, this.f1650e, this.f1651f, null);
        m1527b(wScaleUc411Nfc);
        if (this.f1646a == 2) {
            try {
                wScaleUc411Nfc.m1788c(this.f1652g);
            } catch (C0454a e) {
                C0466a.m1497a("WScaleUc411NfcDetector", "Error:" + e);
            }
        }
        if (this.f1646a == 1 || this.f1646a == 2) {
            try {
                wScaleUc411Nfc.m1790f();
            } catch (C0454a e2) {
                C0466a.m1497a("WScaleUc411NfcDetector", "Error:" + e2);
            }
        }
        return wScaleUc411Nfc;
    }

    protected Class m1810a() {
        return WScaleUc411Nfc.class;
    }
}
