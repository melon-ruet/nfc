package com.nxp.taginfolite.fragments;

import android.app.Activity;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

/* renamed from: com.nxp.taginfolite.fragments.t */
class C0410t extends ActionBarDrawerToggle {
    float f1316a;
    final /* synthetic */ NavigationDrawerFragment f1317b;

    C0410t(NavigationDrawerFragment navigationDrawerFragment, Activity activity, DrawerLayout drawerLayout, int i, int i2, int i3) {
        this.f1317b = navigationDrawerFragment;
        super(activity, drawerLayout, i, i2, i3);
        this.f1316a = 0.0f;
    }

    public void onDrawerClosed(View view) {
        super.onDrawerClosed(view);
        this.f1317b.f1194i = false;
        if (this.f1317b.isAdded()) {
            this.f1317b.m1144b();
            this.f1317b.m1140e().setTitle(this.f1317b.f1195j);
        }
    }

    public void onDrawerOpened(View view) {
        super.onDrawerOpened(view);
        this.f1317b.f1194i = true;
        if (this.f1317b.isAdded()) {
            if (!this.f1317b.f1193h) {
                this.f1317b.f1193h = true;
                PreferenceManager.getDefaultSharedPreferences(this.f1317b.getActivity()).edit().putBoolean("navigation_drawer_learned", true).apply();
            }
            this.f1317b.f1195j = this.f1317b.m1140e().getTitle();
            this.f1317b.m1144b();
        }
    }

    public void onDrawerSlide(View view, float f) {
        super.onDrawerSlide(view, f);
        if (f > this.f1316a && !this.f1317b.f1194i) {
            this.f1317b.f1194i = true;
        } else if (this.f1316a > f && f < 0.5f && this.f1317b.f1194i) {
            this.f1317b.f1194i = false;
        }
        this.f1316a = f;
    }
}
