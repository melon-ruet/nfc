package com.nxp.taginfolite.p009e.p013d;

import android.support.v4.view.MotionEventCompat;
import android.util.SparseArray;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.C0360m;
import com.nxp.taginfolite.p004f.C0369v;
import com.nxp.taginfolite.p009e.C0270w;
import java.util.Arrays;

/* renamed from: com.nxp.taginfolite.e.d.o */
public class C0286o {
    private static final SparseArray f735a;

    static {
        f735a = new C0287p();
    }

    public static String m753a(byte[] bArr) {
        C0428i c0428i = new C0428i();
        int i = (bArr[12] & MotionEventCompat.ACTION_MASK) + 1;
        int i2 = (bArr[13] & MotionEventCompat.ACTION_MASK) + 1;
        c0428i.m1384a(String.format("Memory size: %d bytes", new Object[]{Integer.valueOf(i2 * i)}));
        c0428i.m1384a(String.format(C0358k.f1076c + "%d blocks, with %d bytes per block", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        c0428i.m1387b("64-bit U");
        c0428i.m1384a(C0369v.m1094a(Arrays.copyOfRange(bArr, 2, 10), C0360m.ISO15693));
        c0428i.m1384a(String.format("IC revision: 0x%02X", new Object[]{Byte.valueOf(bArr[14])}));
        return c0428i.toString();
    }

    public static void m754a(C0270w c0270w) {
        c0270w.m660g();
        byte[] transceive = c0270w.m661h().transceive(new byte[]{(byte) 43});
        if (transceive != null && transceive.length > 0 && transceive[0] == null) {
            c0270w.m640a(65538);
            c0270w.m647a((C0279h) f735a.get(((transceive[7] & 15) << 4) | ((transceive[6] & 240) >> 4)));
            c0270w.m655b(transceive);
        }
    }
}
