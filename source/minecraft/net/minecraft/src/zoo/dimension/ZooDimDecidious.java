package net.minecraft.src.zoo.dimension;

import java.util.Random;

import net.minecraft.src.WorldGenerator;
import net.minecraft.src.ZooBiomeBase;
import net.minecraft.src.ZooDirts;
import net.minecraft.src.zoo.core.gen.ZooGenDeciTree;


public class ZooDimDecidious extends ZooBiomeBase
{

	public ZooDimDecidious(int i)
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
}
