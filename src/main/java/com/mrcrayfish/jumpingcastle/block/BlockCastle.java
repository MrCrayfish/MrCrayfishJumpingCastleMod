package com.mrcrayfish.jumpingcastle.block;

import com.mrcrayfish.jumpingcastle.MrCrayfishJumpingCastleMod;
import com.mrcrayfish.jumpingcastle.init.ModSounds;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

/**
 * Author: MrCrayfish
 */
public class BlockCastle extends BlockColored
{
    public BlockCastle()
    {
        super(Material.CLOTH);
        this.setHardness(0.25F);
        this.setUnlocalizedName("castle");
        this.setRegistryName("castle");
        this.setCreativeTab(MrCrayfishJumpingCastleMod.TAB_CASTLE);
    }

    @Override
    public void onLanded(World worldIn, Entity entityIn) {}

    @Override
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance)
    {
        if(entityIn instanceof EntityLivingBase)
        {
            float height = entityIn.fallDistance;
            if(height > 0 && !entityIn.isSneaking())
            {
                if(height > 4) height = 4;
                entityIn.motionY = 0;
                entityIn.addVelocity(0, getRequiredVelocity(height + 1), 0);
                worldIn.playSound(null, pos, ModSounds.BOUNCE, SoundCategory.BLOCKS, 0.75F, 0.8F);
                if(worldIn.isRemote)
                {
                    for(int i = 0; i < 5; i++)
                    {
                        double offsetX = -0.1 + 0.2 * RANDOM.nextDouble();
                        double offsetZ = -0.1 + 0.2 * RANDOM.nextDouble();
                        worldIn.spawnParticle(EnumParticleTypes.SPELL_MOB, entityIn.posX, entityIn.posY, entityIn.posZ, 1, 1, 1, 0);
                    }
                }
            }
            entityIn.fallDistance = 0;
        }
    }

    @Override
    public boolean addLandingEffects(IBlockState state, WorldServer worldObj, BlockPos blockPosition, IBlockState iblockstate, EntityLivingBase entity, int numberOfParticles)
    {
        return true;
    }

    public double getRequiredVelocity(float height)
    {
        return Math.sqrt(0.22 * height);
    }
}
