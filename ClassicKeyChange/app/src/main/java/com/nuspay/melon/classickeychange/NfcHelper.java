package com.nuspay.melon.classickeychange;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by melon on 6/8/15.
 */
public class NfcHelper extends Activity {

    PendingIntent _nfcPendingIntent;
    NfcAdapter _nfcAdapter;


    @Override
    protected void onCreate(Bundle saveInstance) {
        super.onCreate(saveInstance);
        //setContentView(R.layout.splash);

        _nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (_nfcAdapter == null) {
            Toast.makeText(this, "No NFC found on this device", Toast.LENGTH_LONG).show();
            return;
        }

        _nfcPendingIntent = PendingIntent.getActivity(this, 0, new Intent(this,
                getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
    }



    @Override
    protected void onResume() {
        super.onResume();
        if (_nfcAdapter != null) {
            if (!_nfcAdapter.isEnabled()) {
                MifareSettings.showWirelessSettingsDialog(this);
            }
            _nfcAdapter.enableForegroundDispatch(this, _nfcPendingIntent, null,
                    null);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (_nfcAdapter != null) {
            _nfcAdapter.disableForegroundDispatch(this);
        }
    }

    public boolean isNFCtagOK(Intent intent){
        String action = intent.getAction();
        //ACTION_TAG_DISCOVERED 	Intent to start an activity when a tag is discovered.
        //ACTION_TECH_DISCOVERED 	Intent to start an activity when a tag is discovered and
        // activities are registered for the specific technologies on the tag.
        //ACTION_NDEF_DISCOVERED 	Intent to start an activity when a tag with NDEF payload is discovered.
        return NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action);
    }
}
