package com.raptormm4.dinomod.event;

import com.raptormm4.dinomod.DinoMod;
import com.raptormm4.dinomod.entity.ModEntities;
import com.raptormm4.dinomod.entity.client.DodoModel;
import com.raptormm4.dinomod.entity.client.TriceratopsModel;
import com.raptormm4.dinomod.entity.custom.DodoEntity;
import com.raptormm4.dinomod.entity.custom.TriceratopsEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DinoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DodoModel.LAYER_LOCATION, DodoModel::createBodyLayer);
        event.registerLayerDefinition(TriceratopsModel.LAYER_LOCATION, TriceratopsModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.DODO.get(), DodoEntity.createAttributes().build());
        event.put(ModEntities.TRICERATOPS.get(), TriceratopsEntity.createAttributes().build());
    }

}
