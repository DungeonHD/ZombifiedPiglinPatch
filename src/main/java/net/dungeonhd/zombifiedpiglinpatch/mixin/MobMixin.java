package net.dungeonhd.zombifiedpiglinpatch.mixin;

import net.dungeonhd.zombifiedpiglinpatch.SpearUtil;
import net.minecraft.world.entity.monster.zombie.ZombifiedPiglin;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(net.minecraft.world.entity.Mob.class)
public abstract class MobMixin {

    // Prevents Zombified Piglins from picking up or equipping spears from the ground
    @Inject(method = "canHoldItem", at = @At("HEAD"), cancellable = true, require = 0)
    private void zpp$noSpearPickup(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if ((Object) this instanceof ZombifiedPiglin && SpearUtil.isSpear(stack)) {
            cir.setReturnValue(false);
        }
    }
}
