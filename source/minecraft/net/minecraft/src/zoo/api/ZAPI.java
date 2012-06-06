package net.minecraft.src.zoo.api;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.Item;


/**
 * This class was created to make all hooks available in one class.
 * @author Battlefield
 *
 */
public class ZAPI {
	
	/////////////////////////////////////////////
	///////////////////FENCE/////////////////////
	/////////////////////////////////////////////
	
	public static void registerDirt(Block block)
	{
		registerDirt(block, 0);
	}
	
	public static void registerDirt(Block block, int i)
	{
		Fence.registerDirt(block, i);
	}
	
	public static void registerGlass(Block block)
	{
		registerGlass(block, 0);
	}
	
	public static void registerGlass(Block block, int i)
	{
		Fence.registerFenceAsGlass(block, i);
	}
	
	public static void registerFence(Block block)
	{
		registerFence(block, 0);
	}
	
	
	public static void registerFence(Block block, int i)
	{
		Fence.registerFence(block, i);
	}
	
	
	public static void registerFenceTool(Item item)
	{
		Fence.registerRotator(item);
	}
	
	/////////////////////////////////////////////
	///////////////////BIOME/////////////////////
	/////////////////////////////////////////////	
	
	public static void registerBiome(BiomeGenBase biome)
	{
		registerBiome(biome, false, false, false);
	}
	
	public static void registerBiome(BiomeGenBase biome, boolean spawn, boolean village, boolean stronghold)
	{
		Biome.registerBiome(biome, spawn, village, stronghold);
	}
}
