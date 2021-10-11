package com.actionbarsherlock.internal.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SpinnerAdapter;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.LayoutParams;
import com.actionbarsherlock.app.ActionBar.OnMenuVisibilityListener;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator.AnimatorListener;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorListenerAdapter;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet.Builder;
import com.actionbarsherlock.internal.nineoldandroids.animation.ObjectAnimator;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineFrameLayout;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.MenuPopupHelper;
import com.actionbarsherlock.internal.view.menu.SubMenuBuilder;
import com.actionbarsherlock.internal.widget.ActionBarContainer;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import com.actionbarsherlock.internal.widget.ActionBarView;
import com.actionbarsherlock.internal.widget.ScrollingTabContainerView;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode.Callback;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.jraf.android.backport.switchwidget.C0519c;

public class ActionBarImpl extends ActionBar {
    private static final int CONTEXT_DISPLAY_NORMAL = 0;
    private static final int CONTEXT_DISPLAY_SPLIT = 1;
    private static final int INVALID_POSITION = -1;
    ActionModeImpl mActionMode;
    private ActionBarView mActionView;
    private Activity mActivity;
    private ActionBarContainer mContainerView;
    private NineFrameLayout mContentView;
    private Context mContext;
    private int mContextDisplayMode;
    private ActionBarContextView mContextView;
    private Animator mCurrentModeAnim;
    private Animator mCurrentShowAnim;
    ActionMode mDeferredDestroyActionMode;
    Callback mDeferredModeDestroyCallback;
    final Handler mHandler;
    private boolean mHasEmbeddedTabs;
    final AnimatorListener mHideListener;
    private boolean mLastMenuVisibility;
    private ArrayList mMenuVisibilityListeners;
    private int mSavedTabPosition;
    private TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    final AnimatorListener mShowListener;
    private ActionBarContainer mSplitView;
    private ScrollingTabContainerView mTabScrollView;
    Runnable mTabSelector;
    private ArrayList mTabs;
    private Context mThemedContext;
    boolean mWasHiddenBeforeMode;

    /* renamed from: com.actionbarsherlock.internal.app.ActionBarImpl.1 */
    class C00881 extends AnimatorListenerAdapter {
        C00881() {
        }

        public void onAnimationEnd(Animator animator) {
            if (ActionBarImpl.this.mContentView != null) {
                ActionBarImpl.this.mContentView.setTranslationY(0.0f);
                ActionBarImpl.this.mContainerView.setTranslationY(0.0f);
            }
            if (ActionBarImpl.this.mSplitView != null && ActionBarImpl.this.mContextDisplayMode == ActionBarImpl.CONTEXT_DISPLAY_SPLIT) {
                ActionBarImpl.this.mSplitView.setVisibility(8);
            }
            ActionBarImpl.this.mContainerView.setVisibility(8);
            ActionBarImpl.this.mContainerView.setTransitioning(false);
            ActionBarImpl.this.mCurrentShowAnim = null;
            ActionBarImpl.this.completeDeferredDestroyActionMode();
        }
    }

    /* renamed from: com.actionbarsherlock.internal.app.ActionBarImpl.2 */
    class C00892 extends AnimatorListenerAdapter {
        C00892() {
        }

        public void onAnimationEnd(Animator animator) {
            ActionBarImpl.this.mCurrentShowAnim = null;
            ActionBarImpl.this.mContainerView.requestLayout();
        }
    }

    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private Callback mCallback;
        private WeakReference mCustomView;
        private MenuBuilder mMenu;

        public ActionModeImpl(Callback callback) {
            this.mCallback = callback;
            this.mMenu = new MenuBuilder(ActionBarImpl.this.getThemedContext()).setDefaultShowAsAction(ActionBarImpl.CONTEXT_DISPLAY_SPLIT);
            this.mMenu.setCallback(this);
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                boolean onCreateActionMode = this.mCallback.onCreateActionMode(this, this.mMenu);
                return onCreateActionMode;
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public void finish() {
            if (ActionBarImpl.this.mActionMode == this) {
                if (ActionBarImpl.this.mWasHiddenBeforeMode) {
                    ActionBarImpl.this.mDeferredDestroyActionMode = this;
                    ActionBarImpl.this.mDeferredModeDestroyCallback = this.mCallback;
                } else {
                    this.mCallback.onDestroyActionMode(this);
                }
                this.mCallback = null;
                ActionBarImpl.this.animateToMode(false);
                ActionBarImpl.this.mContextView.closeMode();
                ActionBarImpl.this.mActionView.sendAccessibilityEvent(32);
                ActionBarImpl.this.mActionMode = null;
                if (ActionBarImpl.this.mWasHiddenBeforeMode) {
                    ActionBarImpl.this.hide();
                }
            }
        }

        public View getCustomView() {
            return this.mCustomView != null ? (View) this.mCustomView.get() : null;
        }

        public Menu getMenu() {
            return this.mMenu;
        }

        public MenuInflater getMenuInflater() {
            return new MenuInflater(ActionBarImpl.this.getThemedContext());
        }

        public CharSequence getSubtitle() {
            return ActionBarImpl.this.mContextView.getSubtitle();
        }

        public CharSequence getTitle() {
            return ActionBarImpl.this.mContextView.getTitle();
        }

        public void invalidate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                this.mCallback.onPrepareActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return this.mCallback != null ? this.mCallback.onActionItemClicked(this, menuItem) : false;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.mCallback != null) {
                invalidate();
                ActionBarImpl.this.mContextView.showOverflowMenu();
            }
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (this.mCallback == null) {
                return false;
            }
            if (!subMenuBuilder.hasVisibleItems()) {
                return true;
            }
            new MenuPopupHelper(ActionBarImpl.this.getThemedContext(), subMenuBuilder).show();
            return true;
        }

        public void setCustomView(View view) {
            ActionBarImpl.this.mContextView.setCustomView(view);
            this.mCustomView = new WeakReference(view);
        }

        public void setSubtitle(int i) {
            setSubtitle(ActionBarImpl.this.mContext.getResources().getString(i));
        }

        public void setSubtitle(CharSequence charSequence) {
            ActionBarImpl.this.mContextView.setSubtitle(charSequence);
        }

        public void setTitle(int i) {
            setTitle(ActionBarImpl.this.mContext.getResources().getString(i));
        }

        public void setTitle(CharSequence charSequence) {
            ActionBarImpl.this.mContextView.setTitle(charSequence);
        }
    }

    public class TabImpl extends Tab {
        private TabListener mCallback;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        private int mPosition;
        private Object mTag;
        private CharSequence mText;

        public TabImpl() {
            this.mPosition = ActionBarImpl.INVALID_POSITION;
        }

        public TabListener getCallback() {
            return this.mCallback;
        }

        public CharSequence getContentDescription() {
            return this.mContentDesc;
        }

        public View getCustomView() {
            return this.mCustomView;
        }

        public Drawable getIcon() {
            return this.mIcon;
        }

        public int getPosition() {
            return this.mPosition;
        }

        public Object getTag() {
            return this.mTag;
        }

        public CharSequence getText() {
            return this.mText;
        }

        public void select() {
            ActionBarImpl.this.selectTab(this);
        }

        public Tab setContentDescription(int i) {
            return setContentDescription(ActionBarImpl.this.mContext.getResources().getText(i));
        }

        public Tab setContentDescription(CharSequence charSequence) {
            this.mContentDesc = charSequence;
            if (this.mPosition >= 0) {
                ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public Tab setCustomView(int i) {
            return setCustomView(LayoutInflater.from(ActionBarImpl.this.getThemedContext()).inflate(i, null));
        }

        public Tab setCustomView(View view) {
            this.mCustomView = view;
            if (this.mPosition >= 0) {
                ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public Tab setIcon(int i) {
            return setIcon(ActionBarImpl.this.mContext.getResources().getDrawable(i));
        }

        public Tab setIcon(Drawable drawable) {
            this.mIcon = drawable;
            if (this.mPosition >= 0) {
                ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public void setPosition(int i) {
            this.mPosition = i;
        }

        public Tab setTabListener(TabListener tabListener) {
            this.mCallback = tabListener;
            return this;
        }

        public Tab setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        public Tab setText(int i) {
            return setText(ActionBarImpl.this.mContext.getResources().getText(i));
        }

        public Tab setText(CharSequence charSequence) {
            this.mText = charSequence;
            if (this.mPosition >= 0) {
                ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }
    }

    public ActionBarImpl(Activity activity, int i) {
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = INVALID_POSITION;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mHandler = new Handler();
        this.mHideListener = new C00881();
        this.mShowListener = new C00892();
        this.mActivity = activity;
        View decorView = activity.getWindow().getDecorView();
        init(decorView);
        if ((i & AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY) == 0) {
            this.mContentView = (NineFrameLayout) decorView.findViewById(16908290);
        }
    }

    public ActionBarImpl(Dialog dialog) {
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = INVALID_POSITION;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mHandler = new Handler();
        this.mHideListener = new C00881();
        this.mShowListener = new C00892();
        init(dialog.getWindow().getDecorView());
    }

    private void cleanupTabs() {
        if (this.mSelectedTab != null) {
            selectTab(null);
        }
        this.mTabs.clear();
        if (this.mTabScrollView != null) {
            this.mTabScrollView.removeAllTabs();
        }
        this.mSavedTabPosition = INVALID_POSITION;
    }

    private void configureTab(Tab tab, int i) {
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.getCallback() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        tabImpl.setPosition(i);
        this.mTabs.add(i, tabImpl);
        int size = this.mTabs.size();
        for (int i2 = i + CONTEXT_DISPLAY_SPLIT; i2 < size; i2 += CONTEXT_DISPLAY_SPLIT) {
            ((TabImpl) this.mTabs.get(i2)).setPosition(i2);
        }
    }

    private void ensureTabsExist() {
        int i = CONTEXT_DISPLAY_NORMAL;
        if (this.mTabScrollView == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.mContext);
            if (this.mHasEmbeddedTabs) {
                scrollingTabContainerView.setVisibility(CONTEXT_DISPLAY_NORMAL);
                this.mActionView.setEmbeddedTabView(scrollingTabContainerView);
            } else {
                if (getNavigationMode() != 2) {
                    i = 8;
                }
                scrollingTabContainerView.setVisibility(i);
                this.mContainerView.setTabContainer(scrollingTabContainerView);
            }
            this.mTabScrollView = scrollingTabContainerView;
        }
    }

    private void init(View view) {
        int i = CONTEXT_DISPLAY_SPLIT;
        this.mContext = view.getContext();
        this.mActionView = (ActionBarView) view.findViewById(C0086R.id.abs__action_bar);
        this.mContextView = (ActionBarContextView) view.findViewById(C0086R.id.abs__action_context_bar);
        this.mContainerView = (ActionBarContainer) view.findViewById(C0086R.id.abs__action_bar_container);
        this.mSplitView = (ActionBarContainer) view.findViewById(C0086R.id.abs__split_action_bar);
        if (this.mActionView == null || this.mContextView == null || this.mContainerView == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.mActionView.setContextView(this.mContextView);
        this.mContextDisplayMode = this.mActionView.isSplitActionBar() ? CONTEXT_DISPLAY_SPLIT : CONTEXT_DISPLAY_NORMAL;
        int i2 = this.mContext.getApplicationInfo().targetSdkVersion < 14 ? CONTEXT_DISPLAY_SPLIT : CONTEXT_DISPLAY_NORMAL;
        if ((this.mActionView.getDisplayOptions() & 4) == 0) {
            i = CONTEXT_DISPLAY_NORMAL;
        }
        setHomeButtonEnabled(i2 | i);
        setHasEmbeddedTabs(ResourcesCompat.getResources_getBoolean(this.mContext, C0086R.bool.abs__action_bar_embed_tabs));
    }

    private void setHasEmbeddedTabs(boolean z) {
        boolean z2 = true;
        this.mHasEmbeddedTabs = z;
        if (this.mHasEmbeddedTabs) {
            this.mContainerView.setTabContainer(null);
            this.mActionView.setEmbeddedTabView(this.mTabScrollView);
        } else {
            this.mActionView.setEmbeddedTabView(null);
            this.mContainerView.setTabContainer(this.mTabScrollView);
        }
        boolean z3 = getNavigationMode() == 2 ? true : CONTEXT_DISPLAY_NORMAL;
        if (this.mTabScrollView != null) {
            this.mTabScrollView.setVisibility(z3 ? CONTEXT_DISPLAY_NORMAL : 8);
        }
        ActionBarView actionBarView = this.mActionView;
        if (this.mHasEmbeddedTabs || !z3) {
            z2 = false;
        }
        actionBarView.setCollapsable(z2);
    }

    public void addOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(onMenuVisibilityListener);
    }

    public void addTab(Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    public void addTab(Tab tab, int i) {
        addTab(tab, i, this.mTabs.isEmpty());
    }

    public void addTab(Tab tab, int i, boolean z) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, i, z);
        configureTab(tab, i);
        if (z) {
            selectTab(tab);
        }
    }

    public void addTab(Tab tab, boolean z) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, z);
        configureTab(tab, this.mTabs.size());
        if (z) {
            selectTab(tab);
        }
    }

    void animateToMode(boolean z) {
        int i = 8;
        if (z) {
            show(false);
        }
        if (this.mCurrentModeAnim != null) {
            this.mCurrentModeAnim.end();
        }
        this.mActionView.animateToVisibility(z ? 8 : CONTEXT_DISPLAY_NORMAL);
        this.mContextView.animateToVisibility(z ? CONTEXT_DISPLAY_NORMAL : 8);
        if (this.mTabScrollView != null && !this.mActionView.hasEmbeddedTabs() && this.mActionView.isCollapsed()) {
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (!z) {
                i = CONTEXT_DISPLAY_NORMAL;
            }
            scrollingTabContainerView.animateToVisibility(i);
        }
    }

    void completeDeferredDestroyActionMode() {
        if (this.mDeferredModeDestroyCallback != null) {
            this.mDeferredModeDestroyCallback.onDestroyActionMode(this.mDeferredDestroyActionMode);
            this.mDeferredDestroyActionMode = null;
            this.mDeferredModeDestroyCallback = null;
        }
    }

    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = z;
            int size = this.mMenuVisibilityListeners.size();
            for (int i = CONTEXT_DISPLAY_NORMAL; i < size; i += CONTEXT_DISPLAY_SPLIT) {
                ((OnMenuVisibilityListener) this.mMenuVisibilityListeners.get(i)).onMenuVisibilityChanged(z);
            }
        }
    }

    public View getCustomView() {
        return this.mActionView.getCustomNavigationView();
    }

    public int getDisplayOptions() {
        return this.mActionView.getDisplayOptions();
    }

    public int getHeight() {
        return this.mContainerView.getHeight();
    }

    public int getNavigationItemCount() {
        switch (this.mActionView.getNavigationMode()) {
            case CONTEXT_DISPLAY_SPLIT /*1*/:
                SpinnerAdapter dropdownAdapter = this.mActionView.getDropdownAdapter();
                return dropdownAdapter != null ? dropdownAdapter.getCount() : CONTEXT_DISPLAY_NORMAL;
            case C0519c.Switch_textOn /*2*/:
                return this.mTabs.size();
            default:
                return CONTEXT_DISPLAY_NORMAL;
        }
    }

    public int getNavigationMode() {
        return this.mActionView.getNavigationMode();
    }

    public int getSelectedNavigationIndex() {
        switch (this.mActionView.getNavigationMode()) {
            case CONTEXT_DISPLAY_SPLIT /*1*/:
                return this.mActionView.getDropdownSelectedPosition();
            case C0519c.Switch_textOn /*2*/:
                return this.mSelectedTab != null ? this.mSelectedTab.getPosition() : INVALID_POSITION;
            default:
                return INVALID_POSITION;
        }
    }

    public Tab getSelectedTab() {
        return this.mSelectedTab;
    }

    public CharSequence getSubtitle() {
        return this.mActionView.getSubtitle();
    }

    public Tab getTabAt(int i) {
        return (Tab) this.mTabs.get(i);
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public Context getThemedContext() {
        if (this.mThemedContext == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(C0086R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.mThemedContext = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.mThemedContext = this.mContext;
            }
        }
        return this.mThemedContext;
    }

    public CharSequence getTitle() {
        return this.mActionView.getTitle();
    }

    public void hide() {
        if (this.mCurrentShowAnim != null) {
            this.mCurrentShowAnim.end();
        }
        if (this.mContainerView.getVisibility() != 8) {
            if (this.mShowHideAnimationEnabled) {
                float[] fArr;
                this.mContainerView.setAlpha(1.0f);
                this.mContainerView.setTransitioning(true);
                Animator animatorSet = new AnimatorSet();
                float[] fArr2 = new float[CONTEXT_DISPLAY_SPLIT];
                fArr2[CONTEXT_DISPLAY_NORMAL] = 0.0f;
                Builder play = animatorSet.play(ObjectAnimator.ofFloat(this.mContainerView, "alpha", fArr2));
                if (this.mContentView != null) {
                    play.with(ObjectAnimator.ofFloat(this.mContentView, "translationY", 0.0f, (float) (-this.mContainerView.getHeight())));
                    fArr = new float[CONTEXT_DISPLAY_SPLIT];
                    fArr[CONTEXT_DISPLAY_NORMAL] = (float) (-this.mContainerView.getHeight());
                    play.with(ObjectAnimator.ofFloat(this.mContainerView, "translationY", fArr));
                }
                if (this.mSplitView != null && this.mSplitView.getVisibility() == 0) {
                    this.mSplitView.setAlpha(1.0f);
                    fArr = new float[CONTEXT_DISPLAY_SPLIT];
                    fArr[CONTEXT_DISPLAY_NORMAL] = 0.0f;
                    play.with(ObjectAnimator.ofFloat(this.mSplitView, "alpha", fArr));
                }
                animatorSet.addListener(this.mHideListener);
                this.mCurrentShowAnim = animatorSet;
                animatorSet.start();
                return;
            }
            this.mHideListener.onAnimationEnd(null);
        }
    }

    public boolean isShowing() {
        return this.mContainerView.getVisibility() == 0;
    }

    public Tab newTab() {
        return new TabImpl();
    }

    public void onConfigurationChanged(Configuration configuration) {
        setHasEmbeddedTabs(ResourcesCompat.getResources_getBoolean(this.mContext, C0086R.bool.abs__action_bar_embed_tabs));
        if (VERSION.SDK_INT < 8) {
            this.mActionView.onConfigurationChanged(configuration);
            if (this.mContextView != null) {
                this.mContextView.onConfigurationChanged(configuration);
            }
        }
    }

    public void removeAllTabs() {
        cleanupTabs();
    }

    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(onMenuVisibilityListener);
    }

    public void removeTab(Tab tab) {
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i) {
        if (this.mTabScrollView != null) {
            int position = this.mSelectedTab != null ? this.mSelectedTab.getPosition() : this.mSavedTabPosition;
            this.mTabScrollView.removeTabAt(i);
            TabImpl tabImpl = (TabImpl) this.mTabs.remove(i);
            if (tabImpl != null) {
                tabImpl.setPosition(INVALID_POSITION);
            }
            int size = this.mTabs.size();
            for (int i2 = i; i2 < size; i2 += CONTEXT_DISPLAY_SPLIT) {
                ((TabImpl) this.mTabs.get(i2)).setPosition(i2);
            }
            if (position == i) {
                Tab tab;
                if (this.mTabs.isEmpty()) {
                    tab = null;
                } else {
                    tabImpl = (TabImpl) this.mTabs.get(Math.max(CONTEXT_DISPLAY_NORMAL, i + INVALID_POSITION));
                }
                selectTab(tab);
            }
        }
    }

    public void selectTab(Tab tab) {
        int i = INVALID_POSITION;
        if (getNavigationMode() != 2) {
            this.mSavedTabPosition = tab != null ? tab.getPosition() : INVALID_POSITION;
            return;
        }
        FragmentTransaction fragmentTransaction = null;
        if (this.mActivity instanceof FragmentActivity) {
            fragmentTransaction = ((FragmentActivity) this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        }
        if (this.mSelectedTab != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (tab != null) {
                i = tab.getPosition();
            }
            scrollingTabContainerView.setTabSelected(i);
            if (this.mSelectedTab != null) {
                this.mSelectedTab.getCallback().onTabUnselected(this.mSelectedTab, fragmentTransaction);
            }
            this.mSelectedTab = (TabImpl) tab;
            if (this.mSelectedTab != null) {
                this.mSelectedTab.getCallback().onTabSelected(this.mSelectedTab, fragmentTransaction);
            }
        } else if (this.mSelectedTab != null) {
            this.mSelectedTab.getCallback().onTabReselected(this.mSelectedTab, fragmentTransaction);
            this.mTabScrollView.animateToTab(tab.getPosition());
        }
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
            fragmentTransaction.commit();
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mContainerView.setPrimaryBackground(drawable);
    }

    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.mActionView, false));
    }

    public void setCustomView(View view) {
        this.mActionView.setCustomNavigationView(view);
    }

    public void setCustomView(View view, LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.mActionView.setCustomNavigationView(view);
    }

    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : CONTEXT_DISPLAY_NORMAL, 4);
    }

    public void setDisplayOptions(int i) {
        this.mActionView.setDisplayOptions(i);
    }

    public void setDisplayOptions(int i, int i2) {
        this.mActionView.setDisplayOptions((this.mActionView.getDisplayOptions() & (i2 ^ INVALID_POSITION)) | (i & i2));
    }

    public void setDisplayShowCustomEnabled(boolean z) {
        setDisplayOptions(z ? 16 : CONTEXT_DISPLAY_NORMAL, 16);
    }

    public void setDisplayShowHomeEnabled(boolean z) {
        setDisplayOptions(z ? 2 : CONTEXT_DISPLAY_NORMAL, 2);
    }

    public void setDisplayShowTitleEnabled(boolean z) {
        setDisplayOptions(z ? 8 : CONTEXT_DISPLAY_NORMAL, 8);
    }

    public void setDisplayUseLogoEnabled(boolean z) {
        setDisplayOptions(z ? CONTEXT_DISPLAY_SPLIT : CONTEXT_DISPLAY_NORMAL, CONTEXT_DISPLAY_SPLIT);
    }

    public void setHomeButtonEnabled(boolean z) {
        this.mActionView.setHomeButtonEnabled(z);
    }

    public void setIcon(int i) {
        this.mActionView.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.mActionView.setIcon(drawable);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, OnNavigationListener onNavigationListener) {
        this.mActionView.setDropdownAdapter(spinnerAdapter);
        this.mActionView.setCallback(onNavigationListener);
    }

    public void setLogo(int i) {
        this.mActionView.setLogo(i);
    }

    public void setLogo(Drawable drawable) {
        this.mActionView.setLogo(drawable);
    }

    public void setNavigationMode(int i) {
        boolean z = false;
        switch (this.mActionView.getNavigationMode()) {
            case C0519c.Switch_textOn /*2*/:
                this.mSavedTabPosition = getSelectedNavigationIndex();
                selectTab(null);
                this.mTabScrollView.setVisibility(8);
                break;
        }
        this.mActionView.setNavigationMode(i);
        switch (i) {
            case C0519c.Switch_textOn /*2*/:
                ensureTabsExist();
                this.mTabScrollView.setVisibility(CONTEXT_DISPLAY_NORMAL);
                if (this.mSavedTabPosition != INVALID_POSITION) {
                    setSelectedNavigationItem(this.mSavedTabPosition);
                    this.mSavedTabPosition = INVALID_POSITION;
                    break;
                }
                break;
        }
        ActionBarView actionBarView = this.mActionView;
        if (i == 2 && !this.mHasEmbeddedTabs) {
            z = true;
        }
        actionBarView.setCollapsable(z);
    }

    public void setSelectedNavigationItem(int i) {
        switch (this.mActionView.getNavigationMode()) {
            case CONTEXT_DISPLAY_SPLIT /*1*/:
                this.mActionView.setDropdownSelectedPosition(i);
            case C0519c.Switch_textOn /*2*/:
                selectTab((Tab) this.mTabs.get(i));
            default:
                throw new IllegalStateException("setSelectedNavigationItem not valid for current navigation mode");
        }
    }

    public void setShowHideAnimationEnabled(boolean z) {
        this.mShowHideAnimationEnabled = z;
        if (!z && this.mCurrentShowAnim != null) {
            this.mCurrentShowAnim.end();
        }
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
        if (this.mSplitView != null) {
            this.mSplitView.setSplitBackground(drawable);
        }
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.mContainerView.setStackedBackground(drawable);
    }

    public void setSubtitle(int i) {
        setSubtitle(this.mContext.getString(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mActionView.setSubtitle(charSequence);
    }

    public void setTitle(int i) {
        setTitle(this.mContext.getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        this.mActionView.setTitle(charSequence);
    }

    public void show() {
        show(true);
    }

    void show(boolean z) {
        if (this.mCurrentShowAnim != null) {
            this.mCurrentShowAnim.end();
        }
        if (this.mContainerView.getVisibility() != 0) {
            this.mContainerView.setVisibility(CONTEXT_DISPLAY_NORMAL);
            if (this.mShowHideAnimationEnabled) {
                float[] fArr;
                this.mContainerView.setAlpha(0.0f);
                Animator animatorSet = new AnimatorSet();
                float[] fArr2 = new float[CONTEXT_DISPLAY_SPLIT];
                fArr2[CONTEXT_DISPLAY_NORMAL] = 1.0f;
                Builder play = animatorSet.play(ObjectAnimator.ofFloat(this.mContainerView, "alpha", fArr2));
                if (this.mContentView != null) {
                    play.with(ObjectAnimator.ofFloat(this.mContentView, "translationY", (float) (-this.mContainerView.getHeight()), 0.0f));
                    this.mContainerView.setTranslationY((float) (-this.mContainerView.getHeight()));
                    fArr = new float[CONTEXT_DISPLAY_SPLIT];
                    fArr[CONTEXT_DISPLAY_NORMAL] = 0.0f;
                    play.with(ObjectAnimator.ofFloat(this.mContainerView, "translationY", fArr));
                }
                if (this.mSplitView != null && this.mContextDisplayMode == CONTEXT_DISPLAY_SPLIT) {
                    this.mSplitView.setAlpha(0.0f);
                    this.mSplitView.setVisibility(CONTEXT_DISPLAY_NORMAL);
                    fArr = new float[CONTEXT_DISPLAY_SPLIT];
                    fArr[CONTEXT_DISPLAY_NORMAL] = 1.0f;
                    play.with(ObjectAnimator.ofFloat(this.mSplitView, "alpha", fArr));
                }
                animatorSet.addListener(this.mShowListener);
                this.mCurrentShowAnim = animatorSet;
                animatorSet.start();
                return;
            }
            this.mContainerView.setAlpha(1.0f);
            this.mContainerView.setTranslationY(0.0f);
            this.mShowListener.onAnimationEnd(null);
        } else if (z) {
            this.mWasHiddenBeforeMode = false;
        }
    }

    public ActionMode startActionMode(Callback callback) {
        boolean z;
        if (this.mActionMode != null) {
            z = this.mWasHiddenBeforeMode;
            this.mActionMode.finish();
        } else {
            z = false;
        }
        this.mContextView.killMode();
        ActionMode actionModeImpl = new ActionModeImpl(callback);
        if (!actionModeImpl.dispatchOnCreate()) {
            return null;
        }
        z = !isShowing() || z;
        this.mWasHiddenBeforeMode = z;
        actionModeImpl.invalidate();
        this.mContextView.initForMode(actionModeImpl);
        animateToMode(true);
        if (this.mSplitView != null && this.mContextDisplayMode == CONTEXT_DISPLAY_SPLIT) {
            this.mSplitView.setVisibility(CONTEXT_DISPLAY_NORMAL);
        }
        this.mContextView.sendAccessibilityEvent(32);
        this.mActionMode = actionModeImpl;
        return actionModeImpl;
    }
}
