package xyz.trfa.easymode.ui.player;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;
import xyz.trfa.easymode.config.TrainerConfig;
import xyz.trfa.easymode.config.Gamemode;

public class PlayerTrainerScreen extends Screen {

    private final Screen parent;

    public PlayerTrainerScreen(Screen parent) {
        super(Text.translatable("gui.easymode.title.player_trainer"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.translatable("gui.easymode.title.player_trainer"));

        ConfigCategory general = builder.getOrCreateCategory(Text.translatable("gui.easymode.category.general"));

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        // God Mode Checkbox
        general.addEntry(entryBuilder
                .startBooleanToggle(Text.translatable("gui.easymode.button.god_mode"), TrainerConfig.isGodModeEnabled())
                .setSaveConsumer(TrainerConfig::setGodModeEnabled)
                .build());

        // Fly Mode Checkbox
        general.addEntry(entryBuilder
                .startBooleanToggle(Text.translatable("gui.easymode.checkbox.fly_mode"), TrainerConfig.isFlyModeEnabled())
                .setSaveConsumer(TrainerConfig::setFlyModeEnabled)
                .build());

        // Gamemode Dropdown
        general.addEntry(entryBuilder
                .startEnumSelector(Text.translatable("gui.easymode.dropdown.select_gamemode"), GameMode.class, TrainerConfig.getGamemode())
                .setSaveConsumer(TrainerConfig::setGamemode)
                .setTooltip(Text.translatable("gui.easymode.tip.select_gamemode"))
                .build());

        builder.setSavingRunnable(() -> {
            // Save config changes here
//            TrainerConfig.save();
        });

        this.client.setScreen(builder.build());
    }
}
