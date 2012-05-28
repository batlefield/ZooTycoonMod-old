package net.minecraft.src;

import java.io.File;
import java.util.Map;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.MinecraftForgeClient;
import net.minecraft.src.forge.NetworkMod;
import net.minecraft.src.zoo.core.EntityHandeler;
import net.minecraft.src.zoo.core.ZooSettings;

import org.lwjgl.opengl.GL11;

public class mod_ZooCore extends NetworkMod
{

	public static String version = "Alpha 1.0.0";
	public static String mcVersion = "1.1.0";
	public static String author = "Battlefield and AndrewSherman";
	public static int renderMode;
	public static KeyBinding options = new KeyBinding("Zoo options", 25);
	public static ZooSettings settings = new ZooSettings();
	boolean checked;

	public void load()
	{
		ModLoader.registerKey(this, options, false);
		renderMode = ModLoader.getUniqueBlockModelID(this, true);
		initialize();
	}

	public mod_ZooCore()
	{
		instance = this;
	}

	public static void initialize()
	{
		if (initialized)
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

	public void modsLoaded()
	{
		ModLoader.setInGameHook(this, true, true);
		ModLoader.setInGUIHook(this, true, true);
	}

	public boolean renderWorldBlock(RenderBlocks renderblocks, IBlockAccess iblockaccess, int i, int j, int k, Block block, int l)
	{
		if (l == renderMode)
		{
			GL11.glPushMatrix();
			RenderEngine renderengine = ModLoader.getMinecraftInstance().renderEngine;
			Tessellator tessellator = Tessellator.instance;
			tessellator.draw();
			tessellator.startDrawingQuads();
			GL11.glBindTexture(3553 /* GL_TEXTURE_2D */, renderengine.getTexture("/zoo/water.png"));
			renderblocks.renderBlockFluids(block, i, j, k);
			tessellator.draw();
			tessellator.startDrawingQuads();
			GL11.glBindTexture(3553 /* GL_TEXTURE_2D */, renderengine.getTexture("/terrain.png"));
			GL11.glPopMatrix();
			return true;
		} else
		{
			return true;
		}
	}

	public void keyboardEvent(KeyBinding var1)
	{
		if (minecraft.currentScreen == null)
		{
			if (var1 == options)
			{
				minecraft.displayGuiScreen(new net.minecraft.src.zoo.core.GuiOptions());
			}
		}
	}

	public void addRenderer(Map map)
	{
		EntityHandeler.addRender(map);
	}

	public void generateSurface(World world, Random rand, int chunkX, int chunkZ)
	{
		for (int i = 0; i < 50; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(128);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(Zoo.brownStone.blockID, 50)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
		for (int k2 = 0; k2 < 10; k2++)
		{
			int j7 = 1;
			int k11 = chunkX + rand.nextInt(16) + 8;
			int j15 = rand.nextInt(256);
			int l17 = chunkZ + rand.nextInt(16) + 8;
			(new WorldGenTallGrass(Zoo.savannahgrass.blockID, 1)).generate(world, rand, k11, j15, l17);
		}
		for (int k2 = 0; k2 < 10; k2++)
		{
			int j7 = 1;
			int k11 = chunkX + rand.nextInt(16) + 8;
			int j15 = rand.nextInt(256);
			int l17 = chunkZ + rand.nextInt(16) + 8;
			(new WorldGenTallGrass(Zoo.coniferousgrass.blockID, 1)).generate(world, rand, k11, j15, l17);
		}
	}

	public boolean onTickInGame(float f, Minecraft mc)
	{
		if (mc.theWorld == null)
		{
			checked = false;
		}
		if (!checked)
		{
			Zoo.versionCheck();
			checked = true;
		}
		return true;
	}

	public String getVersion()
	{
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
		config.getOrCreateIntProperty(s, config.CATEGORY_ITEM, i);
		config.save();
		return new Integer(config.getOrCreateIntProperty(s, config.CATEGORY_ITEM, i).value).intValue();
	}

	public static int getGeneralInt(String s, int i)
	{
		config.load();
		config.getOrCreateIntProperty(s, config.CATEGORY_GENERAL, i);
		config.save();
		return new Integer(config.getOrCreateIntProperty(s, config.CATEGORY_GENERAL, i).value).intValue();
	}

	public static boolean getBoolean(String s, boolean b)
	{
		config.load();
		config.getOrCreateBooleanProperty(s, config.CATEGORY_GENERAL, b);
		config.save();
		return new Boolean(config.getOrCreateBooleanProperty(s, config.CATEGORY_GENERAL, b).value).booleanValue();
	}

	public static mod_ZooCore instance;
	private static boolean initialized = false;
	private static Minecraft minecraft = ModLoader.getMinecraftInstance();

}
