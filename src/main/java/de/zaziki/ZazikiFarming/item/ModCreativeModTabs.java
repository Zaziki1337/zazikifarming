package de.zaziki.ZazikiFarming.item;

import de.zaziki.ZazikiFarming.ZazikiFarming;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ZazikiFarming.MODID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GEOLOGICAL_HAMMER.get()))
                    .title(Component.translatable("creativetab.zazikifarming_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        // TOOLS
                        pOutput.accept(ModItems.MASHER.get());
                        pOutput.accept(ModItems.MIXER.get());
                        pOutput.accept(ModItems.SPINNINGWHEEL.get());
                        pOutput.accept(ModItems.GEOLOGICAL_HAMMER.get());

                        //
                        pOutput.accept(ModItems.DRIEDAPPLE.get());
                        pOutput.accept(ModItems.POTATOSTARCH.get());

                        pOutput.accept(ModItems.COTTON_SEEDS.get());
                        pOutput.accept(ModItems.RAWCOTTON.get());
                        pOutput.accept(ModItems.COTTON_STRING.get());

                        pOutput.accept(ModItems.SOYBEAN_SEEDS.get());
                        pOutput.accept(ModItems.SOYBEAN.get());
                        pOutput.accept(ModItems.SOAKED_SOYBEAN.get());
                        pOutput.accept(ModItems.RAW_SOYBEAN_MILK.get());

                        pOutput.accept(ModItems.PEPPER_SEEDS.get());
                        pOutput.accept(ModItems.PEPPER.get());

                        pOutput.accept(ModItems.PAPRIKA_SEEDS.get());
                        pOutput.accept(ModItems.PAPRIKA.get());
                        pOutput.accept(ModItems.DRIED_PAPRIKA.get());
                        pOutput.accept(ModItems.PAPRIKA_SPICE.get());

                        pOutput.accept(ModItems.STEAK_SPICE.get());
                        pOutput.accept(ModItems.SALT.get());
                        pOutput.accept(ModItems.CHICKEN_SPICE.get());
                        pOutput.accept(ModItems.PORK_SPICE.get());
                        pOutput.accept(ModItems.FISH_SPICE.get());
                        pOutput.accept(ModItems.RABBIT_SPICE.get());
                        pOutput.accept(ModItems.MUTTON_SPICE.get());
                        pOutput.accept(ModItems.COD_SPICE.get());

                        pOutput.accept(ModItems.CALCIUM_SULPHATE.get());
                        pOutput.accept(ModItems.RAW_TOFU.get());

                        pOutput.accept(ModItems.ONION.get());

                        pOutput.accept(ModItems.PARSLEY.get());

                        pOutput.accept(ModItems.CORIANDER.get());
                        pOutput.accept(ModItems.CORIANDER_GROUND.get());

                        pOutput.accept(ModItems.ROSEMARY.get());

                        pOutput.accept(ModItems.AGAVE.get());
                        pOutput.accept(ModItems.AGAVE_SEEDS.get());

                        pOutput.accept(ModItems.BONE_FRAGMENTS.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
