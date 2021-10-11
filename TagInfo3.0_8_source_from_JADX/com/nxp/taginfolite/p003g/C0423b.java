package com.nxp.taginfolite.p003g;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.p000a.C0132a;
import com.nxp.taginfolite.p000a.C0134c;
import java.io.File;
import java.util.Arrays;

/* renamed from: com.nxp.taginfolite.g.b */
public class C0423b implements C0134c {
    private File f1346a;
    private String[] f1347b;
    private OnClickListener f1348c;

    public C0423b() {
        this.f1346a = null;
        this.f1347b = null;
        this.f1348c = null;
    }

    private void m1365a(FragmentManager fragmentManager, String str, OnClickListener onClickListener) {
        m1367a(this.f1346a, str);
        Arrays.sort(this.f1347b);
        this.f1348c = onClickListener;
        C0132a c0132a = new C0132a();
        Bundle bundle = new Bundle();
        bundle.putStringArray("TI_ChooseFilefiles", this.f1347b);
        c0132a.setArguments(bundle);
        c0132a.m17a((C0134c) this);
        c0132a.show(fragmentManager, "fragment_choose_file");
    }

    private void m1367a(File file, String str) {
        try {
            file.mkdirs();
        } catch (SecurityException e) {
        }
        if (!file.exists()) {
            this.f1347b = new String[0];
        }
        this.f1347b = file.list(new C0425d(this, str));
    }

    private void m1369c(FragmentActivity fragmentActivity, String str) {
        this.f1346a = Environment.getExternalStorageDirectory();
        m1365a(fragmentActivity.getSupportFragmentManager(), str, new C0424c(this, fragmentActivity, str));
    }

    public OnClickListener m1370a() {
        return this.f1348c;
    }

    @SuppressLint({"NewApi"})
    public void m1371a(FragmentActivity fragmentActivity, String str) {
        String str2 = "*/*";
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        try {
            fragmentActivity.startActivityForResult(intent, 41);
        } catch (ActivityNotFoundException e) {
            m1372b(fragmentActivity, str);
        } catch (SecurityException e2) {
            m1372b(fragmentActivity, str);
        }
    }

    void m1372b(FragmentActivity fragmentActivity, String str) {
        Intent intent = new Intent("org.openintents.action.PICK_FILE");
        intent.putExtra("org.openintents.extra.TITLE", fragmentActivity.getString(R.string.dialog_file_title));
        intent.putExtra("org.openintents.extra.BUTTON_TEXT", fragmentActivity.getString(R.string.dialog_file_button));
        try {
            fragmentActivity.startActivityForResult(intent, 42);
        } catch (ActivityNotFoundException e) {
            m1369c(fragmentActivity, str);
        }
    }
}
