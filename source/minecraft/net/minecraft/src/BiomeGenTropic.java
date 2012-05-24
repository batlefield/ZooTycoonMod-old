package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.BAPI.interfaces.IBiome;
import net.minecraft.src.zoo.core.gen.ZooGenTropicalTree;

public class BiomeGenTropic extends BiomeGenBase implements IBiome
{
	public BiomeGenTropic(int i)
    {
        super(i);
        biomeDecorator.treesPerChunk = 3;
        biomeDecorator.flowersPerChunk = 4;
        biomeDecorator.grassPerChunk = -999;
        topBlock = (byte) ZooDirts.tropical.blockID;
    }
    
    
    public WorldGenerator getRandomWorldGenForTrees(Random random)
    {
        return new ZooGenTropicalTree(false);
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
