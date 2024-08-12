package net.gurken.pocket_end_update.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.gurken.pocket_end_update.PocketEndUpdate;
import net.gurken.pocket_end_update.entity.custom.EnderruinEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EnderruinRenderer extends MobRenderer<EnderruinEntity, EnderruinModel<EnderruinEntity>> {
    public EnderruinRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new EnderruinModel<>(pContext.bakeLayer(ModModelLayers.ENDERRUIN_LAYER)), 1f);
        this.addLayer(new EnderruinEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EnderruinEntity pEntity) {
        return new ResourceLocation(PocketEndUpdate.MOD_ID, "textures/entity/enderruin/enderruin.png");
    }

    @Override
    public void render(EnderruinEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
