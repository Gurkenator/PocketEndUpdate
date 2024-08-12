package net.gurken.pocket_end_update.item.custom;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, PocketEndUpdate.MOD_ID);

    public static final RegistryObject<Potion> LEVITATION = POTIONS.register("levitation", () -> new Potion("levitation", new MobEffectInstance(MobEffects.LEVITATION, 200)));
    public static final RegistryObject<Potion> LEVITATION_LONG = POTIONS.register("levitation_long", () -> new Potion("levitation_long", new MobEffectInstance(MobEffects.LEVITATION, 400)));
    public static final RegistryObject<Potion> LEVITATION_STRONG = POTIONS.register("levitation_strong", () -> new Potion("levitation_strong", new MobEffectInstance(MobEffects.LEVITATION, 100, 1)));

    private static RegistryObject<Potion> register(String name, Supplier<Potion> potion) {
        return POTIONS.register(name, potion);
    }
}
