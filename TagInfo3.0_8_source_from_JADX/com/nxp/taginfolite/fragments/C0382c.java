package com.nxp.taginfolite.fragments;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.LayoutParams;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.nxp.taginfolite.C0196b;
import com.nxp.taginfolite.R;
import com.nxp.taginfolite.activities.KeyEditor;
import com.nxp.taginfolite.data.AuthKey;
import com.nxp.taginfolite.database.provider.UserKeys;
import com.nxp.taginfolite.p003g.C0429j;
import org.jraf.android.backport.switchwidget.Switch;

/* renamed from: com.nxp.taginfolite.fragments.c */
public abstract class C0382c extends SherlockFragment implements OnCheckedChangeListener {
    protected Switch f1213a;
    protected boolean f1214b;
    protected boolean f1215c;
    protected AuthKey f1216d;
    protected AuthKey f1217e;

    public C0382c() {
        this.f1214b = false;
        this.f1215c = false;
        this.f1216d = null;
        this.f1217e = null;
    }

    public static void m1159a(AuthKey authKey, boolean z, Activity activity) {
        if (authKey != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", authKey.m266a());
            contentValues.put("chip", authKey.m269c());
            contentValues.put("chip_var", authKey.m270d());
            contentValues.put("selector_type", authKey.m271e());
            contentValues.put("selector_value", authKey.m272f());
            contentValues.put("key_type", authKey.m275i());
            contentValues.put("key_value", authKey.m276j());
            contentValues.put("subselector", authKey.m273g());
            contentValues.put("subselector_value", authKey.m274h());
            contentValues.put("enabled", Integer.valueOf(authKey.m268b() ? 1 : 0));
            ContentResolver contentResolver = activity.getContentResolver();
            Intent intent = activity.getIntent();
            if (z) {
                contentResolver.insert(UserKeys.f350c, contentValues);
            } else if (intent.hasExtra("TagInfo_KeyEditorkey_id")) {
                Uri withAppendedPath = Uri.withAppendedPath(UserKeys.f350c, Long.toString(intent.getLongExtra("TagInfo_KeyEditorkey_id", -1)));
                if (withAppendedPath == null || contentResolver.update(withAppendedPath, contentValues, null, null) == -1) {
                    C0196b.m180a((Context) activity, (int) R.string.toast_file_write_error);
                }
            } else {
                C0196b.m180a((Context) activity, (int) R.string.toast_function_not_implemented);
            }
        }
    }

    protected String m1160a(Activity activity, int i) {
        CharSequence text = ((TextView) activity.findViewById(i)).getText();
        return (text == null || TextUtils.isEmpty(text)) ? null : text.toString();
    }

    protected abstract void m1161a();

    protected byte[] m1162a(Activity activity, int i, int i2) {
        CharSequence text = ((TextView) activity.findViewById(i)).getText();
        return (text == null || TextUtils.isEmpty(text)) ? null : C0429j.m1397a(text.toString(), i2);
    }

    public abstract int m1163b();

    protected String m1164b(Activity activity, int i) {
        Object selectedItem = ((Spinner) activity.findViewById(i)).getSelectedItem();
        return selectedItem == null ? null : selectedItem.toString();
    }

    public abstract boolean m1165c();

    public abstract void m1166d();

    public boolean m1167e() {
        m1161a();
        return this.f1215c || this.f1214b || !(this.f1217e == null || this.f1217e.m267a(this.f1216d));
    }

    public void m1168f() {
        m1161a();
        C0382c.m1159a(this.f1217e, this.f1215c, getActivity());
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.key_editor_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity activity = getActivity();
        if (activity instanceof KeyEditor) {
            ActionBar supportActionBar = ((KeyEditor) activity).getSupportActionBar();
            View inflate = layoutInflater.inflate(R.layout.key_editor_switch, null);
            if (inflate == null) {
                throw new RuntimeException("Cannot find switch view");
            }
            inflate.setPadding(0, 0, activity.getResources().getDimensionPixelSize(R.dimen.action_bar_switch_padding), 0);
            supportActionBar.setDisplayOptions(16, 16);
            supportActionBar.setCustomView(inflate, new LayoutParams(-2, -2, 8388629));
            supportActionBar.setTitle(m1163b());
            this.f1213a = (Switch) inflate.findViewById(R.id.key_editor_switch);
            this.f1213a.setOnCheckedChangeListener(this);
            setHasOptionsMenu(true);
        }
        if (bundle != null) {
            this.f1216d = (AuthKey) bundle.getParcelable("TagInfo_KeyEditorFragmentoriginal_key");
            this.f1217e = (AuthKey) bundle.getParcelable("TagInfo_KeyEditorFragmentauth_key");
            this.f1214b = bundle.getBoolean("TagInfo_KeyEditorFragmentkey_changed");
            this.f1215c = bundle.getBoolean("TagInfo_KeyEditorFragmentnew_key");
        } else {
            Intent intent = activity.getIntent();
            if (intent.hasExtra("TagInfo_KeyEditorkey_data")) {
                this.f1217e = (AuthKey) intent.getExtras().getParcelable("TagInfo_KeyEditorkey_data");
                this.f1216d = this.f1217e == null ? null : this.f1217e.m277k();
            } else if ("TagInfo_KeyEditoradd_key".equals(intent.getAction())) {
                this.f1215c = true;
            }
        }
        activity.getWindow().setSoftInputMode(2);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("TagInfo_KeyEditorFragmentnew_key", this.f1215c);
        bundle.putBoolean("TagInfo_KeyEditorFragmentkey_changed", this.f1214b);
        bundle.putParcelable("TagInfo_KeyEditorFragmentoriginal_key", this.f1216d);
        bundle.putParcelable("TagInfo_KeyEditorFragmentauth_key", this.f1217e);
    }
}
