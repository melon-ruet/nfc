package com.nxp.taginfolite.database.provider;

import android.content.UriMatcher;
import android.support.v4.BuildConfig;
import com.nxp.taginfolite.database.p008b.C0218a;
import com.nxp.taginfolite.database.p008b.C0219b;
import com.nxp.taginfolite.database.p008b.C0229k;
import com.nxp.taginfolite.database.p008b.C0230l;

/* renamed from: com.nxp.taginfolite.database.provider.a */
final class C0239a extends UriMatcher {
    C0239a(int i) {
        super(i);
        addURI("com.nxp.taginfolite.lookup", C0229k.f272a.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 10);
        addURI("com.nxp.taginfolite.lookup", C0229k.f273b.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 11);
        addURI("com.nxp.taginfolite.lookup", C0219b.f259a.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 20);
        addURI("com.nxp.taginfolite.lookup", C0219b.f260b.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 21);
        addURI("com.nxp.taginfolite.lookup", C0230l.f274a.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 30);
        addURI("com.nxp.taginfolite.lookup", C0230l.f275b.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 31);
        addURI("com.nxp.taginfolite.lookup", C0218a.f257a.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 40);
        addURI("com.nxp.taginfolite.lookup", C0218a.f258b.getPath().replaceFirst("/", BuildConfig.VERSION_NAME), 41);
    }
}
