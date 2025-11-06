package net.gurken.pocket_end_update.datagen;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.gurken.pocket_end_update.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PocketEndUpdate.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ENDERITE_BLOCK);
        blockWithItem(ModBlocks.EULIUM_PLANKS);
        stairsBlock((StairBlock) ModBlocks.EULIUM_STAIRS.get(), blockTexture(ModBlocks.EULIUM_PLANKS.get()));
        slabBlock((SlabBlock) ModBlocks.EULIUM_SLAB.get(), blockTexture(ModBlocks.EULIUM_PLANKS.get()), blockTexture(ModBlocks.EULIUM_PLANKS.get()));
        blockItem(ModBlocks.EULIUM_STAIRS);
        blockItem(ModBlocks.EULIUM_SLAB);
        logBlock(((RotatedPillarBlock) ModBlocks.EULIUM_ROOT.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.EULIUM_NODULE.get()), blockTexture(ModBlocks.EULIUM_ROOT.get()), blockTexture(ModBlocks.EULIUM_ROOT.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_EULIUM_ROOT.get(), new ResourceLocation(PocketEndUpdate.MOD_ID, "block/stripped_eulium_root"),
                new ResourceLocation(PocketEndUpdate.MOD_ID, "block/stripped_eulium_root_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_EULIUM_NODULE.get(), new ResourceLocation(PocketEndUpdate.MOD_ID, "block/stripped_eulium_root"),
                new ResourceLocation(PocketEndUpdate.MOD_ID, "block/stripped_eulium_root"));

        fenceBlock((FenceBlock) ModBlocks.EULIUM_FENCE.get(), blockTexture(ModBlocks.EULIUM_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.EULIUM_FENCE_GATE.get(), blockTexture(ModBlocks.EULIUM_PLANKS.get()));
        wallBlock((WallBlock) ModBlocks.GREENSTONE_WALL.get(), blockTexture(ModBlocks.GREENSTONE.get()));

        doorBlockWithRenderType((DoorBlock)ModBlocks.EULIUM_DOOR.get(), modLoc("block/eulium_door_bottom"), modLoc("block/eulium_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.EULIUM_TRAPDOOR.get(), modLoc("block/eulium_trapdoor"), true, "cutout");

        blockItem(ModBlocks.EULIUM_FENCE_GATE);
        blockItem(ModBlocks.EULIUM_TRAPDOOR, "_bottom");

        blockItem(ModBlocks.EULIUM_ROOT);
        blockItem(ModBlocks.EULIUM_NODULE);
        blockItem(ModBlocks.STRIPPED_EULIUM_ROOT);
        blockItem(ModBlocks.STRIPPED_EULIUM_NODULE);

        blockWithItem(ModBlocks.INDIGO_BLOCK);
        blockWithItem(ModBlocks.INDIGO_PANEL);
        axisBlock((RotatedPillarBlock) ModBlocks.INDIGO_PILLAR.get(), new ResourceLocation(PocketEndUpdate.MOD_ID, "block/indigo_pillar"),
                new ResourceLocation(PocketEndUpdate.MOD_ID, "block/indigo_pillar_top"));
        blockItem(ModBlocks.INDIGO_PILLAR);
        blockWithItem(ModBlocks.PURPUR_PANEL);
        blockWithItem(ModBlocks.GREENSTONE);
        blockWithItem(ModBlocks.END_CRYSTAL_ORE);

        stairsBlock((StairBlock) ModBlocks.INDIGO_STAIRS.get(), blockTexture(ModBlocks.INDIGO_BLOCK.get()));
        slabBlock((SlabBlock) ModBlocks.INDIGO_SLAB.get(), blockTexture(ModBlocks.INDIGO_BLOCK.get()), blockTexture(ModBlocks.INDIGO_BLOCK.get()));

        buttonBlock((ButtonBlock) ModBlocks.EULIUM_BUTTON.get(), blockTexture(ModBlocks.EULIUM_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.EULIUM_PRESSURE_PLATE.get(), blockTexture(ModBlocks.EULIUM_PLANKS.get()));

        blockItem(ModBlocks.EULIUM_PRESSURE_PLATE);
        blockItem(ModBlocks.INDIGO_STAIRS);
        blockItem(ModBlocks.INDIGO_SLAB);

        leavesBlock(ModBlocks.EULIUM_FIBERS);
        saplingBlock(ModBlocks.EULIUM_TUBER);

        signBlock(((StandingSignBlock) ModBlocks.EULIUM_SIGN.get()), ((WallSignBlock) ModBlocks.EULIUM_WALL_SIGN.get()),
                blockTexture(ModBlocks.EULIUM_PLANKS.get()));

        hangingSignBlock(ModBlocks.EULIUM_HANGING_SIGN.get(), ModBlocks.EULIUM_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.EULIUM_PLANKS.get()));

    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cubeAll(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("pocket_end_update:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("pocket_end_update:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
