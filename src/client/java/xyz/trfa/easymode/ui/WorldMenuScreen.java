package xyz.trfa.easymode.ui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.CheckboxWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import xyz.trfa.easymode.config.TrainerConfig;

public class WorldMenuScreen extends Screen {

    private final Screen parent;

    public WorldMenuScreen(Screen parent) {
        super(Text.of("Cheat Menu - World"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        // Enable World Cheats
        this.addDrawableChild(new CheckboxWidget(
                this.width / 2 - 100, this.height / 4, 200, 20,
                Text.of("Enable Cheats"), false // Placeholder for state
        ));

        // Toggle Game Rules
        this.addDrawableChild(ButtonWidget.builder(
                Text.of("Toggle Gamerules"),
                button -> {} // Opens gamerules submenu (to implement)
        ).dimensions(this.width / 2 - 100, this.height / 4 + 24, 200, 20).build());

        // Set Weather Button
        this.addDrawableChild(ButtonWidget.builder(
                Text.of("Set Weather"),
                button -> {} // Opens weather submenu
        ).dimensions(this.width / 2 - 100, this.height / 4 + 48, 200, 20).build());

        // Set Time Button
        this.addDrawableChild(ButtonWidget.builder(
                Text.of("Set Time"),
                button -> {} // Opens time submenu
        ).dimensions(this.width / 2 - 100, this.height / 4 + 72, 200, 20).build());

        // Back Button
        this.addDrawableChild(ButtonWidget.builder(
                Text.of("Back"),
                button -> this.client.setScreen(parent)
        ).dimensions(this.width / 2 - 100, this.height / 4 + 96, 200, 20).build());
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 10, 0xFFFFFF);
    }
}
