package com.nxp.taginfolite.database.provider;

import android.content.UriMatcher;
import android.support.v4.BuildConfig;

/* renamed from: com.nxp.taginfolite.database.provider.d */
final class C0242d extends UriMatcher {
    C0242d(int i) {
        super(i);
        addURI("com.nxp.taginfolite.keys", UserKeys.f350c.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 0);
        addURI("com.nxp.taginfolite.keys", UserKeys.f355h.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 10);
        addURI("com.nxp.taginfolite.keys", UserKeys.f351d.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 1);
        addURI("com.nxp.taginfolite.keys", UserKeys.f356i.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 11);
        addURI("com.nxp.taginfolite.keys", UserKeys.f352e.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 2);
        addURI("com.nxp.taginfolite.keys", UserKeys.f357j.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 12);
        addURI("com.nxp.taginfolite.keys", UserKeys.f353f.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 3);
        addURI("com.nxp.taginfolite.keys", UserKeys.f358k.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 13);
        addURI("com.nxp.taginfolite.keys", UserKeys.f354g.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 4);
        addURI("com.nxp.taginfolite.keys", UserKeys.f359l.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 14);
    }
}
