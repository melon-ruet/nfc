package com.nxp.taginfolite.fragments.p021c;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.nxp.taginfolite.R;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.nxp.taginfolite.fragments.c.a */
public class C0390a {
    private final Context f1273a;
    private final View f1274b;
    private final ArrayList f1275c;
    private PopupWindow f1276d;
    private ListView f1277e;
    private C0385g f1278f;
    private int f1279g;
    private int f1280h;
    private int f1281i;
    private int f1282j;
    private final OnDismissListener f1283k;
    private final OnItemClickListener f1284l;
    private final OnGlobalLayoutListener f1285m;

    public C0390a(Context context, View view) {
        this.f1275c = new ArrayList();
        this.f1283k = new C0391b(this);
        this.f1284l = new C0392c(this);
        this.f1285m = new C0393d(this);
        this.f1273a = context;
        this.f1274b = view;
    }

    private void m1278b() {
        ListView listView = this.f1277e;
        PopupWindow popupWindow = this.f1276d;
        Rect rect = new Rect();
        popupWindow.getBackground().getPadding(rect);
        int maxAvailableHeight = (this.f1276d.getMaxAvailableHeight(this.f1274b) - rect.top) - rect.bottom;
        this.f1277e.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(maxAvailableHeight, ExploreByTouchHelper.INVALID_ID));
        this.f1281i = (listView.getMeasuredWidth() + rect.top) + rect.bottom;
        this.f1282j = Math.min(maxAvailableHeight, (listView.getMeasuredHeight() + rect.left) + rect.right);
        this.f1279g = -rect.left;
        this.f1280h = -rect.top;
    }

    private PopupWindow m1280c() {
        PopupWindow popupWindow = new PopupWindow(this.f1273a);
        popupWindow.setOnDismissListener(this.f1283k);
        popupWindow.setBackgroundDrawable(this.f1273a.getResources().getDrawable(R.drawable.menu_dropdown_panel_taginfo));
        this.f1277e = new ListView(this.f1273a, null, 16842861);
        this.f1277e.setAdapter(new C0395f());
        this.f1277e.setOnItemClickListener(this.f1284l);
        popupWindow.setContentView(this.f1277e);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        return popupWindow;
    }

    public void m1289a() {
        if (this.f1276d == null) {
            this.f1274b.getViewTreeObserver().addOnGlobalLayoutListener(this.f1285m);
            this.f1276d = m1280c();
            m1278b();
            this.f1276d.setWidth(this.f1281i);
            this.f1276d.setHeight(this.f1282j);
            this.f1276d.showAsDropDown(this.f1274b, this.f1279g, this.f1280h);
        }
    }

    public void m1290a(int i) {
        this.f1275c.remove(m1293b(i));
    }

    public void m1291a(int i, String str) {
        this.f1275c.add(new C0394e(i, str));
    }

    public void m1292a(C0385g c0385g) {
        this.f1278f = c0385g;
    }

    public C0394e m1293b(int i) {
        Iterator it = this.f1275c.iterator();
        while (it.hasNext()) {
            C0394e c0394e = (C0394e) it.next();
            if (c0394e.f1289a == i) {
                return c0394e;
            }
        }
        return null;
    }
}
