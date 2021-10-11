package com.nxp.taginfolite.ndef.p023a;

import com.nxp.taginfolite.p003g.C0429j;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.nxp.taginfolite.ndef.a.m */
public class C0442m {
    public void m1440a(byte[] bArr, String str, StringBuilder stringBuilder) {
        CharSequence str2 = new String(bArr, C0429j.f1360a);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            stringBuilder.append("JSON object:\n<mono>");
            stringBuilder.append(C0429j.m1391a(jSONObject.toString(2)));
            stringBuilder.append("</mono>");
        } catch (JSONException e) {
            stringBuilder.append("Text:\n");
            stringBuilder.append(str).append("\"").append(C0429j.m1391a(str2)).append("\"");
        }
    }
}
