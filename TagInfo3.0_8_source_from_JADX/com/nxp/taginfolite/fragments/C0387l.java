package com.nxp.taginfolite.fragments;

import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode.Callback;
import com.actionbarsherlock.view.Menu;

/* renamed from: com.nxp.taginfolite.fragments.l */
public abstract class C0387l implements Callback {
    final /* synthetic */ C0386g f1254b;

    protected C0387l(C0386g c0386g) {
        this.f1254b = c0386g;
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        actionMode.getMenuInflater().inflate(this.f1254b.f1245t, menu);
        this.f1254b.m1202a(menu, this.f1254b.f1233h.m1153c());
        return true;
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.f1254b.f1233h.m1151b();
        this.f1254b.f1246w = null;
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }
}
