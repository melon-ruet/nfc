package com.nxp.taginfolite.p004f;

import android.nfc.TagLostException;
import android.nfc.tech.NfcA;
import android.support.v4.BuildConfig;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.SparseArray;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.p003g.C0428i;
import com.nxp.taginfolite.p003g.C0429j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.f.d */
public class C0351d {
    static SparseArray f1063a;
    private static final SparseArray f1064b;

    static {
        f1063a = new SparseArray();
        f1063a.append(0, "302.0\u200a\u00b5s");
        f1063a.append(1, "604.1\u200a\u00b5s");
        f1063a.append(2, "1.208\u200ams");
        f1063a.append(3, "2.417\u200ams");
        f1063a.append(4, "4.833\u200ams");
        f1063a.append(5, "9.666\u200ams");
        f1063a.append(6, "19.33\u200ams");
        f1063a.append(7, "38.66\u200ams");
        f1063a.append(8, "77.33\u200ams");
        f1063a.append(9, "154.7\u200ams");
        f1063a.append(10, "309.3\u200ams");
        f1063a.append(11, "618.6\u200ams");
        f1063a.append(12, "1.237\u200as");
        f1063a.append(13, "2.474\u200as");
        f1063a.append(14, "4.949\u200as");
        f1063a.append(15, "[invalid] (Integer = 15");
        f1064b = new SparseArray();
        f1064b.append(4, "Afghanistan");
        f1064b.append(8, "Albania");
        f1064b.append(10, "Antarctica");
        f1064b.append(12, "Algeria");
        f1064b.append(16, "American Samoa");
        f1064b.append(20, "Andorra");
        f1064b.append(24, "Angola");
        f1064b.append(28, "Antigua and Barbuda");
        f1064b.append(31, "Azerbaijan");
        f1064b.append(32, "Argentina");
        f1064b.append(36, "Australia");
        f1064b.append(40, "Austria");
        f1064b.append(44, "Bahamas");
        f1064b.append(48, "Bahrain");
        f1064b.append(50, "Bangladesh");
        f1064b.append(51, "Armenia");
        f1064b.append(52, "Barbados");
        f1064b.append(56, "Belgium");
        f1064b.append(60, "Bermuda");
        f1064b.append(64, "Bhutan");
        f1064b.append(68, "Bolivia, Plurinational State of");
        f1064b.append(70, "Bosnia and Herzegovina");
        f1064b.append(72, "Botswana");
        f1064b.append(74, "Bouvet Island");
        f1064b.append(76, "Brazil");
        f1064b.append(84, "Belize");
        f1064b.append(86, "British Indian Ocean Territory");
        f1064b.append(90, "Solomon Islands");
        f1064b.append(92, "Virgin Islands, British");
        f1064b.append(96, "Brunei Darussalam");
        f1064b.append(100, "Bulgaria");
        f1064b.append(104, "Myanmar");
        f1064b.append(108, "Burundi");
        f1064b.append(112, "Belarus");
        f1064b.append(116, "Cambodia");
        f1064b.append(120, "Cameroon");
        f1064b.append(124, "Canada");
        f1064b.append(132, "Cape Verde");
        f1064b.append(136, "Cayman Islands");
        f1064b.append(140, "Central African Republic");
        f1064b.append(144, "Sri Lanka");
        f1064b.append(148, "Chad");
        f1064b.append(152, "Chile");
        f1064b.append(156, "China");
        f1064b.append(158, "Taiwan, Province of China");
        f1064b.append(162, "Christmas Island");
        f1064b.append(166, "Cocos (Keeling) Islands");
        f1064b.append(170, "Colombia");
        f1064b.append(174, "Comoros");
        f1064b.append(175, "Mayotte");
        f1064b.append(178, "Congo");
        f1064b.append(180, "Congo, the Democratic Republic of the");
        f1064b.append(184, "Cook Islands");
        f1064b.append(188, "Costa Rica");
        f1064b.append(191, "Croatia");
        f1064b.append(192, "Cuba");
        f1064b.append(196, "Cyprus");
        f1064b.append(203, "Czech Republic");
        f1064b.append(204, "Benin");
        f1064b.append(208, "Denmark");
        f1064b.append(212, "Dominica");
        f1064b.append(214, "Dominican Republic");
        f1064b.append(218, "Ecuador");
        f1064b.append(222, "El Salvador");
        f1064b.append(226, "Equatorial Guinea");
        f1064b.append(231, "Ethiopia");
        f1064b.append(232, "Eritrea");
        f1064b.append(233, "Estonia");
        f1064b.append(234, "Faroe Islands");
        f1064b.append(238, "Falkland Islands (Malvinas)");
        f1064b.append(239, "South Georgia and the South Sandwich Islands");
        f1064b.append(242, "Fiji");
        f1064b.append(246, "Finland");
        f1064b.append(248, "\u00c5land Islands");
        f1064b.append(250, "France");
        f1064b.append(254, "French Guiana");
        f1064b.append(258, "French Polynesia");
        f1064b.append(260, "French Southern Territories");
        f1064b.append(262, "Djibouti");
        f1064b.append(266, "Gabon");
        f1064b.append(268, "Georgia");
        f1064b.append(270, "Gambia");
        f1064b.append(275, "Palestinian Territory, Occupied");
        f1064b.append(276, "Germany");
        f1064b.append(288, "Ghana");
        f1064b.append(292, "Gibraltar");
        f1064b.append(296, "Kiribati");
        f1064b.append(300, "Greece");
        f1064b.append(304, "Greenland");
        f1064b.append(308, "Grenada");
        f1064b.append(312, "Guadeloupe");
        f1064b.append(316, "Guam");
        f1064b.append(320, "Guatemala");
        f1064b.append(324, "Guinea");
        f1064b.append(328, "Guyana");
        f1064b.append(332, "Haiti");
        f1064b.append(334, "Heard Island and McDonald Islands");
        f1064b.append(336, "Holy See (Vatican City State)");
        f1064b.append(340, "Honduras");
        f1064b.append(344, "Hong Kong");
        f1064b.append(348, "Hungary");
        f1064b.append(352, "Iceland");
        f1064b.append(356, "India");
        f1064b.append(360, "Indonesia");
        f1064b.append(364, "Iran, Islamic Republic of");
        f1064b.append(368, "Iraq");
        f1064b.append(372, "Ireland");
        f1064b.append(376, "Israel");
        f1064b.append(380, "Italy");
        f1064b.append(384, "C\u00f4te d'Ivoire");
        f1064b.append(388, "Jamaica");
        f1064b.append(392, "Japan");
        f1064b.append(398, "Kazakhstan");
        f1064b.append(400, "Jordan");
        f1064b.append(404, "Kenya");
        f1064b.append(408, "Korea, Democratic People's Republic of");
        f1064b.append(410, "Korea, Republic of");
        f1064b.append(414, "Kuwait");
        f1064b.append(417, "Kyrgyzstan");
        f1064b.append(418, "Lao People's Democratic Republic");
        f1064b.append(422, "Lebanon");
        f1064b.append(426, "Lesotho");
        f1064b.append(428, "Latvia");
        f1064b.append(430, "Liberia");
        f1064b.append(434, "Libyan Arab Jamahiriya");
        f1064b.append(438, "Liechtenstein");
        f1064b.append(440, "Lithuania");
        f1064b.append(442, "Luxembourg");
        f1064b.append(446, "Macao");
        f1064b.append(450, "Madagascar");
        f1064b.append(454, "Malawi");
        f1064b.append(458, "Malaysia");
        f1064b.append(462, "Maldives");
        f1064b.append(466, "Mali");
        f1064b.append(470, "Malta");
        f1064b.append(474, "Martinique");
        f1064b.append(478, "Mauritania");
        f1064b.append(480, "Mauritius");
        f1064b.append(484, "Mexico");
        f1064b.append(492, "Monaco");
        f1064b.append(496, "Mongolia");
        f1064b.append(498, "Moldova, Republic of");
        f1064b.append(499, "Montenegro");
        f1064b.append(500, "Montserrat");
        f1064b.append(504, "Morocco");
        f1064b.append(508, "Mozambique");
        f1064b.append(AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY, "Oman");
        f1064b.append(516, "Namibia");
        f1064b.append(520, "Nauru");
        f1064b.append(524, "Nepal");
        f1064b.append(528, "Netherlands");
        f1064b.append(531, "Cura\u00e7ao");
        f1064b.append(533, "Aruba");
        f1064b.append(534, "Sint Maarten (Dutch part)");
        f1064b.append(535, "Bonaire, Saint Eustatius and Saba");
        f1064b.append(540, "New Caledonia");
        f1064b.append(548, "Vanuatu");
        f1064b.append(554, "New Zealand");
        f1064b.append(558, "Nicaragua");
        f1064b.append(562, "Niger");
        f1064b.append(566, "Nigeria");
        f1064b.append(570, "Niue");
        f1064b.append(574, "Norfolk Island");
        f1064b.append(578, "Norway");
        f1064b.append(580, "Northern Mariana Islands");
        f1064b.append(581, "United States Minor Outlying Islands");
        f1064b.append(583, "Micronesia, Federated States of");
        f1064b.append(584, "Marshall Islands");
        f1064b.append(585, "Palau");
        f1064b.append(586, "Pakistan");
        f1064b.append(591, "Panama");
        f1064b.append(598, "Papua New Guinea");
        f1064b.append(600, "Paraguay");
        f1064b.append(604, "Peru");
        f1064b.append(608, "Philippines");
        f1064b.append(612, "Pitcairn");
        f1064b.append(616, "Poland");
        f1064b.append(620, "Portugal");
        f1064b.append(624, "Guinea-Bissau");
        f1064b.append(626, "Timor-Leste");
        f1064b.append(630, "Puerto Rico");
        f1064b.append(634, "Qatar");
        f1064b.append(638, "R\u00e9union");
        f1064b.append(642, "Romania");
        f1064b.append(643, "Russian Federation");
        f1064b.append(646, "Rwanda");
        f1064b.append(652, "Saint Barth\u00e9lemy");
        f1064b.append(654, "Saint Helena, Ascension and Tristan da Cunha");
        f1064b.append(659, "Saint Kitts and Nevis");
        f1064b.append(660, "Anguilla");
        f1064b.append(662, "Saint Lucia");
        f1064b.append(663, "Saint Martin (French part)");
        f1064b.append(666, "Saint Pierre and Miquelon");
        f1064b.append(670, "Saint Vincent and the Grenadines");
        f1064b.append(674, "San Marino");
        f1064b.append(678, "Sao Tome and Principe");
        f1064b.append(682, "Saudi Arabia");
        f1064b.append(686, "Senegal");
        f1064b.append(688, "Serbia");
        f1064b.append(690, "Seychelles");
        f1064b.append(694, "Sierra Leone");
        f1064b.append(702, "Singapore");
        f1064b.append(703, "Slovakia");
        f1064b.append(704, "Viet Nam");
        f1064b.append(705, "Slovenia");
        f1064b.append(706, "Somalia");
        f1064b.append(710, "South Africa");
        f1064b.append(716, "Zimbabwe");
        f1064b.append(724, "Spain");
        f1064b.append(732, "Western Sahara");
        f1064b.append(736, "Sudan");
        f1064b.append(740, "Suriname");
        f1064b.append(744, "Svalbard and Jan Mayen");
        f1064b.append(748, "Swaziland");
        f1064b.append(752, "Sweden");
        f1064b.append(756, "Switzerland");
        f1064b.append(760, "Syrian Arab Republic");
        f1064b.append(762, "Tajikistan");
        f1064b.append(764, "Thailand");
        f1064b.append(768, "Togo");
        f1064b.append(772, "Tokelau");
        f1064b.append(776, "Tonga");
        f1064b.append(780, "Trinidad and Tobago");
        f1064b.append(784, "United Arab Emirates");
        f1064b.append(788, "Tunisia");
        f1064b.append(792, "Turkey");
        f1064b.append(795, "Turkmenistan");
        f1064b.append(796, "Turks and Caicos Islands");
        f1064b.append(798, "Tuvalu");
        f1064b.append(800, "Uganda");
        f1064b.append(804, "Ukraine");
        f1064b.append(807, "Macedonia, the former Yugoslav Republic of");
        f1064b.append(818, "Egypt");
        f1064b.append(826, "United Kingdom");
        f1064b.append(831, "Guernsey");
        f1064b.append(832, "Jersey");
        f1064b.append(833, "Isle of Man");
        f1064b.append(834, "Tanzania, United Republic of");
        f1064b.append(840, "United States");
        f1064b.append(850, "Virgin Islands, U.S.");
        f1064b.append(854, "Burkina Faso");
        f1064b.append(858, "Uruguay");
        f1064b.append(860, "Uzbekistan");
        f1064b.append(862, "Venezuela, Bolivarian Republic of");
        f1064b.append(876, "Wallis and Futuna");
        f1064b.append(882, "Samoa");
        f1064b.append(887, "Yemen");
        f1064b.append(894, "Zambia");
        f1064b.append(80, "British Antarctic Territory");
        f1064b.append(AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS, "Canton and Enderbury Islands");
        f1064b.append(200, "Czechoslovakia");
        f1064b.append(216, "Dronning Maud Land");
        f1064b.append(230, "Ethiopia (before Eritrea split away in 1993)");
        f1064b.append(249, "France, Metropolitan");
        f1064b.append(278, "German Democratic Republic");
        f1064b.append(280, "Germany, Federal Republic of (West Germany)");
        f1064b.append(396, "Johnston Island");
        f1064b.append(488, "Midway Islands");
        f1064b.append(530, "Netherlands Antilles (after Aruba split away in 1986)");
        f1064b.append(532, "Netherlands Antilles (before Aruba split away in 1986)");
        f1064b.append(536, "Neutral Zone");
        f1064b.append(582, "Pacific Islands, Trust Territory of the");
        f1064b.append(590, "Panama (before adding Panama Canal Zone in 1979)");
        f1064b.append(594, "Panama Canal Zone");
        f1064b.append(658, "Saint Kitts-Nevis-Anguilla");
        f1064b.append(698, "Sikkim");
        f1064b.append(714, "Viet-Nam, Republic of");
        f1064b.append(720, "Yemen, Democratic");
        f1064b.append(810, "USSR");
        f1064b.append(849, "U.S. Miscellaneous Pacific Islands");
        f1064b.append(872, "Wake Island");
        f1064b.append(886, "Yemen Arab Republic");
        f1064b.append(890, "Yugoslavia, Socialist Federal Republic of");
        f1064b.append(891, "Serbia and Montenegro (Yugoslavia, Federal Republic of)");
    }

    public static byte m1033a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return (byte) 1;
        }
        switch (bArr[0] & MotionEventCompat.ACTION_MASK) {
            case C0519c.Switch_thumb /*0*/:
            case AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS /*128*/:
                ArrayList d = C0351d.m1043d(bArr);
                if (d == null) {
                    return (byte) 1;
                }
                byte[] bArr2 = null;
                Iterator it = d.iterator();
                while (it.hasNext()) {
                    bArr2 = (byte[]) it.next();
                    if (bArr2[0] == (byte) 49) {
                        return (bArr2 == null && bArr2[0] == (byte) 49) ? bArr2[1] : (byte) 1;
                    }
                }
                if (bArr2 == null) {
                    break;
                }
            default:
                return (byte) 1;
        }
    }

    public static String m1034a(byte[] bArr, byte[] bArr2) {
        return (bArr == null || bArr.length == 0) ? null : (bArr[0] != -63 || ((bArr2.length < 7 || bArr2[0] != (byte) 4) && !(bArr2.length == 4 && ("NXP Semiconductors".equals(C0355h.m1067b(bArr2, C0360m.ISO14443_A)) || bArr2[0] == 8)))) ? C0351d.m1045f(bArr) : C0351d.m1044e(bArr);
    }

    static void m1035a(C0428i c0428i, int i) {
        StringBuilder stringBuilder = new StringBuilder("DR: 1");
        c0428i.m1384a(C0358k.f1076c + "Supported receive rates:");
        c0428i.m1387b("\t\u2022 106");
        if ((i & 1) != 0) {
            c0428i.m1387b(", 212");
            stringBuilder.append(", 2");
        }
        if ((i & 2) != 0) {
            c0428i.m1387b(", 424");
            stringBuilder.append(", 4");
        }
        if ((i & 4) != 0) {
            c0428i.m1387b(", 848");
            stringBuilder.append(", 8");
        }
        c0428i.m1387b("\u200akbit/s (");
        c0428i.m1387b(stringBuilder.toString());
        c0428i.m1384a((CharSequence) ")");
        stringBuilder = new StringBuilder("DS: 1");
        c0428i.m1384a(C0358k.f1076c + "Supported send rates:");
        c0428i.m1387b("\t\u2022 106");
        if ((i & 16) != 0) {
            c0428i.m1387b(", 212");
            stringBuilder.append(", 2");
        }
        if ((i & 32) != 0) {
            c0428i.m1387b(", 424");
            stringBuilder.append(", 4");
        }
        if ((i & 64) != 0) {
            c0428i.m1387b(", 848");
            stringBuilder.append(", 8");
        }
        c0428i.m1387b("\u200akbit/s (");
        c0428i.m1387b(stringBuilder.toString());
        c0428i.m1384a((CharSequence) ")");
        if (i != 0 && i != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            String str = C0358k.f1076c + "Different send and receive rates %ssupported";
            Object[] objArr = new Object[1];
            objArr[0] = (i & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0 ? "not " : BuildConfig.VERSION_NAME;
            c0428i.m1384a(String.format(str, objArr));
        }
    }

    public static boolean m1036a(byte b) {
        return (b & 16) != 0;
    }

    public static byte[] m1037a(NfcA nfcA) {
        byte[] transceive;
        try {
            transceive = nfcA.transceive(new byte[]{(byte) -32, Byte.MIN_VALUE});
            try {
                nfcA.transceive(new byte[]{(byte) -62});
                nfcA.close();
                nfcA.connect();
            } catch (TagLostException e) {
                throw e;
            } catch (IOException e2) {
            }
        } catch (TagLostException e3) {
            throw e3;
        } catch (IOException e4) {
            transceive = null;
            try {
                new byte[1][0] = (byte) -62;
                nfcA.connect();
            } catch (TagLostException e32) {
                throw e32;
            } catch (IOException e5) {
            }
        } catch (Throwable th) {
            try {
                new byte[1][0] = (byte) -62;
                nfcA.connect();
            } catch (TagLostException e322) {
                throw e322;
            } catch (IOException e6) {
            }
        }
        return transceive;
    }

    public static C0352e m1038b(byte b) {
        switch (b & 14) {
            case C0519c.Switch_thumb /*0*/:
                return C0352e.ReadRecord;
            case C0519c.Switch_thumbTextPadding /*4*/:
                return C0352e.GetData;
            case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                return C0352e.ReadBinary;
            default:
                return C0352e.UNKNOWN;
        }
    }

    public static String m1039b(byte[] bArr) {
        int i = -1;
        C0428i c0428i = new C0428i();
        if (bArr == null || bArr.length < 2 || (bArr[1] & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0) {
            return BuildConfig.VERSION_NAME;
        }
        int i2;
        int i3;
        int i4;
        int i5 = bArr[1] & MotionEventCompat.ACTION_MASK;
        if ((bArr[1] & 16) == 0) {
            i2 = 2;
            i3 = -1;
        } else if (bArr.length <= 2) {
            return BuildConfig.VERSION_NAME;
        } else {
            i2 = 3;
            i3 = bArr[2] & MotionEventCompat.ACTION_MASK;
        }
        if ((bArr[1] & 32) == 0) {
            i4 = i2;
            i2 = -1;
        } else if (bArr.length <= i2) {
            return BuildConfig.VERSION_NAME;
        } else {
            i4 = i2 + 1;
            i2 = bArr[i2] & MotionEventCompat.ACTION_MASK;
        }
        if ((bArr[1] & 64) != 0) {
            if (bArr.length <= i4) {
                return BuildConfig.VERSION_NAME;
            }
            i = i4 + 1;
            i = bArr[i4] & MotionEventCompat.ACTION_MASK;
        }
        C0351d.m1040b(c0428i, i5 & 15);
        if ((bArr[1] & 16) != 0) {
            C0351d.m1035a(c0428i, i3);
        } else {
            c0428i.m1384a(C0358k.f1076c + "Supported receive rates:\n" + "\t\u2022 " + "106" + "\u200a" + "kbit/s");
            c0428i.m1384a(C0358k.f1076c + "Supported send rates:\n" + "\t\u2022 " + "106" + "\u200a" + "kbit/s");
        }
        if ((bArr[1] & 32) != 0) {
            i4 = i2 & 15;
            i2 = (i2 >> 4) & 15;
            c0428i.m1387b(C0358k.f1076c + "SFGT: ");
            c0428i.m1387b((CharSequence) f1063a.get(i4));
            c0428i.m1384a(String.format("  (SFGI: %d)", new Object[]{Integer.valueOf(i4)}));
            c0428i.m1387b(C0358k.f1076c + "FWT: ");
            c0428i.m1387b((CharSequence) f1063a.get(i2));
            c0428i.m1384a(String.format("  (FWI: %d)", new Object[]{Integer.valueOf(i2)}));
        } else {
            c0428i.m1387b(C0358k.f1076c + "SFGT: ");
            c0428i.m1384a((CharSequence) f1063a.get(0));
            c0428i.m1387b(C0358k.f1076c + "FWT: ");
            c0428i.m1384a((CharSequence) f1063a.get(4));
        }
        if ((bArr[1] & 64) != 0) {
            String str = C0358k.f1076c + "NAD %ssupported";
            Object[] objArr = new Object[1];
            objArr[0] = (i & 1) != 0 ? BuildConfig.VERSION_NAME : "not ";
            c0428i.m1384a(String.format(str, objArr));
            str = C0358k.f1076c + "CID %ssupported";
            objArr = new Object[1];
            objArr[0] = (i & 2) != 0 ? BuildConfig.VERSION_NAME : "not ";
            c0428i.m1384a(String.format(str, objArr));
        } else {
            c0428i.m1384a(C0358k.f1076c + "NAD not supported");
            c0428i.m1384a(C0358k.f1076c + "CID supported");
        }
        c0428i.m1387b(C0358k.f1076c + "Historical bytes: ");
        byte[] c = C0351d.m1042c(bArr);
        if (c != null) {
            c0428i.m1387b(C0429j.m1410f(c));
        } else {
            c0428i.m1387b("[none]");
        }
        return c0428i.toString();
    }

    static void m1040b(C0428i c0428i, int i) {
        c0428i.m1387b(C0358k.f1076c + "Max. accepted frame size: ");
        switch (i) {
            case C0519c.Switch_thumb /*0*/:
                c0428i.m1387b("16 bytes");
                break;
            case C0519c.Switch_track /*1*/:
                c0428i.m1387b("24 bytes");
                break;
            case C0519c.Switch_textOn /*2*/:
                c0428i.m1387b("32 bytes");
                break;
            case C0519c.Switch_textOff /*3*/:
                c0428i.m1387b("40 bytes");
                break;
            case C0519c.Switch_thumbTextPadding /*4*/:
                c0428i.m1387b("48 bytes");
                break;
            case C0519c.Switch_switchTextAppearance /*5*/:
                c0428i.m1387b("64 bytes");
                break;
            case C0519c.Switch_switchMinWidth /*6*/:
                c0428i.m1387b("96 bytes");
                break;
            case C0519c.Switch_switchPadding /*7*/:
                c0428i.m1387b("128 bytes");
                break;
            case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                c0428i.m1387b("256 bytes");
                break;
            default:
                c0428i.m1387b("256 bytes");
                break;
        }
        c0428i.m1384a(String.format(" (FSCI: %d)", new Object[]{Integer.valueOf(i)}));
    }

    public static boolean m1041c(byte b) {
        return (b & 1) == 0;
    }

    public static byte[] m1042c(byte[] bArr) {
        int i = 2;
        if (bArr == null || bArr.length < 2) {
            return null;
        }
        if ((bArr[1] & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0) {
            return null;
        }
        if ((bArr[1] & 16) != 0) {
            i = 3;
        }
        if ((bArr[1] & 32) != 0) {
            i++;
        }
        if ((bArr[1] & 64) != 0) {
            i++;
        }
        byte[] bArr2 = new byte[0];
        int i2 = bArr[0] & MotionEventCompat.ACTION_MASK;
        if (i2 <= bArr.length && i < i2) {
            bArr2 = new byte[(i2 - i)];
            System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
        }
        return bArr2;
    }

    private static ArrayList m1043d(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (i < bArr.length) {
            int i2 = (bArr[i] & 15) + 1;
            if (bArr[0] == null) {
                if (i == bArr.length - 3) {
                    i2 = 3;
                } else if (i > bArr.length - 3) {
                    return null;
                }
            }
            Object obj = new byte[i2];
            if (i + i2 > bArr.length) {
                break;
            }
            System.arraycopy(bArr, i, obj, 0, i2);
            arrayList.add(obj);
            i += i2;
        }
        return arrayList;
    }

    private static String m1044e(byte[] bArr) {
        C0428i c0428i = new C0428i();
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        if (length < 2) {
            return null;
        }
        Object obj = new byte[length];
        System.arraycopy(bArr, 0, obj, 0, length - 2);
        C0358k.m1073c(obj);
        if (bArr[length - 2] == obj[length - 2] && bArr[length - 1] == obj[length - 1] && bArr[1] == length - 2) {
            byte b = bArr[2];
            c0428i.m1387b("Chip type: ");
            switch ((b >>> 4) & 15) {
                case C0519c.Switch_thumb /*0*/:
                    c0428i.m1387b("(Multiple) Virtual Cards");
                    break;
                case C0519c.Switch_track /*1*/:
                    c0428i.m1387b("MIFARE DESFire");
                    break;
                case C0519c.Switch_textOn /*2*/:
                    c0428i.m1387b("MIFARE Plus");
                    break;
                default:
                    c0428i.m1387b("[unknown]");
                    break;
            }
            c0428i.m1384a(String.format("<hexoutput> (0x%X)</hexoutput>", new Object[]{Integer.valueOf((b >> 4) & 15)}));
            c0428i.m1387b("Memory size: ");
            switch (b & 15) {
                case C0519c.Switch_thumb /*0*/:
                    c0428i.m1387b("&lt;1\u200akB");
                    break;
                case C0519c.Switch_track /*1*/:
                    c0428i.m1387b("1\u200akB");
                    break;
                case C0519c.Switch_textOn /*2*/:
                    c0428i.m1387b("2\u200akB");
                    break;
                case C0519c.Switch_textOff /*3*/:
                    c0428i.m1387b("4\u200akB");
                    break;
                case C0519c.Switch_thumbTextPadding /*4*/:
                    c0428i.m1387b("8\u200akB");
                    break;
                case C0086R.styleable.SherlockTheme_actionModeSplitBackground /*15*/:
                    c0428i.m1387b("Unspecified");
                    break;
                default:
                    c0428i.m1387b("[unknown]");
                    break;
            }
            c0428i.m1384a(String.format("<hexoutput> (0x%X)</hexoutput>", new Object[]{Integer.valueOf(b & 15)}));
            b = bArr[3];
            c0428i.m1387b("Chip version: ");
            switch ((b >>> 4) & 15) {
                case C0519c.Switch_thumb /*0*/:
                    c0428i.m1387b("Engineering samples");
                    break;
                case C0519c.Switch_textOn /*2*/:
                    c0428i.m1387b("Released");
                    break;
                default:
                    c0428i.m1387b("[unknown]");
                    break;
            }
            c0428i.m1384a(String.format("<hexoutput> (0x%X)</hexoutput>", new Object[]{Integer.valueOf((b >> 4) & 15)}));
            c0428i.m1387b("Chip generation: ");
            switch (b & 15) {
                case C0519c.Switch_thumb /*0*/:
                    c0428i.m1387b("Generation 1");
                    break;
                case C0519c.Switch_track /*1*/:
                    c0428i.m1387b("Generation 2");
                    break;
                case C0519c.Switch_textOn /*2*/:
                    c0428i.m1387b("Generation 3");
                    break;
                case C0086R.styleable.SherlockTheme_actionModeSplitBackground /*15*/:
                    c0428i.m1387b("Unspecified");
                    break;
                default:
                    c0428i.m1387b("[unknown]");
                    break;
            }
            c0428i.m1384a(String.format("<hexoutput> (0x%X)</hexoutput>", new Object[]{Integer.valueOf(b & 15)}));
            b = bArr[4];
            c0428i.m1387b("Virtual Card Selection capability:");
            c0428i.m1384a(String.format("<hexoutput> (0x%X)</hexoutput>", new Object[]{Integer.valueOf(b & 15)}));
            switch (b & 15) {
                case C0519c.Switch_thumb /*0*/:
                    c0428i.m1384a(C0358k.f1076c + "Only VCSL supported\n" + C0358k.f1076c + "All Security Levels supported");
                    break;
                case C0519c.Switch_track /*1*/:
                    c0428i.m1384a(C0358k.f1076c + "VCS, VCSL and SVC supported\n" + C0358k.f1076c + "All Security Levels supported");
                    break;
                case C0519c.Switch_textOn /*2*/:
                    c0428i.m1384a(C0358k.f1076c + "Only VCSL supported\n" + C0358k.f1076c + "Security Level 3-only card");
                    break;
                case C0519c.Switch_textOff /*3*/:
                    c0428i.m1384a(C0358k.f1076c + "VCS, VCSL and SVC supported\n" + C0358k.f1076c + "Security Level 3-only card");
                    break;
                case C0086R.styleable.SherlockTheme_actionModeBackground /*14*/:
                    c0428i.m1384a(C0358k.f1076c + "No VCS command supported");
                    break;
                case C0086R.styleable.SherlockTheme_actionModeSplitBackground /*15*/:
                    c0428i.m1384a(C0358k.f1076c + "Unspecified");
                    break;
                default:
                    c0428i.m1384a(C0358k.f1076c + "[RFU]");
                    break;
            }
        }
        return "NXP IC information coding\n" + c0428i.toString();
    }

    private static String m1045f(byte[] bArr) {
        C0428i c0428i = new C0428i();
        String str = "ISO/IEC 7816-4 coding\n";
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        switch (bArr[0] & MotionEventCompat.ACTION_MASK) {
            case C0519c.Switch_thumb /*0*/:
            case AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS /*128*/:
                ArrayList d = C0351d.m1043d(bArr);
                if (!(d == null || d.isEmpty())) {
                    c0428i.m1384a((CharSequence) "ISO/IEC 7816-4 coding\n");
                    Iterator it = d.iterator();
                    while (it.hasNext()) {
                        byte[] bArr2 = (byte[]) it.next();
                        if (bArr2 != null && bArr2.length > 0) {
                            byte[] g = C0351d.m1046g(bArr2);
                            byte b = bArr2[0];
                            int i = (b >> 4) & 15;
                            int a;
                            switch (b & 240) {
                                case C0519c.Switch_thumb /*0*/:
                                    c0428i.m1384a(C0351d.m1050k(bArr2));
                                    break;
                                case Menu.CATEGORY_SHIFT /*16*/:
                                    c0428i.m1384a("Country code and national data: " + C0429j.m1410f(bArr2));
                                    if (bArr2.length <= 2) {
                                        c0428i.m1384a(C0358k.f1076c + "Country code incomplete");
                                        break;
                                    }
                                    a = C0429j.m1388a(bArr2[1], (byte) ((bArr2[2] >> 4) & 15));
                                    c0428i.m1384a(C0358k.f1076c + String.format("Country code: %03X", new Object[]{Integer.valueOf(a)}));
                                    CharSequence charSequence = (String) f1064b.get(a);
                                    if (charSequence != null) {
                                        c0428i.m1384a("\t\u2022 " + C0429j.m1391a(charSequence));
                                    }
                                    bArr2[2] = (byte) (bArr2[2] & 15);
                                    bArr2 = Arrays.copyOfRange(bArr2, 2, bArr2.length);
                                    bArr2[2] = (byte) (bArr2[2] & 15);
                                    c0428i.m1387b(C0358k.f1076c);
                                    c0428i.m1387b("National data: ");
                                    c0428i.m1384a(C0429j.m1409e(bArr2));
                                    break;
                                case C0086R.styleable.SherlockTheme_searchViewCloseIcon /*32*/:
                                    c0428i.m1387b("Issuer ID no. and data: ");
                                    c0428i.m1384a(C0429j.m1411g(g));
                                    break;
                                case C0086R.styleable.SherlockTheme_windowMinWidthMajor /*48*/:
                                    if (b != 49) {
                                        c0428i.m1387b(String.format("Unknown data (tag 0x%X): ", new Object[]{Integer.valueOf(i)}));
                                        c0428i.m1384a(C0429j.m1411g(g));
                                        break;
                                    }
                                    c0428i.m1384a(C0351d.m1047h(bArr2));
                                    break;
                                case C0086R.styleable.SherlockTheme_activityChooserViewStyle /*64*/:
                                    c0428i.m1384a(C0351d.m1048i(bArr2));
                                    break;
                                case 80:
                                    c0428i.m1387b("Card issuer's data: ");
                                    c0428i.m1384a(C0429j.m1411g(g));
                                    break;
                                case 96:
                                    c0428i.m1387b("Pre-issuing data: ");
                                    c0428i.m1384a(C0429j.m1411g(g));
                                    break;
                                case 112:
                                    if ((b & 15) >= 4) {
                                        c0428i.m1387b(String.format("Unknown data (tag 0x%X): ", new Object[]{Integer.valueOf(i)}));
                                        c0428i.m1384a(C0429j.m1411g(g));
                                        break;
                                    }
                                    c0428i.m1384a(C0351d.m1049j(bArr2));
                                    break;
                                case AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS /*128*/:
                                    if ((b & 15) >= 4) {
                                        c0428i.m1387b(String.format("Unknown data (tag 0x%X): ", new Object[]{Integer.valueOf(i)}));
                                        c0428i.m1384a(C0429j.m1411g(g));
                                        break;
                                    }
                                    Object obj = new byte[(bArr2.length - 1)];
                                    System.arraycopy(bArr2, 1, obj, 0, obj.length);
                                    c0428i.m1387b(C0351d.m1050k(obj));
                                    break;
                                case 144:
                                    c0428i.m1384a(String.format("Electronic identity document (MRTD): (0x%02X)", new Object[]{Byte.valueOf(b)}));
                                    int i2 = b & 15;
                                    if (i2 <= 0) {
                                        break;
                                    }
                                    for (a = 1; a <= i2; a++) {
                                        if ((bArr2[a] & MotionEventCompat.ACTION_MASK) == 225) {
                                            c0428i.m1384a(C0358k.f1076c + "ePassport");
                                        } else if ((bArr2[a] & MotionEventCompat.ACTION_MASK) == 226) {
                                            c0428i.m1384a(C0358k.f1076c + "eVisa");
                                        }
                                    }
                                    break;
                                case 240:
                                    c0428i.m1384a(String.format("Application identifier: (0x%02X)", new Object[]{Byte.valueOf(b)}));
                                    c0428i.m1387b(C0358k.f1076c);
                                    c0428i.m1387b("Implicitly selected Application ID: ");
                                    c0428i.m1384a(C0429j.m1409e(g));
                                    break;
                                default:
                                    c0428i.m1387b(String.format("Unknown data (tag 0x%X): ", new Object[]{Integer.valueOf(i)}));
                                    c0428i.m1384a(C0429j.m1411g(g));
                                    break;
                            }
                        }
                    }
                }
                return c0428i.toString();
            case Menu.CATEGORY_SHIFT /*16*/:
                return "ISO/IEC 7816-4 coding\nDIR data<hexoutput> (0x10)</hexoutput>";
            case 129:
            case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
                return "ISO/IEC 7816-4 coding\n" + String.format("Category: [RFU]<hexoutput> (0x%02X)</hexoutput>", new Object[]{Byte.valueOf(bArr[0])});
            default:
                return null;
        }
    }

    private static byte[] m1046g(byte[] bArr) {
        return (bArr == null || bArr.length <= 1) ? null : Arrays.copyOfRange(bArr, 1, bArr.length);
    }

    private static String m1047h(byte[] bArr) {
        C0428i c0428i = new C0428i();
        c0428i.m1384a(String.format("Card service data: (0x%02X%02X)", new Object[]{Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1])}));
        int i = bArr[1] & 192;
        c0428i.m1384a(String.format(C0358k.f1076c + "Application selection methods: (0x%02X)", new Object[]{Integer.valueOf(i)}));
        if ((i & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0) {
            c0428i.m1384a((CharSequence) "\t\u2022 By full DF name");
        }
        if ((i & 64) != 0) {
            c0428i.m1384a((CharSequence) "\t\u2022 By partial DF name");
        }
        if ((i & 192) == 0) {
            c0428i.m1384a((CharSequence) "\t\u2022 Implicit application selection");
        }
        i = bArr[1] & 48;
        c0428i.m1384a(String.format(C0358k.f1076c + "BER-TLV data objects available: (0x%02X)", new Object[]{Integer.valueOf(i)}));
        if ((i & 32) != 0) {
            c0428i.m1384a((CharSequence) "\t\u2022 In EF.DIR");
        }
        if ((i & 16) != 0) {
            c0428i.m1384a((CharSequence) "\t\u2022 In EF.ATR");
        }
        if ((i & MotionEventCompat.ACTION_MASK) == 0) {
            c0428i.m1384a((CharSequence) "\t\u2022 None");
        }
        if ((i & MotionEventCompat.ACTION_MASK) != 0) {
            i = bArr[1] & 14;
            c0428i.m1384a(String.format(C0358k.f1076c + "EF.DIR and EF.ATR access services: (0x%02X)", new Object[]{Integer.valueOf(i)}));
            switch (i) {
                case C0519c.Switch_thumb /*0*/:
                    c0428i.m1384a((CharSequence) "\t\u2022 By the READ RECORD(S) command (record structure)");
                    break;
                case C0519c.Switch_thumbTextPadding /*4*/:
                    c0428i.m1384a((CharSequence) "\t\u2022 By the GET DATA command (TLV structure)");
                    break;
                case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                    c0428i.m1384a((CharSequence) "\t\u2022 By the READ BINARY command (transparent structure)");
                    break;
                default:
                    c0428i.m1384a((CharSequence) "\t\u2022 [RFU]");
                    break;
            }
        }
        if ((bArr[1] & 1) == 0) {
            c0428i.m1384a(C0358k.f1076c + "Card with Master File");
        } else {
            c0428i.m1384a(C0358k.f1076c + "Card without Master File");
        }
        return c0428i.toString();
    }

    private static String m1048i(byte[] bArr) {
        C0428i c0428i = new C0428i();
        c0428i.m1387b("Initial access data: ");
        c0428i.m1384a(C0429j.m1409e(bArr));
        if (bArr.length == 2) {
            c0428i.m1384a(String.format(C0358k.f1076c + "READ BINARY: 0x00B00000%02X", new Object[]{Byte.valueOf(bArr[1])}));
        } else if (bArr.length == 3) {
            if ((bArr[1] & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0) {
                c0428i.m1384a(String.format(C0358k.f1076c + "READ BINARY: 0x00B0%02X00%02X", new Object[]{Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2])}));
            } else {
                int i = ((bArr[1] & 31) << 3) + 6;
                c0428i.m1384a(String.format(C0358k.f1076c + "READ RECORD: 0x00B201%02X%02X", new Object[]{Integer.valueOf(i), Byte.valueOf(bArr[2])}));
            }
        } else if (bArr.length >= 6) {
            Object obj = new byte[(bArr.length - 1)];
            System.arraycopy(bArr, 1, obj, 0, obj.length);
            c0428i.m1387b(C0358k.f1076c + "APDU: ");
            c0428i.m1384a(C0429j.m1409e(obj));
        } else {
            c0428i.m1384a(C0358k.f1076c + "[Invalid]");
        }
        return c0428i.toString();
    }

    private static String m1049j(byte[] bArr) {
        C0428i c0428i = new C0428i();
        c0428i.m1387b("Card capabilities: ");
        c0428i.m1384a(C0429j.m1409e(bArr));
        c0428i.m1384a(String.format(C0358k.f1076c + "DF selection methods: (0x%02X)\n", new Object[]{Byte.valueOf(bArr[1])}));
        if ((bArr[1] & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0) {
            c0428i.m1384a((CharSequence) "\t\u2022 By full DF name");
        }
        if ((bArr[1] & 64) != 0) {
            c0428i.m1384a((CharSequence) "\t\u2022 By partial DF name");
        }
        if ((bArr[1] & 32) != 0) {
            c0428i.m1384a((CharSequence) "\t\u2022 By path");
        }
        if ((bArr[1] & 16) != 0) {
            c0428i.m1384a((CharSequence) "\t\u2022 By file identifier");
        }
        if ((bArr[1] & 8) != 0) {
            c0428i.m1384a((CharSequence) "\t\u2022 Implicit DF selection");
        }
        if ((bArr[1] & 4) != 0) {
            c0428i.m1384a(C0358k.f1076c + "Short EF identifier supported");
        }
        if ((bArr[1] & 2) != 0) {
            c0428i.m1384a(C0358k.f1076c + "Record number supported");
        }
        if ((bArr[1] & 1) != 0) {
            c0428i.m1384a(C0358k.f1076c + "Record identifier supported");
        }
        if (bArr[0] >= 114) {
            if ((bArr[2] & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0) {
                c0428i.m1384a(C0358k.f1076c + "EFs of TLV structure supported");
            }
            c0428i.m1387b(C0358k.f1076c + "Behaviour of write function: ");
            switch ((bArr[2] >>> 5) & 3) {
                case C0519c.Switch_thumb /*0*/:
                    c0428i.m1384a((CharSequence) "one-time write");
                    break;
                case C0519c.Switch_track /*1*/:
                    c0428i.m1384a((CharSequence) "proprietary");
                    break;
                case C0519c.Switch_textOn /*2*/:
                    c0428i.m1384a((CharSequence) "write OR");
                    break;
                case C0519c.Switch_textOff /*3*/:
                    c0428i.m1384a((CharSequence) "write AND");
                    break;
            }
            c0428i.m1384a(C0358k.f1076c + "Value 0xFF for the first byte of BER-TLV tag fields:");
            if ((bArr[2] & 16) != 0) {
                c0428i.m1384a((CharSequence) "\t\u2022 Valid (long private tags, constructed encoding)");
            } else {
                c0428i.m1384a((CharSequence) "\t\u2022 Invalid (used for padding, default value)");
            }
            c0428i.m1384a(String.format(C0358k.f1076c + "Data unit size: %d quartets", new Object[]{Integer.valueOf(1 << (bArr[2] & 15))}));
        }
        if (bArr[0] == 115) {
            if ((bArr[3] & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0) {
                c0428i.m1384a(C0358k.f1076c + "Command chaining supported");
            }
            if ((bArr[3] & 64) != 0) {
                c0428i.m1384a(C0358k.f1076c + "Extended Lc and Le fields supported");
            }
            c0428i.m1384a(C0358k.f1076c + "Logical channel no. assignment:");
            switch ((bArr[3] >> 3) & 3) {
                case C0519c.Switch_thumb /*0*/:
                    c0428i.m1384a((CharSequence) "\t\u2022 No logical channels");
                    break;
                case C0519c.Switch_track /*1*/:
                    c0428i.m1384a((CharSequence) "\t\u2022 By the reader");
                    break;
                case C0519c.Switch_textOn /*2*/:
                    c0428i.m1384a((CharSequence) "\t\u2022 By the card");
                    break;
                case C0519c.Switch_textOff /*3*/:
                    c0428i.m1384a((CharSequence) "\t\u2022 [Invalid]");
                    break;
            }
            if (((bArr[3] >> 3) & 3) != 0) {
                c0428i.m1387b(C0358k.f1076c + "Max. no. of logical channels: ");
                if ((bArr[3] & 7) == 7) {
                    c0428i.m1384a((CharSequence) "8 or more");
                } else {
                    c0428i.m1384a(String.format("%d", new Object[]{Integer.valueOf((bArr[3] & 7) + 1)}));
                }
            }
        }
        return c0428i.toString();
    }

    private static String m1050k(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        if (bArr.length == 1 || bArr.length == 3) {
            stringBuilder.append("Life Cycle Status (LCS):\n");
            switch (bArr[0]) {
                case C0519c.Switch_thumb /*0*/:
                    stringBuilder.append(C0358k.f1076c).append("No information given");
                    break;
                case C0519c.Switch_track /*1*/:
                    stringBuilder.append(C0358k.f1076c).append("Creation state");
                    break;
                case C0519c.Switch_textOff /*3*/:
                    stringBuilder.append(C0358k.f1076c).append("Initialization state");
                    break;
                case C0519c.Switch_thumbTextPadding /*4*/:
                case C0519c.Switch_switchMinWidth /*6*/:
                    stringBuilder.append(C0358k.f1076c).append("Operational state (deactivated)");
                    break;
                case C0519c.Switch_switchTextAppearance /*5*/:
                case C0519c.Switch_switchPadding /*7*/:
                    stringBuilder.append(C0358k.f1076c).append("Operational state (activated)");
                    break;
                case C0086R.styleable.SherlockTheme_actionModeStyle /*12*/:
                case C0086R.styleable.SherlockTheme_actionModeCloseButtonStyle /*13*/:
                case C0086R.styleable.SherlockTheme_actionModeBackground /*14*/:
                case C0086R.styleable.SherlockTheme_actionModeSplitBackground /*15*/:
                    stringBuilder.append(C0358k.f1076c).append("Termination state");
                    break;
                default:
                    stringBuilder.append(C0358k.f1076c).append("Proprietary");
                    break;
            }
            stringBuilder.append(String.format(" (0x%02X)\n", new Object[]{Byte.valueOf(bArr[0])}));
        } else if (bArr.length == 2) {
            stringBuilder.append(String.format("SW1-SW2: 0x%02X%02X", new Object[]{Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1])}));
        }
        if (bArr.length == 3) {
            stringBuilder.append(String.format("SW1-SW2: 0x%02X%02X", new Object[]{Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2])}));
        }
        return stringBuilder.toString();
    }
}
