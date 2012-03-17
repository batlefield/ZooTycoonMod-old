package net.minecraft.src.zoo.dimension;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.src.*;
import net.minecraft.src.forge.ITextureProvider;

public class ZooPortal extends BlockPortalBase implements ITextureProvider{

	public ZooPortal(int i, int j, Material material) {
		super(i, j, material);
	}

	public WorldProviderBase getDimension() {
		return new WorldProviderZoo();
	}

	public Teleporter getTeleporter() {
		return new ZooTeleporter();
	}

	public String getEnteringMessage() {
		return "Entering Zoo dimension";
	}

	public String getLeavingMessage() {
		return "Leaving Zoo dimension";
	}
	
	public int returnsPlayerToDimension()
    {
        return 0;
    }

	public String getTextureFile() {
		return "/zoo/dimension/blocks.png";
	}
	
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public int getPortalDelay()
    {
        return 150;
    }
    
    public List canTeleportFromDimension()
    {
            ArrayList arraylist = new ArrayList();
            arraylist.add(Integer.valueOf(0));
            arraylist.add(Integer.valueOf(-1));
            return arraylist;
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public int getRenderBlockPass()
    {
        return 1;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }
	
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

}
