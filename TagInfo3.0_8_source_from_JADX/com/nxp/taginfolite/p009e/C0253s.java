package com.nxp.taginfolite.p009e;

import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.support.v4.BuildConfig;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0351d;
import com.nxp.taginfolite.p004f.C0355h;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.C0360m;
import com.nxp.taginfolite.p004f.C0362o;
import com.nxp.taginfolite.p004f.C0369v;
import com.nxp.taginfolite.p004f.C0372z;
import com.nxp.taginfolite.p005b.C0182c;
import com.nxp.taginfolite.p005b.C0183d;
import com.nxp.taginfolite.p005b.C0184h;
import com.nxp.taginfolite.p005b.C0193o;
import com.nxp.taginfolite.p005b.C0194n;
import com.nxp.taginfolite.p005b.C0195p;
import com.nxp.taginfolite.p006c.C0197a;
import com.nxp.taginfolite.p006c.C0198b;
import com.nxp.taginfolite.p006c.C0199c;
import com.nxp.taginfolite.p006c.C0200d;
import com.nxp.taginfolite.p009e.p014e.C0303k;
import java.io.IOException;
import java.util.Arrays;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.s */
public class C0253s implements ay {
    private static byte[] f520s;
    public byte[] f521a;
    public byte[] f522b;
    protected NfcA f523c;
    protected Tag f524d;
    protected Boolean f525e;
    protected C0182c f526f;
    protected String f527g;
    protected byte[] f528h;
    protected C0182c f529i;
    protected C0158a f530j;
    private C0360m f531k;
    private NfcB f532l;
    private boolean f533m;
    private boolean f534n;
    private as f535o;
    private boolean f536p;
    private C0323v f537q;
    private C0322u f538r;
    private byte[] f539t;
    private boolean f540u;

    static {
        f520s = null;
    }

    public C0253s() {
        this.f531k = null;
        this.f532l = null;
        this.f533m = false;
        this.f534n = false;
        this.f535o = null;
        this.f536p = false;
        this.f521a = null;
        this.f522b = null;
        this.f523c = null;
        this.f524d = null;
        this.f525e = Boolean.valueOf(false);
        this.f537q = C0323v.UNKNOWN;
        this.f538r = C0322u.UNKNOWN;
        this.f526f = null;
        this.f527g = null;
        this.f539t = null;
        this.f528h = null;
        this.f529i = null;
        this.f540u = false;
        this.f530j = null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public static com.nxp.taginfolite.p009e.C0253s m520a(android.nfc.Tag r9, com.nxp.taginfolite.p004f.C0360m r10, boolean r11, com.nxp.taginfolite.C0158a r12, boolean r13) {
        /*
        r4 = new com.nxp.taginfolite.e.s;
        r4.<init>();
        r4.f524d = r9;
        r4.f531k = r10;
        r4.f534n = r13;
        r0 = java.lang.Boolean.valueOf(r11);
        r4.f525e = r0;
        r4.f530j = r12;
        r5 = r9.getId();
        r0 = com.nxp.taginfolite.p004f.C0360m.ISO14443_A;
        if (r10 != r0) goto L_0x01d2;
    L_0x001b:
        r0 = android.nfc.tech.NfcA.get(r9);
        r4.f523c = r0;
    L_0x0021:
        r0 = r4.f523c;
        r1 = r0.getSak();
        r0 = r4.f523c;
        r2 = r0.getAtqa();
        r0 = com.nxp.taginfolite.p004f.C0360m.ISO14443_A;
        if (r10 != r0) goto L_0x01d1;
    L_0x0031:
        r0 = r4.f523c;
        r0 = com.nxp.taginfolite.p009e.ag.m456a(r0);
        if (r0 == 0) goto L_0x0065;
    L_0x0039:
        r0 = r4.f523c;
        r0 = com.nxp.taginfolite.p009e.ag.m464c(r0);
        r4.f535o = r0;
        r0 = r4.f535o;
        r0 = r0.f480b;
        r3 = com.nxp.taginfolite.p009e.au.Mini;
        if (r0 != r3) goto L_0x004f;
    L_0x0049:
        r0 = r4.f535o;
        r3 = com.nxp.taginfolite.p009e.au.Mini_32B;
        r0.f480b = r3;
    L_0x004f:
        r4.f540u = r11;
        r0 = r4.f535o;
        r3 = r4.f523c;
        r3 = r3.getSak();
        r6 = r4.f524d;
        r6 = r6.getId();
        r0 = com.nxp.taginfolite.p009e.p010a.C0243a.m379a(r0, r3, r6);
        r4.f536p = r0;
    L_0x0065:
        r0 = r5.length;
        r3 = 7;
        if (r0 < r3) goto L_0x0218;
    L_0x0069:
        r0 = 0;
        r0 = r5[r0];
        r3 = 5;
        if (r0 != r3) goto L_0x01fa;
    L_0x006f:
        r0 = com.nxp.taginfolite.p009e.C0322u.INFINEON;
        r4.f538r = r0;
        r0 = 1;
        r0 = r5[r0];
        r0 = r0 & 240;
        switch(r0) {
            case 16: goto L_0x01da;
            case 32: goto L_0x01e0;
            case 48: goto L_0x01e6;
            case 112: goto L_0x01f4;
            default: goto L_0x007b;
        };
    L_0x007b:
        r0 = r4.f523c;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0.connect();	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 == 0) goto L_0x00e7;
    L_0x0084:
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = r0.f479a;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r3 = 1;
        r3 = new byte[r3];	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        r6 = 0;
        r7 = 98;
        r3[r6] = r7;	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        r6 = r4.f523c;	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        r3 = r6.transceive(r3);	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        r4.f521a = r3;	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        r3 = r4.f521a;	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        if (r3 == 0) goto L_0x00b6;
    L_0x009c:
        r3 = r4.f521a;	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        r3 = r3.length;	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        r6 = 7;
        if (r3 <= r6) goto L_0x00b6;
    L_0x00a2:
        r3 = r4.f521a;	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        r6 = 2;
        r3 = r3[r6];	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        r3 = r3 & 255;
        switch(r3) {
            case 5: goto L_0x02be;
            default: goto L_0x00ac;
        };	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
    L_0x00ac:
        r3 = r4.f521a;	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        r6 = 6;
        r3 = r3[r6];	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        r3 = r3 & 255;
        switch(r3) {
            case 19: goto L_0x02c6;
            case 20: goto L_0x00b6;
            case 21: goto L_0x02e1;
            default: goto L_0x00b6;
        };
    L_0x00b6:
        r3 = com.nxp.taginfolite.p009e.av.TNP;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 == r3) goto L_0x00be;
    L_0x00ba:
        r3 = com.nxp.taginfolite.p009e.av.TNP_I2C;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 != r3) goto L_0x00e3;
    L_0x00be:
        r3 = 2;
        r3 = new byte[r3];	 Catch:{ IOException -> 0x0415, TagLostException -> 0x02db }
        r3 = {48, 121};	 Catch:{ IOException -> 0x0415, TagLostException -> 0x02db }
        r6 = r4.f523c;	 Catch:{ IOException -> 0x0415, TagLostException -> 0x02db }
        r3 = r6.transceive(r3);	 Catch:{ IOException -> 0x0415, TagLostException -> 0x02db }
        if (r3 == 0) goto L_0x00e3;
    L_0x00cc:
        r6 = r3.length;	 Catch:{ IOException -> 0x0415, TagLostException -> 0x02db }
        r7 = 16;
        if (r6 != r7) goto L_0x00e3;
    L_0x00d1:
        r6 = r4.f535o;	 Catch:{ IOException -> 0x0415, TagLostException -> 0x02db }
        r7 = com.nxp.taginfolite.p009e.av.TNP_I2C;	 Catch:{ IOException -> 0x0415, TagLostException -> 0x02db }
        r6.f479a = r7;	 Catch:{ IOException -> 0x0415, TagLostException -> 0x02db }
        r6 = r4.f521a;	 Catch:{ IOException -> 0x0415, TagLostException -> 0x02db }
        if (r6 != 0) goto L_0x00e1;
    L_0x00db:
        r6 = r4.f535o;	 Catch:{ IOException -> 0x0415, TagLostException -> 0x02db }
        r7 = com.nxp.taginfolite.p009e.au.UNKNOWN;	 Catch:{ IOException -> 0x0415, TagLostException -> 0x02db }
        r6.f480b = r7;	 Catch:{ IOException -> 0x0415, TagLostException -> 0x02db }
    L_0x00e1:
        r4.f522b = r3;	 Catch:{ IOException -> 0x0415, TagLostException -> 0x02db }
    L_0x00e3:
        r3 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r3.f479a = r0;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
    L_0x00e7:
        r0 = r4.f537q;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r3 = com.nxp.taginfolite.p009e.C0323v.MY_D_NFC;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 == r3) goto L_0x00f3;
    L_0x00ed:
        r0 = r4.f537q;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r3 = com.nxp.taginfolite.p009e.C0323v.MY_D_PROX_2;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 != r3) goto L_0x00f6;
    L_0x00f3:
        r4.m527k();	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
    L_0x00f6:
        r0 = r4.m526j();	 Catch:{ IOException -> 0x02e9, TagLostException -> 0x02db }
        r4.f528h = r0;	 Catch:{ IOException -> 0x02e9, TagLostException -> 0x02db }
    L_0x00fc:
        r0 = r4.f523c;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = com.nxp.taginfolite.p009e.C0253s.m521a(r0);	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        f520s = r0;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = f520s;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r6 = com.nxp.taginfolite.p004f.C0351d.m1042c(r0);	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r4.f539t = r6;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = r5.length;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r3 = 4;
        if (r0 != r3) goto L_0x0118;
    L_0x0110:
        r0 = com.nxp.taginfolite.p004f.C0360m.ISO14443_A;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = com.nxp.taginfolite.p004f.C0355h.m1065a(r5, r0);	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 != 0) goto L_0x0122;
    L_0x0118:
        r0 = r5.length;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r3 = 4;
        if (r0 <= r3) goto L_0x02f9;
    L_0x011c:
        r0 = 0;
        r0 = r5[r0];	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r3 = 4;
        if (r0 != r3) goto L_0x02f9;
    L_0x0122:
        r0 = 1;
        r0 = r2[r0];	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 != 0) goto L_0x02f9;
    L_0x0127:
        r0 = 16;
        if (r1 != r0) goto L_0x0138;
    L_0x012b:
        r0 = 0;
        r0 = r2[r0];	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r3 = 4;
        if (r0 == r3) goto L_0x0149;
    L_0x0131:
        r0 = 0;
        r0 = r2[r0];	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r3 = 68;
        if (r0 == r3) goto L_0x0149;
    L_0x0138:
        r0 = 17;
        if (r1 != r0) goto L_0x02f9;
    L_0x013c:
        r0 = 0;
        r0 = r2[r0];	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = 2;
        if (r0 == r1) goto L_0x0149;
    L_0x0142:
        r0 = 0;
        r0 = r2[r0];	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = 66;
        if (r0 != r1) goto L_0x02f9;
    L_0x0149:
        r0 = 1;
        r3 = r0;
    L_0x014b:
        if (r6 == 0) goto L_0x0180;
    L_0x014d:
        if (r3 != 0) goto L_0x0153;
    L_0x014f:
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 == 0) goto L_0x0180;
    L_0x0153:
        r0 = com.nxp.taginfolite.p009e.ab.f400c;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = java.util.Arrays.equals(r6, r0);	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 == 0) goto L_0x02fd;
    L_0x015b:
        r0 = com.nxp.taginfolite.p009e.C0323v.MF_PLUS_X;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r4.f537q = r0;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 == 0) goto L_0x0168;
    L_0x0163:
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = 1;
        r0.f482d = r1;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
    L_0x0168:
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 == 0) goto L_0x0180;
    L_0x016c:
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = r0.f482d;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 == 0) goto L_0x0180;
    L_0x0172:
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = r0.f480b;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = com.nxp.taginfolite.p009e.au.OneK;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 != r1) goto L_0x0180;
    L_0x017a:
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = com.nxp.taginfolite.p009e.au.TwoK;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0.f480b = r1;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
    L_0x0180:
        r0 = r4.f537q;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = com.nxp.taginfolite.p009e.C0323v.MF_PLUS_X;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 == r1) goto L_0x0198;
    L_0x0186:
        r0 = r4.f537q;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = com.nxp.taginfolite.p009e.C0323v.MF_PLUS_S;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 == r1) goto L_0x0198;
    L_0x018c:
        r0 = r4.f537q;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = com.nxp.taginfolite.p009e.C0323v.MF_PLUS;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 == r1) goto L_0x0198;
    L_0x0192:
        r0 = r4.f537q;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = com.nxp.taginfolite.p009e.C0323v.MF_PLUS_ENGINEERING;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 != r1) goto L_0x019c;
    L_0x0198:
        r0 = com.nxp.taginfolite.p009e.C0322u.NXP;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r4.f538r = r0;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
    L_0x019c:
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 != 0) goto L_0x01aa;
    L_0x01a0:
        r0 = 0;
        r0 = r5[r0];	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = 8;
        if (r0 != r1) goto L_0x01aa;
    L_0x01a7:
        r4.m524h();	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
    L_0x01aa:
        r0 = r4.f538r;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = com.nxp.taginfolite.p009e.C0322u.MIKRON;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 != r1) goto L_0x01b6;
    L_0x01b0:
        r0 = r4.m525i();	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r4.f527g = r0;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
    L_0x01b6:
        r0 = r12.m56n();	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 == 0) goto L_0x01cc;
    L_0x01bc:
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 != 0) goto L_0x01cc;
    L_0x01c0:
        r0 = r4.f537q;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = com.nxp.taginfolite.p009e.C0323v.MF_PLUS_X;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 == r1) goto L_0x01cc;
    L_0x01c6:
        r0 = r4.m541e();	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r4.f526f = r0;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
    L_0x01cc:
        r0 = r4.f523c;	 Catch:{ IOException -> 0x040b }
        r0.close();	 Catch:{ IOException -> 0x040b }
    L_0x01d1:
        return r4;
    L_0x01d2:
        r0 = android.nfc.tech.NfcB.get(r9);
        r4.f532l = r0;
        goto L_0x0021;
    L_0x01da:
        r0 = com.nxp.taginfolite.p009e.C0323v.MY_D_PROX_2;
        r4.f537q = r0;
        goto L_0x007b;
    L_0x01e0:
        r0 = com.nxp.taginfolite.p009e.C0323v.MY_D_NFC;
        r4.f537q = r0;
        goto L_0x007b;
    L_0x01e6:
        if (r11 != 0) goto L_0x01ee;
    L_0x01e8:
        r0 = com.nxp.taginfolite.p009e.C0323v.SLE66R01P;
        r4.f537q = r0;
        goto L_0x007b;
    L_0x01ee:
        r0 = com.nxp.taginfolite.p009e.C0323v.MY_D_MOVE;
        r4.f537q = r0;
        goto L_0x007b;
    L_0x01f4:
        r0 = com.nxp.taginfolite.p009e.C0323v.SLE66R01L;
        r4.f537q = r0;
        goto L_0x007b;
    L_0x01fa:
        r0 = 0;
        r0 = r5[r0];
        r3 = 55;
        if (r0 != r3) goto L_0x020b;
    L_0x0201:
        r0 = com.nxp.taginfolite.p009e.C0322u.KOVIO;
        r4.f538r = r0;
        r0 = com.nxp.taginfolite.p009e.C0323v.KOVIO_2K;
        r4.f537q = r0;
        goto L_0x007b;
    L_0x020b:
        r0 = 0;
        r0 = r5[r0];
        r3 = 52;
        if (r0 != r3) goto L_0x007b;
    L_0x0212:
        r0 = com.nxp.taginfolite.p009e.C0322u.MIKRON;
        r4.f538r = r0;
        goto L_0x007b;
    L_0x0218:
        r0 = r5.length;
        r3 = 4;
        if (r0 != r3) goto L_0x007b;
    L_0x021c:
        r0 = com.nxp.taginfolite.p004f.C0360m.ISO14443_A;
        r0 = com.nxp.taginfolite.p004f.C0355h.m1065a(r5, r0);
        if (r0 == 0) goto L_0x023c;
    L_0x0224:
        r0 = 0;
        r0 = r2[r0];
        r3 = 16;
        if (r0 != r3) goto L_0x025b;
    L_0x022b:
        r0 = 1;
        r0 = r2[r0];
        if (r0 != 0) goto L_0x025b;
    L_0x0230:
        r0 = 129; // 0x81 float:1.81E-43 double:6.37E-322;
        if (r1 != r0) goto L_0x025b;
    L_0x0234:
        r0 = com.nxp.taginfolite.p009e.C0323v.MF_LIGHT;
        r4.f537q = r0;
        r0 = com.nxp.taginfolite.p009e.C0322u.NXP;
        r4.f538r = r0;
    L_0x023c:
        r0 = r4.f537q;
        r3 = com.nxp.taginfolite.p009e.C0323v.UNKNOWN;
        if (r0 != r3) goto L_0x007b;
    L_0x0242:
        r0 = 34;
        if (r1 != r0) goto L_0x0274;
    L_0x0246:
        r0 = 0;
        r0 = r2[r0];
        r3 = 4;
        if (r0 != r3) goto L_0x0274;
    L_0x024c:
        r0 = 1;
        r0 = r2[r0];
        if (r0 != 0) goto L_0x0274;
    L_0x0251:
        r0 = com.nxp.taginfolite.p009e.C0322u.HUAHONG;
        r4.f538r = r0;
        r0 = com.nxp.taginfolite.p009e.C0323v.SHC1101;
        r4.f537q = r0;
        goto L_0x007b;
    L_0x025b:
        r0 = 0;
        r0 = r2[r0];
        r3 = 1;
        if (r0 != r3) goto L_0x023c;
    L_0x0261:
        r0 = 1;
        r0 = r2[r0];
        r3 = 15;
        if (r0 != r3) goto L_0x023c;
    L_0x0268:
        r0 = 1;
        if (r1 != r0) goto L_0x023c;
    L_0x026b:
        r0 = com.nxp.taginfolite.p009e.C0323v.MF_TACKNPLAY;
        r4.f537q = r0;
        r0 = com.nxp.taginfolite.p009e.C0322u.NXP;
        r4.f538r = r0;
        goto L_0x023c;
    L_0x0274:
        r0 = 83;
        if (r1 != r0) goto L_0x02a4;
    L_0x0278:
        r0 = 0;
        r0 = r2[r0];
        r3 = 4;
        if (r0 != r3) goto L_0x02a4;
    L_0x027e:
        r0 = 1;
        r0 = r2[r0];
        if (r0 != 0) goto L_0x02a4;
    L_0x0283:
        r0 = com.nxp.taginfolite.p009e.C0322u.FUDAN;
        r4.f538r = r0;
        r0 = com.nxp.taginfolite.p009e.C0323v.FM1208SH01;
        r4.f537q = r0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = "Shanghai public transportation card";
        r0 = r0.append(r3);
        r3 = com.nxp.taginfolite.p004f.C0361n.f1092c;
        r0 = r0.append(r3);
        r0 = r0.toString();
        r4.f527g = r0;
        goto L_0x007b;
    L_0x02a4:
        r0 = 32;
        if (r1 != r0) goto L_0x007b;
    L_0x02a8:
        r0 = 0;
        r0 = r2[r0];
        r3 = 8;
        if (r0 != r3) goto L_0x007b;
    L_0x02af:
        r0 = 1;
        r0 = r2[r0];
        if (r0 != 0) goto L_0x007b;
    L_0x02b4:
        r0 = com.nxp.taginfolite.p009e.C0322u.FUDAN;
        r4.f538r = r0;
        r0 = com.nxp.taginfolite.p009e.C0323v.FM1208;
        r4.f537q = r0;
        goto L_0x007b;
    L_0x02be:
        r3 = com.nxp.taginfolite.p009e.av.TNP;	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        if (r0 != r3) goto L_0x00ac;
    L_0x02c2:
        r0 = com.nxp.taginfolite.p009e.av.TNP_I2C;	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        goto L_0x00ac;
    L_0x02c6:
        r3 = r4.f535o;	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        r6 = com.nxp.taginfolite.p009e.au.OneK;	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        r3.f480b = r6;	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        goto L_0x00b6;
    L_0x02ce:
        r3 = move-exception;
        r3 = r4.f523c;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r3.close();	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r3 = r4.f523c;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r3.connect();	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        goto L_0x00b6;
    L_0x02db:
        r0 = move-exception;
        r0 = 1;
        r4.f533m = r0;
        goto L_0x01cc;
    L_0x02e1:
        r3 = r4.f535o;	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        r6 = com.nxp.taginfolite.p009e.au.TwoK;	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        r3.f480b = r6;	 Catch:{ IOException -> 0x02ce, TagLostException -> 0x02db }
        goto L_0x00b6;
    L_0x02e9:
        r0 = move-exception;
        r0 = r4.f523c;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0.close();	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = r4.f523c;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0.connect();	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        goto L_0x00fc;
    L_0x02f6:
        r0 = move-exception;
        goto L_0x01cc;
    L_0x02f9:
        r0 = 0;
        r3 = r0;
        goto L_0x014b;
    L_0x02fd:
        r0 = com.nxp.taginfolite.p009e.ab.f398a;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = java.util.Arrays.equals(r6, r0);	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 == 0) goto L_0x0314;
    L_0x0305:
        r0 = com.nxp.taginfolite.p009e.C0323v.MF_PLUS_X;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r4.f537q = r0;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 == 0) goto L_0x0168;
    L_0x030d:
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = 1;
        r0.f482d = r1;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        goto L_0x0168;
    L_0x0314:
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 == 0) goto L_0x032b;
    L_0x0318:
        r0 = com.nxp.taginfolite.p009e.ab.f399b;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = java.util.Arrays.equals(r6, r0);	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        if (r0 == 0) goto L_0x032b;
    L_0x0320:
        r0 = com.nxp.taginfolite.p009e.C0323v.MF_PLUS_S;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r4.f537q = r0;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = 1;
        r0.f482d = r1;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        goto L_0x0168;
    L_0x032b:
        r0 = 0;
        r1 = 3;
        r2 = new byte[r1];	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r2 = {118, 4, -112};	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = 3;
        r1 = new byte[r1];	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = {118, 0, 64};
        r6 = 0;
        if (r3 == 0) goto L_0x0379;
    L_0x033b:
        r2 = r4.f523c;	 Catch:{ IOException -> 0x038e, all -> 0x03cc }
        r2.close();	 Catch:{ IOException -> 0x038e, all -> 0x03cc }
        r2 = r4.f523c;	 Catch:{ IOException -> 0x038e, all -> 0x03cc }
        r2.connect();	 Catch:{ IOException -> 0x038e, all -> 0x03cc }
        r0 = 1;
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ IOException -> 0x038e, all -> 0x03cc }
        r7 = 14;
        if (r2 < r7) goto L_0x0353;
    L_0x034c:
        r2 = r4.f523c;	 Catch:{ IOException -> 0x038e, all -> 0x03cc }
        r7 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r2.setTimeout(r7);	 Catch:{ IOException -> 0x038e, all -> 0x03cc }
    L_0x0353:
        r2 = r4.f523c;	 Catch:{ IOException -> 0x038e, all -> 0x03cc }
        r0 = r2.transceive(r1);	 Catch:{ IOException -> 0x038e, all -> 0x03cc }
        r1 = r4.f523c;	 Catch:{ TagLostException -> 0x037b, IOException -> 0x0412 }
        r1.close();	 Catch:{ TagLostException -> 0x037b, IOException -> 0x0412 }
        r1 = r4.f523c;	 Catch:{ TagLostException -> 0x037b, IOException -> 0x0412 }
        r1.connect();	 Catch:{ TagLostException -> 0x037b, IOException -> 0x0412 }
    L_0x0363:
        if (r0 == 0) goto L_0x0168;
    L_0x0365:
        r1 = r0.length;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r2 = 17;
        if (r1 != r2) goto L_0x0168;
    L_0x036a:
        r1 = 0;
        r0 = r0[r1];	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = -112; // 0xffffffffffffff90 float:NaN double:NaN;
        if (r0 != r1) goto L_0x0168;
    L_0x0371:
        if (r3 == 0) goto L_0x037d;
    L_0x0373:
        r0 = com.nxp.taginfolite.p009e.C0323v.MF_PLUS_X;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r4.f537q = r0;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        goto L_0x0168;
    L_0x0379:
        r1 = r2;
        goto L_0x033b;
    L_0x037b:
        r0 = move-exception;
        throw r0;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
    L_0x037d:
        r0 = com.nxp.taginfolite.p009e.C0323v.MF_PLUS;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r4.f537q = r0;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = com.nxp.taginfolite.p009e.av.PLUS;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0.f479a = r1;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = 1;
        r0.f482d = r1;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        goto L_0x0168;
    L_0x038e:
        r1 = move-exception;
        if (r0 == 0) goto L_0x03b3;
    L_0x0391:
        r1 = r4.f523c;	 Catch:{ TagLostException -> 0x03b9, IOException -> 0x0410 }
        r1.close();	 Catch:{ TagLostException -> 0x03b9, IOException -> 0x0410 }
        r1 = r4.f523c;	 Catch:{ TagLostException -> 0x03b9, IOException -> 0x0410 }
        r1.connect();	 Catch:{ TagLostException -> 0x03b9, IOException -> 0x0410 }
    L_0x039b:
        if (r0 == 0) goto L_0x0168;
    L_0x039d:
        if (r6 == 0) goto L_0x0168;
    L_0x039f:
        r0 = r6.length;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = 17;
        if (r0 != r1) goto L_0x0168;
    L_0x03a4:
        r0 = 0;
        r0 = r6[r0];	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = -112; // 0xffffffffffffff90 float:NaN double:NaN;
        if (r0 != r1) goto L_0x0168;
    L_0x03ab:
        if (r3 == 0) goto L_0x03bb;
    L_0x03ad:
        r0 = com.nxp.taginfolite.p009e.C0323v.MF_PLUS_X;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r4.f537q = r0;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        goto L_0x0168;
    L_0x03b3:
        r1 = r4.f523c;	 Catch:{ TagLostException -> 0x03b9, IOException -> 0x0410 }
        r1.connect();	 Catch:{ TagLostException -> 0x03b9, IOException -> 0x0410 }
        goto L_0x039b;
    L_0x03b9:
        r0 = move-exception;
        throw r0;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
    L_0x03bb:
        r0 = com.nxp.taginfolite.p009e.C0323v.MF_PLUS;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r4.f537q = r0;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = com.nxp.taginfolite.p009e.av.PLUS;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0.f479a = r1;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r0 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = 1;
        r0.f482d = r1;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        goto L_0x0168;
    L_0x03cc:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        if (r1 == 0) goto L_0x03f3;
    L_0x03d2:
        r2 = r4.f523c;	 Catch:{ TagLostException -> 0x03f9, IOException -> 0x040e }
        r2.close();	 Catch:{ TagLostException -> 0x03f9, IOException -> 0x040e }
        r2 = r4.f523c;	 Catch:{ TagLostException -> 0x03f9, IOException -> 0x040e }
        r2.connect();	 Catch:{ TagLostException -> 0x03f9, IOException -> 0x040e }
    L_0x03dc:
        if (r1 == 0) goto L_0x03f2;
    L_0x03de:
        if (r6 == 0) goto L_0x03f2;
    L_0x03e0:
        r1 = r6.length;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r2 = 17;
        if (r1 != r2) goto L_0x03f2;
    L_0x03e5:
        r1 = 0;
        r1 = r6[r1];	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r2 = -112; // 0xffffffffffffff90 float:NaN double:NaN;
        if (r1 != r2) goto L_0x03f2;
    L_0x03ec:
        if (r3 == 0) goto L_0x03fb;
    L_0x03ee:
        r1 = com.nxp.taginfolite.p009e.C0323v.MF_PLUS_X;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r4.f537q = r1;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
    L_0x03f2:
        throw r0;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
    L_0x03f3:
        r2 = r4.f523c;	 Catch:{ TagLostException -> 0x03f9, IOException -> 0x040e }
        r2.connect();	 Catch:{ TagLostException -> 0x03f9, IOException -> 0x040e }
        goto L_0x03dc;
    L_0x03f9:
        r0 = move-exception;
        throw r0;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
    L_0x03fb:
        r1 = com.nxp.taginfolite.p009e.C0323v.MF_PLUS;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r4.f537q = r1;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r2 = com.nxp.taginfolite.p009e.av.PLUS;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1.f479a = r2;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r1 = r4.f535o;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        r2 = 1;
        r1.f482d = r2;	 Catch:{ TagLostException -> 0x02db, IOException -> 0x02f6 }
        goto L_0x03f2;
    L_0x040b:
        r0 = move-exception;
        goto L_0x01d1;
    L_0x040e:
        r2 = move-exception;
        goto L_0x03dc;
    L_0x0410:
        r1 = move-exception;
        goto L_0x039b;
    L_0x0412:
        r1 = move-exception;
        goto L_0x0363;
    L_0x0415:
        r3 = move-exception;
        goto L_0x00e3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.e.s.a(android.nfc.Tag, com.nxp.taginfolite.f.m, boolean, com.nxp.taginfolite.a, boolean):com.nxp.taginfolite.e.s");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    private static byte[] m521a(android.nfc.tech.NfcA r5) {
        /*
        r0 = 2;
        r1 = new byte[r0];
        r1 = {-32, -128};
        r0 = 1;
        r2 = new byte[r0];
        r0 = 0;
        r3 = -62;
        r2[r0] = r3;
        r0 = 0;
        r5.close();	 Catch:{ TagLostException -> 0x0038, IOException -> 0x004d, all -> 0x0062 }
        r5.connect();	 Catch:{ TagLostException -> 0x0038, IOException -> 0x004d, all -> 0x0062 }
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ TagLostException -> 0x0038, IOException -> 0x004d, all -> 0x0062 }
        r4 = 14;
        if (r3 < r4) goto L_0x0020;
    L_0x001b:
        r3 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r5.setTimeout(r3);	 Catch:{ TagLostException -> 0x0038, IOException -> 0x004d, all -> 0x0062 }
    L_0x0020:
        r0 = r5.transceive(r1);	 Catch:{ TagLostException -> 0x0038, IOException -> 0x004d, all -> 0x0062 }
        r5.transceive(r2);	 Catch:{ IOException -> 0x002e }
        r5.close();	 Catch:{ IOException -> 0x002e }
        r5.connect();	 Catch:{ IOException -> 0x002e }
    L_0x002d:
        return r0;
    L_0x002e:
        r1 = move-exception;
        r5.close();	 Catch:{ TagLostException -> 0x0036, IOException -> 0x007d }
        r5.connect();	 Catch:{ TagLostException -> 0x0036, IOException -> 0x007d }
        goto L_0x002d;
    L_0x0036:
        r1 = move-exception;
        goto L_0x002d;
    L_0x0038:
        r1 = move-exception;
        r5.transceive(r2);	 Catch:{ IOException -> 0x0043 }
        r5.close();	 Catch:{ IOException -> 0x0043 }
        r5.connect();	 Catch:{ IOException -> 0x0043 }
        goto L_0x002d;
    L_0x0043:
        r1 = move-exception;
        r5.close();	 Catch:{ TagLostException -> 0x004b, IOException -> 0x007b }
        r5.connect();	 Catch:{ TagLostException -> 0x004b, IOException -> 0x007b }
        goto L_0x002d;
    L_0x004b:
        r1 = move-exception;
        goto L_0x002d;
    L_0x004d:
        r1 = move-exception;
        r5.transceive(r2);	 Catch:{ IOException -> 0x0058 }
        r5.close();	 Catch:{ IOException -> 0x0058 }
        r5.connect();	 Catch:{ IOException -> 0x0058 }
        goto L_0x002d;
    L_0x0058:
        r1 = move-exception;
        r5.close();	 Catch:{ TagLostException -> 0x0060, IOException -> 0x0079 }
        r5.connect();	 Catch:{ TagLostException -> 0x0060, IOException -> 0x0079 }
        goto L_0x002d;
    L_0x0060:
        r1 = move-exception;
        goto L_0x002d;
    L_0x0062:
        r0 = move-exception;
        r5.transceive(r2);	 Catch:{ IOException -> 0x006d }
        r5.close();	 Catch:{ IOException -> 0x006d }
        r5.connect();	 Catch:{ IOException -> 0x006d }
    L_0x006c:
        throw r0;
    L_0x006d:
        r1 = move-exception;
        r5.close();	 Catch:{ TagLostException -> 0x0075, IOException -> 0x0077 }
        r5.connect();	 Catch:{ TagLostException -> 0x0075, IOException -> 0x0077 }
        goto L_0x006c;
    L_0x0075:
        r1 = move-exception;
        goto L_0x006c;
    L_0x0077:
        r1 = move-exception;
        goto L_0x006c;
    L_0x0079:
        r1 = move-exception;
        goto L_0x002d;
    L_0x007b:
        r1 = move-exception;
        goto L_0x002d;
    L_0x007d:
        r1 = move-exception;
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.e.s.a(android.nfc.tech.NfcA):byte[]");
    }

    public static String[] m522a(int i, byte b, byte b2) {
        String[] strArr = new String[4];
        String str;
        switch (i) {
            case C0519c.Switch_track /*1*/:
                str = (b & 16) != 0 ? (b & 2) != 0 ? "*" : "x" : (b & 2) != 0 ? "+" : ".";
                strArr[0] = str;
                str = (b & 32) != 0 ? (b & 2) != 0 ? "*" : "x" : (b & 2) != 0 ? "+" : ".";
                strArr[1] = str;
                str = (b & 64) != 0 ? (b & 2) != 0 ? "*" : "x" : (b & 2) != 0 ? "+" : ".";
                strArr[2] = str;
                str = (b & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0 ? (b & 2) != 0 ? "*" : "x" : (b & 2) != 0 ? "+" : ".";
                strArr[3] = str;
                return strArr;
            case C0519c.Switch_textOn /*2*/:
                str = (b2 & 1) != 0 ? (b & 2) != 0 ? "*" : "x" : (b & 2) != 0 ? "+" : ".";
                strArr[0] = str;
                str = (b2 & 2) != 0 ? (b & 2) != 0 ? "*" : "x" : (b & 2) != 0 ? "+" : ".";
                strArr[1] = str;
                str = (b2 & 4) != 0 ? (b & 4) != 0 ? "*" : "x" : (b & 4) != 0 ? "+" : ".";
                strArr[2] = str;
                str = (b2 & 8) != 0 ? (b & 4) != 0 ? "*" : "x" : (b & 4) != 0 ? "+" : ".";
                strArr[3] = str;
                return strArr;
            case C0519c.Switch_textOff /*3*/:
                str = (b2 & 16) != 0 ? (b & 4) != 0 ? "*" : "x" : (b & 4) != 0 ? "+" : ".";
                strArr[0] = str;
                str = (b2 & 32) != 0 ? (b & 4) != 0 ? "*" : "x" : (b & 4) != 0 ? "+" : ".";
                strArr[1] = str;
                str = (b2 & 64) != 0 ? (b & 4) != 0 ? "*" : "x" : (b & 4) != 0 ? "+" : ".";
                strArr[2] = str;
                str = (b2 & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0 ? (b & 4) != 0 ? "*" : "x" : (b & 4) != 0 ? "+" : ".";
                strArr[3] = str;
                return strArr;
            default:
                return null;
        }
    }

    private byte[] m523d(int i) {
        return this.f523c.transceive(new byte[]{(byte) 16, (byte) (i & MotionEventCompat.ACTION_MASK), (byte) ((i >>> 8) & MotionEventCompat.ACTION_MASK)});
    }

    private void m524h() {
        boolean z = false;
        byte[] bArr = new byte[]{(byte) -48, (byte) -38, (byte) 1, (byte) 0};
        int i = 0;
        boolean z2 = false;
        while (i < 6) {
            bArr[3] = (byte) i;
            try {
                this.f523c.transceive(bArr);
                i++;
                z2 = true;
            } catch (IOException e) {
                this.f533m = true;
                this.f523c.close();
                this.f523c.connect();
            }
        }
        z = z2;
        if (z) {
            this.f527g = "ELOCK2 door lock";
        }
    }

    private String m525i() {
        return az.m545a(new byte[][]{m535a(2), m535a(6)});
    }

    private byte[] m526j() {
        return Arrays.copyOf(m535a(3), 4);
    }

    private void m527k() {
        try {
            switch (m523d(2)[0] & 199) {
                case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                    this.f537q = C0323v.SLE66R04S;
                case 132:
                    this.f537q = C0323v.SLE66R16S;
                case 133:
                    this.f537q = C0323v.SLE66R32S;
                case 194:
                    this.f537q = C0323v.SLE66R04P;
                case 196:
                    this.f537q = C0323v.SLE66R16P;
                case 197:
                    this.f537q = C0323v.SLE66R32P;
                default:
            }
        } catch (TagLostException e) {
            throw e;
        } catch (IOException e2) {
        }
    }

    private com.nxp.taginfolite.p005b.C0182c m528l() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.nxp.taginfolite.e.s.l():com.nxp.taginfolite.b.c. bs: [B:8:0x0021, B:22:0x005a]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:57)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r13 = this;
        r1 = 1;
        r0 = 0;
        r7 = new com.nxp.taginfolite.b.c;
        r7.<init>();
        r2 = com.nxp.taginfolite.p009e.C0321t.f911a;
        r3 = r13.f537q;
        r3 = r3.ordinal();
        r2 = r2[r3];
        switch(r2) {
            case 1: goto L_0x0032;
            case 2: goto L_0x0037;
            case 3: goto L_0x0037;
            case 4: goto L_0x003c;
            case 5: goto L_0x003c;
            case 6: goto L_0x0041;
            case 7: goto L_0x0041;
            case 8: goto L_0x0046;
            case 9: goto L_0x0046;
            default: goto L_0x0014;
        };
    L_0x0014:
        r6 = r0;
        r3 = r0;
    L_0x0016:
        r2 = 2;
        r4 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r3 <= r4) goto L_0x00b6;
    L_0x001b:
        r2 = 3;
        r5 = r2;
    L_0x001d:
        if (r3 <= 0) goto L_0x004b;
    L_0x001f:
        if (r0 >= r3) goto L_0x009e;
    L_0x0021:
        r2 = new com.nxp.taginfolite.b.d;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r4 = "";	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r6 = r13.m523d(r0);	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r2.<init>(r0, r5, r4, r6);	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r7.m147a(r2);	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r0 = r0 + 1;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        goto L_0x001f;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
    L_0x0032:
        r2 = 16;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r6 = r2;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r3 = r0;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        goto L_0x0016;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
    L_0x0037:
        r2 = 38;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r6 = r2;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r3 = r0;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        goto L_0x0016;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
    L_0x003c:
        r2 = 77;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r6 = r0;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r3 = r2;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        goto L_0x0016;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
    L_0x0041:
        r2 = 256; // 0x100 float:3.59E-43 double:1.265E-321;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r6 = r0;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r3 = r2;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        goto L_0x0016;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
    L_0x0046:
        r2 = 512; // 0x200 float:7.175E-43 double:2.53E-321;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r6 = r0;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r3 = r2;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        goto L_0x0016;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
    L_0x004b:
        if (r6 <= 0) goto L_0x009e;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
    L_0x004d:
        r4 = r0;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r2 = r0;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
    L_0x004f:
        if (r4 >= r6) goto L_0x0083;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
    L_0x0051:
        if (r4 <= 0) goto L_0x00b4;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
    L_0x0053:
        r3 = r4 % 256;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        if (r3 != 0) goto L_0x00b4;
    L_0x0057:
        r2 = r2 + 1;
        r2 = (byte) r2;
        r13.m536b(r2);	 Catch:{ IOException -> 0x0081, TagLostException -> 0x008d }
        r3 = r2;
    L_0x005e:
        r8 = r13.m535a(r4);	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r2 = r0;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
    L_0x0063:
        r9 = r8.length;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        if (r2 >= r9) goto L_0x009f;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
    L_0x0066:
        r9 = r2 / 4;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r9 = r9 + r4;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        if (r9 >= r6) goto L_0x009f;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
    L_0x006b:
        r9 = new com.nxp.taginfolite.b.d;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r10 = r2 / 4;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r10 = r10 + r4;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r11 = "";	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r12 = r2 + 4;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r12 = java.util.Arrays.copyOfRange(r8, r2, r12);	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r9.<init>(r10, r5, r11, r12);	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r7.m147a(r9);	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r2 = r2 + 4;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        goto L_0x0063;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
    L_0x0081:
        r0 = move-exception;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r0 = r1;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
    L_0x0083:
        if (r0 == 0) goto L_0x009e;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
    L_0x0085:
        r0 = new android.nfc.TagLostException;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r2 = "SectorSelect failed";	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        r0.<init>(r2);	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
        throw r0;	 Catch:{ TagLostException -> 0x008d, IOException -> 0x00a4 }
    L_0x008d:
        r0 = move-exception;
        r13.f533m = r1;
        r0 = new com.nxp.taginfolite.b.o;
        r1 = "<aborted: tag disappeared>";
        r1 = com.nxp.taginfolite.p003g.C0429j.m1391a(r1);
        r0.<init>(r1);
        r7.m147a(r0);
    L_0x009e:
        return r7;
    L_0x009f:
        r2 = r4 + 4;
        r4 = r2;
        r2 = r3;
        goto L_0x004f;
    L_0x00a4:
        r0 = move-exception;
        r0 = new com.nxp.taginfolite.b.o;
        r1 = "<aborted: read error>";
        r1 = com.nxp.taginfolite.p003g.C0429j.m1391a(r1);
        r0.<init>(r1);
        r7.m147a(r0);
        goto L_0x009e;
    L_0x00b4:
        r3 = r2;
        goto L_0x005e;
    L_0x00b6:
        r5 = r2;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.e.s.l():com.nxp.taginfolite.b.c");
    }

    private String m529m() {
        Object b = C0355h.m1067b(this.f524d.getId(), C0360m.ISO14443_A);
        if (b.equals("NXP Semiconductors") && !m534a()) {
            b = "Unknown manufacturer";
        }
        if (this.f538r == C0322u.HUAHONG) {
            b = "Hua Hong Group";
        }
        if (this.f538r == C0322u.FUDAN) {
            b = "Fudan Microelectronics";
        }
        return (this.f535o == null || this.f530j.m68z()) ? null : "NXP Semiconductors".equals(b) ? "No access possible\nThis Android device does not support MIFARE Classic tags" : "No access possible\nThis Android device does not support this type of tag";
    }

    public void m530a(C0197a c0197a, boolean z) {
        if (this.f538r == C0322u.NXP || this.f535o != null) {
            if (this.f537q == C0323v.MF_LIGHT) {
                c0197a.m193a("48 bytes\n" + C0358k.f1076c + "12 pages, with 4 bytes per page");
            } else if (this.f535o != null && this.f535o.f480b != au.UNKNOWN) {
                c0197a.m193a((CharSequence) ag.f429a.get(this.f535o.f480b));
            } else if (this.f537q == C0323v.MF_PLUS_X || this.f537q == C0323v.MF_PLUS_ENGINEERING) {
                short sak = this.f523c.getSak();
                if (sak == (short) 16) {
                    c0197a.m200d("Security Level 2");
                    c0197a.m193a((CharSequence) ag.f429a.get(au.TwoK));
                } else if (sak == (short) 17) {
                    c0197a.m200d("Security Level 2");
                    c0197a.m193a((CharSequence) ag.f429a.get(au.FourK));
                } else {
                    c0197a.m200d("Security Level 1");
                }
            } else if (this.f537q == C0323v.MF_PLUS_S || this.f537q == C0323v.MF_PLUS) {
                c0197a.m200d("Security Level 1");
            }
            if (this.f535o != null && this.f535o.f479a == av.TNP_I2C) {
                c0197a.m198c(C0362o.f1101h);
            }
        } else if (this.f538r == C0322u.INFINEON) {
            CharSequence charSequence = null;
            switch (C0321t.f911a[this.f537q.ordinal()]) {
                case C0519c.Switch_track /*1*/:
                    charSequence = "64 bytes\n" + C0358k.f1076c + "16 blocks, with 4 bytes per block\n" + C0358k.f1076c + "48 bytes user memory (12 blocks)";
                    break;
                case C0519c.Switch_textOn /*2*/:
                case C0519c.Switch_textOff /*3*/:
                    charSequence = "152 bytes\n" + C0358k.f1076c + "38 blocks, with 4 bytes per block\n" + C0358k.f1076c + "128 bytes user memory (32 blocks)";
                    break;
                case C0519c.Switch_thumbTextPadding /*4*/:
                    charSequence = "770 bytes\n" + C0358k.f1076c + "77 pages, with 8(+2) bytes per page\n" + C0358k.f1076c + "592 bytes user memory (74 pages)";
                    break;
                case C0519c.Switch_switchTextAppearance /*5*/:
                    charSequence = "770 bytes\n" + C0358k.f1076c + "77 pages, with 8(+2) bytes per page\n" + C0358k.f1076c + "576 bytes user memory (72 pages)";
                    break;
                case C0519c.Switch_switchMinWidth /*6*/:
                    charSequence = "2560 bytes\n" + C0358k.f1076c + "256 pages, with 8(+2) bytes per page\n" + C0358k.f1076c + "2024 bytes user memory (253 pages)\n" + C0358k.f1076c + "1024 bytes NFC memory";
                    break;
                case C0519c.Switch_switchPadding /*7*/:
                    charSequence = "2560 bytes\n" + C0358k.f1076c + "256 pages, with 8(+2) bytes per page\n" + C0358k.f1076c + "2008 bytes user memory (251 pages)";
                    break;
                case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                    charSequence = "5120 bytes\n" + C0358k.f1076c + "512 pages, with 8(+2) bytes per page\n" + C0358k.f1076c + "4072 bytes user memory (509 pages)\n" + C0358k.f1076c + "2048 bytes NFC memory";
                    break;
                case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                    charSequence = "5120 bytes\n" + C0358k.f1076c + "512 pages, with 8(+2) bytes per page\n" + C0358k.f1076c + "4056 bytes user memory (507 pages)";
                    break;
            }
            c0197a.m193a(charSequence);
        }
        if (this.f521a != null) {
            c0197a.m201d("Version information", C0372z.m1115a(this.f521a));
        }
        if (this.f522b != null) {
            c0197a.m203e("Session configuration", C0303k.m813a(this.f522b, true, true, C0372z.m1118d(this.f521a)));
        }
        if (this.f539t != null) {
            c0197a.m206g(C0351d.m1034a(this.f539t, this.f524d.getId()));
        }
    }

    public void m531a(C0198b c0198b, boolean z) {
        if (this.f528h != null && this.f528h[0] == -31) {
            c0198b.m214a(m542f());
            c0198b.m217b(new C0182c().m147a(new C0184h(-1, this.f528h)));
        }
        if (this.f529i != null) {
            c0198b.m220c(this.f529i);
        }
    }

    public void m532a(C0199c c0199c, boolean z) {
        CharSequence charSequence;
        CharSequence charSequence2 = "Unknown manufacturer";
        String str = "Unknown IC";
        if (this.f531k == C0360m.ISO14443_A) {
            String b = C0355h.m1067b(this.f524d.getId(), C0360m.ISO14443_A);
            if (this.f535o != null && this.f536p) {
                b = "Unknown manufacturer";
            }
            if (!b.equals("NXP Semiconductors") || m534a()) {
                Object obj = (this.f538r != C0322u.INFINEON || this.f536p) ? this.f538r == C0322u.HUAHONG ? "Hua Hong Group" : this.f538r == C0322u.FUDAN ? "Fudan Microelectronics" : b : "Infineon Technologies AG";
            } else {
                charSequence2 = "Unknown manufacturer";
            }
            CharSequence d = m540d();
            switch (C0321t.f911a[this.f537q.ordinal()]) {
                case C0519c.Switch_track /*1*/:
                    charSequence = "my-d move lean (SLE66R01L)";
                    break;
                case C0519c.Switch_textOn /*2*/:
                    charSequence = "my-d move (NFC) (SLE66R01P(N))";
                    break;
                case C0519c.Switch_textOff /*3*/:
                    charSequence = "my-d move (SLE66R01P)";
                    break;
                case C0519c.Switch_thumbTextPadding /*4*/:
                    charSequence = "my-d NFC (SLE66R04P)";
                    break;
                case C0519c.Switch_switchTextAppearance /*5*/:
                    charSequence = "my-d proximity 2 (SLE66R04S)";
                    break;
                case C0519c.Switch_switchMinWidth /*6*/:
                    charSequence = "my-d NFC (SLE66R16P)";
                    break;
                case C0519c.Switch_switchPadding /*7*/:
                    charSequence = "my-d proximity 2 (SLE66R16S)";
                    break;
                case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                    charSequence = "my-d NFC (SLE66R32P)";
                    break;
                case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                    charSequence = "my-d proximity 2 (SLE66R32S)";
                    break;
                case C0086R.styleable.SherlockTheme_actionMenuTextAppearance /*10*/:
                    charSequence = "my-d proximity enhanced (SLE55RxxE)";
                    break;
                case C0086R.styleable.SherlockTheme_actionMenuTextColor /*11*/:
                    charSequence = "my-d proximity 2 (SLE66RxxS)";
                    break;
                case C0086R.styleable.SherlockTheme_actionModeStyle /*12*/:
                    charSequence = "my-d NFC (SLE66RxxP)";
                    break;
                case C0086R.styleable.SherlockTheme_actionModeCloseButtonStyle /*13*/:
                    charSequence = "MIFARE Light (MF1ICL10)";
                    break;
                case C0086R.styleable.SherlockTheme_actionModeBackground /*14*/:
                    charSequence = "Kovio 2Kb (K14T3N)";
                    break;
                case C0086R.styleable.SherlockTheme_actionModeSplitBackground /*15*/:
                    if (!TextUtils.isEmpty(d)) {
                        charSequence = "MIFARE Plus X (" + d.trim() + ")";
                        break;
                    } else {
                        charSequence = "MIFARE Plus X";
                        break;
                    }
                case Menu.CATEGORY_SHIFT /*16*/:
                    if (!TextUtils.isEmpty(d)) {
                        charSequence = "MIFARE Plus S (" + d.trim() + ")";
                        break;
                    } else {
                        charSequence = "MIFARE Plus S";
                        break;
                    }
                case C0086R.styleable.SherlockTheme_actionModeShareDrawable /*17*/:
                    if (!TextUtils.isEmpty(d)) {
                        charSequence = "MIFARE Plus (" + d.trim() + ")";
                        break;
                    } else {
                        charSequence = "MIFARE Plus";
                        break;
                    }
                case C0086R.styleable.SherlockTheme_actionModePopupWindowStyle /*18*/:
                    charSequence = "TNP3xxx";
                    break;
                default:
                    charSequence = str;
                    break;
            }
            if (this.f535o != null) {
                b = (String) ag.f430b.get(this.f535o.f479a);
                StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
                if ("NXP Semiconductors".equals(charSequence2) && !TextUtils.isEmpty(b)) {
                    stringBuilder.append(b);
                    if (!TextUtils.isEmpty(d)) {
                        stringBuilder.append(" (");
                    }
                }
                if (!TextUtils.isEmpty(d)) {
                    stringBuilder.append(d.trim());
                }
                if (!(!"NXP Semiconductors".equals(charSequence2) || TextUtils.isEmpty(b) || TextUtils.isEmpty(d))) {
                    stringBuilder.append(")");
                }
                charSequence = stringBuilder.toString();
            } else if (!TextUtils.isEmpty(d) && "Unknown IC".equals(r0)) {
                charSequence = d;
            }
        } else {
            Object obj2 = str;
        }
        c0199c.m230d(charSequence2);
        c0199c.m231e(charSequence);
        if (this.f537q == C0323v.MF_TACKNPLAY && this.f535o == null) {
            c0199c.m227b("Activision game item");
        } else if (this.f535o != null) {
            c0199c.m227b(m529m());
        }
        if (!TextUtils.isEmpty(this.f527g)) {
            c0199c.m227b(this.f527g);
        }
    }

    public void m533a(C0200d c0200d, boolean z) {
        if (this.f531k == C0360m.ISO14443_A) {
            CharSequence charSequence = "ISO/IEC 14443-3 (Type A) compatible\nISO/IEC 14443-2 (Type A) compatible";
            if (this.f537q == C0323v.MF_PLUS_X) {
                charSequence = "ISO/IEC 14443-4 (Type A) compatible\n" + charSequence;
            }
            c0200d.m238a(charSequence);
            C0369v.m1099a(this.f523c, f520s, c0200d);
        } else {
            String str = "ISO/IEC 14443-3 (Type B) compatible\nISO/IEC 14443-2 (Type B) compatible";
            c0200d.m238a((CharSequence) "ISO/IEC 14443-3 (Type B) compatible\nISO/IEC 14443-2 (Type B) compatible");
            C0369v.m1101a(this.f532l, c0200d);
        }
        if (this.f526f != null) {
            c0200d.m237a(this.f526f);
        } else if (this.f530j.m56n() && this.f535o != null && !this.f530j.m68z()) {
            C0182c c0182c = new C0182c();
            c0182c.m147a(new C0193o(m529m()));
            c0200d.m237a(c0182c);
        }
    }

    public boolean m534a() {
        boolean z = false;
        if (this.f536p) {
            return false;
        }
        switch (C0321t.f911a[this.f537q.ordinal()]) {
            case C0086R.styleable.SherlockTheme_actionModeCloseButtonStyle /*13*/:
            case C0086R.styleable.SherlockTheme_actionModeSplitBackground /*15*/:
            case C0086R.styleable.SherlockTheme_actionModePopupWindowStyle /*18*/:
                return true;
            case C0086R.styleable.SherlockTheme_buttonStyleSmall /*19*/:
                return this.f535o.f481c == ar.NXP;
            default:
                if (this.f535o != null) {
                    return true;
                }
                boolean z2 = C0355h.m1065a(this.f524d.getId(), C0360m.ISO14443_A) && (this.f538r == C0322u.UNKNOWN || this.f538r == C0322u.NXP);
                if (!(z2 && this.f524d.getId().length == 4 && this.f537q == C0323v.UNKNOWN && !this.f534n) && z2) {
                    z = true;
                }
                return z;
        }
    }

    protected byte[] m535a(int i) {
        return this.f523c.transceive(new byte[]{(byte) 48, (byte) i});
    }

    protected void m536b(int i) {
        try {
            this.f523c.transceive(new byte[]{(byte) i, (byte) 0, (byte) 0, (byte) 0});
            throw new IOException("Sector Select part 2 failed");
        } catch (TagLostException e) {
            if (this.f523c.transceive(new byte[]{(byte) -62, (byte) -1}).length != 1) {
                throw new IOException("Sector Select part 1 failed");
            }
        }
    }

    public boolean m537b() {
        return this.f533m;
    }

    protected C0182c m538c(int i) {
        C0182c c0182c = new C0182c();
        try {
            byte[] a = m535a(0);
            if (a == null || a.length < 16) {
                throw new IOException();
            }
            String str;
            int i2;
            int i3;
            byte b = a[10];
            byte b2 = a[11];
            if (this.f525e.booleanValue()) {
                c0182c.m147a(new C0195p(0, "*", Arrays.copyOfRange(a, 0, 4)));
                c0182c.m147a(new C0195p(1, "*", Arrays.copyOfRange(a, 4, 8)));
            } else {
                c0182c.m147a(new C0183d(0, 2, BuildConfig.VERSION_NAME, Arrays.copyOfRange(a, 0, 4)));
                c0182c.m147a(new C0183d(1, 2, BuildConfig.VERSION_NAME, Arrays.copyOfRange(a, 4, 8)));
            }
            if (this.f525e.booleanValue()) {
                str = (b & 7) == 7 ? "*" : (b == null && b2 == null) ? "." : (b & 7) == 0 ? "+" : "x";
                c0182c.m147a(new C0195p(2, str, Arrays.copyOfRange(a, 8, 12)));
                str = (b & 8) != 0 ? (b & 1) != 0 ? "*" : "x" : (b & 1) != 0 ? "+" : ".";
                c0182c.m147a(new C0195p(3, str, Arrays.copyOfRange(a, 12, 16)));
            } else {
                c0182c.m147a(new C0183d(2, 2, BuildConfig.VERSION_NAME, Arrays.copyOfRange(a, 8, 12)));
                c0182c.m147a(new C0183d(3, 2, BuildConfig.VERSION_NAME, Arrays.copyOfRange(a, 12, 16)));
            }
            for (i2 = 1; i2 < 4; i2++) {
                String[] a2 = C0253s.m522a(i2, b, b2);
                byte[] a3 = m535a(i2 * 4);
                if (a3.length >= 16) {
                    for (i3 = 0; i3 < a3.length; i3 += 4) {
                        str = BuildConfig.VERSION_NAME;
                        if (this.f525e.booleanValue()) {
                            str = a2[i3 / 4];
                        }
                        c0182c.m147a(new C0183d((i2 * 4) + (i3 / 4), 2, str, Arrays.copyOfRange(a3, i3, i3 + 4)));
                    }
                }
            }
            if (i > 48) {
                try {
                    int i4 = (i / 4) + 4;
                    int i5 = 16;
                    int i6 = 0;
                    while (i5 < i4) {
                        if (i5 % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY == 0) {
                            i6++;
                            m536b(i6);
                            i2 = i6;
                        } else {
                            i2 = i6;
                        }
                        byte[] a4 = m535a(i5);
                        if (a4.length >= 16) {
                            i3 = 0;
                            while (i3 < a4.length && (i3 / 4) + i5 < i4) {
                                if (this.f525e.booleanValue()) {
                                    str = " ";
                                } else {
                                    try {
                                        str = BuildConfig.VERSION_NAME;
                                    } catch (TagLostException e) {
                                        this.f533m = true;
                                        c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "<aborted: tag disappeared>")));
                                    } catch (IOException e2) {
                                        c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "<aborted: read error>")));
                                    }
                                }
                                c0182c.m147a(new C0183d((i3 / 4) + i5, 2, str, Arrays.copyOfRange(a4, i3, i3 + 4)));
                                i3 += 4;
                            }
                        }
                        i5 += 4;
                        i6 = i2;
                    }
                } catch (IOException e3) {
                    throw new TagLostException("SectorSelect failed");
                } catch (TagLostException e4) {
                    this.f523c.close();
                    this.f523c.connect();
                    m535a(0);
                    c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "<memory probably ends here>")));
                } catch (IOException e22) {
                    c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "<aborted: read error>")));
                }
            }
            if (this.f525e.booleanValue()) {
                c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "\n\n  *:locked & blocked, x:locked,\n  +:blocked, .:un(b)locked")));
            }
            return c0182c;
        } catch (TagLostException e5) {
            this.f533m = true;
            c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "<aborted: tag disappeared>")));
        } catch (IOException e222) {
            c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "<aborted: read error>")));
        }
    }

    public byte[] m539c() {
        return this.f524d.getId();
    }

    public String m540d() {
        if (this.f537q == C0323v.MF_PLUS_X || this.f537q == C0323v.MF_PLUS_ENGINEERING) {
            short sak = this.f523c.getSak();
            if (sak == (short) 16) {
                return "MF1PLUS60";
            }
            if (sak == (short) 17) {
                return "MF1PLUS80";
            }
            switch (C0321t.f912b[this.f535o.f480b.ordinal()]) {
                case C0519c.Switch_track /*1*/:
                    return "MF1PLUS60 ";
                case C0519c.Switch_textOn /*2*/:
                    return "MF1PLUS80 ";
            }
        }
        if (this.f537q == C0323v.MF_PLUS_S) {
            switch (C0321t.f912b[this.f535o.f480b.ordinal()]) {
                case C0519c.Switch_track /*1*/:
                    return "MF1SPLUS60 ";
                case C0519c.Switch_textOn /*2*/:
                    return "MF1SPLUS80 ";
            }
        }
        if (this.f535o != null) {
            return ag.m454a(this.f535o, at.NONE, this.f524d.getId(), null, this.f536p);
        }
        switch (C0321t.f911a[this.f537q.ordinal()]) {
            case C0519c.Switch_textOn /*2*/:
                return "SLE66R01P(N)";
            case C0086R.styleable.SherlockTheme_actionMenuTextColor /*11*/:
                return "SLE66RxxS";
            case C0086R.styleable.SherlockTheme_actionModeStyle /*12*/:
                return "SLE66RxxP";
            case C0086R.styleable.SherlockTheme_actionModeCloseButtonStyle /*13*/:
                return "MF1ICL10";
            case C0086R.styleable.SherlockTheme_actionModePopupWindowStyle /*18*/:
                return "TNP3xxx";
            case C0086R.styleable.SherlockTheme_selectableItemBackground /*20*/:
                return "SHC1101";
            case C0086R.styleable.SherlockTheme_windowContentOverlay /*21*/:
                return "SHC1102";
            case C0086R.styleable.SherlockTheme_textAppearanceLargePopupMenu /*22*/:
                return "FM1208";
            case C0086R.styleable.SherlockTheme_textAppearanceSmallPopupMenu /*23*/:
                return "FM1208SH01";
            default:
                return null;
        }
    }

    protected C0182c m541e() {
        if (this.f538r == C0322u.INFINEON) {
            return m528l();
        }
        byte[] j = m526j();
        int i = (this.f525e.booleanValue() || j[0] == -31) ? ((j[2] & MotionEventCompat.ACTION_MASK) * 8) + 16 : AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT;
        return m538c(i);
    }

    protected String m542f() {
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        if (this.f528h == null || this.f528h[0] != -31 || this.f528h.length < 4) {
            return null;
        }
        int i = this.f528h[2] & MotionEventCompat.ACTION_MASK;
        int i2 = this.f528h[3] & MotionEventCompat.ACTION_MASK;
        stringBuilder.append(String.format("Mapping version: %d.%d", new Object[]{Integer.valueOf((r0 >>> 4) & 15), Integer.valueOf((this.f528h[1] & MotionEventCompat.ACTION_MASK) & 15)}));
        if (1 != (((this.f528h[1] & MotionEventCompat.ACTION_MASK) >>> 4) & 15)) {
            stringBuilder.append(" (ERROR)\n");
        } else {
            stringBuilder.append("\n");
        }
        stringBuilder.append(String.format("Maximum NDEF data size: %d bytes", new Object[]{Integer.valueOf(i * 8)}));
        stringBuilder.append(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(i)}));
        stringBuilder.append("\nNDEF access: ");
        if (i2 == 0) {
            stringBuilder.append(C0429j.m1391a((CharSequence) "Read & Write"));
        } else if (i2 == 15) {
            stringBuilder.append("Read-Only");
        } else {
            stringBuilder.append("[unknown]");
        }
        stringBuilder.append(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(i2)}));
        return stringBuilder.toString();
    }

    public boolean m543g() {
        return this.f540u;
    }
}
