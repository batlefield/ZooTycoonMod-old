package net.minecraft.src.zoo.core;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.BlockBreakable;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.StatList;
import net.minecraft.src.World;
import net.minecraft.src.Zoo;
import net.minecraft.src.forge.ITextureProvider;
import net.minecraft.src.zoo.api.ITrade;
import net.minecraft.src.zoo.trading.GUIType;

public class ZooGlass extends BlockBreakable implements ITextureProvider, ITrade
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

	public int getPrice(int i, int j)
	{
		return 924;
	}

	public void addToGUI(GUIType type, ArrayList list){}
}
