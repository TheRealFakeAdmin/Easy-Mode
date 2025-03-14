package xyz.trfa.easymode;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import org.lwjgl.glfw.GLFW;
import xyz.trfa.easymode.config.TrainerConfig;
import xyz.trfa.easymode.ui.TrainerScreen;

public class Keybindings implements ClientModInitializer {

    // Keybinding fields
    private static KeyBinding toggleGodModeKey;
    private static KeyBinding toggleFlyModeKey;
    private static KeyBinding openTrainerMenuKey;

    @Override
    public void onInitializeClient() {
        // This is the correct entry point where Fabric calls client initialization
        registerKeybindings();

        // Register the tick event to monitor key presses
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (toggleGodModeKey.wasPressed()) {
                TrainerConfig.toggleGodModeEnabled();
                if (client.player != null) {
                    client.player.sendMessage(
                            TrainerConfig.isGodModeEnabled()
                                    ? Text.translatable("gui.easymode.button.god_mode_enabled")
                                    : Text.translatable("gui.easymode.button.god_mode_disabled"),
                            true
                    );
                }
            }

            if (toggleFlyModeKey.wasPressed()) {
                TrainerConfig.toggleFlyModeEnabled();
                if (client.player != null) {
                    client.player.getAbilities().allowFlying = TrainerConfig.isFlyModeEnabled();
                    client.player.getAbilities().flying = TrainerConfig.isFlyModeEnabled();
                    client.player.sendAbilitiesUpdate();
                    client.player.sendMessage(
                            TrainerConfig.isFlyModeEnabled()
                                    ? Text.translatable("gui.easymode.button.fly_mode_enabled")
                                    : Text.translatable("gui.easymode.button.fly_mode_disabled"),
                            true
                    );
                }
            }

            if (openTrainerMenuKey.wasPressed() && client.player != null) {
                client.setScreen(new TrainerScreen(null));
            }
        });
    }

    private void registerKeybindings() {
        // Register each keybinding here
        toggleGodModeKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.easymode.name.toggle_god_mode",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G, // [G] Key
                "key.easymode.category.name"
        ));

        toggleFlyModeKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.easymode.name.toggle_fly_mode",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_H, // [H] Key
                "key.easymode.category.name"
        ));

        openTrainerMenuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "gui.easymode.open_trainer_menu",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_GRAVE_ACCENT, // [`] key
                "key.easymode.category.name"
        ));
    }
}
