package net.minecraft.src;

import java.io.File;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.src.BAPI.BAPI;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.MinecraftForge;
import net.minecraft.src.forge.NetworkMod;
import net.minecraft.src.forge.Property;
import net.minecraft.src.zoo.api.Trade;
import net.minecraft.src.zoo.trading.BlockShop;
import net.minecraft.src.zoo.trading.GUIHandlerTrade;
import net.minecraft.src.zoo.trading.TileEntityShop;
import net.minecraft.src.zoo.trading.TradingBlocksCreative;
import net.minecraft.src.zoo.trading.ZooEntityShopKeeper;
import net.minecraft.src.zoo.trading.ZooItemCoin;
import net.minecraft.src.zoo.trading.ZooRenderShopKeeper;
import net.minecraft.src.zoo.trading.ZooTradeNBT;

public class mod_ZooTrade extends NetworkMod
{

	public static boolean debug = false;
	private static Minecraft minecraft = ModLoader.getMinecraftInstance();
	private static mod_ZooTrade instance;

	public String getVersion()
	{
		return new StringBuilder().append("Zoo Tycoon ").append(mod_ZooCore.version).append(" Trading for Minecraft ").append(mod_ZooCore.mcVersion).append(" by ").append(mod_ZooCore.author).toString();
	}

	static Configuration config = new Configuration(new File(Minecraft.getMinecraftDir(), "Zoo/Trade/Config.cfg"));

	private static int getBlockID(String s, int i)
	{
		config.load();
		config.getOrCreateBlockIdProperty(s, i);
		config.save();
		return new Integer(config.getOrCreateBlockIdProperty(s, i).value).intValue();
	}

	private static int getItemID(String s, int i)
	{
		config.load();
		config.getOrCreateIntProperty(s, config.CATEGORY_ITEM, i);
		config.save();
		return new Integer(config.getOrCreateIntProperty(s, config.CATEGORY_ITEM, i).value).intValue();
	}
	
	public static double getGeneralDouble(String s, double d)
	{
		Property prop = config.getOrCreateProperty(s, config.CATEGORY_GENERAL, Double.toString(d));
		try{
			System.out.println("try");
			Double.parseDouble(prop.value);
			return new Double(Double.parseDouble(prop.value)).doubleValue();
		}catch(Exception e)
		{
			e.printStackTrace();
			prop.value = Double.toString(d);
			return new Double(Double.parseDouble(prop.value)).doubleValue();
		}
	}

	public void load()
	{
		instance = this;

		MinecraftForge.setGuiHandler(this, new GUIHandlerTrade());
		BAPI.registerNBT(new ZooTradeNBT());
		BAPI.registerCreativeHandler(new TradingBlocksCreative());
		loadmod();

		ModLoader.setInGameHook(this, true, false);
		ModLoader.setInGUIHook(this, true, true);

	}

	public boolean onTickInGame(float f, Minecraft minecraft1)
	{
		ScaledResolution scaledresolution = new ScaledResolution(minecraft1.gameSettings, minecraft1.displayWidth, minecraft1.displayHeight);
		int i = scaledresolution.getScaledWidth();
		int j = scaledresolution.getScaledHeight();
		int k = 2;
		int l = 2;
		byte byte0 = 10;
		boolean flag = false;
		String s;

		int money = Trade.getMoney();
		
		if (money < 0)
		{
			s = (new StringBuilder()).append("§4Money balance: $").append(money).toString();
		} else if (money >= 100000)
		{
			s = (new StringBuilder()).append("§aMoney balance: $").append(money).toString();
		} else
		{
			s = (new StringBuilder()).append("Money balance: $").append(money).toString();
		}

		minecraft1.fontRenderer.drawStringWithShadow(s, k - (flag ? minecraft1.fontRenderer.getStringWidth(s) : 0), l, -1);
		l += byte0;

		return true;
	}

	public static BaseMod getInstance()
	{
		return instance;
	}


	public static boolean debug()
	{
		return debug;
	}

	public static void debug(int i)
	{
		if (debug)
		{
			minecraft.thePlayer.addChatMessage(new String((new StringBuilder()).append("Debug Info: ").append(i)));
		}
	}

	public void AddRenderer(Map map)
	{
		map.put(ZooEntityShopKeeper.class, new ZooRenderShopKeeper(0.5F));
	}

	public static void loadmod()
	{
		ModLoader.registerTileEntity(TileEntityShop.class, "Shop block");

		ModLoader.registerBlock(shopkeeperblockdouble);
		ModLoader.addName(shopkeeperblockdouble, "Shop");

		ModLoader.addName(new ItemStack(Coin, 1, 2), "Golden coin");
		ModLoader.addName(new ItemStack(Coin, 1, 1), "Silver coin");
		ModLoader.addName(new ItemStack(Coin, 1, 0), "Bronze coin");

		ModLoader.registerEntityID(ZooEntityShopKeeper.class, "Shop keeper", ModLoader.getUniqueEntityId());

		ModLoader.addRecipe(new ItemStack(shopkeeperblockdouble, 1), new Object[]
		{
				"XXX", "YYY", "XXX", Character.valueOf('X'), Block.planks, Character.valueOf('Y'), Block.thinGlass
		});
	}

	public static Item Coin = (new ZooItemCoin(getItemID("Coin", 407)).setItemName("sc").setIconIndex(9));
	public static final Block shopkeeperblockdouble = (new BlockShop(getBlockID("Shopkeeper block", 225)).setBlockName("shopkeeperdouble"));

}
