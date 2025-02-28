package com.raptormm4.dinomod.worldgen;

import com.raptormm4.dinomod.DinoMod;
import com.raptormm4.dinomod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?,?>> FOSSIL_ORE_KEY = registerKey("fossil_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> CARBON_FOSSIL_KEY = registerKey("carbon_fossil");
    public static final ResourceKey<ConfiguredFeature<?,?>> AMBER_STONE_KEY = registerKey("amber_stone");
    public static final ResourceKey<ConfiguredFeature<?,?>> JUNGLE_AMBER_STONE_KEY = registerKey("jungle_amber_stone");

    public static void boostrap(BootstapContext<ConfiguredFeature<?,?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> fossilOres = List.of(OreConfiguration.target(
                stoneReplaceable, ModBlocks.FOSSIL_ORE.get().defaultBlockState()));

        register(context, FOSSIL_ORE_KEY, Feature.ORE, new OreConfiguration(fossilOres, 6));
        register(context, CARBON_FOSSIL_KEY, Feature.ORE, new OreConfiguration(stoneReplaceable
                , ModBlocks.CARBON_FOSSIL.get().defaultBlockState(), 5));
        register(context, AMBER_STONE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceable,
                ModBlocks.AMBER_STONE.get().defaultBlockState(), 3));
        register(context, JUNGLE_AMBER_STONE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceable,
                ModBlocks.AMBER_STONE.get().defaultBlockState(), 4));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(DinoMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?,?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
