package com.raptormm4.dinomod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.raptormm4.dinomod.DinoMod;
import com.raptormm4.dinomod.entity.animations.ModAnimationDefinitions;
import com.raptormm4.dinomod.entity.custom.TriceratopsEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class BrachiosaurusModel<T extends net.minecraft.world.entity.Entity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(DinoMod.MOD_ID, "brachiosaurus"), "main");
    private final ModelPart Brachiosaurus;
    private final ModelPart RR;
    private final ModelPart RL;
    private final ModelPart FL;
    private final ModelPart FR;
    private final ModelPart Tail;
    private final ModelPart Head;

    public BrachiosaurusModel(ModelPart root) {
        this.Brachiosaurus = root.getChild("Brachiosaurus");
        this.RR = this.Brachiosaurus.getChild("RR");
        this.RL = this.Brachiosaurus.getChild("RL");
        this.FL = this.Brachiosaurus.getChild("FL");
        this.FR = this.Brachiosaurus.getChild("FR");
        this.Tail = this.Brachiosaurus.getChild("Tail");
        this.Head = this.Brachiosaurus.getChild("Head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Brachiosaurus = partdefinition.addOrReplaceChild("Brachiosaurus", CubeListBuilder.create().texOffs(0, 46).addBox(-10.0F, 31.75F, 17.0F, 20.0F, 17.0F, 24.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-9.0F, 48.75F, 17.0F, 18.0F, 2.0F, 44.0F, new CubeDeformation(0.0F))
                .texOffs(0, 87).addBox(-10.0F, 35.75F, 41.0F, 20.0F, 13.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(124, 0).addBox(10.0F, 36.75F, 18.0F, 3.0F, 11.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(146, 92).addBox(10.0F, 40.75F, 50.0F, 3.0F, 7.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(136, 118).addBox(-13.0F, 36.75F, 18.0F, 3.0F, 11.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(146, 143).addBox(-13.0F, 40.75F, 50.0F, 3.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -53.75F, -39.0F));

        PartDefinition cube_r1 = Brachiosaurus.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(146, 72).addBox(-4.0F, -14.0F, -5.5F, 8.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 17.5F, 8.25F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r2 = Brachiosaurus.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(114, 143).addBox(-5.0F, -12.0F, -5.0F, 10.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 32.75F, 20.0F, 0.829F, 0.0F, 0.0F));

        PartDefinition cube_r3 = Brachiosaurus.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(82, 143).addBox(-5.0F, -12.0F, -5.0F, 10.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 27.0F, 13.0F, 0.48F, 0.0F, 0.0F));

        PartDefinition RR = Brachiosaurus.addOrReplaceChild("RR", CubeListBuilder.create().texOffs(66, 143).addBox(-1.0F, -33.0F, 4.0F, 3.0F, 33.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(88, 79).addBox(-1.0F, -3.0F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, 77.75F, 50.0F));

        PartDefinition RL = Brachiosaurus.addOrReplaceChild("RL", CubeListBuilder.create().texOffs(88, 72).addBox(-1.0F, -3.0F, -5.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(18, 140).addBox(-1.0F, -33.0F, -1.0F, 3.0F, 33.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 77.75F, 55.0F));

        PartDefinition FL = Brachiosaurus.addOrReplaceChild("FL", CubeListBuilder.create().texOffs(48, 120).addBox(-1.0F, -33.0F, -1.0F, 3.0F, 33.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 77.75F, 20.0F));

        PartDefinition FR = Brachiosaurus.addOrReplaceChild("FR", CubeListBuilder.create().texOffs(0, 140).addBox(-1.0F, -33.0F, -1.0F, 3.0F, 33.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, 77.75F, 20.0F));

        PartDefinition Tail = Brachiosaurus.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, 59.75F, 95.0F));

        PartDefinition cube_r4 = Tail.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 120).addBox(-4.0F, -1.0F, -1.0F, 8.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r5 = Tail.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(88, 46).addBox(-5.0F, -2.0F, -1.0F, 10.0F, 6.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, -17.0F, -0.48F, 0.0F, 0.0F));

        PartDefinition cube_r6 = Tail.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(80, 87).addBox(-6.0F, -4.0F, -1.0F, 12.0F, 10.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -19.0F, -35.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition Head = Brachiosaurus.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(80, 118).addBox(-4.0F, 0.0F, -12.0F, 8.0F, 5.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(124, 25).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Brachiosaurus.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return Brachiosaurus;
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -15.0F, 15.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -10.0F, 30.0F);

        this.Head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.Head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.animateWalk(ModAnimationDefinitions.BRACHIOSAURUS_WALK, limbSwing, limbSwingAmount, 2.5f, 2.5f);
        this.animate(((TriceratopsEntity) entity).idleAnimationState, ModAnimationDefinitions.BRACHIOSAURUS_IDLE, ageInTicks, 1f);
    }
}
