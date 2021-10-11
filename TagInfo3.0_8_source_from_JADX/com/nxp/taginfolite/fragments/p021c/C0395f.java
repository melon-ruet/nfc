package com.nxp.taginfolite.fragments.p021c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.fragments.c.f */
class C0395f extends BaseAdapter {
    final /* synthetic */ C0390a f1291a;

    private C0395f(C0390a c0390a) {
        this.f1291a = c0390a;
    }

    public int getCount() {
        return this.f1291a.f1275c.size();
    }

    public Object getItem(int i) {
        return this.f1291a.f1275c.get(i);
    }

    public long getItemId(int i) {
        return (long) ((C0394e) this.f1291a.f1275c.get(i)).f1289a;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f1291a.f1273a).inflate(R.layout.popup_list_item, null);
        }
        ((TextView) view.findViewById(16908308)).setText(((C0394e) this.f1291a.f1275c.get(i)).f1290b);
        return view;
    }
}
