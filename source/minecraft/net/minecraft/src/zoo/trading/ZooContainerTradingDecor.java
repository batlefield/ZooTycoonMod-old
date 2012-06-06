package net.minecraft.src.zoo.trading;

import java.util.*;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;
import net.minecraft.src.zoo.api.ITrade;


public class ZooContainerTradingDecor extends Container
{

    public static List itemList;

    public ZooContainerTradingDecor(EntityPlayer entityplayer)
    {
    	itemList = new ArrayList();
        Block ablock[] = {
        		Block.bookShelf, Block.cobblestoneMossy, Block.dirt, Block.dispenser, Block.enchantmentTable, Block.fence, Block.fenceGate,
        		Block.fenceIron, Block.glowStone, Block.music, Block.netherFence, Block.planks, Block.pumpkin, Block.pumpkinLantern,
                Block.plantRed, Block.plantYellow, Block.jukebox, Block.redstoneLampIdle
        };
        for(int i = 0; i < ablock.length; i++)
        {
            itemList.add(new ItemStack(ablock[i]));
        }

        for(int k1 = 0; k1 < 16; k1++)
        {
            itemList.add(new ItemStack(Block.cloth.blockID, 1, k1));
        }
        
        
        addBlocks(itemList);

        Item aitem[] = {
            Item.painting
        };
        for(int l1 = 0; l1 < aitem.length; l1++)
        {
            itemList.add(new ItemStack(aitem[l1]));
        }

        for(int i2 = 0; i2 < 16; i2++)
        {
            itemList.add(new ItemStack(Item.dyePowder.shiftedIndex, 1, i2));
        }
        
        addItems(itemList);
        
        for(int i2 = 0; i2 < 3; i2++)
        {
            itemList.add(new ItemStack(mod_ZooTrade.Coin.shiftedIndex, 1, i2));
        }
        
        sortGui();
        InventoryPlayer var16 = entityplayer.inventory;

		int var13;

		for (var13 = 0; var13 < 5; ++var13)
		{
			for (int var14 = 0; var14 < 8; ++var14)
			{
				this.addSlot(new Slot(ZooGuiContainerTradingDecor.getInventory(), var14 + var13 * 8, 8 + var14 * 18, 18 + var13 * 18));
			}
		}

		for (var13 = 0; var13 < 9; ++var13)
		{
			this.addSlot(new Slot(var16, var13, 8 + var13 * 18, 184));
		}

		scrollTo(0.0F);
    }

    public static void sortGui()
    {
        Collections.sort(itemList, new Comparator() {

            public int compare(Object obj, Object obj1)
            {
                return Integer.valueOf(((ItemStack)obj1).getMaxStackSize()).compareTo(Integer.valueOf(((ItemStack)obj1).getMaxStackSize()));
                
            }

        }
);
    }

    protected void retrySlotClick(int i, int j, boolean flag, EntityPlayer entityplayer)
    {
    }

    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return true;
    }
    
    public void scrollTo(float f)
	{
		int i = (itemList.size() / 8 - 5) + 1;
		int j = (int) ((double) (f * (float) i) + 0.5D);
		if (j < 0)
		{
			j = 0;
		}
		for (int k = 0; k < 5; k++)
		{
			for (int l = 0; l < 8; l++)
			{
				int i1 = l + (k + j) * 8;
				if (i1 >= 0 && i1 < itemList.size())
				{
					ZooGuiContainerTradingDecor.getInventory().setInventorySlotContents(l + k * 8, (ItemStack) itemList.get(i1));
				} else
				{
					ZooGuiContainerTradingDecor.getInventory().setInventorySlotContents(l + k * 8, null);
				}
			}
		}
	}
    
    public void addItems(List list)
    {
    	for(Item item : Item.itemsList)
    	{
    		if(item != null && item instanceof ITrade)
    		{
    			ITrade handler = (ITrade)item;
    			
    			handler.addToGUI(GUIType.DECOR, (ArrayList) list);
    		}
    	}
    }

    public void addBlocks(List list)
    {
    	for(Block block : Block.blocksList)
    	{
    		if(block != null && block instanceof ITrade)
    		{
    			ITrade handler = (ITrade)block;
    			
    			handler.addToGUI(GUIType.DECOR, (ArrayList) list);
    			
    		}
    	}
    }

}
