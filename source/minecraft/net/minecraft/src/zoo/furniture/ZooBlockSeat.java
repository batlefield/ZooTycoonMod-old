package net.minecraft.src.zoo.furniture;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.World;

import org.lwjgl.opengl.GL11;

public abstract class ZooBlockSeat extends ZooFurnitureBase 
{
	public ZooBlockSeat(int a, int b, Class class1, Material mat)
	{
		super(a,b,class1,mat);
	}
	
	public int[] getSeatXYZ(World world, int x, int y, int z)
	{
		int[] array = {x,y,z};
		return array;
	}
	
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
    	if(entityplayer.ridingEntity == null)
    	{
    		int[] array = new int[3];
    		array = getSeatXYZ(world,i,j,k);
    		int x = array[0];
    		int y = array[1];
    		int z = array[2];
	    	ZooEntitySeat seat = new ZooEntitySeat(world, x, y, z, this);
	    	int m = world.getBlockMetadata(x,y,z);
	    	m %= 4;
	    	if(m == 0) entityplayer.rotationYaw = 90;
	        if(m == 1) entityplayer.rotationYaw = -90;
	        if(m == 2) entityplayer.rotationYaw = 180;
	        if(m == 3) entityplayer.rotationYaw = 0;
	    	
	    	world.spawnEntityInWorld(seat);
	    	entityplayer.mountEntity(seat);
    	}
    	else
    	{
    		if(entityplayer.ridingEntity instanceof ZooEntitySeat)
    		{
    			entityplayer.mountEntity(null);
    		}
    	}
    	return true;
    }
	
	public abstract float getSeatHeight();
}
