package xyz.trfa.easymode;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import xyz.trfa.easymode.config.TrainerConfig;

public class ClientModMenu {
    public static Screen getConfigScreen(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.of("Mod Menu"));

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        builder.getOrCreateCategory(Text.of("Trainer Options"))
                .addEntry(entryBuilder.startBooleanToggle(
                    Text.of("God Mode"),
                    TrainerConfig.isGodModeEnabled()
                ).setSaveConsumer(TrainerConfig::setGodModeEnabled)
                .build())
                .addEntry(entryBuilder.startBooleanToggle(
                    Text.of("Fly Mode"),
                    TrainerConfig.isFlyModeEnabled()
                ).setSaveConsumer(TrainerConfig::setFlyModeEnabled)
                .build());

        return builder.build();
    }
}
