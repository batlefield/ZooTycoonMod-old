package net.minecraft.src.zoo.trading;

import java.util.*;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;
import net.minecraft.src.zoo.api.ITrade;


public class ZooContainerTradingPotion extends Container
{

    private static Minecraft minecraft = ModLoader.getMinecraftInstance();
    public static ZooContainerTradingPotion instance = new ZooContainerTradingPotion();
    public static boolean interact;
    public static List itemList;

    public ZooContainerTradingPotion()
    {
        loadStacks();
    }

    public void loadStacks()
    {
        itemList = new ArrayList();
        Block ablock[] =
            {
                Block.enchantmentTable
            };
        for(int i = 0; i < ablock.length; i++)
        {
            itemList.add(new ItemStack(ablock[i]));
        }
        
        addBlocks(itemList);

        Item aitem[] = {
            Item.blazePowder, Item.blazeRod, Item.brewingStand, Item.cauldron, Item.fermentedSpiderEye, Item.ghastTear, Item.glassBottle, 
            Item.goldNugget, Item.gunpowder, Item.lightStoneDust, Item.melon, Item.magmaCream, Item.netherStalkSeeds, Item.redstone,
            Item.speckledMelon, Item.spiderEye, Item.sugar
        };
        for(int l1 = 0; l1 < aitem.length; l1++)
        {
            itemList.add(new ItemStack(aitem[l1]));
        }

        itemList.add(new ItemStack(Item.potion.shiftedIndex, 1, 0));
        itemList.add(new ItemStack(Item.potion.shiftedIndex, 1, 1));
        itemList.add(new ItemStack(Item.potion.shiftedIndex, 1, 2));
        itemList.add(new ItemStack(Item.potion.shiftedIndex, 1, 3));
        itemList.add(new ItemStack(Item.potion.shiftedIndex, 1, 5));
        itemList.add(new ItemStack(Item.potion.shiftedIndex, 1, 9));
        itemList.add(new ItemStack(Item.potion.shiftedIndex, 1, 33));
        itemList.add(new ItemStack(Item.potion.shiftedIndex, 1, 34));
        itemList.add(new ItemStack(Item.potion.shiftedIndex, 1, 37));
        itemList.add(new ItemStack(Item.potion.shiftedIndex, 1, 41));
        itemList.add(new ItemStack(Item.potion.shiftedIndex, 1, 57));
        itemList.add(new ItemStack(Item.potion.shiftedIndex, 1, 65));
        itemList.add(new ItemStack(Item.potion.shiftedIndex, 1, 66));
        itemList.add(new ItemStack(Item.potion.shiftedIndex, 1, 67));
        itemList.add(new ItemStack(Item.potion.shiftedIndex, 1, 73));
        
        addItems(itemList);
        
        for(int i2 = 0; i2 < 3; i2++)
        {
            itemList.add(new ItemStack(mod_ZooTrade.Coin.shiftedIndex, 1, i2));
        }
        
        sortGui();
        InventoryPlayer inventoryplayer = minecraft.thePlayer.inventory;
        for(int l2 = 0; l2 < 5; l2++)
        {
            for(int k3 = 0; k3 < 8; k3++)
            {
                addSlot(new Slot(ZooGuiContainerTradingPotion.getInventory(), k3 + l2 * 8, 8 + k3 * 18, 18 + l2 * 18));
            }

        }

        for(int i3 = 0; i3 < 3; i3++)
        {
            for(int l3 = 0; l3 < 9; l3++)
            {
                addSlot(new Slot(inventoryplayer, l3 + i3 * 9 + 9, 8 + l3 * 18, 127 + i3 * 18));
            }

        }

        for(int j3 = 0; j3 < 9; j3++)
        {
            addSlot(new Slot(inventoryplayer, j3, 8 + j3 * 18, 184));
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
        return interact;
    }
    
    public void scrollTo(float f)
    {
        int i = (itemList.size() / 8 - 5) + 1;
        int j = (int)((double)(f * (float)i) + 0.5D);
        if(j < 0)
        {
            j = 0;
        }
        for(int k = 0; k < 9; k++)
        {
            for(int l = 0; l < 8; l++)
            {
                int i1 = l + (k + j) * 8;
                if(i1 >= 0 && i1 < itemList.size())
                {
                    ZooGuiContainerTradingPotion.getInventory().setInventorySlotContents(l + k * 8, (ItemStack)itemList.get(i1));
                } else
                {
                	ZooGuiContainerTradingPotion.getInventory().setInventorySlotContents(l + k * 8, null);
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
    			
    			handler.addToGUI(GUIType.POTION, (ArrayList) list);
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
    			
    			handler.addToGUI(GUIType.POTION, (ArrayList) list);
    			
    		}
    	}
    }

}
