package com.nxp.taginfolite;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;

/* renamed from: com.nxp.taginfolite.c */
class C0201c implements OnLoadCompleteListener {
    final /* synthetic */ C0196b f206a;

    C0201c(C0196b c0196b) {
        this.f206a = c0196b;
    }

    public void onLoadComplete(SoundPool soundPool, int i, int i2) {
        this.f206a.f148f = true;
    }
}
