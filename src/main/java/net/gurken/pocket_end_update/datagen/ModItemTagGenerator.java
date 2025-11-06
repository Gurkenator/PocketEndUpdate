package net.gurken.pocket_end_update.datagen;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.gurken.pocket_end_update.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future,
                               CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, completableFuture, PocketEndUpdate.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Add Item Tags here
        //tag(ModTags...

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.EULIUM_ROOT.get().asItem())
                .add(ModBlocks.EULIUM_NODULE.get().asItem())
                .add(ModBlocks.STRIPPED_EULIUM_ROOT.get().asItem())
                .add(ModBlocks.STRIPPED_EULIUM_NODULE.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.EULIUM_PLANKS.get().asItem());

        this.tag(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.EULIUM_STAIRS.get().asItem());

        this.tag(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.EULIUM_SLAB.get().asItem());

        this.tag(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.EULIUM_BUTTON.get().asItem());

        this.tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.EULIUM_PRESSURE_PLATE.get().asItem());

        this.tag(ItemTags.STONE_CRAFTING_MATERIALS)
                .add(ModBlocks.GREENSTONE.get().asItem());

        this.tag(ItemTags.STONE_TOOL_MATERIALS)
                .add(ModBlocks.GREENSTONE.get().asItem());

        this.tag(ItemTags.SIGNS)
                .add(ModBlocks.EULIUM_SIGN.get().asItem());

        this.tag(ItemTags.HANGING_SIGNS)
                .add(ModBlocks.EULIUM_HANGING_SIGN.get().asItem());
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
