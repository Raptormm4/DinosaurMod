package com.raptormm4.dinomod.worldgen;

import com.raptormm4.dinomod.DinoMod;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> FOSSIL_ORE_PLACED_KEY = registerKey("fossil_ore_placed");
    public static final ResourceKey<PlacedFeature> CARBON_FOSSIL_PLACED_KEY = registerKey("carbon_fossil_placed");
    public static final ResourceKey<PlacedFeature> AMBER_STONE_PLACED_KEY = registerKey("amber_stone_placed");
    public static final ResourceKey<PlacedFeature> JUNGLE_AMBER_STONE_PLACED_KEY = registerKey("jungle_amber_stone_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?,?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, FOSSIL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FOSSIL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(4,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(85))));
        register(context, CARBON_FOSSIL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CARBON_FOSSIL_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(40), VerticalAnchor.absolute(100))));
        register(context, AMBER_STONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.AMBER_STONE_KEY),
                ModOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-5), VerticalAnchor.absolute(50))));
        register(context, JUNGLE_AMBER_STONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.JUNGLE_AMBER_STONE_KEY),
                ModOrePlacement.commonOrePlacement(4,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(65))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(DinoMod.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?,?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
