package com.nxp.taginfolite.p003g;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.nxp.taginfolite.g.d */
class C0425d implements FilenameFilter {
    final /* synthetic */ String f1352a;
    final /* synthetic */ C0423b f1353b;

    C0425d(C0423b c0423b, String str) {
        this.f1353b = c0423b;
        this.f1352a = str;
    }

    public boolean accept(File file, String str) {
        return str.endsWith(new StringBuilder().append(".").append(this.f1352a).toString()) || new File(file, str).isDirectory();
    }
}
