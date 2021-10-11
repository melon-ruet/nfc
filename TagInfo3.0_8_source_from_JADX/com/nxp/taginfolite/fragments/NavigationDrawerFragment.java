package com.nxp.taginfolite.fragments;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.R;

public class NavigationDrawerFragment extends SherlockFragment implements OnClickListener {
    public DrawerLayout f1186a;
    public View f1187b;
    private C0163v f1188c;
    private ActionBarDrawerToggle f1189d;
    private View f1190e;
    private int f1191f;
    private boolean f1192g;
    private boolean f1193h;
    private boolean f1194i;
    private CharSequence f1195j;

    public NavigationDrawerFragment() {
        this.f1191f = R.id.drawer_scan_report;
        this.f1194i = false;
    }

    private void m1130a(int i, boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f1190e.findViewById(i);
        int i2 = z ? R.style.upper_drawer_item_selected_text : R.style.upper_drawer_item_text;
        if (viewGroup != null) {
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextAppearance(getActivity(), i2);
                }
            }
        }
    }

    private void m1131a(Menu menu, boolean z) {
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            boolean z2 = item.isVisible() && z;
            item.setVisible(z2);
        }
    }

    private void m1134b(int i) {
        Object obj = null;
        if (i != this.f1191f) {
            obj = 1;
            switch (i) {
                case R.id.drawer_scan_report:
                case R.id.drawer_scan_history:
                case R.id.drawer_key_manager:
                    if (this.f1190e != null) {
                        m1141a(i);
                        break;
                    }
                    break;
            }
        }
        m1145c();
        if (obj != null && this.f1188c != null) {
            this.f1188c.m89a(i);
        }
    }

    private void m1137d() {
        ActionBar e = m1140e();
        e.setDisplayShowTitleEnabled(true);
        e.setNavigationMode(0);
        e.setTitle((int) R.string.app_name);
    }

    private ActionBar m1140e() {
        return ((SherlockFragmentActivity) getActivity()).getSupportActionBar();
    }

    public void m1141a(int i) {
        m1130a(this.f1191f, false);
        m1130a(i, true);
        this.f1191f = i;
    }

    public void m1142a(int i, DrawerLayout drawerLayout) {
        this.f1187b = getActivity().findViewById(i);
        this.f1186a = drawerLayout;
        this.f1186a.setDrawerShadow((int) R.drawable.drawer_shadow, (int) GravityCompat.START);
        ActionBar e = m1140e();
        e.setDisplayHomeAsUpEnabled(true);
        e.setHomeButtonEnabled(true);
        this.f1189d = new C0410t(this, getActivity(), this.f1186a, R.drawable.ic_navigation_drawer, R.string.drawer_open, R.string.drawer_close);
        if (this.f1193h || this.f1192g) {
            m1145c();
        } else {
            this.f1186a.openDrawer(this.f1187b);
        }
        this.f1186a.post(new C0411u(this));
        this.f1186a.setDrawerListener(this.f1189d);
    }

    public boolean m1143a() {
        return this.f1186a != null && this.f1186a.isDrawerOpen(this.f1187b);
    }

    void m1144b() {
        getActivity().supportInvalidateOptionsMenu();
    }

    public void m1145c() {
        if (this.f1186a != null) {
            this.f1186a.closeDrawer(this.f1187b);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f1188c = (C0163v) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }

    public void onClick(View view) {
        m1134b(view.getId());
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1189d.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1193h = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("navigation_drawer_learned", false);
        if (bundle != null) {
            this.f1191f = bundle.getInt("TI_NavDrawerselected_navigation_drawer_position");
            this.f1195j = bundle.getCharSequence("TI_NavDrawerold_action_bar_title");
            this.f1194i = bundle.getBoolean("TI_NavDrawershould_go_invisible");
            this.f1192g = true;
        }
        m1134b(this.f1191f);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.f1186a != null && m1143a()) {
            menuInflater.inflate(R.menu.global, menu);
            m1137d();
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1190e = layoutInflater.inflate(R.layout.fragment_navigation_drawer, viewGroup, false);
        return this.f1190e;
    }

    public void onDetach() {
        super.onDetach();
        this.f1188c = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (m1143a()) {
            this.f1186a.closeDrawer((int) GravityCompat.START);
        } else {
            this.f1186a.openDrawer((int) GravityCompat.START);
        }
        return true;
    }

    public void onPrepareOptionsMenu(Menu menu) {
        m1131a(menu, !this.f1194i);
        super.onPrepareOptionsMenu(menu);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("TI_NavDrawerselected_navigation_drawer_position", this.f1191f);
        bundle.putCharSequence("TI_NavDrawerold_action_bar_title", this.f1195j);
        bundle.putBoolean("TI_NavDrawershould_go_invisible", this.f1194i);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f1190e.findViewById(R.id.drawer_scan_report).setOnClickListener(this);
        this.f1190e.findViewById(R.id.drawer_scan_history).setOnClickListener(this);
        this.f1190e.findViewById(R.id.drawer_scan_prev).setOnClickListener(this);
        this.f1190e.findViewById(R.id.drawer_scan_next).setOnClickListener(this);
        this.f1190e.findViewById(R.id.drawer_key_manager).setOnClickListener(this);
        this.f1190e.findViewById(R.id.drawer_settings).setOnClickListener(this);
        this.f1190e.findViewById(R.id.drawer_help).setOnClickListener(this);
        this.f1190e.findViewById(R.id.drawer_about).setOnClickListener(this);
    }
}
