package com.nxp.taginfolite.ndef.span;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.style.URLSpan;
import android.view.View;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.R;

public class AarSpan extends URLSpan {
    public AarSpan(String str) {
        super(str);
    }

    private void m1464a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/search?q=pname:" + str));
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C0196b.m180a(context, (int) R.string.toast_no_app_installed_aar);
        }
    }

    public void onClick(View view) {
        Context context = view.getContext();
        String url = getURL();
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(url);
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
            try {
                context.startActivity(launchIntentForPackage);
                return;
            } catch (ActivityNotFoundException e) {
                m1464a(context, url);
                return;
            }
        }
        m1464a(context, url);
    }
}
