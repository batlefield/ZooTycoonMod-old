package net.minecraft.src.zoo.furniture;

import java.io.*;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class ZooEntitySeat extends Entity {
	
	ZooBlockSeat blockObj;
	Entity lastPlayer;
	boolean isFirstUpdate = true;

	public ZooEntitySeat(World world)
	{
		super(world);
	}
	public ZooEntitySeat(World world, int i, int j, int k, ZooBlockSeat obj1)
	{
		super(world);
        setPosition(i + 0.5D,j,k + 0.5D);
        motionX = 0.0D;
        motionY = 0.0D;
        motionZ = 0.0D;
        prevPosX = i;
        prevPosY = j;
        prevPosZ = k;
        renderDistanceWeight = 0;
        blockObj = obj1;
        setSize(0,0);
	}
	
	@Override
	public double getMountedYOffset()
	{
		return blockObj.getSeatHeight();
	}
	
	@Override
	public void onEntityUpdate()
	{
		if(riddenByEntity == null)
		{
			kill();

		}
		else
		{
			int blockId = worldObj.getBlockId((int)(posX - 0.5D), (int)posY, (int)(posZ - 0.5D));
			
			if(!(Block.blocksList[blockId] instanceof ZooBlockSeat))
			{
				riddenByEntity.mountEntity(null);
			} 
		}
		
		lastPlayer = riddenByEntity;
	}
	
	@Override
    protected void entityInit()
    {
    }

	@Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
    }

	@Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
    }
}
