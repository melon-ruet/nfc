package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator.AnimatorListener;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet.Builder;
import com.actionbarsherlock.internal.nineoldandroids.animation.ObjectAnimator;
import com.actionbarsherlock.internal.nineoldandroids.view.animation.AnimatorProxy;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineLinearLayout;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import com.actionbarsherlock.internal.view.menu.ActionMenuView;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.view.ActionMode;

public class ActionBarContextView extends AbsActionBarView implements AnimatorListener {
    private static final int ANIMATE_IDLE = 0;
    private static final int ANIMATE_IN = 1;
    private static final int ANIMATE_OUT = 2;
    private boolean mAnimateInOnLayout;
    private int mAnimationMode;
    private NineLinearLayout mClose;
    private Animator mCurrentAnimation;
    private View mCustomView;
    private Drawable mSplitBackground;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private int mTitleStyleRes;
    private TextView mTitleView;

    /* renamed from: com.actionbarsherlock.internal.widget.ActionBarContextView.1 */
    class C01021 implements OnClickListener {
        final /* synthetic */ ActionMode val$mode;

        C01021(ActionMode actionMode) {
            this.val$mode = actionMode;
        }

        public void onClick(View view) {
            this.val$mode.finish();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0086R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0086R.styleable.SherlockActionMode, i, ANIMATE_IDLE);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(ANIMATE_IDLE));
        this.mTitleStyleRes = obtainStyledAttributes.getResourceId(4, ANIMATE_IDLE);
        this.mSubtitleStyleRes = obtainStyledAttributes.getResourceId(3, ANIMATE_IDLE);
        this.mContentHeight = obtainStyledAttributes.getLayoutDimension(ANIMATE_OUT, ANIMATE_IDLE);
        this.mSplitBackground = obtainStyledAttributes.getDrawable(ANIMATE_IN);
        obtainStyledAttributes.recycle();
    }

    private void finishAnimation() {
        Animator animator = this.mCurrentAnimation;
        if (animator != null) {
            this.mCurrentAnimation = null;
            animator.end();
        }
    }

    private void initTitle() {
        int i = 8;
        Object obj = ANIMATE_IN;
        if (this.mTitleLayout == null) {
            LayoutInflater.from(getContext()).inflate(C0086R.layout.abs__action_bar_title_item, this);
            this.mTitleLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.mTitleView = (TextView) this.mTitleLayout.findViewById(C0086R.id.abs__action_bar_title);
            this.mSubtitleView = (TextView) this.mTitleLayout.findViewById(C0086R.id.abs__action_bar_subtitle);
            if (this.mTitleStyleRes != 0) {
                this.mTitleView.setTextAppearance(this.mContext, this.mTitleStyleRes);
            }
            if (this.mSubtitleStyleRes != 0) {
                this.mSubtitleView.setTextAppearance(this.mContext, this.mSubtitleStyleRes);
            }
        }
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubtitle);
        Object obj2 = !TextUtils.isEmpty(this.mTitle) ? ANIMATE_IN : ANIMATE_IDLE;
        if (TextUtils.isEmpty(this.mSubtitle)) {
            obj = ANIMATE_IDLE;
        }
        this.mSubtitleView.setVisibility(obj != null ? ANIMATE_IDLE : 8);
        LinearLayout linearLayout = this.mTitleLayout;
        if (!(obj2 == null && obj == null)) {
            i = ANIMATE_IDLE;
        }
        linearLayout.setVisibility(i);
        if (this.mTitleLayout.getParent() == null) {
            addView(this.mTitleLayout);
        }
    }

    private Animator makeInAnimation() {
        this.mClose.setTranslationX((float) ((-this.mClose.getWidth()) - ((MarginLayoutParams) this.mClose.getLayoutParams()).leftMargin));
        float[] fArr = new float[ANIMATE_IN];
        fArr[ANIMATE_IDLE] = 0.0f;
        Animator ofFloat = ObjectAnimator.ofFloat(this.mClose, "translationX", fArr);
        ofFloat.setDuration(200);
        ofFloat.addListener(this);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        Animator animatorSet = new AnimatorSet();
        Builder play = animatorSet.play(ofFloat);
        if (this.mMenuView != null) {
            int childCount = this.mMenuView.getChildCount();
            if (childCount > 0) {
                int i = childCount - 1;
                childCount = ANIMATE_IDLE;
                while (i >= 0) {
                    AnimatorProxy wrap = AnimatorProxy.wrap(this.mMenuView.getChildAt(i));
                    wrap.setScaleY(0.0f);
                    Animator ofFloat2 = ObjectAnimator.ofFloat(wrap, "scaleY", 0.0f, 1.0f);
                    ofFloat2.setDuration(100);
                    ofFloat2.setStartDelay((long) (childCount * 70));
                    play.with(ofFloat2);
                    i--;
                    childCount += ANIMATE_IN;
                }
            }
        }
        return animatorSet;
    }

    private Animator makeOutAnimation() {
        float[] fArr = new float[ANIMATE_IN];
        fArr[ANIMATE_IDLE] = (float) ((-this.mClose.getWidth()) - ((MarginLayoutParams) this.mClose.getLayoutParams()).leftMargin);
        Animator ofFloat = ObjectAnimator.ofFloat(this.mClose, "translationX", fArr);
        ofFloat.setDuration(200);
        ofFloat.addListener(this);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        Animator animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        return (this.mMenuView == null || this.mMenuView.getChildCount() > 0) ? animatorSet : animatorSet;
    }

    public void closeMode() {
        if (this.mAnimationMode != ANIMATE_OUT) {
            if (this.mClose == null) {
                killMode();
                return;
            }
            finishAnimation();
            this.mAnimationMode = ANIMATE_OUT;
            this.mCurrentAnimation = makeOutAnimation();
            this.mCurrentAnimation.start();
        }
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean hideOverflowMenu() {
        return this.mActionMenuPresenter != null ? this.mActionMenuPresenter.hideOverflowMenu() : false;
    }

    public void initForMode(ActionMode actionMode) {
        if (this.mClose == null) {
            this.mClose = (NineLinearLayout) LayoutInflater.from(this.mContext).inflate(C0086R.layout.abs__action_mode_close_item, this, false);
            addView(this.mClose);
        } else if (this.mClose.getParent() == null) {
            addView(this.mClose);
        }
        this.mClose.findViewById(C0086R.id.abs__action_mode_close_button).setOnClickListener(new C01021(actionMode));
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.getMenu();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.dismissPopupMenus();
        }
        this.mActionMenuPresenter = new ActionMenuPresenter(this.mContext);
        this.mActionMenuPresenter.setReserveOverflow(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        if (this.mSplitActionBar) {
            this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
            this.mActionMenuPresenter.setItemLimit(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            layoutParams.width = -1;
            layoutParams.height = this.mContentHeight;
            menuBuilder.addMenuPresenter(this.mActionMenuPresenter);
            this.mMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
            this.mMenuView.setBackgroundDrawable(this.mSplitBackground);
            this.mSplitView.addView(this.mMenuView, layoutParams);
        } else {
            menuBuilder.addMenuPresenter(this.mActionMenuPresenter);
            this.mMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
            this.mMenuView.setBackgroundDrawable(null);
            addView(this.mMenuView, layoutParams);
        }
        this.mAnimateInOnLayout = true;
    }

    public boolean isOverflowMenuShowing() {
        return this.mActionMenuPresenter != null ? this.mActionMenuPresenter.isOverflowMenuShowing() : false;
    }

    public void killMode() {
        finishAnimation();
        removeAllViews();
        if (this.mSplitView != null) {
            this.mSplitView.removeView(this.mMenuView);
        }
        this.mCustomView = null;
        this.mMenuView = null;
        this.mAnimateInOnLayout = false;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if (this.mAnimationMode == ANIMATE_OUT) {
            killMode();
        }
        this.mAnimationMode = ANIMATE_IDLE;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.hideOverflowMenu();
            this.mActionMenuPresenter.hideSubMenus();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.mTitle);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.mClose == null || this.mClose.getVisibility() == 8) {
            i5 = paddingLeft;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.mClose.getLayoutParams();
            paddingLeft += marginLayoutParams.leftMargin;
            i5 = marginLayoutParams.rightMargin + (paddingLeft + positionChild(this.mClose, paddingLeft, paddingTop, paddingTop2));
            if (this.mAnimateInOnLayout) {
                this.mAnimationMode = ANIMATE_IN;
                this.mCurrentAnimation = makeInAnimation();
                this.mCurrentAnimation.start();
                this.mAnimateInOnLayout = false;
            }
        }
        if (this.mTitleLayout != null && this.mCustomView == null) {
            i5 += positionChild(this.mTitleLayout, i5, paddingTop, paddingTop2);
        }
        if (this.mCustomView != null) {
            i5 += positionChild(this.mCustomView, i5, paddingTop, paddingTop2);
        }
        i5 = (i3 - i) - getPaddingRight();
        if (this.mMenuView != null) {
            i5 -= positionChildInverse(this.mMenuView, i5, paddingTop, paddingTop2);
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int size = MeasureSpec.getSize(i);
            int size2 = this.mContentHeight > 0 ? this.mContentHeight : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i4 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i4, ExploreByTouchHelper.INVALID_ID);
            if (this.mClose != null) {
                int measureChildView = measureChildView(this.mClose, paddingLeft, makeMeasureSpec, ANIMATE_IDLE);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.mClose.getLayoutParams();
                paddingLeft = measureChildView - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.mMenuView != null && this.mMenuView.getParent() == this) {
                paddingLeft = measureChildView(this.mMenuView, paddingLeft, makeMeasureSpec, ANIMATE_IDLE);
            }
            if (this.mTitleLayout != null && this.mCustomView == null) {
                paddingLeft = measureChildView(this.mTitleLayout, paddingLeft, makeMeasureSpec, ANIMATE_IDLE);
            }
            if (this.mCustomView != null) {
                LayoutParams layoutParams = this.mCustomView.getLayoutParams();
                makeMeasureSpec = layoutParams.width != -2 ? 1073741824 : ExploreByTouchHelper.INVALID_ID;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = ExploreByTouchHelper.INVALID_ID;
                }
                this.mCustomView.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(layoutParams.height >= 0 ? Math.min(layoutParams.height, i4) : i4, i3));
            }
            if (this.mContentHeight <= 0) {
                i3 = getChildCount();
                makeMeasureSpec = ANIMATE_IDLE;
                size2 = ANIMATE_IDLE;
                while (makeMeasureSpec < i3) {
                    paddingLeft = getChildAt(makeMeasureSpec).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    makeMeasureSpec += ANIMATE_IN;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    public void setContentHeight(int i) {
        this.mContentHeight = i;
    }

    public void setCustomView(View view) {
        if (this.mCustomView != null) {
            removeView(this.mCustomView);
        }
        this.mCustomView = view;
        if (this.mTitleLayout != null) {
            removeView(this.mTitleLayout);
            this.mTitleLayout = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSplitActionBar(boolean z) {
        if (this.mSplitActionBar != z) {
            if (this.mActionMenuPresenter != null) {
                LayoutParams layoutParams = new LayoutParams(-2, -1);
                ViewGroup viewGroup;
                if (z) {
                    this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    this.mActionMenuPresenter.setItemLimit(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    layoutParams.width = -1;
                    layoutParams.height = this.mContentHeight;
                    this.mMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
                    this.mMenuView.setBackgroundDrawable(this.mSplitBackground);
                    viewGroup = (ViewGroup) this.mMenuView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.mMenuView);
                    }
                    this.mSplitView.addView(this.mMenuView, layoutParams);
                } else {
                    this.mMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
                    this.mMenuView.setBackgroundDrawable(null);
                    viewGroup = (ViewGroup) this.mMenuView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.mMenuView);
                    }
                    addView(this.mMenuView, layoutParams);
                }
            }
            super.setSplitActionBar(z);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        initTitle();
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        initTitle();
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        return this.mActionMenuPresenter != null ? this.mActionMenuPresenter.showOverflowMenu() : false;
    }
}
