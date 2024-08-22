package de.zaziki.ZazikiFarming.datagen;
import de.zaziki.ZazikiFarming.ZazikiFarming;
import de.zaziki.ZazikiFarming.loot.AddItemModifier;
import de.zaziki.ZazikiFarming.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraft.advancements.critereon.ItemPredicate;


public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, ZazikiFarming.MODID);
    }

    @Override
    protected void start() {
        add("cotton_seeds_from_grass",
                new AddItemModifier(
                        new LootItemCondition[] {
                            LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                            LootItemRandomChanceCondition.randomChance(0.35f).build()},
                        ModItems.COTTON_SEEDS.get()
                )
        );

        add("soybean_seeds_from_grass",
                new AddItemModifier(
                        new LootItemCondition[] {
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                                LootItemRandomChanceCondition.randomChance(0.35f).build()},
                        ModItems.SOYBEAN_SEEDS.get()
                )
        );

        add("pepper_seeds_from_grass",
                new AddItemModifier(
                        new LootItemCondition[] {
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                                LootItemRandomChanceCondition.randomChance(0.35f).build()},
                        ModItems.PEPPER_SEEDS.get()
                )
        );

        add("paprika_seeds_from_grass",
                new AddItemModifier(
                        new LootItemCondition[] {
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                                LootItemRandomChanceCondition.randomChance(0.35f).build()},
                        ModItems.PAPRIKA_SEEDS.get()
                )
        );


        add("onion_from_grass",
                new AddItemModifier(
                        new LootItemCondition[] {
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                                LootItemRandomChanceCondition.randomChance(0.15f).build()},
                        ModItems.ONION.get()
                )
        );

        add("parsley_from_grass",
                new AddItemModifier(
                        new LootItemCondition[] {
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                                LootItemRandomChanceCondition.randomChance(0.25f).build()},
                        ModItems.PARSLEY.get()
                )
        );

        add("coriander_from_grass",
                new AddItemModifier(
                        new LootItemCondition[] {
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                                LootItemRandomChanceCondition.randomChance(0.25f).build()},
                        ModItems.CORIANDER.get()
                )
        );

        add("rosemary_from_grass",
                new AddItemModifier(
                        new LootItemCondition[] {
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                                LootItemRandomChanceCondition.randomChance(0.25f).build()},
                        ModItems.ROSEMARY.get()
                )
        );


        add("agave_seeds_from_grass",
                new AddItemModifier(
                        new LootItemCondition[] {
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                                LootItemRandomChanceCondition.randomChance(0.35f).build()},
                        ModItems.AGAVE_SEEDS.get()
                )
        );


        add("bone_fragments_from_stones_with_geological_hammer",
                new AddItemModifier(
                        new LootItemCondition[] {
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STONE).build(),
                                LootItemRandomChanceCondition.randomChance(0.35f).build(),
                                MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModItems.GEOLOGICAL_HAMMER.get())).build(),
                        },
                        ModItems.BONE_FRAGMENTS.get()
                )
        );
    }
}
