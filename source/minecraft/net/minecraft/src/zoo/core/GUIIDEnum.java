package net.minecraft.src.zoo.core;

import net.minecraft.src.mod_ZooCore;

public enum GUIIDEnum {

	
	SHOP_DECOR(mod_ZooCore.getGeneralInt("GUI_DECOR", 0)),
	SHOP_DIRT(mod_ZooCore.getGeneralInt("GUI_DIRT", 1)),
	SHOP_FENCING(mod_ZooCore.getGeneralInt("GUI_FENCING", 2)),
	SHOP_FOOD(mod_ZooCore.getGeneralInt("GUI_FOOD", 3)),
	SHOP_PLANTS(mod_ZooCore.getGeneralInt("GUI_PLANTS", 4)),
	SHOP_POTION(mod_ZooCore.getGeneralInt("GUI_POTION", 5)),
	SHOP_SPECIAL(mod_ZooCore.getGeneralInt("GUI_SPECIAL", 6)),
	SHOP_TECH(mod_ZooCore.getGeneralInt("GUI_TECH", 7)),
	SHOP_TOOLS(mod_ZooCore.getGeneralInt("GUI_TOOLS", 8)),
	SHOP_BLOCK(mod_ZooCore.getGeneralInt("GUI_BLOCK", 9)),
	SHOP_BLOCK_SETTINGS(mod_ZooCore.getGeneralInt("GUI_SHOP_SETTINGS", 10));
	
	
	public int ID;
	
	GUIIDEnum(int id)
	{
		this.ID = id;
	}
	
}
