package com.nxp.taginfolite.p009e.p014e;

import android.nfc.tech.MifareUltralight;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.actionbarsherlock.view.Menu;
import java.util.Arrays;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.e.m */
public class C0305m {
    protected MifareUltralight f805a;
    protected byte[][] f806b;
    protected final int f807c;

    public C0305m(MifareUltralight mifareUltralight) {
        this.f805a = mifareUltralight;
        switch (mifareUltralight.getType()) {
            case C0519c.Switch_track /*1*/:
                this.f807c = 64;
                break;
            case C0519c.Switch_textOn /*2*/:
                this.f807c = 192;
                break;
            default:
                this.f807c = AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
                break;
        }
        m827a();
    }

    public C0305m(MifareUltralight mifareUltralight, int i) {
        this.f805a = mifareUltralight;
        this.f807c = i;
        this.f806b = new byte[((i % 16 > 0 ? 1 : 0) + (i / 16))][];
    }

    public byte m825a(int i) {
        return m826a(i / 4, i % 4);
    }

    public byte m826a(int i, int i2) {
        int i3 = i / 4;
        if (this.f806b[i3] == null) {
            this.f806b[i3] = this.f805a.readPages(i);
        }
        return this.f806b[i3][((i % 4) * 4) + i2];
    }

    public void m827a() {
        switch (this.f805a.getType()) {
            case C0519c.Switch_track /*1*/:
                this.f806b = new byte[4][];
            case C0519c.Switch_textOn /*2*/:
                this.f806b = new byte[12][];
            default:
                this.f806b = new byte[12][];
        }
    }

    public int m828b(int i) {
        return (m829b(i, 0) << 16) | (m829b(i, 2) & Menu.USER_MASK);
    }

    public short m829b(int i, int i2) {
        return (short) ((m826a(i, i2) << 8) | (m826a(i, i2 + 1) & MotionEventCompat.ACTION_MASK));
    }

    public byte[] m830c(int i) {
        int i2 = i / 4;
        if (this.f806b[i2] == null) {
            this.f806b[i2] = this.f805a.readPages(i2);
        }
        int i3 = (i % 4) * 4;
        return Arrays.copyOfRange(this.f806b[i2], i3, i3 + 4);
    }
}
