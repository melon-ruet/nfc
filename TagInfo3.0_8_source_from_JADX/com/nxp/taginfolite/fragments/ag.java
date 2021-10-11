package com.nxp.taginfolite.fragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.actionbarsherlock.app.SherlockFragment;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.fragments.p020a.C0380g;
import com.nxp.taginfolite.fragments.view.SlidingTabLayout;

public class ag extends SherlockFragment {
    private ViewPager f1262a;
    private View f1263b;
    private View f1264c;
    private boolean f1265d;
    private View f1266e;
    private boolean f1267f;

    public ag() {
        this.f1265d = true;
        this.f1266e = null;
        this.f1267f = false;
    }

    public int m1257a() {
        return this.f1262a.getCurrentItem();
    }

    public void m1258a(int i) {
        this.f1262a.setCurrentItem(i);
    }

    public void m1259a(boolean z) {
        if (this.f1266e == null) {
            this.f1267f = z;
        } else if (z) {
            this.f1266e.setVisibility(0);
        } else {
            this.f1266e.setVisibility(4);
        }
    }

    public void m1260b(boolean z) {
        int i = 1;
        int i2 = this.f1263b != null ? 1 : 0;
        if (this.f1264c == null) {
            i = 0;
        }
        if ((i2 & i) == 0) {
            this.f1265d = z;
        } else if (z) {
            this.f1263b.setVisibility(0);
            this.f1264c.setVisibility(8);
        } else {
            this.f1263b.setVisibility(8);
            this.f1264c.setVisibility(0);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.main, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        this.f1263b = view.findViewById(R.id.nxp_color);
        this.f1264c = view.findViewById(R.id.nxp_gray);
        m1260b(this.f1265d);
        this.f1266e = view.findViewById(R.id.tag_scan_illustration);
        m1259a(this.f1267f);
        this.f1262a = (ViewPager) view.findViewById(R.id.view_pager);
        C0380g c0380g = new C0380g(getChildFragmentManager(), this.f1262a, new String[]{getString(R.string.tab_info), getString(R.string.tab_ndef), getString(R.string.tab_extra), getString(R.string.tab_tech)});
        ((SlidingTabLayout) view.findViewById(R.id.sliding_tabs)).setViewPager(this.f1262a);
    }
}
