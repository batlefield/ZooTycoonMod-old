package net.minecraft.src;

import java.io.File;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.src.battlefield.API.BAPI;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.zoo.api.Trade;
import net.minecraft.src.zoo.core.entities.ZooEntityAfricanWDog;
import net.minecraft.src.zoo.core.entities.ZooEntityAnteater;
import net.minecraft.src.zoo.core.entities.ZooEntityBighorn;
import net.minecraft.src.zoo.core.entities.ZooEntityElephant;
import net.minecraft.src.zoo.core.entities.ZooEntityGazelle;
import net.minecraft.src.zoo.core.entities.ZooEntityHippo;
import net.minecraft.src.zoo.core.entities.ZooEntityLion;
import net.minecraft.src.zoo.core.entities.ZooEntityPrimate;
import net.minecraft.src.zoo.core.entities.ZooEntityRhino;
import net.minecraft.src.zoo.core.entities.ZooEntityTiger;
import net.minecraft.src.zoo.core.entities.ZooVisitorFemale;
import net.minecraft.src.zoo.core.entities.ZooVisitorMale;
import net.minecraft.src.zoo.core.render.RenderFemale;
import net.minecraft.src.zoo.core.render.ZooRenderAfricanWDog;
import net.minecraft.src.zoo.core.render.ZooRenderAnteater;
import net.minecraft.src.zoo.core.render.ZooRenderBighorn;
import net.minecraft.src.zoo.core.render.ZooRenderElephant;
import net.minecraft.src.zoo.core.render.ZooRenderGazelle;
import net.minecraft.src.zoo.core.render.ZooRenderHippo;
import net.minecraft.src.zoo.core.render.ZooRenderLion;
import net.minecraft.src.zoo.core.render.ZooRenderPrimate;
import net.minecraft.src.zoo.core.render.ZooRenderRhino;
import net.minecraft.src.zoo.core.render.ZooRenderTiger;
import net.minecraft.src.zoo.trading.BlockShop;
import net.minecraft.src.zoo.trading.ZooEntityShopKeeper;
import net.minecraft.src.zoo.trading.ZooItemCoin;
import net.minecraft.src.zoo.trading.ZooPlayerBaseTrade;
import net.minecraft.src.zoo.trading.ZooRenderShopKeeper;

public class mod_ZooTrade extends BaseMod {
	
	
    public static int money;
    public static boolean debug = false;
    private int ctr;
    private boolean worldLoaded;
    private static Minecraft minecraft = ModLoader.getMinecraftInstance();


	public String getVersion() {
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
		config.getOrCreateIntProperty(s, 2, i);
		config.save();
		return new Integer(config.getOrCreateIntProperty(s, 2, i).value).intValue();
	}
	
	public void load() {
		ctr = 0;
		worldLoaded = false;
		
        PlayerAPI.register("ZooPlayerBaseTrade", ZooPlayerBaseTrade.class);
        Trade.init();
        loadmod();
        
        ModLoader.setInGameHook(this, true, false);
        ModLoader.setInGUIHook(this, true, true);
		
	}
	
    public boolean OnTickInGame(float f, Minecraft minecraft1)
    {        
            ScaledResolution scaledresolution = new ScaledResolution(minecraft1.gameSettings, minecraft1.displayWidth, minecraft1.displayHeight);
            int i = scaledresolution.getScaledWidth();
            int j = scaledresolution.getScaledHeight();
            int k = 2;
            int l = 2;
            byte byte0 = 10;
            boolean flag = false;
            String s;
            
            if(money < 0){
            	s = (new StringBuilder()).append("�4Money balance: $").append(money).toString();
            }else if(money >= 100000){
            	s = (new StringBuilder()).append("�aMoney balance: $").append(money).toString();
        	}else{
            	s = (new StringBuilder()).append("Money balance: $").append(money).toString();
            }
               
            minecraft1.fontRenderer.drawStringWithShadow(s, k - (flag ? minecraft1.fontRenderer.getStringWidth(s) : 0), l, -1);
            l += byte0;
            
            
            return true;
    }
	
    public boolean OnTickInGUI(float f, Minecraft minecraft1, GuiScreen guiscreen)
    {
        if(guiscreen instanceof GuiSelectWorld)
        {
            ctr = 0;
            worldLoaded = false;
        }
        return true;
    }

    public static boolean debug()
    {
        return debug;
    }
    
    public static void debug(int i)
    {
        if(debug)
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
		
    	
		ModLoader.registerBlock(shopkeeperblockdouble, net.minecraft.src.zoo.trading.ZooItemShop.class);

		ModLoader.addName(shopkeeperblockdouble, "Shop keeper block");
		ModLoader.addName(new ItemStack(Coin, 1, 2), "Golden coin");
		ModLoader.addName(new ItemStack(Coin, 1, 1), "Silver coin");
		ModLoader.addName(new ItemStack(Coin, 1, 0), "Bronze coin");
		
		
		ModLoader.registerEntityID(ZooEntityShopKeeper.class, "Shop keeper", ModLoader.getUniqueEntityId());
		
		
		ModLoader.addRecipe(new ItemStack(shopkeeperblockdouble, 1), new Object[] {
			"XXX", "YYY", "XXX", Character.valueOf('X'), Block.planks, Character.valueOf('Y'), Block.thinGlass
		});
    }		
	public static Item Coin = (new ZooItemCoin(getItemID("Coin", 407)).setItemName("sc").setIconIndex(9));
	public static final Block shopkeeperblockdouble = (new BlockShop(getBlockID("Shopkeeper block", 225)).setBlockName("shopkeeperdouble"));



}
