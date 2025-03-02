package com.raptormm4.dinomod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.raptormm4.dinomod.DinoMod;
import com.raptormm4.dinomod.entity.animations.ModAnimationDefinitions;
import com.raptormm4.dinomod.entity.custom.DodoEntity;
import com.raptormm4.dinomod.entity.custom.TriceratopsEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import javax.swing.text.html.parser.Entity;

public class TriceratopsModel<T extends net.minecraft.world.entity.Entity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(DinoMod.MOD_ID, "triceratops"), "main");
    private final ModelPart triceratops;
    private final ModelPart hinds;
    private final ModelPart body;
    private final ModelPart RR_leg;
    private final ModelPart RL_leg;
    private final ModelPart FR_leg;
    private final ModelPart FL_leg;
    private final ModelPart tail;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart mouth;

    public TriceratopsModel(ModelPart root) {
        this.triceratops = root.getChild("triceratops");
        this.hinds = this.triceratops.getChild("hinds");
        this.body = this.triceratops.getChild("body");
        this.RR_leg = this.triceratops.getChild("RR_leg");
        this.RL_leg = this.triceratops.getChild("RL_leg");
        this.FR_leg = this.triceratops.getChild("FR_leg");
        this.FL_leg = this.triceratops.getChild("FL_leg");
        this.tail = this.triceratops.getChild("tail");
        this.neck = this.triceratops.getChild("neck");
        this.head = this.triceratops.getChild("head");
        this.mouth = this.head.getChild("mouth");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition triceratops = partdefinition.addOrReplaceChild("triceratops", CubeListBuilder.create(), PartPose.offset(-9.0F, 17.0F, -8.0F));

        PartDefinition hinds = triceratops.addOrReplaceChild("hinds", CubeListBuilder.create().texOffs(46, 87).addBox(17.0F, -4.0F, -1.0F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 76).addBox(17.0F, -7.0F, 11.0F, 2.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(76, 48).addBox(-1.0F, -7.0F, 11.0F, 2.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(32, 87).addBox(0.0F, -4.0F, -1.0F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = triceratops.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, 2.0F, -1.0F, 16.0F, 10.0F, 23.0F, new CubeDeformation(0.0F))
                .texOffs(0, 33).addBox(-9.0F, 1.0F, -1.0F, 10.0F, 1.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(13.0F, -11.0F, -1.0F));

        PartDefinition RR_leg = triceratops.addOrReplaceChild("RR_leg", CubeListBuilder.create().texOffs(78, 12).addBox(-19.0F, -9.0F, -1.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(18.0F, 7.0F, 16.0F));

        PartDefinition RL_leg = triceratops.addOrReplaceChild("RL_leg", CubeListBuilder.create().texOffs(20, 76).addBox(-2.0F, -9.0F, -1.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(18.0F, 7.0F, 16.0F));

        PartDefinition FR_leg = triceratops.addOrReplaceChild("FR_leg", CubeListBuilder.create().texOffs(72, 87).addBox(-2.0F, -8.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 7.0F, 1.0F));

        PartDefinition FL_leg = triceratops.addOrReplaceChild("FL_leg", CubeListBuilder.create().texOffs(60, 87).addBox(-2.0F, -8.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(17.0F, 7.0F, 1.0F));

        PartDefinition tail = triceratops.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(10.0F, 3.0F, 34.0F));

        PartDefinition cube_r1 = tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(78, 6).addBox(-4.0F, -1.9F, -1.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r2 = tail.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(66, 33).addBox(-3.0F, -1.9F, -1.0F, 6.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -6.0F, -9.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r3 = tail.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(38, 74).addBox(-4.0F, -6.0F, -1.0F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.0F, -14.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition neck = triceratops.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(9.0F, -2.0F, -2.0F));

        PartDefinition cube_r4 = neck.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(68, 74).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition head = triceratops.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(9.0F, -9.0F, -5.0F));

        PartDefinition cube_r5 = head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(38, 57).addBox(-9.0F, -9.0F, -0.1F, 18.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r6 = head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(84, 87).addBox(-0.5F, -12.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 88).addBox(4.5F, -12.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, -3.0F, 0.9163F, 0.0F, 0.0F));

        PartDefinition cube_r7 = head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(66, 48).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -11.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r8 = head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(76, 63).addBox(-3.0F, -3.0F, -1.75F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, -11.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r9 = head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 57).addBox(-5.0F, -9.0F, -6.75F, 10.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -1.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create(), PartPose.offset(0.0F, 9.0F, -10.0F));

        PartDefinition cube_r10 = mouth.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(78, 0).addBox(-3.0F, -2.0F, -2.5F, 6.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        triceratops.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return triceratops;
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -15.0F, 15.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -10.0F, 30.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.animateWalk(ModAnimationDefinitions.TRICERATOPS_WALKING, limbSwing, limbSwingAmount, 3.5f, 2.5f);
        this.animate(((TriceratopsEntity) entity).idleAnimationState, ModAnimationDefinitions.TRICERATOPS_IDLE, ageInTicks, 1f);
    }
}