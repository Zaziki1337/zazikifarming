package de.zaziki.ZazikiFarming.datagen;

import de.zaziki.ZazikiFarming.ZazikiFarming;
import de.zaziki.ZazikiFarming.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> APPLE_SMELTABLES = List.of(Items.APPLE);
    private static final List<ItemLike> RAW_SOYBEAN_MILK_SMELTABLES = List.of(ModItems.RAW_SOYBEAN_MILK.get());
    private static final List<ItemLike> PAPRIKA_SMELTABLES = List.of(ModItems.PAPRIKA.get());
    private static final List<ItemLike> SALT_SMELTABLES = List.of(Items.WATER_BUCKET);
    private static final List<ItemLike> AGAVE_SMELTABLES = List.of(ModItems.AGAVE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        /*
         * TOOLS
         */
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MASHER.get(), 1)
                .pattern(" / ")
                .pattern("i i")
                .pattern(" i ")
                .define('i', Items.IRON_INGOT)
                .define('/', Items.STICK)
                .unlockedBy(getHasName(ModItems.MASHER.get()), has(Items.IRON_INGOT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MIXER.get(), 1)
                .pattern("i i")
                .pattern("i i")
                .pattern(" i ")
                .define('i', Items.IRON_INGOT)
                .unlockedBy(getHasName(ModItems.MIXER.get()), has(Items.IRON_INGOT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SPINNINGWHEEL.get())
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .define('#', ItemTags.PLANKS)
                .unlockedBy(getHasName(ModItems.SPINNINGWHEEL.get()), has(ItemTags.PLANKS))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GEOLOGICAL_HAMMER.get())
                .pattern("WWI")
                .pattern(" S ")
                .pattern(" S ")
                .define('W', ItemTags.PLANKS)
                .define('I', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.GEOLOGICAL_HAMMER.get()), has(Items.IRON_INGOT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WOOD_TAPPER.get())
                .pattern("W W")
                .pattern("W W")
                .pattern("WWW")
                .define('W', ItemTags.PLANKS)
                .unlockedBy(getHasName(ModItems.WOOD_TAPPER.get()), has(ItemTags.PLANKS))
                .save(pWriter);

        /*
         * APPLES
         */
        oreSmelting(pWriter, APPLE_SMELTABLES, RecipeCategory.MISC, ModItems.DRIEDAPPLE.get(), 0f, 200, "driedapple");
        oreBlasting(pWriter, APPLE_SMELTABLES, RecipeCategory.MISC, ModItems.DRIEDAPPLE.get(), 0f, 100, "driedapple");



        /*
         * POTATO
         */
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.POTATOSTARCH.get(), 1)
                .requires(ModItems.MASHER.get())
                .requires(Items.POTATO)
                .unlockedBy(getHasName(ModItems.POTATOSTARCH.get()), has(ModItems.MASHER.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LEATHER)
                .pattern("#L#")
                .pattern("PPP")
                .define('P', Items.PAPER)
                .define('#', ModItems.DRIEDAPPLE.get())
                .define('L', ModItems.POTATOSTARCH.get())
                .unlockedBy(getHasName(Items.LEATHER), has(ModItems.POTATOSTARCH.get()))
                .save(pWriter);
        if (ModList.get().isLoaded("thermal")) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LEATHER)
                    .pattern("#L#")
                    .pattern("PPP")
                    .define('P', Items.PAPER)
                    .define('#', ModItems.DRIEDAPPLE.get())
                    .define('L', ForgeRegistries.BLOCKS.getValue(new ResourceLocation("thermal:latex_bucket")))
                    .unlockedBy(getHasName(Items.LEATHER), has(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("thermal:latex_bucket"))))
                    .save(pWriter);
        }
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SLIME_BALL, 1)
                .requires(ModItems.POTATOSTARCH.get())
                .requires(ModItems.SAP.get())
                .requires(Items.WATER_BUCKET)
                .unlockedBy(getHasName(Items.SLIME_BALL), has(ModItems.POTATOSTARCH.get()))
                .save(pWriter);


        /*
         * COTTON
         */

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COTTON_STRING.get(), 1)
                .requires(ModItems.SPINNINGWHEEL.get())
                .requires(ModItems.RAWCOTTON.get())
                .unlockedBy(getHasName(ModItems.COTTON_STRING.get()), has(ModItems.SPINNINGWHEEL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WHITE_WOOL)
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.COTTON_STRING.get())
                .unlockedBy(getHasName(Items.WHITE_WOOL), has(ModItems.COTTON_STRING.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.FEATHER)
                .pattern(" C ")
                .pattern("CCC")
                .pattern("CSC")
                .define('C', ModItems.COTTON_STRING.get())
                .define('S', ModItems.SAP.get())
                .unlockedBy(getHasName(Items.FEATHER), has(ModItems.COTTON_STRING.get()))
                .save(pWriter);


        /*
         * SOYBEANS
         */
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SOAKED_SOYBEAN.get(), 1)
                .requires(ModItems.SOYBEAN.get())
                .requires(Items.SUGAR)
                .requires(Items.WATER_BUCKET)
                .unlockedBy(getHasName(ModItems.SOAKED_SOYBEAN.get()), has(ModItems.SOYBEAN.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_SOYBEAN_MILK.get(), 1)
                .requires(ModItems.SOAKED_SOYBEAN.get())
                .requires(ModItems.MASHER.get())
                .requires(Items.PAPER)
                .requires(Items.BUCKET)
                .unlockedBy(getHasName(ModItems.RAW_SOYBEAN_MILK.get()), has(ModItems.SOYBEAN.get()))
                .save(pWriter);
        oreSmelting(pWriter, RAW_SOYBEAN_MILK_SMELTABLES, RecipeCategory.MISC, Items.MILK_BUCKET, 0f, 200, "rawsoybeanmilk");
        oreBlasting(pWriter, RAW_SOYBEAN_MILK_SMELTABLES, RecipeCategory.MISC, Items.MILK_BUCKET, 0f, 100, "rawsoybeanmilk");


        /*
         * PAPRIKA
         */
        oreSmelting(pWriter, PAPRIKA_SMELTABLES, RecipeCategory.MISC, ModItems.DRIED_PAPRIKA.get(), 0f, 200, "driedpaprika");
        oreBlasting(pWriter, PAPRIKA_SMELTABLES, RecipeCategory.MISC, ModItems.DRIED_PAPRIKA.get(), 0f, 100, "driedpaprika");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PAPRIKA_SPICE.get(), 1)
                .requires(ModItems.DRIED_PAPRIKA.get())
                .requires(ModItems.MIXER.get())
                .unlockedBy(getHasName(ModItems.PAPRIKA_SPICE.get()), has(ModItems.DRIED_PAPRIKA.get()))
                .save(pWriter);


        /*
         * SPICES
         */
        oreSmelting(pWriter, SALT_SMELTABLES, RecipeCategory.MISC, ModItems.SALT.get(), 0f, 200, "salt");
        oreBlasting(pWriter, SALT_SMELTABLES, RecipeCategory.MISC, ModItems.SALT.get(), 0f, 100, "salt");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CORIANDER_GROUND.get(), 1)
                .requires(ModItems.CORIANDER.get())
                .requires(ModItems.MASHER.get())
                .unlockedBy(getHasName(ModItems.CORIANDER_GROUND.get()), has(ModItems.MASHER.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEAK_SPICE.get(), 1)
                .requires(ModItems.PAPRIKA_SPICE.get())
                .requires(ModItems.PEPPER.get())
                .unlockedBy(getHasName(ModItems.STEAK_SPICE.get()), has(ModItems.PAPRIKA_SPICE.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHICKEN_SPICE.get(), 1)
                .requires(ModItems.PAPRIKA_SPICE.get())
                .requires(ModItems.SALT.get())
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(ModItems.CHICKEN_SPICE.get()), has(ModItems.PAPRIKA_SPICE.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PORK_SPICE.get(), 1)
                .requires(ModItems.PAPRIKA_SPICE.get())
                .requires(ModItems.SALT.get())
                .requires(ModItems.PEPPER.get())
                .unlockedBy(getHasName(ModItems.PORK_SPICE.get()), has(ModItems.PAPRIKA_SPICE.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FISH_SPICE.get(), 1)
                .requires(ModItems.SALT.get())
                .requires(ModItems.ONION.get())
                .requires(ModItems.PARSLEY.get())
                .unlockedBy(getHasName(ModItems.FISH_SPICE.get()), has(ModItems.SALT.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RABBIT_SPICE.get(), 1)
                .requires(ModItems.PAPRIKA_SPICE.get())
                .requires(ModItems.CORIANDER_GROUND.get())
                .requires(ModItems.PEPPER.get())
                .unlockedBy(getHasName(ModItems.RABBIT_SPICE.get()), has(ModItems.PAPRIKA_SPICE.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MUTTON_SPICE.get(), 1)
                .requires(ModItems.PARSLEY.get())
                .requires(ModItems.ROSEMARY.get())
                .requires(ModItems.PEPPER.get())
                .unlockedBy(getHasName(ModItems.MUTTON_SPICE.get()), has(ModItems.ROSEMARY.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COD_SPICE.get(), 1)
                .requires(ModItems.SALT.get())
                .requires(ModItems.ONION.get())
                .requires(ModItems.PEPPER.get())
                .unlockedBy(getHasName(ModItems.COD_SPICE.get()), has(ModItems.SALT.get()))
                .save(pWriter);

        /*
         * TOFU
         */
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CALCIUM_SULPHATE.get(), 1)
                .requires(ModItems.MASHER.get())
                .requires(Items.CALCITE)
                .unlockedBy(getHasName(ModItems.CALCIUM_SULPHATE.get()), has(Items.CALCITE))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_TOFU.get(), 1)
                .requires(ModItems.RAW_SOYBEAN_MILK.get())
                .requires(ModItems.CALCIUM_SULPHATE.get())
                .unlockedBy(getHasName(ModItems.RAW_TOFU.get()), has(Items.CALCITE))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BEEF, 1)
                .requires(ModItems.RAW_TOFU.get())
                .requires(ModItems.STEAK_SPICE.get())
                .unlockedBy(getHasName(Items.BEEF), has(ModItems.RAW_TOFU.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PORKCHOP, 1)
                .requires(ModItems.RAW_TOFU.get())
                .requires(ModItems.PORK_SPICE.get())
                .unlockedBy(getHasName(Items.PORKCHOP), has(ModItems.RAW_TOFU.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CHICKEN, 1)
                .requires(ModItems.RAW_TOFU.get())
                .requires(ModItems.CHICKEN_SPICE.get())
                .unlockedBy(getHasName(Items.CHICKEN), has(ModItems.RAW_TOFU.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SALMON, 1)
                .requires(ModItems.RAW_TOFU.get())
                .requires(ModItems.FISH_SPICE.get())
                .unlockedBy(getHasName(Items.SALMON), has(ModItems.RAW_TOFU.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.RABBIT, 1)
                .requires(ModItems.RAW_TOFU.get())
                .requires(ModItems.RABBIT_SPICE.get())
                .unlockedBy(getHasName(Items.RABBIT), has(ModItems.RAW_TOFU.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MUTTON, 1)
                .requires(ModItems.RAW_TOFU.get())
                .requires(ModItems.MUTTON_SPICE.get())
                .unlockedBy(getHasName(Items.MUTTON), has(ModItems.RAW_TOFU.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COD, 1)
                .requires(ModItems.RAW_TOFU.get())
                .requires(ModItems.COD_SPICE.get())
                .unlockedBy(getHasName(Items.COD), has(ModItems.RAW_TOFU.get()))
                .save(pWriter);


        // CAKE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CAKE)
                .pattern("MMM")
                .pattern("SCS")
                .pattern("WWW")
                .define('M', Items.MILK_BUCKET)
                .define('S', Items.SUGAR)
                .define('C', Items.COCOA_BEANS)
                .define('W', Items.WHEAT)
                .unlockedBy(getHasName(Items.CAKE), has(Items.MILK_BUCKET))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PUMPKIN_PIE, 1)
                .requires(Items.CAKE)
                .requires(Items.PUMPKIN)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(Items.PUMPKIN_PIE), has(Items.CAKE))
                .save(pWriter);


        // AGAVE
        oreSmelting(pWriter, AGAVE_SMELTABLES, RecipeCategory.MISC, Items.HONEYCOMB, 0f, 200, "honeycomb");
        oreBlasting(pWriter, AGAVE_SMELTABLES, RecipeCategory.MISC, Items.HONEYCOMB, 0f, 100, "honeycomb");


        // BONE FRAGMENTS
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BONE)
                .pattern("FFF")
                .pattern("WSW")
                .pattern("FFF")
                .define('F', ModItems.BONE_FRAGMENTS.get())
                .define('W', Items.WATER_BUCKET)
                .define('S', ModItems.POTATOSTARCH.get())
                .unlockedBy(getHasName(Items.BONE), has(ModItems.BONE_FRAGMENTS.get()))
                .save(pWriter);

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  ZazikiFarming.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
