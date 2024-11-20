package xyz.trfa.easymode.ui.world;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.CheckboxWidget;
import net.minecraft.text.Text;
import net.minecraft.client.font.TextRenderer;
import xyz.trfa.easymode.config.TrainerConfig;

public class WorldTrainerScreen extends Screen {

    private final Screen parent;

    public WorldTrainerScreen(Screen parent) {
        super(Text.of("Easy Mode Trainer - World"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        if (this.client != null) {
            TextRenderer textRenderer = this.textRenderer;

            // Enable World Cheats Checkbox
            this.addDrawableChild(CheckboxWidget.builder(
                            Text.of("Enable Cheats"),
                            textRenderer
                    ).pos(this.width / 2 - 100, this.height / 4)
                    .maxWidth(200)
                    .checked(TrainerConfig.areWorldCheatsEnabled())
                    .callback((checkbox, checked) -> TrainerConfig.setWorldCheatsEnabled(checked))
                    .build());

            // Toggle Game Rules Button
            this.addDrawableChild(ButtonWidget.builder(
                    Text.of("Toggle Gamerules"),
                    button -> {
                        // Logic to open gamerules submenu
                    }
            ).dimensions(this.width / 2 - 100, this.height / 4 + 24, 200, 20).build());

            // Set Weather Button
            this.addDrawableChild(ButtonWidget.builder(
                    Text.of("Set Weather"),
                    button -> {
                        // Logic to open weather submenu
                    }
            ).dimensions(this.width / 2 - 100, this.height / 4 + 48, 200, 20).build());

            // Set Time Button
            this.addDrawableChild(ButtonWidget.builder(
                    Text.of("Set Time"),
                    button -> {
                        // Logic to open time submenu
                    }
            ).dimensions(this.width / 2 - 100, this.height / 4 + 72, 200, 20).build());

            // Back Button
            this.addDrawableChild(ButtonWidget.builder(
                    Text.of("Back"),
                    button -> this.client.setScreen(parent)
            ).dimensions(this.width / 2 - 100, this.height / 4 + 96, 200, 20).build());
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta); // Adjusted render for DrawContext
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 10, 0xFFFFFF);
    }
}
