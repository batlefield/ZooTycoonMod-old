package net.minecraft.src.zoo.dimension;

import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.forge.ITextureProvider;

public class ZooBlockDim extends Block implements ITextureProvider{

	protected ZooBlockDim(int i, int j, Material material) {
		super(i, j, material);
	}

	public String getTextureFile() {
		return "/zoo/dimension/blocks.png";
	}

}
