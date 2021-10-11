package com.nxp.taginfolite.p009e;

import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.NfcA;
import android.support.v4.BuildConfig;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.p003g.C0422a;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0351d;
import com.nxp.taginfolite.p004f.C0354g;
import com.nxp.taginfolite.p004f.C0355h;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.C0360m;
import com.nxp.taginfolite.p004f.C0361n;
import com.nxp.taginfolite.p004f.C0362o;
import com.nxp.taginfolite.p004f.C0369v;
import com.nxp.taginfolite.p004f.C0372z;
import com.nxp.taginfolite.p004f.p019d.C0347a;
import com.nxp.taginfolite.p004f.p019d.C0349c;
import com.nxp.taginfolite.p004f.p019d.C0350d;
import com.nxp.taginfolite.p005b.C0182c;
import com.nxp.taginfolite.p005b.C0191l;
import com.nxp.taginfolite.p005b.C0192m;
import com.nxp.taginfolite.p005b.C0194n;
import com.nxp.taginfolite.p006c.C0197a;
import com.nxp.taginfolite.p006c.C0198b;
import com.nxp.taginfolite.p006c.C0199c;
import com.nxp.taginfolite.p006c.C0200d;
import com.nxp.taginfolite.p009e.p010a.C0244b;
import com.nxp.taginfolite.p009e.p010a.C0248f;
import com.nxp.taginfolite.p009e.p010a.C0250h;
import com.nxp.taginfolite.p009e.p014e.C0303k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.ag */
public final class ag implements ay {
    protected static final EnumMap f429a;
    protected static final EnumMap f430b;
    private static final List f431e;
    private static final EnumMap f432f;
    private static final List f433g;
    private static final EnumMap f434h;
    private static final EnumMap f435i;
    private static final EnumMap f436j;
    private boolean f437A;
    private aw f438B;
    private byte[] f439C;
    private byte[] f440D;
    private boolean f441E;
    private byte[] f442F;
    private byte[] f443G;
    private int f444H;
    public byte[][] f445c;
    public byte[] f446d;
    private final C0428i f447k;
    private final SparseArray f448l;
    private final SparseArray f449m;
    private as f450n;
    private at f451o;
    private boolean f452p;
    private Tag f453q;
    private MifareClassic f454r;
    private NfcA f455s;
    private boolean f456t;
    private boolean f457u;
    private C0350d f458v;
    private ArrayList f459w;
    private C0158a f460x;
    private boolean f461y;
    private C0182c f462z;

    static {
        f431e = new ah();
        f432f = new ai(au.class);
        f429a = new aj(au.class);
        f430b = new ak(av.class);
        f433g = new al();
        f434h = new am(aw.class);
        f435i = new an(at.class);
        f436j = new ao(ar.class);
    }

    public ag() {
        this.f447k = new C0428i();
        this.f448l = new SparseArray();
        this.f449m = new SparseArray();
        this.f445c = (byte[][]) null;
        this.f453q = null;
        this.f454r = null;
        this.f455s = null;
        this.f456t = false;
        this.f457u = false;
        this.f458v = null;
        this.f459w = null;
        this.f460x = null;
        this.f461y = false;
        this.f462z = null;
        this.f437A = false;
        this.f439C = null;
        this.f440D = null;
        this.f441E = false;
        this.f442F = null;
        this.f443G = null;
        this.f444H = 0;
        this.f446d = null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.nxp.taginfolite.p009e.ag m453a(android.nfc.Tag r6, android.nfc.tech.MifareClassic r7, boolean r8, com.nxp.taginfolite.C0158a r9, boolean r10) {
        /*
        r5 = 1;
        r1 = new com.nxp.taginfolite.e.ag;
        r1.<init>();
        r0 = android.nfc.tech.NfcA.get(r6);
        r1.f454r = r7;
        r1.f453q = r6;
        r1.f455s = r0;
        r2 = com.nxp.taginfolite.p009e.ag.m464c(r0);
        r1.f450n = r2;
        r2 = com.nxp.taginfolite.p009e.at.UNKNOWN;
        r1.f451o = r2;
        r0 = com.nxp.taginfolite.p009e.ag.m461b(r0);
        r1.f452p = r0;
        r1.f460x = r9;
        r1.f461y = r8;
        r0 = com.nxp.taginfolite.p009e.aw.NONE;
        r1.f438B = r0;
        r0 = r1.f450n;
        r0 = r0.f479a;
        r2 = com.nxp.taginfolite.p009e.av.UNKNOWN;
        if (r0 != r2) goto L_0x0032;
    L_0x0030:
        r0 = r1;
    L_0x0031:
        return r0;
    L_0x0032:
        if (r10 == 0) goto L_0x0036;
    L_0x0034:
        r1.f452p = r5;
    L_0x0036:
        r7.connect();	 Catch:{ TagLostException -> 0x0044, IOException -> 0x0049 }
        r0 = r7.isConnected();	 Catch:{ TagLostException -> 0x0044, IOException -> 0x0049 }
        if (r0 != 0) goto L_0x004c;
    L_0x003f:
        r0 = 1;
        r1.f456t = r0;	 Catch:{ TagLostException -> 0x0044, IOException -> 0x0049 }
        r0 = r1;
        goto L_0x0031;
    L_0x0044:
        r0 = move-exception;
        r1.f456t = r5;
        r0 = r1;
        goto L_0x0031;
    L_0x0049:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0031;
    L_0x004c:
        r0 = r1.f450n;
        r0 = r0.f479a;
        r2 = com.nxp.taginfolite.p009e.av.CLASSIC;
        if (r0 == r2) goto L_0x0060;
    L_0x0054:
        r2 = com.nxp.taginfolite.p009e.av.PLUS;
        if (r0 == r2) goto L_0x0060;
    L_0x0058:
        r2 = com.nxp.taginfolite.p009e.av.PRO;
        if (r0 == r2) goto L_0x0060;
    L_0x005c:
        r2 = com.nxp.taginfolite.p009e.av.TNP;
        if (r0 != r2) goto L_0x00a2;
    L_0x0060:
        r1.m468l();	 Catch:{ TagLostException -> 0x00b8 }
        r1.m469m();	 Catch:{ TagLostException -> 0x00b8 }
        if (r10 != 0) goto L_0x0098;
    L_0x0068:
        r2 = 1;
        r2 = new byte[r2];	 Catch:{ IOException -> 0x00af }
        r3 = 0;
        r4 = 98;
        r2[r3] = r4;	 Catch:{ IOException -> 0x00af }
        r3 = r1.f454r;	 Catch:{ IOException -> 0x00af }
        r2 = r3.transceive(r2);	 Catch:{ IOException -> 0x00af }
        r1.f443G = r2;	 Catch:{ IOException -> 0x00af }
        r2 = r1.f443G;	 Catch:{ IOException -> 0x00af }
        r2 = com.nxp.taginfolite.p004f.C0372z.m1116b(r2);	 Catch:{ IOException -> 0x00af }
        if (r2 == 0) goto L_0x0094;
    L_0x0080:
        r2 = r1.f443G;	 Catch:{ IOException -> 0x00af }
        r3 = 2;
        r2 = r2[r3];	 Catch:{ IOException -> 0x00af }
        r2 = r2 & 255;
        switch(r2) {
            case 5: goto L_0x00a8;
            default: goto L_0x008a;
        };	 Catch:{ IOException -> 0x00af }
    L_0x008a:
        r2 = r1.f443G;	 Catch:{ IOException -> 0x00af }
        r3 = 6;
        r2 = r2[r3];	 Catch:{ IOException -> 0x00af }
        r2 = r2 & 255;
        switch(r2) {
            case 19: goto L_0x00bc;
            case 20: goto L_0x0094;
            case 21: goto L_0x00b1;
            default: goto L_0x0094;
        };	 Catch:{ IOException -> 0x00af }
    L_0x0094:
        r2 = r1.f450n;	 Catch:{ IOException -> 0x00af }
        r0 = r2.f479a;	 Catch:{ IOException -> 0x00af }
    L_0x0098:
        r2 = r1.f454r;	 Catch:{ IOException -> 0x017f }
        r2.close();	 Catch:{ IOException -> 0x017f }
        r2 = r1.f454r;	 Catch:{ IOException -> 0x017f }
        r2.connect();	 Catch:{ IOException -> 0x017f }
    L_0x00a2:
        r2 = r1.f456t;
        if (r2 == 0) goto L_0x00c3;
    L_0x00a6:
        r0 = r1;
        goto L_0x0031;
    L_0x00a8:
        r2 = r1.f450n;	 Catch:{ IOException -> 0x00af }
        r3 = com.nxp.taginfolite.p009e.av.TNP_I2C;	 Catch:{ IOException -> 0x00af }
        r2.f479a = r3;	 Catch:{ IOException -> 0x00af }
        goto L_0x008a;
    L_0x00af:
        r2 = move-exception;
        goto L_0x0098;
    L_0x00b1:
        r2 = r1.f450n;	 Catch:{ IOException -> 0x00af }
        r3 = com.nxp.taginfolite.p009e.au.TwoK;	 Catch:{ IOException -> 0x00af }
        r2.f480b = r3;	 Catch:{ IOException -> 0x00af }
        goto L_0x0094;
    L_0x00b8:
        r2 = move-exception;
        r1.f456t = r5;
        goto L_0x00a2;
    L_0x00bc:
        r2 = r1.f450n;	 Catch:{ IOException -> 0x00af }
        r3 = com.nxp.taginfolite.p009e.au.OneK;	 Catch:{ IOException -> 0x00af }
        r2.f480b = r3;	 Catch:{ IOException -> 0x00af }
        goto L_0x0094;
    L_0x00c3:
        r2 = com.nxp.taginfolite.p009e.av.UNKNOWN;
        if (r0 == r2) goto L_0x0107;
    L_0x00c7:
        r2 = com.nxp.taginfolite.p009e.av.TNP;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        if (r0 != r2) goto L_0x010d;
    L_0x00cb:
        r0 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        r0 = r1.m492a(r0);	 Catch:{ IOException -> 0x017c, TagLostException -> 0x0118 }
        if (r0 == 0) goto L_0x00f4;
    L_0x00d3:
        r2 = r0.length;	 Catch:{ IOException -> 0x017c, TagLostException -> 0x0118 }
        r3 = 16;
        if (r2 != r3) goto L_0x00f4;
    L_0x00d8:
        r2 = r1.f450n;	 Catch:{ IOException -> 0x017c, TagLostException -> 0x0118 }
        r3 = com.nxp.taginfolite.p009e.av.TNP_I2C;	 Catch:{ IOException -> 0x017c, TagLostException -> 0x0118 }
        r2.f479a = r3;	 Catch:{ IOException -> 0x017c, TagLostException -> 0x0118 }
        r2 = r1.f443G;	 Catch:{ IOException -> 0x017c, TagLostException -> 0x0118 }
        if (r2 != 0) goto L_0x00e8;
    L_0x00e2:
        r2 = r1.f450n;	 Catch:{ IOException -> 0x017c, TagLostException -> 0x0118 }
        r3 = com.nxp.taginfolite.p009e.au.UNKNOWN;	 Catch:{ IOException -> 0x017c, TagLostException -> 0x0118 }
        r2.f480b = r3;	 Catch:{ IOException -> 0x017c, TagLostException -> 0x0118 }
    L_0x00e8:
        r2 = 2;
        r2 = new byte[r2][];	 Catch:{ IOException -> 0x017c, TagLostException -> 0x0118 }
        r3 = 0;
        r4 = 0;
        r2[r3] = r4;	 Catch:{ IOException -> 0x017c, TagLostException -> 0x0118 }
        r3 = 1;
        r2[r3] = r0;	 Catch:{ IOException -> 0x017c, TagLostException -> 0x0118 }
        r1.f445c = r2;	 Catch:{ IOException -> 0x017c, TagLostException -> 0x0118 }
    L_0x00f4:
        if (r10 != 0) goto L_0x00fe;
    L_0x00f6:
        r1.m465c(r8);	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r0 = r1.f442F;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        com.nxp.taginfolite.p009e.p010a.C0243a.m381b(r1, r0);	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
    L_0x00fe:
        r0 = r9.m56n();	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        if (r0 == 0) goto L_0x0107;
    L_0x0104:
        r1.m480x();	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
    L_0x0107:
        r7.close();	 Catch:{ IOException -> 0x017a }
    L_0x010a:
        r0 = r1;
        goto L_0x0031;
    L_0x010d:
        r2 = com.nxp.taginfolite.p009e.av.TNP_I2C;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        if (r0 != r2) goto L_0x011c;
    L_0x0111:
        r0 = com.nxp.taginfolite.p009e.p010a.C0251i.m396a(r1);	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r1.f445c = r0;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        goto L_0x00f4;
    L_0x0118:
        r0 = move-exception;
        r1.f456t = r5;
        goto L_0x0107;
    L_0x011c:
        r0 = r1.m478v();	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r1.f457u = r0;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r0 = r1.f457u;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        if (r0 == 0) goto L_0x0134;
    L_0x0126:
        r0 = r1.m476t();	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r1.f458v = r0;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        if (r8 == 0) goto L_0x0134;
    L_0x012e:
        r0 = r1.m477u();	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r1.f459w = r0;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
    L_0x0134:
        r0 = r1.f450n;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r0 = r0.f480b;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r2 = com.nxp.taginfolite.p009e.au.FourK;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        if (r0 != r2) goto L_0x0145;
    L_0x013c:
        r2 = r1.f447k;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r3 = r1.m471o();	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r2.m1384a(r3);	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
    L_0x0145:
        r2 = com.nxp.taginfolite.p009e.au.OneK;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        if (r0 != r2) goto L_0x016d;
    L_0x0149:
        r0 = r1.f447k;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r2 = r1.m470n();	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r0.m1384a(r2);	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r0 = r1.f447k;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r2 = r1.m472p();	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r0.m1384a(r2);	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r0 = r1.f447k;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r2 = r1.m474r();	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r0.m1384a(r2);	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r0 = r1.f447k;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r2 = r1.m475s();	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r0.m1384a(r2);	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
    L_0x016d:
        r0 = r1.f447k;	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r2 = r1.m473q();	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        r0.m1384a(r2);	 Catch:{ TagLostException -> 0x0118, IOException -> 0x0178 }
        goto L_0x00f4;
    L_0x0178:
        r0 = move-exception;
        goto L_0x0107;
    L_0x017a:
        r0 = move-exception;
        goto L_0x010a;
    L_0x017c:
        r0 = move-exception;
        goto L_0x00f4;
    L_0x017f:
        r2 = move-exception;
        goto L_0x00a2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.e.ag.a(android.nfc.Tag, android.nfc.tech.MifareClassic, boolean, com.nxp.taginfolite.a, boolean):com.nxp.taginfolite.e.ag");
    }

    public static String m454a(as asVar, at atVar, byte[] bArr, byte[] bArr2, boolean z) {
        String b = C0355h.m1067b(bArr, C0360m.MIFARE);
        ar arVar = asVar.f481c;
        au auVar = asVar.f480b;
        int i = bArr.length == 4 ? 1 : 0;
        int i2 = (arVar == ar.FUDAN || arVar == ar.HUAHONG || arVar == ar.QUANRAY || z) ? 0 : 1;
        if ((arVar == ar.NXP || "NXP Semiconductors".equals(b)) && i2 != 0) {
            switch (ap.f465c[asVar.f479a.ordinal()]) {
                case C0519c.Switch_track /*1*/:
                    if (bArr.length == 4 && (bArr[0] & 15) != 15 && bArr[0] == (byte) 8) {
                    }
                    switch (ap.f463a[auVar.ordinal()]) {
                        case C0519c.Switch_track /*1*/:
                            return "MF1S00";
                        case C0519c.Switch_textOn /*2*/:
                            return "MF1S20";
                        case C0519c.Switch_textOff /*3*/:
                            return "MF1S20 or MF1S00";
                        case C0519c.Switch_thumbTextPadding /*4*/:
                            return "MF1S50";
                        case C0519c.Switch_switchTextAppearance /*5*/:
                            return "MF1S60";
                        case C0519c.Switch_switchMinWidth /*6*/:
                            return "MF1S70";
                        default:
                            break;
                    }
                case C0519c.Switch_textOn /*2*/:
                    switch (ap.f464b[atVar.ordinal()]) {
                        case C0519c.Switch_track /*1*/:
                            switch (ap.f463a[auVar.ordinal()]) {
                                case C0519c.Switch_switchTextAppearance /*5*/:
                                    return "MF1SPLUS60 ";
                                case C0519c.Switch_switchMinWidth /*6*/:
                                    return "MF1SPLUS80 ";
                                default:
                                    break;
                            }
                        case C0519c.Switch_textOn /*2*/:
                            switch (ap.f463a[auVar.ordinal()]) {
                                case C0519c.Switch_switchTextAppearance /*5*/:
                                    return "MF1PLUS60 ";
                                case C0519c.Switch_switchMinWidth /*6*/:
                                    return "MF1PLUS80 ";
                                default:
                                    break;
                            }
                        default:
                            switch (ap.f463a[auVar.ordinal()]) {
                                case C0519c.Switch_switchTextAppearance /*5*/:
                                    return "MF1SPLUS60 or MF1PLUS60 ";
                                case C0519c.Switch_switchMinWidth /*6*/:
                                    return "MF1SPLUS80 or MF1PLUS80 ";
                                default:
                                    break;
                            }
                    }
                case C0519c.Switch_textOff /*3*/:
                    switch (ap.f463a[auVar.ordinal()]) {
                        case C0519c.Switch_thumbTextPadding /*4*/:
                            return "MF2ICD81";
                        case C0519c.Switch_switchMinWidth /*6*/:
                            return "MF2ICD84";
                        default:
                            break;
                    }
                case C0519c.Switch_thumbTextPadding /*4*/:
                    return asVar.f483e ? i != 0 ? "TNP3330" : "TNP3300" : "TNP3xxx";
                case C0519c.Switch_switchTextAppearance /*5*/:
                    return i != 0 ? "TNPP3330" : "TNPP3300";
                case C0519c.Switch_switchMinWidth /*6*/:
                    switch (ap.f463a[auVar.ordinal()]) {
                        case C0519c.Switch_thumbTextPadding /*4*/:
                            return "TNPI32xx";
                        case C0519c.Switch_switchTextAppearance /*5*/:
                            return "TNPI62xx";
                        case C0519c.Switch_switchPadding /*7*/:
                            return "TNPIx2xx";
                        default:
                            break;
                    }
            }
        } else if ((arVar == ar.INFINEON || "Infineon Technologies AG".equals(b)) && i2 != 0) {
            if (bArr.length == 4) {
                if (auVar == au.OneK) {
                    if ((bArr[0] & 15) != 15 && bArr[0] != (byte) 8) {
                        return (bArr[0] & 15) == 1 ? "SLE66R35R" : "SLE66R35";
                    } else {
                        if ((bArr[0] & 15) != 15) {
                            return "SLE66R35I";
                        }
                    }
                }
            } else if (bArr.length == 7 && auVar == au.OneK) {
                return "SLE66R35E7";
            }
        } else if (i2 == 0 && arVar != null) {
            switch (ap.f466d[arVar.ordinal()]) {
                case C0519c.Switch_track /*1*/:
                    return auVar == au.OneK ? "FM11RF08" : "FM11RF32";
                case C0519c.Switch_textOn /*2*/:
                    return auVar == au.OneK ? "SHC1104" : BuildConfig.VERSION_NAME;
                case C0519c.Switch_textOff /*3*/:
                    return auVar == au.OneK ? "IS23SC4439" : "IS23SC4469";
                default:
                    return BuildConfig.VERSION_NAME;
            }
        }
        return null;
    }

    private static String m455a(String[] strArr, int i, int i2) {
        return (i == 0 && i2 == 0) ? strArr[i2 % 4].charAt(0) + "--" : i < 32 ? strArr[i2 % 4] : strArr[(i2 % 16) / 5];
    }

    public static boolean m456a(NfcA nfcA) {
        switch (nfcA.getSak()) {
            case C0519c.Switch_track /*1*/:
            case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
            case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
            case C0086R.styleable.SherlockTheme_textAppearanceSmall /*24*/:
            case C0086R.styleable.SherlockTheme_textColorPrimary /*25*/:
            case C0086R.styleable.SherlockTheme_textColorSearchUrl /*40*/:
            case C0086R.styleable.SherlockTheme_dropdownListPreferredItemHeight /*56*/:
            case (short) 136:
            case (short) 152:
            case (short) 184:
                return true;
            default:
                return false;
        }
    }

    public static boolean m457a(String str) {
        return f433g.contains(str) || f431e.contains(str);
    }

    public static boolean m458a(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            return false;
        }
        boolean z = true;
        for (int i = 0; i < 4 && z; i++) {
            z = bArr[i] == bArr[i + 8] && (bArr[i] & MotionEventCompat.ACTION_MASK) == ((bArr[i + 4] ^ -1) & MotionEventCompat.ACTION_MASK);
        }
        return z && bArr[12] == bArr[14] && bArr[13] == bArr[15] && (bArr[12] & MotionEventCompat.ACTION_MASK) == ((bArr[13] ^ -1) & MotionEventCompat.ACTION_MASK);
    }

    private static byte[] m459a(MifareClassic mifareClassic) {
        TagLostException e;
        Throwable th;
        byte[] bArr;
        Object obj = 1;
        Object obj2 = null;
        byte[] bArr2 = new byte[]{(byte) -32, Byte.MIN_VALUE};
        try {
            mifareClassic.close();
            mifareClassic.connect();
            try {
                bArr2 = mifareClassic.transceive(bArr2);
                try {
                    mifareClassic.transceive(new byte[]{(byte) -62});
                    mifareClassic.close();
                    mifareClassic.connect();
                } catch (TagLostException e2) {
                    throw e2;
                } catch (IOException e3) {
                }
            } catch (TagLostException e4) {
                e2 = e4;
                try {
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e5) {
                obj2 = 1;
                bArr2 = null;
                try {
                    bArr = new byte[]{(byte) -62};
                    if (obj2 == null) {
                        mifareClassic.transceive(bArr);
                        mifareClassic.close();
                        mifareClassic.connect();
                    } else {
                        mifareClassic.connect();
                    }
                } catch (TagLostException e22) {
                    throw e22;
                } catch (IOException e6) {
                }
                return bArr2;
            }
        } catch (TagLostException e7) {
            e22 = e7;
            obj = null;
            throw e22;
        } catch (IOException e8) {
            bArr2 = null;
            bArr = new byte[]{(byte) -62};
            if (obj2 == null) {
                mifareClassic.connect();
            } else {
                mifareClassic.transceive(bArr);
                mifareClassic.close();
                mifareClassic.connect();
            }
            return bArr2;
        } catch (Throwable th3) {
            th = th3;
            obj = null;
            try {
                byte[] bArr3 = new byte[]{(byte) -62};
                if (obj != null) {
                    mifareClassic.transceive(bArr3);
                    mifareClassic.close();
                    mifareClassic.connect();
                } else {
                    mifareClassic.connect();
                }
            } catch (TagLostException e222) {
                throw e222;
            } catch (IOException e9) {
            }
            throw th;
        }
        return bArr2;
    }

    public static int m460b(byte[] bArr) {
        long a = C0429j.m1390a((byte) (bArr[3] & TransportMediator.KEYCODE_MEDIA_PAUSE), bArr[2], bArr[1], bArr[0]);
        if ((bArr[3] & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0) {
            a -= -2147483648L;
        }
        return (int) a;
    }

    public static boolean m461b(NfcA nfcA) {
        switch (nfcA.getSak()) {
            case C0086R.styleable.SherlockTheme_textColorSearchUrl /*40*/:
            case C0086R.styleable.SherlockTheme_dropdownListPreferredItemHeight /*56*/:
            case (short) 184:
                return true;
            default:
                return false;
        }
    }

    public static boolean m462b(String str) {
        return f431e.contains(str);
    }

    private byte[] m463b(int i) {
        try {
            byte[] readBlock = this.f454r.readBlock(i);
            return (readBlock == null || readBlock.length != 1) ? readBlock : null;
        } catch (TagLostException e) {
            throw e;
        } catch (IOException e2) {
            return null;
        }
    }

    public static as m464c(NfcA nfcA) {
        as asVar = new as();
        short sak = nfcA.getSak();
        String b = C0355h.m1067b(nfcA.getTag().getId(), C0360m.MIFARE);
        switch (sak) {
            case C0519c.Switch_track /*1*/:
                asVar.f479a = av.TNP;
                asVar.f480b = au.OneK;
                asVar.f481c = ar.NXP;
                break;
            case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                asVar.f479a = av.CLASSIC;
                asVar.f480b = au.OneK;
                byte[] atqa = nfcA.getAtqa();
                if (atqa != null && atqa.length > 0 && atqa[0] == 64) {
                    asVar.f479a = av.PRO;
                }
                if ("NXP Semiconductors".equals(b)) {
                    asVar.f481c = ar.NXP;
                    break;
                }
                break;
            case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                asVar.f479a = av.CLASSIC;
                asVar.f480b = au.Mini;
                asVar.f481c = ar.NXP;
                break;
            case C0086R.styleable.SherlockTheme_textAppearanceSmall /*24*/:
                asVar.f479a = av.CLASSIC;
                asVar.f480b = au.FourK;
                break;
            case C0086R.styleable.SherlockTheme_textColorPrimary /*25*/:
                asVar.f479a = av.CLASSIC;
                asVar.f480b = au.TwoK;
                if ("NXP Semiconductors".equals(b)) {
                    asVar.f481c = ar.NXP;
                    break;
                }
                break;
            case C0086R.styleable.SherlockTheme_textColorSearchUrl /*40*/:
                asVar.f479a = av.CLASSIC;
                asVar.f480b = au.OneK;
                break;
            case C0086R.styleable.SherlockTheme_dropdownListPreferredItemHeight /*56*/:
                asVar.f479a = av.CLASSIC;
                asVar.f480b = au.FourK;
                asVar.f481c = ar.NXP;
                break;
            case (short) 136:
                asVar.f479a = av.CLASSIC;
                asVar.f480b = au.OneK;
                if ("Infineon Technologies AG".equals(b)) {
                    asVar.f481c = ar.INFINEON;
                    break;
                }
                break;
            case (short) 152:
            case (short) 184:
                asVar.f479a = av.PRO;
                asVar.f480b = au.FourK;
                asVar.f481c = ar.NXP;
                break;
        }
        return asVar;
    }

    private void m465c(boolean z) {
        byte[] readBlock;
        byte[] readBlock2;
        for (C0354g c0354g : C0244b.m386a(0, null, this.f448l, this.f450n, z, true)) {
            if (c0354g != null && c0354g.m1060a() != null && m491a(Integer.valueOf(0), c0354g.m1060a(), true)) {
                try {
                    readBlock = this.f454r.readBlock(0);
                    break;
                } catch (TagLostException e) {
                    this.f456t = true;
                    readBlock = null;
                } catch (IOException e2) {
                    readBlock = null;
                }
            }
        }
        readBlock = null;
        if (readBlock == null) {
            for (C0354g a : C0244b.m386a(0, null, this.f449m, this.f450n, z, false)) {
                if (m491a(Integer.valueOf(0), a.m1060a(), false)) {
                    try {
                        readBlock2 = this.f454r.readBlock(0);
                        break;
                    } catch (TagLostException e3) {
                        this.f456t = true;
                        readBlock2 = readBlock;
                    } catch (IOException e4) {
                        readBlock2 = readBlock;
                    }
                }
            }
        }
        readBlock2 = readBlock;
        if (readBlock2 == null) {
            try {
                this.f454r.close();
                this.f454r.connect();
                readBlock2 = this.f454r.readBlock(0);
            } catch (TagLostException e5) {
                this.f456t = true;
            } catch (IOException e6) {
            }
        }
        if (readBlock2 != null && readBlock2.length == 16) {
            this.f442F = Arrays.copyOf(readBlock2, readBlock2.length);
        }
    }

    private static String[] m466c(byte[] bArr) {
        if (bArr == null || bArr.length < 9) {
            return new String[]{"???", "???", "???", "???"};
        }
        String[] strArr = new String[]{"wrx", "wxx", "-rr", "WXW", "WRW", "-X-", "-R-", "-R-"};
        String[] strArr2 = new String[]{(byte) (bArr[6] ^ MotionEventCompat.ACTION_MASK), (byte) (bArr[7] ^ 15), r1[(((bArr[6] << 2) & 4) | ((bArr[8] << 1) & 2)) | (bArr[7] & 1)], new String[]{"rwi", "r-d", "r--", "RW-", "rW-", "R--", "rWI", "---"}[(((bArr[6] << 1) & 4) | (bArr[8] & 2)) | ((bArr[7] >> 1) & 1)]};
        strArr2[2] = new String[]{"rwi", "r-d", "r--", "RW-", "rW-", "R--", "rWI", "---"}[((bArr[6] & 4) | ((bArr[8] >> 1) & 2)) | ((bArr[7] >> 2) & 1)];
        strArr2[3] = strArr[(((bArr[6] >> 1) & 4) | ((bArr[8] >> 2) & 2)) | ((bArr[7] >> 3) & 1)];
        bArr[6] = (byte) (bArr[6] ^ MotionEventCompat.ACTION_MASK);
        bArr[7] = (byte) (bArr[7] ^ 15);
        return strArr2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m467k() {
        /*
        r7 = this;
        r3 = 0;
        r1 = 1;
        r2 = 0;
        r0 = r7.f453q;
        r0 = r0.getId();
        r0 = r0.length;
        r4 = 4;
        if (r0 != r4) goto L_0x0026;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        r4 = r7.f442F;
        if (r4 == 0) goto L_0x0031;
    L_0x0012:
        r4 = r7.f442F;
        r4 = r4.length;
        r5 = 16;
        if (r4 != r5) goto L_0x0031;
    L_0x0019:
        if (r0 == 0) goto L_0x0028;
    L_0x001b:
        r4 = r7.f442F;
        r5 = 8;
        r4 = r4[r5];
        r4 = r4 & 255;
    L_0x0023:
        if (r4 > 0) goto L_0x0034;
    L_0x0025:
        return r3;
    L_0x0026:
        r0 = r2;
        goto L_0x000e;
    L_0x0028:
        r4 = r7.f442F;
        r5 = 10;
        r4 = r4[r5];
        r4 = r4 & 255;
        goto L_0x0023;
    L_0x0031:
        r4 = r7.f444H;
        goto L_0x0023;
    L_0x0034:
        r5 = r7.f450n;
        r5 = r5.f480b;
        r6 = com.nxp.taginfolite.p009e.au.Mini;
        if (r5 != r6) goto L_0x0042;
    L_0x003c:
        switch(r4) {
            case 68: goto L_0x0044;
            case 69: goto L_0x004c;
            case 70: goto L_0x0054;
            case 71: goto L_0x005c;
            case 72: goto L_0x0064;
            case 100: goto L_0x009e;
            case 192: goto L_0x006c;
            case 193: goto L_0x0074;
            case 194: goto L_0x007c;
            case 199: goto L_0x00b4;
            case 200: goto L_0x00f3;
            case 224: goto L_0x00a1;
            case 225: goto L_0x00a4;
            case 226: goto L_0x008e;
            case 227: goto L_0x00ac;
            case 228: goto L_0x0096;
            default: goto L_0x003f;
        };
    L_0x003f:
        r0 = r3;
    L_0x0040:
        r3 = r0;
        goto L_0x0025;
    L_0x0042:
        r1 = r2;
        goto L_0x003c;
    L_0x0044:
        if (r1 == 0) goto L_0x0049;
    L_0x0046:
        r0 = "MF1ICS2003";
        goto L_0x0040;
    L_0x0049:
        r0 = "MF1ICS5003";
        goto L_0x0040;
    L_0x004c:
        if (r1 == 0) goto L_0x0051;
    L_0x004e:
        r0 = "MF1ICS2004";
        goto L_0x0040;
    L_0x0051:
        r0 = "MF1ICS5004";
        goto L_0x0040;
    L_0x0054:
        if (r1 == 0) goto L_0x0059;
    L_0x0056:
        r0 = "MF1ICS2005";
        goto L_0x0040;
    L_0x0059:
        r0 = "MF1ICS5005";
        goto L_0x0040;
    L_0x005c:
        if (r1 == 0) goto L_0x0061;
    L_0x005e:
        r0 = "MF1ICS2006";
        goto L_0x0040;
    L_0x0061:
        r0 = "MF1ICS5006";
        goto L_0x0040;
    L_0x0064:
        if (r1 == 0) goto L_0x0069;
    L_0x0066:
        r0 = "MF1ICS2007";
        goto L_0x0040;
    L_0x0069:
        r0 = "MF1ICS5007";
        goto L_0x0040;
    L_0x006c:
        if (r1 == 0) goto L_0x0071;
    L_0x006e:
        r0 = "MF1S2035";
        goto L_0x0040;
    L_0x0071:
        r0 = "MF1S5035";
        goto L_0x0040;
    L_0x0074:
        if (r1 == 0) goto L_0x0079;
    L_0x0076:
        r0 = "MF1S2037";
        goto L_0x0040;
    L_0x0079:
        r0 = "MF1S5037";
        goto L_0x0040;
    L_0x007c:
        if (r1 == 0) goto L_0x0086;
    L_0x007e:
        if (r0 == 0) goto L_0x0083;
    L_0x0080:
        r0 = "MF1S203xX";
        goto L_0x0040;
    L_0x0083:
        r0 = "MF1S200xX";
        goto L_0x0040;
    L_0x0086:
        if (r0 == 0) goto L_0x008b;
    L_0x0088:
        r0 = "MF1S503xX";
        goto L_0x0040;
    L_0x008b:
        r0 = "MF1S500xX";
        goto L_0x0040;
    L_0x008e:
        if (r0 == 0) goto L_0x0093;
    L_0x0090:
        r0 = "MF1S603xX";
        goto L_0x0040;
    L_0x0093:
        r0 = "MF1S6000X/V1";
        goto L_0x0040;
    L_0x0096:
        if (r0 == 0) goto L_0x009b;
    L_0x0098:
        r0 = "MF1S603xX/V1";
        goto L_0x0040;
    L_0x009b:
        r0 = "MF1S600xX/V1";
        goto L_0x0040;
    L_0x009e:
        r0 = "MF1ICS7001";
        goto L_0x0040;
    L_0x00a1:
        r0 = "MF1S7035";
        goto L_0x0040;
    L_0x00a4:
        if (r0 == 0) goto L_0x00a9;
    L_0x00a6:
        r0 = "MF1S703xX";
        goto L_0x0040;
    L_0x00a9:
        r0 = "MF1S700xX";
        goto L_0x0040;
    L_0x00ac:
        if (r0 == 0) goto L_0x00b1;
    L_0x00ae:
        r0 = "MF1S703xX/V1";
        goto L_0x0040;
    L_0x00b1:
        r0 = "MF1S700xX/V1";
        goto L_0x0040;
    L_0x00b4:
        r1 = com.nxp.taginfolite.p009e.ap.f463a;
        r2 = r7.f450n;
        r2 = r2.f480b;
        r2 = r2.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 2: goto L_0x00c5;
            case 3: goto L_0x00c3;
            case 4: goto L_0x00cf;
            default: goto L_0x00c3;
        };
    L_0x00c3:
        goto L_0x003f;
    L_0x00c5:
        if (r0 == 0) goto L_0x00cb;
    L_0x00c7:
        r0 = "MF1S2031X/V2";
        goto L_0x0040;
    L_0x00cb:
        r0 = "MF1S2001X/V2";
        goto L_0x0040;
    L_0x00cf:
        r1 = r7.f450n;
        r1 = r1.f479a;
        r2 = com.nxp.taginfolite.p009e.av.TNP;
        if (r1 != r2) goto L_0x00e1;
    L_0x00d7:
        if (r0 == 0) goto L_0x00dd;
    L_0x00d9:
        r0 = "TNP3330DX";
        goto L_0x0040;
    L_0x00dd:
        r0 = "TNP3300DX";
        goto L_0x0040;
    L_0x00e1:
        r1 = r7.f450n;
        r1 = r1.f479a;
        r2 = com.nxp.taginfolite.p009e.av.TNPP;
        if (r1 != r2) goto L_0x003f;
    L_0x00e9:
        if (r0 == 0) goto L_0x00ef;
    L_0x00eb:
        r0 = "TNPP3330DTL";
        goto L_0x0040;
    L_0x00ef:
        r0 = "TNPP3300DX";
        goto L_0x0040;
    L_0x00f3:
        r1 = com.nxp.taginfolite.p009e.ap.f463a;
        r4 = r7.f450n;
        r4 = r4.f480b;
        r4 = r4.ordinal();
        r1 = r1[r4];
        switch(r1) {
            case 1: goto L_0x0104;
            case 2: goto L_0x010e;
            case 3: goto L_0x0102;
            case 4: goto L_0x0118;
            case 5: goto L_0x0133;
            case 6: goto L_0x013d;
            default: goto L_0x0102;
        };
    L_0x0102:
        goto L_0x003f;
    L_0x0104:
        if (r0 == 0) goto L_0x010a;
    L_0x0106:
        r0 = "MF1S003xX/V1";
        goto L_0x0040;
    L_0x010a:
        r0 = "MF1S000xX/V1";
        goto L_0x0040;
    L_0x010e:
        if (r0 == 0) goto L_0x0114;
    L_0x0110:
        r0 = "MF1S203xX/V1";
        goto L_0x0040;
    L_0x0114:
        r0 = "MF1S200xX/V1";
        goto L_0x0040;
    L_0x0118:
        r1 = r7.f453q;
        r1 = r1.getId();
        r1 = r1[r2];
        r1 = r1 & 15;
        r2 = 5;
        if (r1 != r2) goto L_0x0129;
    L_0x0125:
        r0 = "MF1S506xX/V1";
        goto L_0x0040;
    L_0x0129:
        if (r0 == 0) goto L_0x012f;
    L_0x012b:
        r0 = "MF1S503xX/V1";
        goto L_0x0040;
    L_0x012f:
        r0 = "MF1S500xX/V1";
        goto L_0x0040;
    L_0x0133:
        if (r0 == 0) goto L_0x0139;
    L_0x0135:
        r0 = "MF1S603xX/V1";
        goto L_0x0040;
    L_0x0139:
        r0 = "MF1S600xX/V1";
        goto L_0x0040;
    L_0x013d:
        if (r0 == 0) goto L_0x0143;
    L_0x013f:
        r0 = "MF1S703xX/V1";
        goto L_0x0040;
    L_0x0143:
        r0 = "MF1S700xX/V1";
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.e.ag.k():java.lang.String");
    }

    private void m468l() {
        au auVar;
        ar arVar;
        Throwable th;
        ar arVar2;
        av avVar = this.f450n.f479a;
        au auVar2 = this.f450n.f480b;
        ar arVar3 = this.f450n.f481c;
        this.f439C = ag.m459a(this.f454r);
        if (!this.f454r.isConnected()) {
            this.f456t = true;
        }
        byte[] c = C0351d.m1042c(this.f439C);
        this.f440D = c;
        if (c != null) {
            if (Arrays.equals(c, ab.f400c)) {
                avVar = av.PLUS;
                this.f438B = aw.SL1;
                this.f451o = at.X;
                if (auVar2 == au.OneK) {
                    auVar2 = au.TwoK;
                }
                auVar = auVar2;
                arVar = ar.NXP;
            } else if (Arrays.equals(c, ab.f399b)) {
                avVar = av.PLUS;
                this.f438B = aw.SL1;
                this.f451o = at.S;
                if (auVar2 == au.OneK) {
                    auVar2 = au.TwoK;
                }
                auVar = auVar2;
                arVar = ar.NXP;
            } else if (Arrays.equals(c, ab.f398a)) {
                avVar = av.PLUS;
                this.f438B = aw.SL1;
                this.f451o = at.X;
                auVar = auVar2;
                arVar = ar.NXP;
            } else {
                this.f451o = at.NONE;
                ar arVar4 = arVar3;
                auVar = auVar2;
                arVar = arVar4;
            }
            if (this.f451o == at.NONE) {
                byte[] bArr = null;
                boolean isConnected;
                try {
                    byte[] bArr2 = new byte[]{(byte) 118, (byte) 4, (byte) -112};
                    this.f454r.close();
                    this.f454r.connect();
                    isConnected = this.f454r.isConnected();
                    try {
                        bArr = this.f454r.transceive(bArr2);
                        if (isConnected) {
                            try {
                                this.f454r.close();
                                this.f454r.connect();
                            } catch (TagLostException e) {
                                throw e;
                            } catch (IOException e2) {
                            }
                        } else {
                            this.f454r.connect();
                        }
                        if (isConnected && bArr != null && bArr.length == 17 && bArr[0] == (byte) -112) {
                            avVar = av.PLUS;
                            arVar = ar.NXP;
                            this.f438B = aw.SL1;
                            this.f451o = at.UNKNOWN;
                            if (auVar == au.OneK) {
                                auVar = au.TwoK;
                            }
                        }
                    } catch (IOException e3) {
                        if (isConnected) {
                            try {
                                this.f454r.close();
                                this.f454r.connect();
                            } catch (TagLostException e4) {
                                throw e4;
                            } catch (IOException e5) {
                            }
                        } else {
                            this.f454r.connect();
                        }
                        avVar = av.PLUS;
                        arVar = ar.NXP;
                        this.f438B = aw.SL1;
                        this.f451o = at.UNKNOWN;
                        if (auVar == au.OneK) {
                            auVar = au.TwoK;
                        }
                        this.f450n.f480b = auVar;
                        this.f450n.f479a = avVar;
                        this.f450n.f481c = arVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (isConnected) {
                            try {
                                this.f454r.close();
                                this.f454r.connect();
                            } catch (TagLostException e42) {
                                throw e42;
                            } catch (IOException e6) {
                            }
                        } else {
                            this.f454r.connect();
                        }
                        avVar = av.PLUS;
                        arVar2 = ar.NXP;
                        this.f438B = aw.SL1;
                        this.f451o = at.UNKNOWN;
                        if (auVar == au.OneK) {
                            auVar = au.TwoK;
                        }
                        throw th;
                    }
                } catch (IOException e7) {
                    isConnected = false;
                    if (isConnected) {
                        this.f454r.close();
                        this.f454r.connect();
                    } else {
                        this.f454r.connect();
                    }
                    if (isConnected && bArr != null && bArr.length == 17 && bArr[0] == (byte) -112) {
                        avVar = av.PLUS;
                        arVar = ar.NXP;
                        this.f438B = aw.SL1;
                        this.f451o = at.UNKNOWN;
                        if (auVar == au.OneK) {
                            auVar = au.TwoK;
                        }
                    }
                    this.f450n.f480b = auVar;
                    this.f450n.f479a = avVar;
                    this.f450n.f481c = arVar;
                } catch (Throwable th3) {
                    th = th3;
                    isConnected = false;
                    if (isConnected) {
                        this.f454r.close();
                        this.f454r.connect();
                    } else {
                        this.f454r.connect();
                    }
                    if (isConnected && bArr != null && bArr.length == 17 && bArr[0] == (byte) -112) {
                        avVar = av.PLUS;
                        arVar2 = ar.NXP;
                        this.f438B = aw.SL1;
                        this.f451o = at.UNKNOWN;
                        if (auVar == au.OneK) {
                            auVar = au.TwoK;
                        }
                    }
                    throw th;
                }
            }
        }
        arVar4 = arVar3;
        auVar = auVar2;
        arVar = arVar4;
        this.f450n.f480b = auVar;
        this.f450n.f479a = avVar;
        this.f450n.f481c = arVar;
    }

    private void m469m() {
        byte[][] a = C0250h.m394a(this.f454r);
        if (a != null && a.length >= 3 && a[0] != null && a[0].length >= 16) {
            this.f450n.f483e = true;
            byte[] bArr = a[0];
            if (this.f450n.f480b == au.Mini && bArr[15] == (byte) 1) {
                this.f450n.f480b = au.Bytes32;
            }
            if (this.f450n.f479a == av.TNP) {
                this.f444H = 199;
                if (bArr[15] == 4) {
                    this.f450n.f479a = av.TNPP;
                }
            } else if (this.f450n.f480b != au.Mini) {
                this.f444H = 200;
            }
            if (a[1] != null && a[2] != null && a[1].length >= 16 && a[2].length >= 16) {
                this.f446d = new byte[32];
                System.arraycopy(a[1], 0, this.f446d, 0, 16);
                System.arraycopy(a[2], 0, this.f446d, 16, 16);
            }
        }
    }

    private String m470n() {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        if (m491a(Integer.valueOf(6), C0244b.f366a, false)) {
            try {
                Object readBlock = this.f454r.readBlock(6);
                Object obj = new byte[8];
                if (readBlock != null && readBlock.length >= obj.length) {
                    System.arraycopy(readBlock, 0, obj, 0, obj.length);
                    if ("Stadspas".equals(new String(obj, C0429j.f1360a))) {
                        stringBuilder.append("Stadspas Eindhoven\n");
                        byte[] readBlock2 = this.f454r.readBlock(4);
                        stringBuilder.append(C0358k.f1076c).append("Pass no: ");
                        for (int i2 = 0; i2 < 8; i2++) {
                            stringBuilder.append(String.format("%c", new Object[]{Character.valueOf((char) readBlock2[i2])}));
                        }
                        if (m491a(Integer.valueOf(8), C0244b.f366a, false)) {
                            byte[] readBlock3 = this.f454r.readBlock(8);
                            stringBuilder.append("\n").append(C0358k.f1076c).append("BSN: ");
                            while (i < 9) {
                                stringBuilder.append(String.format("%c", new Object[]{Character.valueOf((char) readBlock3[i])}));
                                i++;
                            }
                        }
                    }
                }
            } catch (TagLostException e) {
                throw e;
            } catch (IOException e2) {
                return BuildConfig.VERSION_NAME;
            }
        }
        return stringBuilder.toString();
    }

    private String m471o() {
        byte[] bArr = new byte[]{(byte) -124, (byte) 0, (byte) 0, (byte) 0, (byte) 6, (byte) 3, (byte) -96, (byte) 0, (byte) 19, (byte) -82, (byte) -28};
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        if (m491a(Integer.valueOf(0), C0244b.f371f, true)) {
            try {
                byte[] readBlock = this.f454r.readBlock(1);
                if (!Arrays.equals(Arrays.copyOfRange(readBlock, 0, 11), bArr)) {
                    return BuildConfig.VERSION_NAME;
                }
                stringBuilder.append("OV-chipkaart (Dutch public transport card)\n");
                int i = this.f454r.readBlock(2)[2] & 15;
                if (i == 0) {
                    stringBuilder.append(C0358k.f1076c).append("Anonymous card\n");
                } else if (i == 2) {
                    stringBuilder.append(C0358k.f1076c).append("Personal card\n");
                } else {
                    stringBuilder.append(C0358k.f1076c).append("Unknown card type\n");
                }
                i = (((readBlock[11] & 3) * AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD) + ((readBlock[12] & MotionEventCompat.ACTION_MASK) * 16)) + ((readBlock[13] >>> 4) & 15);
                Calendar instance = Calendar.getInstance();
                instance.clear();
                instance.set(1, 1997);
                instance.set(6, i + 1);
                instance.set(12, 0);
                stringBuilder.append(String.format(C0358k.f1076c + "Valid until %02d-%02d-%02d", new Object[]{Integer.valueOf(instance.get(5)), Integer.valueOf(instance.get(2) + 1), Integer.valueOf(instance.get(1))}));
                stringBuilder.append(C0361n.f1092c);
            } catch (TagLostException e) {
                throw e;
            } catch (IOException e2) {
                return BuildConfig.VERSION_NAME;
            }
        }
        return stringBuilder.toString();
    }

    private String m472p() {
        C0428i c0428i = new C0428i();
        if (m491a(Integer.valueOf(41), C0244b.f374i, true)) {
            try {
                byte[] readBlock = this.f454r.readBlock(41);
                int a = C0429j.m1388a(readBlock[3], readBlock[4]);
                if (m491a(Integer.valueOf(4), C0244b.f375j, true)) {
                    c0428i.m1384a((CharSequence) "Kiev Metro card");
                    byte[] readBlock2 = this.f454r.readBlock(4);
                    c0428i.m1384a(String.format(C0358k.f1076c + "Card no: %02x%02x %02x%02x %02x%02x %02x%02x", new Object[]{Byte.valueOf(readBlock2[13]), Byte.valueOf(readBlock2[12]), Byte.valueOf(readBlock2[11]), Byte.valueOf(readBlock2[10]), Byte.valueOf(readBlock2[9]), Byte.valueOf(readBlock2[8]), Byte.valueOf(readBlock2[7]), Byte.valueOf(readBlock2[6])}));
                    c0428i.m1384a(String.format(Locale.US, C0358k.f1076c + "Current value: %01.2f " + "\u0433\u0440\u043d.", new Object[]{Double.valueOf(((double) a) / 100.0d)}));
                }
            } catch (TagLostException e) {
                throw e;
            } catch (IOException e2) {
                return BuildConfig.VERSION_NAME;
            }
        }
        return c0428i.toString();
    }

    private String m473q() {
        if (!m491a(Integer.valueOf(8), C0244b.f377l, true)) {
            return BuildConfig.VERSION_NAME;
        }
        m491a(Integer.valueOf(0), C0244b.f377l, true);
        C0428i c0428i = new C0428i();
        if (this.f453q.getId().length != 4) {
            return BuildConfig.VERSION_NAME;
        }
        c0428i.m1384a((CharSequence) "Carte E-GO (Luxemburg public transport card)");
        long a = C0429j.m1390a(r1[3], r1[2], r1[1], r1[0]);
        c0428i.m1384a(String.format(C0358k.f1076c + "Card no: %010d", new Object[]{Long.valueOf(a)}));
        c0428i.m1384a(C0361n.f1091b);
        return c0428i.toString();
    }

    private String m474r() {
        C0428i c0428i = new C0428i();
        if (m491a(Integer.valueOf(0), C0244b.f376k, true)) {
            if (this.f453q.getId().length != 4) {
                return BuildConfig.VERSION_NAME;
            }
            c0428i.m1384a((CharSequence) "Kharkov Metro card");
            c0428i.m1384a(C0358k.f1076c + "Card no: " + Long.toString(C0429j.m1390a(r1[3], r1[2], r1[1], r1[0])));
            c0428i.m1384a(C0361n.f1091b);
        }
        return c0428i.toString();
    }

    private String m475s() {
        return m491a(Integer.valueOf(0), C0244b.f373h, true) ? "RATB Activ card" + C0361n.f1092c : BuildConfig.VERSION_NAME;
    }

    private C0350d m476t() {
        try {
            Object readBlock = this.f454r.readBlock(1);
            Object readBlock2 = this.f454r.readBlock(2);
            int i = this.f454r.readBlock(3)[9] & MotionEventCompat.ACTION_MASK;
            if ((i & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) == 0) {
                return null;
            }
            Object readBlock3;
            if ((i & 3) == 2) {
                Object obj;
                boolean a = m491a(Integer.valueOf(64), C0244b.f368c, true);
                if (!a) {
                    a = m491a(Integer.valueOf(64), C0244b.f369d, true);
                    this.f441E = a;
                }
                if (a) {
                    obj = new byte[80];
                    readBlock3 = this.f454r.readBlock(64);
                    Object readBlock4 = this.f454r.readBlock(65);
                    Object readBlock5 = this.f454r.readBlock(66);
                    if (!(readBlock3 == null || readBlock4 == null || readBlock5 == null)) {
                        System.arraycopy(readBlock3, 0, obj, 32, 16);
                        System.arraycopy(readBlock4, 0, obj, 48, 16);
                        System.arraycopy(readBlock5, 0, obj, 64, 16);
                    }
                } else {
                    obj = new byte[32];
                }
                readBlock3 = obj;
            } else if ((i & 3) != 1) {
                return null;
            } else {
                readBlock3 = new byte[32];
            }
            System.arraycopy(readBlock, 0, readBlock3, 0, 16);
            System.arraycopy(readBlock2, 0, readBlock3, 16, 16);
            return new C0350d(readBlock3, i);
        } catch (TagLostException e) {
            throw e;
        } catch (IOException e2) {
            return null;
        }
    }

    private ArrayList m477u() {
        ArrayList arrayList = new ArrayList();
        if (this.f458v == null) {
            return null;
        }
        Iterator it = this.f458v.iterator();
        while (it.hasNext()) {
            C0349c c0349c = (C0349c) it.next();
            if (c0349c != null && c0349c.m1021a() == 57603) {
                int e = c0349c.m1025e();
                int sectorToBlock = (this.f454r.sectorToBlock(e) + this.f454r.getBlockCountInSector(e)) - 1;
                if (m491a(Integer.valueOf(sectorToBlock), C0244b.f370e, true)) {
                    try {
                        arrayList.add(new C0248f((byte) (this.f454r.readBlock(sectorToBlock)[9] & MotionEventCompat.ACTION_MASK), e));
                    } catch (TagLostException e2) {
                        throw e2;
                    } catch (IOException e3) {
                        arrayList.add(new C0248f(e, aq.READ_ERR));
                    }
                } else {
                    arrayList.add(new C0248f(e, aq.AUTH_ERR));
                }
            }
        }
        return arrayList;
    }

    private boolean m478v() {
        boolean a = m491a(Integer.valueOf(0), C0244b.f368c, true);
        if (a) {
            return a;
        }
        a = m491a(Integer.valueOf(0), C0244b.f369d, true);
        this.f441E = true;
        return a;
    }

    private int[] m479w() {
        int i = 0;
        int intValue = ((Integer) f432f.get(this.f450n.f480b)).intValue();
        if (this.f450n.f479a == av.TNPP) {
            intValue++;
        }
        int i2 = (this.f450n.f479a == av.TNP_I2C && this.f450n.f480b == au.OneK) ? 1 : 0;
        if (i2 != 0) {
            intValue += 2;
        }
        int[] iArr = new int[intValue];
        while (i < intValue) {
            iArr[i] = i;
            i++;
        }
        if (i2 != 0) {
            iArr[iArr.length - 2] = 30;
            iArr[iArr.length - 1] = 31;
        }
        return iArr;
    }

    private void m480x() {
        this.f462z = new C0182c();
        C0354g c0354g = new C0354g(C0244b.f368c, "A");
        int[] w = m479w();
        int length = w.length;
        int i = 0;
        C0354g c0354g2 = null;
        C0354g c0354g3 = c0354g;
        while (i < length) {
            int i2 = w[i];
            C0354g c0354g4 = (C0354g) this.f448l.get(i2);
            C0354g c0354g5 = c0354g4 != null ? c0354g4 : c0354g3;
            try {
                Object obj;
                int i3;
                C0354g c0354g6;
                C0354g c0354g7;
                int i4;
                List<C0354g> a = C0244b.m386a(i2, c0354g3, this.f448l, this.f450n, this.f461y, true);
                Object obj2 = null;
                Log.v("TagInfo_MF", "previous key A: " + C0429j.m1409e(c0354g3.m1062b()));
                C0354g c0354g8 = c0354g3;
                Object obj3 = 1;
                for (C0354g c0354g9 : a) {
                    Object obj4;
                    C0354g c0354g10;
                    Log.v("TagInfo_MF", "Sector " + i2 + ", trying key: " + C0429j.m1409e(c0354g9.m1062b()));
                    int i5 = i2 < 32 ? i2 * 4 : ((i2 - 32) * 16) + AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS;
                    Log.v("TagInfo_MF", "auth block " + i5 + ", key " + C0429j.m1409e(c0354g9.m1062b()));
                    String c = c0354g9.m1063c();
                    boolean equals = "A|B".equals(c);
                    Object obj5 = ("A".equals(c) || equals) ? 1 : null;
                    Object obj6 = ("B".equals(c) || equals) ? 1 : null;
                    if (obj5 != null && m491a(Integer.valueOf(i5), c0354g9.m1060a(), true)) {
                        Log.v("TagInfo_MF", "Key A found");
                        obj4 = 1;
                        obj = 1;
                        c0354g10 = c0354g9;
                    } else if (obj6 == null || !m491a(Integer.valueOf(i5), c0354g9.m1060a(), false)) {
                        obj4 = obj3;
                        obj = obj2;
                        c0354g10 = c0354g8;
                    } else {
                        Log.v("TagInfo_MF", "As Key B OK");
                        obj4 = null;
                        int i6 = 1;
                        c0354g10 = c0354g9;
                    }
                    if (obj != null) {
                        int i7 = (i2 < 32 || this.f450n.f480b == au.TwoK) ? 4 : 16;
                        i3 = (i5 + i7) - 1;
                        byte[] b = m463b(i3);
                        String[] c2 = ag.m466c(b);
                        for (int i8 = i5; i8 < (i5 + i7) - 1; i8++) {
                            this.f462z.m147a(new C0191l(i8, ag.m455a(c2, i2, i8), m463b(i8)));
                        }
                        String a2 = ag.m455a(c2, i2, i3);
                        obj6 = (a2.charAt(2) == 'r' || a2.charAt(2) == 'x') ? 1 : null;
                        if (!this.f460x.m63u() || ((obj4 == null || obj6 != null) && obj4 != null)) {
                            this.f462z.m147a(new C0192m((i5 + i7) - 1, a2, b, obj4 != null ? c0354g9.m1062b() : null, obj4 != null ? null : c0354g9.m1062b()));
                            c0354g6 = c0354g2;
                            c0354g7 = c0354g10;
                            if (obj != null) {
                                i3 = i2 >= 32 ? i2 * 4 : ((i2 - 32) * 16) + AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS;
                                i4 = 0;
                                while (true) {
                                    if (i4 < (i2 >= 32 ? 3 : 15)) {
                                        break;
                                    }
                                    this.f462z.m147a(new C0191l(i3 + i4, "???", null));
                                    i4++;
                                }
                                this.f462z.m147a(new C0192m(i3 + (i2 >= 32 ? 3 : 15), "???", null, null, null));
                            }
                            i++;
                            c0354g2 = c0354g6;
                            c0354g3 = c0354g7;
                        } else {
                            for (C0354g c0354g62 : C0244b.m386a(i2, c0354g2, this.f449m, this.f450n, this.f461y, obj4 == null)) {
                                Log.v("TagInfo_MF", "Trying key (B): " + C0429j.m1409e(c0354g62.m1062b()));
                                if (!(c0354g62 == null || c0354g62.m1060a() == null || c0354g62.m1062b() == null)) {
                                    if (!c0354g62.m1061a(c0354g5) || c0354g62 == c0354g5) {
                                        if (m491a(Integer.valueOf(i5), c0354g62.m1060a(), obj4 == null)) {
                                            Log.v("TagInfo_MF", "As key " + (obj4 != null ? "B" : "A") + " found");
                                            this.f462z.m147a(new C0192m((i5 + i7) - 1, a2, b, obj4 != null ? c0354g9.m1062b() : c0354g62.m1062b(), obj4 != null ? c0354g62.m1062b() : c0354g9.m1062b()));
                                            obj6 = 1;
                                            c0354g2 = c0354g62;
                                            if (obj6 == null) {
                                                this.f462z.m147a(new C0192m((i5 + i7) - 1, a2, b, obj4 == null ? c0354g9.m1062b() : null, obj4 == null ? null : c0354g9.m1062b()));
                                            }
                                            c0354g62 = c0354g2;
                                            c0354g7 = c0354g10;
                                            if (obj != null) {
                                                if (i2 >= 32) {
                                                }
                                                i4 = 0;
                                                while (true) {
                                                    if (i2 >= 32) {
                                                    }
                                                    if (i4 < (i2 >= 32 ? 3 : 15)) {
                                                        break;
                                                        if (i2 >= 32) {
                                                        }
                                                        this.f462z.m147a(new C0192m(i3 + (i2 >= 32 ? 3 : 15), "???", null, null, null));
                                                    } else {
                                                        this.f462z.m147a(new C0191l(i3 + i4, "???", null));
                                                        i4++;
                                                    }
                                                }
                                            }
                                            i++;
                                            c0354g2 = c0354g62;
                                            c0354g3 = c0354g7;
                                        }
                                    }
                                }
                            }
                            obj6 = null;
                            if (obj6 == null) {
                                if (obj4 == null) {
                                }
                                if (obj4 == null) {
                                }
                                this.f462z.m147a(new C0192m((i5 + i7) - 1, a2, b, obj4 == null ? c0354g9.m1062b() : null, obj4 == null ? null : c0354g9.m1062b()));
                            }
                            c0354g62 = c0354g2;
                            c0354g7 = c0354g10;
                            if (obj != null) {
                                if (i2 >= 32) {
                                }
                                i4 = 0;
                                while (true) {
                                    if (i2 >= 32) {
                                    }
                                    if (i4 < (i2 >= 32 ? 3 : 15)) {
                                        this.f462z.m147a(new C0191l(i3 + i4, "???", null));
                                        i4++;
                                    } else {
                                        break;
                                        if (i2 >= 32) {
                                        }
                                        this.f462z.m147a(new C0192m(i3 + (i2 >= 32 ? 3 : 15), "???", null, null, null));
                                    }
                                }
                            }
                            i++;
                            c0354g2 = c0354g62;
                            c0354g3 = c0354g7;
                        }
                    } else {
                        obj3 = obj4;
                        obj2 = obj;
                        c0354g8 = c0354g10;
                    }
                }
                obj = obj2;
                c0354g62 = c0354g2;
                c0354g7 = c0354g8;
                if (obj != null) {
                    if (i2 >= 32) {
                    }
                    i4 = 0;
                    while (true) {
                        if (i2 >= 32) {
                        }
                        if (i4 < (i2 >= 32 ? 3 : 15)) {
                            break;
                            if (i2 >= 32) {
                            }
                            this.f462z.m147a(new C0192m(i3 + (i2 >= 32 ? 3 : 15), "???", null, null, null));
                        } else {
                            this.f462z.m147a(new C0191l(i3 + i4, "???", null));
                            i4++;
                        }
                    }
                }
                i++;
                c0354g2 = c0354g62;
                c0354g3 = c0354g7;
            } catch (TagLostException e) {
                this.f462z.m147a(new C0194n(C0429j.m1391a((CharSequence) "<aborted, tag disappeared>\n\n\nr/R=read, w/W=write, i/I=increment,\nd=decr/transfer/restore, x=r+w, X=R+W\ndata block: r/w/i/d:key A|B, R/W/I:key B only,\n  I/i implies d, *=value block\ntrailer (order: key A, AC, key B): r/w:key A,\n  W:key B, R:key A|B, (r)=readable key\nAC: W implies R+r, R implies r")));
                throw e;
            }
        }
        this.f462z.m147a(new C0194n(C0429j.m1391a((CharSequence) "\nr/R=read, w/W=write, i/I=increment,\nd=decr/transfer/restore, x=r+w, X=R+W\ndata block: r/w/i/d:key A|B, R/W/I:key B only,\n  I/i implies d, *=value block\ntrailer (order: key A, AC, key B): r/w:key A,\n  W:key B, R:key A|B, (r)=readable key\nAC: W implies R+r, R implies r")));
    }

    private String m481y() {
        if (this.f459w == null) {
            return null;
        }
        C0428i c0428i = new C0428i();
        Integer valueOf = Integer.valueOf(-1);
        aq aqVar = aq.OK;
        Collections.sort(this.f459w);
        Iterator it = this.f459w.iterator();
        aq aqVar2 = aqVar;
        Integer num = valueOf;
        StringBuilder stringBuilder = null;
        C0428i c0428i2 = null;
        while (it.hasNext()) {
            C0248f c0248f = (C0248f) it.next();
            if (c0248f != null) {
                Integer a = c0248f.m388a();
                aq d = c0248f.m391d();
                if (stringBuilder == null || (!(a == null && r5 == null && r3 == d) && (r5 == null || !r5.equals(a)))) {
                    if (stringBuilder != null) {
                        c0428i.m1384a(stringBuilder.toString());
                        c0428i.m1384a(c0428i2.toString());
                    }
                    c0428i2 = new C0428i();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(String.format("Sectors: %d", new Object[]{Integer.valueOf(c0248f.m389b())}));
                    if (!c0248f.m390c() || a == null) {
                        c0428i2.m1384a(C0358k.f1076c + "Inaccessible: " + c0248f.m392e());
                    } else {
                        c0428i2.m1387b(C0358k.f1076c);
                        c0428i2.m1384a(String.format("General Purpose Byte: 0x%02X", new Object[]{a}));
                        c0428i2.m1387b(C0358k.f1076c);
                        c0428i2.m1384a(String.format("Mapping version %d.%d", new Object[]{Integer.valueOf((a.intValue() >>> 6) & 3), Integer.valueOf((a.intValue() >>> 4) & 3)}));
                        int intValue = (a.intValue() >>> 2) & 3;
                        int intValue2 = a.intValue() & 3;
                        c0428i2.m1387b(C0358k.f1076c + "NDEF access: ");
                        if (intValue == 0 && intValue2 == 0) {
                            c0428i2.m1387b(C0429j.m1391a((CharSequence) "Read & Write"));
                        } else if (intValue == 0 && intValue2 == 3) {
                            c0428i2.m1387b("Read-Only");
                        } else {
                            c0428i2.m1387b("[proprietary]");
                        }
                    }
                    aqVar2 = d;
                    num = a;
                } else {
                    stringBuilder.append(String.format(", %d", new Object[]{Integer.valueOf(c0248f.m389b())}));
                }
            }
        }
        if (stringBuilder != null) {
            c0428i.m1384a(stringBuilder.toString());
            c0428i.m1384a(c0428i2.toString());
        }
        return c0428i.toString();
    }

    String m482a(boolean z) {
        return C0347a.m1015a(this.f457u, this.f458v, z);
    }

    public void m483a(C0197a c0197a, boolean z) {
        av avVar = this.f450n.f479a;
        if (this.f450n.f480b != au.UNKNOWN) {
            if (this.f452p || avVar == av.PRO) {
                c0197a.m196b((CharSequence) f429a.get(this.f450n.f480b));
            } else {
                c0197a.m193a((CharSequence) f429a.get(this.f450n.f480b));
            }
        }
        m493b(c0197a, false);
        if (this.f440D != null) {
            c0197a.m206g(C0351d.m1034a(this.f440D, this.f453q.getId()));
        }
        if (!(this.f438B == aw.UNKNOWN || this.f438B == aw.NONE)) {
            c0197a.m200d((CharSequence) f434h.get(this.f438B));
        }
        if (avVar == av.TNP_I2C) {
            String str = BuildConfig.VERSION_NAME;
            Object k = m467k();
            if (!TextUtils.isEmpty(k)) {
                str = "Full product name: " + k + "\n";
            }
            c0197a.m198c(str + C0362o.f1101h);
            if (this.f445c != null) {
                c0197a.m207g("Start-up configuration", C0303k.m813a(this.f445c[0], false, true, C0372z.m1118d(this.f443G)));
                c0197a.m203e("Session configuration", C0303k.m813a(this.f445c[1], true, true, C0372z.m1118d(this.f443G)));
            }
        } else if (!this.f452p && m490a()) {
            Object k2 = m467k();
            if (!TextUtils.isEmpty(k2)) {
                c0197a.m198c("Full product name: " + k2);
            }
        }
        if (this.f446d != null) {
            CharSequence a = C0250h.m393a(this.f446d, this.f453q.getId());
            if (!TextUtils.isEmpty(a)) {
                c0197a.m203e("Originality check", a);
            }
        }
    }

    public void m484a(C0198b c0198b, boolean z) {
        if (this.f459w == null) {
            return;
        }
        if (this.f452p) {
            c0198b.m221c("MIFARE NDEF sector analysis", m481y());
        } else {
            c0198b.m219b("NDEF sector analysis", m481y());
        }
    }

    public void m485a(C0199c c0199c, boolean z) {
        if (!this.f452p) {
            c0199c.m230d(m499e());
            StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
            String str = (String) f430b.get(this.f450n.f479a);
            CharSequence d = m498d();
            if (m490a() && !TextUtils.isEmpty(str)) {
                stringBuilder.append(str);
                if (!(this.f451o == at.UNKNOWN || this.f451o == at.NONE)) {
                    stringBuilder.append(" ");
                    stringBuilder.append((String) f435i.get(this.f451o));
                }
                if (!TextUtils.isEmpty(d)) {
                    stringBuilder.append(" (");
                }
            }
            if (TextUtils.isEmpty(d)) {
                stringBuilder.append("Unknown IC");
            } else {
                stringBuilder.append(d.trim());
            }
            if (!(!m490a() || TextUtils.isEmpty(str) || TextUtils.isEmpty(d))) {
                stringBuilder.append(")");
            }
            c0199c.m231e(stringBuilder.toString());
        }
        m494b(c0199c, false);
    }

    public void m486a(C0200d c0200d, boolean z) {
        C0428i c0428i = new C0428i();
        String e = m499e();
        if ("NXP Semiconductors".equals(e) || "Infineon Technologies AG".equals(e)) {
            c0428i.m1384a((CharSequence) "MIFARE Classic compatible");
        }
        if (this.f452p) {
            c0428i.m1384a((CharSequence) "ISO/IEC 7816-4 compatible");
            c0428i.m1384a((CharSequence) "ISO/IEC 14443-4 (Type A) compatible");
        }
        c0428i.m1384a((CharSequence) "ISO/IEC 14443-3 (Type A) compatible");
        c0428i.m1384a((CharSequence) "ISO/IEC 14443-2 (Type A) compatible");
        c0200d.m238a(c0428i.toString());
        if (this.f462z != null) {
            if (this.f452p) {
                c0200d.m239b(this.f462z);
            } else {
                c0200d.m237a(this.f462z);
            }
        }
        if (this.f439C != null) {
            C0369v.m1099a(this.f455s, this.f439C, c0200d);
        } else if (this.f452p) {
            IsoDep isoDep = IsoDep.get(this.f455s.getTag());
            if (isoDep != null) {
                C0369v.m1095a(this.f455s, isoDep, this.f439C, c0200d);
            } else {
                C0369v.m1097a(this.f455s, c0200d);
            }
        } else {
            C0369v.m1097a(this.f455s, c0200d);
        }
    }

    public void m487a(ar arVar) {
        this.f450n.f481c = arVar;
    }

    public void m488a(at atVar) {
        this.f451o = atVar;
    }

    public void m489a(au auVar) {
        this.f450n.f480b = auVar;
    }

    public boolean m490a() {
        return this.f452p || "NXP Semiconductors".equals(m499e());
    }

    public boolean m491a(Integer num, C0422a c0422a, boolean z) {
        if (c0422a == null) {
            return false;
        }
        int blockToSector = this.f454r.blockToSector(num.intValue());
        try {
            if (this.f452p) {
                this.f454r.close();
                this.f454r.connect();
                if (!this.f454r.isConnected()) {
                    throw new TagLostException();
                }
            }
            return z ? this.f454r.authenticateSectorWithKeyA(blockToSector, c0422a.m1362a()) : this.f454r.authenticateSectorWithKeyB(blockToSector, c0422a.m1362a());
        } catch (TagLostException e) {
            throw e;
        } catch (IOException e2) {
            return false;
        }
    }

    public byte[] m492a(int i) {
        return this.f454r.readBlock(i);
    }

    void m493b(C0197a c0197a, boolean z) {
        boolean z2 = m490a() || "Infineon Technologies AG".equals(m499e());
        C0347a.m1016a(c0197a, this.f458v, z, this.f441E, z2);
    }

    void m494b(C0199c c0199c, boolean z) {
        Object obj = (m490a() || "Infineon Technologies AG".equals(m499e())) ? 1 : null;
        CharSequence a = m482a(z);
        if (TextUtils.isEmpty(a)) {
            if (this.f452p) {
                if (obj != null) {
                    c0199c.m228b("MIFARE applications", "No known MIFARE applications found");
                } else {
                    c0199c.m228b("NFC-A applications", "No known applications found");
                }
            }
        } else if (obj != null) {
            c0199c.m228b("MIFARE applications", a);
        } else {
            c0199c.m228b("Applications", a);
        }
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        Object c0428i = this.f447k.toString();
        if (!TextUtils.isEmpty(c0428i)) {
            stringBuilder.append(c0428i);
        }
        if (this.f452p) {
            c0199c.m229c(stringBuilder.toString());
        } else {
            c0199c.m227b(stringBuilder.toString());
        }
    }

    public void m495b(boolean z) {
        this.f437A = z;
    }

    public boolean m496b() {
        return this.f456t;
    }

    public byte[] m497c() {
        return this.f453q.getId();
    }

    public String m498d() {
        return ag.m454a(this.f450n, this.f451o, this.f453q.getId(), this.f442F, this.f437A);
    }

    public String m499e() {
        byte[] id = this.f453q.getId();
        String b = C0355h.m1067b(id, C0360m.MIFARE);
        ar arVar = this.f450n.f481c;
        switch (ap.f466d[arVar.ordinal()]) {
            case C0519c.Switch_track /*1*/:
                return "Fudan Microelectronics";
            case C0519c.Switch_textOn /*2*/:
                return "Uncertain (probably Hua Hong Group)";
            case C0519c.Switch_textOff /*3*/:
                return "Uncertain (probably Integrated Silicon Solution Inc)";
            case C0519c.Switch_thumbTextPadding /*4*/:
                return "Quanray Electronics";
            default:
                return !this.f437A ? (id.length != 4 || arVar == ar.UNKNOWN) ? b : (String) f436j.get(arVar) : "Unknown manufacturer";
        }
    }

    public short m500f() {
        return this.f455s.getSak();
    }

    public boolean m501g() {
        return this.f452p;
    }

    public boolean m502h() {
        return this.f437A;
    }

    public au m503i() {
        return this.f450n.f480b;
    }

    public av m504j() {
        return this.f450n.f479a;
    }
}
