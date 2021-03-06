package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;
import java.util.Collections;
import java.util.List;

public class AccessibilityManagerCompat {
    private static final AccessibilityManagerVersionImpl IMPL;

    interface AccessibilityManagerVersionImpl {
        boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat);

        List getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i);

        List getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager);

        boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager);

        Object newAccessiblityStateChangeListener(AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat);

        boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat);
    }

    class AccessibilityManagerStubImpl implements AccessibilityManagerVersionImpl {
        AccessibilityManagerStubImpl() {
        }

        public boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return false;
        }

        public List getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
            return Collections.emptyList();
        }

        public List getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
            return Collections.emptyList();
        }

        public boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
            return false;
        }

        public Object newAccessiblityStateChangeListener(AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return null;
        }

        public boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return false;
        }
    }

    class AccessibilityManagerIcsImpl extends AccessibilityManagerStubImpl {

        /* renamed from: android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerIcsImpl.1 */
        class C00591 implements AccessibilityStateChangeListenerBridge {
            final /* synthetic */ AccessibilityStateChangeListenerCompat val$listener;

            C00591(AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
                this.val$listener = accessibilityStateChangeListenerCompat;
            }

            public void onAccessibilityStateChanged(boolean z) {
                this.val$listener.onAccessibilityStateChanged(z);
            }
        }

        AccessibilityManagerIcsImpl() {
        }

        public boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return AccessibilityManagerCompatIcs.addAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListenerCompat.mListener);
        }

        public List getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
            return AccessibilityManagerCompatIcs.getEnabledAccessibilityServiceList(accessibilityManager, i);
        }

        public List getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
            return AccessibilityManagerCompatIcs.getInstalledAccessibilityServiceList(accessibilityManager);
        }

        public boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
            return AccessibilityManagerCompatIcs.isTouchExplorationEnabled(accessibilityManager);
        }

        public Object newAccessiblityStateChangeListener(AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return AccessibilityManagerCompatIcs.newAccessibilityStateChangeListener(new C00591(accessibilityStateChangeListenerCompat));
        }

        public boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return AccessibilityManagerCompatIcs.removeAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListenerCompat.mListener);
        }
    }

    public abstract class AccessibilityStateChangeListenerCompat {
        final Object mListener;

        public AccessibilityStateChangeListenerCompat() {
            this.mListener = AccessibilityManagerCompat.IMPL.newAccessiblityStateChangeListener(this);
        }

        public abstract void onAccessibilityStateChanged(boolean z);
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            IMPL = new AccessibilityManagerIcsImpl();
        } else {
            IMPL = new AccessibilityManagerStubImpl();
        }
    }

    public static boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
        return IMPL.addAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListenerCompat);
    }

    public static List getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
        return IMPL.getEnabledAccessibilityServiceList(accessibilityManager, i);
    }

    public static List getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
        return IMPL.getInstalledAccessibilityServiceList(accessibilityManager);
    }

    public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
        return IMPL.isTouchExplorationEnabled(accessibilityManager);
    }

    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
        return IMPL.removeAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListenerCompat);
    }
}
