package com.nxp.taginfolite.fragments.p020a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.nxp.taginfolite.R;

/* renamed from: com.nxp.taginfolite.fragments.a.f */
public class C0379f extends C0374c {
    private long f1206b;

    public C0379f(Context context, Cursor cursor, String[] strArr, int[] iArr, long j) {
        super(context, cursor, strArr, iArr, R.layout.scandb_item);
        this.f1206b = j;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        int i = 8;
        int columnIndex = cursor.getColumnIndex("time");
        int columnIndex2 = cursor.getColumnIndex("uid");
        int columnIndex3 = cursor.getColumnIndex("title");
        int columnIndex4 = cursor.getColumnIndex("hasndef");
        int columnIndex5 = cursor.getColumnIndex("taglost");
        int columnIndex6 = cursor.getColumnIndex("_id");
        TextView textView = (TextView) view.findViewById(R.id.scan_time);
        textView.setText(cursor.getString(columnIndex));
        TextView textView2 = (TextView) view.findViewById(R.id.scan_uid);
        textView2.setText(cursor.getString(columnIndex2));
        CharSequence string = cursor.getString(columnIndex3);
        CharSequence charSequence = TextUtils.isEmpty(string) ? "[no title]" : string;
        TextView textView3 = (TextView) view.findViewById(R.id.scan_title);
        textView3.setText(charSequence);
        ((ImageView) view.findViewById(R.id.scan_has_ndef)).setVisibility((cursor.getInt(columnIndex4) != 0 ? 1 : 0) != 0 ? 0 : 8);
        ImageView imageView = (ImageView) view.findViewById(R.id.scan_tag_lost);
        if ((cursor.getInt(columnIndex5) != 0 ? 1 : 0) != 0) {
            i = 0;
        }
        imageView.setVisibility(i);
        long j = cursor.getLong(columnIndex6);
        Resources resources = view.getResources();
        if (this.f1206b == j) {
            columnIndex3 = resources.getColor(R.color.color_nxp_orange);
            textView.setTextColor(columnIndex3);
            textView2.setTextColor(columnIndex3);
            textView2.setTypeface(Typeface.MONOSPACE, 1);
            textView3.setTextColor(-1);
            view.setBackgroundColor(resources.getColor(R.color.color_shown_bg));
        } else {
            textView.setTextColor(-1);
            textView2.setTextColor(-1);
            textView2.setTypeface(Typeface.MONOSPACE, 0);
            textView3.setTextColor(resources.getColor(R.color.color_text_dark));
            view.setBackgroundColor(0);
        }
        m1148a(cursor, view, textView3);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.scandb_item, viewGroup, false);
    }
}
