package com.nxp.taginfolite.p004f.p015a;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.nxp.taginfolite.p003g.C0329f;
import java.util.List;

/* renamed from: com.nxp.taginfolite.f.a.a */
public abstract class C0328a extends C0327e {
    public static final C0329f f958c;
    protected C0332d f959a;
    protected boolean f960b;

    static {
        f958c = new C0330b();
    }

    public C0328a(C0332d c0332d, int i, boolean z, byte[] bArr) {
        super(i, bArr);
        this.f960b = z;
        this.f959a = c0332d;
        m941a();
        m945b();
    }

    protected C0328a(byte[] bArr, int i) {
        m942b(bArr, m937a(bArr, i) + i);
    }

    protected int m937a(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= i) {
            throw new IllegalArgumentException("Tag fields can not be null or empty");
        }
        byte b = bArr[i];
        this.f959a = C0332d.m951a(b);
        this.f960b = (b & 32) == 32;
        this.d = b & 31;
        if (this.d != 31) {
            return 1;
        }
        this.d = 0;
        int i2 = 0;
        int i3;
        do {
            i2++;
            byte b2 = bArr[i + i2];
            i3 = b2 >= null ? 1 : 0;
            this.d <<= 7;
            this.d = ((byte) (b2 & TransportMediator.KEYCODE_MEDIA_PAUSE)) | this.d;
        } while (i3 == 0);
        return i2 + 1;
    }

    public C0328a m938a(int i, C0329f c0329f) {
        List b = m943b(i, c0329f);
        return b.isEmpty() ? null : (C0328a) b.get(0);
    }

    public C0328a m939a(C0329f c0329f) {
        return m938a((int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, c0329f);
    }

    public List m940a(int i) {
        return m943b(i, f958c);
    }

    protected byte[] m941a() {
        int i = (byte) (this.f959a.f969e << 6);
        if (this.f960b) {
            i = (byte) (i | 32);
        }
        if (this.d < 32) {
            byte[] bArr = new byte[1];
            bArr[0] = (byte) ((i | this.d) | bArr[0]);
            return bArr;
        }
        int ceil = (int) Math.ceil(((double) this.d) / 127.0d);
        bArr = new byte[(ceil + 1)];
        bArr[0] = (byte) (i | 31);
        i = this.d;
        bArr[ceil] = (byte) (bArr[ceil] | (i & TransportMediator.KEYCODE_MEDIA_PAUSE));
        int i2 = i >>> 7;
        i = ceil - 1;
        while (i > 0) {
            bArr[i] = (byte) (bArr[i] | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            bArr[i] = (byte) (bArr[i] | (i2 & TransportMediator.KEYCODE_MEDIA_PAUSE));
            i--;
            i2 >>>= 7;
        }
        return bArr;
    }

    protected int m942b(byte[] bArr, int i) {
        int i2 = 1;
        if (bArr == null || bArr.length <= i) {
            throw new IllegalArgumentException("Length fields can not be null or empty");
        }
        byte b = bArr[i];
        if (b < null) {
            int i3 = b & TransportMediator.KEYCODE_MEDIA_PAUSE;
            if (i3 < 1 || i3 > 4 || bArr.length <= i + i3) {
                throw new IllegalArgumentException("Length field corrupted:" + Integer.toHexString(b & MotionEventCompat.ACTION_MASK));
            }
            i2 = 0;
            this.e = 0;
            while (i2 < i3) {
                this.e <<= 8;
                i2++;
                this.e |= bArr[i + i2] & MotionEventCompat.ACTION_MASK;
            }
        } else {
            this.e = b;
        }
        return i2;
    }

    public abstract List m943b(int i, C0329f c0329f);

    public List m944b(C0329f c0329f) {
        return m943b((int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, c0329f);
    }

    protected byte[] m945b() {
        byte[] bArr;
        if (this.e <= TransportMediator.KEYCODE_MEDIA_PAUSE) {
            return new byte[]{(byte) (bArr[0] | this.e)};
        }
        int ceil = (int) Math.ceil(((double) this.e) / 255.0d);
        bArr = new byte[ceil];
        bArr[0] = (byte) (bArr[0] | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        bArr[0] = (byte) (bArr[0] | ceil);
        int i = ceil - 1;
        ceil = this.e;
        while (i > 0) {
            bArr[i] = (byte) (bArr[i] | ceil);
            i--;
            ceil >>= 8;
        }
        return bArr;
    }

    public C0332d m946c() {
        return this.f959a;
    }

    public boolean m947d() {
        return this.f960b;
    }

    public String toString() {
        return "BerTlv {\r\n\tClass         :" + this.f959a + "\r\n" + "\tIs constructed:" + this.f960b + "\r\n" + "\tTag           :" + this.d + "\r\n" + "\tLength        :" + this.e + "\r\n" + "}";
    }
}
