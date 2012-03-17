package net.minecraft.src.zoo.core;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Zoo;
import net.minecraft.src.forge.ITextureProvider;

public class ZooItemFencer extends ItemBlock implements ITextureProvider
{
    public ZooItemFencer(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    public int getMetadata(int i)
    {
        return i;
    }

    public int getIconFromDamage(int i)
    {
        return Zoo.fencer.getBlockTextureFromSideAndMetadata(0, i);
    }

	public String getTextureFile() {
		return "/zoo/blocks.png";
	}
	
	public String getItemNameIS(ItemStack itemstack)
    {
        if(itemstack.getItemDamage() == 0)
        {
        	return blockNames[0];
        }
        if(itemstack.getItemDamage() == 4)
        {
        	return blockNames[1];
        }else{
        	return blockNames[2];
        }
    }
    public static final String blockNames[] = {
        "tile.extool16", "tile.extool32", "tile.extool"
    };
}
