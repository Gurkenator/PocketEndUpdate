package net.gurken.pocket_end_update.datagen;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.gurken.pocket_end_update.block.ModBlocks;
import net.gurken.pocket_end_update.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    //private static final List<ItemLike> ALEXANDRITE_SMELTABLES = List.of(ModItems.RAW_ALEXANDRITE.get(),
    //        ModBlocks.ALEXANDRITE_ORE.get(), ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(), ModBlocks.NETHER_ALEXANDRITE_ORE.get(),
    //        ModBlocks.END_STONE_ALEXANDRITE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENDERITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ENDERITE_INGOT.get())
                .unlockedBy("has_enderite_ingot", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ENDERITE_INGOT.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ENDERITE_INGOT.get(), 9)
                .requires(ModBlocks.ENDERITE_BLOCK.get())
                .unlockedBy("has_enderite_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.ENDERITE_BLOCK.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_CRYSTAL.get())
                .pattern("ABA")
                .pattern("BBB")
                .pattern("ABA")
                .define('A', ModItems.CRACKED_CHORALITE_KERNEL.get())
                .define('B', ModItems.END_CRYSTAL_SHARD.get())
                .unlockedBy("has_end_crystal_shard", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.END_CRYSTAL_SHARD.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EULIUM_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.EULIUM_PLANKS.get())
                .unlockedBy("has_eulium_planks", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.EULIUM_PLANKS.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EULIUM_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.EULIUM_PLANKS.get())
                .unlockedBy("has_eulium_planks", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.EULIUM_PLANKS.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EULIUM_NODULE.get(),3)
                .pattern("AA ")
                .pattern("AA ")
                .define('A', ModBlocks.EULIUM_ROOT.get())
                .unlockedBy("has_eulium_root", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.EULIUM_ROOT.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_EULIUM_NODULE.get(),3)
                .pattern("AA ")
                .pattern("AA ")
                .define('A', ModBlocks.STRIPPED_EULIUM_ROOT.get())
                .unlockedBy("has_stripped_eulium_root", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.STRIPPED_EULIUM_ROOT.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.EULIUM_PRESSURE_PLATE.get())
                .pattern("AA")
                .define('A', ModBlocks.EULIUM_PLANKS.get())
                .unlockedBy("has_eulium_planks", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.EULIUM_PLANKS.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.EULIUM_BUTTON.get(), 1)
                .requires(ModBlocks.EULIUM_PLANKS.get())
                .unlockedBy("has_eulium_planks", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.EULIUM_PLANKS.get()).build()))
                .save(pWriter);

        //nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.RAW_ALEXANDRITE.get(), RecipeCategory.MISC, ModBlocks.RAW_ALEXANDRITE_BLOCK.get(),
        //        "mccourse:raw_alexandrite", "alexandrite","mccourse:raw_alexandrite_block", "alexandrite");
        //oreSmelting(pWriter, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 200, "alexandrite");
        //oreBlasting(pWriter, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 100, "alexandrite");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INDIGO_BLOCK.get())
                .pattern("AA")
                .pattern("AA")
                .define('A', ModItems.CRACKED_CHORALITE_KERNEL.get())
                .unlockedBy("has_cracked_choralite_kernel", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.CRACKED_CHORALITE_KERNEL.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INDIGO_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.INDIGO_BLOCK.get())
                .unlockedBy("has_indigo_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.INDIGO_BLOCK.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INDIGO_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.INDIGO_BLOCK.get())
                .unlockedBy("has_indigo_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.INDIGO_BLOCK.get()).build()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                            pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, PocketEndUpdate.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

}
