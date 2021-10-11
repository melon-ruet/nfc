package com.nxp.taginfolite.fragments.p020a;

import android.content.Context;
import android.support.v4.BuildConfig;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.database.C0235d;
import com.nxp.taginfolite.p005b.C0182c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.nxp.taginfolite.fragments.a.d */
public class C0377d extends ArrayAdapter {
    private List f1198a;
    private Context f1199b;
    private final LayoutInflater f1200c;
    private final boolean f1201d;

    public C0377d(Context context, List list) {
        boolean z = false;
        super(context, R.layout.scan_item, list);
        this.f1198a = null;
        this.f1199b = null;
        this.f1199b = context;
        this.f1200c = LayoutInflater.from(context);
        int i = this.f1199b.getResources().getConfiguration().orientation;
        if (((context.getResources().getConfiguration().screenLayout & 15) >= 3) || i == 2) {
            z = true;
        }
        this.f1201d = z;
        if (list == null || list.isEmpty()) {
            this.f1198a = new ArrayList();
            this.f1198a.add(new C0235d(context.getString(R.string.no_scan_item), null));
            return;
        }
        this.f1198a = list;
    }

    public C0235d m1157a(int i) {
        return i < this.f1198a.size() ? (C0235d) this.f1198a.get(i) : null;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public int getCount() {
        return this.f1198a.size() + 1;
    }

    public /* synthetic */ Object getItem(int i) {
        return m1157a(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f1198a == null) {
            return null;
        }
        TextView textView;
        View findViewById;
        View view2;
        TextView textView2;
        View view3;
        View view4;
        if (view == null) {
            view4 = (LinearLayout) this.f1200c.inflate(R.layout.scan_item, viewGroup, false);
            if (view4 == null) {
                return null;
            }
            TextView textView3 = (TextView) view4.findViewById(R.id.scanTitle);
            View findViewById2 = view4.findViewById(R.id.scanTitleDivider);
            textView = (TextView) view4.findViewById(R.id.scanText);
            findViewById = view4.findViewById(R.id.layout_listDivider);
            view4.setTag(new C0378e(textView3, findViewById2, textView, findViewById));
            view2 = view4;
            View view5 = findViewById2;
            textView2 = textView3;
            view3 = findViewById;
            findViewById = view5;
        } else {
            view4 = (LinearLayout) view;
            C0378e c0378e = (C0378e) view.getTag();
            textView2 = c0378e.f1203b;
            findViewById = c0378e.f1204c;
            textView = c0378e.f1202a;
            view3 = c0378e.f1205d;
            view2 = view4;
        }
        if (i < this.f1198a.size()) {
            C0235d c0235d = (C0235d) this.f1198a.get(i);
            if (c0235d != null) {
                CharSequence a;
                C0182c b = c0235d.m362b();
                CharSequence a2 = c0235d.m361a();
                String str = BuildConfig.VERSION_NAME;
                if (b != null) {
                    a = b.m149a(this.f1199b, this.f1201d);
                } else {
                    Object obj = str;
                }
                boolean isEmpty = TextUtils.isEmpty(a2);
                Object obj2 = (i >= this.f1198a.size() + -1 || !TextUtils.isEmpty(((C0235d) this.f1198a.get(i + 1)).m361a())) ? null : 1;
                textView.setIncludeFontPadding(false);
                if (isEmpty) {
                    textView.setPadding(textView.getPaddingLeft(), 0, textView.getPaddingRight(), textView.getPaddingBottom());
                }
                if (obj2 != null) {
                    textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), 0);
                    view3.setVisibility(8);
                }
                obj2 = 1;
                if (TextUtils.isEmpty(a)) {
                    textView.setVisibility(8);
                } else {
                    obj2 = null;
                    textView.setText(a);
                    if (b != null && b.m152c()) {
                        textView.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                    textView.setVisibility(0);
                }
                if (TextUtils.isEmpty(a2)) {
                    textView2.setVisibility(8);
                    findViewById.setVisibility(8);
                } else {
                    obj2 = null;
                    textView2.setText(a2);
                    textView2.setVisibility(0);
                    findViewById.setVisibility(0);
                }
                if (obj2 != null) {
                    view2.setVisibility(8);
                } else {
                    view2.setVisibility(0);
                }
            } else {
                textView2.setText(this.f1199b.getString(R.string.no_scan_item));
                textView.setVisibility(8);
            }
            if (i + 1 != this.f1198a.size()) {
                return view2;
            }
            view3.setVisibility(8);
            return view2;
        } else if (i != this.f1198a.size()) {
            return view2;
        } else {
            textView2.setVisibility(8);
            findViewById.setVisibility(8);
            textView.setText(" \n ");
            textView.setVisibility(0);
            view3.setVisibility(8);
            return view2;
        }
    }

    public boolean isEnabled(int i) {
        return false;
    }
}
