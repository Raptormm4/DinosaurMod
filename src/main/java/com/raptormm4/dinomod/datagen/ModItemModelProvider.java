package com.raptormm4.dinomod.datagen;

import com.raptormm4.dinomod.DinoMod;
import com.raptormm4.dinomod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DinoMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.FOSSIL.get());
        basicItem(ModItems.AMBER.get());
        basicItem(ModItems.DODO_EGG.get());
        basicItem(ModItems.PLANT_FOSSIL.get());
        basicItem(ModItems.RAW_DNA.get());
        basicItem(ModItems.SYRINGE.get());
        basicItem(ModItems.DODO_MEAT.get());
        basicItem(ModItems.COOKED_DODO_MEAT.get());

        withExistingParent(ModItems.DODO_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
