package com.nxp.taginfolite.fragments.p020a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v4.BuildConfig;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.database.provider.UserKeys;
import com.nxp.taginfolite.fragments.C0406p;

/* renamed from: com.nxp.taginfolite.fragments.a.a */
public class C0375a extends C0374c {
    public C0375a(Context context, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, cursor, strArr, iArr, R.layout.key_manager_item);
    }

    private static String m1156a(String str, String str2, String str3, String str4) {
        return "MFC".equals(str) ? C0406p.m1315a(str2, str3, str4) : "ULC".equals(str) ? BuildConfig.VERSION_NAME : null;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("title");
        int columnIndex2 = cursor.getColumnIndex("chip");
        int columnIndex3 = cursor.getColumnIndex("enabled");
        int columnIndex4 = cursor.getColumnIndex("key_type");
        int columnIndex5 = cursor.getColumnIndex("chip_var");
        int columnIndex6 = cursor.getColumnIndex("selector_value");
        TextView textView = (TextView) view.findViewById(R.id.key_type);
        String string = cursor.getString(columnIndex2);
        textView.setText((CharSequence) UserKeys.f348a.get(string));
        ((TextView) view.findViewById(R.id.key_summary)).setText(C0375a.m1156a(string, cursor.getString(columnIndex4), cursor.getString(columnIndex5), cursor.getString(columnIndex6)));
        CharSequence string2 = cursor.getString(columnIndex);
        CharSequence charSequence = TextUtils.isEmpty(string2) ? "[no title]" : string2;
        textView = (TextView) view.findViewById(R.id.key_title);
        textView.setText(charSequence);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.key_enabled);
        checkBox.setChecked(cursor.getInt(columnIndex3) != 0);
        checkBox.setOnCheckedChangeListener(new C0376b(this));
        Resources resources = view.getResources();
        if (resources != null) {
            textView.setTextColor(resources.getColor(R.color.color_text_dark));
        }
        view.setBackgroundColor(0);
        m1148a(cursor, view, textView);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.key_manager_item, viewGroup, false);
    }
}
