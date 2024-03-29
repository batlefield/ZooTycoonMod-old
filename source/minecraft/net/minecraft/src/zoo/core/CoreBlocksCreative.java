package net.minecraft.src.zoo.core;

import java.util.ArrayList;

import net.minecraft.src.ItemStack;
import net.minecraft.src.Zoo;
import net.minecraft.src.ZooDirts;
import net.minecraft.src.BAPI.interfaces.ICreativeHandler;

public class CoreBlocksCreative implements ICreativeHandler{

	public void addCreativeItems(ArrayList itemList) {
		itemList.add(new ItemStack(Zoo.meat, 0, 1));
		itemList.add(new ItemStack(Zoo.meat, 0, 2));
		itemList.add(new ItemStack(Zoo.meat, 0, 3));
	}

	public void addCreativeBlocks(ArrayList itemList) {
		itemList.add(new ItemStack(Zoo.fencer));
		itemList.add(new ItemStack(Zoo.acorns));
		itemList.add(new ItemStack(Zoo.plexiglass));
		itemList.add(new ItemStack(Zoo.plexiglassBlock));
		itemList.add(new ItemStack(Zoo.Bfence));
		itemList.add(new ItemStack(Zoo.Ofence));
		itemList.add(new ItemStack(Zoo.Gfence));
		itemList.add(new ItemStack(Zoo.fence));
		itemList.add(new ItemStack(Zoo.Quicksand));
		itemList.add(new ItemStack(Zoo.grounder, 1, 0));
		itemList.add(new ItemStack(ZooDirts.coniferous));
		itemList.add(new ItemStack(ZooDirts.coniPeat));
		itemList.add(new ItemStack(ZooDirts.deciduous));
		itemList.add(new ItemStack(ZooDirts.deciPeat));
		itemList.add(new ItemStack(ZooDirts.gleyPeat));
		itemList.add(new ItemStack(ZooDirts.laterite));
		itemList.add(new ItemStack(Zoo.brownStone));
		itemList.add(new ItemStack(ZooDirts.mesa));
		itemList.add(new ItemStack(ZooDirts.rainforest));
		itemList.add(new ItemStack(ZooDirts.savannah));
		itemList.add(new ItemStack(ZooDirts.tropical));
		itemList.add(new ItemStack(Zoo.acaciaLeaves, 1, 8));
		itemList.add(new ItemStack(Zoo.blueLeaves, 1, 8));
		itemList.add(new ItemStack(Zoo.deciLeaves, 1, 0));
		itemList.add(new ItemStack(Zoo.deciLeaves, 1, 1));
		itemList.add(new ItemStack(Zoo.deciLeaves, 1, 2));
		itemList.add(new ItemStack(Zoo.sapling, 1, 0));
		itemList.add(new ItemStack(Zoo.sapling, 1, 1));
		itemList.add(new ItemStack(Zoo.sapling, 1, 2));
		itemList.add(new ItemStack(Zoo.savannahgrass));
		itemList.add(new ItemStack(Zoo.coniferousgrass));
		itemList.add(new ItemStack(Zoo.asphalt));
		itemList.add(new ItemStack(Zoo.concrete));
	}

}
