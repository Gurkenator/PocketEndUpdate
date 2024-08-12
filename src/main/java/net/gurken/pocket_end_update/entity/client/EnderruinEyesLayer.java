package net.gurken.pocket_end_update.entity.client;

import net.gurken.pocket_end_update.PocketEndUpdate;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EnderruinEyesLayer<T extends LivingEntity> extends EyesLayer<T, EnderruinModel<T>> {
    private static final RenderType ENDERRUIN_EYES = RenderType.eyes(new ResourceLocation(PocketEndUpdate.MOD_ID,"textures/entity/enderruin/enderruin_eyes.png"));

    public EnderruinEyesLayer(RenderLayerParent<T, EnderruinModel<T>> p_116964_) {
        super(p_116964_);
    }

    public RenderType renderType() {
        return ENDERRUIN_EYES;
    }
}
