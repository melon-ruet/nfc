package android.support.v4.text;

import android.support.v4.BuildConfig;
import com.actionbarsherlock.C0086R;
import java.util.Locale;
import org.jraf.android.backport.switchwidget.C0519c;

public class TextUtilsCompat {
    private static String ARAB_SCRIPT_SUBTAG;
    private static String HEBR_SCRIPT_SUBTAG;
    public static final Locale ROOT;

    static {
        ROOT = new Locale(BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME);
        ARAB_SCRIPT_SUBTAG = "Arab";
        HEBR_SCRIPT_SUBTAG = "Hebr";
    }

    private static int getLayoutDirectionFromFirstChar(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case C0519c.Switch_track /*1*/:
            case C0519c.Switch_textOn /*2*/:
                return 1;
            default:
                return 0;
        }
    }

    public static int getLayoutDirectionFromLocale(Locale locale) {
        if (!(locale == null || locale.equals(ROOT))) {
            String script = ICUCompat.getScript(ICUCompat.addLikelySubtags(locale.toString()));
            if (script == null) {
                return getLayoutDirectionFromFirstChar(locale);
            }
            if (script.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG) || script.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG)) {
                return 1;
            }
        }
        return 0;
    }

    public static String htmlEncode(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case C0086R.styleable.SherlockTheme_searchViewSearchIcon /*34*/:
                    stringBuilder.append("&quot;");
                    break;
                case C0086R.styleable.SherlockTheme_searchViewTextField /*38*/:
                    stringBuilder.append("&amp;");
                    break;
                case C0086R.styleable.SherlockTheme_searchViewTextFieldRight /*39*/:
                    stringBuilder.append("&#39;");
                    break;
                case C0086R.styleable.SherlockTheme_windowActionBarOverlay /*60*/:
                    stringBuilder.append("&lt;");
                    break;
                case C0086R.styleable.SherlockTheme_windowSplitActionBar /*62*/:
                    stringBuilder.append("&gt;");
                    break;
                default:
                    stringBuilder.append(charAt);
                    break;
            }
        }
        return stringBuilder.toString();
    }
}
