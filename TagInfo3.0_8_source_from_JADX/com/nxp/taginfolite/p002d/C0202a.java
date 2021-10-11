package com.nxp.taginfolite.p002d;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.support.v4.app.FragmentActivity;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.p003g.C0429j;

/* renamed from: com.nxp.taginfolite.d.a */
public final class C0202a {
    public static NfcAdapter m243a(Activity activity) {
        return C0202a.m244a(activity, NfcAdapter.getDefaultAdapter(activity));
    }

    private static NfcAdapter m244a(Activity activity, NfcAdapter nfcAdapter) {
        if (nfcAdapter != null) {
            Intent intent = new Intent(activity.getApplicationContext(), activity.getClass());
            intent.setFlags(536870912);
            nfcAdapter.enableForegroundDispatch(activity, PendingIntent.getActivity(activity.getApplicationContext(), 0, intent, 0), null, (String[][]) null);
            String str = "play.google.com/store/apps/details?id=com.nxp.taginfolite";
            Object obj = new byte[("play.google.com/store/apps/details?id=com.nxp.taginfolite".length() + 1)];
            obj[0] = 4;
            System.arraycopy("play.google.com/store/apps/details?id=com.nxp.taginfolite".getBytes(C0429j.f1360a), 0, obj, 1, "play.google.com/store/apps/details?id=com.nxp.taginfolite".length());
            NdefRecord ndefRecord = new NdefRecord((short) 1, "U".getBytes(C0429j.f1360a), new byte[0], obj);
            NdefRecord ndefRecord2 = new NdefRecord((short) 4, "android.com:pkg".getBytes(C0429j.f1360a), new byte[0], "com.nxp.taginfolite".getBytes(C0429j.f1360a));
            NdefRecord ndefRecord3 = new NdefRecord((short) 4, "android.com:pkg".getBytes(C0429j.f1360a), new byte[0], "com.nxp.taginfo".getBytes(C0429j.f1360a));
            nfcAdapter.enableForegroundNdefPush(activity, new NdefMessage(new NdefRecord[]{ndefRecord, ndefRecord2, ndefRecord3}));
        }
        return nfcAdapter;
    }

    public static NfcAdapter m245a(FragmentActivity fragmentActivity) {
        C0203b c0203b = new C0203b(fragmentActivity);
        c0203b.m253a();
        return C0202a.m244a(fragmentActivity, c0203b.m254b());
    }

    public static boolean m246b(Activity activity) {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(activity.getApplicationContext());
        if (defaultAdapter != null) {
            defaultAdapter.disableForegroundDispatch(activity);
        } else {
            C0196b.m180a((Context) activity, (int) R.string.dialog_error_nfc_adapter);
        }
        return defaultAdapter != null;
    }
}
