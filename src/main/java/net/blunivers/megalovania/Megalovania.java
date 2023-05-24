package net.blunivers.megalovania;

import com.mojang.logging.LogUtils;
import net.blunivers.megalovania.block.ModBlocks;
import net.blunivers.megalovania.block.entity.ModBlockEntities;
import net.blunivers.megalovania.item.ModCreativeModeTabs;
import net.blunivers.megalovania.item.ModItems;
import net.blunivers.megalovania.screen.ModMenuTypes;
import net.blunivers.megalovania.screen.OilExtractorScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Megalovania.MOD_ID)
public class Megalovania
{
    public static final String MOD_ID = "megalovania";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Megalovania()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == ModCreativeModeTabs.MEGALIT_TAB) {

            event.accept(ModBlocks.GROUND_MEGAZA_WOOD);
            event.accept(ModItems.GROUND_MEGAZA_FLESH);
            event.accept(ModBlocks.GROUND_MEGAZA_LEAVES);
            event.accept(ModBlocks.GROUND_MEGAZA_FLESH_BLOCK);
            
            event.accept(ModItems.MEGAZA_OIL);
        }

        if (event.getTab() == ModCreativeModeTabs.CAJTI_TAB) {

            event.accept(ModItems.CEJL);
            event.accept(ModItems.RAW_CEJL);
            event.accept(ModBlocks.CEJL_BLOCK);
            event.accept(ModBlocks.CEJL_ORE);

            event.accept(ModItems.CIKAN);
            event.accept(ModItems.RAW_CIKAN);
            event.accept(ModBlocks.CIKAN_BLOCK);
            event.accept(ModBlocks.CIKAN_ORE);

            event.accept(ModBlocks.OIL_EXTRACTOR);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public void onServerStarting(ServerStartingEvent event)
//    {
//        // Do something when the server starts
//        LOGGER.info("HELLO from server starting");
//    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModMenuTypes.OIL_EXTRACTOR_MENU.get(), OilExtractorScreen::new);

        }
    }
}
