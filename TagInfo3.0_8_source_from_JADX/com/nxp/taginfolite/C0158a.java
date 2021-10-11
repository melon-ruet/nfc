package com.nxp.taginfolite;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.BuildConfig;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.nxp.taginfolite.data.AuthKey;
import com.nxp.taginfolite.fragments.C0382c;
import com.nxp.taginfolite.p003g.C0429j;
import java.io.IOException;

/* renamed from: com.nxp.taginfolite.a */
public final class C0158a {
    public static int f67a;
    private static C0158a f68c;
    private SharedPreferences f69b;
    private final boolean f70d;

    static {
        f67a = 6;
        f68c = null;
    }

    protected C0158a(Context context) {
        this.f69b = null;
        this.f69b = PreferenceManager.getDefaultSharedPreferences(context);
        this.f70d = context.getPackageManager().hasSystemFeature("com.nxp.mifare");
    }

    public static C0158a m29a() {
        return f68c;
    }

    public static C0158a m30a(Context context) {
        if (f68c == null) {
            f68c = new C0158a(context);
        }
        return f68c;
    }

    public String m31A() {
        return this.f69b.getString("search_string", BuildConfig.VERSION_NAME);
    }

    public void m32B() {
        this.f69b.edit().putString("search_string", null).apply();
    }

    public void m33a(int i) {
        this.f69b.edit().putInt("tab_fragment", i).apply();
    }

    public void m34a(long j) {
        this.f69b.edit().putLong("selected_scan", j).apply();
    }

    public void m35a(Activity activity) {
        byte[] a = C0429j.m1397a(this.f69b.getString("user_key", BuildConfig.VERSION_NAME), f67a);
        if (a != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 40; i++) {
                stringBuilder.append("1");
            }
            C0382c.m1159a(new AuthKey("User key", true, "MFC", "Any", "SEC", stringBuilder.toString(), "MFC", "Any", "A|B", a), true, activity);
            this.f69b.edit().putString("user_key", BuildConfig.VERSION_NAME).apply();
        }
    }

    public void m36a(String str) {
        if ("d".equals(str) || "f".equals(str) || "q".equals(str)) {
            this.f69b.edit().putString("scan_level", str).apply();
        }
    }

    public void m37a(boolean z) {
        if (z) {
            this.f69b.edit().putString("license", C0373f.m1126b()).apply();
        } else {
            this.f69b.edit().putString("license", "not.ok").apply();
        }
    }

    public void m38b(int i) {
        this.f69b.edit().putInt("portrait_or_landscape", i).apply();
    }

    public void m39b(String str) {
        try {
            this.f69b.edit().putString("last_scan", C0429j.m1392a(str)).apply();
        } catch (IOException e) {
            this.f69b.edit().putString("last_scan", null).apply();
        }
    }

    public void m40b(boolean z) {
        this.f69b.edit().putBoolean("email_xml", z).apply();
    }

    public boolean m41b() {
        return this.f69b.getBoolean("play_sound", true);
    }

    public void m42c(String str) {
        this.f69b.edit().putString("last_scan_title", str).apply();
    }

    public void m43c(boolean z) {
        this.f69b.edit().putBoolean("reader_mode", z).apply();
    }

    public boolean m44c() {
        return this.f69b.getBoolean("vibrate_enabled", true);
    }

    public void m45d(String str) {
        this.f69b.edit().putString("search_string", str).apply();
    }

    public boolean m46d() {
        return this.f69b.getBoolean("switch_to_info", true);
    }

    public int m47e() {
        return this.f69b.getInt("tab_fragment", 0);
    }

    public boolean m48f() {
        return this.f69b.getString("license", "not.ok").equals(C0373f.m1126b());
    }

    public boolean m49g() {
        return this.f69b.getBoolean("email_only", false);
    }

    public String[] m50h() {
        if (TextUtils.isEmpty(this.f69b.getString("email_share_address", BuildConfig.VERSION_NAME).trim())) {
            return null;
        }
        return new String[]{this.f69b.getString("email_share_address", BuildConfig.VERSION_NAME).trim()};
    }

    public boolean m51i() {
        return this.f69b.getBoolean("show_email_subject", true);
    }

    public void m52j() {
        this.f69b.edit().putBoolean("show_email_subject", false).apply();
    }

    public void m53k() {
        this.f69b.edit().putBoolean("show_email_subject", true).apply();
    }

    public boolean m54l() {
        return this.f69b.getBoolean("email_xml", true);
    }

    public boolean m55m() {
        return this.f69b.getBoolean("show_hex", false);
    }

    public boolean m56n() {
        return "f".equals(this.f69b.getString("scan_level", "f"));
    }

    public boolean m57o() {
        return "q".equals(this.f69b.getString("scan_level", "f"));
    }

    public boolean m58p() {
        return !this.f69b.getBoolean("check_ndef", true);
    }

    public boolean m59q() {
        return this.f69b.getBoolean("reader_mode", false);
    }

    @TargetApi(19)
    public int m60r() {
        int i = 0;
        int i2 = (this.f69b.getBoolean("config_nfc_v", true) ? 8 : 0) | (((this.f69b.getBoolean("config_nfc_b", true) ? 2 : 0) | (this.f69b.getBoolean("config_nfc_a", true) ? 1 : 0)) | (this.f69b.getBoolean("config_nfc_f", true) ? 4 : 0));
        if (this.f69b.getBoolean("config_nfc_barcode", true)) {
            i = 16;
        }
        return ((i2 | i) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) | AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
    }

    public boolean m61s() {
        return !this.f69b.getBoolean("lock_portrait_mode", true);
    }

    public int m62t() {
        return this.f69b.getInt("portrait_or_landscape", 1);
    }

    public boolean m63u() {
        return this.f69b.getBoolean("try_key_b", false);
    }

    public boolean m64v() {
        return this.f69b.getBoolean("detect_msg", true);
    }

    public String m65w() {
        try {
            return C0429j.m1401b(this.f69b.getString("last_scan", BuildConfig.VERSION_NAME));
        } catch (IOException e) {
            return BuildConfig.VERSION_NAME;
        }
    }

    public String m66x() {
        return this.f69b.getString("last_scan_title", null);
    }

    public long m67y() {
        return this.f69b.getLong("selected_scan", -1);
    }

    public boolean m68z() {
        return this.f70d;
    }
}
