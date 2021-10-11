package com.nxp.taginfolite.p009e;

import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.tech.NfcF;
import android.support.v4.BuildConfig;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.C0360m;
import com.nxp.taginfolite.p004f.C0369v;
import com.nxp.taginfolite.p005b.C0182c;
import com.nxp.taginfolite.p005b.C0186f;
import com.nxp.taginfolite.p005b.C0187g;
import com.nxp.taginfolite.p005b.C0188i;
import com.nxp.taginfolite.p005b.C0194n;
import com.nxp.taginfolite.p006c.C0197a;
import com.nxp.taginfolite.p006c.C0198b;
import com.nxp.taginfolite.p006c.C0199c;
import com.nxp.taginfolite.p006c.C0200d;
import com.nxp.taginfolite.p009e.p012c.C0261a;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.h */
public final class C0309h implements ay {
    private static final SparseArray f827a;
    private static final SparseArray f828b;
    private static final SparseArray f829c;
    private static final SparseArray f830d;
    private static final SparseArray f831e;
    private byte[] f832A;
    private byte f833B;
    private byte[] f834C;
    private boolean f835D;
    private NfcF f836f;
    private boolean f837g;
    private byte[] f838h;
    private byte[] f839i;
    private int f840j;
    private int[] f841k;
    private boolean f842l;
    private boolean f843m;
    private boolean f844n;
    private byte[] f845o;
    private boolean f846p;
    private boolean f847q;
    private String f848r;
    private boolean f849s;
    private String f850t;
    private boolean f851u;
    private String f852v;
    private boolean f853w;
    private String f854x;
    private CharSequence f855y;
    private C0182c f856z;

    static {
        f827a = new C0310i();
        f828b = new C0311j();
        f829c = new C0312k();
        f830d = new C0313l();
        f831e = new C0314m();
    }

    public C0309h() {
        this.f836f = null;
        this.f837g = false;
        this.f842l = false;
        this.f843m = false;
        this.f844n = false;
        this.f845o = null;
        this.f846p = false;
        this.f847q = false;
        this.f848r = null;
        this.f849s = false;
        this.f850t = null;
        this.f851u = false;
        this.f852v = null;
        this.f853w = false;
        this.f854x = null;
        this.f855y = null;
        this.f856z = null;
        this.f832A = null;
        this.f833B = (byte) 0;
        this.f834C = null;
        this.f835D = false;
    }

    public static ay m831a(Tag tag, NfcF nfcF, boolean z, C0158a c0158a, C0261a c0261a) {
        boolean z2 = true;
        C0309h c0309h = new C0309h();
        c0309h.f836f = nfcF;
        c0309h.f838h = tag.getId();
        c0309h.f839i = nfcF.getManufacturer();
        c0309h.f846p = z;
        c0309h.f840j = -1;
        try {
            nfcF.connect();
            try {
                byte[] a = c0309h.m838a((int) Menu.USER_MASK, 1);
                byte[] a2 = c0309h.m838a((int) Menu.USER_MASK, 2);
                if (a != null && a[1] == (byte) 1 && a.length == 20) {
                    c0309h.f832A = new byte[]{a[18], a[19]};
                }
                if (a2 != null && a2[1] == (byte) 1 && a2.length == 20 && a2[18] == null) {
                    c0309h.f833B = a2[19];
                }
                a2 = c0309h.f832A;
                boolean z3 = a2 != null && a2.length > 1 && (a2[0] & MotionEventCompat.ACTION_MASK) == 136 && (a2[1] & MotionEventCompat.ACTION_MASK) == 180;
                c0309h.f842l = z3;
                byte[] manufacturer = nfcF.getManufacturer();
                if (manufacturer != null) {
                    c0309h.f843m = manufacturer[1] == -32;
                    z3 = (a2 == null || a2.length == 0) && (manufacturer[1] & MotionEventCompat.ACTION_MASK) == 2;
                    c0309h.f844n = z3;
                }
                if (c0309h.f842l) {
                    c0309h.m836a(z, c0158a.m56n());
                } else if (c0309h.f844n) {
                    c0309h.m843b(c0158a.m56n());
                } else if (c0309h.f843m) {
                    c0309h.m835a(c0158a.m56n(), c0261a);
                } else {
                    c0309h.m834a(c0158a.m56n());
                }
                int i = (c0309h.f842l || z) ? true : 0;
                int i2 = i;
                for (i = 0; i < c0309h.f840j && i2 == 0; i++) {
                    if ((c0309h.f841k[i] & Menu.USER_MASK) == 4860) {
                        i2 = true;
                    }
                }
                if (i2 != 0) {
                    try {
                        a = c0309h.m837a(4860);
                        if (a != null) {
                            c0309h.f834C = c0309h.m840a(a, 11, 0);
                        }
                        if (!c0309h.f846p && c0309h.f843m && c0158a.m56n()) {
                            c0309h.f856z = c0309h.m844c(true);
                        }
                    } catch (TagLostException e) {
                        if (c0309h.m855o()) {
                            z2 = false;
                        }
                        c0309h.f837g = z2;
                    } catch (IOException e2) {
                    }
                }
                try {
                    nfcF.close();
                } catch (IOException e3) {
                }
                return c0309h;
            } catch (TagLostException e4) {
                c0309h.f837g = true;
                return c0309h;
            } catch (IOException e5) {
                return c0309h;
            }
        } catch (TagLostException e6) {
            c0309h.f837g = true;
            return c0309h;
        } catch (IOException e7) {
            return c0309h;
        }
    }

    private static String m832a(byte b, boolean z) {
        int i = b & MotionEventCompat.ACTION_MASK;
        int i2 = ((i >>> 3) & 7) + 1;
        int i3 = (i & 7) + 1;
        float f = ((float) (1 << ((i >>> 6) * 2))) * 0.302f;
        StringBuilder stringBuilder = new StringBuilder();
        if (z) {
            stringBuilder.append(String.format(Locale.US, "%02.2f + n*%02.2f", new Object[]{Float.valueOf(((float) i3) * f), Float.valueOf(f * ((float) i2))}));
        } else {
            stringBuilder.append(String.format(Locale.US, "%02.2f", new Object[]{Float.valueOf(f * ((float) i3))}));
        }
        stringBuilder.append("\u200a");
        stringBuilder.append("ms");
        stringBuilder.append("<hexoutput>");
        stringBuilder.append(String.format(" (0x%02X)", new Object[]{Byte.valueOf(b)}));
        stringBuilder.append("</hexoutput>");
        return stringBuilder.toString();
    }

    private String m833a(boolean z, boolean z2, boolean z3, boolean z4) {
        String str = z ? "*" : ".";
        if (z2) {
            if (z3) {
                return str + (z4 ? "P" : "p");
            }
            return str + (z4 ? "W" : "w");
        } else if (z3) {
            return str + (z4 ? "R" : "r");
        } else {
            return str + (z4 ? "m" : " ");
        }
    }

    private void m834a(boolean z) {
        boolean z2 = true;
        if (this.f838h[0] == (byte) 3 && this.f838h[1] == -2) {
            this.f845o = new byte[]{this.f838h[2], this.f838h[3]};
        }
        try {
            m845e();
        } catch (TagLostException e) {
            this.f837g = !m855o();
        } catch (IOException e2) {
        }
        try {
            this.f847q = m849i();
            this.f849s = m847g();
            this.f851u = m846f();
            this.f853w = m848h();
        } catch (TagLostException e3) {
            if (m855o()) {
                z2 = false;
            }
            this.f837g = z2;
        } catch (IOException e4) {
        }
        if (z) {
            this.f856z = m850j();
        }
    }

    private void m835a(boolean z, C0261a c0261a) {
        if (this.f832A != null && this.f832A.length > 1) {
            this.f840j = 1;
            this.f841k = new int[]{C0429j.m1388a(this.f832A[0], this.f832A[1])};
        }
        if (this.f838h[0] == (byte) 3 && this.f838h[1] == -2) {
            this.f845o = new byte[]{this.f838h[2], this.f838h[3]};
        }
        try {
            this.f836f.close();
            this.f855y = c0261a.m597a(this.f836f.getTag());
            this.f836f.connect();
        } catch (Exception e) {
            Log.v("TagInfo_FC", "Felica Plug exception: " + e.getMessage());
        }
        if (z) {
            try {
                this.f856z = m844c(this.f846p);
            } catch (TagLostException e2) {
                this.f837g = true;
            } catch (IOException e3) {
            }
        }
    }

    private void m836a(boolean z, boolean z2) {
        if (z) {
            this.f840j = 2;
            this.f841k = new int[]{34996, 4860};
        } else {
            this.f840j = 1;
            this.f841k = new int[]{34996};
        }
        try {
            byte[] a = m840a(this.f838h, 11, (int) TransportMediator.KEYCODE_MEDIA_RECORD);
            if (!(a[8] == null && a[9] == null)) {
                this.f845o = new byte[]{a[8], a[9]};
            }
            this.f835D = m851k();
            if (z2) {
                this.f856z = m852l();
            }
        } catch (TagLostException e) {
            this.f837g = true;
        } catch (IOException e2) {
        }
    }

    private byte[] m837a(int i) {
        byte[] a = m838a(i, 0);
        return (a == null || a.length < 10 || a[1] != (byte) 1) ? null : Arrays.copyOfRange(a, 2, 10);
    }

    private byte[] m838a(int i, int i2) {
        return this.f836f.transceive(new byte[]{(byte) 0, (byte) ((i >>> 8) & MotionEventCompat.ACTION_MASK), (byte) (i & MotionEventCompat.ACTION_MASK), (byte) (i2 & MotionEventCompat.ACTION_MASK), (byte) 0, (byte) 6});
    }

    private byte[] m839a(byte[] bArr, byte b, byte[] bArr2) {
        if (bArr == null) {
            return null;
        }
        Object obj;
        int length = bArr2 != null ? bArr2.length : 0;
        Object obj2 = new byte[(length + 10)];
        obj2[0] = (byte) (length + 10);
        obj2[1] = b;
        System.arraycopy(bArr, 0, obj2, 2, bArr.length);
        if (bArr2 != null) {
            System.arraycopy(bArr2, 0, obj2, 10, bArr2.length);
        }
        obj2 = this.f836f.transceive(obj2);
        if (obj2 == null || obj2.length <= 10) {
            obj = null;
        } else {
            obj = new byte[(obj2.length - 9)];
            obj[0] = obj2[1];
            System.arraycopy(obj2, 10, obj, 1, obj2.length - 10);
        }
        return obj;
    }

    private byte[] m840a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[6];
        if (i2 > MotionEventCompat.ACTION_MASK) {
            bArr2 = new byte[7];
        }
        bArr2[0] = (byte) 1;
        bArr2[1] = (byte) (i & MotionEventCompat.ACTION_MASK);
        bArr2[2] = (byte) (i >>> 8);
        bArr2[3] = (byte) 1;
        if (i2 > MotionEventCompat.ACTION_MASK) {
            bArr2[4] = (byte) 0;
            bArr2[5] = (byte) (i2 & MotionEventCompat.ACTION_MASK);
            bArr2[6] = (byte) (i2 >>> 8);
        } else {
            bArr2[4] = Byte.MIN_VALUE;
            bArr2[5] = (byte) i2;
        }
        bArr2 = m839a(bArr, (byte) 6, bArr2);
        return (bArr2 != null && bArr2.length >= 20 && (bArr2[0] & MotionEventCompat.ACTION_MASK) == 7 && bArr2[1] == null && bArr2[2] == null && bArr2[3] == (byte) 1) ? Arrays.copyOfRange(bArr2, 4, 20) : null;
    }

    private byte[] m841a(byte[] bArr, int i, byte[] bArr2) {
        if (bArr == null) {
            return null;
        }
        int length = bArr2.length;
        byte[] bArr3 = new byte[((length * 2) + 4)];
        bArr3[0] = (byte) 1;
        bArr3[1] = (byte) (i & MotionEventCompat.ACTION_MASK);
        bArr3[2] = (byte) (i >>> 8);
        bArr3[3] = (byte) length;
        for (int i2 = 0; i2 < length; i2++) {
            bArr3[(i2 * 2) + 4] = Byte.MIN_VALUE;
            bArr3[(i2 * 2) + 5] = bArr2[i2];
        }
        byte[] a = m839a(bArr, (byte) 6, bArr3);
        return ((a[0] & MotionEventCompat.ACTION_MASK) == 7 && a[1] == null && a[2] == null && (a[3] & MotionEventCompat.ACTION_MASK) == length && a.length >= (length * 16) + 4) ? Arrays.copyOfRange(a, 4, (length * 16) + 4) : null;
    }

    private void m842b(C0198b c0198b, boolean z) {
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        int i = this.f834C[0] & MotionEventCompat.ACTION_MASK;
        int i2 = this.f834C[1] & MotionEventCompat.ACTION_MASK;
        int i3 = this.f834C[2] & MotionEventCompat.ACTION_MASK;
        int a = C0429j.m1388a(this.f834C[3], this.f834C[4]);
        int i4 = this.f834C[9] & MotionEventCompat.ACTION_MASK;
        int i5 = this.f834C[10] & MotionEventCompat.ACTION_MASK;
        int a2 = C0429j.m1389a(this.f834C[11], this.f834C[12], this.f834C[13]);
        int a3 = C0429j.m1388a(this.f834C[14], this.f834C[15]);
        stringBuilder.append(String.format("Mapping version: %d.%d\n", new Object[]{Integer.valueOf((i >>> 4) & 15), Integer.valueOf(i & 15)}));
        stringBuilder.append(String.format("Maximum blocks to read: %d\n", new Object[]{Integer.valueOf(i2)}));
        stringBuilder.append(String.format("Maximum blocks to write: %d\n", new Object[]{Integer.valueOf(i3)}));
        stringBuilder.append(String.format("Blocks for NDEF storage: %d (%d bytes)\n", new Object[]{Integer.valueOf(a), Integer.valueOf(a * 16)}));
        stringBuilder.append("NDEF writing state: ");
        if (i4 == 0) {
            stringBuilder.append("finished");
        } else if (i5 == 15) {
            stringBuilder.append("in progress");
        } else {
            stringBuilder.append("[unknown]");
        }
        stringBuilder.append(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(i4)}));
        stringBuilder.append("\n");
        stringBuilder.append("NDEF access: ");
        if (i5 == 0) {
            stringBuilder.append("Read-Only");
        } else if (i5 == 1) {
            stringBuilder.append(C0429j.m1391a((CharSequence) "Read & Write"));
        } else {
            stringBuilder.append("[unknown]");
        }
        stringBuilder.append(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(i5)}));
        stringBuilder.append("\n");
        stringBuilder.append(String.format("Current NDEF message length: %d bytes", new Object[]{Integer.valueOf(a2)}));
        stringBuilder.append(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(a2)}));
        stringBuilder.append("\n");
        stringBuilder.append("Checksum: ");
        i2 = 0;
        for (i = 0; i < 14; i++) {
            i2 += this.f834C[i] & MotionEventCompat.ACTION_MASK;
        }
        if (i2 == a3) {
            stringBuilder.append("OK");
            stringBuilder.append(String.format("<hexoutput> (0x%04X)</hexoutput>", new Object[]{Integer.valueOf(a3)}));
        } else {
            stringBuilder.append("ERROR");
            stringBuilder.append(String.format("<hexoutput> (0x%04X, should be 0x%04X)</hexoutput>", new Object[]{Integer.valueOf(a3), Integer.valueOf(i2)}));
        }
        C0182c a4 = C0188i.m162a(this.f834C);
        c0198b.m219b("NDEF Attribute Block", stringBuilder.toString());
        c0198b.m217b(a4);
    }

    private void m843b(boolean z) {
        if (z) {
            this.f856z = m854n();
        }
    }

    private C0182c m844c(boolean z) {
        C0182c c0182c = new C0182c();
        if (z) {
            return m853m();
        }
        c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "<no file system present>")));
        return c0182c;
    }

    private void m845e() {
        int i = 0;
        byte[] a = m837a((int) Menu.USER_MASK);
        if (a != null) {
            a = m839a(a, (byte) 12, null);
            if (a == null || a.length <= 3 || (a[0] & MotionEventCompat.ACTION_MASK) != 13) {
                this.f840j = 1;
                if (this.f836f.getSystemCode() != null) {
                    this.f841k = new int[]{C0429j.m1388a(this.f836f.getSystemCode()[0], this.f836f.getSystemCode()[1])};
                    return;
                }
                return;
            }
            this.f840j = a[1] & MotionEventCompat.ACTION_MASK;
            this.f841k = new int[this.f840j];
            while (i < this.f840j) {
                this.f841k[i] = C0429j.m1388a(a[(i * 2) + 2], a[(i * 2) + 3]);
                i++;
            }
        }
    }

    private boolean m846f() {
        boolean z = true;
        try {
            byte[] a = m837a(65024);
            if (a == null || m840a(a, 21899, 0) == null) {
                return false;
            }
            int i;
            String format = String.format("%02X%02X-%02X%02X-%02X%02X-%02X%02X", new Object[]{Byte.valueOf(m840a(a, 21899, 0)[0]), Byte.valueOf(m840a(a, 21899, 0)[1]), Byte.valueOf(m840a(a, 21899, 0)[2]), Byte.valueOf(m840a(a, 21899, 0)[3]), Byte.valueOf(m840a(a, 21899, 0)[4]), Byte.valueOf(m840a(a, 21899, 0)[5]), Byte.valueOf(m840a(a, 21899, 0)[6]), Byte.valueOf(m840a(a, 21899, 0)[7])});
            byte[] a2 = m840a(a, 21911, 0);
            int i2 = -1;
            if (a2 != null) {
                i = 0;
                i2 = 0;
                while (i < 4) {
                    int i3 = ((a2[i] & MotionEventCompat.ACTION_MASK) << (i * 8)) + i2;
                    i++;
                    i2 = i3;
                }
            }
            i = i2;
            String str = null;
            if (m840a(a, 13771, 4) != null) {
                str = String.format("%02X%02X-%02X%02X-%02X%02X-%02X%02X-%02X%02X", new Object[]{Byte.valueOf(m840a(a, 13771, 4)[0]), Byte.valueOf(m840a(a, 13771, 4)[1]), Byte.valueOf(m840a(a, 13771, 4)[2]), Byte.valueOf(m840a(a, 13771, 4)[3]), Byte.valueOf(m840a(a, 13771, 4)[4]), Byte.valueOf(m840a(a, 13771, 4)[5]), Byte.valueOf(m840a(a, 13771, 4)[6]), Byte.valueOf(m840a(a, 13771, 4)[7]), Byte.valueOf(m840a(a, 13771, 4)[8]), Byte.valueOf(m840a(a, 13771, 4)[9])});
            }
            C0428i c0428i = new C0428i();
            if (format != null || i >= 0) {
                c0428i.m1384a((CharSequence) "nanaco card");
            }
            if (format != null) {
                c0428i.m1384a(C0358k.f1076c + "Card no: " + format);
            }
            if (i >= 0) {
                c0428i.m1384a(String.format(C0358k.f1076c + "Current value: " + "\u00a5" + "%d", new Object[]{Integer.valueOf(i)}));
            }
            if (str != null) {
                c0428i.m1384a(C0358k.f1076c + "QUICPay no: " + str);
            }
            this.f852v = c0428i.toString();
            return true;
        } catch (TagLostException e) {
            if (m855o()) {
                z = false;
            }
            this.f837g = z;
            return false;
        }
    }

    private boolean m847g() {
        try {
            byte[] a = m837a(65024);
            if (a == null || m840a(a, 4363, 0) == null) {
                return false;
            }
            int i;
            int i2;
            String format = String.format("%02X%02X %02X%02X %02X%02X %02X%02X", new Object[]{Byte.valueOf(m840a(a, 4363, 0)[2]), Byte.valueOf(m840a(a, 4363, 0)[3]), Byte.valueOf(m840a(a, 4363, 0)[4]), Byte.valueOf(m840a(a, 4363, 0)[5]), Byte.valueOf(m840a(a, 4363, 0)[6]), Byte.valueOf(m840a(a, 4363, 0)[7]), Byte.valueOf(m840a(a, 4363, 0)[8]), Byte.valueOf(m840a(a, 4363, 0)[9])});
            byte[] a2 = m840a(a, 4887, 0);
            int i3 = -1;
            if (a2 != null) {
                i = 0;
                i3 = 0;
                while (i < 4) {
                    i2 = ((a2[i] & MotionEventCompat.ACTION_MASK) << (i * 8)) + i3;
                    i++;
                    i3 = i2;
                }
            }
            i2 = i3;
            a = m841a(a, 5903, new byte[]{(byte) 0, (byte) 1, (byte) 2, (byte) 3});
            String[][] strArr = (String[][]) null;
            if (a != null) {
                strArr = (String[][]) Array.newInstance(String.class, new int[]{4, 3});
                i = 0;
                while (i < strArr.length) {
                    if (a[(i * 16) + 10] != null || a[(i * 16) + 11] != null) {
                        new GregorianCalendar(2000, 0, 1).add(5, (((a[(i * 16) + 4] & MotionEventCompat.ACTION_MASK) << 8) + (a[(i * 16) + 5] & MotionEventCompat.ACTION_MASK)) >> 1);
                        strArr[i][0] = String.format("%d/%02d/%02d", new Object[]{Integer.valueOf(r8.get(1)), Integer.valueOf(r8.get(2) + 1), Integer.valueOf(r8.get(5))});
                        strArr[i][2] = Integer.valueOf(((a[(i * 16) + 14] & MotionEventCompat.ACTION_MASK) << 8) + (a[(i * 16) + 15] & MotionEventCompat.ACTION_MASK)).toString();
                        strArr[i][1] = Integer.valueOf(((a[(i * 16) + 10] & MotionEventCompat.ACTION_MASK) << 8) + (a[(i * 16) + 11] & MotionEventCompat.ACTION_MASK)).toString();
                        if (a[i] == 32) {
                            strArr[i][1] = "-" + strArr[i][1];
                        }
                    } else if (i == 0) {
                    }
                    i++;
                }
            }
            String[][] strArr2 = strArr;
            C0428i c0428i = new C0428i();
            if (format == null && i2 < 0 && strArr2 == null) {
                return false;
            }
            c0428i.m1387b("Edy card\n");
            if (format != null) {
                c0428i.m1384a(C0358k.f1076c + "Card no: " + format);
            }
            if (i2 >= 0) {
                c0428i.m1384a(String.format(C0358k.f1076c + "Current value: " + "\u00a5" + "%d", new Object[]{Integer.valueOf(i2)}));
            }
            if (strArr2 != null) {
                for (CharSequence[] charSequenceArr : strArr2) {
                    if (!(TextUtils.isEmpty(charSequenceArr[0]) || TextUtils.isEmpty(charSequenceArr[1]) || TextUtils.isEmpty(charSequenceArr[2]))) {
                        c0428i.m1384a(String.format(C0358k.f1076c + "%s: %s, value: " + "\u00a5" + "%s", new Object[]{charSequenceArr[0], charSequenceArr[1], charSequenceArr[2]}));
                    }
                }
            }
            this.f850t = c0428i.toString();
            return true;
        } catch (TagLostException e) {
            this.f837g = !m855o();
            return false;
        }
    }

    private boolean m848h() {
        byte[] a;
        int i;
        long a2;
        boolean z = true;
        C0428i c0428i = new C0428i();
        try {
            a = m837a(32776);
            if (a != null) {
                try {
                    c0428i.m1384a((CharSequence) "Octopus public transport card");
                    i = 279;
                } catch (TagLostException e) {
                    this.f837g = m855o();
                    if (!this.f837g) {
                        try {
                            a = m837a(32773);
                            if (a != null) {
                                c0428i.m1384a((CharSequence) "Shenzhen Tong public transport card");
                                i = 280;
                                if (a != null) {
                                    if (m840a(a, i, 0) != null) {
                                        return false;
                                    }
                                    a2 = C0429j.m1390a(m840a(a, i, 0)[0], m840a(a, i, 0)[1], m840a(a, i, 0)[2], m840a(a, i, 0)[3]) - 350;
                                    c0428i.m1384a(C0358k.f1076c + String.format(Locale.US, "Current value: HK$%01.1f", new Object[]{Double.valueOf(((double) a2) / 10.0d)}));
                                }
                                this.f854x = c0428i.toString();
                                return true;
                            }
                        } catch (TagLostException e2) {
                            if (m855o()) {
                                z = false;
                            }
                            this.f837g = z;
                            return false;
                        }
                    }
                    i = 0;
                    if (a != null) {
                        if (m840a(a, i, 0) != null) {
                            return false;
                        }
                        a2 = C0429j.m1390a(m840a(a, i, 0)[0], m840a(a, i, 0)[1], m840a(a, i, 0)[2], m840a(a, i, 0)[3]) - 350;
                        c0428i.m1384a(C0358k.f1076c + String.format(Locale.US, "Current value: HK$%01.1f", new Object[]{Double.valueOf(((double) a2) / 10.0d)}));
                    }
                    this.f854x = c0428i.toString();
                    return true;
                }
                if (a != null) {
                    if (m840a(a, i, 0) != null) {
                        return false;
                    }
                    a2 = C0429j.m1390a(m840a(a, i, 0)[0], m840a(a, i, 0)[1], m840a(a, i, 0)[2], m840a(a, i, 0)[3]) - 350;
                    c0428i.m1384a(C0358k.f1076c + String.format(Locale.US, "Current value: HK$%01.1f", new Object[]{Double.valueOf(((double) a2) / 10.0d)}));
                }
                this.f854x = c0428i.toString();
                return true;
            }
        } catch (TagLostException e3) {
            a = null;
            if (m855o()) {
            }
            this.f837g = m855o();
            if (this.f837g) {
                a = m837a(32773);
                if (a != null) {
                    c0428i.m1384a((CharSequence) "Shenzhen Tong public transport card");
                    i = 280;
                    if (a != null) {
                        if (m840a(a, i, 0) != null) {
                            return false;
                        }
                        a2 = C0429j.m1390a(m840a(a, i, 0)[0], m840a(a, i, 0)[1], m840a(a, i, 0)[2], m840a(a, i, 0)[3]) - 350;
                        c0428i.m1384a(C0358k.f1076c + String.format(Locale.US, "Current value: HK$%01.1f", new Object[]{Double.valueOf(((double) a2) / 10.0d)}));
                    }
                    this.f854x = c0428i.toString();
                    return true;
                }
            }
            i = 0;
            if (a != null) {
                if (m840a(a, i, 0) != null) {
                    return false;
                }
                a2 = C0429j.m1390a(m840a(a, i, 0)[0], m840a(a, i, 0)[1], m840a(a, i, 0)[2], m840a(a, i, 0)[3]) - 350;
                c0428i.m1384a(C0358k.f1076c + String.format(Locale.US, "Current value: HK$%01.1f", new Object[]{Double.valueOf(((double) a2) / 10.0d)}));
            }
            this.f854x = c0428i.toString();
            return true;
        }
        i = 0;
        if (a != null) {
            if (m840a(a, i, 0) != null) {
                return false;
            }
            a2 = C0429j.m1390a(m840a(a, i, 0)[0], m840a(a, i, 0)[1], m840a(a, i, 0)[2], m840a(a, i, 0)[3]) - 350;
            c0428i.m1384a(C0358k.f1076c + String.format(Locale.US, "Current value: HK$%01.1f", new Object[]{Double.valueOf(((double) a2) / 10.0d)}));
        }
        this.f854x = c0428i.toString();
        return true;
    }

    private boolean m849i() {
        boolean z = true;
        C0428i c0428i = new C0428i();
        try {
            byte[] a = m837a(3);
            if (a == null) {
                return false;
            }
            c0428i.m1384a((CharSequence) "Super Urban Intelligent Card (Suica)");
            byte[] bArr = new byte[]{(byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9};
            for (int i = 0; i < 2; i++) {
                byte[] a2 = m841a(a, 2319, bArr);
                if (a2 != null) {
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        byte b = a2[(i2 * 16) + 4];
                        byte b2 = a2[(i2 * 16) + 5];
                        if (b != null || b2 != null) {
                            c0428i.m1387b(String.format(C0358k.f1076c + "Transaction %02d/%02d/%02d, ", new Object[]{Integer.valueOf(((b >> 1) & TransportMediator.KEYCODE_MEDIA_PAUSE) + 2000), Integer.valueOf(((b & 1) << 3) + ((b2 >> 5) & 7)), Integer.valueOf(b2 & 31)}));
                            c0428i.m1384a(String.format("value: \u00a5%d", new Object[]{Integer.valueOf(C0429j.m1388a(a2[(i2 * 16) + 11], a2[(i2 * 16) + 10]))}));
                        }
                    }
                }
                bArr = new byte[]{(byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19};
            }
            this.f848r = c0428i.toString();
            return true;
        } catch (TagLostException e) {
            if (m855o()) {
                z = false;
            }
            this.f837g = z;
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.nxp.taginfolite.p005b.C0182c m850j() {
        /*
        r18 = this;
        r6 = new com.nxp.taginfolite.b.c;
        r6.<init>();
        r0 = r18;
        r1 = r0.f840j;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        if (r1 > 0) goto L_0x0016;
    L_0x000b:
        r0 = r18;
        r1 = r0.f846p;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        if (r1 == 0) goto L_0x0016;
    L_0x0011:
        r1 = r18.m853m();	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
    L_0x0015:
        return r1;
    L_0x0016:
        r1 = 0;
        r9 = r1;
    L_0x0018:
        r0 = r18;
        r1 = r0.f840j;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        if (r9 >= r1) goto L_0x00f1;
    L_0x001e:
        r7 = new java.lang.StringBuilder;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = "";
        r7.<init>(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = "System Code 0x%04X";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r3 = 0;
        r0 = r18;
        r4 = r0.f841k;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r4 = r4[r9];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r2[r3] = r4;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = java.lang.String.format(r1, r2);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r7.append(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = f827a;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r0 = r18;
        r2 = r0.f841k;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r2 = r2[r9];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = r1.get(r2);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = (java.lang.String) r1;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        if (r1 == 0) goto L_0x005a;
    L_0x004e:
        r2 = ": ";
        r7.append(r2);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = com.nxp.taginfolite.p003g.C0429j.m1391a(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r7.append(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
    L_0x005a:
        r1 = "\n";
        r7.append(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r0 = r18;
        r1 = r0.f841k;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = r1[r9];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r0 = r18;
        r10 = r0.m837a(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = com.nxp.taginfolite.p004f.C0358k.f1076c;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = r7.append(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r2 = "IDm: ";
        r1.append(r2);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = "";
        r2 = ":";
        r1 = com.nxp.taginfolite.p003g.C0429j.m1393a(r10, r1, r2);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r7.append(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = "\n";
        r7.append(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r3 = 0;
        r2 = 0;
        r5 = 0;
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r11 = new int[r1];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = 60;
        r12 = new int[r1];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = 60;
        r13 = new int[r1];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r4 = 0;
    L_0x0096:
        if (r10 == 0) goto L_0x0129;
    L_0x0098:
        if (r4 != 0) goto L_0x0129;
    L_0x009a:
        r1 = 0;
        r8 = 10;
        r14 = 2;
        r14 = new byte[r14];	 Catch:{ TagLostException -> 0x00d0, IOException -> 0x0260 }
        r15 = 0;
        r0 = r5 & 255;
        r16 = r0;
        r0 = r16;
        r0 = (byte) r0;	 Catch:{ TagLostException -> 0x00d0, IOException -> 0x0260 }
        r16 = r0;
        r14[r15] = r16;	 Catch:{ TagLostException -> 0x00d0, IOException -> 0x0260 }
        r15 = 1;
        r16 = r5 >>> 8;
        r0 = r16;
        r0 = (byte) r0;	 Catch:{ TagLostException -> 0x00d0, IOException -> 0x0260 }
        r16 = r0;
        r14[r15] = r16;	 Catch:{ TagLostException -> 0x00d0, IOException -> 0x0260 }
        r0 = r18;
        r1 = r0.m839a(r10, r8, r14);	 Catch:{ TagLostException -> 0x00d0, IOException -> 0x0260 }
    L_0x00bc:
        if (r1 == 0) goto L_0x00c7;
    L_0x00be:
        r8 = 1;
        r8 = r1[r8];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r8 = r8 & 255;
        r14 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r8 != r14) goto L_0x00f6;
    L_0x00c7:
        r1 = 1;
        r4 = r3;
        r3 = r2;
        r2 = r5;
    L_0x00cb:
        r5 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r1;
        goto L_0x0096;
    L_0x00d0:
        r8 = move-exception;
        r8 = r18.m855o();	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        if (r8 != 0) goto L_0x00f4;
    L_0x00d7:
        r8 = 1;
    L_0x00d8:
        r0 = r18;
        r0.f837g = r8;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        goto L_0x00bc;
    L_0x00dd:
        r1 = move-exception;
        r1 = new com.nxp.taginfolite.b.n;
        r2 = "<aborted: tag disappeared>";
        r2 = com.nxp.taginfolite.p003g.C0429j.m1391a(r2);
        r1.<init>(r2);
        r6.m147a(r1);
        r1 = 1;
        r0 = r18;
        r0.f837g = r1;
    L_0x00f1:
        r1 = r6;
        goto L_0x0015;
    L_0x00f4:
        r8 = 0;
        goto L_0x00d8;
    L_0x00f6:
        r8 = 2;
        r8 = r1[r8];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r14 = 1;
        r14 = r1[r14];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r8 = com.nxp.taginfolite.p003g.C0429j.m1388a(r8, r14);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r14 = r8 & 62;
        if (r14 == 0) goto L_0x0113;
    L_0x0104:
        r11[r2] = r8;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = r2 + 1;
        r2 = r3;
    L_0x0109:
        r3 = r5 + 1;
        r17 = r4;
        r4 = r2;
        r2 = r3;
        r3 = r1;
        r1 = r17;
        goto L_0x00cb;
    L_0x0113:
        r12[r3] = r8;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r8 = 4;
        r8 = r1[r8];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r14 = 3;
        r1 = r1[r14];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = com.nxp.taginfolite.p003g.C0429j.m1388a(r8, r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r13[r3] = r1;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = r3 + 1;
        r17 = r2;
        r2 = r1;
        r1 = r17;
        goto L_0x0109;
    L_0x0129:
        r1 = 0;
    L_0x012a:
        if (r1 >= r3) goto L_0x0167;
    L_0x012c:
        r4 = new java.lang.StringBuilder;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r4.<init>();	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r5 = com.nxp.taginfolite.p004f.C0358k.f1077d;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r4 = r4.append(r5);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r5 = "Area #%d: 0x%04X - 0x%04X\n";
        r4 = r4.append(r5);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r4 = r4.toString();	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r8 = 0;
        r14 = java.lang.Integer.valueOf(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r5[r8] = r14;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r8 = 1;
        r14 = r12[r1];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r5[r8] = r14;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r8 = 2;
        r14 = r13[r1];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r5[r8] = r14;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r4 = java.lang.String.format(r4, r5);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r7.append(r4);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = r1 + 1;
        goto L_0x012a;
    L_0x0167:
        r1 = 0;
        r5 = r1;
        r4 = r7;
    L_0x016a:
        if (r5 >= r2) goto L_0x029e;
    L_0x016c:
        r7 = r11[r5];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        if (r5 <= 0) goto L_0x02b6;
    L_0x0173:
        r1 = r5 + -1;
        r1 = r11[r1];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r3 = r1;
    L_0x0178:
        r1 = "  \u2022 ";
        r4.append(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = "Service: 0x%04X #%03d";
        r8 = 2;
        r8 = new java.lang.Object[r8];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r12 = 0;
        r13 = java.lang.Integer.valueOf(r7);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r8[r12] = r13;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r12 = 1;
        r13 = r7 >>> 6;
        r13 = java.lang.Integer.valueOf(r13);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r8[r12] = r13;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = java.lang.String.format(r1, r8);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r4.append(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r8 = "%s\n";
        r1 = 1;
        r12 = new java.lang.Object[r1];	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r13 = 0;
        r1 = f829c;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r14 = r7 >> 1;
        r14 = r14 & 15;
        r1 = r1.get(r14);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = (java.lang.CharSequence) r1;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = com.nxp.taginfolite.p003g.C0429j.m1391a(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r12[r13] = r1;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = java.lang.String.format(r8, r12);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r4.append(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = f828b;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = r1.get(r7);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = (java.lang.String) r1;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        if (r1 == 0) goto L_0x01d3;
    L_0x01c2:
        r8 = "    ~ ";
        r4.append(r8);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = com.nxp.taginfolite.p003g.C0429j.m1391a(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r4.append(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = "\n";
        r4.append(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
    L_0x01d3:
        r1 = r7 & 1;
        if (r1 != 0) goto L_0x01f5;
    L_0x01d7:
        r1 = "    ~ Protected (no access)";
        r4.append(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = new com.nxp.taginfolite.b.o;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r3 = r4.toString();	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1.<init>(r3);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r6.m147a(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = new java.lang.StringBuilder;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r3 = "";
        r1.<init>(r3);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
    L_0x01ef:
        r3 = r5 + 1;
        r5 = r3;
        r4 = r1;
        goto L_0x016a;
    L_0x01f5:
        r1 = r7 & 63;
        r8 = r3 & 63;
        r12 = r3 & 1;
        if (r12 == 0) goto L_0x0271;
    L_0x01fd:
        r12 = 65472; // 0xffc0 float:9.1746E-41 double:3.23475E-319;
        r12 = r12 & r7;
        r13 = 65472; // 0xffc0 float:9.1746E-41 double:3.23475E-319;
        r3 = r3 & r13;
        if (r12 != r3) goto L_0x0271;
    L_0x0207:
        r3 = 9;
        if (r1 != r3) goto L_0x020f;
    L_0x020b:
        r3 = 11;
        if (r8 == r3) goto L_0x0247;
    L_0x020f:
        r3 = 11;
        if (r1 != r3) goto L_0x0217;
    L_0x0213:
        r3 = 9;
        if (r8 == r3) goto L_0x0247;
    L_0x0217:
        r3 = 13;
        if (r1 != r3) goto L_0x021f;
    L_0x021b:
        r3 = 15;
        if (r8 == r3) goto L_0x0247;
    L_0x021f:
        r3 = 15;
        if (r1 != r3) goto L_0x0227;
    L_0x0223:
        r3 = 13;
        if (r8 == r3) goto L_0x0247;
    L_0x0227:
        r3 = 17;
        if (r1 != r3) goto L_0x022f;
    L_0x022b:
        r3 = 19;
        if (r8 == r3) goto L_0x0247;
    L_0x022f:
        r3 = 19;
        if (r1 != r3) goto L_0x0237;
    L_0x0233:
        r3 = 17;
        if (r8 == r3) goto L_0x0247;
    L_0x0237:
        r3 = 17;
        if (r1 != r3) goto L_0x023f;
    L_0x023b:
        r3 = 23;
        if (r8 == r3) goto L_0x0247;
    L_0x023f:
        r3 = 23;
        if (r1 != r3) goto L_0x0271;
    L_0x0243:
        r1 = 17;
        if (r8 != r1) goto L_0x0271;
    L_0x0247:
        r1 = "    ~ (Identical to preceding service)";
        r4.append(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = new com.nxp.taginfolite.b.o;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r3 = r4.toString();	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1.<init>(r3);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r6.m147a(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = new java.lang.StringBuilder;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r3 = "";
        r1.<init>(r3);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        goto L_0x01ef;
    L_0x0260:
        r1 = move-exception;
        r1 = new com.nxp.taginfolite.b.n;
        r2 = "<aborted: read error>";
        r2 = com.nxp.taginfolite.p003g.C0429j.m1391a(r2);
        r1.<init>(r2);
        r6.m147a(r1);
        goto L_0x00f1;
    L_0x0271:
        r1 = new com.nxp.taginfolite.b.o;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r3 = r4.toString();	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1.<init>(r3);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r6.m147a(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = new java.lang.StringBuilder;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r3 = "";
        r1.<init>(r3);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r4 = 0;
        r0 = r18;
        r3 = r0.m840a(r10, r7, r4);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
    L_0x028b:
        if (r3 == 0) goto L_0x01ef;
    L_0x028d:
        r8 = new com.nxp.taginfolite.b.f;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r8.<init>(r4, r3);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r6.m147a(r8);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r4 = r4 + 1;
        r0 = r18;
        r3 = r0.m840a(r10, r7, r4);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        goto L_0x028b;
    L_0x029e:
        if (r2 != 0) goto L_0x02b1;
    L_0x02a0:
        r1 = "  \u2022 (No services)";
        r4.append(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1 = new com.nxp.taginfolite.b.o;	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r2 = r4.toString();	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r1.<init>(r2);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
        r6.m147a(r1);	 Catch:{ TagLostException -> 0x00dd, IOException -> 0x0260 }
    L_0x02b1:
        r1 = r9 + 1;
        r9 = r1;
        goto L_0x0018;
    L_0x02b6:
        r3 = r1;
        goto L_0x0178;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.e.h.j():com.nxp.taginfolite.b.c");
    }

    private boolean m851k() {
        byte[] a = m840a(this.f838h, 11, 136);
        return a[0] == null && (a[1] & TransportMediator.KEYCODE_MEDIA_PAUSE) == 0;
    }

    private C0182c m852l() {
        C0182c c0182c = new C0182c();
        Object obj = (this.f839i[1] & MotionEventCompat.ACTION_MASK) == 241 ? 1 : null;
        try {
            byte[] a;
            int i;
            boolean z;
            boolean z2;
            byte[] a2 = m840a(this.f838h, 11, 136);
            int i2 = 0;
            while (i2 < 15) {
                String a3;
                a = m840a(this.f838h, 11, i2);
                int i3 = 1 << (i2 % 8);
                i = a2[i2 < 8 ? 0 : 1] & i3;
                if (obj != null) {
                    a3 = m833a(i != 0, (a2[i2 < 8 ? 6 : 7] & i3) != 0, (a2[i2 < 8 ? 8 : 9] & i3) != 0, (a2[i2 < 8 ? 10 : 11] & i3) != 0);
                } else {
                    a3 = m833a(i != 0, false, false, false);
                }
                c0182c.m147a(new C0187g(i2, a3, a));
                i2++;
            }
            String[] strArr = new String[]{"(RC)", "(MAC)", "(ID)", "(D_ID)", "(SER_C)", "(SYS_C)", "(CKV)", "(CK)"};
            int[] iArr = new int[]{16, 8, 16, 16, 2, 2, 2, 16, 13};
            for (i = AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS; i < 136; i++) {
                int i4 = i - 128;
                byte[] a4 = m840a(this.f838h, 11, i);
                z = false;
                switch (i) {
                    case AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS /*128*/:
                        z2 = false;
                        break;
                    case 134:
                    case 135:
                        z = (obj == null || (a2[5] & 1) == 0) ? false : true;
                        z2 = z;
                        break;
                    default:
                        z2 = true;
                        break;
                }
                boolean z3 = z2;
                z2 = (a2[2] & MotionEventCompat.ACTION_MASK) == MotionEventCompat.ACTION_MASK;
                z = z3;
                c0182c.m147a(new C0187g(i, m833a(z2, false, false, z), a4 == null ? null : Arrays.copyOfRange(a4, 0, iArr[i4]), strArr[i4]));
            }
            c0182c.m147a(new C0187g(136, ((a2[1] & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) == 0 ? "*" : ".") + ((a2[2] & MotionEventCompat.ACTION_MASK) == MotionEventCompat.ACTION_MASK ? "." : "*"), Arrays.copyOfRange(a2, 0, obj != null ? 13 : 5), "(MC)"));
            if (obj != null) {
                strArr = new String[]{"(WCNT)", "(MAC_A)", "(STATE)"};
                iArr = new int[]{3, 8, 2};
                i = 144;
                while (i < 147) {
                    a = m840a(this.f838h, 11, i);
                    int i5 = i - 144;
                    z2 = i == 144;
                    z = i == 146 && (a2[12] & 1) != 0;
                    c0182c.m147a(new C0187g(i, m833a(z2, false, false, z), a == null ? null : Arrays.copyOfRange(a, 0, iArr[i5]), strArr[i5]));
                    i++;
                }
                c0182c.m147a(new C0187g(160, "*", m840a(this.f838h, 11, 160) == null ? null : new byte[]{m840a(this.f838h, 11, 160)[0]}, "(CRC_CHECK)"));
            }
        } catch (TagLostException e) {
            this.f837g = true;
            c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "<aborted: tag disappeared>")));
        }
        c0182c.m147a(new C0194n("\n .:unlocked, *:locked"));
        if (obj != null) {
            c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) " r/R:readable (write-protected),\n w/W:writeable,\n p/P:read+write protected,\n R/W/P/m:write with MAC")));
        }
        return c0182c;
    }

    private C0182c m853m() {
        C0182c c0182c = new C0182c();
        int i = 0;
        try {
            byte[] a = m840a(this.f838h, 11, 0);
            while (a != null) {
                c0182c.m147a(new C0186f(i, a));
                i++;
                a = m840a(this.f838h, 11, i);
            }
        } catch (TagLostException e) {
            this.f837g = true;
            c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "<aborted: tag disappeared>")));
        }
        return c0182c;
    }

    private C0182c m854n() {
        int i = 0;
        C0182c c0182c = new C0182c();
        while (i < 32) {
            try {
                c0182c.m147a(new C0186f(i, 2, m840a(this.f838h, 0, i)));
                i++;
            } catch (IOException e) {
                c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "<aborted: read error>")));
                this.f837g = true;
            }
        }
        return c0182c;
    }

    private boolean m855o() {
        try {
            this.f836f.close();
            this.f836f.connect();
            byte[] a = m837a((int) Menu.USER_MASK);
            return a != null && Arrays.equals(a, this.f838h);
        } catch (TagLostException e) {
            return false;
        } catch (IOException e2) {
            return true;
        }
    }

    private String m856p() {
        C0428i c0428i = new C0428i();
        C0428i c0428i2 = new C0428i();
        int i = 0;
        for (int i2 = 0; i2 < this.f840j; i2++) {
            CharSequence charSequence = (String) f827a.get(Menu.USER_MASK & this.f841k[i2]);
            if (charSequence != null) {
                i++;
                c0428i.m1387b(C0429j.m1391a(charSequence));
                c0428i.m1384a(String.format("<hexoutput> (0x%04X)</hexoutput>", new Object[]{Integer.valueOf(r6)}));
            } else {
                c0428i2.m1384a(String.format("Unknown System Code 0x%04X", new Object[]{Integer.valueOf(r6)}));
            }
        }
        if (i < this.f840j) {
            String str = "%s%d unknown System Code%s present";
            Object[] objArr = new Object[3];
            objArr[0] = i == 0 ? BuildConfig.VERSION_NAME : "and ";
            objArr[1] = Integer.valueOf(this.f840j - i);
            objArr[2] = this.f840j - i == 1 ? BuildConfig.VERSION_NAME : "s";
            c0428i.m1387b(String.format(str, objArr));
            c0428i.m1384a("<hexoutput>:\n" + c0428i2.toString() + "</hexoutput>");
        } else if (this.f840j == 0 && this.f832A != null && this.f832A.length == 2) {
            c0428i.m1387b("1 unknown System Code%s present");
            c0428i.m1384a("<hexoutput>:\nUnknown System Code " + C0429j.m1409e(this.f832A) + "</hexoutput>");
        }
        return c0428i.toString();
    }

    private boolean m857q() {
        return f830d.get(this.f839i[1] & MotionEventCompat.ACTION_MASK) != null;
    }

    public void m858a(C0197a c0197a, boolean z) {
        CharSequence charSequence = (String) f831e.get(this.f839i[1] & MotionEventCompat.ACTION_MASK);
        if (this.f835D) {
            c0197a.m197b("Memory information", C0429j.m1391a(charSequence + (charSequence + "\nMemory is locked")));
            return;
        }
        c0197a.m193a(C0429j.m1391a(charSequence));
        c0197a.m203e("System Codes", m856p());
    }

    public void m859a(C0198b c0198b, boolean z) {
        if (this.f834C != null) {
            m842b(c0198b, z);
        }
    }

    public void m860a(C0199c c0199c, boolean z) {
        CharSequence d = m865d();
        if (m857q()) {
            c0199c.m230d("Sony Corporation");
        } else {
            c0199c.m230d("Unknown manufacturer");
        }
        c0199c.m231e(d);
        switch (this.f839i[1] & MotionEventCompat.ACTION_MASK) {
            case C0519c.Switch_track /*1*/:
            case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
            case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
            case C0086R.styleable.SherlockTheme_actionModeStyle /*12*/:
            case C0086R.styleable.SherlockTheme_actionModeCloseButtonStyle /*13*/:
            case C0086R.styleable.SherlockTheme_searchViewCloseIcon /*32*/:
                c0199c.m233g("FeliCa OS");
                break;
            case 225:
                c0199c.m228b("Operation mode", "FeliCa Plug mode");
                break;
            case 242:
                c0199c.m228b("Operation mode", "FeliCa Lite-S (HT) mode");
                break;
        }
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        if (this.f847q && !TextUtils.isEmpty(this.f848r)) {
            stringBuilder.append(this.f848r);
        }
        if (this.f849s && !TextUtils.isEmpty(this.f850t)) {
            stringBuilder.append(this.f850t);
        }
        if (this.f851u && !TextUtils.isEmpty(this.f852v)) {
            stringBuilder.append(this.f852v);
        }
        if (this.f853w && !TextUtils.isEmpty(this.f854x)) {
            stringBuilder.append(this.f854x);
        }
        if (this.f843m && !TextUtils.isEmpty(this.f855y)) {
            stringBuilder.append(this.f855y);
        }
        c0199c.m227b(stringBuilder.toString());
    }

    public void m861a(C0200d c0200d, boolean z) {
        boolean z2 = true;
        C0428i c0428i = new C0428i();
        c0428i.m1384a((CharSequence) "JIS X 6319-4 compatible");
        if (this.f845o == null && this.f838h[0] == (byte) 1 && this.f838h[1] == (byte) -2) {
            c0428i.m1384a((CharSequence) "ISO/IEC 18092 compatible");
        }
        c0200d.m238a(c0428i.toString());
        C0428i c0428i2 = new C0428i();
        c0428i2.m1384a(C0369v.m1094a(this.f838h, C0360m.FELICA));
        if (this.f845o != null) {
            c0428i2.m1384a(String.format(C0358k.f1076c + "Data Format Code: 0x%02X%02X", new Object[]{Byte.valueOf(this.f845o[0]), Byte.valueOf(this.f845o[1])}));
        } else if (this.f838h[0] == (byte) 1 && this.f838h[1] == (byte) -2) {
            c0428i2.m1384a(C0358k.f1076c + "Device compatible with NFCIP-1");
        } else if (this.f838h[0] == (byte) 2 && this.f838h[1] == (byte) -2) {
            c0428i2.m1384a(C0358k.f1076c + "Random ID");
        } else if (this.f838h[1] != (byte) -2) {
            c0428i2.m1384a(String.format(C0358k.f1076c + "Manufacturer code: 0x%02X%02X", new Object[]{Byte.valueOf(this.f838h[1]), Byte.valueOf(this.f838h[0])}));
        }
        c0428i2.m1384a("PMm: " + C0429j.m1409e(this.f839i));
        c0428i2.m1384a(String.format(C0358k.f1076c + "IC code: 0x%02X%02X", new Object[]{Byte.valueOf(this.f839i[0]), Byte.valueOf(this.f839i[1])}));
        c0428i2.m1384a(String.format("\t\u2022 ROM type: 0x%02X", new Object[]{Byte.valueOf(this.f839i[0])}));
        c0428i2.m1384a(String.format("\t\u2022 IC type: 0x%02X", new Object[]{Byte.valueOf(this.f839i[1])}));
        c0428i2.m1384a(C0358k.f1076c + "Max. command response times:");
        boolean z3 = this.f842l || this.f843m || this.f844n;
        if (!z3) {
            c0428i2.m1384a("\t\u2022 Req. Service: " + C0309h.m832a(this.f839i[2], true));
            c0428i2.m1384a("\t\u2022 Req. Response: " + C0309h.m832a(this.f839i[3], false));
            c0428i2.m1384a("\t\u2022 Authenticate: " + C0309h.m832a(this.f839i[4], true));
        }
        c0428i2.m1384a("\t\u2022 Read/Check: " + C0309h.m832a(this.f839i[5], true));
        c0428i2.m1384a("\t\u2022 Write/Update: " + C0309h.m832a(this.f839i[6], true));
        if (!z3) {
            c0428i2.m1384a("\t\u2022 Issuance command: " + C0309h.m832a(this.f839i[7], false));
        }
        c0428i2.m1384a((CharSequence) "  ('n': no. of blocks/services)");
        c0428i2.m1383a();
        byte[] bArr = this.f832A;
        if (bArr == null || bArr.length == 0) {
            c0428i2.m1384a((CharSequence) "Primary System Code: [none]");
        } else {
            c0428i2.m1384a("Primary System Code: " + C0429j.m1409e(bArr));
        }
        if (this.f833B != null) {
            c0428i2.m1384a((CharSequence) "Advanced Protocol Features:");
            if ((this.f833B & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0) {
                c0428i2.m1384a(C0358k.f1076c + "Automatically selectable bit rates");
            }
            if ((this.f833B & 15) != 0) {
                c0428i2.m1387b(C0358k.f1076c + "Supported communication rates:\n");
                c0428i2.m1387b("\t\u2022 ");
                StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
                if ((this.f833B & 1) != 0) {
                    c0428i2.m1387b("212");
                    stringBuilder.append("2");
                } else {
                    z2 = false;
                }
                if ((this.f833B & 2) != 0) {
                    if (z2) {
                        c0428i2.m1387b(", ");
                        stringBuilder.append(", ");
                    }
                    c0428i2.m1387b("424");
                    stringBuilder.append("4");
                }
                if ((this.f833B & 4) != 0) {
                    if (z2) {
                        c0428i2.m1387b(", ");
                        stringBuilder.append(", ");
                    }
                    c0428i2.m1387b("848");
                    stringBuilder.append("8");
                }
                c0428i2.m1387b("\u200akbit/s");
                if ((this.f833B & 8) != 0) {
                    if (z2) {
                        c0428i2.m1387b(", ");
                        stringBuilder.append(", ");
                    }
                    c0428i2.m1387b("1.6\u200aMbit/s");
                    stringBuilder.append("16");
                }
                c0428i2.m1387b(" (divisors: " + stringBuilder.toString() + ")\n");
                c0428i2.m1383a();
            }
        } else {
            c0428i2.m1384a((CharSequence) "No Advanced Protocol Features supported");
            c0428i2.m1384a(C0358k.f1076c + "Supported communication rate: 212" + "\u200a" + "kbit/s");
        }
        c0200d.m242c(c0428i2.toString());
        if (this.f856z != null) {
            c0200d.m237a(this.f856z);
        }
    }

    public boolean m862a() {
        return false;
    }

    public boolean m863b() {
        return this.f837g;
    }

    public byte[] m864c() {
        return this.f838h;
    }

    public String m865d() {
        String str = (String) f830d.get(this.f839i[1] & MotionEventCompat.ACTION_MASK);
        return str == null ? this.f842l ? "FeliCa Lite" : "FeliCa" : str;
    }
}
