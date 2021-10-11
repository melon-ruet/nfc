package com.nxp.taginfolite.p004f.p017c.p018a;

import android.support.v4.view.MotionEventCompat;
import android.util.SparseArray;

/* renamed from: com.nxp.taginfolite.f.c.a.b */
public class C0343b {
    private static final SparseArray f1047a;

    static {
        f1047a = new SparseArray();
        f1047a.put(25217, "(WP) The returned data may be erroneous. [ISO/IEC 7816-4]");
        f1047a.put(25218, "(WP) Fewer bytes than specified by the Le parameter could be read, since the end of the file was encountered first. [ISO/IEC 7816-4]");
        f1047a.put(25219, "(WP) The selected file is reversibly blocked (invalidated). [ISO/IEC 7816-4]");
        f1047a.put(25220, "(WP) The file control information (FCI) is not structured in accordance with ISO/IEC7816-4. [ISO/IEC 7816-4]");
        f1047a.put(25985, "(EE) Memory error (e.g., during a write operation). [ISO/IEC 7816-4]");
        f1047a.put(26368, "(CE) Length incorrect. [ISO/IEC 7816-4]");
        f1047a.put(26624, "(CE) Functions in the class byte not supported (general). [ISO/IEC 7816-4]");
        f1047a.put(26753, "(CE) Logical channels not supported. [ISO/IEC 7816-4]");
        f1047a.put(26754, "(CE) Secure messaging not supported. [ISO/IEC 7816-4]");
        f1047a.put(26880, "(CE) Command not allowed (general). [ISO/IEC 7816-4]");
        f1047a.put(27009, "(CE) Command incompatible with file structure. [ISO/IEC 7816-4]");
        f1047a.put(27010, "(CE) Security state not satisfied. [ISO/IEC 7816-4]");
        f1047a.put(27011, "(CE) Authentication method blocked. [ISO/IEC 7816-4]");
        f1047a.put(27012, "(CE) Referenced data reversibly blocked (invalidated). [ISO/IEC 7816-4]");
        f1047a.put(27013, "(CE) Usage conditions not satisfied. [ISO/IEC 7816-4]");
        f1047a.put(27014, "(CE) Command not allowed (no EF selected). [ISO/IEC 7816-4]");
        f1047a.put(27015, "(CE) Expected secure messaging data objects missing. [ISO/IEC 7816-4]");
        f1047a.put(27016, "(CE) Secure messaging data objects incorrect. [ISO/IEC 7816-4]");
        f1047a.put(27136, "(CE) Incorrect P1 or P2 parameters (general). [ISO/IEC 7816-4]");
        f1047a.put(27264, "(CE) Parameters in the data portion are incorrect. [ISO/IEC 7816-4]");
        f1047a.put(27265, "(CE) Function not supported. [ISO/IEC 7816-4]");
        f1047a.put(27266, "(CE) File not found. [ISO/IEC 7816-4]");
        f1047a.put(27267, "(CE) Record not found. [ISO/IEC 7816-4]");
        f1047a.put(27268, "(CE) Insufficient memory. [ISO/IEC 7816-4]");
        f1047a.put(27269, "(CE) Lc inconsistent with TLV structure. [ISO/IEC 7816-4]");
        f1047a.put(27270, "(CE) Incorrect P1 or P2 parameter. [ISO/IEC 7816-4]");
        f1047a.put(27271, "(CE) Lc inconsistent with P1 or P2. [ISO/IEC 7816-4]");
        f1047a.put(27272, "(CE) Referenced data not found. [ISO/IEC 7816-4]");
        f1047a.put(27392, "(CE) Parameter 1 or 2 incorrect. [ISO/IEC 7816-4]");
        f1047a.put(27904, "(CE) Instruction not supported. [ISO/IEC 7816-4]");
        f1047a.put(28160, "(CE) Class not supported. [ISO/IEC 7816-4]");
        f1047a.put(28416, "(CE) Command aborted - more exact diagnosis not possible. [ISO/IEC 7816-4]");
        f1047a.put(36864, "(NP) Command successfully executed. [ISO/IEC 7816-4]");
        f1047a.put(37392, "(CE) Insufficient memory. [TS 51.011]");
        f1047a.put(37440, "(EE) Writing to EEPROM not successful. [TS 51.011]");
        f1047a.put(37888, "(CE) No EF selected. [TS 51.011]");
        f1047a.put(37890, "(CE) Address range exceeded. [TS 51.011]");
        f1047a.put(37892, "(CE) FID not found, record not found or comparison pattern not found. [TS 51.011]");
        f1047a.put(37896, "(CE) Selected file type does not match command. [TS 51.011]");
        f1047a.put(38914, "(CE) No PIN defined. [TS 51.011]");
        f1047a.put(38916, "(CE) Access conditions not satisfied, authentication failed. [TS 51.011]");
        f1047a.put(38965, "(CE) ASK RANDOM or GIVE RANDOM not executed. [TS 51.011]");
        f1047a.put(38976, "(CE) PIN verification not successful. [TS 51.011]");
        f1047a.put(38992, "(CE) INCREASE or DECREASE could not be executed because a limit has been reached. [TS 51.011]");
    }

    public static String m983a(int i) {
        String str = (String) f1047a.get(i);
        if (str == null) {
            switch (i >>> 4) {
                case 1596:
                    str = String.format("(WP) The counter has reached the value %d (the exact significance depends on the command).  [ISO/IEC 7816-4]", new Object[]{Integer.valueOf(i & 15)});
                    break;
                case 2336:
                    str = String.format("(NP) Writing to EEPROM successful after %d attempts. [TS 51.011]", new Object[]{Integer.valueOf(i & 15)});
                    break;
            }
        }
        if (str != null) {
            return str;
        }
        int i2 = i & MotionEventCompat.ACTION_MASK;
        switch ((i >> 8) & MotionEventCompat.ACTION_MASK) {
            case 97:
                return String.format("(NP) Command successfully executed; 0x%02X bytes of data are available and can be requested using GET RESPONSE.  [ISO/IEC 7816-4]", new Object[]{Integer.valueOf(i2)});
            case 98:
                return "(WP) Warning; state of non-volatile memory not changed. [ISO/IEC 7816-4]";
            case 99:
                return "(WP) Warning; state of non-volatile memory changed. [ISO/IEC 7816-4]";
            case 100:
                return "(EE) Execution error; state of non-volatile memory not changed. [ISO/IEC 7816-4]";
            case 101:
                return "(EE) Execution error; state of non-volatile memory changed. [ISO/IEC 7816-4]";
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 109:
            case 110:
            case 111:
                return "(CE) Check error. [ISO/IEC 7816-4]";
            case 108:
                return String.format("(CE) Bad length value in Le; 0x%02X is the correct length. [ISO/IEC 7816-4]", new Object[]{Integer.valueOf(i2)});
            case 159:
                return String.format("(NP) Command successfully executed; 0x%02X bytes of data are available and can be requested using GET RESPONSE. [TS 51.011]", new Object[]{Integer.valueOf(i2)});
            default:
                return str;
        }
    }
}
