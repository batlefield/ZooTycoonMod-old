package net.minecraft.src.zoo.core;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;

public class ZooPlatform {
	
	public static File getMinecraftDir()
	{
		return Minecraft.getMinecraftDir();
	}
	
	public static int getFreeBiomeID(int preferred)
	{
		for(int i = preferred; i < BiomeGenBase.biomeList.length; i++)
		{
			if(BiomeGenBase.biomeList[i] == null)
			{
				return i;
			}
		}
		for(int i = preferred - 1; i > 0; i--)
		{
			if(BiomeGenBase.biomeList[i] == null)
			{
				return i;
			}
		}
		return -1;
	}

}
