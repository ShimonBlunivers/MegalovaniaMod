package net.blunivers.megalovania.block;

import net.blunivers.megalovania.Megalovania;
import net.blunivers.megalovania.block.custom.MegazaBlock;
import net.blunivers.megalovania.block.custom.OilExtractorBlock;
import net.blunivers.megalovania.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Megalovania.MOD_ID);

    public static final RegistryObject<Block> CEJL_BLOCK = registerBlock("cejl_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CEJL_ORE = registerBlock("cejl_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(2, 6)));
    public static final RegistryObject<Block> CIKAN_BLOCK = registerBlock("cikan_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CIKAN_ORE = registerBlock("cikan_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(2, 6)));

    public static final RegistryObject<Block> GROUND_MEGAZA_WOOD = registerBlock("ground_megaza_wood",
            () -> new MegazaBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .noLootTable()));

    public static final RegistryObject<Block> GROUND_MEGAZA_FLESH_BLOCK = registerBlock("ground_megaza_flesh_block",
            () -> new MegazaBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(4f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GROUND_MEGAZA_LEAVES = registerBlock("ground_megaza_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .strength(4f)
                    .noLootTable())
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });


    public static final RegistryObject<Block> OIL_EXTRACTOR = registerBlock("oil_extractor",
            () -> new OilExtractorBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
    return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
            new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
