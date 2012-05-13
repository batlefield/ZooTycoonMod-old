package net.minecraft.src.zoo.api;

import java.util.ArrayList;

public interface ITrade {
	
	public int getPrice(int i);
	
	public void addToGUI(GUIType type, ArrayList list);
	
}
