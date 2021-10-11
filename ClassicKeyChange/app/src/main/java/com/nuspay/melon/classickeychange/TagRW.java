package com.nuspay.melon.classickeychange;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.MifareClassic;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by melon on 5/6/15
 * email - mahabub.melon@nuspay.com
 */
public class TagRW {

    private static int interval = 3;
    private static int defaultKey = 1;


    public static Bundle readSectorTrailers(Tag tag) {

        Mifare mifareCard = new Mifare(tag);

        MifareClassic classic = mifareCard.openMifareClassic();

        ArrayList<String> sectorList = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();
        for (int sector = 0; sector < classic.getSectorCount(); sector++) {
            boolean check = mifareCard.authClassic1Kcard(sector, true);
            if (check) {
                sectorList.add(String.valueOf(sector));
                byte [] payload = mifareCard.readBlock(classic.sectorToBlock(sector) + interval);
                data.add(ByteArrayToHexString(payload));
                Log.e("triler "+sector, Arrays.toString(payload));
            }
        }

        mifareCard.closeMifareClassic();

        Bundle bundle = new Bundle();
        bundle.putStringArrayList("sector", sectorList);
        bundle.putStringArrayList("trailer", data);
        return bundle;
    }


    public static void changeSectorTrailer(byte[] key, Tag tag, int sector) {
        Mifare mifareCard = new Mifare(tag);
        MifareClassic classic = mifareCard.openMifareClassic();
        assert classic != null;

        int block = classic.sectorToBlock(sector) + interval;
        boolean check = mifareCard.authClassic1Kcard(sector, true);
        if(check)  mifareCard.WriteBlock(block, key);

        mifareCard.closeMifareClassic();
    }


/*    private static boolean authMifareClassic(MifareClassic mfc, int sector, byte[] key, boolean keyAorB) {
        try {
            if (keyAorB && mfc.authenticateSectorWithKeyA(sector, key)) {
                return true;
            } else if (!keyAorB && mfc.authenticateSectorWithKeyB(sector, key)) {
                return true;
            }
        } catch (IOException e) {
            Log.d("hwt-payload", "auth error");
            return false;
        }
        return false;
    }*/



 /*   public static  byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.putLong(x);
        return buffer.array();
    }

*/

    // tagId is byte array. This function get byte array and return as string
    // format
    public static String ByteArrayToHexString(byte[] inarray) {
        int i, j, in;
        String[] hex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A",
                "B", "C", "D", "E", "F"};
        String out = "";

        for (j = 0; j < inarray.length; ++j) {
            in = (int) inarray[j] & 0xff;
            i = (in >> 4) & 0x0f;
            out += hex[i];
            i = in & 0x0f;
            out += hex[i];
        }
        return out;
    }

/*    public static byte [] StringTo16Byte(String inputString){
        inputString = inputString.substring(0,15);
        byte[] outputByte = new byte[16];
        for(int val=0; val<16; val++)
            byte = inputString.getBytes();
        return outputByte;
    }*/



}
