// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src.zoo.furniture;

import java.util.ArrayList;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;
import net.minecraft.src.forge.ITextureProvider;


// Referenced classes of package net.minecraft.src:
//            Item, Block, BlockBed, EntityPlayer, 
//            MathHelper, World, ItemStack

public class ZooItemFurniture extends Item implements ITextureProvider
{
	public ZooFurnitureBase block;

    public ZooItemFurniture(int i, ZooFurnitureBase blk)
    {
        super(i);
        block = blk;
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(l != 1)
        {
            return false;
        }
        j++;
        int m = MathHelper.floor_double((double)((entityplayer.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        if(m == 0) m = 2;
        else if(m == 1) m = 1;
        else if(m == 2) m = 3;
        else if(m == 3) m = 0;
        System.out.println(block);
        if(!block.canPlaceBlockWithMetaAt(world,i,j,k,m)) return false;
        block.onItemUse(world,i,j,k,m,entityplayer);
        itemstack.stackSize--;
        return true;
    }

	public String getTextureFile() {
		return "/zoo/items.png";
	}
}
