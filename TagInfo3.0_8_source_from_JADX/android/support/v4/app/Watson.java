package android.support.v4.app;

import android.view.View;
import com.actionbarsherlock.ActionBarSherlock.OnCreatePanelMenuListener;
import com.actionbarsherlock.ActionBarSherlock.OnMenuItemSelectedListener;
import com.actionbarsherlock.ActionBarSherlock.OnPreparePanelListener;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import java.util.ArrayList;

public abstract class Watson extends FragmentActivity implements OnCreatePanelMenuListener, OnMenuItemSelectedListener, OnPreparePanelListener {
    private static final String TAG = "Watson";
    private ArrayList mCreatedMenus;

    public interface OnCreateOptionsMenuListener {
        void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater);
    }

    public interface OnOptionsItemSelectedListener {
        boolean onOptionsItemSelected(MenuItem menuItem);
    }

    public interface OnPrepareOptionsMenuListener {
        void onPrepareOptionsMenu(Menu menu);
    }

    public abstract MenuInflater getSupportMenuInflater();

    public abstract boolean onCreateOptionsMenu(Menu menu);

    public boolean onCreatePanelMenu(int i, Menu menu) {
        int i2 = 0;
        if (i != 0) {
            return false;
        }
        int i3;
        Fragment fragment;
        boolean onCreateOptionsMenu = onCreateOptionsMenu(menu);
        MenuInflater supportMenuInflater = getSupportMenuInflater();
        ArrayList arrayList = null;
        if (this.mFragments.mAdded != null) {
            int i4 = 0;
            i3 = 0;
            while (i4 < this.mFragments.mAdded.size()) {
                int i5;
                fragment = (Fragment) this.mFragments.mAdded.get(i4);
                if (fragment != null && !fragment.mHidden && fragment.mHasMenu && fragment.mMenuVisible && (fragment instanceof OnCreateOptionsMenuListener)) {
                    ((OnCreateOptionsMenuListener) fragment).onCreateOptionsMenu(menu, supportMenuInflater);
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    arrayList2.add(fragment);
                    arrayList = arrayList2;
                    i5 = 1;
                } else {
                    i5 = i3;
                }
                i4++;
                i3 = i5;
            }
        } else {
            i3 = 0;
        }
        if (this.mCreatedMenus != null) {
            while (i2 < this.mCreatedMenus.size()) {
                fragment = (Fragment) this.mCreatedMenus.get(i2);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
                i2++;
            }
        }
        this.mCreatedMenus = arrayList;
        return onCreateOptionsMenu | i3;
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (i != 0) {
            return false;
        }
        if (onOptionsItemSelected(menuItem)) {
            return true;
        }
        if (this.mFragments.mAdded == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.mFragments.mAdded.size(); i2++) {
            Fragment fragment = (Fragment) this.mFragments.mAdded.get(i2);
            if (fragment != null && !fragment.mHidden && fragment.mHasMenu && fragment.mMenuVisible && (fragment instanceof OnOptionsItemSelectedListener) && ((OnOptionsItemSelectedListener) fragment).onOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public abstract boolean onOptionsItemSelected(MenuItem menuItem);

    public abstract boolean onPrepareOptionsMenu(Menu menu);

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0) {
            return false;
        }
        int i2;
        boolean onPrepareOptionsMenu = onPrepareOptionsMenu(menu);
        if (this.mFragments.mAdded != null) {
            i2 = 0;
            for (int i3 = 0; i3 < this.mFragments.mAdded.size(); i3++) {
                Fragment fragment = (Fragment) this.mFragments.mAdded.get(i3);
                if (fragment != null && !fragment.mHidden && fragment.mHasMenu && fragment.mMenuVisible && (fragment instanceof OnPrepareOptionsMenuListener)) {
                    i2 = 1;
                    ((OnPrepareOptionsMenuListener) fragment).onPrepareOptionsMenu(menu);
                }
            }
        } else {
            i2 = 0;
        }
        return (onPrepareOptionsMenu | i2) & menu.hasVisibleItems();
    }
}
