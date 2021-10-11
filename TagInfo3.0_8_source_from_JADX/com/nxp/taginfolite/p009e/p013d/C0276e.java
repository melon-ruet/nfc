package com.nxp.taginfolite.p009e.p013d;

import android.nfc.tech.IsoDep;
import android.support.v4.BuildConfig;
import android.support.v4.view.MotionEventCompat;
import com.actionbarsherlock.C0086R;
import com.nxp.taginfolite.p004f.C0362o;
import com.nxp.taginfolite.p004f.C0368u;
import com.nxp.taginfolite.p004f.p017c.C0345a;
import com.nxp.taginfolite.p009e.C0270w;
import java.util.Arrays;

/* renamed from: com.nxp.taginfolite.e.d.e */
public class C0276e {
    public static C0276e m729a(C0270w c0270w) {
        byte[] bArr = new byte[]{(byte) -72, (byte) 0, (byte) 1, (byte) 0, (byte) 0};
        Object c = c0270w.m657c();
        Object obj = new byte[(c.length + 2)];
        System.arraycopy(c, 0, obj, 0, c.length);
        obj[obj.length - 2] = -112;
        obj[obj.length - 1] = null;
        Object obj2 = new byte[(c.length + 4)];
        System.arraycopy(c, 0, obj2, 0, c.length);
        obj2[obj2.length - 4] = null;
        obj2[obj2.length - 3] = null;
        obj2[obj2.length - 2] = -112;
        obj2[obj2.length - 1] = null;
        IsoDep h = c0270w.m661h();
        C0345a c0345a = new C0345a(h);
        bArr = c0345a.m996a(bArr);
        if (!c0345a.m1007c() || (!Arrays.equals(bArr, obj) && !Arrays.equals(bArr, obj2))) {
            return null;
        }
        int i;
        C0276e c0276e = new C0276e();
        c0270w.m651a(true);
        c0270w.m646a(C0275d.EVALOS);
        c0270w.m640a(18320);
        byte[] historicalBytes = h.getHistoricalBytes();
        int length = historicalBytes == null ? 0 : historicalBytes.length;
        if (historicalBytes != null) {
            i = 0;
            while (i < length - 1 && (historicalBytes[i] != 77 || historicalBytes[i + 1] != 88)) {
                i++;
            }
        } else {
            i = 0;
        }
        if (historicalBytes != null) {
            if (i + 2 < length) {
                length = historicalBytes[i + 2] & 15;
                c0270w.m654b(String.format("%d.%d", new Object[]{Integer.valueOf((historicalBytes[i + 2] & 240) >>> 4), Integer.valueOf(length)}));
                c0270w.m647a(C0279h.SmartMX);
            } else {
                i = 0;
                while (i < historicalBytes.length - 1 && (historicalBytes[i] != 82 || historicalBytes[i + 1] != 70)) {
                    i++;
                }
                if (i + 2 < length) {
                    length = historicalBytes[i + 2] & 15;
                    c0270w.m654b(String.format("%d.%d", new Object[]{Integer.valueOf((historicalBytes[i + 2] & 240) >>> 4), Integer.valueOf(length)}));
                    c0270w.m647a(C0279h.MifareProX);
                }
            }
        }
        byte[] a = c0345a.m996a(new byte[]{(byte) -72, (byte) 0, (byte) 2, (byte) 0, (byte) 0});
        if (c0345a.m1007c()) {
            if (c0270w.m663j() == C0279h.SmartMX) {
                if ((a[0] & 15) == 1) {
                    c0270w.m649a((C0368u) C0362o.f1103j.get(a[2] & MotionEventCompat.ACTION_MASK));
                }
                c0270w.m650a(C0276e.m730a(a));
            } else if (c0270w.m663j() == C0279h.MifareProX) {
                c0270w.m649a((C0368u) C0362o.f1103j.get(a[0] & 31));
            }
        }
        return c0276e;
    }

    public static String m730a(byte[] bArr) {
        String str;
        int i;
        String str2 = BuildConfig.VERSION_NAME;
        if ((bArr[0] & 240) != 0) {
            str2 = str2 + "Supported interfaces:";
        }
        switch (bArr[0] & 240) {
            case C0086R.styleable.SherlockTheme_searchViewCloseIcon /*32*/:
                str2 = str2 + C0362o.f1095b + C0362o.f1096c;
                break;
            case C0086R.styleable.SherlockTheme_activityChooserViewStyle /*64*/:
                str2 = str2 + C0362o.f1095b + C0362o.f1096c + C0362o.f1098e;
                break;
            case 96:
                str2 = str2 + C0362o.f1096c + C0362o.f1100g;
                break;
        }
        str2 = (bArr[1] & 15) != 0 ? str2 + "\nCoprocessors: " : str2 + "\nNo crypto-coprocessors";
        if ((bArr[1] & 1) != 0) {
            str = str2 + "3DES";
            i = 1;
        } else {
            str = str2;
            i = 0;
        }
        if ((bArr[1] & 2) != 0) {
            str = str + (i != 0 ? ", " : BuildConfig.VERSION_NAME) + "AES";
            i = 1;
        }
        if ((bArr[1] & 4) == 0) {
            return str;
        }
        return str + (i != 0 ? ", " : BuildConfig.VERSION_NAME) + "FameXE (Public key)";
    }
}
