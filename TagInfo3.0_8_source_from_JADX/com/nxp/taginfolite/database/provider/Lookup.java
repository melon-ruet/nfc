package com.nxp.taginfolite.database.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import com.actionbarsherlock.C0086R;
import com.nxp.taginfolite.database.p007a.C0215b;

public class Lookup extends ContentProvider {
    public static final Uri f332a;
    private static final UriMatcher f333b;
    private C0215b f334c;

    static {
        f332a = Uri.parse("content://com.nxp.taginfolite.lookup");
        f333b = new C0239a(-1);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    public String getType(Uri uri) {
        throw new UnsupportedOperationException();
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    public boolean onCreate() {
        this.f334c = new C0215b(getContext());
        this.f334c.m319a(getContext());
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String str3;
        String[] strArr3;
        switch (f333b.match(uri)) {
            case C0086R.styleable.SherlockTheme_actionMenuTextAppearance /*10*/:
                str3 = "mad_data";
                strArr3 = new String[]{"application", "service_provider", "system_integrator", "company"};
                break;
            case C0086R.styleable.SherlockTheme_selectableItemBackground /*20*/:
                str3 = "blz_data";
                strArr3 = new String[]{"bank", "city"};
                break;
            case C0086R.styleable.SherlockTheme_searchAutoCompleteTextView /*30*/:
                str3 = "oui_data";
                strArr3 = new String[]{"manufacturer"};
                break;
            case C0086R.styleable.SherlockTheme_textColorSearchUrl /*40*/:
                str3 = "bieb_data";
                strArr3 = new String[]{"name"};
                break;
            default:
                str3 = null;
                strArr3 = strArr;
                break;
        }
        if (str3 == null) {
            return null;
        }
        Cursor cursor;
        SQLiteDatabase readableDatabase = this.f334c.getReadableDatabase();
        if (readableDatabase == null) {
            cursor = null;
        } else {
            try {
                cursor = readableDatabase.query(str3, strArr3, str, strArr2, null, null, str2);
            } catch (Exception e) {
                Log.e("TagInfo_Lookup", "Error in query: " + e.getMessage());
                return null;
            }
        }
        return cursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }
}
