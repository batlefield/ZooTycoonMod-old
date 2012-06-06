package net.minecraft.src.zoo.api;

import java.util.ArrayList;

import net.minecraft.src.zoo.trading.GUIType;

public interface ITrade {
	
	/**
	 * This method returns price of a block/item
	 * @param i			ID of block/item
	 * @param j			metadata of block/item
	 * @return
	 */
	public int getPrice(int i, int j);
	
	/**
	 * This method adds your item/block to desired trader
	 * @param type		type of a GUI that provided list corresponds to
	 * @param list		list to which you add items
	 */
	public void addToGUI(GUIType type, ArrayList list);
	
}
