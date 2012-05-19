package net.minecraft.src.zoo.core;

import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Zoo;
import net.minecraft.src.forge.ITextureProvider;

public class ZooItemLeaves extends ItemBlock implements ITextureProvider
{
    public ZooItemLeaves(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    public int getMetadata(int i)
    {
        return i | 4;
    }

    public int getIconFromDamage(int i)
    {
        return Zoo.blueLeaves.getBlockTextureFromSideAndMetadata(0, i);
    }
    
	public String getTextureFile() {
		return "/zoo/blocks.png";
	}
	
	
	public String getItemNameIS(ItemStack itemstack)
    {
		if(itemstack.itemID == Zoo.blueLeaves.blockID)
	        if(itemstack.getItemDamage() == 0)
	        {
	        	return blockNames[0];
	        }else{
	        	return blockNames[2];
	        }
		else
			if(itemstack.getItemDamage() == 0)
	        {
	        	return blockNames[1];
	        }else{
	        	return blockNames[2];
	        }
    }
    public static final String blockNames[] = {
        "bluepine", "savannah", "null"
    };
}
