package com.nxp.taginfolite.p005b;

import android.content.Context;
import android.support.v4.BuildConfig;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p009e.ag;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.nxp.taginfolite.b.l */
public class C0191l extends C0183d {
    public C0191l(int i, String str, byte[] bArr) {
        this(i, str, bArr, null);
    }

    public C0191l(int i, String str, byte[] bArr, String str2) {
        super(i, 2, str, 16, 8, bArr, str2);
    }

    public C0191l(XmlPullParser xmlPullParser) {
        super(xmlPullParser, -1, 2, null, 16, 8, null);
    }

    public CharSequence m167a(Context context, boolean z) {
        int i;
        C0428i c0428i = new C0428i();
        if (this.a < AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS && this.a % 4 == 0) {
            if (this.a / 4 > 0) {
                c0428i.m1387b("\n");
            }
            c0428i.m1387b(String.format("Sector %d (0x%02X)\n", new Object[]{Integer.valueOf(i), Integer.valueOf(i)}));
        } else if (this.a >= AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS && this.a % 16 == 0) {
            i = ((this.a - 128) / 16) + 32;
            c0428i.m1387b(String.format("\nSector %d (0x%02X)\n", new Object[]{Integer.valueOf(i), Integer.valueOf(i)}));
        }
        c0428i.m1387b(String.format("[%02X] ", new Object[]{Integer.valueOf(this.a)}));
        if (z) {
            c0428i.m1387b(this.e);
            if (this.f == null || this.f.length == 0) {
                c0428i.m1387b("  -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
            } else if (!TextUtils.isEmpty(this.g)) {
                c0428i.m1387b("  ");
                c0428i.m1387b(C0429j.m1393a(this.f, BuildConfig.VERSION_NAME, " "));
                c0428i.m1387b(" ");
                c0428i.m1387b(this.g);
            } else if (ag.m458a(this.f)) {
                i = ag.m460b(this.f);
                c0428i.m1387b("* ");
                c0428i.m1387b(C0429j.m1393a(this.f, BuildConfig.VERSION_NAME, " "));
                c0428i.m1387b(String.format("  val:%+d, adr:% 3d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.f[12] & MotionEventCompat.ACTION_MASK)}));
            } else {
                c0428i.m1387b("  ");
                c0428i.m1387b(C0429j.m1412h(this.f));
            }
        } else if (this.f == null || this.f.length == 0) {
            c0428i.m1387b(" -- -- -- -- -- -- -- --\n ");
            c0428i.m1387b(this.e);
            c0428i.m1387b("  -- -- -- -- -- -- -- --");
        } else if (!TextUtils.isEmpty(this.g)) {
            c0428i.m1387b(" ");
            c0428i.m1387b(C0429j.m1394a(this.f, BuildConfig.VERSION_NAME, " ", 0, 8));
            c0428i.m1387b(" ");
            c0428i.m1387b(this.g);
            c0428i.m1387b("\n ");
            c0428i.m1387b(this.e);
            c0428i.m1387b("  ");
            c0428i.m1387b(C0429j.m1394a(this.f, BuildConfig.VERSION_NAME, " ", 8, 8));
        } else if (ag.m458a(this.f)) {
            i = ag.m460b(this.f);
            c0428i.m1387b(" ");
            c0428i.m1387b(C0429j.m1394a(this.f, BuildConfig.VERSION_NAME, " ", 0, 8));
            c0428i.m1387b(String.format("  val: %+d", new Object[]{Integer.valueOf(i)}));
            c0428i.m1387b("\n ");
            c0428i.m1387b(this.e);
            c0428i.m1387b("* ");
            c0428i.m1387b(C0429j.m1394a(this.f, BuildConfig.VERSION_NAME, " ", 8, 8));
            c0428i.m1387b(String.format("  adr: % 3d", new Object[]{Integer.valueOf(this.f[12] & MotionEventCompat.ACTION_MASK)}));
        } else {
            c0428i.m1387b(" ");
            c0428i.m1387b(C0429j.m1407d(this.f, 0, 8));
            c0428i.m1387b("\n ");
            c0428i.m1387b(this.e);
            c0428i.m1387b("  ");
            c0428i.m1387b(C0429j.m1407d(this.f, 8, 8));
        }
        c0428i.m1385a(new TextAppearanceSpan(context, R.style.item_mono));
        return c0428i.m1386b();
    }

    protected String m168b() {
        return "MifareData";
    }
}
