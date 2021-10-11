package com.nxp.taginfolite.p004f;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.nxp.taginfolite.f.f */
public class C0353f {
    public static String m1051a(String str, byte[] bArr, byte[] bArr2) {
        boolean b;
        C0428i c0428i = new C0428i();
        try {
            b = C0353f.m1057b(str, bArr, bArr2);
        } catch (NoSuchAlgorithmException e) {
            c0428i.m1384a((CharSequence) "Cannot verify signature: this Android device has no ECDSA support");
            b = false;
        }
        if (b) {
            c0428i.m1387b("Signature verified with NXP public key");
            c0428i.m1383a();
            c0428i.m1387b("<hexoutput>");
            c0428i.m1384a((CharSequence) "Public key:");
            c0428i.m1387b(C0358k.f1076c + "0x");
            c0428i.m1384a((CharSequence) str);
            c0428i.m1387b("</hexoutput>");
        } else {
            c0428i.m1384a((CharSequence) "Signature cannot be verified");
        }
        c0428i.m1387b("<hexoutput>");
        c0428i.m1384a((CharSequence) "ECDSA signature:");
        c0428i.m1384a(C0358k.f1076c + "r: " + C0429j.m1402b(bArr, 0, 16));
        c0428i.m1384a(C0358k.f1076c + "s: " + C0429j.m1402b(bArr, 16, 16) + "</hexoutput>");
        return c0428i.toString();
    }

    public static ECParameterSpec m1052a() {
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(new BigInteger("fffffffdffffffffffffffffffffffff", 16)), new BigInteger("fffffffdfffffffffffffffffffffffc", 16), new BigInteger("e87579c11079f43dd824993c2cee5ed3", 16)), new ECPoint(new BigInteger("161ff7528b899b2d0c28607ca52c5b86", 16), new BigInteger("cf5ac8395bafeb13c02da292dded7a83", 16)), new BigInteger("fffffffe0000000075a30d1b9038a115", 16), 1);
    }

    public static ECPublicKeySpec m1053a(String str, ECParameterSpec eCParameterSpec) {
        if (str != null && str.length() == 66 && str.startsWith("04")) {
            return new ECPublicKeySpec(new ECPoint(new BigInteger(str.substring(2, 34), 16), new BigInteger(str.substring(34, 66), 16)), eCParameterSpec);
        }
        Log.v("TagInfo_Crypto", "Wrong key format");
        return null;
    }

    public static boolean m1054a(ECPublicKeySpec eCPublicKeySpec, byte[] bArr, byte[] bArr2) {
        KeyFactory instance;
        try {
            instance = KeyFactory.getInstance("EC");
        } catch (NoSuchAlgorithmException e) {
            instance = KeyFactory.getInstance("ECDSA");
        }
        if (instance != null) {
            try {
                PublicKey generatePublic = instance.generatePublic(eCPublicKeySpec);
                Signature instance2 = Signature.getInstance("NONEwithECDSA");
                instance2.initVerify(generatePublic);
                instance2.update(bArr2);
                return instance2.verify(C0353f.m1055a(bArr));
            } catch (SignatureException e2) {
                e2.printStackTrace();
            } catch (InvalidKeySpecException e3) {
                e3.printStackTrace();
            } catch (InvalidKeyException e4) {
                e4.printStackTrace();
            }
        }
        return false;
    }

    public static byte[] m1055a(byte[] bArr) {
        Object copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
        Object copyOfRange2 = Arrays.copyOfRange(bArr, 16, 32);
        int length = copyOfRange.length;
        int length2 = copyOfRange2.length;
        if ((copyOfRange[0] & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0) {
            length++;
        }
        if ((copyOfRange2[0] & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0) {
            length2++;
        }
        Object obj = new byte[((length + length2) + 6)];
        obj[0] = (byte) 48;
        obj[1] = (byte) ((length + 4) + length2);
        obj[2] = 2;
        obj[3] = (byte) length;
        obj[length + 4] = 2;
        obj[(length + 4) + 1] = (byte) length2;
        obj[4] = null;
        obj[(length + 4) + 2] = null;
        System.arraycopy(copyOfRange, 0, obj, (length + 4) - copyOfRange.length, copyOfRange.length);
        System.arraycopy(copyOfRange2, 0, obj, (((length + 4) + 2) + length2) - copyOfRange2.length, copyOfRange2.length);
        return obj;
    }

    public static byte[] m1056a(byte[] bArr, int i, SecretKeySpec secretKeySpec, byte[] bArr2) {
        Cipher instance = Cipher.getInstance("DESede/CBC/NoPadding");
        instance.init(i, secretKeySpec, new IvParameterSpec(bArr2));
        return instance.doFinal(bArr);
    }

    public static boolean m1057b(String str, byte[] bArr, byte[] bArr2) {
        return C0353f.m1054a(C0353f.m1053a(str, C0353f.m1052a()), bArr, bArr2);
    }
}
