package net.minecraft.src.zoo.trading;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

public class GuiContainerSafe extends Container{

	private static TileEntitySafe safe;
	private static EntityPlayer player;
	
	public GuiContainerSafe(EntityPlayer player, TileEntitySafe safe)
	{
		this.safe = safe;
		this.player = player;
		
		if(!safe.locked && !safe.setPassword)
		{
			for(int i = 0; i < 3; i++)
			{
				addSlot(new Slot(safe, i, 129, 14 + 18 * i));
				addSlot(new Slot(safe, i + 3, 147, 14 + 18 * i));
			}
		}
		
		InventoryPlayer inventoryplayer = player.inventory;
		
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
	}
	
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}
	
	public void onCraftGuiClosed(EntityPlayer par1EntityPlayer)
    {
        super.onCraftGuiClosed(par1EntityPlayer);
        safe.closeChest();
    }
	
	public ItemStack transferStackInSlot(int par1)
    {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.inventorySlots.get(par1);

        if (var3 != null && var3.getHasStack())
        {
            ItemStack var4 = var3.getStack();
            var2 = var4.copy();

            if (par1 < 6)
            {
                if (!this.mergeItemStack(var4, 6, this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var4, 0, 6, false))
            {
                return null;
            }

            if (var4.stackSize == 0)
            {
                var3.putStack((ItemStack)null);
            }
            else
            {
                var3.onSlotChanged();
            }
        }

        return var2;
    }

}
