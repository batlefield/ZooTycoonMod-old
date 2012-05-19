package net.minecraft.src;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.DimensionManager;
import net.minecraft.src.forge.MinecraftForgeClient;
import net.minecraft.src.forge.NetworkMod;
import net.minecraft.src.zoo.api.ZAPI;
import net.minecraft.src.zoo.dimension.WorldProviderZoo;
import net.minecraft.src.zoo.dimension.ZooPortal;
import net.minecraft.src.zoo.dimension.ZooTeleporter;

public class mod_ZooDimension extends NetworkMod{

	public static int delayedTicks;
	public static int timeInPortal;
	public static boolean isInPortal = false;
	
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
        
        ModLoader.setInGameHook(this, true, true);
	}
	
	public mod_ZooDimension()
    {
		if(!DimensionManager.registerDimension(ZooDimension.dimensionId, new WorldProviderZoo(), true))
		{
			throw new IllegalArgumentException("Dimension id " + ZooDimension.dimensionId + " is already occupied by " + DimensionManager.getProvider(ZooDimension.dimensionId).getClass().getSimpleName() + " when adding Zoo dimension.");
		}else{
			System.out.println("Zoo: Dimension registered sucessfully");
		}
        instance = this;
    }

	public boolean clientSideRequired()
	{
		return true;
	}

	public boolean serverSideRequired()
	{
		return false;
	}
	
    public static void initialize()
    {
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
    
    public boolean onTickInGame(float var1, Minecraft var2)
    {
    	EntityPlayer entityplayer = var2.thePlayer;
        if (!var2.theWorld.isRemote)
        {
        	EntityPlayerSP entityplayersp = var2.thePlayer;
    		if(!isInPortal(entityplayersp))
    		{
    			timeInPortal = 0;
    			isInPortal = false;
    			/*delayedTicks++;
    			if(delayedTicks >= 85)
    			{
    				delayedTicks = 0;
    				isInPortal = false;
    			}*/
    			return true;
    		}
            if (isInPortal(entityplayersp))
            {
            	isInPortal = true;
                timeInPortal++;
                if (timeInPortal == 75 && entityplayersp.timeUntilPortal <= 0)
                {
    				timeInPortal = 0;
    				entityplayersp.timeUntilPortal = 10;
    				
    		        if (entityplayersp.dimension != ZooDimension.dimensionId)
    		        {
    		            var2.usePortal(ZooDimension.dimensionId, new ZooTeleporter());
    		        }
    		        else if (entityplayersp.dimension == ZooDimension.dimensionId)
    		        {
    		        	var2.usePortal(0, new ZooTeleporter());
    		        }
                }
                
            }
        }
		if (isInPortal((EntityPlayerSP)entityplayer))
		{
			entityplayer.setInPortal();
			if(entityplayer.timeInPortal >= 0.9F)
			{
				entityplayer.timeInPortal = 0.0F;
			}
		}
		return true;
    }
    
    public static boolean isInPortal(EntityPlayerSP entityplayersp)
    {
        int j = (int)Math.floor(entityplayersp.posX);
        int k = (int)Math.floor(entityplayersp.posY);
        int l = (int)Math.floor(entityplayersp.posZ);
		if(entityplayersp.worldObj.getBlockId(j, k, l) == ZooDimension.portal.blockID || entityplayersp.worldObj.getBlockId(j, k - 1, l) == ZooDimension.portal.blockID)
		{
			return true;
		}
		return false;
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
        config.getOrCreateIntProperty(s, config.CATEGORY_ITEM, i);
        config.save();
        return new Integer(config.getOrCreateIntProperty(s, config.CATEGORY_ITEM, i).value).intValue();
    }
    
    public static int getInteger(String s, int i)
    {
    	config.load();
        config.getOrCreateIntProperty(s, config.CATEGORY_GENERAL, i);
        config.save();
        return new Integer(config.getOrCreateIntProperty(s, config.CATEGORY_GENERAL, i).value).intValue();
    }
    
    
    
    public static mod_ZooDimension instance;
    private static boolean initialized = false;
    private static Minecraft minecraft = ModLoader.getMinecraftInstance();

}
