package net.gurken.pocket_end_update.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;

public class ModFoods extends Foods {

    public static final FoodProperties CHORALITE_KERNEL = (new FoodProperties.Builder()).nutrition(3).saturationMod(1.0F).effect(new MobEffectInstance(MobEffects.LEVITATION, 100, 2), 0.25F).effect(new MobEffectInstance(MobEffects.LEVITATION, 60, 3), 0.25F).effect(new MobEffectInstance(MobEffects.LEVITATION, 200, 1), 0.25F).effect(new MobEffectInstance(MobEffects.LEVITATION, 40, 5), 0.25F).effect(new MobEffectInstance(MobEffects.LEVITATION, 40, 1), 1.0F).alwaysEat().build();
}
