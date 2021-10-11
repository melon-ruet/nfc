package com.nxp.taginfolite.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.p000a.C0146o;
import com.nxp.taginfolite.p002d.C0159e;
import com.nxp.taginfolite.p002d.C0202a;
import com.nxp.taginfolite.p002d.C0205d;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.activities.g */
public class C0160g extends SherlockFragmentActivity implements C0159e {
    public static final Bundle f71a;
    protected C0158a f72b;
    protected ActionBar f73c;
    protected boolean f74d;
    protected NfcAdapter f75e;

    static {
        f71a = new Bundle();
        if (VERSION.SDK_INT >= 19) {
            f71a.putInt("presence", 3000);
        }
    }

    public C0160g() {
        this.f74d = false;
    }

    public static Intent m70a(Context context, Intent intent, boolean z) {
        Intent intent2 = new Intent(context, MainView.class);
        if (VERSION.SDK_INT < 19 || !z) {
            intent2.replaceExtras(intent);
            intent2.setAction(intent.getAction());
        }
        return intent2;
    }

    @SuppressLint({"NewApi"})
    protected void m71a() {
        if (VERSION.SDK_INT >= 19 && this.f75e != null && this.f72b.m59q()) {
            this.f75e.enableReaderMode(this, new C0205d(this), this.f72b.m60r(), f71a);
        }
    }

    public void m72a(Intent intent) {
        if (m75c(intent)) {
            runOnUiThread(new C0171h(this, intent));
        }
    }

    protected void m73a(Integer num, Integer num2) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag("fragment_message_dialog") == null) {
            C0146o c0146o = new C0146o();
            Bundle bundle = new Bundle();
            if (num != null) {
                bundle.putInt("TI_MessageDialogtitle", num.intValue());
            }
            if (num2 != null) {
                bundle.putInt("TI_MessageDialogtext", num2.intValue());
            }
            c0146o.setArguments(bundle);
            c0146o.show(supportFragmentManager, "fragment_message_dialog");
        }
    }

    protected void m74b(Intent intent) {
        startActivity(C0160g.m70a(this, intent, this.f72b.m59q()));
    }

    protected boolean m75c(Intent intent) {
        String action = intent.getAction();
        return "android.nfc.action.TECH_DISCOVERED".equals(action) || "android.nfc.action.NDEF_DISCOVERED".equals(action) || "android.nfc.action.TAG_DISCOVERED".equals(action);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f72b = C0158a.m30a((Context) this);
        this.f73c = getSupportActionBar();
        this.f73c.setDisplayHomeAsUpEnabled(true);
    }

    protected void onNewIntent(Intent intent) {
        if (this.f74d || !m75c(intent)) {
            super.onNewIntent(intent);
        } else {
            m74b(intent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @SuppressLint({"NewApi"})
    protected void onPause() {
        super.onPause();
        if (VERSION.SDK_INT >= 19 && this.f75e != null && this.f72b.m59q()) {
            this.f75e.disableReaderMode(this);
        }
        C0202a.m246b(this);
    }

    protected void onResume() {
        super.onResume();
        supportInvalidateOptionsMenu();
        if (this.f72b.m61s()) {
            switch (this.f72b.m62t()) {
                case C0519c.Switch_track /*1*/:
                    setRequestedOrientation(7);
                    return;
                case C0519c.Switch_textOn /*2*/:
                    setRequestedOrientation(6);
                    return;
                default:
                    setRequestedOrientation(-1);
                    return;
            }
        }
        setRequestedOrientation(-1);
    }

    protected void onResumeFragments() {
        super.onResumeFragments();
        this.f75e = C0202a.m245a((FragmentActivity) this);
        m71a();
    }

    public boolean onSearchRequested() {
        Intent intent = new Intent(this, ScanList.class);
        intent.setFlags(67108864);
        startActivity(intent);
        return true;
    }
}
