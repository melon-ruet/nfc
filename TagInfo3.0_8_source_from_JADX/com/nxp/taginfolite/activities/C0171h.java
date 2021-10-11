package com.nxp.taginfolite.activities;

import android.content.Intent;

/* renamed from: com.nxp.taginfolite.activities.h */
class C0171h implements Runnable {
    final /* synthetic */ Intent f110a;
    final /* synthetic */ C0160g f111b;

    C0171h(C0160g c0160g, Intent intent) {
        this.f111b = c0160g;
        this.f110a = intent;
    }

    public void run() {
        this.f111b.m74b(this.f110a);
    }
}
