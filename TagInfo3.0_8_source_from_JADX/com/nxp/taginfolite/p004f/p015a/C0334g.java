package com.nxp.taginfolite.p004f.p015a;

import com.nxp.taginfolite.p003g.C0329f;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.f.a.g */
public class C0334g implements C0329f {
    public static final EnumSet f973d;
    C0328a f974a;
    EnumSet f975b;
    boolean f976c;

    static {
        f973d = EnumSet.of(C0336i.TAG_CLASS, C0336i.CONSTRUCTED, C0336i.TAG_NUMBER);
    }

    public C0334g(C0328a c0328a) {
        this(c0328a, f973d, true);
    }

    public C0334g(C0328a c0328a, EnumSet enumSet, boolean z) {
        this.f976c = z;
        this.f974a = c0328a;
        this.f975b = enumSet;
    }

    public EnumSet m956a(C0328a c0328a) {
        EnumSet of = this.f976c ? EnumSet.of(C0331c.SEARCH_CHILDREN) : EnumSet.noneOf(C0331c.class);
        Iterator it = this.f975b.iterator();
        while (it.hasNext()) {
            switch (C0335h.f977a[((C0336i) it.next()).ordinal()]) {
                case C0519c.Switch_track /*1*/:
                    if (!this.f974a.m946c().equals(c0328a.m946c())) {
                        break;
                    }
                    continue;
                case C0519c.Switch_textOn /*2*/:
                    if (this.f974a.m947d() != c0328a.m947d()) {
                        break;
                    }
                    continue;
                case C0519c.Switch_textOff /*3*/:
                    if (this.f974a.m934e() != c0328a.m934e()) {
                        break;
                    }
                    continue;
                case C0519c.Switch_thumbTextPadding /*4*/:
                    if (this.f974a.m935f() != c0328a.m935f()) {
                        break;
                    }
                    continue;
                case C0519c.Switch_switchTextAppearance /*5*/:
                    if (!Arrays.equals(this.f974a.m936g(), c0328a.m936g())) {
                        break;
                    }
                    continue;
                default:
                    continue;
            }
            return of;
        }
        of.add(C0331c.ACCEPT);
        return of;
    }
}
