package net.blunivers.megalovania.datagen;

import net.blunivers.megalovania.Megalovania;
import net.blunivers.megalovania.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Megalovania.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CIKAN_ORE);
        blockWithItem(ModBlocks.CEJL_ORE);
        blockWithItem(ModBlocks.CEJL_BLOCK);
        blockWithItem(ModBlocks.CIKAN_BLOCK);
        blockWithItem(ModBlocks.GROUND_MEGAZA_FLESH_BLOCK);
        blockWithItem(ModBlocks.GROUND_MEGAZA_WOOD);
        blockWithItem(ModBlocks.GROUND_MEGAZA_LEAVES);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
