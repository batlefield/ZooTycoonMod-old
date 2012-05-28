package net.minecraft.src.zoo.core;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Facing;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraft.src.forge.ITextureProvider;
import net.minecraft.src.zoo.core.entities.ZooVisitorFemale;

public class ZooItem extends Item implements ITextureProvider{

	public ZooItem(int i) {
		super(i);
	}
	
	public String getTextureFile() {
		return "/zoo/items.png";
	}
	
	/*public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7)
    {
        if (par3World.isRemote)
        {
            return true;
        }
        else
        {
            int var8 = par3World.getBlockId(par4, par5, par6);
            par4 += Facing.offsetsXForSide[par7];
            par5 += Facing.offsetsYForSide[par7];
            par6 += Facing.offsetsZForSide[par7];
            double var9 = 0.0D;

            if (par7 == 1 && var8 == Block.fence.blockID || var8 == Block.netherFence.blockID)
            {
                var9 = 0.5D;
            }
            
            Entity entity = new ZooVisitorFemale(par3World);
            entity.setLocationAndAngles(par4, par5, par6, par3World.rand.nextFloat() * 360.0F, 0.0F);
            par3World.spawnEntityInWorld(entity);

            return true;
        }
    }*/
	
}
