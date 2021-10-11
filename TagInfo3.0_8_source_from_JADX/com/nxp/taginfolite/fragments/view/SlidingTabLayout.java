package com.nxp.taginfolite.fragments.view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class SlidingTabLayout extends HorizontalScrollView {
    private final int f1319a;
    private int f1320b;
    private int f1321c;
    private ViewPager f1322d;
    private OnPageChangeListener f1323e;
    private final C0416e f1324f;

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f1319a = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.f1324f = new C0416e(context);
        addView(this.f1324f, -1, -2);
    }

    private void m1334a() {
        PagerAdapter adapter = this.f1322d.getAdapter();
        OnClickListener c0414c = new C0414c();
        for (int i = 0; i < adapter.getCount(); i++) {
            View inflate;
            TextView textView;
            if (this.f1320b != 0) {
                inflate = LayoutInflater.from(getContext()).inflate(this.f1320b, this.f1324f, false);
                textView = (TextView) inflate.findViewById(this.f1321c);
            } else {
                textView = null;
                inflate = null;
            }
            if (inflate == null) {
                inflate = m1339a(getContext());
            }
            if (textView == null && TextView.class.isInstance(inflate)) {
                textView = (TextView) inflate;
            }
            textView.setText(adapter.getPageTitle(i));
            inflate.setOnClickListener(c0414c);
            this.f1324f.addView(inflate);
            inflate.setLayoutParams(new LayoutParams(0, -2, 1.0f));
        }
    }

    private void m1335a(int i, int i2) {
        int childCount = this.f1324f.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount) {
            View childAt = this.f1324f.getChildAt(i);
            if (childAt != null) {
                childCount = childAt.getLeft() + i2;
                if (i > 0 || i2 > 0) {
                    childCount -= this.f1319a;
                }
                scrollTo(childCount, 0);
            }
        }
    }

    protected TextView m1339a(Context context) {
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTextSize(2, 12.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        if (VERSION.SDK_INT >= 11) {
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(16843534, typedValue, true);
            textView.setBackgroundResource(typedValue.resourceId);
        }
        if (VERSION.SDK_INT >= 14) {
            textView.setAllCaps(true);
        }
        int i = (int) (16.0f * getResources().getDisplayMetrics().density);
        textView.setPadding(i, i, i, i);
        return textView;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1322d != null) {
            m1335a(this.f1322d.getCurrentItem(), 0);
        }
    }

    public void setCustomTabColorizer(C0415d c0415d) {
        this.f1324f.m1345a(c0415d);
    }

    public void setDividerColors(int... iArr) {
        this.f1324f.m1347b(iArr);
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f1323e = onPageChangeListener;
    }

    public void setSelectedIndicatorColors(int... iArr) {
        this.f1324f.m1346a(iArr);
    }

    public void setViewPager(ViewPager viewPager) {
        this.f1324f.removeAllViews();
        this.f1322d = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new C0413b());
            m1334a();
        }
    }
}
