package xyz.trfa.easymode.ui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.CheckboxWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.client.font.TextRenderer;
import xyz.trfa.easymode.config.TrainerConfig;

public class PlayerMenuScreen extends Screen {

    private final Screen parent;

    public PlayerMenuScreen(Screen parent) {
        super(Text.of("Cheat Menu - Player"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        TextRenderer textRenderer = this.textRenderer;

        // Add God Mode Checkbox
        this.addDrawableChild(new CheckboxWidget(
                this.width / 2 - 100, this.height / 4, 200, 20,
                Text.of("God Mode"), textRenderer,
                TrainerConfig.isGodModeEnabled(),
                checked -> TrainerConfig.toggleGodModeEnabled()
        ));

        // Add Fly Mode Checkbox
        this.addDrawableChild(new CheckboxWidget(
                this.width / 2 - 100, this.height / 4 + 24, 200, 20,
                Text.of("Fly Mode"), textRenderer,
                TrainerConfig.isFlyModeEnabled(),
                checked -> TrainerConfig.toggleFlyModeEnabled()
        ));

        // Back Button to return to the main menu
        this.addDrawableChild(ButtonWidget.builder(
                Text.of("Back"),
                button -> this.client.setScreen(parent)
        ).dimensions(this.width / 2 - 100, this.height / 4 + 72, 200, 20).build());
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 10, 0xFFFFFF);
    }
}
