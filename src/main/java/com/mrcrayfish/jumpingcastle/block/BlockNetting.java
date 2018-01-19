package com.mrcrayfish.jumpingcastle.block;

import com.mrcrayfish.jumpingcastle.MrCrayfishJumpingCastleMod;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

/**
 * Author: MrCrayfish
 */
public class BlockNetting extends BlockPane
{
    public BlockNetting()
    {
        super(Material.CLOTH, true);
        this.setUnlocalizedName("netting");
        this.setRegistryName("netting");
        this.setCreativeTab(MrCrayfishJumpingCastleMod.TAB_CASTLE);
    }
}
