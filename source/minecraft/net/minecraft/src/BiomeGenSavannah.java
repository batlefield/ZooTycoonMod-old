package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.BAPI.interfaces.IBiome;
import net.minecraft.src.zoo.core.gen.ZooGenUmbrellaThornAcacia;

public class BiomeGenSavannah extends BiomeGenBase implements IBiome
{

	public BiomeGenSavannah(int i)
    {
        super(i);
        biomeDecorator.treesPerChunk = 1;
        biomeDecorator.flowersPerChunk = 4;
        biomeDecorator.grassPerChunk = -999;
        biomeDecorator.cactiPerChunk = 1;
        biomeDecorator.reedsPerChunk = 1;
        topBlock = (byte)(ZooDirts.savannah.blockID);
    }
    
    public WorldGenerator getRandomWorldGenForTrees(Random random)
    {
        return new ZooGenUmbrellaThornAcacia(false);
    }

	public BiomeGenBase getBiome() {
		return this;
	}

	public boolean canGeneratInFlat() {
		return false;
	}

	public boolean canSpawnIn() {
		return true;
	}

	public boolean canGenerateVillage() {
		return true;
	}

	public boolean canGenerateStronghold() {
		return true;
	}
}
