package com.nxp.taginfolite.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.actionbarsherlock.app.SherlockFragment;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.fragments.p020a.C0377d;
import com.nxp.taginfolite.fragments.p022b.C0388a;

public class ad extends SherlockFragment implements OnGestureListener {
    public af f1256a;
    private int f1257b;
    private View f1258c;
    private ListView f1259d;
    private C0388a f1260e;

    public ad() {
        this.f1258c = null;
        this.f1259d = null;
    }

    public static ad m1252a(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("TagInfo_ScanViewFragment.INDEX", i);
        ad adVar = new ad();
        adVar.setArguments(bundle);
        return adVar;
    }

    private void m1254a(C0377d c0377d) {
        if (this.f1259d != null) {
            this.f1259d.setAdapter(c0377d);
            this.f1259d.setVisibility(0);
            if (this.f1258c != null) {
                this.f1258c.findViewById(R.id.emptyScanList).setVisibility(8);
            }
        } else if (this.f1258c != null) {
            this.f1258c.findViewById(R.id.emptyScanList).setVisibility(0);
        }
    }

    public void m1255a() {
        m1254a(this.f1256a.m95a(this));
    }

    public int m1256b() {
        return this.f1257b;
    }

    public void onAttach(Activity activity) {
        this.f1257b = getArguments().getInt("TagInfo_ScanViewFragment.INDEX");
        if (this.f1257b < 0 || this.f1257b > 3) {
            Log.e("TagInfo_ScanViewFragment", "TabIndex number must be between 0 and 3 but is: " + this.f1257b);
            this.f1257b = 0;
        }
        super.onAttach(activity);
        if (activity instanceof af) {
            this.f1256a = (af) activity;
            this.f1256a.m96b(this);
            return;
        }
        throw new ClassCastException(activity.toString() + " must implement UpdateScanView Listener");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1258c = layoutInflater.inflate(R.layout.scanview_fragment, viewGroup, false);
        return this.f1258c;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent2 == null || this.f1259d == null) {
            return false;
        }
        if (this.f1260e.m1272b()) {
            if (f2 < 0.0f) {
                this.f1259d.setSelection(this.f1259d.getCount() - 1);
            } else {
                this.f1259d.setSelection(0);
            }
            this.f1260e.m1274d();
            this.f1260e.m1273c();
            return false;
        } else if (!this.f1260e.m1271a()) {
            return false;
        } else {
            if (f2 < 0.0f) {
                this.f1259d.smoothScrollToPosition(this.f1259d.getCount() - 1);
            } else {
                this.f1259d.smoothScrollToPosition(0);
            }
            this.f1260e.m1273c();
            return true;
        }
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f1259d = (ListView) this.f1258c.findViewById(R.id.scanList);
        this.f1260e = new C0388a(getActivity(), this);
        this.f1259d.setFastScrollEnabled(true);
        this.f1259d.setSmoothScrollbarEnabled(false);
        this.f1259d.setOnTouchListener(new ae(this));
        m1255a();
    }
}
