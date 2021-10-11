package com.nxp.taginfolite;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.BuildConfig;
import com.nxp.taginfolite.p003g.C0428i;

/* renamed from: com.nxp.taginfolite.f */
public final class C0373f {
    private static String f1184a;
    private static String f1185b;

    static {
        f1184a = "<unloaded>";
        f1185b = null;
    }

    public static CharSequence m1123a(Context context) {
        return context.getString(R.string.app_name);
    }

    public static String m1124a() {
        return f1184a;
    }

    public static String m1125a(String str) {
        C0428i c0428i = new C0428i();
        c0428i.m1384a((CharSequence) str);
        c0428i.m1384a("Device model: " + Build.MODEL);
        c0428i.m1384a("Android version: " + VERSION.RELEASE);
        c0428i.m1384a("ROM build: " + Build.DISPLAY);
        c0428i.m1384a("MIFARE Classic support: " + (C0158a.m29a().m68z() ? "present" : "absent"));
        return c0428i.toString() + "\n";
    }

    public static String m1126b() {
        return f1185b;
    }

    public static void m1127b(Context context) {
        String str = "<unknown>";
        String string = context.getString(R.string.license_version);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                str = packageInfo.versionName;
                int i = packageInfo.versionCode;
            }
        } catch (NameNotFoundException e) {
        }
        f1184a = str + BuildConfig.VERSION_NAME;
        f1185b = string;
    }
}
