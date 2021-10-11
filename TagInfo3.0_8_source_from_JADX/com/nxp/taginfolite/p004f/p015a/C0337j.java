package com.nxp.taginfolite.p004f.p015a;

import com.nxp.taginfolite.p003g.C0329f;
import com.nxp.taginfolite.p003g.C0422a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

/* renamed from: com.nxp.taginfolite.f.a.j */
public class C0337j extends C0328a {
    private byte[] f984f;
    private int f985g;
    private int f986h;
    private int f987i;
    private int f988j;

    public C0337j(C0332d c0332d, int i, boolean z, byte[] bArr) {
        super(c0332d, i, z, bArr);
        this.f984f = new byte[((this.f984f == null ? new byte[0] : this.f984f).length + bArr.length)];
        C0422a.m1359a(this.f984f, r0, bArr);
        this.f988j = this.f984f.length;
    }

    public C0337j(C0333f c0333f) {
        super(c0333f.m952a(), c0333f.m954c(), c0333f.m953b(), new byte[0]);
    }

    public C0337j(byte[] bArr) {
        this(C0332d.PRIVATE, 0, true, bArr);
    }

    private C0337j(byte[] bArr, int i) {
        super(bArr, i);
        this.f985g = i;
        this.f984f = bArr;
        this.f988j = (this.f986h + this.f987i) + this.e;
    }

    public static C0337j m957c(byte[] bArr, int i) {
        try {
            return new C0337j(bArr, i);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected int m958a(byte[] bArr, int i) {
        int a = super.m937a(bArr, i);
        this.f986h = a;
        return a;
    }

    public List m959a(int i) {
        return super.m944b(new C0334g(new C0337j(new C0333f(i))));
    }

    public byte[] m960a() {
        byte[] a = super.m941a();
        this.f984f = new byte[((this.f984f == null ? new byte[0] : this.f984f).length + a.length)];
        C0422a.m1359a(this.f984f, r0, a);
        this.f986h = a.length;
        return a;
    }

    protected int m961b(byte[] bArr, int i) {
        int b = super.m942b(bArr, i);
        this.f987i = b;
        return b;
    }

    public C0337j m962b(int i) {
        return (C0337j) super.m939a(new C0334g(new C0337j(new C0333f(i))));
    }

    public List m963b(int i, C0329f c0329f) {
        List arrayList = new ArrayList();
        if (!this.b) {
            return arrayList;
        }
        int j = m968j();
        while (true) {
            int i2;
            C0337j c = C0337j.m957c(this.f984f, j);
            if (c == null) {
                i2 = j + 1;
            } else {
                EnumSet enumSet = (EnumSet) c0329f.m948a(c);
                if (enumSet.contains(C0331c.SEARCH_CHILDREN) && i > 0 && c.m947d()) {
                    arrayList.addAll(c.m963b(i - 1, c0329f));
                }
                if (enumSet.contains(C0331c.ACCEPT)) {
                    arrayList.add(c);
                }
                i2 = c.m969k() + j;
            }
            if (i2 >= m969k()) {
                return arrayList;
            }
            j = i2;
        }
    }

    public byte[] m964b() {
        byte[] b = super.m945b();
        this.f984f = new byte[((this.f984f == null ? new byte[0] : this.f984f).length + b.length)];
        C0422a.m1359a(this.f984f, r0, b);
        this.f987i = b.length;
        return b;
    }

    public byte[] m965g() {
        return Arrays.copyOfRange(this.f984f, m968j(), m968j() + this.e);
    }

    public int m966h() {
        return this.f985g;
    }

    public int m967i() {
        return m966h() + this.f986h;
    }

    public int m968j() {
        return m967i() + this.f987i;
    }

    public int m969k() {
        return this.f988j;
    }

    public byte[] m970l() {
        return Arrays.copyOfRange(this.f984f, this.f985g, this.f985g + m969k());
    }
}
