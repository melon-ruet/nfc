package com.nxp.taginfolite.fragments.p021c;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow.OnDismissListener;

/* renamed from: com.nxp.taginfolite.fragments.c.b */
class C0391b implements OnDismissListener {
    final /* synthetic */ C0390a f1286a;

    C0391b(C0390a c0390a) {
        this.f1286a = c0390a;
    }

    public void onDismiss() {
        if (this.f1286a.f1276d != null) {
            this.f1286a.f1276d = null;
            ViewTreeObserver viewTreeObserver = this.f1286a.f1274b.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f1286a.f1285m);
            }
        }
    }
}
