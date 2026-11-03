package net.dungeonhd.zombifiedpiglinpatch.mixin;

import net.dungeonhd.zombifiedpiglinpatch.SpearUtil;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.monster.zombie.ZombifiedPiglin;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ZombifiedPiglin.class)
public abstract class ZombifiedPiglinMixin {

    // Vanilla rolls a 1 in 20 golden spear here. Swap it for the sword.
    @Inject(method = "populateDefaultEquipmentSlots", at = @At("RETURN"))
    private void zpp$noSpearEquipment(RandomSource random, DifficultyInstance difficulty, CallbackInfo ci) {
        SpearUtil.stripSpears((ZombifiedPiglin) (Object) this, true);
    }

    // No picking spears up off the ground.
    @Inject(method = "wantsToPickUp", at = @At("HEAD"), cancellable = true)
    private void zpp$noSpearPickup(ServerLevel level, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (SpearUtil.isSpear(stack)) {
            cir.setReturnValue(false);
        }
    }
}
