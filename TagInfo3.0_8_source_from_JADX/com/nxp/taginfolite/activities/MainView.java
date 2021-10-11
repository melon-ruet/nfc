package com.nxp.taginfolite.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.BuildConfig;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.C0206d;
import com.nxp.taginfolite.C0373f;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.data.C0212f;
import com.nxp.taginfolite.database.C0233b;
import com.nxp.taginfolite.database.C0236e;
import com.nxp.taginfolite.database.p008b.C0231m;
import com.nxp.taginfolite.database.provider.ScanHistory;
import com.nxp.taginfolite.fragments.C0163v;
import com.nxp.taginfolite.fragments.C0386g;
import com.nxp.taginfolite.fragments.NavigationDrawerFragment;
import com.nxp.taginfolite.fragments.aa;
import com.nxp.taginfolite.fragments.ad;
import com.nxp.taginfolite.fragments.af;
import com.nxp.taginfolite.fragments.ag;
import com.nxp.taginfolite.fragments.p020a.C0377d;
import com.nxp.taginfolite.p000a.C0141j;
import com.nxp.taginfolite.p000a.al;
import com.nxp.taginfolite.p002d.C0205d;
import com.nxp.taginfolite.p003g.C0164e;
import com.nxp.taginfolite.p003g.C0423b;
import com.nxp.taginfolite.p003g.C0426g;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0176x;
import com.nxp.taginfolite.p004f.C0371y;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jraf.android.backport.switchwidget.C0519c;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"NewApi"})
public class MainView extends C0160g implements af, C0163v, C0164e {
    private static boolean f80u;
    C0178o f81f;
    boolean f82g;
    boolean f83h;
    C0371y f84i;
    private int f85j;
    private final List f86k;
    private NavigationDrawerFragment f87l;
    private CharSequence f88m;
    private ag f89n;
    private String f90o;
    private C0233b f91p;
    private String f92q;
    private boolean f93r;
    private C0196b f94s;
    private C0176x f95t;

    public MainView() {
        this.f85j = 0;
        this.f81f = C0178o.EMPTY;
        this.f82g = false;
        this.f83h = false;
        this.f84i = null;
        this.f86k = new ArrayList();
        this.f89n = null;
        this.f91p = null;
        this.f92q = null;
        this.f93r = false;
    }

    private void m100a(String str) {
        this.f90o = str;
        if (TextUtils.isEmpty(this.f90o)) {
            this.f91p = null;
        } else {
            try {
                this.f91p = new C0236e(this, this.f90o).m365a();
            } catch (Exception e) {
                m104c();
                C0196b.m180a((Context) this, (int) R.string.toast_parse_error);
            }
        }
        m110f();
    }

    private void m101a(boolean z, String str) {
        m120o();
        this.f84i = null;
        C0212f.m299a(str, BuildConfig.VERSION_NAME);
        this.f81f = C0178o.FILLED;
        if (z) {
            C0196b.m180a((Context) this, (int) R.string.toast_tag_error_message);
        }
        m100a(C0212f.m298a());
        this.f92q = C0212f.m300b();
        m117l();
        supportInvalidateOptionsMenu();
    }

    private void m103b(boolean z) {
        Cursor g = m112g();
        if (g != null && g.moveToFirst()) {
            int columnIndex = g.getColumnIndex("_id");
            Long valueOf = Long.valueOf(this.b.m67y());
            while (g.getLong(columnIndex) != valueOf.longValue()) {
                if (!g.moveToNext()) {
                    break;
                }
            }
            if (z ? g.moveToPrevious() : g.moveToNext()) {
                aa.m1223a(g, g.getLong(columnIndex), this.b, this);
            } else {
                C0196b.m186c(this, z ? R.string.toast_last_history_item : R.string.toast_first_history_item);
            }
        }
    }

    private void m104c() {
        this.f81f = C0178o.EMPTY;
        this.f92q = null;
        C0212f.m302d();
        m108e();
    }

    private void m105c(int i) {
        if (i == -1) {
            this.b.m37a(true);
            this.f83h = true;
            return;
        }
        finish();
    }

    private void m106d() {
        m126b();
        m124a(this.f85j);
    }

    private void m107d(Intent intent) {
        if ((intent.getFlags() & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) == 0) {
            intent.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START);
            if (m75c(intent) && (VERSION.SDK_INT < 19 || !this.b.m59q() || this.b.m68z())) {
                m128b(intent);
            } else if ("android.intent.action.VIEW".equals(intent.getAction())) {
                m109e(intent);
            }
        }
    }

    private void m108e() {
        if (this.f81f != C0178o.CLEARED) {
            m100a(C0212f.m298a());
            this.f92q = C0212f.m300b();
        }
        supportInvalidateOptionsMenu();
    }

    private void m109e(Intent intent) {
        ByteArrayOutputStream a = C0426g.m1373a(this, intent.getData());
        if (a != null) {
            String byteArrayOutputStream;
            try {
                byteArrayOutputStream = a.toString(C0429j.f1361b.name());
            } catch (UnsupportedEncodingException e) {
                C0196b.m180a((Context) this, (int) R.string.toast_parse_error);
                byteArrayOutputStream = a.toString();
            }
            try {
                new C0236e(this, byteArrayOutputStream).m365a();
                Intent intent2 = new Intent(this, MainView.class);
                intent2.setAction("TagInfo_Mainview.SHOW_FILE");
                C0212f.m299a(byteArrayOutputStream, null);
                startActivity(intent2);
            } catch (XmlPullParserException e2) {
                C0196b.m180a((Context) this, (int) R.string.toast_parse_error);
            }
        }
    }

    private void m110f() {
        boolean z = false;
        if (this.f89n != null) {
            if (this.f81f == C0178o.EMPTY && (this.f91p == null || this.f91p.m356i())) {
                this.f89n.m1259a(true);
            } else {
                this.f89n.m1259a(false);
            }
            ag agVar = this.f89n;
            if (this.f91p == null || this.f91p.m356i() || this.f91p.m352e()) {
                z = true;
            }
            agVar.m1260b(z);
        }
        for (ad a : this.f86k) {
            a.m1255a();
        }
    }

    private void m111f(Intent intent) {
        this.f93r = false;
        startActivity(intent);
    }

    private Cursor m112g() {
        String str;
        String[] strArr = null;
        String[] a = C0386g.m1197a(this.b.m31A(), aa.f1250w);
        if (a != null) {
            str = a[0];
            strArr = (String[]) Arrays.copyOfRange(a, 1, a.length);
        } else {
            str = null;
        }
        return C0386g.m1194a(getContentResolver(), ScanHistory.f335a, str, strArr, aa.m1237s());
    }

    private void m113h() {
        m103b(true);
    }

    private void m114i() {
        m103b(false);
    }

    private boolean m115j() {
        Cursor query = getContentResolver().query(ScanHistory.f336b, new String[]{"_id", "data"}, "uid = ?", new String[]{this.f91p.m351d()}, null);
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", this.f91p.m347a());
        contentValues.put("title", this.f91p.m349b());
        contentValues.put("time", this.f91p.m350c());
        contentValues.put("uid", this.f91p.m351d());
        contentValues.put("hasndef", Boolean.valueOf(this.f91p.m354g()));
        contentValues.put("ndef", this.f91p.m355h());
        contentValues.put("taglost", Boolean.valueOf(this.f91p.m353f()));
        boolean z = C0231m.m337a(query, contentValues) != -1;
        if (query != null) {
            query.close();
        }
        return z;
    }

    private void m116k() {
        if (this.f91p != null) {
            Intent a = C0206d.m255a((Context) this, "message/rfc822", this.f91p, this.f92q);
            if (a == null) {
                return;
            }
            if (this.b.m51i()) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                C0141j c0141j = new C0141j();
                c0141j.m28a(a);
                c0141j.show(supportFragmentManager, "fragment_show_subject");
                return;
            }
            C0206d.m259a((Context) this, a);
        }
    }

    private boolean m117l() {
        ContentResolver contentResolver = getContentResolver();
        contentResolver.query(ScanHistory.f340f, null, null, null, null);
        ContentValues contentValues = new ContentValues();
        if (this.f90o == null) {
            throw new IllegalStateException("Trying to store scan without scan xml");
        }
        contentValues.put("data", this.f91p.m347a());
        contentValues.put("title", this.f91p.m349b());
        contentValues.put("time", this.f91p.m350c());
        contentValues.put("uid", this.f91p.m351d());
        contentValues.put("hasndef", Boolean.valueOf(this.f91p.m354g()));
        contentValues.put("ndef", this.f91p.m355h());
        contentValues.put("taglost", Boolean.valueOf(this.f91p.m353f()));
        Uri insert = contentResolver.insert(ScanHistory.f341g, contentValues);
        boolean z = insert != null;
        if (z) {
            try {
                this.b.m34a(Long.valueOf(Long.parseLong(insert.getLastPathSegment())).longValue());
            } catch (NumberFormatException e) {
                throw new IllegalStateException("Error storing scan data");
            }
        }
        return z;
    }

    private void m118m() {
        Intent intent = new Intent(this, ScanList.class);
        intent.setAction("android.intent.action.VIEW");
        m111f(intent);
    }

    private void m119n() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag("TagInfo_Mainview.TAG_SCAN_DIALOG") == null) {
            new al().show(supportFragmentManager, "TagInfo_Mainview.TAG_SCAN_DIALOG");
        }
    }

    private void m120o() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("TagInfo_Mainview.TAG_SCAN_DIALOG");
        if (findFragmentByTag != null && (findFragmentByTag instanceof al)) {
            ((al) findFragmentByTag).dismissAllowingStateLoss();
        }
    }

    @SuppressLint({"NewApi"})
    private void m121p() {
        new C0423b().m1371a((FragmentActivity) this, "xml");
    }

    public C0377d m122a(ad adVar) {
        return this.f91p == null ? null : new C0377d(this, this.f91p.m348a(adVar.m1256b()));
    }

    protected void m123a() {
        if (VERSION.SDK_INT >= 19 && this.e != null && this.b.m59q()) {
            int r = this.b.m60r();
            if (!this.b.m58p()) {
                r &= -129;
            }
            this.e.enableReaderMode(this, new C0205d(this), r, a);
        }
    }

    public void m124a(int i) {
        this.f85j = i;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment fragment = null;
        switch (i) {
            case R.id.drawer_scan_report:
                this.f89n = new ag();
                fragment = this.f89n;
                break;
            case R.id.drawer_scan_history:
                this.f85j = R.id.drawer_scan_report;
                m118m();
                break;
            case R.id.drawer_scan_prev:
                this.f85j = R.id.drawer_scan_report;
                m114i();
                break;
            case R.id.drawer_scan_next:
                this.f85j = R.id.drawer_scan_report;
                m113h();
                break;
            case R.id.drawer_key_manager:
                this.f85j = R.id.drawer_scan_report;
                startActivity(new Intent(this, KeyManager.class));
                break;
            case R.id.drawer_settings:
                this.f85j = R.id.drawer_scan_report;
                startActivity(new Intent(this, Preferences.class));
                break;
            case R.id.drawer_help:
                this.f85j = R.id.drawer_scan_report;
                startActivity(new Intent(this, Help.class));
                break;
            case R.id.drawer_about:
                this.f85j = R.id.drawer_scan_report;
                startActivity(new Intent(this, About.class));
                break;
            default:
                C0196b.m184b((Context) this, (int) R.string.toast_function_not_implemented);
                break;
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            m127b(i);
        }
    }

    public void m125a(Uri uri) {
        m129b(uri);
    }

    public void m126b() {
        this.c.setNavigationMode(0);
        this.c.setDisplayShowTitleEnabled(true);
        this.c.setTitle(this.f88m);
    }

    public void m127b(int i) {
        switch (i) {
            case C0519c.Switch_track /*1*/:
                this.f88m = getString(R.string.drawer_title_scan_report);
            case C0519c.Switch_textOn /*2*/:
                this.f88m = getString(R.string.drawer_title_scan_history);
            case C0519c.Switch_textOff /*3*/:
                this.f88m = getString(R.string.drawer_title_key_manager);
            case C0519c.Switch_thumbTextPadding /*4*/:
                this.f88m = getString(R.string.drawer_title_settings);
            case C0519c.Switch_switchTextAppearance /*5*/:
                this.f88m = getString(R.string.drawer_title_help);
            case C0519c.Switch_switchMinWidth /*6*/:
                this.f88m = getString(R.string.drawer_title_about);
            default:
                this.f88m = getString(R.string.app_name);
        }
    }

    protected void m128b(Intent intent) {
        this.f81f = C0178o.CLEARED;
        closeOptionsMenu();
        getWindow().setSoftInputMode(2);
        this.f87l.m1145c();
        this.b.m32B();
        m100a(null);
        this.f82g = true;
        this.f84i = new C0371y(this.f95t, this, intent);
        this.f84i.execute(new Void[0]);
        m119n();
    }

    void m129b(Uri uri) {
        String byteArrayOutputStream;
        ByteArrayOutputStream a = C0426g.m1373a(this, uri);
        try {
            byteArrayOutputStream = a.toString(C0429j.f1361b.name());
        } catch (UnsupportedEncodingException e) {
            C0196b.m180a((Context) this, (int) R.string.toast_parse_error);
            byteArrayOutputStream = a.toString();
        }
        try {
            C0233b.m344a(this, byteArrayOutputStream);
        } catch (XmlPullParserException e2) {
            C0196b.m180a((Context) this, (int) R.string.toast_parse_error);
        }
        Intent intent = new Intent(this, MainView.class);
        intent.setAction("TagInfo_Mainview.SHOW_DATA");
        C0212f.m299a(byteArrayOutputStream, null);
        startActivity(intent);
    }

    public void m130b(ad adVar) {
        this.f86k.add(adVar);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            m105c(i2);
        } else if (i2 != -1) {
        } else {
            if ((i == 41 || i == 42) && intent != null) {
                m129b(intent.getData());
            }
        }
    }

    public void onBackPressed() {
        if (this.f84i != null) {
            return;
        }
        if (this.f93r) {
            m118m();
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        this.f94s = new C0196b(this);
        this.d = true;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        C0373f.m1127b(this);
        if (!f80u) {
            new C0175m(this).start();
        }
        this.b.m35a((Activity) this);
        this.f87l = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        this.f88m = getTitle();
        this.f87l.m1142a((int) R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
        this.f85j = R.id.drawer_scan_report;
        m106d();
        this.f95t = new C0177n(this);
        if (this.b.m48f()) {
            Object lastCustomNonConfigurationInstance = getLastCustomNonConfigurationInstance();
            if (lastCustomNonConfigurationInstance instanceof C0371y) {
                this.f84i = (C0371y) lastCustomNonConfigurationInstance;
                this.f84i.m1108a(this.f95t);
                return;
            }
            m107d(getIntent());
            return;
        }
        this.b.m36a("f");
        this.b.m40b(true);
        if (VERSION.SDK_INT >= 19) {
            this.b.m43c(true);
        }
        startActivityForResult(new Intent(this, License.class), 1);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        if (i != 84) {
            return super.onKeyLongPress(i, keyEvent);
        }
        Intent intent = new Intent(this, ScanList.class);
        intent.setAction("android.intent.action.SEARCH_LONG_PRESS");
        m111f(intent);
        return true;
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        boolean equals = "TagInfo_Mainview.SHOW_DATA".equals(intent.getAction());
        this.f82g = equals;
        this.f93r = equals;
        m107d(intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.f87l != null && this.f87l.m1143a()) {
            this.f87l.m1145c();
        }
        switch (menuItem.getItemId()) {
            case 16908332:
                return false;
            case R.id.sendTag:
                m116k();
                return true;
            case R.id.sendNdef:
                C0206d.m264a((FragmentActivity) this, this.f91p.m355h());
                return true;
            case R.id.saveScan:
                if (m117l()) {
                    C0196b.m186c(this, R.string.toast_save_ok);
                } else {
                    C0196b.m180a((Context) this, (int) R.string.toast_save_error);
                }
                supportInvalidateOptionsMenu();
                return true;
            case R.id.openScanFile:
                m121p();
                return true;
            case R.id.clearScreen:
                m104c();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void onPause() {
        super.onPause();
        this.b.m33a(this.f89n.m1257a());
        C0212f.m301c();
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.sendNdef).setVisible(false);
        if (this.f91p == null || this.f91p.m347a() == null || this.f91p.m356i()) {
            menu.findItem(R.id.sendTag).setVisible(false);
            menu.findItem(R.id.shareTag).setVisible(false);
            menu.findItem(R.id.clearScreen).setVisible(false);
            menu.findItem(R.id.saveScan).setVisible(false);
        } else {
            menu.findItem(R.id.sendTag).setVisible(this.b.m49g());
            MenuItem findItem = menu.findItem(R.id.shareTag);
            if (this.b.m49g()) {
                findItem.setVisible(false);
            } else {
                C0206d.m260a((Context) this, (ShareActionProvider) findItem.getActionProvider(), this.f91p, this.f92q);
            }
            menu.findItem(R.id.clearScreen).setVisible(true);
            menu.findItem(R.id.saveScan).setVisible(!m115j());
        }
        if (this.f91p != null && this.f91p.m354g()) {
            menu.findItem(R.id.sendNdef).setVisible(true);
        }
        if (VERSION.SDK_INT >= 19) {
            menu.findItem(R.id.openScanFile).setShowAsAction(1);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle != null) {
            this.f89n.m1258a(bundle.getInt("TagInfo_Mainview.INDEX"));
            m100a(bundle.getString("TagInfo_Mainview.SCAN_DATA"));
            this.f92q = bundle.getString("TagInfo_Mainview.SCAN_TITLE");
            if (bundle.getBoolean("TagInfo_Mainview.FROM_HISTORY", false)) {
                this.f93r = true;
            }
            if (bundle.getBoolean("TagInfo_Mainview.SCREEN_STATE", false)) {
                this.f81f = C0178o.CLEARED;
                m110f();
            }
        }
    }

    public void onResumeFragments() {
        super.onResumeFragments();
        getWindow().setSoftInputMode(2);
        m108e();
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(findViewById(R.id.view_pager).getWindowToken(), 0);
        if (this.f82g && this.b.m46d()) {
            this.f82g = false;
            if (this.b.m57o()) {
                this.f89n.m1258a(3);
            } else {
                this.f89n.m1258a(0);
            }
        } else {
            this.f89n.m1258a(this.b.m47e());
        }
        if (this.f83h) {
            this.f83h = false;
        }
        if (this.f85j == 0) {
            this.f85j = R.id.drawer_scan_report;
        }
        this.f87l.m1141a(this.f85j);
        m107d(getIntent());
    }

    public Object onRetainCustomNonConfigurationInstance() {
        if (this.f84i != null) {
            this.f84i.m1108a(null);
        }
        return this.f84i;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f91p != null) {
            bundle.putString("TagInfo_Mainview.SCAN_DATA", this.f91p.m347a());
            bundle.putString("TagInfo_Mainview.SCAN_TITLE", this.f92q);
        }
        bundle.putInt("TagInfo_Mainview.INDEX", this.c.getSelectedNavigationIndex());
        bundle.putBoolean("TagInfo_Mainview.SCREEN_STATE", this.f81f == C0178o.CLEARED);
        bundle.putBoolean("TagInfo_Mainview.FROM_HISTORY", this.f93r);
    }

    public boolean onSearchRequested() {
        m118m();
        return true;
    }
}
