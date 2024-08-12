package net.gurken.pocket_end_update.client.events;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.gurken.pocket_end_update.entity.client.EnderruinModel;
import net.gurken.pocket_end_update.entity.client.ModModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = PocketEndUpdate.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.ENDERRUIN_LAYER, EnderruinModel::createBodyLayer);
    }
}