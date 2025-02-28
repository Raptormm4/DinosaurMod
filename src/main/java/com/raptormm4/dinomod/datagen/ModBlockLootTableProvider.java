package com.raptormm4.dinomod.datagen;

import com.raptormm4.dinomod.block.ModBlocks;
import com.raptormm4.dinomod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.AMBER_BLOCK.get());

        this.add(ModBlocks.FOSSIL_ORE.get(), block ->
                createMultipleOreDrop(ModBlocks.FOSSIL_ORE.get(), ModItems.FOSSIL.get(), 1, 2));
        this.add(ModBlocks.CARBON_FOSSIL.get(), block ->
                createMultipleOreDrop(ModBlocks.CARBON_FOSSIL.get(), ModItems.PLANT_FOSSIL.get(), 1, 3));
        this.add(ModBlocks.AMBER_STONE.get(), block ->
                createOreDrop(ModBlocks.AMBER_STONE.get(), ModItems.AMBER.get()));
    }

    protected LootTable.Builder createMultipleOreDrop(Block pBlock, Item item, float minDrops, float maxDrops) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item).apply(SetItemCountFunction
                        .setCount(UniformGenerator.between(minDrops, maxDrops))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
