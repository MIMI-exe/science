package de.mimi.science.core.init;


import de.mimi.science.Science;
import de.mimi.science.core.init.custom.MicroscopeBlock;
import de.mimi.science.core.itemgroup.InvGroups;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Science.MOD_ID);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block,CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn,tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static final RegistryObject<Block> CARBON_BLOCK = registerBlock("carbon_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)), InvGroups.BLOCKGROUP);

    public static final RegistryObject<Block> LITHIUM_BLOCK = registerBlock("lithium_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)), InvGroups.BLOCKGROUP);

    public static final RegistryObject<Block> WASSERSTOFF_BLOCK = registerBlock("wasserstoff_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)), InvGroups.BLOCKGROUP);

   public static final RegistryObject<Block> LITHIUM_ORE = registerBlock("lithium_ore",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)), InvGroups.BLOCKGROUP);

    public static final RegistryObject<Block> BORON_BLOCK = registerBlock("boron_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)), InvGroups.BLOCKGROUP);

    public static final RegistryObject<Block> NEON_BLOCK = registerBlock("neon_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)), InvGroups.BLOCKGROUP);

    public static final RegistryObject<Block> CARBON_ORE = registerBlock("carbon_ore",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops()), InvGroups.BLOCKGROUP);

    public static final RegistryObject<Block> BERYLLIUM_BLOCK = registerBlock("beryllium_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)), InvGroups.BLOCKGROUP);

    public static final RegistryObject<Block> BORON_ORE = registerBlock("boron_ore",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)), InvGroups.BLOCKGROUP);

    public static final RegistryObject<Block> BERYLLIUM_ORE = registerBlock("beryllium_ore",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)), InvGroups.BLOCKGROUP);

    public static final RegistryObject<Block> STICKSTOFF_BLOCK = registerBlock("stickstoff_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)), InvGroups.BLOCKGROUP);

    public static final RegistryObject<Block> MICROSCOPE = registerBlock("microscope",
            ()->new MicroscopeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BARS)
                    .strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)), InvGroups.BLOCKGROUP);




}
