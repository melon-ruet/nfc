package com.nxp.taginfolite.fragments.view;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;

/* renamed from: com.nxp.taginfolite.fragments.view.b */
class C0413b implements OnPageChangeListener {
    final /* synthetic */ SlidingTabLayout f1325a;
    private int f1326b;

    private C0413b(SlidingTabLayout slidingTabLayout) {
        this.f1325a = slidingTabLayout;
    }

    public void onPageScrollStateChanged(int i) {
        this.f1326b = i;
        if (this.f1325a.f1323e != null) {
            this.f1325a.f1323e.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        int childCount = this.f1325a.f1324f.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount) {
            this.f1325a.f1324f.m1344a(i, f);
            View childAt = this.f1325a.f1324f.getChildAt(i);
            this.f1325a.m1335a(i, childAt != null ? (int) (((float) childAt.getWidth()) * f) : 0);
            if (this.f1325a.f1323e != null) {
                this.f1325a.f1323e.onPageScrolled(i, f, i2);
            }
        }
    }

    public void onPageSelected(int i) {
        if (this.f1326b == 0) {
            this.f1325a.f1324f.m1344a(i, 0.0f);
            this.f1325a.m1335a(i, 0);
        }
        if (this.f1325a.f1323e != null) {
            this.f1325a.f1323e.onPageSelected(i);
        }
    }
}
