package net.minecraft.src.zoo.core;

import net.minecraft.src.Block;
import net.minecraft.src.Zoo;
import net.minecraft.src.ZooDirts;
import net.minecraft.src.BAPI.interfaces.*;;

public class ZooPlaceableHandler implements IPlacable {

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

	public boolean canPlaceTorchOn(int placeableID, int placeableMeta) {
		return placeableID == Zoo.Bfence.blockID || placeableID == Zoo.Gfence.blockID || placeableID == Zoo.Ofence.blockID || placeableID == Zoo.fence.blockID;
	}

}
