package com.nxp.taginfolite.fragments.view;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.nxp.taginfolite.fragments.view.c */
class C0414c implements OnClickListener {
    final /* synthetic */ SlidingTabLayout f1327a;

    private C0414c(SlidingTabLayout slidingTabLayout) {
        this.f1327a = slidingTabLayout;
    }

    public void onClick(View view) {
        for (int i = 0; i < this.f1327a.f1324f.getChildCount(); i++) {
            if (view == this.f1327a.f1324f.getChildAt(i)) {
                this.f1327a.f1322d.setCurrentItem(i);
                return;
            }
        }
    }
}
