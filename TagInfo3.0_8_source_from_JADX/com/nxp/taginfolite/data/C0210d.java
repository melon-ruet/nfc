package com.nxp.taginfolite.data;

import android.content.Context;
import android.content.Intent;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.BuildConfig;
import android.util.Log;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.p003g.C0429j;
import java.io.IOException;

/* renamed from: com.nxp.taginfolite.data.d */
public class C0210d {
    private boolean f226a;
    private int f227b;
    private int f228c;
    private boolean f229d;
    private String f230e;
    private String f231f;
    private String f232g;
    private Ndef f233h;
    private NdefMessage[] f234i;
    private NdefFormatable f235j;
    private boolean f236k;

    public C0210d() {
        this.f226a = false;
        this.f227b = 0;
        this.f228c = -1;
        this.f229d = false;
        this.f230e = null;
        this.f231f = null;
        this.f232g = null;
        this.f233h = null;
        this.f235j = null;
        this.f234i = null;
    }

    public C0211e m281a(Context context, String str) {
        return new C0211e(context, this, str);
    }

    public void m282a(Context context, Intent intent) {
        NdefMessage ndefMessage;
        int maxSize;
        Object obj;
        String str = null;
        this.f230e = BuildConfig.VERSION_NAME;
        this.f231f = BuildConfig.VERSION_NAME;
        this.f232g = null;
        this.f229d = false;
        this.f228c = -1;
        this.f234i = null;
        this.f226a = false;
        this.f236k = false;
        this.f233h = null;
        this.f235j = null;
        this.f234i = null;
        this.f227b = 0;
        if (intent != null) {
            Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
            if (tag != null) {
                this.f233h = Ndef.get(tag);
                this.f235j = NdefFormatable.get(tag);
            }
            if (VERSION.SDK_INT < 19) {
                Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
                if (parcelableArrayExtra != null) {
                    this.f226a = true;
                    this.f234i = new NdefMessage[parcelableArrayExtra.length];
                    if (parcelableArrayExtra.length > 0) {
                        for (int i = 0; i < parcelableArrayExtra.length; i++) {
                            this.f234i[i] = (NdefMessage) parcelableArrayExtra[i];
                        }
                    }
                }
            } else if (!(this.f233h == null || this.f233h.getCachedNdefMessage() == null)) {
                this.f234i = new NdefMessage[]{this.f233h.getCachedNdefMessage()};
                this.f226a = true;
            }
            if (!(this.f226a || this.f233h == null)) {
                try {
                    this.f233h.connect();
                    ndefMessage = this.f233h.getNdefMessage();
                    try {
                        this.f233h.close();
                    } catch (FormatException e) {
                        this.f236k = true;
                        if (ndefMessage != null) {
                            Log.e("TagInfo_NDEF", "This should never happen! Weird...");
                            this.f234i = new NdefMessage[]{ndefMessage};
                            this.f226a = true;
                        }
                        if (this.f226a) {
                            for (NdefMessage toByteArray : this.f234i) {
                                this.f227b = toByteArray.toByteArray().length + this.f227b;
                            }
                        }
                        if (this.f233h != null) {
                            maxSize = this.f233h.getMaxSize();
                            if (maxSize <= 0) {
                                maxSize = -1;
                            }
                            this.f228c = maxSize;
                            if (this.f233h.isWritable()) {
                                this.f232g = context.getString(R.string.ndef_read_only);
                                this.f229d = false;
                            }
                            this.f232g = C0429j.m1391a(context.getString(R.string.ndef_read_write));
                            this.f229d = this.f233h.canMakeReadOnly();
                            return;
                        }
                    } catch (IOException e2) {
                        Object obj2 = ndefMessage;
                        obj = str;
                        if (ndefMessage != null) {
                            Log.e("TagInfo_NDEF", "This should never happen! Weird...");
                            this.f234i = new NdefMessage[]{ndefMessage};
                            this.f226a = true;
                        }
                        if (this.f226a) {
                            while (maxSize < r4) {
                                this.f227b = toByteArray.toByteArray().length + this.f227b;
                            }
                        }
                        if (this.f233h != null) {
                            maxSize = this.f233h.getMaxSize();
                            if (maxSize <= 0) {
                                maxSize = -1;
                            }
                            this.f228c = maxSize;
                            if (this.f233h.isWritable()) {
                                this.f232g = C0429j.m1391a(context.getString(R.string.ndef_read_write));
                                this.f229d = this.f233h.canMakeReadOnly();
                                return;
                            }
                            this.f232g = context.getString(R.string.ndef_read_only);
                            this.f229d = false;
                        }
                    }
                } catch (FormatException e3) {
                    ndefMessage = null;
                    this.f236k = true;
                    if (ndefMessage != null) {
                        Log.e("TagInfo_NDEF", "This should never happen! Weird...");
                        this.f234i = new NdefMessage[]{ndefMessage};
                        this.f226a = true;
                    }
                    if (this.f226a) {
                        while (maxSize < r4) {
                            this.f227b = toByteArray.toByteArray().length + this.f227b;
                        }
                    }
                    if (this.f233h != null) {
                        maxSize = this.f233h.getMaxSize();
                        if (maxSize <= 0) {
                            maxSize = -1;
                        }
                        this.f228c = maxSize;
                        if (this.f233h.isWritable()) {
                            this.f232g = context.getString(R.string.ndef_read_only);
                            this.f229d = false;
                        }
                        this.f232g = C0429j.m1391a(context.getString(R.string.ndef_read_write));
                        this.f229d = this.f233h.canMakeReadOnly();
                        return;
                    }
                } catch (IOException e4) {
                    obj = str;
                    if (ndefMessage != null) {
                        Log.e("TagInfo_NDEF", "This should never happen! Weird...");
                        this.f234i = new NdefMessage[]{ndefMessage};
                        this.f226a = true;
                    }
                    if (this.f226a) {
                        while (maxSize < r4) {
                            this.f227b = toByteArray.toByteArray().length + this.f227b;
                        }
                    }
                    if (this.f233h != null) {
                        maxSize = this.f233h.getMaxSize();
                        if (maxSize <= 0) {
                            maxSize = -1;
                        }
                        this.f228c = maxSize;
                        if (this.f233h.isWritable()) {
                            this.f232g = C0429j.m1391a(context.getString(R.string.ndef_read_write));
                            this.f229d = this.f233h.canMakeReadOnly();
                            return;
                        }
                        this.f232g = context.getString(R.string.ndef_read_only);
                        this.f229d = false;
                    }
                }
                if (ndefMessage != null) {
                    Log.e("TagInfo_NDEF", "This should never happen! Weird...");
                    this.f234i = new NdefMessage[]{ndefMessage};
                    this.f226a = true;
                }
            }
            if (this.f226a) {
                while (maxSize < r4) {
                    this.f227b = toByteArray.toByteArray().length + this.f227b;
                }
            }
            if (this.f233h != null) {
                maxSize = this.f233h.getMaxSize();
                if (maxSize <= 0) {
                    maxSize = -1;
                }
                this.f228c = maxSize;
                if (this.f233h.isWritable()) {
                    this.f232g = C0429j.m1391a(context.getString(R.string.ndef_read_write));
                    this.f229d = this.f233h.canMakeReadOnly();
                    return;
                }
                this.f232g = context.getString(R.string.ndef_read_only);
                this.f229d = false;
            }
        }
    }

    public void m283a(String str) {
        this.f230e = str;
    }

    public boolean m284a() {
        return this.f226a;
    }

    public int m285b() {
        return this.f227b;
    }

    public void m286b(String str) {
        this.f231f = str;
    }

    public int m287c() {
        return this.f228c;
    }

    public boolean m288d() {
        return this.f229d;
    }

    public String m289e() {
        return this.f230e;
    }

    public String m290f() {
        return this.f231f;
    }

    public String m291g() {
        return this.f232g;
    }

    public Ndef m292h() {
        return this.f233h;
    }

    public NdefFormatable m293i() {
        return this.f235j;
    }

    public NdefMessage[] m294j() {
        return this.f234i;
    }

    public boolean m295k() {
        return this.f236k;
    }
}
