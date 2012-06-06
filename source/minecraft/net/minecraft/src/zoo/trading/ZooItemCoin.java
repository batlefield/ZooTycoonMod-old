package net.minecraft.src.zoo.trading;

import java.util.ArrayList;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraft.src.zoo.api.ITrade;
import net.minecraft.src.zoo.core.ZooItem;

public class ZooItemCoin extends ZooItem implements ITrade{

	public ZooItemCoin(int i) {
		super(i);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	public int getIconFromDamage(int i)
	{
		if(i == 0)
		{
			return 10;
		}
		if(i == 1)
		{
			return 9;
		}
		if(i == 2)
		{
			return 8;
		}
		return 0;
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		if(itemstack.getItemDamage() == 2)
		{
			Trade.increaseMoney(1000);
			itemstack.stackSize --;
		}
		if(itemstack.getItemDamage() == 1)
		{
			Trade.increaseMoney(100);
			itemstack.stackSize --;
		}
		if(itemstack.getItemDamage() == 0)
		{
			Trade.increaseMoney(10);
			itemstack.stackSize --;
		}
		return itemstack;
	}
	
	public boolean hasEffect(ItemStack itemstack)
    {
        return true;
    }
	
	public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.epic;
    }
    
	public String getItemNameIS(ItemStack itemstack)
    {
        if(itemstack.getItemDamage() == 0)
        {
        	return itemNames[0];
        }
        if(itemstack.getItemDamage() == 1)
        {
        	return itemNames[1];
        }
        if(itemstack.getItemDamage() == 2)
        {
        	return itemNames[2];
        }else{
        	return itemNames[3];
        }
    }
    public static final String itemNames[] = {
        "item.coin.bronze", "item.coin.silver", "item.coin.gold", "Coin"
    };
    
	public int getPrice(int i, int j) {
		if(j == 0) return 10;
		if(j == 1) return 100;
		if(j == 2) return 1000;
		else return 0;
	}

	public void addToGUI(GUIType type, ArrayList list) {}

}
