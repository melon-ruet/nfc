package com.nxp.taginfolite.ndef.p023a;

import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import com.nxp.taginfolite.ndef.C0453f;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;

/* renamed from: com.nxp.taginfolite.ndef.a.p */
public class C0445p {
    private static boolean m1442a(C0453f c0453f) {
        return c0453f == C0453f.text_vCard || c0453f == C0453f.text_x_vCard;
    }

    public void m1443a(byte[] bArr, String str, StringBuilder stringBuilder, C0453f c0453f) {
        int length;
        int i = 0;
        int length2 = bArr.length;
        while (true) {
            if (bArr[length2 - 1] != 10 && bArr[length2 - 1] != 13 && bArr[length2 - 1] != null) {
                break;
            }
            length2--;
        }
        String[] split = new String(bArr, 0, length2, C0429j.f1361b).split("[\\n\\r]+");
        C0428i c0428i = new C0428i();
        for (String replaceFirst : split) {
            c0428i.m1384a(replaceFirst.replaceFirst(":", ": "));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + C0429j.m1391a(c0428i.toString()));
        if (C0445p.m1442a(c0453f)) {
            Linkify.addLinks(spannableStringBuilder, 15);
        }
        Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Object.class);
        if (spans != null) {
            length = spans.length;
            while (i < length) {
                Object obj = spans[i];
                int spanStart = spannableStringBuilder.getSpanStart(obj);
                int spanEnd = spannableStringBuilder.getSpanEnd(obj);
                if (obj instanceof URLSpan) {
                    obj = "<url link=\"" + ((URLSpan) obj).getURL() + "\">";
                    spannableStringBuilder.insert(spanStart, obj);
                    spannableStringBuilder.insert(obj.length() + spanEnd, "</url>");
                }
                i++;
            }
        }
        stringBuilder.append(spannableStringBuilder.toString());
    }
}
