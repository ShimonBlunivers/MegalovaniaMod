package net.blunivers.megalovania.block.entity;

import net.blunivers.megalovania.Megalovania;
import net.blunivers.megalovania.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Megalovania.MOD_ID);

    public static final RegistryObject<BlockEntityType<OilExtractorBlockEntity>> OIL_EXTRACTOR =
            BLOCK_ENTITIES.register("oil_extractor", () ->
                    BlockEntityType.Builder.of(OilExtractorBlockEntity::new,
                            ModBlocks.OIL_EXTRACTOR.get()).build(null));
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
