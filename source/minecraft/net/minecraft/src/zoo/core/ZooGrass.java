package net.minecraft.src.zoo.core;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.forge.*;
import net.minecraft.src.*;
public class ZooGrass extends Block implements ITextureProvider {
	
	public ZooGrass(int i)
	{
		super (i, Material.ground);
		setTickRandomly(true);
	}
	public int getBlockTextureFromSide(int i)
    {
        if(i == 1)
        {
            if(blockID == ZooDirts.savannah.blockID)
            {
            	return 2;
            }
            if(blockID == ZooDirts.tropical.blockID)
            {
            	return 6;
            }
            if(blockID == ZooDirts.coniferous.blockID)
            {
            	return 8;
            }
            if(blockID == ZooDirts.deciduous.blockID)
            {
            	return 22;
            }
        }
        if(i == 0)
        {
        	if(blockID == ZooDirts.savannah.blockID)
            {
            	return 32;
            }
        	if(blockID == ZooDirts.tropical.blockID)
            {
            	return 19;
            }
        	if(blockID == ZooDirts.coniferous.blockID)
            {
            	return 11;
            }
        	if(blockID == ZooDirts.deciduous.blockID)
            {
            	return 19;
            }
        }
        if(i == 2 || i == 3 || i == 4 || i == 5)
        {
        	if(blockID == ZooDirts.savannah.blockID)
            {
            	return 3;
            }
        	if(blockID == ZooDirts.tropical.blockID)
            {
            	return 7;
            }
        	if(blockID == ZooDirts.coniferous.blockID)
            {
            	return 9;
            }
        	if(blockID == ZooDirts.deciduous.blockID)
            {
            	return 23;
            }
        }
        return 0;
    }
	
	 public void updateTick(World world, int i, int j, int k, Random random)
	    {
	        if(world.isRemote)
	        {
	            return;
	        }
	        if(world.getBlockLightValue(i, j + 1, k) < 4 && Block.lightOpacity[world.getBlockId(i, j + 1, k)] > 2)
	        {
	            world.setBlockWithNotify(i, j, k, Block.dirt.blockID);
	        } else
	        if(world.getBlockLightValue(i, j + 1, k) >= 9)
	        {
	            for(int l = 0; l < 4; l++)
	            {
	                int i1 = (i + random.nextInt(3)) - 1;
	                int j1 = (j + random.nextInt(5)) - 3;
	                int k1 = (k + random.nextInt(3)) - 1;
	                int l1 = world.getBlockId(i1, j1 + 1, k1);
	                if(world.getBlockId(i1, j1, k1) == Block.dirt.blockID && world.getBlockLightValue(i1, j1 + 1, k1) >= 4 && Block.lightOpacity[l1] <= 2)
	                {
	                	if(blockID == ZooDirts.savannah.blockID)
	                	{
	                    	world.setBlockWithNotify(i1, j1, k1, ZooDirts.savannah.blockID);
	                	}
	                	if(blockID == ZooDirts.tropical.blockID)
	                	{
	                    	world.setBlockWithNotify(i1, j1, k1, ZooDirts.tropical.blockID);
	                	}
	                	if(blockID == ZooDirts.coniferous.blockID)
	                	{
	                    	world.setBlockWithNotify(i1, j1, k1, ZooDirts.coniferous.blockID);
	                	}
	                	if(blockID == ZooDirts.deciduous.blockID)
	                	{
	                    	world.setBlockWithNotify(i1, j1, k1, ZooDirts.deciduous.blockID);
	                	}
	                }
	            }

	        }
	    }
	
	public int idDropped(int i, Random random, int j)
    {
        return Block.dirt.idDropped(0, random, j);
    }

	public String getTextureFile() {
		return "/zoo/blocks.png";
	}
}
