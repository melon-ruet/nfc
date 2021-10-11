package com.nuspay.melon.classickeychange;

import android.nfc.Tag;
import android.nfc.tech.MifareClassic;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by melon on 6/8/15
 * email - mahabub.melon@nuspay.com
 */
public class Mifare {

    Tag tag;
    MifareClassic mifare;

    Mifare(Tag tag) {
        this.tag = tag;
    }

    public MifareClassic openMifareClassic() {
        mifare = MifareClassic.get(tag);
        try {
            mifare.connect();
            return mifare;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean closeMifareClassic() {
        if (mifare != null) {
            try {
                mifare.close();
                return true;
            } catch (IOException e) {
                Log.e("mifare", "Error closing tag", e);
            }
        }
        return false;
    }

    public byte[] readBlock(int block) {
        try {
            return mifare.readBlock(block);
        } catch (IOException e) {
            Log.e("hwt", "IOException while reading", e);
        }
        return null;
    }


    public void WriteBlock(int blockIndex, byte[] data) {
        try {
            mifare.writeBlock(blockIndex, data);
            Log.e("mifare", "Successfully written");
        } catch (IOException e) {
            Log.e("mifare", "IOException while writing Mifare Ultralight message...", e);
        }
    }

    public boolean authClassic1Kcard(int sector, boolean isKeyA) {
        try {
            Iterator it = new KeyDirectory().getKeyDictionary().entrySet().iterator();
            boolean ck;
            while (it.hasNext()) {
                HashMap.Entry pair = (HashMap.Entry) it.next();

                if (isKeyA)
                    ck = mifare.authenticateSectorWithKeyA(sector, (byte[]) pair.getValue());
                else
                    ck = mifare.authenticateSectorWithKeyB(sector, (byte[]) pair.getValue());

                if (ck) return true;
                it.remove();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
