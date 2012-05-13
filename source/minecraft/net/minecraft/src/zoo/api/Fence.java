package net.minecraft.src.zoo.api;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.BAPI.ItemKey;

/** Fence API
 * Developed to register custom fences and custom rotators for exhibit tools(Zoo Mod)
 * 
 * @author Battlefield
 * @category Fencing
 * @see registerFence
 */

public class Fence {
	
	private static boolean hasInit = false;
	
	public static void init()
	{
		if(!hasInit)
		{
			hasInit = true;
			System.out.println("FenceAPI: FenceAPI initialized successfuly");
		}
		
	}
	
	private static List fences = new ArrayList();
	private static List glass = new ArrayList();
	private static List rotators = new ArrayList();
	
	/**
	 * This function registers new fence to exhibit tool
	 * @param block			Fence
	 */
	
	protected static void registerFence(Block block)
	{
		registerFence(block, 0);
	}
	
	/**
	 * This function registers new fence to exhibit tool
	 * @param block			Fence
	 * @param i				Damage value of the block
	 */
	
	protected static void registerFence(Block block, int i)
	{
		fences.add(new ItemKey(block.blockID, i));
		
		String s = block.getBlockName().replace("tile.", "");
		
		if(i == 0)
		{
			System.out.println("FenceAPI: Registered " + s + " as fence into FenceAPI fence map");
		}
		if(i > 0)
		{
			System.out.println("FenceAPI: Registered " + s + " with damge value of" + i + " as fence into FenceAPI fence map");
		}
	}
	
	/**
	 * This function registers new glass-like block to exhibit tool
	 * @param block			Glass(pane) block
	 */
	
	protected static void registerFenceAsGlass(Block block)
	{
		registerFenceAsGlass(block, 0);
	}
	
	/**
	 * This function registers new glass-like block to exhibit tool
	 * @param block			Glass(pane) block
	 * @param i				Damage value of the block
	 */
	
	protected static void registerFenceAsGlass(Block block, int i)
	{
		glass.add(new ItemKey(block.blockID, i));
		
		String s = block.getBlockName().replace("tile.", "");
		
		if(i == 0)
		{
			System.out.println("FenceAPI: Registered " + s + " as glass into FenceAPI glass map");
		}
		if(i > 0)
		{
			System.out.println("FenceAPI: Registered " + s + " with damge value of" + i + " as glass into FenceAPI glass map");
		}
	}
	
	/**
	 * This function registers new tool that can rotate exhibit tools/shopkeeper blocks
	 * @param item			Tool that can rotate exhibit tools/shopkeeper blocks
	 */
	
	protected static void registerRotator(Item item)
	{
		rotators.add(item.shiftedIndex);
		
		String s = item.getItemName().replace("item.", "");
		
		System.out.println("FenceAPI: Registered " + item.getItemName() + " as rotator into FenceAPI rotators map");
	}
	
	public static List getFence()
	{
		return fences;
	}
	
	public static List getGlass()
	{
		return glass;
	}
	
	public static List getRotator()
	{
		return rotators;
	}
	
	static{
		
		registerFence(Block.fence);
		registerFence(Block.netherFence);
		
		registerFenceAsGlass(Block.fenceIron);
		registerFenceAsGlass(Block.glass);
		registerFenceAsGlass(Block.thinGlass);
	}
	

}
