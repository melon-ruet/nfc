package com.nxp.taginfolite.p004f.p015a;

/* renamed from: com.nxp.taginfolite.f.a.e */
public abstract class C0327e {
    protected int f956d;
    protected int f957e;

    protected C0327e() {
    }

    public C0327e(int i, byte[] bArr) {
        this();
        this.f956d = i;
        this.f957e = bArr == null ? 0 : bArr.length;
    }

    public int m934e() {
        return this.f956d;
    }

    public int m935f() {
        return this.f957e;
    }

    public abstract byte[] m936g();
}
