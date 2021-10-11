package com.nxp.taginfolite.p009e.p012c;

import android.support.v4.BuildConfig;
import android.text.TextUtils;
import com.nxp.taginfolite.p003g.C0428i;
import com.sony.nfc.NfcTag;
import com.sony.nfc.bpmonitor.BloodPressureData;
import com.sony.nfc.bpmonitor.BpMonitorUa772NfcData;
import com.sony.nfc.bpmonitor.C0468b;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.nxp.taginfolite.e.c.c */
public class C0265c implements C0264d {
    private static Map f613a;
    private BloodPressureData[] f614b;
    private final String f615c;

    static {
        f613a = new HashMap();
        f613a.put("BpMonitorUa772Nfc", "UA-772NFC");
    }

    public C0265c(NfcTag nfcTag) {
        if (nfcTag instanceof C0468b) {
            this.f614b = ((C0468b) nfcTag).m1506a();
        } else {
            this.f614b = null;
        }
        this.f615c = nfcTag.getClass().getSimpleName();
    }

    public String m605a() {
        C0428i c0428i = new C0428i();
        String str = (String) f613a.get(this.f615c);
        if (TextUtils.isEmpty(str)) {
            c0428i.m1384a((CharSequence) "Blood pressure monitor");
        } else {
            c0428i.m1384a("Blood pressure monitor " + str);
        }
        if (this.f614b != null) {
            for (BloodPressureData bloodPressureData : this.f614b) {
                c0428i.m1384a(C0261a.m590a(bloodPressureData.m1501a()));
                c0428i.m1384a(String.format("\t\u2022 Maximum (systolic) pressure: %d\u200ammHg", new Object[]{Integer.valueOf(bloodPressureData.m1502b())}));
                c0428i.m1384a(String.format("\t\u2022 Minimum (diastolic) pressure: %d\u200ammHg", new Object[]{Integer.valueOf(bloodPressureData.m1503c())}));
                c0428i.m1384a(String.format("\t\u2022 Mean Arterial Pressure: %d\u200ammHg", new Object[]{Integer.valueOf(bloodPressureData.m1504d())}));
                c0428i.m1384a(String.format("\t\u2022 Pulse rate: %d\u200abpm", new Object[]{Integer.valueOf(bloodPressureData.m1505e())}));
                if (bloodPressureData instanceof BpMonitorUa772NfcData) {
                    int i;
                    int f = ((BpMonitorUa772NfcData) bloodPressureData).m1517f();
                    Object obj = BuildConfig.VERSION_NAME;
                    if ((f & 1) != 0) {
                        obj = "irregular";
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if ((f & 4) != 0) {
                        if (i != 0) {
                            str = obj + "/";
                        }
                        obj = str + "fast";
                        i = 1;
                    }
                    if ((f & 2) != 0) {
                        if (i != 0) {
                            str = obj + "/";
                        }
                        obj = str + "slow";
                    }
                    if (!TextUtils.isEmpty(obj)) {
                        c0428i.m1384a("Heartbeat: " + obj);
                    }
                }
            }
        }
        return c0428i.toString();
    }
}
