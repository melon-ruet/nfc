package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.actionbarsherlock.C0086R;
import org.jraf.android.backport.switchwidget.C0519c;

class ConnectivityManagerCompatHoneycombMR2 {
    ConnectivityManagerCompatHoneycombMR2() {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return true;
        }
        switch (activeNetworkInfo.getType()) {
            case C0519c.Switch_thumb /*0*/:
            case C0519c.Switch_textOn /*2*/:
            case C0519c.Switch_textOff /*3*/:
            case C0519c.Switch_thumbTextPadding /*4*/:
            case C0519c.Switch_switchTextAppearance /*5*/:
            case C0519c.Switch_switchMinWidth /*6*/:
                return true;
            case C0519c.Switch_track /*1*/:
            case C0519c.Switch_switchPadding /*7*/:
            case C0086R.styleable.SherlockTheme_actionBarItemBackground /*9*/:
                return false;
            default:
                return true;
        }
    }
}
