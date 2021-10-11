package com.nuspay.melon.classickeychange;

import java.util.HashMap;

/**
 * Author melon on 6/2/15.
 */
public final class KeyDirectory {

    private final  byte[] CHANGED_KEY = {
            (byte)1, (byte)2, (byte)3, (byte)4, (byte)5, (byte)6
    };

    private  final byte[] MIFARE_KEY_DEFAULT = {
            (byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF
    };
    private  final byte[] MIFARE_APPLICATION_DIRECTORY = {
            (byte)0xA0,(byte)0xA1,(byte)0xA2,(byte)0xA3,(byte)0xA4,(byte)0xA5
    };
    private  final byte[] MIFARE_KEY_NFC_FORUM = {
            (byte)0xD3,(byte)0xF7,(byte)0xD3,(byte)0xF7,(byte)0xD3,(byte)0xF7
    };

    //read, write protect for keys and access trailer
    public final byte[] BLOCK_ACCESS_BITS = {
            (byte)0xFF, (byte)0x16, (byte)0x81, (byte)0x69
    };

    private final byte[] DEFAULT_ACCESS_BITS = {
            (byte)0xFF, (byte)0x07, (byte)0x80, (byte)0x69
    };

    private final class AccessBitsHashMap extends HashMap<String, byte[]>{
        AccessBitsHashMap(){
            this.put("DEFAULT_ACCESS_BITS", DEFAULT_ACCESS_BITS);
            this.put("BLOCK_ACCESS_BITS", BLOCK_ACCESS_BITS);
        }
    }

    public HashMap<String, byte[]> getAccessBitsDictionary(){
        return new AccessBitsHashMap();
    }

    private final class KeyHashMap extends HashMap<String, byte[]>{
        KeyHashMap(){
           this.put("KEY_DEFAULT", MIFARE_KEY_DEFAULT);
           this.put("KEY_MIFARE_APPLICATION_DIRECTORY", MIFARE_APPLICATION_DIRECTORY);
           this.put("KEY_NFC_FORUM", MIFARE_KEY_NFC_FORUM);
           this.put("CHANGED_KEY", CHANGED_KEY);
        }
    }

    public HashMap<String, byte[]> getKeyDictionary(){
        return new KeyHashMap();
    }

}
