package net.minecraft.src.zoo.core;

import java.util.ArrayList;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraft.src.forge.ITextureProvider;
import net.minecraft.src.zoo.api.Fence;
import net.minecraft.src.zoo.core.gen.StructureGenerator;

public class ZooBlockWall extends Block implements ITextureProvider{

	private StructureGenerator generator = new StructureGenerator();
	
	public ZooBlockWall(int i) {
		super(i, Material.wood);
	}


	public String getTextureFile() {
		return "/zoo/blocks.png";
	}
	
	public int getRenderBlockPass()
    {
        return 0;
    }
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	public int getBlockTextureFromSideAndMetadata(int i, int j)
	{		
		if((j == 0 || j == 4) && (i == 3 || i == 5))
		{
			return 41;
		}
		else if((j == 1 || j == 5) && (i == 2 || i == 5))
		{
			return 41;
		}
		else if((j == 2 || j == 6) && (i == 2 || i == 4))
		{
			return 41;
		}
		else if((j == 3 || j == 7) && (i == 3 || i == 4))
		{
			return 41;
		}
		return 42;
	}
	
	public static int blockid = Block.stoneBrick.blockID;
	
	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer) {
		
		int md = world.getBlockMetadata(i, j, k);
		
		if(!world.isRemote && j >= 60)
		{
			if(entityplayer.getCurrentEquippedItem() != null && Fence.getRotator().contains(entityplayer.getCurrentEquippedItem().itemID))
			{
				if(md == 0)
				{
					world.setBlockAndMetadataWithNotify(i, j, k, this.blockID, 1);
					entityplayer.getCurrentEquippedItem().damageItem(1, entityplayer);
				}
				if(md == 1)
				{
					world.setBlockAndMetadataWithNotify(i, j, k, this.blockID, 2);
					entityplayer.getCurrentEquippedItem().damageItem(1, entityplayer);
				}
				if(md == 2)
				{
					world.setBlockAndMetadataWithNotify(i, j, k, this.blockID, 3);
					entityplayer.getCurrentEquippedItem().damageItem(1, entityplayer);
				}
				if(md == 3)
				{
					world.setBlockAndMetadataWithNotify(i, j, k, this.blockID, 0);
					entityplayer.getCurrentEquippedItem().damageItem(1, entityplayer);
				}
			}else{
				if(md == 0)
	            {
	            	generate(world, i, j, k, 128);
	            }
	            if(md == 1)
	            {
	            	generateFrontLeft(world, i, j, k, 128);
	            }
	            if(md == 3)
	            {
	            	generateBackRight(world, i, j, k, 128);
	            }
	            if(md == 2)
	            {
	            	generateBackLeft(world, i, j, k, 128);
	            }
			}
		}else{
			super.blockActivated(world, i, j, k, entityplayer);
		}
		return true;
	}
	
	public void generate(World world, int x, int y, int z, int size)
	{
		generator.generateCuboid(world, x, y - 1, z, x + size, y + 4, z + size, blockid);
		generator.generateCuboid(world, x + 1, y, z + 1, x + size - 1, y + 4, z + size - 1, 0);
		generator.generateCuboid(world, x, y + 5, z, x + size, y + 20, z + size, 0);
	}
	
	public void generateFrontLeft(World world, int x, int y, int z, int size)
	{
		generator.generateCuboid(world, x, y - 1, z, x + size, y + 4, z - size, blockid);
		generator.generateCuboid(world, x + 1, y, z - 1, x + size - 1, y + 4, z - size + 1, 0);
		generator.generateCuboid(world, x, y + 5, z, x + size, y + 20, z - size, 0);
	}
	
	public void generateBackRight(World world, int x, int y, int z, int size)
	{
		generator.generateCuboid(world, x, y - 1, z, x - size, y + 4, z + size, blockid);
		generator.generateCuboid(world, x - 1, y, z + 1, x - size + 1, y + 4, z + size - 1, 0);
		generator.generateCuboid(world, x, y + 5, z, x - size, y + 20, z + size, 0);
	}
	
	public void generateBackLeft(World world, int x, int y, int z, int size)
	{
		generator.generateCuboid(world, x, y - 1, z, x - size, y + 4, z - size, blockid);
		generator.generateCuboid(world, x - 1, y, z - 1, x - size + 1, y + 4, z - size + 1, 0);
		generator.generateCuboid(world, x, y + 5, z, x - size, y + 20, z - size, 0);
	}

	public void addCreativeItems(ArrayList itemList)
    {
		itemList.add(new ItemStack(this, 1, 0));
    }
	
}
