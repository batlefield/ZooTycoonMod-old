package net.minecraft.src.zoo.core;

import java.util.ArrayList;

import net.minecraft.src.*;
import net.minecraft.src.forge.*;

public class ItemSaltwaterBucket extends ItemBucket implements IBucketHandler, ITextureProvider {

	public ItemSaltwaterBucket(int id, int blockid, int icon) {
		super(id, blockid);
		setIconIndex(icon);
	}

	public ItemStack fillCustomBucket(World w, int i, int j, int k) {
			if(w.getBlockId(i, j, k) == Zoo.saltwaterStill.blockID || w.getBlockId(i, j, k) == Zoo.saltwaterMoving.blockID)
			{
				w.setBlockWithNotify(i, j, k, 0);
				
				return new ItemStack(this);
			}
		
		return null;
	}

	public String getTextureFile() {
		return "/zoo/items.png";
	}
	
}
