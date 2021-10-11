package com.nxp.taginfolite.fragments;

import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.fragments.f */
class C0399f extends C0387l {
    final /* synthetic */ C0397d f1298a;

    private C0399f(C0397d c0397d) {
        this.f1298a = c0397d;
        super(c0397d);
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        this.f1298a.d = this.f1298a.h.m1155d();
        this.f1298a.e = this.f1298a.h.m1153c();
        if (this.f1298a.e == 0) {
            return true;
        }
        if (this.f1298a.e != 1) {
            switch (menuItem.getItemId()) {
                case R.id.delete_key:
                    this.f1298a.m1216k();
                    break;
                default:
                    break;
            }
        }
        int keyAt = this.f1298a.d.keyAt(0);
        switch (menuItem.getItemId()) {
            case R.id.copy_key:
                this.f1298a.m1298b(keyAt);
                break;
            case R.id.delete_key:
                this.f1298a.m1216k();
                break;
        }
        actionMode.finish();
        this.f1298a.d = null;
        this.f1298a.e = 0;
        return false;
    }
}
