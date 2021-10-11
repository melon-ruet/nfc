package com.nxp.taginfolite.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.BuildConfig;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.fragments.p020a.C0374c;
import com.nxp.taginfolite.fragments.p020a.C0381h;
import com.nxp.taginfolite.fragments.p021c.C0385g;
import com.nxp.taginfolite.fragments.p021c.C0396h;
import com.nxp.taginfolite.p000a.p001a.C0131a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.nxp.taginfolite.fragments.g */
public abstract class C0386g extends C0384x implements C0131a, C0385g {
    private List f1225A;
    protected Enum f1226a;
    protected Enum f1227b;
    protected Cursor f1228c;
    protected SparseBooleanArray f1229d;
    protected int f1230e;
    protected FragmentActivity f1231f;
    protected ContentResolver f1232g;
    protected C0374c f1233h;
    protected TextView f1234i;
    protected String[] f1235j;
    protected C0387l f1236k;
    protected Uri f1237l;
    protected int f1238m;
    protected int f1239n;
    protected int f1240o;
    protected int f1241p;
    protected int f1242q;
    protected int f1243r;
    protected int f1244s;
    protected int f1245t;
    private ActionMode f1246w;
    private C0396h f1247x;
    private View f1248y;
    private C0404n f1249z;

    public C0386g() {
        this.f1230e = 0;
    }

    public static Cursor m1194a(ContentResolver contentResolver, Uri uri, String str, String[] strArr, String str2) {
        return contentResolver.query(uri, null, str, strArr, str2);
    }

    public static String[] m1197a(String str, String[] strArr) {
        if (str == null) {
            return null;
        }
        String str2 = "%" + str.trim() + "%";
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuilder.append(" OR ");
            }
            stringBuilder.append(strArr[i]);
            stringBuilder.append(" LIKE ? ESCAPE '/' ");
        }
        return new String[]{stringBuilder.toString(), str2, str2, str2, str2};
    }

    private void m1199s() {
        ((TextView) this.f1248y.findViewById(this.f1242q)).setText(String.format("%d deleted", new Object[]{Integer.valueOf(this.f1230e)}));
        this.f1248y.setVisibility(0);
        this.f1249z = new C0404n(this);
        this.f1249z.m1307a();
    }

    public Enum m1200a() {
        return this.f1226a;
    }

    protected void m1201a(int i, long j) {
        this.f1233h.m1147a(i);
        this.f1229d = this.f1233h.m1155d();
        this.f1230e = this.f1233h.m1153c();
        Object obj = this.f1230e > 0 ? 1 : null;
        if (obj != null && this.f1246w == null) {
            m1210e();
        } else if (obj == null && this.f1246w != null) {
            this.f1246w.finish();
        }
    }

    protected abstract void m1202a(Menu menu, int i);

    public void m1203a(Enum enumR) {
        this.f1226a = enumR;
        m1215j();
    }

    public void m1204a(boolean z) {
        if (z) {
            if (this.f1228c == null || !this.f1228c.moveToFirst() || this.f1229d == null || this.f1230e == 0) {
                C0196b.m180a(this.f1231f, (int) R.string.toast_error_deleting);
                return;
            }
            m1218m();
        }
        m1215j();
        this.f1229d = null;
        this.f1230e = 0;
        this.f1225A = null;
        ActivityCompat.invalidateOptionsMenu(this.f1231f);
    }

    public boolean m1205a(int i) {
        int i2 = 0;
        boolean a = this.f1233h.m1150a();
        int count = this.f1233h.getCount();
        if (i == R.id.action_select_all) {
            if (a) {
                while (i2 < count) {
                    this.f1233h.m1154c(i2);
                    i2++;
                }
                this.f1246w.finish();
            } else {
                while (i2 < count) {
                    this.f1233h.m1152b(i2);
                    i2++;
                }
            }
        } else if (i == R.id.action_toggle_selection) {
            while (i2 < count) {
                this.f1233h.m1147a(i2);
                i2++;
            }
        }
        m1219n();
        if (this.f1246w != null) {
            m1202a(this.f1246w.getMenu(), this.f1233h.m1153c());
        }
        return true;
    }

    protected abstract Uri a_(long j);

    public Enum m1206b() {
        return this.f1227b;
    }

    public void m1207b(Enum enumR) {
        this.f1227b = enumR;
        m1215j();
    }

    protected abstract void m1208c();

    protected abstract String m1209d();

    @SuppressLint({"NewApi"})
    protected void m1210e() {
        m1217l();
        if (m1191q()) {
            ListView listView = getListView();
            int scrollY = listView.getScrollY();
            onQueryTextSubmit(m1190p());
            if (VERSION.SDK_INT >= 14) {
                listView.setScrollY(scrollY);
            }
        }
        this.f1246w = getSherlockActivity().startActionMode(this.f1236k);
        View inflate = LayoutInflater.from(this.f1231f).inflate(this.f1243r, null);
        if (inflate == null) {
            throw new NullPointerException("Cannot inflate mActionModeLayoutId");
        }
        this.f1246w.setCustomView(inflate);
        this.f1247x = new C0396h(this.f1231f, (Button) inflate.findViewById(this.f1244s), this);
        if (this.f1229d != null) {
            this.f1233h.m1149a(this.f1229d);
            this.f1230e = this.f1233h.m1153c();
            m1202a(this.f1246w.getMenu(), this.f1230e);
        } else {
            this.f1233h.m1151b();
        }
        m1219n();
    }

    protected boolean m1211f() {
        return this.f1246w != null;
    }

    protected Menu m1212g() {
        return m1211f() ? this.f1246w.getMenu() : null;
    }

    @SuppressLint({"NewApi"})
    public void m1213h() {
        this.f1225A = new ArrayList();
        if (this.f1228c != null && this.f1228c.moveToFirst() && this.f1229d != null && this.f1230e != 0) {
            int i = 0;
            do {
                if (this.f1229d.get(this.f1228c.getPosition())) {
                    i++;
                    this.f1225A.add(Long.valueOf(this.f1228c.getLong(this.f1228c.getColumnIndex("_id"))));
                }
                if (i >= this.f1230e) {
                    break;
                }
            } while (this.f1228c.moveToNext());
            i = getListView().getScrollY();
            m1214i();
            this.f1228c = new C0381h(this.f1228c, this.f1229d.clone());
            m1208c();
            getListView().scrollTo(0, i);
        }
    }

    public void m1214i() {
        String[] strArr = null;
        if (this.f1228c != null) {
            this.f1231f.stopManagingCursor(this.f1228c);
        }
        if (this.f1231f != null) {
            String str;
            String[] a = C0386g.m1197a(m1190p(), this.f1235j);
            if (a != null) {
                str = a[0];
                strArr = (String[]) Arrays.copyOfRange(a, 1, a.length);
            } else {
                str = null;
            }
            this.f1228c = C0386g.m1194a(this.f1232g, this.f1237l, str, strArr, m1209d());
            if (!(str == null || this.f1228c == null || this.f1228c.getCount() != 0 || this.f1234i == null)) {
                this.f1234i.setText(this.f1239n);
            }
            this.f1231f.startManagingCursor(this.f1228c);
        }
    }

    public void m1215j() {
        m1214i();
        m1208c();
    }

    protected void m1216k() {
        m1213h();
        m1199s();
        this.f1231f.supportInvalidateOptionsMenu();
    }

    protected void m1217l() {
        if (this.f1249z != null) {
            this.f1249z.m1310d();
        }
    }

    protected void m1218m() {
        if (this.f1225A != null) {
            for (Long longValue : this.f1225A) {
                Uri a_ = a_(longValue.longValue());
                if (a_ != null) {
                    this.f1232g.delete(a_, null, null);
                }
            }
            this.f1225A = null;
        }
    }

    protected void m1219n() {
        if (this.f1247x != null) {
            this.f1230e = this.f1233h.m1153c();
            this.f1247x.m1296a(String.valueOf(this.f1230e) + " selected");
            this.f1247x.m1295a(this.f1230e, this.f1233h.m1150a());
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f1231f = getActivity();
        this.f1232g = activity.getContentResolver();
        if (activity instanceof C0162m) {
            ((C0162m) activity).m88a(this);
        }
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.f1238m, viewGroup, false);
        if (inflate == null) {
            throw new NullPointerException("Cannot inflate mListFragmentLayoutId");
        }
        this.f1248y = inflate.findViewById(this.f1240o);
        this.f1234i = (TextView) inflate.findViewById(16908292);
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("ListFragment2bdeleted");
            if (intArray != null && intArray.length > 0) {
                m1214i();
                if (!(this.f1228c == null || !this.f1228c.moveToFirst() || this.f1229d == null || this.f1230e == 0)) {
                    this.f1230e = intArray.length;
                    this.f1229d = new SparseBooleanArray();
                    for (int i = 0; i < this.f1230e; i++) {
                        this.f1229d.put(intArray[i], true);
                    }
                }
            }
        }
        return inflate;
    }

    public void onDetach() {
        this.f1231f.stopManagingCursor(this.f1228c);
        super.onDetach();
    }

    public void onPause() {
        if (this.f1249z != null) {
            this.f1249z.m1311e();
        }
        m1218m();
        super.onPause();
    }

    public boolean onQueryTextChange(String str) {
        this.u = str;
        m1215j();
        return true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.f1225A != null) {
            this.f1249z.removeCallbacksAndMessages(null);
            int[] iArr = new int[this.f1230e];
            int i = 0;
            if (!(this.f1228c == null || !this.f1228c.moveToFirst() || this.f1229d == null || this.f1230e == 0)) {
                do {
                    int position = this.f1228c.getPosition();
                    if (this.f1229d.get(position)) {
                        int i2 = i + 1;
                        iArr[i] = position;
                        i = i2;
                    }
                    if (i >= this.f1230e) {
                        break;
                    }
                } while (this.f1228c.moveToNext());
                bundle.putIntArray("ListFragment2bdeleted", iArr);
            }
        }
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        ListView listView = getListView();
        listView.setFastScrollEnabled(true);
        listView.setSmoothScrollbarEnabled(false);
        m1215j();
        setHasOptionsMenu(true);
        listView.setOnItemLongClickListener(new C0400h(this));
        this.f1248y.setVisibility(8);
        this.f1248y.setOnTouchListener(new C0401i(this));
        ((Button) this.f1248y.findViewById(this.f1241p)).setOnClickListener(new C0402j(this));
        listView.setOnScrollListener(new C0403k(this));
        if (this.f1246w != null) {
            m1210e();
        } else if (this.f1230e > 0 && this.f1229d != null) {
            m1216k();
            this.f1249z.m1308b();
        }
    }
}
