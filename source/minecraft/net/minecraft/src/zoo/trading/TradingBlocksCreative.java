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
		itemList.add(new ItemStack(mod_ZooTrade.shopBlock));
		itemList.add(new ItemStack(mod_ZooTrade.safe));
	}

}
