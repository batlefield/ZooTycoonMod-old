package net.minecraft.src.zoo.core;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.BlockPane;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.StatList;
import net.minecraft.src.World;
import net.minecraft.src.Zoo;
import net.minecraft.src.forge.ITextureProvider;
import net.minecraft.src.zoo.api.ITrade;
import net.minecraft.src.zoo.trading.GUIType;

// Referenced classes of package net.minecraft.src:
//            Block, IBlockAccess, World, Material, 
//            AxisAlignedBB

public class ZooBlockGlass extends BlockPane implements ITextureProvider, ITrade
{

    private int field_35300_a;
    private final boolean field_40213_b;

    public ZooBlockGlass(int i, int j, int k, Material material, boolean flag)
    {
        super(i, j, k, material, flag);
        field_35300_a = k;
        field_40213_b = flag;
    }

    public int idDropped(int i, Random random, int j)
    {
    	return 0;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 18;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        int i1 = iblockaccess.getBlockId(i, j, k);
        if(i1 == blockID)
        {
            return false;
        } else
        {
            return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
        }
    }

    public void getCollidingBoundingBoxes(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
        boolean flag = canThisPaneConnectToThisBlockID(world.getBlockId(i, j, k - 1));
        boolean flag1 = canThisPaneConnectToThisBlockID(world.getBlockId(i, j, k + 1));
        boolean flag2 = canThisPaneConnectToThisBlockID(world.getBlockId(i - 1, j, k));
        boolean flag3 = canThisPaneConnectToThisBlockID(world.getBlockId(i + 1, j, k));
        if(flag2 && flag3 || !flag2 && !flag3 && !flag && !flag1)
        {
            setBlockBounds(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(flag2 && !flag3)
        {
            setBlockBounds(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(!flag2 && flag3)
        {
            setBlockBounds(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        }
        if(flag && flag1 || !flag2 && !flag3 && !flag && !flag1)
        {
            setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(flag && !flag1)
        {
            setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(!flag && flag1)
        {
            setBlockBounds(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        }
    }

    public void setBlockBoundsForItemRender()
    {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
        float f = 0.4375F;
        float f1 = 0.5625F;
        float f2 = 0.4375F;
        float f3 = 0.5625F;
        boolean flag = canThisPaneConnectToThisBlockID(iblockaccess.getBlockId(i, j, k - 1));
        boolean flag1 = canThisPaneConnectToThisBlockID(iblockaccess.getBlockId(i, j, k + 1));
        boolean flag2 = canThisPaneConnectToThisBlockID(iblockaccess.getBlockId(i - 1, j, k));
        boolean flag3 = canThisPaneConnectToThisBlockID(iblockaccess.getBlockId(i + 1, j, k));
        if(flag2 && flag3 || !flag2 && !flag3 && !flag && !flag1)
        {
            f = 0.0F;
            f1 = 1.0F;
        } else
        if(flag2 && !flag3)
        {
            f = 0.0F;
        } else
        if(!flag2 && flag3)
        {
            f1 = 1.0F;
        }
        if(flag && flag1 || !flag2 && !flag3 && !flag && !flag1)
        {
            f2 = 0.0F;
            f3 = 1.0F;
        } else
        if(flag && !flag1)
        {
            f2 = 0.0F;
        } else
        if(!flag && flag1)
        {
            f3 = 1.0F;
        }
        setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    public int func_35299_s()
    {
        return field_35300_a;
    }

	public String getTextureFile() {
		return "/zoo/blocks.png";
	}
	public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        if(!world.isRemote && entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().itemID == Zoo.fenceDestroyer.shiftedIndex)
        {
            entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
            dropBlockAsItem_do(world, i, j, k, new ItemStack(blockID, 1, l & 3));
        } else
        {
            super.harvestBlock(world, entityplayer, i, j, k, l);
        }
    }

	public int getPrice(int i, int j)
	{
		return 345;
	}

	public void addToGUI(GUIType type, ArrayList list){
		if(type == GUIType.DECOR)
		{
			list.add(new ItemStack(this));
		}
	}
	
}
