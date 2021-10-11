package com.nxp.taginfolite.fragments;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.BuildConfig;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.C0206d;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.activities.MainView;
import com.nxp.taginfolite.data.C0212f;
import com.nxp.taginfolite.database.C0233b;
import com.nxp.taginfolite.database.C0234c;
import com.nxp.taginfolite.database.provider.ScanHistory;
import com.nxp.taginfolite.fragments.p020a.C0379f;
import com.nxp.taginfolite.p000a.C0136e;
import com.nxp.taginfolite.p000a.C0140i;
import com.nxp.taginfolite.p000a.C0141j;
import com.nxp.taginfolite.p000a.af;
import com.nxp.taginfolite.p000a.aj;
import com.nxp.taginfolite.p000a.ak;
import com.nxp.taginfolite.p003g.C0164e;
import com.nxp.taginfolite.p003g.C0423b;
import java.util.ArrayList;
import java.util.List;
import org.jraf.android.backport.switchwidget.C0519c;
import org.xmlpull.v1.XmlPullParserException;

public class aa extends C0386g implements C0140i, C0164e {
    public static final String[] f1250w;
    private C0158a f1251x;

    static {
        f1250w = new String[]{"uid", "title", "data", "comment"};
    }

    public aa() {
        this.a = ak.DESC;
        this.b = aj.TIME;
    }

    private void m1220A() {
        new C0234c(this.f).execute(new String[]{BuildConfig.VERSION_NAME});
    }

    public static String m1221a(String str, String str2) {
        return str2 + " " + str + ", " + "timeMax" + " " + str;
    }

    private void m1222a(Intent intent) {
        if (this.f1251x.m51i()) {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager.findFragmentByTag("fragment_show_subject") == null) {
                C0141j c0141j = new C0141j();
                c0141j.m28a(intent);
                c0141j.show(fragmentManager, "fragment_show_subject");
            }
        } else {
            C0206d.m259a(this.f, intent);
        }
        this.h.m1151b();
    }

    public static void m1223a(Cursor cursor, long j, C0158a c0158a, Context context) {
        C0212f.m299a(cursor.getString(cursor.getColumnIndex("data")), cursor.getString(cursor.getColumnIndex("title")));
        c0158a.m34a(j);
        Intent intent = new Intent(context, MainView.class);
        intent.setAction("TagInfo_Mainview.SHOW_DATA");
        context.startActivity(intent);
    }

    private void m1226b(long j) {
        C0233b g = m1236g(j);
        if (g != null) {
            m1188a(g.m351d());
        }
        this.d = null;
    }

    private void m1229c(long j) {
        C0233b g = m1236g(j);
        if (g != null) {
            Intent a = C0206d.m255a(this.f, "message/rfc822", g, m1245a(j));
            if (a != null) {
                m1222a(a);
            }
        }
    }

    private void m1231d(long j) {
        C0233b g = m1236g(j);
        if (g != null) {
            C0206d.m261a(this.f, g, m1245a(j));
        }
    }

    private void m1233e(long j) {
        byte[] bArr = null;
        Uri withAppendedPath = Uri.withAppendedPath(ScanHistory.f335a, Long.toString(j));
        if (withAppendedPath != null) {
            Cursor query = this.g.query(withAppendedPath, null, null, null, null);
            if (query != null && query.moveToFirst()) {
                bArr = query.getBlob(query.getColumnIndex("ndef"));
                query.close();
            }
        }
        if (bArr == null) {
            C0196b.m180a(this.f, (int) R.string.toast_no_ndef);
        } else {
            C0206d.m264a(this.f, bArr);
        }
    }

    private void m1235f(long j) {
        if (m1245a(j) != null) {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager.findFragmentByTag("fragment_edit_title") == null) {
                Bundle bundle = new Bundle();
                bundle.putLong("edit_id", j);
                C0136e c0136e = new C0136e();
                c0136e.setArguments(bundle);
                c0136e.setTargetFragment(this, 0);
                c0136e.show(fragmentManager, "fragment_edit_title");
            }
        }
    }

    private C0233b m1236g(long j) {
        C0233b c0233b = null;
        Uri withAppendedPath = Uri.withAppendedPath(ScanHistory.f335a, Long.toString(j));
        if (withAppendedPath != null) {
            Cursor query = this.g.query(withAppendedPath, c0233b, c0233b, c0233b, c0233b);
            if (query != null && query.moveToFirst()) {
                String string = query.getString(query.getColumnIndex("data"));
                query.close();
                try {
                    c0233b = C0233b.m344a(this.f, string);
                } catch (XmlPullParserException e) {
                }
            }
        }
        return c0233b;
    }

    public static String m1237s() {
        return m1221a(" DESC", "timeMax");
    }

    private void m1238t() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager.findFragmentByTag("fragment_sort_order") == null) {
            af afVar = new af();
            afVar.setTargetFragment(this, 0);
            afVar.show(fragmentManager, "fragment_sort_order");
        }
    }

    private void m1239u() {
        new C0423b().m1371a(this.f, "sqlite");
    }

    private String m1240v() {
        switch (ab.f1252a[((aj) this.b).ordinal()]) {
            case C0519c.Switch_track /*1*/:
                return "timeMax";
            case C0519c.Switch_textOn /*2*/:
                return "title";
            case C0519c.Switch_textOff /*3*/:
                return "ndef";
            case C0519c.Switch_thumbTextPadding /*4*/:
                return "uid";
            default:
                return "timeMax";
        }
    }

    private String m1241w() {
        switch (ab.f1253b[((ak) this.a).ordinal()]) {
            case C0519c.Switch_track /*1*/:
                return " ASC";
            case C0519c.Switch_textOn /*2*/:
                return " DESC";
            default:
                return " DESC";
        }
    }

    private List m1242x() {
        if (this.c == null || !this.c.moveToFirst() || this.d == null || this.e == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int columnIndex = this.c.getColumnIndex("_id");
        do {
            if (this.d.get(this.c.getPosition())) {
                i++;
                arrayList.add(m1236g(this.c.getLong(columnIndex)));
            }
            if (i >= this.e) {
                break;
            }
        } while (this.c.moveToNext());
        return arrayList;
    }

    private void m1243y() {
        Intent a = C0206d.m256a(this.f, "message/rfc822", m1242x());
        if (a != null) {
            m1222a(a);
        }
    }

    private void m1244z() {
        C0206d.m262a(this.f, m1242x());
    }

    public String m1245a(long j) {
        Uri withAppendedPath = Uri.withAppendedPath(ScanHistory.f335a, Long.toString(j));
        if (withAppendedPath == null) {
            return null;
        }
        Cursor query = this.g.query(withAppendedPath, null, null, null, null);
        return (query == null || !query.moveToFirst()) ? null : query.getString(query.getColumnIndex("title"));
    }

    protected void m1246a(int i, long j) {
        String[] strArr = null;
        super.m1201a(i, j);
        if (m1211f()) {
            Menu g = m1212g();
            m1249a(g, this.e);
            if (this.h.m1153c() == 1) {
                int keyAt = this.h.m1155d().keyAt(0);
                if (keyAt != i) {
                    j = this.h.getItemId(keyAt);
                }
                Uri withAppendedPath = Uri.withAppendedPath(ScanHistory.f335a, Long.toString(j));
                if (withAppendedPath != null) {
                    Cursor query = this.g.query(withAppendedPath, null, null, null, null);
                    if (query != null && query.moveToFirst()) {
                        strArr = query.getBlob(query.getColumnIndex("ndef"));
                        query.close();
                    }
                    MenuItem findItem = g.findItem(R.id.send_scan_ndef);
                    boolean z = strArr != null && strArr.length > 0;
                    findItem.setVisible(z);
                    return;
                }
                return;
            }
            g.findItem(R.id.send_scan_ndef).setVisible(false);
        }
    }

    public void m1247a(long j, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", str);
        Uri withAppendedPath = Uri.withAppendedPath(ScanHistory.f336b, Long.toString(j));
        if (withAppendedPath == null || this.g.update(withAppendedPath, contentValues, null, null) == -1) {
            C0196b.m180a(this.f, (int) R.string.toast_file_write_error);
        }
        this.h.m1151b();
        m1215j();
    }

    public void m1248a(Uri uri) {
        this.g.query(ScanHistory.f340f, null, uri.getPath(), null, null);
        try {
            m1215j();
        } catch (SQLException e) {
            C0196b.m180a(this.f, (int) R.string.toast_file_read_error);
            this.g.query(ScanHistory.f340f, null, null, null, null);
            m1215j();
        }
    }

    protected void m1249a(Menu menu, int i) {
        if (this.f1251x.m49g()) {
            menu.findItem(R.id.send_scan).setVisible(true);
            menu.findItem(R.id.share_scan).setVisible(false);
        } else {
            menu.findItem(R.id.send_scan).setVisible(false);
            menu.findItem(R.id.share_scan).setVisible(true);
        }
        menu.findItem(R.id.delete_scan).setVisible(true);
        switch (i) {
            case C0519c.Switch_thumb /*0*/:
                menu.findItem(R.id.send_scan).setVisible(false);
                menu.findItem(R.id.share_scan).setVisible(false);
                menu.findItem(R.id.find_similar).setVisible(false);
                menu.findItem(R.id.edit_scan_title).setVisible(false);
                menu.findItem(R.id.delete_scan).setVisible(false);
                menu.findItem(R.id.compare_scans).setVisible(false);
                menu.findItem(R.id.send_scan_ndef).setVisible(false);
                break;
            case C0519c.Switch_track /*1*/:
                menu.findItem(R.id.find_similar).setVisible(true);
                menu.findItem(R.id.edit_scan_title).setVisible(true);
                menu.findItem(R.id.compare_scans).setVisible(false);
                break;
            case C0519c.Switch_textOn /*2*/:
                menu.findItem(R.id.compare_scans).setVisible(true);
                menu.findItem(R.id.find_similar).setVisible(false);
                menu.findItem(R.id.edit_scan_title).setVisible(false);
                menu.findItem(R.id.send_scan_ndef).setVisible(false);
                break;
            default:
                menu.findItem(R.id.compare_scans).setVisible(false);
                menu.findItem(R.id.find_similar).setVisible(false);
                menu.findItem(R.id.edit_scan_title).setVisible(false);
                menu.findItem(R.id.send_scan_ndef).setVisible(false);
                break;
        }
        m1219n();
    }

    protected Uri a_(long j) {
        return Uri.withAppendedPath(ScanHistory.f335a, Long.toString(j));
    }

    public void m1250c() {
        this.h = new C0379f(this.f, this.c, new String[]{"title", "time", "uid", "hasndef", "taglost"}, new int[]{R.id.scanTitle, R.id.scan_time, R.id.scan_uid, R.id.scan_has_ndef, R.id.scan_tag_lost}, this.f1251x.m67y());
        setListAdapter(this.h);
    }

    protected String m1251d() {
        return m1221a(m1241w(), m1240v());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            return;
        }
        if ((i == 41 || i == 42) && intent != null) {
            m1248a(intent.getData());
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        m1187a(menu, R.string.search_scans_hint, R.string.menu_search_scans);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1251x = C0158a.m30a(this.f.getApplicationContext());
        this.j = f1250w;
        this.m = R.layout.scandb_list_fragment;
        this.n = R.string.no_scans_found;
        this.o = R.id.scandb_undo_bar;
        this.p = R.id.scandb_undo_bar_button;
        this.q = R.id.scandb_undo_bar_text;
        this.r = R.layout.scandb_action_mode;
        this.s = R.id.scandb_selection_menu;
        this.t = R.menu.scanlist_context_action_bar;
        this.k = new ac();
        this.l = ScanHistory.f335a;
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        m1217l();
        if (m1211f()) {
            m1246a(i, j);
            return;
        }
        ((InputMethodManager) this.f.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        this.f1251x.m45d(m1190p());
        m1223a(this.c, j, this.f1251x, this.f);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        m1217l();
        switch (menuItem.getItemId()) {
            case R.id.mark_items:
                this.d = null;
                m1210e();
                return true;
            case R.id.sortBy:
                m1238t();
                return true;
            case R.id.exportAllScans:
                m1220A();
                return true;
            case R.id.switchDb:
                m1239u();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.sortBy).setVisible(true);
        if (this.c == null || this.c.getCount() == 0) {
            menu.findItem(R.id.mark_items).setVisible(false);
            menu.findItem(R.id.exportAllScans).setVisible(false);
            menu.findItem(R.id.sortBy).setVisible(false);
            menu.findItem(R.id.mark_items).setVisible(false);
            m1192r();
        }
    }
}
