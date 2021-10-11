package com.nxp.taginfolite.data;

import android.content.Context;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.support.v4.BuildConfig;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.ndef.C0448a;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p005b.C0182c;
import com.nxp.taginfolite.p005b.C0188i;
import com.nxp.taginfolite.p005b.C0193o;
import com.nxp.taginfolite.p009e.ag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.nxp.taginfolite.data.e */
public class C0211e {
    private List f237a;
    private String f238b;
    private String f239c;
    private String f240d;
    private String f241e;
    private NdefMessage[] f242f;

    public C0211e(Context context, C0210d c0210d, String str) {
        int i;
        this.f237a = null;
        this.f238b = null;
        this.f239c = null;
        this.f240d = null;
        this.f241e = null;
        this.f242f = null;
        this.f242f = c0210d.m294j();
        this.f237a = new ArrayList();
        NdefMessage[] j = c0210d.m294j();
        if (j != null) {
            if (j.length > 0) {
                i = 0;
                for (NdefMessage ndefMessage : j) {
                    if (ndefMessage != null) {
                        NdefRecord[] records = ndefMessage.getRecords();
                        i += records.length;
                        Collections.addAll(this.f237a, records);
                    }
                }
            } else {
                this.f237a.add(null);
                i = 0;
            }
            this.f240d = null;
        } else if (c0210d.m292h() != null) {
            if (c0210d.m295k()) {
                this.f240d = context.getString(R.string.ndef_malformed_ndef_message);
                i = 0;
            } else {
                this.f240d = context.getString(R.string.ndef_no_ndef_message);
                i = 0;
            }
        } else if (c0210d.m293i() != null) {
            if (C0208b.m280a(str) > 0) {
                this.f240d = context.getString(R.string.ndef_no_ndef_present);
                this.f241e = String.format("Maximum NDEF storage size after format: %d bytes", new Object[]{Integer.valueOf(i)});
            } else {
                this.f240d = context.getString(R.string.ndef_no_ndef_support);
            }
            i = 0;
        } else {
            C0158a a = C0158a.m29a();
            if (!a.m68z() && ag.m457a(str)) {
                this.f240d = context.getString(R.string.ndef_no_ndef_message);
                if (ag.m462b(str)) {
                    this.f241e = context.getString(R.string.ndef_no_nxp_mifare_support);
                    i = 0;
                } else {
                    this.f241e = context.getString(R.string.ndef_no_mifare_support);
                    i = 0;
                }
            } else if (a.m58p()) {
                this.f240d = context.getString(R.string.ndef_check_skipped);
                i = 0;
            } else {
                this.f240d = context.getString(R.string.ndef_no_ndef_support);
                i = 0;
            }
        }
        this.f238b = context.getString(R.string.title_ndef_info);
        if (c0210d.m285b() >= 0 && c0210d.m287c() >= 0 && c0210d.m291g() != null) {
            C0428i c0428i = new C0428i();
            String str2 = "NDEF message containing %d record%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = i != 1 ? "s" : BuildConfig.VERSION_NAME;
            c0428i.m1384a(String.format(str2, objArr));
            c0428i.m1387b(context.getString(R.string.ndef_current_size));
            c0428i.m1384a(String.format(": %d bytes", new Object[]{Integer.valueOf(c0210d.m285b())}));
            c0428i.m1387b(context.getString(R.string.ndef_max_size));
            c0428i.m1384a(String.format(": %d bytes", new Object[]{Integer.valueOf(c0210d.m287c())}));
            c0428i.m1387b(context.getString(R.string.ndef_access));
            c0428i.m1387b(": ");
            c0428i.m1384a(c0210d.m291g());
            if (c0210d.m288d()) {
                c0428i.m1384a(context.getString(R.string.ndef_make_read_only));
            }
            this.f239c = c0428i.toString();
        } else if (c0210d.m285b() > 0) {
            this.f239c = context.getString(R.string.ndef_current_size) + String.format(": %d bytes", new Object[]{Integer.valueOf(c0210d.m285b())});
        }
    }

    public CharSequence m296a(Context context) {
        return m297a(context, "\t\t<subsection title=\"", "\">\n", "\t\t\t", "\n\t\t</subsection>\n");
    }

    protected String m297a(Context context, String str, String str2, String str3, String str4) {
        int i = 0;
        C0193o c0193o = new C0193o(BuildConfig.VERSION_NAME);
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        if (this.f240d != null) {
            stringBuilder.append(str);
            stringBuilder.append(C0429j.m1391a(this.f240d));
            stringBuilder.append(str2);
            if (this.f241e == null) {
                stringBuilder.append(str3);
                stringBuilder.append(c0193o.m173a());
                stringBuilder.append(str4);
            } else {
                stringBuilder.append(str3);
                stringBuilder.append(new C0193o(this.f241e).m173a());
                stringBuilder.append(str4);
            }
        } else {
            String a = C0429j.m1391a(this.f238b);
            stringBuilder.append(str);
            stringBuilder.append(a);
            stringBuilder.append(str2);
            C0193o c0193o2 = this.f239c != null ? new C0193o(this.f239c) : new C0193o("No information retrievable");
            stringBuilder.append(str3);
            stringBuilder.append(c0193o2.m173a());
            stringBuilder.append(str4);
            int size = this.f237a.size() + (this.f239c != null ? 1 : 0);
            for (int i2 = 0; i2 < size - 1; i2++) {
                NdefRecord ndefRecord = (NdefRecord) this.f237a.get(i2);
                if (ndefRecord != null) {
                    stringBuilder.append(str);
                    stringBuilder.append("Record #");
                    stringBuilder.append(Integer.toString(i2 + 1));
                    stringBuilder.append(": ");
                    stringBuilder.append(C0429j.m1391a(C0448a.m1451a(ndefRecord)));
                    stringBuilder.append(" record");
                    stringBuilder.append(str2);
                    stringBuilder.append(str3);
                    stringBuilder.append(new C0193o(C0448a.m1460d(ndefRecord)).m173a());
                    stringBuilder.append(C0448a.m1448a(context, ndefRecord).m151b());
                    stringBuilder.append(str4);
                } else {
                    stringBuilder.append(str);
                    stringBuilder.append(C0429j.m1391a(context.getString(R.string.ndef_no_ndef_message)));
                    stringBuilder.append(str2);
                    stringBuilder.append(str3);
                    stringBuilder.append(c0193o.m173a());
                    stringBuilder.append(str4);
                }
            }
            byte[] bArr = new byte[0];
            if (this.f242f != null && this.f242f.length > 0) {
                NdefMessage[] ndefMessageArr = this.f242f;
                int length = ndefMessageArr.length;
                while (i < length) {
                    bArr = C0429j.m1398a(bArr, ndefMessageArr[i].toByteArray());
                    i++;
                }
            }
            C0182c a2 = C0188i.m162a(bArr);
            if (!a2.m150a().isEmpty()) {
                stringBuilder.append(str);
                stringBuilder.append(C0429j.m1391a(context.getString(R.string.ndef_message_hex)));
                stringBuilder.append(str2);
                stringBuilder.append(str3);
                stringBuilder.append(a2.m151b());
                stringBuilder.append(str4);
            }
        }
        return stringBuilder.toString();
    }
}
