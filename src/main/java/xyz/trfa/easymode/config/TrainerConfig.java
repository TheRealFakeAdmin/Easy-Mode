package xyz.trfa.easymode.config;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameMode;

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

    // Gamemode
    private static Gamemode gamemode = Gamemode.SURVIVAL; // Default value

    public static Gamemode getGamemode() {
        return gamemode;
    }

    public static void setGamemode(Gamemode newGamemode) {
        gamemode = newGamemode;
    }

}
