package com.nxp.taginfolite.database.provider;

import android.content.UriMatcher;
import android.support.v4.BuildConfig;

/* renamed from: com.nxp.taginfolite.database.provider.b */
final class C0240b extends UriMatcher {
    C0240b(int i) {
        super(i);
        addURI("com.nxp.taginfolite.history", ScanHistory.f335a.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 0);
        addURI("com.nxp.taginfolite.history", ScanHistory.f343i.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 1);
        addURI("com.nxp.taginfolite.history", ScanHistory.f336b.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 2);
        addURI("com.nxp.taginfolite.history", ScanHistory.f344j.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 3);
        addURI("com.nxp.taginfolite.history", ScanHistory.f337c.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 4);
        addURI("com.nxp.taginfolite.history", ScanHistory.f345k.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 5);
        addURI("com.nxp.taginfolite.history", ScanHistory.f338d.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 6);
        addURI("com.nxp.taginfolite.history", ScanHistory.f339e.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 7);
        addURI("com.nxp.taginfolite.history", ScanHistory.f340f.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 8);
        addURI("com.nxp.taginfolite.history", ScanHistory.f341g.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 9);
    }
}
