package xyz.trfa.easymode.config;

public class TrainerConfig {
    private static boolean godModeEnabled = false;
    private static boolean flyModeEnabled = false;

    public static boolean isGodModeEnabled() {
        return godModeEnabled;
    }

    public static void setGodModeEnabled(boolean enabled) {
        godModeEnabled = enabled;
    }

    public static void toggleGodModeEnabled() {
        godModeEnabled = !godModeEnabled;
    }

    public static boolean isFlyModeEnabled() {
        return flyModeEnabled;
    }

    public static void setFlyModeEnabled(boolean enabled) {
        flyModeEnabled = enabled;
    }

    public static void toggleFlyModeEnabled() {
        flyModeEnabled = !flyModeEnabled;
    }
}
