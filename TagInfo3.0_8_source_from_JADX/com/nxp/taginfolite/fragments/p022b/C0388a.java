package com.nxp.taginfolite.fragments.p022b;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.fragments.b.a */
public class C0388a extends GestureDetectorCompat {
    boolean f1268a;
    boolean f1269b;
    private long f1270c;

    public C0388a(Context context, OnGestureListener onGestureListener) {
        super(context, onGestureListener);
        this.f1268a = false;
        this.f1269b = false;
    }

    public boolean m1271a() {
        return this.f1268a;
    }

    public boolean m1272b() {
        return this.f1269b;
    }

    public void m1273c() {
        this.f1268a = false;
    }

    public void m1274d() {
        this.f1269b = false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        boolean z2 = false;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        switch (actionMasked) {
            case C0519c.Switch_thumb /*0*/:
                this.f1270c = System.currentTimeMillis();
                break;
            case C0519c.Switch_textOn /*2*/:
                boolean z3 = this.f1268a || pointerCount == 2;
                this.f1268a = z3;
                if (this.f1269b || pointerCount == 3) {
                    z2 = true;
                }
                this.f1269b = z2;
                break;
            case C0519c.Switch_switchTextAppearance /*5*/:
                if (pointerCount != 2) {
                    if (pointerCount != 3) {
                        this.f1268a = false;
                        break;
                    }
                    if (this.f1270c - System.currentTimeMillis() >= 500) {
                        z = false;
                    }
                    this.f1269b = z;
                    break;
                }
                if (this.f1270c - System.currentTimeMillis() >= 500) {
                    z = false;
                }
                this.f1268a = z;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
