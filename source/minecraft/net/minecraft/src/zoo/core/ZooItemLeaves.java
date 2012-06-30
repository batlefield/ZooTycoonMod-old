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
    	if(getBlockID() == Zoo.blueLeaves.blockID)
    	{
    		return Zoo.blueLeaves.getBlockTextureFromSideAndMetadata(0, i);
    	}else if(getBlockID() == Zoo.deciLeaves.blockID)
		{
    		return Zoo.deciLeaves.getBlockTextureFromSideAndMetadata(0, i);
		}
    	else{
    		return Zoo.acaciaLeaves.getBlockTextureFromSideAndMetadata(0, i);
    	}
    }
    
	public String getTextureFile() {
		return "/zoo/blocks.png";
	}
	
	
	public String getItemNameIS(ItemStack itemstack)
    {
		if(itemstack.itemID == Zoo.blueLeaves.blockID)
		{
	        return blockNames[0];
		}else if(itemstack.itemID == Zoo.deciLeaves.blockID)
		{
			return blockNames[2];
		}
		else
		{
        	return blockNames[1];
		}
    }
    public static final String blockNames[] = {
        "bluepine", "savannah", "deciduous", "null"
    };
}
