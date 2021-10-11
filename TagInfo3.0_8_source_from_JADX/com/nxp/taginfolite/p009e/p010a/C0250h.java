package com.nxp.taginfolite.p009e.p010a;

import android.nfc.tech.MifareClassic;
import android.nfc.tech.NfcA;
import android.support.v4.view.MotionEventCompat;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.p004f.C0353f;
import java.io.IOException;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.a.h */
public class C0250h {
    private static final byte[] f385a;
    private static final byte[] f386b;

    static {
        f385a = new byte[]{(byte) 75, (byte) 121, (byte) 27, (byte) -22, (byte) 123, (byte) -52};
        f386b = new byte[]{(byte) -93, (byte) 20, (byte) -15, (byte) 123, (byte) 75, (byte) -21};
    }

    public static String m393a(byte[] bArr, byte[] bArr2) {
        return C0353f.m1051a("044F6D3F294DEA5737F0F46FFEE88A356EED95695DD7E0C27A591E6F6F65962BAF", bArr, bArr2);
    }

    public static byte[][] m394a(MifareClassic mifareClassic) {
        byte[] bArr = null;
        if (mifareClassic == null) {
            return (byte[][]) bArr;
        }
        int i;
        byte[] readBlock;
        byte[] readBlock2;
        int sak = NfcA.get(mifareClassic.getTag()).getSak() & MotionEventCompat.ACTION_MASK;
        switch (sak) {
            case C0519c.Switch_track /*1*/:
            case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
            case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                i = 17;
                break;
            case C0086R.styleable.SherlockTheme_textColorPrimary /*25*/:
                i = 32;
                break;
            default:
                return (byte[][]) bArr;
        }
        try {
            if (mifareClassic.authenticateSectorWithKeyB(i, sak == 1 ? f386b : f385a)) {
                readBlock = mifareClassic.readBlock(i * 4);
                try {
                    readBlock2 = mifareClassic.readBlock((i * 4) + 1);
                    try {
                        bArr = mifareClassic.readBlock((i * 4) + 2);
                    } catch (IOException e) {
                    }
                } catch (IOException e2) {
                    readBlock2 = bArr;
                }
            } else {
                readBlock2 = bArr;
                readBlock = bArr;
            }
        } catch (IOException e3) {
            readBlock2 = bArr;
            readBlock = bArr;
        }
        return new byte[][]{readBlock, readBlock2, bArr};
    }
}
