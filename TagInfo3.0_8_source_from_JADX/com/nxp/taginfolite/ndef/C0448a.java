package com.nxp.taginfolite.ndef;

import android.content.Context;
import android.nfc.NdefRecord;
import android.support.v4.BuildConfig;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.actionbarsherlock.C0086R;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.nxp.taginfolite.ndef.p023a.C0430a;
import com.nxp.taginfolite.ndef.p023a.C0431b;
import com.nxp.taginfolite.ndef.p023a.C0434d;
import com.nxp.taginfolite.ndef.p023a.C0437g;
import com.nxp.taginfolite.ndef.p023a.C0440k;
import com.nxp.taginfolite.ndef.p023a.C0441l;
import com.nxp.taginfolite.ndef.p023a.C0442m;
import com.nxp.taginfolite.ndef.p023a.C0443n;
import com.nxp.taginfolite.ndef.p023a.C0445p;
import com.nxp.taginfolite.ndef.p023a.C0446q;
import com.nxp.taginfolite.ndef.p023a.C0447r;
import com.nxp.taginfolite.p003g.C0429j;
import com.nxp.taginfolite.p005b.C0182c;
import com.nxp.taginfolite.p005b.C0188i;
import com.nxp.taginfolite.p005b.C0193o;
import java.util.HashMap;
import java.util.UUID;
import org.jraf.android.backport.switchwidget.C0519c;

/* renamed from: com.nxp.taginfolite.ndef.a */
public final class C0448a {
    static HashMap f1373a;
    private static final SparseArray f1374b;

    static {
        f1373a = new C0449b();
        f1374b = new C0450c();
    }

    public static C0182c m1448a(Context context, NdefRecord ndefRecord) {
        return C0448a.m1449a(context, ndefRecord, BuildConfig.VERSION_NAME);
    }

    public static C0182c m1449a(Context context, NdefRecord ndefRecord, String str) {
        long j = 0;
        byte[] payload = ndefRecord.getPayload();
        C0453f b = C0448a.m1456b(ndefRecord);
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        C0182c c0182c = null;
        C0448a.m1452a(ndefRecord, str, stringBuilder);
        try {
            switch (C0451d.f1375a[b.ordinal()]) {
                case C0519c.Switch_track /*1*/:
                    C0448a.m1457b(payload, str, stringBuilder);
                    break;
                case C0519c.Switch_textOn /*2*/:
                    C0448a.m1455a(payload, str, stringBuilder);
                    break;
                case C0519c.Switch_textOff /*3*/:
                    new C0443n().m1424a(context, payload, str, stringBuilder);
                    break;
                case C0519c.Switch_thumbTextPadding /*4*/:
                case C0519c.Switch_switchTextAppearance /*5*/:
                    stringBuilder.append(str);
                    stringBuilder.append("\"");
                    stringBuilder.append(C0429j.m1391a(new String(payload, C0429j.f1360a)));
                    stringBuilder.append("\"");
                    break;
                case C0519c.Switch_switchMinWidth /*6*/:
                case C0519c.Switch_switchPadding /*7*/:
                case MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW /*8*/:
                    new C0445p().m1443a(payload, str, stringBuilder, b);
                    break;
                case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                    CharSequence str2 = new String(payload, C0429j.f1360a);
                    stringBuilder.append(str);
                    stringBuilder.append("<aar>");
                    stringBuilder.append(C0429j.m1391a(str2));
                    stringBuilder.append("</aar>");
                    break;
                case C0086R.styleable.SherlockTheme_actionMenuTextAppearance /*10*/:
                    new C0440k().m1435a(context, payload, str, stringBuilder);
                    break;
                case C0086R.styleable.SherlockTheme_actionMenuTextColor /*11*/:
                    new C0430a().m1414a(payload, str, stringBuilder);
                    break;
                case C0086R.styleable.SherlockTheme_actionModeStyle /*12*/:
                    long j2 = 0;
                    for (int i = 0; i < 8; i++) {
                        j2 = (j2 << 8) | ((long) (payload[i] & MotionEventCompat.ACTION_MASK));
                        j = (j << 8) | ((long) (payload[i + 8] & MotionEventCompat.ACTION_MASK));
                    }
                    UUID uuid = new UUID(j2, j);
                    stringBuilder.append(str);
                    stringBuilder.append("UUID: ");
                    stringBuilder.append(uuid.toString());
                    break;
                case C0086R.styleable.SherlockTheme_actionModeCloseButtonStyle /*13*/:
                    new C0434d().m1426a(context, payload, str, stringBuilder);
                    break;
                case C0086R.styleable.SherlockTheme_actionModeBackground /*14*/:
                    new C0437g().m1432c(context, payload, str, stringBuilder);
                    break;
                case C0086R.styleable.SherlockTheme_actionModeSplitBackground /*15*/:
                    new C0437g().m1430b(context, payload, str, stringBuilder);
                    break;
                case Menu.CATEGORY_SHIFT /*16*/:
                    new C0437g().m1429a(payload, str, stringBuilder);
                    break;
                case C0086R.styleable.SherlockTheme_actionModeShareDrawable /*17*/:
                    C0441l.m1437b(payload, str, stringBuilder);
                    break;
                case C0086R.styleable.SherlockTheme_actionModePopupWindowStyle /*18*/:
                    C0441l.m1439d(payload, str, stringBuilder);
                    break;
                case C0086R.styleable.SherlockTheme_buttonStyleSmall /*19*/:
                    C0441l.m1438c(payload, str, stringBuilder);
                    break;
                case C0086R.styleable.SherlockTheme_selectableItemBackground /*20*/:
                    C0441l.m1436a(payload, str, stringBuilder);
                    break;
                case C0086R.styleable.SherlockTheme_windowContentOverlay /*21*/:
                    C0431b.m1418a(payload, str, stringBuilder);
                    break;
                case C0086R.styleable.SherlockTheme_textAppearanceLargePopupMenu /*22*/:
                case C0086R.styleable.SherlockTheme_textAppearanceSmallPopupMenu /*23*/:
                case C0086R.styleable.SherlockTheme_textAppearanceSmall /*24*/:
                    C0446q.m1445a(payload, str, stringBuilder);
                    break;
                case C0086R.styleable.SherlockTheme_textColorPrimary /*25*/:
                    C0447r.m1447a(payload, str, stringBuilder);
                    break;
                case C0086R.styleable.SherlockTheme_textColorPrimaryDisableOnly /*26*/:
                case C0086R.styleable.SherlockTheme_textColorPrimaryInverse /*27*/:
                case C0086R.styleable.SherlockTheme_spinnerItemStyle /*28*/:
                    new C0442m().m1440a(payload, str, stringBuilder);
                    break;
                case C0086R.styleable.SherlockTheme_spinnerDropDownItemStyle /*29*/:
                    stringBuilder.append(str);
                    stringBuilder.append("<url>");
                    stringBuilder.append(C0429j.m1391a(new String(payload, C0429j.f1360a)));
                    stringBuilder.append("</url>");
                    break;
                default:
                    String str3 = new String(ndefRecord.getType(), C0429j.f1360a);
                    if (ndefRecord.getTnf() == (short) 2 && str3.startsWith("text/")) {
                        stringBuilder.append(str);
                        stringBuilder.append("Text:\n");
                        stringBuilder.append(str);
                        stringBuilder.append("\"");
                        stringBuilder.append(C0429j.m1391a(new String(payload, C0429j.f1360a)));
                        stringBuilder.append("\"");
                        break;
                    }
            }
            if (!TextUtils.isEmpty(stringBuilder.toString())) {
                c0182c = C0448a.m1450a(payload, str);
            }
        } catch (IllegalArgumentException e) {
            C0448a.m1454a("\nError parsing embedded NDEF record\n", payload, str, stringBuilder);
            Log.v("TagInfo_NdefPrint", e.toString());
        } catch (ArrayIndexOutOfBoundsException e2) {
            C0448a.m1454a("\nError parsing NDEF record\n", payload, str, stringBuilder);
            Log.v("TagInfo_NdefPrint", e2.toString());
        } catch (StringIndexOutOfBoundsException e3) {
            C0448a.m1454a("\nError parsing NDEF record\n", payload, str, stringBuilder);
            Log.v("TagInfo_NdefPrint", e3.toString());
        }
        C0182c a = new C0182c().m147a(new C0193o(stringBuilder.toString()));
        if (c0182c != null) {
            a.m148a(c0182c);
        }
        return a;
    }

    public static C0182c m1450a(byte[] bArr, String str) {
        C0182c c0182c = new C0182c();
        int length = bArr.length;
        c0182c.m147a(new C0193o(C0429j.m1391a(str + "Payload length: " + String.format("%d bytes", new Object[]{Integer.valueOf(length)}))));
        if (length > 0) {
            c0182c.m147a(new C0193o(C0429j.m1391a(str + "Payload data:\n")));
            c0182c.m148a(C0188i.m162a(bArr));
        }
        return c0182c;
    }

    public static String m1451a(NdefRecord ndefRecord) {
        C0453f b = C0448a.m1456b(ndefRecord);
        if (b != C0453f.NONE) {
            String c0453f = b.toString();
            if (c0453f != null) {
                return c0453f;
            }
        }
        Object c = C0448a.m1458c(ndefRecord);
        return TextUtils.isEmpty(c) ? C0453f.NONE.toString() : c;
    }

    public static void m1452a(NdefRecord ndefRecord, String str, StringBuilder stringBuilder) {
        byte[] id = ndefRecord.getId();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("<mono>");
        if (id != null && id.length > 0) {
            stringBuilder2.append(str);
            stringBuilder2.append("ID: \"");
            stringBuilder2.append(new String(id, C0429j.f1360a));
            stringBuilder2.append("\"\n");
        }
        String str2 = new String(ndefRecord.getType(), C0429j.f1360a);
        if (TextUtils.isEmpty(str2)) {
            stringBuilder2.append(str);
            stringBuilder2.append("type: [NULL]");
        } else {
            stringBuilder2.append(str);
            stringBuilder2.append("type: \"");
            if (ndefRecord.getTnf() == (short) 3) {
                stringBuilder2.append("<url>");
                stringBuilder2.append(str2);
                stringBuilder2.append("</url>");
            } else {
                stringBuilder2.append(str2);
            }
            stringBuilder2.append("\"");
        }
        stringBuilder2.append("\n");
        stringBuilder2.append("</mono>");
        stringBuilder.append(stringBuilder2);
    }

    public static void m1453a(String str, String str2, StringBuilder stringBuilder) {
        String str3 = str2 + "\u25a0 " + str + " record";
        stringBuilder.append("<b><size size=\"14\">");
        stringBuilder.append(str3);
        stringBuilder.append("</size>");
        stringBuilder.append("</b>");
        stringBuilder.append("\n");
    }

    public static void m1454a(String str, byte[] bArr, String str2, StringBuilder stringBuilder) {
        stringBuilder.append("<b>");
        stringBuilder.append(str);
        stringBuilder.append("</b>");
        C0448a.m1459c(bArr, str2, stringBuilder);
    }

    public static void m1455a(byte[] bArr, String str, StringBuilder stringBuilder) {
        int length = bArr.length;
        int i = bArr[0] & TransportMediator.KEYCODE_MEDIA_PAUSE;
        int i2 = (bArr[0] & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) == 0 ? 1 : 0;
        stringBuilder.append(str);
        String str2 = "encoding: %s\n";
        Object[] objArr = new Object[1];
        objArr[0] = i2 != 0 ? "UTF-8" : "UTF-16";
        stringBuilder.append(String.format(str2, objArr));
        if (i < length) {
            stringBuilder.append(str);
            stringBuilder.append("lang: \"");
            stringBuilder.append(new String(bArr, 1, i, C0429j.f1360a));
            stringBuilder.append("\"\n");
            stringBuilder.append(str);
            stringBuilder.append("text: \"");
            stringBuilder.append(C0429j.m1391a(new String(bArr, i + 1, (length - i) - 1, i2 != 0 ? C0429j.f1361b : C0429j.f1362c)));
            stringBuilder.append("\"");
            return;
        }
        C0448a.m1454a("\nError parsing NDEF Text record\n", bArr, str, stringBuilder);
    }

    public static C0453f m1456b(NdefRecord ndefRecord) {
        C0453f a = C0453f.m1461a(ndefRecord);
        return a == null ? C0453f.NONE : a;
    }

    public static void m1457b(byte[] bArr, String str, StringBuilder stringBuilder) {
        String str2 = (String) f1374b.get(bArr[0] & MotionEventCompat.ACTION_MASK);
        CharSequence str3 = new String(bArr, 1, bArr.length - 1, C0429j.f1361b);
        String a = C0429j.m1391a(str2 + str3);
        String a2 = C0429j.m1391a(str3);
        stringBuilder.append(str);
        stringBuilder.append("protocol field: ");
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append("<url link=\"");
            stringBuilder.append(a);
            stringBuilder.append("\">");
            stringBuilder.append(str2);
            stringBuilder.append("</url>");
        } else if (str2 == null) {
            stringBuilder.append("[unknown]");
        } else {
            stringBuilder.append("[none]");
        }
        stringBuilder.append(String.format("<hexoutput> (0x%02X)</hexoutput>\n", new Object[]{Integer.valueOf(bArr[0] & MotionEventCompat.ACTION_MASK)}));
        stringBuilder.append(str);
        stringBuilder.append("URI field: <url link=\"");
        stringBuilder.append(a);
        stringBuilder.append("\">");
        stringBuilder.append(a2);
        stringBuilder.append("</url>");
    }

    public static String m1458c(NdefRecord ndefRecord) {
        switch (ndefRecord.getTnf() & 7) {
            case C0519c.Switch_thumb /*0*/:
                return "Empty";
            case C0519c.Switch_track /*1*/:
                return "NFC Forum well-known type";
            case C0519c.Switch_textOn /*2*/:
                return "MIME type (RFC 2046)";
            case C0519c.Switch_textOff /*3*/:
                return "Absolute URI type (RFC 3986)";
            case C0519c.Switch_thumbTextPadding /*4*/:
                return "NFC Forum external type";
            case C0519c.Switch_switchTextAppearance /*5*/:
                return "Unknown";
            case C0519c.Switch_switchMinWidth /*6*/:
                return "Unchanged";
            default:
                return "[Error]";
        }
    }

    public static void m1459c(byte[] bArr, String str, StringBuilder stringBuilder) {
        int length = bArr.length;
        stringBuilder.append("<hexoutput>\n");
        stringBuilder.append(str);
        stringBuilder.append(String.format("Payload length: %d bytes", new Object[]{Integer.valueOf(length)}));
        if (length > 0) {
            stringBuilder.append("\n");
            stringBuilder.append(str);
            stringBuilder.append("Payload data:\n");
            CharSequence stringBuilder2 = new StringBuilder();
            stringBuilder2.append("<mono>");
            for (int i = 0; i < length; i += 8) {
                if (i != 0) {
                    stringBuilder2.append("\n");
                }
                stringBuilder2.append(String.format("[%04X] ", new Object[]{Integer.valueOf(i)}));
                stringBuilder2.append(C0429j.m1391a(C0429j.m1407d(bArr, i, 8)));
            }
            stringBuilder2.append("</mono>");
            stringBuilder.append(stringBuilder2);
        }
        stringBuilder.append("</hexoutput>");
    }

    public static String m1460d(NdefRecord ndefRecord) {
        int i = 1;
        byte[] toByteArray = ndefRecord.toByteArray();
        if (toByteArray == null) {
            return BuildConfig.VERSION_NAME;
        }
        byte b = toByteArray[0];
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        stringBuilder.append("<size size=\"12\">");
        stringBuilder.append("Type Name Format: ");
        stringBuilder.append(C0448a.m1458c(ndefRecord));
        stringBuilder.append("<hexoutput>");
        stringBuilder.append(String.format(" (%d)", new Object[]{Integer.valueOf(ndefRecord.getTnf() & 7)}));
        stringBuilder.append("</hexoutput>");
        stringBuilder.append("\n");
        if (((b >>> 3) & MotionEventCompat.ACTION_MASK) != 0) {
            if ((b & 16) != 0) {
                stringBuilder.append(BuildConfig.VERSION_NAME);
                stringBuilder.append("Short Record");
            } else {
                i = 0;
            }
            if ((b & 8) != 0) {
                stringBuilder.append(i != 0 ? ", " : BuildConfig.VERSION_NAME);
                stringBuilder.append("ID Length present");
            }
            if ((b & 32) != 0) {
                stringBuilder.append(i != 0 ? ", " : BuildConfig.VERSION_NAME);
                stringBuilder.append("Chunked");
            }
        }
        stringBuilder.append("</size>");
        return stringBuilder.toString();
    }
}
