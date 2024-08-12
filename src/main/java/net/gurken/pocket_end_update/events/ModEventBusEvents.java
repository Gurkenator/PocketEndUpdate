package net.gurken.pocket_end_update.events;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.gurken.pocket_end_update.entity.ModEntities;
import net.gurken.pocket_end_update.entity.custom.EnderruinEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PocketEndUpdate.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.ENDERRUIN.get(), EnderruinEntity.createAttributes().build());
    }
}
