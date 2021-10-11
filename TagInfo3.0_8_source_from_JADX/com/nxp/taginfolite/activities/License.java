package com.nxp.taginfolite.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.R;

public final class License extends C0161i {
    private void m93b() {
        setResult(-1);
        finish();
    }

    protected void m94b(Intent intent) {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.b.m48f()) {
            m93b();
        }
        this.c.setDisplayHomeAsUpEnabled(false);
        setContentView((int) R.layout.license);
        m76a((int) R.string.name_license);
        ((Button) findViewById(R.id.button_license_ok)).setOnClickListener(new C0173k(this));
        ((Button) findViewById(R.id.button_show_notices)).setOnClickListener(new C0174l(this));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return true;
    }

    protected void onResume() {
        if (this.b.m48f()) {
            m93b();
        }
        super.onResume();
    }
}
