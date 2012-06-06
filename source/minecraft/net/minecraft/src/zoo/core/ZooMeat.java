package net.minecraft.src.zoo.core;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumAction;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.World;
import net.minecraft.src.forge.ITextureProvider;

public class ZooMeat extends ItemFood implements ITextureProvider
{

	public ZooMeat(int par1)
	{
		super(par1, 0, 0, false);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	public int getIconFromDamage(int i)
	{
		if(i == 0)
		{
			return 12;
		}
		if(i == 1)
		{
			return 13;
		}
		if(i == 2)
		{
			return 14;
		}
		if(i == 3)
		{
			return 15;
		}
		return 0;
	}
	
	public ItemStack onFoodEaten(ItemStack is, World par2World, EntityPlayer player)
    {
        --is.stackSize;
        
        if(is.getItemDamage() == 0)
        {
        	player.getFoodStats().addStats(3, 0.3F);
        }
        if(is.getItemDamage() == 1)
        {
        	player.getFoodStats().addStats(8, 0.8F);
        }
        if(is.getItemDamage() == 2)
        {
        	player.getFoodStats().addStats(2, 0.3F);
        }
        if(is.getItemDamage() == 3)
        {
        	player.getFoodStats().addStats(6, 0.6F);
        }
        
        par2World.playSoundAtEntity(player, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);

        return is;
    }
	
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.eat;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par3EntityPlayer.canEat(false))
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }

        return par1ItemStack;
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
        }
        if(itemstack.getItemDamage() == 3)
    	{
        	return itemNames[3];
    	}else{
        	return itemNames[4];
        }
    }
    public static final String itemNames[] = {
        "item.meat.carnivore.raw", "item.meat.carnivore.cooked", "item.meat.herbivore.raw", "item.meat.herbivore.cooked", "Meat"
    };

    public String getTextureFile() {
		return "/zoo/items.png";
	}

}
