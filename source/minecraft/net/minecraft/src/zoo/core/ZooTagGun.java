package net.minecraft.src.zoo.core;

import net.minecraft.src.Enchantment;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraft.src.Zoo;
import net.minecraft.src.forge.ITextureProvider;
import net.minecraft.src.zoo.core.entities.ZooDartEntity;

public class ZooTagGun extends Item implements ITextureProvider{

	public ZooTagGun(int par1) {
		super(par1);
		maxStackSize = 1;
	}
	
	public String getTextureFile(){
		return "/zoo/items.png";
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        boolean var5 = par3EntityPlayer.capabilities.isCreativeMode;
		
		if (var5 || par3EntityPlayer.inventory.hasItem(Zoo.dart.shiftedIndex))
        {
            int var6 = 80000;
            float var7 = (float)var6 / 20.0F;
            var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;

            if ((double)var7 < 0.1D)
            {
                return par1ItemStack;
            }

            if (var7 > 1.0F)
            {
                var7 = 1.0F;
            }

            ZooDartEntity var8 = new ZooDartEntity(par2World, par3EntityPlayer, var7 * 2.0F);


            par1ItemStack.damageItem(1, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);

            if (!var5)
            {
                par3EntityPlayer.inventory.consumeInventoryItem(Zoo.dart.shiftedIndex);
            }
            else
            {
                var8.doesArrowBelongToPlayer = false;
            }

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(var8);
            }
        }
		return par1ItemStack;
    }
	
}
