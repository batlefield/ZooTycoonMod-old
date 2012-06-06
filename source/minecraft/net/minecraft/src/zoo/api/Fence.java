package net.minecraft.src.zoo.api;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.BAPI.ItemKey;

/** Fence API
 * Developed to register custom fences and custom rotators for exhibit tools
 * 
 * @author Battlefield
 * @category Fencing
 */

public class Fence {
	
	private static List fences = new ArrayList();
	private static List dirts = new ArrayList();
	private static List rotators = new ArrayList();
	private static List glass = new ArrayList();
	
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
	
	protected static void registerRotator(Item item)
	{
		rotators.add(item.shiftedIndex);
		
		String s = item.getItemName().replace("item.", "");
		
		System.out.println("FenceAPI: Registered " + s + " as rotator into FenceAPI rotators map");
	}
	
	protected static void registerDirt(Block block, int i)
	{
		dirts.add(new ItemKey(block.blockID, i));
		
		String s = block.getBlockName().replace("tile.", "");
		
		if(i == 0)
		{
			System.out.println("FenceAPI: Registered " + s);
		}
		if(i > 0)
		{
			System.out.println("FenceAPI: Registered " + s + " with damge value of" + i);
		}
	}
	
	protected static void registerFenceAsGlass(Block block, int i)
	{
		glass.add(new ItemKey(block.blockID, i));
	}
	
	
	public static List<ItemKey> getFence()
	{
		return fences;
	}
	
	public static List<ItemKey> getDirts()
	{
		return dirts;
	}
	
	public static List<ItemKey> getGlass()
	{
		return glass;
	}
	
	public static List<ItemKey> getRotator()
	{
		return rotators;
	}
	
	static{
		
		fences.add(new ItemKey(Block.fence.blockID, 0));
		fences.add(new ItemKey(Block.netherFence.blockID, 0));
		
		glass.add(new ItemKey(Block.fenceIron.blockID, 0));
		glass.add(new ItemKey(Block.glass.blockID, 0));
		glass.add(new ItemKey(Block.thinGlass.blockID, 0));
		
		dirts.add(new ItemKey(Block.grass.blockID, 0));
		dirts.add(new ItemKey(Block.sand.blockID, 0));
	}
	

}
