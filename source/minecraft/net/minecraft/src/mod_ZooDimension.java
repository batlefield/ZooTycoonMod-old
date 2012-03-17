package net.minecraft.src;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.MinecraftForgeClient;
import net.minecraft.src.zoo.api.ZAPI;
import net.minecraft.src.zoo.dimension.WorldProviderZoo;

public class mod_ZooDimension extends BaseMod{

	public String getVersion() {
		return new StringBuilder().append("Zoo Tycoon ").append(mod_ZooCore.version).append(" Dimension for Minecraft ").append(mod_ZooCore.mcVersion).append(" by ").append(mod_ZooCore.author).toString();
	}

	public void load() {
        initialize();
        ZAPI.registerBiome(ZooBiomeBase.decidious, true, true, true);
        ZAPI.registerBiome(ZooBiomeBase.savannah, true, true, true);
        ZAPI.registerBiome(ZooBiomeBase.tropic, true, true, true);
        ZAPI.registerBiome(ZooBiomeBase.ocean, false, false, true);
        ZAPI.registerBiome(ZooBiomeBase.mesa, true, false, true);
	}
	
	public mod_ZooDimension()
    {
		DimensionAPI.registerDimension(new WorldProviderZoo());
        instance = this;
    }

    public static void initialize()
    {
    	ZooDimension.init();
        if(initialized)
        	
        {
            return;
        } else
        {
            initialized = true;
            ZooDimension.init();
    		MinecraftForgeClient.preloadTexture("/zoo/dimension/blocks.png");
    		MinecraftForgeClient.preloadTexture("/zoo/dimension/items.png");
            return;
        }
    }
    
    public void modsLoaded() {
        ModLoader.setInGameHook(this, true, false);
        ModLoader.setInGUIHook(this, true, true);
	}
    
    
    static Configuration config = new Configuration(new File(Minecraft.getMinecraftDir(), "Zoo/Dimension/Config.cfg"));
    
	public static int getBlockIdFor(String s, int i)
    {
		config.load();
		config.getOrCreateBlockIdProperty(s, i);
        config.save();
        return new Integer(config.getOrCreateBlockIdProperty(s, i).value).intValue();
    }

    public static int getItemIdFor(String s, int i)
    {
    	config.load();
        config.getOrCreateIntProperty(s, 2, i);
        config.save();
        return new Integer(config.getOrCreateIntProperty(s, 2, i).value).intValue();
    }
    
    public static int getInteger(String s, int i)
    {
    	config.load();
        config.getOrCreateIntProperty(s, 0, i);
        config.save();
        return new Integer(config.getOrCreateIntProperty(s, 0, i).value).intValue();
    }
    
    public static boolean getBoolean(String s, boolean b)
    {
    	config.load();
    	config.getOrCreateBooleanProperty(s, 0, b);
    	config.save();
    	return new Boolean(config.getOrCreateBooleanProperty(s, 0, b).value).booleanValue();
    }
    
    
    public static mod_ZooDimension instance;
    private static boolean initialized = false;
    private static Minecraft minecraft = ModLoader.getMinecraftInstance();
}
