package de.zaziki.ZazikiFarming.datagen;

import de.zaziki.ZazikiFarming.ZazikiFarming;
import de.zaziki.ZazikiFarming.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ZazikiFarming.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        simpleItem(ModItems.MASHER);
        simpleItem(ModItems.SPINNINGWHEEL);
        simpleItem(ModItems.MIXER);
        simpleItem(ModItems.GEOLOGICAL_HAMMER);
        simpleItem(ModItems.WOOD_TAPPER);

        simpleItem(ModItems.DRIEDAPPLE);
        simpleItem(ModItems.POTATOSTARCH);

        simpleItem(ModItems.RAWCOTTON);
        simpleItem(ModItems.COTTON_SEEDS);
        simpleItem(ModItems.COTTON_STRING);

        simpleItem(ModItems.SOYBEAN_SEEDS);
        simpleItem(ModItems.SOYBEAN);
        simpleItem(ModItems.SOAKED_SOYBEAN);
        simpleItem(ModItems.RAW_SOYBEAN_MILK);

        simpleItem(ModItems.PEPPER_SEEDS);
        simpleItem(ModItems.PEPPER);

        simpleItem(ModItems.PAPRIKA_SEEDS);
        simpleItem(ModItems.PAPRIKA);
        simpleItem(ModItems.DRIED_PAPRIKA);
        simpleItem(ModItems.PAPRIKA_SPICE);

        simpleItem(ModItems.STEAK_SPICE);
        simpleItem(ModItems.SALT);
        simpleItem(ModItems.CHICKEN_SPICE);
        simpleItem(ModItems.PORK_SPICE);
        simpleItem(ModItems.FISH_SPICE);
        simpleItem(ModItems.RABBIT_SPICE);
        simpleItem(ModItems.MUTTON_SPICE);
        simpleItem(ModItems.COD_SPICE);

        simpleItem(ModItems.CALCIUM_SULPHATE);
        simpleItem(ModItems.RAW_TOFU);

        simpleItem(ModItems.ONION);

        simpleItem(ModItems.PARSLEY);

        simpleItem(ModItems.CORIANDER);
        simpleItem(ModItems.CORIANDER_GROUND);

        simpleItem(ModItems.ROSEMARY);

        simpleItem(ModItems.AGAVE);
        simpleItem(ModItems.AGAVE_SEEDS);

        simpleItem(ModItems.BONE_FRAGMENTS);

        simpleItem(ModItems.SAP);
    }


    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ZazikiFarming.MODID,"item/" + item.getId().getPath()));
    }
}
