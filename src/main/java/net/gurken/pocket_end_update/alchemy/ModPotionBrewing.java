package net.gurken.pocket_end_update.alchemy;

import com.google.common.collect.Lists;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class ModPotionBrewing extends PotionBrewing {
    private static final List<Mix<Potion>> POTION_MIXES = Lists.newArrayList();

    public static void addMix(Potion pPotionEntry, Item pPotionIngredient, Potion pPotionResult) {
        POTION_MIXES.add(new PotionBrewing.Mix<>(net.minecraftforge.registries.ForgeRegistries.POTIONS, pPotionEntry, Ingredient.of(pPotionIngredient), pPotionResult));
    }
}
