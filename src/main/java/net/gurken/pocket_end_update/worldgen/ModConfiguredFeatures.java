package net.gurken.pocket_end_update.worldgen;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.gurken.pocket_end_update.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_CRYSTAL_ORE_KEY = registerKey("end_crystal_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHORALITE_ACCUMULATION_KEY = registerKey("choralite_accumulation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_CRYSTALS_KEY = registerKey("end_crystals");
    //public static final ResourceKey<ConfiguredFeature<?, ?>> EXTRA_END_ISLAND_KEY = registerKey("extra_end_island");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        HolderGetter<StructureProcessorList> holdergetter1 = context.lookup(Registries.PROCESSOR_LIST);
        //List<ResourceLocation> list = List.of(new ResourceLocation("pocket_end_update:extra_end_islands/extra_end_island_large"), new ResourceLocation("pocket_end_update:extra_end_islands/extra_end_island_wide"), new ResourceLocation("pocket_end_update:extra_end_islands/extra_end_island_medium"), new ResourceLocation("pocket_end_update:extra_end_islands/extra_end_island_small"));
        //ist<ResourceLocation> list1 = List.of(new ResourceLocation("pocket_end_update:extra_end_islands/extra_end_island_large_overlay"), new ResourceLocation("pocket_end_update:extra_end_islands/extra_end_island_wide_overlay"), new ResourceLocation("pocket_end_update:extra_end_islands/extra_end_island_medium_overlay"), new ResourceLocation("pocket_end_update:extra_end_islands/extra_end_island_small_overlay"));
        //Holder<StructureProcessorList> holder = holdergetter1.getOrThrow(ModProcessorLists.END_CRYSTAL_ADDITION);

        register(context, END_CRYSTAL_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.END_CRYSTAL_ORE.get().defaultBlockState(), 1));

        register(context, CHORALITE_ACCUMULATION_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CHORALITE_ACCUMULATION.get())))));

        register(context, END_CRYSTALS_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(24, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.BLOCK_COLUMN,
                        new BlockColumnConfiguration(List.of(BlockColumnConfiguration
                        .layer(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                        .add(UniformInt.of(3, 6), 2).build()),
                                BlockStateProvider.simple(ModBlocks.END_CRYSTAL.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y)))),
                                Direction.DOWN, BlockPredicate.allOf(BlockPredicate.matchesBlocks(new Vec3i(0, 0, 0), List.of(Blocks.AIR, Blocks.CAVE_AIR, Blocks.VOID_AIR))),false))));

                                //BlockPredicate.matchesBlocks(new Vec3i(0, 1, 0), List.of(Blocks.END_STONE, ModBlocks.END_CRYSTAL_ORE.get(), ModBlocks.END_CRYSTAL.get())),false))));
                                //BlockPredicate.allOf(BlockPredicate.matchesBlocks(new Vec3i(0, 0, 0), List.of(Blocks.AIR, Blocks.CAVE_AIR, Blocks.VOID_AIR))),true))));
                                //BlockPredicate.matchesBlocks(new Vec3i(0, 0, 0), List.of(Blocks.AIR, Blocks.CAVE_AIR, Blocks.VOID_AIR)),false))));

        //register(context, EXTRA_END_ISLAND_KEY, ModFeatures.EXTRA_END_ISLAND.get(),
        //        new StructuralFeatureConfiguration(list, list1, holder, holdergetter1.getOrThrow(ModProcessorLists.END_CRYSTAL_ADDITION), 4));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(PocketEndUpdate.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
