package net.minecraft.src.zoo.trading;

import java.util.ArrayList;

import net.minecraft.src.*;
import net.minecraft.src.forge.ITextureProvider;
import net.minecraft.src.zoo.core.ZooItem;

public class ZooItemCoin extends ZooItem {

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
	
    public void addCreativeItems(ArrayList itemList)
    {    	
    	if (this.shiftedIndex != Item.potion.shiftedIndex && this.shiftedIndex != Item.monsterPlacer.shiftedIndex)
    	{
			itemList.add(new ItemStack(this, 1, 0));
			itemList.add(new ItemStack(this, 1, 1));
			itemList.add(new ItemStack(this, 1, 2));
    	}
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

}
