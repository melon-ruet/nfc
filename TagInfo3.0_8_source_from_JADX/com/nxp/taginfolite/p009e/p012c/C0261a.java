package com.nxp.taginfolite.p009e.p012c;

import android.app.Activity;
import android.nfc.Tag;
import android.support.v4.BuildConfig;
import android.util.Log;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0358k;
import com.sony.nfc.C0262h;
import com.sony.nfc.C0464i;
import com.sony.nfc.C0465a;
import com.sony.nfc.C0472f;
import com.sony.nfc.C0474d;
import com.sony.nfc.C0478g;
import com.sony.nfc.NfcTag;
import com.sony.nfc.p024a.C0454a;
import java.util.Calendar;

/* renamed from: com.nxp.taginfolite.e.c.a */
public class C0261a {
    private C0464i f608a;
    private final C0472f[] f609b;
    private final C0428i f610c;
    private final C0262h f611d;

    public C0261a(Activity activity) {
        this.f611d = new C0263b(this);
        C0472f[][] c0472fArr = new C0472f[2][];
        c0472fArr[0] = C0478g.m1541a();
        c0472fArr[1] = new C0472f[]{new C0474d()};
        this.f609b = C0478g.m1542a(c0472fArr);
        this.f610c = new C0428i();
        this.f608a = null;
        try {
            this.f608a = new C0465a(activity);
        } catch (C0454a e) {
            Log.e("FeliCa Plug", "Error: new AndroidNfcTagManager()");
        }
    }

    public static String m590a(Calendar calendar) {
        int i = calendar.get(1);
        int i2 = calendar.get(2) + 1;
        int i3 = calendar.get(5);
        int i4 = calendar.get(11);
        int i5 = calendar.get(12);
        int i6 = calendar.get(13);
        return String.format(C0358k.f1076c + "%04d-%02d-%02d %02d:%02d:%02d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
    }

    public static String m591a(byte[] bArr) {
        return (bArr == null || bArr.length <= 0) ? null : C0358k.f1076c + "ID: " + C0429j.m1393a(bArr, BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME);
    }

    private void m594a(NfcTag nfcTag) {
        C0264d a = C0266e.m606a(nfcTag);
        if (a != null) {
            m595a(a.m604a());
        }
    }

    private void m595a(String str) {
        this.f610c.m1384a((CharSequence) str);
    }

    public static String m596b(Calendar calendar) {
        int i = calendar.get(1);
        int i2 = calendar.get(2) + 1;
        int i3 = calendar.get(5);
        return String.format(C0358k.f1076c + "%04d-%02d-%02d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public CharSequence m597a(Tag tag) {
        if (this.f608a != null && C0465a.class.isAssignableFrom(this.f608a.getClass())) {
            try {
                synchronized (this.f608a) {
                    ((C0465a) this.f608a).m1492a(tag, this.f609b, this.f611d);
                }
            } catch (C0454a e) {
                m595a("Error:" + e.getMessage());
            }
        }
        return this.f610c.m1386b();
    }
}
