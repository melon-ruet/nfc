package com.nxp.taginfolite.p005b;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.actionbarsherlock.view.Menu;
import java.util.Arrays;

/* renamed from: com.nxp.taginfolite.b.i */
public class C0188i {
    public static C0182c m162a(byte[] bArr) {
        return C0188i.m163a(bArr, 16);
    }

    public static C0182c m163a(byte[] bArr, int i) {
        C0182c c0182c = new C0182c();
        int length = bArr.length;
        int i2 = 2;
        if (length >= 268435456) {
            i2 = 8;
        } else if (length >= ViewCompat.MEASURED_STATE_TOO_SMALL) {
            i2 = 7;
        } else if (length >= AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) {
            i2 = 6;
        } else if (length >= Menu.CATEGORY_CONTAINER) {
            i2 = 5;
        } else if (length >= AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD) {
            i2 = 4;
        } else if (length >= AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) {
            i2 = 3;
        }
        int i3 = 0;
        while (i3 < length) {
            if (i3 + i < length) {
                c0182c.m147a(new C0184h(i3, i2, Arrays.copyOfRange(bArr, i3, i3 + i)));
            } else {
                c0182c.m147a(new C0184h(i3, i2, Arrays.copyOfRange(bArr, i3, length)));
            }
            i3 += i;
        }
        return c0182c;
    }
}
