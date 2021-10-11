package com.nxp.taginfolite.fragments.p020a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.fragments.a.c */
public class C0374c extends SimpleCursorAdapter {
    protected SparseBooleanArray f1196a;

    public C0374c(Context context, Cursor cursor, String[] strArr, int[] iArr, int i) {
        super(context, i, cursor, strArr, iArr);
        this.f1196a = new SparseBooleanArray();
    }

    private void m1146a(int i, boolean z) {
        if (z) {
            this.f1196a.put(i, true);
        } else {
            this.f1196a.delete(i);
        }
        notifyDataSetChanged();
    }

    public void m1147a(int i) {
        m1146a(i, !this.f1196a.get(i));
    }

    void m1148a(Cursor cursor, View view, TextView textView) {
        Resources resources = view.getResources();
        if (this.f1196a.get(cursor.getPosition())) {
            textView.setTextColor(-1);
            view.setBackgroundColor(resources.getColor(R.color.color_selected_bg));
        }
    }

    public void m1149a(SparseBooleanArray sparseBooleanArray) {
        this.f1196a = sparseBooleanArray;
    }

    public boolean m1150a() {
        Cursor cursor = getCursor();
        return cursor != null && this.f1196a.size() == cursor.getCount();
    }

    public void m1151b() {
        this.f1196a = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void m1152b(int i) {
        m1146a(i, true);
    }

    public int m1153c() {
        return this.f1196a.size();
    }

    public void m1154c(int i) {
        m1146a(i, false);
    }

    public SparseBooleanArray m1155d() {
        return this.f1196a;
    }
}
