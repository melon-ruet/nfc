package com.nxp.taginfolite.database.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.actionbarsherlock.C0086R;
import com.nxp.taginfolite.database.p007a.C0214a;
import com.nxp.taginfolite.database.p008b.C0221c;
import com.nxp.taginfolite.database.p008b.C0223e;
import com.nxp.taginfolite.database.p008b.C0225g;
import com.nxp.taginfolite.database.p008b.C0227i;
import java.util.HashMap;
import org.jraf.android.backport.switchwidget.C0519c;

public class UserKeys extends ContentProvider {
    public static final HashMap f348a;
    public static final Uri f349b;
    public static final Uri f350c;
    public static final Uri f351d;
    public static final Uri f352e;
    public static final Uri f353f;
    public static final Uri f354g;
    private static final Uri f355h;
    private static final Uri f356i;
    private static final Uri f357j;
    private static final Uri f358k;
    private static final Uri f359l;
    private static final UriMatcher f360m;
    private C0214a f361n;

    static {
        f348a = new C0241c();
        f349b = Uri.parse("content://com.nxp.taginfolite.keys");
        f350c = Uri.withAppendedPath(f349b, "compound");
        f355h = Uri.withAppendedPath(f350c, "#");
        f351d = Uri.withAppendedPath(f349b, "user_keys");
        f356i = Uri.withAppendedPath(f351d, "#");
        f352e = Uri.withAppendedPath(f349b, "key_selector");
        f357j = Uri.withAppendedPath(f352e, "#");
        f353f = Uri.withAppendedPath(f349b, "key_subselector");
        f358k = Uri.withAppendedPath(f353f, "#");
        f354g = Uri.withAppendedPath(f349b, "chip_var");
        f359l = Uri.withAppendedPath(f354g, "#");
        f360m = new C0242d(-1);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        int i = 0;
        int match = f360m.match(uri);
        if (match == -1) {
            return 0;
        }
        SQLiteDatabase writableDatabase = this.f361n.getWritableDatabase();
        switch (match) {
            case C0519c.Switch_thumb /*0*/:
                return delete(f351d, str, strArr);
            case C0519c.Switch_track /*1*/:
                if (writableDatabase != null) {
                    i = writableDatabase.delete("user_keys", str, strArr);
                    break;
                }
                break;
            case C0519c.Switch_textOn /*2*/:
                if (writableDatabase != null) {
                    i = writableDatabase.delete("key_selector", str, strArr);
                    break;
                }
                break;
            case C0086R.styleable.SherlockTheme_actionMenuTextAppearance /*10*/:
                return delete(Uri.withAppendedPath(f351d, uri.getLastPathSegment()), str, strArr);
            case C0086R.styleable.SherlockTheme_actionMenuTextColor /*11*/:
                String str2 = "user_keys._id = ?";
                String[] strArr2 = new String[]{uri.getLastPathSegment()};
                if (writableDatabase != null) {
                    i = writableDatabase.delete("user_keys", str2, strArr2);
                    break;
                }
                break;
            default:
                i = -1;
                break;
        }
        if (i <= 0) {
            return i;
        }
        Context context = getContext();
        if (context == null) {
            return i;
        }
        context.getContentResolver().notifyChange(uri, null);
        return i;
    }

    public String getType(Uri uri) {
        throw new UnsupportedOperationException();
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        int match = f360m.match(uri);
        if (match == -1) {
            return null;
        }
        Uri insert;
        switch (match) {
            case C0519c.Switch_thumb /*0*/:
                insert = insert(f351d, contentValues);
                long parseId = ContentUris.parseId(insert);
                contentValues.put("chip_var_user_keys_id", Long.valueOf(parseId));
                insert(f354g, contentValues);
                contentValues.put("key_selector_user_keys_id", Long.valueOf(parseId));
                insert(f352e, contentValues);
                contentValues.put("key_subselector_user_keys_id", Long.valueOf(parseId));
                insert(f353f, contentValues);
                break;
            case C0519c.Switch_track /*1*/:
                insert = ContentUris.withAppendedId(f351d, C0227i.m332a().m333a(this.f361n, contentValues));
                break;
            case C0519c.Switch_textOn /*2*/:
                insert = ContentUris.withAppendedId(f352e, C0223e.m326a().m327a(this.f361n, contentValues));
                break;
            case C0519c.Switch_textOff /*3*/:
                insert = ContentUris.withAppendedId(f353f, C0225g.m329a().m330a(this.f361n, contentValues));
                break;
            case C0519c.Switch_thumbTextPadding /*4*/:
                insert = ContentUris.withAppendedId(f354g, C0221c.m323a().m324a(this.f361n, contentValues));
                break;
            default:
                insert = uri;
                break;
        }
        if (insert != null) {
            Context context = getContext();
            if (context != null) {
                context.getContentResolver().notifyChange(insert, null);
            }
        }
        return insert;
    }

    public boolean onCreate() {
        this.f361n = new C0214a(getContext());
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.database.Cursor query(android.net.Uri r10, java.lang.String[] r11, java.lang.String r12, java.lang.String[] r13, java.lang.String r14) {
        /*
        r9 = this;
        r1 = 0;
        r0 = "user_keys._id";
        r0 = r9.f361n;
        r0 = r0.getReadableDatabase();
        r2 = f360m;
        r2 = r2.match(r10);
        switch(r2) {
            case 0: goto L_0x0109;
            case 1: goto L_0x00b4;
            case 2: goto L_0x00bc;
            case 10: goto L_0x0019;
            case 12: goto L_0x00c4;
            default: goto L_0x0012;
        };
    L_0x0012:
        r4 = r13;
        r3 = r12;
        r2 = r11;
    L_0x0015:
        if (r1 != 0) goto L_0x00d8;
    L_0x0017:
        r0 = 0;
    L_0x0018:
        return r0;
    L_0x0019:
        r2 = new java.lang.StringBuilder;
        if (r12 != 0) goto L_0x001f;
    L_0x001d:
        r12 = "";
    L_0x001f:
        r2.<init>(r12);
        r1 = r2.length();
        if (r1 <= 0) goto L_0x002d;
    L_0x0028:
        r1 = " AND ";
        r2.append(r1);
    L_0x002d:
        r1 = "user_keys._id";
        r2.append(r1);
        r1 = " = ? ";
        r2.append(r1);
        if (r13 != 0) goto L_0x009e;
    L_0x0039:
        r1 = 1;
        r1 = new java.lang.String[r1];
    L_0x003c:
        r3 = r1.length;
        r3 = r3 + -1;
        r4 = r10.getLastPathSegment();
        r1[r3] = r4;
        r3 = r2.toString();
        r4 = r1;
    L_0x004a:
        if (r11 == 0) goto L_0x004f;
    L_0x004c:
        r1 = r11.length;
        if (r1 != 0) goto L_0x0107;
    L_0x004f:
        r1 = 13;
        r2 = new java.lang.String[r1];
        r1 = 0;
        r5 = "user_keys._id";
        r2[r1] = r5;
        r1 = 1;
        r5 = "title";
        r2[r1] = r5;
        r1 = 2;
        r5 = "chip";
        r2[r1] = r5;
        r1 = 3;
        r5 = "key_type";
        r2[r1] = r5;
        r1 = 4;
        r5 = "key_value";
        r2[r1] = r5;
        r1 = 5;
        r5 = "enabled";
        r2[r1] = r5;
        r1 = 6;
        r5 = "chip_var";
        r2[r1] = r5;
        r1 = 7;
        r5 = "key_selector_user_keys_id";
        r2[r1] = r5;
        r1 = 8;
        r5 = "selector_type";
        r2[r1] = r5;
        r1 = 9;
        r5 = "selector_value";
        r2[r1] = r5;
        r1 = 10;
        r5 = "key_subselector_user_keys_id";
        r2[r1] = r5;
        r1 = 11;
        r5 = "subselector";
        r2[r1] = r5;
        r1 = 12;
        r5 = "subselector_value";
        r2[r1] = r5;
    L_0x0099:
        if (r0 != 0) goto L_0x00a8;
    L_0x009b:
        r0 = 0;
        goto L_0x0018;
    L_0x009e:
        r1 = r13.length;
        r1 = r1 + 1;
        r1 = java.util.Arrays.copyOf(r13, r1);
        r1 = (java.lang.String[]) r1;
        goto L_0x003c;
    L_0x00a8:
        r1 = "user_keys LEFT JOIN key_selector ON user_keys._id = key_selector_user_keys_id LEFT JOIN key_subselector ON user_keys._id = key_subselector_user_keys_id LEFT JOIN chip_var ON user_keys._id = chip_var_user_keys_id";
        r5 = "user_keys._id";
        r6 = 0;
        r7 = r14;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        goto L_0x0018;
    L_0x00b4:
        r1 = "user_keys";
        r2 = com.nxp.taginfolite.database.p008b.C0227i.f271b;
        r4 = r13;
        r3 = r12;
        goto L_0x0015;
    L_0x00bc:
        r1 = "key_selector";
        r2 = com.nxp.taginfolite.database.p008b.C0223e.f267b;
        r4 = r13;
        r3 = r12;
        goto L_0x0015;
    L_0x00c4:
        r1 = "key_selector";
        r12 = "key_selector_user_keys_id = ?";
        r2 = 1;
        r13 = new java.lang.String[r2];
        r2 = 0;
        r3 = r10.getLastPathSegment();
        r13[r2] = r3;
        r2 = com.nxp.taginfolite.database.p008b.C0223e.f267b;
        r4 = r13;
        r3 = r12;
        goto L_0x0015;
    L_0x00d8:
        r8 = 0;
        if (r0 != 0) goto L_0x00de;
    L_0x00db:
        r0 = 0;
        goto L_0x0018;
    L_0x00de:
        r5 = 0;
        r6 = 0;
        r7 = r14;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x00e7 }
        goto L_0x0018;
    L_0x00e7:
        r0 = move-exception;
        r1 = "TagInfo_UserKeys";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Error in query: ";
        r2 = r2.append(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        android.util.Log.e(r1, r0);
        r0 = r8;
        goto L_0x0018;
    L_0x0107:
        r2 = r11;
        goto L_0x0099;
    L_0x0109:
        r4 = r13;
        r3 = r12;
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.database.provider.UserKeys.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int update(android.net.Uri r8, android.content.ContentValues r9, java.lang.String r10, java.lang.String[] r11) {
        /*
        r7 = this;
        r1 = -1;
        r6 = 1;
        r0 = 0;
        r2 = f360m;
        r2 = r2.match(r8);
        if (r2 != r1) goto L_0x000c;
    L_0x000b:
        return r0;
    L_0x000c:
        r3 = r8.getLastPathSegment();
        switch(r2) {
            case 1: goto L_0x0054;
            case 2: goto L_0x0071;
            case 3: goto L_0x008e;
            case 4: goto L_0x00ac;
            case 5: goto L_0x0013;
            case 6: goto L_0x0013;
            case 7: goto L_0x0013;
            case 8: goto L_0x0013;
            case 9: goto L_0x0013;
            case 10: goto L_0x0025;
            case 11: goto L_0x004a;
            case 12: goto L_0x005e;
            case 13: goto L_0x007b;
            case 14: goto L_0x0099;
            default: goto L_0x0013;
        };
    L_0x0013:
        r0 = r1;
    L_0x0014:
        if (r0 <= 0) goto L_0x000b;
    L_0x0016:
        r1 = r7.getContext();
        if (r1 == 0) goto L_0x000b;
    L_0x001c:
        r1 = r1.getContentResolver();
        r2 = 0;
        r1.notifyChange(r8, r2);
        goto L_0x000b;
    L_0x0025:
        r1 = f351d;
        r1 = android.net.Uri.withAppendedPath(r1, r3);
        r7.update(r1, r9, r10, r11);
        r1 = f354g;
        r1 = android.net.Uri.withAppendedPath(r1, r3);
        r7.update(r1, r9, r10, r11);
        r1 = f352e;
        r1 = android.net.Uri.withAppendedPath(r1, r3);
        r7.update(r1, r9, r10, r11);
        r1 = f353f;
        r1 = android.net.Uri.withAppendedPath(r1, r3);
        r7.update(r1, r9, r10, r11);
        goto L_0x0014;
    L_0x004a:
        r10 = "user_keys._id = ?";
        r11 = new java.lang.String[r6];
        r1 = r8.getLastPathSegment();
        r11[r0] = r1;
    L_0x0054:
        r1 = com.nxp.taginfolite.database.p008b.C0227i.m332a();
        r2 = r7.f361n;
        r1.m334a(r2, r9, r10, r11);
        goto L_0x0014;
    L_0x005e:
        r1 = "key_selector_user_keys_id";
        r4 = java.lang.Long.parseLong(r3);
        r2 = java.lang.Long.valueOf(r4);
        r9.put(r1, r2);
        r10 = "key_selector.key_selector_user_keys_id = ?";
        r11 = new java.lang.String[r6];
        r11[r0] = r3;
    L_0x0071:
        r1 = com.nxp.taginfolite.database.p008b.C0223e.m326a();
        r2 = r7.f361n;
        r1.m328a(r2, r9, r10, r11);
        goto L_0x0014;
    L_0x007b:
        r1 = "key_subselector_user_keys_id";
        r4 = java.lang.Long.parseLong(r3);
        r2 = java.lang.Long.valueOf(r4);
        r9.put(r1, r2);
        r10 = "key_subselector.key_subselector_user_keys_id = ?";
        r11 = new java.lang.String[r6];
        r11[r0] = r3;
    L_0x008e:
        r1 = com.nxp.taginfolite.database.p008b.C0225g.m329a();
        r2 = r7.f361n;
        r1.m331a(r2, r9, r10, r11);
        goto L_0x0014;
    L_0x0099:
        r1 = "chip_var_user_keys_id";
        r4 = java.lang.Long.parseLong(r3);
        r2 = java.lang.Long.valueOf(r4);
        r9.put(r1, r2);
        r10 = "chip_var.chip_var_user_keys_id = ?";
        r11 = new java.lang.String[r6];
        r11[r0] = r3;
    L_0x00ac:
        r1 = com.nxp.taginfolite.database.p008b.C0221c.m323a();
        r2 = r7.f361n;
        r1.m325a(r2, r9, r10, r11);
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.database.provider.UserKeys.update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }
}
