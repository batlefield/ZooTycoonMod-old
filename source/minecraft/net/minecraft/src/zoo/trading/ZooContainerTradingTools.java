package net.minecraft.src.zoo.trading;

import java.util.*;
import net.minecraft.client.Minecraft;
import net.minecraft.src.*;
import net.minecraft.src.zoo.api.Trade;


public class ZooContainerTradingTools extends Container
{

    private static Minecraft minecraft = ModLoader.getMinecraftInstance();
    public static ZooContainerTradingTools instance = new ZooContainerTradingTools();
    public static boolean interact;
    public static List itemList;

    public ZooContainerTradingTools()
    {
        loadStacks();
    }

    public void loadStacks()
    {
        itemList = new ArrayList();
        Block ablock[] =
            {
                Block.workbench
            };
        for(int i = 0; i < ablock.length; i++)
        {
            itemList.add(new ItemStack(ablock[i]));
        }
        
        addBlocks();

        Item aitem[] = {
            Item.arrow, Item.axeDiamond, Item.axeGold, Item.axeSteel, Item.axeStone, Item.axeWood, Item.bootsChain, Item.bootsDiamond, 
            Item.bootsGold, Item.bootsLeather, Item.bootsSteel, Item.bucketEmpty, Item.bucketLava, Item.bucketWater, Item.compass, 
            Item.fishingRod, Item.flintAndSteel, Item.helmetChain, Item.helmetDiamond, Item.helmetGold, Item.helmetLeather, Item.helmetSteel, 
            Item.hoeDiamond, Item.hoeGold, Item.hoeSteel, Item.hoeStone, Item.hoeWood, Item.legsChain, Item.legsDiamond, Item.legsGold, 
            Item.legsLeather, Item.legsSteel, Item.map, Item.pickaxeDiamond, Item.pickaxeGold, Item.pickaxeSteel, Item.pickaxeStone, 
            Item.pickaxeWood, Item.plateChain, Item.plateDiamond, Item.plateGold, Item.plateLeather, Item.plateSteel, Item.pocketSundial,
            Item.shovelDiamond, Item.shovelGold, Item.shovelSteel, Item.shovelStone, Item.shovelWood, 
            Item.swordDiamond, Item.swordGold, Item.swordSteel, Item.swordStone, Item.swordWood, Item.shears
        };
        for(int l1 = 0; l1 < aitem.length; l1++)
        {
            itemList.add(new ItemStack(aitem[l1]));
        }
        
        for(int i2 = 0; i2 < 3; i2++)
        {
            itemList.add(new ItemStack(mod_ZooTrade.Coin.shiftedIndex, 1, i2));
        }
        
        addItems();
        sortGui();
        InventoryPlayer inventoryplayer = minecraft.thePlayer.inventory;
        for(int l2 = 0; l2 < 5; l2++)
        {
            for(int k3 = 0; k3 < 8; k3++)
            {
                addSlot(new Slot(ZooGuiContainerTradingTools.getInventory(), k3 + l2 * 8, 8 + k3 * 18, 18 + l2 * 18));
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
        int i = (itemList.size() / 8 - 8) + 1;
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
                    ZooGuiContainerTradingTools.getInventory().setInventorySlotContents(l + k * 8, (ItemStack)itemList.get(i1));
                } else
                {
                	ZooGuiContainerTradingTools.getInventory().setInventorySlotContents(l + k * 8, null);
                }
            }

        }

    }
    
    public void addItems()
    {
      List items = Trade.getItems(8);
      if (items != null)
      {
        for (int i = 0; i < items.size(); i++)
        {
          itemList.add(items.get(i));
        }
      }
    }

    public void addBlocks()
    {
      List blocks = Trade.getBlocks(8);
      if (blocks != null)
      {
        for (int i = 0; i < blocks.size() / 2; i++)
        {
          itemList.add(blocks.get(i));
        }
      }
    }

}
