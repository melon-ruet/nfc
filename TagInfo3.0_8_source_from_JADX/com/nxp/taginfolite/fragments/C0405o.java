package com.nxp.taginfolite.fragments;

import android.os.Message;

/* renamed from: com.nxp.taginfolite.fragments.o */
class C0405o implements Runnable {
    final /* synthetic */ C0404n f1306a;

    C0405o(C0404n c0404n) {
        this.f1306a = c0404n;
    }

    public void run() {
        Message message = new Message();
        message.what = 3;
        this.f1306a.sendMessageDelayed(message, 20000);
    }
}
