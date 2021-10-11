package com.nxp.taginfolite.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.actionbarsherlock.internal.widget.IcsAdapterView;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.data.AuthKey;
import com.nxp.taginfolite.fragments.C0382c;
import com.nxp.taginfolite.fragments.C0383a;
import com.nxp.taginfolite.fragments.C0406p;
import com.nxp.taginfolite.fragments.C0419w;
import com.nxp.taginfolite.fragments.ah;
import com.nxp.taginfolite.p000a.C0156y;
import com.nxp.taginfolite.p000a.ab;
import java.util.HashMap;
import org.jraf.android.backport.switchwidget.C0519c;

public class KeyEditor extends C0160g implements ab {
    private static final HashMap f76f;

    static {
        f76f = new C0172j();
    }

    private void m82a(C0382c c0382c) {
        Bundle arguments = c0382c.getArguments();
        Bundle extras = getIntent().getExtras();
        if (arguments == null || extras == null) {
            arguments = extras;
        } else {
            arguments.putAll(extras);
        }
        if (arguments != null) {
            c0382c.setArguments(arguments);
        }
        getSupportFragmentManager().beginTransaction().add(R.id.key_editor_fragment_container, c0382c, "TagInfo_KeyEditorkey_editor").commit();
    }

    private C0382c m83b(int i) {
        C0382c c0382c = null;
        Bundle bundle = new Bundle();
        switch (i) {
            case IcsAdapterView.ITEM_VIEW_TYPE_IGNORE /*-1*/:
                break;
            case C0519c.Switch_thumb /*0*/:
                c0382c = new C0406p();
                break;
            case C0519c.Switch_track /*1*/:
                c0382c = new ah();
                break;
            case C0519c.Switch_textOn /*2*/:
                c0382c = new C0383a();
                break;
            case C0519c.Switch_textOff /*3*/:
                c0382c = new C0419w();
                bundle.putString("TagInfo_NtagKeyEditorFragmentkey_type", "21X");
                break;
            case C0519c.Switch_thumbTextPadding /*4*/:
                c0382c = new C0419w();
                bundle.putString("TagInfo_NtagKeyEditorFragmentkey_type", "UL1");
                break;
            default:
                C0196b.m180a((Context) this, (int) R.string.toast_function_not_implemented);
                m87b();
                break;
        }
        if (!(bundle.isEmpty() || c0382c == null)) {
            c0382c.setArguments(bundle);
        }
        return c0382c;
    }

    private int m84c() {
        Intent intent = getIntent();
        if ("TagInfo_KeyEditoredit_key".equals(intent.getAction()) && intent.hasExtra("TagInfo_KeyEditorkey_data")) {
            AuthKey authKey = (AuthKey) intent.getExtras().getParcelable("TagInfo_KeyEditorkey_data");
            if (authKey != null) {
                Integer num = (Integer) f76f.get(authKey.m269c());
                if (num != null) {
                    return num.intValue();
                }
            }
        }
        m85d();
        return -1;
    }

    private void m85d() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag("fragment_new_key") == null) {
            new C0156y().show(supportFragmentManager, "fragment_new_key");
        }
    }

    public void m86a(int i) {
        C0382c b = m83b(i);
        if (b != null) {
            m82a(b);
        }
    }

    public void m87b() {
        finish();
    }

    public void onBackPressed() {
        C0382c c0382c = (C0382c) getSupportFragmentManager().findFragmentByTag("TagInfo_KeyEditorkey_editor");
        if (c0382c != null && c0382c.m1167e()) {
            if (c0382c.m1165c()) {
                c0382c.m1168f();
            } else {
                c0382c.m1166d();
            }
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.key_editor);
        if (bundle == null) {
            C0382c b = m83b(m84c());
            if (b != null) {
                m82a(b);
            }
        }
    }
}
