package net.minecraft.src.zoo.core;

import net.minecraft.src.BlockFence;
import net.minecraft.src.Material;
import net.minecraft.src.forge.ITextureProvider;

public class ZooFence extends BlockFence implements ITextureProvider
{

	public ZooFence(int par1, int par2, Material par3Material)
	{
		super(par1, par2, par3Material);
	}

	public String getTextureFile()
	{
		return "/zoo/blocks.png";
	}

}
