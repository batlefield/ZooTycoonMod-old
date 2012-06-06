package net.minecraft.src.zoo.core;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraft.src.forge.IGuiHandler;

public class GuiHandlerCore implements IGuiHandler
{

	public Object getGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileentity = null;

        if (!world.blockExists(x, y, z))
        {
            return null;
        }

        tileentity = world.getBlockTileEntity(x, y, z);
        
        if(ID == GUIIDEnum.EXHIBIT_TOOL.ID)
        {
        	return new GuiFencer((TileEntityFencer)tileentity, player);
        }
		return null;
	}

}
