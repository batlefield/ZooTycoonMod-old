package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.BAPI.BAPI;
import net.minecraft.src.BAPI.VersionCheck;
import net.minecraft.src.BAPI.interfaces.IBiome;
import net.minecraft.src.forge.MinecraftForge;
import net.minecraft.src.zoo.api.ZAPI;
import net.minecraft.src.zoo.core.BlockFencer;
import net.minecraft.src.zoo.core.CoreBlocksCreative;
import net.minecraft.src.zoo.core.EntityHandeler;
import net.minecraft.src.zoo.core.ItemSaltwaterBucket;
import net.minecraft.src.zoo.core.ZooAcorns;
import net.minecraft.src.zoo.core.ZooAxe;
import net.minecraft.src.zoo.core.ZooBlock;
import net.minecraft.src.zoo.core.ZooBlockGlass;
import net.minecraft.src.zoo.core.ZooBlockQuicksand;
import net.minecraft.src.zoo.core.ZooBlockWall;
import net.minecraft.src.zoo.core.ZooBonemealHandler;
import net.minecraft.src.zoo.core.ZooCrafting;
import net.minecraft.src.zoo.core.ZooEnumTool;
import net.minecraft.src.zoo.core.ZooFence;
import net.minecraft.src.zoo.core.ZooGlass;
import net.minecraft.src.zoo.core.ZooHoe;
import net.minecraft.src.zoo.core.ZooItem;
import net.minecraft.src.zoo.core.ZooItemFenceDestroyer;
import net.minecraft.src.zoo.core.ZooLeaves;
import net.minecraft.src.zoo.core.ZooPickaxe;
import net.minecraft.src.zoo.core.ZooPlaceableHandler;
import net.minecraft.src.zoo.core.ZooPlatform;
import net.minecraft.src.zoo.core.ZooSaltwaterFlowing;
import net.minecraft.src.zoo.core.ZooSaltwaterStationary;
import net.minecraft.src.zoo.core.ZooSapling;
import net.minecraft.src.zoo.core.ZooShovel;
import net.minecraft.src.zoo.core.ZooSword;
import net.minecraft.src.zoo.core.ZooTallGrass;

public class Zoo {
	
	//stuff that needs to be defined earlier
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
	private int shopB2 = 226;/////
	private int exhibitB = 227;
	private int coniferousTallGrassB = 228;
	private int acornsB = 229;
	private int acaciaLeavesB = 230;
	private int bluePineLeavesB = 231;
	private int saplingB = 232;
	private int grounder = 233;
	private int portal = 234;
	private int portalTool = 235;**/

	public static boolean versionCheck()
	{
		String s = VersionCheck.run("http://www2.arnes.si/~pmati/ZTUC.html");
		if(versionCheck && !s.equals(mod_ZooCore.version))
        {
        	mc.thePlayer.addChatMessage(BAPI.getCustomStringColor() + "New version of Zoo Tycoon Available (" + s + ")");
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
        
		BAPI.registerPlacableHandler(new ZooPlaceableHandler());
		BAPI.registerCreativeHandler(new CoreBlocksCreative());
		
		if(mod_ZooCore.settings.generateBiomesInOver)
		{
			BAPI.registerBiomeHandler(savannah);
			BAPI.registerBiomeHandler(decidious);
			BAPI.registerBiomeHandler(coniferous);
			BAPI.registerBiomeHandler(tropic);
		}
        
		new ZooCrafting();
		

		//items
		ModLoader.addName(saltBucket, "Bucket of saltwater");
		ModLoader.addName(fenceDestroyer, "Fence removing tool");
		ModLoader.addName(bsSword, "Brownstone Sword");
		ModLoader.addName(bsPickaxe, "Brownstone Pickaxe");
		ModLoader.addName(bsHoe, "Brownstone Hoe");
		ModLoader.addName(bsShovel, "Brownstone Shovel");
		ModLoader.addName(bsAxe, "Brownstone Axe");
		ModLoader.addName(smallFencePack, "Small fence pack");
		ModLoader.addName(fencePack, "Fence Pack");
		ModLoader.addName(compactFencePack, "Compact Fence Pack");
		ModLoader.addName(lasso, "Lasso");
		
		
		//blocks
		registerBlock(asphalt, "Asphalt");
		registerBlock(concrete, "Concrete");
		registerBlock(brownStone, "Brown Stone");
		registerBlock(saltwaterStill, "Saltwater");
		registerBlock(saltwaterMoving, "Saltwater");
		registerBlock(fence, "Stone fence");
		registerBlock(plexiglass, "Plexi Glass Pane");
		registerBlock(Quicksand, "Quicksand");
		registerBlock(Gfence, "Gold Fence");
		registerBlock(Ofence, "Obsidian Fence");
		registerBlock(Bfence, "Brownstone Fence");
		registerBlock(plexiglassBlock, "Plexi Glass");
		registerBlock(fencer, "Exhibit tool");
		registerBlock(savannahgrass, "Savannah grass");
		registerBlock(coniferousgrass, "Coniferous Grass");
		registerBlock(acorns, "Acorns");
		registerBlock(acaciaLeaves, "Acacia leaves");
		registerBlock(ZooDirts.savannah, "Savannah");
		registerBlock(ZooDirts.deciduous, "Deciduous");
		registerBlock(ZooDirts.coniferous, "Coniferous");
		registerBlock(ZooDirts.tropical, "Tropical");
		registerBlock(ZooDirts.coniPeat, "Deciduous Peat");
		registerBlock(ZooDirts.deciPeat, "Coniferous Peat");
		registerBlock(ZooDirts.mesa, "Mesa");
		registerBlock(ZooDirts.laterite, "Laterite");
		registerBlock(ZooDirts.gleyPeat, "Gley Peat");
		registerBlock(ZooDirts.rainforest, "Rainforest");
		
		
		//blocks with metadata
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
		
		
		//other stuff
		mc.renderEngine.registerTextureFX(new ZooSaltwaterTextureFX(saltwaterStill.blockIndexInTexture, false));
        mc.renderEngine.registerTextureFX(new ZooSaltwaterTextureFX(saltwaterMoving.blockIndexInTexture, true));
		if (saltwaterMoving.blockID + 1 != saltwaterStill.blockID) {
		      throw new RuntimeException("Still saltwater id must be moving saltwater id + 1");
		}
		
		MinecraftForge.registerOre("brownstone", new ItemStack(brownStone, 1, 0));
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
		MinecraftForge.versionDetect("Zoo Tycoon", 3, 0, 1);
		MinecraftForge.registerBonemealHandler(new ZooBonemealHandler());
		
		/*test recipes
        ModLoader.AddRecipe(new ItemStack(Item.shears, 1), new Object[] {
		     "X", Character.valueOf('X'), Block.dirt
		});*/
		
		EntityHandeler.init();
	}
	
	private static void registerBlock(Block block, String s)
	{
		ModLoader.registerBlock(block);
		ModLoader.addName(block, s);
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
	public static final Block coniferousgrass = (new ZooTallGrass(mod_ZooCore.getBlockIdFor("Coniferous Tall Grass", 228), 27).setBlockName("cg").setStepSound(Block.soundGrassFootstep));
	public static final Block acorns = (new ZooAcorns(mod_ZooCore.getBlockIdFor("Acorns", 229), 35).setBlockName("acorns").setStepSound(Block.soundWoodFootstep));
	public static final BlockFencer fencer = (BlockFencer)(new BlockFencer(mod_ZooCore.getBlockIdFor("Exhibit tool", 227)).setBlockName("fencer").setHardness(0F));
	public static final Block acaciaLeaves = (new ZooLeaves(mod_ZooCore.getBlockIdFor("Acacia Leaves", 230), 43).setHardness(0.2F).setBlockName("leaves").setStepSound(Block.soundGrassFootstep));
	public static final Block blueLeaves = (new ZooLeaves(mod_ZooCore.getBlockIdFor("Blue Pine Leaves", 231), 39).setHardness(0.2F).setBlockName("blueleaves").setStepSound(Block.soundGrassFootstep).setRequiresSelfNotify());
	public static final Block sapling = (new ZooSapling(mod_ZooCore.getBlockIdFor("Sapling", 232), 44).setBlockName("sapling").setStepSound(Block.soundGrassFootstep));
	public static final Block fence = (new BlockFence(mod_ZooCore.getBlockIdFor("Stone Fence", 206), 1, Material.rock).setHardness(3F).setResistance(6F).setBlockName("stonefence").setStepSound(Block.soundStoneFootstep));
	public static final Block Gfence = (new BlockFence(mod_ZooCore.getBlockIdFor("Golden Fence", 220), 23, Material.iron).setHardness(20F).setResistance(6F).setBlockName("gfence").setStepSound(Block.soundMetalFootstep));
	public static final Block Ofence = (new BlockFence(mod_ZooCore.getBlockIdFor("Obsidian Fence", 221), 37, Material.rock).setHardness(50F).setResistance(6F).setBlockName("ofence").setStepSound(Block.soundStoneFootstep));
	public static final Block Bfence = (new ZooFence(mod_ZooCore.getBlockIdFor("Brownstone Fence", 222), 10, Material.rock).setHardness(3F).setResistance(6F).setBlockName("bfence").setStepSound(Block.soundStoneFootstep));
	public static final Block plexiglass = (new ZooBlockGlass(mod_ZooCore.getBlockIdFor("Plexi glass pane", 207), 12, 31, Material.glass, true).setHardness(0.5F).setResistance(20000F).setBlockName("plexiglasspane").setStepSound(Block.soundGlassFootstep));
	public static final Block plexiglassBlock = (new ZooGlass(mod_ZooCore.getBlockIdFor("Plexi glass", 223), 12, Material.glass, false).setHardness(0.5F).setResistance(20000F).setBlockName("plexiglass").setStepSound(Block.soundGlassFootstep));
		
	//items
	public static ItemSaltwaterBucket saltBucket = (ItemSaltwaterBucket)(new ItemSaltwaterBucket(mod_ZooCore.getItemIdFor("Saltwater bucket", 400), Zoo.saltwaterMoving.blockID, 1).setItemName("saltbucket").setContainerItem(Item.bucketEmpty));
	public static Item fenceDestroyer = (new ZooItemFenceDestroyer(mod_ZooCore.getItemIdFor("Fence hammer", 401), ZooEnumTool.FENCEDES).setIconIndex(0).setItemName("fencedes"));
	public static Item smallFencePack = (new ZooItem(mod_ZooCore.getItemIdFor("Small Fence Pack", 408)).setItemName("smallFencePack").setIconIndex(11));
	public static Item fencePack = (new ZooItem(mod_ZooCore.getItemIdFor("Fence Pack", 409)).setItemName("fencePack").setIconIndex(12));
	public static Item compactFencePack = (new ZooItem(mod_ZooCore.getItemIdFor("Compact Fence Pack", 410)).setItemName("compactFencePack").setIconIndex(13));
	public static Item lasso = (new ZooItem(mod_ZooCore.getItemIdFor("Lasso", 411)).setIconIndex(14).setItemName("lasso"));
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
	public static Minecraft mc = ModLoader.getMinecraftInstance();
}
