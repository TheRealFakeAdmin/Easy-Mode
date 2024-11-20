package xyz.trfa.easymode.config;

public class TrainerConfig {
    private static boolean godModeEnabled = false;
    private static boolean flyModeEnabled = false;
    private static boolean worldCheatsEnabled = false;

    public static boolean isGodModeEnabled() {
        return godModeEnabled;
    }

    public static void setGodModeEnabled(boolean enabled) {
        godModeEnabled = enabled;
    }

    public static boolean toggleGodModeEnabled() {
        return godModeEnabled = !godModeEnabled;
    }

    public static boolean isFlyModeEnabled() {
        return flyModeEnabled;
    }

    public static void setFlyModeEnabled(boolean enabled) {
        flyModeEnabled = enabled;
    }

    public static boolean toggleFlyModeEnabled() {
        return flyModeEnabled = !flyModeEnabled;
    }

    public static boolean areWorldCheatsEnabled() {
        return worldCheatsEnabled;
    }

    public static void setWorldCheatsEnabled(boolean checked) {
        worldCheatsEnabled = checked;
    }
}
