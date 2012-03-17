package net.minecraft.src.zoo.core;

import net.minecraft.src.Block;
import net.minecraft.src.ZooDirts;
import net.minecraft.src.battlefield.API.IPlantable;

public class ZooPlantHandler implements IPlantable {

	public boolean canPlantFlower(int flowerID, int plantableID, int plantableMeta) {
		if(flowerID == Block.plantRed.blockID)
		{
			return plantableID == ZooDirts.coniferous.blockID || plantableID == ZooDirts.deciduous.blockID
			|| plantableID == ZooDirts.savannah.blockID || plantableID == ZooDirts.rainforest.blockID || plantableID == ZooDirts.tropical.blockID;
		}
		return false;
	}

	public boolean canCactusGrowOn(int plantableID, int plantableMeta) {
		return plantableID == ZooDirts.savannah.blockID;
	}

	public boolean canReedGrowOn(int plantableID, int plantableMeta) {
		return plantableID == ZooDirts.coniferous.blockID || plantableID == ZooDirts.deciduous.blockID || plantableID == ZooDirts.savannah.blockID || plantableID == ZooDirts.rainforest.blockID || plantableID == ZooDirts.tropical.blockID;
	}

}
