package de.zaziki.ZazikiFarming;

import com.mojang.logging.LogUtils;

import de.zaziki.ZazikiFarming.block.ModBlocks;
import de.zaziki.ZazikiFarming.item.ModItems;
import de.zaziki.ZazikiFarming.loot.ModLootModifiers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@SuppressWarnings("unused")
@Mod(ZazikiFarming.MODID)
public class ZazikiFarming
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "zazikifarming";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public ZazikiFarming()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {

            event.accept(ModItems.MASHER);
            event.accept(ModItems.SPINNINGWHEEL);
            event.accept(ModItems.MIXER);
            event.accept(ModItems.GEOLOGICAL_HAMMER);
            event.accept(ModItems.WOOD_TAPPER);

            event.accept(ModItems.DRIEDAPPLE);
            event.accept(ModItems.POTATOSTARCH);

            event.accept(ModItems.COTTON_SEEDS);
            event.accept(ModItems.RAWCOTTON);
            event.accept(ModItems.COTTON_STRING);

            event.accept(ModItems.SOYBEAN_SEEDS);
            event.accept(ModItems.SOYBEAN);
            event.accept(ModItems.SOAKED_SOYBEAN);
            event.accept(ModItems.RAW_SOYBEAN_MILK);

            event.accept(ModItems.PEPPER_SEEDS);
            event.accept(ModItems.PEPPER);

            event.accept(ModItems.PAPRIKA_SEEDS);
            event.accept(ModItems.PAPRIKA);
            event.accept(ModItems.DRIED_PAPRIKA);
            event.accept(ModItems.PAPRIKA_SPICE);

            event.accept(ModItems.STEAK_SPICE);
            event.accept(ModItems.SALT);
            event.accept(ModItems.CHICKEN_SPICE);
            event.accept(ModItems.PORK_SPICE);
            event.accept(ModItems.FISH_SPICE);
            event.accept(ModItems.RABBIT_SPICE);
            event.accept(ModItems.MUTTON_SPICE);
            event.accept(ModItems.COD_SPICE);

            event.accept(ModItems.CALCIUM_SULPHATE);
            event.accept(ModItems.RAW_TOFU);

            event.accept(ModItems.ONION);

            event.accept(ModItems.PARSLEY);

            event.accept(ModItems.CORIANDER);
            event.accept(ModItems.CORIANDER_GROUND);

            event.accept(ModItems.ROSEMARY);

            event.accept(ModItems.AGAVE);
            event.accept(ModItems.AGAVE_SEEDS);

            event.accept(ModItems.BONE_FRAGMENTS);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            
        }
    }
}
