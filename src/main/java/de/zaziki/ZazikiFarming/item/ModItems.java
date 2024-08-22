package de.zaziki.ZazikiFarming.item;

import de.zaziki.ZazikiFarming.ZazikiFarming;
import de.zaziki.ZazikiFarming.block.ModBlocks;
import de.zaziki.ZazikiFarming.item.custom.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ZazikiFarming.MODID);

        // TOOLS
        public static final RegistryObject<Item> MASHER = ITEMS.register("masher",
            () -> new Masher(new Item.Properties().durability(100)));
        public static final RegistryObject<Item> SPINNINGWHEEL = ITEMS.register("spinningwheel",
            () -> new SpinningWheel(new Item.Properties().durability(100)));
        public static final RegistryObject<Item> MIXER = ITEMS.register("mixer",
            () -> new Mixer(new Item.Properties().durability(100)));
        public static final RegistryObject<Item> GEOLOGICAL_HAMMER = ITEMS.register("geological_hammer",
            () -> new GeologicalHammer(Tiers.WOOD, 1, 0.1f, new Item.Properties().durability(1024)));
        public static final RegistryObject<Item> WOOD_TAPPER = ITEMS.register("wood_tapper",
            () -> new WoodTapper(new Item.Properties().durability(100)));

        // APPLE
        public static final RegistryObject<Item> DRIEDAPPLE = ITEMS.register("driedapple",
        () -> new Item(new Item.Properties()));

        // POTATO
        public static final RegistryObject<Item> POTATOSTARCH = ITEMS.register("potatostarch",
        () -> new Item(new Item.Properties()));

        // COTTON
        public static final RegistryObject<Item> COTTON_STRING = ITEMS.register("cotton_string",
            () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> COTTON_SEEDS = ITEMS.register("cotton_seeds",
            () -> new ItemNameBlockItem(ModBlocks.COTTON_CROP.get(), new Item.Properties()));
        public static final RegistryObject<Item> RAWCOTTON = ITEMS.register("rawcotton",
            () -> new Item(new Item.Properties()));

        // SOYBEAN
        public static final RegistryObject<Item> SOYBEAN_SEEDS = ITEMS.register("soybean_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SOYBEAN_CROP.get(), new Item.Properties()));
        public static final RegistryObject<Item> SOYBEAN = ITEMS.register("soybean",
            () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> SOAKED_SOYBEAN = ITEMS.register("soaked_soybean",
            () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_SOYBEAN_MILK = ITEMS.register("raw_soybean_milk",
            () -> new Item(new Item.Properties()));

        // PEPPER
        public static final RegistryObject<Item> PEPPER_SEEDS = ITEMS.register("pepper_seeds",
                () -> new ItemNameBlockItem(ModBlocks.PEPPER_CROP.get(), new Item.Properties()));
        public static final RegistryObject<Item> PEPPER = ITEMS.register("pepper",
            () -> new Item(new Item.Properties()));

        // PAPRIKA
        public static final RegistryObject<Item> PAPRIKA_SEEDS = ITEMS.register("paprika_seeds",
                () -> new ItemNameBlockItem(ModBlocks.PAPRIKA_CROP.get(), new Item.Properties()));
        public static final RegistryObject<Item> PAPRIKA = ITEMS.register("paprika",
            () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> DRIED_PAPRIKA = ITEMS.register("dried_paprika",
            () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> PAPRIKA_SPICE = ITEMS.register("paprika_spice",
            () -> new Item(new Item.Properties()));


        // SPICES
        public static final RegistryObject<Item> STEAK_SPICE = ITEMS.register("steak_spice",
                () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> SALT = ITEMS.register("salt",
                () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CHICKEN_SPICE = ITEMS.register("chicken_spice",
                () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> PORK_SPICE = ITEMS.register("pork_spice",
                () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> FISH_SPICE = ITEMS.register("fish_spice",
                () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RABBIT_SPICE = ITEMS.register("rabbit_spice",
                () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> MUTTON_SPICE = ITEMS.register("mutton_spice",
                () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> COD_SPICE = ITEMS.register("cod_spice",
            () -> new Item(new Item.Properties()));


        // TOFU
        public static final RegistryObject<Item> CALCIUM_SULPHATE = ITEMS.register("calcium_sulphate",
                () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_TOFU = ITEMS.register("raw_tofu",
            () -> new Item(new Item.Properties()));


        // ONION
        public static final RegistryObject<Item> ONION = ITEMS.register("onion",
                () -> new ItemNameBlockItem(ModBlocks.ONION_CROP.get(), new Item.Properties()));


        // PARSLEY
        public static final RegistryObject<Item> PARSLEY = ITEMS.register("parsley",
                () -> new Item(new Item.Properties()));

        // CORIANDER
        public static final RegistryObject<Item> CORIANDER = ITEMS.register("coriander",
                () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CORIANDER_GROUND = ITEMS.register("coriander_ground",
                () -> new Item(new Item.Properties()));

        // ROSEMARY
        public static final RegistryObject<Item> ROSEMARY = ITEMS.register("rosemary",
                () -> new Item(new Item.Properties()));

        // AGAVE
        public static final RegistryObject<Item> AGAVE = ITEMS.register("agave",
                () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> AGAVE_SEEDS = ITEMS.register("agave_seeds",
                () -> new Item(new Item.Properties()));

        // BONE FRAGMENTS
        public static final RegistryObject<Item> BONE_FRAGMENTS = ITEMS.register("bone_fragments",
                () -> new Item(new Item.Properties()));

        // SAP
        public static final RegistryObject<Item> SAP = ITEMS.register("sap",
                () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
