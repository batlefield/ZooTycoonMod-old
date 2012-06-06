package net.minecraft.src.zoo.core;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class TileEntityBase extends TileEntity
{
	public void blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
	{
		
	}
	
	public int getX()
	{
		return MathHelper.floor_double(xCoord);
	}
	
	public int getY()
	{
		return MathHelper.floor_double(yCoord);
	}
	
	public int getZ()
	{
		return MathHelper.floor_double(zCoord);
	}
}
