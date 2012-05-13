package net.minecraft.src.zoo.core;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.BlockFlower;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenBigTree;
import net.minecraft.src.WorldGenForest;
import net.minecraft.src.WorldGenTaiga2;
import net.minecraft.src.WorldGenTrees;
import net.minecraft.src.WorldGenerator;
import net.minecraft.src.Zoo;
import net.minecraft.src.ZooDirts;
import net.minecraft.src.forge.ITextureProvider;
import net.minecraft.src.zoo.core.gen.ZooGenBluePine2;
import net.minecraft.src.zoo.core.gen.ZooGenDeciTree;
import net.minecraft.src.zoo.core.gen.ZooGenUmbrellaThornAcacia;

public class ZooSapling extends BlockFlower implements ITextureProvider
{
    public ZooSapling(int i, int j)
    {
        super(i, j);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
    }
    
    protected boolean canThisPlantGrowOnThisBlockID(int i, int j)
    {
        return i == ZooDirts.savannah.blockID || i == ZooDirts.coniferous.blockID || i == ZooDirts.deciduous.blockID;
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if (world.isRemote)
        {
            return;
        }
        super.updateTick(world, i, j, k, random);
        if (world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(7) == 0)
        {
            int l = world.getBlockMetadata(i, j, k);
            if ((l & 8) == 0)
            {
                world.setBlockMetadataWithNotify(i, j, k, l | 8);
            }
            else
            {
                growTree(world, i, j, k, random);
            }
        }
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if (j == 1)
        {
            return 45;
        }
        if (j == 2)
        {
            return 46;
        }
        else
        {
            return super.getBlockTextureFromSideAndMetadata(i, j);
        }
    }

    public void growTree(World world, int i, int j, int k, Random random)
    {
    	if(world.getBlockId(i, j, k) == Zoo.sapling.blockID)
    	{
	    	int l = world.getBlockMetadata(i, j, k) & 3;  
	        Object obj = null;
	        if (l == 1)
	        {
	        	world.setBlock(i, j, k, 0);
	            obj = new ZooGenBluePine2(true);
	        }
	        else if (l == 2)
	        {
	        	world.setBlock(i, j, k, 0);
	            obj = new ZooGenDeciTree(true);
	        }
	        else if (l == 0)
	        {
	        	world.setBlock(i, j, k, 0);
	            obj = new ZooGenUmbrellaThornAcacia(true);
	        }else{
	        	return;
	        }
	        if (!((WorldGenerator) (obj)).generate(world, random, i, j, k))
	        {
	            world.setBlockAndMetadata(i, j, k, blockID, l);
	        }
    	}else{
    		return;
    	}
    }

    protected int damageDropped(int i)
    {
        return i & 3;
    }

	@Override
	public String getTextureFile() {
		return "/zoo/blocks.png";
	}
	
}
