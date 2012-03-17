package net.minecraft.src.zoo.furniture;

import net.minecraft.src.ModelBase;

public abstract class ZooModel extends ModelBase
{
	public boolean isMultiBlock = false;
	
	public abstract void renderModel(float f1);
}
