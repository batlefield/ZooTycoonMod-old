package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.BAPI.interfaces.IBiome;
import net.minecraft.src.zoo.core.gen.ZooGenBluePine1;
import net.minecraft.src.zoo.core.gen.ZooGenBluePine2;

public class BiomeGenConiferous extends BiomeGenBase implements IBiome
{

	public BiomeGenConiferous(int i)
    {
        super(i);
        biomeDecorator.treesPerChunk = -999;
        biomeDecorator.flowersPerChunk = 4;
        biomeDecorator.grassPerChunk = -999;
        topBlock = (byte)ZooDirts.coniferous.blockID;
        biomeDecorator.treesPerChunk = 10;
        biomeDecorator.mushroomsPerChunk = 5;
    }
    
    public WorldGenerator getRandomWorldGenForTrees(Random random)
    {
        if (random.nextInt(3) == 0)
        {
            return new ZooGenBluePine1();
        }
        else
        {
            return new ZooGenBluePine2(false);
        }
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
		return false;
	}

	public boolean canGenerateStronghold() {
		return true;
	}
}
