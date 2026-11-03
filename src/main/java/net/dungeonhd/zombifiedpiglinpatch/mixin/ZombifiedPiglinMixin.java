package net.dungeonhd.zombifiedpiglinpatch.mixin;

import net.dungeonhd.zombifiedpiglinpatch.SpearUtil;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.monster.zombie.ZombifiedPiglin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ZombifiedPiglin.class)
public abstract class ZombifiedPiglinMixin {

    // Vanilla rolls a 1 in 20 golden spear here. Swap it for the sword.
    // Spears given by hand, command or pickup are left alone.
    @Inject(method = "populateDefaultEquipmentSlots", at = @At("RETURN"))
    private void zpp$noSpearEquipment(RandomSource random, DifficultyInstance difficulty, CallbackInfo ci) {
        SpearUtil.swapSpearForSword((ZombifiedPiglin) (Object) this);
    }
}
