package net.gurken.pocket_end_update.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.gurken.pocket_end_update.entity.animations.ModAnimationDefinitions;
import net.gurken.pocket_end_update.entity.custom.EnderruinEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class EnderruinModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart enderruin;
	private final ModelPart head;

	public EnderruinModel(ModelPart root) {

		this.enderruin = root.getChild("enderruin");
		this.head = enderruin.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition enderruin = partdefinition.addOrReplaceChild("enderruin", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 8.0F));

		PartDefinition rightarm = enderruin.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(32, 28).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -19.0F, -11.0F));

		PartDefinition leftarm = enderruin.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(24, 28).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -19.0F, -11.0F));

		PartDefinition body = enderruin.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -7.0F, 3.0F, 8.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -11.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightleg = enderruin.addOrReplaceChild("rightleg", CubeListBuilder.create(), PartPose.offset(-5.0F, -9.8076F, -1.7218F));

		PartDefinition lower_r1 = rightleg.addOrReplaceChild("lower_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.5858F, -2.9142F, 0.7854F, 0.0F, 0.0F));

		PartDefinition upper_right = rightleg.addOrReplaceChild("upper_right", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0503F, -0.2071F));

		PartDefinition upper_r1 = upper_right.addOrReplaceChild("upper_r1", CubeListBuilder.create().texOffs(24, 18).addBox(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.8284F, 0.8284F, 0.7854F, 0.0F, 0.0F));

		PartDefinition leftleg = enderruin.addOrReplaceChild("leftleg", CubeListBuilder.create(), PartPose.offset(5.0F, -9.8076F, -1.9718F));

		PartDefinition lower_r2 = leftleg.addOrReplaceChild("lower_r2", CubeListBuilder.create().texOffs(0, 36).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.2929F, -3.3713F, -0.7854F, 0.0F, 0.0F));

		PartDefinition upper_left = leftleg.addOrReplaceChild("upper_left", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0503F, 0.0429F));

		PartDefinition upper_r2 = upper_left.addOrReplaceChild("upper_r2", CubeListBuilder.create().texOffs(24, 8).addBox(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.8284F, 0.8284F, 0.7854F, 0.0F, 0.0F));

		PartDefinition head = enderruin.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, -12.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 2.4541F, -0.7678F));

		PartDefinition cube_r2 = jaw.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(24, 0).addBox(-2.0F, -1.1F, -3.5F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.3536F, 0.3536F, 0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.ENDERRUIN_WALK, limbSwing, limbSwingAmount, 0.5f, 1.0f);
		this.animate(((EnderruinEntity) entity).idleAnimationState, ModAnimationDefinitions.ENDERRUIN_IDLE, ageInTicks, 1f);
		this.animate(((EnderruinEntity) entity).attackAnimationState, ModAnimationDefinitions.ENDERRUIN_ATTACK, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		enderruin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return enderruin;
	}
}