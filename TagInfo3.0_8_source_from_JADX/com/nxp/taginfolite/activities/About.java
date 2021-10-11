package com.nxp.taginfolite.activities;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.C0373f;
import com.nxp.taginfolite.R;

public final class About extends C0161i {
    private void m78a(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C0196b.m180a(context, (int) R.string.toast_no_app_installed_uri);
        }
    }

    private void m81a(String str, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        intent.putExtra("android.intent.extra.SUBJECT", str2);
        intent.putExtra("android.intent.extra.TEXT", str3);
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        try {
            startActivity(Intent.createChooser(intent, str2));
        } catch (ActivityNotFoundException e) {
            C0196b.m180a((Context) this, (int) R.string.toast_no_email);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.about);
        TextView textView = (TextView) findViewById(R.id.aboutText);
        textView.setText(Html.fromHtml(getString(R.string.about_dialog_text)));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        getWindow().setFormat(1);
        ((Button) findViewById(R.id.button_license)).setOnClickListener(new C0165a(this));
        ((Button) findViewById(R.id.button_notices)).setOnClickListener(new C0166b(this));
        ((ImageButton) findViewById(R.id.button_nfc)).setOnClickListener(new C0167c(this));
        ((ImageButton) findViewById(R.id.button_nxp)).setOnClickListener(new C0168d(this));
        ((ImageButton) findViewById(R.id.button_play)).setOnClickListener(new C0169e(this));
    }

    protected void onResume() {
        super.onResume();
        String str = (String) C0373f.m1123a((Context) this);
        C0373f.m1127b(this);
        m77a(getString(R.string.about_dialog_title) + " " + str);
        TextView textView = (TextView) findViewById(R.id.aboutVersion);
        String format = String.format(getString(R.string.about_dialog_app_version), new Object[]{C0373f.m1124a()});
        textView.setText(format + "\n" + "2014-08-21 23:33:16");
        findViewById(R.id.button_feedback).setOnClickListener(new C0170f(this, format));
    }
}
