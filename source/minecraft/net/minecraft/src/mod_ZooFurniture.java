package net.minecraft.src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import net.minecraft.client.Minecraft;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.MinecraftForgeClient;
import net.minecraft.src.forge.NetworkMod;
import net.minecraft.src.zoo.furniture.ZooBlockBench;
import net.minecraft.src.zoo.furniture.ZooEntitySeat;
import net.minecraft.src.zoo.furniture.ZooFurnitureBase;
import net.minecraft.src.zoo.furniture.ZooItemFurniture;
import net.minecraft.src.zoo.furniture.ZooModelBench;
import net.minecraft.src.zoo.furniture.ZooTileEntityBench;
import net.minecraft.src.zoo.furniture.ZooTileEntityFurnitureRenderer;

public class mod_ZooFurniture extends NetworkMod
{

	public void load()
	{
		setupEntities();
		setupBlocks();

		MinecraftForgeClient.preloadTexture("/zoo/blocks.png");
		MinecraftForgeClient.preloadTexture("/zoo/items.png");

		ModLoader.addName(itemBench, "Bench");

		ModLoader.addRecipe(new ItemStack(mod_ZooFurniture.itemBench, 1), new Object[]
		{
				"XXX", "YYY", "X X", Character.valueOf('X'), Item.stick, Character.valueOf('Y'), new ItemStack(Block.stairSingle, 1, 2)
		});

	}

	public boolean clientSideRequired()
	{
		return true;
	}

	public boolean serverSideRequired()
	{
		return false;
	}

	static Configuration config = new Configuration(new File(Minecraft.getMinecraftDir(), "Zoo/Furniture/Config.cfg"));

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
		config.getOrCreateIntProperty(s, config.CATEGORY_BLOCK, i);
		config.save();
		return new Integer(config.getOrCreateIntProperty(s, config.CATEGORY_BLOCK, i).value).intValue();
	}

	public static Block makeBlock(Class blockClass, String idname, int id, Class tileClass, Material mat, float hard, String name)
	{
		try
		{
			return ((ZooFurnitureBase) (blockClass.getConstructors()[0].newInstance(getBlockID(idname, id), 0, tileClass, mat))).setHardness(hard).setBlockName(name);
		} catch (Exception e)
		{
			System.err.print(e);
			return null;
		}
	}

	public static Item makeItem(String idname, int id, Block block, int tex, String name)
	{
		return new ZooItemFurniture(getItemID(idname, id), (ZooFurnitureBase) block).setIconIndex(tex).setItemName(name);

	}

	public static void debugWrite(String string)
	{
		try
		{
			FileWriter fstream = new FileWriter("C:/Documents and Settings/Owner/AppData/Roaming/.minecraft/mods/ZooDebug.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			out.append(string);
			out.close();
		} catch (Exception e)
		{
			System.err.println(e);
		}
	}

	public void setupEntities()
	{
		ModLoader.registerEntityID(ZooEntitySeat.class, "EntitySeat", ModLoader.getUniqueEntityId());
	}

	public static void setupBlocks()
	{
		ZooTileEntityFurnitureRenderer benchRenderer = new ZooTileEntityFurnitureRenderer("/zoo/modells/Furniture/ModelWood.png", ZooModelBench.class);
		ModLoader.registerTileEntity(ZooTileEntityBench.class, "Tile Bench", benchRenderer);

	}

	// Blocks/Items
	public static Block blockBench = makeBlock(ZooBlockBench.class, "Bench", 218, ZooTileEntityBench.class, Material.wood, 2.0f, "Block Bench");
	public static Item itemBench = makeItem("Bench item", 412, blockBench, 7, "Item Bench");

	public String author = "HojoINC";

	public String getVersion()
	{
		return new StringBuilder().append("Zoo Tycoon ").append(mod_ZooCore.version).append(" Furniture for Minecraft ").append(mod_ZooCore.mcVersion).append(" by ").append(author).append(" modified by ").append(mod_ZooCore.author).toString();
	}
}
