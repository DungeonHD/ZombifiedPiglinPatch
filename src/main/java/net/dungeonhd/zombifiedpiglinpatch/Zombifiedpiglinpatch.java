package net.dungeonhd.zombifiedpiglinpatch;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.world.entity.monster.zombie.ZombifiedPiglin;

public class Zombifiedpiglinpatch implements ModInitializer {

    @Override
    public void onInitialize() {
        // Catches spears that bypass the equipment mixin: chunk loads, piglin conversion, /summon with NBT.
        // Runs once per entity load, no ticking.
        ServerEntityEvents.ENTITY_LOAD.register((entity, level) -> {
            if (entity instanceof ZombifiedPiglin piglin) {
                SpearUtil.stripSpears(piglin, false);
            }
        });
    }
}
