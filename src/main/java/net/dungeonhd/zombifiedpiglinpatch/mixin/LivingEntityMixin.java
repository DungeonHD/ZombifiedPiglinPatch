package net.dungeonhd.zombifiedpiglinpatch.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.zombie.ZombifiedPiglin;
import net.minecraft.world.level.gamerules.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    // dropExperience() only pays out without a recent player hit if this returns true.
    // XP amount stays vanilla, the mob_drops gamerule still applies.
    @Inject(method = "isAlwaysExperienceDropper", at = @At("HEAD"), cancellable = true)
    private void zpp$alwaysDropExperience(CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (self instanceof ZombifiedPiglin
            && self.level() instanceof ServerLevel level
            && level.getGameRules().get(GameRules.MOB_DROPS)) {
            cir.setReturnValue(true);
        }
    }
}
