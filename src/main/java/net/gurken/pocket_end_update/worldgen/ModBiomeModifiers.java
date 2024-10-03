package net.gurken.pocket_end_update.worldgen;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_END_CRYSTAL_ORE = registerKey("add_end_crystal_ore");
    public static final ResourceKey<BiomeModifier> ADD_CHORALITE_ACCUMULATION = registerKey("add_choralite_accumulation");
    public static final ResourceKey<BiomeModifier> ADD_END_CRYSTALS = registerKey("add_end_crystals");
    public static final ResourceKey<BiomeModifier> ADD_EXTRA_END_ISLAND = registerKey("add_extra_end_island");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_END_CRYSTAL_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModBiomeTags.IS_OUTER_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_CRYSTAL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_CHORALITE_ACCUMULATION, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModBiomeTags.IS_OUTER_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CHORALITE_ACCUMULATION_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_END_CRYSTALS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModBiomeTags.IS_OUTER_ISLAND),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_CRYSTALS_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_DECORATION));

        //context.register(ADD_EXTRA_END_ISLAND, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
        //        biomes.getOrThrow(ModBiomeTags.IS_OUTER_END),
        //        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.EXTRA_END_ISLAND_PLACED_KEY)),
        //       GenerationStep.Decoration.RAW_GENERATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(PocketEndUpdate.MOD_ID, name));
    }
}
