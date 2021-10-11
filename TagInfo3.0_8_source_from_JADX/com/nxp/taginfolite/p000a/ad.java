package com.nxp.taginfolite.p000a;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityEventCompat;

/* renamed from: com.nxp.taginfolite.a.ad */
class ad implements OnClickListener {
    final /* synthetic */ ac f8a;

    ad(ac acVar) {
        this.f8a = acVar;
    }

    @SuppressLint({"InlinedApi"})
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.WIRELESS_SETTINGS");
        if (VERSION.SDK_INT >= 16) {
            intent = new Intent("android.settings.NFC_SETTINGS");
        }
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.f8a.startActivity(intent);
        dialogInterface.dismiss();
    }
}
