package com.nxp.taginfolite.fragments;

import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.R;

class ac extends C0387l {
    final /* synthetic */ aa f1255a;

    private ac(aa aaVar) {
        this.f1255a = aaVar;
        super(aaVar);
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        this.f1255a.d = this.f1255a.h.m1155d();
        this.f1255a.e = this.f1255a.h.m1153c();
        if (this.f1255a.e == 0) {
            return true;
        }
        if (this.f1255a.e == 1) {
            long itemId = this.f1255a.h.getItemId(this.f1255a.d.keyAt(0));
            switch (menuItem.getItemId()) {
                case R.id.share_scan:
                    this.f1255a.m1231d(itemId);
                    break;
                case R.id.send_scan:
                    this.f1255a.m1229c(itemId);
                    break;
                case R.id.send_scan_ndef:
                    this.f1255a.m1233e(itemId);
                    break;
                case R.id.delete_scan:
                    this.f1255a.m1216k();
                    break;
                case R.id.find_similar:
                    this.f1255a.m1226b(itemId);
                    break;
                case R.id.edit_scan_title:
                    this.f1255a.m1235f(itemId);
                    break;
            }
        } else if (this.f1255a.e != 2 || menuItem.getItemId() != R.id.compare_scans) {
            switch (menuItem.getItemId()) {
                case R.id.share_scan:
                    this.f1255a.m1244z();
                    break;
                case R.id.send_scan:
                    this.f1255a.m1243y();
                    break;
                case R.id.delete_scan:
                    this.f1255a.m1216k();
                    break;
                default:
                    break;
            }
        } else {
            C0196b.m180a(this.f1255a.f, (int) R.string.toast_function_not_implemented);
        }
        actionMode.finish();
        this.f1255a.d = null;
        this.f1255a.e = 0;
        return false;
    }
}
