package com.nxp.taginfolite.p005b;

import android.content.Context;

/* renamed from: com.nxp.taginfolite.b.o */
public class C0193o implements C0180a {
    private final CharSequence f138a;
    private final boolean f139b;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0193o(android.content.Context r30, org.xmlpull.v1.XmlPullParser r31) {
        /*
        r29 = this;
        r29.<init>();
        r23 = new android.text.SpannableStringBuilder;
        r23.<init>();
        r21 = 0;
        r20 = 0;
        r19 = r31.next();
        r18 = 0;
        r4 = com.nxp.taginfolite.C0158a.m29a();
        r24 = r4.m55m();
        r17 = -1;
        r16 = 0;
        r15 = -1;
        r14 = 0;
        r13 = -1;
        r12 = 0;
        r11 = 0;
        r9 = 0;
        r8 = -1;
        r7 = 0;
        r6 = 0;
        r5 = -1;
        r4 = 0;
        r10 = 0;
        r22 = r21;
        r21 = r18;
        r18 = r15;
        r15 = r11;
        r11 = r4;
        r4 = r9;
        r27 = r7;
        r7 = r20;
        r20 = r17;
        r17 = r14;
        r14 = r8;
        r8 = r12;
        r12 = r5;
        r5 = r27;
        r28 = r16;
        r16 = r13;
        r13 = r6;
        r6 = r19;
        r19 = r28;
    L_0x0049:
        if (r10 != 0) goto L_0x0464;
    L_0x004b:
        r9 = 1;
        if (r6 == r9) goto L_0x0464;
    L_0x004e:
        switch(r6) {
            case 2: goto L_0x0085;
            case 3: goto L_0x022f;
            case 4: goto L_0x043d;
            default: goto L_0x0051;
        };
    L_0x0051:
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
    L_0x0067:
        if (r10 != 0) goto L_0x0479;
    L_0x0069:
        r4 = r31.next();
    L_0x006d:
        r6 = r4;
        r4 = r12;
        r12 = r7;
        r7 = r21;
        r21 = r20;
        r20 = r19;
        r19 = r18;
        r18 = r17;
        r17 = r16;
        r16 = r15;
        r15 = r13;
        r13 = r8;
        r8 = r14;
        r14 = r11;
        r11 = r5;
        r5 = r9;
        goto L_0x0049;
    L_0x0085:
        r9 = r31.getName();
        r25 = "block";
        r0 = r25;
        r25 = r0.equalsIgnoreCase(r9);
        if (r25 == 0) goto L_0x0095;
    L_0x0093:
        r7 = r7 + 1;
    L_0x0095:
        r25 = "content";
        r0 = r25;
        r25 = r0.equalsIgnoreCase(r9);
        if (r25 == 0) goto L_0x00b8;
    L_0x009f:
        r22 = 1;
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
        goto L_0x0067;
    L_0x00b8:
        r25 = "hexoutput";
        r0 = r25;
        r25 = r0.equalsIgnoreCase(r9);
        if (r25 == 0) goto L_0x00db;
    L_0x00c2:
        r21 = 1;
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
        goto L_0x0067;
    L_0x00db:
        r25 = "mono";
        r0 = r25;
        r25 = r0.equalsIgnoreCase(r9);
        if (r25 == 0) goto L_0x0103;
    L_0x00e5:
        r19 = 1;
        r20 = r23.length();
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
        goto L_0x0067;
    L_0x0103:
        r25 = "b";
        r0 = r25;
        r25 = r0.equalsIgnoreCase(r9);
        if (r25 == 0) goto L_0x012b;
    L_0x010d:
        r17 = 1;
        r18 = r23.length();
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
        goto L_0x0067;
    L_0x012b:
        r25 = "aar";
        r0 = r25;
        r25 = r0.equalsIgnoreCase(r9);
        if (r25 == 0) goto L_0x0152;
    L_0x0135:
        r13 = 1;
        r12 = r23.length();
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
        goto L_0x0067;
    L_0x0152:
        r25 = "size";
        r0 = r25;
        r25 = r0.equalsIgnoreCase(r9);
        if (r25 == 0) goto L_0x0191;
    L_0x015c:
        r15 = 1;
        r16 = r23.length();
        r9 = 0;
        r25 = "size";
        r0 = r31;
        r1 = r25;
        r9 = r0.getAttributeValue(r9, r1);
        if (r9 == 0) goto L_0x0176;
    L_0x016e:
        r8 = r9.trim();	 Catch:{ NumberFormatException -> 0x018e }
        r8 = java.lang.Integer.parseInt(r8);	 Catch:{ NumberFormatException -> 0x018e }
    L_0x0176:
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
        goto L_0x0067;
    L_0x018e:
        r8 = move-exception;
        r8 = 0;
        goto L_0x0176;
    L_0x0191:
        r25 = "url";
        r0 = r25;
        r25 = r0.equalsIgnoreCase(r9);
        if (r25 == 0) goto L_0x01c1;
    L_0x019b:
        r11 = 1;
        r14 = r23.length();
        r4 = 0;
        r9 = "link";
        r0 = r31;
        r4 = r0.getAttributeValue(r4, r9);
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
        goto L_0x0067;
    L_0x01c1:
        r25 = "<";
        r0 = r23;
        r1 = r25;
        r0.append(r1);
        r0 = r23;
        r0.append(r9);
        r9 = 0;
    L_0x01d0:
        r25 = r31.getAttributeCount();
        r0 = r25;
        if (r9 >= r0) goto L_0x0210;
    L_0x01d8:
        r25 = " ";
        r0 = r23;
        r1 = r25;
        r0.append(r1);
        r0 = r31;
        r25 = r0.getAttributeName(r9);
        r0 = r23;
        r1 = r25;
        r0.append(r1);
        r25 = "=\"";
        r0 = r23;
        r1 = r25;
        r0.append(r1);
        r0 = r31;
        r25 = r0.getAttributeValue(r9);
        r0 = r23;
        r1 = r25;
        r0.append(r1);
        r25 = "\"";
        r0 = r23;
        r1 = r25;
        r0.append(r1);
        r9 = r9 + 1;
        goto L_0x01d0;
    L_0x0210:
        r9 = ">";
        r0 = r23;
        r0.append(r9);
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
        goto L_0x0067;
    L_0x022f:
        r9 = r31.getName();
        r25 = "block";
        r0 = r25;
        r25 = r0.equalsIgnoreCase(r9);
        if (r25 == 0) goto L_0x025b;
    L_0x023d:
        if (r7 != 0) goto L_0x0476;
    L_0x023f:
        r9 = 1;
    L_0x0240:
        r7 = r7 + -1;
        r10 = r9;
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
        goto L_0x0067;
    L_0x025b:
        r25 = "hexoutput";
        r0 = r25;
        r25 = r0.equalsIgnoreCase(r9);
        if (r25 == 0) goto L_0x027f;
    L_0x0265:
        r21 = 0;
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
        goto L_0x0067;
    L_0x027f:
        r25 = "mono";
        r0 = r25;
        r25 = r0.equalsIgnoreCase(r9);
        if (r25 == 0) goto L_0x02c2;
    L_0x0289:
        if (r19 == 0) goto L_0x02a8;
    L_0x028b:
        r9 = new android.text.style.TextAppearanceSpan;
        r19 = 2131558529; // 0x7f0d0081 float:1.8742376E38 double:1.0531298413E-314;
        r0 = r30;
        r1 = r19;
        r9.<init>(r0, r1);
        r19 = r23.length();
        r25 = 17;
        r0 = r23;
        r1 = r20;
        r2 = r19;
        r3 = r25;
        r0.setSpan(r9, r1, r2, r3);
    L_0x02a8:
        r19 = 0;
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
        goto L_0x0067;
    L_0x02c2:
        r25 = "b";
        r0 = r25;
        r25 = r0.equalsIgnoreCase(r9);
        if (r25 == 0) goto L_0x0302;
    L_0x02cc:
        if (r17 == 0) goto L_0x02e8;
    L_0x02ce:
        r9 = new android.text.style.StyleSpan;
        r17 = 1;
        r0 = r17;
        r9.<init>(r0);
        r17 = r23.length();
        r25 = 17;
        r0 = r23;
        r1 = r18;
        r2 = r17;
        r3 = r25;
        r0.setSpan(r9, r1, r2, r3);
    L_0x02e8:
        r17 = 0;
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
        goto L_0x0067;
    L_0x0302:
        r25 = "aar";
        r0 = r25;
        r25 = r0.equalsIgnoreCase(r9);
        if (r25 == 0) goto L_0x0342;
    L_0x030c:
        if (r13 == 0) goto L_0x0329;
    L_0x030e:
        r5 = r23.length();
        r0 = r23;
        r9 = r0.subSequence(r12, r5);
        r9 = r9.toString();
        r13 = new com.nxp.taginfolite.ndef.span.AarSpan;
        r13.<init>(r9);
        r9 = 17;
        r0 = r23;
        r0.setSpan(r13, r12, r5, r9);
        r5 = 1;
    L_0x0329:
        r13 = 0;
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
        goto L_0x0067;
    L_0x0342:
        r25 = "url";
        r0 = r25;
        r25 = r0.equalsIgnoreCase(r9);
        if (r25 == 0) goto L_0x0390;
    L_0x034c:
        if (r11 == 0) goto L_0x046f;
    L_0x034e:
        r5 = r23.length();
        r9 = android.text.TextUtils.isEmpty(r4);
        if (r9 == 0) goto L_0x0362;
    L_0x0358:
        r0 = r23;
        r4 = r0.subSequence(r14, r5);
        r4 = r4.toString();
    L_0x0362:
        r9 = new com.nxp.taginfolite.ndef.span.UrlSpan;
        r9.<init>(r4);
        r11 = 17;
        r0 = r23;
        r0.setSpan(r9, r14, r5, r11);
        r5 = 1;
        r27 = r5;
        r5 = r4;
        r4 = r27;
    L_0x0374:
        r11 = 0;
        r9 = r4;
        r27 = r12;
        r12 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r27;
        goto L_0x0067;
    L_0x0390:
        r25 = "size";
        r0 = r25;
        r25 = r0.equalsIgnoreCase(r9);
        if (r25 == 0) goto L_0x03df;
    L_0x039a:
        if (r15 == 0) goto L_0x03ba;
    L_0x039c:
        if (r8 <= 0) goto L_0x03ba;
    L_0x039e:
        r9 = 0;
        switch(r8) {
            case 12: goto L_0x03d3;
            case 13: goto L_0x03d7;
            case 14: goto L_0x03db;
            default: goto L_0x03a2;
        };
    L_0x03a2:
        if (r9 <= 0) goto L_0x03ba;
    L_0x03a4:
        r15 = new android.text.style.TextAppearanceSpan;
        r0 = r30;
        r15.<init>(r0, r9);
        r9 = r23.length();
        r25 = 17;
        r0 = r23;
        r1 = r16;
        r2 = r25;
        r0.setSpan(r15, r1, r9, r2);
    L_0x03ba:
        r15 = 0;
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
        goto L_0x0067;
    L_0x03d3:
        r9 = 2131558530; // 0x7f0d0082 float:1.8742378E38 double:1.053129842E-314;
        goto L_0x03a2;
    L_0x03d7:
        r9 = 2131558531; // 0x7f0d0083 float:1.874238E38 double:1.0531298423E-314;
        goto L_0x03a2;
    L_0x03db:
        r9 = 2131558532; // 0x7f0d0084 float:1.8742382E38 double:1.053129843E-314;
        goto L_0x03a2;
    L_0x03df:
        r25 = "content";
        r0 = r25;
        r25 = r0.equalsIgnoreCase(r9);
        if (r25 == 0) goto L_0x0403;
    L_0x03e9:
        r22 = 0;
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
        goto L_0x0067;
    L_0x0403:
        r25 = new java.lang.StringBuilder;
        r25.<init>();
        r26 = "</";
        r25 = r25.append(r26);
        r0 = r25;
        r9 = r0.append(r9);
        r25 = ">";
        r0 = r25;
        r9 = r9.append(r0);
        r9 = r9.toString();
        r0 = r23;
        r0.append(r9);
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
        goto L_0x0067;
    L_0x043d:
        r9 = r31.getText();
        if (r22 == 0) goto L_0x0051;
    L_0x0443:
        if (r24 != 0) goto L_0x0447;
    L_0x0445:
        if (r21 != 0) goto L_0x0051;
    L_0x0447:
        r0 = r23;
        r0.append(r9);
        r9 = r5;
        r5 = r11;
        r11 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r7;
        r7 = r12;
        r12 = r4;
        goto L_0x0067;
    L_0x0464:
        r0 = r23;
        r1 = r29;
        r1.f138a = r0;
        r0 = r29;
        r0.f139b = r5;
        return;
    L_0x046f:
        r27 = r5;
        r5 = r4;
        r4 = r27;
        goto L_0x0374;
    L_0x0476:
        r9 = r10;
        goto L_0x0240;
    L_0x0479:
        r4 = r6;
        goto L_0x006d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nxp.taginfolite.b.o.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public C0193o(String str) {
        this.f138a = str;
        this.f139b = false;
    }

    public CharSequence m172a(Context context, boolean z) {
        return this.f138a;
    }

    public String m173a() {
        return "<block type=\"text\">\n\t<content>" + this.f138a + "</" + "content" + ">\n" + "</" + "block" + ">";
    }

    public boolean m174b() {
        return this.f139b;
    }
}
