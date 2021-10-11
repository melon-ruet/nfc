package com.sony.nfc;

import com.sony.nfc.bpmonitor.C0475e;
import com.sony.nfc.pedometer.C0484d;
import com.sony.nfc.pedometer.C0486f;
import com.sony.nfc.pedometer.C0489i;
import com.sony.nfc.pedometer.C0492l;
import com.sony.nfc.pedometer.C0494n;
import com.sony.nfc.pedometer.C0497q;
import com.sony.nfc.pedometer.C0500t;
import com.sony.nfc.pedometer.C0503w;
import com.sony.nfc.pedometer.C0506z;
import com.sony.nfc.pedometer.ac;
import com.sony.nfc.wscale.C0512b;
import com.sony.nfc.wscale.C0515e;

/* renamed from: com.sony.nfc.g */
public class C0478g {
    public static C0472f[] m1541a() {
        return new C0472f[]{new C0475e(), new C0486f(), new C0489i(), new C0492l(), new C0497q(), new C0500t(), new C0503w(), new C0484d(), new C0494n(), new C0506z(), new ac(), new C0512b(), new C0515e(1, 0, 1750, 32, true)};
    }

    public static C0472f[] m1542a(C0472f[]... c0472fArr) {
        int i;
        int i2 = 0;
        for (C0472f[] length : c0472fArr) {
            i2 += length.length;
        }
        Object obj = new C0472f[i2];
        i2 = 0;
        for (i = 0; i < c0472fArr.length; i++) {
            System.arraycopy(c0472fArr[i], 0, obj, i2, c0472fArr[i].length);
            i2 += c0472fArr[i].length;
        }
        return obj;
    }
}
