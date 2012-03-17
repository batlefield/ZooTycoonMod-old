package net.minecraft.src.zoo.api;

import java.util.*;

import net.minecraft.src.battlefield.API.DamageKey;
import net.minecraft.src.forge.*;
import net.minecraft.src.*;

/** Trading API or TAPI
 * Developed to add custom items/blocks
 * to desired shopkeeper GUI<br /><br />
 * 
 * GUI ID's:<br />
 * 1 - Merchant that sells dirt.<br />
 * 2 - Merchant that sells food.<br />
 * 3 - Merchant that sells fencing.<br />
 * 4 - Merchant that sells special blocks<br />
 * 5 - Merchant that sells technical stuff<br />
 * 6 - Merchant that sells ingridients for potions and potions<br />
 * 7 - Merchant that sells plants and stuff<br />
 * 8 - Merchant that sells tools and armor<br />
 * 9 - Merchant that sells decorative items(bookshelves wool...)<br />
 * 10 - merchant that sells items from other mods<br />
 * 
 * @author Battlefield
 * @category Trading
 * @see registerBlock
 * @see registerItem
 */

public class Trade {
	
	private static boolean hasInit = false;
	
	public static void init()
    {
		if(!hasInit)
		{
			hasInit = true;
			System.out.println("TradeAPI: TradeAPI initialized successfuly");
		}
    }
	
	private static Map<DamageKey, Integer> priceMap = new HashMap<DamageKey, Integer>();
	
	private static List dirtBlocks = new ArrayList();
	private static List dirtItems = new ArrayList();
	
	private static List foodBlocks = new ArrayList();
	private static List foodItems = new ArrayList();
	
	private static List fenceBlocks = new ArrayList();
	private static List fenceItems = new ArrayList();
	
	private static List specialBlocks = new ArrayList();
	private static List specialItems = new ArrayList();
	
	private static List techBlocks = new ArrayList();
	private static List techItems = new ArrayList();
	
	private static List potionBlocks = new ArrayList();
	private static List potionItems = new ArrayList();
	
	private static List plantBlocks = new ArrayList();
	private static List plantItems = new ArrayList();
	
	private static List toolBlocks = new ArrayList();
	private static List toolItems = new ArrayList();
	
	private static List decorBlocks = new ArrayList();
	private static List decorItems = new ArrayList();	
	
	private static List modBlocks = new ArrayList();
	private static List modItems = new ArrayList();
	
	
	/**
	 * This function gets a list of items to be put to ceratin GUI. Should not be used
	 * outside default shopkeeper GUI's
	 * @param id				Id of GUI in which item is placed in.
	 * @return					Returns list of items.
	 * @throws					IllegalArgumentException if the GUI id is not defined.
	 */
	public static List getItems(int id)
	{
		if(!hasInit)
		{
			init();
		}
		  if(id == 1)
		  {
			  return dirtItems;
		  }
		  if(id == 2)
		  {
			  return foodItems;
		  }
		  if(id == 3)
		  {
			  return fenceItems;
		  }
		  if(id == 4)
		  {
			  return specialItems;
		  }
		  if(id == 5)
		  {
			  return techItems;
		  }
		  if(id == 6)
		  {
			  return potionItems;
		  }
		  if(id == 7)
		  {
			  return plantItems;
		  }
		  if(id == 8)
		  {
			  return toolItems;
		  }
		  if(id == 9)
		  {
			  return decorItems;
		  }
		  if(id == 10)
		  {
			  return modItems;
		  }else{
			  ModLoader.getLogger().fine((new StringBuilder("GUI id: " + id + " not defined in TAPI")).toString());
			  throw new IllegalArgumentException("GUI id: " + id + " not defined in TAPI");
		  }
	}

	/**
	 * This function gets a list of blocks to be put to ceratin GUI. Should not be used
	 * outside default shopkeeper GUI's
	 * @param id				Id of GUI in which item is placed in.
	 * @return					Returns list of blocks.
	 * @throws					IllegalArgumentException if the GUI id is not defined.
	 */
	
	public static List getBlocks(int id)
	{
		if(!hasInit)
		{
			init();
		}
		if(id == 1)
		  {
			  return dirtBlocks;
		  }
		  if(id == 2)
		  {
			  return foodBlocks;
		  }
		  if(id == 3)
		  {
			  return fenceBlocks;
		  }
		  if(id == 4)
		  {
			  return specialBlocks;
		  }
		  if(id == 5)
		  {
			  return techBlocks;
		  }
		  if(id == 6)
		  {
			  return potionBlocks;
		  }
		  if(id == 7)
		  {
			  return plantBlocks;
		  }
		  if(id == 8)
		  {
			  return toolBlocks;
		  }
		  if(id == 9)
		  {
			  return decorBlocks;
		  }
		  if(id == 10)
		  {
			  return modBlocks;
		  }else{
			  ModLoader.getLogger().fine((new StringBuilder("GUI id: " + id + " not defined in TAPI")).toString());
			  throw new IllegalArgumentException("GUI id: " + id + " not defined in TAPI");
		  }
	}
	
	/**
	 * This function registers custom block to any of the shopkeeper GUI's
	 * @param item				Block you want to add.
	 * @param id				Id of GUI in which item should be placed in.
	 * @param p					Price you want to be assigned for the block.
	 */
	
	protected static void registerBlock(Block block, int id, int p)
	{
		if(!hasInit)
		{
			init();
		}
		registerBlock(block, 0, id, p);
	}
	
	/**
	 * This function registers custom block to any of the shopkeeper GUI's
	 * @param item				Item you want to add.
	 * @param i 				Damage value of the item you want to register.
	 * @param id				Id of GUI in which item should be register.
	 * @param p					Price you want to be assigned for the block.
	 * @throws					IllegalArgumentException if the GUI id is not defined.
	 */

	protected static void registerBlock(Block block, int i, int id, int p)
	{
		if(!hasInit)
		{
			init();
		}
		if(id == 1)
		{
			dirtBlocks.add(new ItemStack(block, 1, i));
		}
		if(id == 2)
		{
			foodBlocks.add(new ItemStack(block, 1, i));
		}
		if(id == 3)
		{
			fenceBlocks.add(new ItemStack(block, 1, i));
		}
		if(id == 4)
		{
			specialBlocks.add(new ItemStack(block, 1, i));
		}
		if(id == 5)
		{
			techBlocks.add(new ItemStack(block, 1, i));
		}
		if(id == 6)
		{
			potionBlocks.add(new ItemStack(block, 1, i));
		}
		if(id == 7)
		{
			plantBlocks.add(new ItemStack(block, 1, i));
		}
		if(id == 8)
		{
			toolBlocks.add(new ItemStack(block, 1, i));
		}
		if(id == 9)
		{
			decorBlocks.add(new ItemStack(block, 1, i));
		}if(id < 1 || id > 9)
		{
			ModLoader.getLogger().fine((new StringBuilder("GUI id: " + id + " not defined in TAPI")).toString());
			 throw new IllegalArgumentException("GUI id: " + id + " not defined in TAPI");
		}
		
		modBlocks.add(new ItemStack(block, 1, i));
		
		setPrice(block, i, p);
		
	}
	
	/**
	 * This function registers custom item to any of the shopkeeper GUI's
	 * @param item				Item you want to add.
	 * @param id				Id of GUI in which item should be placed in.
	 * @param p					Price you want to be assigned for the item.
	 */
	
	protected static void registerItem(Item item, int id, int p)
	{
		if(!hasInit)
		{
			init();
		}
		registerItem(item, 0, id, p);
	}
	
	/**
	 * This function registers custom item to any of the shopkeeper GUI's
	 * @param item				Item you want to add.
	 * @param i 				Damage value of the item you want to register.
	 * @param id				Id of GUI in which item should be register.
	 * @param p					Price you want to be assigned for the item.
	 * @throws					IllegalArgumentException if the GUI id is not defined.
	 */

	protected static void registerItem(Item item, int i, int id, int p)
	{
		if(!hasInit)
		{
			init();
		}
		
		if(id == 1)
		{
			dirtItems.add(new ItemStack(item, 1, i));
		}
		if(id == 2)
		{
			foodItems.add(new ItemStack(item, 1, i));
		}
		if(id == 3)
		{
			fenceItems.add(new ItemStack(item, 1, i));
		}
		if(id == 4)
		{
			specialItems.add(new ItemStack(item, 1, i));
		}
		if(id == 5)
		{
			techItems.add(new ItemStack(item, 1, i));
		}
		if(id == 6)
		{
			potionItems.add(new ItemStack(item, 1, i));
		}
		if(id == 7)
		{
			plantItems.add(new ItemStack(item, 1, i));
		}
		if(id == 8)
		{
			toolItems.add(new ItemStack(item, 1, i));
		}
		if(id == 9)
		{
			decorItems.add(new ItemStack(item, 1, i));
		}if(id < 1 || id > 9)
		{
			  ModLoader.getLogger().fine((new StringBuilder("GUI id: " + id + " not defined in TAPI")).toString());
			  throw new IllegalArgumentException("GUI id: " + id + " not defined in TAPI");
		}
		
		modItems.add(new ItemStack(item, 1, i));
		
		setPrice(item, i, p);
	}
	
	/**
	 * This sets price for an item(if you are using registerItem you don't
	 * need to use this call)
	 * @param item				Item you want to set price for.
	 * @param damage			Damage value of item(if you don't use damage values at your items use 0).
	 * @param p 				Price of the item.
	 */
	
	protected static final void setPrice(Item item, int damage, int p)
	{
		if(!hasInit)
		{
			init();
		}
		priceMap.put(new DamageKey(item.shiftedIndex, damage), Integer.valueOf(p));
		
		if(damage != 0)
		{
			System.out.println((new StringBuilder()).append("Registering ").append(item.getItemName()).append(" with ID ").append(item.shiftedIndex).append(", damage ").append(damage).append(" and price ").append(p).append(" into TAPI price map.").toString());
		}else{
			System.out.println((new StringBuilder()).append("Registering ").append(item.getItemName()).append(" with ID ").append(item.shiftedIndex).append(" and price ").append(p).append(" into TAPI price map.").toString());
		}

	}
	
	/**
	 * This sets price for a block(if you are using registerBlock you don't
	 * need to use this call)
	 * @param block				Block you want to set price for.
	 * @param damage			Damage value of block(if you don't use damage values at your blocks use 0).
	 * @param p 				Price of the block.
	 */
	
	protected static final void setPrice(Block block, int damage, int p)
	{
		if(!hasInit)
		{
			init();
		}
		priceMap.put(new DamageKey(block.blockID, damage), Integer.valueOf(p));
		
		if(damage != 0)
		{
			System.out.println((new StringBuilder()).append("Registering ").append(block.getBlockName()).append(" with ID ").append(block.blockID).append(", damage ").append(damage).append(" and price ").append(p).append(" into TAPI price map.").toString());
		}else{
			System.out.println((new StringBuilder()).append("Registering ").append(block.getBlockName()).append(" with ID ").append(block.blockID).append(" and price ").append(p).append(" into TAPI price map.").toString());
		}

	}
	
	/**
	 * This function returns price of certain item in itemstack
	 * @param itemstack				ItemStack
	 * @return						Item price.
	 */

	public static int getPrice(ItemStack itemstack)
    {
		
		if(!hasInit)
		{
			init();
		}
		
    	Integer i = priceMap.get(new DamageKey(itemstack.itemID, itemstack.getItemDamage()));
    	if(i == null){
    		return priceLib(itemstack);
    	}
    	return i;
    }
	
	/**
	 * This function is mainly a library which defines prices of vanilla
	 * minecraft items and blocks
	 * @param itemstack				ItemStack
	 * @return						Item price.
	 */
	
    protected static int priceLib(ItemStack itemstack)
    {
        String s = itemstack.getItem().getItemNameIS(itemstack);
        if(s.equals("tile.stone"))
        {
            return 1;
        }
        if(s.equals("tile.grass"))
        {
            return 1;
        }
        if(s.equals("tile.dirt"))
        {
            return 1;
        }
        if(s.equals("tile.stonebrick"))
        {
            return 1;
        }
        if(s.equals("tile.wood"))
        {
            return 1;
        }
        if(s.equals("tile.sapling"))
        {
            return 2;
        }
        if(s.equals("tile.bedrock"))
        {
            return 0;
        }
        if(s.equals("tile.water"))
        {
            return 0;
        }
        if(s.equals("tile.water"))
        {
            return 0;
        }
        if(s.equals("tile.lava"))
        {
            return 0;
        }
        if(s.equals("tile.lava"))
        {
            return 0;
        }
        if(s.equals("tile.sand"))
        {
            return 1;
        }
        if(s.equals("tile.gravel"))
        {
            return 1;
        }
        if(s.equals("tile.oreGold"))
        {
            return 250;
        }
        if(s.equals("tile.oreIron"))
        {
            return 50;
        }
        if(s.equals("tile.oreCoal"))
        {
            return 0;
        }
        if(s.equals("tile.log"))
        {
            return 4;
        }
        if(s.equals("tile.leaves"))
        {
            return 1;
        }
        if(s.equals("tile.sponge"))
        {
            return 0;
        }
        if(s.equals("tile.glass"))
        {
            return 3;
        }
        if(s.equals("tile.oreLapis"))
        {
            return 0;
        }
        if(s.equals("tile.blockLapis"))
        {
            return 180;
        }
        if(s.equals("tile.dispenser"))
        {
            return 40;
        }
        if(s.equals("tile.sandStone"))
        {
            return 2;
        }
        if(s.equals("tile.musicBlock"))
        {
            return 10;
        }
        if(s.equals("tile.bed"))
        {
            return 0;
        }
        if(s.equals("tile.goldenRail"))
        {
            return 70;
        }
        if(s.equals("tile.detectorRail"))
        {
            return 15;
        }
        if(s.equals("tile.pistonStickyBase"))
        {
            return 130;
        }
        if(s.equals("tile.web"))
        {
            return 10;
        }
        if(s.equals("tile.tallgrass.shrub"))
        {
            return 2;
        }
        if(s.equals("tile.tallgrass.grass"))
        {
            return 3;
        }
        if(s.equals("tile.tallgrass.fern"))
        {
            return 2;
        }
        if(s.equals("tile.tallgrass"))
        {
            return 3;
        }
        if(s.equals("tile.deadbush"))
        {
            return 2;
        }
        if(s.equals("tile.pistonBase"))
        {
            return 113;
        }
        if(s.equals("tile.cloth.white"))
        {
            return 5;
        }
        if(s.equals("tile.cloth.orange"))
        {
            return 5;
        }
        if(s.equals("tile.cloth.magenta"))
        {
            return 5;
        }
        if(s.equals("tile.cloth.lightBlue"))
        {
            return 5;
        }
        if(s.equals("tile.cloth.yellow"))
        {
            return 5;
        }
        if(s.equals("tile.cloth.lime"))
        {
            return 5;
        }
        if(s.equals("tile.cloth.pink"))
        {
            return 5;
        }
        if(s.equals("tile.cloth.gray"))
        {
            return 5;
        }
        if(s.equals("tile.cloth.silver"))
        {
            return 5;
        }
        if(s.equals("tile.cloth.cyan"))
        {
            return 5;
        }
        if(s.equals("tile.cloth.purple"))
        {
            return 5;
        }
        if(s.equals("tile.cloth.blue"))
        {
            return 20;
        }
        if(s.equals("tile.cloth.brown"))
        {
            return 5;
        }
        if(s.equals("tile.cloth.green"))
        {
            return 5;
        }
        if(s.equals("tile.cloth.red"))
        {
            return 5;
        }
        if(s.equals("tile.cloth.black"))
        {
            return 5;
        }
        if(s.equals("tile.flower"))
        {
            return 2;
        }
        if(s.equals("tile.rose"))
        {
            return 2;
        }
        if(s.equals("tile.mushroom"))
        {
            return 3;
        }
        if(s.equals("tile.mushroom"))
        {
            return 3;
        }
        if(s.equals("tile.blockGold"))
        {
            return 1350;
        }
        if(s.equals("tile.blockIron"))
        {
            return 450;
        }
        if(s.equals("tile.stoneSlab"))
        {
            return 0;
        }
        if(s.equals("tile.stoneSlab.stone"))
        {
            return 1;
        }
        if(s.equals("tile.stoneSlab.sand"))
        {
            return 1;
        }
        if(s.equals("tile.stoneSlab.wood"))
        {
            return 1;
        }
        if(s.equals("tile.stoneSlab.cobble"))
        {
            return 1;
        }
        if(s.equals("tile.stoneSlab.brick"))
        {
            return 2;
        }
        if(s.equals("tile.stoneSlab.smoothStoneBrick"))
        {
            return 2;
        }
        if(s.equals("tile.brick"))
        {
            return 12;
        }
        if(s.equals("tile.tnt"))
        {
            return 154;
        }
        if(s.equals("tile.bookshelf"))
        {
            return 51;
        }
        if(s.equals("tile.stoneMoss"))
        {
            return 14;
        }
        if(s.equals("tile.obsidian"))
        {
            return 25;
        }
        if(s.equals("tile.torch"))
        {
            return 1;
        }
        if(s.equals("tile.fire"))
        {
            return 0;
        }
        if(s.equals("tile.mobSpawner"))
        {
            return 0;
        }
        if(s.equals("tile.stairsWood"))
        {
            return 2;
        }
        if(s.equals("tile.chest"))
        {
            return 4;
        }
        if(s.equals("tile.redstoneDust"))
        {
            return 0;
        }
        if(s.equals("tile.oreDiamond"))
        {
            return 0;
        }
        if(s.equals("tile.blockDiamond"))
        {
            return 8100;
        }
        if(s.equals("tile.workbench"))
        {
            return 2;
        }
        if(s.equals("tile.crops"))
        {
            return 0;
        }
        if(s.equals("tile.farmland"))
        {
            return 0;
        }
        if(s.equals("tile.furnace"))
        {
            return 8;
        }
        if(s.equals("tile.furnace"))
        {
            return 8;
        }
        if(s.equals("tile.sign"))
        {
            return 0;
        }
        if(s.equals("tile.doorWood"))
        {
            return 0;
        }
        if(s.equals("tile.ladder"))
        {
            return 1;
        }
        if(s.equals("tile.rail"))
        {
            return 30;
        }
        if(s.equals("tile.stairsStone"))
        {
            return 6;
        }
        if(s.equals("tile.sign"))
        {
            return 0;
        }
        if(s.equals("tile.lever"))
        {
            return 1;
        }
        if(s.equals("tile.pressurePlate"))
        {
            return 3;
        }
        if(s.equals("tile.doorIron"))
        {
            return 0;
        }
        if(s.equals("tile.pressurePlate"))
        {
            return 3;
        }
        if(s.equals("tile.oreRedstone"))
        {
            return 0;
        }
        if(s.equals("tile.oreRedstone"))
        {
            return 0;
        }
        if(s.equals("tile.notGate"))
        {
            return 0;
        }
        if(s.equals("tile.notGate"))
        {
            return 0;
        }
        if(s.equals("tile.button"))
        {
            return 5;
        }
        if(s.equals("tile.snow"))
        {
            return 4;
        }
        if(s.equals("tile.ice"))
        {
            return 2;
        }
        if(s.equals("tile.snow"))
        {
            return 4;
        }
        if(s.equals("tile.cactus"))
        {
            return 2;
        }
        if(s.equals("tile.clay"))
        {
            return 4;
        }
        if(s.equals("tile.reeds"))
        {
            return 5;
        }
        if(s.equals("tile.jukebox"))
        {
            return 908;
        }
        if(s.equals("tile.fence"))
        {
            return 1;
        }
        if(s.equals("tile.pumpkin"))
        {
            return 30;
        }
        if(s.equals("tile.hellrock"))
        {
            return 1;
        }
        if(s.equals("tile.hellsand"))
        {
            return 1;
        }
        if(s.equals("tile.lightgem"))
        {
            return 12;
        }
        if(s.equals("tile.portal"))
        {
            return 0;
        }
        if(s.equals("tile.litpumpkin"))
        {
            return 31;
        }
        if(s.equals("tile.cake"))
        {
            return 50;
        }
        if(s.equals("tile.diode"))
        {
            return 0;
        }
        if(s.equals("tile.diode"))
        {
            return 0;
        }
        if(s.equals("tile.lockedchest"))
        {
            return 0;
        }
        if(s.equals("tile.trapdoor"))
        {
            return 6;
        }
        if(s.equals("tile.stonebricksmooth"))
        {
            return 5;
        }
        if(s.equals("tile.mushroom"))
        {
            return 3;
        }
        if(s.equals("tile.fenceIron"))
        {
            return 5;
        }
        if(s.equals("tile.thinGlass"))
        {
            return 1;
        }
        if(s.equals("tile.melon"))
        {
            return 18;
        }
        if(s.equals("tile.pumpkinStem"))
        {
            return 0;
        }
        if(s.equals("tile.pumpkinStem"))
        {
            return 0;
        }
        if(s.equals("tile.vine"))
        {
            return 10;
        }
        if(s.equals("tile.fenceGate"))
        {
            return 1;
        }
        if(s.equals("tile.stairsBrick"))
        {
            return 4;
        }
        if(s.equals("tile.stairsStoneBrickSmooth"))
        {
            return 10;
        }
        if(s.equals("tile.mycel"))
        {
            return 0;
        }
        if(s.equals("tile.waterlily"))
        {
            return 2;
        }
        if(s.equals("tile.netherBrick"))
        {
            return 4;
        }
        if(s.equals("tile.netherFence"))
        {
            return 8;
        }
        if(s.equals("tile.stairsNetherBrick"))
        {
            return 8;
        }
        if(s.equals("tile.netherStalk"))
        {
            return 20;
        }
        if(s.equals("tile.enchantmentTable"))
        {
            return 1915;
        }
        if(s.equals("tile.brewingStand"))
        {
            return 0;
        }
        if(s.equals("tile.cauldron"))
        {
            return 350;
        }
        if(s.equals("tile.endPortalFrame"))
        {
            return 10;
        }
        if(s.equals("tile.whiteStone"))
        {
            return 10;
        }
        if(s.equals("tile.dragonEgg"))
        {
            return 0;
        }
        if(s.equals("item.shovelIron"))
        {
            return 52;
        }
        if(s.equals("item.pickaxeIron"))
        {
            return 152;
        }
        if(s.equals("item.hatchetIron"))
        {
            return 152;
        }
        if(s.equals("item.flintAndSteel"))
        {
            return 53;
        }
        if(s.equals("item.apple"))
        {
            return 30;
        }
        if(s.equals("item.bow"))
        {
            return 16;
        }
        if(s.equals("item.arrow"))
        {
            return 7;
        }
        if(s.equals("item.coal"))
        {
            return 2;
        }
        if(s.equals("item.charcoal"))
        {
            return 2;
        }
        if(s.equals("item.emerald"))
        {
            return 900;
        }
        if(s.equals("item.ingotIron"))
        {
            return 50;
        }
        if(s.equals("item.ingotGold"))
        {
            return 150;
        }
        if(s.equals("item.swordIron"))
        {
            return 101;
        }
        if(s.equals("item.swordWood"))
        {
            return 3;
        }
        if(s.equals("item.shovelWood"))
        {
            return 3;
        }
        if(s.equals("item.pickaxeWood"))
        {
            return 5;
        }
        if(s.equals("item.hatchetWood"))
        {
            return 4;
        }
        if(s.equals("item.swordStone"))
        {
            return 4;
        }
        if(s.equals("item.shovelStone"))
        {
            return 4;
        }
        if(s.equals("item.pickaxeStone"))
        {
            return 6;
        }
        if(s.equals("item.hatchetStone"))
        {
            return 5;
        }
        if(s.equals("item.swordDiamond"))
        {
            return 1801;
        }
        if(s.equals("item.shovelDiamond"))
        {
            return 902;
        }
        if(s.equals("item.pickaxeDiamond"))
        {
            return 2702;
        }
        if(s.equals("item.hatchetDiamond"))
        {
            return 2702;
        }
        if(s.equals("item.stick"))
        {
            return 1;
        }
        if(s.equals("item.bowl"))
        {
            return 2;
        }
        if(s.equals("item.mushroomStew"))
        {
            return 6;
        }
        if(s.equals("item.swordGold"))
        {
            return 301;
        }
        if(s.equals("item.shovelGold"))
        {
            return 152;
        }
        if(s.equals("item.pickaxeGold"))
        {
            return 452;
        }
        if(s.equals("item.hatchetGold"))
        {
            return 452;
        }
        if(s.equals("item.string"))
        {
            return 8;
        }
        if(s.equals("item.feather"))
        {
            return 4;
        }
        if(s.equals("item.sulphur"))
        {
            return 30;
        }
        if(s.equals("item.hoeWood"))
        {
            return 2;
        }
        if(s.equals("item.hoeStone"))
        {
            return 3;
        }
        if(s.equals("item.hoeIron"))
        {
            return 102;
        }
        if(s.equals("item.hoeDiamond"))
        {
            return 1802;
        }
        if(s.equals("item.hoeGold"))
        {
            return 302;
        }
        if(s.equals("item.seeds"))
        {
            return 20;
        }
        if(s.equals("item.wheat"))
        {
            return 16;
        }
        if(s.equals("item.bread"))
        {
            return 13;
        }
        if(s.equals("item.helmetCloth"))
        {
            return 70;
        }
        if(s.equals("item.chestplateCloth"))
        {
            return 156;
        }
        if(s.equals("item.leggingsCloth"))
        {
            return 130;
        }
        if(s.equals("item.bootsCloth"))
        {
            return 80;
        }
        if(s.equals("item.helmetChain"))
        {
            return 130;
        }
        if(s.equals("item.chestplateChain"))
        {
            return 230;
        }
        if(s.equals("item.leggingsChain"))
        {
            return 170;
        }
        if(s.equals("item.bootsChain"))
        {
            return 110;
        }
        if(s.equals("item.helmetIron"))
        {
            return 250;
        }
        if(s.equals("item.chestplateIron"))
        {
            return 400;
        }
        if(s.equals("item.leggingsIron"))
        {
            return 350;
        }
        if(s.equals("item.bootsIron"))
        {
            return 102;
        }
        if(s.equals("item.helmetDiamond"))
        {
            return 4500;
        }
        if(s.equals("item.chestplateDiamond"))
        {
            return 7300;
        }
        if(s.equals("item.leggingsDiamond"))
        {
            return 6300;
        }
        if(s.equals("item.bootsDiamond"))
        {
            return 3600;
        }
        if(s.equals("item.helmetGold"))
        {
            return 750;
        }
        if(s.equals("item.chestplateGold"))
        {
            return 1200;
        }
        if(s.equals("item.leggingsGold"))
        {
            return 1050;
        }
        if(s.equals("item.bootsGold"))
        {
            return 600;
        }
        if(s.equals("item.flint"))
        {
            return 3;
        }
        if(s.equals("item.porkchopRaw"))
        {
            return 12;
        }
        if(s.equals("item.porkchopCooked"))
        {
            return 15;
        }
        if(s.equals("item.painting"))
        {
            return 15;
        }
        if(s.equals("item.appleGold"))
        {
            return 10830;
        }
        if(s.equals("item.sign"))
        {
            return 5;
        }
        if(s.equals("item.doorWood"))
        {
            return 5;
        }
        if(s.equals("item.bucket"))
        {
            return 110;
        }
        if(s.equals("item.bucketWater"))
        {
            return 120;
        }
        if(s.equals("item.bucketLava"))
        {
            return 170;
        }
        if(s.equals("item.minecart"))
        {
            return 220;
        }
        if(s.equals("item.saddle"))
        {
            return 250;
        }
        if(s.equals("item.doorIron"))
        {
            return 300;
        }
        if(s.equals("item.redstone"))
        {
            return 7;
        }
        if(s.equals("item.snowball"))
        {
            return 3;
        }
        if(s.equals("item.boat"))
        {
            return 5;
        }
        if(s.equals("item.leather"))
        {
            return 15;
        }
        if(s.equals("item.milk"))
        {
            return 130;
        }
        if(s.equals("item.brick"))
        {
            return 3;
        }
        if(s.equals("item.clay"))
        {
            return 3;
        }
        if(s.equals("item.reeds"))
        {
            return 5;
        }
        if(s.equals("item.paper"))
        {
            return 6;
        }
        if(s.equals("item.book"))
        {
            return 15;
        }
        if(s.equals("item.slimeball"))
        {
            return 17;
        }
        if(s.equals("item.minecartChest"))
        {
            return 230;
        }
        if(s.equals("item.minecartFurnace"))
        {
            return 220;
        }
        if(s.equals("item.egg"))
        {
            return 1;
        }
        if(s.equals("item.compass"))
        {
            return 207;
        }
        if(s.equals("item.fishingRod"))
        {
            return 13;
        }
        if(s.equals("item.clock"))
        {
            return 407;
        }
        if(s.equals("item.yellowDust"))
        {
            return 1;
        }
        if(s.equals("item.fishRaw"))
        {
            return 5;
        }
        if(s.equals("item.fishCooked"))
        {
            return 7;
        }
        if(s.equals("item.dyePowder.black"))
        {
            return 10;
        }
        if(s.equals("item.dyePowder.red"))
        {
            return 10;
        }
        if(s.equals("item.dyePowder.green"))
        {
            return 10;
        }
        if(s.equals("item.dyePowder.brown"))
        {
            return 10;
        }
        if(s.equals("item.dyePowder.blue"))
        {
            return 20;
        }
        if(s.equals("item.dyePowder.purple"))
        {
            return 10;
        }
        if(s.equals("item.dyePowder.cyan"))
        {
            return 10;
        }
        if(s.equals("item.dyePowder.silver"))
        {
            return 10;
        }
        if(s.equals("item.dyePowder.gray"))
        {
            return 10;
        }
        if(s.equals("item.dyePowder.pink"))
        {
            return 10;
        }
        if(s.equals("item.dyePowder.lime"))
        {
            return 10;
        }
        if(s.equals("item.dyePowder.yellow"))
        {
            return 10;
        }
        if(s.equals("item.dyePowder.lightBlue"))
        {
            return 10;
        }
        if(s.equals("item.dyePowder.magenta"))
        {
            return 10;
        }
        if(s.equals("item.dyePowder.orange"))
        {
            return 10;
        }
        if(s.equals("item.dyePowder.white"))
        {
            return 2;
        }
        if(s.equals("item.bone"))
        {
            return 6;
        }
        if(s.equals("item.sugar"))
        {
            return 6;
        }
        if(s.equals("item.cake"))
        {
            return 150;
        }
        if(s.equals("item.bed"))
        {
            return 33;
        }
        if(s.equals("item.diode"))
        {
            return 29;
        }
        if(s.equals("item.cookie"))
        {
            return 4;
        }
        if(s.equals("item.map"))
        {
            return 260;
        }
        if(s.equals("item.shears"))
        {
            return 120;
        }
        if(s.equals("item.melon"))
        {
            return 6;
        }
        if(s.equals("item.seeds_pumpkin"))
        {
            return 30;
        }
        if(s.equals("item.seeds_melon"))
        {
            return 30;
        }
        if(s.equals("item.beefRaw"))
        {
            return 4;
        }
        if(s.equals("item.beefCooked"))
        {
            return 6;
        }
        if(s.equals("item.chickenRaw"))
        {
            return 10;
        }
        if(s.equals("item.chickenCooked"))
        {
            return 12;
        }
        if(s.equals("item.rottenFlesh"))
        {
            return 4;
        }
        if(s.equals("item.enderPearl"))
        {
            return 13;
        }
        if(s.equals("item.blazeRod"))
        {
            return 10;
        }
        if(s.equals("item.ghastTear"))
        {
            return 10;
        }
        if(s.equals("item.goldNugget"))
        {
            return 10;
        }
        if(s.equals("item.netherStalkSeeds"))
        {
            return 10;
        }
        if(s.equals("item.potion") && itemstack.getItemDamage() == 0)
        {
            return 10;
        }
        if(s.equals("item.potion") && itemstack.getItemDamage() == 1)
        {
            return 40;
        }
        if(s.equals("item.potion") && itemstack.getItemDamage() == 2)
        {
            return 40;
        }
        if(s.equals("item.potion") && itemstack.getItemDamage() == 3)
        {
            return 40;
        }
        if(s.equals("item.potion") && itemstack.getItemDamage() == 5)
        {
            return 40;
        }
        if(s.equals("item.potion") && itemstack.getItemDamage() == 9)
        {
            return 70;
        }
        if(s.equals("item.potion") && itemstack.getItemDamage() == 33)
        {
            return 100;
        }
        if(s.equals("item.potion") && itemstack.getItemDamage() == 34)
        {
            return 100;
        }
        if(s.equals("item.potion") && itemstack.getItemDamage() == 37)
        {
            return 100;
        }
        if(s.equals("item.potion") && itemstack.getItemDamage() == 41)
        {
            return 200;
        }
        if(s.equals("item.potion") && itemstack.getItemDamage() == 57)
        {
            return 200;
        }
        if(s.equals("item.potion") && itemstack.getItemDamage() == 65)
        {
            return 200;
        }
        if(s.equals("item.potion") && itemstack.getItemDamage() == 66)
        {
            return 200;
        }
        if(s.equals("item.potion") && itemstack.getItemDamage() == 67)
        {
            return 300;
        }
        if(s.equals("item.potion") && itemstack.getItemDamage() == 73)
        {
            return 300;
        }
        if(s.equals("item.glassBottle"))
        {
            return 3;
        }
        if(s.equals("item.spiderEye"))
        {
            return 10;
        }
        if(s.equals("item.fermentedSpiderEye"))
        {
            return 10;
        }
        if(s.equals("item.blazePowder"))
        {
            return 13;
        }
        if(s.equals("item.magmaCream"))
        {
            return 30;
        }
        if(s.equals("item.brewingStand"))
        {
            return 100;
        }
        if(s.equals("item.cauldron"))
        {
            return 100;
        }
        if(s.equals("item.eyeOfEnder"))
        {
            return 50;
        }
        if(s.equals("item.speckledMelon"))
        {
            return 10;
        }
        if(s.equals("item.record"))
        {
            return 720;
        }
        if(s.equals("item.coin.gold"))
        {
        	return 1000;
        }
        if(s.equals("item.coin.silver"))
        {
        	return 100;
        }
        if(s.equals("item.coin.bronze"))
        {
        	return 10;
        }
        if(s.equals("tile.bs"))
        {
        	return 1;
        }
        if(s.equals("tile.deciduous"))
        {
            return 1;
        }
        if(s.equals("tile.coniferous"))
        {
            return 1;
        }
        if(s.equals("tile.tropical"))
        {
            return 1;
        }
        if(s.equals("tile.savannah"))
        {
            return 1;
        }
        if(s.equals("tile.conipeat"))
        {
            return 1;
        }
        if(s.equals("tile.decipeat"))
        {
            return 1;
        }
        if(s.equals("tile.mesa"))
        {
        	return 1;
        }
        if(s.equals("tile.laterite"))
        {
        	return 1;
        }
        if(s.equals("tile.gleypeat"))
        {
        	return 1;
        }
        if(s.equals("tile.rf"))
        {
        	return 1;
        }
        if(s.equals("tile.sg"))
        {
        	return 3;
        }
        if(s.equals("tile.dg"))
        {
        	return 3;
        }
        if(s.equals("tile.cg"))
        {
        	return 3;
        }
               
        return !s.equals("item.rand") ? 0 : 1;
    }

    /**
     * This function displays value of certain itemstack
     * @param itemstack				ItemStack
     * @param i						0 - price for 1 of that stack, 1 - price for full possible stack size
     */
    
	public static void displayValues(ItemStack itemstack, int i)
    {
		String s = itemstack.getItem().getItemNameIS(itemstack);
		if(s.startsWith("tile."))
		{
	    	switch(i){
	    	case 0:
	    		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Single Block Value:$ " + getPrice(itemstack) * itemstack.stackSize);
	    		break;
	    	case 1:
	    		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Max Stack Value:$ " + getPrice(itemstack) * itemstack.getMaxStackSize());
	    	}
		}
		if(s.startsWith("item."))
		{
			switch(i){
	    	case 0:
	    		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Single Item Value:$ " + getPrice(itemstack) * itemstack.stackSize);
	    		break;
	    	case 1:
	    		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Max Stack Value:$ " + getPrice(itemstack) * itemstack.getMaxStackSize());
	    	}
		}
    }

}
