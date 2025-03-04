package com.raptormm4.dinomod.entity;

import com.raptormm4.dinomod.DinoMod;
import com.raptormm4.dinomod.entity.custom.BrachiosaurusEntity;
import com.raptormm4.dinomod.entity.custom.DodoEntity;
import com.raptormm4.dinomod.entity.custom.TriceratopsEntity;
import com.raptormm4.dinomod.entity.projectile.ThrownDodoEgg;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DinoMod.MOD_ID);

    public static final RegistryObject<EntityType<DodoEntity>> DODO = ENTITY_TYPES.register("dodo",
            () -> EntityType.Builder.of(DodoEntity::new, MobCategory.CREATURE)
                    .sized(0.8f, 0.8f).build("dodo"));
    public static final RegistryObject<EntityType<TriceratopsEntity>> TRICERATOPS = ENTITY_TYPES.register("triceratops",
            () -> EntityType.Builder.of(TriceratopsEntity::new, MobCategory.CREATURE)
                    .sized(2f,1f).build("triceratops"));
    public static final RegistryObject<EntityType<BrachiosaurusEntity>> BRACHIOSAURUS = ENTITY_TYPES.register("brachiosaurus",
            () -> EntityType.Builder.of(BrachiosaurusEntity::new, MobCategory.CREATURE)
                    .sized(2f,5f).build("brachiosaurus"));

    public static final RegistryObject<EntityType<ThrownDodoEgg>> THROWN_DODO_EGG =
            ENTITY_TYPES.register("thrown_dodo_egg", () -> EntityType.Builder.<ThrownDodoEgg>of(ThrownDodoEgg::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("thrown_dodo_egg"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
