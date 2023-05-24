package net.blunivers.megalovania.item;

import net.blunivers.megalovania.Megalovania;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Megalovania.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab MEGALIT_TAB;
    public static CreativeModeTab CAJTI_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        MEGALIT_TAB = event.registerCreativeModeTab(new ResourceLocation(Megalovania.MOD_ID, "megalit_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.GROUND_MEGAZA_FLESH.get()))
                        .title(Component.translatable("creativemodetab.megalit_tab")));
        CAJTI_TAB = event.registerCreativeModeTab(new ResourceLocation(Megalovania.MOD_ID, "cajti_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.CEJL.get()))
                        .title(Component.translatable("creativemodetab.cajti_tab")));
    }
}
