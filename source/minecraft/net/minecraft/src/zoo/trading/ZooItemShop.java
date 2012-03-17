package net.minecraft.src.zoo.trading;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Zoo;
import net.minecraft.src.mod_ZooTrade;
import net.minecraft.src.forge.ITextureProvider;

public class ZooItemShop extends ItemBlock implements ITextureProvider
{
    public ZooItemShop(int i)
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
        return mod_ZooTrade.shopkeeperblockdouble.getBlockTextureFromSideAndMetadata(0, i);
    }

	public String getTextureFile() {
		return "/zoo/blocks.png";
	}
}
