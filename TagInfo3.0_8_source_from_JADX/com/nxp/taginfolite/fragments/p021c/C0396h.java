package com.nxp.taginfolite.fragments.p021c;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.fragments.c.h */
public class C0396h implements OnClickListener {
    private final Activity f1292a;
    private final Button f1293b;
    private final C0390a f1294c;
    private final String f1295d;

    public C0396h(Activity activity, Button button, C0385g c0385g) {
        this.f1292a = activity;
        this.f1293b = button;
        this.f1294c = new C0390a(activity, this.f1293b);
        this.f1294c.m1291a((int) R.id.action_select_all, activity.getString(R.string.select_all));
        this.f1294c.m1292a(c0385g);
        this.f1293b.setOnClickListener(this);
        this.f1295d = activity.getString(R.string.toggle_all);
    }

    public void m1295a(int i, boolean z) {
        C0394e b = this.f1294c.m1293b((int) R.id.action_select_all);
        if (b != null) {
            b.m1294a(this.f1292a.getString(z ? R.string.deselect_all : R.string.select_all));
        }
        if (z || i == 0) {
            this.f1294c.m1290a((int) R.id.action_toggle_selection);
        } else if (this.f1294c.m1293b((int) R.id.action_toggle_selection) == null) {
            this.f1294c.m1291a((int) R.id.action_toggle_selection, this.f1295d);
        }
    }

    public void m1296a(CharSequence charSequence) {
        this.f1293b.setText(charSequence);
    }

    public void onClick(View view) {
        this.f1294c.m1289a();
    }
}
