package net.minecraft.src.zoo.trading;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.src.*;
import net.minecraft.src.zoo.api.Trade;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class ZooGuiContainerTradingTools extends GuiContainer
{

	private static InventoryBasic inventory = new InventoryBasic("tmp2", 72);
	private float currentScroll = 0.0F;
	private boolean isScrolling = false;
	private boolean wasClicking;
	private Minecraft minecraft;

	public ZooGuiContainerTradingTools(EntityPlayer player)
	{
		super(new ZooContainerTradingTools(player));
		minecraft = ModLoader.getMinecraftInstance();
		minecraft.thePlayer.craftingInventory = inventorySlots;
		allowUserInput = true;
		ySize = 208;
	}

	protected void handleMouseClick(Slot slot, int i, int j, boolean flag)
	{
		if (slot != null)
		{
			double d = 0.6D;
			if (slot.inventory == inventory)
			{
				InventoryPlayer inventoryplayer = mc.thePlayer.inventory;
				ItemStack itemstack1 = inventoryplayer.getItemStack();
				ItemStack itemstack4 = slot.getStack();
				if (!mod_ZooTrade.debug() && Keyboard.isKeyDown(25) && itemstack4 != null)
				{
					if (flag)
					{
						mod_ZooTrade.debug(0);
						Trade.displayValues(itemstack4, 1);
					} else
					{
						mod_ZooTrade.debug(1);
						Trade.displayValues(itemstack4, 0);
					}
				} else if (itemstack1 != null && itemstack4 != null && itemstack1.itemID == itemstack4.itemID && j != 1)
				{
					if (j == 0)
					{
						if (flag)
						{
							if (mod_ZooTrade.money >= Trade.getPrice(itemstack4) * itemstack4.getMaxStackSize() - Trade.getPrice(itemstack4) * itemstack4.stackSize)
							{
								if (mod_ZooTrade.money < Trade.getPrice(itemstack4) * itemstack4.getMaxStackSize() - Trade.getPrice(itemstack4) * itemstack4.stackSize)
								{
									mod_ZooTrade.debug(2);
								} else if (itemstack1.stackSize < itemstack1.getMaxStackSize())
								{
									if (Trade.getPrice(itemstack4) * itemstack1.getMaxStackSize() - Trade.getPrice(itemstack4) * itemstack1.stackSize > mod_ZooTrade.money)
									{
										mod_ZooTrade.debug(3);
									} else
									{
										mod_ZooTrade.debug(4);
										mod_ZooTrade.money -= Trade.getPrice(itemstack4) * itemstack1.getMaxStackSize() - Trade.getPrice(itemstack4) * itemstack1.stackSize;
										itemstack1.stackSize = itemstack1.getMaxStackSize();
									}
								}
							}
						} else if (itemstack1.stackSize < itemstack1.getMaxStackSize())
						{
							if (itemstack4.getItemDamage() != itemstack1.getItemDamage())
							{
								if (Trade.getPrice(itemstack1) * d * itemstack1.stackSize <= (1 * itemstack1.stackSize) && itemstack1.itemID != Item.potion.shiftedIndex)
								{
									if (itemstack1.itemID < 256)
									{
										mc.thePlayer.addChatMessage("Those blocks are worthless.");
									} else
									{
										mc.thePlayer.addChatMessage("Those items are worthless.");
									}
								} else
								{
									mod_ZooTrade.debug(4);
									inventoryplayer.setItemStack(null);
									mod_ZooTrade.money = (int) (mod_ZooTrade.money + Trade.getPrice(itemstack1) * d * itemstack1.stackSize);
								}
							} else if (mod_ZooTrade.money >= Trade.getPrice(itemstack4))
							{
								mod_ZooTrade.debug(4);
								itemstack1.stackSize++;
								mod_ZooTrade.money -= Trade.getPrice(itemstack4);
							}
						}
					} else if (itemstack1.stackSize <= 1)
					{
						if (Trade.getPrice(itemstack1) * d <= 1.0D && itemstack1.itemID != Item.potion.shiftedIndex)
						{
							if (itemstack1.itemID < 256)
							{
								mc.thePlayer.addChatMessage("That block is worthless.");
							} else
							{
								mc.thePlayer.addChatMessage("That item is worthless.");
							}
						} else
						{
							mod_ZooTrade.debug(6);
							inventoryplayer.setItemStack(null);
							mod_ZooTrade.money = (int) (mod_ZooTrade.money + Trade.getPrice(itemstack1) * d);
						}
					} else if (mod_ZooTrade.money >= Trade.getPrice(itemstack1))
					{
						if (Trade.getPrice(itemstack1) <= 1 && itemstack1.itemID != Item.potion.shiftedIndex)
						{
							mod_ZooTrade.debug(8);
						} else if (Trade.getPrice(itemstack1) * d <= 1.0D && itemstack1.itemID != Item.potion.shiftedIndex)
						{
							if (itemstack1.itemID < 256)
							{
								mc.thePlayer.addChatMessage("That block is worthless.");
							} else
							{
								mc.thePlayer.addChatMessage("That item is worthless.");
							}
						} else
						{
							mod_ZooTrade.debug(9);
							itemstack1.stackSize--;
							mod_ZooTrade.money = (int) (mod_ZooTrade.money + Trade.getPrice(itemstack1) * d);
						}
					}

				} else if (itemstack1 != null)
				{
					if (Trade.getPrice(itemstack1) <= 1 && itemstack1.itemID != Item.potion.shiftedIndex)
					{
						mod_ZooTrade.debug(10);
					} else if (itemstack1.stackSize >= 2)
					{
						if (j == 0)
						{
							if (Trade.getPrice(itemstack1) * d * itemstack1.stackSize <= 1 * itemstack1.stackSize && itemstack1.itemID != Item.potion.shiftedIndex)
							{
								if (itemstack1.itemID < 256)
								{
									mc.thePlayer.addChatMessage("Those blocks are worthless.");
								} else
								{
									mc.thePlayer.addChatMessage("Those items are worthless.");
								}
							} else
							{
								mod_ZooTrade.debug(12);
								inventoryplayer.setItemStack(null);
								mod_ZooTrade.money += (int) (Trade.getPrice(itemstack1) * d * itemstack1.stackSize);
							}
						} else if (j == 1)
						{
							if (Trade.getPrice(itemstack1) * d <= 1.0D)
							{
								if (itemstack1.itemID < 256)
								{
									mc.thePlayer.addChatMessage("That block is worthless.");
								} else
								{
									mc.thePlayer.addChatMessage("That item is worthless.");
								}
							} else
							{
								mod_ZooTrade.debug(14);
								itemstack1.stackSize--;
								mod_ZooTrade.money += (int) (Trade.getPrice(itemstack1) * d);
							}
						}
					} else if (Trade.getPrice(itemstack1) * d <= 1.0D && itemstack1.itemID != Item.potion.shiftedIndex)
					{
						if (itemstack1.itemID < 256)
						{
							mc.thePlayer.addChatMessage("That block is worthless.");
						} else
						{
							mc.thePlayer.addChatMessage("That item is worthless.");
						}
					} else
					{
						mod_ZooTrade.debug(16);
						inventoryplayer.setItemStack(null);
						mod_ZooTrade.money += (int) (Trade.getPrice(itemstack1) * d);
					}
				} else if (itemstack4 == null)
				{
					mod_ZooTrade.debug(17);
					inventoryplayer.setItemStack(null);
				} else if (itemstack1 == null || itemstack1.itemID != itemstack4.itemID)
				{
					if (mod_ZooTrade.money >= Trade.getPrice(itemstack4))
					{
						if (!flag && j != 1)
						{
							mod_ZooTrade.debug(18);
							inventoryplayer.setItemStack(ItemStack.copyItemStack(itemstack4));
							mod_ZooTrade.money -= Trade.getPrice(itemstack4);
						} else if (mod_ZooTrade.money >= Trade.getPrice(itemstack4) * itemstack4.getMaxStackSize() && j != 1)
						{
							mod_ZooTrade.debug(19);
							inventoryplayer.setItemStack(ItemStack.copyItemStack(itemstack4));
							ItemStack itemstack2 = inventoryplayer.getItemStack();
							if (flag && itemstack2.stackSize < itemstack2.getMaxStackSize())
							{
								mod_ZooTrade.debug(20);
								mod_ZooTrade.money -= Trade.getPrice(itemstack2) * itemstack2.getMaxStackSize();
								itemstack2.stackSize = itemstack2.getMaxStackSize();
							}
						}
					}
				}
			} else
			{
				mod_ZooTrade.debug(21);
				ItemStack itemstack = inventorySlots.getSlot(slot.slotNumber).getStack();
				if (Keyboard.isKeyDown(25) && itemstack != null)
				{
					if (flag)
					{
						Trade.displayValues(itemstack, 1);
					} else
					{
						Trade.displayValues(itemstack, 0);
					}
				} else
				{
					inventorySlots.slotClick(slot.slotNumber, j, flag, mc.thePlayer);
					mc.playerController.sendSlotPacket(itemstack, slot.slotNumber - inventorySlots.inventorySlots.size() + 9 + 36);
				}
			}
		} else
		{
			InventoryPlayer inventoryplayer1 = mc.thePlayer.inventory;
			if (inventoryplayer1.getItemStack() != null)
			{
				if (j == 0)
				{
					mc.thePlayer.dropPlayerItem(inventoryplayer1.getItemStack());
					mc.playerController.func_35639_a(inventoryplayer1.getItemStack());
					inventoryplayer1.setItemStack(null);
				}
				if (j == 1)
				{
					ItemStack itemstack3 = inventoryplayer1.getItemStack().splitStack(1);
					mc.thePlayer.dropPlayerItem(itemstack3);
					mc.playerController.func_35639_a(itemstack3);
					if (inventoryplayer1.getItemStack().stackSize == 0)
					{
						inventoryplayer1.setItemStack(null);
					}
				}
			}
		}
	}

	public void drawScreen(int i, int j, float f)
	{
		boolean flag = Mouse.isButtonDown(0);
		int k = guiLeft;
		int l = guiTop;
		int i1 = k + 154;
		int j1 = l + 17;
		int k1 = i1 + 14;
		int l1 = j1 + 90;
		if (!wasClicking && flag && i >= i1 && j >= j1 && i < k1 && j < l1)
		{
			isScrolling = true;
		}
		if (!flag)
		{
			isScrolling = false;
		}
		wasClicking = flag;
		if (isScrolling)
		{
			currentScroll = (float) (j - (j1 + 8)) / ((float) (l1 - j1) - 25F);
			if (currentScroll < 0.0F)
			{
				currentScroll = 0.0F;
			}
			if (currentScroll > 1.0F)
			{
				currentScroll = 1.0F;
			}
			((ZooContainerTradingTools) inventorySlots).scrollTo(currentScroll);
		}
		super.drawScreen(i, j, f);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(2896 /* GL_LIGHTING */);
	}

	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int k = mc.renderEngine.getTexture("/zoo/gui/guiTrading.png");
		mc.renderEngine.bindTexture(k);
		int l = guiLeft;
		int i1 = guiTop;
		drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
		int j1 = l + 155;
		int k1 = i1 + 17;
		int l1 = k1 + 160 + 2;
		drawTexturedModalRect(l + 154, i1 + 17 + (int) ((float) (l1 - k1 - 89) * currentScroll), 0, 208, 16, 16);
	}

	protected void drawGuiContainerForegroundLayer()
	{
		if (mod_ZooTrade.debug())
		{
			fontRenderer.drawString("You are in debug mode!", 8, 6, 0x404040);
		} else
		{
			fontRenderer.drawString("Hold P and click for price.", 8, 6, 0x404040);
		}
	}

	public void initGui()
	{
		super.initGui();
		controlList.clear();
	}

	public void handleMouseInput()
	{
		super.handleMouseInput();
		int i = Mouse.getEventDWheel();
		if (i != 0)
		{
			int j = (((ZooContainerTradingTools) inventorySlots).itemList.size() / 8 - 8) + 1;
			if (i > 0)
			{
				i = 1;
			}
			if (i < 0)
			{
				i = -1;
			}
			currentScroll -= (double) i / (double) j;
			if (currentScroll < 0.0F)
			{
				currentScroll = 0.0F;
			}
			if (currentScroll > 1.0F)
			{
				currentScroll = 1.0F;
			}
			((ZooContainerTradingTools) inventorySlots).scrollTo(currentScroll);
		}
	}

	static InventoryBasic getInventory()
	{
		return inventory;
	}

}
