package net.minecraft.src;

import net.minecraft.src.battlefield.API.BAPI;
import net.minecraft.src.zoo.dimension.PortalTool;
import net.minecraft.src.zoo.dimension.ZooPortal;
import net.minecraft.src.Zoo;

public class ZooDimension {

	public static int dimensionId = mod_ZooDimension.getInteger("Dimension ID", 5);
	
	public static void init() {
		ModLoader.registerBlock(portal);
		ModLoader.registerBlock(portalCreator);
		
		ModLoader.addName(portal, "Zoo Portal");
		ModLoader.addName(portalCreator, "Portal tool");
		
		ModLoader.addRecipe(new ItemStack(portalCreator, 1), new Object[]{
			"XXX", "XXX", "XXX", Character.valueOf('X'), Zoo.brownStone
		});
		
		ModLoader.getMinecraftInstance().renderEngine.registerTextureFX(new ZooPortalFX());
	}
	
	
	public static final ZooPortal portal = (ZooPortal) new ZooPortal(mod_ZooDimension.getBlockIdFor("Portal", 233), 0, Material.portal).setHardness(-1F).setStepSound(Block.soundGlassFootstep).setLightValue(0.75F).setBlockName("zooportal");
	public static final Block portalCreator = new PortalTool(mod_ZooDimension.getBlockIdFor("Portal tool", 234), 0, Material.iron).setHardness(1F).setStepSound(Block.soundMetalFootstep).setBlockName("portaltool");

}