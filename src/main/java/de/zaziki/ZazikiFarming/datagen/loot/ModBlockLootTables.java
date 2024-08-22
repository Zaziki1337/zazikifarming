package de.zaziki.ZazikiFarming.datagen.loot;

import de.zaziki.ZazikiFarming.block.ModBlocks;
import de.zaziki.ZazikiFarming.block.custom.PepperCropBlock;
import de.zaziki.ZazikiFarming.block.custom.SoybeanCropBlock;
import de.zaziki.ZazikiFarming.item.ModItems;
import de.zaziki.ZazikiFarming.block.custom.CottonCropBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collections;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        addCropsLoot((CropBlock) ModBlocks.COTTON_CROP.get(), ModItems.COTTON_SEEDS.get(), ModItems.RAWCOTTON.get());
        addCropsLoot((CropBlock) ModBlocks.SOYBEAN_CROP.get(), ModItems.SOYBEAN_SEEDS.get(), ModItems.SOYBEAN.get());
        addCropsLoot((CropBlock) ModBlocks.PEPPER_CROP.get(), ModItems.PEPPER_SEEDS.get(), ModItems.PEPPER.get());
        addCropsLoot((CropBlock) ModBlocks.PAPRIKA_CROP.get(), ModItems.PAPRIKA_SEEDS.get(), ModItems.PAPRIKA.get());
        addCropsLoot((CropBlock) ModBlocks.ONION_CROP.get(), ModItems.ONION.get(), ModItems.ONION.get());
        addCropsLoot((CropBlock) ModBlocks.AGAVE_CROP.get(), ModItems.AGAVE_SEEDS.get(), ModItems.AGAVE.get());
    }

    private void addCropsLoot(CropBlock cropBlock, Item seed, Item gatherItem) {
        LootItemCondition.Builder lootitemconditionBuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(cropBlock)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PepperCropBlock.AGE, 5));
        this.add(cropBlock, createCropDrops(cropBlock, gatherItem,
                seed, lootitemconditionBuilder));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
