package xyz.trfa.easymode;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import xyz.trfa.easymode.config.TrainerConfig;

public class Keybindings {
    private static KeyBinding toggleGodModeKey;
    private static KeyBinding toggleFlyModeKey;

    public static void register() {
        registerKeybindings();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // God Mode
            if (toggleGodModeKey.wasPressed()) {
                TrainerConfig.toggleGodModeEnabled();

                if (client.player != null) {
                    client.player.sendMessage(
                            TrainerConfig.isGodModeEnabled()
                                    ? Text.of("God Mode Enabled")
                                    : Text.of("God Mode Disabled"),
                            true // Display in action bar
                    );
                    System.out.println("God Mode toggled: " + TrainerConfig.isGodModeEnabled());
                }
            }

            // Fly Mode
            if (toggleFlyModeKey.wasPressed()) {
                TrainerConfig.toggleFlyModeEnabled();

                if (client.player != null) {
                    client.player.sendMessage(
                            TrainerConfig.isFlyModeEnabled()
                                    ? Text.of("Fly Mode Enabled")
                                    : Text.of("Fly Mode Disabled"),
                            true
                    );
                    System.out.println("Fly Mode toggled: " + TrainerConfig.isFlyModeEnabled());
                }
            }
        });
    }

    private static void registerKeybindings() {
        toggleGodModeKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.easymode.toggle_godmode",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                "category.easymode"
        ));

        toggleFlyModeKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.easymode.toggle_flymode",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_H,
                "category.easymode"
        ));
    }
}
