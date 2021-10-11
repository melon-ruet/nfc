package com.nxp.taginfolite.p002d;

import android.annotation.SuppressLint;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.p000a.ac;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.nxp.taginfolite.d.b */
public class C0203b implements Runnable {
    private final FragmentActivity f207a;
    private NfcAdapter f208b;
    private int f209c;
    private final CountDownLatch f210d;
    private boolean f211e;
    private final C0204c f212f;

    public C0203b(FragmentActivity fragmentActivity) {
        this.f208b = null;
        this.f209c = -1;
        this.f210d = new CountDownLatch(1);
        this.f211e = false;
        this.f207a = fragmentActivity;
        this.f212f = new C0204c(this);
    }

    @SuppressLint({"NewApi"})
    private static void m252b(FragmentActivity fragmentActivity, int i) {
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag("fragment_show_nfc_settings") == null) {
            Bundle bundle = new Bundle();
            DialogFragment acVar = new ac();
            if (i == 1) {
                bundle.putInt("TI_NfcSettingstitle", R.string.dialog_title_nfc_off);
                bundle.putInt("TI_NfcSettingstext", R.string.dialog_text_nfc_off);
            } else {
                bundle.putInt("TI_NfcSettingstitle", R.string.dialog_title_nfc_timeout);
                bundle.putInt("TI_NfcSettingstext", R.string.dialog_text_nfc_timeout);
            }
            acVar.setArguments(bundle);
            acVar.show(supportFragmentManager, "fragment_show_nfc_settings");
        }
    }

    public void m253a() {
        new Thread(this).start();
    }

    public NfcAdapter m254b() {
        if (!this.f211e) {
            try {
                this.f210d.await(3000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
            }
        }
        return this.f208b;
    }

    public void run() {
        Message message = new Message();
        message.what = 2;
        this.f212f.sendMessageDelayed(message, 3000);
        this.f208b = NfcAdapter.getDefaultAdapter(this.f207a);
        if (this.f208b == null || !this.f208b.isEnabled()) {
            this.f212f.sendEmptyMessage(1);
        } else {
            this.f212f.sendEmptyMessage(0);
        }
        this.f210d.countDown();
    }
}
