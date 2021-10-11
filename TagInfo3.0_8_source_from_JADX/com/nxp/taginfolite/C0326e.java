package com.nxp.taginfolite;

import android.content.Context;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.nxp.taginfolite.database.C0233b;

/* renamed from: com.nxp.taginfolite.e */
final class C0326e extends Thread {
    final /* synthetic */ Context f952a;
    final /* synthetic */ C0233b f953b;
    final /* synthetic */ String f954c;
    final /* synthetic */ ShareActionProvider f955d;

    C0326e(Context context, C0233b c0233b, String str, ShareActionProvider shareActionProvider) {
        this.f952a = context;
        this.f953b = c0233b;
        this.f954c = str;
        this.f955d = shareActionProvider;
    }

    public void run() {
        this.f955d.setShareIntent(C0206d.m255a(this.f952a, "text/plain", this.f953b, this.f954c));
    }
}
