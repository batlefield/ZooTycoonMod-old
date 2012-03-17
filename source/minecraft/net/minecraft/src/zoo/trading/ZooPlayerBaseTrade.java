package net.minecraft.src.zoo.trading;

import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.PlayerAPI;
import net.minecraft.src.PlayerBase;
import net.minecraft.src.mod_ZooTrade;

public class ZooPlayerBaseTrade extends PlayerBase {

	public ZooPlayerBaseTrade(PlayerAPI playerapi) {
		super(playerapi);
	}
	
	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        int i = mod_ZooTrade.money;
        double d = i * 3.14159265;
        nbttagcompound.setDouble("Money", d);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        double d = nbttagcompound.getDouble("Money");
        int i =  (int) (d / 3.14159265);
        mod_ZooTrade.money = i;
    }
}
