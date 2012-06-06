package net.minecraft.src.zoo.core;

import net.minecraft.src.mod_ZooCore;

public enum GUIIDEnum {

	
	SHOP_DECOR(mod_ZooCore.getGeneralInt("GUI DECOR", 0)),
	SHOP_DIRT(mod_ZooCore.getGeneralInt("GUI DIRT", 1)),
	SHOP_FENCING(mod_ZooCore.getGeneralInt("GUI FENCING", 2)),
	SHOP_FOOD(mod_ZooCore.getGeneralInt("GUI FOOD", 3)),
	SHOP_PLANTS(mod_ZooCore.getGeneralInt("GUI PLANTS", 4)),
	SHOP_POTION(mod_ZooCore.getGeneralInt("GUI POTION", 5)),
	SHOP_SPECIAL(mod_ZooCore.getGeneralInt("GUI SPECIAL", 6)),
	SHOP_TECH(mod_ZooCore.getGeneralInt("GUI TECH", 7)),
	SHOP_TOOLS(mod_ZooCore.getGeneralInt("GUI TOOLS", 8)),
	SHOP_BLOCK_SETTINGS(mod_ZooCore.getGeneralInt("GUI SHOP SETTINGS", 10)),
	SAFE_LOCKED(mod_ZooCore.getGeneralInt("GUI SAFE LOCKED", 11)),
	SAFE_UNLOCKED(mod_ZooCore.getGeneralInt("GUI SAFE UNLOCKED", 12)),
	EXHIBIT_TOOL(mod_ZooCore.getGeneralInt("GUI EXHIBIT TOOL", 13)),
	OPTIONS(mod_ZooCore.getGeneralInt("GUI OPTIONS", 14));
	
	
	public int ID;
	
	GUIIDEnum(int id)
	{
		this.ID = id;
	}
	
}
