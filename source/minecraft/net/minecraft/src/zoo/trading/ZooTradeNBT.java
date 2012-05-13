package net.minecraft.src.zoo.trading;

import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.mod_ZooTrade;
import net.minecraft.src.BAPI.interfaces.INBT;

public class ZooTradeNBT implements INBT {


	public String nbtName() {
		return "ZooTycoon";
	}

	public void writeToNBT(NBTTagCompound nbttagcompound) {
        int i = mod_ZooTrade.money;
        double d = i * 3.14159265;
        nbttagcompound.setDouble("Money", d);
		
	}

	public void readFromNBT(NBTTagCompound nbttagcompound) {
        double d = nbttagcompound.getDouble("Money");
        int i =  (int) (d / 3.14159265);
        mod_ZooTrade.money = i;
	}
}
