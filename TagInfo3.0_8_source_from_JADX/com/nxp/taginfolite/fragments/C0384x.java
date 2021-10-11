package com.nxp.taginfolite.fragments;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.BuildConfig;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.SearchView;
import com.actionbarsherlock.widget.SearchView.OnQueryTextListener;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.fragments.x */
public abstract class C0384x extends SherlockListFragment implements OnQueryTextListener {
    private MenuItem f1218a;
    private String f1219b;
    private boolean f1220c;
    private boolean f1221d;
    private C0158a f1222e;
    protected String f1223u;
    protected FragmentActivity f1224v;

    public C0384x() {
        this.f1218a = null;
        this.f1219b = null;
        this.f1223u = null;
        this.f1220c = false;
        this.f1221d = false;
    }

    private void m1185c() {
        this.f1219b = BuildConfig.VERSION_NAME;
        onQueryTextChange(BuildConfig.VERSION_NAME);
    }

    protected void m1187a(Menu menu, int i, int i2) {
        MenuItem findItem = menu.findItem(R.id.search_item);
        if (findItem != null) {
            if (this.f1218a == null) {
                this.f1218a = findItem;
            }
            this.f1218a.setVisible(true);
            return;
        }
        View searchView = VERSION.SDK_INT >= 14 ? new SearchView(this.f1224v.getActionBar().getThemedContext()) : new SearchView(getSherlockActivity().getSupportActionBar().getThemedContext());
        searchView.setQueryHint(getString(i));
        searchView.findViewById(R.id.abs__search_plate).setBackgroundResource(R.drawable.textfield_searchview_holo_dark);
        this.f1218a = menu.add(0, 0, 1, i2);
        this.f1218a.setIcon((int) R.drawable.abs__ic_search).setActionView(searchView).setShowAsAction(9);
        searchView.setOnQueryTextListener(this);
        searchView.setOnQueryTextFocusChangeListener(new C0420y(this));
        searchView.setOnSearchClickListener(new C0421z(this, searchView, i));
        String action = this.f1224v.getIntent().getAction();
        if ("android.intent.action.SEARCH_LONG_PRESS".equals(action)) {
            m1189o();
        } else if ("android.intent.action.VIEW".equals(action)) {
            this.f1219b = this.f1222e.m31A();
            this.f1223u = this.f1219b;
            if (!TextUtils.isEmpty(this.f1219b)) {
                onQueryTextChange(this.f1219b);
            }
        }
        if (this.f1221d) {
            m1189o();
        }
    }

    public void m1188a(String str) {
        this.f1219b = str;
        this.f1223u = str;
        this.f1218a.collapseActionView();
        this.f1221d = false;
        this.f1220c = false;
        onQueryTextSubmit(str);
    }

    public boolean m1189o() {
        if (this.f1218a != null && this.f1218a.isVisible()) {
            if (this.f1218a.isActionViewExpanded()) {
                this.f1218a.collapseActionView();
                this.f1219b = this.f1223u;
            } else {
                this.f1218a.expandActionView();
                return true;
            }
        }
        return false;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f1224v = getActivity();
        this.f1222e = C0158a.m30a(this.f1224v.getApplicationContext());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle != null) {
            this.f1219b = bundle.getString("TagInfo_QueryList.QUERY");
            this.f1221d = bundle.getBoolean("TagInfo_QueryList.SEARCH_FOCUS");
        } else {
            this.f1219b = this.f1222e.m31A();
        }
        if (TextUtils.isEmpty(this.f1219b)) {
            this.f1223u = BuildConfig.VERSION_NAME;
        } else {
            this.f1223u = this.f1219b;
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onPause() {
        super.onPause();
        this.f1222e.m45d(this.f1223u);
    }

    public boolean onQueryTextSubmit(String str) {
        if (this.f1218a != null && this.f1218a.isActionViewExpanded()) {
            this.f1218a.collapseActionView();
        }
        this.f1219b = str;
        return onQueryTextChange(str);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("TagInfo_QueryList.SEARCH_FOCUS", this.f1220c);
        if (this.f1220c) {
            bundle.putString("TagInfo_QueryList.QUERY", this.f1223u);
        } else {
            bundle.putString("TagInfo_QueryList.QUERY", this.f1219b);
        }
        super.onSaveInstanceState(bundle);
    }

    public String m1190p() {
        return this.f1223u == null ? BuildConfig.VERSION_NAME : this.f1223u.trim();
    }

    public boolean m1191q() {
        return this.f1218a != null && this.f1218a.isActionViewExpanded();
    }

    public void m1192r() {
        if (this.f1218a != null) {
            this.f1218a.setVisible(false);
        }
    }
}
