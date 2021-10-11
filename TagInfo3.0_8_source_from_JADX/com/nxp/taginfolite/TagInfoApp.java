package com.nxp.taginfolite;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;

public class TagInfoApp extends Application {
    private static Context f3a;

    static {
        f3a = null;
    }

    public static ContentResolver m10a() {
        return f3a == null ? null : f3a.getContentResolver();
    }

    public void onCreate() {
        f3a = this;
        super.onCreate();
    }
}
