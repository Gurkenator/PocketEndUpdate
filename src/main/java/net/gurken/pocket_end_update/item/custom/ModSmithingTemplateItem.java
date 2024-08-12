package net.gurken.pocket_end_update.item.custom;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ModSmithingTemplateItem extends Item {
    //This class is an altered copy of the SmithingTemplateItem class

    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final String DESCRIPTION_ID = Util.makeDescriptionId("item", new ResourceLocation(PocketEndUpdate.MOD_ID,"smithing_template"));
    private static final Component INGREDIENTS_TITLE = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(PocketEndUpdate.MOD_ID,"smithing_template.ingredients"))).withStyle(TITLE_FORMAT);
    private static final Component APPLIES_TO_TITLE = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(PocketEndUpdate.MOD_ID,"smithing_template.applies_to"))).withStyle(TITLE_FORMAT);
    private static final Component ENDERITE_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation(PocketEndUpdate.MOD_ID,"enderite_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component ENDERITE_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(PocketEndUpdate.MOD_ID,"smithing_template.enderite_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component ENDERITE_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(PocketEndUpdate.MOD_ID,"smithing_template.enderite_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component ENDERITE_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(PocketEndUpdate.MOD_ID,"smithing_template.enderite_upgrade.base_slot_description")));
    private static final Component ENDERITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(PocketEndUpdate.MOD_ID,"smithing_template.enderite_upgrade.additions_slot_description")));
    private static final ResourceLocation EMPTY_SLOT_BOW = new ResourceLocation(PocketEndUpdate.MOD_ID,"item/empty_slot_bow");
    private static final ResourceLocation EMPTY_SLOT_CROSSBOW = new ResourceLocation(PocketEndUpdate.MOD_ID,"item/empty_slot_crossbow");
    private static final ResourceLocation EMPTY_SLOT_INGOT = new ResourceLocation("item/empty_slot_ingot");
    private static final Component ARMOR_TRIM_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.armor_trim.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component ARMOR_TRIM_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.armor_trim.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component ARMOR_TRIM_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.armor_trim.base_slot_description")));
    private static final Component ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.armor_trim.additions_slot_description")));
    private static final ResourceLocation EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_REDSTONE_DUST = new ResourceLocation("item/empty_slot_redstone_dust");
    private static final ResourceLocation EMPTY_SLOT_QUARTZ = new ResourceLocation("item/empty_slot_quartz");
    private static final ResourceLocation EMPTY_SLOT_EMERALD = new ResourceLocation("item/empty_slot_emerald");
    private static final ResourceLocation EMPTY_SLOT_DIAMOND = new ResourceLocation("item/empty_slot_diamond");
    private static final ResourceLocation EMPTY_SLOT_LAPIS_LAZULI = new ResourceLocation("item/empty_slot_lapis_lazuli");
    private static final ResourceLocation EMPTY_SLOT_AMETHYST_SHARD = new ResourceLocation("item/empty_slot_amethyst_shard");
    private final Component appliesTo;
    private final Component ingredients;
    private final Component upgradeDescription;
    private final Component baseSlotDescription;
    private final Component additionsSlotDescription;
    private final List<ResourceLocation> baseSlotEmptyIcons;
    private final List<ResourceLocation> additionalSlotEmptyIcons;

    public ModSmithingTemplateItem(Component pAppliesTo, Component pIngredients, Component pUpdradeDescription, Component pBaseSlotDescription, Component pAdditionsSlotDescription, List<ResourceLocation> pBaseSlotEmptyIcons, List<ResourceLocation> pAdditonalSlotEmptyIcons) {
        super(new Item.Properties());
        this.appliesTo = pAppliesTo;
        this.ingredients = pIngredients;
        this.upgradeDescription = pUpdradeDescription;
        this.baseSlotDescription = pBaseSlotDescription;
        this.additionsSlotDescription = pAdditionsSlotDescription;
        this.baseSlotEmptyIcons = pBaseSlotEmptyIcons;
        this.additionalSlotEmptyIcons = pAdditonalSlotEmptyIcons;
    }

    public static SmithingTemplateItem createEnderiteUpgradeTemplate() {
        return new SmithingTemplateItem(ENDERITE_UPGRADE_APPLIES_TO, ENDERITE_UPGRADE_INGREDIENTS, ENDERITE_UPGRADE, ENDERITE_UPGRADE_BASE_SLOT_DESCRIPTION, ENDERITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createEnderiteUpgradeIconList(), createEnderiteUpgradeMaterialList());
    }

    private static List<ResourceLocation> createEnderiteUpgradeIconList() {
        return List.of(EMPTY_SLOT_BOW, EMPTY_SLOT_CROSSBOW);
    }

    private static List<ResourceLocation> createEnderiteUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }

    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        pTooltipComponents.add(this.upgradeDescription);
        pTooltipComponents.add(CommonComponents.EMPTY);
        pTooltipComponents.add(APPLIES_TO_TITLE);
        pTooltipComponents.add(CommonComponents.space().append(this.appliesTo));
        pTooltipComponents.add(INGREDIENTS_TITLE);
        pTooltipComponents.add(CommonComponents.space().append(this.ingredients));
    }

    public static ModSmithingTemplateItem createArmorTrimTemplate(ResourceKey<TrimPattern> pPatternKey) {
        return createArmorTrimTemplate(pPatternKey.location());
    }

    public static ModSmithingTemplateItem createArmorTrimTemplate(ResourceLocation pLocation) {
        return new ModSmithingTemplateItem(ARMOR_TRIM_APPLIES_TO, ARMOR_TRIM_INGREDIENTS, Component.translatable(Util.makeDescriptionId("trim_pattern", pLocation)).withStyle(TITLE_FORMAT), ARMOR_TRIM_BASE_SLOT_DESCRIPTION, ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION, createTrimmableArmorIconList(), createTrimmableMaterialIconList());
    }

    private static List<ResourceLocation> createTrimmableArmorIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
    }

    private static List<ResourceLocation> createTrimmableMaterialIconList() {
        return List.of(EMPTY_SLOT_INGOT, EMPTY_SLOT_REDSTONE_DUST, EMPTY_SLOT_LAPIS_LAZULI, EMPTY_SLOT_QUARTZ, EMPTY_SLOT_DIAMOND, EMPTY_SLOT_EMERALD, EMPTY_SLOT_AMETHYST_SHARD);
    }

    public Component getBaseSlotDescription() {
        return this.baseSlotDescription;
    }

    public Component getAdditionSlotDescription() {
        return this.additionsSlotDescription;
    }

    public List<ResourceLocation> getBaseSlotEmptyIcons() {
        return this.baseSlotEmptyIcons;
    }

    public List<ResourceLocation> getAdditionalSlotEmptyIcons() {
        return this.additionalSlotEmptyIcons;
    }

    /**
     * Returns the unlocalized name of this item.
     */
    public String getDescriptionId() {
        return DESCRIPTION_ID;
    }
}
