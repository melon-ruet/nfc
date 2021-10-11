package com.nxp.taginfolite.data;

import android.nfc.Tag;
import com.nxp.taginfolite.p009e.C0271c;
import com.nxp.taginfolite.p009e.ag;
import com.nxp.taginfolite.p009e.ay;

/* renamed from: com.nxp.taginfolite.data.g */
public class C0213g {
    private Tag f246a;
    private ay f247b;
    private ag f248c;
    private C0271c f249d;
    private boolean f250e;
    private String f251f;
    private String f252g;

    public C0213g() {
        this.f247b = null;
        this.f248c = null;
        this.f250e = false;
        this.f251f = null;
        this.f252g = null;
    }

    public ay m303a() {
        return this.f247b;
    }

    public void m304a(Tag tag) {
        this.f246a = tag;
    }

    public void m305a(ay ayVar, ag agVar, C0271c c0271c) {
        this.f247b = ayVar;
        this.f248c = agVar;
        this.f249d = c0271c;
    }

    public void m306a(String str) {
        this.f251f = str;
    }

    public void m307a(boolean z) {
        this.f250e = z;
    }

    public ag m308b() {
        return this.f248c;
    }

    public void m309b(String str) {
        this.f252g = str;
    }

    public C0271c m310c() {
        return this.f249d;
    }

    public boolean m311d() {
        return this.f250e;
    }

    public String m312e() {
        return this.f251f;
    }

    public String m313f() {
        return this.f252g;
    }
}
