package net.minecraft.src.zoo.core;
import java.util.ArrayList;

import net.minecraft.src.forge.*;
import net.minecraft.src.*;

public class ZooBlock extends Block implements ITextureProvider {
	public ZooBlock(int i, int j, Material material)
	{
		super (i, j, material);
	}
	public String getTextureFile()
	{
		return "/zoo/blocks.png";
	}

}
