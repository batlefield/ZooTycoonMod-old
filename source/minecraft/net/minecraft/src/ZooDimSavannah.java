package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.battlefield.API.IBiome;
import net.minecraft.src.zoo.core.gen.ZooGenUmbrellaThornAcacia;

public class ZooDimSavannah extends ZooBiomeBase implements IBiome
{

	public ZooDimSavannah(int i)
    {
        super(i);
        biomeDecorator.treesPerChunk = 1;
        biomeDecorator.flowersPerChunk = 4;
        biomeDecorator.grassPerChunk = -999;
        biomeDecorator.cactiPerChunk = 1;
        biomeDecorator.reedsPerChunk = 1;
        topBlock = (byte)ZooDirts.savannah.blockID;
        
    }
    
    public WorldGenerator getRandomWorldGenForTrees(Random random)
    {
        return new ZooGenUmbrellaThornAcacia(false);
    }

	public BiomeGenBase getBiome() {
		return null;
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
		return false;
	}
}
