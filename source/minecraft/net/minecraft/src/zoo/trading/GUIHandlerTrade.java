package net.minecraft.src.zoo.trading;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraft.src.forge.IGuiHandler;
import net.minecraft.src.zoo.core.GUIIDEnum;

public class GUIHandlerTrade implements IGuiHandler{

	public Object getGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileentity = null;

		if(!isEntityGui(ID))
		{
	        if (!world.blockExists(x, y, z))
	        {
	            return null;
	        }
		}

        tileentity = world.getBlockTileEntity(x, y, z);
        
        if(ID == GUIIDEnum.SHOP_BLOCK_SETTINGS.ID)
        {
        	return new GUIShop((TileEntityShop) tileentity);
        }
        
        if(ID == GUIIDEnum.SHOP_DECOR.ID)
        {
        	return new ZooGuiContainerTradingDecor(player);
        }
        
        if(ID == GUIIDEnum.SHOP_DIRT.ID)
        {
        	return new ZooGuiContainerTradingDirt();
        }
        
        if(ID == GUIIDEnum.SHOP_FENCING.ID)
        {
        	return new ZooGuiContainerTradingFencing();
        }
        
        if(ID == GUIIDEnum.SHOP_FOOD.ID)
        {
        	return new ZooGuiContainerTradingFood();
        }
        
        if(ID == GUIIDEnum.SHOP_PLANTS.ID)
        {
        	return new ZooGuiContainerTradingPlants();
        }
        
        if(ID == GUIIDEnum.SHOP_POTION.ID)
        {
        	return new ZooGuiContainerTradingPotion();
        }
        
        if(ID == GUIIDEnum.SHOP_SPECIAL.ID)
        {
        	return new ZooGuiContainerTradingSpecial();
        }
        
        if(ID == GUIIDEnum.SHOP_TECH.ID)
        {
        	return new ZooGuiContainerTradingTech();
        }
        
        if(ID == GUIIDEnum.SHOP_TOOLS.ID)
        {
        	return new ZooGuiContainerTradingTools(player);
        }
        
        else
        {
        	return null;
        }
	}
	
	public static boolean isEntityGui(int i)
	{
		return i == GUIIDEnum.SHOP_DECOR.ID || i == GUIIDEnum.SHOP_DIRT.ID || i == GUIIDEnum.SHOP_FENCING.ID || i == GUIIDEnum.SHOP_FOOD.ID || i == GUIIDEnum.SHOP_PLANTS.ID || i == GUIIDEnum.SHOP_POTION.ID || i == GUIIDEnum.SHOP_SPECIAL.ID || i == GUIIDEnum.SHOP_TECH.ID || i == GUIIDEnum.SHOP_TOOLS.ID;
	}
}
