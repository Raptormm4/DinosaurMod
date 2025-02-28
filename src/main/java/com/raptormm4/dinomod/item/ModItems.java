package com.raptormm4.dinomod.item;

import com.raptormm4.dinomod.DinoMod;
import com.raptormm4.dinomod.entity.ModEntities;
import com.raptormm4.dinomod.item.custom.DodoEgg;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DinoMod.MOD_ID);

    public static final RegistryObject<Item> FOSSIL = ITEMS.register("fossil", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMBER = ITEMS.register("amber", () -> new Item(new Item.Properties()));
    public static final RegistryObject<DodoEgg> DODO_EGG = ITEMS.register("dodo_egg", () -> new DodoEgg(new Item.Properties()
            .stacksTo(16)));
    public static final RegistryObject<Item> PLANT_FOSSIL = ITEMS.register("plant_fossil", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SYRINGE = ITEMS.register("syringe", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_DNA = ITEMS.register("raw_dna", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DODO_SPAWN_EGG = ITEMS.register("dodo_spawn_egg", () ->
            new ForgeSpawnEggItem(ModEntities.DODO, 0x9E9E9E, 0x947251, new Item.Properties()));

    public static final RegistryObject<Item> DODO_MEAT = ITEMS.register("dodo_meat",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_DODO_MEAT)));
    public static final RegistryObject<Item> COOKED_DODO_MEAT = ITEMS.register("cooked_dodo_meat",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_DODO_MEAT)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
