package de.mimi.science.core.itemgroup;

import de.mimi.science.core.init.BlockInit;
import de.mimi.science.core.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class InvGroups {
    public static final CreativeModeTab GASGROUP = new CreativeModeTab("gasgroup") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.WASSERSTOFF_GAS.get());
        }
    };

    public static final CreativeModeTab BLOCKGROUP = new CreativeModeTab("blockgroup") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BlockInit.CARBON_BLOCK.get());
        }
    };

    public static final CreativeModeTab FLUESSIGGROUP = new CreativeModeTab("fluessiggroup") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.FLUESSIG_WASSERSTOFF.get());
        }
    };

    public static final CreativeModeTab INGOTGROUP = new CreativeModeTab("ingotgroup") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.CARBON_INGOT.get());
        }
    };

    public static final CreativeModeTab MOLEGROUP = new CreativeModeTab("molegroup") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.ETHANOL.get());
        }
    };

    public static final CreativeModeTab RANDOMGROUP = new CreativeModeTab("randomgroup") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.ION_LINSE.get());
        }
    };





}
