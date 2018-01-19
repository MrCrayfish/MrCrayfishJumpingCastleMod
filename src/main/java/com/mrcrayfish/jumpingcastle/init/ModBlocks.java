package com.mrcrayfish.jumpingcastle.init;

import com.mrcrayfish.jumpingcastle.block.BlockCastle;
import com.mrcrayfish.jumpingcastle.block.BlockNetting;
import com.mrcrayfish.jumpingcastle.item.ItemCastle;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

/**
 * Author: MrCrayfish
 */
public class ModBlocks
{
    public static final Block CASTLE_BLOCK;
    public static final Block NETTING;

    static
    {
        CASTLE_BLOCK = new BlockCastle();
        NETTING = new BlockNetting();
    }

    public static void register()
    {
        registerBlock(CASTLE_BLOCK, new ItemCastle(CASTLE_BLOCK));
        registerBlock(NETTING);
    }

    private static void registerBlock(Block block)
    {
        registerBlock(block, new ItemBlock(block));
    }

    private static void registerBlock(Block block, ItemBlock item)
    {
        if(block.getRegistryName() == null)
            throw new IllegalArgumentException("A block being registered does not have a registry name and could be successfully registered.");

        RegistrationHandler.Blocks.add(block);
        item.setRegistryName(block.getRegistryName());
        RegistrationHandler.Items.add(item);
    }
}
