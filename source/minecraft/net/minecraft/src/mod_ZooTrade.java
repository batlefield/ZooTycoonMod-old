package net.minecraft.src;

import java.io.File;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.src.BAPI.BAPI;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.MinecraftForge;
import net.minecraft.src.forge.NetworkMod;
import net.minecraft.src.forge.Property;
import net.minecraft.src.zoo.trading.BlockSafe;
import net.minecraft.src.zoo.trading.BlockShop;
import net.minecraft.src.zoo.trading.GUIHandlerTrade;
import net.minecraft.src.zoo.trading.TileEntitySafe;
import net.minecraft.src.zoo.trading.TileEntitySafeRender;
import net.minecraft.src.zoo.trading.TileEntityShop;
import net.minecraft.src.zoo.trading.Trade;
import net.minecraft.src.zoo.trading.TradingBlocksCreative;
import net.minecraft.src.zoo.trading.ZooEntityShopKeeper;
import net.minecraft.src.zoo.trading.ZooItemCoin;
import net.minecraft.src.zoo.trading.ZooRenderShopKeeper;
import net.minecraft.src.zoo.trading.ZooTradeNBT;

public class mod_ZooTrade extends NetworkMod
{

	private static Minecraft minecraft = ModLoader.getMinecraftInstance();
	private static mod_ZooTrade instance;
	public static int safeRender;

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

	public void load()
	{
		instance = this;

		safeRender = ModLoader.getUniqueBlockModelID(this, true);
		MinecraftForge.setGuiHandler(this, new GUIHandlerTrade());
		BAPI.registerNBT(new ZooTradeNBT());
		BAPI.registerCreativeHandler(new TradingBlocksCreative());
		loadmod();

		ModLoader.setInGameHook(this, true, false);
		ModLoader.setInGUIHook(this, true, true);

	}

	public void renderInvBlock(RenderBlocks rb, Block block, int i, int j) {
		if(j == safeRender)
		{
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntitySafe(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
	}
	
	public boolean onTickInGame(float f, Minecraft minecraft1)
	{
		int k = 2;
		int l = 2;
		byte byte0 = 10;
		boolean flag = false;

		int money = Trade.getMoney();
		int color;
		
		if (money < 0)
		{
			color = 0xFF0000;
		} else if (money >= 100000)
		{
			color = 0x00FF00;
		} else
		{
			color = 0xFFFFFF;
		}
		if(minecraft1.currentScreen == null && !minecraft.theWorld.isRemote)
		{
			minecraft1.fontRenderer.drawStringWithShadow("Money balance: $" + money, k - (flag ? minecraft1.fontRenderer.getStringWidth("Money balance: $" + money) : 0), l, color);
		}
		l += byte0;

		return true;
	}

	public static BaseMod getInstance()
	{
		return instance;
	}

	public void AddRenderer(Map map)
	{
		map.put(ZooEntityShopKeeper.class, new ZooRenderShopKeeper(0.5F));
	}

	public static void loadmod()
	{
		ModLoader.registerTileEntity(TileEntityShop.class, "Shop block");
		ModLoader.registerTileEntity(TileEntitySafe.class, "Safe", new TileEntitySafeRender());

		ModLoader.registerBlock(shopBlock);
		ModLoader.registerBlock(safe);
		
		ModLoader.addName(safe, "Safe");
		ModLoader.addName(shopBlock, "Shop");

		ModLoader.addName(new ItemStack(Coin, 1, 2), "Golden coin");
		ModLoader.addName(new ItemStack(Coin, 1, 1), "Silver coin");
		ModLoader.addName(new ItemStack(Coin, 1, 0), "Bronze coin");

		ModLoader.registerEntityID(ZooEntityShopKeeper.class, "Shop keeper", ModLoader.getUniqueEntityId());

		ModLoader.addRecipe(new ItemStack(shopBlock, 1), new Object[]
		{
				"XXX", "YYY", "XXX", Character.valueOf('X'), Block.planks, Character.valueOf('Y'), Block.thinGlass
		});
		ModLoader.addRecipe(new ItemStack(safe, 1), new Object[]
				{
						"XXX", "Y Y", "XXX", Character.valueOf('X'), Item.ingotIron, Character.valueOf('Y'), Block.blockSteel
				});
	}

	public static Item Coin = (new ZooItemCoin(getItemID("Coin", 2274)).setItemName("sc").setIconIndex(9));
	public static final Block shopBlock = (new BlockShop(getBlockID("Shopkeeper block", 225)).setBlockName("shopkeeperdouble"));
	public static final Block safe = new BlockSafe(getBlockID("Safe", 226)).setBlockName("safe").setHardness(1F);

}
