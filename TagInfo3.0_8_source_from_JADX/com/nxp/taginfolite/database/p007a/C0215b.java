package com.nxp.taginfolite.database.p007a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.Log;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.database.C0217a;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/* renamed from: com.nxp.taginfolite.database.a.b */
public class C0215b extends SQLiteOpenHelper {
    private String f254a;

    public C0215b(Context context) {
        super(context, context.getDatabasePath("TagInfo_data").getPath(), null, 1);
        this.f254a = null;
        this.f254a = context.getDatabasePath("TagInfo_data").getPath();
    }

    public static String m314a(InputStream inputStream) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD];
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        instance.update(bArr, 0, read);
                    } else {
                        String bigInteger = new BigInteger(1, instance.digest()).toString(16);
                        bigInteger = String.format("%32s", new Object[]{bigInteger}).replace(' ', '0');
                        try {
                            inputStream.close();
                            return bigInteger;
                        } catch (Throwable e) {
                            Log.e("TagInfo_LookupHelper", "Exception on closing MD5 input stream", e);
                            return bigInteger;
                        }
                    }
                } catch (Throwable e2) {
                    throw new RuntimeException("Unable to process file for MD5", e2);
                } catch (Throwable th) {
                    try {
                        inputStream.close();
                    } catch (Throwable e3) {
                        Log.e("TagInfo_LookupHelper", "Exception on closing MD5 input stream", e3);
                    }
                }
            }
        } catch (Throwable e22) {
            Log.e("TagInfo_LookupHelper", "Exception while getting Digest", e22);
            return null;
        }
    }

    private boolean m315a() {
        SQLiteDatabase sQLiteDatabase = null;
        boolean z = true;
        try {
            sQLiteDatabase = SQLiteDatabase.openDatabase(this.f254a, null, 1);
            sQLiteDatabase.close();
        } catch (SQLiteException e) {
        }
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
            if (!m318b()) {
                return false;
            }
        }
        if (sQLiteDatabase == null) {
            z = false;
        }
        return z;
    }

    public static boolean m316a(String str, InputStream inputStream) {
        if (TextUtils.isEmpty(str) || inputStream == null) {
            Log.e("TagInfo_LookupHelper", "MD5 String NULL or UpdateFile NULL");
            return false;
        }
        String a = C0215b.m314a(inputStream);
        if (a != null) {
            return a.equalsIgnoreCase(str);
        }
        Log.e("TagInfo_LookupHelper", "calculatedDigest NULL");
        return false;
    }

    private void m317b(Context context) {
        OutputStream fileOutputStream = new FileOutputStream(this.f254a);
        for (int openRawResource : new int[]{R.raw.data_00}) {
            InputStream openRawResource2 = context.getResources().openRawResource(openRawResource);
            byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
            while (true) {
                int read = openRawResource2.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            openRawResource2.close();
        }
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    private boolean m318b() {
        try {
            return C0215b.m316a(C0217a.f256a, new FileInputStream(this.f254a));
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public void m319a(Context context) {
        if (!m315a()) {
            getReadableDatabase();
            try {
                m317b(context);
            } catch (IOException e) {
                Log.e("TagInfo_LookupHelper", "Error copying database: " + e.getMessage());
            }
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
