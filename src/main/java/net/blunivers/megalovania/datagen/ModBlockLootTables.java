package net.blunivers.megalovania.datagen;

import net.blunivers.megalovania.block.ModBlocks;
import net.blunivers.megalovania.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.CEJL_BLOCK.get());
        dropSelf(ModBlocks.CIKAN_BLOCK.get());
        dropSelf(ModBlocks.OIL_EXTRACTOR.get());

        add(ModBlocks.CEJL_ORE.get(),
                (block) -> createOreDrop(ModBlocks.CEJL_ORE.get(), ModItems.RAW_CEJL.get()));

        add(ModBlocks.CIKAN_ORE.get(),
                (block) -> createOreDrop(ModBlocks.CIKAN_ORE.get(), ModItems.RAW_CIKAN.get()));

        add(ModBlocks.GROUND_MEGAZA_FLESH_BLOCK.get(),
                (block) -> createOreDrop(ModBlocks.GROUND_MEGAZA_FLESH_BLOCK.get(), ModItems.GROUND_MEGAZA_FLESH.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
