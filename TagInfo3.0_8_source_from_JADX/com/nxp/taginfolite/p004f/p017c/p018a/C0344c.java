package com.nxp.taginfolite.p004f.p017c.p018a;

import android.support.v4.view.MotionEventCompat;
import android.util.SparseArray;

/* renamed from: com.nxp.taginfolite.f.c.a.c */
public class C0344c {
    private static final SparseArray f1048a;

    static {
        f1048a = new SparseArray();
        f1048a.put(5, "Incorrect final certificate type [MULTOS]");
        f1048a.put(7, "Incorrect final session data size [MULTOS]");
        f1048a.put(8, "Incorrect final DIR file final record size [MULTOS]");
        f1048a.put(9, "Incorrect final FCI record size [MULTOS]");
        f1048a.put(16, "Insufficient final memory to final load application [MULTOS]");
        f1048a.put(17, "Invalid final application ID [MULTOS]");
        f1048a.put(18, "Duplicate final application ID [MULTOS]");
        f1048a.put(19, "Application final previously loaded [MULTOS]");
        f1048a.put(20, "Application final history full [MULTOS]");
        f1048a.put(21, "Application final not open [MULTOS]");
        f1048a.put(23, "Final Invalid offset [MULTOS]");
        f1048a.put(24, "Application final already loaded [MULTOS]");
        f1048a.put(25, "Final Invalid certificate [MULTOS]");
        f1048a.put(26, "Final Invalid signature [MULTOS]");
        f1048a.put(27, "Final Invalid key final transformation unit [MULTOS]");
        f1048a.put(29, "MSM final controls not set [MULTOS]");
        f1048a.put(30, "Application Signature does not exist [MULTOS]");
        f1048a.put(48, "Check data parameter is incorrect (invalid start address) [MULTOS]");
        f1048a.put(49, "final Check data parameter final is\tincorrect (final invalid length) [MULTOS]");
        f1048a.put(50, "Check data parameter is incorrect (illegal memory check area) [MULTOS]");
        f1048a.put(65, "MSM controls set [MULTOS]");
        f1048a.put(66, "Set MSM Controls data length less than 2 bytes [MULTOS]");
        f1048a.put(67, "Invalid msm controls data length [MULTOS]");
        f1048a.put(68, "Xcess msm controls ciphertext [MULTOS]");
        f1048a.put(69, "Verification of msm controls data failed [MULTOS]");
        f1048a.put(80, "Invalid mcd issuer product ID [MULTOS]");
        f1048a.put(81, "Invalid mcd issuer ID [MULTOS]");
        f1048a.put(82, "Invalid set msm controls data date [MULTOS]");
        f1048a.put(83, "Invalid mcd number [MULTOS]");
        f1048a.put(86, "Reserved field error [MULTOS]");
        f1048a.put(87, "Reserved field error [MULTOS]");
        f1048a.put(96, "MAC verification failed [MULTOS]");
        f1048a.put(97, "Maximum number of unblocks reached [MULTOS]");
        f1048a.put(98, "This is not a blocked device [MULTOS]");
    }

    public static String m984a(int i) {
        return ((i >> 8) & MotionEventCompat.ACTION_MASK) != 157 ? null : (String) f1048a.get(i);
    }
}
