package com.mrcrayfish.jumpingcastle;

import com.mrcrayfish.jumpingcastle.init.ModBlocks;
import com.mrcrayfish.jumpingcastle.init.RegistrationHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Author: MrCrayfish
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, acceptedMinecraftVersions = Reference.MOD_COMPATIBILITY)
public class MrCrayfishJumpingCastleMod
{
    public static final CreativeTabs TAB_CASTLE = new CreativeTabs("tabCastle")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ModBlocks.CASTLE_BLOCK);
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        RegistrationHandler.init();
    }
}

//TODO ideas
//Generate castles with block
//Added pyramid block
