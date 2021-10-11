package com.nxp.taginfolite;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.BuildConfig;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.nxp.taginfolite.database.C0233b;
import com.nxp.taginfolite.database.C0235d;
import com.nxp.taginfolite.p000a.C0148q;
import com.nxp.taginfolite.p003g.C0427h;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p005b.C0180a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.nxp.taginfolite.d */
public class C0206d {
    public static Intent m255a(Context context, String str, C0233b c0233b, String str2) {
        String string = context.getString(R.string.send_subject);
        if (TextUtils.isEmpty(str2)) {
            str2 = c0233b.m349b();
        }
        if (!TextUtils.isEmpty(str2)) {
            string = string + ": " + C0358k.m1069a(str2);
        }
        C0158a a = C0158a.m30a(context);
        Intent a2 = C0206d.m257a(str, string, a.m50h());
        C0427h c0427h = new C0427h();
        String a3 = C0206d.m258a(context, c0233b);
        if (!TextUtils.isEmpty(a3)) {
            Parcelable a4;
            if (a3.getBytes().length < Menu.CATEGORY_CONTAINER) {
                a2.putExtra("android.intent.extra.TEXT", a3);
                if (a.m54l()) {
                    a4 = c0427h.m1377a(context, c0233b.m347a().getBytes(), "taginfo_scan.xml");
                    if (a4 != null) {
                        a2.putExtra("android.intent.extra.STREAM", a4);
                    }
                }
            } else {
                a2.putExtra("android.intent.extra.TEXT", "Large scan report put in attachment");
                if (a.m54l()) {
                    a2.setAction("android.intent.action.SEND_MULTIPLE");
                    a2.setType("application/octet-stream");
                    Uri a5 = c0427h.m1377a(context, a3.getBytes(), "taginfo_scan.txt");
                    Uri a6 = c0427h.m1377a(context, c0233b.m347a().getBytes(), "taginfo_scan.xml");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(a5);
                    arrayList.add(a6);
                    a2.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                } else {
                    a4 = c0427h.m1377a(context, a3.getBytes(), "taginfo_scan.txt");
                    if (a4 != null) {
                        a2.putExtra("android.intent.extra.STREAM", a4);
                    }
                }
            }
        }
        return a2;
    }

    public static Intent m256a(Context context, String str, List list) {
        if (list == null) {
            C0196b.m184b(context, (int) R.string.toast_no_scans_found);
            return null;
        }
        C0158a a = C0158a.m30a(context);
        Intent a2 = C0206d.m257a(str, context.getString(R.string.send_subject_all), a.m50h());
        C0427h c0427h = new C0427h();
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        for (C0233b c0233b : list) {
            if (c0233b != null) {
                stringBuilder.append(C0206d.m258a(context, c0233b));
            } else {
                stringBuilder.append("\n[Error parsing scan report]\n");
            }
            stringBuilder.append("\n====================================\n");
        }
        Parcelable a3 = c0427h.m1377a(context, stringBuilder.toString().getBytes(), "taginfo_scan_collection.txt");
        if (a.m54l()) {
            StringBuilder stringBuilder2 = new StringBuilder(BuildConfig.VERSION_NAME);
            for (C0233b c0233b2 : list) {
                if (c0233b2 != null) {
                    stringBuilder2.append(c0233b2.m347a());
                } else {
                    stringBuilder2.append("\n<!-- Error in scan report -->\n");
                }
                stringBuilder2.append("\n\n");
            }
            a2.setAction("android.intent.action.SEND_MULTIPLE");
            a2.setType("application/octet-stream");
            Uri a4 = c0427h.m1377a(context, stringBuilder2.toString().getBytes(), "taginfo_scan_collection.xml");
            ArrayList arrayList = new ArrayList();
            arrayList.add(a3);
            arrayList.add(a4);
            a2.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        } else if (a3 != null) {
            a2.putExtra("android.intent.extra.STREAM", a3);
        }
        return a2;
    }

    private static Intent m257a(String str, String str2, String[] strArr) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(str);
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("android.intent.extra.SUBJECT", str2);
        }
        if (strArr != null && strArr.length > 0) {
            intent.putExtra("android.intent.extra.EMAIL", strArr);
        }
        return intent;
    }

    private static String m258a(Context context, C0233b c0233b) {
        String[] strArr = new String[]{context.getString(R.string.tab_info), context.getString(R.string.tab_ndef), context.getString(R.string.tab_extra), context.getString(R.string.tab_tech)};
        StringBuilder stringBuilder = new StringBuilder("** " + context.getString(R.string.start_text) + " ");
        stringBuilder.append("(version ");
        stringBuilder.append(c0233b.m357j());
        stringBuilder.append(") ");
        stringBuilder.append(c0233b.m350c());
        stringBuilder.append(" **\n\n");
        for (int i = 0; i < 4; i++) {
            stringBuilder.append("-- ");
            stringBuilder.append(strArr[i]);
            stringBuilder.append(" ------------------------------\n\n");
            List a = c0233b.m348a(i);
            if (a != null) {
                int i2 = 0;
                while (i2 < a.size()) {
                    int i3 = i2 + 1;
                    C0235d c0235d = (C0235d) a.get(i2);
                    boolean isEmpty = TextUtils.isEmpty(c0235d.m361a());
                    boolean z = i3 < a.size() && TextUtils.isEmpty(((C0235d) a.get(i3)).m361a());
                    if (!isEmpty) {
                        stringBuilder.append("# ");
                        stringBuilder.append(c0235d.m361a());
                        stringBuilder.append(":\n");
                    }
                    for (C0180a a2 : c0235d.m362b().m150a()) {
                        Object charSequence = a2.m144a(context, true).toString();
                        if (!TextUtils.isEmpty(charSequence)) {
                            stringBuilder.append(charSequence);
                            stringBuilder.append("\n");
                        }
                    }
                    if (!z) {
                        stringBuilder.append("\n");
                    }
                    i2 = i3;
                }
            }
        }
        stringBuilder.append("--------------------------------------\n\n");
        return C0358k.m1069a(stringBuilder.toString());
    }

    public static void m259a(Context context, Intent intent) {
        try {
            context.startActivity(Intent.createChooser(intent, "message/rfc822".equals(intent.getType()) ? context.getString(R.string.email_chooser_title) : context.getString(R.string.share_chooser_title)));
        } catch (ActivityNotFoundException e) {
            C0196b.m180a(context, (int) R.string.toast_no_activity_found);
        }
    }

    public static void m260a(Context context, ShareActionProvider shareActionProvider, C0233b c0233b, String str) {
        Intent a = C0206d.m257a("text/plain", null, null);
        a.putExtra("android.intent.extra.TEXT", "Scan report text not yet loaded...");
        shareActionProvider.setShareIntent(a);
        new C0326e(context, c0233b, str, shareActionProvider).run();
    }

    public static void m261a(Context context, C0233b c0233b, String str) {
        Intent a = C0206d.m255a(context, "text/plain", c0233b, str);
        if (a != null) {
            C0206d.m259a(context, a);
        }
    }

    public static void m262a(Context context, List list) {
        Intent a = C0206d.m256a(context, "text/plain", list);
        if (a != null) {
            C0206d.m259a(context, a);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"WorldReadableFiles"})
    private static void m263a(android.content.Context r4, byte[] r5, java.lang.String r6) {
        /*
        r2 = 2131493146; // 0x7f0c011a float:1.8609764E38 double:1.053097538E-314;
        if (r5 != 0) goto L_0x000c;
    L_0x0005:
        r0 = 2131493160; // 0x7f0c0128 float:1.8609792E38 double:1.0530975447E-314;
        com.nxp.taginfolite.C0196b.m184b(r4, r0);
    L_0x000b:
        return;
    L_0x000c:
        r0 = 0;
        r1 = 1;
        r0 = r4.openFileOutput(r6, r1);	 Catch:{ FileNotFoundException -> 0x0020, all -> 0x0032 }
        r0.write(r5);	 Catch:{ IOException -> 0x0041, FileNotFoundException -> 0x0020 }
    L_0x0015:
        if (r0 == 0) goto L_0x000b;
    L_0x0017:
        r0.close();	 Catch:{ IOException -> 0x001b }
        goto L_0x000b;
    L_0x001b:
        r0 = move-exception;
        com.nxp.taginfolite.C0196b.m180a(r4, r2);
        goto L_0x000b;
    L_0x0020:
        r1 = move-exception;
        r1 = 2131493146; // 0x7f0c011a float:1.8609764E38 double:1.053097538E-314;
        com.nxp.taginfolite.C0196b.m180a(r4, r1);	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x000b;
    L_0x0029:
        r0.close();	 Catch:{ IOException -> 0x002d }
        goto L_0x000b;
    L_0x002d:
        r0 = move-exception;
        com.nxp.taginfolite.C0196b.m180a(r4, r2);
        goto L_0x000b;
    L_0x0032:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x0036:
        if (r1 == 0) goto L_0x003b;
    L_0x0038:
        r1.close();	 Catch:{ IOException -> 0x003c }
    L_0x003b:
        throw r0;
    L_0x003c:
        r1 = move-exception;
        com.nxp.taginfolite.C0196b.m180a(r4, r2);
        goto L_0x003b;
    L_0x0041:
        r1 = move-exception;
        goto L_0x0015;
    L_0x0043:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.d.a(android.content.Context, byte[], java.lang.String):void");
    }

    public static void m264a(FragmentActivity fragmentActivity, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            C0196b.m184b((Context) fragmentActivity, (int) R.string.toast_tag_no_ndef_message);
        }
        C0206d.m263a((Context) fragmentActivity, bArr, "ndef.bin");
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setComponent(new ComponentName("com.nxp.nfc.tagwriter", "com.nxp.nfc.tagwriter.activities.ExternalInvocationActivity"));
            intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
            intent.setDataAndType(Uri.fromFile(fragmentActivity.getFileStreamPath("ndef.bin")), "vnd.android.cursor.item/ndef_msg_mime");
            fragmentActivity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            if (supportFragmentManager.findFragmentByTag("fragment_install_tagwriter") == null) {
                new C0148q().show(supportFragmentManager, "fragment_install_tagwriter");
            }
        }
    }
}
