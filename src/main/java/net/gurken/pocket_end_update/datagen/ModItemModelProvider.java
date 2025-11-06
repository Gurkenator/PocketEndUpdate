package net.gurken.pocket_end_update.datagen;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.gurken.pocket_end_update.block.ModBlocks;
import net.gurken.pocket_end_update.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PocketEndUpdate.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ENDERFERENCE_CRYSTAL);
        simpleItem(ModItems.ENDERITE_INGOT);
        simpleItem(ModItems.END_CRYSTAL_SHARD);

        buttonItem(ModBlocks.EULIUM_BUTTON, ModBlocks.EULIUM_PLANKS);
        fenceItem(ModBlocks.EULIUM_FENCE, ModBlocks.EULIUM_PLANKS);
        wallItem(ModBlocks.GREENSTONE_WALL, ModBlocks.GREENSTONE);

        simpleBlockItem(ModBlocks.EULIUM_DOOR);

        saplingItem(ModBlocks.EULIUM_TUBER);

        simpleItem(ModItems.EULIUM_SIGN);
        simpleItem(ModItems.EULIUM_HANGING_SIGN);
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PocketEndUpdate.MOD_ID,"block/" + item.getId().getPath()));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(PocketEndUpdate.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(PocketEndUpdate.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(PocketEndUpdate.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PocketEndUpdate.MOD_ID,"item/" + item.getId().getPath()));
    }


    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PocketEndUpdate.MOD_ID,"item/" + item.getId().getPath()));
    }
}
