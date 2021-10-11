package com.nxp.taginfolite.p004f;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcBarcode;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.Build.VERSION;
import android.support.v4.BuildConfig;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p006c.C0200d;
import java.util.Arrays;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.f.v */
public class C0369v {
    @SuppressLint({"NewApi"})
    public static String m1085a(IsoDep isoDep) {
        if (VERSION.SDK_INT < 14) {
            return BuildConfig.VERSION_NAME;
        }
        C0428i c0428i = new C0428i();
        c0428i.m1384a(String.format(C0358k.f1076c + "Maximum transceive length: %d bytes", new Object[]{Integer.valueOf(isoDep.getMaxTransceiveLength())}));
        c0428i.m1384a(String.format(C0358k.f1076c + "Default maximum transceive time-out: %d" + "\u200a" + "ms", new Object[]{Integer.valueOf(isoDep.getTimeout())}));
        if (VERSION.SDK_INT >= 16) {
            if (isoDep.isExtendedLengthApduSupported()) {
                c0428i.m1384a(C0358k.f1076c + "Extended length APDUs supported");
            } else {
                c0428i.m1384a(C0358k.f1076c + "Extended length APDUs not supported");
            }
        }
        return c0428i.toString();
    }

    @SuppressLint({"NewApi"})
    public static String m1086a(NfcA nfcA) {
        if (VERSION.SDK_INT < 14) {
            return BuildConfig.VERSION_NAME;
        }
        C0428i c0428i = new C0428i();
        c0428i.m1387b(C0358k.f1076c + "Maximum transceive length: ");
        if (nfcA.getMaxTransceiveLength() > 0) {
            c0428i.m1384a(String.format("%d bytes", new Object[]{Integer.valueOf(nfcA.getMaxTransceiveLength())}));
        } else {
            c0428i.m1384a((CharSequence) "[not available]");
        }
        c0428i.m1387b(C0358k.f1076c + "Default maximum transceive time-out: ");
        if (nfcA.getTimeout() > 0) {
            c0428i.m1384a(String.format("%d\u200ams", new Object[]{Integer.valueOf(nfcA.getTimeout())}));
        } else {
            c0428i.m1384a((CharSequence) "[not available]");
        }
        return c0428i.toString();
    }

    private static String m1087a(NfcA nfcA, C0360m c0360m) {
        C0428i c0428i = new C0428i();
        c0428i.m1384a(C0369v.m1094a(nfcA.getTag().getId(), c0360m));
        c0428i.m1384a("ATQA: " + C0429j.m1409e(nfcA.getAtqa()));
        return c0428i.toString();
    }

    private static String m1088a(NfcA nfcA, byte[] bArr) {
        return C0369v.m1089a(nfcA, bArr, C0360m.ISO14443_A);
    }

    private static String m1089a(NfcA nfcA, byte[] bArr, C0360m c0360m) {
        C0428i c0428i = new C0428i();
        c0428i.m1384a(C0369v.m1087a(nfcA, c0360m));
        short sak = nfcA.getSak();
        c0428i.m1384a("SAK: " + String.format("0x%02X", new Object[]{Integer.valueOf(sak)}));
        if ((sak & 68) == 64) {
            c0428i.m1387b(C0358k.f1076c);
            c0428i.m1384a((CharSequence) "Configured for NFC-DEP");
        }
        if (!(bArr == null || (bArr.length == 1 && bArr[0] == 4))) {
            c0428i.m1384a("ATS: " + C0429j.m1409e(bArr));
            CharSequence b = C0351d.m1039b(bArr);
            if (!TextUtils.isEmpty(b)) {
                c0428i.m1384a(b);
            }
        }
        return c0428i.toString();
    }

    @SuppressLint({"NewApi"})
    public static String m1090a(NfcB nfcB) {
        if (VERSION.SDK_INT < 14) {
            return BuildConfig.VERSION_NAME;
        }
        C0428i c0428i = new C0428i();
        c0428i.m1387b(C0358k.f1076c + "Maximum transceive length: ");
        if (nfcB.getMaxTransceiveLength() > 0) {
            c0428i.m1384a(String.format("%d bytes", new Object[]{Integer.valueOf(nfcB.getMaxTransceiveLength())}));
        } else {
            c0428i.m1384a((CharSequence) "[not available]");
        }
        return c0428i.toString();
    }

    @TargetApi(17)
    public static String m1091a(NfcBarcode nfcBarcode) {
        C0428i c0428i = new C0428i();
        c0428i.m1387b("NFC Barcode type: ");
        switch (nfcBarcode.getType()) {
            case C0519c.Switch_track /*1*/:
                c0428i.m1387b("Kovio");
                break;
            default:
                c0428i.m1387b("[unknown]");
                break;
        }
        c0428i.m1387b("<hexoutput>");
        c0428i.m1387b(String.format(" (0x%02X)", new Object[]{Integer.valueOf(r1)}));
        c0428i.m1387b("</hexoutput>");
        return c0428i.toString();
    }

    @SuppressLint({"NewApi"})
    public static String m1092a(NfcF nfcF) {
        if (VERSION.SDK_INT < 14) {
            return BuildConfig.VERSION_NAME;
        }
        C0428i c0428i = new C0428i();
        c0428i.m1384a(String.format(C0358k.f1076c + "Maximum transceive length: %d bytes", new Object[]{Integer.valueOf(nfcF.getMaxTransceiveLength())}));
        c0428i.m1384a(String.format(C0358k.f1076c + "Default maximum transceive time-out: %d" + "\u200a" + "ms", new Object[]{Integer.valueOf(nfcF.getTimeout())}));
        return c0428i.toString();
    }

    @SuppressLint({"NewApi"})
    public static String m1093a(NfcV nfcV) {
        if (VERSION.SDK_INT < 14) {
            return BuildConfig.VERSION_NAME;
        }
        return String.format(C0358k.f1076c + "Maximum transceive length: %d bytes", new Object[]{Integer.valueOf(nfcV.getMaxTransceiveLength())});
    }

    public static String m1094a(byte[] bArr, C0360m c0360m) {
        if (bArr == null || c0360m == C0360m.UNKNOWN) {
            return BuildConfig.VERSION_NAME;
        }
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        stringBuilder.append("ID: ");
        if (c0360m == C0360m.ISO15693) {
            for (int length = bArr.length - 1; length > 0; length--) {
                stringBuilder.append(String.format("%02X:", new Object[]{Integer.valueOf(bArr[length] & MotionEventCompat.ACTION_MASK)}));
            }
            stringBuilder.append(String.format("%02X", new Object[]{Integer.valueOf(bArr[0] & MotionEventCompat.ACTION_MASK)}));
        } else {
            stringBuilder.append(C0429j.m1393a(bArr, BuildConfig.VERSION_NAME, ":"));
        }
        if (C0358k.m1071a(bArr, c0360m)) {
            stringBuilder.append("\n").append(C0358k.f1076c).append("Random ID");
        } else if (bArr.length == 4 && (bArr[0] & 15) == 15 && c0360m == C0360m.ISO14443_A) {
            stringBuilder.append("\n").append(C0358k.f1076c).append("Non-unique ID");
        } else if (bArr.length == 7 && bArr[0] == null) {
            stringBuilder.append("\n").append(C0358k.f1076c).append("Illegal ID: first byte equals 0");
        }
        return stringBuilder.toString();
    }

    public static void m1095a(NfcA nfcA, IsoDep isoDep, byte[] bArr, C0200d c0200d) {
        C0369v.m1096a(nfcA, isoDep, bArr, c0200d, C0360m.ISO14443_A);
    }

    public static void m1096a(NfcA nfcA, IsoDep isoDep, byte[] bArr, C0200d c0200d, C0360m c0360m) {
        C0428i c0428i = new C0428i();
        if (bArr != null) {
            c0428i.m1384a(C0369v.m1089a(nfcA, bArr, c0360m));
        } else {
            c0428i.m1384a(C0369v.m1089a(nfcA, null, c0360m));
            c0428i.m1384a("ATS Historical bytes: " + C0429j.m1410f(isoDep.getHistoricalBytes()));
        }
        c0200d.m242c(c0428i.toString());
    }

    public static void m1097a(NfcA nfcA, C0200d c0200d) {
        C0369v.m1099a(nfcA, null, c0200d);
    }

    public static void m1098a(NfcA nfcA, C0200d c0200d, int i, int i2) {
        C0428i c0428i = new C0428i();
        c0428i.m1384a(C0369v.m1104b(nfcA));
        c0428i.m1384a(String.format("Header ROM bytes: 0x%02X%02X", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        c0200d.m242c(c0428i.toString());
    }

    public static void m1099a(NfcA nfcA, byte[] bArr, C0200d c0200d) {
        C0428i c0428i = new C0428i();
        c0428i.m1384a(C0369v.m1088a(nfcA, bArr));
        c0200d.m242c(c0428i.toString());
    }

    public static void m1100a(NfcB nfcB, IsoDep isoDep, C0200d c0200d) {
        C0428i c0428i = new C0428i();
        c0428i.m1384a(C0369v.m1105b(nfcB));
        c0428i.m1384a("Higher Layer Response: " + C0429j.m1409e(isoDep.getHiLayerResponse()));
        c0200d.m242c(c0428i.toString());
    }

    public static void m1101a(NfcB nfcB, C0200d c0200d) {
        C0428i c0428i = new C0428i();
        c0428i.m1384a(C0369v.m1105b(nfcB));
        c0200d.m242c(c0428i.toString());
    }

    @SuppressLint({"NewApi"})
    public static void m1102a(NfcBarcode nfcBarcode, C0200d c0200d) {
        if (VERSION.SDK_INT >= 17) {
            C0428i c0428i = new C0428i();
            byte[] id = nfcBarcode.getTag().getId();
            c0428i.m1387b("ID: ");
            c0428i.m1384a(C0429j.m1393a(id, BuildConfig.VERSION_NAME, ":"));
            c0428i.m1387b(C0358k.f1076c);
            c0428i.m1387b(String.format("Manufacturer ID: 0x%02X", new Object[]{Integer.valueOf(id[0] & TransportMediator.KEYCODE_MEDIA_PAUSE)}));
            CharSequence b = C0355h.m1067b(id, C0360m.BARCODE);
            if (TextUtils.isEmpty(b) || "Unknown manufacturer".equals(b)) {
                c0428i.m1387b(" [unknown]");
            } else {
                c0428i.m1387b(" (");
                c0428i.m1387b(b);
                c0428i.m1387b(")");
            }
            c0428i.m1383a();
            c0200d.m242c(c0428i.toString());
        }
    }

    public static void m1103a(NfcV nfcV, int i, C0200d c0200d) {
        C0428i c0428i = new C0428i();
        c0428i.m1384a(C0369v.m1094a(nfcV.getTag().getId(), C0360m.ISO15693));
        if (i >= 0) {
            c0428i.m1384a(String.format("AFI: 0x%02X", new Object[]{Integer.valueOf(i)}));
        }
        c0428i.m1384a(String.format("DSFID: 0x%02X", new Object[]{Byte.valueOf(nfcV.getDsfId())}));
        c0200d.m242c(c0428i.toString());
    }

    private static String m1104b(NfcA nfcA) {
        return C0369v.m1087a(nfcA, C0360m.ISO14443_A);
    }

    private static String m1105b(NfcB nfcB) {
        C0428i c0428i = new C0428i();
        if (nfcB == null) {
            return BuildConfig.VERSION_NAME;
        }
        Tag tag = nfcB.getTag();
        if (tag != null) {
            c0428i.m1384a(C0369v.m1094a(tag.getId(), C0360m.ISO14443_B));
        } else {
            c0428i.m1384a(BuildConfig.VERSION_NAME);
        }
        c0428i.m1384a("Application Data: " + C0429j.m1409e(nfcB.getApplicationData()));
        byte[] protocolInfo = nfcB.getProtocolInfo();
        c0428i.m1384a("Protocol info: " + C0429j.m1409e(protocolInfo));
        byte[] bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0};
        if (!(protocolInfo == null || protocolInfo.length < 3 || Arrays.equals(protocolInfo, bArr))) {
            C0351d.m1035a(c0428i, protocolInfo[0] & MotionEventCompat.ACTION_MASK);
            C0351d.m1040b(c0428i, (protocolInfo[1] >> 4) & 15);
            int i = (protocolInfo[2] >> 4) & 15;
            c0428i.m1387b(C0358k.f1076c + "FWT: ");
            c0428i.m1387b((CharSequence) C0351d.f1063a.get(i));
            c0428i.m1384a(String.format("  (FWI: %d)", new Object[]{Integer.valueOf(i)}));
            c0428i.m1387b(C0358k.f1076c);
            if ((protocolInfo[2] & 12) == 0) {
                c0428i.m1384a((CharSequence) "Application Data Coding is proprietary");
            } else {
                c0428i.m1384a((CharSequence) "Application Data Coding using CRC_B compression");
            }
            i = protocolInfo[2] & 3;
            String str = C0358k.f1076c + "NAD %ssupported";
            Object[] objArr = new Object[1];
            objArr[0] = (i & 2) != 0 ? BuildConfig.VERSION_NAME : "not ";
            c0428i.m1384a(String.format(str, objArr));
            str = C0358k.f1076c + "CID %ssupported";
            objArr = new Object[1];
            objArr[0] = (i & 1) != 0 ? BuildConfig.VERSION_NAME : "not ";
            c0428i.m1384a(String.format(str, objArr));
            if (protocolInfo.length > 3) {
                int i2 = (protocolInfo[3] >> 4) & 15;
                c0428i.m1387b(C0358k.f1076c + "SFGT: ");
                c0428i.m1387b((CharSequence) C0351d.f1063a.get(i2));
                c0428i.m1384a(String.format("  (SFGI: %d)", new Object[]{Integer.valueOf(i2)}));
            }
        }
        return c0428i.toString();
    }
}
