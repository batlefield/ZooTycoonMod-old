package net.minecraft.src.zoo.dimension;

import java.util.ArrayList;

import net.minecraft.src.ItemStack;
import net.minecraft.src.ZooDimension;
import net.minecraft.src.BAPI.interfaces.ICreativeHandler;

public class DimensionBlocksCreative implements ICreativeHandler {

	public void addCreativeItems(ArrayList itemList) {

	}

	public void addCreativeBlocks(ArrayList itemList) {
		itemList.add(new ItemStack(ZooDimension.portalCreator));
	}

}
