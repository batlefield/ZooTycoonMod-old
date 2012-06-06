package net.minecraft.src.zoo.core;
import java.util.ArrayList;

import net.minecraft.src.forge.*;
import net.minecraft.src.zoo.api.ITrade;
import net.minecraft.src.zoo.trading.GUIType;
import net.minecraft.src.*;

public class ZooBlock extends Block implements ITextureProvider, ITrade {
	public ZooBlock(int i, int j, Material material)
	{
		super (i, j, material);
	}
	public String getTextureFile()
	{
		return "/zoo/blocks.png";
	}
	
	public int getPrice(int i, int j)
	{
		if(i == Zoo.asphalt.blockID)
		{
			return 10;
		}else if(i == Zoo.brownStone.blockID)
		{
			return 2;
		}else if(i ==  Zoo.concrete.blockID)
		{
			return 10;
		}else{
			return 10;
		}
	}
	
	public void addToGUI(GUIType type, ArrayList list){}

}
