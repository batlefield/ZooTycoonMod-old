package net.minecraft.src.zoo.core;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityList;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumMovingObjectType;
import net.minecraft.src.ModLoader;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;
import net.minecraft.src.BAPI.interfaces.INBT;

public class TaggedEntitiesSave implements INBT
{
	private static boolean[] tagged = new boolean[1024];

	public static void setTagged(MovingObjectPosition mop)
	{
		if(mop.typeOfHit == EnumMovingObjectType.ENTITY)
		{
			if(!(mop.entityHit instanceof EntityPlayer))
			{
				if(tagged[EntityList.getEntityID(mop.entityHit)] == false)
				{
					tagged[EntityList.getEntityID(mop.entityHit)] = true;
					ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Succesfully tagged " + EntityList.getEntityString(mop.entityHit));
				}
			}
		}
	}

	public String nbtName()
	{
		return "TaggedEntities";
	}

	public void writeToNBT(NBTTagCompound nbttagcompound)
	{
		for(int i = 0; i < tagged.length; i++)
		{
			if(tagged[i] == true)
			{
				nbttagcompound.setBoolean("ID" + i, true);
			}
		}
	}

	public void readFromNBT(NBTTagCompound nbttagcompound)
	{
		for(int i = 0; i < tagged.length; i++)
		{
			boolean b = nbttagcompound.getBoolean("ID" + i);
			if(b == true)
			{
				tagged[i] = true;
			}
		}
	}
	
	public static boolean[] getTagged()
	{
		return tagged;
	}

	public void beforeWorldLoad()
	{
		tagged = new boolean[1024];
	}

}
