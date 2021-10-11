package com.nxp.taginfolite.activities;

import android.content.Intent;

/* renamed from: com.nxp.taginfolite.activities.p */
class C0179p implements Runnable {
    final /* synthetic */ Intent f120a;
    final /* synthetic */ Preferences f121b;

    C0179p(Preferences preferences, Intent intent) {
        this.f121b = preferences;
        this.f120a = intent;
    }

    public void run() {
        this.f121b.m135b(this.f120a);
    }
}
