package com.nxp.taginfolite.fragments.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

/* renamed from: com.nxp.taginfolite.fragments.view.e */
class C0416e extends LinearLayout {
    private final int f1328a;
    private final int f1329b;
    private final Paint f1330c;
    private final Paint f1331d;
    private final float f1332e;
    private int f1333f;
    private float f1334g;
    private C0415d f1335h;
    private final C0418g f1336i;

    C0416e(Context context) {
        this(context, null);
    }

    C0416e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        float f = getResources().getDisplayMetrics().density;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842800, typedValue, true);
        int i = typedValue.data;
        int a = C0416e.m1342a(-412416, (byte) -1);
        this.f1336i = new C0418g();
        this.f1336i.m1349a(-412416);
        this.f1336i.m1351b(C0416e.m1342a(i, (byte) 32));
        this.f1328a = (int) (1.0f * f);
        new Paint().setColor(a);
        this.f1329b = (int) (6.0f * f);
        this.f1330c = new Paint();
        this.f1332e = 0.5f;
        this.f1331d = new Paint();
        this.f1331d.setStrokeWidth((float) ((int) (f * 1.0f)));
    }

    private static int m1342a(int i, byte b) {
        return Color.argb(b, Color.red(i), Color.green(i), Color.blue(i));
    }

    private static int m1343a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.rgb((int) ((((float) Color.red(i)) * f) + (((float) Color.red(i2)) * f2)), (int) ((((float) Color.green(i)) * f) + (((float) Color.green(i2)) * f2)), (int) ((f2 * ((float) Color.blue(i2))) + (((float) Color.blue(i)) * f)));
    }

    void m1344a(int i, float f) {
        this.f1333f = i;
        this.f1334g = f;
        invalidate();
    }

    void m1345a(C0415d c0415d) {
        this.f1335h = c0415d;
        invalidate();
    }

    void m1346a(int... iArr) {
        this.f1335h = null;
        this.f1336i.m1349a(iArr);
        invalidate();
    }

    void m1347b(int... iArr) {
        this.f1335h = null;
        this.f1336i.m1351b(iArr);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        int height = getHeight();
        int childCount = getChildCount();
        int min = (int) (Math.min(Math.max(0.0f, this.f1332e), 1.0f) * ((float) height));
        if (this.f1335h != null) {
            C0415d c0415d = this.f1335h;
        } else {
            Object obj = this.f1336i;
        }
        if (childCount > 0) {
            int i;
            View childAt = getChildAt(this.f1333f);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            int a = c0415d.m1340a(this.f1333f);
            if (this.f1334g <= 0.0f || this.f1333f >= getChildCount() - 1) {
                i = right;
                right = left;
            } else {
                i = c0415d.m1340a(this.f1333f + 1);
                if (a != i) {
                    a = C0416e.m1343a(i, a, this.f1334g);
                }
                View childAt2 = getChildAt(this.f1333f + 1);
                left = (int) ((((float) left) * (1.0f - this.f1334g)) + (this.f1334g * ((float) childAt2.getLeft())));
                i = (int) ((((float) right) * (1.0f - this.f1334g)) + (((float) childAt2.getRight()) * this.f1334g));
                right = left;
            }
            this.f1330c.setColor(a);
            canvas.drawRect((float) right, (float) (height - this.f1329b), (float) i, (float) height, this.f1330c);
        }
        canvas.drawRect(0.0f, (float) (height - this.f1328a), (float) getWidth(), (float) height, this.f1330c);
        int i2 = (height - min) / 2;
        for (height = 0; height < childCount - 1; height++) {
            childAt = getChildAt(height);
            this.f1331d.setColor(c0415d.m1341b(height));
            canvas.drawLine((float) childAt.getRight(), (float) i2, (float) childAt.getRight(), (float) (i2 + min), this.f1331d);
        }
    }
}
