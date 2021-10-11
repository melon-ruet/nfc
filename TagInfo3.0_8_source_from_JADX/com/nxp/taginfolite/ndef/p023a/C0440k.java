package com.nxp.taginfolite.ndef.p023a;

import android.content.Context;
import android.support.v4.BuildConfig;
import com.nxp.taginfolite.p003g.C0429j;

/* renamed from: com.nxp.taginfolite.ndef.a.k */
public final class C0440k extends C0433i {
    public void m1435a(Context context, byte[] bArr, String str, StringBuilder stringBuilder) {
        int i = 1;
        String str2 = new String(bArr, C0429j.f1360a);
        String str3 = "?q=";
        str3 = "0,0?q=";
        if (!str2.contains("?q=")) {
            String[] split = str2.split(",");
            if (split != null && split.length >= 2) {
                Float valueOf = Float.valueOf(split[0]);
                CharSequence replace = split[0].replace("+", BuildConfig.VERSION_NAME).replace("-", BuildConfig.VERSION_NAME);
                Float valueOf2 = Float.valueOf(split[1]);
                CharSequence replace2 = split[1].replace("+", BuildConfig.VERSION_NAME).replace("-", BuildConfig.VERSION_NAME);
                if (split.length <= 2) {
                    i = 0;
                }
                stringBuilder.append(str).append("latitude: ").append(C0429j.m1391a(replace)).append("\u200a").append(valueOf.floatValue() > 0.0f ? "N" : "S").append("\n");
                stringBuilder.append(str).append("longitude: ").append(C0429j.m1391a(replace2)).append("\u200a").append(valueOf2.floatValue() > 0.0f ? 'E' : 'W');
                if (i != 0) {
                    stringBuilder.append(str).append("\naltitude: ").append(C0429j.m1391a(split[2])).append("\u200a").append("m");
                }
            }
        } else if (str2.startsWith("0,0?q=")) {
            stringBuilder.append(str).append("address: \"").append(C0429j.m1391a(str2.substring(6).replace('+', ' '))).append("\"");
        }
    }
}
