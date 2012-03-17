package net.minecraft.src.zoo.core;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.Zoo;
import net.minecraft.src.mod_ZooFurniture;

public class ZooCrafting {
	
	public ZooCrafting() {
		
		ModLoader.addRecipe(new ItemStack(Zoo.plexiglassBlock, 8), new Object[] {
		     "XXX", "XYX","XXX", Character.valueOf('X'), Block.glass, Character.valueOf('Y'), Item.diamond
		});
		ModLoader.addRecipe(new ItemStack(Zoo.fence, 2), new Object[] {
		     "XXX", "XXX", Character.valueOf('X'), Block.stone
		});
		ModLoader.addRecipe(new ItemStack(Zoo.fenceDestroyer, 1), new Object[] {
		     "XXX", "XYX", " Y ", Character.valueOf('X'), Zoo.brownStone, Character.valueOf('Y'), Item.stick
		});
		ModLoader.addRecipe(new ItemStack(Zoo.bsSword, 1), new Object[] {
		     "X", "X", "Y", Character.valueOf('X'), Zoo.brownStone, Character.valueOf('Y'), Item.stick
		});
		ModLoader.addRecipe(new ItemStack(Zoo.bsPickaxe, 1), new Object[] {
		     "XXX", " Y ", " Y ", Character.valueOf('X'), Zoo.brownStone, Character.valueOf('Y'), Item.stick
		});
		ModLoader.addRecipe(new ItemStack(Zoo.bsAxe, 1), new Object[] {
		     "XX ", "XY ", " Y ", Character.valueOf('X'), Zoo.brownStone, Character.valueOf('Y'), Item.stick
		});
		ModLoader.addRecipe(new ItemStack(Zoo.bsAxe, 1), new Object[] {
		     " XX", " YX", " Y ", Character.valueOf('X'), Zoo.brownStone, Character.valueOf('Y'), Item.stick
		});
		ModLoader.addRecipe(new ItemStack(Zoo.bsShovel, 1), new Object[] {
		     "X", "Y", "Y", Character.valueOf('X'), Zoo.brownStone, Character.valueOf('Y'), Item.stick
		});
		ModLoader.addRecipe(new ItemStack(Zoo.bsHoe, 1), new Object[] {
		     "XX", " Y", " Y", Character.valueOf('X'), Zoo.brownStone, Character.valueOf('Y'), Item.stick
		});
		ModLoader.addRecipe(new ItemStack(Zoo.bsHoe, 1), new Object[] {
		     "XX", "Y ", "Y ", Character.valueOf('X'), Zoo.brownStone, Character.valueOf('Y'), Item.stick
		});
		ModLoader.addRecipe(new ItemStack(Zoo.Gfence, 2), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), Item.ingotGold
		});
		ModLoader.addRecipe(new ItemStack(Zoo.Ofence, 2), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), Block.obsidian
		});
		ModLoader.addRecipe(new ItemStack(Zoo.Bfence, 2), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), Zoo.brownStone
		});
		ModLoader.addRecipe(new ItemStack(Zoo.plexiglass, 1), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), Zoo.plexiglassBlock
		});
		ModLoader.addRecipe(new ItemStack(Zoo.Quicksand, 1), new Object[] {
			"X", "Y", Character.valueOf('X'), Item.bucketWater, Character.valueOf('Y'), Block.sand
		});
		ModLoader.addRecipe(new ItemStack(Zoo.smallFencePack, 1), new Object[] {
			"XXX", "X X", "XXX", Character.valueOf('X'), Zoo.fence
		});
		ModLoader.addRecipe(new ItemStack(Zoo.fencePack, 1), new Object[] {
			"XXX", "X X", "XXX", Character.valueOf('X'), Zoo.smallFencePack
		});
		ModLoader.addShapelessRecipe(new ItemStack(Zoo.compactFencePack, 1), new Object[] {
            Zoo.fencePack, Zoo.fencePack
        });
		ModLoader.addRecipe(new ItemStack(Zoo.fencer, 1, 0), new Object[] {
			"XXX", "XYX", "XXX", Character.valueOf('X'), Block.stone, Character.valueOf('Y'), Zoo.compactFencePack
		});
		ModLoader.addRecipe(new ItemStack(Zoo.fencer, 1, 4), new Object[] {
			"XXX", "YXY", "XXX", Character.valueOf('X'), Block.stone, Character.valueOf('Y'), Zoo.compactFencePack
		});
		ModLoader.addRecipe(new ItemStack(Zoo.lasso, 1), new Object[] {
			"XXX", "X X", " X ", Character.valueOf('X'), Item.silk
		});
		ModLoader.addRecipe(new ItemStack(Zoo.grounder, 1, 0), new Object[] {
			"YXY", "XYX", "YXY", Character.valueOf('X'), new ItemStack(Zoo.fencer, 1, 4), Character.valueOf('Y'), Block.stoneBrick
		});
	}

}
