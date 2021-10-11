package com.nxp.taginfolite.p009e;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.NfcA;
import android.support.v4.BuildConfig;
import android.support.v4.media.TransportMediator;
import android.support.v4.os.EnvironmentCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.C0158a;
import com.nxp.taginfolite.p003g.C0422a;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p004f.C0358k;
import com.nxp.taginfolite.p004f.C0362o;
import com.nxp.taginfolite.p004f.C0369v;
import com.nxp.taginfolite.p004f.C0372z;
import com.nxp.taginfolite.p005b.C0182c;
import com.nxp.taginfolite.p005b.C0184h;
import com.nxp.taginfolite.p005b.C0193o;
import com.nxp.taginfolite.p005b.C0194n;
import com.nxp.taginfolite.p005b.C0195p;
import com.nxp.taginfolite.p006c.C0197a;
import com.nxp.taginfolite.p006c.C0199c;
import com.nxp.taginfolite.p006c.C0200d;
import com.nxp.taginfolite.p009e.p014e.C0293a;
import com.nxp.taginfolite.p009e.p014e.C0300h;
import com.nxp.taginfolite.p009e.p014e.C0302j;
import com.nxp.taginfolite.p009e.p014e.C0303k;
import com.nxp.taginfolite.p009e.p014e.C0304l;
import com.nxp.taginfolite.p009e.p014e.C0305m;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.e.az */
public final class az extends C0253s {
    public MifareUltralight f541k;
    public boolean f542l;
    public boolean f543m;
    public bb f544n;
    public String f545o;
    public byte[] f546p;
    public C0300h f547q;
    public String f548r;
    public C0302j f549s;
    public byte[][] f550t;
    private byte[] f551u;
    private String f552v;
    private boolean f553w;
    private String f554x;

    public az() {
        this.f541k = null;
        this.f542l = false;
        this.f543m = false;
        this.f551u = null;
        this.f552v = null;
        this.f553w = false;
        this.f554x = BuildConfig.VERSION_NAME;
        this.f545o = null;
        this.f546p = null;
        this.f547q = null;
        this.f548r = null;
        this.f549s = C0302j.UNKNOWN;
        this.f550t = (byte[][]) null;
    }

    public static az m544a(Tag tag, MifareUltralight mifareUltralight, boolean z, NdefMessage[] ndefMessageArr, C0158a c0158a) {
        byte[] bArr;
        byte[] payload;
        byte[] copyOfRange;
        NfcA nfcA = NfcA.get(tag);
        az azVar = new az();
        azVar.c = nfcA;
        azVar.f541k = mifareUltralight;
        azVar.e = Boolean.valueOf(z);
        azVar.f544n = bb.ULTRALIGHT;
        azVar.f551u = tag.getId();
        azVar.d = tag;
        azVar.j = c0158a;
        if (z && ndefMessageArr != null && ndefMessageArr.length == 1) {
            NdefRecord[] records = ndefMessageArr[0].getRecords();
            if (records.length == 1) {
                NdefRecord ndefRecord = records[0];
                if (ndefRecord.getTnf() == (short) 1) {
                    if (Arrays.equals(ndefRecord.getType(), new byte[]{(byte) 85})) {
                        bArr = new byte[]{(byte) 1, (byte) 116, (byte) 111, (byte) 117, (byte) 99, (byte) 104, (byte) 97, (byte) 110, (byte) 100, (byte) 116, (byte) 114, (byte) 97, (byte) 118, (byte) 101, (byte) 108, (byte) 46, (byte) 100, (byte) 101, (byte) 47, (byte) 73, (byte) 68, (byte) 63};
                        payload = ndefRecord.getPayload();
                        if (payload.length == bArr.length + 14) {
                            copyOfRange = Arrays.copyOfRange(payload, 0, bArr.length);
                            CharSequence str = new String(payload, bArr.length, 14, C0429j.f1361b);
                            CharSequence a = C0429j.m1393a(azVar.f551u, BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME);
                            if (Arrays.equals(bArr, copyOfRange) && TextUtils.equals(a, str)) {
                                azVar.g = "German public transport Touch and Travel tag";
                            }
                        } else {
                            copyOfRange = new byte[]{(byte) 0, (byte) 115, (byte) 101, (byte) 109, (byte) 99, (byte) 58, (byte) 47, (byte) 47, (byte) 108, (byte) 105, (byte) 118, (byte) 101, (byte) 119, (byte) 97, (byte) 114, (byte) 101, (byte) 47, (byte) 65, (byte) 49, (byte) 47, (byte) 49, (byte) 47, (byte) 78, (byte) 84, (byte) 49, (byte) 47};
                            bArr = new byte[]{(byte) 0, (byte) 115, (byte) 101, (byte) 109, (byte) 99, (byte) 58, (byte) 47, (byte) 47, (byte) 108, (byte) 105, (byte) 118, (byte) 101, (byte) 119, (byte) 97, (byte) 114, (byte) 101, (byte) 47, (byte) 65, (byte) 49, (byte) 47, (byte) 50, (byte) 47, (byte) 78, (byte) 84, (byte) 50, (byte) 47};
                            int length = copyOfRange.length;
                            byte[] copyOfRange2 = Arrays.copyOfRange(payload, 0, length);
                            String str2;
                            int i;
                            if (Arrays.equals(copyOfRange, copyOfRange2)) {
                                str2 = BuildConfig.VERSION_NAME;
                                i = payload[length] & MotionEventCompat.ACTION_MASK;
                                if (payload[length + 1] == 47) {
                                    switch (i) {
                                        case C0086R.styleable.SherlockTheme_windowMinWidthMinor /*49*/:
                                            str2 = " (Blue - Car)";
                                            break;
                                        case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /*50*/:
                                            str2 = " (Red - Home)";
                                            break;
                                        case C0086R.styleable.SherlockTheme_actionDropDownStyle /*51*/:
                                            str2 = " (Black - Bedroom)";
                                            break;
                                        case C0086R.styleable.SherlockTheme_actionButtonStyle /*52*/:
                                            str2 = " (White - Office)";
                                            break;
                                    }
                                }
                                azVar.g = "Sony Xperia SmartTag" + str2;
                            } else if (Arrays.equals(bArr, copyOfRange2)) {
                                str2 = BuildConfig.VERSION_NAME;
                                i = payload[length] & MotionEventCompat.ACTION_MASK;
                                if (payload[length + 1] == 47) {
                                    switch (i) {
                                        case C0086R.styleable.SherlockTheme_homeAsUpIndicator /*53*/:
                                            str2 = " (Gray - Active)";
                                            break;
                                        case C0086R.styleable.SherlockTheme_dropDownListViewStyle /*54*/:
                                            str2 = " (Orange - Listen)";
                                            break;
                                        case C0086R.styleable.SherlockTheme_popupMenuStyle /*55*/:
                                            str2 = " (Purple - Watch)";
                                            break;
                                        case C0086R.styleable.SherlockTheme_dropdownListPreferredItemHeight /*56*/:
                                            str2 = " (Green - Play)";
                                            break;
                                    }
                                }
                                azVar.g = "Sony Xperia SmartTag" + str2;
                            }
                        }
                    }
                }
            }
        }
        try {
            mifareUltralight.connect();
            try {
                copyOfRange = C0293a.m777a(mifareUltralight);
                if (copyOfRange != null && copyOfRange.length == 8 && copyOfRange[0] == null) {
                    azVar.a = copyOfRange;
                    if (copyOfRange[2] == 3) {
                        azVar.f544n = bb.ULTRALIGHT_EV1;
                    } else if (copyOfRange[2] == 4) {
                        azVar.f544n = bb.NTAG21x;
                        if (copyOfRange[4] == 2) {
                            azVar.f544n = bb.NTAG_I2C;
                        }
                    } else {
                        azVar.f544n = bb.UNKNOWN;
                    }
                    azVar.f549s = (C0302j) C0293a.f753d.get(new C0422a(copyOfRange));
                    if (azVar.f549s == null) {
                        azVar.f549s = C0302j.UNKNOWN;
                    }
                }
            } catch (IOException e) {
                try {
                    mifareUltralight.close();
                    mifareUltralight.connect();
                } catch (IOException e2) {
                }
            }
            copyOfRange = null;
            if (azVar.f544n == bb.ULTRALIGHT) {
                try {
                    mifareUltralight.readPages(16);
                    azVar.f544n = bb.NTAG203;
                } catch (IOException e3) {
                }
                try {
                    bArr = C0304l.m823a(mifareUltralight);
                    mifareUltralight.close();
                    mifareUltralight.connect();
                    if (bArr != null && bArr.length == 9 && bArr[0] == -81) {
                        if (C0304l.m822a(azVar.f541k, C0304l.f804b)) {
                            azVar.f552v = "Default sample key";
                        } else if (C0304l.m822a(azVar.f541k, C0304l.f803a)) {
                            azVar.f552v = "Default key";
                        }
                        azVar.f544n = bb.ULTRALIGHT_C;
                        copyOfRange = mifareUltralight.readPages(40);
                    }
                } catch (IOException e4) {
                }
            }
            if (azVar.f544n == bb.ULTRALIGHT) {
                try {
                    mifareUltralight.close();
                    mifareUltralight.connect();
                    mifareUltralight.readPages(0);
                } catch (TagLostException e5) {
                } catch (IOException e6) {
                    azVar.f544n = bb.NTAG_I2C;
                    azVar.f543m = true;
                }
            }
            Object obj = null;
            try {
                Object obj2;
                mifareUltralight.close();
                mifareUltralight.connect();
                obj = 1;
                if ((azVar.f544n == bb.ULTRALIGHT || (azVar.f544n == bb.ULTRALIGHT_EV1 && azVar.f549s == C0302j.UC0)) && !z && azVar.g == null) {
                    azVar.g = azVar.m551k();
                    if (azVar.g == null) {
                        azVar.g = azVar.m552l();
                    }
                    if (azVar.g == null) {
                        azVar.g = azVar.m550j();
                    }
                    if (azVar.g == null) {
                        azVar.g = azVar.m549i();
                    }
                }
                if (azVar.f544n == bb.ULTRALIGHT_EV1 || azVar.f544n == bb.NTAG21x) {
                    C0293a.m775a(azVar);
                } else if (azVar.f544n == bb.NTAG_I2C) {
                    azVar.f550t = C0303k.m816a(azVar);
                }
                if (!azVar.f543m) {
                    payload = mifareUltralight.readPages(2);
                    azVar.h = azVar.m547a(payload);
                    azVar.f553w = azVar.m546a(payload, copyOfRange);
                    if (z || (azVar.h != null && azVar.h.length >= 4 && azVar.h[0] == -31 && (azVar.h[1] & 240) == 16)) {
                        int i2;
                        switch (ba.f598a[azVar.f544n.ordinal()]) {
                            case C0519c.Switch_textOff /*3*/:
                            case C0519c.Switch_thumbTextPadding /*4*/:
                                i2 = 160;
                                break;
                            case C0519c.Switch_switchTextAppearance /*5*/:
                            case C0519c.Switch_switchMinWidth /*6*/:
                                i2 = C0293a.m769a(azVar.a, azVar.f549s) * 4;
                                break;
                            default:
                                i2 = 64;
                                break;
                        }
                        azVar.i = azVar.m548d(i2);
                    }
                }
                if (c0158a.m56n()) {
                    azVar.f = azVar.m559e();
                    mifareUltralight.close();
                    mifareUltralight.connect();
                    obj2 = 1;
                } else {
                    azVar.f = null;
                    obj2 = 1;
                }
                obj = obj2;
            } catch (TagLostException e7) {
                azVar.f542l = true;
            } catch (IOException e8) {
            }
            if (obj != null) {
                try {
                    mifareUltralight.close();
                } catch (IOException e9) {
                }
            }
            return azVar;
        } catch (TagLostException e10) {
            azVar.f542l = true;
            return azVar;
        } catch (IOException e11) {
            return azVar;
        }
    }

    public static String m545a(byte[][] bArr) {
        if (bArr[1][2] != null || bArr[1][3] != null || bArr[1][6] != null || bArr[1][7] != null) {
            return null;
        }
        if (((bArr[0][2] & MotionEventCompat.ACTION_MASK) != 240 && (bArr[0][2] & MotionEventCompat.ACTION_MASK) != 248) || ((bArr[0][3] & MotionEventCompat.ACTION_MASK) != 153 && (bArr[0][3] & MotionEventCompat.ACTION_MASK) != MotionEventCompat.ACTION_MASK && (bArr[0][3] & MotionEventCompat.ACTION_MASK) != 0)) {
            return null;
        }
        int i = bArr[0][14] & 15;
        if (i != 8 && i != 12 && i != 13) {
            return null;
        }
        String str;
        CharSequence charSequence;
        String str2 = "Moscow metro ticket";
        switch (((bArr[0][8] & MotionEventCompat.ACTION_MASK) << 2) | ((bArr[0][9] & 192) >> 6)) {
            case 262:
                break;
            case 264:
                str2 = "Moscow bus/tram/trolley ticket";
                break;
            case 266:
                str2 = "Moscow unified social ticket";
                break;
            case 270:
                str2 = "Moscow light metro ticket";
                break;
            case 279:
                str2 = "Moscow public transport ticket";
                break;
            default:
                return null;
        }
        Object obj;
        switch (((bArr[0][10] & 240) >> 4) | ((bArr[0][9] & 63) << 4)) {
            case 120:
            case 161:
            case 411:
                str = "single trip";
                obj = str2;
                i = 1;
                break;
            case 121:
            case 162:
            case 412:
                str = "2 trips";
                obj = str2;
                i = 2;
                break;
            case TransportMediator.KEYCODE_MEDIA_PLAY /*126*/:
            case 163:
            case 413:
                str = "5 trips";
                obj = str2;
                i = 5;
                break;
            case TransportMediator.KEYCODE_MEDIA_PAUSE /*127*/:
            case 164:
            case 414:
                str = "10 trips";
                obj = str2;
                i = 10;
                break;
            case AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS /*128*/:
            case 165:
            case 416:
                str = "20 trips";
                obj = str2;
                i = 20;
                break;
            case 129:
            case 166:
            case 418:
                str = "60 trips";
                obj = str2;
                i = 60;
                break;
            case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                str = "Luggage + single trip";
                obj = str2;
                i = 1;
                break;
            case 131:
                str = "Luggage";
                obj = str2;
                i = 1;
                break;
            case 148:
                charSequence = "Moscow public transport ticket";
                str = "one month (max. 70 trips by underground or monorail)";
                i = 70;
                break;
            case 149:
                str = "70 trips";
                obj = str2;
                i = 70;
                break;
            case 150:
                str = "\u0412\u0415\u0421\u0411";
                obj = str2;
                i = 100;
                break;
            case 415:
                str = "11 trips";
                obj = str2;
                i = 11;
                break;
            case 417:
                str = "40 trips";
                obj = str2;
                i = 40;
                break;
            case 421:
                str = "single activation (valid for 90 min.)";
                obj = str2;
                i = 1;
                break;
            case 422:
                str = "2 activations (valid for 90 min.)";
                obj = str2;
                i = 2;
                break;
            case 423:
                str = "5 activations (valid for 90 min.)";
                obj = str2;
                i = 5;
                break;
            case 425:
                str = "11 activations (valid for 90 min.)";
                obj = str2;
                i = 11;
                break;
            case 426:
                str = "20 activations (valid for 90 min.)";
                obj = str2;
                i = 20;
                break;
            case 427:
                str = "60 activations (valid for 90 min.)";
                obj = str2;
                i = 60;
                break;
            case 428:
                str = "40 activations (valid for 90 min.)";
                obj = str2;
                i = 40;
                break;
            default:
                str = EnvironmentCompat.MEDIA_UNKNOWN;
                charSequence = str2;
                i = -1;
                break;
        }
        int i2 = bArr[1][10] & MotionEventCompat.ACTION_MASK;
        switch (i2) {
            case C0519c.Switch_switchTextAppearance /*5*/:
            case C0086R.styleable.SherlockTheme_searchAutoCompleteTextView /*30*/:
            case C0086R.styleable.SherlockTheme_listPreferredItemPaddingLeft /*45*/:
            case C0086R.styleable.SherlockTheme_activatedBackgroundIndicator /*65*/:
            case 90:
                int a = C0429j.m1388a(bArr[1][8], bArr[1][9]);
                int a2 = C0429j.m1388a(bArr[0][15], bArr[1][0]);
                BigInteger bigInteger = new BigInteger(String.format("%02X%02X%02X%02X%X", new Object[]{Integer.valueOf(bArr[0][10] & 15), Integer.valueOf(bArr[0][11] & MotionEventCompat.ACTION_MASK), Integer.valueOf(bArr[0][12] & MotionEventCompat.ACTION_MASK), Integer.valueOf(bArr[0][13] & MotionEventCompat.ACTION_MASK), Integer.valueOf((bArr[0][14] & 240) >> 4)}), 16);
                Calendar instance = Calendar.getInstance();
                instance.clear();
                instance.set(1, 1992);
                instance.set(6, a);
                Calendar instance2 = Calendar.getInstance();
                instance2.clear();
                instance2.set(1, 1992);
                instance2.set(6, a2);
                a2 = C0429j.m1388a(bArr[1][12], bArr[1][13]);
                C0428i c0428i = new C0428i();
                c0428i.m1384a(charSequence);
                c0428i.m1384a(C0358k.f1076c + "Card no: " + bigInteger.toString());
                c0428i.m1384a(String.format(C0358k.f1076c + "Purchased: %s %s %d, %d", new Object[]{C0358k.f1074a[instance.get(7) - 1], C0358k.f1075b[instance.get(2)], Integer.valueOf(instance.get(5)), Integer.valueOf(instance.get(1))}));
                c0428i.m1384a(C0358k.f1076c + "Type: " + str);
                c0428i.m1384a(C0358k.f1076c + "Valid for: " + i2 + " days");
                if (instance2.compareTo(instance) >= 0) {
                    c0428i.m1384a(String.format(C0358k.f1076c + "Valid until: %s %s %d, %d", new Object[]{C0358k.f1074a[instance2.get(7) - 1], C0358k.f1075b[instance2.get(2)], Integer.valueOf(instance2.get(5)), Integer.valueOf(instance2.get(1))}));
                }
                if (a2 <= i && a2 >= 0) {
                    c0428i.m1384a(C0358k.f1076c + "Trips left: " + a2);
                }
                return c0428i.toString();
            default:
                return null;
        }
    }

    private boolean m546a(byte[] bArr, byte[] bArr2) {
        C0428i c0428i = new C0428i();
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        if (this.f544n == bb.ULTRALIGHT) {
            if ((bArr[2] & 7) == 7) {
                i = 1;
            } else {
                z = false;
            }
            if ((bArr[2] & 8) == 8) {
                i2 = 1;
            } else {
                z2 = false;
            }
            if ((bArr[2] & 240) == 240 && (bArr[3] & MotionEventCompat.ACTION_MASK) == MotionEventCompat.ACTION_MASK) {
                i3 = 1;
            } else {
                z3 = false;
            }
            if (bArr[4] == (byte) -1 && bArr[5] == (byte) -1 && bArr[6] == (byte) -1 && bArr[7] == (byte) -1) {
                i4 = 1;
            } else {
                z4 = false;
            }
            if (i == 0 || i2 == 0 || i3 == 0) {
                if (i2 != 0) {
                    c0428i.m1384a((CharSequence) "OTP bytes are locked");
                }
                if (i3 != 0) {
                    c0428i.m1384a((CharSequence) "Data pages are locked");
                }
                if (i != 0) {
                    c0428i.m1384a((CharSequence) "Lock configuration is frozen");
                }
            } else {
                c0428i.m1384a((CharSequence) "Memory is locked");
            }
            if (i4 != 0) {
                c0428i.m1384a((CharSequence) "All OTP bits are set");
            }
            this.f554x = c0428i.toString();
            return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? false : true;
        } else if (this.f544n != bb.ULTRALIGHT_C) {
            return false;
        } else {
            int i5;
            int i6;
            int i7;
            if (bArr2 == null) {
                bArr2 = new byte[]{(byte) 0, (byte) 0};
            }
            if ((bArr[2] & 7) == 7 && (bArr2[0] & 17) == 17 && (bArr2[1] & 15) == 15) {
                i = 1;
            } else {
                z = false;
            }
            if ((bArr[2] & 8) == 8) {
                i2 = 1;
            } else {
                z2 = false;
            }
            if ((bArr[2] & 240) == 240 && (bArr[3] & MotionEventCompat.ACTION_MASK) == MotionEventCompat.ACTION_MASK && (bArr2[0] & 238) == 238) {
                i3 = 1;
            } else {
                z3 = false;
            }
            if ((bArr2[1] & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) == AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
                i4 = 1;
            } else {
                z4 = false;
            }
            if ((bArr2[1] & 96) == 96) {
                i5 = 1;
            } else {
                boolean z5 = false;
            }
            if ((bArr2[1] & 16) == 16) {
                i6 = 1;
            } else {
                boolean z6 = false;
            }
            if (bArr[4] == (byte) -1 && bArr[5] == (byte) -1 && bArr[6] == (byte) -1 && bArr[7] == (byte) -1) {
                i7 = 1;
            } else {
                boolean z7 = false;
            }
            if (i == 0 || i2 == 0 || i3 == 0 || i4 == 0 || i5 == 0 || i6 == 0) {
                if (i2 != 0) {
                    c0428i.m1384a((CharSequence) "OTP bytes are locked");
                }
                if (i3 != 0) {
                    c0428i.m1384a((CharSequence) "Data pages are locked");
                }
                if (i4 != 0) {
                    c0428i.m1384a((CharSequence) "Authentication key is locked");
                }
                if (i5 != 0) {
                    c0428i.m1384a((CharSequence) "Authentication configuration is locked");
                }
                if (i6 != 0) {
                    c0428i.m1384a((CharSequence) "Counter is locked");
                }
                if (i != 0) {
                    c0428i.m1384a((CharSequence) "Lock configuration is frozen");
                }
            } else {
                c0428i.m1384a((CharSequence) "Memory is locked");
            }
            if (i7 != 0) {
                c0428i.m1384a((CharSequence) "All OTP bits are set");
            }
            this.f554x = c0428i.toString();
            return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0 && i6 == 0 && i7 == 0) ? false : true;
        }
    }

    private byte[] m547a(byte[] bArr) {
        return Arrays.copyOfRange(bArr, 4, 8);
    }

    private C0182c m548d(int i) {
        C0182c c0182c = new C0182c();
        int i2 = ((this.h[2] & MotionEventCompat.ACTION_MASK) * 8) + 16;
        if (i2 < i) {
            i = i2;
        }
        C0305m c0305m = new C0305m(this.f541k, i);
        Object obj = null;
        Object obj2 = null;
        i2 = 16;
        while (obj == null) {
            try {
                int a = c0305m.m825a(i2) & MotionEventCompat.ACTION_MASK;
                switch (a) {
                    case C0519c.Switch_thumb /*0*/:
                    case 253:
                        break;
                    case C0519c.Switch_track /*1*/:
                    case C0519c.Switch_textOn /*2*/:
                        obj2 = 1;
                        break;
                    case C0519c.Switch_textOff /*3*/:
                    case 254:
                        obj = 1;
                        break;
                    default:
                        obj = 1;
                        break;
                }
                if (obj != null) {
                    return c0182c;
                }
                int i3;
                Object obj3;
                if (obj2 != null) {
                    C0428i c0428i = new C0428i();
                    if (a == 1) {
                        c0428i.m1384a(String.format("Lock Control TLV at address 0x%02X, offset %d", new Object[]{Integer.valueOf(i2 / 4), Integer.valueOf(i2 % 4)}));
                    } else if (a == 2) {
                        c0428i.m1384a(String.format("Memory Control TLV at address 0x%02X, offset %d", new Object[]{Integer.valueOf(i2 / 4), Integer.valueOf(i2 % 4)}));
                    }
                    i2++;
                    int i4 = i2 + 1;
                    if ((c0305m.m825a(i2) & MotionEventCompat.ACTION_MASK) != 3) {
                        c0428i.m1384a(String.format(C0358k.f1076c + "Wrong length: %d", new Object[]{Integer.valueOf(c0305m.m825a(i2) & MotionEventCompat.ACTION_MASK)}));
                        c0182c.m147a(new C0193o(c0428i.toString()));
                        return c0182c;
                    }
                    int[] iArr = new int[3];
                    int i5 = i4 + 1;
                    iArr[0] = c0305m.m825a(i4) & MotionEventCompat.ACTION_MASK;
                    int i6 = i5 + 1;
                    iArr[1] = c0305m.m825a(i5) & MotionEventCompat.ACTION_MASK;
                    iArr[2] = c0305m.m825a(i6) & MotionEventCompat.ACTION_MASK;
                    byte[] bArr = new byte[]{(byte) a, (byte) i2, (byte) iArr[0], (byte) iArr[1], (byte) iArr[2]};
                    i5 = (iArr[0] >> 4) & 15;
                    int i7 = iArr[0] & 15;
                    i2 = iArr[1];
                    if (i2 == 0) {
                        i2 = AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
                    }
                    int i8 = ((1 << (iArr[2] & 15)) * i5) + i7;
                    if (a == 1) {
                        c0428i.m1384a(String.format(C0358k.f1076c + "Dynamic lock bytes at address 0x%02X, offset %d", new Object[]{Integer.valueOf(i8 / 4), Integer.valueOf(i8 % 4)}));
                    } else {
                        c0428i.m1384a(String.format(C0358k.f1076c + "Reserved area at address 0x%02X, offset %d", new Object[]{Integer.valueOf(i8 / 4), Integer.valueOf(i8 % 4)}));
                    }
                    if (a == 1) {
                        c0428i.m1384a(String.format("\t\u2022 %d lock bits<hexoutput> (0x%02X)</hexoutput>", new Object[]{Integer.valueOf(i2), Integer.valueOf(iArr[1])}));
                        i2 = 1 << ((iArr[2] >> 4) & 15);
                        c0428i.m1384a(String.format("\t\u2022 %d bytes locked per lock bit<hexoutput> (0x%X)", new Object[]{Integer.valueOf(i2), Integer.valueOf((iArr[2] >> 4) & 15)}));
                    } else {
                        c0428i.m1384a(String.format("\t\u2022 Reserved area length: %d bytes<hexoutput> (0x%02X)", new Object[]{Integer.valueOf(i2), Integer.valueOf(iArr[1])}));
                    }
                    c0428i.m1384a((CharSequence) "\t\u2022 Address calculation:");
                    c0428i.m1384a(String.format("\t\t~ page address: 0x%X", new Object[]{Integer.valueOf(i5)}));
                    c0428i.m1384a(String.format("\t\t~ byte offset: 0x%X", new Object[]{Integer.valueOf(i7)}));
                    c0428i.m1384a(C0429j.m1391a(String.format("\t\t~ %d bytes per page (1<<0x%X)", new Object[]{Integer.valueOf(1 << r12), Integer.valueOf(r12)})) + "</hexoutput>");
                    c0182c.m147a(new C0193o(c0428i.toString()));
                    c0182c.m147a(new C0184h(-1, bArr));
                    i3 = i6 + 1;
                    obj3 = null;
                } else if (a == 0) {
                    obj3 = obj2;
                    i3 = i2 + 1;
                } else {
                    a = i2 + 1;
                    i2 = c0305m.m825a(a) & MotionEventCompat.ACTION_MASK;
                    if (i2 == MotionEventCompat.ACTION_MASK) {
                        i2 = a + 1;
                        a = i2 + 1;
                        i2 = ((c0305m.m825a(i2) & MotionEventCompat.ACTION_MASK) * AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) + (c0305m.m825a(a) & MotionEventCompat.ACTION_MASK);
                    }
                    i2 = (i2 + 1) + a;
                    obj3 = obj2;
                    i3 = i2;
                }
                obj = i3 >= i ? 1 : obj;
                i2 = i3;
                obj2 = obj3;
            } catch (TagLostException e) {
                throw e;
            } catch (IOException e2) {
                this.f541k.close();
                this.f541k.connect();
            }
        }
        return c0182c;
    }

    private String m549i() {
        byte[] bArr = new byte[]{(byte) 6, (byte) 10, (byte) 0, (byte) 33, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        byte[] readPages = this.f541k.readPages(4);
        return (readPages.length == 16 && Arrays.equals(bArr, Arrays.copyOfRange(readPages, 0, bArr.length))) ? "VingCard hotel room key" : null;
    }

    private String m550j() {
        CharSequence charSequence = null;
        if (this.e.booleanValue()) {
            return null;
        }
        C0305m c0305m = new C0305m(this.f541k);
        if (c0305m.m828b(4) != 606085762) {
            return null;
        }
        int i;
        for (byte b : c0305m.m830c(7)) {
            if (b != null) {
                return null;
            }
        }
        C0428i c0428i = new C0428i();
        c0428i.m1384a((CharSequence) "Riga public transport ticket");
        long j = 0;
        for (i = 6; i > 0; i--) {
            j = (j * 256) + ((long) (this.f551u[i] & MotionEventCompat.ACTION_MASK));
        }
        c0428i.m1384a(C0358k.f1076c + "Card no: 1-" + j);
        switch (c0305m.m826a(6, 2)) {
            case (byte) -119:
                charSequence = "5-trip ticket";
                break;
            case (byte) -87:
                charSequence = "10-trip ticket";
                break;
            case (byte) -55:
                charSequence = "20-trip ticket";
                break;
            case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                if (c0305m.m826a(6, 3) == -29) {
                    charSequence = "3-day ticket";
                    break;
                }
                break;
            case C0086R.styleable.SherlockTheme_searchResultListItemHeight /*41*/:
                if (c0305m.m826a(6, 3) == -29) {
                    charSequence = "Single day ticket";
                    break;
                }
                break;
            default:
                charSequence = String.format("Unknown ticket type<hexoutput> (0x%02X)</hexoutput>", new Object[]{Byte.valueOf(c0305m.m826a(6, 2))});
                break;
        }
        if (!TextUtils.isEmpty(charSequence)) {
            c0428i.m1387b(C0358k.f1076c);
            c0428i.m1384a(charSequence);
        }
        c0428i.m1387b("\t\u2022 ");
        int i2 = 0;
        for (byte valueOf : c0305m.m830c(3)) {
            Byte valueOf2 = Byte.valueOf(valueOf);
            i = 0;
            while (i < 8) {
                if (((valueOf2.byteValue() >>> i) & 1) == 1) {
                    c0428i.m1384a(i2 + " trips left");
                    if (c0305m.m828b(12) != 0) {
                        c0428i.m1384a(C0358k.f1076c + "No trips recorded");
                        return c0428i.toString();
                    }
                    c0428i.m1384a(C0358k.f1076c + "Recorded trips:");
                    for (i2 = 0; i2 < 2; i2++) {
                        i = (i2 * 4) + 8;
                        if (c0305m.m828b(i) == 16264192) {
                            c0428i.m1387b("\t\u2022 ");
                            switch (c0305m.m826a(i, 0)) {
                                case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                                    c0428i.m1387b("Bus");
                                    break;
                                case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                                    c0428i.m1387b("Tram");
                                    break;
                                case C0086R.styleable.SherlockTheme_actionMenuTextAppearance /*10*/:
                                    c0428i.m1387b("Trolley");
                                    break;
                                default:
                                    c0428i.m1387b("Unknown transport");
                                    c0428i.m1387b("<hexoutput> (");
                                    c0428i.m1387b(String.format("0x%02X", new Object[]{Byte.valueOf(c0305m.m826a(i, 0))}));
                                    c0428i.m1387b(")</hexoutput>");
                                    break;
                            }
                            if (c0305m.m826a(i + 1, 1) == -128) {
                                c0428i.m1387b(" (inspected)");
                            }
                            c0428i.m1383a();
                        }
                    }
                    return c0428i.toString();
                }
                i++;
                i2++;
            }
        }
        c0428i.m1384a(i2 + " trips left");
        if (c0305m.m828b(12) != 0) {
            c0428i.m1384a(C0358k.f1076c + "Recorded trips:");
            for (i2 = 0; i2 < 2; i2++) {
                i = (i2 * 4) + 8;
                if (c0305m.m828b(i) == 16264192) {
                    c0428i.m1387b("\t\u2022 ");
                    switch (c0305m.m826a(i, 0)) {
                        case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                            c0428i.m1387b("Bus");
                            break;
                        case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                            c0428i.m1387b("Tram");
                            break;
                        case C0086R.styleable.SherlockTheme_actionMenuTextAppearance /*10*/:
                            c0428i.m1387b("Trolley");
                            break;
                        default:
                            c0428i.m1387b("Unknown transport");
                            c0428i.m1387b("<hexoutput> (");
                            c0428i.m1387b(String.format("0x%02X", new Object[]{Byte.valueOf(c0305m.m826a(i, 0))}));
                            c0428i.m1387b(")</hexoutput>");
                            break;
                    }
                    if (c0305m.m826a(i + 1, 1) == -128) {
                        c0428i.m1387b(" (inspected)");
                    }
                    c0428i.m1383a();
                }
            }
            return c0428i.toString();
        }
        c0428i.m1384a(C0358k.f1076c + "No trips recorded");
        return c0428i.toString();
    }

    private String m551k() {
        C0428i c0428i = new C0428i();
        byte[][] bArr = new byte[][]{this.f541k.readPages(4), this.f541k.readPages(8)};
        int[] iArr = new int[2];
        Calendar[] calendarArr = new Calendar[2];
        for (int i = 0; i < 2; i++) {
            iArr[i] = (((bArr[i][0] & 7) * AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD) + ((bArr[i][1] & MotionEventCompat.ACTION_MASK) * 16)) + ((bArr[i][2] >>> 4) & 15);
            int i2 = (((bArr[i][4] & 31) << 9) + ((bArr[i][5] & MotionEventCompat.ACTION_MASK) << 1)) + (((bArr[i][6] & MotionEventCompat.ACTION_MASK) >>> 7) & 1);
            int i3 = ((bArr[i][6] & TransportMediator.KEYCODE_MEDIA_PAUSE) * 16) + ((bArr[i][7] >>> 4) & 15);
            calendarArr[i] = Calendar.getInstance();
            calendarArr[i].clear();
            calendarArr[i].set(1, 1997);
            calendarArr[i].set(6, i2 + 1);
            calendarArr[i].set(12, i3);
        }
        if ((iArr[1] != 1 || iArr[0] != 32767) && (iArr[0] == iArr[1] || iArr[1] - iArr[0] > 2 || iArr[0] - iArr[1] > 2)) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        if (calendarArr[0].after(instance) || calendarArr[1].after(instance)) {
            return null;
        }
        Object obj = null;
        c0428i.m1384a((CharSequence) "OV-chipkaart (disposable)");
        i3 = 0;
        while (i3 < 2) {
            if (iArr[i3] != 32767) {
                CharSequence charSequence;
                c0428i.m1387b(String.format(C0358k.f1076c + "Transaction %d: ", new Object[]{Integer.valueOf(iArr[i3])}));
                switch ((bArr[i3][4] >>> 5) & 7) {
                    case C0519c.Switch_thumb /*0*/:
                        charSequence = "purchase";
                        break;
                    case C0519c.Switch_track /*1*/:
                        charSequence = "check-in";
                        break;
                    case C0519c.Switch_textOn /*2*/:
                        charSequence = "check-out";
                        break;
                    case C0519c.Switch_switchMinWidth /*6*/:
                        charSequence = "transfer";
                        break;
                    default:
                        charSequence = String.format("unknown transaction type (0x%02X)", new Object[]{Integer.valueOf((bArr[i3][4] >>> 5) & 7)});
                        break;
                }
                c0428i.m1384a(charSequence);
                if (!(bArr[i3][4] == null && bArr[i3][5] == null && bArr[i3][6] == null && bArr[i3][7] == null)) {
                    c0428i.m1384a(String.format("\t\u2022 %s %s %d %d, %02d:%02d", new Object[]{C0358k.f1074a[calendarArr[i3].get(7) - 1], C0358k.f1075b[calendarArr[i3].get(2)], Integer.valueOf(calendarArr[i3].get(5)), Integer.valueOf(calendarArr[i3].get(1)), Integer.valueOf(calendarArr[i3].get(11)), Integer.valueOf(calendarArr[i3].get(12))}));
                }
                switch (((bArr[i3][2] & 15) * AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) + (bArr[i3][3] & MotionEventCompat.ACTION_MASK)) {
                    case C0519c.Switch_thumb /*0*/:
                        charSequence = "Trans Link Systems";
                        break;
                    case C0519c.Switch_track /*1*/:
                        charSequence = "Connexxion/Hermes/Breng";
                        break;
                    case C0519c.Switch_textOn /*2*/:
                        charSequence = "GVB (Amsterdam)";
                        break;
                    case C0519c.Switch_textOff /*3*/:
                        charSequence = "HTM (the Hague)";
                        break;
                    case C0519c.Switch_thumbTextPadding /*4*/:
                        charSequence = "Nederlandse Spoorwegen";
                        break;
                    case C0519c.Switch_switchTextAppearance /*5*/:
                        charSequence = "RET (Rotterdam)";
                        obj = 1;
                        break;
                    case C0519c.Switch_switchPadding /*7*/:
                        charSequence = "Veolia";
                        break;
                    case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                        charSequence = "Arriva/Aquabus";
                        break;
                    case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                        charSequence = "Syntus";
                        break;
                    case C0086R.styleable.SherlockTheme_actionMenuTextAppearance /*10*/:
                        charSequence = "Qbuzz";
                        break;
                    case C0086R.styleable.SherlockTheme_actionModeStyle /*12*/:
                    case C0086R.styleable.SherlockTheme_listPreferredItemHeightSmall /*44*/:
                        charSequence = "DUO (Studenten OV-chipkaart)";
                        break;
                    case C0086R.styleable.SherlockTheme_textColorPrimary /*25*/:
                        charSequence = "AH/Primera/Hermes (charging station)";
                        break;
                    default:
                        charSequence = String.format("[Unknown] (0x%03X)", new Object[]{Integer.valueOf(((bArr[i3][2] & 15) * AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) + (bArr[i3][3] & MotionEventCompat.ACTION_MASK))});
                        break;
                }
                if (!TextUtils.isEmpty(charSequence)) {
                    c0428i.m1387b("\t\u2022 ");
                    c0428i.m1387b("Transport company: ");
                    c0428i.m1384a(charSequence);
                }
            }
            i3++;
        }
        if (obj != null) {
            long j = 0;
            for (byte b : this.f541k.getTag().getId()) {
                j = (j << 8) + ((long) (b & MotionEventCompat.ACTION_MASK));
            }
            c0428i.m1387b(C0358k.f1076c);
            c0428i.m1384a(String.format("Card no: %d", new Object[]{Long.valueOf(j)}));
        }
        return c0428i.toString();
    }

    private String m552l() {
        return az.m545a(new byte[][]{this.f541k.readPages(2), this.f541k.readPages(6)});
    }

    public void m553a(C0197a c0197a, boolean z) {
        CharSequence charSequence = BuildConfig.VERSION_NAME;
        if (this.f544n == bb.ULTRALIGHT) {
            charSequence = "64 bytes total memory\n" + C0358k.f1076c + "16 pages, with 4 bytes per page\n" + C0358k.f1076c + "48 bytes user memory (12 pages)";
        } else if (this.f544n == bb.ULTRALIGHT_C) {
            charSequence = "192 bytes total memory\n" + C0358k.f1076c + "48 pages, with 4 bytes per page\n" + C0358k.f1076c + "144 bytes user memory (36 pages)";
        } else if (this.f544n == bb.NTAG203) {
            charSequence = "168 bytes total memory\n" + C0358k.f1076c + "42 pages, with 4 bytes per page\n" + C0358k.f1076c + "144 bytes user memory (36 pages)";
        } else if (this.a != null) {
            Integer d = C0372z.m1118d(this.a);
            if (d != null) {
                int i = d.intValue() % 4 > 0 ? 1 : 0;
                charSequence = C0372z.m1117c(this.a) + " user memory\n" + C0358k.f1076c + String.format("%d pages, with 4 bytes per page", new Object[]{Integer.valueOf(i + (d.intValue() / 4))});
            }
            if (this.f544n == bb.NTAG_I2C) {
                charSequence = charSequence + "\n64 bytes SRAM buffer for fast data transfer to I\u00b2C";
            }
        }
        if (this.f553w) {
            c0197a.m197b("Memory information", charSequence + "\n" + this.f554x);
        } else {
            c0197a.m193a(charSequence);
        }
        if (this.a != null) {
            charSequence = (String) C0293a.f750a.get(new C0422a(this.a));
            if (!TextUtils.isEmpty(charSequence)) {
                C0428i c0428i = new C0428i();
                c0428i.m1387b("Full product name: ");
                c0428i.m1384a(charSequence);
                i = this.a[3] & 15;
                c0428i.m1387b("Capacitance: ");
                switch (i) {
                    case C0519c.Switch_track /*1*/:
                    case C0519c.Switch_textOff /*3*/:
                        c0428i.m1384a((CharSequence) "17\u200apF");
                        break;
                    case C0519c.Switch_textOn /*2*/:
                    case C0519c.Switch_thumbTextPadding /*4*/:
                    case C0519c.Switch_switchTextAppearance /*5*/:
                        c0428i.m1384a((CharSequence) "50\u200apF");
                        break;
                }
                switch (i) {
                    case C0519c.Switch_thumbTextPadding /*4*/:
                    case C0519c.Switch_switchTextAppearance /*5*/:
                        c0428i.m1384a((CharSequence) "RF field detection");
                        break;
                }
                switch (i) {
                    case C0519c.Switch_switchTextAppearance /*5*/:
                        c0428i.m1384a(C0362o.f1101h);
                        break;
                }
                c0197a.m198c(c0428i.toString());
            }
        } else if (this.f544n == bb.NTAG203) {
            c0197a.m198c("Full product name:\n" + C0358k.f1076c + "NT2H0301G0DUD or NT2H0301F0DTx");
        } else if (this.f544n == bb.NTAG_I2C) {
            C0428i c0428i2 = new C0428i();
            c0428i2.m1387b("Full product name: ");
            c0428i2.m1384a((CharSequence) "NT3H1101W0FHK or NT3H1201W0FHK");
            c0428i2.m1387b("Capacitance: ");
            c0428i2.m1384a((CharSequence) "50\u200apF");
            c0428i2.m1384a((CharSequence) "RF field detection");
            c0428i2.m1384a(C0362o.f1101h);
            c0197a.m198c(c0428i2.toString());
        }
        if (this.f544n == bb.ULTRALIGHT_C && this.f552v != null) {
            c0197a.m203e("Authentication information", this.f552v);
        }
        if (!TextUtils.isEmpty(this.f545o)) {
            c0197a.m203e("Originality check", this.f545o);
        }
        if (this.f544n == bb.NTAG21x || this.f544n == bb.ULTRALIGHT_EV1) {
            c0197a.m207g("Configuration information", C0293a.m783b(this));
        } else if (this.f544n == bb.NTAG_I2C && this.f550t != null) {
            c0197a.m207g("Start-up configuration", C0303k.m813a(this.f550t[0], false, false, C0372z.m1118d(this.a)));
            c0197a.m203e("Session configuration", C0303k.m813a(this.f550t[1], true, false, C0372z.m1118d(this.a)));
        }
        if (!TextUtils.isEmpty(this.f548r)) {
            c0197a.m195a((CharSequence) "Virtual Card Type Identifier", this.f548r);
        }
        if (this.a != null) {
            c0428i2 = new C0428i();
            c0428i2.m1384a(C0372z.m1115a(this.a));
            c0197a.m201d("Version information", c0428i2.toString());
        }
    }

    public void m554a(C0199c c0199c, boolean z) {
        c0199c.m230d("NXP Semiconductors");
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        Object d = m558d();
        String str;
        if (this.f544n == bb.NTAG21x) {
            str = (String) C0293a.f751b.get(new C0422a(this.a));
            if (TextUtils.isEmpty(str)) {
                str = "NTAG21x";
                if (C0372z.m1116b(this.a) && (this.a[3] & 15) == 4) {
                    str = str + "F";
                }
            }
            stringBuilder.append(str);
        } else if (this.f544n == bb.NTAG203) {
            stringBuilder.append("NTAG203(F)");
        } else if (this.f544n == bb.NTAG_I2C) {
            str = (String) C0293a.f751b.get(new C0422a(this.a));
            if (str == null) {
                str = "NTAG I\u00b2C (NT3H1101/NT3H1201)";
            }
            stringBuilder.append(str);
        } else {
            stringBuilder.append("MIFARE Ultralight");
            if (this.f544n == bb.ULTRALIGHT_EV1) {
                stringBuilder.append(" EV1");
            } else if (this.f544n == bb.ULTRALIGHT_C) {
                stringBuilder.append(" C");
            } else if (this.f544n == bb.UNKNOWN) {
                stringBuilder.append(" (unknown type)");
            }
        }
        if (!TextUtils.isEmpty(d)) {
            stringBuilder.append(" (");
            stringBuilder.append(d);
            stringBuilder.append(")");
        }
        c0199c.m231e(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder(BuildConfig.VERSION_NAME);
        if (!TextUtils.isEmpty(this.g)) {
            stringBuilder2.append(this.g);
        }
        c0199c.m227b(stringBuilder2.toString());
    }

    public void m555a(C0200d c0200d, boolean z) {
        c0200d.m238a((CharSequence) "ISO/IEC 14443-3 (Type A) compatible\nISO/IEC 14443-2 (Type A) compatible");
        C0369v.m1097a(this.c, c0200d);
        if (this.f != null) {
            c0200d.m237a(this.f);
        }
    }

    public boolean m556a() {
        return true;
    }

    public boolean m557b() {
        return this.f542l;
    }

    public String m558d() {
        return this.f544n == bb.ULTRALIGHT ? "MF0ICU1" : this.f544n == bb.ULTRALIGHT_C ? "MF0ICU2" : this.a != null ? (String) C0293a.f752c.get(new C0422a(this.a)) : BuildConfig.VERSION_NAME;
    }

    protected C0182c m559e() {
        if (this.f544n == bb.UNKNOWN) {
            try {
                this.f541k.close();
                this.c.connect();
                return super.m541e();
            } catch (IOException e) {
                this.f542l = true;
                return null;
            }
        } else if (this.f544n == bb.NTAG_I2C) {
            return C0303k.m817b(this);
        } else {
            if (this.f544n == bb.ULTRALIGHT_C || this.f544n == bb.NTAG203) {
                return C0304l.m819a(this);
            }
            if (this.f544n == bb.ULTRALIGHT_EV1 || this.f544n == bb.NTAG21x) {
                return C0293a.m786c(this);
            }
            C0182c c0182c = new C0182c();
            try {
                int i;
                byte[] readPages = this.f541k.readPages(0);
                int i2 = 0;
                if (this.h[0] == -31) {
                    i2 = ((this.h[2] * 8) / 4) + 3;
                }
                int a = this.a != null ? C0293a.m769a(this.a, this.f549s) : i2;
                byte b = readPages[10];
                byte b2 = readPages[11];
                String str = "(UID0-UID2, BCC0)";
                if ((((((readPages[0] ^ 136) ^ readPages[1]) ^ readPages[2]) ^ readPages[3]) & MotionEventCompat.ACTION_MASK) != 0) {
                    str = str + " CRC error";
                }
                c0182c.m147a(new C0195p(0, "*", Arrays.copyOfRange(readPages, 0, 4), str));
                str = "(UID3-UID6)";
                if ((((((readPages[4] ^ readPages[5]) ^ readPages[6]) ^ readPages[7]) ^ readPages[8]) & MotionEventCompat.ACTION_MASK) != 0) {
                    str = str + " CRC error";
                }
                c0182c.m147a(new C0195p(1, "*", Arrays.copyOfRange(readPages, 4, 8), str));
                str = (b & 7) == 7 ? "*" : (b == null && b2 == null) ? "." : (b & 7) == 0 ? "x" : "+";
                c0182c.m147a(new C0195p(2, str, Arrays.copyOfRange(readPages, 8, 12), "(BCC1, INT, LOCK0-LOCK1)"));
                str = (b & 8) != 0 ? (b & 1) != 0 ? "*" : "x" : (b & 1) != 0 ? "+" : ".";
                c0182c.m147a(new C0195p(3, str, Arrays.copyOfRange(readPages, 12, 16), "(OTP0-OTP3)"));
                for (i = 1; i < 4; i++) {
                    String[] a2 = C0253s.m522a(i, b, b2);
                    byte[] readPages2 = this.f541k.readPages(i * 4);
                    if (readPages2.length >= 16) {
                        for (i2 = 0; i2 < readPages2.length; i2 += 4) {
                            c0182c.m147a(new C0195p((i * 4) + (i2 / 4), a2[i2 / 4], Arrays.copyOfRange(readPages2, i2, i2 + 4)));
                        }
                    }
                }
                if (a >= 16) {
                    this.f541k.close();
                    this.c.connect();
                    int i3 = 16;
                    i2 = 0;
                    while (i3 <= a) {
                        if (i3 % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY == 0) {
                            i2++;
                            m536b(i2);
                            i = i2;
                        } else {
                            i = i2;
                        }
                        byte[] a3 = m535a(i3 % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
                        if (a3.length >= 16) {
                            for (i2 = 0; i2 < a3.length; i2 += 4) {
                                if ((i2 / 4) + i3 <= a) {
                                    c0182c.m147a(new C0195p((i2 / 4) + i3, " ", Arrays.copyOfRange(a3, i2, i2 + 4)));
                                }
                            }
                        }
                        i3 += 4;
                        i2 = i;
                    }
                }
                this.c.close();
                this.f541k.connect();
            } catch (IOException e2) {
                this.c.close();
                this.f541k.connect();
                throw new TagLostException("SectorSelect failed");
            } catch (TagLostException e3) {
                this.f542l = true;
                c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "\n<aborted: tag disappeared>")));
            } catch (IndexOutOfBoundsException e4) {
                c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "\n<aborted: cannot read any further>")));
            } catch (IOException e5) {
                c0182c.m147a(new C0194n(C0429j.m1391a((CharSequence) "\n<aborted: read error>")));
            }
            c0182c.m147a(new C0193o(C0429j.m1391a((CharSequence) "\n  *:locked & blocked, x:locked,\n  +:blocked, .:un(b)locked")));
            return c0182c;
        }
    }

    public byte[][] m560h() {
        return this.f550t;
    }
}
