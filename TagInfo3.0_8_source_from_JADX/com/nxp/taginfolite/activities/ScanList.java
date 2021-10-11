package com.nxp.taginfolite.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.fragments.C0162m;
import com.nxp.taginfolite.fragments.C0163v;
import com.nxp.taginfolite.fragments.C0386g;
import com.nxp.taginfolite.fragments.NavigationDrawerFragment;
import com.nxp.taginfolite.fragments.aa;

public class ScanList extends C0160g implements C0162m, C0163v {
    private C0386g f100f;
    private NavigationDrawerFragment f101g;
    private int f102h;

    public ScanList() {
        this.f102h = 0;
    }

    public void m137a(int i) {
        this.f102h = i;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intent intent;
        switch (i) {
            case R.id.drawer_scan_report:
                intent = new Intent(this, MainView.class);
                intent.setFlags(67108864);
                startActivity(intent);
                break;
            case R.id.drawer_scan_history:
                this.f102h = R.id.drawer_scan_report;
                break;
            case R.id.drawer_scan_prev:
                this.f102h = R.id.drawer_scan_report;
                break;
            case R.id.drawer_scan_next:
                this.f102h = R.id.drawer_scan_report;
                break;
            case R.id.drawer_key_manager:
                this.f102h = R.id.drawer_scan_report;
                intent = new Intent(this, KeyManager.class);
                intent.setFlags(67108864);
                startActivity(intent);
                break;
            case R.id.drawer_settings:
                this.f102h = R.id.drawer_scan_report;
                startActivity(new Intent(this, Preferences.class));
                break;
            case R.id.drawer_help:
                this.f102h = R.id.drawer_scan_report;
                startActivity(new Intent(this, Help.class));
                break;
            case R.id.drawer_about:
                this.f102h = R.id.drawer_scan_report;
                startActivity(new Intent(this, About.class));
                break;
            default:
                C0196b.m184b((Context) this, (int) R.string.toast_function_not_implemented);
                break;
        }
        if (null != null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, null).commit();
        }
    }

    public void m138a(C0386g c0386g) {
        this.f100f = c0386g;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.f100f != null) {
            this.f100f.onActivityResult(i, i2, intent);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        this.c.setTitle((int) R.string.name_history);
        this.f101g = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        this.f101g.m1142a((int) R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add((int) R.id.container, new aa());
        beginTransaction.commit();
        this.f102h = R.id.drawer_scan_history;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.scanlist_menu, menu);
        menu.findItem(R.id.switchDb).setVisible(VERSION.SDK_INT > 10);
        return true;
    }

    public void onNewIntent(Intent intent) {
        setIntent(intent);
        if (m75c(intent)) {
            m74b(intent);
        } else if (this.f100f != null) {
            this.f100f.m1215j();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.f101g != null && this.f101g.m1143a()) {
            this.f101g.m1145c();
        }
        switch (menuItem.getItemId()) {
            case 16908332:
                return false;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    protected void onResumeFragments() {
        super.onResumeFragments();
        this.f101g.m1141a(this.f102h);
    }

    public boolean onSearchRequested() {
        this.f100f.m1189o();
        return true;
    }
}
