package net.gurken.pocket_end_update.block;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.gurken.pocket_end_update.block.custom.ChoraliteCropBlock;
import net.gurken.pocket_end_update.block.custom.ChoralitePlantBlock;
import net.gurken.pocket_end_update.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PocketEndUpdate.MOD_ID);

    public static final RegistryObject<Block> ENDERITE_BLOCK = registerBlock("enderite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).mapColor(MapColor.SAND)));
    public static final RegistryObject<Block> END_CRYSTAL_ORE = registerBlock("end_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS).mapColor(MapColor.SAND), UniformInt.of(12, 16)));
    public static final RegistryObject<Block> PURPUR_PANEL = registerBlock("purpur_panel",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_BLOCK)));
    public static final RegistryObject<Block> CHORALITE_ACCUMULATION = registerBlock("choralite_accumulation",
            () -> new ChoralitePlantBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).mapColor(MapColor.COLOR_PURPLE).offsetType(BlockBehaviour.OffsetType.XZ).forceSolidOn().lightLevel((p_50892_) -> {
                return 3; })));
    public static final RegistryObject<Block> CHORALITE_GROWTH = registerBlock("choralite_growth",
            () -> new ChoraliteCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).lightLevel((p_50892_) -> {
                return 5; }).randomTicks()));

    public static final RegistryObject<Block> INDIGO_BLOCK = registerBlock("indigo_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_BLOCK).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> INDIGO_PILLAR = registerBlock("indigo_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> INDIGO_PANEL = registerBlock("indigo_panel",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_BLOCK).mapColor(MapColor.COLOR_LIGHT_BLUE)));

    public static final RegistryObject<Block> INDIGO_STAIRS = registerBlock("indigo_stairs",
            () -> new StairBlock(() -> ModBlocks.INDIGO_BLOCK.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.PURPUR_STAIRS).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> INDIGO_SLAB = registerBlock("indigo_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_SLAB).mapColor(MapColor.COLOR_LIGHT_BLUE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
