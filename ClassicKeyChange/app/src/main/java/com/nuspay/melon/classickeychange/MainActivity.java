package com.nuspay.melon.classickeychange;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


public class MainActivity extends NfcHelper {


    String tagIdAsString;


    @Override
    protected void onCreate(Bundle saveInstance) {
        super.onCreate(saveInstance);
        setContentView(R.layout.splash);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);

        if(isNFCtagOK(intent)) {
            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            byte[] id = tag.getId();
            tagIdAsString = TagRW.ByteArrayToHexString(id);
            Log.e("tag_id", tagIdAsString);

            Bundle data = TagRW.readSectorTrailers(tag);
            if (data != null && data.size() > 0) {
                Intent intent2 = new Intent(this, SectorTrailerActivity.class);
                intent2.putExtra("data", data);
                startActivity(intent2);
            }
            else {
                Toast.makeText(this, "Can not read card", Toast.LENGTH_LONG).show();
            }
        }
    }
}

