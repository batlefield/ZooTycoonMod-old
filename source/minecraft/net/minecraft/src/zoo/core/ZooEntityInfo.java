package net.minecraft.src.zoo.core;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.src.forge.Configuration;

public class ZooEntityInfo
{
	static EntityConfig config = new EntityConfig(new File(Minecraft.getMinecraftDir(), "Zoo/Core/Entity config.cfg"));
	
	public static int getEntityID(String s, int i)
	{
		config.load();
		config.getOrCreateIntProperty(s, config.ENTITY_ID, i);
		config.save();
		return new Integer(config.getOrCreateIntProperty(s, config.ENTITY_ID, i).value).intValue();
	}
	
	public static int getSpawnrate(String s, int i)
	{
		config.load();
		config.getOrCreateIntProperty(s, config.SPAWNRATE, i);
		config.save();
		return new Integer(config.getOrCreateIntProperty(s, config.SPAWNRATE, i).value).intValue();
	}
}
