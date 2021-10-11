package com.nxp.taginfolite.fragments;

import android.support.v4.media.TransportMediator;
import android.widget.ScrollView;

/* renamed from: com.nxp.taginfolite.fragments.s */
class C0409s implements Runnable {
    final /* synthetic */ ScrollView f1314a;
    final /* synthetic */ C0406p f1315b;

    C0409s(C0406p c0406p, ScrollView scrollView) {
        this.f1315b = c0406p;
        this.f1314a = scrollView;
    }

    public void run() {
        this.f1314a.fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
    }
}
