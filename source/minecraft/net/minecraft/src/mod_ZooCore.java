package net.minecraft.src;

import java.io.File;
import java.util.Map;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.src.battlefield.API.BAPI;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.MinecraftForgeClient;
import net.minecraft.src.zoo.api.Fence;
import net.minecraft.src.zoo.core.ZooSettings;
import net.minecraft.src.zoo.core.entities.ZooEntityAfricanWDog;
import net.minecraft.src.zoo.core.entities.ZooEntityAnteater;
import net.minecraft.src.zoo.core.entities.ZooEntityBighorn;
import net.minecraft.src.zoo.core.entities.ZooEntityElephant;
import net.minecraft.src.zoo.core.entities.ZooEntityFennecFox;
import net.minecraft.src.zoo.core.entities.ZooEntityGazelle;
import net.minecraft.src.zoo.core.entities.ZooEntityGiraffe;
import net.minecraft.src.zoo.core.entities.ZooEntityHippo;
import net.minecraft.src.zoo.core.entities.ZooEntityLion;
import net.minecraft.src.zoo.core.entities.ZooEntityPrimate;
import net.minecraft.src.zoo.core.entities.ZooEntityRhino;
import net.minecraft.src.zoo.core.entities.ZooEntityTiger;
import net.minecraft.src.zoo.core.entities.ZooVisitorFemale;
import net.minecraft.src.zoo.core.render.RenderFemale;
import net.minecraft.src.zoo.core.render.ZooRenderAfricanWDog;
import net.minecraft.src.zoo.core.render.ZooRenderAnteater;
import net.minecraft.src.zoo.core.render.ZooRenderBighorn;
import net.minecraft.src.zoo.core.render.ZooRenderElephant;
import net.minecraft.src.zoo.core.render.ZooRenderFennecFox;
import net.minecraft.src.zoo.core.render.ZooRenderGazelle;
import net.minecraft.src.zoo.core.render.ZooRenderGiraffe;
import net.minecraft.src.zoo.core.render.ZooRenderHippo;
import net.minecraft.src.zoo.core.render.ZooRenderLion;
import net.minecraft.src.zoo.core.render.ZooRenderPrimate;
import net.minecraft.src.zoo.core.render.ZooRenderRhino;
import net.minecraft.src.zoo.core.render.ZooRenderTiger;

import org.lwjgl.opengl.GL11;

public class mod_ZooCore extends BaseMod
{
	
	
	public static String version = "Indev 1.10.0";
	public static String mcVersion = "1.1.0";
	public static String author = "Battlefield";
	public static int renderMode;
	public static KeyBinding options = new KeyBinding("Zoo options", 25);
	public static ZooSettings settings = new ZooSettings();
	
	public void load()
	{
		ModLoader.registerKey(this, options, false);
		renderMode = ModLoader.getUniqueBlockModelID(this, true);
        BAPI.init();
        Fence.init();
        initialize();
	}
	
	public mod_ZooCore()
    {
        instance = this;
    }

    public static void initialize()
    {
    	Zoo.init();
        if(initialized)
        	
        {
            return;
        } else
        {
            initialized = true;
            Zoo.init();
    		MinecraftForgeClient.preloadTexture("/zoo/blocks.png");
    		MinecraftForgeClient.preloadTexture("/zoo/items.png");
    		MinecraftForgeClient.preloadTexture("/zoo/paintings.png");
    		MinecraftForgeClient.preloadTexture("/zoo/water.png");
            return;
        }
    }
    
    public void modsLoaded() {
        ModLoader.setInGameHook(this, true, false);
        ModLoader.setInGUIHook(this, true, true);
      }

    public boolean renderWorldBlock(RenderBlocks renderblocks, IBlockAccess iblockaccess, int i, int j, int k, Block block, int l)
    {
        if(l == renderMode)
        {
            GL11.glPushMatrix();
            RenderEngine renderengine = ModLoader.getMinecraftInstance().renderEngine;
            Tessellator tessellator = Tessellator.instance;
            tessellator.draw();
            tessellator.startDrawingQuads();
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, renderengine.getTexture("/zoo/water.png"));
            renderblocks.renderBlockFluids(block, i, j, k);
            tessellator.draw();
            tessellator.startDrawingQuads();
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, renderengine.getTexture("/terrain.png"));
            GL11.glPopMatrix();
            return true;
        } else
        {
            return true;
        }
    }

    public void renderInvBlock(RenderBlocks renderblocks, Block block, int i, int j) {

    }
    
    public void keyboardEvent(KeyBinding var1) {
    	
    	if(var1 == options)
    	{
    		minecraft.displayGuiScreen(new net.minecraft.src.zoo.core.GuiOptions());
    	}
    	
    }

    
   public void addRenderer(Map map)
   {
	       map.put(ZooEntityBighorn.class, new ZooRenderBighorn(0.5F));
	       map.put(ZooEntityGazelle.class, new ZooRenderGazelle(0.5F));
	       map.put(ZooEntityHippo.class, new ZooRenderHippo(0.5F));
	       map.put(ZooEntityPrimate.class, new ZooRenderPrimate(0.5F));
	       map.put(ZooEntityRhino.class, new ZooRenderRhino(0.5F));
	       map.put(ZooEntityTiger.class, new ZooRenderTiger(0.5F));
	       map.put(ZooEntityElephant.class, new ZooRenderElephant(0.5F));
	       map.put(ZooEntityAfricanWDog.class, new ZooRenderAfricanWDog(0.5F));
	       map.put(ZooEntityAnteater.class, new ZooRenderAnteater(0.5F));
	       map.put(ZooVisitorFemale.class, new RenderFemale(0.5F));
	       map.put(ZooEntityLion.class, new ZooRenderLion(0.5F));
	       //map.put(ZooEntityPanther.class, new ZooRenderPanter(0.5F));
	       map.put(ZooEntityFennecFox.class, new ZooRenderFennecFox(0.5F));
	       map.put(ZooEntityGiraffe.class, new ZooRenderGiraffe(0.6F));
	       //map.put(ZooEntityFlamingo.class, new ZooRenderFlamingo(0.5F));
	       //map.put(ZooEntityGreyWolf.class, new ZooRenderGreyWolf(0.5F));
   }
   
	public void generateSurface(World world, Random rand, int chunkX, int chunkZ)
    {
	        for(int i = 0; i < 50; i++)
	        {
	            int randPosX = chunkX + rand.nextInt(16);
	            int randPosY = rand.nextInt(128);
	            int randPosZ = chunkZ + rand.nextInt(16);
	            (new WorldGenMinable(Zoo.brownStone.blockID, 50)).generate(world, rand, randPosX, randPosY, randPosZ);
	        }
	        for(int k2 = 0; k2 < 10; k2++)
	        {
	            int j7 = 1;
	            int k11 = chunkX + rand.nextInt(16) + 8;
	            int j15 = rand.nextInt(world.getWorldHeight());
	            int l17 = chunkZ + rand.nextInt(16) + 8;
	            (new WorldGenTallGrass(Zoo.savannahgrass.blockID, 1)).generate(world, rand, k11, j15, l17);
	        }
	        for(int k2 = 0; k2 < 10; k2++)
	        {
	            int j7 = 1;
	            int k11 = chunkX + rand.nextInt(16) + 8;
	            int j15 = rand.nextInt(world.getWorldHeight());
	            int l17 = chunkZ + rand.nextInt(16) + 8;
	            (new WorldGenTallGrass(Zoo.coniferousgrass.blockID, 1)).generate(world, rand, k11, j15, l17);
	        }
    }
	
    
    
    public boolean OnTickInGame(float f, Minecraft minecraft1)
    {
    	Zoo.versionCheck();
    	return false;
    }
    
	public String getVersion() {
		return new StringBuilder().append("Zoo Tycoon ").append(mod_ZooCore.version).append(" Core for Minecraft ").append(mod_ZooCore.mcVersion).append(" by ").append(mod_ZooCore.author).toString();
	}
	
	static Configuration config = new Configuration(new File(Minecraft.getMinecraftDir(), "Zoo/Core/Config.cfg"));
    
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
        config.getOrCreateIntProperty(s, config.ITEM_PROPERTY, i);
        config.save();
        return new Integer(config.getOrCreateIntProperty(s, config.ITEM_PROPERTY, i).value).intValue();
    }
    
    public static int getSpawnRate(String s, int i)
    {
    	config.load();
        config.getOrCreateIntProperty(s, config.GENERAL_PROPERTY, i);
        config.save();
        return new Integer(config.getOrCreateIntProperty(s, config.GENERAL_PROPERTY, i).value).intValue();
    }
    
    public static boolean getBoolean(String s, boolean b)
    {
    	config.load();
    	config.getOrCreateBooleanProperty(s, config.GENERAL_PROPERTY, b);
    	config.save();
    	return new Boolean(config.getOrCreateBooleanProperty(s, config.GENERAL_PROPERTY, b).value).booleanValue();
    }
    

    
    public static mod_ZooCore instance;
    private static boolean initialized = false;
    private static Minecraft minecraft = ModLoader.getMinecraftInstance();
}
