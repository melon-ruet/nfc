package com.nxp.taginfolite.p003g;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri.Builder;
import android.support.v4.app.FragmentActivity;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.R;
import java.io.File;

/* renamed from: com.nxp.taginfolite.g.c */
class C0424c implements OnClickListener {
    final /* synthetic */ FragmentActivity f1349a;
    final /* synthetic */ String f1350b;
    final /* synthetic */ C0423b f1351c;

    C0424c(C0423b c0423b, FragmentActivity fragmentActivity, String str) {
        this.f1351c = c0423b;
        this.f1349a = fragmentActivity;
        this.f1350b = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        String str = this.f1351c.f1346a.getAbsolutePath() + "/" + this.f1351c.f1347b[i];
        File file = new File(str);
        if (!file.exists() || !file.canRead()) {
            C0196b.m180a(this.f1349a, (int) R.string.toast_file_read_error);
        } else if (file.isDirectory()) {
            this.f1351c.f1346a = file;
            dialogInterface.dismiss();
            this.f1351c.m1365a(this.f1349a.getSupportFragmentManager(), this.f1350b, this);
        } else {
            try {
                ((C0164e) this.f1349a).m97a(new Builder().scheme("file").path(str).build());
                dialogInterface.dismiss();
            } catch (ClassCastException e) {
                throw new ClassCastException("Activity must implement FileChooser.Callback");
            }
        }
    }
}
