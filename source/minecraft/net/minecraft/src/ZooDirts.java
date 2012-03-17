package net.minecraft.src;

import net.minecraft.src.zoo.core.*;

public class ZooDirts {
	
	public ZooDirts()
	{
		ModLoader.addName(savannah, "Savannah");
		ModLoader.addName(deciduous, "Deciduous");
		ModLoader.addName(coniferous, "Coniferous");
		ModLoader.addName(tropical, "Tropical");
		ModLoader.addName(coniPeat, "Deciduous Peat");
		ModLoader.addName(deciPeat, "Coniferous Peat");
		ModLoader.addName(mesa, "Mesa");
		ModLoader.addName(laterite, "Laterite");
		ModLoader.addName(gleyPeat, "Gley Peat");
		ModLoader.addName(rainforest, "Rainforest");
	}
	
	public static final Block deciduous = (new ZooGrass(mod_ZooCore.getBlockIdFor("Decidious dirt", 208)).setHardness(0.5F).setBlockName("deciduous").setStepSound(Block.soundGrassFootstep));
	public static final Block coniferous = (new ZooGrass(mod_ZooCore.getBlockIdFor("Coniferous dirt", 209)).setHardness(0.5F).setBlockName("coniferous").setStepSound(Block.soundGrassFootstep));
	public static final Block tropical = (new ZooGrass(mod_ZooCore.getBlockIdFor("Tropical dirt", 210)).setHardness(0.5F).setBlockName("tropical").setStepSound(Block.soundGrassFootstep));
	public static final Block savannah = (new ZooGrass(mod_ZooCore.getBlockIdFor("Savannah floor", 211)).setHardness(0.5F).setBlockName("savannah").setStepSound(Block.soundGrassFootstep));
	public static final Block deciPeat = (new ZooDirt(mod_ZooCore.getBlockIdFor("Deciduous Peat floor", 212)).setHardness(0.5F).setBlockName("conipeat").setStepSound(Block.soundGrassFootstep));
	public static final Block coniPeat = (new ZooDirt(mod_ZooCore.getBlockIdFor("Coniferous Peat floor", 213)).setHardness(0.5F).setBlockName("decipeat").setStepSound(Block.soundGrassFootstep));
	public static final Block mesa = (new ZooBlock(mod_ZooCore.getBlockIdFor("Mesa", 214), 16, Material.rock).setHardness(0.5F).setBlockName("mesa").setStepSound(Block.soundStoneFootstep));
	public static final Block laterite = (new ZooBlock(mod_ZooCore.getBlockIdFor("Laterite", 215), 13, Material.rock).setHardness(0.5F).setBlockName("laterite").setStepSound(Block.soundGrassFootstep));
	public static final Block gleyPeat = (new ZooDirt(mod_ZooCore.getBlockIdFor("Gley Peat", 216)).setHardness(0.5F).setBlockName("gleypeat").setStepSound(Block.soundGrassFootstep));
	public static final Block rainforest = (new ZooDirt(mod_ZooCore.getBlockIdFor("Rainforest", 217)).setHardness(0.5F).setBlockName("rf").setStepSound(Block.soundGrassFootstep));

}
