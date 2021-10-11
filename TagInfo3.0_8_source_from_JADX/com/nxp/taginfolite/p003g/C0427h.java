package com.nxp.taginfolite.p003g;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.nxp.taginfolite.g.h */
public class C0427h {
    private boolean f1354a;
    private boolean f1355b;
    private boolean f1356c;

    public C0427h() {
        this.f1354a = false;
        this.f1355b = false;
        this.f1356c = false;
        m1379a();
    }

    public Uri m1377a(Context context, byte[] bArr, String str) {
        FileOutputStream fileOutputStream;
        Throwable th;
        File a = m1378a(context, str);
        if (a == null) {
            return null;
        }
        if (m1381c()) {
            FileOutputStream fileOutputStream2;
            try {
                fileOutputStream2 = new FileOutputStream(a);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e) {
                            C0196b.m180a(context, (int) R.string.toast_file_write_error);
                            return null;
                        }
                    }
                    return Uri.fromFile(a);
                } catch (FileNotFoundException e2) {
                    try {
                        C0196b.m180a(context, (int) R.string.toast_file_write_error);
                        if (fileOutputStream2 != null) {
                            return null;
                        }
                        try {
                            fileOutputStream2.close();
                            return null;
                        } catch (IOException e3) {
                            C0196b.m180a(context, (int) R.string.toast_file_write_error);
                            return null;
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        fileOutputStream = fileOutputStream2;
                        th = th3;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                C0196b.m180a(context, (int) R.string.toast_file_write_error);
                                return null;
                            }
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    C0196b.m180a(context, (int) R.string.toast_file_write_error);
                    if (fileOutputStream2 != null) {
                        return null;
                    }
                    try {
                        fileOutputStream2.close();
                        return null;
                    } catch (IOException e6) {
                        C0196b.m180a(context, (int) R.string.toast_file_write_error);
                        return null;
                    }
                }
            } catch (FileNotFoundException e7) {
                fileOutputStream2 = null;
                C0196b.m180a(context, (int) R.string.toast_file_write_error);
                if (fileOutputStream2 != null) {
                    return null;
                }
                fileOutputStream2.close();
                return null;
            } catch (IOException e8) {
                fileOutputStream2 = null;
                C0196b.m180a(context, (int) R.string.toast_file_write_error);
                if (fileOutputStream2 != null) {
                    return null;
                }
                fileOutputStream2.close();
                return null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
        C0196b.m180a(context, (int) R.string.toast_file_write_error);
        return null;
    }

    public File m1378a(Context context, String str) {
        if (m1380b()) {
            return new File(context.getExternalFilesDir(null), str);
        }
        C0196b.m180a(context, (int) R.string.toast_usb_error);
        return null;
    }

    public void m1379a() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f1356c = true;
            this.f1355b = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f1355b = true;
            this.f1356c = false;
        } else {
            this.f1356c = false;
            this.f1355b = false;
        }
        this.f1354a = true;
    }

    public boolean m1380b() {
        if (!this.f1354a) {
            m1379a();
        }
        return this.f1355b;
    }

    public boolean m1381c() {
        if (!this.f1354a) {
            m1379a();
        }
        return this.f1356c;
    }
}
