package com.nxp.taginfolite.p009e.p014e;

import android.database.Cursor;
import android.nfc.TagLostException;
import android.nfc.tech.MifareUltralight;
import android.support.v4.view.MotionEventCompat;
import com.nxp.taginfolite.TagInfoApp;
import com.nxp.taginfolite.database.provider.UserKeys;
import com.nxp.taginfolite.p003g.C0422a;
import com.nxp.taginfolite.p004f.C0353f;
import com.nxp.taginfolite.p004f.C0354g;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.nxp.taginfolite.e.e.l */
public class C0304l {
    public static final byte[] f803a;
    public static final byte[] f804b;

    static {
        f803a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        f804b = new byte[]{(byte) 73, (byte) 69, (byte) 77, (byte) 75, (byte) 65, (byte) 69, (byte) 82, (byte) 66, (byte) 33, (byte) 78, (byte) 65, (byte) 67, (byte) 85, (byte) 79, (byte) 89, (byte) 70};
    }

    public static int m818a(MifareUltralight mifareUltralight, int i, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int[] copyOfRange = Arrays.copyOfRange(iArr, 12, 16);
        int[] copyOfRange2 = Arrays.copyOfRange(iArr, 8, 12);
        int[] copyOfRange3 = Arrays.copyOfRange(iArr, 4, 8);
        if (!Arrays.equals(copyOfRange, iArr2) && !Arrays.equals(copyOfRange2, iArr2) && !Arrays.equals(copyOfRange3, iArr2)) {
            return 4;
        }
        int i2;
        if (Arrays.equals(copyOfRange3, iArr2) && Arrays.equals(copyOfRange2, iArr3) && Arrays.equals(copyOfRange, iArr4)) {
            i2 = 1;
        } else if (Arrays.equals(copyOfRange2, iArr2) && Arrays.equals(copyOfRange, iArr3)) {
            i2 = 2;
        } else if (!Arrays.equals(copyOfRange, iArr2)) {
            return 4;
        } else {
            i2 = 3;
        }
        try {
            mifareUltralight.readPages(i + i2);
            return 4;
        } catch (TagLostException e) {
            throw e;
        } catch (IOException e2) {
            try {
                mifareUltralight.close();
                mifareUltralight.connect();
            } catch (IOException e3) {
            }
            return i2;
        }
    }

    public static com.nxp.taginfolite.p005b.C0182c m819a(com.nxp.taginfolite.p009e.az r24) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.nxp.taginfolite.e.e.l.a(com.nxp.taginfolite.e.az):com.nxp.taginfolite.b.c. bs: [B:72:0x0189, B:81:0x01a8, B:84:0x01ac]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:57)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r3 = "\n  *:locked & blocked, x:locked,\n  +:blocked, .:un(b)locked, ?:unknown\n  r:readable (write-protected),\n  p:password protected, -:write-only\n  P:password protected write-only";
        r2 = "\n\n  *:locked & blocked, x:locked,\n  +:blocked, .:un(b)locked";
        r0 = r24;
        r2 = r0.f541k;
        r0 = r24;
        r0 = r0.f544n;
        r21 = r0;
        r4 = com.nxp.taginfolite.p009e.bb.NTAG203;
        r0 = r21;
        if (r0 != r4) goto L_0x0856;
    L_0x0014:
        r3 = "\n\n  *:locked & blocked, x:locked,\n  +:blocked, .:un(b)locked";
        r8 = r3;
    L_0x0017:
        r16 = "";
        r3 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        r0 = new int[r3];
        r22 = r0;
        r3 = -1;
        r0 = r22;
        java.util.Arrays.fill(r0, r3);
        r12 = 0;
        r11 = 4;
        r15 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r3 = 0;
        r10 = "r";
        r4 = 0;
        r5 = 0;
        r9 = r2.readPages(r5);	 Catch:{ TagLostException -> 0x07ee, IOException -> 0x01e3 }
        r13 = 1;
        r3 = 4;
        r5 = new int[r3];	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = 0;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r6 = 0;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r6 = r9[r6];	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r6 = r6 & 255;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r5[r3] = r6;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = 1;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r6 = 1;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r6 = r9[r6];	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r6 = r6 & 255;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r5[r3] = r6;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = 2;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r6 = 2;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r6 = r9[r6];	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r6 = r6 & 255;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r5[r3] = r6;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = 3;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r6 = 3;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r6 = r9[r6];	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r6 = r6 & 255;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r5[r3] = r6;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = 4;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r6 = new int[r3];	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = 0;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r7 = 4;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r7 = r9[r7];	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r7 = r7 & 255;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r6[r3] = r7;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = 1;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r7 = 5;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r7 = r9[r7];	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r7 = r7 & 255;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r6[r3] = r7;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = 2;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r7 = 6;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r7 = r9[r7];	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r7 = r7 & 255;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r6[r3] = r7;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = 3;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r7 = 7;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r7 = r9[r7];	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r7 = r7 & 255;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r6[r3] = r7;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = 4;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r7 = new int[r3];	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = 0;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r14 = 8;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r14 = r9[r14];	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r14 = r14 & 255;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r7[r3] = r14;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = 1;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r14 = 9;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r14 = r9[r14];	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r14 = r14 & 255;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r7[r3] = r14;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = 2;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r14 = 10;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r14 = r9[r14];	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r14 = r14 & 255;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r7[r3] = r14;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = 3;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r14 = 11;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r14 = r9[r14];	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r14 = r14 & 255;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r7[r3] = r14;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = 0;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
    L_0x00a1:
        r14 = r9.length;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        if (r3 >= r14) goto L_0x00ad;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
    L_0x00a4:
        r14 = r9[r3];	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r14 = r14 & 255;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r22[r3] = r14;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = r3 + 1;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        goto L_0x00a1;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
    L_0x00ad:
        r3 = com.nxp.taginfolite.p009e.p014e.C0304l.m821a();	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r9 = com.nxp.taginfolite.p009e.bb.NTAG203;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r0 = r21;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        if (r0 == r9) goto L_0x0853;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
    L_0x00b7:
        r9 = r3.iterator();	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
    L_0x00bb:
        r3 = r9.hasNext();	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        if (r3 == 0) goto L_0x00d3;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
    L_0x00c1:
        r3 = r9.next();	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = (com.nxp.taginfolite.p004f.C0354g) r3;	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r3 = r3.m1062b();	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        r14 = com.nxp.taginfolite.p009e.p014e.C0304l.m822a(r2, r3);	 Catch:{ TagLostException -> 0x07f3, IOException -> 0x07b6 }
        if (r14 == 0) goto L_0x0850;
    L_0x00d1:
        r4 = r3;
        goto L_0x00bb;
    L_0x00d3:
        r9 = r4;
    L_0x00d4:
        r3 = 4;
        r4 = r15;
        r23 = r13;
        r13 = r3;
        r3 = r23;
    L_0x00db:
        r14 = 40;
        if (r13 >= r14) goto L_0x084c;
    L_0x00df:
        r17 = r2.readPages(r13);	 Catch:{ TagLostException -> 0x0105, IOException -> 0x0149 }
        r3 = r3 + 1;	 Catch:{ TagLostException -> 0x0105, IOException -> 0x0149 }
        r14 = 0;	 Catch:{ TagLostException -> 0x0105, IOException -> 0x0149 }
    L_0x00e6:
        r0 = r17;	 Catch:{ TagLostException -> 0x0105, IOException -> 0x0149 }
        r0 = r0.length;	 Catch:{ TagLostException -> 0x0105, IOException -> 0x0149 }
        r18 = r0;	 Catch:{ TagLostException -> 0x0105, IOException -> 0x0149 }
        r0 = r18;	 Catch:{ TagLostException -> 0x0105, IOException -> 0x0149 }
        if (r14 >= r0) goto L_0x0100;	 Catch:{ TagLostException -> 0x0105, IOException -> 0x0149 }
    L_0x00ef:
        r18 = r13 * 4;	 Catch:{ TagLostException -> 0x0105, IOException -> 0x0149 }
        r18 = r18 + r14;	 Catch:{ TagLostException -> 0x0105, IOException -> 0x0149 }
        r19 = r17[r14];	 Catch:{ TagLostException -> 0x0105, IOException -> 0x0149 }
        r0 = r19;	 Catch:{ TagLostException -> 0x0105, IOException -> 0x0149 }
        r0 = r0 & 255;	 Catch:{ TagLostException -> 0x0105, IOException -> 0x0149 }
        r19 = r0;	 Catch:{ TagLostException -> 0x0105, IOException -> 0x0149 }
        r22[r18] = r19;	 Catch:{ TagLostException -> 0x0105, IOException -> 0x0149 }
        r14 = r14 + 1;
        goto L_0x00e6;
    L_0x0100:
        r4 = r13 + 4;
        r13 = r13 + 4;
        goto L_0x00db;
    L_0x0105:
        r2 = move-exception;
        throw r2;	 Catch:{ TagLostException -> 0x0107, IOException -> 0x07b9 }
    L_0x0107:
        r2 = move-exception;
        r2 = r10;
        r10 = r4;
        r4 = r9;
    L_0x010b:
        r5 = 1;
        r0 = r24;
        r0.f542l = r5;
        r15 = r3 * 4;
        r3 = "\n<aborted: tag disappeared>";
        r17 = r4;
        r18 = r15;
        r19 = r12;
        r20 = r3;
        r3 = r10;
    L_0x011d:
        if (r19 == 0) goto L_0x083c;
    L_0x011f:
        r2 = 3;
        if (r11 < r2) goto L_0x01f9;
    L_0x0122:
        r2 = 8;
        r2 = r19[r2];
        r3 = r2 & 255;
        r2 = 12;
        r2 = r19[r2];
        r2 = r2 & 1;
        if (r2 == 0) goto L_0x01f5;
    L_0x0130:
        r2 = "r";
    L_0x0132:
        r9 = r2;
        r10 = r3;
    L_0x0134:
        r14 = new com.nxp.taginfolite.b.c;
        r14.<init>();
        if (r18 > 0) goto L_0x0201;
    L_0x013b:
        r2 = new com.nxp.taginfolite.b.o;
        r3 = com.nxp.taginfolite.p003g.C0429j.m1391a(r20);
        r2.<init>(r3);
        r14.m147a(r2);
        r2 = r14;
    L_0x0148:
        return r2;
    L_0x0149:
        r4 = move-exception;
        r4 = "p";	 Catch:{ TagLostException -> 0x07f9, IOException -> 0x07bf }
        r2.close();	 Catch:{ TagLostException -> 0x07ff, IOException -> 0x07c5 }
        r2.connect();	 Catch:{ TagLostException -> 0x07ff, IOException -> 0x07c5 }
        r10 = r4;
        r14 = r3;
    L_0x0154:
        r3 = r14 + -1;
        r18 = r3 * 16;
        r3 = r18 + 16;
        r0 = r22;	 Catch:{ TagLostException -> 0x0805, IOException -> 0x07cc }
        r1 = r18;	 Catch:{ TagLostException -> 0x0805, IOException -> 0x07cc }
        r4 = java.util.Arrays.copyOfRange(r0, r1, r3);	 Catch:{ TagLostException -> 0x0805, IOException -> 0x07cc }
        r3 = r18 / 4;	 Catch:{ TagLostException -> 0x0805, IOException -> 0x07cc }
        r17 = com.nxp.taginfolite.p009e.p014e.C0304l.m818a(r2, r3, r4, r5, r6, r7);	 Catch:{ TagLostException -> 0x0805, IOException -> 0x07cc }
        r3 = 4;
        r0 = r17;
        if (r0 >= r3) goto L_0x0845;
    L_0x016d:
        r3 = 4 - r17;
        r4 = r13 - r3;
        r3 = "p";	 Catch:{ TagLostException -> 0x080c, IOException -> 0x07d2 }
        r10 = r17;
    L_0x0175:
        r13 = 4;
        if (r10 >= r13) goto L_0x0183;
    L_0x0178:
        r13 = r10 * 4;
        r13 = r13 + r18;
        r17 = -1;
        r22[r13] = r17;	 Catch:{ TagLostException -> 0x0813, IOException -> 0x07d8 }
        r10 = r10 + 1;
        goto L_0x0175;
    L_0x0183:
        r13 = r3;
        r10 = r4;
    L_0x0185:
        if (r9 == 0) goto L_0x019c;
    L_0x0187:
        r3 = 40;
        r2 = r2.readPages(r3);	 Catch:{ TagLostException -> 0x01d0, IOException -> 0x07df }
        r3 = r11;	 Catch:{ TagLostException -> 0x01d0, IOException -> 0x07df }
        r4 = r2;	 Catch:{ TagLostException -> 0x01d0, IOException -> 0x07df }
        r2 = r10;	 Catch:{ TagLostException -> 0x01d0, IOException -> 0x07df }
    L_0x0190:
        r17 = r9;	 Catch:{ TagLostException -> 0x01d0, IOException -> 0x07df }
        r18 = r15;	 Catch:{ TagLostException -> 0x01d0, IOException -> 0x07df }
        r11 = r3;	 Catch:{ TagLostException -> 0x01d0, IOException -> 0x07df }
        r19 = r4;	 Catch:{ TagLostException -> 0x01d0, IOException -> 0x07df }
        r20 = r16;	 Catch:{ TagLostException -> 0x01d0, IOException -> 0x07df }
        r3 = r2;	 Catch:{ TagLostException -> 0x01d0, IOException -> 0x07df }
        r2 = r13;	 Catch:{ TagLostException -> 0x01d0, IOException -> 0x07df }
        goto L_0x011d;	 Catch:{ TagLostException -> 0x01d0, IOException -> 0x07df }
    L_0x019c:
        r3 = com.nxp.taginfolite.p009e.bb.NTAG203;	 Catch:{ TagLostException -> 0x01d0, IOException -> 0x07df }
        r0 = r21;
        if (r0 == r3) goto L_0x01a6;
    L_0x01a2:
        r3 = 40;
        if (r10 != r3) goto L_0x0840;
    L_0x01a6:
        r3 = 40;
        r12 = r2.readPages(r3);	 Catch:{ TagLostException -> 0x01ce, IOException -> 0x01d6 }
        r3 = r12.length;	 Catch:{ TagLostException -> 0x01ce, IOException -> 0x0822 }
        r4 = new int[r3];	 Catch:{ TagLostException -> 0x01ce, IOException -> 0x0822 }
        r3 = 0;	 Catch:{ TagLostException -> 0x01ce, IOException -> 0x0822 }
    L_0x01b0:
        r0 = r12.length;	 Catch:{ TagLostException -> 0x01ce, IOException -> 0x0822 }
        r17 = r0;	 Catch:{ TagLostException -> 0x01ce, IOException -> 0x0822 }
        r0 = r17;	 Catch:{ TagLostException -> 0x01ce, IOException -> 0x0822 }
        if (r3 >= r0) goto L_0x01c4;	 Catch:{ TagLostException -> 0x01ce, IOException -> 0x0822 }
    L_0x01b7:
        r17 = r12[r3];	 Catch:{ TagLostException -> 0x01ce, IOException -> 0x0822 }
        r0 = r17;	 Catch:{ TagLostException -> 0x01ce, IOException -> 0x0822 }
        r0 = r0 & 255;	 Catch:{ TagLostException -> 0x01ce, IOException -> 0x0822 }
        r17 = r0;	 Catch:{ TagLostException -> 0x01ce, IOException -> 0x0822 }
        r4[r3] = r17;	 Catch:{ TagLostException -> 0x01ce, IOException -> 0x0822 }
        r3 = r3 + 1;	 Catch:{ TagLostException -> 0x01ce, IOException -> 0x0822 }
        goto L_0x01b0;	 Catch:{ TagLostException -> 0x01ce, IOException -> 0x0822 }
    L_0x01c4:
        r3 = 40;	 Catch:{ TagLostException -> 0x01ce, IOException -> 0x0822 }
        r2 = com.nxp.taginfolite.p009e.p014e.C0304l.m818a(r2, r3, r4, r5, r6, r7);	 Catch:{ TagLostException -> 0x01ce, IOException -> 0x0822 }
        r3 = r2;
        r4 = r12;
        r2 = r10;
        goto L_0x0190;
    L_0x01ce:
        r2 = move-exception;
        throw r2;	 Catch:{ TagLostException -> 0x01d0, IOException -> 0x07df }
    L_0x01d0:
        r2 = move-exception;
        r4 = r9;
        r2 = r13;
        r3 = r14;
        goto L_0x010b;
    L_0x01d6:
        r3 = move-exception;
        r4 = r12;
    L_0x01d8:
        r3 = 40;
        r2.close();	 Catch:{ TagLostException -> 0x081a, IOException -> 0x07e6 }
        r2.connect();	 Catch:{ TagLostException -> 0x081a, IOException -> 0x07e6 }
        r2 = r3;
        r3 = r11;
        goto L_0x0190;
    L_0x01e3:
        r2 = move-exception;
        r13 = r3;
    L_0x01e5:
        r2 = r13 * 4;
        r3 = "\n<aborted: read error>";
        r17 = r4;
        r18 = r2;
        r19 = r12;
        r20 = r3;
        r2 = r10;
        r3 = r15;
        goto L_0x011d;
    L_0x01f5:
        r2 = "p";
        goto L_0x0132;
    L_0x01f9:
        r3 = r11 + 40;
        r2 = "p";
        r9 = r2;
        r10 = r3;
        goto L_0x0134;
    L_0x0201:
        r2 = com.nxp.taginfolite.p009e.bb.NTAG203;
        r0 = r21;
        if (r0 != r2) goto L_0x0356;
    L_0x0207:
        r2 = "";
    L_0x0209:
        r3 = "(UID0-UID2, BCC0)";
        r4 = 0;
        r4 = r22[r4];
        r4 = r4 ^ 136;
        r5 = 1;
        r5 = r22[r5];
        r4 = r4 ^ r5;
        r5 = 2;
        r5 = r22[r5];
        r4 = r4 ^ r5;
        r5 = 3;
        r5 = r22[r5];
        r4 = r4 ^ r5;
        r4 = r4 & 255;
        if (r4 == 0) goto L_0x0233;
    L_0x0220:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r3 = r4.append(r3);
        r4 = " CRC error";
        r3 = r3.append(r4);
        r3 = r3.toString();
    L_0x0233:
        r4 = new com.nxp.taginfolite.b.p;
        r5 = 0;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "*";
        r6 = r6.append(r7);
        r6 = r6.append(r2);
        r6 = r6.toString();
        r7 = 0;
        r11 = 4;
        r0 = r22;
        r7 = java.util.Arrays.copyOfRange(r0, r7, r11);
        r7 = com.nxp.taginfolite.p003g.C0422a.m1361a(r7);
        r4.<init>(r5, r6, r7, r3);
        r14.m147a(r4);
        r3 = "(UID3-UID6)";
        r4 = 4;
        r4 = r22[r4];
        r5 = 5;
        r5 = r22[r5];
        r4 = r4 ^ r5;
        r5 = 6;
        r5 = r22[r5];
        r4 = r4 ^ r5;
        r5 = 7;
        r5 = r22[r5];
        r4 = r4 ^ r5;
        r5 = 8;
        r5 = r22[r5];
        r4 = r4 ^ r5;
        r4 = r4 & 255;
        if (r4 == 0) goto L_0x0288;
    L_0x0275:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r3 = r4.append(r3);
        r4 = " CRC error";
        r3 = r3.append(r4);
        r3 = r3.toString();
    L_0x0288:
        r4 = new com.nxp.taginfolite.b.p;
        r5 = 1;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "*";
        r6 = r6.append(r7);
        r6 = r6.append(r2);
        r6 = r6.toString();
        r7 = 4;
        r11 = 8;
        r0 = r22;
        r7 = java.util.Arrays.copyOfRange(r0, r7, r11);
        r7 = com.nxp.taginfolite.p003g.C0422a.m1361a(r7);
        r4.<init>(r5, r6, r7, r3);
        r14.m147a(r4);
        r3 = 10;
        r3 = r22[r3];
        r3 = r3 & 255;
        r11 = (byte) r3;
        r3 = 11;
        r3 = r22[r3];
        r3 = r3 & 255;
        r12 = (byte) r3;
        r3 = r11 & 7;
        r4 = 7;
        if (r3 != r4) goto L_0x035a;
    L_0x02c4:
        r3 = "*";
    L_0x02c6:
        r4 = new com.nxp.taginfolite.b.p;
        r5 = 2;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r3 = r6.append(r3);
        r2 = r3.append(r2);
        r2 = r2.toString();
        r3 = 8;
        r6 = 12;
        r0 = r22;
        r3 = java.util.Arrays.copyOfRange(r0, r3, r6);
        r3 = com.nxp.taginfolite.p003g.C0422a.m1361a(r3);
        r6 = "(BCC1, INT, LOCK0-LOCK1)";
        r4.<init>(r5, r2, r3, r6);
        r14.m147a(r4);
        r2 = r11 & 8;
        if (r2 == 0) goto L_0x0372;
    L_0x02f4:
        r2 = r11 & 1;
        if (r2 == 0) goto L_0x036e;
    L_0x02f8:
        r2 = "*";
        r4 = r2;
    L_0x02fb:
        r2 = com.nxp.taginfolite.p009e.bb.NTAG203;
        r0 = r21;
        if (r0 != r2) goto L_0x037f;
    L_0x0301:
        r2 = "";
    L_0x0303:
        r3 = 3;
        if (r3 < r10) goto L_0x0307;
    L_0x0306:
        r2 = r9;
    L_0x0307:
        if (r17 != 0) goto L_0x0382;
    L_0x0309:
        r3 = "p";
        r3 = r3.equals(r2);
        if (r3 == 0) goto L_0x0382;
    L_0x0311:
        r2 = new com.nxp.taginfolite.b.p;
        r3 = 3;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r4 = r5.append(r4);
        r5 = "p";
        r4 = r4.append(r5);
        r4 = r4.toString();
        r5 = 1;
        r6 = 4;
        r7 = "(OTP0-OTP3)";
        r2.<init>(r3, r4, r5, r6, r7);
        r14.m147a(r2);
    L_0x0331:
        r2 = 1;
        r5 = r2;
    L_0x0333:
        r2 = 4;
        if (r5 >= r2) goto L_0x0405;
    L_0x0336:
        r6 = com.nxp.taginfolite.p009e.C0253s.m522a(r5, r11, r12);
        r2 = 0;
        r4 = r2;
    L_0x033c:
        r2 = 4;
        if (r4 >= r2) goto L_0x0400;
    L_0x033f:
        r2 = r5 * 4;
        r7 = r2 + r4;
        r0 = r18;
        if (r7 < r0) goto L_0x03ad;
    L_0x0347:
        r2 = new com.nxp.taginfolite.b.o;
        r3 = com.nxp.taginfolite.p003g.C0429j.m1391a(r20);
        r2.<init>(r3);
        r14.m147a(r2);
        r2 = r14;
        goto L_0x0148;
    L_0x0356:
        r2 = " ";
        goto L_0x0209;
    L_0x035a:
        if (r11 != 0) goto L_0x0362;
    L_0x035c:
        if (r12 != 0) goto L_0x0362;
    L_0x035e:
        r3 = ".";
        goto L_0x02c6;
    L_0x0362:
        r3 = r11 & 7;
        if (r3 != 0) goto L_0x036a;
    L_0x0366:
        r3 = "x";
        goto L_0x02c6;
    L_0x036a:
        r3 = "+";
        goto L_0x02c6;
    L_0x036e:
        r2 = "x";
        r4 = r2;
        goto L_0x02fb;
    L_0x0372:
        r2 = r11 & 1;
        if (r2 == 0) goto L_0x037a;
    L_0x0376:
        r2 = "+";
        r4 = r2;
        goto L_0x02fb;
    L_0x037a:
        r2 = ".";
        r4 = r2;
        goto L_0x02fb;
    L_0x037f:
        r2 = " ";
        goto L_0x0303;
    L_0x0382:
        r3 = new com.nxp.taginfolite.b.p;
        r5 = 3;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r4 = r6.append(r4);
        r2 = r4.append(r2);
        r2 = r2.toString();
        r4 = 12;
        r6 = 16;
        r0 = r22;
        r4 = java.util.Arrays.copyOfRange(r0, r4, r6);
        r4 = com.nxp.taginfolite.p003g.C0422a.m1361a(r4);
        r6 = "(OTP0-OTP3)";
        r3.<init>(r5, r2, r4, r6);
        r14.m147a(r3);
        goto L_0x0331;
    L_0x03ad:
        r2 = com.nxp.taginfolite.p009e.bb.NTAG203;
        r0 = r21;
        if (r0 != r2) goto L_0x03e3;
    L_0x03b3:
        r2 = "";
    L_0x03b5:
        if (r7 < r10) goto L_0x0839;
    L_0x03b7:
        r3 = r9;
    L_0x03b8:
        if (r17 != 0) goto L_0x03e6;
    L_0x03ba:
        r2 = "p";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x03e6;
    L_0x03c2:
        r2 = 0;
    L_0x03c3:
        r13 = new com.nxp.taginfolite.b.p;
        r15 = new java.lang.StringBuilder;
        r15.<init>();
        r16 = r6[r4];
        r15 = r15.append(r16);
        r3 = r15.append(r3);
        r3 = r3.toString();
        r13.<init>(r7, r3, r2);
        r14.m147a(r13);
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x033c;
    L_0x03e3:
        r2 = " ";
        goto L_0x03b5;
    L_0x03e6:
        r2 = r7 * 4;
        r2 = r22[r2];
        r13 = -1;
        if (r2 == r13) goto L_0x03fe;
    L_0x03ed:
        r2 = r7 * 4;
        r13 = r7 * 4;
        r13 = r13 + 4;
        r0 = r22;
        r2 = java.util.Arrays.copyOfRange(r0, r2, r13);
        r2 = com.nxp.taginfolite.p003g.C0422a.m1361a(r2);
        goto L_0x03c3;
    L_0x03fe:
        r2 = 0;
        goto L_0x03c3;
    L_0x0400:
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x0333;
    L_0x0405:
        r3 = 0;
        r2 = 0;
        if (r19 == 0) goto L_0x0835;
    L_0x0409:
        r2 = 0;
        r3 = r19[r2];
        r2 = 1;
        r2 = r19[r2];
        r11 = r2;
        r12 = r3;
    L_0x0411:
        r2 = 4;
        r16 = r2;
    L_0x0414:
        r2 = 10;
        r0 = r16;
        if (r0 >= r2) goto L_0x04cd;
    L_0x041a:
        r2 = "?";
        if (r19 == 0) goto L_0x0832;
    L_0x041e:
        r2 = r16 * 4;
        r2 = com.nxp.taginfolite.p009e.p014e.C0304l.m820a(r2, r12, r11);
        r13 = r2;
    L_0x0425:
        r2 = 0;
        r15 = r2;
    L_0x0427:
        r2 = 4;
        if (r15 >= r2) goto L_0x04c7;
    L_0x042a:
        r2 = r16 * 4;
        r3 = r2 + r15;
        r0 = r18;
        if (r3 < r0) goto L_0x0441;
    L_0x0432:
        r2 = new com.nxp.taginfolite.b.o;
        r3 = com.nxp.taginfolite.p003g.C0429j.m1391a(r20);
        r2.<init>(r3);
        r14.m147a(r2);
        r2 = r14;
        goto L_0x0148;
    L_0x0441:
        r2 = com.nxp.taginfolite.p009e.bb.NTAG203;
        r0 = r21;
        if (r0 != r2) goto L_0x0476;
    L_0x0447:
        r2 = "";
    L_0x0449:
        if (r3 < r10) goto L_0x082f;
    L_0x044b:
        r4 = r9;
    L_0x044c:
        if (r17 != 0) goto L_0x0479;
    L_0x044e:
        r2 = "p";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0479;
    L_0x0456:
        r2 = new com.nxp.taginfolite.b.p;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5 = r5.append(r13);
        r4 = r5.append(r4);
        r4 = r4.toString();
        r5 = 1;
        r6 = 4;
        r7 = 0;
        r2.<init>(r3, r4, r5, r6, r7);
        r14.m147a(r2);
    L_0x0472:
        r2 = r15 + 1;
        r15 = r2;
        goto L_0x0427;
    L_0x0476:
        r2 = " ";
        goto L_0x0449;
    L_0x0479:
        r2 = r3 * 4;
        r2 = r22[r2];
        r5 = -1;
        if (r2 == r5) goto L_0x04aa;
    L_0x0480:
        r2 = r3 * 4;
        r5 = r3 * 4;
        r5 = r5 + 4;
        r0 = r22;
        r2 = java.util.Arrays.copyOfRange(r0, r2, r5);
        r2 = com.nxp.taginfolite.p003g.C0422a.m1361a(r2);
        r5 = new com.nxp.taginfolite.b.p;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r6 = r6.append(r13);
        r4 = r6.append(r4);
        r4 = r4.toString();
        r5.<init>(r3, r4, r2);
        r14.m147a(r5);
        goto L_0x0472;
    L_0x04aa:
        r2 = new com.nxp.taginfolite.b.p;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5 = r5.append(r13);
        r4 = r5.append(r4);
        r4 = r4.toString();
        r5 = 0;
        r6 = 4;
        r7 = 0;
        r2.<init>(r3, r4, r5, r6, r7);
        r14.m147a(r2);
        goto L_0x0472;
    L_0x04c7:
        r2 = r16 + 1;
        r16 = r2;
        goto L_0x0414;
    L_0x04cd:
        if (r19 == 0) goto L_0x06e0;
    L_0x04cf:
        r0 = r19;
        r2 = r0.length;
        r3 = 16;
        if (r2 < r3) goto L_0x06e0;
    L_0x04d6:
        r2 = com.nxp.taginfolite.p009e.bb.NTAG203;
        r0 = r21;
        if (r0 != r2) goto L_0x05e7;
    L_0x04dc:
        r13 = "";
    L_0x04de:
        r2 = 40;
        if (r2 < r10) goto L_0x04e3;
    L_0x04e2:
        r13 = r9;
    L_0x04e3:
        if (r17 != 0) goto L_0x05eb;
    L_0x04e5:
        r2 = "p";
        r2 = r2.equals(r13);
        if (r2 == 0) goto L_0x05eb;
    L_0x04ed:
        r2 = new com.nxp.taginfolite.b.p;
        r3 = 40;
        r4 = "?p";
        r5 = 1;
        r6 = 2;
        r7 = "(LOCK2-LOCK3)";
        r2.<init>(r3, r4, r5, r6, r7);
        r14.m147a(r2);
    L_0x04fd:
        r2 = 41;
        r4 = com.nxp.taginfolite.p009e.p014e.C0304l.m820a(r2, r12, r11);
        r2 = 41;
        if (r2 < r10) goto L_0x0508;
    L_0x0507:
        r13 = r9;
    L_0x0508:
        if (r17 != 0) goto L_0x061f;
    L_0x050a:
        r2 = "p";
        r2 = r2.equals(r13);
        if (r2 == 0) goto L_0x061f;
    L_0x0512:
        r2 = new com.nxp.taginfolite.b.p;
        r3 = 41;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r4 = r5.append(r4);
        r5 = "p";
        r4 = r4.append(r5);
        r4 = r4.toString();
        r5 = 1;
        r6 = 2;
        r7 = "(CNT0-CNT1)";
        r2.<init>(r3, r4, r5, r6, r7);
        r14.m147a(r2);
    L_0x0533:
        r2 = com.nxp.taginfolite.p009e.bb.NTAG203;
        r0 = r21;
        if (r0 == r2) goto L_0x05a9;
    L_0x0539:
        r2 = 42;
        r4 = com.nxp.taginfolite.p009e.p014e.C0304l.m820a(r2, r12, r11);
        r2 = 42;
        if (r2 < r10) goto L_0x0544;
    L_0x0543:
        r13 = r9;
    L_0x0544:
        if (r17 != 0) goto L_0x068e;
    L_0x0546:
        r2 = "p";
        r2 = r2.equals(r13);
        if (r2 == 0) goto L_0x068e;
    L_0x054e:
        r2 = 48;
        if (r10 <= r2) goto L_0x0666;
    L_0x0552:
        r2 = new com.nxp.taginfolite.b.p;
        r3 = 42;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r4 = r5.append(r4);
        r5 = "p";
        r4 = r4.append(r5);
        r4 = r4.toString();
        r5 = 1;
        r6 = 1;
        r7 = "(AUTH0)";
        r2.<init>(r3, r4, r5, r6, r7);
        r14.m147a(r2);
    L_0x0573:
        r2 = 43;
        r4 = com.nxp.taginfolite.p009e.p014e.C0304l.m820a(r2, r12, r11);
        r2 = 43;
        if (r2 < r10) goto L_0x082c;
    L_0x057d:
        r2 = r9;
    L_0x057e:
        if (r17 != 0) goto L_0x06b7;
    L_0x0580:
        r3 = "p";
        r3 = r3.equals(r2);
        if (r3 == 0) goto L_0x06b7;
    L_0x0588:
        r2 = new com.nxp.taginfolite.b.p;
        r3 = 43;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r4 = r5.append(r4);
        r5 = "p";
        r4 = r4.append(r5);
        r4 = r4.toString();
        r5 = 1;
        r6 = 1;
        r7 = "(AUTH1)";
        r2.<init>(r3, r4, r5, r6, r7);
        r14.m147a(r2);
    L_0x05a9:
        r2 = "?";
        if (r19 == 0) goto L_0x0829;
    L_0x05ad:
        r0 = r19;
        r3 = r0.length;
        r4 = 16;
        if (r3 < r4) goto L_0x0829;
    L_0x05b4:
        r2 = 44;
        r2 = com.nxp.taginfolite.p009e.p014e.C0304l.m820a(r2, r12, r11);
        r12 = r2;
    L_0x05bb:
        if (r17 == 0) goto L_0x076b;
    L_0x05bd:
        r0 = r17;
        r2 = r0.length;
        r4 = new byte[r2];
        r2 = 0;
    L_0x05c3:
        r3 = 4;
        if (r2 >= r3) goto L_0x072f;
    L_0x05c6:
        r3 = 7 - r2;
        r3 = r17[r3];
        r4[r2] = r3;
        r3 = r2 + 4;
        r5 = 3 - r2;
        r5 = r17[r5];
        r4[r3] = r5;
        r3 = r2 + 8;
        r5 = 15 - r2;
        r5 = r17[r5];
        r4[r3] = r5;
        r3 = r2 + 12;
        r5 = 11 - r2;
        r5 = r17[r5];
        r4[r3] = r5;
        r2 = r2 + 1;
        goto L_0x05c3;
    L_0x05e7:
        r13 = " ";
        goto L_0x04de;
    L_0x05eb:
        r2 = 40;
        r2 = com.nxp.taginfolite.p009e.p014e.C0304l.m820a(r2, r12, r11);
        r3 = new com.nxp.taginfolite.b.p;
        r4 = 40;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r2 = r5.append(r2);
        r2 = r2.append(r13);
        r2 = r2.toString();
        r5 = 2;
        r5 = new byte[r5];
        r6 = 0;
        r7 = 0;
        r7 = r19[r7];
        r5[r6] = r7;
        r6 = 1;
        r7 = 1;
        r7 = r19[r7];
        r5[r6] = r7;
        r6 = "(LOCK2-LOCK3)";
        r3.<init>(r4, r2, r5, r6);
        r14.m147a(r3);
        goto L_0x04fd;
    L_0x061f:
        r2 = 5;
        r2 = r19[r2];
        r3 = 4;
        r3 = r19[r3];
        r2 = com.nxp.taginfolite.p003g.C0429j.m1388a(r2, r3);
        r3 = new com.nxp.taginfolite.b.p;
        r5 = 41;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r4 = r6.append(r4);
        r4 = r4.append(r13);
        r4 = r4.toString();
        r6 = 2;
        r6 = new byte[r6];
        r7 = 0;
        r15 = 4;
        r15 = r19[r15];
        r6[r7] = r15;
        r7 = 1;
        r15 = 5;
        r15 = r19[r15];
        r6[r7] = r15;
        r7 = "(CNT0-CNT1, value: %d)";
        r15 = 1;
        r15 = new java.lang.Object[r15];
        r16 = 0;
        r2 = java.lang.Integer.valueOf(r2);
        r15[r16] = r2;
        r2 = java.lang.String.format(r7, r15);
        r3.<init>(r5, r4, r6, r2);
        r14.m147a(r3);
        goto L_0x0533;
    L_0x0666:
        r2 = new com.nxp.taginfolite.b.p;
        r3 = 42;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r4 = r5.append(r4);
        r5 = "p";
        r4 = r4.append(r5);
        r4 = r4.toString();
        r5 = 1;
        r5 = new byte[r5];
        r6 = 0;
        r7 = (byte) r10;
        r5[r6] = r7;
        r6 = "(AUTH0)";
        r2.<init>(r3, r4, r5, r6);
        r14.m147a(r2);
        goto L_0x0573;
    L_0x068e:
        r2 = new com.nxp.taginfolite.b.p;
        r3 = 42;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r4 = r5.append(r4);
        r4 = r4.append(r13);
        r4 = r4.toString();
        r5 = 1;
        r5 = new byte[r5];
        r6 = 0;
        r7 = 8;
        r7 = r19[r7];
        r5[r6] = r7;
        r6 = "(AUTH0)";
        r2.<init>(r3, r4, r5, r6);
        r14.m147a(r2);
        goto L_0x0573;
    L_0x06b7:
        r3 = new com.nxp.taginfolite.b.p;
        r5 = 43;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r4 = r6.append(r4);
        r2 = r4.append(r2);
        r2 = r2.toString();
        r4 = 1;
        r4 = new byte[r4];
        r6 = 0;
        r7 = 12;
        r7 = r19[r7];
        r4[r6] = r7;
        r6 = "(AUTH1)";
        r3.<init>(r5, r2, r4, r6);
        r14.m147a(r3);
        goto L_0x05a9;
    L_0x06e0:
        r2 = r10 & 255;
        r3 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r2 != r3) goto L_0x06e8;
    L_0x06e6:
        r10 = 40;
    L_0x06e8:
        r2 = new com.nxp.taginfolite.b.p;
        r3 = 40;
        r4 = "?p";
        r5 = 1;
        r6 = 2;
        r7 = "(LOCK2-LOCK3)";
        r2.<init>(r3, r4, r5, r6, r7);
        r14.m147a(r2);
        r2 = new com.nxp.taginfolite.b.p;
        r3 = 41;
        r4 = "?p";
        r5 = 1;
        r6 = 2;
        r7 = "(CNT0-CNT1)";
        r2.<init>(r3, r4, r5, r6, r7);
        r14.m147a(r2);
        r2 = new com.nxp.taginfolite.b.p;
        r3 = 42;
        r4 = "?p";
        r5 = 1;
        r5 = new byte[r5];
        r6 = 0;
        r7 = (byte) r10;
        r5[r6] = r7;
        r6 = "(AUTH0)";
        r2.<init>(r3, r4, r5, r6);
        r14.m147a(r2);
        r2 = new com.nxp.taginfolite.b.p;
        r3 = 43;
        r4 = "?p";
        r5 = 1;
        r6 = 1;
        r7 = "(AUTH1)";
        r2.<init>(r3, r4, r5, r6, r7);
        r14.m147a(r2);
        goto L_0x05a9;
    L_0x072f:
        r2 = 0;
        r3 = r2;
    L_0x0731:
        r2 = 4;
        if (r3 >= r2) goto L_0x07a7;
    L_0x0734:
        r5 = r3 + 44;
        r2 = "-";
        if (r5 < r10) goto L_0x0744;
    L_0x073a:
        r6 = "p";
        r6 = r6.equals(r9);
        if (r6 == 0) goto L_0x0744;
    L_0x0742:
        r2 = "P";
    L_0x0744:
        r6 = new com.nxp.taginfolite.b.p;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r7 = r7.append(r12);
        r2 = r7.append(r2);
        r2 = r2.toString();
        r7 = r3 * 4;
        r11 = r3 * 4;
        r11 = r11 + 4;
        r7 = java.util.Arrays.copyOfRange(r4, r7, r11);
        r6.<init>(r5, r2, r7);
        r14.m147a(r6);
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0731;
    L_0x076b:
        r2 = com.nxp.taginfolite.p009e.bb.NTAG203;
        r0 = r21;
        if (r0 == r2) goto L_0x07a7;
    L_0x0771:
        r2 = 0;
        r11 = r2;
    L_0x0773:
        r2 = 4;
        if (r11 >= r2) goto L_0x07a7;
    L_0x0776:
        r3 = r11 + 44;
        r2 = "-";
        if (r3 < r10) goto L_0x0826;
    L_0x077c:
        r4 = "p";
        r4 = r4.equals(r9);
        if (r4 == 0) goto L_0x0826;
    L_0x0784:
        r2 = "P";
        r4 = r2;
    L_0x0787:
        r2 = new com.nxp.taginfolite.b.p;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5 = r5.append(r12);
        r4 = r5.append(r4);
        r4 = r4.toString();
        r5 = 1;
        r6 = 4;
        r7 = 0;
        r2.<init>(r3, r4, r5, r6, r7);
        r14.m147a(r2);
        r2 = r11 + 1;
        r11 = r2;
        goto L_0x0773;
    L_0x07a7:
        r2 = new com.nxp.taginfolite.b.o;
        r3 = com.nxp.taginfolite.p003g.C0429j.m1391a(r8);
        r2.<init>(r3);
        r14.m147a(r2);
        r2 = r14;
        goto L_0x0148;
    L_0x07b6:
        r2 = move-exception;
        goto L_0x01e5;
    L_0x07b9:
        r2 = move-exception;
        r13 = r3;
        r15 = r4;
        r4 = r9;
        goto L_0x01e5;
    L_0x07bf:
        r2 = move-exception;
        r4 = r9;
        r15 = r13;
        r13 = r3;
        goto L_0x01e5;
    L_0x07c5:
        r2 = move-exception;
        r10 = r4;
        r15 = r13;
        r13 = r3;
        r4 = r9;
        goto L_0x01e5;
    L_0x07cc:
        r2 = move-exception;
        r4 = r9;
        r15 = r13;
        r13 = r14;
        goto L_0x01e5;
    L_0x07d2:
        r2 = move-exception;
        r13 = r14;
        r15 = r4;
        r4 = r9;
        goto L_0x01e5;
    L_0x07d8:
        r2 = move-exception;
        r10 = r3;
        r13 = r14;
        r15 = r4;
        r4 = r9;
        goto L_0x01e5;
    L_0x07df:
        r2 = move-exception;
        r4 = r9;
        r15 = r10;
        r10 = r13;
        r13 = r14;
        goto L_0x01e5;
    L_0x07e6:
        r2 = move-exception;
        r10 = r13;
        r15 = r3;
        r12 = r4;
        r4 = r9;
        r13 = r14;
        goto L_0x01e5;
    L_0x07ee:
        r2 = move-exception;
        r2 = r10;
        r10 = r15;
        goto L_0x010b;
    L_0x07f3:
        r2 = move-exception;
        r2 = r10;
        r3 = r13;
        r10 = r15;
        goto L_0x010b;
    L_0x07f9:
        r2 = move-exception;
        r4 = r9;
        r2 = r10;
        r10 = r13;
        goto L_0x010b;
    L_0x07ff:
        r2 = move-exception;
        r2 = r4;
        r10 = r13;
        r4 = r9;
        goto L_0x010b;
    L_0x0805:
        r2 = move-exception;
        r4 = r9;
        r2 = r10;
        r3 = r14;
        r10 = r13;
        goto L_0x010b;
    L_0x080c:
        r2 = move-exception;
        r2 = r10;
        r3 = r14;
        r10 = r4;
        r4 = r9;
        goto L_0x010b;
    L_0x0813:
        r2 = move-exception;
        r2 = r3;
        r10 = r4;
        r3 = r14;
        r4 = r9;
        goto L_0x010b;
    L_0x081a:
        r2 = move-exception;
        r2 = r13;
        r10 = r3;
        r12 = r4;
        r4 = r9;
        r3 = r14;
        goto L_0x010b;
    L_0x0822:
        r3 = move-exception;
        r4 = r12;
        goto L_0x01d8;
    L_0x0826:
        r4 = r2;
        goto L_0x0787;
    L_0x0829:
        r12 = r2;
        goto L_0x05bb;
    L_0x082c:
        r2 = r13;
        goto L_0x057e;
    L_0x082f:
        r4 = r2;
        goto L_0x044c;
    L_0x0832:
        r13 = r2;
        goto L_0x0425;
    L_0x0835:
        r11 = r2;
        r12 = r3;
        goto L_0x0411;
    L_0x0839:
        r3 = r2;
        goto L_0x03b8;
    L_0x083c:
        r9 = r2;
        r10 = r3;
        goto L_0x0134;
    L_0x0840:
        r2 = r10;
        r3 = r11;
        r4 = r12;
        goto L_0x0190;
    L_0x0845:
        r23 = r10;
        r10 = r13;
        r13 = r23;
        goto L_0x0185;
    L_0x084c:
        r14 = r3;
        r13 = r4;
        goto L_0x0154;
    L_0x0850:
        r3 = r4;
        goto L_0x00d1;
    L_0x0853:
        r9 = r4;
        goto L_0x00d4;
    L_0x0856:
        r8 = r3;
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.e.e.l.a(com.nxp.taginfolite.e.az):com.nxp.taginfolite.b.c");
    }

    private static String m820a(int i, byte b, byte b2) {
        int i2 = 7;
        int i3 = 3;
        Object obj = 1;
        if (i < 16) {
            return "?";
        }
        Object obj2;
        Object obj3;
        if (i < 40) {
            i2 = ((i - 16) / 4) + 1;
            if (i >= 28) {
                i2++;
            }
            obj3 = ((b >> i2) & 1) == 1 ? 1 : null;
            if (((b >> (i < 28 ? 0 : 4)) & 1) != 1) {
                obj = null;
            }
            obj2 = obj3;
        } else if (i == 40) {
            if (!((b & 17) == 17 && (b2 & 15) == 15)) {
                obj = null;
            }
            obj2 = obj;
        } else {
            int i4 = (i - 40) + 4;
            if (i4 <= 7) {
                i2 = i4;
            }
            obj3 = ((b2 >> i2) & 1) == 1 ? 1 : null;
            i4 = i - 40;
            if (i4 <= 3) {
                i3 = i4;
            }
            if (((b2 >> i3) & 1) != 1) {
                obj = null;
            }
            obj2 = obj3;
        }
        return (obj2 == null || obj == null) ? obj2 != null ? "x" : obj != null ? "+" : "." : "*";
    }

    private static List m821a() {
        List arrayList = new ArrayList();
        arrayList.add(new C0354g(new C0422a(f803a), null));
        arrayList.add(new C0354g(new C0422a(f804b), null));
        Collection a = C0354g.m1058a(C0304l.m824b());
        if (a != null) {
            arrayList.addAll(a);
        }
        return C0354g.m1059a(arrayList);
    }

    public static boolean m822a(MifareUltralight mifareUltralight, byte[] bArr) {
        boolean z = true;
        Object obj = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "DESede");
        byte[] bArr2 = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        try {
            byte[] a = C0304l.m823a(mifareUltralight);
            if ((a[0] & MotionEventCompat.ACTION_MASK) != 175) {
                return false;
            }
            a = Arrays.copyOfRange(a, 1, 9);
            bArr2 = C0353f.m1056a(a, 2, secretKeySpec, bArr2);
            Object obj2 = new byte[]{bArr2[1], bArr2[2], bArr2[3], bArr2[4], bArr2[5], bArr2[6], bArr2[7], bArr2[0]};
            Object obj3 = new byte[(obj.length + obj2.length)];
            System.arraycopy(obj, 0, obj3, 0, obj.length);
            System.arraycopy(obj2, 0, obj3, obj.length, obj2.length);
            obj = C0353f.m1056a(obj3, 1, secretKeySpec, a);
            Object obj4 = new byte[(obj.length + 1)];
            obj4[0] = (byte) -81;
            System.arraycopy(obj, 0, obj4, 1, obj.length);
            if (mifareUltralight.transceive(obj4)[0] != null) {
                z = false;
            }
            return z;
        } catch (IOException e) {
            try {
                mifareUltralight.close();
                mifareUltralight.connect();
                return false;
            } catch (IOException e2) {
                return false;
            }
        } catch (GeneralSecurityException e3) {
            return false;
        }
    }

    public static byte[] m823a(MifareUltralight mifareUltralight) {
        return mifareUltralight.transceive(new byte[]{(byte) 26, (byte) 0});
    }

    private static Cursor m824b() {
        return TagInfoApp.m10a().query(UserKeys.f350c, new String[]{"key_value", "key_type"}, "enabled = '" + Integer.toString(1) + "' AND " + "chip" + " = '" + "ULC" + "'", null, null);
    }
}
