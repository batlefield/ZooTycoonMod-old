package net.minecraft.src.zoo.dimension;

import java.util.ArrayList;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraft.src.Zoo;
import net.minecraft.src.ZooDimension;
import net.minecraft.src.ZooDirts;
import net.minecraft.src.zoo.core.gen.StructureGenerator;

public class PortalTool extends ZooBlockDim {

	private StructureGenerator generator = new StructureGenerator();
	
	public PortalTool(int i, int j, Material material) {
		super(i, j, material);
	}
	
	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer) {
		if(!world.isRemote && entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().itemID == Item.feather.shiftedIndex)
		{
			createPortal(world, i, j, k);
		}
		return super.blockActivated(world, i, j, k, entityplayer);
	}

	private void createPortal(World world, int i, int j, int k) {
		int bs = Zoo.brownStone.blockID;
		int p = ZooDimension.portal.blockID;
		int slab;
		
		if(world.getBlockId(i, j - 1, k) == Block.sand.blockID || world.getBlockId(i, j - 1, k) == Block.sandStone.blockID || world.getBlockId(i, j - 1, k) == ZooDirts.savannah.blockID)
		{
			slab = 1;
		}else{
			slab = 5;
		}
		
		world.editingBlocks = true;
		
		generator.generateCuboid(world, i - 3, j, k - 3, i + 3, j + 4, k + 3, 0);
		generator.generateFloor(world, j, i - 3, k - 3, i + 3, k + 3, Block.stairSingle.blockID, slab);
		generator.generateFloor(world, j, i - 2, k - 2, i + 2, k + 2, bs);
		generator.generateFloor(world, j + 3, i - 1, k - 1, i + 1, k + 1, bs);
		
		generator.placeBlock(world, i + 1, j + 1, k + 1, bs);
		generator.placeBlock(world, i + 1, j + 1, k - 1, bs);
		generator.placeBlock(world, i - 1, j + 1, k + 1, bs);
		generator.placeBlock(world, i - 1, j + 1, k - 1, bs);
		
		generator.placeBlock(world, i + 1, j + 2, k + 1, bs);
		generator.placeBlock(world, i + 1, j + 2, k - 1, bs);
		generator.placeBlock(world, i - 1, j + 2, k + 1, bs);
		generator.placeBlock(world, i - 1, j + 2, k - 1, bs);
		
		generator.placeBlock(world, i, j + 4, k, bs);
		generator.placeBlock(world, i, j + 1, k, Block.torchWood.blockID);
		
		generator.placeBlock(world, i + 1, j + 1, k, p);
		generator.placeBlock(world, i, j + 1, k - 1, p);
		generator.placeBlock(world, i, j + 1, k + 1, p);
		generator.placeBlock(world, i - 1, j + 1, k, p);
		
		generator.placeBlock(world, i + 1, j + 2, k, p);
		generator.placeBlock(world, i, j + 2, k - 1, p);
		generator.placeBlock(world, i, j + 2, k + 1, p);
		generator.placeBlock(world, i - 1, j + 2, k, p);
		
		
		world.editingBlocks = false;
	}
	
	public void addCreativeItems(ArrayList itemList)
    {    	
		itemList.add(new ItemStack(this));
    }

}
