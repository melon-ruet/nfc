package com.nxp.taginfolite.p004f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.NdefFormatable;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcBarcode;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.v4.BuildConfig;
import android.text.TextUtils;
import android.util.Log;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.data.C0210d;
import com.nxp.taginfolite.data.C0213g;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p009e.C0252a;
import com.nxp.taginfolite.p009e.C0253s;
import com.nxp.taginfolite.p009e.C0260b;
import com.nxp.taginfolite.p009e.C0270w;
import com.nxp.taginfolite.p009e.C0271c;
import com.nxp.taginfolite.p009e.C0309h;
import com.nxp.taginfolite.p009e.C0315z;
import com.nxp.taginfolite.p009e.C0316n;
import com.nxp.taginfolite.p009e.aa;
import com.nxp.taginfolite.p009e.ab;
import com.nxp.taginfolite.p009e.ag;
import com.nxp.taginfolite.p009e.ax;
import com.nxp.taginfolite.p009e.ay;
import com.nxp.taginfolite.p009e.az;
import com.nxp.taginfolite.p009e.p012c.C0261a;

/* renamed from: com.nxp.taginfolite.f.w */
public abstract class C0370w extends AsyncTask {
    protected Context f1173a;
    protected C0213g f1174b;
    protected C0210d f1175c;
    protected C0261a f1176d;
    private C0176x f1177e;
    private final Tag f1178f;
    private Object f1179g;
    private boolean f1180h;
    private boolean f1181i;

    protected C0370w(C0176x c0176x, Activity activity, Intent intent) {
        if (intent.hasExtra("android.nfc.extra.TAG")) {
            this.f1177e = c0176x;
            this.f1173a = activity.getApplicationContext();
            this.f1175c = new C0210d();
            this.f1175c.m282a(this.f1173a, intent);
            this.f1174b = new C0213g();
            this.f1178f = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
            this.f1174b.m304a(this.f1178f);
            this.f1176d = new C0261a(activity);
            return;
        }
        throw new IllegalArgumentException("Can't make a tag scanner for an intent without tag");
    }

    private void m1106a() {
        if (this.f1177e != null) {
            this.f1177e.m139a().m187a(this.f1174b, this.f1175c);
            this.f1177e.m140a(this.f1181i, this.f1179g);
            this.f1180h = false;
            this.f1177e = null;
            this.f1176d = null;
            this.f1173a = null;
            this.f1175c = null;
        }
    }

    protected abstract Object m1107a(Object[] objArr);

    public final void m1108a(C0176x c0176x) {
        this.f1177e = c0176x;
        if (this.f1180h) {
            m1106a();
        }
    }

    @SuppressLint({"NewApi"})
    protected final Object doInBackground(Object... objArr) {
        NfcA nfcA;
        MifareClassic mifareClassic;
        MifareUltralight mifareUltralight;
        boolean z;
        NfcBarcode nfcBarcode;
        NfcV nfcV;
        ag agVar;
        NfcB nfcB;
        NfcA nfcA2;
        NfcF nfcF;
        C0271c c0271c;
        ay ayVar;
        C0428i c0428i;
        Object obj;
        CharSequence charSequence;
        String str;
        CharSequence charSequence2;
        byte[] id;
        Object a;
        IsoDep isoDep;
        MifareClassic mifareClassic2;
        C0271c c0271c2;
        ay ayVar2;
        C0158a a2 = C0158a.m30a(this.f1173a);
        boolean a3 = this.f1175c.m284a();
        C0271c c0271c3 = null;
        NfcB nfcB2 = null;
        IsoDep isoDep2 = null;
        MifareUltralight mifareUltralight2 = null;
        String str2 = BuildConfig.VERSION_NAME;
        try {
            NfcF nfcF2;
            NfcF nfcF3;
            if (a2.m57o()) {
                nfcA = NfcA.get(this.f1178f);
                if (nfcA != null) {
                    try {
                        mifareClassic = MifareClassic.get(this.f1178f);
                        if (mifareClassic == null) {
                            try {
                                mifareUltralight = MifareUltralight.get(this.f1178f);
                            } catch (IllegalStateException e) {
                                z = false;
                                nfcBarcode = null;
                                mifareUltralight = mifareUltralight2;
                                nfcV = null;
                                agVar = null;
                                nfcB = nfcB2;
                                nfcA2 = nfcA;
                                nfcF = null;
                                c0271c = null;
                                ayVar = null;
                                this.f1181i = true;
                                c0428i = new C0428i();
                                if (VERSION.SDK_INT > 10) {
                                    c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                                }
                                if (this.f1175c.m292h() != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                                }
                                if (NdefFormatable.get(this.f1178f) != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                                }
                                if (isoDep2 == null) {
                                    obj = str2;
                                } else {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                    c0428i.m1384a(C0369v.m1085a(isoDep2));
                                    charSequence = "IsoDep";
                                }
                                if (mifareClassic != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                    charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                                } else if (mifareUltralight != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                    charSequence = "MifareUltralight";
                                }
                                if (nfcA2 != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                    c0428i.m1384a(C0369v.m1086a(nfcA2));
                                    str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                                } else if (nfcB != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                    c0428i.m1384a(C0369v.m1090a(nfcB));
                                    str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                                } else if (nfcF != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                    c0428i.m1384a(C0369v.m1092a(nfcF));
                                    str = "NfcF";
                                } else if (nfcV == null) {
                                    if (nfcBarcode != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                        c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                        str = "NfcBarcode";
                                    }
                                    charSequence2 = charSequence;
                                } else {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                    c0428i.m1384a(C0369v.m1093a(nfcV));
                                    str = "NfcV";
                                }
                                if (mifareClassic == null) {
                                    if (a2.m68z()) {
                                        c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                    } else {
                                        c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                    }
                                }
                                str = "AndroidBeam";
                                id = this.f1178f.getId();
                                c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                                this.f1174b.m305a(ayVar, agVar, c0271c);
                                this.f1174b.m306a(c0428i.toString());
                                this.f1174b.m309b(str);
                                this.f1174b.m307a(z);
                                a = m1107a(objArr);
                                this.f1179g = a;
                                return a;
                            }
                        }
                        mifareUltralight = mifareUltralight2;
                    } catch (IllegalStateException e2) {
                        z = false;
                        nfcBarcode = null;
                        mifareUltralight = mifareUltralight2;
                        mifareClassic = null;
                        nfcV = null;
                        nfcF = null;
                        nfcB = nfcB2;
                        nfcA2 = nfcA;
                        agVar = null;
                        c0271c = null;
                        ayVar = null;
                        this.f1181i = true;
                        c0428i = new C0428i();
                        if (VERSION.SDK_INT > 10) {
                            c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                        }
                        if (this.f1175c.m292h() != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                        }
                        if (NdefFormatable.get(this.f1178f) != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                        }
                        if (isoDep2 == null) {
                            obj = str2;
                        } else {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                            c0428i.m1384a(C0369v.m1085a(isoDep2));
                            charSequence = "IsoDep";
                        }
                        if (mifareClassic != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                            if (TextUtils.isEmpty(charSequence)) {
                            }
                            charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                        } else if (mifareUltralight != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                            charSequence = "MifareUltralight";
                        }
                        if (nfcA2 != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                            c0428i.m1384a(C0369v.m1086a(nfcA2));
                            if (TextUtils.isEmpty(charSequence)) {
                            }
                            str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                        } else if (nfcB != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                            c0428i.m1384a(C0369v.m1090a(nfcB));
                            if (TextUtils.isEmpty(charSequence)) {
                            }
                            str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                        } else if (nfcF != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                            c0428i.m1384a(C0369v.m1092a(nfcF));
                            str = "NfcF";
                        } else if (nfcV == null) {
                            if (nfcBarcode != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                str = "NfcBarcode";
                            }
                            charSequence2 = charSequence;
                        } else {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                            c0428i.m1384a(C0369v.m1093a(nfcV));
                            str = "NfcV";
                        }
                        if (mifareClassic == null) {
                            if (a2.m68z()) {
                                c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                            } else {
                                c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                            }
                        }
                        str = "AndroidBeam";
                        id = this.f1178f.getId();
                        c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                        this.f1174b.m305a(ayVar, agVar, c0271c);
                        this.f1174b.m306a(c0428i.toString());
                        this.f1174b.m309b(str);
                        this.f1174b.m307a(z);
                        a = m1107a(objArr);
                        this.f1179g = a;
                        return a;
                    }
                }
                mifareUltralight = mifareUltralight2;
                mifareClassic = null;
                try {
                    NfcB nfcB3 = NfcB.get(this.f1178f);
                    try {
                        isoDep = IsoDep.get(this.f1178f);
                        try {
                            nfcF2 = NfcF.get(this.f1178f);
                            try {
                                nfcV = NfcV.get(this.f1178f);
                                try {
                                    ayVar = ax.m505a(this.f1178f);
                                    isoDep2 = isoDep;
                                    agVar = null;
                                    c0271c = null;
                                    nfcBarcode = null;
                                    nfcB = nfcB3;
                                    nfcA2 = nfcA;
                                    nfcF3 = nfcF2;
                                    z = false;
                                    nfcF = nfcF3;
                                } catch (IllegalStateException e3) {
                                    isoDep2 = isoDep;
                                    agVar = null;
                                    c0271c = null;
                                    ayVar = null;
                                    nfcBarcode = null;
                                    nfcB = nfcB3;
                                    nfcA2 = nfcA;
                                    nfcF = nfcF2;
                                    z = false;
                                    this.f1181i = true;
                                    c0428i = new C0428i();
                                    if (VERSION.SDK_INT > 10) {
                                        c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                                    }
                                    if (this.f1175c.m292h() != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                                    }
                                    if (NdefFormatable.get(this.f1178f) != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                                    }
                                    if (isoDep2 == null) {
                                        obj = str2;
                                    } else {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                        c0428i.m1384a(C0369v.m1085a(isoDep2));
                                        charSequence = "IsoDep";
                                    }
                                    if (mifareClassic != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                                    } else if (mifareUltralight != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                        charSequence = "MifareUltralight";
                                    }
                                    if (nfcA2 != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                        c0428i.m1384a(C0369v.m1086a(nfcA2));
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                                    } else if (nfcB != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                        c0428i.m1384a(C0369v.m1090a(nfcB));
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                                    } else if (nfcF != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                        c0428i.m1384a(C0369v.m1092a(nfcF));
                                        str = "NfcF";
                                    } else if (nfcV == null) {
                                        if (nfcBarcode != null) {
                                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                            c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                            str = "NfcBarcode";
                                        }
                                        charSequence2 = charSequence;
                                    } else {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                        c0428i.m1384a(C0369v.m1093a(nfcV));
                                        str = "NfcV";
                                    }
                                    if (mifareClassic == null) {
                                        if (a2.m68z()) {
                                            c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                        } else {
                                            c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                        }
                                    }
                                    str = "AndroidBeam";
                                    id = this.f1178f.getId();
                                    c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                                    this.f1174b.m305a(ayVar, agVar, c0271c);
                                    this.f1174b.m306a(c0428i.toString());
                                    this.f1174b.m309b(str);
                                    this.f1174b.m307a(z);
                                    a = m1107a(objArr);
                                    this.f1179g = a;
                                    return a;
                                }
                            } catch (IllegalStateException e4) {
                                isoDep2 = isoDep;
                                nfcV = null;
                                agVar = null;
                                ayVar = null;
                                c0271c = null;
                                nfcBarcode = null;
                                nfcB = nfcB3;
                                nfcA2 = nfcA;
                                nfcF3 = nfcF2;
                                z = false;
                                nfcF = nfcF3;
                                this.f1181i = true;
                                c0428i = new C0428i();
                                if (VERSION.SDK_INT > 10) {
                                    c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                                }
                                if (this.f1175c.m292h() != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                                }
                                if (NdefFormatable.get(this.f1178f) != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                                }
                                if (isoDep2 == null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                    c0428i.m1384a(C0369v.m1085a(isoDep2));
                                    charSequence = "IsoDep";
                                } else {
                                    obj = str2;
                                }
                                if (mifareClassic != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                    if (TextUtils.isEmpty(charSequence)) {
                                    }
                                    charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                                } else if (mifareUltralight != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                    charSequence = "MifareUltralight";
                                }
                                if (nfcA2 != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                    c0428i.m1384a(C0369v.m1086a(nfcA2));
                                    if (TextUtils.isEmpty(charSequence)) {
                                    }
                                    str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                                } else if (nfcB != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                    c0428i.m1384a(C0369v.m1090a(nfcB));
                                    if (TextUtils.isEmpty(charSequence)) {
                                    }
                                    str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                                } else if (nfcF != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                    c0428i.m1384a(C0369v.m1092a(nfcF));
                                    str = "NfcF";
                                } else if (nfcV == null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                    c0428i.m1384a(C0369v.m1093a(nfcV));
                                    str = "NfcV";
                                } else {
                                    if (nfcBarcode != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                        c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                        str = "NfcBarcode";
                                    }
                                    charSequence2 = charSequence;
                                }
                                if (mifareClassic == null) {
                                    if (a2.m68z()) {
                                        c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                    } else {
                                        c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                    }
                                }
                                str = "AndroidBeam";
                                id = this.f1178f.getId();
                                c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                                this.f1174b.m305a(ayVar, agVar, c0271c);
                                this.f1174b.m306a(c0428i.toString());
                                this.f1174b.m309b(str);
                                this.f1174b.m307a(z);
                                a = m1107a(objArr);
                                this.f1179g = a;
                                return a;
                            }
                        } catch (IllegalStateException e5) {
                            z = false;
                            isoDep2 = isoDep;
                            nfcV = null;
                            agVar = null;
                            nfcF = null;
                            nfcBarcode = null;
                            c0271c = null;
                            nfcB = nfcB3;
                            ayVar = null;
                            nfcA2 = nfcA;
                            this.f1181i = true;
                            c0428i = new C0428i();
                            if (VERSION.SDK_INT > 10) {
                                c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                            }
                            if (this.f1175c.m292h() != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                            }
                            if (NdefFormatable.get(this.f1178f) != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                            }
                            if (isoDep2 == null) {
                                obj = str2;
                            } else {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                c0428i.m1384a(C0369v.m1085a(isoDep2));
                                charSequence = "IsoDep";
                            }
                            if (mifareClassic != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                            } else if (mifareUltralight != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                charSequence = "MifareUltralight";
                            }
                            if (nfcA2 != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                c0428i.m1384a(C0369v.m1086a(nfcA2));
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                            } else if (nfcB != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                c0428i.m1384a(C0369v.m1090a(nfcB));
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                            } else if (nfcF != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                c0428i.m1384a(C0369v.m1092a(nfcF));
                                str = "NfcF";
                            } else if (nfcV == null) {
                                if (nfcBarcode != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                    c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                    str = "NfcBarcode";
                                }
                                charSequence2 = charSequence;
                            } else {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                c0428i.m1384a(C0369v.m1093a(nfcV));
                                str = "NfcV";
                            }
                            if (mifareClassic == null) {
                                if (a2.m68z()) {
                                    c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                } else {
                                    c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                }
                            }
                            str = "AndroidBeam";
                            id = this.f1178f.getId();
                            c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                            this.f1174b.m305a(ayVar, agVar, c0271c);
                            this.f1174b.m306a(c0428i.toString());
                            this.f1174b.m309b(str);
                            this.f1174b.m307a(z);
                            a = m1107a(objArr);
                            this.f1179g = a;
                            return a;
                        }
                    } catch (IllegalStateException e6) {
                        z = false;
                        nfcBarcode = null;
                        nfcV = null;
                        agVar = null;
                        nfcB = nfcB3;
                        nfcF = null;
                        c0271c = null;
                        nfcA2 = nfcA;
                        ayVar = null;
                        this.f1181i = true;
                        c0428i = new C0428i();
                        if (VERSION.SDK_INT > 10) {
                            c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                        }
                        if (this.f1175c.m292h() != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                        }
                        if (NdefFormatable.get(this.f1178f) != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                        }
                        if (isoDep2 == null) {
                            obj = str2;
                        } else {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                            c0428i.m1384a(C0369v.m1085a(isoDep2));
                            charSequence = "IsoDep";
                        }
                        if (mifareClassic != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                            if (TextUtils.isEmpty(charSequence)) {
                            }
                            charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                        } else if (mifareUltralight != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                            charSequence = "MifareUltralight";
                        }
                        if (nfcA2 != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                            c0428i.m1384a(C0369v.m1086a(nfcA2));
                            if (TextUtils.isEmpty(charSequence)) {
                            }
                            str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                        } else if (nfcB != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                            c0428i.m1384a(C0369v.m1090a(nfcB));
                            if (TextUtils.isEmpty(charSequence)) {
                            }
                            str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                        } else if (nfcF != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                            c0428i.m1384a(C0369v.m1092a(nfcF));
                            str = "NfcF";
                        } else if (nfcV == null) {
                            if (nfcBarcode != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                str = "NfcBarcode";
                            }
                            charSequence2 = charSequence;
                        } else {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                            c0428i.m1384a(C0369v.m1093a(nfcV));
                            str = "NfcV";
                        }
                        if (mifareClassic == null) {
                            if (a2.m68z()) {
                                c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                            } else {
                                c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                            }
                        }
                        str = "AndroidBeam";
                        id = this.f1178f.getId();
                        c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                        this.f1174b.m305a(ayVar, agVar, c0271c);
                        this.f1174b.m306a(c0428i.toString());
                        this.f1174b.m309b(str);
                        this.f1174b.m307a(z);
                        a = m1107a(objArr);
                        this.f1179g = a;
                        return a;
                    }
                } catch (IllegalStateException e7) {
                    z = false;
                    nfcBarcode = null;
                    nfcV = null;
                    nfcA2 = nfcA;
                    agVar = null;
                    nfcF = null;
                    nfcB = nfcB2;
                    c0271c = null;
                    ayVar = null;
                    this.f1181i = true;
                    c0428i = new C0428i();
                    if (VERSION.SDK_INT > 10) {
                        c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                    }
                    if (this.f1175c.m292h() != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                    }
                    if (NdefFormatable.get(this.f1178f) != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                    }
                    if (isoDep2 == null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                        c0428i.m1384a(C0369v.m1085a(isoDep2));
                        charSequence = "IsoDep";
                    } else {
                        obj = str2;
                    }
                    if (mifareClassic != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                    } else if (mifareUltralight != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                        charSequence = "MifareUltralight";
                    }
                    if (nfcA2 != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                        c0428i.m1384a(C0369v.m1086a(nfcA2));
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                    } else if (nfcB != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                        c0428i.m1384a(C0369v.m1090a(nfcB));
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                    } else if (nfcF != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                        c0428i.m1384a(C0369v.m1092a(nfcF));
                        str = "NfcF";
                    } else if (nfcV == null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                        c0428i.m1384a(C0369v.m1093a(nfcV));
                        str = "NfcV";
                    } else {
                        if (nfcBarcode != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                            c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                            str = "NfcBarcode";
                        }
                        charSequence2 = charSequence;
                    }
                    if (mifareClassic == null) {
                        if (a2.m68z()) {
                            c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                        } else {
                            c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                        }
                    }
                    str = "AndroidBeam";
                    id = this.f1178f.getId();
                    c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                    this.f1174b.m305a(ayVar, agVar, c0271c);
                    this.f1174b.m306a(c0428i.toString());
                    this.f1174b.m309b(str);
                    this.f1174b.m307a(z);
                    a = m1107a(objArr);
                    this.f1179g = a;
                    return a;
                }
            }
            nfcA = NfcA.get(this.f1178f);
            Object obj2;
            ay a4;
            C0253s a5;
            if (nfcA != null) {
                try {
                    mifareClassic2 = MifareClassic.get(this.f1178f);
                } catch (RuntimeException e8) {
                    mifareClassic2 = null;
                }
                try {
                    mifareUltralight2 = MifareUltralight.get(this.f1178f);
                } catch (IllegalStateException e9) {
                    z = false;
                    nfcBarcode = null;
                    mifareUltralight = mifareUltralight2;
                    mifareClassic = mifareClassic2;
                    nfcV = null;
                    nfcF = null;
                    nfcB = nfcB2;
                    nfcA2 = nfcA;
                    agVar = null;
                    c0271c = null;
                    ayVar = null;
                    this.f1181i = true;
                    c0428i = new C0428i();
                    if (VERSION.SDK_INT > 10) {
                        c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                    }
                    if (this.f1175c.m292h() != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                    }
                    if (NdefFormatable.get(this.f1178f) != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                    }
                    if (isoDep2 == null) {
                        obj = str2;
                    } else {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                        c0428i.m1384a(C0369v.m1085a(isoDep2));
                        charSequence = "IsoDep";
                    }
                    if (mifareClassic != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                    } else if (mifareUltralight != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                        charSequence = "MifareUltralight";
                    }
                    if (nfcA2 != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                        c0428i.m1384a(C0369v.m1086a(nfcA2));
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                    } else if (nfcB != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                        c0428i.m1384a(C0369v.m1090a(nfcB));
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                    } else if (nfcF != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                        c0428i.m1384a(C0369v.m1092a(nfcF));
                        str = "NfcF";
                    } else if (nfcV == null) {
                        if (nfcBarcode != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                            c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                            str = "NfcBarcode";
                        }
                        charSequence2 = charSequence;
                    } else {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                        c0428i.m1384a(C0369v.m1093a(nfcV));
                        str = "NfcV";
                    }
                    if (mifareClassic == null) {
                        if (a2.m68z()) {
                            c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                        } else {
                            c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                        }
                    }
                    str = "AndroidBeam";
                    id = this.f1178f.getId();
                    c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                    this.f1174b.m305a(ayVar, agVar, c0271c);
                    this.f1174b.m306a(c0428i.toString());
                    this.f1174b.m309b(str);
                    this.f1174b.m307a(z);
                    a = m1107a(objArr);
                    this.f1179g = a;
                    return a;
                }
                try {
                    az azVar;
                    ag a6;
                    isoDep = IsoDep.get(this.f1178f);
                    boolean z2 = (mifareClassic2 == null || isoDep == null) ? false : true;
                    if (mifareUltralight2 != null) {
                        try {
                            az a7 = az.m544a(this.f1178f, mifareUltralight2, a3, this.f1175c.m294j(), a2);
                            if (a3) {
                                try {
                                    this.f1175c.m283a(this.f1173a.getString(R.string.nfc_forum_tag));
                                    this.f1175c.m286b(this.f1173a.getString(R.string.type_2_tag));
                                } catch (IllegalStateException e10) {
                                    mifareUltralight = mifareUltralight2;
                                    mifareClassic = mifareClassic2;
                                    isoDep2 = isoDep;
                                    nfcV = null;
                                    nfcBarcode = null;
                                    nfcA2 = nfcA;
                                    agVar = null;
                                    c0271c = null;
                                    nfcB = nfcB2;
                                    obj2 = a7;
                                    z = z2;
                                    nfcF = null;
                                    this.f1181i = true;
                                    c0428i = new C0428i();
                                    if (VERSION.SDK_INT > 10) {
                                        c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                                    }
                                    if (this.f1175c.m292h() != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                                    }
                                    if (NdefFormatable.get(this.f1178f) != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                                    }
                                    if (isoDep2 == null) {
                                        obj = str2;
                                    } else {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                        c0428i.m1384a(C0369v.m1085a(isoDep2));
                                        charSequence = "IsoDep";
                                    }
                                    if (mifareClassic != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                                    } else if (mifareUltralight != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                        charSequence = "MifareUltralight";
                                    }
                                    if (nfcA2 != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                        c0428i.m1384a(C0369v.m1086a(nfcA2));
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                                    } else if (nfcB != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                        c0428i.m1384a(C0369v.m1090a(nfcB));
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                                    } else if (nfcF != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                        c0428i.m1384a(C0369v.m1092a(nfcF));
                                        str = "NfcF";
                                    } else if (nfcV == null) {
                                        if (nfcBarcode != null) {
                                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                            c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                            str = "NfcBarcode";
                                        }
                                        charSequence2 = charSequence;
                                    } else {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                        c0428i.m1384a(C0369v.m1093a(nfcV));
                                        str = "NfcV";
                                    }
                                    if (mifareClassic == null) {
                                        if (a2.m68z()) {
                                            c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                        } else {
                                            c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                        }
                                    }
                                    str = "AndroidBeam";
                                    id = this.f1178f.getId();
                                    c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                                    this.f1174b.m305a(ayVar, agVar, c0271c);
                                    this.f1174b.m306a(c0428i.toString());
                                    this.f1174b.m309b(str);
                                    this.f1174b.m307a(z);
                                    a = m1107a(objArr);
                                    this.f1179g = a;
                                    return a;
                                }
                            }
                            azVar = a7;
                        } catch (IllegalStateException e11) {
                            z = z2;
                            mifareUltralight = mifareUltralight2;
                            mifareClassic = mifareClassic2;
                            isoDep2 = isoDep;
                            nfcV = null;
                            nfcBarcode = null;
                            nfcF = null;
                            nfcA2 = nfcA;
                            agVar = null;
                            c0271c = null;
                            nfcB = nfcB2;
                            ayVar = null;
                            this.f1181i = true;
                            c0428i = new C0428i();
                            if (VERSION.SDK_INT > 10) {
                                c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                            }
                            if (this.f1175c.m292h() != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                            }
                            if (NdefFormatable.get(this.f1178f) != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                            }
                            if (isoDep2 == null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                c0428i.m1384a(C0369v.m1085a(isoDep2));
                                charSequence = "IsoDep";
                            } else {
                                obj = str2;
                            }
                            if (mifareClassic != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                            } else if (mifareUltralight != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                charSequence = "MifareUltralight";
                            }
                            if (nfcA2 != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                c0428i.m1384a(C0369v.m1086a(nfcA2));
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                            } else if (nfcB != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                c0428i.m1384a(C0369v.m1090a(nfcB));
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                            } else if (nfcF != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                c0428i.m1384a(C0369v.m1092a(nfcF));
                                str = "NfcF";
                            } else if (nfcV == null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                c0428i.m1384a(C0369v.m1093a(nfcV));
                                str = "NfcV";
                            } else {
                                if (nfcBarcode != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                    c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                    str = "NfcBarcode";
                                }
                                charSequence2 = charSequence;
                            }
                            if (mifareClassic == null) {
                                if (a2.m68z()) {
                                    c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                } else {
                                    c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                }
                            }
                            str = "AndroidBeam";
                            id = this.f1178f.getId();
                            c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                            this.f1174b.m305a(ayVar, agVar, c0271c);
                            this.f1174b.m306a(c0428i.toString());
                            this.f1174b.m309b(str);
                            this.f1174b.m307a(z);
                            a = m1107a(objArr);
                            this.f1179g = a;
                            return a;
                        }
                    }
                    azVar = null;
                    if (isoDep != null) {
                        boolean z3 = false;
                        try {
                            C0271c c0271c4;
                            Object obj3;
                            if (C0271c.m686a(isoDep)) {
                                C0271c a8 = C0271c.m682a(this.f1178f, isoDep, a2);
                                try {
                                    if (a8.m714e()) {
                                        z3 = true;
                                        c0271c3 = a8;
                                        obj3 = azVar;
                                    } else {
                                        c0271c3 = null;
                                        c0271c4 = a8;
                                    }
                                } catch (IllegalStateException e12) {
                                    mifareClassic = mifareClassic2;
                                    isoDep2 = isoDep;
                                    nfcV = null;
                                    nfcBarcode = null;
                                    agVar = null;
                                    c0271c = a8;
                                    nfcB = nfcB2;
                                    z = z2;
                                    nfcF = null;
                                    obj2 = azVar;
                                    mifareUltralight = mifareUltralight2;
                                    nfcA2 = nfcA;
                                    this.f1181i = true;
                                    c0428i = new C0428i();
                                    if (VERSION.SDK_INT > 10) {
                                        c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                                    }
                                    if (this.f1175c.m292h() != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                                    }
                                    if (NdefFormatable.get(this.f1178f) != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                                    }
                                    if (isoDep2 == null) {
                                        obj = str2;
                                    } else {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                        c0428i.m1384a(C0369v.m1085a(isoDep2));
                                        charSequence = "IsoDep";
                                    }
                                    if (mifareClassic != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                                    } else if (mifareUltralight != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                        charSequence = "MifareUltralight";
                                    }
                                    if (nfcA2 != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                        c0428i.m1384a(C0369v.m1086a(nfcA2));
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                                    } else if (nfcB != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                        c0428i.m1384a(C0369v.m1090a(nfcB));
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                                    } else if (nfcF != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                        c0428i.m1384a(C0369v.m1092a(nfcF));
                                        str = "NfcF";
                                    } else if (nfcV == null) {
                                        if (nfcBarcode != null) {
                                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                            c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                            str = "NfcBarcode";
                                        }
                                        charSequence2 = charSequence;
                                    } else {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                        c0428i.m1384a(C0369v.m1093a(nfcV));
                                        str = "NfcV";
                                    }
                                    if (mifareClassic == null) {
                                        if (a2.m68z()) {
                                            c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                        } else {
                                            c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                        }
                                    }
                                    str = "AndroidBeam";
                                    id = this.f1178f.getId();
                                    c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                                    this.f1174b.m305a(ayVar, agVar, c0271c);
                                    this.f1174b.m306a(c0428i.toString());
                                    this.f1174b.m309b(str);
                                    this.f1174b.m307a(z);
                                    a = m1107a(objArr);
                                    this.f1179g = a;
                                    return a;
                                }
                            }
                            obj3 = azVar;
                            if (!z2) {
                                try {
                                    if (ab.m430a(nfcA, isoDep)) {
                                        a4 = ab.m429a(this.f1178f, nfcA, isoDep, a2);
                                        if (a3) {
                                            try {
                                                if ("org.nfcforum.ndef.type4".equals(this.f1175c.m292h().getType())) {
                                                    this.f1175c.m283a(this.f1173a.getString(R.string.nfc_forum_like_tag));
                                                    this.f1175c.m286b(this.f1173a.getString(R.string.type_mifare_tag));
                                                } else {
                                                    this.f1175c.m283a(this.f1173a.getString(R.string.nfc_forum_tag));
                                                    this.f1175c.m286b(this.f1173a.getString(R.string.type_4_tag));
                                                    c0271c2 = c0271c3;
                                                    ayVar2 = a4;
                                                }
                                            } catch (IllegalStateException e13) {
                                                mifareUltralight = mifareUltralight2;
                                                mifareClassic = mifareClassic2;
                                                isoDep2 = isoDep;
                                                nfcV = null;
                                                nfcBarcode = null;
                                                nfcA2 = nfcA;
                                                agVar = null;
                                                c0271c = c0271c3;
                                                nfcB = nfcB2;
                                                ayVar = a4;
                                                z = z2;
                                                nfcF = null;
                                                this.f1181i = true;
                                                c0428i = new C0428i();
                                                if (VERSION.SDK_INT > 10) {
                                                    c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                                                }
                                                if (this.f1175c.m292h() != null) {
                                                    c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                                                }
                                                if (NdefFormatable.get(this.f1178f) != null) {
                                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                                                }
                                                if (isoDep2 == null) {
                                                    c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                                    c0428i.m1384a(C0369v.m1085a(isoDep2));
                                                    charSequence = "IsoDep";
                                                } else {
                                                    obj = str2;
                                                }
                                                if (mifareClassic != null) {
                                                    c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                                    if (TextUtils.isEmpty(charSequence)) {
                                                    }
                                                    charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                                                } else if (mifareUltralight != null) {
                                                    c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                                    charSequence = "MifareUltralight";
                                                }
                                                if (nfcA2 != null) {
                                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                                    c0428i.m1384a(C0369v.m1086a(nfcA2));
                                                    if (TextUtils.isEmpty(charSequence)) {
                                                    }
                                                    str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                                                } else if (nfcB != null) {
                                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                                    c0428i.m1384a(C0369v.m1090a(nfcB));
                                                    if (TextUtils.isEmpty(charSequence)) {
                                                    }
                                                    str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                                                } else if (nfcF != null) {
                                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                                    c0428i.m1384a(C0369v.m1092a(nfcF));
                                                    str = "NfcF";
                                                } else if (nfcV == null) {
                                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                                    c0428i.m1384a(C0369v.m1093a(nfcV));
                                                    str = "NfcV";
                                                } else {
                                                    if (nfcBarcode != null) {
                                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                                        c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                                        str = "NfcBarcode";
                                                    }
                                                    charSequence2 = charSequence;
                                                }
                                                if (mifareClassic == null) {
                                                    if (a2.m68z()) {
                                                        c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                                    } else {
                                                        c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                                    }
                                                }
                                                str = "AndroidBeam";
                                                id = this.f1178f.getId();
                                                c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                                                this.f1174b.m305a(ayVar, agVar, c0271c);
                                                this.f1174b.m306a(c0428i.toString());
                                                this.f1174b.m309b(str);
                                                this.f1174b.m307a(z);
                                                a = m1107a(objArr);
                                                this.f1179g = a;
                                                return a;
                                            }
                                        }
                                        c0271c2 = c0271c3;
                                        ayVar2 = a4;
                                    }
                                } catch (IllegalStateException e14) {
                                    z = z2;
                                    mifareUltralight = mifareUltralight2;
                                    mifareClassic = mifareClassic2;
                                    isoDep2 = isoDep;
                                    nfcV = null;
                                    nfcBarcode = null;
                                    nfcF = null;
                                    nfcA2 = nfcA;
                                    agVar = null;
                                    c0271c = c0271c3;
                                    nfcB = nfcB2;
                                    obj2 = c0271c4;
                                    this.f1181i = true;
                                    c0428i = new C0428i();
                                    if (VERSION.SDK_INT > 10) {
                                        c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                                    }
                                    if (this.f1175c.m292h() != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                                    }
                                    if (NdefFormatable.get(this.f1178f) != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                                    }
                                    if (isoDep2 == null) {
                                        obj = str2;
                                    } else {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                        c0428i.m1384a(C0369v.m1085a(isoDep2));
                                        charSequence = "IsoDep";
                                    }
                                    if (mifareClassic != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                                    } else if (mifareUltralight != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                        charSequence = "MifareUltralight";
                                    }
                                    if (nfcA2 != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                        c0428i.m1384a(C0369v.m1086a(nfcA2));
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                                    } else if (nfcB != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                        c0428i.m1384a(C0369v.m1090a(nfcB));
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                                    } else if (nfcF != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                        c0428i.m1384a(C0369v.m1092a(nfcF));
                                        str = "NfcF";
                                    } else if (nfcV == null) {
                                        if (nfcBarcode != null) {
                                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                            c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                            str = "NfcBarcode";
                                        }
                                        charSequence2 = charSequence;
                                    } else {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                        c0428i.m1384a(C0369v.m1093a(nfcV));
                                        str = "NfcV";
                                    }
                                    if (mifareClassic == null) {
                                        if (a2.m68z()) {
                                            c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                        } else {
                                            c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                        }
                                    }
                                    str = "AndroidBeam";
                                    id = this.f1178f.getId();
                                    c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                                    this.f1174b.m305a(ayVar, agVar, c0271c);
                                    this.f1174b.m306a(c0428i.toString());
                                    this.f1174b.m309b(str);
                                    this.f1174b.m307a(z);
                                    a = m1107a(objArr);
                                    this.f1179g = a;
                                    return a;
                                }
                            }
                            if (c0271c4 == null) {
                                a4 = C0270w.m617a(this.f1178f, isoDep, C0360m.ISO14443_A, a3, z3, this.f1175c.m294j(), a2);
                            } else {
                                a = c0271c4;
                            }
                            if (a3) {
                                if ("org.nfcforum.ndef.type4".equals(this.f1175c.m292h().getType())) {
                                    this.f1175c.m283a(this.f1173a.getString(R.string.nfc_forum_like_tag));
                                    this.f1175c.m286b(this.f1173a.getString(R.string.type_mifare_tag));
                                } else {
                                    this.f1175c.m283a(this.f1173a.getString(R.string.nfc_forum_tag));
                                    this.f1175c.m286b(this.f1173a.getString(R.string.type_4_tag));
                                    c0271c2 = c0271c3;
                                    ayVar2 = a4;
                                }
                            }
                            c0271c2 = c0271c3;
                            ayVar2 = a4;
                        } catch (IllegalStateException e15) {
                            z = z2;
                            mifareClassic = mifareClassic2;
                            isoDep2 = isoDep;
                            nfcV = null;
                            nfcBarcode = null;
                            nfcF = null;
                            agVar = null;
                            c0271c = null;
                            nfcB = nfcB2;
                            obj2 = azVar;
                            mifareUltralight = mifareUltralight2;
                            nfcA2 = nfcA;
                            this.f1181i = true;
                            c0428i = new C0428i();
                            if (VERSION.SDK_INT > 10) {
                                c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                            }
                            if (this.f1175c.m292h() != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                            }
                            if (NdefFormatable.get(this.f1178f) != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                            }
                            if (isoDep2 == null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                c0428i.m1384a(C0369v.m1085a(isoDep2));
                                charSequence = "IsoDep";
                            } else {
                                obj = str2;
                            }
                            if (mifareClassic != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                            } else if (mifareUltralight != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                charSequence = "MifareUltralight";
                            }
                            if (nfcA2 != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                c0428i.m1384a(C0369v.m1086a(nfcA2));
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                            } else if (nfcB != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                c0428i.m1384a(C0369v.m1090a(nfcB));
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                            } else if (nfcF != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                c0428i.m1384a(C0369v.m1092a(nfcF));
                                str = "NfcF";
                            } else if (nfcV == null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                c0428i.m1384a(C0369v.m1093a(nfcV));
                                str = "NfcV";
                            } else {
                                if (nfcBarcode != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                    c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                    str = "NfcBarcode";
                                }
                                charSequence2 = charSequence;
                            }
                            if (mifareClassic == null) {
                                if (a2.m68z()) {
                                    c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                } else {
                                    c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                }
                            }
                            str = "AndroidBeam";
                            id = this.f1178f.getId();
                            c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                            this.f1174b.m305a(ayVar, agVar, c0271c);
                            this.f1174b.m306a(c0428i.toString());
                            this.f1174b.m309b(str);
                            this.f1174b.m307a(z);
                            a = m1107a(objArr);
                            this.f1179g = a;
                            return a;
                        }
                    }
                    obj = azVar;
                    c0271c2 = null;
                    if (mifareClassic2 != null) {
                        try {
                            a6 = ag.m453a(this.f1178f, mifareClassic2, a3, a2, z2);
                            if (!z2) {
                                ayVar2 = a6;
                            }
                            if (a3) {
                                try {
                                    if ("org.nfcforum.ndef.type4".equals(this.f1175c.m292h().getType())) {
                                        this.f1175c.m283a(this.f1173a.getString(R.string.nfc_forum_tag));
                                        this.f1175c.m286b(this.f1173a.getString(R.string.type_4_tag));
                                    } else {
                                        this.f1175c.m283a(this.f1173a.getString(R.string.nfc_forum_like_tag));
                                        String e16 = a6.m499e();
                                        if (!"NXP Semiconductors".equals(e16)) {
                                            if (!"Infineon Technologies AG".equals(e16)) {
                                                this.f1175c.m286b(this.f1173a.getString(R.string.type_nfca_tag));
                                            }
                                        }
                                        this.f1175c.m286b(this.f1173a.getString(R.string.type_mifare_tag));
                                    }
                                } catch (IllegalStateException e17) {
                                    mifareClassic = mifareClassic2;
                                    nfcV = null;
                                    agVar = a6;
                                    c0271c = c0271c2;
                                    mifareUltralight = mifareUltralight2;
                                    z = z2;
                                    nfcF = null;
                                    nfcA2 = nfcA;
                                    ayVar = ayVar2;
                                    isoDep2 = isoDep;
                                    nfcBarcode = null;
                                    nfcB = nfcB2;
                                    this.f1181i = true;
                                    c0428i = new C0428i();
                                    if (VERSION.SDK_INT > 10) {
                                        c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                                    }
                                    if (this.f1175c.m292h() != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                                    }
                                    if (NdefFormatable.get(this.f1178f) != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                                    }
                                    if (isoDep2 == null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                        c0428i.m1384a(C0369v.m1085a(isoDep2));
                                        charSequence = "IsoDep";
                                    } else {
                                        obj = str2;
                                    }
                                    if (mifareClassic != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                                    } else if (mifareUltralight != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                        charSequence = "MifareUltralight";
                                    }
                                    if (nfcA2 != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                        c0428i.m1384a(C0369v.m1086a(nfcA2));
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                                    } else if (nfcB != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                        c0428i.m1384a(C0369v.m1090a(nfcB));
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                                    } else if (nfcF != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                        c0428i.m1384a(C0369v.m1092a(nfcF));
                                        str = "NfcF";
                                    } else if (nfcV == null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                        c0428i.m1384a(C0369v.m1093a(nfcV));
                                        str = "NfcV";
                                    } else {
                                        if (nfcBarcode != null) {
                                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                            c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                            str = "NfcBarcode";
                                        }
                                        charSequence2 = charSequence;
                                    }
                                    if (mifareClassic == null) {
                                        if (a2.m68z()) {
                                            c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                        } else {
                                            c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                        }
                                    }
                                    str = "AndroidBeam";
                                    id = this.f1178f.getId();
                                    c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                                    this.f1174b.m305a(ayVar, agVar, c0271c);
                                    this.f1174b.m306a(c0428i.toString());
                                    this.f1174b.m309b(str);
                                    this.f1174b.m307a(z);
                                    a = m1107a(objArr);
                                    this.f1179g = a;
                                    return a;
                                }
                            }
                        } catch (IllegalStateException e18) {
                            z = z2;
                            mifareClassic = mifareClassic2;
                            nfcV = null;
                            nfcF = null;
                            agVar = null;
                            c0271c = c0271c2;
                            mifareUltralight = mifareUltralight2;
                            ayVar = ayVar2;
                            nfcA2 = nfcA;
                            isoDep2 = isoDep;
                            nfcBarcode = null;
                            nfcB = nfcB2;
                            this.f1181i = true;
                            c0428i = new C0428i();
                            if (VERSION.SDK_INT > 10) {
                                c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                            }
                            if (this.f1175c.m292h() != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                            }
                            if (NdefFormatable.get(this.f1178f) != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                            }
                            if (isoDep2 == null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                c0428i.m1384a(C0369v.m1085a(isoDep2));
                                charSequence = "IsoDep";
                            } else {
                                obj = str2;
                            }
                            if (mifareClassic != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                            } else if (mifareUltralight != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                charSequence = "MifareUltralight";
                            }
                            if (nfcA2 != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                c0428i.m1384a(C0369v.m1086a(nfcA2));
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                            } else if (nfcB != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                c0428i.m1384a(C0369v.m1090a(nfcB));
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                            } else if (nfcF != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                c0428i.m1384a(C0369v.m1092a(nfcF));
                                str = "NfcF";
                            } else if (nfcV == null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                c0428i.m1384a(C0369v.m1093a(nfcV));
                                str = "NfcV";
                            } else {
                                if (nfcBarcode != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                    c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                    str = "NfcBarcode";
                                }
                                charSequence2 = charSequence;
                            }
                            if (mifareClassic == null) {
                                if (a2.m68z()) {
                                    c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                } else {
                                    c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                }
                            }
                            str = "AndroidBeam";
                            id = this.f1178f.getId();
                            c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                            this.f1174b.m305a(ayVar, agVar, c0271c);
                            this.f1174b.m306a(c0428i.toString());
                            this.f1174b.m309b(str);
                            this.f1174b.m307a(z);
                            a = m1107a(objArr);
                            this.f1179g = a;
                            return a;
                        }
                    }
                    a6 = null;
                    if (aa.m416a(nfcA)) {
                        ayVar2 = aa.m413a(this.f1178f, a2);
                        if (a3) {
                            try {
                                this.f1175c.m283a(this.f1173a.getString(R.string.nfc_forum_tag));
                                this.f1175c.m286b(this.f1173a.getString(R.string.type_1_tag));
                            } catch (IllegalStateException e19) {
                                mifareClassic = mifareClassic2;
                                nfcV = null;
                                agVar = a6;
                                c0271c = c0271c2;
                                mifareUltralight = mifareUltralight2;
                                z = z2;
                                nfcF = null;
                                nfcA2 = nfcA;
                                ayVar = ayVar2;
                                isoDep2 = isoDep;
                                nfcBarcode = null;
                                nfcB = nfcB2;
                                this.f1181i = true;
                                c0428i = new C0428i();
                                if (VERSION.SDK_INT > 10) {
                                    c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                                }
                                if (this.f1175c.m292h() != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                                }
                                if (NdefFormatable.get(this.f1178f) != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                                }
                                if (isoDep2 == null) {
                                    obj = str2;
                                } else {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                    c0428i.m1384a(C0369v.m1085a(isoDep2));
                                    charSequence = "IsoDep";
                                }
                                if (mifareClassic != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                    if (TextUtils.isEmpty(charSequence)) {
                                    }
                                    charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                                } else if (mifareUltralight != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                    charSequence = "MifareUltralight";
                                }
                                if (nfcA2 != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                    c0428i.m1384a(C0369v.m1086a(nfcA2));
                                    if (TextUtils.isEmpty(charSequence)) {
                                    }
                                    str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                                } else if (nfcB != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                    c0428i.m1384a(C0369v.m1090a(nfcB));
                                    if (TextUtils.isEmpty(charSequence)) {
                                    }
                                    str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                                } else if (nfcF != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                    c0428i.m1384a(C0369v.m1092a(nfcF));
                                    str = "NfcF";
                                } else if (nfcV == null) {
                                    if (nfcBarcode != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                        c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                        str = "NfcBarcode";
                                    }
                                    charSequence2 = charSequence;
                                } else {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                    c0428i.m1384a(C0369v.m1093a(nfcV));
                                    str = "NfcV";
                                }
                                if (mifareClassic == null) {
                                    if (a2.m68z()) {
                                        c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                    } else {
                                        c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                    }
                                }
                                str = "AndroidBeam";
                                id = this.f1178f.getId();
                                c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                                this.f1174b.m305a(ayVar, agVar, c0271c);
                                this.f1174b.m306a(c0428i.toString());
                                this.f1174b.m309b(str);
                                this.f1174b.m307a(z);
                                a = m1107a(objArr);
                                this.f1179g = a;
                                return a;
                            }
                        }
                    }
                    if (ayVar2 == null) {
                        a5 = C0253s.m520a(this.f1178f, C0360m.ISO14443_A, a3, a2, z2);
                        if (a3) {
                            try {
                                String type = this.f1175c.m292h().getType();
                                if ("org.nfcforum.ndef.type4".equals(type)) {
                                    this.f1175c.m283a(this.f1173a.getString(R.string.nfc_forum_tag));
                                    this.f1175c.m286b(this.f1173a.getString(R.string.type_4_tag));
                                } else if ("com.nxp.ndef.mifareclassic".equals(type) || a5.m543g()) {
                                    this.f1175c.m283a(this.f1173a.getString(R.string.nfc_forum_like_tag));
                                    this.f1175c.m286b(this.f1173a.getString(R.string.type_mifare_tag));
                                } else {
                                    this.f1175c.m283a(this.f1173a.getString(R.string.nfc_forum_tag));
                                    this.f1175c.m286b(this.f1173a.getString(R.string.type_2_tag));
                                }
                            } catch (IllegalStateException e20) {
                                mifareClassic = mifareClassic2;
                                nfcV = null;
                                agVar = a6;
                                c0271c = c0271c2;
                                mifareUltralight = mifareUltralight2;
                                z = z2;
                                nfcF = null;
                                nfcA2 = nfcA;
                                obj2 = a5;
                                isoDep2 = isoDep;
                                nfcBarcode = null;
                                nfcB = nfcB2;
                                this.f1181i = true;
                                c0428i = new C0428i();
                                if (VERSION.SDK_INT > 10) {
                                    c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                                }
                                if (this.f1175c.m292h() != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                                }
                                if (NdefFormatable.get(this.f1178f) != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                                }
                                if (isoDep2 == null) {
                                    obj = str2;
                                } else {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                    c0428i.m1384a(C0369v.m1085a(isoDep2));
                                    charSequence = "IsoDep";
                                }
                                if (mifareClassic != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                    if (TextUtils.isEmpty(charSequence)) {
                                    }
                                    charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                                } else if (mifareUltralight != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                    charSequence = "MifareUltralight";
                                }
                                if (nfcA2 != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                    c0428i.m1384a(C0369v.m1086a(nfcA2));
                                    if (TextUtils.isEmpty(charSequence)) {
                                    }
                                    str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                                } else if (nfcB != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                    c0428i.m1384a(C0369v.m1090a(nfcB));
                                    if (TextUtils.isEmpty(charSequence)) {
                                    }
                                    str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                                } else if (nfcF != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                    c0428i.m1384a(C0369v.m1092a(nfcF));
                                    str = "NfcF";
                                } else if (nfcV == null) {
                                    if (nfcBarcode != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                        c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                        str = "NfcBarcode";
                                    }
                                    charSequence2 = charSequence;
                                } else {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                    c0428i.m1384a(C0369v.m1093a(nfcV));
                                    str = "NfcV";
                                }
                                if (mifareClassic == null) {
                                    if (a2.m68z()) {
                                        c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                    } else {
                                        c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                    }
                                }
                                str = "AndroidBeam";
                                id = this.f1178f.getId();
                                c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                                this.f1174b.m305a(ayVar, agVar, c0271c);
                                this.f1174b.m306a(c0428i.toString());
                                this.f1174b.m309b(str);
                                this.f1174b.m307a(z);
                                a = m1107a(objArr);
                                this.f1179g = a;
                                return a;
                            }
                        }
                        mifareClassic = mifareClassic2;
                        nfcV = null;
                        agVar = a6;
                        c0271c = c0271c2;
                        mifareUltralight = mifareUltralight2;
                        z = z2;
                        nfcF = null;
                        nfcA2 = nfcA;
                        obj2 = a5;
                        isoDep2 = isoDep;
                        nfcBarcode = null;
                        nfcB = nfcB2;
                    } else {
                        mifareClassic = mifareClassic2;
                        nfcV = null;
                        agVar = a6;
                        c0271c = c0271c2;
                        mifareUltralight = mifareUltralight2;
                        z = z2;
                        nfcF = null;
                        nfcA2 = nfcA;
                        ayVar = ayVar2;
                        isoDep2 = isoDep;
                        nfcBarcode = null;
                        nfcB = nfcB2;
                    }
                } catch (IllegalStateException e21) {
                    z = false;
                    nfcBarcode = null;
                    mifareUltralight = mifareUltralight2;
                    mifareClassic = mifareClassic2;
                    nfcV = null;
                    nfcF = null;
                    nfcB = nfcB2;
                    nfcA2 = nfcA;
                    agVar = null;
                    c0271c = null;
                    ayVar = null;
                    this.f1181i = true;
                    c0428i = new C0428i();
                    if (VERSION.SDK_INT > 10) {
                        c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                    }
                    if (this.f1175c.m292h() != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                    }
                    if (NdefFormatable.get(this.f1178f) != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                    }
                    if (isoDep2 == null) {
                        obj = str2;
                    } else {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                        c0428i.m1384a(C0369v.m1085a(isoDep2));
                        charSequence = "IsoDep";
                    }
                    if (mifareClassic != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                    } else if (mifareUltralight != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                        charSequence = "MifareUltralight";
                    }
                    if (nfcA2 != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                        c0428i.m1384a(C0369v.m1086a(nfcA2));
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                    } else if (nfcB != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                        c0428i.m1384a(C0369v.m1090a(nfcB));
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                    } else if (nfcF != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                        c0428i.m1384a(C0369v.m1092a(nfcF));
                        str = "NfcF";
                    } else if (nfcV == null) {
                        if (nfcBarcode != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                            c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                            str = "NfcBarcode";
                        }
                        charSequence2 = charSequence;
                    } else {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                        c0428i.m1384a(C0369v.m1093a(nfcV));
                        str = "NfcV";
                    }
                    if (mifareClassic == null) {
                        if (a2.m68z()) {
                            c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                        } else {
                            c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                        }
                    }
                    str = "AndroidBeam";
                    id = this.f1178f.getId();
                    c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                    this.f1174b.m305a(ayVar, agVar, c0271c);
                    this.f1174b.m306a(c0428i.toString());
                    this.f1174b.m309b(str);
                    this.f1174b.m307a(z);
                    a = m1107a(objArr);
                    this.f1179g = a;
                    return a;
                }
            }
            nfcB2 = NfcB.get(this.f1178f);
            if (nfcB2 != null) {
                try {
                    isoDep = IsoDep.get(this.f1178f);
                    if (isoDep != null) {
                        try {
                            a4 = C0270w.m617a(this.f1178f, isoDep, C0360m.ISO14443_B, a3, false, null, a2);
                            if (a3) {
                                try {
                                    this.f1175c.m283a(this.f1173a.getString(R.string.nfc_forum_tag));
                                    this.f1175c.m286b(this.f1173a.getString(R.string.type_4_tag));
                                    mifareUltralight = mifareUltralight2;
                                    mifareClassic = null;
                                    isoDep2 = isoDep;
                                    nfcV = null;
                                    nfcBarcode = null;
                                    nfcA2 = nfcA;
                                    agVar = null;
                                    c0271c = null;
                                    nfcB = nfcB2;
                                    ayVar = a4;
                                    z = false;
                                    nfcF = null;
                                } catch (IllegalStateException e22) {
                                    mifareUltralight = mifareUltralight2;
                                    mifareClassic = null;
                                    isoDep2 = isoDep;
                                    nfcV = null;
                                    nfcBarcode = null;
                                    nfcA2 = nfcA;
                                    agVar = null;
                                    c0271c = null;
                                    nfcB = nfcB2;
                                    ayVar = a4;
                                    z = false;
                                    nfcF = null;
                                    this.f1181i = true;
                                    c0428i = new C0428i();
                                    if (VERSION.SDK_INT > 10) {
                                        c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                                    }
                                    if (this.f1175c.m292h() != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                                    }
                                    if (NdefFormatable.get(this.f1178f) != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                                    }
                                    if (isoDep2 == null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                        c0428i.m1384a(C0369v.m1085a(isoDep2));
                                        charSequence = "IsoDep";
                                    } else {
                                        obj = str2;
                                    }
                                    if (mifareClassic != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                                    } else if (mifareUltralight != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                        charSequence = "MifareUltralight";
                                    }
                                    if (nfcA2 != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                        c0428i.m1384a(C0369v.m1086a(nfcA2));
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                                    } else if (nfcB != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                        c0428i.m1384a(C0369v.m1090a(nfcB));
                                        if (TextUtils.isEmpty(charSequence)) {
                                        }
                                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                                    } else if (nfcF != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                        c0428i.m1384a(C0369v.m1092a(nfcF));
                                        str = "NfcF";
                                    } else if (nfcV == null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                        c0428i.m1384a(C0369v.m1093a(nfcV));
                                        str = "NfcV";
                                    } else {
                                        if (nfcBarcode != null) {
                                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                            c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                            str = "NfcBarcode";
                                        }
                                        charSequence2 = charSequence;
                                    }
                                    if (mifareClassic == null) {
                                        if (a2.m68z()) {
                                            c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                        } else {
                                            c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                        }
                                    }
                                    str = "AndroidBeam";
                                    id = this.f1178f.getId();
                                    c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                                    this.f1174b.m305a(ayVar, agVar, c0271c);
                                    this.f1174b.m306a(c0428i.toString());
                                    this.f1174b.m309b(str);
                                    this.f1174b.m307a(z);
                                    a = m1107a(objArr);
                                    this.f1179g = a;
                                    return a;
                                }
                            }
                            mifareUltralight = mifareUltralight2;
                            mifareClassic = null;
                            isoDep2 = isoDep;
                            nfcV = null;
                            nfcBarcode = null;
                            nfcA2 = nfcA;
                            agVar = null;
                            c0271c = null;
                            nfcB = nfcB2;
                            ayVar = a4;
                            z = false;
                            nfcF = null;
                        } catch (IllegalStateException e23) {
                            z = false;
                            mifareUltralight = mifareUltralight2;
                            mifareClassic = null;
                            isoDep2 = isoDep;
                            nfcV = null;
                            nfcBarcode = null;
                            nfcF = null;
                            nfcA2 = nfcA;
                            agVar = null;
                            c0271c = null;
                            nfcB = nfcB2;
                            ayVar = null;
                            this.f1181i = true;
                            c0428i = new C0428i();
                            if (VERSION.SDK_INT > 10) {
                                c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                            }
                            if (this.f1175c.m292h() != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                            }
                            if (NdefFormatable.get(this.f1178f) != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                            }
                            if (isoDep2 == null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                c0428i.m1384a(C0369v.m1085a(isoDep2));
                                charSequence = "IsoDep";
                            } else {
                                obj = str2;
                            }
                            if (mifareClassic != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                            } else if (mifareUltralight != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                charSequence = "MifareUltralight";
                            }
                            if (nfcA2 != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                c0428i.m1384a(C0369v.m1086a(nfcA2));
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                            } else if (nfcB != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                c0428i.m1384a(C0369v.m1090a(nfcB));
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                            } else if (nfcF != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                c0428i.m1384a(C0369v.m1092a(nfcF));
                                str = "NfcF";
                            } else if (nfcV == null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                c0428i.m1384a(C0369v.m1093a(nfcV));
                                str = "NfcV";
                            } else {
                                if (nfcBarcode != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                    c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                    str = "NfcBarcode";
                                }
                                charSequence2 = charSequence;
                            }
                            if (mifareClassic == null) {
                                if (a2.m68z()) {
                                    c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                } else {
                                    c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                }
                            }
                            str = "AndroidBeam";
                            id = this.f1178f.getId();
                            c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                            this.f1174b.m305a(ayVar, agVar, c0271c);
                            this.f1174b.m306a(c0428i.toString());
                            this.f1174b.m309b(str);
                            this.f1174b.m307a(z);
                            a = m1107a(objArr);
                            this.f1179g = a;
                            return a;
                        }
                    }
                    a5 = C0253s.m520a(this.f1178f, C0360m.ISO14443_B, a3, a2, false);
                    z = false;
                    mifareUltralight = mifareUltralight2;
                    mifareClassic = null;
                    nfcV = null;
                    nfcF = null;
                    nfcA2 = nfcA;
                    agVar = null;
                    c0271c = null;
                    obj2 = a5;
                    isoDep2 = isoDep;
                    nfcBarcode = null;
                    nfcB = nfcB2;
                } catch (IllegalStateException e24) {
                    z = false;
                    nfcBarcode = null;
                    mifareUltralight = mifareUltralight2;
                    mifareClassic = null;
                    nfcV = null;
                    nfcF = null;
                    nfcB = nfcB2;
                    nfcA2 = nfcA;
                    agVar = null;
                    c0271c = null;
                    ayVar = null;
                    this.f1181i = true;
                    c0428i = new C0428i();
                    if (VERSION.SDK_INT > 10) {
                        c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                    }
                    if (this.f1175c.m292h() != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                    }
                    if (NdefFormatable.get(this.f1178f) != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                    }
                    if (isoDep2 == null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                        c0428i.m1384a(C0369v.m1085a(isoDep2));
                        charSequence = "IsoDep";
                    } else {
                        obj = str2;
                    }
                    if (mifareClassic != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                    } else if (mifareUltralight != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                        charSequence = "MifareUltralight";
                    }
                    if (nfcA2 != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                        c0428i.m1384a(C0369v.m1086a(nfcA2));
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                    } else if (nfcB != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                        c0428i.m1384a(C0369v.m1090a(nfcB));
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                    } else if (nfcF != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                        c0428i.m1384a(C0369v.m1092a(nfcF));
                        str = "NfcF";
                    } else if (nfcV == null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                        c0428i.m1384a(C0369v.m1093a(nfcV));
                        str = "NfcV";
                    } else {
                        if (nfcBarcode != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                            c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                            str = "NfcBarcode";
                        }
                        charSequence2 = charSequence;
                    }
                    if (mifareClassic == null) {
                        if (a2.m68z()) {
                            c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                        } else {
                            c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                        }
                    }
                    str = "AndroidBeam";
                    id = this.f1178f.getId();
                    c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                    this.f1174b.m305a(ayVar, agVar, c0271c);
                    this.f1174b.m306a(c0428i.toString());
                    this.f1174b.m309b(str);
                    this.f1174b.m307a(z);
                    a = m1107a(objArr);
                    this.f1179g = a;
                    return a;
                }
            }
            nfcF2 = NfcF.get(this.f1178f);
            if (nfcF2 != null) {
                try {
                    ayVar = C0309h.m831a(this.f1178f, nfcF2, a3, a2, this.f1176d);
                    if (a3) {
                        try {
                            this.f1175c.m283a(this.f1173a.getString(R.string.nfc_forum_tag));
                            this.f1175c.m286b(this.f1173a.getString(R.string.type_3_tag));
                            nfcBarcode = null;
                            mifareUltralight = mifareUltralight2;
                            mifareClassic = null;
                            nfcV = null;
                            nfcB = nfcB2;
                            nfcA2 = nfcA;
                            agVar = null;
                            c0271c = null;
                            nfcF = nfcF2;
                            z = false;
                        } catch (IllegalStateException e25) {
                            nfcBarcode = null;
                            mifareUltralight = mifareUltralight2;
                            mifareClassic = null;
                            nfcV = null;
                            nfcB = nfcB2;
                            nfcA2 = nfcA;
                            agVar = null;
                            c0271c = null;
                            nfcF = nfcF2;
                            z = false;
                            this.f1181i = true;
                            c0428i = new C0428i();
                            if (VERSION.SDK_INT > 10) {
                                c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                            }
                            if (this.f1175c.m292h() != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                            }
                            if (NdefFormatable.get(this.f1178f) != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                            }
                            if (isoDep2 == null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                c0428i.m1384a(C0369v.m1085a(isoDep2));
                                charSequence = "IsoDep";
                            } else {
                                obj = str2;
                            }
                            if (mifareClassic != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                            } else if (mifareUltralight != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                charSequence = "MifareUltralight";
                            }
                            if (nfcA2 != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                c0428i.m1384a(C0369v.m1086a(nfcA2));
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                            } else if (nfcB != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                c0428i.m1384a(C0369v.m1090a(nfcB));
                                if (TextUtils.isEmpty(charSequence)) {
                                }
                                str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                            } else if (nfcF != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                c0428i.m1384a(C0369v.m1092a(nfcF));
                                str = "NfcF";
                            } else if (nfcV == null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                c0428i.m1384a(C0369v.m1093a(nfcV));
                                str = "NfcV";
                            } else {
                                if (nfcBarcode != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                    c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                    str = "NfcBarcode";
                                }
                                charSequence2 = charSequence;
                            }
                            if (mifareClassic == null) {
                                if (a2.m68z()) {
                                    c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                } else {
                                    c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                }
                            }
                            str = "AndroidBeam";
                            id = this.f1178f.getId();
                            c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                            this.f1174b.m305a(ayVar, agVar, c0271c);
                            this.f1174b.m306a(c0428i.toString());
                            this.f1174b.m309b(str);
                            this.f1174b.m307a(z);
                            a = m1107a(objArr);
                            this.f1179g = a;
                            return a;
                        }
                    }
                    nfcBarcode = null;
                    mifareUltralight = mifareUltralight2;
                    mifareClassic = null;
                    nfcV = null;
                    nfcB = nfcB2;
                    nfcA2 = nfcA;
                    agVar = null;
                    c0271c = null;
                    nfcF = nfcF2;
                    z = false;
                } catch (IllegalStateException e26) {
                    nfcBarcode = null;
                    mifareUltralight = mifareUltralight2;
                    mifareClassic = null;
                    nfcV = null;
                    ayVar = null;
                    nfcB = nfcB2;
                    nfcA2 = nfcA;
                    agVar = null;
                    c0271c = null;
                    nfcF3 = nfcF2;
                    z = false;
                    nfcF = nfcF3;
                    this.f1181i = true;
                    c0428i = new C0428i();
                    if (VERSION.SDK_INT > 10) {
                        c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                    }
                    if (this.f1175c.m292h() != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                    }
                    if (NdefFormatable.get(this.f1178f) != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                    }
                    if (isoDep2 == null) {
                        obj = str2;
                    } else {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                        c0428i.m1384a(C0369v.m1085a(isoDep2));
                        charSequence = "IsoDep";
                    }
                    if (mifareClassic != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                    } else if (mifareUltralight != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                        charSequence = "MifareUltralight";
                    }
                    if (nfcA2 != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                        c0428i.m1384a(C0369v.m1086a(nfcA2));
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                    } else if (nfcB != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                        c0428i.m1384a(C0369v.m1090a(nfcB));
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                    } else if (nfcF != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                        c0428i.m1384a(C0369v.m1092a(nfcF));
                        str = "NfcF";
                    } else if (nfcV == null) {
                        if (nfcBarcode != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                            c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                            str = "NfcBarcode";
                        }
                        charSequence2 = charSequence;
                    } else {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                        c0428i.m1384a(C0369v.m1093a(nfcV));
                        str = "NfcV";
                    }
                    if (mifareClassic == null) {
                        if (a2.m68z()) {
                            c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                        } else {
                            c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                        }
                    }
                    str = "AndroidBeam";
                    id = this.f1178f.getId();
                    c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                    this.f1174b.m305a(ayVar, agVar, c0271c);
                    this.f1174b.m306a(c0428i.toString());
                    this.f1174b.m309b(str);
                    this.f1174b.m307a(z);
                    a = m1107a(objArr);
                    this.f1179g = a;
                    return a;
                }
            }
            nfcV = NfcV.get(this.f1178f);
            if (nfcV != null) {
                try {
                    if (C0316n.m913a(this.f1178f)) {
                        ayVar = C0316n.m910a(this.f1178f, nfcV, a3, a2);
                        if (a3) {
                            try {
                                this.f1175c.m283a(this.f1173a.getString(R.string.nfc_forum_like_tag));
                                this.f1175c.m286b(this.f1173a.getString(R.string.type_icode_tag));
                                nfcBarcode = null;
                                mifareUltralight = mifareUltralight2;
                                mifareClassic = null;
                                c0271c = null;
                                nfcB = nfcB2;
                                nfcA2 = nfcA;
                                agVar = null;
                                nfcF3 = nfcF2;
                                z = false;
                                nfcF = nfcF3;
                            } catch (IllegalStateException e27) {
                                nfcBarcode = null;
                                mifareUltralight = mifareUltralight2;
                                mifareClassic = null;
                                c0271c = null;
                                nfcB = nfcB2;
                                nfcA2 = nfcA;
                                agVar = null;
                                nfcF3 = nfcF2;
                                z = false;
                                nfcF = nfcF3;
                                this.f1181i = true;
                                c0428i = new C0428i();
                                if (VERSION.SDK_INT > 10) {
                                    c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                                }
                                if (this.f1175c.m292h() != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                                }
                                if (NdefFormatable.get(this.f1178f) != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                                }
                                if (isoDep2 == null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                                    c0428i.m1384a(C0369v.m1085a(isoDep2));
                                    charSequence = "IsoDep";
                                } else {
                                    obj = str2;
                                }
                                if (mifareClassic != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                                    if (TextUtils.isEmpty(charSequence)) {
                                    }
                                    charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                                } else if (mifareUltralight != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                                    charSequence = "MifareUltralight";
                                }
                                if (nfcA2 != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                                    c0428i.m1384a(C0369v.m1086a(nfcA2));
                                    if (TextUtils.isEmpty(charSequence)) {
                                    }
                                    str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                                } else if (nfcB != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                                    c0428i.m1384a(C0369v.m1090a(nfcB));
                                    if (TextUtils.isEmpty(charSequence)) {
                                    }
                                    str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                                } else if (nfcF != null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                                    c0428i.m1384a(C0369v.m1092a(nfcF));
                                    str = "NfcF";
                                } else if (nfcV == null) {
                                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                                    c0428i.m1384a(C0369v.m1093a(nfcV));
                                    str = "NfcV";
                                } else {
                                    if (nfcBarcode != null) {
                                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                        c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                        str = "NfcBarcode";
                                    }
                                    charSequence2 = charSequence;
                                }
                                if (mifareClassic == null) {
                                    if (a2.m68z()) {
                                        c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                                    } else {
                                        c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                                    }
                                }
                                str = "AndroidBeam";
                                id = this.f1178f.getId();
                                c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                                this.f1174b.m305a(ayVar, agVar, c0271c);
                                this.f1174b.m306a(c0428i.toString());
                                this.f1174b.m309b(str);
                                this.f1174b.m307a(z);
                                a = m1107a(objArr);
                                this.f1179g = a;
                                return a;
                            }
                        }
                    }
                    ayVar = C0315z.m869b(this.f1178f, nfcV, a3, a2);
                    if (a3) {
                        this.f1175c.m283a(this.f1173a.getString(R.string.nfc_forum_like_tag));
                        this.f1175c.m286b(this.f1173a.getString(R.string.type_nfcv_tag));
                        nfcBarcode = null;
                        mifareUltralight = mifareUltralight2;
                        mifareClassic = null;
                        c0271c = null;
                        nfcB = nfcB2;
                        nfcA2 = nfcA;
                        agVar = null;
                        nfcF3 = nfcF2;
                        z = false;
                        nfcF = nfcF3;
                    }
                    nfcBarcode = null;
                    mifareUltralight = mifareUltralight2;
                    mifareClassic = null;
                    c0271c = null;
                    nfcB = nfcB2;
                    nfcA2 = nfcA;
                    agVar = null;
                    nfcF3 = nfcF2;
                    z = false;
                    nfcF = nfcF3;
                } catch (IllegalStateException e28) {
                    nfcBarcode = null;
                    mifareUltralight = mifareUltralight2;
                    mifareClassic = null;
                    c0271c = null;
                    ayVar = null;
                    nfcB = nfcB2;
                    nfcA2 = nfcA;
                    agVar = null;
                    nfcF = nfcF2;
                    z = false;
                    this.f1181i = true;
                    c0428i = new C0428i();
                    if (VERSION.SDK_INT > 10) {
                        c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                    }
                    if (this.f1175c.m292h() != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                    }
                    if (NdefFormatable.get(this.f1178f) != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                    }
                    if (isoDep2 == null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                        c0428i.m1384a(C0369v.m1085a(isoDep2));
                        charSequence = "IsoDep";
                    } else {
                        obj = str2;
                    }
                    if (mifareClassic != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                    } else if (mifareUltralight != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                        charSequence = "MifareUltralight";
                    }
                    if (nfcA2 != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                        c0428i.m1384a(C0369v.m1086a(nfcA2));
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                    } else if (nfcB != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                        c0428i.m1384a(C0369v.m1090a(nfcB));
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                    } else if (nfcF != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                        c0428i.m1384a(C0369v.m1092a(nfcF));
                        str = "NfcF";
                    } else if (nfcV == null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                        c0428i.m1384a(C0369v.m1093a(nfcV));
                        str = "NfcV";
                    } else {
                        if (nfcBarcode != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                            c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                            str = "NfcBarcode";
                        }
                        charSequence2 = charSequence;
                    }
                    if (mifareClassic == null) {
                        if (a2.m68z()) {
                            c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                        } else {
                            c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                        }
                    }
                    str = "AndroidBeam";
                    id = this.f1178f.getId();
                    c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                    this.f1174b.m305a(ayVar, agVar, c0271c);
                    this.f1174b.m306a(c0428i.toString());
                    this.f1174b.m309b(str);
                    this.f1174b.m307a(z);
                    a = m1107a(objArr);
                    this.f1179g = a;
                    return a;
                }
            }
            if (VERSION.SDK_INT >= 17) {
                nfcBarcode = NfcBarcode.get(this.f1178f);
                if (nfcBarcode != null) {
                    try {
                        ayVar = C0260b.m581a(this.f1178f, nfcBarcode);
                        mifareUltralight = mifareUltralight2;
                        mifareClassic = null;
                        nfcB = nfcB2;
                        c0271c = null;
                        nfcA2 = nfcA;
                        agVar = null;
                        nfcF = nfcF2;
                        z = false;
                    } catch (IllegalStateException e29) {
                        mifareUltralight = mifareUltralight2;
                        mifareClassic = null;
                        nfcB = nfcB2;
                        c0271c = null;
                        ayVar = null;
                        nfcA2 = nfcA;
                        agVar = null;
                        nfcF3 = nfcF2;
                        z = false;
                        nfcF = nfcF3;
                        this.f1181i = true;
                        c0428i = new C0428i();
                        if (VERSION.SDK_INT > 10) {
                            c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                        }
                        if (this.f1175c.m292h() != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                        }
                        if (NdefFormatable.get(this.f1178f) != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                        }
                        if (isoDep2 == null) {
                            obj = str2;
                        } else {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                            c0428i.m1384a(C0369v.m1085a(isoDep2));
                            charSequence = "IsoDep";
                        }
                        if (mifareClassic != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                            if (TextUtils.isEmpty(charSequence)) {
                            }
                            charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                        } else if (mifareUltralight != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                            charSequence = "MifareUltralight";
                        }
                        if (nfcA2 != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                            c0428i.m1384a(C0369v.m1086a(nfcA2));
                            if (TextUtils.isEmpty(charSequence)) {
                            }
                            str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                        } else if (nfcB != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                            c0428i.m1384a(C0369v.m1090a(nfcB));
                            if (TextUtils.isEmpty(charSequence)) {
                            }
                            str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                        } else if (nfcF != null) {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                            c0428i.m1384a(C0369v.m1092a(nfcF));
                            str = "NfcF";
                        } else if (nfcV == null) {
                            if (nfcBarcode != null) {
                                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                                c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                                str = "NfcBarcode";
                            }
                            charSequence2 = charSequence;
                        } else {
                            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                            c0428i.m1384a(C0369v.m1093a(nfcV));
                            str = "NfcV";
                        }
                        if (mifareClassic == null) {
                            if (a2.m68z()) {
                                c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                            } else {
                                c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                            }
                        }
                        str = "AndroidBeam";
                        id = this.f1178f.getId();
                        c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                        this.f1174b.m305a(ayVar, agVar, c0271c);
                        this.f1174b.m306a(c0428i.toString());
                        this.f1174b.m309b(str);
                        this.f1174b.m307a(z);
                        a = m1107a(objArr);
                        this.f1179g = a;
                        return a;
                    }
                }
            }
            nfcBarcode = null;
            if (a3) {
                ayVar = new C0252a();
                mifareUltralight = mifareUltralight2;
                mifareClassic = null;
                nfcB = nfcB2;
                c0271c = null;
                nfcA2 = nfcA;
                agVar = null;
                nfcF = nfcF2;
                z = false;
            } else {
                Log.e("TagInfo_TagScanner", "Unknown tag technology!?!");
                ayVar = ax.m505a(this.f1178f);
                mifareUltralight = mifareUltralight2;
                mifareClassic = null;
                nfcB = nfcB2;
                c0271c = null;
                nfcA2 = nfcA;
                agVar = null;
                nfcF = nfcF2;
                z = false;
            }
            try {
                this.f1181i = false;
            } catch (IllegalStateException e30) {
                this.f1181i = true;
                c0428i = new C0428i();
                if (VERSION.SDK_INT > 10) {
                    c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
                }
                if (this.f1175c.m292h() != null) {
                    c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
                }
                if (NdefFormatable.get(this.f1178f) != null) {
                    c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
                }
                if (isoDep2 == null) {
                    c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                    c0428i.m1384a(C0369v.m1085a(isoDep2));
                    charSequence = "IsoDep";
                } else {
                    obj = str2;
                }
                if (mifareClassic != null) {
                    c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                    if (TextUtils.isEmpty(charSequence)) {
                    }
                    charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
                } else if (mifareUltralight != null) {
                    c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                    charSequence = "MifareUltralight";
                }
                if (nfcA2 != null) {
                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                    c0428i.m1384a(C0369v.m1086a(nfcA2));
                    if (TextUtils.isEmpty(charSequence)) {
                    }
                    str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
                } else if (nfcB != null) {
                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                    c0428i.m1384a(C0369v.m1090a(nfcB));
                    if (TextUtils.isEmpty(charSequence)) {
                    }
                    str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
                } else if (nfcF != null) {
                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                    c0428i.m1384a(C0369v.m1092a(nfcF));
                    str = "NfcF";
                } else if (nfcV == null) {
                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                    c0428i.m1384a(C0369v.m1093a(nfcV));
                    str = "NfcV";
                } else {
                    if (nfcBarcode != null) {
                        c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                        c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                        str = "NfcBarcode";
                    }
                    charSequence2 = charSequence;
                }
                if (mifareClassic == null) {
                    if (a2.m68z()) {
                        c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                    } else {
                        c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                    }
                }
                str = "AndroidBeam";
                id = this.f1178f.getId();
                c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
                this.f1174b.m305a(ayVar, agVar, c0271c);
                this.f1174b.m306a(c0428i.toString());
                this.f1174b.m309b(str);
                this.f1174b.m307a(z);
                a = m1107a(objArr);
                this.f1179g = a;
                return a;
            }
        } catch (IllegalStateException e31) {
            nfcBarcode = null;
            mifareUltralight = mifareUltralight2;
            mifareClassic = null;
            nfcV = null;
            nfcB = nfcB2;
            nfcA2 = null;
            agVar = null;
            c0271c = null;
            z = false;
            nfcF = null;
            ayVar = null;
            this.f1181i = true;
            c0428i = new C0428i();
            if (VERSION.SDK_INT > 10) {
                c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
            }
            if (this.f1175c.m292h() != null) {
                c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
            }
            if (NdefFormatable.get(this.f1178f) != null) {
                c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
            }
            if (isoDep2 == null) {
                obj = str2;
            } else {
                c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
                c0428i.m1384a(C0369v.m1085a(isoDep2));
                charSequence = "IsoDep";
            }
            if (mifareClassic != null) {
                c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
                if (TextUtils.isEmpty(charSequence)) {
                }
                charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
            } else if (mifareUltralight != null) {
                c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
                charSequence = "MifareUltralight";
            }
            if (nfcA2 != null) {
                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
                c0428i.m1384a(C0369v.m1086a(nfcA2));
                if (TextUtils.isEmpty(charSequence)) {
                }
                str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
            } else if (nfcB != null) {
                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
                c0428i.m1384a(C0369v.m1090a(nfcB));
                if (TextUtils.isEmpty(charSequence)) {
                }
                str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
            } else if (nfcF != null) {
                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
                c0428i.m1384a(C0369v.m1092a(nfcF));
                str = "NfcF";
            } else if (nfcV == null) {
                if (nfcBarcode != null) {
                    c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                    c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                    str = "NfcBarcode";
                }
                charSequence2 = charSequence;
            } else {
                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
                c0428i.m1384a(C0369v.m1093a(nfcV));
                str = "NfcV";
            }
            if (mifareClassic == null) {
                if (a2.m68z()) {
                    c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
                } else {
                    c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
                }
            }
            str = "AndroidBeam";
            id = this.f1178f.getId();
            c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
            this.f1174b.m305a(ayVar, agVar, c0271c);
            this.f1174b.m306a(c0428i.toString());
            this.f1174b.m309b(str);
            this.f1174b.m307a(z);
            a = m1107a(objArr);
            this.f1179g = a;
            return a;
        }
        c0428i = new C0428i();
        if (VERSION.SDK_INT > 10) {
            c0428i.m1384a("Tag description:\n" + C0358k.f1076c + this.f1178f.toString());
        }
        if (this.f1175c.m292h() != null) {
            c0428i.m1384a((CharSequence) "android.nfc.tech.Ndef");
        }
        if (NdefFormatable.get(this.f1178f) != null) {
            c0428i.m1384a((CharSequence) "android.nfc.tech.NdefFormatable");
        }
        if (isoDep2 == null) {
            c0428i.m1384a((CharSequence) "android.nfc.tech.IsoDep");
            c0428i.m1384a(C0369v.m1085a(isoDep2));
            charSequence = "IsoDep";
        } else {
            obj = str2;
        }
        if (mifareClassic != null) {
            c0428i.m1384a((CharSequence) "android.nfc.tech.MifareClassic");
            if (TextUtils.isEmpty(charSequence)) {
            }
            charSequence = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "MifareClassic";
        } else if (mifareUltralight != null) {
            c0428i.m1384a((CharSequence) "android.nfc.tech.MifareUltralight");
            charSequence = "MifareUltralight";
        }
        if (nfcA2 != null) {
            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcA");
            c0428i.m1384a(C0369v.m1086a(nfcA2));
            if (mifareClassic == null && mifareUltralight == null) {
                if (TextUtils.isEmpty(charSequence)) {
                }
                str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcA";
            }
            charSequence2 = charSequence;
        } else if (nfcB != null) {
            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcB");
            c0428i.m1384a(C0369v.m1090a(nfcB));
            if (TextUtils.isEmpty(charSequence)) {
            }
            str = charSequence + (TextUtils.isEmpty(charSequence) ? "/" : BuildConfig.VERSION_NAME) + "NfcB";
        } else if (nfcF != null) {
            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcF");
            c0428i.m1384a(C0369v.m1092a(nfcF));
            str = "NfcF";
        } else if (nfcV == null) {
            c0428i.m1384a((CharSequence) "android.nfc.tech.NfcV");
            c0428i.m1384a(C0369v.m1093a(nfcV));
            str = "NfcV";
        } else {
            if (nfcBarcode != null) {
                c0428i.m1384a((CharSequence) "android.nfc.tech.NfcBarcode");
                c0428i.m1384a(C0369v.m1091a(nfcBarcode));
                str = "NfcBarcode";
            }
            charSequence2 = charSequence;
        }
        if (mifareClassic == null) {
            if (a2.m68z()) {
                c0428i.m1384a((CharSequence) "<hexoutput>MIFARE Classic support present in Android</hexoutput>");
            } else {
                c0428i.m1384a((CharSequence) "<hexoutput>No MIFARE Classic support present in Android</hexoutput>");
            }
        }
        if (TextUtils.isEmpty(str) && this.f1175c.m292h() != null) {
            str = "AndroidBeam";
            id = this.f1178f.getId();
            if (id != null && id.length > 1) {
                c0428i.m1384a("NFC-ID: " + C0429j.m1409e(id));
            }
        }
        this.f1174b.m305a(ayVar, agVar, c0271c);
        this.f1174b.m306a(c0428i.toString());
        this.f1174b.m309b(str);
        this.f1174b.m307a(z);
        a = m1107a(objArr);
        this.f1179g = a;
        return a;
    }

    protected final void onCancelled(Object obj) {
        this.f1179g = obj;
        this.f1180h = true;
        this.f1181i = true;
        m1106a();
    }

    protected final void onPostExecute(Object obj) {
        this.f1180h = true;
        m1106a();
    }

    protected void onPreExecute() {
        this.f1177e.m139a().m188a(true);
    }
}
