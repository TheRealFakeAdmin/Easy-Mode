package xyz.trfa.easymode.mixins;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.trfa.easymode.config.TrainerConfig; // Replace with the actual path to your config class

@Mixin(PlayerEntity.class)
public abstract class GodModeMixin {

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void onDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (TrainerConfig.isGodModeEnabled()) {  // Replace with your method for checking God Mode
            cir.setReturnValue(false);  // Cancel the damage
        }
    }
}
