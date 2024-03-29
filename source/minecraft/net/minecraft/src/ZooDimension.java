package net.minecraft.src;

import net.minecraft.src.zoo.dimension.PortalTool;
import net.minecraft.src.zoo.dimension.ZooPortal;
import net.minecraft.src.zoo.dimension.ZooPortalFX;
import net.minecraft.src.zoo.dimension.ZooPortalOverlay;
import net.minecraft.src.Zoo;
import net.minecraft.src.BAPI.*;

public class ZooDimension {

	public static int dimensionId = mod_ZooDimension.getInteger("Dimension ID", 5);
	
	public static void init() {
		BAPI.registerGameOverlay(new ZooPortalOverlay());
		
		ModLoader.registerBlock(portal);
		ModLoader.registerBlock(portalCreator);
		
		ModLoader.addName(portal, "Zoo Portal");
		ModLoader.addName(portalCreator, "Portal tool");
		
		ModLoader.addRecipe(new ItemStack(portalCreator, 1), new Object[]{
			"XXX", "XXX", "XXX", Character.valueOf('X'), Zoo.brownStone
		});
		
		ModLoader.getMinecraftInstance().renderEngine.registerTextureFX(new ZooPortalFX());
	}
	
	
	public static final ZooPortal portal = (ZooPortal) new ZooPortal(mod_ZooDimension.getBlockIdFor("Portal", 234), 0, Material.portal).setHardness(-1F).setStepSound(Block.soundGlassFootstep).setLightValue(0.75F).setBlockName("zooportal");
	public static final Block portalCreator = new PortalTool(mod_ZooDimension.getBlockIdFor("Portal tool", 235), 0, Material.iron).setHardness(1F).setStepSound(Block.soundMetalFootstep).setBlockName("portaltool");

}