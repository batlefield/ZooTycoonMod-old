

package net.minecraft.src;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.src.battlefield.API.BAPI;
import net.minecraft.src.battlefield.API.IBiome;
import net.minecraft.src.battlefield.API.VersionCheck;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.IBucketHandler;
import net.minecraft.src.forge.MinecraftForge;
import net.minecraft.src.forge.MinecraftForgeClient;
import net.minecraft.src.zoo.api.Trade;
import net.minecraft.src.zoo.api.ZAPI;
import net.minecraft.src.zoo.core.*;
import net.minecraft.src.zoo.core.entities.*;
import net.minecraft.src.zoo.trading.ZooItemCoin;

public class Zoo {
	
	public Zoo()
	{
	}
	
	
	// stuff that needs to be defined earlier
	private static boolean versionCheck = mod_ZooCore.settings.version;
	
	/**block ID's
	private int asphaltB = 201;
	private int concreteB = 202;
	private int brownstoneB = 203;
	private int saltwaterM = 204;
	private int saltwaterS = 205;
	private int stoneF = 206;
	private int plexiglassPane = 207;
	private int deciduousB = 208;
	private int coniferousB = 209;
	private int tropicB = 210;
	private int savannahB = 211;
	private int deciduousPeatB = 212;
	private int coniferousPeatB = 213;
	private int mesaB = 214;
	private int lateriteB = 215;
	private int gleyPeatB = 216;
	private int rainforestB = 217;
	private int benchB = 218;
	private int quicksandB = 219;
	private int goldFenceB = 220;
	private int obsidianFenceB = 221;
	private int brownstoneFenceB = 222;
	private int plexiglassB = 223;
	private int savannahTallGrassB = 224;
	private int shopB = 225;
	private int exhibitB = 226;
	private int coniferousTallGrassB = 227;
	private int acornsB = 228;
	private int acaciaLeavesB = 229;
	private int bluePineLeavesB = 230;
	private int saplingB = 231;
	private int grounder = 232
	private int portal = 233
	private int portalTool = 234**/

	public static boolean versionCheck()
	{
		if(versionCheck && !VersionCheck.run("http://www2.arnes.si/~pmati/ZTUC.html").equals(mod_ZooCore.version))
        {
        	Random random = new Random();
        	int color = random.nextInt(15);
        	
        	String colorS;
        	
        	switch (color)
        	{
	        	case 0:
	        		colorS = "§4";
	        		break;
	        	case 1:
	        		colorS = "§c";
	        		break;
	        	case 2:
	        		colorS = "§6";
	        		break;
	        	case 3:
	        		colorS = "§e";
	        		break;
	        	case 4:
	        		colorS = "§2";
	        		break;
	        	case 5:
	        		colorS = "§a";
	        		break;
	        	case 6:
	        		colorS = "§b";
	        		break;
	        	case 7:
	        		colorS = "§3";
	        		break;
	        	case 8:
	        		colorS = "§1";
	        		break;
	        	case 9:
	        		colorS = "§9";
	        		break;
	        	case 10:
	        		colorS = "§d";
	        		break;
	        	case 11:
	        		colorS = "§5";
	        		break;
	        	case 12:
	        		colorS = "§f";
	        		break;
	        	case 13:
	        		colorS = "§7";
	        		break;
	        	case 14:
	        		colorS = "§8";
	        		break;
	        	case 15:
	        		colorS = "§0";
	        		break;
	        		
        		default:
        			colorS = "§f";
        			break;
        	}
        	
        	mc.thePlayer.addChatMessage(colorS + "New version of ZooTycoon Available (" + VersionCheck.run("http://www2.arnes.si/~pmati/ZTUC.html") + ")");
        }
		return false;
	}

	
	public static void init()
	{
		
		ZAPI.registerFenceTool(fenceDestroyer);
		
		ZAPI.registerGlass(plexiglassBlock);
		ZAPI.registerPane(plexiglass);
		
		ZAPI.registerFence(Bfence);
		ZAPI.registerFence(Gfence);
		ZAPI.registerFence(Ofence);
		ZAPI.registerFence(fence);
        
		BAPI.registerPlantableHandler(new ZooPlantHandler());
		
		if(mod_ZooCore.settings.generateBiomesInOver)
		{
			BAPI.registerBiomeHandler((IBiome) savannah);
			BAPI.registerBiomeHandler((IBiome) decidious);
			BAPI.registerBiomeHandler((IBiome) coniferous);
			BAPI.registerBiomeHandler((IBiome) tropic);
		}
        
		
		new ZooDirts();
		new ZooCrafting();
		
				
		//register
		ModLoader.registerBlock(ZooDirts.savannah);
		ModLoader.registerBlock(asphalt);
		ModLoader.registerBlock(concrete);
		ModLoader.registerBlock(brownStone);
		ModLoader.registerBlock(fence);
		ModLoader.registerBlock(plexiglass);
		ModLoader.registerBlock(ZooDirts.deciduous);
		ModLoader.registerBlock(ZooDirts.coniferous);
		ModLoader.registerBlock(ZooDirts.tropical);
		ModLoader.registerBlock(ZooDirts.coniPeat);
		ModLoader.registerBlock(ZooDirts.deciPeat);
		ModLoader.registerBlock(ZooDirts.laterite);
		ModLoader.registerBlock(ZooDirts.mesa);
		ModLoader.registerBlock(ZooDirts.gleyPeat);
		ModLoader.registerBlock(ZooDirts.rainforest);
		ModLoader.registerBlock(Quicksand);
		ModLoader.registerBlock(Gfence);
		ModLoader.registerBlock(Ofence);
		ModLoader.registerBlock(Bfence);
		ModLoader.registerBlock(plexiglassBlock);
		ModLoader.registerBlock(savannahgrass);
		ModLoader.registerBlock(coniferousgrass);
		ModLoader.registerBlock(acorns);
		ModLoader.registerBlock(acaciaLeaves);
		ModLoader.registerBlock(saltwaterMoving);
        ModLoader.registerBlock(saltwaterStill);

		//names
		ModLoader.addName(asphalt, "Asphalt");
		ModLoader.addName(concrete, "Concrete");
		ModLoader.addName(brownStone, "Brown Stone");
		ModLoader.addName(saltwaterStill, "Saltwater");
		ModLoader.addName(saltwaterMoving, "Saltwater");
		ModLoader.addName(saltBucket, "Bucket of saltwater");
		ModLoader.addName(fence, "Stone fence");
		ModLoader.addName(plexiglass, "Plexi Glass Pane");
		ModLoader.addName(fenceDestroyer, "Fence removing tool");
		ModLoader.addName(bsSword, "Brownstone Sword");
		ModLoader.addName(bsPickaxe, "Brownstone Pickaxe");
		ModLoader.addName(bsHoe, "Brownstone Hoe");
		ModLoader.addName(bsShovel, "Brownstone Shovel");
		ModLoader.addName(bsAxe, "Brownstone Axe");
		ModLoader.addName(Quicksand, "Quicksand");
		ModLoader.addName(Gfence, "Gold Fence");
		ModLoader.addName(Ofence, "Obsidian Fence");
		ModLoader.addName(Bfence, "Brownstone Fence");
		ModLoader.addName(plexiglassBlock, "Plexi Glass");
		ModLoader.addName(fencer, "Exhibit tool");
		ModLoader.addName(smallFencePack, "Small fence pack");
		ModLoader.addName(fencePack, "Fence Pack");
		ModLoader.addName(compactFencePack, "Compact Fence Pack");
		ModLoader.addName(lasso, "Lasso");
		ModLoader.addName(savannahgrass, "Savannah grass");
		ModLoader.addName(coniferousgrass, "Coniferous Grass");
		ModLoader.addName(acorns, "Acorns");
		ModLoader.addName(acaciaLeaves, "Acacia leaves");
		
		ModLoader.registerBlock(blueLeaves, net.minecraft.src.zoo.core.ZooItemLeaves.class);
		ModLoader.addName(new ItemStack(blueLeaves), "Blue pine leaves");
		ModLoader.registerBlock(grounder, net.minecraft.src.zoo.core.ZooItemGrounder.class);
		ModLoader.addName(new ItemStack(grounder, 1, 0), "Grounder 128x128");
		ModLoader.registerBlock(fencer, net.minecraft.src.zoo.core.ZooItemFencer.class);
		ModLoader.addName(new ItemStack(fencer, 1, 0), "Exhibit tool 16x16");
		ModLoader.addName(new ItemStack(fencer, 1, 4), "Exhibit tool 32x32");
		ModLoader.registerBlock(sapling, net.minecraft.src.zoo.core.ZooItemSapling.class);
		ModLoader.addName(new ItemStack(sapling, 1, 0), "Acacia sapling");
		ModLoader.addName(new ItemStack(sapling, 1, 1), "Blue pine sapling");
		ModLoader.addName(new ItemStack(sapling, 1, 2), "Deciduous sapling");
		
		mc.renderEngine.registerTextureFX(new ZooSaltwaterTextureFX(saltwaterStill.blockIndexInTexture, false));
        mc.renderEngine.registerTextureFX(new ZooSaltwaterTextureFX(saltwaterMoving.blockIndexInTexture, true));
				
		//other stuff
		if (saltwaterMoving.blockID + 1 != saltwaterStill.blockID) {
		      throw new RuntimeException("Still saltwater id must be moving saltwater id + 1");
		}
		
		MinecraftForge.setToolClass(fenceDestroyer, "zoofencedestroyer", 6);
		MinecraftForge.setBlockHarvestLevel(fence,"pickaxe",6);
		MinecraftForge.setBlockHarvestLevel(Gfence,"pickaxe",6);
		MinecraftForge.setBlockHarvestLevel(Ofence,"pickaxe",6);
		MinecraftForge.setBlockHarvestLevel(Bfence,"pickaxe",6);
		MinecraftForge.setBlockHarvestLevel(Block.fence, "pickaxe", 6);
		MinecraftForge.setBlockHarvestLevel(Block.netherFence, "pickaxe", 6);
		MinecraftForge.setBlockHarvestLevel(Block.fence, "axe", 6);
		MinecraftForge.setBlockHarvestLevel(fence,"zoofencedestroyer",1);
		MinecraftForge.setBlockHarvestLevel(Gfence,"zoofencedestroyer",1);
		MinecraftForge.setBlockHarvestLevel(Ofence,"zoofencedestroyer",1);
		MinecraftForge.setBlockHarvestLevel(Bfence,"zoofencedestroyer",1);
		MinecraftForge.setBlockHarvestLevel(plexiglass,"zoofencedestroyer",1);
		MinecraftForge.setBlockHarvestLevel(plexiglassBlock,"zoofencedestroyer",1);
		MinecraftForge.setBlockHarvestLevel(Block.netherFence, "zoofencedestroyer", 1);
		MinecraftForge.setBlockHarvestLevel(Block.fence, "zoofencedestroyer", 1);
		MinecraftForge.registerCustomBucketHandler(saltBucket);
		
		MinecraftForge.versionDetect("Zoo Tycoon", 1, 3, 3);
		
		MinecraftForge.registerBonemealHandler(new ZooBonemealHandler());
		
		/*test recipes
        ModLoader.AddRecipe(new ItemStack(Item.shears, 1), new Object[] {
		     "X", Character.valueOf('X'), Block.dirt
		});*/

				
		/**entities*/
		//animals
	    ModLoader.registerEntityID(ZooEntityBighorn.class, "Bighorn", ModLoader.getUniqueEntityId());
		ModLoader.registerEntityID(ZooEntityGazelle.class, "Gazelle", ModLoader.getUniqueEntityId());
		ModLoader.registerEntityID(ZooEntityHippo.class, "Hippo", ModLoader.getUniqueEntityId());
		ModLoader.registerEntityID(ZooEntityPrimate.class, "Primate", ModLoader.getUniqueEntityId());
		ModLoader.registerEntityID(ZooEntityRhino.class, "Rhino", ModLoader.getUniqueEntityId());
	    ModLoader.registerEntityID(ZooEntityTiger.class, "Tiger", ModLoader.getUniqueEntityId());
		ModLoader.registerEntityID(ZooEntityElephant.class, "Elephant", ModLoader.getUniqueEntityId());
		ModLoader.registerEntityID(ZooEntityAfricanWDog.class, "African Wild Dog", ModLoader.getUniqueEntityId());
		ModLoader.registerEntityID(ZooEntityAnteater.class, "Anteater", ModLoader.getUniqueEntityId());
		ModLoader.registerEntityID(ZooEntityLion.class, "Lion", ModLoader.getUniqueEntityId());
		//ModLoader.registerEntityID(ZooEntityPanther.class, "Panther", ModLoader.getUniqueEntityId());
		ModLoader.registerEntityID(ZooEntityFennecFox.class, "Fennec Fox", ModLoader.getUniqueEntityId());
		ModLoader.registerEntityID(ZooEntityGiraffe.class, "Giraffe", ModLoader.getUniqueEntityId());
		//ModLoader.registerEntityID(ZooEntityFlamingo.class, "Flamingo", ModLoader.getUniqueEntityId());
		//ModLoader.registerEntityID(ZooEntityGreyWolf.class, "Grey wolf", ModLoader.getUniqueEntityId());
		
		
		//NPC's
		ModLoader.registerEntityID(ZooVisitorMale.class, "NPC 1", ModLoader.getUniqueEntityId());
		ModLoader.registerEntityID(ZooVisitorFemale.class, "Female", ModLoader.getUniqueEntityId());
		          
		
	    //spawning
	    ModLoader.addSpawn(ZooEntityBighorn.class, mod_ZooCore.getSpawnRate("Bighorn Spawnrate", 1), 4, 4, EnumCreatureType.creature);
		ModLoader.addSpawn(ZooEntityGazelle.class, mod_ZooCore.getSpawnRate("Gazelle Spawnrate", 1), 4, 4, EnumCreatureType.creature);
		ModLoader.addSpawn(ZooEntityHippo.class, mod_ZooCore.getSpawnRate("Hippo Spawnrate", 1), 4, 4, EnumCreatureType.creature);
		ModLoader.addSpawn(ZooEntityPrimate.class, mod_ZooCore.getSpawnRate("Primate Spawnrate", 1), 4, 4, EnumCreatureType.creature);
		ModLoader.addSpawn(ZooEntityRhino.class, mod_ZooCore.getSpawnRate("Rhino Spawnrate", 1), 4, 4, EnumCreatureType.creature);
		ModLoader.addSpawn(ZooEntityTiger.class, mod_ZooCore.getSpawnRate("Tiger Spawnrate", 1), 4, 4, EnumCreatureType.creature);
		ModLoader.addSpawn(ZooVisitorMale.class, mod_ZooCore.getSpawnRate("NPC 1 Spawnrate", 1), 1, 1, EnumCreatureType.creature);
		ModLoader.addSpawn(ZooEntityLion.class, mod_ZooCore.getSpawnRate("Lion Spawnrate", 1), 4, 4, EnumCreatureType.creature);
		ModLoader.addSpawn(ZooEntityAnteater.class, mod_ZooCore.getSpawnRate("Anteater Spawnrate", 1), 4, 4, EnumCreatureType.creature);
		ModLoader.addSpawn(ZooEntityAfricanWDog.class, mod_ZooCore.getSpawnRate("African wild dog spawnrate", 1), 4, 8, EnumCreatureType.creature, savana);
		//ModLoader.addSpawn(ZooEntityPanther.class, mod_ZooCore.getSpawnRate("Panther Spawnrate", 20), 4, 4, EnumCreatureType.creature);
		ModLoader.addSpawn(ZooEntityFennecFox.class, mod_ZooCore.getSpawnRate("Fennec Fox Spawnrate", 1), 4, 4, EnumCreatureType.creature);
		ModLoader.addSpawn(ZooEntityGiraffe.class, mod_ZooCore.getSpawnRate("Giraffe Spawnrate", 1), 4, 4, EnumCreatureType.creature);
		//ModLoader.addSpawn(ZooEntityFlamingo.class, mod_ZooCore.getSpawnRate("Flamingo Spawnrate", 20), 4, 4, EnumCreatureType.creature);
		//ModLoader.addSpawn(ZooEntityGreyWolf.class, mod_ZooCore.getSpawnRate("Grey Wolf Spawnrate", 10), 10, 10, EnumCreatureType.creature);
		
		/**broken*/
		//
		//ModLoader.addSpawn(ZooEntityElephant.class, mod_Zoo.getSpawnRate("Elephant Spawnrate", 20), 10, 10, EnumCreatureType.creature);
		
		
	}
		
	//misc
	public static final Block grounder = new ZooBlockWall(mod_ZooCore.getBlockIdFor("Grounder", 233)).setBlockName("test");
	public static final Block asphalt = (new ZooBlock(mod_ZooCore.getBlockIdFor("Asphalt", 201), 29, Material.rock).setHardness(1.0F).setResistance(1.0F).setBlockName("asphalt").setStepSound(Block.soundStoneFootstep));
	public static final Block concrete = (new ZooBlock(mod_ZooCore.getBlockIdFor("Concrete", 202), 30, Material.rock).setHardness(1.0F).setResistance(1.0F).setBlockName("concrete").setStepSound(Block.soundStoneFootstep));
	public static final Block brownStone = (new ZooBlock(mod_ZooCore.getBlockIdFor("Brown stone", 203), 10, Material.rock).setHardness(1.5F).setResistance(10F).setBlockName("bs").setStepSound(Block.soundStoneFootstep));
	public static final Block saltwaterStill = (new ZooSaltwaterStationary(mod_ZooCore.getBlockIdFor("Still saltwater", 205), Material.water).setHardness(100F).setBlockName("sws").setLightOpacity(2).disableStats().setRequiresSelfNotify());
	public static final Block saltwaterMoving = (new ZooSaltwaterFlowing(mod_ZooCore.getBlockIdFor("Moving saltwater", 204), Material.water).setHardness(100F).setBlockName("swm").setLightOpacity(2).disableStats().setRequiresSelfNotify());
	public static final Block Quicksand = (new ZooBlockQuicksand(mod_ZooCore.getBlockIdFor("Quicksand", 219), 37).setBlockName("qs"));
	public static final Block savannahgrass = (new ZooTallGrass(mod_ZooCore.getBlockIdFor("Savannah Tall Grass", 224), 26).setBlockName("sg").setStepSound(Block.soundGrassFootstep));
	public static final Block coniferousgrass = (new ZooTallGrass(mod_ZooCore.getBlockIdFor("Coniferous Tall Grass", 227), 27).setBlockName("cg").setStepSound(Block.soundGrassFootstep));
	public static final Block acorns = (new ZooAcorns(mod_ZooCore.getBlockIdFor("Acorns", 228), 35).setBlockName("acorns").setStepSound(Block.soundWoodFootstep));
	public static final BlockFencer fencer = (BlockFencer)(new BlockFencer(mod_ZooCore.getBlockIdFor("Exhibit tool", 226)).setBlockName("fencer").setHardness(0F));

	
	//leaves and tree stuff
	public static final Block acaciaLeaves = (new ZooLeaves(mod_ZooCore.getBlockIdFor("Acacia Leaves", 229), 43).setHardness(0.2F).setBlockName("leaves").setStepSound(Block.soundGrassFootstep));
	public static final Block blueLeaves = (new ZooLeaves(mod_ZooCore.getBlockIdFor("Blue Pine Leaves", 230), 39).setHardness(0.2F).setBlockName("blueleaves").setStepSound(Block.soundGrassFootstep).setRequiresSelfNotify());
	public static final Block sapling = (new ZooSapling(mod_ZooCore.getBlockIdFor("Sapling", 231), 44).setBlockName("sapling").setStepSound(Block.soundGrassFootstep));
	
	
	//fences
	public static final Block fence = (new BlockFence(mod_ZooCore.getBlockIdFor("Stone Fence", 206), 1, Material.rock).setHardness(3F).setResistance(6F).setBlockName("stonefence").setStepSound(Block.soundStoneFootstep));
	public static final Block Gfence = (new BlockFence(mod_ZooCore.getBlockIdFor("Golden Fence", 220), 23, Material.iron).setHardness(20F).setResistance(6F).setBlockName("gfence").setStepSound(Block.soundMetalFootstep));
	public static final Block Ofence = (new BlockFence(mod_ZooCore.getBlockIdFor("Obsidian Fence", 221), 37, Material.rock).setHardness(50F).setResistance(6F).setBlockName("ofence").setStepSound(Block.soundStoneFootstep));
	public static final Block Bfence = (new BlockFence(mod_ZooCore.getBlockIdFor("Brownstone Fence", 222), ModLoader.addOverride("/terrain.png", "/zoo/bs.png"), Material.rock).setHardness(3F).setResistance(6F).setBlockName("bfence").setStepSound(Block.soundStoneFootstep));
	public static final Block plexiglass = (new ZooBlockGlass(mod_ZooCore.getBlockIdFor("Plexi glass pane", 207), 12, 31, Material.glass, true).setHardness(0.5F).setResistance(20000F).setBlockName("plexiglasspane").setStepSound(Block.soundGlassFootstep));
	public static final Block plexiglassBlock = (new ZooGlass(mod_ZooCore.getBlockIdFor("Plexi glass", 223), 12, Material.glass, false).setHardness(0.5F).setResistance(20000F).setBlockName("plexiglass").setStepSound(Block.soundGlassFootstep));
		
	//items
	public static ItemSaltwaterBucket saltBucket = (ItemSaltwaterBucket)(new ItemSaltwaterBucket(mod_ZooCore.getItemIdFor("Saltwater bucket", 400), Zoo.saltwaterMoving.blockID, 1).setItemName("saltbucket").setContainerItem(Item.bucketEmpty));
	public static Item fenceDestroyer = (new ZooItemFenceDestroyer(mod_ZooCore.getItemIdFor("Fence hammer", 401), ZooEnumTool.FENCEDES).setIconIndex(0).setItemName("fencedes"));
	public static Item smallFencePack = (new ZooItem(mod_ZooCore.getItemIdFor("Small Fence Pack", 408)).setItemName("smallFencePack").setIconIndex(11));
	public static Item fencePack = (new ZooItem(mod_ZooCore.getItemIdFor("Fence Pack", 409)).setItemName("fencePack").setIconIndex(12));
	public static Item compactFencePack = (new ZooItem(mod_ZooCore.getItemIdFor("Compact Fence Pack", 410)).setItemName("compactFencePack").setIconIndex(13));
	public static Item lasso = (new ZooItem(mod_ZooCore.getItemIdFor("Lasso", 411)).setIconIndex(14).setItemName("lasso"));

	
	//tools
	public static Item bsSword = (new ZooSword(mod_ZooCore.getItemIdFor("Brownstone Sword", 402), ZooEnumTool.BS).setIconIndex(6).setItemName("bssw"));
	public static Item bsPickaxe = (new ZooPickaxe(mod_ZooCore.getItemIdFor("Brownstone Pickaxe", 403), ZooEnumTool.BS).setIconIndex(2).setItemName("bsp"));
	public static Item bsAxe = (new ZooAxe(mod_ZooCore.getItemIdFor("Brownstone Axe", 404), ZooEnumTool.BS).setIconIndex(3).setItemName("bsa"));
	public static Item bsHoe = (new ZooHoe(mod_ZooCore.getItemIdFor("Brownstone Hoe", 405), ZooEnumTool.BS).setIconIndex(4).setItemName("bsh"));
	public static Item bsShovel = (new ZooShovel(mod_ZooCore.getItemIdFor("Brownstone Shovel", 406), ZooEnumTool.BS).setIconIndex(5).setItemName("bssh"));
	
	
	//biomes
    public static final BiomeGenBase rainforest = (new BiomeGenTropic(ZooPlatform.getFreeBiomeID(250))).setColor(0x8db360).setBiomeName("Tropic").setTemperatureRainfall(2F, 2F);
    public static final BiomeGenBase savannah = (new BiomeGenSavannah(ZooPlatform.getFreeBiomeID(252))).setColor(0xFFEF00).setBiomeName("Savannah").setDisableRain().setTemperatureRainfall(2.0F, 0.0F);
    public static final BiomeGenBase decidious = (new BiomeGenDecidious(ZooPlatform.getFreeBiomeID(253))).setColor(0x8db360).setBiomeName("Decidious").setTemperatureRainfall(0.8F, 0.4F).func_4124_a(0x4eba31);
    public static final BiomeGenBase coniferous = (new BiomeGenConiferous(ZooPlatform.getFreeBiomeID(254))).setColor(0xb6659).setBiomeName("Coniferous").func_4124_a(0x4eba31).setTemperatureRainfall(0.05F, 0.8F).setMinMaxHeight(0.1F, 0.4F);
    public static final BiomeGenBase tropic = (new BiomeGenTropic(ZooPlatform.getFreeBiomeID(255))).setColor(0x8db360).setBiomeName("Tropic").setTemperatureRainfall(2F, 2F);

	
	
	
	//other
	public static int GameModeID = mod_ZooCore.getSpawnRate("Gamemode ID", 5);
	public static Minecraft mc = ModLoader.getMinecraftInstance();
	
	public static BiomeGenBase savana[] = {savannah};
}
