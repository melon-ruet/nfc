package com.nxp.taginfolite.ndef.p023a;

import android.net.Uri;
import android.util.Base64;
import com.nxp.taginfolite.p003g.C0429j;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.nxp.taginfolite.ndef.a.a */
public class C0430a {
    public void m1414a(byte[] bArr, String str, StringBuilder stringBuilder) {
        CharSequence decode = Uri.decode(new String(bArr, C0429j.f1360a));
        if (decode != null && decode.startsWith("smarttriggers://?data=")) {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(decode.substring("smarttriggers://?data=".length()), 0), C0429j.f1360a));
                stringBuilder.append("JSON object:\n<mono>");
                stringBuilder.append(C0429j.m1391a(jSONObject.toString(2)));
                stringBuilder.append("</mono>");
            } catch (JSONException e) {
                stringBuilder.append("Data:\n");
                stringBuilder.append(str);
                stringBuilder.append("\"");
                stringBuilder.append(C0429j.m1391a(decode));
                stringBuilder.append("\"");
            }
        }
    }
}
