package com.raptormm4.dinomod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.raptormm4.dinomod.DinoMod;
import com.raptormm4.dinomod.entity.custom.DodoEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.swing.text.html.parser.Entity;

public class DodoRenderer extends MobRenderer<DodoEntity, DodoModel<DodoEntity>> {
    public DodoRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DodoModel<>(pContext.bakeLayer(DodoModel.LAYER_LOCATION)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(DodoEntity dodoEntity) {
        return ResourceLocation.fromNamespaceAndPath(DinoMod.MOD_ID, "textures/entity/dodo.png");
    }

    @Override
    public void render(DodoEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
