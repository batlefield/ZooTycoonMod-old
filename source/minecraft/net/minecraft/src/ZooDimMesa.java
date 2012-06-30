package net.minecraft.src;

import java.util.Random;

import net.minecraft.src.zoo.core.gen.ZooGenMesa;


public class ZooDimMesa extends ZooBiomeBase
{

	public ZooDimMesa(int i)
    {
        super(i);
        biomeDecorator.treesPerChunk = -999;
        biomeDecorator.flowersPerChunk = -999;
        biomeDecorator.grassPerChunk = -999;
        topBlock = (byte)ZooDirts.mesa.blockID;
        fillerBlock = (byte)ZooDirts.mesa.blockID;
        biomeDecorator.generateLakes = false;
        spawnableCreatureList.clear();
        spawnableWaterCreatureList.clear();
    }
}
