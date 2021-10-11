package com.nxp.taginfolite.activities;

import android.content.Context;
import android.content.Intent;
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
import com.nxp.taginfolite.fragments.C0397d;
import com.nxp.taginfolite.fragments.NavigationDrawerFragment;

public class KeyManager extends C0160g implements C0162m, C0163v {
    private C0386g f77f;
    private NavigationDrawerFragment f78g;
    private int f79h;

    public KeyManager() {
        this.f79h = 0;
    }

    public void m90a(int i) {
        this.f79h = i;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intent intent;
        switch (i) {
            case R.id.drawer_scan_report:
                intent = new Intent(this, MainView.class);
                intent.setFlags(67108864);
                startActivity(intent);
                break;
            case R.id.drawer_scan_history:
                this.f79h = R.id.drawer_scan_report;
                intent = new Intent(this, ScanList.class);
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(67108864);
                startActivity(intent);
                break;
            case R.id.drawer_scan_prev:
                this.f79h = R.id.drawer_scan_report;
                break;
            case R.id.drawer_scan_next:
                this.f79h = R.id.drawer_scan_report;
                break;
            case R.id.drawer_key_manager:
                this.f79h = R.id.drawer_scan_report;
                break;
            case R.id.drawer_settings:
                this.f79h = R.id.drawer_scan_report;
                startActivity(new Intent(this, Preferences.class));
                break;
            case R.id.drawer_help:
                this.f79h = R.id.drawer_scan_report;
                startActivity(new Intent(this, Help.class));
                break;
            case R.id.drawer_about:
                this.f79h = R.id.drawer_scan_report;
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

    public void m91a(C0386g c0386g) {
        this.f77f = c0386g;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        this.c.setTitle((int) R.string.name_keys);
        this.f78g = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        this.f78g.m1142a((int) R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add((int) R.id.container, new C0397d());
        beginTransaction.commit();
        this.f79h = R.id.drawer_key_manager;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.keymanager_menu, menu);
        return true;
    }

    public void onNewIntent(Intent intent) {
        setIntent(intent);
        if (m75c(intent)) {
            m74b(intent);
        } else if (this.f77f != null) {
            this.f77f.m1215j();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.f78g != null && this.f78g.m1143a()) {
            this.f78g.m1145c();
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
        this.f78g.m1141a(this.f79h);
    }

    public boolean onSearchRequested() {
        this.f77f.m1189o();
        return true;
    }
}
