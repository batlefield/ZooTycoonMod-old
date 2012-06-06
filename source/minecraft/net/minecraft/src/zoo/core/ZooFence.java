package net.minecraft.src.zoo.core;

import java.util.ArrayList;

import net.minecraft.src.BlockFence;
import net.minecraft.src.Material;
import net.minecraft.src.Zoo;
import net.minecraft.src.forge.ITextureProvider;
import net.minecraft.src.zoo.api.ITrade;
import net.minecraft.src.zoo.trading.GUIType;

public class ZooFence extends BlockFence implements ITextureProvider, ITrade
{

	public ZooFence(int par1, int par2, Material par3Material)
	{
		super(par1, par2, par3Material);
	}

	public String getTextureFile()
	{	
		if(this == Zoo.Bfence)
		{
			return "/zoo/blocks.png";
		}else{
			return "/terrain.png";
		}
	}

	public int getPrice(int i, int j)
	{
		if(i == Zoo.Bfence.blockID)
		{
			return 12;
		}else if(i == Zoo.Ofence.blockID)
		{
			return 150;
		}else if(i == Zoo.Gfence.blockID)
		{
			return 800;
		}else{
			return 6;
		}
	}

	public void addToGUI(GUIType type, ArrayList list){}

}
