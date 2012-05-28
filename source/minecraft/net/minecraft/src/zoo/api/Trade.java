package net.minecraft.src.zoo.api;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Container;
import net.minecraft.src.InventoryBasic;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.Slot;
import net.minecraft.src.mod_ZooCore;
import net.minecraft.src.mod_ZooTrade;

import org.lwjgl.input.Keyboard;

public class Trade
{

	private static int money;
	private static double priceModifier = mod_ZooTrade.getGeneralDouble("Price modifier", 0.6D);

	public static void handleMouseClick(Slot slot, Minecraft mc, Container inventorySlots, InventoryBasic inventory, int j, boolean flag)
	{
		if (slot != null)
		{
			double d = getPriceModifier();
			if (slot.inventory == inventory)
			{
				InventoryPlayer inventoryplayer = mc.thePlayer.inventory;
				ItemStack itemstack1 = inventoryplayer.getItemStack();
				ItemStack itemstack4 = slot.getStack();
				if (!mod_ZooTrade.debug() && Keyboard.isKeyDown(mod_ZooCore.instance.options.keyCode) && itemstack4 != null)
				{
					if (flag)
					{
						mod_ZooTrade.debug(0);
						displayValues(itemstack4, 1);
					} else
					{
						mod_ZooTrade.debug(1);
						displayValues(itemstack4, 0);
					}
				} else if (itemstack1 != null && itemstack4 != null && itemstack1.itemID == itemstack4.itemID && j != 1)
				{
					if (j == 0)
					{
						if (flag)
						{
							if (getMoney() >= getPrice(itemstack4) * itemstack4.getMaxStackSize() - getPrice(itemstack4) * itemstack4.stackSize)
							{
								if (getMoney() < getPrice(itemstack4) * itemstack4.getMaxStackSize() - getPrice(itemstack4) * itemstack4.stackSize)
								{
									mod_ZooTrade.debug(2);
								} else if (itemstack1.stackSize < itemstack1.getMaxStackSize())
								{
									if (getPrice(itemstack4) * itemstack1.getMaxStackSize() - getPrice(itemstack4) * itemstack1.stackSize > getMoney())
									{
										mod_ZooTrade.debug(3);
									} else
									{
										mod_ZooTrade.debug(4);
										decreaseMoney(getPrice(itemstack4) * itemstack1.getMaxStackSize() - getPrice(itemstack4) * itemstack1.stackSize);
										itemstack1.stackSize = itemstack1.getMaxStackSize();
									}
								}
							}
						} else if (itemstack1.stackSize < itemstack1.getMaxStackSize())
						{
							if (itemstack4.getItemDamage() != itemstack1.getItemDamage())
							{
								if (getPrice(itemstack1) * d * itemstack1.stackSize <= (1 * itemstack1.stackSize) && itemstack1.itemID != Item.potion.shiftedIndex)
								{
									if (itemstack1.itemID < Item.shovelSteel.shiftedIndex)
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
									increaseMoney((int) (getPrice(itemstack1) * d * itemstack1.stackSize));
								}
							} else if (getMoney() >= getPrice(itemstack4))
							{
								mod_ZooTrade.debug(4);
								itemstack1.stackSize++;
								decreaseMoney(getPrice(itemstack4));
							}
						}
					} else if (itemstack1.stackSize <= 1)
					{
						if (getPrice(itemstack1) * d <= 1.0D && itemstack1.itemID != Item.potion.shiftedIndex)
						{
							if (itemstack1.itemID < Item.shovelSteel.shiftedIndex)
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
							increaseMoney((int) (getPrice(itemstack1) * d));
						}
					} else if (getMoney() >= getPrice(itemstack1))
					{
						if (getPrice(itemstack1) <= 1 && itemstack1.itemID != Item.potion.shiftedIndex)
						{
							mod_ZooTrade.debug(8);
						} else if (getPrice(itemstack1) * d <= 1.0D && itemstack1.itemID != Item.potion.shiftedIndex)
						{
							if (itemstack1.itemID < Item.shovelSteel.shiftedIndex)
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
							increaseMoney((int) (getPrice(itemstack1) * d));
						}
					}

				} else if (itemstack1 != null)
				{
					if (getPrice(itemstack1) <= 1 && itemstack1.itemID != Item.potion.shiftedIndex)
					{
						mod_ZooTrade.debug(10);
					} else if (itemstack1.stackSize >= 2)
					{
						if (j == 0)
						{
							if (getPrice(itemstack1) * d * itemstack1.stackSize <= 1 * itemstack1.stackSize && itemstack1.itemID != Item.potion.shiftedIndex)
							{
								if (itemstack1.itemID < Item.shovelSteel.shiftedIndex)
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
								increaseMoney((int) (getPrice(itemstack1) * d * itemstack1.stackSize));
							}
						} else if (j == 1)
						{
							if (getPrice(itemstack1) * d <= 1.0D)
							{
								if (itemstack1.itemID < Item.shovelSteel.shiftedIndex)
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
								increaseMoney((int) (getPrice(itemstack1) * d));
							}
						}
					} else if (getPrice(itemstack1) * d <= 1.0D && itemstack1.itemID != Item.potion.shiftedIndex)
					{
						if (itemstack1.itemID < Item.shovelSteel.shiftedIndex)
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
						increaseMoney((int) (getPrice(itemstack1) * d));
					}
				} else if (itemstack4 == null)
				{
					mod_ZooTrade.debug(17);
					inventoryplayer.setItemStack(null);
				} else if (itemstack1 == null || itemstack1.itemID != itemstack4.itemID)
				{
					if (getMoney() >= getPrice(itemstack4))
					{
						if (!flag && j != 1)
						{
							mod_ZooTrade.debug(18);
							inventoryplayer.setItemStack(ItemStack.copyItemStack(itemstack4));
							decreaseMoney(getPrice(itemstack4));
						} else if (getMoney() >= getPrice(itemstack4) * itemstack4.getMaxStackSize() && j != 1)
						{
							mod_ZooTrade.debug(19);
							inventoryplayer.setItemStack(ItemStack.copyItemStack(itemstack4));
							ItemStack itemstack2 = inventoryplayer.getItemStack();
							if (flag && itemstack2.stackSize < itemstack2.getMaxStackSize())
							{
								mod_ZooTrade.debug(20);
								decreaseMoney(getPrice(itemstack2) * itemstack2.getMaxStackSize());
								itemstack2.stackSize = itemstack2.getMaxStackSize();
							}
						}
					}
				}
			} else
			{
				mod_ZooTrade.debug(21);
				ItemStack itemstack = inventorySlots.getSlot(slot.slotNumber).getStack();
				if (Keyboard.isKeyDown(mod_ZooCore.instance.options.keyCode) && itemstack != null)
				{
					if (flag)
					{
						displayValues(itemstack, 1);
					} else
					{
						displayValues(itemstack, 0);
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

	public static void setMoney(int i)
	{
		money = i;
	}

	public static double getPriceModifier()
	{
		return priceModifier;
	}

	public static int getMoney()
	{
		return money;
	}

	public static boolean decreaseMoney(int i)
	{
		int money1 = money;
		if (money1 - i > 0)
		{
			money -= i;
			return true;
		} else
		{
			ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Not enough money!");
			return false;
		}
	}

	public static void increaseMoney(int i)
	{
		money += i;
	}

	public static int getPrice(ItemStack itemstack)
	{
		int i = priceLib(itemstack);

		if (itemstack.getItem() instanceof ItemBlock)
		{
			for (Block block : Block.blocksList)
			{
				if (block != null && block instanceof ITrade)
				{
					ITrade handler = (ITrade) block;

					if (itemstack.itemID == block.blockID)
					{
						i = handler.getPrice(itemstack.itemID, itemstack.getItemDamage());
					}
				}
			}
		} else
		{
			for (Item item : Item.itemsList)
			{
				if (item != null && item instanceof ITrade)
				{
					ITrade handler = (ITrade) item;

					if (itemstack.itemID == item.shiftedIndex)
					{
						System.out.println(itemstack.itemID + " " + itemstack.getItemDamage());
						i = handler.getPrice(itemstack.itemID, itemstack.getItemDamage());
					}
				}
			}
		}
		return i;
	}

	/**
	 * This function is mainly a library which defines prices of vanilla
	 * minecraft items and blocks
	 * 
	 * @param itemstack
	 *            ItemStack
	 * @return Item price.
	 */

	protected static int priceLib(ItemStack itemstack)
	{
		String name = itemstack.getItem().getItemName();
		int i = itemstack.getItemDamage();
		if (name.equals("tile.stone"))
			return 1; // Stone
		if (name.equals("tile.grass"))
			return 1; // Grass Block
		if (name.equals("tile.dirt"))
			return 1; // Dirt
		if (name.equals("tile.stonebrick"))
			return 1; // Cobblestone
		if (name.equals("tile.wood"))
			return 1; // Wooden Planks
		if (name.equals("tile.sapling"))
			return 2; // Sapling
		if (name.equals("tile.bedrock"))
			return 0; // Bedrock
		if (name.equals("tile.water"))
			return 0; // Water
		if (name.equals("tile.water"))
			return 0; // Water
		if (name.equals("tile.lava"))
			return 0; // Lava
		if (name.equals("tile.lava"))
			return 0; // Lava
		if (name.equals("tile.sand"))
			return 1; // Sand
		if (name.equals("tile.gravel"))
			return 1; // Gravel
		if (name.equals("tile.oreGold"))
			return 250; // Gold Ore
		if (name.equals("tile.oreIron"))
			return 50; // Iron Ore
		if (name.equals("tile.oreCoal"))
			return 0; // Coal Ore
		if (name.equals("tile.log") && i == 0)
			return 4; // Wood
		if (name.equals("tile.log") && i == 1)
			return 5; // Wood
		if (name.equals("tile.log") && i == 2)
			return 5; // Wood
		if (name.equals("tile.leaves"))
			return 1; // Leaves
		if (name.equals("tile.sponge"))
			return 0; // Sponge
		if (name.equals("tile.glass"))
			return 3; // Glass
		if (name.equals("tile.oreLapis"))
			return 0; // Lapis Lazuli Ore
		if (name.equals("tile.blockLapis"))
			return 180; // Lapis Lazuli Block
		if (name.equals("tile.dispenser"))
			return 40; // Dispenser
		if (name.equals("tile.sandStone"))
			return 2; // Sandstone
		if (name.equals("tile.musicBlock"))
			return 10; // Note Block
		if (name.equals("tile.bed"))
			return 0; // Bed
		if (name.equals("tile.goldenRail"))
			return 70; // Powered Rail
		if (name.equals("tile.detectorRail"))
			return 15; // Detector Rail
		if (name.equals("tile.pistonStickyBase"))
			return 130; // Sticky Piston
		if (name.equals("tile.web"))
			return 10; // Cobweb
		if (name.equals("tile.tallgrass") && i == 0)
			return 2; // Shrub
		if (name.equals("tile.tallgrass") && i == 1)
			return 3; // Grass
		if (name.equals("tile.tallgrass") && i == 3)
			return 2; // Fern
		if (name.equals("tile.tallgrass") && i == 4)
			return 3; // Grass
		if (name.equals("tile.deadbush"))
			return 2; // Dead Bush
		if (name.equals("tile.pistonBase"))
			return 113; // Piston
		if (name.equals("tile.cloth") && i == 11)
			return 20; // Blue Wool
		if (name.equals("tile.cloth"))
			return 5; // Wool
		if (name.equals("tile.flower"))
			return 2; // Flower
		if (name.equals("tile.rose"))
			return 2; // Rose
		if (name.equals("tile.mushroom"))
			return 3; // Mushroom
		if (name.equals("tile.mushroom"))
			return 3; // Mushroom
		if (name.equals("tile.blockGold"))
			return 1350; // Block of Gold
		if (name.equals("tile.blockIron"))
			return 450; // Block of Iron
		if (name.equals("tile.stoneSlab"))
			return 1; //
		if (name.equals("tile.brick"))
			return 12; // Bricks
		if (name.equals("tile.tnt"))
			return 154; // TNT
		if (name.equals("tile.bookshelf"))
			return 51; // Bookshelf
		if (name.equals("tile.stoneMoss"))
			return 14; // Moss Stone
		if (name.equals("tile.obsidian"))
			return 25; // Obsidian
		if (name.equals("tile.torch"))
			return 1; // Torch
		if (name.equals("tile.fire"))
			return 0; // Fire
		if (name.equals("tile.mobSpawner"))
			return 0; // Monster Spawner
		if (name.equals("tile.stairsWood"))
			return 2; // Wooden Stairs
		if (name.equals("tile.chest"))
			return 4; // Chest
		if (name.equals("tile.redstoneDust"))
			return 0; // Redstone Dust
		if (name.equals("tile.oreDiamond"))
			return 0; // Diamond Ore
		if (name.equals("tile.blockDiamond"))
			return 8100; // Block of Diamond
		if (name.equals("tile.workbench"))
			return 2; // Crafting Table
		if (name.equals("tile.crops"))
			return 0; // Crops
		if (name.equals("tile.farmland"))
			return 0; // Farmland
		if (name.equals("tile.furnace"))
			return 8; // Furnace
		if (name.equals("tile.furnace"))
			return 8; // Furnace
		if (name.equals("tile.sign"))
			return 0; // Sign
		if (name.equals("tile.doorWood"))
			return 0; // Wooden Door
		if (name.equals("tile.ladder"))
			return 1; // Ladder
		if (name.equals("tile.rail"))
			return 30; // Rail
		if (name.equals("tile.stairsStone"))
			return 6; // Stone Stairs
		if (name.equals("tile.sign"))
			return 0; // Sign
		if (name.equals("tile.lever"))
			return 1; // Lever
		if (name.equals("tile.pressurePlate"))
			return 3; // Pressure Plate
		if (name.equals("tile.doorIron"))
			return 0; // Iron Door
		if (name.equals("tile.pressurePlate"))
			return 3; // Pressure Plate
		if (name.equals("tile.oreRedstone"))
			return 0; // Redstone Ore
		if (name.equals("tile.oreRedstone"))
			return 0; // Redstone Ore
		if (name.equals("tile.notGate"))
			return 0; // Redstone Torch
		if (name.equals("tile.notGate"))
			return 0; // Redstone Torch
		if (name.equals("tile.button"))
			return 5; // Button
		if (name.equals("tile.snow"))
			return 4; // Snow
		if (name.equals("tile.ice"))
			return 2; // Ice
		if (name.equals("tile.snow"))
			return 4; // Snow
		if (name.equals("tile.cactus"))
			return 2; // Cactus
		if (name.equals("tile.clay"))
			return 4; // Clay
		if (name.equals("tile.reeds"))
			return 5; // Sugar cane
		if (name.equals("tile.jukebox"))
			return 908; // Jukebox
		if (name.equals("tile.fence"))
			return 1; // Fence
		if (name.equals("tile.pumpkin"))
			return 30; // Pumpkin
		if (name.equals("tile.hellrock"))
			return 1; // Netherrack
		if (name.equals("tile.hellsand"))
			return 1; // Soul Sand
		if (name.equals("tile.lightgem"))
			return 12; // Glowstone
		if (name.equals("tile.portal"))
			return 0; // Portal
		if (name.equals("tile.litpumpkin"))
			return 31; // Jack 'o' Lantern
		if (name.equals("tile.cake"))
			return 50; // Cake
		if (name.equals("tile.diode"))
			return 0; //
		if (name.equals("tile.diode"))
			return 0; //
		if (name.equals("tile.lockedchest"))
			return 0; // Locked chest
		if (name.equals("tile.trapdoor"))
			return 6; // Trapdoor
		if (name.equals("tile.stonebricksmooth"))
			return 5; // Stone Bricks
		if (name.equals("tile.mushroom"))
			return 3; // Mushroom
		if (name.equals("tile.fenceIron"))
			return 5; // Iron Bars
		if (name.equals("tile.thinGlass"))
			return 1; // Glass Pane
		if (name.equals("tile.melon"))
			return 18; // Melon
		if (name.equals("tile.pumpkinStem"))
			return 0; //
		if (name.equals("tile.pumpkinStem"))
			return 0; //
		if (name.equals("tile.vine"))
			return 10; // Vines
		if (name.equals("tile.fenceGate"))
			return 1; // Fence Gate
		if (name.equals("tile.stairsBrick"))
			return 4; // Brick Stairs
		if (name.equals("tile.stairsStoneBrickSmooth"))
			return 10; // Stone Brick Stairs
		if (name.equals("tile.mycel"))
			return 0; // Mycelium
		if (name.equals("tile.waterlily"))
			return 2; // Lily Pad
		if (name.equals("tile.netherBrick"))
			return 4; // Nether Brick
		if (name.equals("tile.netherFence"))
			return 8; // Nether Brick Fence
		if (name.equals("tile.stairsNetherBrick"))
			return 8; // Nether Brick Stairs
		if (name.equals("tile.netherStalk"))
			return 20; // Nether Wart
		if (name.equals("tile.enchantmentTable"))
			return 1915; // Enchantment Table
		if (name.equals("tile.whiteStone"))
			return 10; // End Stone
		if (name.equals("tile.redstoneLight"))
			return 40; // Glowstone Lamp
		if (name.equals("item.shovelIron"))
			return 52; // Iron Shovel
		if (name.equals("item.pickaxeIron"))
			return 152; // Iron Pickaxe
		if (name.equals("item.hatchetIron"))
			return 152; // Iron Axe
		if (name.equals("item.flintAndSteel"))
			return 53; // Flint and Steel
		if (name.equals("item.apple"))
			return 30; // Apple
		if (name.equals("item.bow"))
			return 16; // Bow
		if (name.equals("item.arrow"))
			return 7; // Arrow
		if (name.equals("item.coal"))
			return 2; // Coal
		if (name.equals("item.charcoal"))
			return 2; // Charcoal
		if (name.equals("item.emerald"))
			return 900; // Diamond
		if (name.equals("item.ingotIron"))
			return 50; // Iron Ingot
		if (name.equals("item.ingotGold"))
			return 150; // Gold Ingot
		if (name.equals("item.swordIron"))
			return 101; // Iron Sword
		if (name.equals("item.swordWood"))
			return 3; // Wooden Sword
		if (name.equals("item.shovelWood"))
			return 3; // Wooden Shovel
		if (name.equals("item.pickaxeWood"))
			return 5; // Wooden Pickaxe
		if (name.equals("item.hatchetWood"))
			return 4; // Wooden Axe
		if (name.equals("item.swordStone"))
			return 4; // Stone Sword
		if (name.equals("item.shovelStone"))
			return 4; // Stone Shovel
		if (name.equals("item.pickaxeStone"))
			return 6; // Stone Pickaxe
		if (name.equals("item.hatchetStone"))
			return 5; // Stone Axe
		if (name.equals("item.swordDiamond"))
			return 1801; // Diamond Sword
		if (name.equals("item.shovelDiamond"))
			return 902; // Diamond Shovel
		if (name.equals("item.pickaxeDiamond"))
			return 2702; // Diamond Pickaxe
		if (name.equals("item.hatchetDiamond"))
			return 2702; // Diamond Axe
		if (name.equals("item.stick"))
			return 1; // Stick
		if (name.equals("item.bowl"))
			return 2; // Bowl
		if (name.equals("item.mushroomStew"))
			return 6; // Mushroom Stew
		if (name.equals("item.swordGold"))
			return 301; // Golden Sword
		if (name.equals("item.shovelGold"))
			return 152; // Golden Shovel
		if (name.equals("item.pickaxeGold"))
			return 452; // Golden Pickaxe
		if (name.equals("item.hatchetGold"))
			return 452; // Golden Axe
		if (name.equals("item.string"))
			return 8; // String
		if (name.equals("item.feather"))
			return 4; // Feather
		if (name.equals("item.sulphur"))
			return 30; // Gunpowder
		if (name.equals("item.hoeWood"))
			return 2; // Wooden Hoe
		if (name.equals("item.hoeStone"))
			return 3; // Stone Hoe
		if (name.equals("item.hoeIron"))
			return 102; // Iron Hoe
		if (name.equals("item.hoeDiamond"))
			return 1802; // Diamond Hoe
		if (name.equals("item.hoeGold"))
			return 302; // Golden Hoe
		if (name.equals("item.seeds"))
			return 3; // Seeds
		if (name.equals("item.wheat"))
			return 16; // Wheat
		if (name.equals("item.bread"))
			return 13; // Bread
		if (name.equals("item.helmetCloth"))
			return 70; // Leather Cap
		if (name.equals("item.chestplateCloth"))
			return 156; // Leather Tunic
		if (name.equals("item.leggingsCloth"))
			return 130; // Leather Pants
		if (name.equals("item.bootsCloth"))
			return 80; // Leather Boots
		if (name.equals("item.helmetChain"))
			return 130; // Chain Helmet
		if (name.equals("item.chestplateChain"))
			return 230; // Chain Chestplate
		if (name.equals("item.leggingsChain"))
			return 170; // Chain Leggings
		if (name.equals("item.bootsChain"))
			return 110; // Chain Boots
		if (name.equals("item.helmetIron"))
			return 250; // Iron Helmet
		if (name.equals("item.chestplateIron"))
			return 400; // Iron Chestplate
		if (name.equals("item.leggingsIron"))
			return 350; // Iron Leggings
		if (name.equals("item.bootsIron"))
			return 102; // Iron Boots
		if (name.equals("item.helmetDiamond"))
			return 4500; // Diamond Helmet
		if (name.equals("item.chestplateDiamond"))
			return 7300; // Diamond Chestplate
		if (name.equals("item.leggingsDiamond"))
			return 6300; // Diamond Leggings
		if (name.equals("item.bootsDiamond"))
			return 3600; // Diamond Boots
		if (name.equals("item.helmetGold"))
			return 750; // Golden Helmet
		if (name.equals("item.chestplateGold"))
			return 1200; // Golden Chestplate
		if (name.equals("item.leggingsGold"))
			return 1050; // Golden Leggings
		if (name.equals("item.bootsGold"))
			return 600; // Golden boots
		if (name.equals("item.flint"))
			return 3; // Flint
		if (name.equals("item.porkchopRaw"))
			return 12; // Raw Porkchop
		if (name.equals("item.porkchopCooked"))
			return 15; // Cooked Porkchop
		if (name.equals("item.painting"))
			return 15; // Painting
		if (name.equals("item.appleGold"))
			return 110; // Golden Apple
		if (name.equals("item.sign"))
			return 5; // Sign
		if (name.equals("item.doorWood"))
			return 5; // Wooden Door
		if (name.equals("item.bucket"))
			return 110; // Bucket
		if (name.equals("item.bucketWater"))
			return 120; // Water Bucket
		if (name.equals("item.bucketLava"))
			return 170; // Lava bucket
		if (name.equals("item.minecart"))
			return 220; // Minecart
		if (name.equals("item.saddle"))
			return 250; // Saddle
		if (name.equals("item.doorIron"))
			return 300; // Iron Door
		if (name.equals("item.redstone"))
			return 7; // Redstone
		if (name.equals("item.snowball"))
			return 3; // Snowball
		if (name.equals("item.boat"))
			return 5; // Boat
		if (name.equals("item.leather"))
			return 15; // Leather
		if (name.equals("item.milk"))
			return 130; // Milk
		if (name.equals("item.brick"))
			return 3; // Brick
		if (name.equals("item.clay"))
			return 3; // Clay
		if (name.equals("item.reeds"))
			return 5; // Sugar Canes
		if (name.equals("item.paper"))
			return 6; // Paper
		if (name.equals("item.book"))
			return 15; // Book
		if (name.equals("item.slimeball"))
			return 17; // Slimeball
		if (name.equals("item.minecartChest"))
			return 230; // Minecart with Chest
		if (name.equals("item.minecartFurnace"))
			return 220; // Minecart with Furnace
		if (name.equals("item.egg"))
			return 1; // Egg
		if (name.equals("item.compass"))
			return 207; // Compass
		if (name.equals("item.fishingRod"))
			return 13; // Fishing Rod
		if (name.equals("item.clock"))
			return 407; // Clock
		if (name.equals("item.yellowDust"))
			return 1; // Glowstone Dust
		if (name.equals("item.fishRaw"))
			return 5; // Raw Fish
		if (name.equals("item.fishCooked"))
			return 7; // Cooked Fish
		if (name.equals("item.dyePowder") && i == 4)
			return 20; // Lapis Lazuli
		if (name.equals("item.dyePowder"))
			return 10;
		if (name.equals("item.bone"))
			return 6; // Bone
		if (name.equals("item.sugar"))
			return 6; // Sugar
		if (name.equals("item.cake"))
			return 150; // Cake
		if (name.equals("item.bed"))
			return 33; // Bed
		if (name.equals("item.diode"))
			return 29; // Redstone Repeater
		if (name.equals("item.cookie"))
			return 4; // Cookie
		if (name.equals("item.map"))
			return 260; // Map
		if (name.equals("item.shears"))
			return 120; // Shears
		if (name.equals("item.melon"))
			return 6; // Melon
		if (name.equals("item.seeds_pumpkin"))
			return 2; // Pumpkin Seeds
		if (name.equals("item.seeds_melon"))
			return 2; // Melon Seeds
		if (name.equals("item.beefRaw"))
			return 4; // Raw Beef
		if (name.equals("item.beefCooked"))
			return 6; // Steak
		if (name.equals("item.chickenRaw"))
			return 10; // Raw Chicken
		if (name.equals("item.chickenCooked"))
			return 12; // Cooked Chicken
		if (name.equals("item.rottenFlesh"))
			return 4; // Rotten Flesh
		if (name.equals("item.enderPearl"))
			return 13; // Ender Pearl
		if (name.equals("item.blazeRod"))
			return 10; // Blaze Rod
		if (name.equals("item.ghastTear"))
			return 10; // Ghast Tear
		if (name.equals("item.goldNugget"))
			return 10; // Gold Nugget
		if (name.equals("item.netherStalkSeeds"))
			return 10; // Nether Wart
		if (name.equals("item.potion") && i == 0)
			return 10; // Water Bottle
		if (name.equals("item.potion") && i == 1)
			return 40; // Water Bottle
		if (name.equals("item.potion") && i == 2)
			return 40; // Water Bottle
		if (name.equals("item.potion") && i == 3)
			return 40; // Water Bottle
		if (name.equals("item.potion") && i == 5)
			return 40; // Water Bottle
		if (name.equals("item.potion") && i == 9)
			return 70; // Water Bottle
		if (name.equals("item.potion") && i == 33)
			return 100; // Water Bottle
		if (name.equals("item.potion") && i == 34)
			return 100; // Water Bottle
		if (name.equals("item.potion") && i == 37)
			return 100; // Water Bottle
		if (name.equals("item.potion") && i == 41)
			return 200; // Water Bottle
		if (name.equals("item.potion") && i == 57)
			return 200; // Water Bottle
		if (name.equals("item.potion") && i == 65)
			return 200; // Water Bottle
		if (name.equals("item.potion") && i == 66)
			return 200; // Water Bottle
		if (name.equals("item.potion") && i == 67)
			return 300; // Water Bottle
		if (name.equals("item.potion") && i == 73)
			return 300; // Water Bottle
		if (name.equals("item.glassBottle"))
			return 3; // Glass Bottle
		if (name.equals("item.spiderEye"))
			return 10; // Spider Eye
		if (name.equals("item.fermentedSpiderEye"))
			return 10; // Fermented Spider Eye
		if (name.equals("item.blazePowder"))
			return 13; // Blaze Powder
		if (name.equals("item.magmaCream"))
			return 30; // Magma Cream
		if (name.equals("item.brewingStand"))
			return 100; // Brewing Stand
		if (name.equals("item.cauldron"))
			return 100; // Cauldron
		if (name.equals("item.eyeOfEnder"))
			return 50; // Eye of Ender
		if (name.equals("item.speckledMelon"))
			return 10; // Glistering Melon
		if (name.equals("item.record"))
			return 720; // Music Disc
		if (name.equals("item.catalogue"))
			return 143; // Minecraft Catalogue
		if (name.equals("item.expBottle"))
			return 150; // Exp Bottle
		if (name.equals("item.fireball"))
			return 4; // Fire Charge
		return -1;
	}

	/**
	 * This function displays value of certain itemstack
	 * 
	 * @param itemstack
	 *            ItemStack
	 * @param i
	 *            0 - price for 1 of that stack, 1 - price for full possible
	 *            stack size
	 */

	public static void displayValues(ItemStack itemstack, int i)
	{
		String s = itemstack.getItem().getItemNameIS(itemstack);
		if (s.startsWith("tile."))
		{
			switch (i)
			{
			case 0:
				ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Single Block Value:$ " + getPrice(itemstack) * itemstack.stackSize);
				break;
			case 1:
				ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Max Stack Value:$ " + getPrice(itemstack) * itemstack.getMaxStackSize());
			}
		}
		if (s.startsWith("item."))
		{
			switch (i)
			{
			case 0:
				ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Single Item Value:$ " + getPrice(itemstack) * itemstack.stackSize);
				break;
			case 1:
				ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Max Stack Value:$ " + getPrice(itemstack) * itemstack.getMaxStackSize());
			}
		}
	}

}
