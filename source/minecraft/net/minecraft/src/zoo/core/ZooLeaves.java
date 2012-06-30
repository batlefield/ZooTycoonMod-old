package net.minecraft.src.zoo.core;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.BlockLeavesBase;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.StatList;
import net.minecraft.src.World;
import net.minecraft.src.Zoo;
import net.minecraft.src.forge.IShearable;
import net.minecraft.src.forge.ITextureProvider;

// Referenced classes of package net.minecraft.src:
//            BlockLeavesBase, Material, ColorizerFoliage, IBlockAccess, 
//            WorldChunkManager, BiomeGenBase, World, Block, 
//            EntityPlayer, ItemStack, Item, ItemShears, 
//            StatList, Entity

public class ZooLeaves extends Block implements ITextureProvider, IShearable
{

    private int baseIndexInPNG;
    int adjacentTreeBlocks[];

    public ZooLeaves(int i, int j)
    {
        super(i, j, Material.leaves);
        baseIndexInPNG = j;
        setTickRandomly(true);

    }
    
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
    	if(blockID == Zoo.deciLeaves.blockID)
    	{
    		switch(j & 3)
    		{
    			case 0:
    				return 47;
    			case 1:
    				return 48;
    			case 2:
    				return 49;
				default:
					return 48;
    			
    		}
    	}else{
    		return blockIndexInTexture;
    	}
    }
    
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        int var6 = par1IBlockAccess.getBlockId(par2, par3, par4);
        if(var6 == this.blockID)
        {
        	return false;
        }
        else {
        	return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
        }
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
        int l = 1;
        int i1 = l + 1;
        if(world.checkChunksExist(i - i1, j - i1, k - i1, i + i1, j + i1, k + i1))
        {
            for(int j1 = -l; j1 <= l; j1++)
            {
                for(int k1 = -l; k1 <= l; k1++)
                {
                    for(int l1 = -l; l1 <= l; l1++)
                    {
                        int i2 = world.getBlockId(i + j1, j + k1, k + l1);
                        if(i2 == Zoo.blueLeaves.blockID || i2 == Zoo.deciLeaves.blockID)
                        {
                            int j2 = world.getBlockMetadata(i + j1, j + k1, k + l1);
                            world.setBlockMetadata(i + j1, j + k1, k + l1, j2 | 8);
                        }
                    }

                }

            }

        }
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(world.isRemote)
        {
            return;
        }
        int l = world.getBlockMetadata(i, j, k);
        if((l & 8) != 0 && (l & 4) == 0)
        {
            byte byte0 = 4;
            int i1 = byte0 + 1;
            byte byte1 = 32;
            int j1 = byte1 * byte1;
            int k1 = byte1 / 2;
            if(adjacentTreeBlocks == null)
            {
                adjacentTreeBlocks = new int[byte1 * byte1 * byte1];
            }
            if(world.checkChunksExist(i - i1, j - i1, k - i1, i + i1, j + i1, k + i1))
            {
                for(int l1 = -byte0; l1 <= byte0; l1++)
                {
                    for(int k2 = -byte0; k2 <= byte0; k2++)
                    {
                        for(int i3 = -byte0; i3 <= byte0; i3++)
                        {
                            int k3 = world.getBlockId(i + l1, j + k2, k + i3);
                            if(k3 == Block.wood.blockID)
                            {
                                adjacentTreeBlocks[(l1 + k1) * j1 + (k2 + k1) * byte1 + (i3 + k1)] = 0;
                                continue;
                            }
                            if(k3 == Zoo.blueLeaves.blockID || k3 == Zoo.deciLeaves.blockID)
                            {
                                adjacentTreeBlocks[(l1 + k1) * j1 + (k2 + k1) * byte1 + (i3 + k1)] = -2;
                            } else
                            {
                                adjacentTreeBlocks[(l1 + k1) * j1 + (k2 + k1) * byte1 + (i3 + k1)] = -1;
                            }
                        }

                    }

                }

                for(int i2 = 1; i2 <= 4; i2++)
                {
                    for(int l2 = -byte0; l2 <= byte0; l2++)
                    {
                        for(int j3 = -byte0; j3 <= byte0; j3++)
                        {
                            for(int l3 = -byte0; l3 <= byte0; l3++)
                            {
                                if(adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] != i2 - 1)
                                {
                                    continue;
                                }
                                if(adjacentTreeBlocks[((l2 + k1) - 1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] == -2)
                                {
                                    adjacentTreeBlocks[((l2 + k1) - 1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] = i2;
                                }
                                if(adjacentTreeBlocks[(l2 + k1 + 1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] == -2)
                                {
                                    adjacentTreeBlocks[(l2 + k1 + 1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] = i2;
                                }
                                if(adjacentTreeBlocks[(l2 + k1) * j1 + ((j3 + k1) - 1) * byte1 + (l3 + k1)] == -2)
                                {
                                    adjacentTreeBlocks[(l2 + k1) * j1 + ((j3 + k1) - 1) * byte1 + (l3 + k1)] = i2;
                                }
                                if(adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1 + 1) * byte1 + (l3 + k1)] == -2)
                                {
                                    adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1 + 1) * byte1 + (l3 + k1)] = i2;
                                }
                                if(adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1) * byte1 + ((l3 + k1) - 1)] == -2)
                                {
                                    adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1) * byte1 + ((l3 + k1) - 1)] = i2;
                                }
                                if(adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1) * byte1 + (l3 + k1 + 1)] == -2)
                                {
                                    adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1) * byte1 + (l3 + k1 + 1)] = i2;
                                }
                            }

                        }

                    }

                }

            }
            int j2 = adjacentTreeBlocks[k1 * j1 + k1 * byte1 + k1];
            if(j2 >= 0)
            {
                world.setBlockMetadata(i, j, k, l & -9);
            } else
            {
                removeLeaves(world, i, j, k);
            }
        }
    }

    private void removeLeaves(World world, int i, int j, int k)
    {
        dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
        world.setBlockWithNotify(i, j, k, 0);
    }

    public int quantityDropped(Random random)
    {
        return random.nextInt(20) != 0 ? 0 : 1;
    }

    public int idDropped(int i, Random random, int j)
    {
        return Block.sapling.blockID;
    }
    
    public boolean isOpaqueCube()
    {
    	return false;
    }

    public void onEntityWalking(World world, int i, int j, int k, Entity entity)
    {
        super.onEntityWalking(world, i, j, k, entity);
    }

	public String getTextureFile() {
		return "/zoo/blocks.png";
	}
	
    public boolean isShearable(ItemStack item, World world, int X, int Y, int Z) 
    {
        return true;
    }
    
    public ArrayList<ItemStack> onSheared(ItemStack item, World world, int X, int Y, int Z, int fortune) 
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
    	if(blockID == Zoo.blueLeaves.blockID)
    	{
        	ret.add(new ItemStack(Zoo.blueLeaves.blockID, 1, 0));
    	}
    	if(blockID == Zoo.acaciaLeaves.blockID)
    	{
    		ret.add(new ItemStack(Zoo.acaciaLeaves.blockID, 1, 0));
    	}
    	if(blockID == Zoo.deciLeaves.blockID)
    	{
    		ret.add(new ItemStack(Zoo.deciLeaves.blockID, 1, 0));
    	}
        return ret;
    }
	
}
