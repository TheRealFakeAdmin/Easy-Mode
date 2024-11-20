package xyz.trfa.easymode.ui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class TrainerScreen extends Screen {

    private final Screen parent;

    public TrainerScreen(Screen parent) {
        super(Text.of("Easy Mode Trainer - Main"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        // Player Menu Button
        this.addDrawableChild(ButtonWidget.builder(
                Text.of("Player"),
                button -> this.client.setScreen(new PlayerMenuScreen(this))
        ).dimensions(this.width / 2 - 100, this.height / 4, 200, 20).build());

        // World Menu Button
        this.addDrawableChild(ButtonWidget.builder(
                Text.of("World"),
                button -> this.client.setScreen(new WorldMenuScreen(this))
        ).dimensions(this.width / 2 - 100, this.height / 4 + 24, 200, 20).build());

        // Close Menu Button
        this.addDrawableChild(ButtonWidget.builder(
                Text.of("Close"),
                button -> this.client.setScreen(null)
        ).dimensions(this.width / 2 - 100, this.height / 4 + 48, 200, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta); // Fixed parameters
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 10, 0xFFFFFF);
    }
}
