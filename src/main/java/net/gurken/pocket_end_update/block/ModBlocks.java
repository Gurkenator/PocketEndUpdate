package net.gurken.pocket_end_update.block;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.gurken.pocket_end_update.block.custom.*;
import net.gurken.pocket_end_update.item.ModItems;
import net.gurken.pocket_end_update.util.ModWoodTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
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
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS).mapColor(MapColor.TERRACOTTA_BLUE)));
    public static final RegistryObject<Block> PURPUR_PANEL = registerBlock("purpur_panel",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_BLOCK)));
    public static final RegistryObject<Block> CHORALITE_ACCUMULATION = registerBlock("choralite_accumulation",
            () -> new ChoralitePlantBlock(BlockBehaviour.Properties.copy(Blocks.CHORUS_PLANT).mapColor(MapColor.COLOR_PURPLE).forceSolidOn().lightLevel((p_50892_) -> {
                return 6; })));
    public static final RegistryObject<Block> CHORALITE_GROWTH = registerBlock("choralite_growth",
            () -> new ChoraliteCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).lightLevel((p_50892_) -> {
                return 4; }).randomTicks()));
    public static final RegistryObject<Block> EULIUM_ROOT = registerBlock("eulium_root",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).mapColor(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> EULIUM_NODULE = registerBlock("eulium_nodule",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).mapColor(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> STRIPPED_EULIUM_ROOT = registerBlock("stripped_eulium_root",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> STRIPPED_EULIUM_NODULE = registerBlock("stripped_eulium_nodule",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> EULIUM_PLANKS = registerBlock("eulium_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_MAGENTA)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> EULIUM_FIBERS = registerBlock("eulium_fibers",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> EULIUM_TUBER = registerBlock("eulium_tuber",
            () -> new SaplingBlock(null, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> EULIUM_STAIRS = registerBlock("eulium_stairs",
            () -> new StairBlock(() -> ModBlocks.EULIUM_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.PURPUR_STAIRS).mapColor(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> EULIUM_SLAB = registerBlock("eulium_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).mapColor(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> EULIUM_PRESSURE_PLATE = registerBlock("eulium_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Block> EULIUM_BUTTON = registerBlock("eulium_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).sound(SoundType.WOOD), BlockSetType.OAK, 10, true));

    public static final RegistryObject<Block> EULIUM_DOOR = registerBlock("eulium_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(ModBlocks.EULIUM_PLANKS.get()).noOcclusion(), BlockSetType.BIRCH));
    public static final RegistryObject<Block> EULIUM_TRAPDOOR = registerBlock("eulium_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(ModBlocks.EULIUM_PLANKS.get()).noOcclusion(), BlockSetType.BIRCH));
    public static final RegistryObject<Block> EULIUM_FENCE = registerBlock("eulium_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(ModBlocks.EULIUM_PLANKS.get())));
    public static final RegistryObject<Block> EULIUM_FENCE_GATE = registerBlock("eulium_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(ModBlocks.EULIUM_PLANKS.get()), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> GREENSTONE = registerBlock("greenstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL).mapColor(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> GREENSTONE_WALL = registerBlock("greenstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.GREENSTONE.get())));
    public static final RegistryObject<Block> END_CRYSTAL = registerBlock("end_crystal",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PEARLESCENT_FROGLIGHT).mapColor(MapColor.COLOR_LIGHT_BLUE)));

    public static final RegistryObject<Block> EULIUM_SIGN = BLOCKS.register("eulium_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.EULIUM));
    public static final RegistryObject<Block> EULIUM_WALL_SIGN = BLOCKS.register("eulium_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.EULIUM));

    public static final RegistryObject<Block> EULIUM_HANGING_SIGN = BLOCKS.register("eulium_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.EULIUM));
    public static final RegistryObject<Block> EULIUM_WALL_HANGING_SIGN = BLOCKS.register("eulium_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.EULIUM));

    public static final RegistryObject<Block> DRAGON_LANTERN = registerBlock("dragon_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_LANTERN)));


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
