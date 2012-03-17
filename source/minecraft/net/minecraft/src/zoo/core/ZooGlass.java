package net.minecraft.src.zoo.core;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.*;
import net.minecraft.src.forge.ITextureProvider;

public class ZooGlass extends BlockBreakable implements ITextureProvider
{

    public ZooGlass(int i, int j, Material material, boolean flag)
    {
        super(i, j, material, flag);
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public int getRenderBlockPass()
    {
        return 0;
    }

	public String getTextureFile() {
		return "/zoo/blocks.png";
	}
	public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        if(!world.isRemote && entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().itemID == Zoo.fenceDestroyer.shiftedIndex)
        {
            entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
            dropBlockAsItem_do(world, i, j, k, new ItemStack(blockID, 1, l & 3));
        } else
        {
            super.harvestBlock(world, entityplayer, i, j, k, l);
        }
    }
	
	public void addCreativeItems(ArrayList itemList)
    {
		itemList.add(new ItemStack(this));
    }
}
