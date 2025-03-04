package com.raptormm4.dinomod.item;

import com.raptormm4.dinomod.DinoMod;
import com.raptormm4.dinomod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DinoMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DINO_TAB = CREATIVE_MODE_TABS.register("dino_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FOSSIL.get()))
                    .title(Component.translatable("creativetab.dino_tab"))
                    .displayItems((pParamenters, pOutput) -> {
                        pOutput.accept(ModItems.FOSSIL.get());
                        pOutput.accept(ModItems.PLANT_FOSSIL.get());
                        pOutput.accept(ModItems.AMBER.get());
                        pOutput.accept(ModItems.DODO_EGG.get());
                        pOutput.accept(ModItems.RAW_DNA.get());
                        pOutput.accept(ModItems.SYRINGE.get());
                        pOutput.accept(ModItems.DODO_SPAWN_EGG.get());
                        pOutput.accept(ModItems.DODO_MEAT.get());
                        pOutput.accept(ModItems.COOKED_DODO_MEAT.get());
                        pOutput.accept(ModItems.TRIKE_SPAWN_EGG.get());
                        pOutput.accept(ModItems.BRACHIOSAURUS_SPAWN_EGG.get());

                        pOutput.accept(ModBlocks.FOSSIL_ORE.get());
                        pOutput.accept(ModBlocks.CARBON_FOSSIL.get());
                        pOutput.accept(ModBlocks.AMBER_BLOCK.get());
                        pOutput.accept(ModBlocks.AMBER_STONE.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
