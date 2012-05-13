package net.minecraft.src.zoo.dimension;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraft.src.Zoo;
import net.minecraft.src.ZooDimension;
import net.minecraft.src.forge.ITextureProvider;

public class ZooPortal extends Block implements ITextureProvider{

	public static int timeInPortal;
	
	public ZooPortal(int i, int j, Material material) {
		super(i, j, material);
	}
	
	/**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
        if (iblockaccess.getBlockId(i - 1, j, k) == Zoo.brownStone.blockID || iblockaccess.getBlockId(i + 1, j, k) == Zoo.brownStone.blockID)
        {
            float f = 0.5F;
            float f2 = 0.125F;
            setBlockBounds(0.5F - f, 0.0F, 0.5F - f2, 0.5F + f, 1.0F, 0.5F + f2);
        }
        else
        {
            float f1 = 0.125F;
            float f3 = 0.5F;
            setBlockBounds(0.5F - f1, 0.0F, 0.5F - f3, 0.5F + f1, 1.0F, 0.5F + f3);
        }
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if (iblockaccess.getBlockId(i, j, k) == blockID)
        {
            return false;
        }
        boolean flag = iblockaccess.getBlockId(i - 1, j, k) == blockID && iblockaccess.getBlockId(i - 2, j, k) != blockID;
        boolean flag1 = iblockaccess.getBlockId(i + 1, j, k) == blockID && iblockaccess.getBlockId(i + 2, j, k) != blockID;
        boolean flag2 = iblockaccess.getBlockId(i, j, k - 1) == blockID && iblockaccess.getBlockId(i, j, k - 2) != blockID;
        boolean flag3 = iblockaccess.getBlockId(i, j, k + 1) == blockID && iblockaccess.getBlockId(i, j, k + 2) != blockID;
        boolean flag4 = flag || flag1;
        boolean flag5 = flag2 || flag3;
        if (flag4 && l == 4)
        {
            return true;
        }
        if (flag4 && l == 5)
        {
            return true;
        }
        if (flag5 && l == 2)
        {
            return true;
        }
        return flag5 && l == 3;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass()
    {
        return 1;
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
    	if (entity instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entity;
            if (!world.isRemote)
            {
            	EntityPlayerSP entityplayersp = (EntityPlayerSP)entity;
        		if(!isInPortal(entityplayersp, blockID))
        		{
        			timeInPortal = 0;
        			ZooDimension.isInPortal = false;
        			return;
        		}
                if (isInPortal(entityplayersp, blockID))
                {
                	ZooDimension.isInPortal = true;
                    timeInPortal++;
                    if (timeInPortal == 150 && entityplayersp.timeUntilPortal <= 0)
                    {
        				timeInPortal = 0;
        				entityplayersp.timeUntilPortal = 10;
        				
        		        if (entityplayersp.dimension != ZooDimension.dimensionId)
        		        {
        		            ModLoader.getMinecraftInstance().usePortal(ZooDimension.dimensionId, new ZooTeleporter());
        		        }
        		        else if (entityplayersp.dimension == ZooDimension.dimensionId)
        		        {
        		        	ModLoader.getMinecraftInstance().usePortal(0, new ZooTeleporter());
        		        }
                    }
                    
                }
            }
			if (isInPortal((EntityPlayerSP)entityplayer, blockID))
			{
				entityplayer.setInPortal();
				if(entityplayer.timeInPortal >= 0.9F)
				{
					entityplayer.timeInPortal = 0.0F;
				}
			}
        }
    }
	
    private boolean isInPortal(EntityPlayerSP entityplayersp, int i)
    {
        int j = (int)Math.floor(entityplayersp.posX);
        int k = (int)Math.floor(entityplayersp.posY);
        int l = (int)Math.floor(entityplayersp.posZ);
		if(entityplayersp.worldObj.getBlockId(j, k, l) == i || entityplayersp.worldObj.getBlockId(j, k - 1, l) == i)
		{
			return true;
		}
		return false;
    }
    
	public String getTextureFile() {
		return "/zoo/dimension/blocks.png";
	}

}
