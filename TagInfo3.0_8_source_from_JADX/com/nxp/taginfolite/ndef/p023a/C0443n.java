package com.nxp.taginfolite.ndef.p023a;

import android.content.Context;
import android.nfc.NdefRecord;
import android.support.v4.view.MotionEventCompat;
import com.nxp.taginfolite.ndef.C0448a;
import com.nxp.taginfolite.ndef.C0453f;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0358k;
import java.util.HashMap;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.ndef.a.n */
public final class C0443n extends C0433i {
    private static HashMap f1370a;

    static {
        f1370a = null;
        f1370a = new HashMap();
        f1370a.put("act", C0453f.Sp_act);
        f1370a.put("s", C0453f.Sp_s);
        f1370a.put("t", C0453f.Sp_t);
    }

    public void m1441a(Context context, NdefRecord ndefRecord, String str, StringBuilder stringBuilder) {
        byte[] payload = ndefRecord.getPayload();
        C0453f a = C0433i.m1421a(ndefRecord, f1370a);
        C0448a.m1453a(a.toString(), str, stringBuilder);
        C0448a.m1452a(ndefRecord, str, stringBuilder);
        switch (C0444o.f1371a[a.ordinal()]) {
            case C0519c.Switch_track /*1*/:
                C0448a.m1457b(payload, str + C0358k.f1076c, stringBuilder);
            case C0519c.Switch_textOn /*2*/:
                C0448a.m1455a(payload, str + C0358k.f1076c, stringBuilder);
            case C0519c.Switch_textOff /*3*/:
                stringBuilder.append(str);
                stringBuilder.append(C0358k.f1076c).append("action: ");
                switch (payload[0] & MotionEventCompat.ACTION_MASK) {
                    case C0519c.Switch_thumb /*0*/:
                        stringBuilder.append("Do the action");
                        break;
                    case C0519c.Switch_track /*1*/:
                        stringBuilder.append("Save for later");
                        break;
                    case C0519c.Switch_textOn /*2*/:
                        stringBuilder.append("Open for editing");
                        break;
                    default:
                        stringBuilder.append("Unknown");
                        break;
                }
                stringBuilder.append(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(r0)}));
            case C0519c.Switch_thumbTextPadding /*4*/:
                stringBuilder.append(str);
                String str2 = C0358k.f1076c + "size: %d";
                Object[] objArr = new Object[1];
                objArr[0] = Long.valueOf(C0429j.m1390a(payload[0], payload[1], payload[2], payload[3]));
                stringBuilder.append(String.format(str2, objArr));
            case C0519c.Switch_switchTextAppearance /*5*/:
                stringBuilder.append(str);
                stringBuilder.append(C0358k.f1076c).append("type: ");
                stringBuilder.append(C0429j.m1391a(new String(payload, C0429j.f1361b)));
            default:
                C0448a.m1459c(payload, str, stringBuilder);
        }
    }
}
