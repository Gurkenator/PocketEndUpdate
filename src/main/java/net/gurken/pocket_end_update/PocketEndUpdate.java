package net.gurken.pocket_end_update;

import com.mojang.logging.LogUtils;
import net.gurken.pocket_end_update.alchemy.ModPotionBrewing;
import net.gurken.pocket_end_update.block.ModBlocks;
import net.gurken.pocket_end_update.datagen.ModProcessorLists;
import net.gurken.pocket_end_update.entity.ModEntities;
import net.gurken.pocket_end_update.entity.client.EnderruinRenderer;
import net.gurken.pocket_end_update.init.ModFeatures;
import net.gurken.pocket_end_update.item.ModItemProperties;
import net.gurken.pocket_end_update.item.ModItems;
import net.gurken.pocket_end_update.item.custom.ModPotions;
import net.gurken.pocket_end_update.util.ModBrewingRecipe;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PocketEndUpdate.MOD_ID)
public class PocketEndUpdate
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "pocket_end_update";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public PocketEndUpdate()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        //Register Potions
        ModPotions.POTIONS.register(modEventBus);

        //Register Features
        ModFeatures.FEATURES.register(modEventBus);

        //Register Processor Lists
        ModProcessorLists.PROCESSOR_LISTS.register(modEventBus);

        //Register Entities
        ModEntities.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, net.gurken.pocket_end_update.Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ModPotionBrewing.addMix(Potions.AWKWARD, ModItems.CHORALITE_KERNEL.get(), ModPotions.LEVITATION.get());
        ModPotionBrewing.addMix(ModPotions.LEVITATION.get(), Items.REDSTONE, ModPotions.LEVITATION_LONG.get());
        ModPotionBrewing.addMix(ModPotions.LEVITATION.get(), Items.GLOWSTONE_DUST, ModPotions.LEVITATION_STRONG.get());

        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD,
                ModItems.CHORALITE_KERNEL.get(), ModPotions.LEVITATION.get()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ENDERITE_INGOT);
            event.accept(ModItems.ENDERFERENCE_CRYSTAL);
            event.accept(ModItems.CRACKED_CHORALITE_KERNEL);
            event.accept(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE);
            event.accept(ModItems.SAIL_ARMOR_TRIM_SMITHING_TEMPLATE);
        }

    if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.ENDERITE_BLOCK);
            event.accept(ModBlocks.PURPUR_PANEL);
            event.accept(ModBlocks.INDIGO_BLOCK);
            event.accept(ModBlocks.INDIGO_PILLAR);
            event.accept(ModBlocks.INDIGO_PANEL);
            event.accept(ModBlocks.INDIGO_STAIRS);
            event.accept(ModBlocks.INDIGO_SLAB);
        }

    if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.CHORALITE_ACCUMULATION);
            event.accept(ModItems.CHORALITE_SPORES);
            event.accept(ModBlocks.END_CRYSTAL_ORE);
        }

    if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.ENDERITE_BOW);
            event.accept(ModItems.ENDERITE_CROSSBOW);
        }

    if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.CHORALITE_KERNEL);
        }

        if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.ENDERRUIN_SPAWN_EGG);
        }
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.ENDERRUIN.get(), EnderruinRenderer::new);
            event.enqueueWork(() -> {
                ModItemProperties.addCustomItemProperties();
            });
        }
    }
}
