package net.gurken.pocket_end_update.datagen;

import com.google.common.collect.ImmutableList;
import net.gurken.pocket_end_update.PocketEndUpdate;
import net.gurken.pocket_end_update.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import net.minecraftforge.registries.DeferredRegister;

import java.util.List;

public class ModProcessorLists {

    public static final DeferredRegister<StructureProcessorType<?>> PROCESSOR_LISTS = DeferredRegister.create(Registries.STRUCTURE_PROCESSOR, PocketEndUpdate.MOD_ID);
    public static final ResourceKey<StructureProcessorList> END_CRYSTAL_ADDITION = createKey("pocket_end_update:end_crystal_addition");

    private static ResourceKey<StructureProcessorList> createKey(String pName) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(pName));
    }

    private static void register(BootstapContext<StructureProcessorList> pContext, ResourceKey<StructureProcessorList> pKey, List<StructureProcessor> pProcessors) {
        pContext.register(pKey, new StructureProcessorList(pProcessors));
    }

    public static void bootstrap(BootstapContext<StructureProcessorList> pContext) {
        register(pContext, END_CRYSTAL_ADDITION, ImmutableList.of(new RuleProcessor(ImmutableList.of(new ProcessorRule(new RandomBlockMatchTest(Blocks.END_STONE, 0.2F), AlwaysTrueTest.INSTANCE, ModBlocks.END_CRYSTAL_ORE.get().defaultBlockState())))));
    }
}
