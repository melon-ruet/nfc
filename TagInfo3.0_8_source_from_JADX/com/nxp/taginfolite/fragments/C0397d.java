package com.nxp.taginfolite.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.activities.KeyEditor;
import com.nxp.taginfolite.data.AuthKey;
import com.nxp.taginfolite.database.provider.UserKeys;
import com.nxp.taginfolite.fragments.p020a.C0375a;
import com.nxp.taginfolite.p000a.C0150s;
import com.nxp.taginfolite.p000a.C0154w;
import com.nxp.taginfolite.p000a.C0155x;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.fragments.d */
public class C0397d extends C0386g {
    public C0397d() {
        this.a = C0155x.ASC;
        this.b = C0154w.TITLE;
    }

    private void m1298b(int i) {
        this.c.move(i);
        C0382c.m1159a(AuthKey.m265a(this.c), true, this.f);
        m1215j();
    }

    private void m1299s() {
        m1217l();
        Intent intent = new Intent(this.f, KeyEditor.class);
        intent.setAction("TagInfo_KeyEditoradd_key");
        intent.putExtra("KeyManagerFragment.QUERY", m1190p());
        startActivity(intent);
    }

    private void m1300t() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager.findFragmentByTag("fragment_sort_order") == null) {
            C0150s c0150s = new C0150s();
            c0150s.setTargetFragment(this, 0);
            c0150s.show(fragmentManager, "fragment_sort_order");
        }
    }

    private String m1301u() {
        switch (C0398e.f1296a[((C0154w) this.b).ordinal()]) {
            case C0519c.Switch_track /*1*/:
                return "title";
            case C0519c.Switch_textOn /*2*/:
                return "enabled";
            case C0519c.Switch_textOff /*3*/:
                return "chip";
            default:
                return "_id";
        }
    }

    private String m1302v() {
        switch (C0398e.f1297b[((C0155x) this.a).ordinal()]) {
            case C0519c.Switch_track /*1*/:
                return " ASC";
            case C0519c.Switch_textOn /*2*/:
                return " DESC";
            default:
                return " DESC";
        }
    }

    protected void m1303a(int i, long j) {
        super.m1201a(i, j);
        if (m1211f()) {
            m1304a(m1212g(), this.e);
            if (this.h.m1153c() == 1) {
                int keyAt = this.h.m1155d().keyAt(0);
                if (keyAt != i) {
                    this.h.getItemId(keyAt);
                }
            }
        }
    }

    protected void m1304a(Menu menu, int i) {
        menu.findItem(R.id.delete_key).setVisible(true);
        menu.findItem(R.id.copy_key).setVisible(false);
        switch (i) {
            case C0519c.Switch_thumb /*0*/:
                menu.findItem(R.id.delete_key).setVisible(false);
                break;
            case C0519c.Switch_track /*1*/:
                menu.findItem(R.id.copy_key).setVisible(true);
                break;
        }
        m1219n();
    }

    protected Uri a_(long j) {
        return Uri.withAppendedPath(UserKeys.f350c, Long.toString(j));
    }

    public void m1305c() {
        this.h = new C0375a(this.f, this.c, new String[]{"title", "enabled", "chip"}, new int[]{R.id.key_title, R.id.key_enabled, R.id.key_type, R.id.key_summary});
        setListAdapter(this.h);
    }

    protected String m1306d() {
        return m1301u() + " " + m1302v();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        m1187a(menu, R.string.search_keys_hint, R.string.menu_search_keys);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.j = new String[]{"chip", "title", "key_type", "chip_var", "key_value"};
        this.m = R.layout.key_manager_fragment;
        this.n = R.string.no_keys_found;
        this.o = R.id.key_manager_undo_bar;
        this.p = R.id.key_manager_undo_bar_button;
        this.q = R.id.key_manager_undo_bar_text;
        this.r = R.layout.key_manager_action_mode;
        this.s = R.id.key_manager_selection_menu;
        this.t = R.menu.keymanager_context_action_bar;
        this.k = new C0399f();
        this.l = UserKeys.f350c;
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        m1217l();
        if (m1211f()) {
            m1303a(i, j);
            return;
        }
        ((InputMethodManager) this.f.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        Intent intent = new Intent(this.f, KeyEditor.class);
        intent.setAction("TagInfo_KeyEditoredit_key");
        intent.putExtra("TagInfo_KeyEditorkey_id", Long.valueOf(this.c.getLong(this.c.getColumnIndex("_id"))));
        intent.putExtra("TagInfo_KeyEditorkey_data", AuthKey.m265a(this.c));
        intent.putExtra("KeyManagerFragment.QUERY", m1190p());
        startActivity(intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        m1217l();
        switch (menuItem.getItemId()) {
            case R.id.add_key:
                m1299s();
                return true;
            case R.id.mark_items:
                this.d = null;
                m1210e();
                return true;
            case R.id.sortBy:
                m1300t();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.sortBy).setVisible(true);
        if (this.c == null || this.c.getCount() == 0) {
            menu.findItem(R.id.mark_items).setVisible(false);
            menu.findItem(R.id.sortBy).setVisible(false);
            m1192r();
        }
    }
}
