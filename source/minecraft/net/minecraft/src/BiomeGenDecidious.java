package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.battlefield.API.BAPI;
import net.minecraft.src.battlefield.API.IBiome;
import net.minecraft.src.zoo.core.gen.ZooGenDeciTree;


public class BiomeGenDecidious extends BiomeGenBase implements IBiome
{

	public BiomeGenDecidious(int i)
    {
        super(i);
        biomeDecorator.treesPerChunk = 30;
        biomeDecorator.flowersPerChunk = 4;
        biomeDecorator.grassPerChunk = -999;
        biomeDecorator.mushroomsPerChunk = 5;
        topBlock = (byte)ZooDirts.deciduous.blockID;
    }
    
    public WorldGenerator getRandomWorldGenForTrees(Random random)
    {

        return new ZooGenDeciTree(false);

    }
    
    public BiomeGenBase getBiome() {
		return this;
	}

	public boolean canGeneratInFlat() {
		return false;
	}

	public boolean canSpawnIn() {
		return false;
	}

	public boolean canGenerateVillage() {
		return true;
	}

	public boolean canGenerateStronghold() {
		return true;
	}
}
