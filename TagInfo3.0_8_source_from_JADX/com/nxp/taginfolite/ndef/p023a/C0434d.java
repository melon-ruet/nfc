package com.nxp.taginfolite.ndef.p023a;

import android.content.Context;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.support.v4.view.MotionEventCompat;
import com.nxp.taginfolite.ndef.C0448a;
import com.nxp.taginfolite.ndef.C0453f;
import com.nxp.taginfolite.p004f.C0358k;
import java.util.Arrays;
import java.util.HashMap;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.ndef.a.d */
public final class C0434d extends C0433i {
    private static final HashMap f1365a;

    static {
        f1365a = new C0435e();
    }

    public void m1425a(Context context, NdefRecord ndefRecord, String str, StringBuilder stringBuilder) {
        int i = 0;
        byte[] payload = ndefRecord.getPayload();
        C0453f a = C0433i.m1421a(ndefRecord, f1365a);
        C0448a.m1453a(a.toString(), str, stringBuilder);
        C0448a.m1452a(ndefRecord, str, stringBuilder);
        NdefRecord[] records;
        int length;
        switch (C0436f.f1366a[a.ordinal()]) {
            case C0519c.Switch_track /*1*/:
                C0448a.m1457b(payload, str + C0358k.f1076c, stringBuilder);
            case C0519c.Switch_textOn /*2*/:
                C0448a.m1455a(payload, str + C0358k.f1076c, stringBuilder);
            case C0519c.Switch_textOff /*3*/:
                try {
                    m1422a(context, new NdefMessage(payload), str + "\t", stringBuilder);
                } catch (Throwable e) {
                    throw new IllegalArgumentException(e);
                }
            case C0519c.Switch_thumbTextPadding /*4*/:
                stringBuilder.append(str).append(C0358k.f1076c + "action flag:");
                if ((payload[0] & 1) != 0) {
                    stringBuilder.append(" NC");
                } else {
                    stringBuilder.append(" NDEF record");
                }
                if ((payload[0] & 254) != 0) {
                    stringBuilder.append(String.format(" [invalid] 0x%02X", new Object[]{Byte.valueOf(payload[0])}));
                }
                stringBuilder.append("\n");
                if ((payload[0] & 1) != 0) {
                    int i2 = payload[1] & MotionEventCompat.ACTION_MASK;
                    stringBuilder.append(str).append(C0358k.f1076c + "numeric code: ");
                    switch (i2) {
                        case C0519c.Switch_thumb /*0*/:
                            stringBuilder.append("Default action");
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
                    stringBuilder.append(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(i2)}));
                    return;
                }
                try {
                    records = new NdefMessage(Arrays.copyOfRange(payload, 1, payload.length)).getRecords();
                    length = records.length;
                    while (i < length) {
                        stringBuilder.append(C0448a.m1449a(context, records[i], str + "\t").m149a(context, true));
                        i++;
                    }
                } catch (Throwable e2) {
                    throw new IllegalArgumentException(e2);
                }
            case C0519c.Switch_switchTextAppearance /*5*/:
                try {
                    records = new NdefMessage(payload).getRecords();
                    length = records.length;
                    while (i < length) {
                        stringBuilder.append(C0448a.m1449a(context, records[i], str + "\t").m149a(context, true));
                        i++;
                    }
                } catch (Throwable e22) {
                    throw new IllegalArgumentException(e22);
                }
            default:
                C0448a.m1459c(payload, str, stringBuilder);
        }
    }

    public void m1426a(Context context, byte[] bArr, String str, StringBuilder stringBuilder) {
        stringBuilder.append(str).append("configuration:");
        if ((bArr[0] & 2) != 0) {
            stringBuilder.append(" SC");
        }
        if ((bArr[0] & 4) != 0) {
            stringBuilder.append(" EC");
        }
        if ((bArr[0] & 1) != 0 || (bArr[0] & 248) != 0) {
            stringBuilder.append(" [invalid]");
        } else if (bArr[0] == null) {
            stringBuilder.append(" [empty]");
        }
        stringBuilder.append(String.format("<hexoutput> (0x%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[0])}));
        stringBuilder.append("\n");
        try {
            m1422a(context, new NdefMessage(Arrays.copyOfRange(bArr, 1, bArr.length)), str + "\t", stringBuilder);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }
}
