package com.nxp.taginfolite.ndef.p023a;

import android.content.Context;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import com.nxp.taginfolite.ndef.C0448a;
import com.nxp.taginfolite.ndef.C0453f;
import com.nxp.taginfolite.p003g.C0429j;
import java.util.HashMap;

/* renamed from: com.nxp.taginfolite.ndef.a.i */
public class C0433i {
    private static HashMap f1364a;

    static {
        f1364a = null;
        f1364a = new HashMap();
    }

    public static C0453f m1421a(NdefRecord ndefRecord, HashMap hashMap) {
        String str = new String(ndefRecord.getType(), C0429j.f1360a);
        C0453f c0453f = null;
        if (hashMap != null) {
            c0453f = (C0453f) hashMap.get(str);
        }
        return c0453f == null ? C0448a.m1456b(ndefRecord) : c0453f;
    }

    public void m1422a(Context context, NdefMessage ndefMessage, String str, StringBuilder stringBuilder) {
        NdefRecord[] records = ndefMessage.getRecords();
        if (records != null) {
            for (int i = 0; i < records.length; i++) {
                if (i != 0) {
                    stringBuilder.append("\n");
                }
                NdefRecord ndefRecord = records[i];
                try {
                    m1423a(context, ndefRecord, str, stringBuilder);
                } catch (IllegalArgumentException e) {
                    C0448a.m1454a("\nError parsing NDEF embedded record\n", ndefRecord.getPayload(), str, stringBuilder);
                } catch (ArrayIndexOutOfBoundsException e2) {
                    C0448a.m1454a("\nError parsing NDEF record\n", ndefRecord.getPayload(), str, stringBuilder);
                } catch (StringIndexOutOfBoundsException e3) {
                    C0448a.m1454a("\nError parsing NDEF record\n", ndefRecord.getPayload(), str, stringBuilder);
                }
            }
        }
    }

    public void m1423a(Context context, NdefRecord ndefRecord, String str, StringBuilder stringBuilder) {
        byte[] payload = ndefRecord.getPayload();
        int i = C0439j.f1369a[C0433i.m1421a(ndefRecord, f1364a).ordinal()];
        C0448a.m1459c(payload, "\t" + str, stringBuilder);
    }

    public void m1424a(Context context, byte[] bArr, String str, StringBuilder stringBuilder) {
        try {
            m1422a(context, new NdefMessage(bArr), str + "\t", stringBuilder);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }
}
