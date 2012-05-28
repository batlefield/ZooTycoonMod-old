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
	
	public ZAPI()
	{
		Fence.init();
	}
	
	/////////////////////////////////////////////
	///////////////////FENCE/////////////////////
	/////////////////////////////////////////////
	
	/**
	 * This function registers new fence to exhibit tool
	 * @param block			Fence
	 */
	
	public static void registerFence(Block block)
	{
		registerFence(block, 0);
	}
	
	/**
	 * This function registers new fence to exhibit tool
	 * @param block			Fence
	 * @param i				Damage value of the block
	 */
	
	public static void registerFence(Block block, int i)
	{
		Fence.registerFence(block, i);
	}
	
	/**
	 * This function registers new glass-like block to exhibit tool
	 * @param block			Glass(pane) block
	 */
	
	public static void registerGlass(Block block)
	{
		registerGlass(block, 0);
	}
	
	/**
	 * This function registers new glass-like block to exhibit tool
	 * @param block			Glass(pane) block
	 * @param i				Damage value of the block
	 */
	
	public static void registerGlass(Block block, int i)
	{
		Fence.registerFenceAsGlass(block, i);
	}
	
	/**
	 * This function registers new pane-like block to exhibit tool
	 * @param block			Glass(pane) block
	 */
	
	public static void registerPane(Block block)
	{
		registerGlass(block, 0);
	}
	
	/**
	 * This function registers new pane-like block to exhibit tool
	 * @param block			Glass(pane) block
	 * @param i				Damage value of the block
	 */
	
	public static void registerPane(Block block, int i)
	{
		registerGlass(block, i);
	}
	
	/**
	 * This function registers new tool that can rotate exhibit tools/shopkeeper blocks/grunders
	 * @param item			Tool that can rotate exhibit tools/shopkeeper blocks
	 */
	
	public static void registerFenceTool(Item item)
	{
		Fence.registerRotator(item);
	}
	
	/////////////////////////////////////////////
	///////////////////BIOME/////////////////////
	/////////////////////////////////////////////	
	
	/**
	 * Registers biome
	 * @param biome			Biome you are registering
	 */
	
	public static void registerBiome(BiomeGenBase biome)
	{
		registerBiome(biome, false, false, false);
	}
	
	/**
	 * Registers biome and sets it as you want
	 * @param biome			Biome you are registering
	 * @param spawn			Set to true if you want player to be able to spawn in your biome
	 * @param i				Rarity of a biome(default is 10)
	 */
	
	public static void registerBiome(BiomeGenBase biome, boolean spawn, boolean village, boolean stronghold)
	{
		Biome.registerBiome(biome, spawn, village, stronghold);
	}
}
