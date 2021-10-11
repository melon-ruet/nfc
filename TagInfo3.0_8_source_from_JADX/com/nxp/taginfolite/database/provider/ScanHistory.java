package com.nxp.taginfolite.database.provider;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.v4.BuildConfig;
import com.actionbarsherlock.C0086R;
import com.nxp.taginfolite.database.p007a.C0216c;
import com.nxp.taginfolite.database.p008b.C0231m;
import com.nxp.taginfolite.database.p008b.C0232n;
import java.io.File;
import java.io.FileNotFoundException;
import org.jraf.android.backport.switchwidget.C0519c;

public class ScanHistory extends ContentProvider {
    public static final Uri f335a;
    public static final Uri f336b;
    public static final Uri f337c;
    public static final Uri f338d;
    public static final Uri f339e;
    public static final Uri f340f;
    public static final Uri f341g;
    private static final Uri f342h;
    private static final Uri f343i;
    private static final Uri f344j;
    private static final Uri f345k;
    private static final UriMatcher f346l;
    private C0216c f347m;

    static {
        f342h = Uri.parse("content://com.nxp.taginfolite.history");
        f335a = Uri.withAppendedPath(f342h, "compound");
        f343i = Uri.withAppendedPath(f335a, "#");
        f336b = Uri.withAppendedPath(f342h, "scan");
        f344j = Uri.withAppendedPath(f336b, "#");
        f337c = Uri.withAppendedPath(f342h, "scan_time");
        f345k = Uri.withAppendedPath(f337c, "#");
        f338d = Uri.withAppendedPath(f342h, "dbFile");
        f339e = Uri.withAppendedPath(f342h, "scanCount");
        f340f = Uri.withAppendedPath(f342h, "switchDatabase");
        f341g = Uri.withAppendedPath(f342h, "data");
        f346l = new C0240b(-1);
    }

    @SuppressLint({"NewApi"})
    public Bundle call(String str, String str2, Bundle bundle) {
        if (!str.equalsIgnoreCase("switchDatabase")) {
            return super.call(str, str2, bundle);
        }
        File file = str2 == null ? null : new File(str2);
        if (!(str2 != null && file.exists() && !file.isDirectory() && file.canRead() && file.canWrite())) {
            str2 = "TagInfo_Scans";
        }
        if (!this.f347m.getDatabaseName().equalsIgnoreCase(str2)) {
            this.f347m.close();
            try {
                this.f347m = new C0216c(getContext(), str2);
            } catch (RuntimeException e) {
                if ("TagInfo_Scans".equals(str2)) {
                    throw e;
                }
                call("switchDatabase", "TagInfo_Scans", bundle);
            }
        }
        return new Bundle();
    }

    public int delete(Uri uri, String str, String[] strArr) {
        int i = 0;
        int match = f346l.match(uri);
        if (match == -1) {
            return 0;
        }
        SQLiteDatabase writableDatabase = this.f347m.getWritableDatabase();
        switch (match) {
            case C0519c.Switch_thumb /*0*/:
                return delete(f336b, str, strArr);
            case C0519c.Switch_track /*1*/:
                return delete(Uri.withAppendedPath(f336b, uri.getLastPathSegment()), str, strArr);
            case C0519c.Switch_textOn /*2*/:
                if (writableDatabase != null) {
                    i = writableDatabase.delete("scan", str, strArr);
                    break;
                }
                break;
            case C0519c.Switch_textOff /*3*/:
                String str2 = "scan._id = ?";
                String[] strArr2 = new String[]{uri.getLastPathSegment()};
                if (writableDatabase != null) {
                    i = writableDatabase.delete("scan", str2, strArr2);
                    break;
                }
                break;
            case C0519c.Switch_thumbTextPadding /*4*/:
                if (writableDatabase != null) {
                    i = writableDatabase.delete("scan_time", str, strArr);
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
        int match = f346l.match(uri);
        if (match != -1) {
            switch (match) {
                case C0519c.Switch_thumb /*0*/:
                case C0519c.Switch_textOn /*2*/:
                case C0519c.Switch_thumbTextPadding /*4*/:
                    break;
                default:
                    break;
            }
        }
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        boolean z = false;
        int match = f346l.match(uri);
        if (match == -1) {
            return null;
        }
        Uri insert;
        switch (match) {
            case C0519c.Switch_thumb /*0*/:
                insert = insert(f336b, contentValues);
                contentValues.put("scan_id", Long.valueOf(ContentUris.parseId(insert)));
                insert(f337c, contentValues);
                break;
            case C0519c.Switch_textOn /*2*/:
                insert = ContentUris.withAppendedId(f336b, C0231m.m339a().m341a(this.f347m, contentValues));
                break;
            case C0519c.Switch_thumbTextPadding /*4*/:
                insert = ContentUris.withAppendedId(f337c, C0232n.m342a().m343a(this.f347m, contentValues));
                break;
            case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("data", contentValues.getAsString("data"));
                String asString = contentValues.getAsString("title");
                String str = "title";
                if (asString == null) {
                    asString = BuildConfig.VERSION_NAME;
                }
                contentValues2.put(str, asString);
                asString = contentValues.getAsString("time");
                str = "time";
                if (asString == null) {
                    asString = BuildConfig.VERSION_NAME;
                }
                contentValues2.put(str, asString);
                Boolean asBoolean = contentValues.getAsBoolean("hasndef");
                contentValues2.put("hasndef", Boolean.valueOf(asBoolean == null ? false : asBoolean.booleanValue()));
                byte[] asByteArray = contentValues.getAsByteArray("ndef");
                str = "ndef";
                if (asByteArray == null) {
                    asByteArray = new byte[0];
                }
                contentValues2.put(str, asByteArray);
                asBoolean = contentValues.getAsBoolean("taglost");
                str = "taglost";
                if (asBoolean != null) {
                    z = asBoolean.booleanValue();
                }
                contentValues2.put(str, Boolean.valueOf(z));
                asString = contentValues.getAsString("uid");
                String str2 = "uid";
                if (asString == null) {
                    asString = BuildConfig.VERSION_NAME;
                }
                contentValues2.put(str2, asString);
                return insert(f335a, contentValues2);
            default:
                insert = null;
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
        this.f347m = new C0216c(getContext());
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        ParcelFileDescriptor parcelFileDescriptor = null;
        int match = f346l.match(uri);
        if (match != -1) {
            switch (match) {
                case C0519c.Switch_switchMinWidth /*6*/:
                    SQLiteDatabase writableDatabase = this.f347m.getWritableDatabase();
                    if (writableDatabase != null) {
                        try {
                            parcelFileDescriptor = ParcelFileDescriptor.open(new File(writableDatabase.getPath()), 268435456);
                            break;
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return parcelFileDescriptor;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public android.database.Cursor query(android.net.Uri r10, java.lang.String[] r11, java.lang.String r12, java.lang.String[] r13, java.lang.String r14) {
        /*
        r9 = this;
        r8 = 10;
        r7 = 0;
        r5 = 1;
        r6 = 0;
        r0 = f346l;
        r1 = r0.match(r10);
        r0 = -1;
        if (r1 != r0) goto L_0x000f;
    L_0x000e:
        return r6;
    L_0x000f:
        r0 = "scan._id";
        r0 = r9.f347m;
        r0 = r0.getReadableDatabase();
        switch(r1) {
            case 0: goto L_0x0110;
            case 1: goto L_0x002a;
            case 2: goto L_0x00b6;
            case 3: goto L_0x001a;
            case 4: goto L_0x00e6;
            case 5: goto L_0x00c9;
            case 6: goto L_0x001a;
            case 7: goto L_0x00f9;
            case 8: goto L_0x0103;
            default: goto L_0x001a;
        };
    L_0x001a:
        if (r6 == 0) goto L_0x000e;
    L_0x001c:
        r0 = r9.getContext();
        if (r0 == 0) goto L_0x000e;
    L_0x0022:
        r0 = r0.getContentResolver();
        r6.setNotificationUri(r0, r10);
        goto L_0x000e;
    L_0x002a:
        r2 = new java.lang.StringBuilder;
        if (r12 != 0) goto L_0x0030;
    L_0x002e:
        r12 = "";
    L_0x0030:
        r2.<init>(r12);
        r1 = r2.length();
        if (r1 <= 0) goto L_0x003e;
    L_0x0039:
        r1 = " AND ";
        r2.append(r1);
    L_0x003e:
        r1 = "scan._id";
        r2.append(r1);
        r1 = " = ? ";
        r2.append(r1);
        if (r13 != 0) goto L_0x00ac;
    L_0x004a:
        r1 = new java.lang.String[r5];
    L_0x004c:
        r3 = r1.length;
        r3 = r3 + -1;
        r4 = r10.getLastPathSegment();
        r1[r3] = r4;
        r3 = r2.toString();
        r4 = r1;
    L_0x005a:
        if (r11 == 0) goto L_0x005f;
    L_0x005c:
        r1 = r11.length;
        if (r1 != 0) goto L_0x010e;
    L_0x005f:
        r1 = 12;
        r2 = new java.lang.String[r1];
        r1 = "scan._id";
        r2[r7] = r1;
        r1 = "hasndef";
        r2[r5] = r1;
        r1 = 2;
        r5 = "ndef";
        r2[r1] = r5;
        r1 = 3;
        r5 = "comment";
        r2[r1] = r5;
        r1 = 4;
        r5 = "data";
        r2[r1] = r5;
        r1 = 5;
        r5 = "taglost";
        r2[r1] = r5;
        r1 = 6;
        r5 = "title";
        r2[r1] = r5;
        r1 = 7;
        r5 = "uid";
        r2[r1] = r5;
        r1 = 8;
        r5 = "min(time) as time";
        r2[r1] = r5;
        r1 = 9;
        r5 = "min(time) as timeMin";
        r2[r1] = r5;
        r1 = "max(time) as timeMax";
        r2[r8] = r1;
        r1 = 11;
        r5 = "count(time) as timecount";
        r2[r1] = r5;
    L_0x009f:
        if (r0 == 0) goto L_0x000e;
    L_0x00a1:
        r1 = "scan JOIN scan_time ON scan._id = scan_id";
        r5 = "scan._id";
        r7 = r14;
        r6 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        goto L_0x000e;
    L_0x00ac:
        r1 = r13.length;
        r1 = r1 + 1;
        r1 = java.util.Arrays.copyOf(r13, r1);
        r1 = (java.lang.String[]) r1;
        goto L_0x004c;
    L_0x00b6:
        r0 = r9.f347m;
        r1 = r0.getReadableDatabase();
        r2 = "scan";
        r3 = r11;
        r4 = r12;
        r5 = r13;
        r7 = r6;
        r8 = r14;
        r6 = r1.query(r2, r3, r4, r5, r6, r7, r8);
        goto L_0x001a;
    L_0x00c9:
        r4 = "scan_id = ?";
        r5 = new java.lang.String[r5];
        r0 = r10.getLastPathSegment();
        r5[r7] = r0;
        r0 = r9.f347m;
        r1 = r0.getWritableDatabase();
        if (r1 == 0) goto L_0x001a;
    L_0x00db:
        r2 = "scan_time";
        r3 = r11;
        r7 = r6;
        r8 = r14;
        r6 = r1.query(r2, r3, r4, r5, r6, r7, r8);
        goto L_0x001a;
    L_0x00e6:
        r0 = r9.f347m;
        r1 = r0.getReadableDatabase();
        r2 = "scan_time";
        r3 = r11;
        r4 = r12;
        r5 = r13;
        r7 = r6;
        r8 = r14;
        r6 = r1.query(r2, r3, r4, r5, r6, r7, r8);
        goto L_0x001a;
    L_0x00f9:
        if (r0 == 0) goto L_0x001a;
    L_0x00fb:
        r1 = "SELECT _id, uid, count(uid) AS uidcount FROM scan GROUP BY uid";
        r6 = r0.rawQuery(r1, r6);
        goto L_0x001a;
    L_0x0103:
        r0 = android.os.Build.VERSION.SDK_INT;
        if (r0 <= r8) goto L_0x001a;
    L_0x0107:
        r0 = "switchDatabase";
        r9.call(r0, r12, r6);
        goto L_0x001a;
    L_0x010e:
        r2 = r11;
        goto L_0x009f;
    L_0x0110:
        r4 = r13;
        r3 = r12;
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.database.provider.ScanHistory.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int i = 0;
        int match = f346l.match(uri);
        if (match != -1) {
            int i2;
            SQLiteDatabase writableDatabase = this.f347m.getWritableDatabase();
            switch (match) {
                case C0519c.Switch_track /*1*/:
                    delete(Uri.withAppendedPath(f336b, uri.getLastPathSegment()), str, strArr);
                    if (ContentUris.parseId(insert(Uri.withAppendedPath(f336b, uri.getLastPathSegment()), contentValues)) <= 0) {
                        i2 = 0;
                        break;
                    }
                    i2 = 1;
                    break;
                case C0519c.Switch_textOn /*2*/:
                    if (writableDatabase != null) {
                        i = writableDatabase.update("scan", contentValues, str, strArr);
                        break;
                    }
                    break;
                case C0519c.Switch_textOff /*3*/:
                    i2 = 0;
                    break;
                case C0519c.Switch_thumbTextPadding /*4*/:
                    if (writableDatabase != null) {
                        i = writableDatabase.update("scan_time", contentValues, str, strArr);
                        break;
                    }
                    break;
                default:
                    i = -1;
                    break;
            }
            i = writableDatabase != null ? writableDatabase.update("scan", contentValues, "scan._id = ?", new String[]{uri.getLastPathSegment()}) : i2;
            if (i > 0) {
                Context context = getContext();
                if (context != null) {
                    context.getContentResolver().notifyChange(uri, null);
                }
            }
        }
        return i;
    }
}
