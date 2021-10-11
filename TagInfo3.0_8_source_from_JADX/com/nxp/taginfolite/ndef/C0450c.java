package com.nxp.taginfolite.ndef;

import android.support.v4.BuildConfig;
import android.util.SparseArray;

/* renamed from: com.nxp.taginfolite.ndef.c */
final class C0450c extends SparseArray {
    C0450c() {
        append(0, BuildConfig.VERSION_NAME);
        append(1, "http://www.");
        append(2, "https://www.");
        append(3, "http://");
        append(4, "https://");
        append(5, "tel:");
        append(6, "mailto:");
        append(7, "ftp://anonymous:anonymous@");
        append(8, "ftp://ftp.");
        append(9, "ftps:");
        append(10, "sftp://");
        append(11, "smb://");
        append(12, "nfs://");
        append(13, "ftp://");
        append(14, "dav://");
        append(15, "news:");
        append(16, "telnet://");
        append(17, "imap:");
        append(18, "rtsp://");
        append(19, "urn:");
        append(20, "pop:");
        append(21, "sip:");
        append(22, "sips:");
        append(23, "tftp:");
        append(24, "btspp://");
        append(25, "btl2cap://");
        append(26, "btgoep://");
        append(27, "tcpobex://");
        append(28, "irdaobex://");
        append(29, "file://");
        append(30, "urn:epc:id:");
        append(31, "urn:epc:tag:");
        append(32, "urn:epc:pat:");
        append(33, "urn:epc:raw:");
        append(34, "urn:epc:");
        append(35, "urn:nfc:");
    }
}
