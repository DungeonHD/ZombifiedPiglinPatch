package net.dungeonhd.zombifiedpiglinpatch;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public final class SpearUtil {

    private static final EquipmentSlot[] HANDS = {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND};

    private SpearUtil() {
    }

    // Matches by registry id suffix, so modded *_spear items are covered too.
    public static boolean isSpear(ItemStack stack) {
        if (stack.isEmpty()) {
            return false;
        }
        return BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath().endsWith("_spear");
    }

    // swapForSword: main hand spear becomes a golden sword, otherwise the slot is just cleared.
    public static void stripSpears(Mob mob, boolean swapForSword) {
        for (EquipmentSlot slot : HANDS) {
            if (isSpear(mob.getItemBySlot(slot))) {
                if (swapForSword && slot == EquipmentSlot.MAINHAND) {
                    mob.setItemSlot(slot, new ItemStack(Items.GOLDEN_SWORD));
                } else {
                    mob.setItemSlot(slot, ItemStack.EMPTY);
                }
            }
        }
    }
}
