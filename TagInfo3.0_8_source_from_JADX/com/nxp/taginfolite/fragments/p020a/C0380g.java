package com.nxp.taginfolite.fragments.p020a;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.nxp.taginfolite.fragments.ad;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.nxp.taginfolite.fragments.a.g */
public class C0380g extends FragmentPagerAdapter {
    private final ViewPager f1207a;
    private final ArrayList f1208b;
    private final String[] f1209c;

    public C0380g(FragmentManager fragmentManager, ViewPager viewPager, String[] strArr) {
        super(fragmentManager);
        this.f1208b = new ArrayList();
        this.f1209c = (String[]) Arrays.copyOf(strArr, strArr.length);
        for (int i = 0; i < 4; i++) {
            m1158a(i);
        }
        this.f1207a = viewPager;
        if (this.f1207a != null) {
            this.f1207a.setAdapter(this);
        }
    }

    public void m1158a(int i) {
        this.f1208b.add(Integer.valueOf(i));
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f1208b.size();
    }

    public Fragment getItem(int i) {
        return ad.m1252a(((Integer) this.f1208b.get(i)).intValue());
    }

    public CharSequence getPageTitle(int i) {
        return this.f1209c[i];
    }
}
