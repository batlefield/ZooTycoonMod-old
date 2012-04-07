package net.minecraft.src.zoo.trading;

import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
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
		if (this.shiftedIndex == mod_ZooTrade.shopkeeperblockdouble.blockID)
		{
			return mod_ZooTrade.shopkeeperblockdouble.getBlockTextureFromSideAndMetadata(0, i);
		}
		else if (this.shiftedIndex == mod_ZooTrade.shopkeeperblockdouble2.blockID)
		{
			return mod_ZooTrade.shopkeeperblockdouble2.getBlockTextureFromSideAndMetadata(0, i);
		}
		return mod_ZooTrade.shopkeeperblockdouble.getBlockTextureFromSideAndMetadata(0, i);
	}

	public String getTextureFile()
	{
		return "/zoo/blocks.png";
	}

	public String getItemNameIS(ItemStack itemstack)
	{
		if (itemstack.itemID == mod_ZooTrade.shopkeeperblockdouble.blockID)
		{
			return blockNames[itemstack.getItemDamage() / 4];
		}
		else if (itemstack.itemID == mod_ZooTrade.shopkeeperblockdouble2.blockID)
		{
			return blockNames2[itemstack.getItemDamage() / 4];
		}
		return "null";
	}

	public static final String blockNames[] =
	{
			"tile.shop.food", "tile.shop.dirt", "tile.shop.diamond", "tile.shop.technic"
	};

	public static final String blockNames2[] =
	{
			"tile.shop.potion", "tile.shop.armor", "tile.shop.decoration", "tile.shop.nature"
	};
}
