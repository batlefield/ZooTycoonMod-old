package net.minecraft.src.zoo.trading;

import java.util.ArrayList;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraft.src.mod_ZooTrade;
import net.minecraft.src.zoo.api.GUIType;
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
			mod_ZooTrade.money += 1000;
			itemstack.stackSize --;
		}
		if(itemstack.getItemDamage() == 1)
		{
			mod_ZooTrade.money += 100;
			itemstack.stackSize --;
		}
		if(itemstack.getItemDamage() == 0)
		{
			mod_ZooTrade.money += 10;
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
        	return blockNames[0];
        }
        if(itemstack.getItemDamage() == 1)
        {
        	return blockNames[1];
        }
        if(itemstack.getItemDamage() == 2)
        {
        	return blockNames[2];
        }else{
        	return blockNames[3];
        }
    }
    public static final String blockNames[] = {
        "item.coin.bronze", "item.coin.silver", "item.coin.gold", "Coin"
    };
    
	public int getPrice(int i) {
		if(i == 0) return 10;
		if(i == 1) return 100;
		if(i == 2) return 1000;
		else return 0;
	}

	public void addToGUI(GUIType type, ArrayList list) {}

}
