package com.nuspay.melon.classickeychange;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

/**
 * Created by melon on 5/6/15.
 */
public class MifareSettings {

    public static void showWirelessSettingsDialog(final Context conn) {
        AlertDialog.Builder builder = new AlertDialog.Builder(conn);
        builder.setMessage(R.string.nfc_disabled);
        builder.setPositiveButton(android.R.string.ok,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(
                                android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                        conn.startActivity(intent);
                    }
                });
        builder.setNegativeButton(android.R.string.cancel,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((Activity)conn).finish();
                    }
                });
        builder.create().show();
    }
}
