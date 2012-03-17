package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.zoo.core.gen.ZooGenTropicalTree;

public class ZooDimTropic extends ZooBiomeBase
{
	public ZooDimTropic(int i)
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
}
