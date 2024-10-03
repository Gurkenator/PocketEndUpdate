package net.gurken.pocket_end_update.worldgen;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ModBiomeTags {
    public static final TagKey<Biome> IS_OUTER_END = create("is_outer_end");
    public static final TagKey<Biome> IS_OUTER_ISLAND = create("is_outer_island");

    private ModBiomeTags() {
    }

    private static TagKey<Biome> create(String pName) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(PocketEndUpdate.MOD_ID, pName));
    }
}
