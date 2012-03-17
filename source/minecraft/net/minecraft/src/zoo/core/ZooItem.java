package net.minecraft.src.zoo.core;

import net.minecraft.src.Item;
import net.minecraft.src.forge.ITextureProvider;

public class ZooItem extends Item implements ITextureProvider{

	public ZooItem(int i) {
		super(i);
	}
	
	public String getTextureFile() {
		return "/zoo/items.png";
	}
	
}
