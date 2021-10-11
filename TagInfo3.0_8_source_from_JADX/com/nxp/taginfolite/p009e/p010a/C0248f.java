package com.nxp.taginfolite.p009e.p010a;

import com.nxp.taginfolite.p009e.aq;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.a.f */
public class C0248f implements Comparable {
    private final Integer f381a;
    private final int f382b;
    private final aq f383c;

    public C0248f(int i, int i2) {
        this.f381a = Integer.valueOf(i);
        this.f382b = i2;
        this.f383c = aq.OK;
    }

    public C0248f(int i, aq aqVar) {
        this.f381a = null;
        this.f382b = i;
        this.f383c = aqVar;
    }

    public int m387a(C0248f c0248f) {
        return c0248f == null ? 1 : !m390c() ? !c0248f.m390c() ? this.f383c.compareTo(c0248f.f383c) : 1 : c0248f.m390c() ? this.f381a.compareTo(c0248f.f381a) : 1;
    }

    public Integer m388a() {
        return this.f381a;
    }

    public int m389b() {
        return this.f382b;
    }

    public boolean m390c() {
        return this.f383c == aq.OK;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m387a((C0248f) obj);
    }

    public aq m391d() {
        return this.f383c;
    }

    public String m392e() {
        switch (C0249g.f384a[this.f383c.ordinal()]) {
            case C0519c.Switch_track /*1*/:
                return "no error";
            case C0519c.Switch_textOn /*2*/:
                return "read error";
            case C0519c.Switch_textOff /*3*/:
                return "wrong key";
            default:
                return "unknown error";
        }
    }
}
