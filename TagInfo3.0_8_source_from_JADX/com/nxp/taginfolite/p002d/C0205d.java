package com.nxp.taginfolite.p002d;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.nfc.NfcAdapter.ReaderCallback;
import android.nfc.Tag;

@SuppressLint({"NewApi"})
/* renamed from: com.nxp.taginfolite.d.d */
public class C0205d implements ReaderCallback {
    private final C0159e f214a;

    public C0205d(C0159e c0159e) {
        this.f214a = c0159e;
    }

    public void onTagDiscovered(Tag tag) {
        Intent intent = new Intent();
        intent.setAction("android.nfc.action.TAG_DISCOVERED");
        intent.putExtra("android.nfc.extra.TAG", tag);
        this.f214a.m69a(intent);
    }
}
