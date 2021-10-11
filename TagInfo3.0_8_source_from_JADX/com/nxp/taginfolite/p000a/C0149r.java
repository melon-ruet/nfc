package com.nxp.taginfolite.p000a;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.a.r */
class C0149r implements OnClickListener {
    final /* synthetic */ Activity f49a;
    final /* synthetic */ C0148q f50b;

    C0149r(C0148q c0148q, Activity activity) {
        this.f50b = c0148q;
        this.f49a = activity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        String str = "https://play.google.com/store/apps/details?id=com.nxp.nfc.tagwriter";
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.nxp.nfc.tagwriter"));
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        try {
            this.f50b.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C0196b.m180a(this.f49a, (int) R.string.toast_no_tagwriter_found);
        }
    }
}
