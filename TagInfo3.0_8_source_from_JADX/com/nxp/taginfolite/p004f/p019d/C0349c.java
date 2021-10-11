package com.nxp.taginfolite.p004f.p019d;

import android.support.v4.view.MotionEventCompat;
import com.nxp.taginfolite.p003g.C0429j;

/* renamed from: com.nxp.taginfolite.f.d.c */
public class C0349c {
    private final int f1053a;
    private final int f1054b;

    public C0349c(int i, int i2) {
        this.f1053a = i;
        this.f1054b = i2;
    }

    public int m1021a() {
        return this.f1053a;
    }

    public byte m1022b() {
        return (byte) ((this.f1053a >> 8) & MotionEventCompat.ACTION_MASK);
    }

    public byte m1023c() {
        return (byte) (this.f1053a & MotionEventCompat.ACTION_MASK);
    }

    public int m1024d() {
        return C0429j.m1388a(m1023c(), m1022b());
    }

    public int m1025e() {
        return this.f1054b;
    }
}
