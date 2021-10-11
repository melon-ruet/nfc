package com.nxp.taginfolite.p009e;

import android.annotation.SuppressLint;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcBarcode;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.Build.VERSION;
import android.support.v4.BuildConfig;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0360m;
import com.nxp.taginfolite.p004f.C0369v;
import com.nxp.taginfolite.p006c.C0197a;
import com.nxp.taginfolite.p006c.C0198b;
import com.nxp.taginfolite.p006c.C0199c;
import com.nxp.taginfolite.p006c.C0200d;
import java.util.Arrays;

/* renamed from: com.nxp.taginfolite.e.ax */
public class ax implements ay {
    private Tag f513a;
    private NfcA f514b;
    private NfcB f515c;
    private NfcF f516d;
    private NfcV f517e;
    private NfcBarcode f518f;
    private IsoDep f519g;

    public ax() {
        this.f513a = null;
        this.f514b = null;
        this.f515c = null;
        this.f516d = null;
        this.f517e = null;
        this.f518f = null;
        this.f519g = null;
    }

    @SuppressLint({"NewApi"})
    public static ay m505a(Tag tag) {
        ay axVar = new ax();
        axVar.f513a = tag;
        axVar.f514b = NfcA.get(tag);
        axVar.f515c = NfcB.get(tag);
        axVar.f519g = IsoDep.get(tag);
        axVar.f516d = NfcF.get(tag);
        axVar.f517e = NfcV.get(tag);
        if (VERSION.SDK_INT >= 17) {
            axVar.f518f = NfcBarcode.get(tag);
        }
        return axVar;
    }

    private void m506a(C0200d c0200d) {
        C0369v.m1097a(this.f514b, c0200d);
    }

    private void m507b(C0200d c0200d) {
        C0369v.m1101a(this.f515c, c0200d);
    }

    private void m508c(C0200d c0200d) {
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        stringBuilder.append(C0369v.m1094a(m518c(), C0360m.FELICA));
        stringBuilder.append("\n");
        byte[] manufacturer = this.f516d.getManufacturer();
        stringBuilder.append("PMm: ");
        stringBuilder.append(C0429j.m1409e(manufacturer));
        stringBuilder.append("\n");
        manufacturer = this.f516d.getSystemCode();
        if (manufacturer == null || manufacturer.length <= 0 || Arrays.equals(manufacturer, new byte[]{(byte) 0, (byte) 0})) {
            stringBuilder.append("Primary System Code: [none]");
        } else {
            stringBuilder.append("Primary System Code: ");
            stringBuilder.append(C0429j.m1409e(manufacturer));
        }
        c0200d.m242c(stringBuilder.toString());
    }

    private void m509d(C0200d c0200d) {
        C0428i c0428i = new C0428i();
        c0428i.m1384a(C0369v.m1094a(this.f513a.getId(), C0360m.ISO15693));
        c0428i.m1384a(String.format("DSFID: 0x%02X", new Object[]{Byte.valueOf(this.f517e.getDsfId())}));
        c0200d.m242c(c0428i.toString());
    }

    private void m510e(C0200d c0200d) {
        if (this.f514b != null) {
            C0369v.m1095a(this.f514b, this.f519g, null, c0200d);
        } else {
            C0369v.m1100a(this.f515c, this.f519g, c0200d);
        }
    }

    private void m511f(C0200d c0200d) {
        C0369v.m1102a(this.f518f, c0200d);
    }

    public void m512a(C0197a c0197a, boolean z) {
    }

    public void m513a(C0198b c0198b, boolean z) {
    }

    public void m514a(C0199c c0199c, boolean z) {
    }

    public void m515a(C0200d c0200d, boolean z) {
        if (this.f519g != null) {
            m510e(c0200d);
        } else if (this.f514b != null) {
            m506a(c0200d);
        } else if (this.f515c != null) {
            m507b(c0200d);
        } else if (this.f516d != null) {
            m508c(c0200d);
        } else if (this.f517e != null) {
            m509d(c0200d);
        } else if (this.f518f != null) {
            m511f(c0200d);
        } else if (!Arrays.asList(this.f513a.getTechList()).contains("android.nfc.tech.IsoPcdA")) {
            c0200d.m240b((CharSequence) "android.nfc.tech.IsoPcdA");
        }
    }

    public boolean m516a() {
        return false;
    }

    public boolean m517b() {
        return false;
    }

    public byte[] m518c() {
        return this.f513a.getId();
    }

    public String m519d() {
        return null;
    }
}
