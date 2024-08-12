package net.gurken.pocket_end_update.entity;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.gurken.pocket_end_update.entity.custom.EnderruinEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PocketEndUpdate.MOD_ID);

    public static final RegistryObject<EntityType<EnderruinEntity>> ENDERRUIN =
            ENTITY_TYPES.register("enderruin", () -> EntityType.Builder.of(EnderruinEntity::new, MobCategory.MONSTER)
                    .sized(1f, 2f).build("enderruin"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
