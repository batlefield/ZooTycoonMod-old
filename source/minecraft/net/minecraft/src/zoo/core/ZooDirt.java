package net.minecraft.src.zoo.core;

import java.util.ArrayList;

import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.ZooDirts;
import net.minecraft.src.forge.ITextureProvider;
import net.minecraft.src.zoo.api.ITrade;
import net.minecraft.src.zoo.trading.GUIType;

public class ZooDirt extends Block implements ITextureProvider, ITrade{
	
	
	public ZooDirt(int i) {
		super(i, Material.grass);
	}

	public int getBlockTextureFromSide(int i)
    {
        if(i == 1)
        {
        	if(blockID == ZooDirts.deciPeat.blockID)
        	{
        		return 8;
        	}
        	if(blockID == ZooDirts.coniPeat.blockID)
        	{
        		return 15;
        	}
        	if(blockID == ZooDirts.gleyPeat.blockID)
        	{
        		return 17;
        	}
        	if(blockID == ZooDirts.rainforest.blockID)
        	{
        		return 15;
        	}
        }
        if(i == 0)
        {
        	if(blockID == ZooDirts.deciPeat.blockID)
        	{
        		return 18;
        	}
        	if(blockID == ZooDirts.coniPeat.blockID)
        	{
        		return 18;
        	}
        	if(blockID == ZooDirts.gleyPeat.blockID)
        	{
        		return 18;
        	}
        	if(blockID == ZooDirts.rainforest.blockID)
        	{
        		return 4;
        	}
        }
        if(i == 2 || i == 3 || i == 4 || i == 5)
        {
        	if(blockID == ZooDirts.deciPeat.blockID)
        	{
        		return 20;
        	}
        	if(blockID == ZooDirts.coniPeat.blockID)
        	{
        		return 21;
        	}
        	if(blockID == ZooDirts.gleyPeat.blockID)
        	{
        		return 18;
        	}
        	if(blockID == ZooDirts.rainforest.blockID)
        	{
        		return 5;
        	}
        }
        return 0;
    }

	public String getTextureFile() {
		return "/zoo/blocks.png";
	}

	public int getPrice(int i, int j)
	{
		return 10;
	}

	public void addToGUI(GUIType type, ArrayList list){}
}
