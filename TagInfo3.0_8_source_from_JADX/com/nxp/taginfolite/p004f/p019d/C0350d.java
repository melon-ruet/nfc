package com.nxp.taginfolite.p004f.p019d;

import android.support.v4.view.MotionEventCompat;
import com.nxp.taginfolite.p003g.C0429j;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.nxp.taginfolite.f.d.d */
public class C0350d implements Iterable {
    private final int f1055a;
    private final int f1056b;
    private final ArrayList f1057c;
    private final int f1058d;
    private final boolean f1059e;
    private final int[] f1060f;
    private final int[] f1061g;
    private final boolean f1062h;

    public C0350d(byte[] bArr, int i) {
        this.f1055a = i;
        this.f1056b = i & 3;
        this.f1058d = bArr[1] != null ? bArr[1] & 63 : -1;
        this.f1059e = (i & 64) != 0;
        this.f1057c = new ArrayList();
        int i2 = this.f1056b == 2 ? 80 : 32;
        int i3 = 2;
        int i4 = 1;
        while (i3 < i2 && i3 + 1 < bArr.length) {
            int i5;
            if (i3 == 32) {
                i5 = i4 + 1;
            } else {
                i5 = i4 + 1;
                this.f1057c.add(new C0349c(C0429j.m1388a(bArr[i3 + 1], bArr[i3]), i4));
            }
            i3 += 2;
            i4 = i5;
        }
        if (bArr.length > 32) {
            this.f1060f = new int[]{bArr[0] & MotionEventCompat.ACTION_MASK, bArr[32] & MotionEventCompat.ACTION_MASK};
            this.f1061g = new int[2];
        } else {
            this.f1060f = new int[]{bArr[0] & MotionEventCompat.ACTION_MASK};
            this.f1061g = new int[1];
        }
        this.f1062h = m1026a(bArr);
    }

    private boolean m1026a(byte[] bArr) {
        byte b = (byte) -57;
        byte b2 = (byte) -57;
        for (int i = 1; i < 32; i++) {
            b2 = (byte) (b2 ^ bArr[i]);
            b2 = (byte) (((b2 & MotionEventCompat.ACTION_MASK) >>> 4) ^ (((b2 & MotionEventCompat.ACTION_MASK) ^ ((b2 & MotionEventCompat.ACTION_MASK) >>> 6)) ^ ((b2 & MotionEventCompat.ACTION_MASK) >>> 5)));
            b2 = (byte) (((b2 & MotionEventCompat.ACTION_MASK) << 4) ^ (((b2 & MotionEventCompat.ACTION_MASK) ^ ((b2 & MotionEventCompat.ACTION_MASK) << 2)) ^ ((b2 & MotionEventCompat.ACTION_MASK) << 3)));
        }
        this.f1061g[0] = b2 & MotionEventCompat.ACTION_MASK;
        boolean z = bArr[0] == b2;
        if (bArr.length <= 32) {
            return z;
        }
        for (int i2 = 33; i2 < 80; i2++) {
            b = (byte) (b ^ bArr[i2]);
            b = (byte) (((b & MotionEventCompat.ACTION_MASK) >>> 4) ^ (((b & MotionEventCompat.ACTION_MASK) ^ ((b & MotionEventCompat.ACTION_MASK) >>> 6)) ^ ((b & MotionEventCompat.ACTION_MASK) >>> 5)));
            b = (byte) (((b & MotionEventCompat.ACTION_MASK) << 4) ^ (((b & MotionEventCompat.ACTION_MASK) ^ ((b & MotionEventCompat.ACTION_MASK) << 2)) ^ ((b & MotionEventCompat.ACTION_MASK) << 3)));
        }
        this.f1061g[1] = b & MotionEventCompat.ACTION_MASK;
        return z && bArr[32] == b;
    }

    public int[] m1027a() {
        return this.f1060f;
    }

    public int[] m1028b() {
        return this.f1061g;
    }

    public int m1029c() {
        return this.f1056b;
    }

    public boolean m1030d() {
        return this.f1059e;
    }

    public int m1031e() {
        return this.f1058d;
    }

    public int m1032f() {
        return this.f1057c.size();
    }

    public Iterator iterator() {
        return this.f1057c == null ? null : this.f1057c.iterator();
    }
}
