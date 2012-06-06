package net.minecraft.src.zoo.api;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.BAPI.Main;

/** Biome API
 * Developed to register custom biomes for zoo dimension
 * 
 * @author Battlefield
 * @category Biome
 * @see registerBiome
 */

public class Biome {
	
	private static List biomes =  new ArrayList();
	private static List biomesSpawn =  new ArrayList();
	private static List biomesStronghold =  new ArrayList();
	private static List biomesSpawnVillage =  new ArrayList();
	
	
	
	protected static void registerBiome(BiomeGenBase biome)
	{
		registerBiome(biome, false, false, false);
	}
	
	protected static void registerBiome(BiomeGenBase biome, boolean spawn, boolean village, boolean stronghold)
	{
		biomes.add(biome);
		if(spawn)
		{
			biomesSpawn.add(biome);
		}
		if(village)
		{
			Main.getBiome(2).add(biome);
		}
		if(stronghold)
		{
			Main.getBiome(3).add(biome);
		}
		
		System.out.println("Registered biome " + biome.biomeName + ", chace of spawning in it was set to " + spawn);
	}
	
	public static List getBiomes(int i)
	{
		if(i == 2)
		{
			return biomesSpawn;
		}if(i == 1)
		{
			return biomes;
		}else{
			throw new IllegalArgumentException("Invalid integer");
		}
	}
}
