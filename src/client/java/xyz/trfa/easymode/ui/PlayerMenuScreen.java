package xyz.trfa.easymode.ui;

import net.minecraft.client.gui.DrawContext;
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
        super(Text.of("Easy Mode Trainer - Player"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        TextRenderer textRenderer = this.textRenderer;

        // Add God Mode Checkbox
        this.addDrawableChild(CheckboxWidget.builder(
                        Text.of("God Mode"),
                        textRenderer
                ).pos(this.width / 2 - 100, this.height / 4)
                .maxWidth(200)
                .checked(TrainerConfig.isGodModeEnabled())
                .callback((checkbox, checked) -> TrainerConfig.setGodModeEnabled(checked))
                .build());

        // Add Fly Mode Checkbox
        this.addDrawableChild(CheckboxWidget.builder(
                        Text.of("Fly Mode"),
                        textRenderer
                ).pos(this.width / 2 - 100, this.height / 4 + 24)
                .maxWidth(200)
                .checked(TrainerConfig.isFlyModeEnabled())
                .callback((checkbox, checked) -> TrainerConfig.setFlyModeEnabled(checked))
                .build());

        // Back Button to return to the main menu
        this.addDrawableChild(ButtonWidget.builder(
                Text.of("Back"),
                button -> this.client.setScreen(parent)
        ).dimensions(this.width / 2 - 100, this.height / 4 + 72, 200, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta); // Fixed parameters
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 10, 0xFFFFFF);
    }
}
