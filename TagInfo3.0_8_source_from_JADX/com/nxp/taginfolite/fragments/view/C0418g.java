package com.nxp.taginfolite.fragments.view;

/* renamed from: com.nxp.taginfolite.fragments.view.g */
class C0418g implements C0415d {
    private int[] f1337a;
    private int[] f1338b;

    private C0418g() {
    }

    public final int m1348a(int i) {
        return this.f1337a[i % this.f1337a.length];
    }

    void m1349a(int... iArr) {
        this.f1337a = iArr;
    }

    public final int m1350b(int i) {
        return this.f1338b[i % this.f1338b.length];
    }

    void m1351b(int... iArr) {
        this.f1338b = iArr;
    }
}
