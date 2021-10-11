package com.nxp.taginfolite.ndef.p023a;

import android.content.Context;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.support.v4.view.MotionEventCompat;
import com.nxp.taginfolite.ndef.C0448a;
import com.nxp.taginfolite.ndef.C0453f;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0358k;
import java.util.Arrays;
import java.util.HashMap;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.ndef.a.g */
public final class C0437g extends C0433i {
    private static HashMap f1367a;

    static {
        f1367a = null;
        f1367a = new HashMap();
        f1367a.put("cr", C0453f.Hr_cr);
        f1367a.put("ac", C0453f.Hr_ac);
        f1367a.put("err", C0453f.Hr_err);
    }

    private void m1427d(Context context, byte[] bArr, String str, StringBuilder stringBuilder) {
        stringBuilder.append(str).append(String.format("version: %d.%d\n", new Object[]{Integer.valueOf((bArr[0] >> 4) & 15), Integer.valueOf(bArr[0] & 15)}));
        try {
            m1422a(context, new NdefMessage(Arrays.copyOfRange(bArr, 1, bArr.length)), str + "\t", stringBuilder);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void m1428a(Context context, NdefRecord ndefRecord, String str, StringBuilder stringBuilder) {
        byte[] payload = ndefRecord.getPayload();
        C0453f a = C0433i.m1421a(ndefRecord, f1367a);
        C0448a.m1453a(a.toString(), str, stringBuilder);
        C0448a.m1452a(ndefRecord, str, stringBuilder);
        switch (C0438h.f1368a[a.ordinal()]) {
            case C0519c.Switch_track /*1*/:
                m1431b(payload, str, stringBuilder);
            case C0519c.Switch_textOn /*2*/:
                m1433c(payload, str, stringBuilder);
            case C0519c.Switch_textOff /*3*/:
                m1434d(payload, str, stringBuilder);
            default:
                C0448a.m1459c(payload, str, stringBuilder);
        }
    }

    public void m1429a(byte[] bArr, String str, StringBuilder stringBuilder) {
        stringBuilder.append(str).append("carrier type format: ");
        switch (bArr[0] & 7) {
            case C0519c.Switch_track /*1*/:
                stringBuilder.append("NFC Forum well-known type\n");
                break;
            case C0519c.Switch_textOn /*2*/:
                stringBuilder.append("MIME type (RFC2046)\n");
                break;
            case C0519c.Switch_textOff /*3*/:
                stringBuilder.append("URI type (RFC3986)\n");
                break;
            case C0519c.Switch_thumbTextPadding /*4*/:
                stringBuilder.append("NFC Forum external type\n");
                break;
            default:
                stringBuilder.append(String.format("[unknown] (0x%02X)\n", new Object[]{Integer.valueOf(bArr[0] & 7)}));
                break;
        }
        stringBuilder.append(str).append("carrier data: ").append(C0429j.m1391a(new String(bArr, 2, bArr[1] & MotionEventCompat.ACTION_MASK, C0429j.f1360a)));
    }

    public void m1430b(Context context, byte[] bArr, String str, StringBuilder stringBuilder) {
        m1427d(context, bArr, str, stringBuilder);
    }

    public void m1431b(byte[] bArr, String str, StringBuilder stringBuilder) {
        stringBuilder.append(str).append(C0358k.f1076c + "carrier power state: ");
        switch (bArr[0] & 3) {
            case C0519c.Switch_thumb /*0*/:
                stringBuilder.append("Inactive\n");
                break;
            case C0519c.Switch_track /*1*/:
                stringBuilder.append("Active\n");
                break;
            case C0519c.Switch_textOn /*2*/:
                stringBuilder.append("Activating\n");
                break;
            case C0519c.Switch_textOff /*3*/:
                stringBuilder.append("Unknown\n");
                break;
        }
        stringBuilder.append(str).append(C0358k.f1076c + "carrier data record: \"").append(C0429j.m1391a(new String(bArr, 2, bArr[1] & MotionEventCompat.ACTION_MASK, C0429j.f1360a))).append("\"");
        int i = (bArr[1] & MotionEventCompat.ACTION_MASK) + 2;
        int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
        if (i2 > 0) {
            int i3 = i + 1;
            for (int i4 = 0; i4 < i2 && i3 < bArr.length; i4++) {
                stringBuilder.append("\n").append(str).append(String.format(C0358k.f1076c + "auxiliary data record #%d: ", new Object[]{Integer.valueOf(i4)}));
                for (byte b = (byte) 0; b < bArr[i3]; b++) {
                    stringBuilder.append(C0429j.m1391a(new String(bArr, (i3 + b) + 1, 1, C0429j.f1360a)));
                }
                i3 += bArr[i3] + 1;
            }
            return;
        }
        stringBuilder.append("\n").append(str).append(C0358k.f1076c + "no auxiliary data records");
    }

    public void m1432c(Context context, byte[] bArr, String str, StringBuilder stringBuilder) {
        m1427d(context, bArr, str, stringBuilder);
    }

    public void m1433c(byte[] bArr, String str, StringBuilder stringBuilder) {
        stringBuilder.append(str).append(String.format(C0358k.f1076c + "random number: 0x%02X%02X", new Object[]{Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1])}));
    }

    public void m1434d(byte[] bArr, String str, StringBuilder stringBuilder) {
        stringBuilder.append(str).append(String.format(C0358k.f1076c + "reason: ", new Object[0]));
        switch (bArr[0] & MotionEventCompat.ACTION_MASK) {
            case C0519c.Switch_thumb /*0*/:
                stringBuilder.append("Reserved\n");
                break;
            case C0519c.Switch_track /*1*/:
                stringBuilder.append("Temporary memory restraints\n");
                break;
            case C0519c.Switch_textOn /*2*/:
                stringBuilder.append("Permanent memory restraints\n");
                break;
            case C0519c.Switch_textOff /*3*/:
                stringBuilder.append("Carrier-specific restraints\n");
                break;
            default:
                stringBuilder.append(String.format("[unknown] (0x%02X)\n", new Object[]{Byte.valueOf(bArr[0])}));
                break;
        }
        stringBuilder.append(str).append(String.format(C0358k.f1076c + "data: ", new Object[0]));
        switch (bArr[0] & MotionEventCompat.ACTION_MASK) {
            case C0519c.Switch_track /*1*/:
            case C0519c.Switch_textOff /*3*/:
                stringBuilder.append(String.format("Repeat after %d msec", new Object[]{Integer.valueOf(bArr[1] & MotionEventCompat.ACTION_MASK)}));
            case C0519c.Switch_textOn /*2*/:
                Object[] objArr = new Object[1];
                objArr[0] = Long.valueOf(C0429j.m1390a(bArr[1], bArr[2], bArr[3], bArr[3]));
                stringBuilder.append(String.format("Maximum message size: %d bytes", objArr));
            default:
                stringBuilder.append(String.format("[unknown] (0x%02X)\n", new Object[]{Byte.valueOf(bArr[0])}));
        }
    }
}
