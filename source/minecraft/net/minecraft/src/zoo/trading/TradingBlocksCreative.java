package net.minecraft.src.zoo.trading;

import java.util.ArrayList;

import net.minecraft.src.ItemStack;
import net.minecraft.src.mod_ZooTrade;
import net.minecraft.src.BAPI.interfaces.ICreativeHandler;

public class TradingBlocksCreative implements ICreativeHandler {

	public void addCreativeItems(ArrayList itemList) {
		itemList.add(new ItemStack(mod_ZooTrade.Coin, 1, 1));
		itemList.add(new ItemStack(mod_ZooTrade.Coin, 1, 2));
	}

	public void addCreativeBlocks(ArrayList itemList) {
		itemList.add(new ItemStack(mod_ZooTrade.shopkeeperblockdouble, 1, 0));
		itemList.add(new ItemStack(mod_ZooTrade.shopkeeperblockdouble, 1, 4));
		itemList.add(new ItemStack(mod_ZooTrade.shopkeeperblockdouble, 1, 8));
		itemList.add(new ItemStack(mod_ZooTrade.shopkeeperblockdouble, 1, 12));
		itemList.add(new ItemStack(mod_ZooTrade.shopkeeperblockdouble2, 1, 0));
		itemList.add(new ItemStack(mod_ZooTrade.shopkeeperblockdouble2, 1, 4));
		itemList.add(new ItemStack(mod_ZooTrade.shopkeeperblockdouble2, 1, 8));
		itemList.add(new ItemStack(mod_ZooTrade.shopkeeperblockdouble2, 1, 12));
	}

}
