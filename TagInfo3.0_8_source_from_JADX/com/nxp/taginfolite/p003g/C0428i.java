package com.nxp.taginfolite.p003g;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;

/* renamed from: com.nxp.taginfolite.g.i */
public class C0428i {
    private final SpannableStringBuilder f1357a;
    private SpannableStringBuilder f1358b;
    private boolean f1359c;

    public C0428i() {
        this.f1357a = new SpannableStringBuilder();
        this.f1359c = true;
        this.f1358b = null;
    }

    private void m1382c() {
        if (this.f1358b != null) {
            if (!this.f1359c) {
                this.f1357a.append("\n");
            }
            this.f1357a.append(this.f1358b);
            this.f1358b = null;
            this.f1359c = false;
        }
    }

    public void m1383a() {
        if (this.f1358b != null) {
            m1382c();
            return;
        }
        if (!this.f1359c) {
            this.f1357a.append("\n");
        }
        this.f1359c = false;
    }

    public void m1384a(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && !charSequence.equals("\n")) {
            m1383a();
            this.f1357a.append(charSequence);
            int length = charSequence.length();
            if (length > 0 && charSequence.charAt(length - 1) == '\n') {
                this.f1357a.delete(this.f1357a.length() - 1, this.f1357a.length());
            }
        }
    }

    public void m1385a(CharacterStyle... characterStyleArr) {
        m1382c();
        for (Object span : characterStyleArr) {
            this.f1357a.setSpan(span, 0, this.f1357a.length(), 17);
        }
    }

    public CharSequence m1386b() {
        m1382c();
        return this.f1357a;
    }

    public void m1387b(CharSequence charSequence) {
        if (charSequence != null) {
            if (this.f1358b == null) {
                this.f1358b = new SpannableStringBuilder();
            }
            this.f1358b.append(charSequence);
        }
    }

    public String toString() {
        m1382c();
        return this.f1357a.toString();
    }
}
