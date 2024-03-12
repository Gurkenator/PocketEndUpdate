package net.gurken.impactful_end.item;

import net.gurken.impactful_end.Impactful_End;
import net.gurken.impactful_end.item.custom.EnderiteBowItem;
import net.gurken.impactful_end.item.custom.EnderiteCrossbowItem;
import net.gurken.impactful_end.item.custom.ModSmithingTemplateItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Impactful_End.MOD_ID);

    public static final RegistryObject<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENDERFERENCE_CRYSTAL = ITEMS.register("enderference_crystal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENDERITE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("enderite_upgrade_smithing_template",
            ModSmithingTemplateItem::createEnderiteUpgradeTemplate);
    public static final RegistryObject<Item> SAIL_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("sail_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(new ResourceLocation("impactful_end:sail")));

    public static final RegistryObject<Item> ENDERITE_BOW = ITEMS.register("enderite_bow",
            () -> new EnderiteBowItem(new Item.Properties().durability(768), () -> Ingredient.of(ModItems.ENDERITE_INGOT.get()), 22));

    public static final RegistryObject<Item> ENDERITE_CROSSBOW = ITEMS.register("enderite_crossbow",
            () -> new EnderiteCrossbowItem(new Item.Properties().durability(930), () -> Ingredient.of(ModItems.ENDERITE_INGOT.get()), 22));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
