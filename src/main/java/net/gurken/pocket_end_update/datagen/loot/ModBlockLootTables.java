package net.gurken.pocket_end_update.datagen.loot;

import net.gurken.pocket_end_update.block.ModBlocks;
import net.gurken.pocket_end_update.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.ENDERITE_BLOCK.get());
        this.dropSelf(ModBlocks.PURPUR_PANEL.get());
        this.dropSelf(ModBlocks.INDIGO_BLOCK.get());
        this.dropSelf(ModBlocks.INDIGO_PANEL.get());
        this.dropSelf(ModBlocks.INDIGO_PILLAR.get());
        this.dropSelf(ModBlocks.INDIGO_STAIRS.get());
        this.add(ModBlocks.INDIGO_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.INDIGO_SLAB.get()));

        this.add(ModBlocks.END_CRYSTAL_ORE.get(),
                block -> createOreDrop(ModBlocks.END_CRYSTAL_ORE.get(), ModItems.ENDERFERENCE_CRYSTAL.get()));

        this.dropSelf(ModBlocks.EULIUM_ROOT.get());
        this.dropSelf(ModBlocks.STRIPPED_EULIUM_ROOT.get());
        this.dropSelf(ModBlocks.EULIUM_NODULE.get());
        this.dropSelf(ModBlocks.STRIPPED_EULIUM_NODULE.get());
        this.dropSelf(ModBlocks.EULIUM_PLANKS.get());
        this.dropSelf(ModBlocks.EULIUM_STAIRS.get());
        this.add(ModBlocks.EULIUM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.EULIUM_SLAB.get()));
        this.dropSelf(ModBlocks.EULIUM_BUTTON.get());
        this.dropSelf(ModBlocks.EULIUM_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.EULIUM_FENCE.get());
        this.dropSelf(ModBlocks.EULIUM_FENCE_GATE.get());
        this.dropSelf(ModBlocks.EULIUM_TRAPDOOR.get());
        this.add(ModBlocks.EULIUM_DOOR.get(),
                block -> createDoorTable(ModBlocks.EULIUM_DOOR.get()));
        this.dropSelf(ModBlocks.EULIUM_TUBER.get());
        this.add(ModBlocks.EULIUM_FIBERS.get(), block ->
                createLeavesDrops(block, ModBlocks.EULIUM_TUBER.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ModBlocks.GREENSTONE.get());
        this.dropSelf(ModBlocks.GREENSTONE_WALL.get());
        this.dropSelf(ModBlocks.DRAGON_LANTERN.get());

        this.add(ModBlocks.EULIUM_SIGN.get(), block ->
                createSingleItemTable(ModItems.EULIUM_SIGN.get()));
        this.add(ModBlocks.EULIUM_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.EULIUM_SIGN.get()));
        this.add(ModBlocks.EULIUM_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.EULIUM_HANGING_SIGN.get()));
        this.add(ModBlocks.EULIUM_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.EULIUM_HANGING_SIGN.get()));

        //this.(ModBlocks.CHORALITE_ACCUMULATION.get(),
        //        block -> createLeavesDrops(ModBlocks.CHORALITE_ACCUMULATION.get(), Block.byItem(ModItems.CHORALITE_SPORES.get())), 0.25);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).filter(block ->
                block != ModBlocks.CHORALITE_ACCUMULATION.get() &&
                        block != ModBlocks.CHORALITE_GROWTH.get() &&
                        block != ModBlocks.END_CRYSTAL.get())::iterator;
    }
}
