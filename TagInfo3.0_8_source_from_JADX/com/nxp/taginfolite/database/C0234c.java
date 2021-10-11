package com.nxp.taginfolite.database;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.support.v4.BuildConfig;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.Toast;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.database.provider.ScanHistory;
import com.nxp.taginfolite.p000a.ae;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.nxp.taginfolite.database.c */
public class C0234c extends AsyncTask {
    private final FragmentActivity f289a;
    private String f290b;

    public C0234c(FragmentActivity fragmentActivity) {
        this.f290b = null;
        this.f289a = fragmentActivity;
    }

    private void m358a(ParcelFileDescriptor parcelFileDescriptor, File file) {
        FileChannel channel = new AutoCloseInputStream(parcelFileDescriptor).getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        Object channel2 = fileOutputStream.getChannel();
        try {
            channel.transferTo(0, channel.size(), channel2);
        } finally {
            if (channel != null) {
                channel.close();
            }
            if (channel2 != null) {
                channel2.close();
            }
            fileOutputStream.close();
        }
    }

    protected Boolean m359a(String... strArr) {
        try {
            ParcelFileDescriptor openFileDescriptor = this.f289a.getContentResolver().openFileDescriptor(ScanHistory.f338d, null);
            File file = new File(Environment.getExternalStorageDirectory(), BuildConfig.VERSION_NAME);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f290b = "TagInfo_Scans" + ("_" + new SimpleDateFormat("yyyyMMdd-HHmm").format(new Date()) + ".sqlite");
            File file2 = new File(file, this.f290b);
            try {
                file2.createNewFile();
                m358a(openFileDescriptor, file2);
                return Boolean.valueOf(true);
            } catch (Throwable e) {
                Log.e("ScanDatabaseExport", e.getMessage(), e);
                return Boolean.valueOf(false);
            }
        } catch (Exception e2) {
            return Boolean.valueOf(false);
        }
    }

    protected void m360a(Boolean bool) {
        Fragment findFragmentByTag = this.f289a.getSupportFragmentManager().findFragmentByTag("fragment_exporting");
        if (findFragmentByTag != null) {
            ((DialogFragment) findFragmentByTag).dismiss();
        }
        if (bool.booleanValue()) {
            Toast.makeText(this.f289a, this.f289a.getString(R.string.toast_export_ok) + " " + this.f290b, 0).show();
        } else {
            C0196b.m180a(this.f289a, (int) R.string.toast_export_failed);
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m359a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m360a((Boolean) obj);
    }

    protected void onPreExecute() {
        FragmentManager supportFragmentManager = this.f289a.getSupportFragmentManager();
        ae aeVar = new ae();
        Bundle bundle = new Bundle();
        bundle.putInt("TI_ProgressDialogtext", R.string.dialog_exporting);
        aeVar.setArguments(bundle);
        aeVar.show(supportFragmentManager, "fragment_exporting");
    }
}
