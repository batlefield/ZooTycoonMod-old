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
		Trade.init();
		Fence.init();
	}
	
	/////////////////////////////////////////////
	///////////////////TRADE/////////////////////
	/////////////////////////////////////////////
	
	 /** GUI ID's:
	 * 1 - Merchant that sells dirt.
	 * 2 - Merchant that sells food.
	 * 3 - Merchant that sells fencing.
	 * 4 - Merchant that sells special blocks
	 * 5 - Merchant that sells technical stuff
	 * 6 - Merchant that sells ingridients for potions and potions
	 * 7 - Merchant that sells plants and stuff
	 * 8 - Merchant that sells tools and armor
	 * 9 - Merchant that sells decorative items(bookshelves wool...)
	 * 10 - merchant that sells items from other mods*/
	
	
	/**
	 * This function registers custom block to any of the shopkeeper GUI's
	 * @param item				Block you want to add.
	 * @param id				Id of GUI in which item should be placed in.
	 * @param p					Price you want to be assigned for the block.
	 */
	
	public static void tradingAdd(Block block, int id, int p)
	{
		tradingAdd(block, 0, id, p);
	}
	
	/**
	 * This function registers custom block to any of the shopkeeper GUI's
	 * @param item				Item you want to add.
	 * @param i 				Damage value of the item you want to register.
	 * @param id				Id of GUI in which item should be register.
	 * @param p					Price you want to be assigned for the block.
	 * @throws					IllegalArgumentException if the GUI id is not defined.
	 */
	
	public static void tradingAdd(Block block, int i, int id, int p)
	{
		Trade.registerBlock(block, i, id, p);
	}
	
	/**
	 * This function registers custom item to any of the shopkeeper GUI's
	 * @param item				Item you want to add.
	 * @param id				Id of GUI in which item should be placed in.
	 * @param p					Price you want to be assigned for the item.
	 */
	
	public static void tradingAdd(Item item, int id, int p)
	{
		tradingAdd(item, 0, id, p);
	}
	
	/**
	 * This function registers custom item to any of the shopkeeper GUI's
	 * @param item				Item you want to add.
	 * @param i 				Damage value of the item you want to register.
	 * @param id				Id of GUI in which item should be register.
	 * @param p					Price you want to be assigned for the item.
	 * @throws					IllegalArgumentException if the GUI id is not defined.
	 */
	
	public static void tradingAdd(Item item, int i, int id, int p)
	{
		Trade.registerItem(item, i, id, p);
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
