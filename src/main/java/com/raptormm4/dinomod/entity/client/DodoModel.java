package com.raptormm4.dinomod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.raptormm4.dinomod.DinoMod;
import com.raptormm4.dinomod.entity.animations.ModAnimationDefinitions;
import com.raptormm4.dinomod.entity.custom.DodoEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class DodoModel<T extends Entity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(DinoMod.MOD_ID, "dodo_layer"), "main");
	private final ModelPart dodo;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;
	private final ModelPart body;
	private final ModelPart head;

	public DodoModel(ModelPart root) {
		this.dodo = root.getChild("dodo");
		this.rightLeg = this.dodo.getChild("rightLeg");
		this.leftLeg = this.dodo.getChild("leftLeg");
		this.body = this.dodo.getChild("body");
		this.head = this.dodo.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition dodo = partdefinition.addOrReplaceChild("dodo", CubeListBuilder.create(), PartPose.offset(-3.0F, 24.0F, 0.0F));

		PartDefinition rightLeg = dodo.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(3, 4).addBox(0.0F, 0.0F, -2.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 2).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftLeg = dodo.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(1, 4).addBox(0.0F, 0.0F, -2.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 0.0F));

		PartDefinition body = dodo.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 17).addBox(-5.0F, -10.0F, 0.0F, 2.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 17).addBox(0.0F, -10.0F, 0.0F, 2.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(-5.0F, -10.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 34).addBox(0.0F, -10.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 36).addBox(-3.0F, -11.0F, 0.0F, 3.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(29, 57).addBox(-3.0F, -11.0F, -1.0F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 60).addBox(-3.0F, -8.0F, 7.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(19, 17).addBox(-6.0F, -9.75F, 0.5F, 1.0F, 3.5F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(58, 26).addBox(-6.0F, -6.25F, 0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(19, 17).addBox(2.0F, -9.75F, 0.5F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(58, 26).addBox(2.0F, -5.75F, 0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, -3.0F));

		PartDefinition head = dodo.addOrReplaceChild("head", CubeListBuilder.create().texOffs(7, 50).addBox(-4.0F, -15.0F, -3.0F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(49, 53).addBox(-3.0F, -14.5F, -6.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(27, 17).addBox(-3.0F, -12.5F, -4.25F, 3.0F, 1.0F, 1.25F, new CubeDeformation(0.0F))
				.texOffs(8, 8).addBox(-2.75F, -14.0F, -7.5F, 2.5F, 1.5F, 1.5F, new CubeDeformation(0.0F))
				.texOffs(53, 1).addBox(-3.0F, -10.0F, -3.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, -3.0F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(31, 4).addBox(-7.875F, -0.75F, 3.525F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(31, 4).addBox(-7.875F, -0.75F, 0.475F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -13.5F, -11.025F, 0.0F, 1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		dodo.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return dodo;
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.DODO_WALK, limbSwing, limbSwingAmount, 3.5f, 2.5f);
		this.animate(((DodoEntity) entity).idleAnimationState, ModAnimationDefinitions.DODO_IDLE, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -15.0F, 15.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -10.0F, 30.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}
}