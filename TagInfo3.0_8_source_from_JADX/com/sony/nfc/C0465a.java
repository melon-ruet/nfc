package com.sony.nfc;

import android.app.Activity;
import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.NfcF;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.sony.nfc.p024a.C0455b;
import com.sony.nfc.p024a.C0458e;
import com.sony.nfc.p024a.C0459f;
import com.sony.nfc.p024a.C0461h;
import com.sony.nfc.p025b.C0466a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.sony.nfc.a */
public class C0465a extends C0464i {
    private static Method f1450n;
    private static Class f1451o;
    private static Method f1452p;
    private static Method f1453q;
    private static int f1454r;
    private static int f1455s;
    private Activity f1456h;
    private NfcAdapter f1457i;
    private boolean f1458j;
    private int f1459k;
    private boolean f1460l;
    private Tag f1461m;

    static {
        try {
            f1450n = NfcF.class.getMethod("setTimeout", new Class[]{Integer.TYPE});
            C0466a.m1497a("AndroidNfcTagManager", "setTimeout is available.");
        } catch (NoSuchMethodException e) {
        }
        f1454r = 4;
        f1455s = AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS;
        try {
            f1451o = Class.forName("android.nfc.NfcAdapter$ReaderCallback");
        } catch (ClassNotFoundException e2) {
        }
        try {
            f1452p = NfcAdapter.class.getMethod("enableReaderMode", new Class[]{Activity.class, f1451o, Integer.TYPE, Bundle.class});
            f1453q = NfcAdapter.class.getMethod("disableReaderMode", new Class[]{Activity.class});
            C0466a.m1497a("AndroidNfcTagManager", "ReaderMode is available.");
        } catch (NoSuchMethodException e3) {
        }
    }

    private C0465a() {
        this.f1458j = false;
        this.f1459k = MotionEventCompat.ACTION_MASK;
        this.f1460l = false;
    }

    public C0465a(Activity activity) {
        this.f1458j = false;
        this.f1459k = MotionEventCompat.ACTION_MASK;
        this.f1460l = false;
        if (activity == null) {
            throw new NullPointerException();
        }
        this.f1456h = activity;
        this.f1457i = m1489a((Context) activity);
        if (this.f1457i == null) {
            throw new C0461h();
        }
    }

    private void m1488a(NfcF nfcF, int i) {
        if (i > this.f1459k) {
            i = this.f1459k;
        }
        if (f1450n != null) {
            try {
                f1450n.invoke(nfcF, new Object[]{new Integer(i)});
            } catch (InvocationTargetException e) {
            } catch (Exception e2) {
            }
        }
    }

    protected NfcAdapter m1489a(Context context) {
        return NfcAdapter.getDefaultAdapter(context);
    }

    protected Type3Tag m1490a(int i, int i2, int i3) {
        int i4 = 0;
        C0466a.m1497a("AndroidNfcTagManager", "selectType3");
        if (this.f1461m == null) {
            throw new C0455b();
        }
        m1488a(NfcF.get(this.f1461m), this.c);
        byte[] bArr = new byte[]{(byte) 6, (byte) 0, (byte) ((i >> 8) & MotionEventCompat.ACTION_MASK), (byte) ((i >> 0) & MotionEventCompat.ACTION_MASK), (byte) (i2 & MotionEventCompat.ACTION_MASK), (byte) (i3 & MotionEventCompat.ACTION_MASK)};
        while (i4 <= this.e) {
            try {
                Object transceive = NfcF.get(this.f1461m).transceive(bArr);
                if ((transceive.length == 18 || transceive.length == 20) && (transceive[0] & MotionEventCompat.ACTION_MASK) == transceive.length && (transceive[1] & MotionEventCompat.ACTION_MASK) == 1) {
                    Object obj = new byte[8];
                    System.arraycopy(transceive, 2, obj, 0, 8);
                    Object obj2 = new byte[8];
                    System.arraycopy(transceive, 10, obj2, 0, 8);
                    byte[] bArr2 = null;
                    if (transceive.length == 20) {
                        bArr2 = new byte[2];
                        System.arraycopy(transceive, 18, bArr2, 0, 2);
                    }
                    return new Type3Tag(new NfcTag(this, obj), obj2, bArr2);
                }
                throw new C0458e();
            } catch (IOException e) {
                C0466a.m1498b("AndroidNfcTagManager", "selectType3:IOException");
                i4++;
            }
        }
        throw new C0459f();
    }

    protected void m1491a() {
        C0466a.m1497a("AndroidNfcTagManager", "connectType3");
        try {
            NfcF.get(this.f1461m).connect();
        } catch (IOException e) {
            throw new C0459f();
        }
    }

    public void m1492a(Tag tag, C0472f[] c0472fArr, C0262h c0262h) {
        NfcTag type3Tag;
        NfcTag nfcTag;
        C0466a.m1497a("AndroidNfcTagManager", "readTag");
        this.f1461m = tag;
        NfcTag nfcTag2 = new NfcTag(this, tag.getId());
        String[] techList = tag.getTechList();
        int i = 0;
        while (i < techList.length) {
            if (NfcF.class.getName().equals(techList[i])) {
                type3Tag = new Type3Tag(nfcTag2, NfcF.get(tag).getManufacturer(), null);
                try {
                    m1491a();
                    nfcTag = type3Tag;
                    break;
                } catch (C0459f e) {
                }
            } else {
                i++;
            }
        }
        nfcTag = nfcTag2;
        type3Tag = m1482a(nfcTag, c0472fArr);
        if (type3Tag == null) {
            nfcTag.m1466c();
            return;
        }
        if (c0262h != null) {
            c0262h.m600b(type3Tag);
        }
        type3Tag.m1466c();
    }

    protected byte[] m1493a(byte[] bArr) {
        C0466a.m1497a("AndroidNfcTagManager", "transceiveType3");
        if (this.f1461m == null) {
            throw new C0455b();
        }
        m1488a(NfcF.get(this.f1461m), this.d);
        int i = 0;
        while (i <= this.f) {
            try {
                return NfcF.get(this.f1461m).transceive(bArr);
            } catch (IOException e) {
                C0466a.m1498b("AndroidNfcTagManager", "transceiveType3:IOException");
                i++;
            }
        }
        throw new C0459f();
    }

    protected void m1494b() {
        C0466a.m1497a("AndroidNfcTagManager", "disconnectType3");
        try {
            NfcF.get(this.f1461m).close();
        } catch (IOException e) {
            C0466a.m1498b("AndroidNfcTagManager", "disconnectType3:close");
            throw new C0459f();
        }
    }
}
