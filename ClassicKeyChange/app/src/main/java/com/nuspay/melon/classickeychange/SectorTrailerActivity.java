package com.nuspay.melon.classickeychange;

import android.app.Dialog;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.MifareClassic;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SectorTrailerActivity extends NfcHelper {


    private byte [] sectorTrailer;
    private int sector;
    private boolean isChangeKey = false;
    private Spinner selectkeyA, selectkeyB, selectAccessBits;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sector_trailers);

        final ListView mainListView = (ListView) findViewById(R.id.trailer_list);

        Bundle dataBundle = getIntent().getBundleExtra("data");

        final ArrayList<String> sectorList = dataBundle.getStringArrayList("sector");
        mainListView.setAdapter(new RecordAdapter(this, sectorList,
                dataBundle.getStringArrayList("trailer")));


        mainListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final Dialog dialog = new Dialog(SectorTrailerActivity.this);
                dialog.setContentView(R.layout.change_key);

                dialog.setTitle("Change Sector Trailer - " + sectorList.get(position));

                final HashMap<String, byte[]> keyDictionary = new KeyDirectory().getKeyDictionary();
                final HashMap<String, byte[]> accessBitsDictionary = new KeyDirectory().getAccessBitsDictionary();
                List<String> keyValues = new ArrayList<>(keyDictionary.keySet());
                List<String> accessBitsValues = new ArrayList<>(accessBitsDictionary.keySet());


                selectkeyA = (Spinner) dialog.findViewById(R.id.select_key_A);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(SectorTrailerActivity.this,
                        android.R.layout.simple_spinner_item, keyValues);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectkeyA.setAdapter(adapter);


                selectkeyB = (Spinner) dialog.findViewById(R.id.select_key_B);
                ArrayAdapter<String> adapterb = new ArrayAdapter<>(SectorTrailerActivity.this,
                        android.R.layout.simple_spinner_item, keyValues);
                adapterb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectkeyB.setAdapter(adapterb);

                selectAccessBits = (Spinner) dialog.findViewById(R.id.select_access_bits);
                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(SectorTrailerActivity.this,
                        android.R.layout.simple_spinner_item, accessBitsValues);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectAccessBits.setAdapter(adapter2);


                Button okButton = (Button) dialog.findViewById(R.id.ok);
                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        sector = Integer.valueOf(sectorList.get(position));
                        sectorTrailer = new byte[MifareClassic.BLOCK_SIZE];

                        byte [] keyA = keyDictionary.get(selectkeyA.getSelectedItem().toString());
                        byte [] keyB = keyDictionary.get(selectkeyB.getSelectedItem().toString());
                        byte [] access = accessBitsDictionary.get(selectAccessBits.getSelectedItem().toString());

                        System.arraycopy(keyA, 0, sectorTrailer, 0, keyA.length);
                        System.arraycopy(access, 0, sectorTrailer, keyA.length, access.length);
                        System.arraycopy(keyB, 0, sectorTrailer, keyA.length + access.length, keyB.length);

                        Log.e("sector", Arrays.toString(sectorTrailer));

                        isChangeKey = true;
                        dialog.dismiss();
                        Toast.makeText(SectorTrailerActivity.this,
                                "Approach the card to change Sector Trailer", Toast.LENGTH_LONG).show();
                    }
                });

                Button cancelButton = (Button) dialog.findViewById(R.id.cancel);
                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();

                return true;
            }
        });

    }



    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if(isChangeKey){
            if(TagRW.isNFCtagOK(intent)) {
                Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
                TagRW.changeSectorTrailer(sectorTrailer, tag, sector);
                Toast.makeText(SectorTrailerActivity.this,
                        "Sector Trailer Changed Successfully", Toast.LENGTH_LONG).show();
            }
        }
        isChangeKey = false;
    }

}