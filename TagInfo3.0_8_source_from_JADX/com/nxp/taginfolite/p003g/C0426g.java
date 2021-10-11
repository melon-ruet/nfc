package com.nxp.taginfolite.p003g;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.R;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.nxp.taginfolite.g.g */
public class C0426g {
    public static ByteArrayOutputStream m1373a(Context context, Uri uri) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (uri == null) {
            C0196b.m180a(context, (int) R.string.toast_no_file_error);
        } else {
            String scheme = uri.getScheme();
            try {
                InputStream b;
                if ("content".equals(scheme)) {
                    b = C0426g.m1376b(context, uri);
                } else if ("file".equals(scheme)) {
                    b = C0426g.m1375a(uri);
                } else {
                    Object obj = byteArrayOutputStream;
                }
                if (b == null) {
                    C0196b.m180a(context, (int) R.string.toast_file_read_error);
                } else {
                    try {
                        byteArrayOutputStream = C0426g.m1374a(b);
                    } catch (IOException e) {
                        C0196b.m180a(context, (int) R.string.toast_file_read_error);
                    }
                }
            } catch (FileNotFoundException e2) {
                C0196b.m180a(context, (int) R.string.toast_file_open_error);
            } catch (SecurityException e3) {
                C0196b.m180a(context, (int) R.string.toast_file_permission_error);
            } catch (Exception e4) {
                Log.v("TI_ReadFile", "Exception: " + e4.getMessage());
                C0196b.m180a(context, (int) R.string.toast_file_access_error);
            }
        }
        return byteArrayOutputStream;
    }

    public static ByteArrayOutputStream m1374a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int read = inputStream.read();
            while (read != -1) {
                byteArrayOutputStream.write(read);
                read = inputStream.read();
            }
            inputStream.close();
            return byteArrayOutputStream;
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            inputStream.close();
        }
    }

    public static FileInputStream m1375a(Uri uri) {
        return new FileInputStream(uri.getPath());
    }

    public static InputStream m1376b(Context context, Uri uri) {
        return context.getContentResolver().openInputStream(uri);
    }
}
