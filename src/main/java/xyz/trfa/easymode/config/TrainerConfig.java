package xyz.trfa.easymode.config;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameMode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TrainerConfig {
    // Initializing Persistent Settings
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_FILE = new File("config/easymode_config.json");

    private static TrainerConfig instance;


    // God Mode
    private boolean godModeEnabled = false;

    public static boolean isGodModeEnabled() {
        return getInstance().godModeEnabled;
    }

    public static void setGodModeEnabled(boolean enabled) {
        getInstance().godModeEnabled = enabled;
        save();
    }

    public static boolean toggleGodModeEnabled() {
        getInstance().godModeEnabled = !getInstance().godModeEnabled;
        save();
        return isGodModeEnabled();
    }


    // Fly Mode
    private boolean flyModeEnabled = false;

    public static boolean isFlyModeEnabled() {
        return getInstance().flyModeEnabled;
    }

    public static void setFlyModeEnabled(boolean enabled) {
        getInstance().flyModeEnabled = enabled;
    }

    public static boolean toggleFlyModeEnabled() {
        getInstance().flyModeEnabled = !getInstance().flyModeEnabled;
        save();
        return isFlyModeEnabled();
    }


    // World Cheats
    private static boolean worldCheatsEnabled = false;

    public static boolean areWorldCheatsEnabled() {
        return worldCheatsEnabled;
    }

    public static void setWorldCheatsEnabled(boolean checked) {
        worldCheatsEnabled = checked;
    }

    // Gamemode
    private void setPlayerGameMode(ServerPlayerEntity player, GameMode gameMode) {
        player.changeGameMode(gameMode);
    }

    private static GameMode gamemode = GameMode.SURVIVAL; // Default value

    public static GameMode getGamemode() {
        return gamemode;
    }

    public static void setGamemode(GameMode newGamemode) {
        gamemode = newGamemode;
    }


    //
    public static void load() {
        if (CONFIG_FILE.exists()) {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                instance = GSON.fromJson(reader, TrainerConfig.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            instance = new TrainerConfig(); // Default Settings
            save();
        }
    }

    public static void save() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(getInstance(), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static TrainerConfig getInstance() {
        if (instance == null) {
            load();
        }
        return instance;
    }

}
