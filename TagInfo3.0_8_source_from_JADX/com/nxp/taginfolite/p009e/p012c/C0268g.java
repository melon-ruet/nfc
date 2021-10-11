package com.nxp.taginfolite.p009e.p012c;

import android.support.v4.BuildConfig;
import android.text.TextUtils;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.p003g.C0428i;
import com.sony.nfc.NfcTag;
import com.sony.nfc.thermometer.C0508a;
import com.sony.nfc.thermometer.ThermometerData;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.c.g */
public class C0268g implements C0264d {
    private static Map f619c;
    final ThermometerData[] f620a;
    final String f621b;

    static {
        f619c = new HashMap();
    }

    public C0268g(NfcTag nfcTag) {
        if (nfcTag instanceof C0508a) {
            this.f620a = ((C0508a) nfcTag).m1766a();
        } else {
            this.f620a = null;
        }
        this.f621b = (String) f619c.get(nfcTag.getClass().getSimpleName());
    }

    public String m611a() {
        C0428i c0428i = new C0428i();
        if (TextUtils.isEmpty(this.f621b)) {
            c0428i.m1384a((CharSequence) "Thermometer\n");
        } else {
            c0428i.m1384a("Thermometer " + this.f621b);
        }
        if (this.f620a != null) {
            for (ThermometerData thermometerData : this.f620a) {
                c0428i.m1384a(C0261a.m590a(thermometerData.m1761a()));
                c0428i.m1384a(String.format(Locale.US, "\t\u2022 Temperature: %.1f\u200a" + ("\u00b0" + (thermometerData.m1763c() == 0 ? "C" : "F")) + ((thermometerData.m1765e() & 1) != 0 ? " (predicted)" : BuildConfig.VERSION_NAME), new Object[]{Double.valueOf(((double) thermometerData.m1762b()) / 1000.0d)}));
                switch (thermometerData.m1764d()) {
                    case C0519c.Switch_thumb /*0*/:
                        c0428i.m1384a((CharSequence) "\t\u2022 Site: generic body temperature");
                        break;
                    case C0519c.Switch_track /*1*/:
                        c0428i.m1384a((CharSequence) "\t\u2022 Site: eardrum");
                        break;
                    case C0519c.Switch_textOn /*2*/:
                        c0428i.m1384a((CharSequence) "\t\u2022 Site: rectum");
                        break;
                    case C0519c.Switch_textOff /*3*/:
                        c0428i.m1384a((CharSequence) "\t\u2022 Site: mouth");
                        break;
                    case C0519c.Switch_thumbTextPadding /*4*/:
                        c0428i.m1384a((CharSequence) "\t\u2022 Site: earlobe");
                        break;
                    case C0519c.Switch_switchTextAppearance /*5*/:
                        c0428i.m1384a((CharSequence) "\t\u2022 Site: finger");
                        break;
                    case C0519c.Switch_switchMinWidth /*6*/:
                        c0428i.m1384a((CharSequence) "\t\u2022 Site: toe");
                        break;
                    case C0519c.Switch_switchPadding /*7*/:
                        c0428i.m1384a((CharSequence) "\t\u2022 Site: armpit");
                        break;
                    case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                        c0428i.m1384a((CharSequence) "\t\u2022 Site: gastrointestinal tract");
                        break;
                    default:
                        c0428i.m1384a((CharSequence) "\t\u2022 Site: [unknown]");
                        break;
                }
            }
        }
        return c0428i.toString();
    }
}
