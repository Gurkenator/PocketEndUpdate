package net.gurken.pocket_end_update.datagen;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.gurken.pocket_end_update.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PocketEndUpdate.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PURPUR_PANEL.get(),
                        ModBlocks.INDIGO_BLOCK.get(),
                        ModBlocks.INDIGO_PANEL.get(),
                        ModBlocks.INDIGO_PANEL.get(),
                        ModBlocks.INDIGO_SLAB.get(),
                        ModBlocks.INDIGO_STAIRS.get(),
                        ModBlocks.GREENSTONE.get(),
                        ModBlocks.DRAGON_LANTERN.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.EULIUM_PLANKS.get(),
                        ModBlocks.EULIUM_STAIRS.get(),
                        ModBlocks.EULIUM_SLAB.get(),
                        ModBlocks.EULIUM_ROOT.get(),
                        ModBlocks.STRIPPED_EULIUM_ROOT.get(),
                        ModBlocks.EULIUM_NODULE.get(),
                        ModBlocks.STRIPPED_EULIUM_NODULE.get(),
                        ModBlocks.EULIUM_PRESSURE_PLATE.get(),
                        ModBlocks.EULIUM_BUTTON.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.EULIUM_FIBERS.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.END_CRYSTAL_ORE.get(),
                        ModBlocks.ENDERITE_BLOCK.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.EULIUM_ROOT.get())
                .add(ModBlocks.EULIUM_NODULE.get())
                .add(ModBlocks.STRIPPED_EULIUM_ROOT.get())
                .add(ModBlocks.STRIPPED_EULIUM_NODULE.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.EULIUM_PLANKS.get());

        this.tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.EULIUM_STAIRS.get());

        this.tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.EULIUM_SLAB.get());

        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.EULIUM_BUTTON.get());

        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.EULIUM_PRESSURE_PLATE.get());

        this.tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.EULIUM_DOOR.get());

        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.EULIUM_TRAPDOOR.get());

        this.tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.EULIUM_FENCE.get());

        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.EULIUM_FIBERS.get());

        this.tag(BlockTags.SAPLINGS)
                .add(ModBlocks.EULIUM_TUBER.get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.GREENSTONE_WALL.get());

    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
