package net.gurken.pocket_end_update.item;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.gurken.pocket_end_update.block.ModBlocks;
import net.gurken.pocket_end_update.entity.ModEntities;
import net.gurken.pocket_end_update.item.custom.EnderiteBowItem;
import net.gurken.pocket_end_update.item.custom.EnderiteCrossbowItem;
import net.gurken.pocket_end_update.item.custom.ModFoods;
import net.gurken.pocket_end_update.item.custom.ModSmithingTemplateItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PocketEndUpdate.MOD_ID);

    public static final RegistryObject<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENDERFERENCE_CRYSTAL = ITEMS.register("enderference_crystal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHORALITE_KERNEL = ITEMS.register("choralite_kernel",
            () -> new Item(new Item.Properties().food(ModFoods.CHORALITE_KERNEL)));
    public static final RegistryObject<Item> CRACKED_CHORALITE_KERNEL = ITEMS.register("cracked_choralite_kernel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<ItemNameBlockItem> CHORALITE_SPORES = ITEMS.register("choralite_spores",
            () -> new ItemNameBlockItem(ModBlocks.CHORALITE_GROWTH.get(), new Item.Properties()));
    public static final RegistryObject<Item> ENDERITE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("enderite_upgrade_smithing_template",
            ModSmithingTemplateItem::createEnderiteUpgradeTemplate);
    public static final RegistryObject<Item> SAIL_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("sail_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(new ResourceLocation("pocket_end_update:sail")));

    public static final RegistryObject<Item> ENDERITE_BOW = ITEMS.register("enderite_bow",
            () -> new EnderiteBowItem(new Item.Properties().durability(768), () -> Ingredient.of(ModItems.ENDERITE_INGOT.get()), 22));

    public static final RegistryObject<Item> ENDERITE_CROSSBOW = ITEMS.register("enderite_crossbow",
            () -> new EnderiteCrossbowItem(new Item.Properties().durability(930), () -> Ingredient.of(ModItems.ENDERITE_INGOT.get()), 22));

    public static final RegistryObject<Item> ENDERRUIN_SPAWN_EGG = ITEMS.register("enderruin_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.ENDERRUIN, 0xeef8bf, 0x54508f,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
