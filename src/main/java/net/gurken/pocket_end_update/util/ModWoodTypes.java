package net.gurken.pocket_end_update.util;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType EULIUM = WoodType.register(new WoodType(PocketEndUpdate.MOD_ID + ":eulium", BlockSetType.OAK));
}
