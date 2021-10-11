package com.nxp.taginfolite.ndef;

import android.nfc.NdefRecord;
import com.nxp.taginfolite.p003g.C0429j;
import java.util.Locale;

/* renamed from: com.nxp.taginfolite.ndef.f */
public enum C0453f {
    U(C0452e.WellKnown, "URI"),
    T(C0452e.WellKnown, "Text"),
    Sp(C0452e.WellKnown, "Smart Poster"),
    Sp_act(C0452e.WellKnown, "Recommended Action"),
    Sp_s(C0452e.WellKnown, "Size"),
    Sp_t(C0452e.WellKnown, "Type"),
    Gc(C0452e.WellKnown, "Generic Control"),
    Gc_t(C0452e.WellKnown, "Target"),
    Gc_a(C0452e.WellKnown, "Action"),
    Gc_d(C0452e.WellKnown, "Data"),
    Hr(C0452e.WellKnown, "Handover Request"),
    Hs(C0452e.WellKnown, "Handover Select"),
    Hc(C0452e.WellKnown, "Handover Carrier"),
    Hr_cr(C0452e.WellKnown, "Collision Resolution"),
    Hr_ac(C0452e.WellKnown, "Alternative Carrier"),
    Hr_err(C0452e.WellKnown, "Error"),
    Sig(C0452e.WellKnown, "Signature"),
    PHD(C0452e.WellKnown, "Personal Health Device"),
    nokia_com_bt(C0452e.External, "nokia.com:bt", "Nokia Bluetooth"),
    nokia_com_ac(C0452e.External, "nokia.com:ac", "Nokia Alarm Clock"),
    nokia_com_pf(C0452e.External, "nokia.com:pf", "Nokia Profile"),
    nokia_com_rf(C0452e.External, "nokia.com:rf", "Nokia Radio Frequency"),
    android_com_pkg(C0452e.External, "android.com:pkg", "Android Application"),
    db_de_tandt(C0452e.External, "db.de:tandt", "DB Touch and Travel"),
    usingnfc_geo(C0452e.External, "usingnfc.com:geo", "NFCGeo location"),
    rim_smarttrigger(C0452e.External, "rim.com:ac", "BlackBerry Smart Trigger"),
    lg_tag_plus(C0452e.External, "Lge", "LG Tag+"),
    text_plain(C0452e.Media, "text/plain", "Plain Text"),
    text_plain_FORMAT_FIXED(C0452e.Media, "text/plain; FORMAT=FIXED", "Plain Text (fixed format)"),
    text_vCard(C0452e.Media, "text/vcard", "vCard"),
    text_x_vCard(C0452e.Media, "text/x-vcard", "vCard"),
    text_vCalendar(C0452e.Media, "text/x-vcalendar", "vCalendar"),
    text_SBeam_gallery(C0452e.Media, "text/DirectShareGallery", "Samsung S Beam pictures"),
    text_SBeam_videos(C0452e.Media, "text/DirectShareVideos", "Samsung S Beam videos"),
    text_SBeam_music(C0452e.Media, "text/DirectShareVideos", "Samsung S Beam music"),
    text_SBeam_error(C0452e.Media, "text/", "Samsung S Beam error"),
    image_jpeg(C0452e.Media, "image/jpeg", "JPEG image"),
    image_png(C0452e.Media, "image/png", "PNG image"),
    application_vnd_wfa_wsc(C0452e.Media, "application/vnd.wfa.wsc", "Wi-Fi Simple Configuration"),
    application_vnd_wfa_wsc_ibss(C0452e.Media, "application/vnd.wfa.wsc;mode=ibss", "Wi-Fi Simple Configuration"),
    WifiSimpleConfig(C0452e.Media, "application/wifi-simpleconfig", "Wi-Fi Simple Configuration (draft)"),
    BluetoothOob(C0452e.Media, "application/vnd.bluetooth.ep.oob", "Bluetooth Secure Simple Pairing"),
    SamsungApps(C0452e.Media, "application/com.sec.android.app.samsungapps.detail", "Samsung Apps details"),
    app_RMV(C0452e.Media, "app/x-rmv", "Rhein-Main Verkehrsverbund (RMV)"),
    cm_profile(C0452e.Media, "cm/profile", "CyanogenMod Profile"),
    lg_tag_on(C0452e.Media, "application/com.lge.tv.nfcapps", "LG TV Tag On"),
    sony_play_memories(C0452e.Media, "application/x-sony-pmm", "Sony PlayMemories Mobile"),
    Win8_LaunchApp(C0452e.AbsoluteUri, "windows.com/LaunchApp", "Windows 8 application launch"),
    NONE(null, "Unknown");
    
    private final String f1435X;
    private final C0452e f1436Y;
    private final String f1437Z;

    private C0453f(C0452e c0452e, String str) {
        this.f1437Z = str;
        this.f1435X = name();
        this.f1436Y = c0452e;
    }

    private C0453f(C0452e c0452e, String str, String str2) {
        this.f1437Z = str2;
        this.f1435X = str;
        this.f1436Y = c0452e;
    }

    static C0453f m1461a(NdefRecord ndefRecord) {
        String str = new String(ndefRecord.getType(), C0429j.f1360a);
        C0452e c0452e = (C0452e) C0448a.f1373a.get(Short.valueOf(ndefRecord.getTnf()));
        if (c0452e == null) {
            return null;
        }
        String str2 = str;
        for (C0453f c0453f : C0453f.values()) {
            if (c0453f.m1463b() == c0452e) {
                if (c0452e == C0452e.External || c0452e == C0452e.Media) {
                    str2 = str2.toLowerCase(Locale.US);
                    if (c0453f.m1462a().toLowerCase(Locale.US).equals(str2)) {
                        return c0453f;
                    }
                } else if (c0453f.m1462a().equals(str2)) {
                    return c0453f;
                }
            }
        }
        return null;
    }

    public String m1462a() {
        return this.f1435X;
    }

    public C0452e m1463b() {
        return this.f1436Y;
    }

    public String toString() {
        return this.f1437Z;
    }
}
