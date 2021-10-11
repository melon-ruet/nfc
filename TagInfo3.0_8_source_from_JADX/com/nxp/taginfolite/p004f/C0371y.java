package com.nxp.taginfolite.p004f;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.BuildConfig;
import com.nxp.taginfolite.database.C0233b;
import com.nxp.taginfolite.p006c.C0197a;
import com.nxp.taginfolite.p006c.C0198b;
import com.nxp.taginfolite.p006c.C0199c;
import com.nxp.taginfolite.p006c.C0200d;
import com.nxp.taginfolite.p009e.C0271c;
import com.nxp.taginfolite.p009e.ay;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.nxp.taginfolite.f.y */
public class C0371y extends C0370w {
    private String f1182e;

    public C0371y(C0176x c0176x, Activity activity, Intent intent) {
        super(c0176x, activity, intent);
    }

    public C0199c m1109a() {
        C0199c c0199c = new C0199c();
        ay a = this.b.m303a();
        if (a != null) {
            a.m399a(c0199c, true);
            if (this.b.m311d()) {
                this.b.m308b().m485a(c0199c, true);
            }
            C0271c c = this.b.m310c();
            if (c != null) {
                c.m710a(c0199c, true);
            }
            c0199c.m226a(this.c.m289e(), this.c.m290f());
        } else {
            c0199c.m225a();
            c0199c.m226a(this.c.m289e(), this.c.m290f());
        }
        return c0199c;
    }

    protected String m1111a(Void[] voidArr) {
        ay a = this.b.m303a();
        return C0233b.m345a(this.a, this.f1182e, this.c, this.b, m1109a(), this.c.m281a(this.a, a != null ? a.m404d() : BuildConfig.VERSION_NAME), m1112b(), m1113c(), m1114d());
    }

    public C0198b m1112b() {
        C0198b c0198b = new C0198b();
        ay a = this.b.m303a();
        if (a != null) {
            c0198b.m212a();
            if (this.b.m311d()) {
                this.b.m308b().m484a(c0198b, true);
            }
            C0271c c = this.b.m310c();
            if (c != null) {
                c.m643a(c0198b, true);
            }
            a.m398a(c0198b, true);
        } else {
            c0198b.m212a();
        }
        return c0198b;
    }

    public C0197a m1113c() {
        C0197a c0197a = new C0197a();
        ay a = this.b.m303a();
        if (a != null) {
            c0197a.m191a();
            if (this.b.m311d()) {
                this.b.m308b().m483a(c0197a, true);
            }
            C0271c c = this.b.m310c();
            if (c != null) {
                c.m709a(c0197a, true);
            }
            a.m397a(c0197a, true);
        } else {
            c0197a.m191a();
        }
        return c0197a;
    }

    public C0200d m1114d() {
        C0200d c0200d = new C0200d();
        ay a = this.b.m303a();
        if (a != null) {
            c0200d.m236a();
            a.m400a(c0200d, true);
            if (this.b.m311d()) {
                this.b.m308b().m486a(c0200d, true);
            } else {
                C0271c c = this.b.m310c();
                if (c != null) {
                    c.m711a(c0200d, true);
                }
            }
        } else {
            c0200d.m236a();
        }
        c0200d.m240b(this.b.m312e());
        return c0200d;
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f1182e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
