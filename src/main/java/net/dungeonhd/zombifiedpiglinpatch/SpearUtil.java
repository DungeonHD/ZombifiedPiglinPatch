package net.dungeonhd.zombifiedpiglinpatch;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public final class SpearUtil {

    private SpearUtil() {
    }

    // Matches by registry id suffix, so modded *_spear items are covered too.
    public static boolean isSpear(ItemStack stack) {
        if (stack.isEmpty()) {
            return false;
        }
        return BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath().endsWith("_spear");
    }

    // Replaces a spear in the main hand with a golden sword.
    public static void swapSpearForSword(Mob mob) {
        if (isSpear(mob.getItemBySlot(EquipmentSlot.MAINHAND))) {
            mob.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
        }
    }
}
