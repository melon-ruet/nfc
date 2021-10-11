package com.nxp.taginfolite.database.p008b;

import android.net.Uri;
import com.nxp.taginfolite.database.provider.Lookup;

/* renamed from: com.nxp.taginfolite.database.b.b */
public class C0219b {
    public static final Uri f259a;
    public static final Uri f260b;

    static {
        f259a = Uri.withAppendedPath(Lookup.f332a, "blz");
        f260b = Uri.withAppendedPath(f259a, "#");
    }
}
