package com.raptormm4.dinomod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.raptormm4.dinomod.DinoMod;
import com.raptormm4.dinomod.entity.custom.DodoEntity;
import com.raptormm4.dinomod.entity.custom.TriceratopsEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TriceratopsRenderer extends MobRenderer<TriceratopsEntity, TriceratopsModel<TriceratopsEntity>> {
    public TriceratopsRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TriceratopsModel<>(pContext.bakeLayer(TriceratopsModel.LAYER_LOCATION)), 1.5f);
    }

    @Override
    public void render(TriceratopsEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pPoseStack.scale(0.6f, 0.6f, 0.6f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(TriceratopsEntity triceratopsEntity) {
        return ResourceLocation.fromNamespaceAndPath(DinoMod.MOD_ID, "textures/entity/triceratops.png");
    }
}
