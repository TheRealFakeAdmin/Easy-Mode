package xyz.trfa.easymode.ui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import xyz.trfa.easymode.config.TrainerConfig;

public class TrainerScreen extends Screen {

    protected TrainerScreen() {
        super(Text.of("Trainer Menu"));
    }

    @Override
    protected void init() {
        // Add a button to toggle God Mode
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 4, 200, 20,
                Text.of("Toggle God Mode: " + (TrainerConfig.isGodModeEnabled() ? "ON" : "OFF")),
                button -> {
                    TrainerConfig.toggleGodModeEnabled();
                    button.setMessage(Text.of("Toggle God Mode: " + (TrainerConfig.isGodModeEnabled() ? "ON" : "OFF")));
                }));

        // Add a button to toggle Fly Mode
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 4 + 24, 200, 20,
                Text.of("Toggle Fly Mode: " + (TrainerConfig.isFlyModeEnabled() ? "ON" : "OFF")),
                button -> {
                    TrainerConfig.toggleFlyModeEnabled();
                    button.setMessage(Text.of("Toggle Fly Mode: " + (TrainerConfig.isFlyModeEnabled() ? "ON" : "OFF")));
                }));

        // Add a close button
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 4 + 48, 200, 20,
                Text.of("Close"), button -> this.close()));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 10, 0xFFFFFF);
    }
}
