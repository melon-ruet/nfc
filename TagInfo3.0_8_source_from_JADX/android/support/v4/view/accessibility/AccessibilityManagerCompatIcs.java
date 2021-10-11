package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import java.util.List;

class AccessibilityManagerCompatIcs {

    interface AccessibilityStateChangeListenerBridge {
        void onAccessibilityStateChanged(boolean z);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityManagerCompatIcs.1 */
    final class C00601 implements AccessibilityStateChangeListener {
        final /* synthetic */ AccessibilityStateChangeListenerBridge val$bridge;

        C00601(AccessibilityStateChangeListenerBridge accessibilityStateChangeListenerBridge) {
            this.val$bridge = accessibilityStateChangeListenerBridge;
        }

        public void onAccessibilityStateChanged(boolean z) {
            this.val$bridge.onAccessibilityStateChanged(z);
        }
    }

    AccessibilityManagerCompatIcs() {
    }

    public static boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, Object obj) {
        return accessibilityManager.addAccessibilityStateChangeListener((AccessibilityStateChangeListener) obj);
    }

    public static List getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
        return accessibilityManager.getEnabledAccessibilityServiceList(i);
    }

    public static List getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
        return accessibilityManager.getInstalledAccessibilityServiceList();
    }

    public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
        return accessibilityManager.isTouchExplorationEnabled();
    }

    public static Object newAccessibilityStateChangeListener(AccessibilityStateChangeListenerBridge accessibilityStateChangeListenerBridge) {
        return new C00601(accessibilityStateChangeListenerBridge);
    }

    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, Object obj) {
        return accessibilityManager.removeAccessibilityStateChangeListener((AccessibilityStateChangeListener) obj);
    }
}
