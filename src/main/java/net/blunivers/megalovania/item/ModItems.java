package net.blunivers.megalovania.item;

import net.blunivers.megalovania.Megalovania;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Megalovania.MOD_ID);

    public static final RegistryObject<Item> GROUND_MEGAZA_FLESH = ITEMS.register("ground_megaza_flesh",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CEJL = ITEMS.register("cejl",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_CEJL = ITEMS.register("raw_cejl",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> CIKAN = ITEMS.register("cikan",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_CIKAN = ITEMS.register("raw_cikan",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEGAZA_OIL = ITEMS.register("megaza_oil",
            () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
