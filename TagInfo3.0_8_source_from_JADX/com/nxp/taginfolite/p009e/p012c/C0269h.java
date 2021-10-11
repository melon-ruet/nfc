package com.nxp.taginfolite.p009e.p012c;

import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import com.actionbarsherlock.internal.widget.IcsAdapterView;
import com.nxp.taginfolite.p003g.C0428i;
import com.sony.nfc.NfcTag;
import com.sony.nfc.wscale.C0510f;
import com.sony.nfc.wscale.WScaleUc411NfcData;
import com.sony.nfc.wscale.WeighingScaleData;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.c.h */
public class C0269h implements C0264d {
    private static final Map f622c;
    WeighingScaleData[] f623a;
    String f624b;

    static {
        f622c = new HashMap();
        f622c.put("WScaleUc324Nfc", "UC-324NFC");
        f622c.put("WScaleUc411Nfc", "UC-411NFC");
    }

    public C0269h(NfcTag nfcTag) {
        if (nfcTag instanceof C0510f) {
            this.f623a = ((C0510f) nfcTag).m1769e();
        } else {
            this.f623a = null;
        }
        this.f624b = (String) f622c.get(nfcTag.getClass().getSimpleName());
    }

    public String m612a() {
        C0428i c0428i = new C0428i();
        if (TextUtils.isEmpty(this.f624b)) {
            c0428i.m1384a((CharSequence) "Weighing scale");
        } else {
            c0428i.m1384a("Weighing scale " + this.f624b);
        }
        if (this.f623a != null) {
            for (WeighingScaleData weighingScaleData : this.f623a) {
                c0428i.m1384a(C0261a.m590a(weighingScaleData.m1791e()));
                if (weighingScaleData instanceof WScaleUc411NfcData) {
                    String str;
                    int d = ((WScaleUc411NfcData) weighingScaleData).m1800d();
                    switch (d) {
                        case IcsAdapterView.ITEM_VIEW_TYPE_IGNORE /*-1*/:
                            str = EnvironmentCompat.MEDIA_UNKNOWN;
                            break;
                        case C0519c.Switch_thumb /*0*/:
                            str = "unspecified";
                            break;
                        default:
                            str = Integer.toString(d);
                            break;
                    }
                    c0428i.m1384a(String.format("\t\u2022 User ID: " + str, new Object[0]));
                }
                c0428i.m1384a(String.format(Locale.US, "\t\u2022 Weight: %.03f\u200a" + (weighingScaleData.m1796j() == 0 ? "kg" : "pound"), new Object[]{Double.valueOf(((double) weighingScaleData.m1792f()) / 1000.0d)}));
                if (weighingScaleData.m1793g() >= 0) {
                    c0428i.m1384a(String.format(Locale.US, "\t\u2022 BMI: %.1f", new Object[]{Double.valueOf(((double) weighingScaleData.m1793g()) / 10.0d)}));
                }
                if (weighingScaleData.m1794h() >= 0) {
                    c0428i.m1384a(String.format(Locale.US, "\t\u2022 Body fat percentage: %.1f%%", new Object[]{Double.valueOf(((double) weighingScaleData.m1794h()) / 10.0d)}));
                }
                if (weighingScaleData.m1795i() >= 0) {
                    c0428i.m1384a(String.format(Locale.US, "\t\u2022 Basal metabolism: %.1f\u200akcal", new Object[]{Double.valueOf(((double) weighingScaleData.m1795i()) / 1000.0d)}));
                }
                if (weighingScaleData instanceof WScaleUc411NfcData) {
                    WScaleUc411NfcData wScaleUc411NfcData = (WScaleUc411NfcData) weighingScaleData;
                    c0428i.m1384a(String.format(Locale.US, "\t\u2022 Muscle weight: %.1f\u200akg", new Object[]{Double.valueOf(((double) wScaleUc411NfcData.m1798b()) / 1000.0d)}));
                    c0428i.m1384a(String.format(Locale.US, "\t\u2022 Water weight: %.1f\u200akg", new Object[]{Double.valueOf(((double) wScaleUc411NfcData.m1799c()) / 1000.0d)}));
                    c0428i.m1384a(String.format(Locale.US, "\t\u2022 Impedance: %.1f\u200aOhm", new Object[]{Double.valueOf(((double) wScaleUc411NfcData.m1797a()) / 10.0d)}));
                }
            }
        }
        return c0428i.toString();
    }
}
