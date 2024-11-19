package xyz.trfa.easymode.mixins;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.trfa.easymode.config.TrainerConfig;

@Mixin(PlayerEntity.class)
public class FlyModeMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        // Enable or disable flight based on TrainerConfig
        if (player.getWorld().isClient) { // Only apply on the client side
            player.getAbilities().allowFlying = TrainerConfig.isFlyModeEnabled();
            player.sendAbilitiesUpdate(); // Ensure changes are reflected in-game
        }
    }
}
