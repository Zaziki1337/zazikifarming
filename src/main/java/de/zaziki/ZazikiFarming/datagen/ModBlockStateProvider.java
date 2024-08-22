package de.zaziki.ZazikiFarming.datagen;

import de.zaziki.ZazikiFarming.ZazikiFarming;
import de.zaziki.ZazikiFarming.block.ModBlocks;
import de.zaziki.ZazikiFarming.block.custom.*;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ZazikiFarming.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        makeCottonCrop((CropBlock) ModBlocks.COTTON_CROP.get(), "cotton_stage", "cotton_stage");
        makeSoybeanCrop((CropBlock) ModBlocks.SOYBEAN_CROP.get(), "soybean_stage", "soybean_stage");
        makePepperCrop((CropBlock) ModBlocks.PEPPER_CROP.get(), "pepper_stage", "pepper_stage");
        makePaprikaCrop((CropBlock) ModBlocks.PAPRIKA_CROP.get(), "paprika_stage", "paprika_stage");
        makeOnionCrop((CropBlock) ModBlocks.ONION_CROP.get(), "onion_stage", "onion_stage");
        makeAgaveCrop((CropBlock) ModBlocks.AGAVE_CROP.get(), "agave_stage", "agave_stage");
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    public void makeCottonCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cottonStates(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] cottonStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CottonCropBlock) block).getAgeProperty()),
                new ResourceLocation(ZazikiFarming.MODID, "block/" + textureName + state.getValue(((CottonCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }


    public void makeSoybeanCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> soybeanStates(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] soybeanStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((SoybeanCropBlock) block).getAgeProperty()),
                new ResourceLocation(ZazikiFarming.MODID, "block/" + textureName + state.getValue(((SoybeanCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }


    public void makePepperCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> pepperStates(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] pepperStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((PepperCropBlock) block).getAgeProperty()),
                new ResourceLocation(ZazikiFarming.MODID, "block/" + textureName + state.getValue(((PepperCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }


    public void makePaprikaCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> paprikaStates(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] paprikaStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((PaprikaCropBlock) block).getAgeProperty()),
                new ResourceLocation(ZazikiFarming.MODID, "block/" + textureName + state.getValue(((PaprikaCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }


    public void makeOnionCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> onionStates(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] onionStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((OnionCropBlock) block).getAgeProperty()),
                new ResourceLocation(ZazikiFarming.MODID, "block/" + textureName + state.getValue(((OnionCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }


    public void makeAgaveCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> agaveStates(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] agaveStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((AgaveCropBlock) block).getAgeProperty()),
                new ResourceLocation(ZazikiFarming.MODID, "block/" + textureName + state.getValue(((AgaveCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
}
