package com.raptormm4.dinomod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.raptormm4.dinomod.DinoMod;
import com.raptormm4.dinomod.entity.custom.BrachiosaurusEntity;
import com.raptormm4.dinomod.entity.custom.TriceratopsEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BrachiosaurusRenderer extends MobRenderer<BrachiosaurusEntity, BrachiosaurusModel<BrachiosaurusEntity>> {

    public BrachiosaurusRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BrachiosaurusModel<>(pContext.bakeLayer(BrachiosaurusModel.LAYER_LOCATION)), 2f);
    }

    @Override
    public void render(BrachiosaurusEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pPoseStack.scale(0.3f, 0.3f, 0.3f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(BrachiosaurusEntity brachiosaurusEntity) {
        return ResourceLocation.fromNamespaceAndPath(DinoMod.MOD_ID, "textures/entity/brachiosaurus.png");
    }
}
