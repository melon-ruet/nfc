package com.nxp.taginfolite.fragments;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.actionbarsherlock.widget.SearchView;

/* renamed from: com.nxp.taginfolite.fragments.z */
class C0421z implements OnClickListener {
    final /* synthetic */ SearchView f1341a;
    final /* synthetic */ int f1342b;
    final /* synthetic */ C0384x f1343c;

    C0421z(C0384x c0384x, SearchView searchView, int i) {
        this.f1343c = c0384x;
        this.f1341a = searchView;
        this.f1342b = i;
    }

    public void onClick(View view) {
        if (TextUtils.isEmpty(this.f1343c.f1219b)) {
            this.f1341a.setQueryHint(this.f1343c.getString(this.f1342b));
        } else {
            this.f1341a.setQuery(this.f1343c.f1219b, true);
        }
    }
}
