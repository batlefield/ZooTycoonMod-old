package net.minecraft.src.zoo.core;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.BlockFlower;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.StatList;
import net.minecraft.src.World;
import net.minecraft.src.Zoo;
import net.minecraft.src.ZooDirts;
import net.minecraft.src.forge.ForgeHooks;
import net.minecraft.src.forge.ITextureProvider;

public class ZooTallGrass extends BlockFlower implements ITextureProvider
{

    public ZooTallGrass(int i, int j)
    {
        super(i, j, Material.vine);
        float f = 0.4F;
        blockIndexInTexture = j;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
    }
    
    public boolean isBlockReplaceable(World world, int x, int y, int z) 
    {
	    return true;
    }
    
    public boolean canThisPlantGrowOnThisBlockID(int i, int j)
    { 
    	if(blockID == Zoo.savannahgrass.blockID)
    	{
    		return i == ZooDirts.savannah.blockID;  
    	}
    	if(blockID == Zoo.coniferousgrass.blockID)
    	{
    		return i == ZooDirts.coniferous.blockID;
    	}else{
    		return false;
    	}
	    
    	
    }

    public int idDropped(int i, Random random, int j)
    {
        return -1;
    }

    public int quantityDroppedWithBonus(int i, Random random)
    {
        return 1 + random.nextInt(i * 2 + 1);
    }

    @Override
    public ArrayList<ItemStack> getBlockDropped(World world, int i, int j, int k, int md, int fortune)
    {
    	ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
    	if (world.rand.nextInt(8) != 0)
    	{
    		return ret;
    	}
    	
    	ItemStack item = ForgeHooks.getGrassSeed(world);
    	if (item != null)
    	{
    		ret.add(item);
    	}
    	return ret;
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        if(!world.isRemote && entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().itemID == Item.shears.shiftedIndex)
        {
        	if(blockID == Zoo.savannahgrass.blockID)
        	{
	            entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
	            dropBlockAsItem_do(world, i, j, k, new ItemStack(Zoo.savannahgrass, 1, l));
        	}if(blockID == Zoo.coniferousgrass.blockID)
            {
	            entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
	            dropBlockAsItem_do(world, i, j, k, new ItemStack(Zoo.coniferousgrass, 1, l));
            }
        } else
        {
            super.harvestBlock(world, entityplayer, i, j, k, l);
        }
    }

	public String getTextureFile() {
		return "/zoo/blocks.png";
	}
}
