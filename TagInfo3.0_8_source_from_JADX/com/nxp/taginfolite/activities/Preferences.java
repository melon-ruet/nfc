package com.nxp.taginfolite.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.text.TextUtils;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.p002d.C0159e;
import com.nxp.taginfolite.p002d.C0202a;
import com.nxp.taginfolite.p002d.C0205d;
import org.jraf.android.backport.switchwidget.C0519c;

public final class Preferences extends SherlockPreferenceActivity implements OnSharedPreferenceChangeListener, C0159e {
    protected NfcAdapter f96a;
    private C0158a f97b;
    private boolean f98c;
    private PreferenceScreen f99d;

    public Preferences() {
        this.f98c = false;
    }

    private void m131a() {
        if (this.f97b.m61s()) {
            switch (this.f97b.m62t()) {
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

    private void m132a(Preference preference) {
        int i = 1;
        if (preference != null) {
            CharSequence charSequence = "[none]";
            String key = preference.getKey();
            if (preference instanceof ListPreference) {
                CharSequence entry;
                int i2;
                ListPreference listPreference = (ListPreference) preference;
                if ("scan_level".equals(key)) {
                    entry = listPreference.getEntry();
                    i2 = 1;
                } else {
                    entry = charSequence;
                    i2 = 0;
                }
                i = i2;
                charSequence = entry;
            } else {
                if (preference instanceof EditTextPreference) {
                    if ("email_share_address".equals(key)) {
                        String[] h = this.f97b.m50h();
                        String string = (h == null || h.length <= 0 || TextUtils.isEmpty(h[0])) ? getString(R.string.pref_email_share_address_none) : h[0];
                        Object obj = string;
                    }
                } else if (preference instanceof CheckBoxPreference) {
                    if ("play_sound".equals(key)) {
                        charSequence = (this.f97b.m41b() || VERSION.SDK_INT <= 10 || VERSION.SDK_INT >= 19) ? (this.f97b.m41b() || this.f97b.m59q()) ? getString(R.string.pref_sound_enabled_summary) : getString(R.string.pref_sound_enabled_summary_off) : getString(R.string.pref_sound_enabled_summary_off);
                    } else if ("lock_portrait_mode".equals(key)) {
                        if (this.f97b.m61s()) {
                            switch (this.f97b.m62t()) {
                                case C0519c.Switch_track /*1*/:
                                    charSequence = getString(R.string.pref_lock_portrait_mode_summary);
                                    break;
                                case C0519c.Switch_textOn /*2*/:
                                    charSequence = getString(R.string.pref_lock_landscape_mode_summary);
                                    break;
                                default:
                                    charSequence = null;
                                    break;
                            }
                        }
                        charSequence = null;
                    }
                }
                i = 0;
            }
            if (i != 0) {
                preference.setSummary(charSequence != null ? charSequence.toString() : null);
            }
        }
    }

    private void m133b(Preference preference) {
        if (preference instanceof PreferenceCategory) {
            PreferenceCategory preferenceCategory = (PreferenceCategory) preference;
            for (int i = 0; i < preferenceCategory.getPreferenceCount(); i++) {
                m133b(preferenceCategory.getPreference(i));
            }
            return;
        }
        m132a(preference);
    }

    public void m134a(Intent intent) {
        if (m136c(intent)) {
            runOnUiThread(new C0179p(this, intent));
        }
    }

    protected void m135b(Intent intent) {
        startActivity(C0160g.m70a(this, intent, this.f97b.m59q()));
    }

    protected boolean m136c(Intent intent) {
        String action = intent.getAction();
        return "android.nfc.action.TECH_DISCOVERED".equals(action) || "android.nfc.action.NDEF_DISCOVERED".equals(action) || "android.nfc.action.TAG_DISCOVERED".equals(action);
    }

    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle bundle) {
        Preference findPreference;
        PreferenceCategory preferenceCategory;
        Preference findPreference2;
        super.onCreate(bundle);
        this.f97b = C0158a.m30a((Context) this);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle((int) R.string.name_preferences);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        addPreferencesFromResource(R.xml.preferences);
        this.f99d = getPreferenceScreen();
        if (this.f99d != null) {
            for (int i = 0; i < this.f99d.getPreferenceCount(); i++) {
                m133b(this.f99d.getPreference(i));
            }
        }
        String string = PreferenceManager.getDefaultSharedPreferences(this).getString("scan_level", null);
        Preference findPreference3 = findPreference("try_key_b");
        if (findPreference3 != null) {
            findPreference3.setEnabled("f".equals(string));
        }
        this.f98c = this.f97b.m68z();
        if (!this.f98c) {
            findPreference = findPreference("try_key_b");
            if (findPreference != null) {
                findPreference.setShouldDisableView(true);
                findPreference.setSummary(R.string.pref_no_mifare);
                findPreference.setEnabled(false);
            }
        }
        if (VERSION.SDK_INT < 19) {
            preferenceCategory = (PreferenceCategory) findPreference("operation_category");
            findPreference2 = findPreference("reader_mode");
            if (!(preferenceCategory == null || findPreference2 == null)) {
                preferenceCategory.removePreference(findPreference2);
            }
            findPreference2 = findPreference("reader_config");
            if (!(preferenceCategory == null || findPreference2 == null)) {
                preferenceCategory.removePreference(findPreference2);
            }
        } else if (!this.f97b.m59q()) {
            findPreference = findPreference("play_sound");
            if (findPreference != null) {
                m132a(findPreference);
            }
        }
        Vibrator vibrator = (Vibrator) getSystemService("vibrator");
        if (VERSION.SDK_INT > 10 && !vibrator.hasVibrator()) {
            findPreference2 = findPreference("vibrate_enabled");
            preferenceCategory = (PreferenceCategory) findPreference("general_category");
            if (preferenceCategory != null && findPreference2 != null) {
                preferenceCategory.removePreference(findPreference2);
            }
        }
    }

    protected void onNewIntent(Intent intent) {
        if (m136c(intent)) {
            m135b(intent);
        } else {
            super.onNewIntent(intent);
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
        if (VERSION.SDK_INT >= 19 && this.f96a != null) {
            this.f96a.disableReaderMode(this);
        }
        C0202a.m246b(this);
        if (this.f99d != null) {
            SharedPreferences sharedPreferences = this.f99d.getSharedPreferences();
            if (sharedPreferences != null) {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
            }
        }
    }

    @SuppressLint({"NewApi"})
    protected void onResume() {
        super.onResume();
        m131a();
        if (this.f99d != null) {
            SharedPreferences sharedPreferences = this.f99d.getSharedPreferences();
            if (sharedPreferences != null) {
                sharedPreferences.registerOnSharedPreferenceChangeListener(this);
            }
        }
        this.f96a = C0202a.m243a((Activity) this);
        if (VERSION.SDK_INT >= 19 && this.f96a != null) {
            this.f96a.enableReaderMode(this, new C0205d(this), this.f97b.m60r(), C0160g.f71a);
        }
    }

    public boolean onSearchRequested() {
        Intent intent = new Intent(this, ScanList.class);
        intent.setFlags(67108864);
        startActivity(intent);
        return true;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if ("foreground_only".equals(str)) {
            boolean z = defaultSharedPreferences.getBoolean("foreground_only", true);
            String packageName = getPackageName();
            PackageManager packageManager = getPackageManager();
            if (packageManager != null) {
                packageManager.setComponentEnabledSetting(new ComponentName(packageName, packageName + ".activities.MainViewTechDiscovery"), z ? 2 : 1, 1);
            }
        } else if ("scan_level".equals(str)) {
            m132a(findPreference(str));
            if (this.f98c) {
                String string = defaultSharedPreferences.getString("scan_level", null);
                Preference findPreference = findPreference("try_key_b");
                if (findPreference != null) {
                    findPreference.setEnabled("f".equals(string));
                    m132a(findPreference);
                }
            }
        } else if ("reader_mode".equals(str)) {
            m132a(findPreference(str));
            if (defaultSharedPreferences.getBoolean(str, true)) {
                m132a(findPreference("play_sound"));
            }
        } else if ("lock_portrait_mode".equals(str)) {
            this.f97b.m38b(getResources().getConfiguration().orientation);
            m132a(findPreference(str));
            m131a();
        } else if ("email_share_address".equals(str)) {
            m132a(findPreference(str));
        }
    }
}
