package net.gurken.pocket_end_update.init;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.gurken.pocket_end_update.feature.StructuralFeature;
import net.gurken.pocket_end_update.feature.StructuralFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    // CREDIT GOES TO: TeamTwilight | https://github.com/TeamTwilight/twilightforest, from whom this code is adapted.
    // The Twilight Forest uses a custom LGPL License
    // https://github.com/TeamTwilight/twilightforest/blob/1.20.x/LICENSE

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, PocketEndUpdate.MOD_ID);

    public static final RegistryObject<Feature<StructuralFeatureConfiguration>> EXTRA_END_ISLAND = FEATURES.register("extra_end_island", () -> new StructuralFeature(StructuralFeatureConfiguration.CODEC));
}
