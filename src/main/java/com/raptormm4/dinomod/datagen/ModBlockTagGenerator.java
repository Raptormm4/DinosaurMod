package com.raptormm4.dinomod.datagen;

import com.raptormm4.dinomod.DinoMod;
import com.raptormm4.dinomod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DinoMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(Tags.Blocks.ORES)
                .add(ModBlocks.FOSSIL_ORE.get())
                .add(ModBlocks.CARBON_FOSSIL.get())
                .add(ModBlocks.AMBER_STONE.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.FOSSIL_ORE.get())
                .add(ModBlocks.AMBER_STONE.get())
                .add(ModBlocks.AMBER_BLOCK.get())
                .add(ModBlocks.CARBON_FOSSIL.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.FOSSIL_ORE.get())
                .add(ModBlocks.CARBON_FOSSIL.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.AMBER_STONE.get())
                .add(ModBlocks.AMBER_BLOCK.get());
    }
}
