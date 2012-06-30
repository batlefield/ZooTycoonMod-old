package net.minecraft.src.zoo.trading;

import java.util.*;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;
import net.minecraft.src.zoo.api.ITrade;
import net.minecraft.src.zoo.core.TaggedEntitiesSave;

public class ZooContainerTradingAnimal extends Container
{

	public static List itemList;

	public ZooContainerTradingAnimal(EntityPlayer player)
	{
		itemList = new ArrayList();


		Iterator iterator = EntityList.entityEggs.keySet().iterator();
		boolean[] tagged = TaggedEntitiesSave.getTagged();
		
        while (iterator.hasNext())
        {
            Integer i = (Integer)iterator.next();
            if(tagged[i.intValue()])
            {
            	itemList.add(new ItemStack(Item.monsterPlacer.shiftedIndex, 1, i.intValue()));
            }
        }

		sortGui();
		InventoryPlayer var16 = player.inventory;

		int var13;

		for (var13 = 0; var13 < 5; ++var13)
		{
			for (int var14 = 0; var14 < 8; ++var14)
			{
				this.addSlot(new Slot(ZooGuiContainerTradingTools.getInventory(), var14 + var13 * 8, 8 + var14 * 18, 18 + var13 * 18));
			}
		}
		
		for(int i3 = 0; i3 < 3; i3++)
        {
            for(int l3 = 0; l3 < 9; l3++)
            {
                addSlot(new Slot(var16, l3 + i3 * 9 + 9, 8 + l3 * 18, 127 + i3 * 18));
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
				return Integer.valueOf(((ItemStack) obj1).getMaxStackSize()).compareTo(Integer.valueOf(((ItemStack) obj1).getMaxStackSize()));

			}

		});
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
					ZooGuiContainerTradingTools.getInventory().setInventorySlotContents(l + k * 8, (ItemStack) itemList.get(i1));
				} else
				{
					ZooGuiContainerTradingTools.getInventory().setInventorySlotContents(l + k * 8, null);
				}
			}
		}
	}

	public void retrySlotClick(int i, int j, boolean flag, EntityPlayer entityplayer)
	{
	}
}
