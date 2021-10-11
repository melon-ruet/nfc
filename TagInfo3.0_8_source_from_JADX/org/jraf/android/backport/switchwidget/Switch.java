package org.jraf.android.backport.switchwidget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.CompoundButton;
import com.actionbarsherlock.view.Menu;

public class Switch extends CompoundButton {
    private static final int[] f1653A;
    private final Drawable f1654a;
    private final Drawable f1655b;
    private final int f1656c;
    private final int f1657d;
    private final int f1658e;
    private CharSequence f1659f;
    private CharSequence f1660g;
    private int f1661h;
    private final int f1662i;
    private float f1663j;
    private float f1664k;
    private final VelocityTracker f1665l;
    private final int f1666m;
    private float f1667n;
    private int f1668o;
    private int f1669p;
    private int f1670q;
    private int f1671r;
    private int f1672s;
    private int f1673t;
    private int f1674u;
    private final TextPaint f1675v;
    private ColorStateList f1676w;
    private Layout f1677x;
    private Layout f1678y;
    private final Rect f1679z;

    static {
        f1653A = new int[]{16842912};
    }

    public Switch(Context context) {
        this(context, null);
    }

    public Switch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0518b.switchStyle);
    }

    public Switch(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        super(context, attributeSet, i);
        this.f1665l = VelocityTracker.obtain();
        this.f1679z = new Rect();
        this.f1675v = new TextPaint(1);
        this.f1675v.density = getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0519c.Switch, i, 0);
        this.f1654a = obtainStyledAttributes.getDrawable(0);
        this.f1655b = obtainStyledAttributes.getDrawable(1);
        this.f1659f = obtainStyledAttributes.getText(2);
        this.f1660g = obtainStyledAttributes.getText(3);
        this.f1656c = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.f1657d = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.f1658e = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        int resourceId = obtainStyledAttributes.getResourceId(5, 0);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, C0519c.Android);
            ColorStateList colorStateList = obtainStyledAttributes2.getColorStateList(3);
            if (colorStateList != null) {
                this.f1676w = colorStateList;
            } else {
                this.f1676w = getTextColors();
            }
            resourceId = obtainStyledAttributes2.getDimensionPixelSize(0, 0);
            if (!(resourceId == 0 || ((float) resourceId) == this.f1675v.getTextSize())) {
                this.f1675v.setTextSize((float) resourceId);
                requestLayout();
            }
            int i2 = obtainStyledAttributes2.getInt(1, -1);
            int i3 = obtainStyledAttributes2.getInt(2, -1);
            Typeface typeface = null;
            switch (i2) {
                case C0519c.Switch_track /*1*/:
                    typeface = Typeface.SANS_SERIF;
                    break;
                case C0519c.Switch_textOn /*2*/:
                    typeface = Typeface.SERIF;
                    break;
                case C0519c.Switch_textOff /*3*/:
                    typeface = Typeface.MONOSPACE;
                    break;
            }
            if (i3 > 0) {
                typeface = typeface == null ? Typeface.defaultFromStyle(i3) : Typeface.create(typeface, i3);
                setSwitchTypeface(typeface);
                resourceId = ((typeface != null ? typeface.getStyle() : 0) ^ -1) & i3;
                TextPaint textPaint = this.f1675v;
                if ((resourceId & 1) != 0) {
                    z = true;
                }
                textPaint.setFakeBoldText(z);
                this.f1675v.setTextSkewX((resourceId & 2) != 0 ? -0.25f : 0.0f);
            } else {
                this.f1675v.setFakeBoldText(false);
                this.f1675v.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            obtainStyledAttributes2.recycle();
        }
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1662i = viewConfiguration.getScaledTouchSlop();
        this.f1666m = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private Layout m1813a(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.f1675v, (int) Math.ceil((double) Layout.getDesiredWidth(charSequence, this.f1675v)), Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private boolean getTargetCheckedState() {
        return this.f1667n >= ((float) (getThumbScrollRange() / 2));
    }

    private int getThumbScrollRange() {
        if (this.f1655b == null) {
            return 0;
        }
        this.f1655b.getPadding(this.f1679z);
        return ((this.f1668o - this.f1670q) - this.f1679z.left) - this.f1679z.right;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.f1654a != null) {
            this.f1654a.setState(drawableState);
        }
        if (this.f1655b != null) {
            this.f1655b.setState(drawableState);
        }
        invalidate();
    }

    public int getCompoundPaddingRight() {
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f1668o;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f1658e : compoundPaddingRight;
    }

    public CharSequence getTextOff() {
        return this.f1660g;
    }

    public CharSequence getTextOn() {
        return this.f1659f;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f1653A);
        }
        return onCreateDrawableState;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.f1671r;
        int i2 = this.f1672s;
        int i3 = this.f1673t;
        int i4 = this.f1674u;
        this.f1655b.setBounds(i, i2, i3, i4);
        this.f1655b.draw(canvas);
        canvas.save();
        this.f1655b.getPadding(this.f1679z);
        i += this.f1679z.left;
        int i5 = this.f1679z.top + i2;
        int i6 = i4 - this.f1679z.bottom;
        canvas.clipRect(i, i2, i3 - this.f1679z.right, i4);
        this.f1654a.getPadding(this.f1679z);
        i3 = (int) (this.f1667n + 0.5f);
        int i7 = (i - this.f1679z.left) + i3;
        i3 = this.f1679z.right + ((i + i3) + this.f1670q);
        this.f1654a.setBounds(i7, i2, i3, i4);
        this.f1654a.draw(canvas);
        if (this.f1676w != null) {
            this.f1675v.setColor(this.f1676w.getColorForState(getDrawableState(), this.f1676w.getDefaultColor()));
        }
        this.f1675v.drawableState = getDrawableState();
        Layout layout = getTargetCheckedState() ? this.f1677x : this.f1678y;
        canvas.translate((float) (((i7 + i3) / 2) - (layout.getWidth() / 2)), (float) (((i5 + i6) / 2) - (layout.getHeight() / 2)));
        layout.draw(canvas);
        canvas.restore();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        this.f1667n = isChecked() ? (float) getThumbScrollRange() : 0.0f;
        int width = getWidth() - getPaddingRight();
        int i6 = width - this.f1668o;
        switch (getGravity() & 112) {
            case Menu.CATEGORY_SHIFT /*16*/:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.f1669p / 2);
                i5 = this.f1669p + paddingTop;
                break;
            case 80:
                i5 = getHeight() - getPaddingBottom();
                paddingTop = i5 - this.f1669p;
                break;
            default:
                paddingTop = getPaddingTop();
                i5 = this.f1669p + paddingTop;
                break;
        }
        this.f1671r = i6;
        this.f1672s = paddingTop;
        this.f1674u = i5;
        this.f1673t = width;
    }

    @TargetApi(11)
    public void onMeasure(int i, int i2) {
        if (this.f1677x == null) {
            this.f1677x = m1813a(this.f1659f);
        }
        if (this.f1678y == null) {
            this.f1678y = m1813a(this.f1660g);
        }
        this.f1655b.getPadding(this.f1679z);
        int max = Math.max(this.f1677x.getWidth(), this.f1678y.getWidth());
        int max2 = Math.max(this.f1657d, (((max * 2) + (this.f1656c * 4)) + this.f1679z.left) + this.f1679z.right);
        int intrinsicHeight = this.f1655b.getIntrinsicHeight();
        this.f1670q = max + (this.f1656c * 2);
        this.f1668o = max2;
        this.f1669p = intrinsicHeight;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() >= intrinsicHeight) {
            return;
        }
        if (VERSION.SDK_INT < 11) {
            setMeasuredDimension(getMeasuredWidth(), intrinsicHeight);
        } else {
            setMeasuredDimension(getMeasuredWidthAndState(), intrinsicHeight);
        }
    }

    @SuppressLint({"NewApi"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        this.f1665l.addMovement(motionEvent);
        float x;
        switch (VERSION.SDK_INT < 8 ? motionEvent.getAction() : motionEvent.getActionMasked()) {
            case C0519c.Switch_thumb /*0*/:
                x = motionEvent.getX();
                float y = motionEvent.getY();
                if (isEnabled()) {
                    this.f1654a.getPadding(this.f1679z);
                    int i = this.f1672s - this.f1662i;
                    int i2 = (this.f1671r + ((int) (this.f1667n + 0.5f))) - this.f1662i;
                    int i3 = (((this.f1670q + i2) + this.f1679z.left) + this.f1679z.right) + this.f1662i;
                    int i4 = this.f1674u + this.f1662i;
                    if (x > ((float) i2) && x < ((float) i3) && y > ((float) i) && y < ((float) i4)) {
                        z = true;
                    }
                    if (z) {
                        this.f1661h = 1;
                        this.f1663j = x;
                        this.f1664k = y;
                        break;
                    }
                }
                break;
            case C0519c.Switch_track /*1*/:
            case C0519c.Switch_textOff /*3*/:
                if (this.f1661h != 2) {
                    this.f1661h = 0;
                    this.f1665l.clear();
                    break;
                }
                this.f1661h = 0;
                boolean z2 = motionEvent.getAction() == 1 && isEnabled();
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                super.onTouchEvent(obtain);
                obtain.recycle();
                if (z2) {
                    this.f1665l.computeCurrentVelocity(1000);
                    x = this.f1665l.getXVelocity();
                    if (Math.abs(x) <= ((float) this.f1666m)) {
                        z = getTargetCheckedState();
                    } else if (x > 0.0f) {
                        z = true;
                    }
                    setChecked(z);
                    return true;
                }
                setChecked(isChecked());
                return true;
                break;
            case C0519c.Switch_textOn /*2*/:
                float y2;
                switch (this.f1661h) {
                    case C0519c.Switch_thumb /*0*/:
                        break;
                    case C0519c.Switch_track /*1*/:
                        x = motionEvent.getX();
                        y2 = motionEvent.getY();
                        if (Math.abs(x - this.f1663j) > ((float) this.f1662i) || Math.abs(y2 - this.f1664k) > ((float) this.f1662i)) {
                            this.f1661h = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.f1663j = x;
                            this.f1664k = y2;
                            return true;
                        }
                    case C0519c.Switch_textOn /*2*/:
                        x = motionEvent.getX();
                        y2 = Math.max(0.0f, Math.min((x - this.f1663j) + this.f1667n, (float) getThumbScrollRange()));
                        if (y2 == this.f1667n) {
                            return true;
                        }
                        this.f1667n = y2;
                        this.f1663j = x;
                        invalidate();
                        return true;
                    default:
                        break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        this.f1667n = z ? (float) getThumbScrollRange() : 0.0f;
        invalidate();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.f1675v.getTypeface() != typeface) {
            this.f1675v.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.f1660g = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.f1659f = charSequence;
        requestLayout();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1654a || drawable == this.f1655b;
    }
}
